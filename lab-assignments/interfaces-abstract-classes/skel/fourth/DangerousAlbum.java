package fourth;

public class DangerousAlbum extends Album {
    @Override
    public void addSong(Song song) {
        if (PrimeTester.isPrime(song.getId())) {
            this.getSongs().add(song);
        }
    }
}
