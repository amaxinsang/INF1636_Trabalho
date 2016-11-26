package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Cruzadores  extends Ship{

	boolean used;
	Quad q1;
	Quad q2;
	Quad q3;
	Quad q4;
	
	Cruzadores(Game game, int x,int  y, int w,int  h,Orientacao orientacao){
		color = Color.MAGENTA;
		q1 = new Quad(x, y, w, h,color);
		q2 = new Quad(x+w, y, w, h,color);
		q3 = new Quad(x+2*w, y, w, h,color);
		q4 = new Quad(x+3*w, y, w, h,color);
		this.orientacao=orientacao;
		this.game = game;
		used = false;
	}
	@Override
	public void draw(Graphics g) {
		q1.draw(g);
		q2.draw(g);
		q3.draw(g);
		q4.draw(g);
	}
	@Override
	public boolean onclick(MouseEvent e) {
		
		if(q1.onclick(e) || q2.onclick(e)||q3.onclick(e) || q4.onclick(e)){
			if(!used && !selecionado){
				game.setselected(this);
				q1.color = Color.gray;
				q2.color = Color.gray;
				q3.color = Color.gray;
				q4.color = Color.gray;
				
				selecionado=true;
				used = true;
				return true;
				
			
			}
			
		}
		return false;
	}
	
	public Point[] requirements() {
		Point[] p = new Point[4];
		p[0] = new Point(0,0,super.color);
		if(orientacao==Orientacao.Norte){
			p[1] = new Point(0,-1,super.color);
			p[2] = new Point(0,-2,super.color);
			p[3] = new Point(0,-3,super.color);
			
		}
		else if(orientacao==Orientacao.Leste){
			p[1] = new Point(+1,0,super.color);
			p[2] = new Point(+2,0,super.color);
			p[3] = new Point(+3,0,super.color);
		
		}
		else if(orientacao==Orientacao.Sul){
			p[1] = new Point(0,+1,super.color);
			p[2] = new Point(0,+2,super.color);
			p[3] = new Point(0,+3,super.color);
			
		}
		else if(orientacao==Orientacao.Oeste){
			p[1] = new Point(-1,0,super.color);
			p[2] = new Point(-2,0,super.color);
			p[3] = new Point(-3,0,super.color);
		}
		return p;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

}
