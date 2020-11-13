import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.exit;
import static java.lang.System.out;

/*
 *  Program to simulate segregation.
 *  See : http://nifty.stanford.edu/2014/mccown-schelling-model-segregation/
 *
 * NOTE:
 * - JavaFX first calls method init() and then method start() far below.
 * - To test methods uncomment call to test() first in init() method!
 *
 */
// Extends Application because of JavaFX (just accept for now)
public class Neighbours extends Application {

    class Actor {
        final Color color;        // Color an existing JavaFX class
        boolean isSatisfied;      // false by default

        Actor(Color color) {      // Constructor to initialize
            this.color = color;
        }
    } 

    final static Random rand = new Random();
    
    // Below is the *only* accepted instance variable (i.e. variables outside any method)
    // This variable may *only* be used directly in methods init() and updateWorld()
    Actor[][] world;              // The world is a square matrix of Actors

    // This is the method called by the timer to update the world
    // (i.e move unsatisfied) approx each 1/60 sec.
    
    void updateWorld() {
        // % of surrounding neighbours that are like me
        //double threshold = 0.7;
    }
    // This method initializes the world variable with a random distribution of Actors
    // Method automatically called by JavaFX runtime
    // That's why we must have "@Override" and "public" (just accept for now)
    
    @Override
    public void init() {
        test();    // <---------------- Uncomment to TEST, see below!
        //Intitializations
        double[] dist = {0.25, 0.25, 0.50}; // %-distribution of RED, BLUE and NONE
        int nLocations = 900; // Number of locations (places) in world (must be a square)
        world = toWorld(shuffle(distribute(dist, nLocations)));
        // Should be last
        fixScreenSize(nLocations);
    }

   // ******************** Regular Methods  ************** 
    
    int dimensions(int nLocations) {
        double root = sqrt(nLocations); // roten ur nlocations = en sida 
        int dimension = (int) Math.round(root); // gör om från double till int 
        return dimension; 
    }
    
    Actor[] distribute(double[] dist, int n){
        Actor [] locations = new Actor[n];
        int numRed = (int) Math.round(dist[0] * n);
        int numBlue = (int) Math.round(dist[1] * n);
        int numNull = (int) Math.round(dist[2] * n);
        
        for (int i = 0; i < n; i++){
            if (i < numRed) {
                locations[i] = new Actor(Color.RED); //0-224
            } else if ((i >= numRed) && (i < (numRed + numBlue))){
                locations[i] = new Actor(Color.BLUE); //225-450
            } else if (i > numRed+numBlue) {
                locations[i] = null; //0-224
            } 
        }
        return locations;
    }
    
