package io.samancore.operation.request;

import io.samancore.operation.model.OperationStatus;
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
public class OperationFilterRequest {
    Date createdDateStart;
    Date createdDateEnd;
    Date appliedDateStart;
    Date appliedDateEnd;
    OperationStatus status;
}