package fourth;

public class BadAlbum extends Album {

    @Override
    public void addSong(Song song) {
        if (song.getName().length() == 3 && PalindromeTester.isPalindrome(song.getId())) {
            this.getSongs().add(song);
        }
    }
}
