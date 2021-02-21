package entertainment;

import java.util.ArrayList;

public abstract class Video {
    private final String title;
    private final int year;
    private final ArrayList<Genre> genres;
    private double viewsNumber = 0;
    private double favoritesNumber = 0;

    public Video(final String title, final int year,
                 final ArrayList<Genre> genres) {
        this.title = title;
        this.year = year;
        this.genres = genres;
    }

    public final String getTitle() {
        return title;
    }

    public final int getYear() {
        return year;
    }

    public final ArrayList<Genre> getGenres() {
        return genres;
    }

    public final double getViewsNumber() {
        return viewsNumber;
    }

    public final double getFavoritesNumber() {
        return favoritesNumber;
    }

    /**
     * @param views number of views from user
     */
    public final void addView(final int views) {
        viewsNumber += views;
    }

    /**
     * Counts that user added Video to his favorite list
     */
    public final void addFavorite() {
        favoritesNumber++;
    }

    /**
     * @return true is at least one user viewed the video
     */
    public final boolean hasViews() {
        return viewsNumber != 0;
    }

    /**
     * @return true if at least one user added it to the favorite list
     */
    public final boolean isAddedToFavorites() {
        return favoritesNumber != 0;
    }

    /**
     * @return Rating Average
     */
    public abstract Double getRatingAverage();

    /**
     * @return true if at least one user rated the video
     */
    public abstract boolean hasRatings();

    /**
     * @return duration of the video
     */
    public abstract double getDuration();
}
