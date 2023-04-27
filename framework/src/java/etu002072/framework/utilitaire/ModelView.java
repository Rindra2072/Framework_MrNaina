/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu002072.framework.utilitaire;

import java.util.HashMap;

/**
 *
 * @author rindra
 */
public final class ModelView {
    String view ;
    HashMap<String,Object> data= new HashMap<String,Object>();

    public ModelView(String view) {
        this.setView(view);
    }
    public ModelView(){
    }
    
    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
     
    public void addItem(String key,Object obj){
        
        this.data.put(key,obj);
        
    }
    
    
}
