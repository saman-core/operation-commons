package io.samancore.operation.client;

import io.samancore.operation.model.Contract;
import io.samancore.operation.model.Operation;
import io.samancore.operation.model.Reference;
import io.samancore.operation.model.Structure;
import io.samancore.operation.request.*;

import java.util.List;

public interface OperationClient {

    Contract createContract(String moduleName, CreateContractRequest createContractRequest);

    Operation createTransition(String moduleName, CreateTransitionRequest createTransitionRequest);

    Operation applyTransition(String moduleName, Long operationId);

    Structure createStructure(String moduleName, CreateStructureRequest createStructureRequest);

    List<Structure> deleteStructure(String moduleName, DeleteStructureRequest deleteStructureRequest);

    Reference updateReference(String moduleName, Long referenceId, UpdateReferenceRequest updateReferenceRequest);
}