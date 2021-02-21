package fourth;

public class ThrillerAlbum extends Album {
    @Override
    public void addSong(Song song) {
        if (song.getComposer().equals("Michael Jackson") && song.getId() % 2 == 0) {
            this.getSongs().add(song);
        }
    }
}
