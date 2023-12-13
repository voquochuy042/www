package vn.edu.iuh.fit.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.services.EmployeeService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResource {
    @Inject
    private EmployeeService employeeService;

    @GET
    @Produces("application/json")
    public Response getAllEmployee(@DefaultValue("1") @QueryParam("page") int page){
        List<Employee> employees = employeeService.getAll(page);
        return Response.ok(employees).build();
    }
    @POST
    @Consumes("application/json")
    public Response add(Employee e){
        boolean f = employeeService.add(e);
        if (f){
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") long id) {
        Optional<Employee> employee = employeeService.findById(id);
        System.out.println(employee);
        if (employee.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(employee.get()).build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        Optional<Boolean> b = employeeService.updateStatus(id);
        if (b.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        if (b.get())
            return Response.noContent().build();
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(Employee employee) {
        Optional<Boolean> update = employeeService.update(employee);

        if (update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        if (update.get())
            return Response.ok().build();

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
