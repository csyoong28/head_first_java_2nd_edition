package soonyoong.headfirst.java;

import java.util.*;
import java.io.*;

public class java13DataStructureSort {
	ArrayList<Song> songList = new ArrayList<Song>();

	public static void main(String[] args) {
		new java13DataStructureSort().go();
	}

	class ArtistCompare implements Comparator<Song> {
		public int compare(Song one, Song two) {
			return one.getArtist().compareTo(two.getArtist());
		}
	}

	public void go() {
		getSongs();
		System.out.println(songList);
		//Collections.sort(songList);
		System.out.println(songList);
		HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);
		System.out.println("in the set: " + songSet);
		TreeSet<Song> songTreeSet = new TreeSet<Song>();
		songTreeSet.addAll(songList);
		System.out.println("in the TreeSet: " + songTreeSet);
	}

	void getSongs() {
		try {
			File ﬁle = new File("SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(ﬁle));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}

}
