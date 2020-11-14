import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;

public class CoppolaAddItem extends JFrame {

	//Allows fields to have a money format
	NumberFormat Curr = NumberFormat.getCurrencyInstance();
	
	private JPanel contentPane;
	private final JLabel lblName = new JLabel("Item Name");
	private final JLabel lblID = new JLabel("ID");
	private final JTextField idTF = new JTextField();
	private final JTextField nameTF = new JTextField();
	private final JLabel lblCategory = new JLabel("Category");
	private final JLabel lblWholeSalePrice = new JLabel("WholeSale");
	private final JComboBox categoryCB = new JComboBox();
	private final JLabel lblRetailprice = new JLabel("Retail");
	private final JLabel lblQoh = new JLabel("QOH");
	private final JTextField qohTF = new JTextField();
	private final JLabel lblMinquant = new JLabel("Min Quant");
	private final JLabel lblClerk = new JLabel("Clerk");
	private final JTextField minQuantTF = new JTextField();
	private final JTextField clerkTF = new JTextField();
	private final JButton btnAddItem = new JButton("Add Item");
	private final JButton btnCancel = new JButton("Cancel");
	//Has the money Format
	//put Curr in the parens to add money format
	private final JFormattedTextField wholeSaleFTF = new JFormattedTextField();
	private final JFormattedTextField retailFTF = new JFormattedTextField();
	
