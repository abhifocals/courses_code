package designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class SongGroup extends SongComponent {

    List<SongComponent> songsList;
    String groupName;

    public SongGroup(String newGroupName) {
        groupName = newGroupName;
        songsList = new ArrayList<>();
    }

    public void add(SongComponent songComponent) {
        songsList.add(songComponent);
    }

    @Override
    public void displaySongName() {

        for (SongComponent component:songsList) {
            component.displaySongName();
        }

    }
}
