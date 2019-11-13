
public class Level2 implements Ilevel {

	LevelController controller;
	
	
	
	public Level2(LevelController controller) {
		
		this.controller = controller;
	}



	public void changeState() {
		
		controller.changeToLevel3();
	}

}
