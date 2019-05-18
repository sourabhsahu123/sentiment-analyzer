/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentianalysis;
import au.com.bytecode.opencsv.CSVReader;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;    // importing event package for event listener
import java.io.FileReader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
class RegForm{
    static  JFreeChart barChart;
   static JProgressBar jp1 ,jp2;
   static JLabel label1,label2,label3,label4,label5,label6;
   static JTextArea jta1,jta2;
   
      static ChartPanel chartPanel6;
	//Creating Static variables
	static JTextField twittername1_txt ;
	static JTextField twittername2_txt;
	static JRadioButton male;
	static JRadioButton female;
	static JComboBox day;
	static JComboBox month;
	static JComboBox year;
	static JTextArea add_txtArea;
	static JTextField phone_txt;
	static JTextField email_txt;
	static JCheckBox chkbox;
	static JButton submit_btn;
	static JTextArea output_txtArea;
        static JPanel chartPanel;
	
	private static CategoryDataset createDataset(String n1,String n2, int pos1,int neg1,int neu1,int pos2,int neg2,int neu2) {
      final String text11 = n1;        
      final String text22 = n2;        
     final String positive = "Positive";        
      final String negative = "Negative";        
      final String neutral = "Neutral";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  
      

      dataset.addValue(pos1 , text11 , positive );        
      dataset.addValue( neg1, text11 , negative );        
      dataset.addValue( neu1 , text11 , neutral ); 
     
      dataset.addValue( pos2 , text22 , positive );        
      dataset.addValue( neg2 , text22 , negative );       
      dataset.addValue( neu2 , text22 , neutral );        
     
             

      return dataset; 
   }
   