	private final JLabel lblAddItem = new JLabel("Add Item");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoppolaAddItem frame = new CoppolaAddItem();
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
	public CoppolaAddItem() {
		qohTF.setToolTipText("Enter the current quantity we have on hand");
		qohTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_qohTF_focusLost(e);
			}
		});
		qohTF.setFont(new Font("Courier New", Font.PLAIN, 13));
		qohTF.setBounds(109, 303, 116, 22);
		qohTF.setColumns(10);
		nameTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_nameTF_focusLost(arg0);
			}
		});
		nameTF.setToolTipText("Enter the item's name");
		nameTF.setFont(new Font("Courier New", Font.PLAIN, 13));
		nameTF.setBounds(109, 129, 116, 22);
		nameTF.setColumns(10);
		idTF.setToolTipText("Enter a unique ID number");
		idTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_idTF_focusLost(arg0);
			}
		});
		
		idTF.setFont(new Font("Courier New", Font.PLAIN, 13));
		idTF.setBounds(109, 78, 116, 22);
		idTF.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Add Item");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 312, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblName.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblName.setBounds(12, 129, 85, 22);
		
		contentPane.add(lblName);
		lblID.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblID.setBounds(12, 73, 43, 32);
		
		contentPane.add(lblID);
		
		contentPane.add(idTF);
		
		contentPane.add(nameTF);
		lblCategory.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblCategory.setBounds(12, 179, 72, 22);
		
		contentPane.add(lblCategory);
		lblWholeSalePrice.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblWholeSalePrice.setBounds(12, 222, 87, 22);
		
		contentPane.add(lblWholeSalePrice);
		categoryCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_categoryCB_focusLost(e);
			}
		});
		categoryCB.setToolTipText("Select the category of the item");
		categoryCB.setFont(new Font("Courier New", Font.PLAIN, 13));
		categoryCB.setModel(new DefaultComboBoxModel(new String[] {"Choose", "Dairy", "Meat", "Frozen", "Canned", "Produce", "Beverage", "Paper", "Snack", "Cereal", "Other"}));
		categoryCB.setBounds(109, 178, 116, 22);
		
		contentPane.add(categoryCB);
		lblRetailprice.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblRetailprice.setBounds(12, 270, 54, 16);
		
		contentPane.add(lblRetailprice);
		lblQoh.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblQoh.setBounds(12, 309, 56, 16);
		
		contentPane.add(lblQoh);
		
		contentPane.add(qohTF);
		lblMinquant.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblMinquant.setBounds(12, 346, 87, 16);
		
		contentPane.add(lblMinquant);
		lblClerk.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblClerk.setBounds(12, 389, 56, 16);
		
		contentPane.add(lblClerk);
		minQuantTF.setToolTipText("Enter the minimum quantity of that item");
		minQuantTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_minQuantTF_focusLost(e);
			}
		});
		minQuantTF.setFont(new Font("Courier New", Font.PLAIN, 13));
		minQuantTF.setColumns(10);
		minQuantTF.setBounds(109, 344, 116, 22);
		
		contentPane.add(minQuantTF);
		clerkTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_clerkTF_focusLost(e);
			}
		});
		clerkTF.setToolTipText("Enter the name of the clerk that checked out this item");
		clerkTF.setFont(new Font("Courier New", Font.PLAIN, 13));
		clerkTF.setColumns(10);
		clerkTF.setBounds(109, 387, 116, 22);
		
		contentPane.add(clerkTF);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAddItem_actionPerformed(e);
			}
		});
		btnAddItem.setToolTipText("Press to add this item to our database");
		btnAddItem.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnAddItem.setBounds(109, 422, 116, 32);
		
		contentPane.add(btnAddItem);
		btnCancel.setToolTipText("Cancel adding this item");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnCancel.setBounds(109, 467, 116, 32);
		
		contentPane.add(btnCancel);
		wholeSaleFTF.setText("0");
		wholeSaleFTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_wholeSaleFTF_focusLost(e);
			}
		});

		wholeSaleFTF.setToolTipText("Enter the price of the item that the store bought it for");
		wholeSaleFTF.setFont(new Font("Courier New", Font.PLAIN, 13));
		wholeSaleFTF.setHorizontalAlignment(SwingConstants.RIGHT);
		wholeSaleFTF.setBounds(109, 221, 116, 22);
		
		contentPane.add(wholeSaleFTF);
		retailFTF.setText("0");
		retailFTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_retailFTF_focusLost(e);
			}
		});
		retailFTF.setToolTipText("Enter the price that the consumer paid for");
		retailFTF.setFont(new Font("Courier New", Font.PLAIN, 13));
		retailFTF.setHorizontalAlignment(SwingConstants.RIGHT);
		retailFTF.setBounds(109, 266, 116, 22);
		
		contentPane.add(retailFTF);
		lblAddItem.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblAddItem.setBounds(109, 28, 96, 36);
		
		contentPane.add(lblAddItem);
	}
	
	//Cancels the item from being added into the database
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) 
	{
		this.dispose();
	}//Cancel
	
	//finds if the string only has digits
		public boolean numSearch (String chars)
		{
			boolean digit = true;
			char [] characters = chars.toCharArray();
			
			//makes sure that all the characters are digits
			for(int count = 0; count < chars.length() ; count++)
			{
				//Finds if the character is a digit
				if(Character.isDigit(characters[count]))
				{
					digit  = true;
				}//if
				else
				{
					digit = false;
				}//else
				
				count ++;
			}//while
			
			return digit;
		}//numSearch
	
	//Makes sure that the number is an integer
	public void integerNum(JTextField tf, JLabel lbl )
	{
		//Makes sure the text field is not empty
		if(!tf.getText().isEmpty())
			
		
			if(numSearch(tf.getText().trim()))
			 {
				 if(Integer.parseInt(tf.getText()) < 0)
					 lbl.setForeground(Color.RED);
				 else
					 lbl.setForeground(Color.BLUE);
			 }//if
			 else
			 {
				 JOptionPane.showMessageDialog(this, "Please make sure you enter a real number", "Invaild Intger Value", JOptionPane.ERROR_MESSAGE);
				 lbl.setForeground(Color.RED);
			 }//else
		else
		{
			JOptionPane.showMessageDialog(this, "Please make sure you enter a number", "Empty Value", JOptionPane.ERROR_MESSAGE);
			lbl.setForeground(Color.RED);
		}//else
		
	}//IntegerNum
		
	//ID validation	
	protected void do_idTF_focusLost(FocusEvent arg0)
	{
		integerNum(idTF, lblID);
		
		//HERE YOU MUST ENSURE THAT THE VALUE ENTERED IS NOT A REPEAT!!!!
		
	}//ID Text Field
	
	//ItemName Validation
	protected void do_nameTF_focusLost(FocusEvent arg0) 
	{
		if(nameTF.getText().isEmpty())
			lblName.setForeground(Color.RED);
		else
		{
			lblName.setForeground(Color.BLUE);
		}//else
	}//Item Name
	
	//QOH validation
	protected void do_qohTF_focusLost(FocusEvent e) 
	{
		integerNum(qohTF, lblQoh);
	}//QOH Text Field
	
	
	protected void do_minQuantTF_focusLost(FocusEvent e)
	{
		integerNum(minQuantTF, lblMinquant);
	}//MinQuant TextField
	
	//Category Validation
	protected void do_categoryCB_focusLost(FocusEvent e)
	{
		if(categoryCB.getSelectedItem().toString() == "Choose")
			lblCategory.setForeground(Color.RED);
		else
			lblCategory.setForeground(Color.BLUE);
	}//Category Combo Box 
	

	
	//Whole Sale Validation
	protected void do_wholeSaleFTF_focusLost(FocusEvent e) 
	{
		if( Integer.parseInt(wholeSaleFTF.getText()) <= 0)
			lblWholeSalePrice.setForeground(Color.RED);

		else
			lblWholeSalePrice.setForeground(Color.BLUE);
	}//Whole Sale FTF
	
	//Retail Sale Validation
	protected void do_retailFTF_focusLost(FocusEvent e)
	{
		if(Integer.parseInt(retailFTF.getText()) <= 0)
			lblRetailprice.setForeground(Color.RED);
		else
			lblRetailprice.setForeground(Color.BLUE);	
	}//Retail Formatted Text Field
	
	//Clerk Validation
	protected void do_clerkTF_focusLost(FocusEvent e)
	{
		if(clerkTF.getText().isEmpty())
			lblClerk.setForeground(Color.RED);
		else
			lblClerk.setForeground(Color.BLUE);
	}//Clerk Text Field

	protected void do_btnAddItem_actionPerformed(ActionEvent e) 
	{
		 boolean run = true;
		 
		 JLabel labels [] = new JLabel [8];
		 labels[0] = lblID;
		 labels[1] = lblName;
		 labels[2] = lblCategory;
		 labels[3] = lblWholeSalePrice;
		 labels[4] = lblRetailprice;
		 labels[5] = lblQoh;
		 labels[6] = lblMinquant;
		 labels[7]=  lblClerk;
		
		 for(int i = 0; i > labels.length; i++ )
		 {
			 //Checks if any of the label have any errors
			if( labels[i].getForeground().toString() == "java.awt.Color[r=0,g=0,b=255]\r\n" + "");
			{
				run = false;
				//test
				System.out.println("False");
				JOptionPane.showMessageDialog(this, "Error on "+labels[i].getText(), "Invalid Data", JOptionPane.ERROR_MESSAGE);
			}//if
		 }//for
		 
		//ONCE THE VALIDATION IS CHECKS POSTIVE PROCEED
		if(run)
		{
			DataCoppola.setID(idTF.getText().toString());
			DataCoppola.setName(nameTF.getText().toString());
			DataCoppola.setCat(categoryCB.getSelectedItem().toString());
			DataCoppola.setWhole(wholeSaleFTF.getText().toString());
			DataCoppola.setRetail(retailFTF.getText().toString());
			DataCoppola.setQOH(qohTF.getText().toString());
			DataCoppola.setMinQuant(minQuantTF.getText().toString());
			DataCoppola.setClerk(clerkTF.getText().toString());
			DataCoppola.signal(true);
	
			this.dispose();
			
			System.out.println(DataCoppola.getName());
		}//if
	}//Add Button
	
}
