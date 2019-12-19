package com.Sort.src;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MusicDemo {

	public static void main(String[] args) {
		List<Song> library = new ArrayList<>();
		library.add(new Song("Basket Case"));
		library.add(new Song("Blood On The Leaves"));
		library.add(new Song("Creep"));
		library.add(new Song("Juicy"));
		library.add(new Song("Rocket Man"));
		library.add(new Song("Video Games"));
		library.add(new Song("Wannabe"));
		myShuffle(library);
		library.stream().map(s -> s.getSongName()).forEach(System.out::print);
	}

	private static void myShuffle(List<Song> library) {
		Collections.sort(library);
		Random random = new Random();
		for(int index =0; index<library.size();index++) {
			int secondIndex = random.nextInt(library.size());
			swap(index, secondIndex, library);
		}
	}

	private static void swap(int firstIndex, int secondIndex, List<Song> library) {
		Song firstSong = library.get(firstIndex);
		Song secondSong = library.get(secondIndex);
		library.set(firstIndex, secondSong);
		library.set(secondIndex, firstSong);
	}

}
