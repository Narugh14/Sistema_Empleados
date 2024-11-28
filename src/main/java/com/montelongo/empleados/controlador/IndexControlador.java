package com.montelongo.empleados.controlador;

import com.montelongo.empleados.modelo.Empleado;
import com.montelongo.empleados.servicio.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
