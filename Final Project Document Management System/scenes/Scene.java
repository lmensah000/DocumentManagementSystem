package scenes;

import javax.swing.JPanel;

public abstract class Scene extends JPanel {

	/** Serial version UID **/
	private static final long serialVersionUID = 8500651598978836111L;
	
	/** Abstract methods **/
	public abstract void Update();
	
	/** Transition methods **/
	public void OnEnter() {}
	public void OnExit() {}
	
	public void enterScene() {
		AppController.enterScene(this);
	}
	
}