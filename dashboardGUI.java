import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import items.*;
import containers.*;
import methods.Calculation;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane; // import the ArrayList class



public class dashboardGUI {
	
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */

	
	//global values
	Calculation myAccount = new Calculation();
	int counter = 0;
	String totalVolumen;
	String totalPrice;
	String totalWeight;
	String bestShippingContent;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					dashboardGUI window = new dashboardGUI();
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
	public dashboardGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 917, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final TextField InputQuantity = new TextField();
		InputQuantity.setFont(new Font("Dialog", Font.PLAIN, 30));
		InputQuantity.setBounds(174, 25, 152, 42);
		frame.getContentPane().add(InputQuantity);
		
		final TextField InputLength = new TextField();
		InputLength.setFont(new Font("Dialog", Font.PLAIN, 30));
		InputLength.setBounds(174, 100, 152, 42);
		frame.getContentPane().add(InputLength);
		
		final TextField InputWidth = new TextField();
		InputWidth.setFont(new Font("Dialog", Font.PLAIN, 30));
		InputWidth.setBounds(174, 175, 152, 42);
		frame.getContentPane().add(InputWidth);
		
		final TextField InputHeight = new TextField();
		InputHeight.setFont(new Font("Dialog", Font.PLAIN, 30));
		InputHeight.setBounds(174, 250, 152, 42);
		frame.getContentPane().add(InputHeight);
		
		Label labelQuantity = new Label("Quantity (n)");
		labelQuantity.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		labelQuantity.setBounds(48, 25, 120, 40);
		frame.getContentPane().add(labelQuantity);
		
		Label labelLength = new Label("Length (cm)");
		labelLength.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		labelLength.setBounds(52, 100, 116, 42);
		frame.getContentPane().add(labelLength);
		
		Label labelWidth = new Label("Width (cm)");
		labelWidth.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		labelWidth.setBounds(48, 177, 116, 40);
		frame.getContentPane().add(labelWidth);
		
		Label labelHeight = new Label("Height (cm)");
		labelHeight.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		labelHeight.setBounds(48, 250, 116, 42);
		frame.getContentPane().add(labelHeight);
		
		final TextField InputWeight = new TextField();
		InputWeight.setFont(new Font("Dialog", Font.PLAIN, 30));
		InputWeight.setBounds(174, 325, 152, 42);
		frame.getContentPane().add(InputWeight);
		
		Label labelWeight = new Label("Weight (g)");
		labelWeight.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		labelWeight.setBounds(48, 325, 116, 42);
		frame.getContentPane().add(labelWeight);
		
		final JList optionList = new JList();
		optionList.setFont(new Font("Tahoma", Font.ITALIC, 14));
		optionList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Laptop", "Mouse", "Desktop", "LCD Screens"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		optionList.setSelectedIndex(0);
		optionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		optionList.setBounds(48, 423, 278, 83);
		frame.getContentPane().add(optionList);
		
		Label labelWeight_1 = new Label("Select an Option");
		labelWeight_1.setFont(new Font("Footlight MT Light", Font.BOLD, 10));
		labelWeight_1.setBounds(48, 381, 116, 42);
		frame.getContentPane().add(labelWeight_1);
		
