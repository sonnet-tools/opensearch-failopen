        }
        if (indexShardRoutingTable.size() == 0) {
import org.opensearch.threadpool.ThreadPool;
                    expectedActiveCopies,
        }
                    request.clusterName,
 * this work for additional information regarding copyright
 * @opensearch.internal
    // TODO this class can be foled into either IndicesService and partially into IndicesClusterStateService
 *
 * not use this file except in compliance with the License.
        }
        private final int expectedActiveCopies;
                                        request.shardId
    @Inject
                        return currentShard == null || shardActive(currentShard);
    }
                        }
                logger.trace(
            }
 * SPDX-License-Identifier: Apache-2.0
                                channel.sendResponse(new ShardActiveResponse(shardActive, clusterService.localNode()));
                        default:
        this.indicesService = indicesService;
 * specific language governing permissions and limitations
        this.threadPool = threadPool;
                        indicesService.deleteShardStore("no longer used", shardId, currentState);
    // there is no need for a separate public service
import org.opensearch.cluster.metadata.IndexMetadata;
            shardId.writeTo(out);
                    shardId,
import org.opensearch.transport.TransportRequestHandler;
        private final boolean shardActive;
                        // send back that the shard is active here we could also evaluate the cluster state and get the
                        case STILL_ALLOCATED:
                return false;
            // Note, closed indices will not have any routing information, so won't be deleted
        if (localRoutingNode != null) {
        for (Tuple<DiscoveryNode, ShardActiveRequest> request : requests) {
     *
                    request.timeout,
            }
import org.opensearch.cluster.node.DiscoveryNode;
                            sendResult(false);
        }
