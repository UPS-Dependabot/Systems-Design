import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CategoryCoppola extends JFrame {

	private JPanel contentPane;
	private final JLabel lblCategories = new JLabel("Categories");
	private final JCheckBox chckbxDairy = new JCheckBox("Dairy");
	private final JCheckBox chckbxMeat = new JCheckBox("Meat");
	private final JCheckBox chckbxFrozen = new JCheckBox("Frozen");
	private final JCheckBox chckbxCanned = new JCheckBox("Canned");
	private final JCheckBox chckbxProduce = new JCheckBox("Produce");
	private final JCheckBox chckbxBeverage = new JCheckBox("Beverage");
	private final JCheckBox chckbxPaper = new JCheckBox("Paper");
	private final JCheckBox chckbxSnack = new JCheckBox("Snack");
	private final JButton btnConfirm = new JButton("Confirm");
	private final JButton btnCancel = new JButton("Cancel");
	private final JCheckBox chckbxOther = new JCheckBox("Other");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryCoppola frame = new CategoryCoppola();
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
	public CategoryCoppola() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Category Coppola");
		setBounds(100, 100, 247, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCategories.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblCategories.setBounds(68, 28, 133, 26);
		
		contentPane.add(lblCategories);
		chckbxDairy.setFont(new Font("Courier New", Font.PLAIN, 15));
		chckbxDairy.setBounds(68, 63, 113, 25);
		
		contentPane.add(chckbxDairy);
		chckbxMeat.setFont(new Font("Courier New", Font.PLAIN, 15));
		chckbxMeat.setBounds(68, 108, 113, 25);
		
		contentPane.add(chckbxMeat);
		chckbxFrozen.setFont(new Font("Courier New", Font.PLAIN, 15));
		chckbxFrozen.setBounds(68, 149, 113, 25);
		
		contentPane.add(chckbxFrozen);
		chckbxCanned.setFont(new Font("Courier New", Font.PLAIN, 15));
		chckbxCanned.setBounds(68, 194, 113, 25);
		
		contentPane.add(chckbxCanned);
		chckbxProduce.setFont(new Font("Courier New", Font.PLAIN, 15));
		chckbxProduce.setBounds(68, 236, 113, 25);
		
		contentPane.add(chckbxProduce);
		chckbxBeverage.setFont(new Font("Courier New", Font.PLAIN, 15));
		chckbxBeverage.setBounds(68, 281, 113, 25);
		
		contentPane.add(chckbxBeverage);
		chckbxPaper.setFont(new Font("Courier New", Font.PLAIN, 15));
		chckbxPaper.setBounds(68, 322, 113, 25);
		
		contentPane.add(chckbxPaper);
		chckbxSnack.setFont(new Font("Courier New", Font.PLAIN, 15));
		chckbxSnack.setBounds(68, 367, 113, 25);
		
		contentPane.add(chckbxSnack);
		btnConfirm.setToolTipText("Updates the categories the next time you search.");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnConfirm_actionPerformed(arg0);
			}
		});
		btnConfirm.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnConfirm.setBounds(68, 461, 115, 37);
		
		contentPane.add(btnConfirm);
		btnCancel.setToolTipText("Cancel your changes");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnCancel.setBounds(70, 511, 115, 37);
		
		contentPane.add(btnCancel);
		chckbxOther.setFont(new Font("Courier New", Font.PLAIN, 15));
		chckbxOther.setBounds(68, 410, 113, 25);
		
		contentPane.add(chckbxOther);
	}
	//Cancels the Category Screen
	protected void do_btnCancel_actionPerformed(ActionEvent arg0)
	{
		this.dispose();
	}//Cancel
	
	protected void do_btnConfirm_actionPerformed(ActionEvent arg0)
	{
		DataCoppola.setDairy(chckbxDairy.isSelected());
		DataCoppola.setMeat(chckbxMeat.isSelected());
		DataCoppola.setFrozen(chckbxFrozen.isSelected());
		DataCoppola.setCanned(chckbxCanned.isSelected());
		DataCoppola.setProduce(chckbxProduce.isSelected());
		DataCoppola.setBeverage(chckbxBeverage.isSelected());
		DataCoppola.setPaper(chckbxPaper.isSelected());
		DataCoppola.setSnack(chckbxSnack.isSelected());
		DataCoppola.setOther(chckbxOther.isSelected());
		
		this.dispose();
	}//Confirm
}
