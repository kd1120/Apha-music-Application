import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String name;
    private String artist;

    private List<Song> songs;

    public Album() {
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong(String title){
        for(Song s:this.songs){
            if(s.getTitle().equals(title)){
                //System.out.println("Song is present");

                return true;
            }


        }
        return false;
    }

    public boolean addSong(String title, double duration){
        if(!findSong(title)){

            Song s = new Song(title, duration);
            this.songs.add(s);
            System.out.println("Song has been added");
        }
        System.out.println("Song is already present");
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> myPlaylist){

        if(findSong(title)){
            for(Song s: this.songs){
                if(this.getName().equals(title)){
                    myPlaylist.add(s);
                    System.out.println("Song added to playlist");
                    return true;
                }
            }
        }
        System.out.println("Sorry! Song does not exist");
        return false;
    }

    public boolean addToPlaylist(int index,LinkedList<Song> myPlaylist){

        index  = index -1;
        if(index>0 && index<this.songs.size()){

            myPlaylist.add(this.songs.get(index));
            System.out.println("Song added");
            return true;
        }
        System.out.println("Incorrect command");
        return false;
    }
}
