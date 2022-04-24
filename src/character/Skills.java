package src.character;

import java.util.Random;

import src.main.Util;

public class Skills {

	private int skillPoints = 100;

	private int strength = 1;
	private int precision = 1;
	private int speed = 1;
	private int armor = 1;
	private int regen = 1;

	public void spendSkillPoints() {
		if (skillPoints <= 0)
			return;

		System.out.println("\n\nYou have Skill Points to spend.");
		System.out.println("Choose One Skill.");
		System.out.println(this); // Show current skills and points
		System.out.print(" Skill: ");

		addPoints(Util.scanner.nextLine(), Util.askAmount());
		Util.sleep(1000);
		spendSkillPoints(); // Ask again
	}

	public void spendRandomly() {
		if (skillPoints <= 0)
			return;

		Random r = new Random();
		int min = 4;
		int max = 20;

		addPoints("armor", r.nextInt(max) + min);
		addPoints("precision", r.nextInt(max) + min);
		addPoints("regen", r.nextInt(max) + min);
		addPoints("speed", r.nextInt(max) + min);
		addPoints("strength", r.nextInt(max) + min);

		spendRandomly(); // Ask again
	}

	public void setSkillPoints(int skillPoints) {
		this.skillPoints = Math.max(0, skillPoints);
	}

	public int getSkillPoints() {
		return skillPoints;
	}

	public int getStrength() {
		return strength;
	}

	public int getPrecision() {
		return precision;
	}

	public int getSpeed() {
		return speed;
	}

	public int getArmor() {
		return armor;
	}

	public int getRegen() {
		return regen;
	}

	public void addPoints(String skill, int rawPoints) {
		if (rawPoints <= 0)
			return;

		int points = Math.min(skillPoints, rawPoints);

		switch (skill.strip().toLowerCase()) {
			case "armor":
				this.armor += points;
				break;
			case "precision":
				this.precision += points;
				break;
			case "regen":
				this.regen += points;
				break;
			case "speed":
				this.speed += points;
				break;
			case "strength":
				this.strength += points;
				break;
			default:
				System.out.println("Invalid Skill!");
				return;
		}

		// Decrease the skillPoints if we didn't return on default
		this.skillPoints -= points;
	}

	@Override
	public String toString() {

		String format = "Skills (%s Points Available)";
		format += "\n[Armor: %s, Precision: %s, Regen: %s, Speed: %s, Strength: %s]";

		return String.format(
				format, skillPoints,
				armor, precision, regen, speed, strength);

	}

}
