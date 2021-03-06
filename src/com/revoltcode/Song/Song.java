package com.revoltcode.Song;

import java.util.HashSet;
import java.util.Set;

/*
 * A playlist is considered a repeating playlist if any of the songs contain a reference to a previous song in the playlist. Otherwise, the playlist will end with the last song which points to null.

 * Implement a function isRepeatingPlaylist that, efficiently with respect to time used, returns true if a playlist is repeating or false if it is not.

 * For example, the following code prints "true" as both songs point to each other.

 * Song first = new Song("Hello");
 * Song second = new Song("Eye of the tiger");

 * first.setNextSong(second);
 * second.setNextSong(first);

 * System.out.println(first.isRepeatingPlaylist());
 */
public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public Song getNextSong() {
        return nextSong;
    }

    public boolean isRepeatingPlaylist() {
        // next song = previous song
        Set<Song> songs = new HashSet<>();
        songs.add(this);
        Song current = this.getNextSong();
        //if you did not implment a getter for the nextSong property I think you should
        while (current.getNextSong() != null && !songs.contains(current.getNextSong())) {

            songs.add(current);
            current = current.getNextSong();
        }

        return songs.contains(current.getNextSong());
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}
