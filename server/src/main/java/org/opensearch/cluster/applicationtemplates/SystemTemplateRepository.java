package org.opensearch.cluster.applicationtemplates;
    /**
    TemplateRepositoryMetadata metadata();
/**
     */
 */
@ExperimentalApi
 * Repository interface around the templates provided by a store (e.g. code repo, remote file store, etc)  
    SystemTemplate getTemplate(SystemTemplateMetadata template) throws IOException;
}  
     */  
    Iterable<SystemTemplateMetadata> listTemplates() throws IOException;
     * @return The actual template content  
 * The OpenSearch Contributors require contributions made to  
     * @return Metadata about the repository  
public interface SystemTemplateRepository extends AutoCloseable {  
     * @return Metadata for all available templates
     */
 * SPDX-License-Identifier: Apache-2.0
     * @param template metadata about template to be fetched
     *
import org.opensearch.common.annotation.ExperimentalApi;
 */  
/*  
 *
    /**  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
    /**
