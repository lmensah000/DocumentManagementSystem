package scenes;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MainMenu extends Scene {

	private static final long serialVersionUID = 6000860871743994634L;

	public MainMenu() {
		setLayout(null);
		
		category_btn = new JButton("Categories");
		topic_btn = new JButton("Topics");
		document_btn = new JButton("Documents");
		
		//Clicking on the category button
		category_btn.addActionListener(action -> {
			AppController.VIEW_TYPE = "Categories";
			AppController.LoadCategories();
			AppController.DOCUMENT_SCENE.enterScene();
		});
		
		//Clicking on the topic button
		topic_btn.addActionListener(action -> {
			AppController.VIEW_TYPE = "Topics";
			AppController.DOCUMENT_SCENE.enterScene();
		});
		
		//Clicking on the document button
		document_btn.addActionListener(action -> {
			AppController.VIEW_TYPE = "Documents";
			AppController.DOCUMENT_SCENE.enterScene();
		});
		
		title_label = new JLabel("Document Management System");
		title_label.setFont(new Font("Helvetica", Font.BOLD, 32));
		
		add(category_btn);
		add(topic_btn);
		add(document_btn);
		add(title_label);
	}
	
	@Override
	public void OnEnter() {
		
		category_btn.setBounds(230, 300, 100, 30);
		topic_btn.setBounds(350, 300, 100, 30);
		document_btn.setBounds(470, 300, 100, 30);
		
		title_label.setBounds(getWidth()/2 - 250, 50, 500, 100);
	}
	
	@Override
	public void Update() {
	}

	private JButton category_btn,
					topic_btn,
					document_btn;
	private JLabel title_label;
}
