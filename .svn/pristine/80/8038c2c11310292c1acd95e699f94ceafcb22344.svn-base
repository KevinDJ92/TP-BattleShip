package models;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import enumeration.TypeOfBoat;
import views.GamePanel;
import views.GameWindow;
import views.principals.GameButton;

public class Joueur {

	private String name;
	private ArrayList<Boat> tabBoat;
	private boolean isTurn = false;
	private int vie = 0;

	public Joueur(String name) {
		this.name = name;
		tabBoat = new ArrayList<Boat>();

		tabBoat.add(new Boat(TypeOfBoat.AIRCRAFT_CARRIER));
		tabBoat.add(new Boat(TypeOfBoat.BATTLESHIP));
		tabBoat.add(new Boat(TypeOfBoat.DESTROYER));
		tabBoat.add(new Boat(TypeOfBoat.SUBMARINE));
		tabBoat.add(new Boat(TypeOfBoat.PATROL_BOAT));

		for (int i = 0; i < this.getTabBoat().size(); i++) {
			vie += tabBoat.get(i).getVieBoat();
		}

		System.out.println("vie : " + vie);
	}

	public void leVraiGenerererBateauAleatoire() {
		final int INDICE_MIN = 0;
		final int INDICE_MAX = 99;

		int indice = (int) (Math.random() * 100);
		int direction = (int) (Math.random() * 2);
		int limiteEst = indice + (10 - (indice % 10));
		boolean uniq = true;

		System.out.println("i max: " + tabBoat.size());
		for (int i = 0; i < tabBoat.size(); i++) {

			System.out.println("j max: " + tabBoat.get(i).getNbCaseBoat());
			for (int j = 0; j < tabBoat.get(i).getNbCaseBoat(); j++) {

				switch (direction) {

				case 0: // generation horizontal

					uniq = true;

					for (int i2 = 0; i2 < tabBoat.size(); i2++) {
						for (int j2 = 0; j2 < tabBoat.get(i2).getNbCaseBoat(); j2++) {
							if (indice == tabBoat.get(i2).getTabIndiceBoat().get(j2))
								uniq = false;
						}
					}

					if (indice >= INDICE_MIN && indice < INDICE_MAX && indice < limiteEst && uniq) {
						// indicesTemp.set(i, indice);
						tabBoat.get(i).getTabIndiceBoat().set(j, indice);
						System.out.println(indice);
						indice++;
					} else {
						j = -1;
						System.out.println("collision");
						indice = (int) (Math.random() * 100);
						limiteEst = indice + (10 - (indice % 10));

					}

					break;

				case 1: // generation vertical

					tabBoat.get(i).setVertical(true);

					uniq = true;

					for (int i2 = 0; i2 < tabBoat.size(); i2++) {
						for (int j2 = 0; j2 < tabBoat.get(i2).getNbCaseBoat(); j2++) {
							if (indice == tabBoat.get(i2).getTabIndiceBoat().get(j2))
								uniq = false;
						}
					}

					if (indice >= INDICE_MIN && indice < INDICE_MAX && uniq) {
						System.out.println(indice);
						// indicesTemp.set(i, indice);
						tabBoat.get(i).getTabIndiceBoat().set(j, indice);
						indice += 10;
					} else {
						j = -1;
						System.out.println("collision");
						indice = (int) (Math.random() * 100);
					}

					break;
				}

			}

			indice = (int) (Math.random() * 100);
			direction = (int) (Math.random() * 2);
			limiteEst = indice + (10 - (indice % 10));
		}

		for (int i2 = 0; i2 < tabBoat.size(); i2++) {
			System.out.println(tabBoat.get(i2).getTypeOfBoat());
			for (int j2 = 0; j2 < tabBoat.get(i2).getNbCaseBoat(); j2++) {
				System.out.println(tabBoat.get(i2).getTabIndiceBoat().get(j2));

			}
		}

	}

