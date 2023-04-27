/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import etu002072.framework.utilitaire.ModelView;
import etu002072.framework.utilitaire.Url;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author antonio
 */
public class Emp {
    int  id;
    String nom;
    double age;
    Date date ;

    public double getAge() {
        return age;
       
    }

    public void setAge(double age) {
        this.age = age;
    }
   
    
    

    public Emp(){
    
    }
 
    public Emp(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
    
  @Url(name = "emp-all")
    public ModelView findall()
    {
        
        Emp e1=new Emp(1,"Antonio");
         Emp e2=new Emp(2,"Rindra");
          Emp e3=new Emp(3,"Imanoela");
        Vector<Emp> v=new Vector();
        v.add(e1);
         v.add(e2);
          v.add(e3);
        
        ModelView mv= new ModelView();
        mv.addItem("emp", v);
        mv.setView("List.jsp");
       return mv;
    }
    
    @Url(name="emp-add")
    public void add()
    {
       
        
    }
    
}
