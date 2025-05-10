public class Rider{
    private String name;
    private RATING rating;

    public Rider(String name, RATING rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getRiderName() {
        return name;
    }
    public RATING getRating() {
        return rating;
    }
}