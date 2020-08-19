package scenes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import gui.Display;

public class AppController {

	/** Scenes **/
	public static Scene currentScene = null;
	public final static Scene MAIN_MENU_SCENE = new MainMenu();
	public final static Scene DOCUMENT_SCENE = new DocumentScene();
	
	public static Display display = null;
	
	public static String VIEW_TYPE = "";
	
	public static void enterScene(Scene scene) {
		if(currentScene != null) {
			currentScene.OnExit();
			currentScene.setVisible(false);
		}
		
		currentScene = scene;
		if(currentScene != null) {
			//Fill the parent container
			currentScene.setBounds(0, 0, Math.max(display.getSize().width, 0), Math.max(display.getSize().height, 0));
			currentScene.setVisible(true);
			currentScene.OnEnter();
		}
	}
	
	public static void LoadCategories() {
		data = new Object[2][10];//[Rows][Columns]
		File dataFile = new File("./category.txt");
		if(!dataFile.exists()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		int lineCount = 0;
		//At this point the file exists
		try {
			lineCount = Files.readAllLines(Paths.get(dataFile.toURI())).size();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		data = new Object[Math.max(10, lineCount)][2];
		String line = "";
		String[] tokens;
		int lineID = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
			while((line = br.readLine()) != null) {
				tokens = line.split(" = ");
				data[lineID][0] = tokens[0];
				data[lineID][1] = tokens[1];
				lineID++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object[][] data = new Object[10][2];//[Rows][Columns]
	
}
