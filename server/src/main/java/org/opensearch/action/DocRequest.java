 * compatible open source license.
    }
    /**
 * @opensearch.api  
    String id();
 *
     *
@PublicApi(since = "3.1.0")
     * pertain to a single report definition would override this to specify "report_definition"
     * @return the type  
/*  
     * Used in the context of resource sharing to specify the type of sharable resource.
     * @return the index  
 */
     * Get the index that this request operates on
     *
     */
package org.opensearch.action;
 * Generic interface to group ActionRequest, which perform actions on a single document
/**  
 */  
}
     */
     * Get the type of the request. This should match the action name prefix: i.e. indices:data/read/get
        return "indices";  
     * i.e. A report definition is sharable, so ActionRequests in the reporting plugin that  
     * Get the id of the document for this request
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    /**
    default String type() {
    String index();
 *
     */
     * @return the id  
    /**
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
     *  
public interface DocRequest {  
