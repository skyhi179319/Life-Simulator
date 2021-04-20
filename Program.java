import javax.swing.*;

import Assets.Actions;
import Assets.Ageing;
import Assets.Child;
import Assets.CreateLife;
import Assets.Jobs;
import Assets.Life;
import Assets.Status;
import Assets.Traits;
import Assets.Graphics.Objects;
import Assets.Graphics.Objects.Healthbar;
import Assets.Graphics.Objects.HealthbarRect;
import Assets.Graphics.Objects.Actions.StoryPan;
import Assets.JobScrips.NonDegree;
import Assets.JobScrips.CrimeScripts.Policing;
import lib.Colors;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
public class Program {
    private JFrame GameWindow;
    private static JLabel UserInfo;
    private static JLabel MomName;
    private static JLabel MomJob;
    private static JLabel DadName;
    private static JLabel DadJob;
    private static JLabel SchoolStatus;
    private static JLabel SportsStatus;
    private static JLabel MiddleschoolAward;
    private static JLabel HighschoolAward;
    private static JLabel CollegeAward;
    private static JButton Age = new JButton("Age");
    private static JTextField MomHealth = Objects.Healthbars.Mom;
    private static JTextField DadHealth = Objects.Healthbars.Dad;
    private static JTextField PlayerHealth = Objects.Healthbars.Player;
    private static JTextField ChildHealth;
    public Program(){
        prepareGUI();
    }
    public static void main(String[] args){
    	Program  Game = new Program();
    	Game.NameInfo();
    	Game.ToolBar();
    	Game.GameData();
    }
    private void Update(JLabel Label,String String, String Age) {
    	Label.setText(String + " " + Age);
    }
    private void UpdateUser(JLabel Label,String Name,String Age,String Money) {
    	Label.setText(Name + " " + Age + " $" + Money);
    }
    private static void Parents() {
	    JDialog Parents = new JDialog();
	    Parents.setTitle("Parents");
	    Parents.setBounds(750,150,600,200);
	    Parents.setVisible(true);
	    JPanel Main = new JPanel();
	    JPanel Health = new JPanel();
	    JPanel Mom = new JPanel();
	    JPanel Dad = new JPanel();
	    Parents.getContentPane().add(Main, BorderLayout.CENTER);
	    Parents.getContentPane().add(Health, BorderLayout.SOUTH);
	    String MomInfo = Life.Sims.Parents.Mom.Firstname + " " + Life.Sims.Parents.Mom.Lastname + ": " + Life.Sims.Parents.Mom.Age;
	    String DadInfo = Life.Sims.Parents.Dad.Firstname + " " + Life.Sims.Parents.Dad.Lastname + ": " + Life.Sims.Parents.Dad.Age;
	    MomName = new JLabel(MomInfo);
	    MomJob = new JLabel(Life.Sims.Parents.Mom.Job + " : $" + Life.Sims.Parents.Mom.Salary);
	    DadName = new JLabel(DadInfo);
	    DadJob = new JLabel(Life.Sims.Parents.Dad.Job + " : $" + Life.Sims.Parents.Dad.Salary);
	    Mom.add(MomName);
	    Mom.add(MomJob);
	    Mom.updateUI();
	    Dad.add(DadName);
	    Dad.add(DadJob);
	    Dad.updateUI();
	    Main.add(Mom);
	    Main.add(Dad);
	    Main.updateUI();
	    Parents.disable();
    }
    private static void Start() {
	   	JDialog User = new JDialog();
	   	User.setTitle("Start");
	   	User.setBounds(150,150,600,200);
	   	User.setVisible(true);
	    JPanel NewUser = new JPanel();
	    User.getContentPane().add(NewUser, BorderLayout.CENTER);
	    JLabel Firstname = new JLabel("Firstname");
	    JTextField FirstnameTextfield = new JTextField(10);
	    JLabel Lastname = new JLabel("Lastname");
	    JTextField LastnameTextfield = new JTextField(10);
	    JRadioButton male = new JRadioButton("Male");
	    JRadioButton female = new JRadioButton("Female");
	    JButton Create = new JButton("Create");
	    if(Life.CurrentPlayer.hasChild == false) {
	    	NewUser.add(Firstname);
		    NewUser.add(FirstnameTextfield);
		    NewUser.add(Lastname);
		    NewUser.add(LastnameTextfield);
		    NewUser.add(male);
		    NewUser.add(female);
		    Create.addMouseListener(new MouseAdapter() {
		    	@Override
			    public void mouseClicked(MouseEvent e) {
			   		if(male.isSelected() == true) {
			   			 CreateLife.CreateCurrent(FirstnameTextfield.getText(), LastnameTextfield.getText(),"Male");
			   		}
			   		if(female.isSelected() == true) {
			   			 CreateLife.CreateCurrent(FirstnameTextfield.getText(), LastnameTextfield.getText(),"Female");
			   		}
		            UserInfo.setText(Life.CurrentPlayer.Firstname + " " + Life.CurrentPlayer.Lastname + " " + Life.CurrentPlayer.Age);
		            User.dispose();
		            Parents();
		            HealthBars();
			   	}
		    });
		    NewUser.add(Create);
	    }
	    if(Life.CurrentPlayer.hasChild == true) {
	    	Choice ChildChoice = new Choice();
	    	ChildChoice.add(Life.simChild.Firstname);
	    	NewUser.add(ChildChoice);
	    	JButton create1Button = new JButton("Create");
	    	create1Button.addMouseListener(new MouseAdapter() {
			   	@Override
		        public void mouseClicked(MouseEvent e) {
			   		CreateLife.CreateChild(Life.simChild.Firstname);
			   		Traits.Functions.resetUser();
			   		//new Life.CurrentPlayer(Life.simChild.Firstname, Life.simChild.Lastname, 0);
			   		UserInfo.setText(Life.CurrentPlayer.Firstname + " " + Life.CurrentPlayer.Lastname + " " + Life.CurrentPlayer.Age);
			   		User.dispose();
			   		Parents();
			   		HealthBars();
			   }
		   });
		   JButton Exit = new JButton("Exit");
		   Exit.addMouseListener(new MouseAdapter() {
			   @Override
			   public void mouseClicked(MouseEvent e) {
				   System.exit(0);
			   }
		   });
		   NewUser.add(create1Button);
		   NewUser.add(Exit);
		   if(Age.isSelected() == true) {
			   System.exit(0);
		   }
	    }
	    NewUser.updateUI();
   }
    private void prepareGUI(){
    	GameWindow = new JFrame();
    	GameWindow.setTitle("Life Simulator");
    	GameWindow.setBounds(100, 100, 550, 329);
    	GameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	GameWindow.setVisible(true);
    	Jobs.Populate();
    	System.out.println(Jobs.JobsArray);
    	Start();
    }
    private void NameInfo(){
        JPanel NamePanel = new JPanel();
        GameWindow.getContentPane().add(NamePanel, BorderLayout.NORTH);
        UserInfo = new JLabel();
        NamePanel.add(UserInfo);
    }
    private void updateChild() {
    	if(Life.CurrentPlayer.hasChild) {
    		ChildHealth.setText(Objects.Healthbar.changeAgeMeter(Objects.Healthbar.Child.childAge()));
    		ChildHealth.setBackground(Objects.Healthbar.changeColor(Objects.Healthbar.Child.childAge()));
    	}
    }
    private void ToolBar(){
    	JToolBar ToolBar = new JToolBar();
	    ToolBar.setSize(new Dimension(250,0));
	    ToolBar.setOrientation(SwingConstants.HORIZONTAL);
	    GameWindow.getContentPane().add(ToolBar, BorderLayout.SOUTH);
	    JButton SchoolButton = new JButton("School");
	    Ageing.hideButton(SchoolButton);
	    JButton School[] = {new JButton("Elementary"),new JButton("Middleschool"),new JButton("Highschool"),new JButton("College")};
	    JButton Job = new JButton("Jobs");
	    Ageing.hideButton(Job);
	    JButton Dating = new JButton("Dating");
	    Ageing.hideButton(Dating);
	    JButton Crime = new JButton("Crime");
	    Ageing.hideButton(Crime);
	    Age.addMouseListener(new MouseAdapter() {
	    	@Override
	        public void mouseClicked(MouseEvent e) {
	    		Ageing.Age();
	    		System.out.println(Life.CurrentPlayer.Job);
	    		Update(MomName,Ageing.UpdateInfo.MomInfo,Integer.toString(Life.Sims.Parents.Mom.Age));
	    		Update(MomJob,Ageing.UpdateInfo.MomJob,"");
	    		Update(DadName,Ageing.UpdateInfo.DadInfo,Integer.toString(Life.Sims.Parents.Dad.Age));
	    		Update(DadJob,Ageing.UpdateInfo.DadJob,"");
	    		UpdateUser(UserInfo,Ageing.UpdateInfo.UserInfo,Integer.toString(Life.CurrentPlayer.Age),Life.CurrentPlayer.StringMoney + Status.getJobInfo());
	    		Status.UpdateLabel(SchoolStatus, Status.getSchool());
	    		Status.UpdateLabel(SportsStatus,Status.getSports());
	    		Status.UpdateLabel(MiddleschoolAward, "Middleschool: " + Status.getSportAward(Life.CurrentPlayer.Middleschool));
	    		Status.UpdateLabel(HighschoolAward, "Highschool: " + Status.getSportAward(Life.CurrentPlayer.Highschool));
	    		Status.UpdateLabel(CollegeAward, "College: " + Status.getSportAward(Life.CurrentPlayer.College));
	    		if(Life.CurrentPlayer.Age == 6) {
	    			Ageing.showButton(SchoolButton);
	    			Ageing.hideButton(School[1]);
	    			Ageing.hideButton(School[2]);
	    			Ageing.hideButton(School[3]);
	    		}
	    		if(Life.CurrentPlayer.Age == 12) {
	    			Ageing.hideButton(School[0]);
	    			Ageing.showButton(School[1]);
	    		}
	    		if(Life.CurrentPlayer.Age == 14) {
	    			Ageing.hideButton(School[1]);
	    			Ageing.showButton(School[2]);
	    			Ageing.showButton(Job);
	    			Ageing.showButton(Dating);
	    			Actions.Job.autoClick(Job);
	    		}
	    		if(Life.CurrentPlayer.Age == 18) {
	    			Ageing.hideButton(School[2]);
	    			Ageing.showButton(School[3]);
	    			Actions.School.autoClick(School[3]);
	    		}
	    		if(Life.CurrentPlayer.Age == 21) {
	    			Ageing.hideButton(School[3]);
	    			Ageing.hideButton(SchoolButton);
	    		}
	    		if(Life.CurrentPlayer.Age == 80) {
	    			Actions.Storyline.createStory();
	    			JDialog Confirm = new JDialog();
	    			if(Life.CurrentPlayer.hasChild == false) {
	    				Confirm.setTitle("Confirm");
	    				Confirm.setBounds(200, 100, 300, 400);
	    				Confirm.setVisible(true);
	    				JPanel Message = new JPanel();
	    				JPanel Buttons = new JPanel();
	    				Confirm.getContentPane().add(Message,BorderLayout.NORTH);
	    				Confirm.getContentPane().add(Buttons,BorderLayout.CENTER);
	    				Message.add(new JLabel("Do You Want To Exit"));
	    				JButton Yes = new JButton("Yes");
	    				JButton No = new JButton("No");
	    				Yes.addMouseListener(new MouseAdapter() {
	    					@Override
	    					public void mouseClicked(MouseEvent e) {
	    						System.exit(0);
	    					}
	    				});
	    				Buttons.add(Yes);
	    				Buttons.add(No);
	    				Message.updateUI();
	    				Buttons.updateUI();
	    			}
	    			else {
	    				Start();
	    			}
	    		}
	    		Actions.School.ClearLabel(SchoolStatus);
	    		Actions.School.ClearLabel(SportsStatus);
	    		Policing.Jail.lock(SchoolButton, Job, Crime);
	    		Policing.Offense.yearsLeft();
	    		Policing.Jail.BreakoutAtt = 0;
	    		PlayerHealth.setBackground(Objects.Healthbar.changeColor(Life.CurrentPlayer.Age));
	    		MomHealth.setBackground(Objects.Healthbar.changeColor(Life.Sims.Parents.Mom.Age));
	    		DadHealth.setBackground(Objects.Healthbar.changeColor(Life.Sims.Parents.Dad.Age));
	    		PlayerHealth.setText(Objects.Healthbar.changeAgeMeter(Life.CurrentPlayer.Age));
	    		MomHealth.setText(Objects.Healthbar.changeAgeMeter(Life.Sims.Parents.Mom.Age));
	    		DadHealth.setText(Objects.Healthbar.changeAgeMeter(Life.Sims.Parents.Dad.Age));
	    		updateChild();
	    	}
	    });
	    SchoolButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		JDialog Schools = new JDialog();
	    	    Schools.setTitle("Schools");
	    	    Schools.setBounds(400,150,600,200);
	    	    Schools.setVisible(true);
	    	    JPanel Buttons = new JPanel();
	    	    Schools.getContentPane().add(Buttons, BorderLayout.CENTER);
	    	    Buttons.add(School[0]);
	    	    School[1].addMouseListener(new MouseAdapter() {
	    	    	public void mouseClicked(MouseEvent e) {
	    	    		JDialog MiddleSchool = new JDialog();
	    	    		MiddleSchool.setTitle("Middleschool");
	    	    		MiddleSchool.setBounds(400,150,600,200);
	    	    		MiddleSchool.setVisible(true);
	    	    	    JPanel Actions = new JPanel();
	    	    	    MiddleSchool.getContentPane().add(Actions, BorderLayout.CENTER);
	    	    	    JButton Sports = new JButton("Sports");
	    	    	    Sports.addMouseListener(new MouseAdapter() {
	    	    	    	@Override
	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    		JDialog SportWindow = new JDialog();
	    	    	    		SportWindow.setTitle("Sports");
	    	    	    		SportWindow.setBounds(400,150,600,200);
	    	    	    		SportWindow.setVisible(true);
	    	    	    	    JPanel SportsActions = new JPanel();
	    	    	    	    SportWindow.getContentPane().add(SportsActions, BorderLayout.CENTER);
	    	    	    	    JButton Football = new JButton("Football");
	    	    	    	    Football.addMouseListener(new MouseAdapter() {
	    	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    	    		if(Life.CurrentPlayer.Sex.equals(Assets.Restrictions.Jobs.Football)) {
	    	    	    	    			Life.CurrentPlayer.Activities.clear();
	    	    	    	    			Life.CurrentPlayer.Activities.add("Football");
	    	    	    	    		}	    	    	    
	    	    	    	    	}
	    	    	    	    });
	    	    	    	    SportsActions.add(Football);
	    	    	    	    JButton Basketball = new JButton("Basketball");
	    	    	    	    Basketball.addMouseListener(new MouseAdapter() {
	    	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    	    		Life.CurrentPlayer.Activities.clear();
	    	    	    	    		Life.CurrentPlayer.Activities.add("Basketball");
	    	    	    	    	}
	    	    	    	    });
	    	    	    	    SportsActions.add(Basketball);
	    	    	    	    SportsActions.updateUI();
	    	    	    	}
	    	    	    });
	    	    	    Actions.add(Sports);
	    	    	    Actions.updateUI();
	    	    	}
	    	    });
	    	    School[2].addMouseListener(new MouseAdapter() {
	    	    	public void mouseClicked(MouseEvent e) {
	    	    		JDialog HighSchool = new JDialog();
	    	    		HighSchool.setTitle("Highschool");
	    	    		HighSchool.setBounds(400,150,600,200);
	    	    		HighSchool.setVisible(true);
	    	    	    JPanel Actions = new JPanel();
	    	    	    HighSchool.getContentPane().add(Actions, BorderLayout.CENTER);
	    	    	    JButton Sports = new JButton("Sports");
	    	    	    Sports.addMouseListener(new MouseAdapter() {
	    	    	    	@Override
	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    		JDialog SportWindow = new JDialog();
	    	    	    		SportWindow.setTitle("Sports");
	    	    	    		SportWindow.setBounds(400,150,600,200);
	    	    	    		SportWindow.setVisible(true);
	    	    	    	    JPanel SportsActions = new JPanel();
	    	    	    	    SportWindow.getContentPane().add(SportsActions, BorderLayout.CENTER);
	    	    	    	    JButton Football = new JButton("Football");
	    	    	    	    Football.addMouseListener(new MouseAdapter() {
	    	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    	    		Life.CurrentPlayer.Activities.clear();
	    	    	    	    		Life.CurrentPlayer.Activities.add("Football");
	    	    	    	    	}
	    	    	    	    });
	    	    	    	    SportsActions.add(Football);
	    	    	    	    JButton Basketball = new JButton("Basketball");
	    	    	    	    Basketball.addMouseListener(new MouseAdapter() {
	    	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    	    		Life.CurrentPlayer.Activities.clear();
	    	    	    	    		Life.CurrentPlayer.Activities.add("Basketball");
	    	    	    	    	}
	    	    	    	    });
	    	    	    	    SportsActions.add(Basketball);
	    	    	    	    JButton Baseball = new JButton("Baseball");
	    	    	    	    Baseball.addMouseListener(new MouseAdapter() {
	    	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    	    		Life.CurrentPlayer.Activities.clear();
	    	    	    	    		Life.CurrentPlayer.Activities.add("Baseball");
	    	    	    	    	}
	    	    	    	    });
	    	    	    	    SportsActions.add(Baseball);
	    	    	    	    SportsActions.updateUI();
	    	    	    	}
	    	    	    });
	    	    	    Actions.add(Sports);
	    	    	    Actions.updateUI();
	    	    	}
	    	    });
	    	    School[3].addMouseListener(new MouseAdapter() {
	    	    	@Override
	    	    	public void mouseClicked(MouseEvent e) {
	    	    		JDialog College = new JDialog();
	    	    		College.setTitle("College");
	    	    		College.setBounds(400,150,600,200);
	    	    		College.setVisible(true);
	    	    	    JPanel Actions = new JPanel();
	    	    	    College.getContentPane().add(Actions, BorderLayout.CENTER);
	    	    	    JButton Degree = new JButton("Degree");
	    	    	    Degree.addMouseListener(new MouseAdapter() {
	    	    	    	@Override
	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    		JDialog DegreeWindow = new JDialog();
	    	    	    		DegreeWindow.setTitle("Degree");
	    	    	    		DegreeWindow.setBounds(400,150,600,200);
	    	    	    		DegreeWindow.setVisible(true);
	    	    	    		JPanel DegreePanel = new JPanel();
	    	    	    		DegreeWindow.getContentPane().add(DegreePanel, BorderLayout.CENTER);
	    	    	    		String[] DegreeStrings = Assets.School.College.Degrees.DegreeSet();
	    	    	    		Choice DegreeChoice = new Choice();
	    	    	    		for(String i : DegreeStrings) {
	    	    	    			DegreeChoice.add(i);
	    	    	    		}
	    	    	    		
	    	    	    		JButton Pick = new JButton("Pick Degree");
	    	    	    		Pick.addMouseListener(new MouseAdapter() {
	    	    	    			@Override
	    	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    				Assets.School.College.Degrees.pickDegree(DegreeChoice.getSelectedItem());
	    	    	    			}
	    	    	    		});
	    	    	    		DegreePanel.add(DegreeChoice);
	    	    	    		DegreePanel.add(Pick);
	    	    	    		DegreePanel.updateUI();
	    	    	    	}
	    	    	    });
	    	    	    JButton Sports = new JButton("Sports");
	    	    	    Sports.addMouseListener(new MouseAdapter() {
	    	    	    	@Override
	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    		JDialog SportWindow = new JDialog();
	    	    	    		SportWindow.setTitle("Sports");
	    	    	    		SportWindow.setBounds(400,150,600,200);
	    	    	    		SportWindow.setVisible(true);
	    	    	    	    JPanel SportsActions = new JPanel();
	    	    	    	    SportWindow.getContentPane().add(SportsActions, BorderLayout.CENTER);
	    	    	    	    JButton Football = new JButton("Football");
	    	    	    	    Football.addMouseListener(new MouseAdapter() {
	    	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    	    		Life.CurrentPlayer.Activities.clear();
	    	    	    	    		Life.CurrentPlayer.Activities.add("Football");
	    	    	    	    	}
	    	    	    	    });
	    	    	    	    SportsActions.add(Football);
	    	    	    	    JButton Basketball = new JButton("Basketball");
	    	    	    	    Basketball.addMouseListener(new MouseAdapter() {
	    	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    	    		Life.CurrentPlayer.Activities.clear();
	    	    	    	    		Life.CurrentPlayer.Activities.add("Basketball");
	    	    	    	    	}
	    	    	    	    });
	    	    	    	    SportsActions.add(Basketball);
	    	    	    	    JButton Baseball = new JButton("Baseball");
	    	    	    	    Baseball.addMouseListener(new MouseAdapter() {
	    	    	    	    	public void mouseClicked(MouseEvent e) {
	    	    	    	    		Life.CurrentPlayer.Activities.clear();
	    	    	    	    		Life.CurrentPlayer.Activities.add("Baseball");
	    	    	    	    	}
	    	    	    	    });
	    	    	    	    SportsActions.add(Baseball);
	    	    	    	    SportsActions.updateUI();
	    	    	    	}
	    	    	    });
	    	    	    Actions.add(Degree);
	    	    	    Actions.add(Sports);
	    	    	    Actions.updateUI();
	    	    	}
	    	    });
	    	    Buttons.add(School[1]);
	    	    Buttons.add(School[2]);
	    	    Buttons.add(School[3]);
	    	    Buttons.updateUI();
	    	}
	    });
	    Job.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		JDialog Jobs = new JDialog();
	    		Jobs.setTitle("Jobs");
	    		Jobs.setBounds(400,150,600,200);
	    		Jobs.setVisible(true);
	    		JPanel JobsPanel = new JPanel();
	    		Jobs.getContentPane().add(JobsPanel, BorderLayout.CENTER);
	    		ArrayList<String> JobsFound = new ArrayList<String>();
	    		String[] Advance = Assets.Jobs.FindAdvanceJobs(Life.CurrentPlayer.Age,Life.CurrentPlayer.Degrees);
	    		String[] JobStrings = Assets.Jobs.FindJob(Life.CurrentPlayer.Age,Life.CurrentPlayer.Degrees);
	    		for(String i : Advance) {
	    			if(JobsFound.contains(i)) {
	    				
	    			}
	    			else {
	    				if(Advance.length == 2) {
	    					Life.CurrentPlayer.Debts = new BigDecimal(50.00);
	    				}
	    				if(Advance.length == 1) {
	    					Life.CurrentPlayer.Debts = new BigDecimal(100.00);
	    				}
	    				JobsFound.add(i);
	    			}
	    		}
	    		for(String i : JobStrings) {
	    			if(JobsFound.contains(i)) {
	    				
	    			}
	    			else {
	    				JobsFound.add(i);
	    			}
	    		}
	    		Choice JobsChoice = new Choice();
	    		for(String i : JobsFound) {
	    			JobsChoice.add(i);
	    		}
	    		JobsPanel.add(JobsChoice);
	    		JButton Pick = new JButton("Pick Job");
	    		Pick.addMouseListener(new MouseAdapter() {
	    			@Override
	    	    	public void mouseClicked(MouseEvent e) {
	    				Assets.Jobs.pickJob(JobsChoice.getSelectedItem());
	    			}
	    		});
	    		JobsPanel.add(Pick);
	    		JobsPanel.updateUI();
	    		if(Life.CurrentPlayer.Retirement == true) {
	    			Ageing.hideButton(Job);
	    		}
	    	}
	    });
	    Crime.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		JDialog Crimes = new JDialog();
	    		Crimes.setTitle("Crimes");
	    		Crimes.setBounds(400,150,600,200);
	    		Crimes.setVisible(true);
	    		JPanel CrimesPanel = new JPanel();
	    		Crimes.getContentPane().add(CrimesPanel, BorderLayout.CENTER);
	    		String[] Jobs = {Life.CurrentPlayer.Job};
	    		BigDecimal[] Money = {new BigDecimal(25.00),new BigDecimal(50.00),new BigDecimal(100.00)};
	    		Choice CrimeChoice = new Choice();
	    		for(String i : Jobs) {
	    			CrimeChoice.add(i);
	    		}
	    		Choice MoneyChoice = new Choice();
	    		for(BigDecimal i : Money) {
	    			MoneyChoice.add(i.round(new MathContext(2)).toPlainString());
	    		}
	    		JButton Commit = new JButton("Commit");
	    		Commit.addMouseListener(new MouseAdapter() {
	    			@Override
	    			public void mouseClicked(MouseEvent e) {
	    				if(Life.CurrentPlayer.Job.equals("Drug Dealer") || Life.CurrentPlayer.Job.equals("Robber")) {
	    					Policing.Offense.Attempt();
	    					if(Life.CurrentPlayer.Job == "Robber") {
	    						Life.CurrentPlayer.Crime = "Robbery";
	    					}
	    					if(Life.CurrentPlayer.Job == "Drug Dealer") {
	    						Life.CurrentPlayer.Crime = "Drug Dealing";
	    					}
	    					if(Life.CurrentPlayer.Jail == false) {
	    						NonDegree.Crime.addMoney(BigDecimal.valueOf(Double.valueOf(Life.CurrentPlayer.PettyCash.toPlainString())));
	    					}
	    					if(Life.CurrentPlayer.Jail == true) {
	    						Life.CurrentPlayer.Job = "";
	    			    		Policing.Jail.lock(SchoolButton, Job, Crime);
	    			    		JDialog Jail = new JDialog();
	    			    		Jail.setTitle("Jail");
	    			    		Jail.setBounds(400,150,600,200);
	    			    		Jail.setVisible(true);
	    			    		JPanel JailPanel = new JPanel();
	    			    		Jail.getContentPane().add(JailPanel, BorderLayout.CENTER);
	    			    		JPanel JailStatusPanel = new JPanel();
	    			    		Jail.getContentPane().add(JailStatusPanel, BorderLayout.SOUTH);
	    			    		JLabel Status = new JLabel(Policing.Jail.JailStatus());
	    			    		Status.addMouseListener(new MouseAdapter() {
	    			    			@Override
	    			    	    	public void mouseClicked(MouseEvent e) {
	    			    	    		String name = Life.CurrentPlayer.Firstname + " " + Life.CurrentPlayer.Lastname;
		    			    			int age = Life.CurrentPlayer.Age;
		    			    			String job = Life.CurrentPlayer.Job;
		    			    			String crime = Life.CurrentPlayer.Crime;
		    			    			int mustserve = Life.CurrentPlayer.YearsMustServe;
		    			    			new Objects.Places.Jail.Info(name,age,job,new Objects.HealthbarRect(Objects.Healthbar.width),crime,mustserve);
	    			    	    	}
	    			    		});
	    			    		JButton Breakout = new JButton("Breakout");
	    			    		Breakout.addMouseListener(new MouseAdapter() {
	    			    			@Override
	    			    			public void mouseClicked(MouseEvent e) {
	    			    				Policing.Jail.Breakout();
	    			    				Policing.Jail.BreakoutAtt = Policing.Jail.BreakoutAtt + 1;
	    			    				Policing.Jail.lock(SchoolButton, Job, Crime);
	    			    				if(Life.CurrentPlayer.Jail == false) {
	    			    					Jail.dispose();
	    			    					Policing.Jail.BreakoutAtt = 0;
	    			    				}
	    			    				else {
	    			    					Status.setText(Policing.Jail.JailFullStatus());
	    			    				}
	    			    			}
	    			    		});
	    			    		JailStatusPanel.add(Status);
	    			    		JailStatusPanel.updateUI();
	    			    		JailPanel.add(Breakout);
	    			    		JailPanel.updateUI();
	    					}
	    				}
	    			}
	    		});
	    		CrimesPanel.add(CrimeChoice);
	    		CrimesPanel.add(MoneyChoice);
	    		CrimesPanel.add(Commit);
	    		CrimesPanel.updateUI();
	    	}
	    });
	    Dating.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		String[] Date1 = Assets.Dating.pickDate.Name();
	    		String[] Date2 = Assets.Dating.pickDate.Name();
	    		String[] Date3 = Assets.Dating.pickDate.Name();
	    		String Date1Name = Date1[0] + " " + Date1[1];
	    		String Date2Name = Date2[0] + " " + Date2[1];
	    		String Date3Name = Date3[0] + " " + Date3[1];
	    		JDialog Dating = new JDialog();
	    		Dating.setTitle("Dating");
	    		Dating.setBounds(400,150,600,200);
	    		Dating.setVisible(true);
	    		JPanel DatingPanel = new JPanel();
	    		Dating.getContentPane().add(DatingPanel, BorderLayout.CENTER);
	    		if(Life.CurrentPlayer.Dating.isEmpty()) {
	    			Choice DatingChoice = new Choice();
		    		DatingChoice.add(Date1Name);
		    		DatingChoice.add(Date2Name);
		    		DatingChoice.add(Date3Name);
		    		JButton Choice = new JButton("Date");
		    		Choice.addMouseListener(new MouseAdapter() {
		    			@Override
		    			public void mouseClicked(MouseEvent e) {
		    				if(DatingChoice.getSelectedItem().equals(Date1Name)) {
		    					CreateLife.CreateDate(Date1[0], Date1[1]);
		    					Life.CurrentPlayer.Dating = Date1Name;
		    				}
		    				if(DatingChoice.getSelectedItem().equals(Date2Name)) {
		    					CreateLife.CreateDate(Date2[0], Date2[1]);
		    					Life.CurrentPlayer.Dating = Date2Name;
		    				}
		    				if(DatingChoice.getSelectedItem().equals(Date3Name)) {
		    					CreateLife.CreateDate(Date3[0], Date3[1]);
		    					Life.CurrentPlayer.Dating = Date3Name;
		    				}
		    				Life.CurrentPlayer.RelationshipStatus = "Girlfriend";
		    				Assets.Dating.CurrentDate.RelationshipStatus = "Boyfriend";
		    			}
		    		});
		    		DatingPanel.add(DatingChoice);
		    		DatingPanel.add(Choice);
		    		DatingPanel.updateUI();
	    		}
	    		if(Life.CurrentPlayer.isMarried == false && !Life.CurrentPlayer.Dating.isEmpty()) {
	    			JButton getMarried = new JButton("Get Married");
	    			getMarried.addMouseListener(new MouseAdapter() {
	    				@Override
	    				public void mouseClicked(MouseEvent e) {
	    					Life.CurrentPlayer.isMarried = true;
	    					Life.CurrentPlayer.RelationshipStatus = "Married";
	    					Assets.Dating.CurrentDate.Lastname = Life.CurrentPlayer.Lastname;
	    				}
	    			});
	    			DatingPanel.add(getMarried);
	    			DatingPanel.updateUI();
	    		}
	    		if(Life.CurrentPlayer.isMarried == true && Life.CurrentPlayer.hasChild == false) {
	    			JButton haveBaby = new JButton("Have Baby");
	    			haveBaby.addMouseListener(new MouseAdapter() {
	    				@Override
	    				public void mouseClicked(MouseEvent e) {
	    					if(Child.haveChild.born() == true) {
	    						Life.CurrentPlayer.yearOnlyChildBirth = Life.CurrentPlayer.Age;
	    						JDialog User = new JDialog();
	    				    	 User.setTitle("Child");
	    				    	 User.setBounds(150,150,600,200);
	    				    	 User.setVisible(true);
	    				         JPanel NewUser = new JPanel();
	    				         User.getContentPane().add(NewUser, BorderLayout.CENTER);
	    				         JLabel Firstname = new JLabel("Firstname");
	    				         JTextField FirstnameTextfield = new JTextField(10);
	    				         JRadioButton male = new JRadioButton("Male");
	    				 	     JRadioButton female = new JRadioButton("Female");
	    				 	     NewUser.add(male);
	    				 	     NewUser.add(female);
	    				         JButton Create = new JButton("Create");
	    				         NewUser.add(Firstname);
	    				         NewUser.add(FirstnameTextfield);
	    				         Create.addMouseListener(new MouseAdapter() {
	    				        	 @Override
	    				             public void mouseClicked(MouseEvent e) {
	    				        		if(male.isSelected() == true) {
	    						   			CreateLife.CreateSimChild(FirstnameTextfield.getText(),Life.CurrentPlayer.Lastname,"Male");
	    						   		}
	    						   		if(female.isSelected() == true) {
	    						   			CreateLife.CreateSimChild(FirstnameTextfield.getText(),Life.CurrentPlayer.Lastname,"Female");
	    						   		}
	    				                
	    				                Life.CurrentPlayer.OnlyChildName = Life.simChild.Firstname + " " + Life.CurrentPlayer.Lastname;
	    				                Assets.Dating.CurrentDate.OnlyChild = Life.simChild.Firstname + " " + Life.CurrentPlayer.Lastname;
	    				                Life.CurrentPlayer.hasChild = true;
	    				                User.dispose();
	    				        	 }
	    				         });
	    				         NewUser.add(Create);
	    				         NewUser.updateUI();	    						
	    					}
	    				}
	    			});
	    			DatingPanel.add(haveBaby);
	    			DatingPanel.updateUI();
	    		}
	    	}
	    });
	    ToolBar.add(Age);
	    ToolBar.add(SchoolButton);
	    ToolBar.add(Job);
	    ToolBar.add(Crime);
	    ToolBar.add(Dating);
    }
    private void GameData() {
    	JPanel GameDataPanel = new JPanel();
    	JPanel SchoolPanel = new JPanel();
    	JPanel SportsPanel = new JPanel();
        GameWindow.getContentPane().add(GameDataPanel, BorderLayout.CENTER);
        SchoolStatus = new JLabel(Status.getSchool());
        SportsStatus = new JLabel(Status.getSports());
        MiddleschoolAward = new JLabel();
        HighschoolAward = new JLabel();
        CollegeAward = new JLabel();
        SchoolPanel.add(SchoolStatus);
        SchoolPanel.add(SportsStatus);
        SportsPanel.add(MiddleschoolAward);
        SportsPanel.add(HighschoolAward);
        SportsPanel.add(CollegeAward);
        GameDataPanel.add(SchoolPanel);
        GameDataPanel.add(SportsPanel);
    }
    private static void HealthBars() {
    	JDialog Health = new JDialog();
    	Health.setTitle("Health Bars");
    	Health.setBounds(400,400,700,200);
    	Health.setVisible(true);
	    JPanel Bars = new JPanel();
	    Health.getContentPane().add(Bars, BorderLayout.CENTER);
	    Bars.add(new JLabel("Mom: "));
	    MomHealth.setEditable(Objects.Healthbar.editable);
	    MomHealth.setBackground(Objects.Healthbar.changeColor(Life.Sims.Parents.Mom.Age));
	    Bars.add(MomHealth);
	    Bars.add(new JLabel("Dad: "));
	    DadHealth.setEditable(Objects.Healthbar.editable);
	    DadHealth.setBackground(Objects.Healthbar.changeColor(Life.Sims.Parents.Dad.Age));
	    Bars.add(DadHealth);
	    Bars.add(new JLabel("Player :"));
	    PlayerHealth.setEditable(Objects.Healthbar.editable);
        PlayerHealth.setBackground(Objects.Healthbar.changeColor(Life.CurrentPlayer.Age));
        Bars.add(PlayerHealth);
        Bars.add(new JLabel("Child: "));
        ChildHealth = Objects.Healthbars.Blank;
        ChildHealth.setBackground(Colors.white);
        ChildHealth.setEditable(Objects.Healthbar.editable);
        if(Life.CurrentPlayer.hasChild == false) {
        	ChildHealth.setText("N/A");
        }
        Bars.add(ChildHealth);
	    PlayerHealth.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		String Name = Life.CurrentPlayer.Firstname + " " + Life.CurrentPlayer.Lastname;
	    		int Age = Life.CurrentPlayer.Age;
	    		String Job = Life.CurrentPlayer.Job;
	    		new Objects.Faces.Info(Name, Age, Job, new Objects.HealthbarRect(Objects.Healthbar.width));
	    	}
        });
	    MomHealth.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		String Name = Life.Sims.Parents.Mom.Firstname + " " + Life.Sims.Parents.Mom.Lastname;
	    		int Age = Life.Sims.Parents.Mom.Age;
	    		String Job = Life.Sims.Parents.Mom.Job;
	    		new Objects.Faces.Info(Name, Age, Job, new Objects.HealthbarRect(Objects.Healthbar.width));
	    	}
        });
	    DadHealth.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		String Name = Life.Sims.Parents.Dad.Firstname + " " + Life.Sims.Parents.Dad.Lastname;
	    		int Age = Life.Sims.Parents.Dad.Age;
	    		String Job = Life.Sims.Parents.Dad.Job;
	    		new Objects.Faces.Info(Name, Age, Job, new Objects.HealthbarRect(Objects.Healthbar.width));
	    	}
        });
        PlayerHealth.setText(Objects.Healthbar.changeAgeMeter(Life.CurrentPlayer.Age));
		MomHealth.setText(Objects.Healthbar.changeAgeMeter(Life.Sims.Parents.Mom.Age));
		DadHealth.setText(Objects.Healthbar.changeAgeMeter(Life.Sims.Parents.Dad.Age));
		Bars.updateUI();
    }
}