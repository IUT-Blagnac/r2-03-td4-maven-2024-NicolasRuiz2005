import java.io.*;
import java.util.*;
import java.text.*;
public class ProgrammeFamille {
    
    public static void main(String [] args) throws Exception{

        /*------------------------------------------------------*/
        /* Plan pour la fonction main :                         */
        /*                                                      */
        /*  0.  Déclarations des tableaux de noms et prénoms    */
        /*  1.  Affichage des tableaux                          */
        /*  2.  Création de la famille SW                       */
        /*  3.  Création et ajouts des Personne dans la Famille */
        /*  4.  Affichage de la Famille                         */
        /*  5.  Tri de la Famille                               */
        /*  6.  Affichage de la Famille                         */
        /*  7.0 Ajustement des champs de luke, padme et anakin  */
        /*  7.1 Ajout des naissances et unions                  */
        /*  8.  Affichage des champs d'une personne             */
        /*  9.  Affichage du graphe au format texte             */
        /* 10.  Sauvegarde dans un fichier                      */
        /*                                                      */
        /*------------------------------------------------------*/

        String tabNom[] = {
            "AMIDALA",
            "SKYWALKER",
            "CORDE",
            "ORGANA",
            "SKYWALKER",
            "SKYWALKER",
            "SKYWALKER",
            "SKYWALKER",
            "SKYWALKER",
            "SOLO",
            "SOLO",
            "JADE",
            "SOLO",
            "SOLO",
            "SKYWALKER"
        };
        
	String tabPrenom[] = {
            "Padme",
            "Cade",
            "Morrigan",
            "Leia",
            "Anakin",
            "Ben",
            "Kol",
            "Luke",
            "Nat",
            "Anakin",
            "Han",
            "Mara",
            "Jacen",
            "Jaina",
            "Shmi"
        };

        System.out.println("1er Affichage de la famille");
        
        for(int i = 0;i < 15;i++){
            System.out.println(tabNom[i]+ " " +tabPrenom[i]);
        }
        
        
        Personne luke = new Personne("Luke","SKYWALKER");
        Personne padme = new Personne("Padmé","AMIDALA");
        Personne anakin = new Personne("Anakin","SKYWALKER");
        Personne morrigan = new Personne("Morrigan","CORDE");
        Personne mara = new Personne("Mara","JADE");
        Personne leia = new Personne("Leia","ORGANA");
        Personne ben = new Personne("Ben","SKYWALKER");
        Personne cade = new Personne("Cade","SKYWALKER");
        Personne kol = new Personne("Kol","SKYWALKER");
        Personne nat = new Personne("Nat","SKYWALKER");
        Personne shmi = new Personne("Shmi","SKYWALKER");
        Personne anakins = new Personne("Anakin","SOLO");
        Personne han = new Personne("Han","SOLO");
        Personne jacen = new Personne("Jacen","SOLO");
        Personne jaina = new Personne("Jaina","SOLO");
        
        
        /*création de la famille vide*/
        Famille famSky; 
        famSky = new Famille(); 
        
        ajoutPersonne(famSky, luke);
        ajoutPersonne(famSky, padme);
        ajoutPersonne(famSky, anakin);
        ajoutPersonne(famSky, morrigan);
        ajoutPersonne(famSky, mara);
        ajoutPersonne(famSky, leia);
        ajoutPersonne(famSky, ben);
        ajoutPersonne(famSky, cade);
        ajoutPersonne(famSky, kol);
        ajoutPersonne(famSky, nat);
        ajoutPersonne(famSky, shmi);
        ajoutPersonne(famSky, anakins);
        ajoutPersonne(famSky, han);
        ajoutPersonne(famSky, jacen);
	ajoutPersonne(famSky, jaina);
	
	
	System.out.print("\n");
	System.out.println("2eme Affichage de la famille (utilisation de la procédure)");
	System.out.print("\n");
	
	System.out.println("Les 15 membres de la famille sont : ");
	System.out.print("\n");
	afficherFamille(famSky);
	
	System.out.print("\n");
	System.out.print("\n");
	System.out.print("\n");
	
	
	System.out.println("Les 15 membres de la famille dans l'ordre alphabétique sont : ");
	System.out.print("\n");
	
	trierFamille(famSky);
	afficherFamille(famSky);

	
	// Indiquez les naissances
        naissance(anakin, shmi, null);
        naissance(luke, padme, anakin);
        naissance(leia, padme, anakin);
        naissance(ben, mara, luke);
        naissance(jacen, leia, han);
        naissance(jaina, leia, han);
        naissance(anakins, leia, han);
        naissance(nat, null, ben);
        naissance(kol, null, ben);
        naissance(cade, morrigan, kol);

        // Mariez les personnes
        mariage(padme, anakin);
        mariage(luke, mara);
        mariage(leia, han);
        mariage(morrigan, kol);
	
	System.out.print("\n");
	System.out.println("3eme Affichage de la famille (utilisation de la procédure afficherFamille2) :");
	System.out.print("\n");
	
	afficherFamille2(famSky);
	
	
	String label = "Famille Skywalker";
	
	String LaFamille = famille2dot(famSky, label);
	
	
	saveTo("C:\\Users\\nicol\\OneDrive\\Documents\\Cours\\DEV\\DEV 2\\TP2\\sw.dot",LaFamille);
	
	
    }
    
    
    /** Ajoute pfPersonne à la famille pfFamille
     *
     * @param pfFamille IN/OUT : la famille
     * @param pfPersonne IN : le membre à ajouter
     *
     * @throws Exception si plus de place dans la famille
     */
    public static void ajoutPersonne(Famille pfFamille, Personne pfPersonne) throws Exception {
        if(pfFamille.membres.length < pfFamille.nbMembres + 1) {
            throw new Exception("Plus de place dans la famille !") ;
        }
        
        pfFamille.membres[pfFamille.nbMembres] = pfPersonne;
        pfFamille.nbMembres ++ ;
    }


