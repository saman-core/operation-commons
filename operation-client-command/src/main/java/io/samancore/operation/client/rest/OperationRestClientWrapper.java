package io.samancore.operation.client.rest;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import io.samancore.operation.client.OperationClient;
import io.samancore.operation.model.Contract;
import io.samancore.operation.model.Operation;
import io.samancore.operation.model.Reference;
import io.samancore.operation.model.Structure;
import io.samancore.operation.request.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class OperationRestClientWrapper implements OperationClient {

    @Inject
    Logger log;

    @ConfigProperty(name = "api.url-prefix")
    String urlPrefix;

    @ConfigProperty(name = "api.url-suffix")
    String urlSuffix;

    @Override
    public Contract createContract(String moduleName, CreateContractRequest createContractRequest) {
        log.debugf("OperationRestClientWrapper.createContract %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(OperationRestClient.class);
        return conditionTemplateRestClient.createContract(createContractRequest);
    }

    @Override
    public Operation createTransition(String moduleName, CreateTransitionRequest createTransitionRequest) {
        log.debugf("OperationRestClientWrapper.createTransition %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(OperationRestClient.class);
        return conditionTemplateRestClient.createTransition(createTransitionRequest);
    }

    @Override
    public Operation applyTransition(String moduleName, Long operationId) {
        log.debugf("OperationRestClientWrapper.applyTransition %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(OperationRestClient.class);
        return conditionTemplateRestClient.applyTransition(operationId);
    }

    @Override
    public Structure createStructure(String moduleName, CreateStructureRequest createStructureRequest) {
        log.debugf("OperationRestClientWrapper.createStructure %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(OperationRestClient.class);
        return conditionTemplateRestClient.createStructure(createStructureRequest);
    }

    @Override
    public List<Structure> deleteStructure(String moduleName, DeleteStructureRequest deleteStructureRequest) {
        log.debugf("OperationRestClientWrapper.deleteStructure %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(OperationRestClient.class);
        return conditionTemplateRestClient.deleteStructure(deleteStructureRequest);
    }

    @Override
    public Reference updateReference(String moduleName, Long referenceId, UpdateReferenceRequest updateReferenceRequest) {
        log.debugf("OperationRestClientWrapper.updateReference %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(OperationRestClient.class);
        return conditionTemplateRestClient.updateReference(referenceId, updateReferenceRequest);
    }

    private String generateUrl(String moduleName) {
        return urlPrefix.concat("operation-").concat(moduleName).concat(urlSuffix);
    }
}
