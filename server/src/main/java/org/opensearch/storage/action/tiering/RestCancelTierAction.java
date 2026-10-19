 * in RUNNING_SHARD_RELOCATION state, allowing manual recovery.  
import org.opensearch.core.common.util.CollectionUtils;
    @Override  
        return "cancel_tier_action";  
package org.opensearch.storage.action.tiering;
import org.opensearch.rest.RestRequest;  
/**  
    /**
        } else if (indices[0] == null || indices[0].isBlank()) {
public class RestCancelTierAction extends BaseRestHandler {
        validateIndices(indices);  
import org.opensearch.rest.BaseRestHandler;
     * @param indices array of index names to validate
import org.opensearch.transport.client.node.NodeClient;  
        final String[] indices = splitStringByCommaToArray(request.param("index"));
import org.opensearch.storage.common.tiering.TieringUtils;
            .cluster()  
            throw new IllegalArgumentException("Index is blocklisted for migrations");
            request.paramAsTime("cluster_manager_timeout", cancelTieringRequest.clusterManagerNodeTimeout())
    }  
        if (CollectionUtils.isEmpty(indices)) {  
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {  
    @Override
            throw new IllegalArgumentException("Index name cannot be null or empty");
     * Validates the indices parameter from the request.  
 */  
        } else if (indices.length != 1) {
            .execute(CancelTieringAction.INSTANCE, cancelTieringRequest, new RestToXContentListener<>(channel));
        } else if (TieringUtils.isMigrationAllowed(indices[0]) == false) {  
        return channel -> client.admin()
import java.util.Locale;  
/*  
 *
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Cancel tiering request should contain exactly one index"));  
        cancelTieringRequest.clusterManagerNodeTimeout(
import static java.util.Collections.singletonList;
        );  
 * compatible open source license.
    }
 * The OpenSearch Contributors require contributions made to  
    @Override
}  
 * SPDX-License-Identifier: Apache-2.0
    }
            throw new IllegalArgumentException("Index parameter is required");
     * @throws IllegalArgumentException if validation fails  
        return singletonList(new Route(POST, "/_tier/_cancel/{index}"));
 */
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rest.action.RestToXContentListener;
        cancelTieringRequest.timeout(request.paramAsTime("timeout", cancelTieringRequest.timeout()));  
import static org.opensearch.core.common.Strings.splitStringByCommaToArray;  
    }  
    public String getName() {
        }
 * REST handler for cancelling ongoing tiering operations.
    public List<Route> routes() {
import java.util.List;
        final CancelTieringRequest cancelTieringRequest = new CancelTieringRequest(indices[0]);
    protected void validateIndices(final String[] indices) {
 * This handler provides an endpoint to cancel migrations that may be stuck
import static org.opensearch.rest.RestRequest.Method.POST;
     *
     */
