package CS2020.assignment2;

import java.awt.BorderLayout;
import java.util.UUID;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ProductListGUI extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtfieldprodid;
	private JTextField txtfieldname;
	private JTextField txtfieldquantity;
	private JButton btndelete;
	private JComboBox<String> combotype;
	private JCheckBox chboxnextday;
    private UUID uuid;
    private JList<Products> list;
    DefaultListModel<Products> model;
    Products p;

	public ProductListGUI() {
                // Setup frame
		setTitle("<Dean Murray>: Assignment 2");
		uuid = UUID.randomUUID();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setSize(800,600);
		
		contentPane = new JPanel(new BorderLayout());
                //contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Initialise Model used by Jlist
		// Example from https://www.youtube.com/watch?v=KOI1WbkKUpQ
		// Lasic B.  Java swing GUI tutorial #28: JList, ListSelectionListener and DefaultListModel
		model = new DefaultListModel<>();
        // Initialise Jlist and Jscrollpane
	    //final JList<Products> list = new JList(model); 
		list = new JList<Products>(model); 
	    // Only one item can be selected at a time from the Jlist
	    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	 // Add a valuechanged listener for the Jlist - disable or enable the delete button
	    list.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if (list.getModel().getSize() == 0) {
	    			btndelete.setEnabled(false);
	    		}
	    		else {
	    			btndelete.setEnabled(true);
	    		}
	    	}
	    });
	    list.setBounds(549, 10, 225, 519);
	    list.setModel(model);
	    // Add a selection listener for the Jlist - selected items will populate Jtextfields/Combo box/
	    list.getSelectionModel().addListSelectionListener(e -> {
	    	p = list.getSelectedValue();
	    	txtfieldprodid.setText(p.getproductid());
	    	txtfieldname.setText(p.getname());
	    	txtfieldquantity.setText(Integer.toString(p.getquantity()));
	    	combotype.setSelectedItem(p.gettype());
	    	if (p.getnextday() .equals("yes")) {
	    	chboxnextday.setSelected(true);
	    	}
	    	else {
	    		chboxnextday.setSelected(false);
	    	}
	    });
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(list);
		scrollPane.setBounds(578, 10, 178, 467);
		contentPane.add(scrollPane);
		
		// Product ID label
		JLabel lblprodid = new JLabel("ProductID");
		lblprodid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblprodid.setBounds(10, 56, 72, 14);
		contentPane.add(lblprodid);

        // Name field label	
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblname.setBounds(10, 91, 46, 14);
		contentPane.add(lblname);

		// Item field label	
		JLabel lbltype = new JLabel("Item Type");
		lbltype.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltype.setBounds(10, 127, 60, 14);
		contentPane.add(lbltype);
		
        // quantity field label
		JLabel lblquantity = new JLabel("Quantity");
		lblquantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblquantity.setBounds(10, 165, 53, 14);
		contentPane.add(lblquantity);
		
        // checkbox for delivery 
		chboxnextday = new JCheckBox("Available for Next Day Delivery");
		chboxnextday.setFont(new Font("Tahoma", Font.BOLD, 11));
		chboxnextday.setBounds(10, 203, 248, 23);
		contentPane.add(chboxnextday);
		
        // textfield for product id 
		txtfieldprodid = new JTextField();
		txtfieldprodid.setBounds(80, 53, 257, 20);
		String stringuuid = uuid.toString();
		txtfieldprodid.setText(stringuuid);
		contentPane.add(txtfieldprodid);
		txtfieldprodid.setColumns(10);
		
        // textfield for name 
		txtfieldname = new JTextField();
		txtfieldname.setBounds(80, 88, 144, 20);
		contentPane.add(txtfieldname);
		txtfieldname.setColumns(10);

        // textfield for quantity 		
		txtfieldquantity = new JTextField();
		txtfieldquantity.setBounds(80, 162, 86, 20);
		contentPane.add(txtfieldquantity);
		txtfieldquantity.setColumns(10);
		
		// Initialise Combo box and hard code entries
        combotype = new JComboBox<String>();
		combotype.setBounds(80, 123, 126, 22);
		combotype.addItem("Select Type");
		combotype.addItem("Homeware");
		combotype.addItem("Hobby");
		combotype.addItem("Garden");
		contentPane.add(combotype);
		
                // New item button
		JButton btnnewitem = new JButton("New Item");
		btnnewitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uuid = UUID.randomUUID();
				txtfieldprodid.setText(uuid.toString());
		    	txtfieldname.setText("");
		    	txtfieldquantity.setText(Integer.toString(0));
		    	combotype.setSelectedItem("Select Type");
		    	chboxnextday.setSelected(false);
			}
		});
		btnnewitem.setBounds(117, 488, 89, 23);
		contentPane.add(btnnewitem);

                // Save button		
		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get state of checkbox as yes or no
				String chkbox;
				if (chboxnextday.isSelected()) {
					chkbox = "yes";
				}
					else {
						chkbox = "no";
					}
				// Add new product to the Jlist
				model.addElement(new Products(txtfieldprodid.getText(),(String) combotype.getSelectedItem(),Integer.parseInt(txtfieldquantity.getText()),txtfieldname.getText(),"yes"));
				JOptionPane.showMessageDialog(null,"Item has been saved.","Save",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnsave.setBounds(229, 488, 89, 23);
		contentPane.add(btnsave);

                // Delete button		
		btndelete = new JButton("Delete Selected");
		// Add an action listener to call DeleteItem method
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteItem();
			}
		});
		btndelete.setBounds(602, 488, 126, 23);
		btndelete.setEnabled(false);
		contentPane.add(btndelete);
		
		// Initiailse MenuBar
        JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// Initialise Action menu
		JMenu mnNewMenu = new JMenu("Actions");
		menuBar.add(mnNewMenu);
		// About menu
                JMenuItem menuabout = new JMenuItem("About");
		menuabout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Assignment 2 App v1.00","About",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(menuabout);
		JMenuItem menuimport = new JMenuItem("Import Data");
		mnNewMenu.add(menuimport);
		JMenuItem menuinventory = new JMenuItem("Inventory");
		mnNewMenu.add(menuinventory);
		JMenuItem menuexport = new JMenuItem("Export to CSV");
		mnNewMenu.add(menuexport);
	}
	public void DeleteItem() {
		int input = JOptionPane.showConfirmDialog(null, "Are you sure?");
		// check answer and exit if not yes
		if (input != 0) {
			return;
		}
		int selectedIndex = list.getSelectedIndex();
		System.out.println("INDEX is " + selectedIndex);
		//if (selectedIndex != -1) {
			//		model.remove(selectedIndex);
		 //model.remove(selectedIndex); //doesnt work
		 model.removeElementAt(selectedIndex);
	     list.revalidate(); //doesnt work
	     list.repaint(); // doesnt work
		//}
	}
}
