class Song {
    String title;
    String artist;
    float duration; // in minutes

    public Song(String title, String artist, float duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Duration: " + duration + " mins";
    }
}

class Node {
    Song song;
    Node next;

    public Node(Song song) {
        this.song = song;
        this.next = null;
    }
}

class Playlist {
    private Node head;

    public Playlist() {
        this.head = null;
    }

    // Add a song to the playlist
    public void addSong(String title, String artist, float duration) {
        Song newSong = new Song(title, artist, duration);
        Node newNode = new Node(newSong);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Song added: " + title);
    }

    // Remove a song by title
    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty. No song to remove.");
            return;
        }

        if (head.song.title.equals(title)) {
            head = head.next;
            System.out.println("Song removed: " + title);
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && !current.song.title.equals(title)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Song not found: " + title);
        } else {
            previous.next = current.next;
            System.out.println("Song removed: " + title);
        }
    }

    // Display all songs in the playlist
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("Playlist:");
        Node current = head;
        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        // Adding songs
        playlist.addSong("Dandilions", "xyz", 3);
        playlist.addSong("Beautiful Scars", "mno", 1);
        playlist.addSong("Blank Space", "efg", 2);

        // Displaying playlist
        playlist.displayPlaylist();

        // Removing a song
        playlist.removeSong("Dandilions");

        // Displaying playlist after removal
        playlist.displayPlaylist();
    }
}
