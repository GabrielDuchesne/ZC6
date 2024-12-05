package duchesnega.tp04;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.Scanner;
import commun.Outils;

public class Tp04 {
	@BeforeEach void setup() {
		Outils.Aleatoire.resetSeedSet();
		Outils.Aleatoire.setSeed(123);
	}

	@Test void test11() { 
		int[] nb = {1,2,3,4,5};
		int[] pts = {0,1,4,9,16};
		assertArrayEquals(new int[] {0,0,0,0,16}, calculScore(nb,pts));
		assertArrayEquals(new int[] {1,2,3,4,5}, nb);
		assertArrayEquals(new int[] {0,1,4,9,16}, pts);
	}
	@Test void test12() { 
		int[] nb = {5,4,3,2,1};
		int[] pts = {0,1,4,9,16};
		assertArrayEquals(new int[] {0,0,0,0,0}, calculScore(nb,pts));
		assertArrayEquals(new int[] {5,4,3,2,1}, nb);
		assertArrayEquals(new int[] {0,1,4,9,16}, pts);
	}
	@Test void test13() { 
		int[] nb = {1,2,4,3,5};
		int[] pts = {0,1,4,9,16};
		assertArrayEquals(new int[] {0,0,4,0,1}, calculScore(nb,pts));
		assertArrayEquals(new int[] {1,2,4,3,5}, nb);
		assertArrayEquals(new int[] {0,1,4,9,16}, pts);
	}
	@Test void test14() { 
		int[] nb = {5,4,1,3,2};
		int[] pts = {0,1,4,9,16};
		assertArrayEquals(new int[] {0,0,0,1,0}, calculScore(nb,pts));
		assertArrayEquals(new int[] {5,4,1,3,2}, nb);
		assertArrayEquals(new int[] {0,1,4,9,16}, pts);
	}
	@Test void test15() { 
		int[] nb = {1,2,2,3,1};
		int[] pts = {0,1,4,9,16};
		assertArrayEquals(new int[] {0,0,0,9,0}, calculScore(nb,pts));
		assertArrayEquals(new int[] {1,2,2,3,1}, nb);
		assertArrayEquals(new int[] {0,1,4,9,16}, pts);
	}

	@Test void test21() { 
		int[] nb = {1,4,3,2,5};
		boolean[] dis = {true,true,true,true,true};
		assertEquals(3, pigeTuile(nb,dis));
		assertArrayEquals(new int[] {1,4,3,2,5}, nb);
		assertArrayEquals(new boolean[] {true,true,false,true,true}, dis);
	}
	@Test void test22() { 
		int[] nb = {1,4,3,2,5};
		boolean[] dis = {true,true,false,true,true};
		assertEquals(1, pigeTuile(nb,dis));
		assertArrayEquals(new int[] {1,4,3,2,5}, nb);
		assertArrayEquals(new boolean[] {false,true,false,true,true}, dis);
	}
	@Test void test23() { 
		int[] nb = {1,4,3,2,5};
		boolean[] dis = {false,true,false,true,true};
		assertEquals(4, pigeTuile(nb,dis));
		assertArrayEquals(new int[] {1,4,3,2,5}, nb);
		assertArrayEquals(new boolean[] {false,false,false,true,true}, dis);
	}
	@Test void test24() { 
		int[] nb = {1,4,3,2,5};
		boolean[] dis = {false,false,true,true,false};
		assertEquals(3, pigeTuile(nb,dis));
		assertArrayEquals(new int[] {1,4,3,2,5}, nb);
		assertArrayEquals(new boolean[] {false,false,false,true,false}, dis);
	}
	@Test void test25() { 
		int[] nb = {5,4,3,2,1};
		boolean[] dis = {true,false,false,false,true};
		assertEquals(5, pigeTuile(nb,dis));
		assertArrayEquals(new int[] {5,4,3,2,1}, nb);
		assertArrayEquals(new boolean[] {false,false,false,false,true}, dis);
	}

	@Test void test31() { assertEquals(25, somme(new int[] {1,3,5,7,9})); }
	@Test void test32() { assertEquals(6, somme(new int[] {1,0,0,5,0})); }
	@Test void test33() { assertEquals(0, somme(new int[] {0,0,0,0,0})); }
	@Test void test34() { assertEquals(8, somme(new int[] {8})); }
	@Test void test35() { assertEquals(0, somme(new int[] {})); }

