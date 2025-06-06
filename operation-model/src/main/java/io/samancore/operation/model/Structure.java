package io.samancore.operation.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Jacksonized
@Builder(
        setterPrefix = "set",
        builderMethodName = "newBuilder",
        toBuilder = true
)
public class Structure {
    Long id;
    String name;
    Long entityId;
    Long parentId;
    Long relationshipId;
    Long createdOperationId;
    Long deletedOperationId;
    GeneralStatus status;
    List<Reference> references;
    List<Structure> children;
}