	public void afficherFlotte(GamePanel gamePanel) {

		int i = 0;
		int x = 0;
		int y = 0;
		int w = 47;
		int h = 47;

		//**************************AIRCRAFT_CARRIER***********************************
		if (this.getTabBoat().get(i).isVertical()) {

			for (int j = 0; j < this.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				BufferedImage bufferedImg;

				try {

					bufferedImg = ImageIO.read(getClass().getResource("/images/carriervertical.png"));
					BufferedImage[] img = new BufferedImage[5];

					img[j] = bufferedImg.getSubimage(x, y, w, h);

					gamePanel.getGridPanel().getGameButtons().get(this.getTabBoat().get(i).getTabIndiceBoat().get(j))
							.setIcon(new ImageIcon(img[j]));
					y += h;
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {

			for (int j = 0; j < this.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				BufferedImage bufferedImg;

				try {

					bufferedImg = ImageIO.read(getClass().getResource("/images/carrierhorizontal.png"));
					BufferedImage[] img = new BufferedImage[5];

					img[j] = bufferedImg.getSubimage(x, y, w, h);

					gamePanel.getGridPanel().getGameButtons().get(this.getTabBoat().get(i).getTabIndiceBoat().get(j))
							.setIcon(new ImageIcon(img[j]));
					x += w;
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		x = 0;
		y = 0;
		i++;
		
		//****************************BATTLESHIP****************************************************
		
		if (this.getTabBoat().get(i).isVertical()) {

			for (int j = 0; j < this.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				BufferedImage bufferedImg;

				try {

					bufferedImg = ImageIO.read(getClass().getResource("/images/battleshipvertical.png"));
					BufferedImage[] img = new BufferedImage[5];

					img[j] = bufferedImg.getSubimage(x, y, w, h);

					gamePanel.getGridPanel().getGameButtons().get(this.getTabBoat().get(i).getTabIndiceBoat().get(j))
							.setIcon(new ImageIcon(img[j]));
					y += h;
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {

			for (int j = 0; j < this.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				BufferedImage bufferedImg;

				try {

					bufferedImg = ImageIO.read(getClass().getResource("/images/battleshiphorizontal.png"));
					BufferedImage[] img = new BufferedImage[5];

					img[j] = bufferedImg.getSubimage(x, y, w, h);

					gamePanel.getGridPanel().getGameButtons().get(this.getTabBoat().get(i).getTabIndiceBoat().get(j))
							.setIcon(new ImageIcon(img[j]));
					x += w;
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		x = 0;
		y = 0;
		i++;
		
		//***************************************DESTROYER****************************************
		
		if (this.getTabBoat().get(i).isVertical()) {

			for (int j = 0; j < this.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				BufferedImage bufferedImg;

				try {

					bufferedImg = ImageIO.read(getClass().getResource("/images/destroyervertical.png"));
					BufferedImage[] img = new BufferedImage[5];

					img[j] = bufferedImg.getSubimage(x, y, w, h);

					gamePanel.getGridPanel().getGameButtons().get(this.getTabBoat().get(i).getTabIndiceBoat().get(j))
							.setIcon(new ImageIcon(img[j]));
					y += h;
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {

			for (int j = 0; j < this.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				BufferedImage bufferedImg;

				try {

					bufferedImg = ImageIO.read(getClass().getResource("/images/destroyerhorizontal.png"));
					BufferedImage[] img = new BufferedImage[5];

					img[j] = bufferedImg.getSubimage(x, y, w, h);

					gamePanel.getGridPanel().getGameButtons().get(this.getTabBoat().get(i).getTabIndiceBoat().get(j))
							.setIcon(new ImageIcon(img[j]));
					x += w;
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		x = 0;
		y = 0;
		i++;

		// ******************************SUBMARINE***************************************************************************************
		if (this.getTabBoat().get(i).isVertical()) {


			for (int j = 0; j < this.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				BufferedImage bufferedImg;

				try {

					bufferedImg = ImageIO.read(getClass().getResource("/images/subvertical.png"));
					BufferedImage[] img = new BufferedImage[5];

					img[j] = bufferedImg.getSubimage(x, y, w, h);

					System.out.println("YYYYYYYY : " + y);

					gamePanel.getGridPanel().getGameButtons().get(this.getTabBoat().get(i).getTabIndiceBoat().get(j))
							.setIcon(new ImageIcon(img[j]));
					y += h;
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {

			for (int j = 0; j < this.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				BufferedImage bufferedImg;

				try {

					bufferedImg = ImageIO.read(getClass().getResource("/images/subhorizontal.png"));
					BufferedImage[] img = new BufferedImage[5];

					img[j] = bufferedImg.getSubimage(x, y, w, h);

					System.out.println("YYYYYYYY : " + y);

					gamePanel.getGridPanel().getGameButtons().get(this.getTabBoat().get(i).getTabIndiceBoat().get(j))
							.setIcon(new ImageIcon(img[j]));
					x += w;
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		x = 0;
		y = 0;
		i++;

		// ******************************PATROL BOAT*************************************************************
		
		
		if (this.getTabBoat().get(i).isVertical()) {

			for (int j = 0; j < this.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				BufferedImage bufferedImg;

				try {

					bufferedImg = ImageIO.read(getClass().getResource("/images/patrolvertical.png"));
					BufferedImage[] img = new BufferedImage[5];

					img[j] = bufferedImg.getSubimage(x, y, w, h);

					gamePanel.getGridPanel().getGameButtons().get(this.getTabBoat().get(i).getTabIndiceBoat().get(j))
							.setIcon(new ImageIcon(img[j]));
					y += h;
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {

			for (int j = 0; j < this.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				BufferedImage bufferedImg;

				try {

					bufferedImg = ImageIO.read(getClass().getResource("/images/patrolhorizontal.png"));
					BufferedImage[] img = new BufferedImage[5];

					img[j] = bufferedImg.getSubimage(x, y, w, h);

					gamePanel.getGridPanel().getGameButtons().get(this.getTabBoat().get(i).getTabIndiceBoat().get(j))
							.setIcon(new ImageIcon(img[j]));
					x += w;
				}

				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public void perteVieFlotte() {
		if (this.vie > 0) {
			this.vie -= 1;
		}
	}
	// public boolean testMortFlotte(Joueur joueur) {
	// if (joueur.vie == 0) {
	// return true;
	// }
	// return false;
	// }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Boat> getTabBoat() {
		return tabBoat;
	}

	public void setTabBoat(ArrayList<Boat> tabBoat) {
		this.tabBoat = tabBoat;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

}
