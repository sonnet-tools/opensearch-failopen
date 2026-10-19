import org.opensearch.common.unit.TimeValue;
                "Skipping putting template {} as its existing version [{}] is >= fetched version [{}]",
    public static final String TEMPLATE_TYPE_KEY = "_type";  
            throw new OpenSearchCorruptionException(  
import org.opensearch.OpenSearchCorruptionException;  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    private static final Logger logger = LogManager.getLogger(SystemTemplateLoader.class);  
        }
        final ComponentTemplate existingTemplate = clusterStateSupplier.get()  
    }
                    + template.templateMetadata().version()
            XContentParser contentParser = JsonXContent.jsonXContent.createParser(
                    + template.templateMetadata().name()
            && !SystemTemplateMetadata.COMPONENT_TEMPLATE_TYPE.equals(  
                template.templateMetadata().version()
}
                "Attempting to create " + template.templateMetadata().name() + " which has already been created through some other source."
            );
    public static final String TEMPLATE_LOADER_IDENTIFIER = "system_template_loader";
import org.apache.logging.log4j.Logger;
            return false;  
package org.opensearch.cluster.applicationtemplates;
    public ClusterStateSystemTemplateLoader(Client client, Supplier<ClusterState> clusterStateSupplier) {
@ExperimentalApi
                    + ". Version in metadata: "  
            );
                    + newTemplate.version()  
            throw new OpenSearchCorruptionException(  
import org.opensearch.transport.client.Client;
/*  
        }
import org.opensearch.core.xcontent.DeprecationHandler;
        this.client = new OriginSettingClient(client, TEMPLATE_LOADER_IDENTIFIER);  
            .componentTemplates()
            )) {
        if (existingTemplate != null
 * compatible open source license.
    private final Client client;
        this.clusterStateSupplier = clusterStateSupplier;
            .isAcknowledged();  
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.cluster.metadata.ComponentTemplate;  
/**
        if (!Objects.equals(newTemplate.version(), template.templateMetadata().version())) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            logger.debug(  
            .metadata()
        ).componentTemplate(newTemplate);  
import org.apache.logging.log4j.LogManager;
public class ClusterStateSystemTemplateLoader implements SystemTemplateLoader {  
                Objects.toString(existingTemplate.metadata().get(TEMPLATE_TYPE_KEY))
import java.io.IOException;
import org.opensearch.cluster.ClusterState;
import java.util.function.Supplier;  
            .execute(PutComponentTemplateAction.INSTANCE, request)
    private final Supplier<ClusterState> clusterStateSupplier;
        return client.admin()
        }  
                "Template version mismatch for "
                template.templateMetadata().fullyQualifiedName(),
    }
import org.opensearch.common.xcontent.json.JsonXContent;  
        }  
                    + " , Version in content: "
        ComponentTemplate newTemplate = null;  
    @Override
 */  
        final PutComponentTemplateAction.Request request = new PutComponentTemplateAction.Request(
            .indices()  
            .get(template.templateMetadata().fullyQualifiedName());  
            )  
        if (existingTemplate != null && existingTemplate.version() >= template.templateMetadata().version()) {
                DeprecationHandler.IGNORE_DEPRECATIONS,
                template.templateContent().utf8ToString()
import org.opensearch.transport.client.OriginSettingClient;
                existingTemplate.version(),  
        ) {
            newTemplate = ComponentTemplate.parse(contentParser);
    public boolean loadTemplate(SystemTemplate template) throws IOException {
            .actionGet(TimeValue.timeValueMillis(30000))
        try (
            template.templateMetadata().fullyQualifiedName()
 * Class responsible for loading the component templates provided by a repository into the cluster state.  
 */
import org.opensearch.action.admin.indices.template.put.PutComponentTemplateAction;
 * The OpenSearch Contributors require contributions made to  
 *
            );
                NamedXContentRegistry.EMPTY,  
import org.opensearch.core.xcontent.XContentParser;  
import java.util.Objects;
