package action.query.actor;

import actor.Actor;
import actor.ActorsAwards;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class ActorAwardsQuery extends ActorQuery {

    private final List<ActorsAwards> awards;

    public ActorAwardsQuery(final List<Actor> actors, final String sortType,
                            final List<ActorsAwards> awards) {
        super(actors, sortType);
        this.awards = awards;
    }

    @Override
    public String getResultMessage() {

        List<Pair<Object, Double>> awardedActors = new ArrayList<>();

        for (var actor : getActors()) {
            boolean hasAwards = true;
            for (var award : awards) {
                if (!actor.getAwards().containsKey(award)) {
                    hasAwards = false;
                    break;
                }
            }
            if (hasAwards) {
                awardedActors.add(new Pair<>(actor, actor.getNumberOfAwards()));
            }
        }

        Pair.sortPairListByNumber(awardedActors, getSortType());

        sortSameNumberByName(awardedActors);

        return resultMessage(createNameListFromPair(awardedActors), awardedActors.size());
    }
}
