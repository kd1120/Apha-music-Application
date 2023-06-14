import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

    Album album = new Album("Shiv Bhajan", "Shiv");
    Album album1 = new Album("3:59","Divine");

    album.addSong("Bazigar",6.6);
    album1.addSong("Rap", 4.5);
    album.addSong("ram ram", 9.0);
    album.addSong("kd", 4.5);
    album.addSong("rom rom", 3.4);
    album1.addSong("aigiri nandini", 7.7);


    if(album1.findSong("abc")){
        System.out.println("abc is present");
    }
    else{
        System.out.println("abc is not present");
    }


        LinkedList<Song> myPlaylist = new LinkedList<>();
    album1.addToPlaylist("3:59",myPlaylist);
        album1.addToPlaylist("Shiv Bhajan",myPlaylist);


        album.addToPlaylist(3, myPlaylist);
        album1.addToPlaylist(6,myPlaylist);


        play(myPlaylist);

    }
    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> itr = playlist.listIterator();

        if(!itr.hasNext()){
            System.out.println("Your playlist is empty");
        return;
        }


        System.out.println("Now playing: ");
        System.out.println(itr.next());

        boolean wasNext = true;
        printMenu();

        Scanner s = new Scanner(System.in);

        while(true){

            int option = s.nextInt();

            switch (option){
                case 1:
                    if(wasNext == false){
                        itr.next();
                        wasNext = true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now Playing");
                        System.out.println(itr.next());
                    wasNext =  true;
                    }
                    else{
                        System.out.println("You have reached the end of playlist");
                    }
                    break;
                case 2:
                    if(wasNext == true){
                        itr.previous();
                        wasNext = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now Playing");
                        System.out.println(itr.previous());
                    wasNext = false;
                    }
                    else{
                        System.out.println("You are at the starting of the playlist");
                    }
                    break;
                case 3:

                    if(wasNext == true){
                        if(itr.hasPrevious()){
                            System.out.println("Now Playing");
                            System.out.println(itr.previous());
                            wasNext = false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println("Now Playing");
                            System.out.println(itr.next());
                            wasNext =  true;
                        }
                    }
                    break;
                case 4:
                    printSongs(playlist);
                    break;
                case 5:
                    itr.remove();
                    break;
                case 6: printMenu();
                    break;
                case 7:
                    exit(0);


            }

        }
    }
    public static void printSongs(LinkedList<Song> playList){
        for(Song s : playList){
            System.out.println(s);
        }
        return;
    }
    public static void printMenu(){
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Repeat the current song");
        System.out.println("4. Show all songs in playlist");
        System.out.println("5. delete the current song");
        System.out.println("6. Show the menu again");
        System.out.println("7. exit");
    }
}