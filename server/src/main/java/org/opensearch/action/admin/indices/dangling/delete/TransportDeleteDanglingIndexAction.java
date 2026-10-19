    }  
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
import org.opensearch.common.inject.Inject;
    private ClusterState deleteDanglingIndex(ClusterState currentState, Index indexToDelete) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.service.ClusterService;  
                        protected AcknowledgedResponse newResponse(boolean acknowledged) {
import org.opensearch.transport.TransportService;
                // This flag is checked at this point so that we always check that the supplied index ID
                            .map(FailedNodeException::nodeId)
 * specific language governing permissions and limitations
}
                        for (DanglingIndexInfo each : nodeResponse.getDanglingIndices()) {
    ) throws Exception {  
 * compatible open source license.
                        }
    }
 */
 * Modifications Copyright OpenSearch Contributors. See
                        + "] already exists in the cluster state"  
        Metadata.Builder metaDataBuilder = Metadata.builder(metaData);  
import java.util.stream.Collectors;  
/**
                };
                            if (each.getIndexUUID().equals(indexUUID)) {  
    DeleteDanglingIndexRequest,  
        final Metadata metaData = currentState.getMetadata();  
            if (indexToDelete.getUUID().equals(each.getIndexUUID())) {  
import org.opensearch.action.admin.indices.dangling.list.NodeListDanglingIndicesResponse;  
                        for (FailedNodeException failure : response.failures()) {
 * to add the index to the index graveyard.
            public void onFailure(Exception e) {
    @Override
        return ThreadPool.Names.GENERIC;
 */  
                    new AckedClusterStateUpdateTask<AcknowledgedResponse>(deleteRequest, clusterStateUpdatedListener) {
import org.apache.logging.log4j.LogManager;
    }
public class TransportDeleteDanglingIndexAction extends TransportClusterManagerNodeAction<
            .build(settings);
 *  
 * this class first checks that such a dangling index exists. It then submits a cluster state update  
                        public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
import org.opensearch.cluster.metadata.IndexGraveyard;
import org.opensearch.cluster.block.ClusterBlockException;  
    }
                        @Override
 * this work for additional information regarding copyright
            transportService,
                        deleteListener.onResponse(response);
                @Override
                            return deleteDanglingIndexTaskKey;
        }
        return ClusterState.builder(currentState).metadata(metaDataBuilder.build()).build();
        final IndexGraveyard newGraveyard = IndexGraveyard.builder(metaDataBuilder.indexGraveyard())
import org.opensearch.OpenSearchException;  
    AcknowledgedResponse> {
            }
                        + " as an index with UUID ["
            DeleteDanglingIndexRequest::new,  
                    "Refusing to delete dangling index "
                        }
        ActionListener<AcknowledgedResponse> deleteListener
            @Override  
                    final List<NodeListDanglingIndicesResponse> nodes = response.getNodes();
        return null;  
    protected String executor() {
                    }  
 * not use this file except in compliance with the License.
                        }  
            ListDanglingIndicesAction.INSTANCE,
                        public ClusterState execute(final ClusterState currentState) {
    public TransportDeleteDanglingIndexAction(  
            }
                            .collect(Collectors.joining(","));
    @Override
            }
                                listener.onResponse(new Index(each.getIndexName(), each.getIndexUUID()));
 */  
import org.opensearch.cluster.ClusterState;
                        + indexToDelete  
        this.settings = settings;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesRequest;
import org.opensearch.cluster.metadata.IndexMetadata;
    private static final Logger logger = LogManager.getLogger(TransportDeleteDanglingIndexAction.class);
                    return;
