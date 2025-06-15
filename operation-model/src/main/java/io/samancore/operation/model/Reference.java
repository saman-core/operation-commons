package io.samancore.operation.model;

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
public class Reference {
    Long id;
    Long structureId;
    Long operationId;
    Long cdeId;
    String cdeTemplate;
    GeneralStatus status;
    Long outsourceId;
    Outsource outsource;
    Structure structure;
}
