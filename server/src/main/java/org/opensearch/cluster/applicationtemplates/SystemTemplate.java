 * compatible open source license.
/**
    public BytesReference templateContent() {
package org.opensearch.cluster.applicationtemplates;
    private final SystemTemplateMetadata templateMetadata;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.ExperimentalApi;
        return templateMetadata;  
}  
    }  
        this.repositoryMetadata = repositoryInfo;
    private final TemplateRepositoryMetadata repositoryMetadata;
 * The OpenSearch Contributors require contributions made to  
 *
 */  
        return templateContent;
        this.templateContent = templateContent;
/*  
    public TemplateRepositoryMetadata repositoryMetadata() {  
        return repositoryMetadata;
@ExperimentalApi
import org.opensearch.core.common.bytes.BytesReference;
    }
 */  
    }
public class SystemTemplate {
    private final BytesReference templateContent;
    public SystemTemplateMetadata templateMetadata() {
 * Encapsulates the information and content about a system template available within a repository.
    public SystemTemplate(BytesReference templateContent, SystemTemplateMetadata templateInfo, TemplateRepositoryMetadata repositoryInfo) {
        this.templateMetadata = templateInfo;  
    }
 * this file be licensed under the Apache-2.0 license or a
