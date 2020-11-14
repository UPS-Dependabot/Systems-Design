import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class InventoryCoppolaJFrame extends JFrame {

	//Step 1 Load the Driver using a class variable available to the entire project
	private String connString = "jdbc:ucanaccess://C:/users/Public/InventoryCoppola.accdb";
	
	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnTools = new JMenu("Tools");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenuItem mntmAddItem = new JMenuItem("Add Item");
	private final JMenu mnSetSort = new JMenu("Set Sort");
	private final JMenuItem mntmName = new JMenuItem("ItemName");
	private final JMenuItem mntmRetailPrice = new JMenuItem("RetailPrice");
	private final JMenuItem mntmCategory = new JMenuItem("ItemCategory");
	private final JMenu mnSetFilter = new JMenu("Set Filter");
	private final JMenuItem mntmByRetailPrice = new JMenuItem("By Retail Price");
	private final JMenuItem mntmByCategory = new JMenuItem("By Category");
	private final JMenuItem mntmHelp = new JMenuItem("Help");
	private final JTable itemTable = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblItems = new JLabel("Items");
	private final JLabel lblSortedBy = new JLabel("Sorted By:");
	private final JLabel lblSort = new JLabel("ID");
	private final JLabel lblFilter = new JLabel("Filters:");
	private final JLabel lblCategories = new JLabel("Nothing Selected");
	private final JLabel lblRange = new JLabel("None");
	private final JLabel lblCategoriesStatus = new JLabel("Categories:");
	private final JLabel lblRange_1 = new JLabel("Price Range:");
	private final JButton btnSearch = new JButton("Search");
	private final JButton btnAdd = new JButton("Add");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryCoppolaJFrame frame = new InventoryCoppolaJFrame();
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
	public InventoryCoppolaJFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Inventory Coppola");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 725, 564);
		
		//Step 1a) actually loads the driver so we can access the connection
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}//try
		catch (ClassNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//catch
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnTools);
		mntmAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAddItem_actionPerformed(e);
			}
		});
		
		mnTools.add(mntmAddItem);
		
		mnTools.add(mnSetSort);
		mntmName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmName_actionPerformed(e);
			}
		});
		
		mnSetSort.add(mntmName);
		mntmRetailPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmRetailPrice_actionPerformed(e);
			}
		});
		
		mnSetSort.add(mntmRetailPrice);
		mntmCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmCategory_actionPerformed(e);
			}
		});
		
		mnSetSort.add(mntmCategory);
		
		mnTools.add(mnSetFilter);
		mntmByRetailPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByRetailPrice_actionPerformed(e);
			}
		});
		
		mnSetFilter.add(mntmByRetailPrice);
		mntmByCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByCategory_actionPerformed(e);
			}
		});
		
		mnSetFilter.add(mntmByCategory);
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmHelp_actionPerformed(e);
			}
		});
		
		menuBar.add(mntmHelp);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(0, 203, 707, 288);
		
		contentPane.add(scrollPane);
		itemTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ItemID", "ItemName", "ItemCategory", "WholeSale", "RetailPrice", "QOH", "MinQuant", "Clerk"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Object.class, Double.class, Double.class, Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		itemTable.setFont(new Font("Courier New", Font.PLAIN, 13));
		scrollPane.setViewportView(itemTable);
		lblItems.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblItems.setBounds(303, 167, 70, 23);
		
		contentPane.add(lblItems);
		lblSortedBy.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblSortedBy.setBounds(39, 142, 85, 16);
		
		contentPane.add(lblSortedBy);
		lblSort.setToolTipText("How the table is sorted");
		lblSort.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblSort.setBounds(136, 142, 126, 16);
		
		contentPane.add(lblSort);
		lblFilter.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblFilter.setBounds(12, 13, 85, 16);
		
		contentPane.add(lblFilter);
		lblCategories.setToolTipText("Categories for the items that are currently on the table");
		lblCategories.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblCategories.setBounds(73, 113, 622, 16);
		
		contentPane.add(lblCategories);
		lblRange.setToolTipText("The range of prices for the items that are currently on the table.");
		lblRange.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblRange.setBounds(73, 59, 137, 16);
		
		contentPane.add(lblRange);
		lblCategoriesStatus.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblCategoriesStatus.setBounds(39, 84, 137, 16);
		
		contentPane.add(lblCategoriesStatus);
		lblRange_1.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblRange_1.setBounds(39, 30, 105, 16);
		
		contentPane.add(lblRange_1);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSearch_actionPerformed(arg0);
			}
		});
		btnSearch.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnSearch.setToolTipText("Filters and Orders the Items according to the specifications you have made above.");
		btnSearch.setBounds(39, 167, 118, 25);
		
		contentPane.add(btnSearch);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setToolTipText("Adds a new item into the database. Select search to make it appear in the table.");
		btnAdd.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnAdd.setBounds(553, 168, 118, 25);
		
		contentPane.add(btnAdd);
	}
	
	//Ends the Program
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) 
	{
		this.dispose();
	}//Exit
	
	//Displays the Add Item menu
	protected void do_mntmAddItem_actionPerformed(ActionEvent e) 
	{
		CoppolaAddItem addScreen = new CoppolaAddItem();
		addScreen.setVisible(true);
		
	}//AddItem
	
	//Displays the Price Range menu
	protected void do_mntmByRetailPrice_actionPerformed(ActionEvent e)
	{
		RetailCoppola rangeScreen = new RetailCoppola();
		rangeScreen.setVisible(true);
	
	}//Retail Price
	
	//Displays the Category Menu 
	protected void do_mntmByCategory_actionPerformed(ActionEvent e)
	{
		CategoryCoppola categoryScreen = new CategoryCoppola();
		categoryScreen.setVisible(true);
	}//Item Category
	
	//Displays the Help menu
	protected void do_mntmHelp_actionPerformed(ActionEvent e) 
	{
		HelpCoppola helpScreen = new HelpCoppola();
		helpScreen.setVisible(true);
	}//Help Menu
	
	//Changes the Name of the Sort Label
	public void sortLabel( String sort )
	{
		if(lblSort.getText() == sort)
		{
			lblSort.setText("ID");
			//CHANGE THE ORDER BY IN THE QUERY HERE
			DataCoppola.setOrderBy("ORDER BY ItemID");
		}//if
		else
		{
			lblSort.setText(sort);
			//CHANGE THE ORDER BY IN THE QUERY HERE
			DataCoppola.setOrderBy("ORDER BY "+sort);
		}//else
	}//SortLabel
	
	//Orders the items by name
	protected void do_mntmName_actionPerformed(ActionEvent e)
	{	
		//Changes the label
		sortLabel("ItemName");
		
	}//Name Sort
	
	//Orders the items by retail price
	protected void do_mntmRetailPrice_actionPerformed(ActionEvent e) 
	{
		//Changes the label
		sortLabel("RetailPrice");
	
	}//Retail Sort
	
	//Orders the items by category
	protected void do_mntmCategory_actionPerformed(ActionEvent e) 
	{
		//Changes the label
		sortLabel("ItemCategory");
	
	}//Category Sort
	
	//Toggles the Range Status Label
	public void rangeText()
	{
		lblRange.setText( DataCoppola.getLowPrice()+ " - " +DataCoppola.getHighPrice());	
	}//RangeText
	

	//Finds what categories will be in the query
	public String findCategories(int index)
	{
		String cat = "Error";
		
		switch(index)
		{
		case 0:
			cat = "Dairy";
			break;
		case 1:
			cat = "Meat";
			break;
		case 2:
			cat = "Frozen";
			break;
		case 3:
			cat = "Canned";
			break;
		case 4:
			cat = "Produce";
			break;
		case 5:
			cat = "Beverage";
			break;
		case 6:
			cat = "Paper";
			break;
		case 7:
			cat = "Snack";
			break;
		case 8:
			cat = "Other";
			break;
		}//switch
		
		return cat;
		
	}//findCategories
	
	//Searches for the user's results
	protected void do_btnSearch_actionPerformed(ActionEvent arg0) 
	{

		//Updates the UI to show the users range of prices
		rangeText();
		
		//Searches with the given filters
		search();

	}//SearchButton
	
	//searches with the filters the user specified 
	public void search()
	{
		ResultSet rs = null;
		Statement stmt = null;
		
		boolean categories [] = new boolean [9];
		categories[0] = DataCoppola.getDairy();
		categories[1] = DataCoppola.getMeat();
		categories[3] = DataCoppola.getFrozen();
		categories[4] = DataCoppola.getCanned();
		categories[5] = DataCoppola.getBeverage();
		categories[6] = DataCoppola.getPaper();
		categories[7] = DataCoppola.getSnack();
		categories[8] = DataCoppola.getOther();
		
		boolean noORs = true;
		
		String catInUse = "";
		
		try 
		{
			//Step 2 Establish Connection
			Connection conn = DriverManager.getConnection(connString);
			
			//Step 3 Create the SQL statement
			stmt = conn.createStatement();

			//Currently set the query to just load everything
			String theQuery = "SELECT ItemID, ItemName, ItemCategory, WholeSale, RetailPrice, QOH, MinQuant, Clerk";
			theQuery += " FROM ITEMS AS I";
			theQuery +=" WHERE(1 = 1)";
			if(DataCoppola.getHigh() != null)
			{
				theQuery += " "+DataCoppola.getHigh();
			}//if
			if(DataCoppola.getLow() != null)
			{
				theQuery +=  " "+DataCoppola.getLow();
			}//if
		
			
			//Finds if there are any categories selected
			for(int i = 0; i < categories.length && noORs ; i++)
			{
				//Finds if any categories are selected 
				if(categories[i])
				{					
					theQuery +=" AND ((1 = 0)";
					theQuery +=" OR(ItemCategory = '"+ findCategories(i)  +"')";
					noORs = false;
					
					for(int counter = i+1; counter < categories.length; counter++)
					{
						//Adds the the selected items into the Query Statement
						if(categories[counter])
						{
							theQuery += " OR(ItemCategory = '"+ findCategories(counter) +"')";
							catInUse += findCategories(counter)+", ";
							
						}//if
					}//for
					
					theQuery +=" )";
				}//if
			}//for
			
			//Displays categories that the user is currently using
			lblCategories.setText(catInUse);
			
			//Determines how to order the query
			if(DataCoppola.getOrderBy() != null)
				theQuery += " "+DataCoppola.getOrderBy().trim();
			
			
			
			//test
			System.out.println(theQuery);
			
			
			//Step 4 execute the statement
			rs = stmt.executeQuery(theQuery);
			
			//Remove any previously added rows form the table
			while(itemTable.getRowCount()>0)
				((DefaultTableModel)itemTable.getModel()).removeRow(0);
			
			int numColumns = rs.getMetaData().getColumnCount();
			
			//While the result set has another record
			while(rs.next())
			{
				//Create an array tp hold a single record
				Object[] row = new Object[numColumns];
				
				//get each field in the record
				for(int i = 0; i < numColumns; i++)
					row[i] =  rs.getObject(i+1);
				
				//Insert the record into the table
				((DefaultTableModel)itemTable.getModel()).insertRow(rs.getRow() - 1, row);
			}//while
			
			//Step 6 Close stuff
			rs.close();
			stmt.close();
			conn.close();
			
		}//try
		
		catch (SQLException ex)
		{
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		} //catch
	}//Search
	
	//Adds the new item into the table
	public void insert()
	{
		//Tells the program when to add the new item
		if(DataCoppola.update())
		{
			try
			{
				
				Statement insertS;
				String insertQ;
				
				//Step 2 Establish Connection
				Connection conn = DriverManager.getConnection(connString);
				
				//If there is no duplicate continue
				if(!isDuplicate(DataCoppola.getID()))
				{
					//Step 3 Create the SQL statement
					insertS = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
					insertQ =  "INSERT INTO ITEMS (ItemID, ItemName, ItemCategory, WholeSale,  RetailPrice, QOH, MinQuant, Clerk)";
				    insertQ += "VALUES (";
				    //tests to get rid of the null pointer exception
				    if(DataCoppola.getID() != null)
				    	insertQ	+= " '"+ DataCoppola.getID().trim()+"' ,";
				    if(DataCoppola.getName() != null)
				    	insertQ	+= " '"+ DataCoppola.getName().trim()+ "' ,";
				    if(DataCoppola.getCat() != null)
				    	insertQ += " '"+ DataCoppola.getCat().trim() +"' ,";
				    if(DataCoppola.getWhole() != null)
				    	insertQ += " '"+ DataCoppola.getWhole().trim() +"' ,";
				    if(DataCoppola.getRetail() != null)
				    	insertQ += " '"+DataCoppola.getRetail().trim()+"', ";
				    if(DataCoppola.getQOH() != null)
				    	insertQ += " '"+DataCoppola.getQOH().trim()+ "', ";
				    if(DataCoppola.getMinQuant() != null)
				    	insertQ += " '"+DataCoppola.getMinQuant().trim()+"', ";
				    if(DataCoppola.getClerk() != null)
				    	insertQ += " '"+ DataCoppola.getClerk().trim()+"' )";
				    
					System.out.println(insertQ);
					
					//Execute the statement
					if(insertS.executeUpdate(insertQ) != 0)
					{
						//test
						System.out.println("Success");
					}//if
					
					insertS.close();
					conn.close();
				}//if
				
				//Error if there is a duplicate
				else 
				{
					JOptionPane.showMessageDialog(this, "The item you want to add has an ID that aleardy exists! Duplicate IDs are not allowed!", "Duplicates", JOptionPane.PLAIN_MESSAGE);
				}//else
			}//try
				
			catch (SQLException ex)
			{
				System.out.println("SQL Exception: " + ex.getMessage());
				System.out.println("SQL State: " + ex.getSQLState());
				System.out.println("Vendor Error: " + ex.getErrorCode());
				ex.printStackTrace();
			} //catch
	
		}//if
		
	}//insert
	
		//Tests for duplicate IDs
		public boolean isDuplicate(String id)
		{
			boolean copy = false;
			int counter = 0;
				
			ResultSet validR = null;
			Statement validS = null;
			
			try
			{
			//Establish Connection
			Connection validC = DriverManager.getConnection(connString);
			
			//Step 3 Create the SQL statement
			validS = validC.createStatement();
			
			//Validation Query
			String vQuery = " SELECT ItemID";
			       vQuery +=" FROM Items";
			       vQuery +=" WHERE ItemID = "+id; 
			
			 System.out.println(vQuery);      
			       
			//Step 4 execute the statement
			validR = validS.executeQuery(vQuery); 
		
			
			//Finds if there are any results
			if(validR.next())
				copy = true;
			
					
				validR.close();
				validS.close();
				validC.close();
			}//try
				
			catch (SQLException ex)
			{
				System.out.println("SQL Exception: " + ex.getMessage());
				System.out.println("SQL State: " + ex.getSQLState());
				System.out.println("Vendor Error: " + ex.getErrorCode());
				ex.printStackTrace();
			} //catch
			
			//try
			System.out.println(copy);
			
			return copy;
		}//isDuplicate
	

	protected void do_btnAdd_actionPerformed(ActionEvent e) 
	{
		//adds the new item
		insert();
	}//Add button
}
