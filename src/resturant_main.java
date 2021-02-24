import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;
import javax.swing.text.NavigationFilter;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class resturant_main extends JFrame{

	static JFrame frame = new JFrame();
	static JPanel panel1 = new JPanel();
	static JPanel panel2 = new JPanel();
	static JPanel panel3 = new JPanel();
	static JPanel panel4 = new JPanel();
	static JPanel panel5 = new JPanel();
	//static JPanel panel6 = new JPanel();
	static Vector<String> nationality =new Vector<String>();
	static Vector<String> foodtype =new Vector<String>();
	static Vector<String> menutype =new Vector<String>();
	static Vector<String> waiterslist = new Vector<String>();
	static Vector<String> customerslist = new Vector<String>();
	static restaurant Restaurant;
	static String str;
	static int price;
	public static void main(String[] args) 
	{
		/*Restaurant=new restaurant("amin", 500);
		Restaurant.CustomerEntry("English", "veg", "ch", 1000, 2);
		Restaurant.WaiterEntry(4, "English");
		System.out.println(Restaurant.getWaiters().get(0).getNationality());
		System.out.println(Restaurant.getCustomers()[0].getNationality());*/
		///////////////////////////////////
		nationality.add("China");
		nationality.add("Italian");
		nationality.add("French");
		nationality.add("Indian");
		nationality.add("Iranian");
		nationality.add("English");
		nationality.add("Other");
		///////////////////////////////////
		foodtype.add("Vegetarian");
		foodtype.add("non-Vegetarian");
		///////////////////////////////////
		menutype.add("China");
		menutype.add("Italian");
		menutype.add("French");
		menutype.add("Indian");
		menutype.add("Iranian");
		menutype.add("English");
		////////////restaurant////////////
		JLabel restaurantlabel = new JLabel("Restaurant");
		restaurantlabel.setBounds(80, 0, 100, 30);
		restaurantlabel.setFont(new Font("Dialog",Font.BOLD+Font.ITALIC, 18));
		
		JLabel restaurantnamelabel = new JLabel("Name");
		restaurantnamelabel.setBounds(10, 50, 60, 30);
		
		JLabel restaurantcapacitylabel = new JLabel("Capacity");
		restaurantcapacitylabel.setBounds(10, 90, 60, 30);
		
		final JTextField restaurantnametextfeild = new JTextField();
		restaurantnametextfeild.setBounds(75, 50, 105, 30);
		
		final JTextField restaurantcapacitytextfeild = new JTextField();
		restaurantcapacitytextfeild.setBounds(75, 90, 105, 30);
		
		JLabel restaurantfundlabel = new JLabel("Fund");
		restaurantfundlabel.setBounds(10, 130, 60, 30);
		
		final JTextField restauranttextfeild = new JTextField();
		restauranttextfeild.setBounds(75, 130, 105, 30);
		restauranttextfeild.setEditable(false);
		restauranttextfeild.setFont(new Font("Dialog",Font.BOLD, 15));
		
		final JButton restaurantcreatbutton = new JButton("Creat");
		restaurantcreatbutton.setBounds(195, 130, 70, 30);
		//restaurantcreatbutton.setFont(new Font("Dialog",Font.CENTER_BASELINE,14));
		//////////////////////////////////
		////////////waiter////////////
		JLabel waiterlabel = new JLabel("Waiter");
		waiterlabel.setBounds(100, 170, 100, 30);
		waiterlabel.setFont(new Font("Dialog",Font.BOLD+Font.ITALIC, 18));
		
		JLabel waiteridlabel = new JLabel("ID");
		waiteridlabel.setBounds(10, 210, 60, 30);
		
		JLabel waiternationalitylabel = new JLabel("Nationality");
		waiternationalitylabel.setBounds(10, 250, 60, 30);
		
		final JTextField waiteridtextfeild = new JTextField();
		waiteridtextfeild.setBounds(75, 210, 105, 30);
		
		final JComboBox<String> waiternationalitycombobox = new JComboBox<>(nationality);
		waiternationalitycombobox.setBounds(75, 250, 105, 30);
		
		JButton waiteraddbutton = new JButton("Add");
		waiteraddbutton.setBounds(195, 250, 70, 30);
		//////////////////////////////////
		////////////customer//////////////
		JLabel customerlabel = new JLabel("Customer");
		customerlabel.setBounds(100, 0, 100, 30);
		customerlabel.setFont(new Font("Dialog",Font.BOLD+Font.ITALIC, 18));
		
		JLabel customernationalitylabel = new JLabel("Nationality");
		customernationalitylabel.setBounds(10, 60, 60, 30);
		
		JLabel customerfoodTypelabel = new JLabel("FoodType");
		customerfoodTypelabel.setBounds(10, 100, 60, 30);
		
		JLabel customermenuTypelabel = new JLabel("MenuType");
		customermenuTypelabel.setBounds(10, 140, 60, 30);
		
		JLabel customermoneylabel = new JLabel("Money");
		customermoneylabel.setBounds(10, 180, 60, 30);
		
		JLabel customervotelabel = new JLabel("Vote(1-10)");
		customervotelabel.setBounds(10, 220, 60, 30);
		
		final JComboBox<String> customernationalitycombobox = new JComboBox<>(nationality);
		customernationalitycombobox.setBounds(80, 60, 150, 30);
		
		final JComboBox<String> customerfoodTypecombobox = new JComboBox<>(foodtype);
		customerfoodTypecombobox.setBounds(80, 100, 150, 30);
		
		final JComboBox<String> customermenuTypecombobox = new JComboBox<>(menutype);
		customermenuTypecombobox.setBounds(80, 140, 150, 30);
		
		final JTextField customermoneytextfeild = new JTextField();
		customermoneytextfeild.setBounds(80, 180, 150, 30);
		
		final JTextField customervotetextfeild = new JTextField();
		customervotetextfeild.setBounds(80, 220, 150, 30);
		
		JButton customeraddbutton = new JButton("Add");
		customeraddbutton.setBounds(250, 230, 70, 50);
		//////////////////////////////////
		///////////Waiters List///////////
		JLabel waiterlistlabel = new JLabel("Waiters List:");
		waiterlistlabel.setBounds(10, 0, 150, 30);
		waiterlistlabel.setFont(new Font("Dialog",Font.BOLD+Font.ITALIC, 18));
		
		final JList<String> waiterslistscrollpane = new JList<String>();
		waiterslistscrollpane.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane waitersscrollpane = new JScrollPane(waiterslistscrollpane);
		waitersscrollpane.setBounds(10, 30, 150, 150);
		/////////Customers List//////////
		JLabel customerlistlabel = new JLabel("Customers List:");
		customerlistlabel.setBounds(200, 0, 150, 30);
		customerlistlabel.setFont(new Font("Dialog",Font.BOLD+Font.ITALIC, 18));
		
		final JList<String> customerslistscrollpane = new JList<String>();
		customerslistscrollpane.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane customersscrollpane = new JScrollPane(customerslistscrollpane);
		customersscrollpane.setBounds(200, 30, 350, 250);
		
		
		/*JButton customerselectbutton = new JButton("Select");
		customerselectbutton.setBounds(460, 150, 80, 30);*/
		//////////////////////////////////
		///////////////Menu///////////////
		JLabel menulistlabel = new JLabel("Menu :");
		menulistlabel.setBounds(10, 0, 150, 30);
		menulistlabel.setFont(new Font("Dialog",Font.BOLD+Font.ITALIC, 18));
		
		final JList<String> menulistscrollpane = new JList<String>();
		menulistscrollpane.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane menuscrollpane = new JScrollPane(menulistscrollpane);
		menuscrollpane.setBounds(10, 30, 270, 250);
		//////////////////////////////////
		JLabel pricelabel = new JLabel("Price ");
		pricelabel.setBounds(10, 210, 80, 30);
		
		final JTextField pricetextfeild = new JTextField();
		pricetextfeild.setBounds(50, 210, 90, 30);
		
		JButton eatbutton = new JButton("Eat");
		eatbutton.setBounds(50, 250, 90, 30);
		//////////////////////////////////
		//////////////////////////////////
		JLabel salarywaiterlabel = new JLabel("Salary Waiter $");
		salarywaiterlabel.setBounds(10, 10, 150, 30);
		
		final JTextField salarywaitertextfeild = new JTextField();
		salarywaitertextfeild.setBounds(110, 10, 150, 30);
		
		JButton salarywaiterbutton = new JButton("Salary Waiter");
		salarywaiterbutton.setBounds(110, 50, 150, 50);
		//////////////////////////////////
		//////////////////////////////////
		
		JButton payoffbutton = new JButton("Pay off");
		payoffbutton.setBounds(80, 170, 150, 70);
		payoffbutton.setFont(new Font("Dialog",Font.BOLD+Font.ITALIC, 18));
		//////////////////////////////////
		//////////////panel1//////////////
		panel1.setBackground(Color.BLUE);
		panel1.setBounds(0, 0, 270, 300);
		panel1.setLayout(null);
		panel1.add(restaurantlabel);
		panel1.add(restaurantnamelabel);
		panel1.add(restaurantcapacitylabel);
		panel1.add(restaurantfundlabel);
		panel1.add(restaurantnametextfeild);
		panel1.add(restaurantcapacitytextfeild);
		panel1.add(restaurantcreatbutton);
		panel1.add(restauranttextfeild);
		panel1.add(waiterlabel);
		panel1.add(waiteridlabel);
		panel1.add(waiternationalitylabel);
		panel1.add(waiteridtextfeild);
		panel1.add(waiternationalitycombobox);
		panel1.add(waiteraddbutton);
		//////////////panel2//////////////
		panel2.setBackground(Color.orange);
		panel2.setBounds(270, 0, 330, 300);
		panel2.setLayout(null);
		panel2.add(customerlabel);
		panel2.add(customernationalitylabel);
		panel2.add(customerfoodTypelabel);
		panel2.add(customermenuTypelabel);
		panel2.add(customermoneylabel);
		panel2.add(customervotelabel);
		panel2.add(customernationalitycombobox);
		panel2.add(customerfoodTypecombobox);
		panel2.add(customermenuTypecombobox);
		panel2.add(customermoneytextfeild);
		panel2.add(customervotetextfeild);
		panel2.add(customeraddbutton);
		//////////////panel3//////////////
		panel3.setBackground(Color.red);
		panel3.setBounds(600, 0, 300, 300);
		panel3.setLayout(null);
		panel3.add(menulistlabel);
		panel3.add(menuscrollpane);
		panel3.add(menulistlabel);
		panel3.add(menuscrollpane);
		//////////////panel4//////////////
		panel4.setBackground(Color.green);
		panel4.setBounds(0, 300, 600, 300);
		panel4.setLayout(null);
		panel4.add(waiterlistlabel);
		panel4.add(waitersscrollpane);
		panel4.add(customerlistlabel);
		panel4.add(customersscrollpane);
		//panel4.add(customerselectbutton);
		panel4.add(eatbutton);
		panel4.add(pricelabel);
		panel4.add(pricetextfeild);
		//////////////panel5//////////////
		panel5.setBackground(Color.PINK);
		panel5.setBounds(600, 300, 300, 300);
		panel5.setLayout(null);
		panel5.add(salarywaiterbutton);
		panel5.add(salarywaitertextfeild);
		panel5.add(salarywaiterlabel);
		panel5.add(payoffbutton);
		//////////////panel6//////////////
/*		panel6.setBackground(Color.orange);
		panel6.setBounds(600, 300, 300, 300);
		panel6.setLayout(null);*/
		//////////////////////////////////
		
		
		
		//////////////frame///////////////
		frame.setTitle("Restaurant");
		frame.setBounds(250, 30, 916, 639);
		frame.setLayout(null);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		frame.add(panel5);
		//frame.add(panel6);
		frame.setVisible(true);
		//////////////////////////////////
		////////////////////////////////////////Restaurant/////////////////////////////////////////////////
		restaurantcreatbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Restaurant = new restaurant(restaurantnametextfeild.getText(), 
							   Integer.parseInt(restaurantcapacitytextfeild.getText()));
					restauranttextfeild.setText(""+Restaurant.getFund());
					JOptionPane.showMessageDialog(null,"Restaurant created", "Wellcome",JOptionPane.INFORMATION_MESSAGE);
					restaurantcreatbutton.setEnabled(false);
					restaurantcapacitytextfeild.setEnabled(false);
					restaurantnametextfeild.setEnabled(false);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Please enter correct input", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////Waiters/////////////////////////////////////////////////////
		waiteraddbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					if(Integer.parseInt(waiteridtextfeild.getText())>0)
					{
						if(!searchid(Restaurant.getWaiters(), Integer.parseInt(waiteridtextfeild.getText())))
								{
									Restaurant.WaiterEntry(Integer.parseInt(waiteridtextfeild.getText()), 
											               waiternationalitycombobox.getSelectedItem().toString());
									waiterslist.add("ID:"+waiteridtextfeild.getText()+
													"  Nationality:"+waiternationalitycombobox.getSelectedItem().toString());
									//JOptionPane.showMessageDialog(null, "Waiter Added", "ADD",JOptionPane.INFORMATION_MESSAGE);
									waiterslistscrollpane.setListData(waiterslist);
								}
						else
						{
							JOptionPane.showMessageDialog(null,"This ID exist", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter correct input", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e)
				{
					if(Restaurant==null)
					{
						JOptionPane.showMessageDialog(null,"Restaurant not created", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter correct input", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////Customers////////////////////////////////////////////////
		customeraddbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					if(Integer.parseInt(customermoneytextfeild.getText())>0 
					&& 1<=Integer.parseInt(customervotetextfeild.getText())
					&& Integer.parseInt(customervotetextfeild.getText())<=10)
					{
						Restaurant.getWaiters().get(waiterslistscrollpane.getSelectedIndex()).setSalary(3);
						Restaurant.CustomerEntry(customernationalitycombobox.getSelectedItem().toString()
											   , customerfoodTypecombobox.getSelectedItem().toString()
											   , customermenuTypecombobox.getSelectedItem().toString()
											   , Integer.parseInt(customermoneytextfeild.getText())
											   , Integer.parseInt(customervotetextfeild.getText()));
						customerslist.add("Nationality: "+customernationalitycombobox.getSelectedItem().toString()
								        + "  FoodType: "+customerfoodTypecombobox.getSelectedItem().toString()
								        + "  MenuType: "+customermenuTypecombobox.getSelectedItem().toString()
								        + "  Money: "+customermoneytextfeild.getText()
								        + "  Vote: "+customervotetextfeild.getText());
						
						customerslistscrollpane.setListData(customerslist);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter correct input", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
				
				}
				catch(Exception e)
				{
					if(Restaurant==null)
					{
						JOptionPane.showMessageDialog(null,"Restaurant not created", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter correct input", "ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		customerslistscrollpane.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				try
				{
				menulistscrollpane.setListData(menu(customerslistscrollpane.getSelectedIndex()));
				}
				catch (Exception e)
				{
				}
			}
		});

/*		customerselectbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					menulistscrollpane.setListData(menu(customerslistscrollpane.getSelectedIndex()));
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null,"ERROR", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});*/
		///////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////eat////////////////////////////////////////////////////
		eatbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					int i=Integer.parseInt(menulistscrollpane.getSelectedValue().substring(0, menulistscrollpane.getSelectedValue().indexOf(")")))-1;
					if(!Restaurant.getFoods()[i].isFinished())
					{
						//pricetextfeild.setText(""+Restaurant.getFoods()[i].getCost());
						if((Restaurant.getFoods()[i].getCost()
						   +Restaurant.getCustomers()[customerslistscrollpane.getSelectedIndex()].getCost())
						  <=Restaurant.getCustomers()[customerslistscrollpane.getSelectedIndex()].getMoney())
						{
							if(Restaurant.getWaiters().get(waiterslistscrollpane.getSelectedIndex()).getCounter()==9)
							{
								Restaurant.getWaiters().get(waiterslistscrollpane.getSelectedIndex()).setSalary(10);
								Restaurant.getWaiters().get(waiterslistscrollpane.getSelectedIndex()).setCounter(0);
								Restaurant.setFund(-10);
								restauranttextfeild.setText(""+Restaurant.getFund());
							}
							else
							{
								Restaurant.getWaiters().get(waiterslistscrollpane.getSelectedIndex()).setSalary(0);
							}
							
							Restaurant.getCustomers()[customerslistscrollpane.getSelectedIndex()].Cost(Restaurant.getFoods()[i].getCost());
							Restaurant.getFoods()[i].setNumber(1);
							pricetextfeild.setText(""+Restaurant.getCustomers()[customerslistscrollpane.getSelectedIndex()].getCost());		
							menulistscrollpane.setListData(menu(customerslistscrollpane.getSelectedIndex()));
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Your money is low", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null,"ERROR", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////SalaryWAiter/////////////////////////////////////////////////
		salarywaiterbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				salarywaitertextfeild.setText(""+Restaurant.getWaiters().get(waiterslistscrollpane.getSelectedIndex()).getSalary());
				
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////pay off///////////////////////////////////////////////////
		payoffbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try{
					Restaurant.settlement(Restaurant.getCustomers()[customerslistscrollpane.getSelectedIndex()]);
					restauranttextfeild.setText(""+Restaurant.getFund());
					customerslist.remove(customerslistscrollpane.getSelectedIndex());
					customerslist.add(customerslistscrollpane.getSelectedIndex(),"Nationality: "+Restaurant.getCustomers()[customerslistscrollpane.getSelectedIndex()].getNationality()
					        + "  FoodType: "+Restaurant.getCustomers()[customerslistscrollpane.getSelectedIndex()].getFoodType()
					        + "  MenuType: "+Restaurant.getCustomers()[customerslistscrollpane.getSelectedIndex()].getMenuType()
					        + "  Money: "+Restaurant.getCustomers()[customerslistscrollpane.getSelectedIndex()].getMoney()
					        + "  Vote: "+Restaurant.getCustomers()[customerslistscrollpane.getSelectedIndex()].getVote());
			
					customerslistscrollpane.setListData(customerslist);
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null,"ERROR", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////////////

	}
	public static String[] menu(int index)
	{
		String[] foods = new String[20];
		for(int i=0;i<=(Restaurant.getCustomers()[index].getMenu().getMenuFoods().length)-1;i++)
		{
					foods[i]=Restaurant.getCustomers()[index].getMenu().getMenuFoods()[i].getId()+1+") "
						    +Restaurant.getCustomers()[index].getMenu().getMenuFoods()[i].getNationality() 
		+"       FoodType :"+Restaurant.getCustomers()[index].getMenu().getMenuFoods()[i].getFoodType()
		+"       Quality :"+Restaurant.getCustomers()[index].getMenu().getMenuFoods()[i].getQuality()
		+"       IQuality :"+Restaurant.getCustomers()[index].getMenu().getMenuFoods()[i].getInternationalQuality()
		+"       Number :"+Restaurant.getCustomers()[index].getMenu().getMenuFoods()[i].getNumber()
		+"         COst :"+Restaurant.getCustomers()[index].getMenu().getMenuFoods()[i].getCost();					
					
		}
			
		return foods;
	}
	public static boolean searchid(ArrayList<Waiter> waiters,int id)
	{
		boolean flag=false;
		for (Waiter waiter : waiters) 
		{
			if(waiter.getId()==id)
			{
				flag=true;
				break;
			}
		}
		
		return flag;
	}


}