    Actor[] findNeighbours (Actor [][] w, int r, int c){
        int[] rowIndices = {r, r-1, r+1};   // r, c   r, c-1,  r,c+1
        int[] colIndices = {c, c-1, c+1};   // r-1, c  r-1,c-1  r-1,c+1
        Actor[] neighbours = new Actor[8];  // r +1,c r+1, c-1, r-1,c+1
        int sumfoundNeigh = 0;

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if(isValidLocation(w.length, rowIndices[i], colIndices[j]) ) { 
                    if ((w[rowIndices[i]][colIndices[j]] == null) || (i == 0 && j == 0)){
                        out.println(w[rowIndices[i]][colIndices[j]]);
                        continue;
                    } else {
                        neighbours[sumfoundNeigh] = w[rowIndices[i]][colIndices[j]];
                        sumfoundNeigh++;
                        out.println(sumfoundNeigh);
                      }
                }
            }
        } 
        out.println("sum neighbour " + sumfoundNeigh);
        Actor[] neighbours2 = new Actor[sumfoundNeigh];
        for (int i = 0; i < sumfoundNeigh; i++) {
            neighbours2[i] = neighbours[i];
        } 
        out.println("antalet grannar: " + neighbours2.length);
        return neighbours2;
    }
        /*
rätt:
0,0 = 2
0,1 = 2 x
0,2 = 2           
1,0 = 4 x
1,1 = 4
1,2 = 3  
2,0 = 1         
2,1 = 3 
2,2 = 1

fel:
0,0 = 4
0,1 = 6
0,2 = 4
1,0 = 4
1,1 = exception 8 out of bounds
1.2 = 6
2.0 = 4
2.1 = 6
2.2 =4


        */

    // ----------- Property checking methods -----------------
    
    boolean isSatisfied(Actor[] neighbours, Actor current, double th){
        Color friendlyColour = current.color;
        int sumFriends = 0;
        int bigDouble = (int) Math.round(th*100);
        out.println("double times " + bigDouble);  // 50
        out.println("arrayen grannars längd: " + neighbours.length); 
        for (int i = 0; i < neighbours.length; i++){
            if(neighbours[i].color == friendlyColour){
                sumFriends++; 
            } 
        }
        out.println("antalet samma färg: " + sumFriends); 
        out.println("procent:");
        if (neighbours.length !=0){
            int x = (sumFriends)*100 /(neighbours.length);   //300 / 4
            out.println(x);
            return ((x) >=  bigDouble);
        } else {
            return true;
        }
    }

    // Check if inside world
    boolean isValidLocation(int size, int row, int col) {
        return 0 <= row && row < size && 0 <= col && col < size;
    }    

    boolean prop_distribute(double[] dist, Actor[] a){
        int total = a.length;
        out.println("total: " + total);
        int sumRed = 0;
        int sumBlue = 0;
        int numRed = (int) Math.round(dist[0] * total);
        int numBlue = (int) Math.round(dist[1] * total);
        for (int i = 0; i < total; i++) {
            if (a[i]==null){
                continue;
            } else {
                if (a[i].color == Color.RED){
                    sumRed++;
                    
                } else if (a[i].color == Color.BLUE){
                    sumBlue++;
                }
            }
        } 
        return ((sumRed == numRed) && (sumBlue == numBlue));
    }

    boolean prop_matrix(double[] dist, Actor[][] world){
        int dim = world.length;
        int sumRed = 0;
        int sumBlue = 0;
        int total = dim*dim;
        //int sumNull = 0;
        int numRed = (int) Math.round(dist[0] * total);
        int numBlue = (int) Math.round(dist[1] * total);
        //int numNull = (int) Math.round(dist[2] * total);
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (world[i][j] == null) {
                    continue;
                }else if (world[i][j].color == Color.RED){
                    sumRed++;
                } else if (world[i][j].color == Color.BLUE){
                    sumBlue++;
                }
            }
        }
        return ((sumRed == numRed) && (sumBlue == numBlue));
    }
                
    // ----------- Utility methods -----------------

    // Method to change format of data, generate random etc.

    
    Actor[][] toWorld(Actor[] list) {
        int cap = list.length;
        int dimensions = dimensions(cap);
        
        Actor[][] world = new Actor[dimensions][dimensions];

        for (int i = 0; i < dimensions; i++) { // 0 // 1 // 2 // 3 ...
            //int forList = i*dimensions;
            for (int j = 0; j < dimensions; j++) { // 0,0 // 0,1 ...
                world[i][j] = list[(j*dimensions)+i];  //  0,0 0,1 0,2 ... 0,29; 1,
            }
        }
        return world;
    }
 
    Actor[] shuffle(Actor[] locations) {
        for (int i = 0; i < locations.length; i++) {
            int randomIndexToSwap = rand.nextInt(locations.length);
            Actor temp = locations[randomIndexToSwap];
            locations[randomIndexToSwap] = locations[i];
            locations[i] = temp;
        }
        return locations;
    }
    

    // ------- Testing -------------------------------------
    
    void plot(Actor[][] matrix) { 
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row])); 
        }
    }
    
    // Here you run your tests i.e. call your logic methods
    // to see that they really work. Important!!!!
    void test() {
        // A small hard coded world for testing
        double[] dist = {0.25, 0.25, 0.50}; // %-distribution of RED, BLUE and NONE
        int nLocations = 900;  
        double th = 0.5;  
        //plot(toWorld((distribute(dist, nLocations))));
        //int p = (toWorld((distribute(dist, nLocations)))).length;
        //out.println(p);
        Actor[][] testWorld = new Actor[][]{
                {new Actor(Color.RED), new Actor(Color.RED),                   null},
                {null,                 new Actor(Color.BLUE),                  null},
                {new Actor(Color.RED),          null,         new Actor(Color.BLUE)}
        };
        /* 
0,0 = 4, ska va 2
0,1 = 6, ska va 2
0, 2 = 4, ska va 2

1, 0 = 4, ska va 4 !!
1, 1 = exception, ska vara 4
1, 2 = 6 ska va 3

2, 0 = 4, 
2, 1 = 6,
2,2 = 4

(2,0) = 1
(0,2) = 2
(1,2) = 3
(2,1) = 3
(2, 2) = 1
        */
        out.println((findNeighbours(testWorld, 0, 0)));

        //out.println(findNeighbours(testWorld, 1, 0));

        //out.println(findNeighbours(testWorld, 2, 1));
        //out.println(findNeighbours(testWorld, 0, 1));

        /*
        out.println(findNeighbours(testWorld, 2, 2));
        
        out.println(findNeighbours(testWorld, 2, 0));

        out.println(findNeighbours(testWorld, 1, 2));
        out.println(findNeighbours(testWorld, 1, 1));
        out.println(findNeighbours(testWorld, 1, 0));

        out.println(findNeighbours(testWorld, 0, 2));
        out.println(findNeighbours(testWorld, 0, 1));
        out.println((findNeighbours(testWorld, 0, 0)));
        */
        

        //out.println(isSatisfied((findNeighbours(testWorld, 2, 0)), testWorld[2][0], th));
      // Simple threshold used for testing
        //out.println(prop_distribute(dist,(distribute(dist, nLocations))));
        //out.println(prop_matrix(dist,toWorld((distribute(dist, nLocations)))));
        //out.println(Arrays.toString(distribute(dist, nLocations)));
        int size = testWorld.length;
        //out.println(dimensions(90000));
        //out.println(isValidLocation(size, 0, 0));   // true
        //out.println(!isValidLocation(size, -1, 0)); // false
        //out.println(!isValidLocation(size, 0, 3)); // true

        // More tests here. Implement and test one method at the time
        // Always keep all tests! Easy to rerun if something happens

        exit(0);
    }

    // ******************** NOTHING to do below this row, it's JavaFX stuff  **************

    double width = 500;   // Size for window
    double height = 500;
    final double margin = 50;
    double dotSize;

    void fixScreenSize(int nLocations) {
        // Adjust screen window
        dotSize = (double) 9000 / nLocations;
        if (dotSize < 1) {
            dotSize = 2;
        }
        width = sqrt(nLocations) * dotSize + 2 * margin;
        height = width;
    }

    long lastUpdateTime;
    final long INTERVAL = 450_000_000;


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Build a scene graph
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a timer
        AnimationTimer timer = new AnimationTimer() {
            // This method called by FX, parameter is the current time
            public void handle(long now) {
                long elapsedNanos = now - lastUpdateTime;
                if (elapsedNanos > INTERVAL) {
                    updateWorld();
                    renderWorld(gc);
                    lastUpdateTime = now;
                }
            }
        };

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation");
        primaryStage.show();

        timer.start();  // Start simulation
    }


    // Render the state of the world to the screen
    public void renderWorld(GraphicsContext g) {
        g.clearRect(0, 0, width, height);
        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = (int) (dotSize * col + margin);
                int y = (int) (dotSize * row + margin);
                if (world[row][col] != null) {
                    g.setFill(world[row][col].color);
                    g.fillOval(x, y, dotSize, dotSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}

/*
1. Gå igenom världen och notera vilka som är missnöjda (och nöjda).
Här använder vi att minst 50% av grannarna skall ha samma färg.
2. Gå igenom världen och spara index till alla tomma platser (null). Byt
mellan rad/kolumn och index se Anteckningar/Arrayer.
3. Shuffla de tomma platserna (indexen).
4. Byt första tomma plats mot första missnöjda. Nästa tomma plats mot
nästa missnöjda o.s.v.
*/