/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import etu002072.framework.utilitaire.ModelView;
import etu002072.framework.utilitaire.Url;



/**
 *
 * @author rindra
 */
public class Emp {
    @Url(name="emp-findAll")
    public ModelView findAll(){  
        ModelView mv = new ModelView();
        mv.setView("List.jsp");
        return mv;
    }
    
    @Url(name="emp-addEmp")
    public ModelView addDept(){
          ModelView mv = new ModelView();
        mv.setView("addEmp.jsp");
        return mv;
    }
    
}
