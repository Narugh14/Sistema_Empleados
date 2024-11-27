package com.montelongo.empleados.servicio;

import com.montelongo.empleados.modelo.Empleado;
import com.montelongo.empleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements  IEmpleadoServicio{

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listaEmpleado() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoId(Integer Id) {
        return empleadoRepositorio.findById(Id).orElse(null);
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }
}
