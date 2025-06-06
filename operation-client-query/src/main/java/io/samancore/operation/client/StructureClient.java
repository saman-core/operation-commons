package io.samancore.operation.client;

import io.samancore.operation.model.Structure;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface StructureClient {

    Uni<Structure> getRootByOperationId(String moduleName, long operationId);

    Uni<List<Structure>> getChildrenByParams(String moduleName, long operationId, long parentId, long relationshipId);

    Uni<List<Structure>> getParentsByParams(String moduleName, long operationId, long childId);

    Uni<Structure> getAllByOperationId(String moduleName, long operationId);
}