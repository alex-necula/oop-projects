package action.query.user;

import action.query.Query;
import common.Constants;
import user.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class UserRatingNumberQuery extends Query {

    private final List<User> users;
    private final int queryNumber;

    public UserRatingNumberQuery(final List<User> users, final int queryNumber,
                                 final String sortType) {
        super(sortType);
        this.users = users;
        this.queryNumber = queryNumber;
    }

    private List<String> createUsernameList() {
        List<String> usernames = new ArrayList<>();
        for (var user : users) {
            if (user.isActive()) {
                usernames.add(user.getUsername());
            }
        }
        return usernames;
    }

    private void sortUsersByNumberOfRatings(final String sortType) {
        if (sortType.equals("asc")) {
            users.sort(Comparator.comparing(User::getNumberOfRatings));
        } else {
            users.sort(Comparator.comparing(User::getNumberOfRatings).reversed());
        }
    }

    private void sortUsersWithSameRatingByUserName() {
        users.sort((user1, user2) -> {
            if (user1.getNumberOfRatings() == user2.getNumberOfRatings()) {
                int i = user1.getUsername().compareTo(user2.getUsername());
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

    @Override
    public String getResultMessage() {

        sortUsersByNumberOfRatings(getSortType());

        sortUsersWithSameRatingByUserName();

        return resultMessage(createUsernameList(), queryNumber);
    }
}
