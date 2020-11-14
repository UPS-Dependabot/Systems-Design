import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class HelpCoppola extends JFrame {

	private JPanel contentPane;
	private final JLabel lblHelpMenu = new JLabel("Help Menu");
	private final JButton btnClose = new JButton("Close");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenuItem mntmMainMenuControls = new JMenuItem("Main Menu Controls");
	private final JMenuItem mntmAddIttemControls = new JMenuItem("Add Item Controls");
	private final JMenuItem mntmPriceSettingsControls = new JMenuItem("Price Controls");
	private final JMenuItem mntmCategoryControls = new JMenuItem("Category Controls");
	private final JLabel lblNewLabel = new JLabel("Select one of the Items above to get in depth explainations about how each screen works in the program. ");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpCoppola frame = new HelpCoppola();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HelpCoppola() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Help Coppola");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 692, 229);
		
		setJMenuBar(menuBar);
		mntmMainMenuControls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmMainMenuControls_actionPerformed(e);
			}
		});
		
		menuBar.add(mntmMainMenuControls);
		mntmAddIttemControls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAddIttemControls_actionPerformed(e);
			}
		});
		
		menuBar.add(mntmAddIttemControls);
		mntmPriceSettingsControls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmPriceSettingsControls_actionPerformed(e);
			}
		});
		
		menuBar.add(mntmPriceSettingsControls);
		mntmCategoryControls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmCategoryControls_actionPerformed(e);
			}
		});
		
		menuBar.add(mntmCategoryControls);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblHelpMenu.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblHelpMenu.setBounds(261, 13, 111, 33);
		
		contentPane.add(lblHelpMenu);
		btnClose.setToolTipText("Closes the help menu");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnClose_actionPerformed(e);
			}
		});
		btnClose.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnClose.setBounds(275, 101, 97, 25);
		
		contentPane.add(btnClose);
		lblNewLabel.setBounds(26, 58, 608, 16);
		
		contentPane.add(lblNewLabel);
	}

	//Closes the Help menu
	protected void do_btnClose_actionPerformed(ActionEvent e) 
	{
		this.dispose();
	}//Close
	protected void do_mntmMainMenuControls_actionPerformed(ActionEvent e) 
	{
		JOptionPane.showMessageDialog(this, "<html>  The main menu is where you begin in the program. <br>"
				+ "Here you can look at all the filters that are currently being applied to the table <br>"
				+ "In order to change the filters select the Tools menu on the top of the screen:"
				+ "There you will see 3 options:"
				+ "		Add Item- adds an item <br>"
				+ "		Set Sort- Sorts the table by the item's:<br>"
				+ "						-Name<br>"
				+ "						-Price<br>"
				+ "						-Category<br>"
				+ "		Set Filter- Filters the items with<br>"
				+ "						-Price<br>"
				+ "						-Category<br>"
				+ "You can also select the File menu and exit the program<br>"
				+ "<br>"
				+ "When you Select Search towards the bottom of the screen to upadate all the changes you have made.<br>"
				+ "This is where all the changes you have created will be aplied<br>"
				+ "Add wil add a new item into the dataabase<br>"
				+ "The item will not appear in the tabel until you press search agiain",
				"Main Menu Controls", JOptionPane.PLAIN_MESSAGE);  
	}//Main Menu Help
	
	protected void do_mntmAddIttemControls_actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(this, "<html>  The Add Item menu is where you add new items into your table. <br>"
			+ "Here you can select all properties that are attached to the prodcut <br>"
			+ "All of the feilds are required!!<br>"
			+ "The ID must be a unquie number!<br>"
			+ "If it is not the program wil not let you add it when you click on Search in the home menu.<br>"
			+ " Type in the name of the item for the item name.<br>"
			+ "The category describes what type of item you have<br>"
			+ "However you are restricted to the options in the combo box<br>"
			+ "WholeSale is the price that our company has purchased the item for.<br>"
			+ "Retail is the price that our consumer is paying for the product<br>"
			+ "QOH is the quanty of we have on hand of that specific type of item.<br>"
			+ "Min Quant is the minimum quantity of an item we can have<br>"
			+ "Clerk needs the name of the clerk that checked out the item<br>"
			+ "The add item button will set all of these feilds into the stored data.<br>"
			+ "However it will not be added into the table until you press add  and then search in the main menu<br>"
			+ "In the main menu it will also give you an error message if the item you entered has a duplicate ID<br>"
			+ "Finally you can press cancel to not apply the changes you made<br>",
			"Add Item Controls", JOptionPane.PLAIN_MESSAGE);  
	}//Add Item Help
	protected void do_mntmPriceSettingsControls_actionPerformed(ActionEvent e) 
	{
		JOptionPane.showMessageDialog(this, "<html>  Price Range determines the price range you will have <br>"
				+ "Next to the Highest Label you can enter the Highest price that you will see in the table <br>"
				+ "Next to the Lowest Label you can enter the Lowest price that you will see in the table <br>"
				+ "Enter will apply these changes<br>"
				+ "Cancel will discard the chages<br>",
				"Add Item Controls", JOptionPane.PLAIN_MESSAGE); 
	}//Price Controls 
	
	protected void do_mntmCategoryControls_actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(this, "<html>   <br>"
				+ "In the categories screen you select the checkboxes nex to the categories that you want to search for <br>"
				+ "Select confirm to apply your changes <br>"
				+ "Cancel will discard the chages<br>",
				"Add Item Controls", JOptionPane.PLAIN_MESSAGE); 
	}//Category Controls
}
