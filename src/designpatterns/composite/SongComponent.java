package designpatterns.composite;

public abstract class SongComponent {

    // applies to both group and song
    public void displaySongName() {
        throw new UnsupportedOperationException();
    }

    // applies to a group
    public String getGroupInfo() {
        throw new UnsupportedOperationException();
    }

    // applies to a group
    public void add(SongComponent songComponent) {
        throw new UnsupportedOperationException();
    }

}
