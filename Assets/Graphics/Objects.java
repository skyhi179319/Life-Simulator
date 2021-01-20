package Assets.Graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Assets.Life;
import Assets.Restrictions;

import lib.Colors;
public class Objects {
	public static class Healthbar{
		public static int x = 0;
		public static int y = 0;
		public static int width = 10;
		public static boolean editable = false;
		public static Color changeColor(int age) {
			int first = 20;
			int second = 40;
			int third = 60;
			int fourth = 70;
			int fifth = 80;
			Color background = null;
			if(age <= first) {
				background = lib.Colors.Palettes.Green.Green;
			}
			if(age <= second && age > first) {
				background = lib.Colors.Palettes.Green.Brightgreen;
			}
			if(age <= third && age > second) {
				background = lib.Colors.Palettes.Green.Lightgreen;
			}
			if(age <= fourth && age > third) {
				background = lib.Colors.Palettes.Yellow.Yellow;
			}
			if(age <= fifth && age > fourth) {
				background = lib.Colors.Palettes.Red.Brightred;
			}
			return background; 
		}
		public static String changeAgeMeter(int age) {
			String Result = "";
			if(age < 9) {
				Result = "0"+ age + "/" + Restrictions.Settings.Age;
				return Result;
			}
			else {
				Result = age + "/" + Restrictions.Settings.Age;
				return Result;
			}
		}
		public static class Child{
			public static boolean haveChild() {
				return Life.CurrentPlayer.hasChild;
			}
			public static int childAge() {
				int Age = Life.CurrentPlayer.Age - Life.CurrentPlayer.yearOnlyChildBirth;
				return Age;
			}
		}
	}
	public static class HealthbarRect extends JTextField{
		private static int col;
		public HealthbarRect(int Col) {
			col = Col;
			super.setColumns(col);
		}
		@Override
		public void paintComponent(Graphics g) {
			// y = height
			// x = width
			Color currentBackground = super.getBackground();
			if(currentBackground == Colors.Palettes.Green.Green) {
				Graphics2D g2 = (Graphics2D) g.create();
			    g2.setPaint(new GradientPaint(new Point(0, getHeight()), Colors.Palettes.Green.Green, new Point(getWidth(),0), Colors.Palettes.Green.Brightgreen));
			    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
			    g2.setPaint(Colors.Palettes.Light.Silver);
			    g2.drawString(super.getText(), 40, 12);
			    g2.dispose();
			}
			else if(currentBackground == Colors.Palettes.Green.Brightgreen) {
				Graphics2D g2 = (Graphics2D) g.create();
			    g2.setPaint(new GradientPaint(new Point(0, getHeight()), Colors.Palettes.Green.Brightgreen, new Point(getWidth(),0), Colors.Palettes.Green.Lightgreen));
			    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
			    g2.setPaint(Colors.Palettes.Light.Lightslategray);
			    g2.drawString(super.getText(), 42, 12);
			    g2.dispose();
			}
			else if(currentBackground == Colors.Palettes.Green.Lightgreen) {
				Graphics2D g2 = (Graphics2D) g.create();
			    g2.setPaint(new GradientPaint(new Point(10, getHeight()), Colors.Palettes.Red.Brightred, new Point(getWidth() - 54,0), Colors.Palettes.Green.Lightgreen));
			    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
			    g2.setPaint(Colors.Palettes.Dark.Darkblue);
			    g2.drawString(super.getText(), 42, 12);
			    g2.dispose();
			}
			else if(currentBackground == Colors.Palettes.Yellow.Yellow) {
				Graphics2D g2 = (Graphics2D) g.create();
			    g2.setPaint(new GradientPaint(new Point(20, getHeight()), Colors.Palettes.Red.Brightred, new Point(getWidth(),0), Colors.Palettes.Yellow.Yellow));
			    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
			    g2.setPaint(Colors.Palettes.Dark.Darkblue);
			    g2.drawString(super.getText(), 42, 12);
			    g2.dispose();
			}
			else if(currentBackground == Colors.Palettes.Red.Brightred) {
				Graphics2D g2 = (Graphics2D) g.create();
			    g2.setPaint(new GradientPaint(new Point(20, getHeight()), Colors.Palettes.Red.Brightred, new Point(getWidth(),0), Colors.Palettes.Red.Lightred));
			    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
			    g2.setPaint(Colors.Palettes.Light.Gold);
			    g2.drawString(super.getText(), 42, 12);
			    g2.dispose();
			}
			else {
				Graphics2D g2 = (Graphics2D) g.create();
			    g2.setPaint(new GradientPaint(new Point(30, getHeight()), Colors.Palettes.White.White, new Point(getWidth(),0), Colors.Palettes.White.Whitesmoke));
			    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
			    g2.setPaint(Colors.Palettes.Light.Gold);
			    g2.drawString(super.getText(), 42, 12);
			    g2.dispose();
			}
		}
	}
	public static class Healthbars{
		public static HealthbarRect Mom = new HealthbarRect(Healthbar.width);
		public static HealthbarRect Dad = new HealthbarRect(Healthbar.width);
		public static HealthbarRect Player = new HealthbarRect(Healthbar.width);
		public static HealthbarRect Child = new HealthbarRect(Healthbar.width);
		public static HealthbarRect Blank = new HealthbarRect(Healthbar.width);
	}
	public static class Faces{
		public static class Face extends JPanel{
			private static int x;
			private static int y;
			private static int age;
			public Face(int X,int Y, int Age) {
				x = X;
				y = Y;
				age = Age;
				Canvas c = new Canvas() {
					public void paint(Graphics g) {
						int first = 20;
						int second = 40;
						int third = 60;
						int fourth = 70;
						int fifth = 80;
						Color background = null;
						if(age <= first) {
							background = lib.Colors.Palettes.Green.Green;
						}
						if(age <= second && age > first) {
							background = lib.Colors.Palettes.Green.Brightgreen;
						}
						if(age <= third && age > second) {
							background = lib.Colors.Palettes.Green.Lightgreen;
						}
						if(age <= fourth && age > third) {
							background = lib.Colors.Palettes.Yellow.Yellow;
						}
						if(age <= fifth && age > fourth) {
							background = lib.Colors.Palettes.Red.Brightred;
						}
				        g.setColor(background); 
						g.drawOval(x, y, 30, 30); 
						  
				        // Ovals for eyes 
				        // with black color filled
						g.setColor(Colors.Palettes.Dark.Darkgray);
				        g.fillOval(8 + x, 10 + y, 3, 3); 
				        g.fillOval(18 + x, 10 + y, 3, 3); 
				  
				        // Arc for the smile 
				        g.drawArc(8 + x, 18 + y, 14, 2, 4, 4);
				        g.dispose();
					}
				};
				c.setBounds(0, 0, 50, 100);
				super.add(c);
				super.updateUI();
			}
		}
		public static class Info extends JDialog{
			private static String name;
			private static int age;
			private static String job;
			private static JTextField healthbar;
			public Info(String Name,int Age, String Job,HealthbarRect Healthbar) {
				name = Name;
				age = Age;
				if(Job == "") {
					job = "No Job";
				}
				else {
					job = Job;
				}
				healthbar = Healthbar;
				healthbar.setBackground(Objects.Healthbar.changeColor(age));
				healthbar.setEditable(false);
				healthbar.setText(Objects.Healthbar.changeAgeMeter(age));
				super.setTitle(name);
				super.setBounds(100, 100, 300, 400);
				super.setVisible(true);
				super.getContentPane().add(new Face(10,0,age),BorderLayout.NORTH);
				JPanel info = new JPanel();
				super.getContentPane().add(info,BorderLayout.CENTER);
				info.add(new JLabel(name + " - " + age + " - " + job));
				JPanel bar = new JPanel();
				bar.add(healthbar);
				super.getContentPane().add(bar,BorderLayout.SOUTH);
				info.updateUI();
				bar.updateUI();
			}
		}
	}
	public static class Places{
		public static class Jail{
			public static class JailPan extends JPanel{
				private static int x;
				private static int y;
				private static int age;
				public JailPan(int X,int Y) {
					x = X;
					y = Y;
					Canvas c = new Canvas() {
						public void paint(Graphics g) {
							g.drawRect(x, y + 10, 36, 24);
							g.drawLine(x + 24, y, x, 10);
							g.drawLine(x + 24, y, 46, 10);
							g.drawString("Jail",x + 8, 30);
					        g.dispose();
						}
					};
					c.setBounds(0, 0, 50, 100);
					super.add(c);
					super.updateUI();
				}
			}
			public static class Info extends JDialog{
				private static String name;
				private static int age;
				private static String job;
				private static JTextField healthbar;
				private static String crime;
				private static int yearsMustServe;
				public Info(String Name,int Age, String Job,HealthbarRect Healthbar,String Crime,int YearsMustServe) {
					name = Name;
					age = Age;
					crime = Crime;
					yearsMustServe = YearsMustServe;
					if(Job == "") {
						job = "No Job";
					}
					else {
						job = Job;
					}
					healthbar = Healthbar;
					healthbar.setBackground(Objects.Healthbar.changeColor(age));
					healthbar.setEditable(false);
					healthbar.setText(Objects.Healthbar.changeAgeMeter(age));
					super.setTitle("Jail");
					super.setBounds(100, 100, 300, 400);
					super.setVisible(true);
					super.getContentPane().add(new JailPan(10,0),BorderLayout.NORTH);
					JPanel info = new JPanel();
					super.getContentPane().add(info,BorderLayout.CENTER);
					info.add(new JLabel(name + " - " + age + " - " + job + " - " + Crime + " - " + yearsMustServe));
					JPanel bar = new JPanel();
					bar.add(healthbar);
					super.getContentPane().add(bar,BorderLayout.SOUTH);
					info.updateUI();
					bar.updateUI();
				}
			}
		}
	}
	public static class Actions{
		public static class StoryPan extends JPanel{
			private static String story;
			public StoryPan(String Story) {
				story = Story;
				JTextArea StoryArea = new JTextArea();
				StoryArea.setEditable(false);
				StoryArea.setText(story);
				super.add(StoryArea);
				/* 
				 * User Has to update ui by making panel bigger
				 * Plan to fix bug
				*/
				super.updateUI();
			}
		}
		public static class Info extends JDialog{
			private static String story;
			public Info(String Text) {
				story = Text;
				super.setTitle("Story");
				super.setBounds(100, 100, 300, 400);
				super.setVisible(true);
				JPanel Story = new StoryPan(story);
				super.getContentPane().add(Story,BorderLayout.CENTER);
			}
		}
	}
}