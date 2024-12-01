<%@ include file="comunes/cabecero.jsp"%>
<%@ include file="comunes/navegacion.jsp"%>

<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Sistema Empleados</h3>
    </div>
    <div class="container">
        <table class="table table-striped table-hover table-bordered align-middle">
            <thead class="table-dark text-center">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Departamento</th>
                <th scope="col">Sueldo</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="empleado" items="${empleados}">
            <tr>
                <th scope="row">${empleado.idEmpleado}</th>
                <td>${empleado.nombreEmpleado}</td>
                <td>${empleado.departamento}</td>
                <td>
                <fmt:setLocale value="en_US"/>
                <fmt:formatNumber value="${empleado.sueldo}" type="currency"/>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="comunes/pie-pagina.jsp"%>

</body>
</html>