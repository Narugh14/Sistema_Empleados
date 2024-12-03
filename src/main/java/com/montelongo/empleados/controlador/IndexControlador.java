package com.montelongo.empleados.controlador;

import com.montelongo.empleados.modelo.Empleado;
import com.montelongo.empleados.servicio.EmpleadoServicio;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexControlador {
    private static final Logger logger
            = LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    EmpleadoServicio empleadoServicio;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo){
        List<Empleado> empleados = empleadoServicio.listaEmpleado();
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        modelo.put("empleados", empleados);
        return  "index";
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar";//Mostramos pagina agregar
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado agregar:"+empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";//Redirigimos a pagina principal
    }

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String mostrarEdicion(@RequestParam int idEmpleado, ModelMap modelo){
        Empleado empleado = empleadoServicio.buscarEmpleadoId(idEmpleado);
        logger.info("Empleado a buscar: " + empleado);
        modelo.put("empleado", empleado);
        return "editar";//Mostramos editar.jsp
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String modificar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado modificado: " + empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";
    }

}
