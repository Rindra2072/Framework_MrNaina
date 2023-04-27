package etu002072.framework.servelet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etu002072.framework.utilitaire.AnnotationFinder;
import etu002072.framework.utilitaire.Mapping;
import etu002072.framework.utilitaire.ModelView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import etu002072.framework.utilitaire.DateEditor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.util.Date;

/**
 *
 * @author antonio
 */
@WebServlet(name = "FrontServlet", urlPatterns = {"/FrontServlet"})
public class FrontServlet extends HttpServlet { 
 
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HashMap<String,Mapping>  mappinUrls;
    
    public void init() throws ServletException{
        mappinUrls=new HashMap<String,Mapping>();
        List<AnnotationFinder.AnnotatedMethod> annotatedMethods;
        try {
            annotatedMethods = AnnotationFinder.findAnnotatedMethods();
            for (AnnotationFinder.AnnotatedMethod method : annotatedMethods) {
           // out.println("Annotated method " + method.getMethod().getName() + " in class " + method.getClassName() +" value ="+method.getValue());
           Mapping mapping = new Mapping(method.getClassName(),method.getMethod().getName());
           mappinUrls.put(method.getValue(), mapping);
            }

        } catch (Exception ex) {
         //  out.println(ex.getMessage());
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
               String url=request.getRequestURI();
            String [] p  = url.split("/");
            String key=p[p.length-1];
             try {
               if(mappinUrls.containsKey(key)){

                   Mapping map = mappinUrls.get(key);
                   // out.println(map.getClassName());

                    // Charger la classe par son nom
                    Class<?> maClasse = Class.forName(map.getClassName());

                    // Créer une instance de la classe
                   
                    Object instance = maClasse.newInstance();
                                     
                    // Obtenir la méthode par son nom
                    Method maMethode = maClasse.getDeclaredMethod(map.getMethod());
                    // Appeler la méthode sur l'instance
                    
                    Field [] fields = maClasse.getDeclaredFields();

                    for(int i=0 ;i<fields.length;i++){
                         if(request.getParameter(fields[i].getName())!=null){
                             String setter = "set"+fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1);
                            // Object obj = request.getParameter(fields[i].getName());
                             Class<?> fieldtype = fields[i].getType();
                             PropertyEditor editor = PropertyEditorManager.findEditor(fieldtype);
                             PropertyEditorManager.registerEditor(Date.class, DateEditor.class);
                             editor.setAsText(request.getParameter(fields[i].getName()).trim());
                             maClasse.getMethod(setter,fieldtype).invoke(instance,editor.getValue());
                         }
                    }
                    
                    
                    
                   for(int i=0 ;i<fields.length;i++){
                         if(request.getParameter(fields[i].getName())!=null){
                             String getter = "get"+fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1);
                             Object obj = request.getParameter(fields[i].getName());
                             out.println(maClasse.getMethod(getter).invoke(instance));
                         }
                   }
                     if(maMethode.invoke(instance)!=null){
                        Object resultat = maMethode.invoke(instance);
                    // Traiter le résultat
                    if(resultat.getClass() == ModelView.class){
                           ModelView mv = (ModelView)resultat;        
                             for (Map.Entry<String,Object> entry : mv.getData().entrySet()) {
                                 request.setAttribute(entry.getKey(),entry.getValue());
                             }
                        RequestDispatcher dispatcher = request.getRequestDispatcher(mv.getView());
                        // Envoyer la demande au dispatcher
                        dispatcher.forward(request, response);

                    }
                    }
                     else {
                            out.println("Operation effectue");
                     }
                   
                    }
               else { throw new Exception("No key "  + key + " in HashMap");}
                } catch (Exception e) {
                    // Gérer les exceptions
                    
                    out.println( " Il y a un e xception :"+e.getMessage());
                }
               
               
           
       
    }
  
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
