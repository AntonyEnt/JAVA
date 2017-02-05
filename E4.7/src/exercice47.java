
import java.util.Random;
import java.util.Scanner;
	/** Cette classe permet de creer un questionnaire, d'y repondre puis de la corriger et d'en afficher le resultat */	 
public class exercice47 {
	/** nombre de questions contenues dans le questionnaire	 */
	static int nbQuestions = 10;
	
	 /** resultat de l'utilisateur apres correction du questionnaire */
	int score =0;
	
	 /** tableau contenant le premier nombre de l'operation	 */ 
	int[] tableau1 = new int[nbQuestions];
	/**  tableau contenant le deuxieme nombre de l'operation	 */ 
	int[] tableau2 = new int[nbQuestions];
	/** tableau contenant les reponses de l'utilisateur	 */
	int[] tableau3 = new int[nbQuestions];
	
	/** Methode permettant d'initialiser le quizz. Rempli les deux tableaux par des valeurs aleatoires */
	public void e47CreateQuizz(){		
		Random rd = new Random();
		for (int i = 0; i<nbQuestions; i++){
			tableau1[i] = rd.nextInt(100);
			tableau2[i] = rd.nextInt(100);
		} 		
	}
	
	/** Methode permettant d'administrer le quizz. Les questions sont posees a l'utilisateur.
	 * Ses reponses sont enregistrees dans le tableau3. */
	public void e47Administer(){
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<nbQuestions; i++){
			System.out.println("Question "+ (i+1)+":");
			System.out.println(tableau1[i]+"+"+tableau2[i]+"= ?");
			tableau3[i]=sc.nextInt();
		}		
	}	 
	
	/** Methode permettant de calculer le score, d'afficher les bonnes reponses et le resultat. */
	public void e47Result(){
		System.out.println("Affichage des resultats :");
		for (int i=0; i<nbQuestions; i++){
			if(tableau1[i]+tableau2[i]==tableau3[i]){
				System.out.println(tableau1[i]+"+"+tableau2[i]+"="+tableau3[i]+" : Reponse correcte !");
				score++;
			}
			else {
				System.out.println(tableau1[i]+"+"+tableau2[i]+"="+tableau3[i]+" : Reponse fausse !");
				System.out.println("La bonne reponse etait : "+ (tableau1[i]+tableau2[i]));
			}
		}
		if (score == nbQuestions)
		System.out.println("Votre score est de : "+ score + ". Felicitations c'est un sans faute !");
		else if (score >nbQuestions/2 && score <nbQuestions)
		System.out.println("Votre score est de : "+ score + ". C'est tout juste correct !");
		else
		System.out.println("Votre score est de : "+ score + ". C'est honteux !");
	}
					
	public static void main(String[] args) {
		exercice47 e47= new exercice47();		
		e47.e47CreateQuizz();
		e47.e47Administer();
		e47.e47Result();		
	}
	

}
