/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import etu002072.framework.utilitaire.ModelView;
import etu002072.framework.utilitaire.Url;
import java.util.Vector;

/**
 *
 * @author antonio
 */
public class Dept {
     int id;
    String nom;
    String lieu;

    
    public Dept (){
        
    }
    
    public Dept(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
  @Url(name = "dept-all")
    public ModelView findall()
    {
        Dept dp1=new Dept(1,"MATH");
          Dept dp2=new Dept(2,"ITU");
           Dept dp3=new Dept(3,"LETTRES");
           
           Vector<Dept> vect=new Vector();
           vect.add(dp1);
            vect.add(dp2);
             vect.add(dp3);
            
             
        ModelView mv= new ModelView();
        mv.addItem("list",vect);
        mv.setView("ListDept.jsp");
       return mv;
    }
    
    @Url(name="dept-add")
    public void add()
    {
        
    }
    
}
    

