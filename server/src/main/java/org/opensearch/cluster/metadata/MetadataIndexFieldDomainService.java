        this.threadPool = Objects.requireNonNull(threadPool, "threadPool must not be null");  
        Metadata.Builder metadata = Metadata.builder(currentState.metadata()).put(updatedIndexMetadata, true);
        this.clusterService = Objects.requireNonNull(clusterService, "clusterService must not be null");
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
import org.opensearch.threadpool.ThreadPool;
        );
import static org.opensearch.action.support.ContextPreservingActionListener.wrapPreservingContext;
        putIndexFieldDomainsTaskKey = clusterService.registerClusterManagerTask(PUT_INDEX_FIELD_DOMAINS, true);  
        }  
    static ClusterState applyFieldDomains(ClusterState currentState, PutIndexFieldDomainsClusterStateUpdateRequest request) {
import org.opensearch.cluster.AckedClusterStateUpdateTask;
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
import org.opensearch.cluster.ClusterState;  
            currentIndexMetadata.getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY),
import org.opensearch.action.admin.indices.fielddomain.PutIndexFieldDomainsClusterStateUpdateRequest;
        if (Objects.equals(  
    }
        IndexMetadata updatedIndexMetadata = IndexFieldDomainMetadata.getInstance()
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_INDEX_FIELD_DOMAINS;
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
        IndexMetadata currentIndexMetadata = currentState.metadata()
    private final ThreadPool threadPool;  
                @Override
 *
        Map<String, String> encodedFieldDomains = request.fieldDomainCustomData();
                    return new ClusterStateUpdateResponse(acknowledged);  
import org.opensearch.index.fielddomain.IndexFieldDomainMetadata;
                }
        if (encodedFieldDomains == null || encodedFieldDomains.isEmpty()) {  
                @Override
    ) {  
    public MetadataIndexFieldDomainService(ClusterService clusterService, ThreadPool threadPool) {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
 * Field-domain metadata describes values that may exist for a field in one concrete index. Trusted producers use this
    private final ClusterManagerTaskThrottler.ThrottlingKey putIndexFieldDomainsTaskKey;
    @Inject  
            return currentState;
                }  
package org.opensearch.cluster.metadata;
    public void putFieldDomains(  
import org.opensearch.common.inject.Inject;
     * Publishes field-domain metadata through a cluster state update.
        Objects.requireNonNull(request, "request must not be null");  
/*  
        return ClusterState.builder(currentState).metadata(metadata).build();  
}
                    return applyFieldDomains(currentState, request);
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
     */  
import org.opensearch.common.Priority;
        }
            .putFieldDomains(currentIndexMetadata, encodedFieldDomains);
            }  
    }
     * Applies the metadata merge to the supplied cluster state.
    private final ClusterService clusterService;
 * compatible open source license.
                public ClusterState execute(ClusterState currentState) {  
            .getIndexSafe(Objects.requireNonNull(request.targetIndex(), "targetIndex must not be null"));  
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException("field domain metadata is required");
        final ActionListener<ClusterStateUpdateResponse> listener
        clusterService.submitStateUpdateTask(
 * this file be licensed under the Apache-2.0 license or a
            new AckedClusterStateUpdateTask<>(Priority.NORMAL, request, wrapPreservingContext(listener, threadPool.getThreadContext())) {  
 */  
import java.util.Objects;
        final PutIndexFieldDomainsClusterStateUpdateRequest request,
            // Avoid publishing a new cluster state when the stored field-domain metadata is unchanged.
/**
import org.opensearch.cluster.service.ClusterService;  
public class MetadataIndexFieldDomainService {
import org.opensearch.core.action.ActionListener;  
     */
            updatedIndexMetadata.getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY)
 * service to merge validated metadata into {@link IndexMetadata#getCustomData(String)} on the cluster-manager node.
 *  
        )) {  
            "put-index-field-domains [" + request.targetIndex() + "]",
    /**
    /**  
 */  
 * Service responsible for publishing index-level field-domain metadata.
                @Override  
    }
                }
                    return putIndexFieldDomainsTaskKey;
        Objects.requireNonNull(currentState, "currentState must not be null");