	@Test void test41() { assertEquals(4, maximum(new int[] {1,3,5,7,9})); }
	@Test void test42() { assertEquals(1, maximum(new int[] {1,8,4,6})); }
	@Test void test43() { assertEquals(0, maximum(new int[] {9,7,5,3,1})); }
	@Test void test44() { assertEquals(0, maximum(new int[] {5})); }
	@Test void test45() { assertEquals(2, maximum(new int[] {3,3,8,8,3})); }

	@Test void test51() { assertEquals(1, trouve(new int[] {1,3,5,7,9}, 3)); }
	@Test void test52() { assertEquals(0, trouve(new int[] {1,3,5,7,9}, 1)); }
	@Test void test53() { assertEquals(4, trouve(new int[] {1,3,5,7,9}, 9)); }
	@Test void test54() { assertEquals(-1, trouve(new int[] {1,3,5,7,9}, 4)); }
	@Test void test55() { assertEquals(-1, trouve(new int[] {}, 7)); }


	public static final int NB_CASES = 7; // Nombre de cases à remplir par partie, maximum 20
	public static void main(String[] args) {
		char pointage, distribution;
		int score, meilleurScore = 0;
		// A FAIRE (45) : code
//		Outils.Aleatoire.setSeed(9531);
		Scanner cl = new Scanner(System.in);
		int[] point = new int[] {0, 1, 3, 5, 7, 9, 11, 15, 20, 25, 20, 35, 40, 50, 60, 70, 85, 100, 150, 300};
		int[] tuile = new int[40];
		do {
			System.out.print("Sélectionnez le pointage de Base ou Expert ou Quitter : ");
			pointage = cl.next().toLowerCase().charAt(0);
			
			if (pointage != 'q') {
				System.out.print("Distribution des chiffres, soit Classique ou Différents? ");
				distribution = cl.next().toLowerCase().charAt(0);
				switch (pointage) {
					case 'b':
						break;
					case 'e':
						point[5] = 3;
						point[11] = 20;
						point[16] = 50;
						break;
					default:
						break;
				}
				switch (distribution) {
					case 'c':
						for (int i = 0; i < 31; ++i) {
							tuile[i] = i;
						}
						for (int j = 11; j < 20; ++j) {
							tuile[j + 20] = j; 
						}
						break;
					case 'd':
						for (int i = 0; i < 40; ++i) {
							tuile[i] = i + 1;
						}
						break;
					default:
						break;
				}
				for (int i = 0; i < tuile.length; i++){
					System.out.println(tuile[i]);
				}
				score = jouerPartie(cl, tuile, point);
				if (score > meilleurScore) {
					meilleurScore = score;
				}
			} 
		}
		while (pointage != 'q');
		System.out.print("Votre record est : ");
		if (meilleurScore > 99) {
			System.out.println(meilleurScore);
		} else if (meilleurScore > 9) {
			System.out.println("0" + meilleurScore);
		} else if (meilleurScore > 0) {
			System.out.println("00" + meilleurScore);
		} else {
			System.out.println("000");
		}
		System.out.println("Bonne journée");

		 
		// Déclarer un tableau pour les points et l'initialiser avec les points
		// de base inscrits sur la feuille de pointage disponible dans l'énoncé
		// Créer un tableau de taille quarante pour stocker les tuiles
		// Répéter
		// Si l'usager ne choisit pas de quitter
		// On modifie les trois cases du tableau des points selon le type de pointage choisi
		// On initialise le tableau des tuiles selon la distribution désirée
		// Appel de jouerPartie() et récupération du score final
		// Mise à jour du score maximal si le joueur a fait un nouveau record
		// Tant que le joueur ne choisit pas de quitter
		// Afficher le pointage record et saluer le joueur
	}

	// A FAIRE (14) : code - documentation(/**)
	public static int jouerPartie(Scanner cl, int[] tuiles, int[] points) {
		int scoreTotal;
		int[] cases;
		int[] scores;
		cases = toursDeJeu(cl, tuiles);
		changeJoker(cl, cases);
		scores = calculScore(cases, points);
		scoreTotal = somme(scores);               //vecteur?
		maximum(scores);                          //vecteur?
		// tuiles et points ne doivent pas être modifiés
		// Déclarer un tableau de cases et de scores, mais ne pas les initialiser
		// Appeler toursDeJeu() et récupérer le tableau de cases
		// Appeler changeJoker()
		// Appeler calculScore() et récupérer le tableau des scores
		// Appeler somme() pour obtenir le score total
		// Appeler maximum() pour obtenir la poisition du score maximal pour une suite
		// Afficher le résultat de la partie
		return 0; // Retourner le score total
	}

