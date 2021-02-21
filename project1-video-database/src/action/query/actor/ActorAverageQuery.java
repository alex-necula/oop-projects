package action.query.actor;

import actor.Actor;
import entertainment.Ratable;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class ActorAverageQuery extends ActorQuery {

    private final int queryNumber;

    public ActorAverageQuery(final List<Actor> actors, final String sortType,
                             final int queryNumber) {
        super(actors, sortType);
        this.queryNumber = queryNumber;
    }

    @Override
    public String getResultMessage() {

        List<Pair<Object, Double>> actorRatings = new ArrayList<>();

        for (var actor : getActors()) {
            List<Double> videoRatings = new ArrayList<>();
            for (var video : actor.getFilmography()) {
                if (video.hasRatings()) {
                    videoRatings.add(video.getRatingAverage());
                }
            }
            if (!videoRatings.isEmpty()) {
                actorRatings.add(new Pair<>(actor,
                        Ratable.computeRatingAverage(videoRatings)));
            }
        }

        Pair.sortPairListByNumber(actorRatings, getSortType());

        sortSameNumberByName(actorRatings);

        return resultMessage(createNameListFromPair(actorRatings), queryNumber);
    }
}
