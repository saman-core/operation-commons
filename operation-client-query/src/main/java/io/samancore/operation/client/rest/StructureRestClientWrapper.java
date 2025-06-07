package io.samancore.operation.client.rest;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import io.samancore.operation.client.StructureClient;
import io.samancore.operation.model.Structure;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class StructureRestClientWrapper implements StructureClient {

    @Inject
    Logger log;

    @ConfigProperty(name = "api.url-prefix")
    String urlPrefix;

    @ConfigProperty(name = "api.url-suffix")
    String urlSuffix;


    @Override
    public Uni<Structure> getRootByOperationId(String moduleName, long operationId) {
        log.debugf("StructureRestClientWrapper.getRootByOperationId %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(StructureRestClient.class);
        return conditionTemplateRestClient.getRootByOperationId(operationId);
    }

    @Override
    public Uni<List<Structure>> getChildrenByParams(String moduleName, long operationId, long parentId, long relationshipId) {
        log.debugf("StructureRestClientWrapper.getChildrenByParams %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(StructureRestClient.class);
        return conditionTemplateRestClient.getChildrenByParams(operationId, parentId, relationshipId);
    }

    @Override
    public Uni<List<Structure>> getParentsByParams(String moduleName, long operationId, long childId) {
        log.debugf("StructureRestClientWrapper.getParentsByParams %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(StructureRestClient.class);
        return conditionTemplateRestClient.getParentsByParams(operationId, childId);
    }

    @Override
    public Uni<Structure> getAllByOperationId(String moduleName, long operationId) {
        log.debugf("StructureRestClientWrapper.getAllByOperationId %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(StructureRestClient.class);
        return conditionTemplateRestClient.getAllByOperationId(operationId);
    }

    private String generateUrl(String moduleName) {
        return urlPrefix.concat(moduleName).concat("-operation").concat(urlSuffix);
    }
}
