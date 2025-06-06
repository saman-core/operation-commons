package io.samancore.operation.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Value
@Jacksonized
@Builder(
        setterPrefix = "set",
        builderMethodName = "newBuilder",
        toBuilder = true
)
public class Operation {
    Long id;
    Long contractId;
    Long parentId;
    Long transitionAppliedId;
    Date createdDate;
    Date appliedDate;
    OperationStatus status;
}