/*  
    private void findDanglingIndex(String indexUUID, ActionListener<Index> listener) {  
    }
                @Override
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesAction;  
 *
                    deleteListener.onFailure(new IllegalArgumentException("accept_data_loss must be set to true"));
                    }  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
        deleteDanglingIndexTaskKey = clusterService.registerClusterManagerTask(DELETE_DANGLING_INDEX, true);  
        metaDataBuilder.indexGraveyard(newGraveyard);
            DeleteDanglingIndexAction.NAME,
 * KIND, either express or implied.  See the License for the
                    public void onFailure(Exception e) {  
/*  
import org.apache.logging.log4j.Logger;
                if (deleteRequest.isAcceptDataLoss() == false) {  
                        deleteListener.onFailure(e);
import java.io.IOException;
import org.opensearch.common.settings.Settings;
                final ActionListener<AcknowledgedResponse> clusterStateUpdatedListener = new ActionListener<AcknowledgedResponse>() {
    private final Settings settings;
 * Unless required by applicable law or agreed to in writing,
        super(  
                }  
    @Override  
                    listener.onFailure(exp);  
                        logger.debug("Failed to delete dangling index [" + indexName + "] [" + indexUUID + "]", e);
                    taskSource,  
                // does correspond to a dangling index.
                    @Override
                String indexUUID = indexToDelete.getUUID();  
import java.util.List;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
                throw new IllegalArgumentException(
        ClusterService clusterService,
            public void onResponse(Index indexToDelete) {  
    protected void clusterManagerOperation(
                            return new AcknowledgedResponse(acknowledged);
                        return;
                            logger.error("Failed to query node [" + failure.nodeId() + "]", failure);  
            .addTombstone(indexToDelete)  
 */
            clusterService,  
    @Override
    }
                logger.debug("Failed to find dangling index [" + deleteRequest.getIndexUUID() + "]", e);
        TransportService transportService,
                String indexName = indexToDelete.getName();
                        + indexToDelete.getUUID()
        Settings settings,  
import org.opensearch.action.FailedNodeException;
    protected ClusterBlockException checkBlock(DeleteDanglingIndexRequest request, ClusterState state) {
import org.opensearch.threadpool.ThreadPool;  
            indexNameExpressionResolver
            threadPool,
        ThreadPool threadPool,  
                );  
                deleteListener.onFailure(e);  
                    if (response.hasFailures()) {
                        final String nodeIds = response.failures()
            }
                public void onResponse(ListDanglingIndicesResponse response) {  
                clusterService.submitStateUpdateTask(
 *     http://www.apache.org/licenses/LICENSE-2.0
        // that a tombstone doesn't already exist for this index.
                            return deleteDanglingIndex(currentState, indexToDelete);  
                            .stream()  
import org.opensearch.action.support.ActionFilters;
import org.opensearch.core.index.Index;
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                );
import org.opensearch.core.common.io.stream.StreamInput;
 *
        // so we shouldn't reach this point if these conditions aren't met. For super-safety, however, check  
        findDanglingIndex(deleteRequest.getIndexUUID(), new ActionListener<Index>() {
        this.nodeClient = nodeClient;
                        @Override
                                return;
            return currentState;  
import org.opensearch.cluster.AckedClusterStateUpdateTask;
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
            @Override
                    @Override  
                    }
        IndexNameExpressionResolver indexNameExpressionResolver,
        });
    private final ClusterManagerTaskThrottler.ThrottlingKey deleteDanglingIndexTaskKey;  
                }
                        }
                    for (NodeListDanglingIndicesResponse nodeResponse : nodes) {
                        @Override  
                    }
        if (metaData.indexGraveyard().containsIndex(indexToDelete)) {
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
    ) {
        NodeClient nodeClient
        return new AcknowledgedResponse(in);
    private final NodeClient nodeClient;
/*
 * @opensearch.internal  
    }  
package org.opensearch.action.admin.indices.dangling.delete;
                        listener.onFailure(e);
                    }  
                public void onFailure(Exception exp) {
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse;
 * software distributed under the License is distributed on an
        );
        }  
        this.nodeClient.execute(
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        for (final IndexMetadata each : metaData.indices().values()) {
                            e.addSuppressed(failure);
 * Licensed to Elasticsearch under one or more contributor  
                final String taskSource = "delete-dangling-index [" + indexName + "] [" + indexUUID + "]";  
                }
import org.opensearch.action.admin.indices.dangling.DanglingIndexInfo;
import org.opensearch.cluster.metadata.Metadata;
    @Inject
        ClusterState state,
            new ActionListener<ListDanglingIndicesResponse>() {
        );  
 *
        ActionFilters actionFilters,
            actionFilters,
                        }
import org.opensearch.transport.client.node.NodeClient;
 * Implements the deletion of a dangling index. When handling a {@link DeleteDanglingIndexAction},
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                    listener.onFailure(new IllegalArgumentException("No dangling index found for UUID [" + indexUUID + "]"));
        DeleteDanglingIndexRequest deleteRequest,  
                        OpenSearchException e = new OpenSearchException("Failed to query nodes [" + nodeIds + "]");  
            new ListDanglingIndicesRequest(indexUUID),  
 * GitHub history for details.
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_DANGLING_INDEX;
        // By definition, a dangling index is an index not present in the cluster state and with no tombstone,
                    public void onResponse(AcknowledgedResponse response) {
import org.opensearch.core.action.ActionListener;  
                            }  
 * this file be licensed under the Apache-2.0 license or a
