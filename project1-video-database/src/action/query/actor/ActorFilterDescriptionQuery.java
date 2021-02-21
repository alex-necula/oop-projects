package action.query.actor;

import actor.Actor;
import common.Constants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ActorFilterDescriptionQuery extends ActorQuery {

    private final List<String> words;

    public ActorFilterDescriptionQuery(final List<Actor> actors, final String sortType,
                                       final List<String> words) {
        super(actors, sortType);
        this.words = words;
    }

    private void sortActorsByName(final List<Actor> actorList) {
        if (getSortType().equals(Constants.ASCENDING)) {
            actorList.sort(Comparator.comparing(Actor::getName));
        } else {
            actorList.sort(Comparator.comparing(Actor::getName).reversed());
        }
    }

    @Override
    public String getResultMessage() {

        List<Actor> matchedActors = new ArrayList<>();

        for (var actor : getActors()) {
            boolean match = true;
            for (var word : words) {
                String regex = "\\b" + word + "\\b";
                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(actor.getCareerDescription());
                if (!matcher.find()) {
                    match = false;
                    break;
                }
            }
            if (match) {
                matchedActors.add(actor);
            }
        }

        sortActorsByName(matchedActors);

        return resultMessage(createNameList(matchedActors), matchedActors.size());
    }
}
