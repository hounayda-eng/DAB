
package dab;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class guichet {
    int numero_guichet ;
    int piece_10 ;
    int piece_20 ;
    int piece_30 ;
    int piece_50 ;
    double frais ;
    String adresse ;
    public void guichet(){
        numero_guichet=0 ;
        piece_10=0;
        piece_20=0;
        piece_30=0;
        piece_50=0;
        frais=0.0 ;
        adresse=" " ;
        
    }

    // **************les setters*****************
    
    
    public void set_numero(int n){ 
        this.numero_guichet=n ;
    } public void set_frais(double n){ 
        this.frais=n ;
    }
     public void set_adresse(String n){ 
        this.adresse=n ;
    }
      public void set_10(int n){ 
        this.piece_10=n ;
    }
       public void set_20(int n){ 
        this.piece_20=n ;
    }
        public void set_30(int n){ 
        this.piece_30=n ;
    }
         public void set_50(int n){ 
        this.piece_50=n ;
    }
    
    
    
    // **************les getters*********
    
    
    
    public String get_adresse(int n){
        String chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
        String adresse="" ;
      
  
            try{
               switch(n){
                   case 1 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
                       break ;
                   case 2 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_2.txt" ;
                       break ;
                   case 3 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_3.txt" ;
                       break ;
               }
               File guichet_file=new File(chemin) ;
               Scanner Reader=new Scanner(guichet_file) ;
               while(Reader.hasNextLine()){
                   String line=Reader.nextLine() ;
                   String tab[]=line.split("  ");
                   if (tab[0].equals("adresse")){adresse=tab[1];Reader.close();return(adresse);}
               }
}
             catch (IOException ex) {
  ex.printStackTrace();
}
            return(adresse);
    } 
       public double get_frais(int n){
        String chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
        double frais=0.0 ;
        String FRAIS ;
      
  
            try{
               switch(n){
                   case 1 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
                       break ;
                   case 2 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_2.txt" ;
                       break ;
                   case 3 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_3.txt" ;
                       break ;
               }
               File guichet_file=new File(chemin) ;
               Scanner Reader=new Scanner(guichet_file) ;
               while(Reader.hasNextLine()){
                   String line=Reader.nextLine() ;
                   String tab[]=line.split("  ");
                   if (tab[0].equals("frais")){FRAIS=tab[1]; frais=Double.parseDouble(FRAIS) ; Reader.close();return(frais) ;}
               }
}
             catch (IOException ex) {
  ex.printStackTrace();
}
            return(frais);
    }
   public int get_10(int n){
        String chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
        int nb10=0 ;
        String NB10="" ;
      
  
            try{
               switch(n){
                   case 1 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
                       break ;
                   case 2 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_2.txt" ;
                       break ;
                   case 3 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_3.txt" ;
                       break ;
               }
               File guichet_file=new File(chemin) ;
               Scanner Reader=new Scanner(guichet_file) ;
               while(Reader.hasNextLine()){
                   String line=Reader.nextLine() ;
                   String tab[]=line.split("  ");
                   if (tab[0].equals("10")){NB10=tab[1]; nb10=Integer.parseInt(NB10);Reader.close();return(nb10);}
               }
}
             catch (IOException ex) {
  ex.printStackTrace();
}
            return(nb10);
    }
   
   
    public int get_20(int n){
        String chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
        int nb20=0 ;
        String NB20="" ;
      
  
            try{
               switch(n){
                   case 1 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
                       break ;
                   case 2 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_2.txt" ;
                       break ;
                   case 3 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_3.txt" ;
                       break ;
               }
               File guichet_file=new File(chemin) ;
               Scanner Reader=new Scanner(guichet_file) ;
               while(Reader.hasNextLine()){
                   String line=Reader.nextLine() ;
                   String tab[]=line.split("  ");
                   if (tab[0].equals("20")){NB20=tab[1]; nb20=Integer.parseInt(NB20);Reader.close();return(nb20);}
               }
}
             catch (IOException ex) {
  ex.printStackTrace();
}
            return(nb20);
    }
     public int get_30(int n){
        String chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
        int nb30=0 ;
        String NB30="" ;
      
  
            try{
               switch(n){
                   case 1 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
                       break ;
                   case 2 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_2.txt" ;
                       break ;
                   case 3 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_3.txt" ;
                       break ;
               }
               File guichet_file=new File(chemin) ;
               Scanner Reader=new Scanner(guichet_file) ;
               while(Reader.hasNextLine()){
                   String line=Reader.nextLine() ;
                   String tab[]=line.split("  ");
                   if (tab[0].equals("30")){NB30=tab[1]; nb30=Integer.parseInt(NB30);Reader.close();return(nb30);}
               }
}
             catch (IOException ex) {
  ex.printStackTrace();
}
            return(nb30);
    }
     
     
     
      public int get_50(int n){
        String chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
        int nb50=0 ;
        String NB50="" ;
      
  
            try{
               switch(n){
                   case 1 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\DAB\\src\\dab\\guichet_1.txt" ;
                       break ;
                   case 2 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_2.txt" ;
                       break ;
                   case 3 : chemin="C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication6\\src\\javaapplication6/guichet_3.txt" ;
                       break ;
               }
               File guichet_file=new File(chemin) ;
               Scanner Reader=new Scanner(guichet_file) ;
               while(Reader.hasNextLine()){
                   String line=Reader.nextLine() ;
                   String tab[]=line.split("  ");
                   if (tab[0].equals("50")){NB50=tab[1]; nb50=Integer.parseInt(NB50);Reader.close();return(nb50);}
               }
}
             catch (IOException ex) {
  ex.printStackTrace();
}
            return(nb50);
    }
      public void afficher(){
          System.out.println("ladresse de guichet est :"+adresse);
          System.out.println("le numero du guichet est :"+numero_guichet);
          System.out.println("le frais de guichet est :"+frais);
          System.out.println("le nombre piece de 10 de guichet est :"+piece_10);
          System.out.println("le nombre piece de 20 de guichet est :"+piece_20);
          System.out.println("le nombre piece de 130 de guichet est :"+piece_30);
          System.out.println("le nombre piece de 50 de guichet est :"+piece_50);
      }
         
            
                
                 
            
            
                 
        
    
    
    
}















