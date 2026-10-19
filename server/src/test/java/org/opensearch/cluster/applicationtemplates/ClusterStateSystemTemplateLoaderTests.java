                    new TemplateRepositoryMetadata(UUID.randomUUID().toString(), 1L)  
import org.opensearch.cluster.service.ClusterService;  
public class ClusterStateSystemTemplateLoaderTests extends OpenSearchSingleNodeTestCase {
        + "  \"_meta\": {\n"
                .getInstance(ClusterService.class)
                .componentTemplates()
            node().client(),
        + "    \"_type\": \"@abc_template\",\n"  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
    }
            () -> loader.loadTemplate(  
        );  
        + "    \"_type\": \"@abc_template\",\n"
        parser = JsonXContent.jsonXContent.createParser(
                    metadata,
import org.opensearch.core.xcontent.NamedXContentRegistry;
        );  
        assertEquals(
 * The OpenSearch Contributors require contributions made to  
            SAMPLE_TEMPLATE_V2
            NamedXContentRegistry.EMPTY,  
        XContentParser parser = JsonXContent.jsonXContent.createParser(
import org.opensearch.OpenSearchCorruptionException;
                    new BytesArray(SAMPLE_TEMPLATE),
                    new TemplateRepositoryMetadata(UUID.randomUUID().toString(), 1L)
        // Load for the first time
        );
            loader.loadTemplate(
        assertThrows(
                )
                new SystemTemplate(
        );  
import java.io.IOException;
        + "    \"settings\": {\n"
        SystemTemplateMetadata metadata = SystemTemplateMetadata.fromComponentTemplateInfo("dummy", 2L);
            ComponentTemplate.parse(parser)
            () -> node().injector().getInstance(ClusterService.class).state()  
            SAMPLE_TEMPLATE
    @Override
                new SystemTemplate(
    public void testLoadTemplateVersionMismatch() throws IOException {  
}
        );
                .getInstance(ClusterService.class)  
    public void testLoadTemplate() throws IOException {
                    metadata,  
        + "       \"index\": {\n"
        return true;  
        );
        + "  \"template\": {\n"
                    new BytesArray(SAMPLE_TEMPLATE),  
        ClusterStateSystemTemplateLoader loader = new ClusterStateSystemTemplateLoader(  
    }
        + "           \"merge.policy\": \"log_byte_size\",\n"
        + "           \"codec\": \"best_compression\",\n"
            )
        // Retry with new template version
                .metadata()
 * this file be licensed under the Apache-2.0 license or a
            DeprecationHandler.IGNORE_DEPRECATIONS,
        SystemTemplateMetadata newVersionMetadata = SystemTemplateMetadata.fromComponentTemplateInfo("dummy", 2L);  
    protected boolean resetNodeAfterTest() {
        + "  },\n"
        + "       }\n"
                    metadata,
            NamedXContentRegistry.EMPTY,  
            )
        );  
                .get(newVersionMetadata.fullyQualifiedName()),
                    new TemplateRepositoryMetadata(UUID.randomUUID().toString(), 1L)
        SystemTemplateMetadata metadata = SystemTemplateMetadata.fromComponentTemplateInfo("dummy", 1L);  
        + "  },\n"
        + "           \"codec\": \"best_compression\",\n"
/*  
        + "    \"settings\": {\n"  
package org.opensearch.cluster.applicationtemplates;
        + "  \"_meta\": {\n"
        + "           \"refresh_interval\": \"60s\"\n"
        assertFalse(
import org.opensearch.cluster.metadata.ComponentTemplate;
        + "           \"merge.policy\": \"log_byte_size\",\n"  
                .metadata()
                .state()
            OpenSearchCorruptionException.class,
        + "}";
        + "  },\n"
        assertEquals(
                )  
    public static final String SAMPLE_TEMPLATE_V2 = "{\n"  
import org.opensearch.core.xcontent.DeprecationHandler;  
        + "    }\n"
            node().injector()
        + "  },\n"  
            node().client(),
        );
        + "    \"_version\": 1\n"
            node().injector().getInstance(ClusterService.class).state().metadata().componentTemplates().get(metadata.fullyQualifiedName()),
            ComponentTemplate.parse(parser)  
import org.opensearch.core.common.bytes.BytesArray;
        + "    }\n"  
        assertTrue(loader.loadTemplate(new SystemTemplate(new BytesArray(SAMPLE_TEMPLATE_V2), newVersionMetadata, repositoryMetadata)));
                .containsKey(metadata.fullyQualifiedName())  
        // Retry and ensure loading does not happen again with same version  
            )  
        TemplateRepositoryMetadata repositoryMetadata = new TemplateRepositoryMetadata(UUID.randomUUID().toString(), 1L);  
            DeprecationHandler.IGNORE_DEPRECATIONS,
        assertTrue(  
 * compatible open source license.
        + "  \"version\": 2\n"
import java.util.UUID;  
        + "       \"index\": {\n"  
            () -> node().injector().getInstance(ClusterService.class).state()
                )
        + "       }\n"
 *
        );  
                .state()  
        + "           \"refresh_interval\": \"60s\"\n"  
            node().injector()
        ClusterStateSystemTemplateLoader loader = new ClusterStateSystemTemplateLoader(
        // Load for the first time  
                    new BytesArray(SAMPLE_TEMPLATE),
        );
        + "  \"version\": 1\n"  
        TemplateRepositoryMetadata repositoryMetadata = new TemplateRepositoryMetadata(UUID.randomUUID().toString(), 1L);
    }
        + "}";  
            loader.loadTemplate(
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.common.xcontent.json.JsonXContent;
                .componentTemplates()  
                new SystemTemplate(  
        + "  \"template\": {\n"
import org.opensearch.core.xcontent.XContentParser;
    public static final String SAMPLE_TEMPLATE = "{\n"
        assertTrue(  
        + "    \"_version\": 2\n"  