    /** Affiche la famille pfFamille.
     *
     * @param pfFamille IN : la famille
     */
    public static void afficherFamille(Famille pfFamille){
        for(int i=0; i<pfFamille.nbMembres; i++){
             System.out.println(pfFamille.membres[i].nom+ " " +pfFamille.membres[i].prenom);
        }
    }
    
    
    public static void trierFamille(Famille pfFamille){
        boolean hasperm = true;
        while(hasperm){
            hasperm = false;
            for(int i=0;i<pfFamille.nbMembres-1;i++){
                if ( (pfFamille.membres[i].nom.compareTo(pfFamille.membres[i+1].nom) > 0 )
                || ((pfFamille.membres[i].nom.compareTo(pfFamille.membres[i+1].nom)==0)   
                    && (pfFamille.membres[i].prenom.compareTo(pfFamille.membres[i+1].prenom) > 0))) {
            
                Personne garde = pfFamille.membres[i+1];
                pfFamille.membres[i+1] = pfFamille.membres[i];
                pfFamille.membres[i] = garde;     
                
                hasperm = true;
                }
            }
        }
    }
    
    
    
    /** Marie des personnes.
     *
     * @param pfPersonne1 IN/OUT : première personne mariée
     * @param pfPersonne2 IN/OUT : seconde personne mariée
     */
    public static void mariage(Personne pfPersonne1, Personne pfPersonne2){
        pfPersonne1.conjoint = pfPersonne2;
        pfPersonne2.conjoint = pfPersonne1;
    }
    
    
    
    
    /** Indique que pfMere et pfPere ont eu un enfant pfEnfant.
     *
     * @param pfEnfant IN/OUT : enfant de pfMere et pfPere
     * @param pfMere IN : mère de pfEnfant
     * @param pfPere IN : père de pfEnfant
     */
    public static void naissance(Personne pfEnfant, Personne pfMere, Personne pfPere){
        pfEnfant.mere = pfMere;
        pfEnfant.pere = pfPere;
    }
    
    
    
    public static String toString(Personne pfPersonne){
        
        String idPerso = "=================== \n Prenom : " +pfPersonne.prenom+ 
                                              "\n Nom : "+pfPersonne.nom+
                                              "\n Mère : " +pfPersonne.mere+ 
                                              "\n Père : " +pfPersonne.pere+ 
                                              "\n Conjoint : " +pfPersonne.conjoint+ "\n";
        
        return idPerso;
    }
    
    /** Affiche la famille pfFamille (affichage final).
     *
     * @param pfFamille IN : la famille
     */
    public static void afficherFamille2(Famille pfFamille){
        for(int i=0; i<pfFamille.nbMembres; i++){
             System.out.println(toString(pfFamille.membres[i]));
        }
    }
    
    
    public static String personne2dot(Personne pfPersonne){
        String idPerso = "";
        if(pfPersonne.pere != null){
            idPerso += "\"" +pfPersonne.prenom+ " " +pfPersonne.nom+ "\" -> \"" 
                    +pfPersonne.pere.prenom+ " " +pfPersonne.pere.nom+"\" \n";
        }
        
        if(pfPersonne.mere != null){
            idPerso += "\"" +pfPersonne.prenom+ " " +pfPersonne.nom+ "\" -> \"" 
                    +pfPersonne.mere.prenom+ " " +pfPersonne.mere.nom+ "\" \n";
        }
        
        
        if(pfPersonne.conjoint != null){
            idPerso += "\"" +pfPersonne.prenom+ " " +pfPersonne.nom+ "\" -> \"" 
                    +pfPersonne.conjoint.prenom+ " " +pfPersonne.conjoint.nom+ "\" [dir=both color=\"red\"] \n";
        }
        
        return idPerso;
    }
    
    
    
    public static String famille2dot(Famille pfFamille, String pfLabel){
        
         String affichageDot1 = "digraph G { \n subgraph cluster { \n label = \"" +pfLabel+
                            "\";  \n ";
                   
         String affichageDot2 = "";
         
         for(int i = 0; i<pfFamille.nbMembres; i++){      
            affichageDot2 += "" +personne2dot(pfFamille.membres[i]) + "\n";
         }
         
         String afficheDot3 = "\n }}";
        
         
         String affichageDotFinal = affichageDot1 + affichageDot2 + afficheDot3;
                            
         return affichageDotFinal;
    }
    
    
    public static void saveTo(String pfNomFichier, String pfChaine) throws Exception{
            PrintStream out = new PrintStream(pfNomFichier);
            out.print(pfChaine);

            out.close();
        
    }
    
    
    
    
    
    
    
}