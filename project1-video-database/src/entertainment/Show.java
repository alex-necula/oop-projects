package entertainment;

import java.util.ArrayList;
import java.util.List;

public final class Show extends Video {
    private final ArrayList<Season> seasons;

    public Show(final String title, final int year,
                final ArrayList<Genre> genres,
                final ArrayList<Season> seasons) {
        super(title, year, genres);
        this.seasons = seasons;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    @Override
    public Double getRatingAverage() {
        List<Double> ratings = new ArrayList<>();
        for (var season : seasons) {
            ratings.add(season.getRatingAverage());
        }
        return Ratable.computeRatingAverage(ratings);
    }

    @Override
    public boolean hasRatings() {
        return getRatingAverage() > 0;
    }

    @Override
    public double getDuration() {
        double duration = 0;
        for (var season : seasons) {
            duration += season.getDuration();
        }
        return duration;
    }

    @Override
    public String toString() {
        return super.getTitle() + ", rating=" + getRatingAverage();
    }
}
