package entertainment;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a season of a tv show
 */
public final class Season implements Ratable {

    private final int currentSeason;
    private final int duration;
    private final List<Double> ratings;

    public Season(final int currentSeason, final int duration) {
        this.currentSeason = currentSeason;
        this.duration = duration;
        this.ratings = new ArrayList<>();
    }

    public int getDuration() {
        return duration;
    }

    public Double getRatingAverage() {
        return Ratable.computeRatingAverage(ratings);
    }

    @Override
    public void addRating(final double grade) {
        ratings.add(grade);
    }

    @Override
    public String toString() {
        return currentSeason + getRatingAverage().toString();
    }
}

