
public class FoodFactory extends Creators{

	Integer randomNumber=0;
	public Food getFood() {
		
		randomNumber++;
		if(randomNumber%2 == 0) {
			return new Apple();
		}
		else {
			return new Pizza();
		}
		
		
	}

}
