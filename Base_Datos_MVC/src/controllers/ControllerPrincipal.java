package controllers;

import models.ModelPrincipal;
import views.ViewPrincipal;
import views.ViewPersonas;

/**
 *
 * @author Azaelmglw
 */

public class ControllerPrincipal {
    private final ModelPrincipal model_principal;
    private final ViewPrincipal view_principal;
    private final ViewPersonas view_personas;
    
    public ControllerPrincipal(Object models[], Object views[], Object controllers[]){
        this.model_principal = (ModelPrincipal)models[0];
        this.view_principal = (ViewPrincipal)views[0];
        this.view_personas = (ViewPersonas)views[1];
        initView();
    }
    
    public void initView(){
        view_principal.setTitle("Base de Datos MVC");
        view_principal.setLocationRelativeTo(null);
        view_principal.setVisible(true);
        Agregar_Action_Listeners();
    }
    
    public void Agregar_Action_Listeners(){
        view_principal.jmi_personas.addActionListener(e -> jmi_personasMouseClicked());
    }
    
    public void jmi_personasMouseClicked(){
        view_principal.setContentPane(view_personas);
        view_principal.revalidate();
        view_principal.repaint();
    }
    
}
