import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class RetailCoppola extends JFrame {

	private JPanel contentPane;
	private final JLabel lblPriceRange = new JLabel("Price Range");
	private final JLabel lblHighest = new JLabel("Highest");
	private final JLabel lblLowest = new JLabel("Lowest");
	private final JFormattedTextField highFTF = new JFormattedTextField();
	private final JFormattedTextField lowFTF = new JFormattedTextField();
	private final JButton btnEnter = new JButton("Enter");
	private final JButton btnCancel = new JButton("Cancel");

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetailCoppola frame = new RetailCoppola();
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
	public RetailCoppola() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Price Settings");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 368, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblPriceRange.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblPriceRange.setBounds(101, 13, 141, 57);
		
		contentPane.add(lblPriceRange);
		lblHighest.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblHighest.setBounds(12, 91, 63, 16);
		
		contentPane.add(lblHighest);
		lblLowest.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblLowest.setBounds(12, 141, 56, 16);
		
		contentPane.add(lblLowest);

		highFTF.setFont(new Font("Courier New", Font.PLAIN, 15));
		
		
		highFTF.setToolTipText("Enter the highest retail price you will pay");
		highFTF.setHorizontalAlignment(SwingConstants.RIGHT);
		highFTF.setBounds(101, 88, 141, 22);
		
		contentPane.add(highFTF);

		lowFTF.setFont(new Font("Courier New", Font.PLAIN, 15));
		lowFTF.setToolTipText("Enter the lowest retail price you will pay");
		lowFTF.setHorizontalAlignment(SwingConstants.RIGHT);
		lowFTF.setBounds(101, 138, 141, 22);
		
		contentPane.add(lowFTF);
		btnEnter.setToolTipText("Updates the price range. The next time you search.");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEnter_actionPerformed(e);
			}
		});
		btnEnter.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnEnter.setBounds(101, 185, 141, 25);
		
		contentPane.add(btnEnter);
		btnCancel.setToolTipText("Cancel your changes");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnCancel.setBounds(101, 223, 141, 25);
		
		contentPane.add(btnCancel);
	}
	
	
	//Tests for a negative number
	public boolean negative(JFormattedTextField ftf)
	{
		boolean positive = true;
		if(ftf.getText() != null)
		{
			if(Integer.parseInt(ftf.getText().trim()) < 0)
			{
				//Makes the text Red if the number is negative
				ftf.setForeground(Color.RED);
				positive = false;
			}//if
			else
				ftf.setForeground(Color.BLACK);
		}//if
		return positive;
	}//negative
	
	protected void do_btnEnter_actionPerformed(ActionEvent e)
	{
		if(highFTF.getText() == "" )
			highFTF.setText(DataCoppola.getHigh());
		if(lowFTF.getText().trim() ==  "")
			lowFTF.setText(DataCoppola.getLow());	
		
			//Makes sure the numbers are not negative
			if(negative(highFTF) && negative(lowFTF))
			{
				
				//Makes sure the low value is actually lower than the high value
				if(Integer.parseInt(highFTF.getText().trim()) < Integer.parseInt(lowFTF.getText().trim()))
				{
					JOptionPane.showMessageDialog(this, "Your range is not possible currently not possible" , "Invalid value", JOptionPane.ERROR_MESSAGE);
				}//if
				
				//YOU WILL EDIT YOUR QUERY IN THIS ELSE!!!!!!!
				else
				{
					//Range Label in InventoryCoppola Changes Here		
					DataCoppola.setHigh(Double.parseDouble(highFTF.getText()));
					DataCoppola.setLow(Double.parseDouble(lowFTF.getText()));
					
					this.dispose();
				}//else
				
			}//if
			else
			{
				JOptionPane.showMessageDialog(this, "Please enter a valid positve number in the red feilds" , "Invalid value", JOptionPane.ERROR_MESSAGE);
			}//else
	}//Enter

	protected void do_btnCancel_actionPerformed(ActionEvent arg0) 
	{
		this.dispose();
	}//Cancel Button
}