/*
 * GitHub history for details.
    }
        private final DiscoveryNode node;
                    activeCopies.get()
                    )
                return ACTIVE_STATES.contains(indexShard.state());
        }
                            // nothing to do
                            currentState.getVersion(),
            ShardActiveRequest::new,
 * Licensed to Elasticsearch under one or more contributor
        private ClusterName clusterName;
        private ShardId shardId;
            // it's easier to do that check when the current cluster state is visible.
            }
                        logger.debug(() -> new ParameterizedMessage("{} failed to delete unallocated shard, ignoring", shardId), ex);
import java.util.List;
        }
            this.shardId = shardId;
                return null;
        ShardActiveResponseHandler(ShardId shardId, long clusterStateVersion, int expectedActiveCopies) {
    private final ThreadPool threadPool;
        ThreadPool threadPool
import org.opensearch.core.common.io.stream.StreamInput;
            // shard replication group, in any case, protected from deleting something by mistake
 */
            if (indexShard != null) {
            IndexService indexService = indicesService.indexService(shardId.getIndex());
                        case NO_LOCAL_STORAGE:
                    (source, e) -> logger.error(
            DiscoveryNode currentNode = state.nodes().get(shardRouting.currentNodeId());
                // in general, using a cluster state observer here is a workaround for the fact that we cannot listen on
     */
        final String localNodeId = event.state().nodes().getLocalNodeId();
        }
                        public void onClusterServiceClose() {
    /**
 * license agreements. See the NOTICE file distributed with
                );
                },
    }
            if (awaitingResponses.decrementAndGet() == 0) {
            return ThreadPool.Names.SAME;
import org.opensearch.index.IndexSettings;
        return true;
    private class ShardActiveRequestHandler implements TransportRequestHandler<ShardActiveRequest> {
                        public void onNewClusterState(ClusterState state) {
                            "not deleting shard {}, the update task state version[{}] is not equal to cluster state before "
                    // shard is not active, might be POST_RECOVERY so check if cluster state changed inbetween or wait for next change
        private boolean shardActive(IndexShard indexShard) {
                        public void sendResult(boolean shardActive) {
            indexShardRoutingTable.shardId(),
                // create observer here. we need to register it here because we need to capture the current cluster state
                // which will then be compared to the one that is applied when we call waitForNextChange(). if we create it
                return;
        IndicesService indicesService,
    ) {
                    "not deleting shard {}, expected {} active copies, but only {} found active copies",
            if (activeCopies.get() != expectedActiveCopies) {
                                );
            if (clusterStateVersion != latestClusterState.getVersion()) {
        transportService.registerRequestHandler(
        public void writeTo(StreamOutput out) throws IOException {
    public void clusterChanged(ClusterChangedEvent event) {
    // Cache successful shard deletion checks to prevent unnecessary file system lookups
import org.opensearch.common.settings.Setting;
 * You may obtain a copy of the License at
        public void writeTo(StreamOutput out) throws IOException {
                    threadPool.getThreadContext()
            }
            transportService.sendRequest(request.v1(), ACTION_SHARD_EXISTS, request.v2(), responseHandler);
                // later we might miss an update and wait forever in case no new cluster state comes in.
        }
                        return;
        private final long clusterStateVersion;
                            } catch (IOException | OpenSearchRejectedExecutionException e) {
 * under the License.
            // be conservative here, check on started, not even active
import org.opensearch.core.transport.TransportResponse;
    /**
                            assert false : "shard deletion only runs on data nodes which always have local storage";
                        + "before shard active api call [{}]",
            ThreadPool.Names.SAME,
                            assert false : "unknown shard deletion check result: " + shardDeletionCheckResult;
            requests.add(
import java.util.HashSet;
                    }
        }
        private final AtomicInteger awaitingResponses;
            if (response.shardActive) {
            logger.trace("{} is {}active on node {}", shardId, response.shardActive ? "" : "not ", response.node);
                        @Override
        }
            out.writeString(indexUUID);
                            clusterStateVersion
import org.opensearch.cluster.service.ClusterService;
            shardActive = in.readBoolean();
                                    e
        private void allNodesResponded() {
import org.opensearch.cluster.ClusterChangedEvent;
        this.transportService = transportService;
        }
                    switch (shardDeletionCheckResult) {
        if (DiscoveryNode.isDataNode(settings)) {
        }
                            break;
import org.opensearch.cluster.ClusterState;
                    thisClusterName
                            shardId,
import org.opensearch.common.inject.Inject;
                    );
import org.opensearch.cluster.routing.RoutingNode;
                logger.trace(
            }
        }
                            // nothing to do
    private static final EnumSet<IndexShardState> ACTIVE_STATES = EnumSet.of(IndexShardState.STARTED);
            requests.size()
        private String indexUUID;
                        case FOLDER_FOUND_CAN_DELETE:
                } else {
    public void close() {
 *
            clusterService.addListener(this);
            this.activeCopies = new AtomicInteger();
            out.writeBoolean(shardActive);
        protected TimeValue timeout = null;
                            try {
            return;
                }
            return;
        @Override
            this.indexUUID = indexUUID;
 * Store for multiple indexes
            }
        @Override
                .runOnApplierThread("indices_store ([" + shardId + "] active fully on other nodes)", currentState -> {
 * the Apache License, Version 2.0 (the "License"); you may
            // check if shard is active on the current node
import org.opensearch.transport.TransportService;
        }
                    latestClusterState.getVersion(),
import org.apache.logging.log4j.LogManager;
        }
                    clusterService,
                    channel.sendResponse(new ShardActiveResponse(true, clusterService.localNode()));
            ShardId shardId = request.shardId;
 *
        @Override
            if (indexShard == null) {
import org.opensearch.common.settings.Settings;
                // shard state changes explicitly. instead we wait for the cluster state changes because we know any
                ClusterStateObserver observer = new ClusterStateObserver(
    );
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.TransportException;
                            sendResult(shardActive(getShard(request)));
import java.io.Closeable;
                activeCopies.incrementAndGet();
        }
    private static final Logger logger = LogManager.getLogger(IndicesStore.class);
import org.apache.logging.log4j.Logger;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
                                    () -> new ParameterizedMessage(
                allNodesResponded();
                        indexSettings = indexService.getIndexSettings();
import org.apache.logging.log4j.message.ParameterizedMessage;
        public void handleResponse(ShardActiveResponse response) {
            IndexShard indexShard = getShard(request);
import org.opensearch.transport.TransportResponseHandler;
        ShardActiveResponse(StreamInput in) throws IOException {
        this.clusterService = clusterService;
            ClusterName thisClusterName = clusterService.getClusterName();
            this.expectedActiveCopies = expectedActiveCopies;
     * @opensearch.internal
import java.util.EnumSet;
            if (awaitingResponses.decrementAndGet() == 0) {
     * @opensearch.internal
    public static final String ACTION_SHARD_EXISTS = "internal:index/shard/exists";
    private void deleteShardIfExistElseWhere(ClusterState state, IndexShardRoutingTable indexShardRoutingTable) {
                                            + "delete shard {} - shard will probably not be removed",
package org.opensearch.indices.store;
                    observer.waitForNextChange(new ClusterStateObserver.Listener() {
            // should not really happen, there should always be at least 1 (primary) shard in a
                );
public class IndicesStore implements ClusterStateListener, Closeable {
                    IndexService indexService = indicesService.indexService(indexRoutingTable.getIndex());
     * A shard active request
                        }
 */
                return indexService.getShardOrNull(shardId.id());
    public static final Setting<TimeValue> INDICES_STORE_DELETE_SHARD_TIMEOUT = Setting.positiveTimeSetting(
                    });
            node.writeTo(out);
import org.opensearch.cluster.routing.ShardRouting;
        if (!event.routingTableChanged()) {
                        }
    private final IndicesService indicesService;
                    }
                        public void onTimeout(TimeValue timeout) {
        ShardActiveResponseHandler responseHandler = new ShardActiveResponseHandler(
                    logger,
import org.opensearch.index.shard.IndexShard;
                            folderNotFoundCache.add(shardId);
            node = new DiscoveryNode(in);
 *    http://www.apache.org/licenses/LICENSE-2.0
                        shardId,
 * The OpenSearch Contributors require contributions made to
                if (folderNotFoundCache.contains(shardId) == false && shardCanBeDeleted(localNodeId, indexShardRoutingTable)) {
        for (ShardRouting shardRouting : indexShardRoutingTable) {
 *
            // we double check nothing has changed when responses come back from other nodes.
                        logger.trace(
        String indexUUID = indexShardRoutingTable.shardId().getIndex().getUUID();
    }
                    }
            clusterService.getClusterApplierService()
        private final ShardId shardId;
                                + "shard active api call [{}]",
import org.opensearch.index.shard.IndexShardState;
            }
            );
                        // so the cluster state listener must be notified or the shard is active in which case we want to
            this.clusterName = clusterName;
import org.opensearch.cluster.ClusterName;
                // check if shard is active. if so, all is good
            timeout = new TimeValue(in.readLong(), TimeUnit.MILLISECONDS);
        // remove entries from cache which are allocated to this node
                    } catch (Exception ex) {
import org.opensearch.transport.TransportChannel;
            super(in);
                            break;
                            }
                logger.trace(
        @Override
                        );