	//public void turnOn()
        public static void main(String []arg)
	{
            
          
		/* ---------------------------------- Creating JFrame -------------------------------------------------------- */
					// Step 1 :  Creating a frame using JFrame class	
							JFrame frame=new JFrame("Twitter Sentiment Analysis");  
							frame.setVisible(true);	     
							frame.setBounds(200,100,500,500 );    
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                                                        
					// Step 2 : setting background color of Frame.		 
							Container c=frame.getContentPane();   
							c.setLayout(null);    
							c.setBackground(Color.yellow);     
		 
		 /*---------------------------------- Creating JLabel for Heading Text ------------------------------------------- */
		 
					Font f=new Font("Arial",Font.BOLD,20);   // Creating font style and size for heading
		
					// step 3 : creating JLabel for Heading
							JLabel heading_lbl=new JLabel();
							heading_lbl.setBounds(250,5,200,40);
							heading_lbl.setText("<html><font><u><b>Twitter Sentiment Analysis</b></u></html>");	
		
							// applying font on  heading Label
							heading_lbl.setFont(f);
		
                                                         JPanel tbdPanel1 = new JPanel( new FlowLayout() );
                                                         JPanel tbdPanel2 = new JPanel( new FlowLayout() );
                                                       
                                                         label1 = new JLabel("Positive");
                                                        label2 = new JLabel("Negative");
                                                        label3 = new JLabel("Neutral");
                                                        label4 = new JLabel("Positive");
                                                        label5 = new JLabel("Negative");
                                                        label6 = new JLabel("Neutral");
                                                         tbdPanel1.add(label1);
                                                         tbdPanel1.add(label2);
                                                         tbdPanel1.add(label3);
                                                          tbdPanel2.add(label4);
                                                         tbdPanel2.add(label5);
                                                         tbdPanel2.add(label6);
                                                         
		/* ----------------------------------- Creating Global Font style for all components ------------------------------ */

							Font f1=new Font("Arial",Font.BOLD,14);
		 
                                                        jta1 = new JTextArea("Tweets");
                                                        jta2=new JTextArea("Tweets");
		/* ----------------------------------- Creating components for Registration details ---------------------------------- */
					
					// Step 4 : Creating JLabel for Name
							JLabel name_lbl=new JLabel("Twitter Handle 1#  ");
							name_lbl.setBounds(50,80,200,30); 
	
							// Creating JTextField for Name
							twittername1_txt=new JTextField();
							twittername1_txt.setBounds(180,80,200,30);  
                                                        tbdPanel1.setBounds(280,80,400,30); 
                                                         tbdPanel2.setBounds(280,120,400,30); 
				    // Step 5 : Creating JLabel for Father's Name
							JLabel fname_lbl=new JLabel("Twitter Handle 2#  ");
							fname_lbl.setBounds(50,120,200,30);  
					
							// Creating JTextField for Father's name
							twittername2_txt=new JTextField();
							twittername2_txt.setBounds(180,120,200,30);
		 // Setting Cursor for components
							Cursor cur=new Cursor(Cursor.HAND_CURSOR);
                                                        jp1 = new JProgressBar();
                                                        jp1.setBounds(50,160,220,30); 
                                                        jp2=new JProgressBar();
							jp2.setBounds(50,250,220,30);
                                                        chartPanel = new JPanel();
                                                       
                                                        
					/*Step 6 : Creating JLabel for Gender
                                                        
                                                        
							JLabel gender_lbl=new JLabel("Gender : ");
							gender_lbl.setBounds(50,160,150,30);   
		
								
		
							// Creating JRadioButton for the Male		
							male=new JRadioButton("Male");
							male.setBounds(180,160,70,30);
							male.setBackground(Color.yellow);
							male.setCursor(cur);
		
							// Creating JRadioButton for the Female
							female=new JRadioButton("Female");
							female.setBounds(280,160,80,30);
							female.setBackground(Color.yellow);
							female.setCursor(cur);
		
							// Creating ButtonGroup for the JRadioButtons
							ButtonGroup gender_grp=new ButtonGroup();
							gender_grp.add(male);    // adding male radio button in the ButtonGroup
							gender_grp.add(female);    // adding female radio button in the ButtonGroup

					// Step 7 : Creating JLabel for Date of Birth
							JLabel dob_lbl=new JLabel("Date of Birth : ");
							dob_lbl.setBounds(50,200,100,30);	
					
							// Creating JComboBox for the day
							String day_arr[]=new String[31];
							for(int i=1;i<=31;i++)
							day_arr[i-1]=Integer.toString(i);		
							day=new JComboBox(day_arr);
							day.setBounds(180,200,40,30);
		
							// Creating JComboBox for the month
							String month_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" };	
							month=new JComboBox(month_arr);
							month.setBounds(230,200,60,30);
		
							// Creating JComboBox for the year	
							String year_arr[]=new String[70];
							for(int i=1951;i<=2020;i++)
							year_arr[i-1951]=Integer.toString(i);
							year=new JComboBox(year_arr);
							year.setBounds(300,200,60,30);
		
					// Step 8 : Creating JLabel for the Address
							JLabel add_lbl=new JLabel("Address : ");
							add_lbl.setBounds(50,240,100,30);				
		
							// Creating JTextArea for the address
							add_txtArea= new JTextArea();
							add_txtArea.setBounds(180,240,180,100);
		
					// Step 9 :  Creating JLabel for the phone
							JLabel phone_lbl=new JLabel("Phone No. : ");
							phone_lbl.setBounds(50,350,100,30);
		
							// Creating JTextField for the phone
							phone_txt=new JTextField();
							phone_txt.setBounds(180,350,180,30);
		
					// Step 10 : Creating JLabel for the Email
							JLabel email_lbl=new JLabel("Email : ");
							email_lbl.setBounds(50,390,100,30);
							
							// Creating JTextField for the Email
							email_txt=new JTextField();
							email_txt.setBounds(180,390,180,30);					
				
				    // Step 11 : Creating JCheckBox for the license agreement		
							chkbox=new JCheckBox("I accept the terms and conditions");
							chkbox.setBounds(50,430,300,30);
							chkbox.setBackground(Color.yellow);
		
					// Step 12 : Creating JButton for submit the details
*/
							submit_btn=new JButton("Analyze & Recommend");
							submit_btn.setBounds(180,200,300,40);
							submit_btn.setCursor(cur);  // Applying hand cursor on the button
							
					// Step 18 :  Adding ActionListener on submit button
							submit_btn.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent event){
									submit_action(event);									
								}			
							});
								
							
					// Step 17 : Creating JTextArea for output
							output_txtArea=new JTextArea();
							output_txtArea.setBounds(380,80,260,320);
		
					// Step 13 : Applying Global Font on all the JLabels	
							name_lbl.setFont(f1);
							fname_lbl.setFont(f1);
