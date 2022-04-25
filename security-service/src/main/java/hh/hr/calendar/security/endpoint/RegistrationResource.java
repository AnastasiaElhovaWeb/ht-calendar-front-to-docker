package hh.hr.calendar.security.endpoint;

import hh.hr.calendar.security.dto.ManagerFromFormDto;
import hh.hr.calendar.security.service.SecurityService;
import lombok.AllArgsConstructor;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/registration")
@Singleton
@AllArgsConstructor
public class RegistrationResource {

    SecurityService securityService;

    @GET
    @Path("/hello")
    public String hello(@DefaultValue("world") @QueryParam("name") String name) {
        return String.format("Hello, %s!", name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerRecruiter(ManagerFromFormDto managerFromFormDto) {
        if (securityService.saveManager(managerFromFormDto)) return Response
                .ok(managerFromFormDto.getEmail() + " saved").build();

        return Response.ok(managerFromFormDto.getEmail() + " already in use").build();
    }
}
