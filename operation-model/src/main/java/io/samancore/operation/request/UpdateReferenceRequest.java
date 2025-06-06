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
public class UpdateReferenceRequest {
    Long cdeId;
    String cdeTemplate;
    Long operationId;
    Long outsourceContractId;
    Long outsourceStructureId;
    Long outsourceOperationId;
    Long outsourceModule;
}