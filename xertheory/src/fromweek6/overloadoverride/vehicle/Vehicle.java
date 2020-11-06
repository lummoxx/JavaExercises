package fromweek6.overloadoverride.vehicle;

// See TestVehicle
public class Vehicle {
    protected int licNumb;

    public Vehicle(int licNumb) {
        this.licNumb = licNumb;
    }

    public boolean equals(Vehicle v) {
        if (this == v) {
            return true;
        } else if (v == null) {
            return false;
        } else if (getClass() != v.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) v;
        return licNumb == other.licNumb;
    }
}
