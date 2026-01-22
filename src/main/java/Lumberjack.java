public class Lumberjack extends Person {
    private String favoriteTree;
    // constructor
    public Lumberjack(String firstName, String lastName, String phoneNumber, String favoriteTree) {
        super(firstName, lastName, phoneNumber);
        this.favoriteTree = favoriteTree;
    }
    // getter
    public String getFavoriteTree() {
        return favoriteTree;
    }
    // toString
    @Override
    public String toString() {
        return super.toString() + " Favorite tree: " + favoriteTree;
    }
}
