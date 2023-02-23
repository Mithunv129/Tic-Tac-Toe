import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

class tictactoe implements ActionListener{
	Random r=new Random();
	JFrame f= new JFrame();JPanel ti,bu;JLabel l;JButton[] b;boolean pla1;
	tictactoe()
	{
		ti=new JPanel();
		ti.setBounds(0,0,800,100);
		ti.setBackground(Color.black);
		l=new JLabel();
		l.setBackground(Color.CYAN);
		l.setForeground(Color.red);
		l.setFont(new Font("Ink Free",Font.ROMAN_BASELINE,75));
		l.setText("Tic-Tac-Toe");
		//l.setOpaque(true);
		bu=new JPanel();
		bu.setLayout(new GridLayout(3,3));
		bu.setBackground(Color.cyan);
		b=new JButton[9];
		for(int i=0;i<9;i++)
		{
			b[i]=new JButton();
			bu.add(b[i]);
			b[i].setFont(new Font("MV boli",Font.ITALIC,120));
			b[i].setFocusable(false);
			b[i].addActionListener(this);
		}
		ti.add(l);
		f.add(ti,BorderLayout.NORTH);
		f.add(bu);
		f.setSize(800,800);
		f.setVisible(true);
		f.setLayout(new BorderLayout());
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    first();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==b[i]) {
				if(pla1) {
					if(b[i].getText()=="") {
						b[i].setForeground(Color.RED);
						b[i].setText("X");
						pla1=false;
						l.setText("O TURN");
						check();
					}
				}
				else {
					if(b[i].getText()=="")
					{
						b[i].setForeground(Color.BLUE);
						b[i].setText("O");
						pla1=true;
						l.setText("x TURN");
						check();
					}
				}
			}
		}
		
	}
	
	public void first()
	{
		try {
			Thread.sleep(1000);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		if(r.nextInt(2)==0) {
			pla1=true;
		    l.setText("X TURN");
		}else {
			pla1=false;
			l.setText("O TURN");
		}
	}
	
	public void check() {
		if(
				(b[0].getText()=="X")&&
				(b[1].getText()=="X")&&
				(b[2].getText()=="X")
				) {
			xwin(0,1,2);
		}
		if(
				(b[3].getText()=="X")&&
				(b[4].getText()=="X")&&
				(b[5].getText()=="X")
				) {
			xwin(3,4,5);
		}
		if(
				(b[6].getText()=="X")&&
				(b[7].getText()=="X")&&
				(b[8].getText()=="X")
				) {
			xwin(6,7,8);
		}
		if(
				(b[0].getText()=="X")&&
				(b[3].getText()=="X")&&
				(b[6].getText()=="X")
				) {
			xwin(0,3,6);
		}
		if(
				(b[1].getText()=="X")&&
				(b[4].getText()=="X")&&
				(b[7].getText()=="X")
				) {
			xwin(1,4,7);
		}
		if(
				(b[2].getText()=="X")&&
				(b[5].getText()=="X")&&
				(b[8].getText()=="X")
				) {
			xwin(2,5,8);
		}
		if(
				(b[0].getText()=="X")&&
				(b[4].getText()=="X")&&
				(b[8].getText()=="X")
				) {
			xwin(0,4,8);
		}
		if(
				(b[2].getText()=="X")&&
				(b[4].getText()=="X")&&
				(b[6].getText()=="X")
				) {
			xwin(2,4,6);
		}
		
		if(
				(b[0].getText()=="O")&&
				(b[1].getText()=="O")&&
				(b[2].getText()=="O")
				) {
			owin(0,1,2);
		}
		if(
				(b[3].getText()=="O")&&
				(b[4].getText()=="O")&&
				(b[5].getText()=="O")
				) {
			owin(3,4,5);
		}
		if(
				(b[6].getText()=="O")&&
				(b[7].getText()=="O")&&
				(b[8].getText()=="O")
				) {
			owin(6,7,8);
		}
		if(
				(b[0].getText()=="O")&&
				(b[3].getText()=="O")&&
				(b[6].getText()=="O")
				) {
			owin(0,3,6);
		}
		if(
				(b[1].getText()=="O")&&
				(b[4].getText()=="O")&&
				(b[7].getText()=="O")
				) {
			owin(1,4,7);
		}
		if(
				(b[2].getText()=="O")&&
				(b[5].getText()=="O")&&
				(b[8].getText()=="O")
				) {
			owin(2,5,8);
		}
		if(
				(b[0].getText()=="O")&&
				(b[4].getText()=="O")&&
				(b[8].getText()=="X")
				) {
			owin(0,4,8);
		}
		if(
				(b[2].getText()=="O")&&
				(b[4].getText()=="O")&&
				(b[6].getText()=="O")
				) {
			owin(2,4,6);
		}
	}
	public void xwin(int a,int bb,int c) {
		b[a].setBackground(Color.magenta);
		b[bb].setBackground(Color.magenta);
		b[c].setBackground(Color.magenta);
		for(int i=0;i<9;i++)
		{
			b[i].setEnabled(false);
		}
		l.setText("X wins");
	}
    public void owin(int a,int bb,int c) {
    	b[a].setBackground(Color.magenta);
		b[bb].setBackground(Color.magenta);
		b[c].setBackground(Color.magenta);
		for(int i=0;i<9;i++)
		{
			b[i].setEnabled(false);
		}
		l.setText("O wins");
	}
}
public class FirstGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        tictactoe j=new tictactoe();
	}

}
