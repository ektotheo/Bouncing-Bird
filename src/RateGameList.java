import java.util.Observable;

public class RateGameList extends Observable {
    private BouncingBirdDBDAO dbDAO;

    public RateGameList() {
this.dbDAO = new BouncingBirdDBDAO();
    }
   public void writeReviewFile(String username, String comments, int rating,  ){
   dbDAO.addRating(username, rating, comments);
    setChanged();
    notifyObservers();
   }

    public List<Rating> renderReview(){
    return dbDAO.getRatings();
}
