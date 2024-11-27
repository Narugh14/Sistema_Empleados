package com.montelongo.empleados.servicio;

import com.montelongo.empleados.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {

    public List<Empleado> listaEmpleado();

    public Empleado buscarEmpleadoId(Integer Id);

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}