		JLabel lblNewLabel = new JLabel("Order Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(569, 100, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		
		//order report
		
		JLabel orderReportLabel = new JLabel("Order Report");
		orderReportLabel.setBackground(Color.WHITE);
		orderReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderReportLabel.setForeground(Color.DARK_GRAY);
		orderReportLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		orderReportLabel.setBounds(473, 25, 336, 58);
		frame.getContentPane().add(orderReportLabel);
		
		JLabel totalweightLabel = new JLabel("Total Weight (kg): ");
		totalweightLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalweightLabel.setBounds(473, 197, 141, 20);
		frame.getContentPane().add(totalweightLabel);
		
		JLabel totalVolumenLabel = new JLabel("Total Volume (m3): ");
		totalVolumenLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalVolumenLabel.setBounds(473, 155, 152, 20);
		frame.getContentPane().add(totalVolumenLabel);
		
		JLabel totalPricelabel = new JLabel("Total Price (€): ");
		totalPricelabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalPricelabel.setBounds(569, 551, 120, 20);
		frame.getContentPane().add(totalPricelabel);
		
		final JLabel totalVolumenValue = new JLabel("Total Volume");
		totalVolumenValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalVolumenValue.setBounds(679, 155, 130, 20);
		totalVolumenValue.setVisible(false);
		frame.getContentPane().add(totalVolumenValue);
		
		final JLabel totalWeightValue = new JLabel("Total Weight");
		totalWeightValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalWeightValue.setBounds(679, 197, 130, 20);
		totalWeightValue.setVisible(false);
		frame.getContentPane().add(totalWeightValue);
		
		JLabel bestshippingLabel = new JLabel("Best Shipping Method");
		bestshippingLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bestshippingLabel.setBounds(475, 238, 174, 20);
		frame.getContentPane().add(bestshippingLabel);
		
		final Label valuePrice = new Label("finalprice");
		valuePrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		valuePrice.setBounds(712, 551, 97, 20);
		valuePrice.setVisible(false);
		frame.getContentPane().add(valuePrice);
		
		final JLabel productsNumber = new JLabel("Cantidad de Grupo de  Products");
		productsNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productsNumber.setBounds(473, 100, 336, 42);
		productsNumber.setVisible(false);
		frame.getContentPane().add(productsNumber);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(472, 291, 337, 215);
		frame.getContentPane().add(scrollPane);
		scrollPane.setVisible(false);
		
		final JTextArea textAreaShipping = new JTextArea();
		textAreaShipping.setEditable(false);
		scrollPane.setViewportView(textAreaShipping);
		textAreaShipping.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaShipping.setText("bestShipping");
		textAreaShipping.setVisible(false);
		
		///buttons
		
		
		
		//btn add product
		
		final JButton btnAddProducts = new JButton("Add");
		btnAddProducts.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAddProducts.setBackground(Color.RED);
				btnAddProducts.setForeground(Color.WHITE);
				
			}
			public void mouseExited(MouseEvent e) {
				btnAddProducts.setBackground(Color.WHITE);
				btnAddProducts.setForeground(Color.RED);
			}
		});
		btnAddProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int qttNumber;
				double lenghtNumber, widthNumber, heightNumber, weightNumber;
				Object itemName;
				int option = 0;

				try {
					qttNumber = Integer.parseInt(InputQuantity.getText());
					lenghtNumber = Double.parseDouble(InputLength.getText());
					widthNumber = Double.parseDouble(InputWidth.getText());
					heightNumber = Double.parseDouble(InputHeight.getText());
					weightNumber = Double.parseDouble(InputWeight.getText());
					itemName = optionList.getSelectedValue().toString();
					
					if (itemName == "Laptop") option = 1;
					if (itemName == "Mouse") option = 2;
					if (itemName == "Desktop") option = 3;
					if (itemName == "LCD Screens") option = 4;
					
				switch(option) {
			    case 1:
			    	myAccount.addItems(lenghtNumber, widthNumber, heightNumber, weightNumber, "Laptop", qttNumber, option);
			    	counter+=1;
			      break;
			    case 2:
			    	myAccount.addItems(lenghtNumber, widthNumber, heightNumber, weightNumber, "Mouse", qttNumber, option);
			    	counter+=1;
			      break;
			    case 3:
			    	myAccount.addItems(lenghtNumber, widthNumber, heightNumber, weightNumber, "Desktop", qttNumber, option);
			    	counter+=1;
			    	break;
			    case 4:
			    	myAccount.addItems(lenghtNumber, widthNumber, heightNumber, weightNumber,"LCD Screens", qttNumber, option);
			    	counter+=1;
			    	break;
			    default:
			      System.out.println("Wrong option, please choose a number between 1 to 4");
			  }
				JOptionPane.showMessageDialog(null, "Product added sucessfully");
				
				// adding text marker of number of products 
				productsNumber.setVisible(true);
				
				productsNumber.setText(String.format("No. Groups of Products + %d", counter));
				
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Just number are allowed");
					//JOptionPane.showMessageDialog(null, e1);	
				}
				
		    	InputQuantity.setText("");
		    	InputLength.setText("");
		    	InputWidth.setText("");
		    	InputHeight.setText("");
		    	InputWeight.setText("");
				
				
				
			}
		});
		btnAddProducts.setToolTipText("add products");
		btnAddProducts.setForeground(Color.DARK_GRAY);
		btnAddProducts.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddProducts.setBackground(new Color(255, 255, 255));
		btnAddProducts.setBounds(48, 526, 116, 58);
		frame.getContentPane().add(btnAddProducts);
		
		//btn estimate
		final JButton btnEstimate = new JButton("Estimate");
		btnEstimate.setToolTipText("");
		btnEstimate.setForeground(Color.WHITE);
		btnEstimate.setBackground(Color.RED);
		btnEstimate.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
		btnEstimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					totalVolumen = Double.toString(myAccount.totalVolume()/1000000);
					totalVolumenValue.setVisible(true);
					totalVolumenValue.setText(totalVolumen);
					
					totalWeight = Double.toString(myAccount.totalWeight()/1000);
					totalWeightValue.setVisible(true);
					totalWeightValue.setText(totalWeight);
					
					myAccount.bestShipping();
					totalPrice = Double.toString(myAccount.shippingPrice());
					valuePrice.setVisible(true);
					valuePrice.setText(totalPrice);
					
					
					ArrayList <Object> myShippingList = new ArrayList <>();
					myShippingList = myAccount.getContainerList();
					bestShippingContent = "";
					for(Object i: myShippingList){
						bestShippingContent = bestShippingContent + String.format("1x - %s \n", ((Container) i).getContainerName() );            
					}
					scrollPane.setVisible(true);
					textAreaShipping.setVisible(true);
					textAreaShipping.setText(bestShippingContent);
					
					btnEstimate.setEnabled(false);
					//btnClean.setVisible(true);
					btnAddProducts.setEnabled(false);
					
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "There is nothing to calculate");
					
					
				}
				
				
			}
		});
		btnEstimate.setBounds(174, 526, 152, 58);
		frame.getContentPane().add(btnEstimate);
		
		//btn clean 
		
		final JButton btnClean = new JButton("Clean");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnEstimate.setEnabled(true);
				//productsNumber.setVisible(false);
				counter = 0;
				totalVolumenValue.setVisible(false);
				totalWeightValue.setVisible(false);		
				valuePrice.setVisible(false);
				textAreaShipping.setVisible(false);
				btnAddProducts.setEnabled(true);
				productsNumber.setText("");
				scrollPane.setVisible(false);
				
				((Calculation) myAccount).setContainerList(new ArrayList <>());
				((Calculation) myAccount).setClientItems(new ArrayList <>());
				((Calculation) myAccount).setTotalPrice(0);
				bestShippingContent = "";
				
			}
		});
		btnClean.setToolTipText("add products");
		btnClean.setForeground(new Color(255, 255, 255));
		btnClean.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClean.setBackground(new Color(64, 0, 0));
		btnClean.setBounds(339, 526, 116, 58);
		btnClean.setVisible(true);
		frame.getContentPane().add(btnClean);
		
		
		
		
	}
}
