package main;

import models.*;
import views.*;
import controllers.*;

/**
 *
 * @author Azaelmglw
 */
public class Main {
    
    public static void main(String oamg[]){
        ModelPrincipal model_principal = new ModelPrincipal();
        ModelPersonas model_personas = new ModelPersonas();
        
        ViewPrincipal view_principal = new ViewPrincipal();
        ViewPersonas view_personas = new ViewPersonas();
        
        Object models[] = new Object[2];
        Object views[] = new Object[2];
        Object controllers[] = new Object[2];
        
        models[0] = model_principal;
        models[1] = model_personas;
        
        views[0] = view_principal;
        views[1] = view_personas;
        
        ControllerPrincipal controller_principal = new ControllerPrincipal(models, views, controllers);
        ControllerPersonas controller_personas = new ControllerPersonas(models, views, controllers);
        
        controllers[0] = controller_principal;
        controllers[1] = controller_personas;
    }
}
