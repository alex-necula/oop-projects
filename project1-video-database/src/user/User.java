package user;

import entertainment.Ratable;
import entertainment.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class User {

    private final String username;
    private final String subscriptionType;
    private final Map<Video, Integer> history;
    private final List<Video> favoriteVideos;
    private final List<Ratable> ratableList; // List of rated movies and seasons

    public User(final String username, final String subscriptionType,
                final ArrayList<Video> favoriteVideos,
                final Map<Video, Integer> history) {
        this.username = username;
        this.subscriptionType = subscriptionType;
        this.history = history;
        this.favoriteVideos = favoriteVideos;
        this.ratableList = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public Map<Video, Integer> getHistory() {
        return history;
    }

    public List<Video> getFavoriteVideos() {
        return favoriteVideos;
    }

    public List<Ratable> getRatableList() {
        return ratableList;
    }

    public int getNumberOfRatings() {
        return ratableList.size();
    }

    /**
     * @return true if the user rated at least one video
     */
    public boolean isActive() {
        return !ratableList.isEmpty();
    }

    /**
     * Adds video to the list of rated videos
     *
     * @param ratable video or season that was rated by users
     */
    public void addToRatedVideos(final Ratable ratable) {
        ratableList.add(ratable);
    }
}
