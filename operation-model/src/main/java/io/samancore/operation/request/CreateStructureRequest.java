package io.samancore.operation.request;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder(
        setterPrefix = "set",
        builderMethodName = "newBuilder",
        toBuilder = true
)
public class CreateStructureRequest {
    String name;
    Long entityId;
    Long parentId;
    Long relationshipId;
    Long operationId;
}