
public class Level1 implements Ilevel{

	LevelController controller;

	public Level1(LevelController controller) {
		
		this.controller = controller;
	}

	@Override
	public void changeState() {
		System.out.println("level1 to level2");
		controller.changeLevel2();
		
	}

	
	

	
}
