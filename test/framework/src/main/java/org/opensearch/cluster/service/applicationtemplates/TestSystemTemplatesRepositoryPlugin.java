 * SPDX-License-Identifier: Apache-2.0
    private final SystemTemplate systemTemplate = new SystemTemplate(  
            public boolean loadTemplate(SystemTemplate template) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
            @Override
        return new SystemTemplateLoader() { // Asserting Loader
            @Override  
public class TestSystemTemplatesRepositoryPlugin extends Plugin implements SystemTemplatesPlugin {  
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;  
                return true;
/*  
import java.nio.charset.StandardCharsets;  
package org.opensearch.cluster.service.applicationtemplates;
    public SystemTemplateLoader loaderFor(SystemTemplateMetadata templateMetadata) {  
            }  
                assert template.templateContent() == systemTemplate.templateContent();  
            @Override  
    public SystemTemplateRepository loadRepository() throws IOException {
import org.opensearch.plugins.Plugin;
    );
        BytesReference.fromByteBuffer(ByteBuffer.wrap("content".getBytes(StandardCharsets.UTF_8))),
            public void close() throws Exception {}
 */  
                assert template.templateMetadata() == TestSystemTemplatesRepositoryPlugin.this.templateMetadata;
import org.opensearch.core.common.bytes.BytesReference;
                assert template.repositoryMetadata() == repoMetadata;
    @Override
            public TemplateRepositoryMetadata metadata() {
import org.opensearch.cluster.applicationtemplates.SystemTemplateLoader;
import java.io.IOException;
            public List<SystemTemplateMetadata> listTemplates() throws IOException {  
    }
 * The OpenSearch Contributors require contributions made to  
            }
import java.nio.ByteBuffer;
                return repoMetadata;
                return List.of(templateMetadata);
import org.opensearch.cluster.applicationtemplates.SystemTemplate;
 * compatible open source license.
        };  
    @Override  
import org.opensearch.cluster.applicationtemplates.TemplateRepositoryMetadata;  
            }
        repoMetadata  
}
        };
    private final TemplateRepositoryMetadata repoMetadata = new TemplateRepositoryMetadata("test", 1);
        templateMetadata,
            @Override
            }
    }  
            public SystemTemplate getTemplate(SystemTemplateMetadata template) throws IOException {
                return systemTemplate;  
            @Override
 *
import org.opensearch.cluster.applicationtemplates.SystemTemplateRepository;
        return new SystemTemplateRepository() {
    private final SystemTemplateMetadata templateMetadata = SystemTemplateMetadata.fromComponentTemplateInfo("dummy", 1);
import java.util.List;
import org.opensearch.cluster.applicationtemplates.SystemTemplatesPlugin;
