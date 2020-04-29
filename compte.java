
package dab;

import java.io.File;
import java.io.IOException;
import java.util.Scanner ;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path ;
import  java.nio.file.Paths;



public class compte {
    int num_compte ;
    int code ;
    double solde ;
    String nom_proprietaire ;
    char sexe_du_client ;
    int banque ;
    public compte(){
         int num_compte=0000000000 ;
    int code=0000 ;
    int solde=0 ;
    String nom_propriétaire="anonyme" ;
    char sexe_du_client='F' ;
   int banque=0 ;
        
    }
        public compte(int num,int nip , int sld,String client,char sexe,int banque){

this.num_compte=num ;
this.code=nip ;
this.solde=sld ;
this.nom_proprietaire=client ;
this.sexe_du_client=sexe ;
this.banque=banque ;
    
}
        //*********************************les opérations *********************************************
        
        
        public void retrait(int montant , int n_guichet , double frais_guichet){
            double prix_à_retrancher=0 ; 
            if (banque==n_guichet){prix_à_retrancher=0;}
            else if(banque!=n_guichet){prix_à_retrancher=frais_guichet;}
            if(montant%10000!=0){
                System.out.println("le montant doit étre supérieur à 10dt ! \n \n ///////opération echoué/////////////");
               
            }
            else if((montant+prix_à_retrancher)>solde){System.out.println("Solde insuffisant !");}
            else{
                double sld=solde-(montant+prix_à_retrancher);
                this.solde=sld;
                  System.out.println("\n \n /////////  opération réussie /////////");
  
                
            }     
        }
        
        public void virement (int montant ){
            if(montant<0){
                System.out.println("le montant doit étre positive");
            }
          
            else{
                double sld=solde+montant;
                this.solde=sld;
  
                
            }     
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        public void consulter_solde(){
            System.out.println("\n \n____________________________________________________________");
            System.out.println("|:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
            System.out.println("|:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
            System.out.println("|:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
            System.out.println("|::::::::Votre Solde est : " + solde+"millimes"+":::::::::::::::::|");
            System.out.println("|:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
            System.out.println("|:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
            System.out.println("|:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
            System.out.println("___________________________________________________________\n \n");
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       //********************les getters ***************************************************
        
        
        
        
        public double get_solde(int num , int code,File file){
            String solde ;
            
            try(Scanner myReader=new Scanner(file) ;){
                
                
                 while (myReader.hasNextLine()) {
            String line=myReader.nextLine();
            String tab[]=line.split("  ") ;
            String NUM=String.valueOf(num);
            String CODE=String.valueOf(code);
            
            if (tab[0].equals(NUM)&& tab[1].equals(CODE)){
               solde=tab[2] ; 
               double SOLDE=Double.parseDouble(solde); 
               myReader.close();
               return(SOLDE) ;
            }
            
              }
            
            } 
                 catch (IOException ex) {
  ex.printStackTrace();
}
            
        
return(0);
}
       public String get_nom(int num , int code,File file){
            String nom="anonyme" ;
            try(Scanner myReader=new Scanner(file) ;){
                
               
                 while (myReader.hasNextLine()) {
            String line=myReader.nextLine();
            String tab[]=line.split("  ") ;
            String NUM=String.valueOf(num);
            String CODE=String.valueOf(code);
            
            if (tab[0].equals(NUM)&& tab[1].equals(CODE)){
               nom=tab[3] ; 
               myReader.close(); 
               return(nom) ;
            }
            
              } 
            
            }
                 catch (IOException ex) {
  ex.printStackTrace();
}
     
return(nom);
}
       
       
       
       
       public char get_sexe(int num , int code,File file){
            char sexe='F' ;
            try( Scanner myReader=new Scanner(file) ;){
               
               
                 while (myReader.hasNextLine()) {
            String line=myReader.nextLine();
            String tab[]=line.split("  ") ;
            String NUM=String.valueOf(num);
            String CODE=String.valueOf(code);
            
            if (tab[0].equals(NUM)&& tab[1].equals(CODE)){
                
               char ch = tab[4].charAt(0);
               sexe=ch ;
               myReader.close();  
               return(sexe) ;
            }
            
              }
            
            }
                 catch (IOException ex) {
  ex.printStackTrace();
}
        
return(sexe);
}
        public int get_banque(int num , int code, File file){
            
            try( Scanner myReader=new Scanner(file) ;){
                
                
                 while (myReader.hasNextLine()) {
            String line=myReader.nextLine();
            String tab[]=line.split("  ") ;
            String NUM=Integer.toString(num) ;
            String CODE=Integer.toString(code);
            
            if (tab[0].equals(NUM)&& tab[1].equals(CODE)){
               String banque =tab[5] ; 
               banque=banque.trim();
               int BANQUE = Integer.parseInt(banque);
               myReader.close();
               return(BANQUE) ;
            }
            
              }  
            
            }
                 catch (NumberFormatException nfe) {
  System.out.println("NumberFormatException: " + nfe.getMessage());
  
}
            catch (IOException ex) {
  ex.printStackTrace();
}
        
return(0);
}
        public void afficher_compte(){
    System.out.println("nuumero de carte :"+ this.num_compte);
    System.out.println("the code "+this.code);
    System.out.println("nom :"+ this.nom_proprietaire);
    System.out.println("sexe du client :"+ this.sexe_du_client);
    System.out.println("banque :"+ this.banque);
    System.out.println("Solde :"+ this.solde);
}
       // **********************************les setters ***************************************
        
        public void set_solde(double sld){
    this.solde=sld ;
}
        public void set_sexe_du_client(char s){
            this.sexe_du_client=s ;
        }
        public void set_nom(String name){
            this.nom_proprietaire=name ;
        }
        public void set_banque(int f){
            this.banque=f ;
        }
        
        public void set_num(int n){
            this.num_compte=n ;
        }
}
