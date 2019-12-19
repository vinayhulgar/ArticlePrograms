package com.Sort.src;

public class Song implements Comparable<Song> {
	
	private String songName;

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public Song(String songName) {
		super();
		this.songName = songName;
	}

	@Override
	public int compareTo(Song song) {
		return this.songName.compareTo(song.getSongName());
	}
	
	

}
