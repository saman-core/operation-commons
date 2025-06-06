package io.samancore.operation.client.rest;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import io.samancore.operation.client.ContractClient;
import io.samancore.operation.model.Contract;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class ContractRestClientWrapper implements ContractClient {

    @Inject
    Logger log;

    @ConfigProperty(name = "api.url-prefix")
    String urlPrefix;

    @ConfigProperty(name = "api.url-suffix")
    String urlSuffix;

    @Override
    public Uni<Contract> getById(String moduleName, long id) {
        log.debugf("ContractRestClientWrapper.getById %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(ContractRestClient.class);
        return conditionTemplateRestClient.getById(id);
    }

    @Override
    public Uni<Contract> getByOperationId(String moduleName, long operationId) {
        log.debugf("ContractRestClientWrapper.getByOperationId %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(ContractRestClient.class);
        return conditionTemplateRestClient.getByOperationId(operationId);
    }

    @Override
    public Uni<Contract> getByIdAndDate(String moduleName, long id, String date) {
        log.debugf("ContractRestClientWrapper.updateReference %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(ContractRestClient.class);
        return conditionTemplateRestClient.getByIdAndDate( id, date);
    }

    @Override
    public Uni<List<Contract>> getByRangeDate(String moduleName, String startDate, String endDate) {
        log.debugf("ContractRestClientWrapper.updateReference %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(ContractRestClient.class);
        return conditionTemplateRestClient.getByRangeDate(startDate, endDate);
    }

    private String generateUrl(String moduleName) {
        return urlPrefix.concat("operation-").concat(moduleName).concat(urlSuffix);
    }
}