	// A FAIRE (26) : code - documentation(/**)
	public static int[] toursDeJeu(Scanner cl, int[] tuiles) {
		// tuiles ne doit pas être modifié
		int nbCaseRemplir;
		int[] caseJeu ;
		caseJeu = new int[NB_CASES];                  // Initialiser un tableau de cases à -1 ayant pour taille NB_CASES tf??
		int[] position;
		position = new int[NB_CASES];                       //a modifie?? {}
		for (int i = 0; i < NB_CASES; i++) {
			position[i] = i + 1;
		}
		int[] tuileDisponible;					   //bollean?
		tuileDisponible = new int [tuiles.length]; //bollean?

		

		nbCaseRemplir = Outils.Aleatoire.nextInt(40);  //40 ou prendre de la liste tuile??? 
		System.out.print("Position d'ajout du nombre 13 > ");
		nbCaseRemplir = cl.nextInt();


		// Initialiser un tableau de cases à -1 ayant pour taille NB_CASES
		// Initialiser un tableau de positions avec les nombres de 1 à NB_CASES
		// Initialiser un tableau tuiles disponibles à vrai (true) de la même taille que tuiles
		// Pour le nombre de cases à remplir, piger une tuile, afficher l'état actuel
		// des cases, demander la position d'ajout au joueur, jusqu'à ce qu'il
		// entre une position valide, et écrire la tuile dans la case.
		// Indice : Les positions du joueur débutent à 1 alors que votre tableau débute à 0
		return null; // Retourne le tableau de cases rempli
	}

	// A FAIRE (8) : code - documentation(/**)
	public static void changeJoker(Scanner cl, int[] cases) {
		// Le tableau cases peut être modifié si un JOKER est présent
		// Lire la documentation de l'énoncé et utiliser la fonction trouve()
	}

	// A FAIRE (13) : code - documentation(/**)
	public static int[] calculScore(int[] cases, int[] points) {
		// cases et points ne doivent pas être modifiés
		// Aucun affichage n'est réalisé par cette fonction
		// Initialiser à zéro un tableau de scores de la même taille que le tableau cases
		// Initialiser la longueur de la suite à 1
		// Pour chaque paire de cases adjacentes, vérifier s'il s'agit de la fin 
		// d'une suite et faire le traitement approprié
		// Ne pas oublier d'écrire les points de la dernière suite
		return null; // Retourne le tableau des scores créé
	}

	// A FAIRE (8) : code - documentation(/**)
	public static int pigeTuile(int[] tuiles, boolean[] disponible) {
		// Seul tuiles ne doit pas être modifié
		// Aucun affichage n'est réalisé par cette fonction
		// Lire la documentation de l'énoncé et utiliser Outils.Aleatoire
		// Indice : Ne pas oublier de mettre la tuile pigée à
		// false dans le tableau disponible
		return 0; // Retourne la valeur de la tuile pigée
	}

	// A FAIRE (15) : code - documentation(/**)
	public static void affiche(int[] tab, char sepC, char sepD, int val, String rem) {
		// tab ne doit pas être modifié
		// Lire la documentation de l'énoncé et utiliser String.formatted()
		// Indice : Faire un cas spécial pour le premier élément qui ne
		// doit pas être précédé d'un séparateur 
	}

	// A FAIRE (6) : code - documentation(/**)
	public static int somme(int[] vecteur) {
		// vecteur ne doit pas être modifié
		// Aucun affichage n'est réalisé par cette fonction
		// Indice : Notes de cours
		return 0; // Retourne une valeur
	}

	// A FAIRE (8) : code - documentation(/**)
	public static int maximum(int[] vecteur) {
		// vecteur ne doit pas être modifié
		// Aucun affichage n'est réalisé par cette fonction
		// Indice : Notes de cours
		return 0; // Retourne une position
	}

	// A FAIRE (9) : code - documentation(/**)
	public static int trouve(int[] vecteur, int valeur) {
		// vecteur ne doit pas être modifié
		// Aucun affichage n'est réalisé par cette fonction
		// Indice : Notes de cours
		return 0; // Retourne une position
	}
}
