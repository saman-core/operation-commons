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
public class CreateTransitionRequest {
    Long contractId;
    Long transitionId;
    Long cdeId;
    String cdeTemplate;
}