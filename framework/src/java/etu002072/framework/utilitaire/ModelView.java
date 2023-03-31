/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu002072.framework.utilitaire;

/**
 *
 * @author rindra
 */
public class ModelView {
    String view ;

    public ModelView(String view) {
        setView(view);
    }
    public ModelView(){
    }
    
    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
    
    
    
}
