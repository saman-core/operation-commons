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
public class ContractKeyword {
    Long id;
    Long contractId;
    String name;
    String value;
}
