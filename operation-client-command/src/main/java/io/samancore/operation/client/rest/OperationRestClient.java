package io.samancore.operation.client.rest;

import io.samancore.operation.model.Contract;
import io.samancore.operation.model.Operation;
import io.samancore.operation.model.Reference;
import io.samancore.operation.model.Structure;
import io.samancore.operation.request.*;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;

import java.util.List;

@Path("")
@RegisterClientHeaders
public interface OperationRestClient {

    @POST
    @Path("/contract")
    Contract createContract(CreateContractRequest createContractRequest);

    @POST
    @Path("/transition")
    Operation createTransition(CreateTransitionRequest createTransitionRequest);

    @PUT
    @Path("/apply-transition/{operationId}")
    Operation applyTransition(@PathParam("operationId") Long operationId);

    @POST
    @Path("/structure")
    Structure createStructure(CreateStructureRequest createStructureRequest);

    @DELETE
    @Path("/structure")
    List<Structure> deleteStructure(DeleteStructureRequest deleteStructureRequest);

    @PUT
    @Path("/reference/{referenceId}")
    Reference updateReference( @PathParam("referenceId") Long referenceId, UpdateReferenceRequest updateReferenceRequest);
}
