package action.query.actor;

import action.query.Query;
import actor.Actor;
import common.Constants;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class ActorQuery extends Query {

    private final List<Actor> actors;

    protected ActorQuery(final List<Actor> actors, final String sortType) {
        super(sortType);
        this.actors = actors;
    }

    protected final List<Actor> getActors() {
        return actors;
    }

    protected final List<String> createNameList(final List<Actor> actorList) {
        List<String> names = new ArrayList<>();
        for (var actor : actorList) {
            names.add(actor.getName());
        }
        return names;
    }

    protected final void sortSameNumberByName(final List<Pair<Object, Double>> actorList) {
        actorList.sort((pair1, pair2) -> {
            Actor actor1 = (Actor) pair1.getL();
            Actor actor2 = (Actor) pair2.getL();
            if (pair1.getR().equals(pair2.getR())) {
                int i = actor1.getName().compareTo(actor2.getName());
                if (getSortType().equals(Constants.ASCENDING)) {
                    return i;
                } else {
                    return -i;
                }
            } else {
                return 0;
            }
        });
    }

    protected final List<String> createNameListFromPair(
            final List<Pair<Object, Double>> actorList) {
        List<String> names = new ArrayList<>();
        for (var pair : actorList) {
            Actor actor = (Actor) pair.getL();
            names.add(actor.getName());
        }
        return names;
    }
}
