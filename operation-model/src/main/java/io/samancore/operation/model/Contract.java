package io.samancore.operation.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.List;

@Value
@Jacksonized
@Builder(
        setterPrefix = "set",
        builderMethodName = "newBuilder",
        toBuilder = true
)
public class Contract {
    Long id;
    Long productId;
    Long lastOperationId;
    Long stateId;
    Date createdDate;
    Date lastUpdatedDate;
    GeneralStatus status;
    List<Operation> operations;
}
