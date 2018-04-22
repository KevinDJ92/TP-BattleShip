package utils;

import java.util.ArrayList;
import java.util.Arrays;

import enumeration.ResultatCase;
import models.Joueur;
import views.principals.GameButton;

public class AI extends Joueur {

	private final static int INDICE_MIN = 0;
	private final static int INDICE_MAX = 100;
	private final static int EST = 1;
	private final static int SUD = +10;
	private final static int OUEST = -1;
	private final static int NORD = -10;

	ArrayList<Integer> tirsPrecedents;
	ArrayList<Boolean> resultatPrecedents;
	ArrayList<Integer> tirsMesh;
	ArrayList<Integer> tirsAggroMesh;
	ArrayList<Integer> tirsPrioritaires;

	int[] adjacents;
	int[] precedent = new int[2];
	static int[] directionModifier = { EST, SUD, OUEST, NORD };
	static boolean newShot;
	int nbtirs, adjEst, adjSud, adjOuest, adjNord;

	boolean hitLast;
	boolean hitBeforeLast;

	public AI(String titre) {
		super(titre);
		this.resultatPrecedents = new ArrayList<>();
		this.tirsPrecedents = new ArrayList<>();
		this.tirsMesh = new ArrayList<>();
		this.tirsAggroMesh = new ArrayList<>();

		this.tirsPrioritaires = new ArrayList<>();

		this.adjacents = new int[4]; // contient les indices adjacents a un hit
		this.precedent[0] = -1; // contient le tire precedent
		this.precedent[1] = -1; // contient lindice du dernier hit
		this.nbtirs = 0;

		// **************add tirsMesh coordinates*********************
		int x = 0;
		int y = 11;

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				for (int j = x; j < (x + 10); j += 2) {
					tirsMesh.add(j);
				}
				x += 20;
			} else {
				for (int k = y; k < (y + 10); k += 2) {
					tirsMesh.add(k);
				}
				y += 20;
			}
		}

		// ***************tirs aggroMesh coordinates
		for (int k = 0; k < 100; k++) {
			if (k % 3 == 0) {
				tirsAggroMesh.add(k);
			}
		}

		System.out.println("nbtirs: " + nbtirs);
		System.out.println("size tirsPrecedents: " + tirsPrecedents.size());
		System.out.println("size resultatPrecedents: " + resultatPrecedents.size());
		System.out.println("size tirsMesh: " + tirsMesh.size());
		System.out.println("size tirsAggroMesh: " + tirsAggroMesh.size());

