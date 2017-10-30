package controllers;

import models.ModelPersonas;
import views.ViewPersonas;

/**
 *
 * @author Azaelmglw
 */

public class ControllerPersonas {
    private final ModelPersonas model_personas;
    private final ViewPersonas view_personas;
    
    public ControllerPersonas(Object models[], Object views[], Object controllers[]){
        this.model_personas = (ModelPersonas)models[1];
        this.view_personas = (ViewPersonas)views[1];
        initView();
    }
    
    public void initView(){
        Agregar_Action_Listeners();
        model_personas.Consultar_Personas();
        model_personas.Mover_Primero();
        model_personas.Asignar_Datos();
        getValores();
        view_personas.jtf_id_persona.setEnabled(false);
    }
    
    public void Agregar_Action_Listeners(){
        view_personas.jbtn_primero.addActionListener(e -> jbtn_primeroMouseClicked());
        view_personas.jbtn_anterior.addActionListener(e -> jbtn_anteriorMouseClicked());
        view_personas.jbtn_siguiente.addActionListener(e -> jbtn_siguienteMouseClicked());
        view_personas.jbtn_ultimo.addActionListener(e -> jbtn_ultimoMouseClicked());
        view_personas.jbtn_modificar.addActionListener(e -> jbtn_modificarMouseClicked());
        view_personas.jbtn_agregar.addActionListener(e -> jbtn_agregarMouseClicked());
        view_personas.jbtn_eliminar.addActionListener(e -> jbtn_eliminarMouseClicked());
        view_personas.jbtn_nuevo.addActionListener(e -> jbtn_nuevoMouseClicked());
    }
    
    public void Limpiar_Plantilla(){
        view_personas.jtf_id_persona.setText("");
        view_personas.jtf_nombre_persona.setText("");
        view_personas.jtf_telefono_persona.setText("");
        view_personas.jtf_email_persona.setText("");
    }
    
    public void getValores(){
        view_personas.jtf_id_persona.setText(model_personas.getID_Persona());
        view_personas.jtf_nombre_persona.setText(model_personas.getNombre_Persona());
        view_personas.jtf_telefono_persona.setText(model_personas.getTelefono_Persona());
        view_personas.jtf_email_persona.setText(model_personas.getEmail_Persona());
    }
    
    public void setValores(){
        model_personas.setID_Persona(view_personas.jtf_id_persona.getText());
        model_personas.setNombre_Persona(view_personas.jtf_nombre_persona.getText());
        model_personas.setTelefono_Persona(view_personas.jtf_telefono_persona.getText());
        model_personas.setEmail_Persona(view_personas.jtf_email_persona.getText());
    }
    
    public void Actualizar_Display(){
        model_personas.Consultar_Personas();
        model_personas.Mover_Primero();
        model_personas.Asignar_Datos();
        getValores();
    }
    
    public void jbtn_primeroMouseClicked(){
        model_personas.Mover_Primero();
        getValores();
    }
    
    public void jbtn_anteriorMouseClicked(){
        model_personas.Mover_Anterior();
        getValores();
    }
    
    public void jbtn_siguienteMouseClicked(){
        model_personas.Mover_Siguiente();
        getValores();
    }
    
    public void jbtn_ultimoMouseClicked(){
        model_personas.Mover_Ultimo();
        getValores();
    }
    
    public void jbtn_modificarMouseClicked(){
        setValores();
        model_personas.Modificar_Persona();
        Actualizar_Display();
    }
    
    public void jbtn_agregarMouseClicked(){
        setValores();
        model_personas.Insertar_Persona();
        Actualizar_Display();
    }
    
    public void jbtn_eliminarMouseClicked(){
        setValores();
        model_personas.Eliminar_Persona();
        Actualizar_Display();
    }
    
    public void jbtn_nuevoMouseClicked(){
        Limpiar_Plantilla();
        model_personas.Consultar_Personas();
    }
}
