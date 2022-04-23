package src.main;

import java.util.ArrayList;

import src.character.Character;
import src.character.Monster;
import src.character.Race;

public class Main {

	public static void main(String[] args) {

		// List of created characters
		ArrayList<Character> chars = new ArrayList<Character>(Race.values().length);

		// Create the player (selectable race and skills)
		Character player = new Character(Race.selectRace());
		player.skills.spendSkillPoints();
		chars.add(player);

		// Create every other race, with random values
		for (Race race : Race.values()) {
			if (race == player.race)
				continue;
			Character ch = new Character(race);
			ch.skills.spendRandomly();
			chars.add(ch);
		}

		// System.out.println(player);
		chars.stream().forEach(c -> System.out.println("\n" + c));

		// TODO: fix attack and takeDamage functions
		Monster slime = new Monster();
		player.attack(slime);
		slime.attack(player);

		Util.scanner.close();
	}

}
