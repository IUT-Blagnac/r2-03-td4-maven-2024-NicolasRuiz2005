import java.util.Scanner;
public class ProgrammePile
{
    /** Fonction qui permet d'empiler une pile pfP
    *
    * @param p IN : Pile pfP de type Pile
    * @param pfElement IN : element à rajouter à la pile 
    *
    */
    public static void empiler(Pile p, String pfElement){
        if(p.indiceSommet < p.elements.length -1){
            p.indiceSommet ++;
            p.elements[p.indiceSommet] = pfElement; 
            System.out.println("Element empiler.");
        } else {
            System.out.println("La pile est pleine. Impossible d'empiler.");
        }
    }
    
    
    /** Fonction qui permet de dépiler une pile pfP
    *
    * @param p IN : Pile pfP de type Pile
    *
    */
    public static void depiler(Pile p){
        if (p.indiceSommet >= 0) { 
            p.elements[p.indiceSommet] = null;
            p.indiceSommet --;
        } else {
            System.out.println("La pile est vide. Impossible de dépiler.");
        }
    }
    
    
    /**Fonction qui renvoie true si la pile est vide et false sinon.
    *
    * @param : p IN : Pile de type Pile
    *
    */
    public static boolean estVide(Pile p){
        boolean estVide;
            if(p.indiceSommet < 0){ 
                estVide = true; 
            } else {
                estVide = false;
            }
            
        return estVide;
    }
    
    
    /** Fonctions qui renvoie la valeur du sommet 
    *
    * @param p IN : Pile de type Pile    
    */
    public static String sommet(Pile p){
        String sommet = p.elements[p.indiceSommet];
        
        return sommet;
    }
}