//							gender_lbl.setFont(f1);
//							dob_lbl.setFont(f1);
//							add_lbl.setFont(f1);
//							phone_lbl.setFont(f1);
//							email_lbl.setFont(f1);
				 
					// Step 14 : Applying Font on all JTextFields, JRadioButtons, JComboBox and JTextArea
							twittername1_txt.setFont(f1);
							twittername2_txt.setFont(f1);
							/*male.setFont(f1);
							female.setFont(f1);
							add_txtArea.setFont(f1);
							phone_txt.setFont(f1);
							email_txt.setFont(f1);
							chkbox.setFont(f1);
							submit_btn.setFont(f1);
							output_txtArea.setFont(f1);
					 */
					// Step 15 : Adding label components to the container 
							
                                        c.add(heading_lbl);	
							c.add(name_lbl);			
							c.add(fname_lbl);
//							c.add(gender_lbl);
//							c.add(male);
//							c.add(female);
//							c.add(dob_lbl);
//							c.add(add_lbl);
//							c.add(phone_lbl);
//							c.add(email_lbl);
		
					// Step 16 : Adding JTextField, JTextArea, JComboBox, JCheckBox, JRadioButton to the container
							c.add(twittername1_txt);
							c.add(twittername2_txt);
                                                        JPanel panel = new JPanel();
                                                        panel.setLayout(new BorderLayout());
                                                        
                                                        panel.setBorder(BorderFactory.createLineBorder(Color.CYAN,15));
                                                        chartPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN,10));
                                                       chartPanel.setBounds(700,50,500,500);
                                                       
                                                        JLabel ll = new JLabel("We Recommend");
                                                        panel.add(ll,BorderLayout.CENTER);
                                                       
                                                        panel.add(jp1,BorderLayout.NORTH);
                                                        panel.add(jp2,BorderLayout.SOUTH);
                                                        panel.setBounds(230,300,350,200);
                                                         jta1.setBounds(50,550,500,100);
                                                         jta2.setBounds(600,550,600,100);
                                                         c.add(jta1);
                                                         c.add(jta2);
                                                         
                                                        //c.add(jp1);
                                                       // c.add(jp2);
                                                       c.add(chartPanel);
                                                          c.add(panel);
                                                           c.add(tbdPanel1);
                                                           c.add(tbdPanel2);
                                                        jp1.setValue(0);
                                                        jp2.setValue(0);
                                                        jp1.setStringPainted(true);
                                                        jp2.setStringPainted(true);
                                                        jp1.setString("#1");
                                                        jp2.setString("#2");
