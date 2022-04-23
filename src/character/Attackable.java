package src.character;

public interface Attackable {

	void attack(Attackable other);

	void takeDamage(Integer damage);

}
