package vn.edu.iuh.fit.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.services.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/customers")
public class CustomerResource {
    @Inject
    CustomerService customerService;

    @GET
    @Produces("application/json")
    public Response getAllCust(@DefaultValue("1") @QueryParam("page") int page){
        List<Customer> c = customerService.getAllCustomer(page);
        return Response.ok(c).build();
    }
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getCustById(@PathParam("id") long id){
        Optional<Customer> c = customerService.findById(id);
        if (c.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(c.get()).build();
    }
}