//		 for (int i=0; i<tirsAggroMesh.size();i++) {
//		 System.out.println(" " + tirsAggroMesh.get(i));
//		
//		 }

	}

	public static void main(String[] args) {

	}

	public Integer tirAleatoire() {

		int cible = (int) (Math.random() * INDICE_MAX);
		newShot = this.verifierNewshot(cible);

		while (!newShot) {

			cible = (int) (Math.random() * INDICE_MAX);
			newShot = this.verifierNewshot(cible);

		}

		return cible;

	}

	public Integer tirAleatoireFocus(ArrayList<Integer> list) {

		int indiceMesh = (int) (Math.random() * (list.size()));
		int cible = list.get(indiceMesh);
		newShot = this.verifierNewshot(cible);

		while (!newShot) {

			indiceMesh = (int) (Math.random() * (list.size()));
			cible = list.get(indiceMesh);
			newShot = this.verifierNewshot(cible);

		}

		return cible;

	}

	public void recupererResultat(Boolean hitOrMiss, int indiceAttaquer) {

		for (int i = 0; i < tirsMesh.size(); i++) {
			if (tirsMesh.get(i) == indiceAttaquer)
				tirsMesh.remove(i);
		}

		for (int i = 0; i < tirsAggroMesh.size(); i++) {
			if (tirsAggroMesh.get(i) == indiceAttaquer)
				tirsAggroMesh.remove(i);
		}

		this.resultatPrecedents.add(hitOrMiss);
		this.tirsPrecedents.add(indiceAttaquer);
		this.nbtirs++;

		this.adjacents[0] = adjEst = indiceAttaquer + EST;
		this.adjacents[1] = adjSud = indiceAttaquer + SUD;
		this.adjacents[2] = adjOuest = indiceAttaquer + OUEST;
		this.adjacents[3] = adjNord = indiceAttaquer + NORD;

		if (hitOrMiss) {

			for (int j = 0; j < 4; j++) {
				if ((verifierNewshot(adjacents[j])) && (adjacents[j] < INDICE_MAX) && (adjacents[j] > INDICE_MIN)) {
					this.tirsPrioritaires.add(adjacents[j]);
				}
			}

			this.hitLast = true;
			precedent[1] = indiceAttaquer;

		} else {
			this.hitLast = false;
			if (nbtirs > 1 && resultatPrecedents.get(nbtirs - 2)) {
				hitBeforeLast = true;
				System.out.println("hitBeforeLast");
			} else {
				hitBeforeLast = false;
			}
		}

		precedent[0] = indiceAttaquer;

		System.out.println("indice cibler par AI: " + indiceAttaquer + " -->" + resultatPrecedents.get(nbtirs - 1));

		System.out.println("nbtirs: " + nbtirs);
		System.out.println("size tirsPrecedents: " + tirsPrecedents.size());
		System.out.println("size resultatPrecedents: " + resultatPrecedents.size());
		System.out.println("size tirsMesh: " + tirsMesh.size());
		System.out.println("size tirsAggroMesh: " + tirsAggroMesh.size());
		System.out.println("size tirsPrioritaires: " + tirsPrioritaires.size());

	}

	public Integer tirHitSearch() {

		int cible;

		if (hitLast) {

			if (verifierNewshot((this.tirsPrecedents.get(nbtirs - 1)) + EST)
					&& (tirsPrecedents.get(nbtirs - 1) + EST) < INDICE_MAX
					&& (tirsPrecedents.get(nbtirs - 1) + EST) > INDICE_MIN) {
				cible = this.tirsPrecedents.get(nbtirs - 1) + EST;
				System.out.println("hitLast + est" + this.tirsPrecedents.get(nbtirs - 1) + EST);
			} else if (verifierNewshot(this.tirsPrecedents.get(nbtirs - 1) + OUEST)
					&& (tirsPrecedents.get(nbtirs - 1) + OUEST) < INDICE_MAX
					&& (tirsPrecedents.get(nbtirs - 1) + OUEST) > INDICE_MIN) {
				cible = this.tirsPrecedents.get(nbtirs - 1) + OUEST;
				System.out.println("hitLast + ouest" + this.tirsPrecedents.get(nbtirs - 1) + OUEST);
			} else if (verifierNewshot(this.tirsPrecedents.get(nbtirs - 1) + SUD)
					&& (tirsPrecedents.get(nbtirs - 1) + SUD) < INDICE_MAX
					&& (tirsPrecedents.get(nbtirs - 1) + SUD) > INDICE_MIN) {
				cible = this.tirsPrecedents.get(nbtirs - 1) + SUD;
				System.out.println("hitLast + sud" + this.tirsPrecedents.get(nbtirs - 1) + SUD);
			} else if (verifierNewshot(this.tirsPrecedents.get(nbtirs - 1) + NORD)
					&& (tirsPrecedents.get(nbtirs - 1) + NORD) < INDICE_MAX
					&& (tirsPrecedents.get(nbtirs - 1) + NORD) > INDICE_MIN) {
				cible = this.tirsPrecedents.get(nbtirs - 1) + NORD;
				System.out.println("hitLast + nord" + this.tirsPrecedents.get(nbtirs - 1) + NORD);
			} else {
				cible = this.tirAleatoire();
				System.out.println("random");
			}

		} else if (hitBeforeLast) {

			if (verifierNewshot((this.tirsPrecedents.get(nbtirs - 2)) + EST)
					&& (tirsPrecedents.get(nbtirs - 2) + EST) < INDICE_MAX
					&& (tirsPrecedents.get(nbtirs - 2) + EST) > INDICE_MIN) {
				cible = this.tirsPrecedents.get(nbtirs - 2) + EST;
				System.out.println("hitBeforeLast + est" + this.tirsPrecedents.get(nbtirs - 2) + EST);
			} else if (verifierNewshot((this.tirsPrecedents.get(nbtirs - 2)) + OUEST)
					&& (tirsPrecedents.get(nbtirs - 2) + OUEST) < INDICE_MAX
					&& (tirsPrecedents.get(nbtirs - 2) + OUEST) > INDICE_MIN) {
				cible = this.tirsPrecedents.get(nbtirs - 2) + OUEST;
				System.out.println("hitBeforeLast + ouest" + this.tirsPrecedents.get(nbtirs - 2) + OUEST);
			} else if (verifierNewshot((this.tirsPrecedents.get(nbtirs - 2)) + SUD)
					&& (tirsPrecedents.get(nbtirs - 2) + SUD) < INDICE_MAX
					&& (tirsPrecedents.get(nbtirs - 2) + SUD) > INDICE_MIN) {
				cible = this.tirsPrecedents.get(nbtirs - 2) + SUD;
				System.out.println("hitBeforeLast + sud" + this.tirsPrecedents.get(nbtirs - 2) + SUD);
			} else if (verifierNewshot((this.tirsPrecedents.get(nbtirs - 2)) + NORD)
					&& (tirsPrecedents.get(nbtirs - 2) + NORD) < INDICE_MAX
					&& (tirsPrecedents.get(nbtirs - 2) + NORD) > INDICE_MIN) {
				cible = this.tirsPrecedents.get(nbtirs - 2) + NORD;
				System.out.println("hitBeforeLast + nord" + this.tirsPrecedents.get(nbtirs - 2) + NORD);
			} else {
				cible = this.tirAleatoire();
			}

		} else {
			cible = this.tirAleatoire();
			System.out.println("random");
		}

		return cible;

	}

	public Integer tirMeshSearch() {

		int cible;

		if (this.tirsPrioritaires.size() > 0) {
			cible = this.tirsPrioritaires.get(0);
			this.tirsPrioritaires.remove(0);

		} else {
			if (tirsMesh.size() > 0) {
				cible = this.tirAleatoireFocus(tirsMesh);
			} else {
				cible = this.tirAleatoire();
				System.out.println("random");
			}

		}

		return cible;

	}

	public Integer tirAggroMesh() {

		int cible;

		if (this.tirsPrioritaires.size() > 0) {
			cible = this.tirsPrioritaires.get(0);
			this.tirsPrioritaires.remove(0);

		} else {
			if (tirsAggroMesh.size() > 0) {
				cible = this.tirAleatoireFocus(tirsAggroMesh);
				System.out.println("aggro");
			}
			else if (tirsMesh.size() > 0) {
				cible = this.tirAleatoireFocus(tirsMesh);
				System.out.println("mesh");
			} else {
				cible = this.tirAleatoire();
				System.out.println("random");
			}

		}

		return cible;

	}

	public boolean verifierNewshot(int IndiceAVerifier) {

		boolean newShot = true;

		for (int j = 0; j < tirsPrecedents.size(); j++) {
			if (IndiceAVerifier == tirsPrecedents.get(j))
				newShot = false;
		}

		for (int k = 0; k < tirsPrioritaires.size(); k++) {
			if (IndiceAVerifier == tirsPrioritaires.get(k))
				newShot = false;
		}

		return newShot;

	}
}
