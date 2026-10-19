    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) {
import static org.opensearch.core.common.Strings.splitStringByCommaToArray;
    protected final String targetTier;
    }
import org.opensearch.rest.RestRequest;
     * Constructs a RestBaseTierAction for the given target tier.
    }  
 * this file be licensed under the Apache-2.0 license or a
    }
            );
        final IndexTieringRequest indexTieringRequest = new IndexTieringRequest(targetTier, indices[0]);
     * Validates the indices parameter from the request.  
            throw new IllegalArgumentException(  
     *
     */
 */  
import org.opensearch.core.common.util.CollectionUtils;  
 * Base REST handler for tiering operations.  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        return singletonList(new Route(POST, "/{index}/_tier/" + targetTier));
     */
        return channel -> client.admin().cluster().execute(getTierAction(), indexTieringRequest, new RestToXContentListener<>(channel));  
import static java.util.Collections.singletonList;
import org.opensearch.rest.action.RestToXContentListener;  
        indexTieringRequest.timeout(request.paramAsTime("timeout", indexTieringRequest.timeout()));
import org.opensearch.transport.client.node.NodeClient;
    }
            request.paramAsTime("cluster_manager_timeout", indexTieringRequest.clusterManagerNodeTimeout())
import java.util.Locale;
        if (CollectionUtils.isEmpty(indices)) {  
    /** Returns the migration type identifier for this action. @return the migration type */  
            throw new IllegalArgumentException("Index parameter is required");
import java.util.List;
import org.opensearch.storage.common.tiering.TieringUtils;
        indexTieringRequest.clusterManagerNodeTimeout(  
import org.opensearch.rest.BaseRestHandler;
import static org.opensearch.rest.RestRequest.Method.POST;  
    /**
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException("Index is blocklisted for migrations");  
    @Override  
    @Override
    protected void validateIndices(final String[] indices) {
        );
        validateIndices(indices);
     * @param targetTier the target tier  
        } else if (indices[0] == null || indices[0].isBlank()) {  
    /** The target tier for this action. */
        } else if (indices.length != 1) {
 * compatible open source license.
    protected abstract String getMigrationType();
    /** Returns the action type for this tier operation. @return the tier action type */  
        this.targetTier = targetTier;  
 *
 */
    protected RestBaseTierAction(String targetTier) {
        } else if (TieringUtils.isMigrationAllowed(indices[0]) == false) {
/*  
        }
 * SPDX-License-Identifier: Apache-2.0
                String.format(Locale.ROOT, "%s request should contain exactly one index", getMigrationType())
    protected abstract ActionType<AcknowledgedResponse> getTierAction();
    /**
import org.opensearch.action.ActionType;
/**
        final String[] indices = splitStringByCommaToArray(request.param("index"));  
     * @param indices array of index names to validate
}
public abstract class RestBaseTierAction extends BaseRestHandler {
package org.opensearch.storage.action.tiering;
    public List<Route> routes() {
     * @throws IllegalArgumentException if validation fails  
            throw new IllegalArgumentException("Index name cannot be null or empty");
