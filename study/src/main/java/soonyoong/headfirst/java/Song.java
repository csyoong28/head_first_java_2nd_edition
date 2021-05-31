package soonyoong.headfirst.java;

public class Song implements Comparable<Song> { // we’re specifying the type that the implementing class can be compared
												// against.
	String title;
	String artist;
	String rating;
	String bpm;

	Song(String t, String a, String r, String b) {
		title = t;
		artist = a;
		rating = r;
		bpm = b;

	}

	public int compareTo(Song song) {
		return title.compareTo(song.getTitle());
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getRating() {
		return rating;
	}

	public String getBpm() {
		return bpm;
	}

	public String toString() {
		return title + ":" + artist;
	}

	public boolean equals(Object aSong) {		//use by Set to check equality
		Song s = (Song) aSong;
		return getTitle().equals(s.getTitle());
	}

	public int hashCode() {		//use by Set to check equality
		return title.hashCode();
	}

}