/*
        List<Tuple<DiscoveryNode, ShardActiveRequest>> requests = new ArrayList<>(indexShardRoutingTable.size());
            } else {
            assert shardRouting.started() : "expected started shard but was " + shardRouting;
                    }
            clusterName = new ClusterName(in);
            }
                        case NO_FOLDER_FOUND:
                }
 * this file be licensed under the Apache-2.0 license or a
        "indices.store.delete.shard.timeout",
        }
            this.timeout = timeout;
                        e
        RoutingTable routingTable = event.state().routingTable();
        folderNotFoundCache.removeIf(shardId -> !routingTable.hasIndex(shardId.getIndex()));
                    final IndexSettings indexSettings;
        }
    private final TransportService transportService;
            this.shardId = shardId;
                ShardId shardId = indexShardRoutingTable.shardId();
                    if (clusterStateVersion != currentState.getVersion()) {
                        indexSettings
import java.util.concurrent.atomic.AtomicInteger;
        );
import org.opensearch.index.IndexService;
            super.writeTo(out);
import java.util.Set;
                );
                        }
                    try {
                allNodesResponded();
        );
    private final TimeValue deleteShardTimeout;
import org.opensearch.common.unit.TimeValue;
                    }, newState -> {
            }
            if (!thisClusterName.equals(request.clusterName)) {
            ClusterState latestClusterState = clusterService.state();
                    clusterStateVersion
        @Override
        for (ShardRouting shardRouting : indexShardRoutingTable) {
                    shardId,
                    } else {
            return new ShardActiveResponse(in);
    }
                        @Override
                            sendResult(shardActive(getShard(request)));
        if (DiscoveryNode.isDataNode(settings)) {
            this.awaitingResponses = new AtomicInteger(expectedActiveCopies);
        for (IndexRoutingTable indexRoutingTable : routingTable) {
    @Override
                folderNotFoundCache.remove(routing.shardId());
        // - closed indices don't need to be removed from the cache but we do it anyway for code simplicity
                            deleteShardIfExistElseWhere(event.state(), indexShardRoutingTable);
                        () -> new ParameterizedMessage("{} unexpected error during deletion of unallocated shard", shardId),
            // make sure shard is really there before register cluster state observer
            clusterName.writeTo(out);
/*
        public void handleException(TransportException exp) {
                                        "failed send response for shard active while trying to "
                                    ),
                if (shardActive) {
import org.opensearch.cluster.ClusterStateObserver;
        }
            }
/**
    private static class ShardActiveResponse extends TransportResponse {
import org.opensearch.cluster.ClusterStateListener;
        if (event.state().blocks().disableStatePersistence()) {
 */
                            break;
                return;
    }
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                // shard state change will trigger or be triggered by a cluster state change.
 * software distributed under the License is distributed on an
                );
                            break;
                boolean shardActive = shardActive(indexShard);
            this.clusterStateVersion = clusterStateVersion;
