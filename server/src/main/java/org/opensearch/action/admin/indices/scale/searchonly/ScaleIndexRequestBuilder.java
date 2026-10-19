public class ScaleIndexRequestBuilder extends ActionRequestBuilder<ScaleIndexRequest, AcknowledgedResponse> {
 */  
/*  
import org.opensearch.common.annotation.PublicApi;  
/**  
     *
     * @param client    the client to use for executing the request  
@PublicApi(since = "3.0.0")  
 * <p>
 * <p>  
import org.opensearch.transport.client.OpenSearchClient;
     * Constructs a new builder for scaling an index, allowing explicit direction specification.
 * A builder for constructing {@link ScaleIndexRequest} objects to perform search-only scale operations.
 * this file be licensed under the Apache-2.0 license or a
     */  
 * The OpenSearch Contributors require contributions made to  
 */
    /**  
 * It provides methods to configure the scaling direction and follows the builder pattern to allow
    public ScaleIndexRequestBuilder(OpenSearchClient client, boolean searchOnly, String index) {
     * @param searchOnly true for scaling down to search-only mode, false for scaling up to normal mode
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }  
 * SPDX-License-Identifier: Apache-2.0
 * method chaining for constructing requests.
 *
     * @param index     the name of the index to scale
        super(client, ScaleIndexAction.INSTANCE, new ScaleIndexRequest(index, searchOnly));
 * This builder simplifies the creation of requests to scale indices up or down for search-only mode.  
package org.opensearch.action.admin.indices.scale.searchonly;
 * The builder is part of the public API since OpenSearch 3.0.0.
import org.opensearch.action.ActionRequestBuilder;
 * compatible open source license.
}
