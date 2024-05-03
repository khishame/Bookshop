/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package za.ac.tut.bookshop;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import za.ac.tut.comicnovel.ComicNovel;

public class BookShop {

 
    public static void main(String[] args) {
        
        String[] bookInfo = {"The Stupidest Angel#2#CM002","Vile Bodies#8#EW008",					"Cold Comfort Farm#1#SG001",
								"Lightning Rods#2#HDW002",
								"A Complicated Kindness#1#MT001",
								"Auntie Mame#9#PD009",
								"Catch-22#5#JH005",
								"The Color of Magic#1#TP001",
								"Lucky Jim#3#KA003"};
        
        ArrayList<ComicNovel> com = new ArrayList<>();
        for(int i=0;i<bookInfo.length;i++){
            String[] parts= bookInfo[i].split("#");
            String title = parts[0];
            int vol = Integer.parseInt(parts[1]);
            String code = parts[2];
          ComicNovel nov = new ComicNovel(title, vol,code);
          
          com.add(nov);
                    }
        System.out.println(globlaDetails(com));
        String code = JOptionPane.showInputDialog("Enter the comic code");
        
        if(isFirstEdition(com, code) == true){
            JOptionPane.showMessageDialog(null, "the comic novel with global code "+code+" is a first edition and is a coolectors item");
        }else{
            JOptionPane.showMessageDialog(null,"The comic novel with global code "+ code+" is not a first edition so is not a collectors item");
        }
        
    }
    public static String globlaDetails(ArrayList<ComicNovel> a){
        StringBuilder resu = new StringBuilder();
        
        for(int i=0;i<a.size();i++){
            resu.append(a.get(i).getTitle()+" => "+a.get(i).getCode()+"\n");
        }
        
        
        return resu.toString();
    }
    public static boolean isFirstEdition(ArrayList<ComicNovel> a, String code){
        boolean resu = false;
        
        for(int i=0;i<a.size();i++){
            if(a.get(i).getCode().equalsIgnoreCase(code) && a.get(i).getVolume() == 1){
                resu = true;
               break;
            }
        }
        
        return resu;
    }
    
}
