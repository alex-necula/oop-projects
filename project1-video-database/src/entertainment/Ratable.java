package entertainment;

import java.util.List;

/**
 * Can receive a rating (video or season)
 */
public interface Ratable {
    /**
     * @param ratings list of ratings given by users
     * @return the average of the ratings
     */
    static Double computeRatingAverage(List<Double> ratings) {
        Double sum = (double) 0;
        if (!ratings.isEmpty()) {
            for (var rating : ratings) {
                sum += rating;
            }
            return sum / ratings.size();
        }
        return sum;
    }

    /**
     * Adds rating to a video or season
     *
     * @param grade from user
     */
    void addRating(double grade);
}
