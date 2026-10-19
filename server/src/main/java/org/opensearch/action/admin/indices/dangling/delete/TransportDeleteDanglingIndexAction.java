/**
                        @Override
                    listener.onFailure(exp);
 * not use this file except in compliance with the License.
        Settings settings,
            }
        return null;
            }
            threadPool,
                            .map(FailedNodeException::nodeId)
package org.opensearch.action.admin.indices.dangling.delete;
    private final NodeClient nodeClient;
                        protected AcknowledgedResponse newResponse(boolean acknowledged) {
    @Override
        findDanglingIndex(deleteRequest.getIndexUUID(), new ActionListener<Index>() {
 * under the License.
            .build(settings);
                    deleteListener.onFailure(new IllegalArgumentException("accept_data_loss must be set to true"));
                            if (each.getIndexUUID().equals(indexUUID)) {
                logger.debug("Failed to find dangling index [" + deleteRequest.getIndexUUID() + "]", e);
        ActionFilters actionFilters,
 * You may obtain a copy of the License at
                        deleteListener.onFailure(e);
                @Override
    AcknowledgedResponse> {
                        logger.debug("Failed to delete dangling index [" + indexName + "] [" + indexUUID + "]", e);
                        for (FailedNodeException failure : response.failures()) {
        this.settings = settings;
                final String taskSource = "delete-dangling-index [" + indexName + "] [" + indexUUID + "]";
                            return deleteDanglingIndexTaskKey;
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        // that a tombstone doesn't already exist for this index.
            indexNameExpressionResolver
        NodeClient nodeClient
    @Inject
                        }
 * software distributed under the License is distributed on an
        metaDataBuilder.indexGraveyard(newGraveyard);
        TransportService transportService,
import org.opensearch.action.support.ActionFilters;
                    }
    }
                public void onResponse(ListDanglingIndicesResponse response) {
            ListDanglingIndicesAction.INSTANCE,
    }
                );
            return currentState;
 * @opensearch.internal
                final ActionListener<AcknowledgedResponse> clusterStateUpdatedListener = new ActionListener<AcknowledgedResponse>() {
 * SPDX-License-Identifier: Apache-2.0
        this.nodeClient.execute(
                            logger.error("Failed to query node [" + failure.nodeId() + "]", failure);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.transport.client.node.NodeClient;
                    if (response.hasFailures()) {
        return ThreadPool.Names.GENERIC;
        );
    protected String executor() {
            DeleteDanglingIndexRequest::new,
        deleteDanglingIndexTaskKey = clusterService.registerClusterManagerTask(DELETE_DANGLING_INDEX, true);
            new ActionListener<ListDanglingIndicesResponse>() {
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor
import java.util.stream.Collectors;
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * ownership. Elasticsearch licenses this file to you under
 */
    DeleteDanglingIndexRequest,
    private ClusterState deleteDanglingIndex(ClusterState currentState, Index indexToDelete) {
/*
        ClusterState state,
                        return;
                if (deleteRequest.isAcceptDataLoss() == false) {
 * KIND, either express or implied.  See the License for the
        // By definition, a dangling index is an index not present in the cluster state and with no tombstone,
 * this class first checks that such a dangling index exists. It then submits a cluster state update
                };
                            e.addSuppressed(failure);
    }
import org.apache.logging.log4j.LogManager;
            public void onFailure(Exception e) {
                // This flag is checked at this point so that we always check that the supplied index ID
 *
                    new AckedClusterStateUpdateTask<AcknowledgedResponse>(deleteRequest, clusterStateUpdatedListener) {
 * this work for additional information regarding copyright
            @Override
import org.opensearch.cluster.block.ClusterBlockException;
 * specific language governing permissions and limitations
                    final List<NodeListDanglingIndicesResponse> nodes = response.getNodes();
                    }
                throw new IllegalArgumentException(
        this.nodeClient = nodeClient;
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesAction;
                clusterService.submitStateUpdateTask(
                    return;
    ) throws Exception {
                    }
            .addTombstone(indexToDelete)
            clusterService,
                        public ClusterState execute(final ClusterState currentState) {
            transportService,
                    }
        }
        return new AcknowledgedResponse(in);
import org.opensearch.action.FailedNodeException;
            if (indexToDelete.getUUID().equals(each.getIndexUUID())) {
 * Implements the deletion of a dangling index. When handling a {@link DeleteDanglingIndexAction},
import org.opensearch.transport.TransportService;
    private final Settings settings;
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
 *
    protected void clusterManagerOperation(
                @Override
import java.io.IOException;
    private static final Logger logger = LogManager.getLogger(TransportDeleteDanglingIndexAction.class);
    }
            }
                            .collect(Collectors.joining(","));
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.admin.indices.dangling.list.NodeListDanglingIndicesResponse;
            DeleteDanglingIndexAction.NAME,
                        @Override
                        listener.onFailure(e);
                    for (NodeListDanglingIndicesResponse nodeResponse : nodes) {
                );
 */
import org.opensearch.core.action.ActionListener;
import org.opensearch.threadpool.ThreadPool;
                        }
                    "Refusing to delete dangling index "
                public void onFailure(Exception exp) {
                            return new AcknowledgedResponse(acknowledged);
                        + "] already exists in the cluster state"
/*
import org.opensearch.OpenSearchException;
    private final ClusterManagerTaskThrottler.ThrottlingKey deleteDanglingIndexTaskKey;
                        final String nodeIds = response.failures()
        ActionListener<AcknowledgedResponse> deleteListener
 * to add the index to the index graveyard.
                            .stream()
        for (final IndexMetadata each : metaData.indices().values()) {
 * Unless required by applicable law or agreed to in writing,
                deleteListener.onFailure(e);
        Metadata.Builder metaDataBuilder = Metadata.builder(metaData);
import org.opensearch.cluster.AckedClusterStateUpdateTask;
import org.opensearch.action.admin.indices.dangling.DanglingIndexInfo;
        DeleteDanglingIndexRequest deleteRequest,
    }
 * GitHub history for details.
                        OpenSearchException e = new OpenSearchException("Failed to query nodes [" + nodeIds + "]");
            actionFilters,
                }
    @Override
                    }
                        deleteListener.onResponse(response);
            new ListDanglingIndicesRequest(indexUUID),
                                return;
import org.apache.logging.log4j.Logger;
                    public void onResponse(AcknowledgedResponse response) {
 */
                        @Override
                    public void onFailure(Exception e) {
 *
    ) {
 * The OpenSearch Contributors require contributions made to
public class TransportDeleteDanglingIndexAction extends TransportClusterManagerNodeAction<
            @Override
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.inject.Inject;
    @Override
        );
import org.opensearch.cluster.metadata.IndexGraveyard;
        ThreadPool threadPool,
                    @Override
    }
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_DANGLING_INDEX;
                        + indexToDelete
                        public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            }
    protected ClusterBlockException checkBlock(DeleteDanglingIndexRequest request, ClusterState state) {
                    listener.onFailure(new IllegalArgumentException("No dangling index found for UUID [" + indexUUID + "]"));
 *
            public void onResponse(Index indexToDelete) {
        final Metadata metaData = currentState.getMetadata();
                String indexName = indexToDelete.getName();
        final IndexGraveyard newGraveyard = IndexGraveyard.builder(metaDataBuilder.indexGraveyard())
    }
                        for (DanglingIndexInfo each : nodeResponse.getDanglingIndices()) {
                        + indexToDelete.getUUID()
 */
        super(
                                listener.onResponse(new Index(each.getIndexName(), each.getIndexUUID()));
                            }
        if (metaData.indexGraveyard().containsIndex(indexToDelete)) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.Metadata;
        }
import java.util.List;
                            return deleteDanglingIndex(currentState, indexToDelete);
                // does correspond to a dangling index.
import org.opensearch.core.index.Index;
import org.opensearch.common.settings.Settings;
}
                }
    @Override
import org.opensearch.cluster.metadata.IndexMetadata;
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                        }
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
    public TransportDeleteDanglingIndexAction(
        });
                    taskSource,
                        + " as an index with UUID ["
                        }
                    @Override
        // so we shouldn't reach this point if these conditions aren't met. For super-safety, however, check
                        }
/*
                }
        return ClusterState.builder(currentState).metadata(metaDataBuilder.build()).build();
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        ClusterService clusterService,
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
                String indexUUID = indexToDelete.getUUID();
    private void findDanglingIndex(String indexUUID, ActionListener<Index> listener) {
