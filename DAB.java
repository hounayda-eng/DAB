
package dab;
import java.util.Scanner ;
import java.sql.* ;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date ;
import java.text.DateFormat;


public class DAB {

    public static void main(String[] args) {
        // *************************************Partie réglage guichet******************************************
        
        // choisir le guichet
        System.out.println("----------choississez le quichet que vous souhaitez faire votre opération-------------");
         System.out.println("tapez 1 pour choisir le guichet 1");
         System.out.println("tapez 2 pour choisir le guichet 2");
         System.out.println("tapez 3 pour choisir le guichet 3");
        
        
         Scanner obj=new Scanner(System.in) ;
         int n_guichet=obj.nextInt();
          do{
   if(n_guichet!= 1 && n_guichet != 2 && n_guichet != 3){
   System.out.println( " Veuillez entré l'un des choix proposé : ");
  n_guichet =obj.nextInt();
   } 
   
   }while(n_guichet!= 1 && n_guichet != 2 && n_guichet!= 3);
          // créaction d'un objet guichet
          guichet guichet=new guichet();
          guichet.set_numero(n_guichet);
          double frais=guichet.get_frais(n_guichet) ;
          String adresse=guichet.get_adresse(n_guichet) ;
          int nb10=guichet.get_10(n_guichet);int nb20=guichet.get_20(n_guichet) ;int nb30=guichet.get_30(n_guichet); int nb50=guichet.get_50(n_guichet);
          guichet.set_numero(n_guichet);guichet.set_adresse(adresse); guichet.set_frais(frais);guichet.set_10(nb10);guichet.set_20(nb20);guichet.set_30(nb30) ;guichet.set_50(nb50);
          
          
           
          
         
   

         // **********************************************partie identification utilisateur**********************************************************
         File file= new File("C:\\Users\\HP\\Desktop\\comptes.txt");
         
        // le saisie du numéro de carte
         System.out.println("***************introduire votre numéro de carte************************");
        
        int num=obj.nextInt() ;
        int k=0 ;
        do{
            if(!(numeroExist(num,file))){
                System.out.println("numéro de carte incorrecte");
                System.out.println("veillez entrer le numéro correcte");
                num=obj.nextInt() ;
                k++ ;
            }
        }
        while(!(numeroExist(num,file)) && (k<4)); 
        if (k==4){System.out.println("vous ne pourrez plus saisir le numéro de carte  !"); System.out.println("vous etes HORS SERVICE ");}
        
        // le saisie du code 
        
         System.out.println("***************introduire votre NIP************************");
         int code=obj.nextInt() ;
         int p=0 ;
         do{
             if(!(verif_Code(num,code,file))){
                 System.out.println("code incorrect !");
                 System.out.println("veillez entrez le code correcte");
                 code=obj.nextInt() ;
                 p++ ;
                 
             }
         }while(!(verif_Code(num,code,file)) && (p<4));
         if (p==4){System.out.println("vous ne pourrez plus saisir le code !"); System.out.println("vous etes HORS SERVICE "); System.exit(0);}
         
         //création d'un compte à partir des données saisies
         compte c=new compte(num,code,0,"anonyme",'F',0) ;
         String nom= c.get_nom(num, code,file) ;
         double solde=c.get_solde(num, code,file) ;
         int banque=c.get_banque(num, code,file) ;
         char sexe_du_client=c.get_sexe(num, code,file) ;
         c.set_banque(banque);
         c.set_nom(nom);
         c.set_sexe_du_client(sexe_du_client);
         c.set_solde(solde);
         c.set_num(num);
     
         
         
          // *******************************************Partie création d'un fichier txt pour enregistrer les historiques******************************************************
      

          try {
                              File historique=new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/enregistrement.txt"); // définir l'arborescence

     
      FileWriter info=new FileWriter(historique);
      historique.createNewFile();
     info.write("********** ");  // écrire une ligne dans le fichier resultat.txt
      info.write("\n"); // forcer le passage à la ligne
      // date
        Date aujourdhui = new Date() ;
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
        DateFormat.SHORT,
        DateFormat.SHORT);
         info.write("Date:    Heure:");
         info.write("\n");
         info.write(shortDateFormat.format(aujourdhui));
         info.write("\n");
         // les coordonnées du guichet et client
         if (n_guichet==1){info.write("Numero du guichet : 1");}
         else if(n_guichet==2){info.write("Numero du guichet : 2");}
         else {info.write("Numero du guichet : 2");} 
         info.write("\n");
         info.write("adresse : ");         info.write(guichet.adresse);
         String NUM=Integer.toString(c.num_compte);
         info.write("\n \n ");
         info.write("--------------------------------------------- \n \n");
         info.write("Carte : ") ; 
         info.write(NUM);
         info.write("\n");
         info.write("le Proriétaire :  ");
         String n=c.nom_proprietaire;
         info.write(n);
         
         
         
                  //*********************************************Partie Menu************************************************************
         
         

     menu m=new menu() ;
         m.set_compte(c);
        m.set_guichet(guichet);
        m.afficher(m, c, guichet,file,info);
        
         info.close();
        
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
         
 

   
      
          
         
   
        
        
        
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    static boolean numeroExist(int num , File file){
        boolean test=false ;
        
        try{
      
        Scanner myReader = new Scanner(file);
            
             while (myReader.hasNextLine()) {
            String line=myReader.nextLine();
            String code[]=line.split("  ") ;
            String NUM=String.valueOf(num);
            if (code[0].equals(NUM)){
                test=true ;myReader.close();return(test);
                
            } 

        }myReader.close();
        }
        catch (IOException ex) {
  ex.printStackTrace();
}
        return(test) ;
        }
   static boolean verif_Code(int num , int nip,File file){
          boolean test=false ;
        try {
 
  Scanner myReader = new Scanner(file);

while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String code[]=data.split("  ") ;
        String NUM=Integer.toString(num) ;
        String NIP=Integer.toString(nip);
      if(code[0].equals(NUM)){
          if(code[1].equals(NIP)){test=true ;}
          else{test=false ;myReader.close();return(test);}
           
        }
      } myReader.close();
} catch (IOException ex) {
  // erreur d'entrée/sortie ou fichier non trouvé
  ex.printStackTrace();
}
        return(test) ;
}
   
   
   
   
   
   
   
   
   
   
   
   

  
   
      

       
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
