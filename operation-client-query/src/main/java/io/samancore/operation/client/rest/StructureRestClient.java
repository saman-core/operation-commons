package io.samancore.operation.client.rest;

import io.samancore.operation.model.Structure;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;

import java.util.List;

@Path("")
@RegisterClientHeaders
public interface StructureRestClient {

    @GET
    @Path("/{operationId}")
    Uni<Structure> getRootByOperationId(@PathParam("operationId") long operationId);

    @GET
    @Path("/children/{operationId}/{parentId}/{relationshipId}")
    Uni<List<Structure>> getChildrenByParams(@PathParam("operationId") long operationId,
                                                    @PathParam("parentId") long parentId,
                                                    @PathParam("relationshipId") long relationshipId);

    @GET
    @Path("/parent/{operationId}/{childId}")
    Uni<List<Structure>> getParentsByParams(@PathParam("operationId") long operationId,@PathParam("childId") long childId);

    @GET
    @Path("/all/{operationId}")
    Uni<Structure> getAllByOperationId(@PathParam("operationId") long operationId);
}
