class Song {
    String name;
    Song next;

    public Song(String name) {
        this.name = name;
        this.next = null;
    }
}

class Playlist {
    private Song head;
    private Song currentSong; // Keeps track of the current song

    public Playlist() {
        this.head = null;
        this.currentSong = null;
    }

    // Add a new song at the end of the playlist
    public void addSong(String name) {
        Song newSong = new Song(name);
        if (head == null) {
            head = newSong;
            currentSong = head;
        } else {
            Song temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newSong;
        }
        System.out.println("Added: " + name);
    }

    // Delete a song by name
    public void deleteSong(String name) {
        if (head == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Deleted: " + name);
            return;
        }
        Song temp = head;
        while (temp.next != null && !temp.next.name.equals(name)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Song not found!");
        } else {
            temp.next = temp.next.next;
            System.out.println("Deleted: " + name);
        }
    }

    // Display all songs in the playlist
    public void displaySongs() {
        if (head == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        Song temp = head;
        System.out.println("Your Playlist:");
        while (temp != null) {
            System.out.println("- " + temp.name);
            temp = temp.next;
        }
    }

    // Play next song in order
    public void playNext() {
        if (currentSong == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        System.out.println("Playing: " + currentSong.name);
        if (currentSong.next != null) {
            currentSong = currentSong.next;
        } else {
            currentSong = head; // Loop back to the first song
        }
    }
}

public class PlaylistManager {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        playlist.addSong("Song A");
        playlist.addSong("Song B");
        playlist.addSong("Song C");

        playlist.displaySongs();

        playlist.playNext();
        playlist.playNext();
        playlist.playNext();
        playlist.playNext(); // Loops back to the first song

        playlist.deleteSong("Song B");
        playlist.displaySongs();
    }
}

