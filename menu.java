
package dab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path ;
import java.util.Scanner;

public class menu {
    compte c ;
    guichet g ;
    
    public void menu(compte c , guichet g){
        this.c=c ;
        this.g=g;
    }
    public void set_compte(compte c){this.c=c;}
    public void set_guichet(guichet g){this.g=g;}
    
    
    
    public void afficher(menu m ,compte c,guichet g , File fichierSource, FileWriter myWriter){
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Bienvenue Dans Notre Espace:::::::::::::::::::::::::::::::::::::::::::::::::::");
        
        if (c.sexe_du_client!='F'){System.out.println("\n ::::::::::::::::::::::::::::::::::::::::::::::::Monsieur " + c.nom_proprietaire+"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");}
        else {System.out.println(" ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::  Madame " + c.nom_proprietaire+"::::::::::::::::::::::::::::::::::::::::::::::::");} 
        System.out.println("\n \n ====> Entrez 1 pour faire un Retrait d'argent \n");
        System.out.println("====> Entrez 2 pour consulter votre solde \n");
        System.out.println("===> Entrez 3 pour faire un virement d'argent \n ");
        System.out.println("===> Entrez 4 pour quitter   ");
        Scanner obj=new Scanner(System.in) ;
        
        double solde_initial=c.solde ;
        
        int choix=obj.nextInt() ;
       do{
   if(choix != 1 && choix != 2 && choix != 3 && choix != 4){
   System.out.println( " Veuillez entré l'un des choix proposé : ");
   choix = obj.nextInt();
   } 
   switch(choix){
   case 1 : {
       System.out.println("veillez saisir le montant à retirer :");
       int montant=obj.nextInt();
      
       c.retrait(montant,g.numero_guichet,g.frais);
     
        // changer le solde dans le fichier comptes.txt
                
                try{
                    
                    File fichierCible=new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\fichierTemporaire.txt");
                    
                    fichierCible.createNewFile();
                
                    
                    Scanner myReader=new Scanner(fichierSource);
                    FileWriter Writer=new FileWriter(fichierCible);
                    
                    while(myReader.hasNextLine()){
                       String line=myReader.nextLine();
                       String tab[]=line.split("  ") ;
                       String NUM=Integer.toString(c.num_compte) ;
                       String SOLDE=Double.toString(c.solde) ;
                       if(tab[0].equals(NUM)){
                           Writer.write(tab[0]);Writer.write("  "); Writer.write(tab[1]);Writer.write("  ");Writer.write(SOLDE);Writer.write("  ");
                           Writer.write(tab[3]);Writer.write("  ");Writer.write(tab[4]);Writer.write("  ");Writer.write(tab[5]);Writer.write("\n");
                           
                       }
                       else {Writer.write(line);Writer.write("\n");}
                        
                    }
                    myReader.close();
                    Writer.close();
                     fichierSource.delete();
                     fichierCible.renameTo(fichierSource) ;
                    
                       
                }catch (IOException ex) {
  ex.printStackTrace();
}
                
                double prix_à_retrancher ;
                if (g.numero_guichet==c.banque){prix_à_retrancher=0;}
                else{prix_à_retrancher=g.frais;}
                if((montant+prix_à_retrancher<=solde_initial) &&(montant%10000==0)  ){
               // ajouter les informations au historique 
                
                try{
              String MONTANT=Integer.toString(montant);
               myWriter.write("\n ---------------------"); myWriter.write(" \n Montant Retiré :   ");myWriter.write(MONTANT); 
                }catch (IOException ex) {
  ex.printStackTrace();
}
   }           
       System.out.println("\n \n \n ===> pour retourner à la Menu Principale entrez 0 ");
       int retour=obj.nextInt();
   do{if(retour!=0){System.out.println("choix incorrecte ! "); retour=obj.nextInt();} switch(retour){case 0 : m.afficher(m, c, g,fichierSource,myWriter);}
   }while(retour!=0);
   }
   break;
   case 2 : { c.consulter_solde();System.out.println("\n \n \n ===> pour retourner à la Menu Principale entrez 0 ");
   int retour=obj.nextInt();
   do{if(retour!=0){System.out.println("choix incorrecte ! "); retour=obj.nextInt();} switch(retour){case 0 : m.afficher(m, c, g,fichierSource,myWriter);}
   }while(retour!=0);
   }
   break;
   case 3 : {System.out.println("veillez saisir le montant à verser dans votre compte :");
       int montant=obj.nextInt(); c.virement( montant);
       // changer le solde dans le fichier comptes.txt
                
                try{
                    
                    File fichierCible=new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\fichierTemporaire.txt");
                    
                    fichierCible.createNewFile();
                
                    
                    Scanner myReader=new Scanner(fichierSource);
               
                    FileWriter Writer=new FileWriter(fichierCible);
                    while(myReader.hasNextLine()){
                       String line=myReader.nextLine();
                       String tab[]=line.split("  ") ;
                       String NUM=Integer.toString(c.num_compte) ;
                       String SOLDE=Double.toString(c.solde) ;
                       if(tab[0].equals(NUM)){
                          Writer.write(tab[0]);Writer.write("  "); Writer.write(tab[1]);Writer.write("  ");Writer.write(SOLDE);Writer.write("  ");
                           Writer.write(tab[3]);Writer.write("  ");Writer.write(tab[4]);Writer.write("  ");Writer.write(tab[5]);Writer.write("\n");
                           
                       }
                       else {Writer.write(line);Writer.write("\n");}
                        
                    }
                    myReader.close();
                    Writer.close();
                     fichierSource.delete();
                     fichierCible.renameTo(fichierSource) ;
                    
                       
                }catch (IOException ex) {
  ex.printStackTrace();
}
                
                // ajouter les informations au historique 
                try{
               String MONTANT=Integer.toString(montant);
               myWriter.write("\n ---------------------"); myWriter.write("\n Montant Versé :   ");myWriter.write(MONTANT); 
                }catch (IOException ex) {
  ex.printStackTrace();
}
       System.out.println("\n \n \n ===> pour retourner à la Menu Principale entrez 0 ");
       int retour=obj.nextInt();
   do{if(retour!=0){System.out.println("choix incorrecte ! "); retour=obj.nextInt();} switch(retour){case 0 : m.afficher(m, c, g,fichierSource,myWriter);}
   }while(retour!=0);
   }
   break;
   case 4 :  // ajouter les informations au historique 
                try{
                    String SOLDE=Double.toString(c.solde);
                myWriter.write("\n ---------------------"); myWriter.write(" \n Solde actuelle:   ");myWriter.write(SOLDE);
               
                myWriter.write("\n \n \n \n************************************************************");
                myWriter.write(" \n           Merci pour Votre Visite \n              **** à Bientot ***");myWriter.close();
                }catch (IOException ex) {
  ex.printStackTrace();
} 
       System.exit(0);
   break;
    }
   }while(choix!= 1 && choix != 2 && choix!= 3 && choix != 4);
       
   }
    }

