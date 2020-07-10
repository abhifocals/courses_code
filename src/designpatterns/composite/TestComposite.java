package designpatterns.composite;

public class TestComposite {

    public static void main(String[] args) {

        SongComponent outer = new SongGroup("Outer");
        SongGroup inner = new SongGroup("Inner");

        SongComponent song1 = new Song("song1");
        SongComponent song2 = new Song("song2");
        SongComponent song3 = new Song("song3");


        outer.add(song1);
        outer.add(song2);
        outer.displaySongName();

        inner.add(song3);
        inner.displaySongName();

        outer.add(inner);
        outer.displaySongName();



        song2.displaySongName();


    }


}
