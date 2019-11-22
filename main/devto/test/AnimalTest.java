import main.com.src.Animal;
import main.com.src.Cat;
import main.com.src.Dog;

public class AnimalTest {
	
	
	public static void main(String [] args) {
		Dog rover = new Dog("bacon");
		Cat bingo = new Cat("fish");
		
		GiveTreatTo(rover);
		GiveTreatTo(bingo);
	}

	private static void GiveTreatTo(Animal animal) {
		String msg = "You fed the "+ animal.getClass().getSimpleName() + " some " + animal.favoriteFood;
		System.out.println(msg);
	}

}
