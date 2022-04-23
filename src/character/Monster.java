package src.character;

public class Monster implements Attackable {

	public Integer life = 100;

	@Override
	public void attack(Attackable other) {
		other.takeDamage(20);
	}

	@Override
	public void takeDamage(Integer damage) {
		life = Math.min(0, life - damage);
		System.out.println(String.format("%s took %s damage! Now with %s of life", this, damage, life));
	}

}
