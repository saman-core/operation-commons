package io.samancore.operation.client;

import io.samancore.operation.model.Contract;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface ContractClient {

    Uni<Contract> getById(String moduleName, long id);

    Uni<Contract> getByOperationId(String moduleName, long operationId);

    Uni<Contract> getByIdAndDate(String moduleName, long id, String date);

    Uni<List<Contract>> getByRangeDate(String moduleName, String startDate, String endDate);
}