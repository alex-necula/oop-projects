package fourth;

import java.util.ArrayList;
import java.util.StringJoiner;

public abstract class Album {
    private final ArrayList<Song> songs = new ArrayList<>();

    public abstract void addSong(Song song);

    public void removeSong(Song song) {
        songs.remove(song);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Song song : songs) {
            stringJoiner.add(song.toString());
        }
        return "Album{" +
                "songs=" + stringJoiner.toString() +
                '}';
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
