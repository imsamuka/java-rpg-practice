package src.character;

import java.util.Random;

public class Character implements Attackable {

	public static final int MAX_LIFE = 100;

	public final Race race;
	public final Skills skills = new Skills();

	private Integer life = 100;
	private Integer energy = 100;

	public Character(Race race) {
		this.race = race;
	}

	public Integer getLife() {
		return life;
	}

	public Integer getEnergy() {
		return energy;
	}

	public void setLife(Integer life) {
		this.life = Math.max(0, life);
	}

	public void setEnergy(Integer energy) {
		this.energy = Math.max(0, life);
	}

	@Override
	public void attack(Attackable other) {
		float scale = Math.min(skills.getPrecision() / 100, 1);
		Random r = new Random();
		int d20 = 1 + r.nextInt(20);
		int damage = (int) ((float) skills.getStrength() * scale * (float) d20);
		other.takeDamage(damage);
	}

	@Override
	public void takeDamage(Integer damage) {
		float scale = Math.min(skills.getArmor() / 100, 1);

		setLife(life - (int) (damage / scale));

		System.out.println(String.format("%s took %s damage! Now with %s of life", race.race, damage, life));

	}

	@Override
	public String toString() {
		String str = race.race;
		str += "\n\tLife: " + life;
		str += "\n\tEnergy: " + energy;
		// str += "\n\tRace: " + race.race;
		str += "\n\tNation: " + race.nation;
		str += "\n\t" + skills;
		return str;

	}

}
