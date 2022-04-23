package src.character;

import java.util.Random;
import java.util.stream.IntStream;

import src.main.Util;

public enum Race {
	OrcSnaga("OrcSnaga", "CirithUngol"),
	Uruk_hai("Uruk-hai", "Portão Negro"),
	CavRohan("Cavaleiro de Rohan", "Abismo de Helm"),
	GuerGondor("Guerreiro de Gondor", "Minas Tirith"),
	Nacao("Nação", "Casa"),
	Hobbit("Hobbit", "O Condado"),
	ElfFlo("Elfo da Floresta", "Floresta das Trevas"),
	ElfLoth("Elfo de Lothlórien", "Caras Galadhon"),
	Anao("Anão", "Colinas de Ferro");

	public final String race;
	public final String nation;

	private Race(String race, String nation) {
		this.race = race;
		this.nation = nation;
	}

	public static Race random() {
		Race[] races = Race.values();
		return races[new Random().nextInt(races.length)];
	}

	public static Race selectRace() {
		Race[] races = Race.values();

		System.out.println("\n\nSelect A Race:");

		String options = IntStream
				.range(0, races.length)
				.mapToObj(i -> String.format("[%s] %s \tfrom %s", i, races[i].race, races[i].nation))
				.reduce((a, c) -> a + "\n" + c)
				.get();

		System.out.println(options);
		System.out.print(" Race: ");

		int raceIndex = Util.getAmount();

		if (0 <= raceIndex && raceIndex < races.length) {
			Race race = races[raceIndex];
			System.out.println(String.format("You selected: %s", race.race, race.nation));
			Util.sleep(1000);
			return race;
		}

		System.out.println("Invalid Race!");
		return selectRace(); // Try again
	}

}
