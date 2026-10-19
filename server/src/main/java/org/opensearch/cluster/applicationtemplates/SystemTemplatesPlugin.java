     * @return repository implementation from which templates are to be fetched.  
import org.opensearch.common.annotation.ExperimentalApi;
 */  
@ExperimentalApi
 * this file be licensed under the Apache-2.0 license or a
    SystemTemplateRepository loadRepository() throws IOException;
     * @param templateInfo Metadata about the template to load
 * compatible open source license.
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
}  
    /**
 * SPDX-License-Identifier: Apache-2.0
    SystemTemplateLoader loaderFor(SystemTemplateMetadata templateInfo);
     */
 * Plugin interface to expose the template maintaining logic.  
/*  
public interface SystemTemplatesPlugin {  
 */
package org.opensearch.cluster.applicationtemplates;
    /**
     */
 *
     * @return Implementation of TemplateLoader which determines how to make the template available at runtime.  
/**
