import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
public class Level2 implements Ilevel {

	LevelController controller;
	
	
	
	public Level2(LevelController controller) {
		
		this.controller = controller;
	}



	public void changeState() {
		JOptionPane.showMessageDialog(null, "Level3","Congrats!", JOptionPane.INFORMATION_MESSAGE);
		controller.changeToLevel3();
	}

}