//							c.add(fname_txt);
//							c.add(day);
//							c.add(month);
//							c.add(year);
//							c.add(add_txtArea);
//							c.add(phone_txt);
//							c.add(email_txt);
//							c.add(chkbox);
//							c.add(submit_btn);
//							c.add(output_txtArea);	
                                                        c.add(submit_btn);
                              frame.setBounds(200,100,500,500 ); 
                            
                              frame.pack();
                                frame.setSize(700, 700);
                              frame.setVisible(true);
							
		}
		
		// Step 19 : Reading value from the Registration Form
		public static void submit_action(ActionEvent event){
			//if(chkbox.isSelected()==true)
			//{
                        submit_btn.setText("Wait till analyses gets completed!!!!");
				String name=twittername1_txt.getText();
				String fname=twittername2_txt.getText();
                                SentiAnalysis sa = new SentiAnalysis();
                                String score1 =sa.getMyTwitterScore(name);
                             
                                String score2 =sa.getMyTwitterScore(fname);
                             
                                
                                String[] result1 = score1.split("-");
                                String[] result2 = score2.split("-");
                              label1.setText("  + "+result1[2]);
                              label1.setForeground(Color.GREEN);
                                label2.setForeground(Color.RED);
                                  label3.setForeground(Color.GRAY);
                                   label4.setForeground(Color.GREEN);
                                label5.setForeground(Color.RED);
                                  label6.setForeground(Color.GRAY);
                              label2.setText("  - "+result1[0]);
                                 label3.setText("  "+result1[1]);
                                    label4.setText("  + "+result2[2]);
                              label5.setText("  - "+result2[0]);
                                 label6.setText("  "+result2[1]);
                                 int scor1=Integer.parseInt(result1[2].trim())*1+(Integer.parseInt(result1[0].trim())*-1);
                                   int scor2=Integer.parseInt(result2[2].trim())*1+(Integer.parseInt(result2[0].trim())*-1);
                                JFreeChart barChart = ChartFactory.createBarChart(
         "Sentiment Analysis Chart",           
         "Sentiments",            
         "Score",            
         createDataset(name,fname,
                 Integer.parseInt(result1[2].trim()),
                 Integer.parseInt(result1[0].trim()),
                 Integer.parseInt(result1[1].trim()),
                 Integer.parseInt(result2[2].trim()),
                 Integer.parseInt(result2[0].trim()),
                 Integer.parseInt(result2[1].trim()))  ,        
                     PlotOrientation.VERTICAL,           
         true, true, false);     
                                  chartPanel6 = new ChartPanel(barChart);
                                    chartPanel.add(chartPanel6);
                              
                              
                                jp1.setValue(scor1);
                                jp2.setValue(scor2);
                                System.out.println(score1+"  "+score2);
                                jp1.setString(name+"("+scor1+")");
                                jp2.setString(fname+"("+scor2+")");
                                readDataLineByLine(jta1,name);
                                readDataLineByLine(jta2, fname);
                                
                        submit_btn.setText("Analyze & Recommend");
//				String gender="Male";
//				if(female.isSelected()==true)
//					gender="Female";
//				String day_name=(String)day.getSelectedItem();
//				String month_name=(String)month.getSelectedItem();
//				String year_name=(String)year.getSelectedItem();
//				String add=add_txtArea.getText();
//				String phone=phone_txt.getText();
//				String email=email_txt.getText();
//				
//				
//				// displaying value in the JTextArea
//				output_txtArea.setText(" Name :   " +name + "\n Father's Name :  " +fname + "\n Gender :   "+gender +
//                                        				"\n Date of Birth :   "+day_name + "  "+month_name + " " +year_name +  
//														"\n Address :  "+add + " \n Phone no :  "+phone + 
//														"\n Email :  "+email + "\n ");
				


			//}
			//else
			//{
			//	output_txtArea.setText("Please accept the terms and condition");
			//}
			
		}
		
                // Java code to illustrate reading a 
// CSV file line by line 
public static void readDataLineByLine(JTextArea jt,String file) 
{ 
  
    try { 
        
        jt.append(file);
  
        // Create an object of filereader 
        // class with CSV file as a parameter. 
        FileReader filereader = new FileReader("D:\\ "+file+" .csv"); 
  
        // create csvReader object passing 
        // file reader as a parameter 
        CSVReader csvReader = new CSVReader(filereader); 
        String[] nextRecord; 
  
        // we are going to read data line by line 
        while ((nextRecord = csvReader.readNext()) != null) { 
            for (String cell : nextRecord) { 
                
               // System.out.print(cell + "\t"); 
                jt.append(cell+"\t");
            } 
            jt.append("\n");
           // System.out.println(); 
        } 
    } 
    catch (Exception e) { 
        e.printStackTrace(); 
    } 
} 
}