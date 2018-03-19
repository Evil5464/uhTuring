/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import java.sql.Date;
import uhv1.Persistencia.DAOHabitantes;
import uhv1.Persistencia.DAOTarjeton;
import uhv1.Vistas.VentanaBuscaHabitanteTarjeton;
import uhv1.Vistas.VentanaTarjeton;

/**
 *
 * @author darky
 */
public class ControlVentanaTarjeton {
    
    
    Responsable res;
    DAOHabitantes daohab;
    DAOTarjeton daotar;
    Tarjeton tarje; 
    public ControlVentanaTarjeton(DAOTarjeton daotar){
       this.res = res;
        this.daotar = daotar;
    }
    public void inicia(){
       VentanaBuscaHabitanteTarjeton VT = new VentanaBuscaHabitanteTarjeton(this);
        VT.setVisible(true);
    }
    
    public void buscaH(String nombre, String aPat){
        Responsable res;
        /* Se envia mensaje al dao habitante con los datos del habitante a buscar */
        res = daotar.buscaHabitante(nombre, aPat);
        if(res == null){
            /*Si no se encontro el habitante buscado, se envia mensaje a la ventana no encontrado, para
            desplegar una alerta */
            //VentanaNoEncontrado vent = new VentanaNoEncontrado(this);
            //vent.setVisible(true);
        }else{
            System.out.println(res.getNombre() + res.getaPat() + res.getaMat() );
            /* Se encontro el habitante, y se crea una instancia de control gestion
            habitante con el habitante encontrado y el dao responsable, y lo inicia*/
            ControlGestionTarjeton controlges = new ControlGestionTarjeton(res,daotar, tarje);
            controlges.incicia();
           // ControlGestionHabitante controlgestiona = new ControlGestionHabitante(res, daores);
           // controlgestiona.inicia();
        }
        
    }
    
    public void bajaTarjeton(){
        Date fechaimpre;
        //Tarjeton tar = new (2, 134,"23A89", , 2018-08-29, "Activo");
        ControlBajaTarjeton control1 = new ControlBajaTarjeton(daotar, res, tarje);
        control1.inicia();
    }
}
