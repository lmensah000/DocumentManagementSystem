package scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * DocumentScene
 * 
 * This scene displays a table for the type of data of (Category/Document/Topic)
 **/
public class DocumentScene extends Scene {

	private static final long serialVersionUID = 1490571262834241618L;

	public DocumentScene() {
		setLayout(null);
		menu_btn = new JButton("<< Main menu");
		
		menu_btn.addActionListener(action -> {
			AppController.MAIN_MENU_SCENE.enterScene();
		});
		
		add(menu_btn);
	}
	
	@Override
	public void OnEnter() {
		menu_btn.setBounds(10, 10, 150, 30);
		
		if(table_panel != null)
			remove(table_panel);
		
		String[] header = null;
		if(AppController.VIEW_TYPE.equals("Categories"))
			header = headers[0];
		else if(AppController.VIEW_TYPE.equals("Topics"))
			header = headers[1];
		else if(AppController.VIEW_TYPE.equals("Documents"))
			header = headers[2];
		
		table = new JTable(new DefaultTableModel(AppController.data, header));
		table.setShowGrid(true);
		table.setFillsViewportHeight(true);
		table.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		table_panel = new JScrollPane(table);
		table_panel.setBounds(30, 50, 740, 300);
		table_panel.setViewportView(table);
		add(table_panel);
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D)graphics;
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Helvetica", Font.BOLD, 20));
		g.drawString("Viewing: "+AppController.VIEW_TYPE, getWidth()/2 - g.getFontMetrics().stringWidth("Viewing: "+AppController.VIEW_TYPE)/2, 30);
	}
	
	@Override
	public void Update() {
	}

	private final String[][] headers = {
			{"Category ID", "Name"},
			{"Topic ID", "Topic", "Storage folder"},
			{"Document ID", "Category ID", "Topic ID", "Tags", "Filename"}
	};
	private JButton menu_btn;
	private JTable table = null;
	private JScrollPane table_panel;
}
