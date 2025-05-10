public class Driver{

    private String name;
    private boolean avail;
    private RATING rating;

    public Driver(String name, boolean avail, RATING rating) {
        this.name = name;
        this.avail = avail;
        this.rating = rating;
    }

    public void updateAvail(boolean pAvail) {
        this.avail = pAvail;
    }
    public String getDriverName() {
        return name;
    }
    public RATING getRating() {
        return rating;
    }

    public boolean isAvail() {
        return avail;
    }

}