import org.opensearch.transport.TransportRequest;
 */
            state.getVersion(),
                    IndicesService.ShardDeletionCheckResult shardDeletionCheckResult = indicesService.canDeleteShardContent(
 * Unless required by applicable law or agreed to in writing,
                        IndexMetadata indexMetadata = event.state().getMetadata().getIndexSafe(indexRoutingTable.getIndex());
                                logger.error(
                return false;
        public ShardActiveResponse read(StreamInput in) throws IOException {
            ACTION_SHARD_EXISTS,
        ClusterService clusterService,
            if (localNodeId.equals(shardRouting.currentNodeId())) {
        @Override
    private class ShardActiveResponseHandler implements TransportResponseHandler<ShardActiveResponse> {
}
import java.util.ArrayList;
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
                        @Override
        private IndexShard getShard(ShardActiveRequest request) {
 * compatible open source license.
    public IndicesStore(
import org.opensearch.common.settings.Setting.Property;
        // a shard can be deleted if all its copies are active, and its not allocated on this node
            logger.debug(() -> new ParameterizedMessage("shards active request failed for {}", shardId), exp);
        ShardActiveResponse(boolean shardActive, DiscoveryNode node) {
        }
    }
        // Doesn't make sense to delete shards on non-data nodes
            }
            this.shardActive = shardActive;
            if (shardRouting.started() == false) {
                channel.sendResponse(new ShardActiveResponse(false, clusterService.localNode()));
import org.opensearch.core.index.shard.ShardId;
                );
import org.opensearch.common.collect.Tuple;
                new Tuple<>(currentNode, new ShardActiveRequest(clusterName, indexUUID, shardRouting.shardId(), deleteShardTimeout))
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                        // the shard is not there in which case we want to send back a false (shard is not active),
            new ShardActiveRequestHandler()
            return false;
    private final ClusterService clusterService;
        }
                    "shard exists request meant for cluster[{}], but this is cluster[{}], ignoring request",
        ClusterName clusterName = state.getClusterName();
 * ownership. Elasticsearch licenses this file to you under
    static boolean shardCanBeDeleted(String localNodeId, IndexShardRoutingTable indexShardRoutingTable) {
            return false;
import java.util.concurrent.TimeUnit;
            out.writeLong(timeout.millis());
            // also it's good in general to let things settle down
        private final AtomicInteger activeCopies;
        }
        }
     *
import org.opensearch.indices.IndicesService;
        new TimeValue(30, TimeUnit.SECONDS),
        TransportService transportService,
    private final Set<ShardId> folderNotFoundCache = new HashSet<>();
            clusterService.removeListener(this);
    private static class ShardActiveRequest extends TransportRequest {
        ShardActiveRequest(ClusterName clusterName, String indexUUID, ShardId shardId, TimeValue timeout) {
                        // information from there. we don't do it because we would have to write another method for this
    }
                        // that would have the same effect
            indexUUID = in.readString();
        // - removing shard data of deleted indices is handled by IndicesClusterStateService
     */
     * The shard active response
                        indexSettings = new IndexSettings(indexMetadata, settings);
        // remove entries from cache that don't exist in the routing table anymore (either closed or deleted indices)
            for (ShardRouting routing : localRoutingNode) {
    private final Settings settings;
        }
            if (indexService != null && indexService.indexUUID().equals(request.indexUUID)) {
                    "not deleting shard {}, the latest cluster state version[{}] is not equal to cluster state "
        Property.NodeScope
        ShardActiveRequest(StreamInput in) throws IOException {
            return null;
import org.opensearch.cluster.routing.IndexRoutingTable;
            logger.trace("{} sending shard active check to {}", request.v2().shardId, request.v1());
                    if (indexService == null) {
import org.opensearch.cluster.routing.RoutingTable;
        public void messageReceived(final ShardActiveRequest request, final TransportChannel channel, Task task) throws Exception {
import org.opensearch.tasks.Task;
        public String executor() {
        RoutingNode localRoutingNode = event.state().getRoutingNodes().node(localNodeId);
    @Override
            }
            }
        this.deleteShardTimeout = INDICES_STORE_DELETE_SHARD_TIMEOUT.get(settings);
            this.node = node;
        }
        this.settings = settings;
                        IndexShard currentShard = getShard(request);
    }
            shardId = new ShardId(in);
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
        Settings settings,
