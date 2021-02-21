package action.query.video;

import entertainment.Genre;
import entertainment.Video;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class VideoFavoriteQuery extends VideoQuery {

    public VideoFavoriteQuery(final String sortType, final int yearFilter,
                              final Genre genreFilter, final int queryNumber,
                              final List<Video> videos, final String objectType) {
        super(sortType, yearFilter, genreFilter, queryNumber, videos, objectType);
    }

    @Override
    public String getResultMessage() {

        List<Pair<Object, Double>> favoriteNumbers = new ArrayList<>();

        for (var video : getVideos()) {
            if (video.isAddedToFavorites() && matchesFilters(video)
                    && hasRequiredType(video)) {
                favoriteNumbers.add(new Pair<>(video, video.getFavoritesNumber()));
            }
        }

        Pair.sortPairListByNumber(favoriteNumbers, getSortType());

        sortSameNumberByTitle(favoriteNumbers);

        return resultMessage(createTitleList(favoriteNumbers), getQueryNumber());
    }
}
