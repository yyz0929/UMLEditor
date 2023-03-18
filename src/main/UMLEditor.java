package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class UMLEditor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UMLEditor window = new UMLEditor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UMLEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		// We don't have auto resizing functionality.
		frame.setResizable(false);
		frame.setBounds(100, 100, 1388, 836);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Group");
		editMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ungroup");
		editMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Change Object Name");
		editMenu.add(mntmNewMenuItem);
		
		ButtonsPanel buttonsPanel = new ButtonsPanel();
		buttonsPanel.setBackground(new Color(255, 128, 128));

		
		Canvas canvas = new Canvas();
		
		canvas.setBackground(new Color(255, 255, 255));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(buttonsPanel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
					.addComponent(canvas, GroupLayout.PREFERRED_SIZE, 1270, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(buttonsPanel, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
						.addComponent(canvas, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE))
					.addContainerGap())
		);
		GroupLayout gl_canvas = new GroupLayout(canvas);
		gl_canvas.setHorizontalGroup(
			gl_canvas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1270, Short.MAX_VALUE)
		);
		gl_canvas.setVerticalGroup(
			gl_canvas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 764, Short.MAX_VALUE)
		);
		canvas.setLayout(gl_canvas);
		
		JToggleButton selectButton = new JToggleButton();
		selectButton.setSize(64, 64);
		selectButton.setToolTipText("Select");
		selectButton.setIcon(new ImageIcon("assets\\select.png"));
		selectButton.setSelected(true);
		selectButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (selectButton.isSelected()) {
					canvas.setState(new SelectState(canvas));
				}
			}
		});
		buttonsPanel.add(selectButton);
		buttonsPanel.addtoButtonGroup(selectButton);
		
		JToggleButton associationLineButton = new JToggleButton();
		associationLineButton.setSize(64, 64);
		associationLineButton.setToolTipText("Association Line");
		associationLineButton.setIcon(new ImageIcon("assets\\association.png"));
		associationLineButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (associationLineButton.isSelected()) {
					canvas.setState(new ALState());
				}
			}
		});
		buttonsPanel.add(associationLineButton);
		buttonsPanel.addtoButtonGroup(associationLineButton);
		
		JToggleButton generalizationLineButton = new JToggleButton();
		generalizationLineButton.setSize(64, 64);
		generalizationLineButton.setToolTipText("Generalization Line");
		generalizationLineButton.setIcon(new ImageIcon("assets\\generalization.png"));
		generalizationLineButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (generalizationLineButton.isSelected()) {
					canvas.setState(new GLState());
				}
			}
		});
		buttonsPanel.add(generalizationLineButton);
		buttonsPanel.addtoButtonGroup(generalizationLineButton);
		
		JToggleButton compositionLineButton = new JToggleButton();
		compositionLineButton.setSize(64, 64);
		compositionLineButton.setIcon(new ImageIcon("assets\\composition.png"));
		compositionLineButton.setToolTipText("Composition Line");
		compositionLineButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (compositionLineButton.isSelected()) {
					canvas.setState(new CLState());
				}
			}
		});
		buttonsPanel.add(compositionLineButton);
		buttonsPanel.addtoButtonGroup(compositionLineButton);
		
		JToggleButton classButton = new JToggleButton();
		classButton.setSize(64, 64);
		classButton.setToolTipText("Class");
		classButton.setIcon(new ImageIcon("assets\\class.png"));
		classButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (classButton.isSelected()) {
					canvas.setState(new ClassState());
				}
			}
		});
		buttonsPanel.add(classButton);
		buttonsPanel.addtoButtonGroup(classButton);
		
		JToggleButton useCaseButton = new JToggleButton();
		useCaseButton.setSize(64, 64);
		useCaseButton.setToolTipText("Use Case");
		useCaseButton.setIcon(new ImageIcon("assets\\uc.png"));
		useCaseButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (useCaseButton.isSelected()) {
					canvas.setState(new UCState());
				}
			}
		});
		buttonsPanel.add(useCaseButton);
		buttonsPanel.addtoButtonGroup(useCaseButton);
		frame.getContentPane().setLayout(groupLayout);
	}
}