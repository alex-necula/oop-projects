package actor;

import entertainment.Video;

import java.util.ArrayList;
import java.util.Map;

public final class Actor {
    private final String name;
    private final String careerDescription;
    private final ArrayList<Video> filmography;
    private final Map<ActorsAwards, Integer> awards;

    public Actor(final String name, final String careerDescription,
                 final Map<ActorsAwards, Integer> awards,
                 final ArrayList<Video> filmography) {
        this.name = name;
        this.careerDescription = careerDescription;
        this.awards = awards;
        this.filmography = filmography;
    }

    public String getName() {
        return name;
    }

    public String getCareerDescription() {
        return careerDescription;
    }

    public ArrayList<Video> getFilmography() {
        return filmography;
    }

    public Map<ActorsAwards, Integer> getAwards() {
        return awards;
    }

    /**
     * @return number of awards received by actor
     */
    public Double getNumberOfAwards() {
        double sum = 0;
        for (var award : awards.entrySet()) {
            sum += award.getValue();
        }
        return sum;
    }

    @Override
    public String toString() {
        return name;
    }
}
