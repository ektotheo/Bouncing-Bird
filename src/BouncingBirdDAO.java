public interface BouncingBirdDAO {

    public void setterMethode(String typ, String pfad);
    public String getterMethode(String typ);


    public void addRating( String username, String comments, int rating);
    public String getRatings();


    
}
