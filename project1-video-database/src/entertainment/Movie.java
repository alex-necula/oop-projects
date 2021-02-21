package entertainment;

import java.util.ArrayList;
import java.util.List;

public final class Movie extends Video implements Ratable {
    private final int duration;
    private final List<Double> ratings;

    public Movie(final String title, final int year,
                 final ArrayList<Genre> genres, final int duration) {
        super(title, year, genres);
        this.duration = duration;
        this.ratings = new ArrayList<>();
    }

    @Override
    public double getDuration() {
        return duration;
    }

    @Override
    public void addRating(final double grade) {
        ratings.add(grade);
    }

    @Override
    public boolean hasRatings() {
        return !(ratings.isEmpty());
    }

    @Override
    public Double getRatingAverage() {
        return Ratable.computeRatingAverage(ratings);
    }

    @Override
    public String toString() {
        return super.getTitle() + " rating= " + getRatingAverage();
    }
}
