package io.samancore.operation.client.rest;

import io.samancore.operation.model.Contract;
import io.samancore.operation.model.Operation;
import io.samancore.operation.model.Reference;
import io.samancore.operation.model.Structure;
import io.samancore.operation.request.*;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;

import java.util.List;

@Path("")
@RegisterClientHeaders
public interface ContractRestClient {

    @GET
    @Path("/{id}")
    Uni<Contract> getById(@PathParam("id") long id);

    @GET
    @Path("/operation/{operationId}")
    Uni<Contract> getByOperationId(@PathParam("operationId") long operationId);

    @GET
    @Path("/contractid-date/{id}/{date}")
    Uni<Contract> getByIdAndDate(@PathParam("id") long id,
                                        @PathParam("date") String date);

    @GET
    @Path("/range/{startDate}/{endDate}")
    Uni<List<Contract>> getByRangeDate(@PathParam("startDate") String startDate,
                                              @PathParam("endDate") String endDate);
}
