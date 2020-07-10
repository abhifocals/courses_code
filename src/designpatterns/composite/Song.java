package designpatterns.composite;

public class Song extends SongComponent{

    String songName;

    public Song (String newSongName) {
        songName = newSongName;
    }

    @Override
    public void displaySongName() {
        System.out.println(songName);
    }


}
