        this.clusterService = clusterService;
     */
import org.opensearch.index.shard.IndexShardState;
 * Unless required by applicable law or agreed to in writing,
        RoutingTable routingTable = event.state().routingTable();
 */  
    private final ClusterService clusterService;  
                    clusterStateVersion  
                return ACTIVE_STATES.contains(indexShard.state());  
                    activeCopies.get()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
import org.opensearch.cluster.node.DiscoveryNode;
        public void writeTo(StreamOutput out) throws IOException {
            clusterName.writeTo(out);  
                    switch (shardDeletionCheckResult) {  
 */  
        IndicesService indicesService,  
        }
        if (!event.routingTableChanged()) {
            ThreadPool.Names.SAME,  
                    IndicesService.ShardDeletionCheckResult shardDeletionCheckResult = indicesService.canDeleteShardContent(
        this.settings = settings;
            this.expectedActiveCopies = expectedActiveCopies;  
            if (indexShard == null) {  
                        case NO_FOLDER_FOUND:
 *    http://www.apache.org/licenses/LICENSE-2.0
            // Note, closed indices will not have any routing information, so won't be deleted
        Property.NodeScope  
                logger.trace(
        @Override
                    // shard is not active, might be POST_RECOVERY so check if cluster state changed inbetween or wait for next change
                );  
 *  
            return null;
import org.opensearch.cluster.ClusterStateObserver;
    private static final EnumSet<IndexShardState> ACTIVE_STATES = EnumSet.of(IndexShardState.STARTED);  
        }
import java.util.List;
                logger.trace(
            node.writeTo(out);  
        }
            indexShardRoutingTable.shardId(),
                        public void onTimeout(TimeValue timeout) {  
 * GitHub history for details.
            this.shardActive = shardActive;  
 * KIND, either express or implied.  See the License for the
                            }
            // it's easier to do that check when the current cluster state is visible.
                        // the shard is not there in which case we want to send back a false (shard is not active),
        }
import java.util.HashSet;
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {  
                    );
                        case STILL_ALLOCATED:
import org.opensearch.common.settings.Setting;
import org.apache.logging.log4j.LogManager;
        this.threadPool = threadPool;  
                        public void onClusterServiceClose() {
        ShardActiveResponseHandler responseHandler = new ShardActiveResponseHandler(  
                                    () -> new ParameterizedMessage(  
        private final AtomicInteger activeCopies;
 * this work for additional information regarding copyright
 */
        for (Tuple<DiscoveryNode, ShardActiveRequest> request : requests) {
 *
            out.writeString(indexUUID);
                return indexService.getShardOrNull(shardId.id());  
            }
    public static final Setting<TimeValue> INDICES_STORE_DELETE_SHARD_TIMEOUT = Setting.positiveTimeSetting(  
import org.opensearch.transport.TransportChannel;
    );
        public void writeTo(StreamOutput out) throws IOException {
import java.io.Closeable;  
}  
        private ClusterName clusterName;
    public IndicesStore(
            requests.size()  
                                    e
            return false;  
        if (DiscoveryNode.isDataNode(settings)) {
            ShardActiveRequest::new,
            this.clusterName = clusterName;
import org.opensearch.transport.TransportService;
                        case NO_LOCAL_STORAGE:
            }
        // - closed indices don't need to be removed from the cache but we do it anyway for code simplicity
    @Inject  
     *  
        }
        folderNotFoundCache.removeIf(shardId -> !routingTable.hasIndex(shardId.getIndex()));  
    private static final Logger logger = LogManager.getLogger(IndicesStore.class);
                    shardId,
        new TimeValue(30, TimeUnit.SECONDS),
            // shard replication group, in any case, protected from deleting something by mistake
                    }
            ClusterState latestClusterState = clusterService.state();
 * ownership. Elasticsearch licenses this file to you under  
            return ThreadPool.Names.SAME;  
        }  
            clusterService.addListener(this);
            this.clusterStateVersion = clusterStateVersion;
import org.opensearch.transport.TransportResponseHandler;  
                            "not deleting shard {}, the update task state version[{}] is not equal to cluster state before "  
        }
                            clusterStateVersion
        ShardActiveRequest(ClusterName clusterName, String indexUUID, ShardId shardId, TimeValue timeout) {
 *
                        // so the cluster state listener must be notified or the shard is active in which case we want to
                        e
                                        request.shardId  
import org.opensearch.common.settings.Settings;  
        @Override  
            for (ShardRouting routing : localRoutingNode) {
import org.opensearch.cluster.ClusterState;  
        }
            this.node = node;
                        default:
    ) {
            clusterService.removeListener(this);
            return new ShardActiveResponse(in);
                            shardId,
public class IndicesStore implements ClusterStateListener, Closeable {  
            }  
        if (indexShardRoutingTable.size() == 0) {  
                );  
                        return;  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
 */
    public void close() {  
                    }, newState -> {  
import org.opensearch.common.unit.TimeValue;
        }
        @Override  
import org.opensearch.cluster.ClusterChangedEvent;
                    IndexService indexService = indicesService.indexService(indexRoutingTable.getIndex());  
    private class ShardActiveRequestHandler implements TransportRequestHandler<ShardActiveRequest> {
import org.opensearch.indices.IndicesService;
            );  
    private final ThreadPool threadPool;
        for (ShardRouting shardRouting : indexShardRoutingTable) {
        ShardActiveRequest(StreamInput in) throws IOException {  
            if (localNodeId.equals(shardRouting.currentNodeId())) {
                        logger.trace(
            if (indexService != null && indexService.indexUUID().equals(request.indexUUID)) {
            IndexService indexService = indicesService.indexService(shardId.getIndex());
                        public void sendResult(boolean shardActive) {
                        indicesService.deleteShardStore("no longer used", shardId, currentState);  
                    shardId,
        }  
/*  
        public void handleResponse(ShardActiveResponse response) {  
                boolean shardActive = shardActive(indexShard);
        return true;  
        }  
            timeout = new TimeValue(in.readLong(), TimeUnit.MILLISECONDS);
            shardId = new ShardId(in);
        private void allNodesResponded() {  
 *  
                    )
                } else {
                // later we might miss an update and wait forever in case no new cluster state comes in.
    }
                    thisClusterName
    }  
            // check if shard is active on the current node  
                        logger.debug(() -> new ParameterizedMessage("{} failed to delete unallocated shard, ignoring", shardId), ex);
                            deleteShardIfExistElseWhere(event.state(), indexShardRoutingTable);
                            break;
                logger.trace(
import org.opensearch.threadpool.ThreadPool;
                }
                                logger.error(
            }
import org.opensearch.common.settings.Setting.Property;
                    "not deleting shard {}, expected {} active copies, but only {} found active copies",  
                        indexSettings = new IndexSettings(indexMetadata, settings);
        for (IndexRoutingTable indexRoutingTable : routingTable) {
        transportService.registerRequestHandler(
            } else {
 * not use this file except in compliance with the License.
/*  
        // remove entries from cache that don't exist in the routing table anymore (either closed or deleted indices)  
            node = new DiscoveryNode(in);  
                            currentState.getVersion(),  
import org.opensearch.cluster.routing.ShardRouting;  
        }
    public static final String ACTION_SHARD_EXISTS = "internal:index/shard/exists";
                if (shardActive) {
                    observer.waitForNextChange(new ClusterStateObserver.Listener() {  
                return null;
                        indexSettings
                    request.timeout,
        "indices.store.delete.shard.timeout",
                        );
                        () -> new ParameterizedMessage("{} unexpected error during deletion of unallocated shard", shardId),  
        this.deleteShardTimeout = INDICES_STORE_DELETE_SHARD_TIMEOUT.get(settings);
            if (shardRouting.started() == false) {
import org.opensearch.core.transport.TransportResponse;  
                        public void onNewClusterState(ClusterState state) {
                                + "shard active api call [{}]",
                                );  
            }  
                    } else {
 * You may obtain a copy of the License at  
                        @Override
                            // nothing to do  
        }  
        public void handleException(TransportException exp) {  
    // there is no need for a separate public service
        // a shard can be deleted if all its copies are active, and its not allocated on this node
        public String executor() {
                            break;  
        }
            return false;
            this.timeout = timeout;  
            out.writeBoolean(shardActive);
            return;
        }
                    threadPool.getThreadContext()
                channel.sendResponse(new ShardActiveResponse(false, clusterService.localNode()));
                    latestClusterState.getVersion(),
    }
        private final ShardId shardId;
            IndexShard indexShard = getShard(request);  
import org.opensearch.cluster.service.ClusterService;
                );
        private String indexUUID;  
            transportService.sendRequest(request.v1(), ACTION_SHARD_EXISTS, request.v2(), responseHandler);
            logger.trace("{} sending shard active check to {}", request.v2().shardId, request.v1());  
    private final Settings settings;
                                    ),
import java.util.Set;  
     * A shard active request
        }
            shardActive = in.readBoolean();
 * compatible open source license.
            }
            if (awaitingResponses.decrementAndGet() == 0) {  
    }  
            logger.trace("{} is {}active on node {}", shardId, response.shardActive ? "" : "not ", response.node);
        ShardActiveResponse(boolean shardActive, DiscoveryNode node) {
import java.io.IOException;
                        @Override  
                // check if shard is active. if so, all is good  
        }
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.cluster.ClusterStateListener;
    private void deleteShardIfExistElseWhere(ClusterState state, IndexShardRoutingTable indexShardRoutingTable) {  
        public void messageReceived(final ShardActiveRequest request, final TransportChannel channel, Task task) throws Exception {
        ShardActiveResponse(StreamInput in) throws IOException {
        }
        }  
     * The shard active response
        );
            this.activeCopies = new AtomicInteger();  
            }
            super(in);
            this.indexUUID = indexUUID;
                    } catch (Exception ex) {
                // shard state changes explicitly. instead we wait for the cluster state changes because we know any
import org.opensearch.transport.TransportRequest;
            return;  
                ShardId shardId = indexShardRoutingTable.shardId();
     * @opensearch.internal
                new Tuple<>(currentNode, new ShardActiveRequest(clusterName, indexUUID, shardRouting.shardId(), deleteShardTimeout))
            }  
    }  
        ThreadPool threadPool  
    }
                }  
        );  
                        }
                );
                        // information from there. we don't do it because we would have to write another method for this
import org.opensearch.common.collect.Tuple;
            if (awaitingResponses.decrementAndGet() == 0) {
            ACTION_SHARD_EXISTS,
    private static class ShardActiveResponse extends TransportResponse {  
                    }
                return;
 * license agreements. See the NOTICE file distributed with
    private final TimeValue deleteShardTimeout;
        TransportService transportService,
        Settings settings,
    @Override
        private ShardId shardId;
                        IndexShard currentShard = getShard(request);  
import java.util.EnumSet;  
                    "shard exists request meant for cluster[{}], but this is cluster[{}], ignoring request",  
                            assert false : "shard deletion only runs on data nodes which always have local storage";
        private boolean shardActive(IndexShard indexShard) {
        for (ShardRouting shardRouting : indexShardRoutingTable) {  
        private IndexShard getShard(ShardActiveRequest request) {
            }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.shard.IndexShard;  
     *  
                    if (clusterStateVersion != currentState.getVersion()) {
                // create observer here. we need to register it here because we need to capture the current cluster state  
        this.transportService = transportService;
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeLong(timeout.millis());  
                            sendResult(false);
        if (localRoutingNode != null) {
import org.apache.logging.log4j.Logger;
            this.shardId = shardId;
            }
    /**
import org.opensearch.cluster.routing.IndexRoutingTable;
    private class ShardActiveResponseHandler implements TransportResponseHandler<ShardActiveResponse> {
            clusterName = new ClusterName(in);
                        }
/**
 * Licensed to Elasticsearch under one or more contributor  
                                            + "delete shard {} - shard will probably not be removed",
 * SPDX-License-Identifier: Apache-2.0
                    logger,  
        // Doesn't make sense to delete shards on non-data nodes
import org.opensearch.cluster.routing.RoutingTable;
        this.indicesService = indicesService;  
import org.opensearch.tasks.Task;  
                        }
        public ShardActiveResponse read(StreamInput in) throws IOException {
            // be conservative here, check on started, not even active
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
                ClusterStateObserver observer = new ClusterStateObserver(  
                        IndexMetadata indexMetadata = event.state().getMetadata().getIndexSafe(indexRoutingTable.getIndex());  
                                        "failed send response for shard active while trying to "
                        }  
import org.opensearch.cluster.metadata.IndexMetadata;  
            super.writeTo(out);
    public void clusterChanged(ClusterChangedEvent event) {
    static boolean shardCanBeDeleted(String localNodeId, IndexShardRoutingTable indexShardRoutingTable) {
import org.apache.logging.log4j.message.ParameterizedMessage;  
                            sendResult(shardActive(getShard(request)));  
                        // send back that the shard is active here we could also evaluate the cluster state and get the  
                return false;
        if (DiscoveryNode.isDataNode(settings)) {  
                    try {
                );
import org.opensearch.core.common.io.stream.StreamInput;
                    "not deleting shard {}, the latest cluster state version[{}] is not equal to cluster state "
                        // that would have the same effect
                // which will then be compared to the one that is applied when we call waitForNextChange(). if we create it
                        shardId,  
                    channel.sendResponse(new ShardActiveResponse(true, clusterService.localNode()));  
package org.opensearch.indices.store;
            shardId.writeTo(out);
            logger.debug(() -> new ParameterizedMessage("shards active request failed for {}", shardId), exp);
        }
                    });
                return false;  
import org.opensearch.core.common.io.stream.StreamOutput;  
                    }  
                    if (indexService == null) {
    private final TransportService transportService;
                            sendResult(shardActive(getShard(request)));
            // also it's good in general to let things settle down  
        String indexUUID = indexShardRoutingTable.shardId().getIndex().getUUID();
        }
import java.util.concurrent.TimeUnit;
        if (event.state().blocks().disableStatePersistence()) {  
                                channel.sendResponse(new ShardActiveResponse(shardActive, clusterService.localNode()));  
                            try {
        ShardActiveResponseHandler(ShardId shardId, long clusterStateVersion, int expectedActiveCopies) {
                // shard state change will trigger or be triggered by a cluster state change.
            ShardId shardId = request.shardId;  
            DiscoveryNode currentNode = state.nodes().get(shardRouting.currentNodeId());  
/*
import org.opensearch.index.IndexService;
        // - removing shard data of deleted indices is handled by IndicesClusterStateService
        // remove entries from cache which are allocated to this node
import org.opensearch.core.index.shard.ShardId;
            // make sure shard is really there before register cluster state observer
                    final IndexSettings indexSettings;
    @Override  
        RoutingNode localRoutingNode = event.state().getRoutingNodes().node(localNodeId);  
                    (source, e) -> logger.error(
            if (indexShard != null) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.IndexSettings;
            if (response.shardActive) {
    // TODO this class can be foled into either IndicesService and partially into IndicesClusterStateService
        @Override
            // we double check nothing has changed when responses come back from other nodes.
                },
    /**
                            assert false : "unknown shard deletion check result: " + shardDeletionCheckResult;  
                            } catch (IOException | OpenSearchRejectedExecutionException e) {
        protected TimeValue timeout = null;
                allNodesResponded();  
    private final Set<ShardId> folderNotFoundCache = new HashSet<>();
        }
            }
            clusterService.getClusterApplierService()
 * specific language governing permissions and limitations
        final String localNodeId = event.state().nodes().getLocalNodeId();
            this.awaitingResponses = new AtomicInteger(expectedActiveCopies);
            assert shardRouting.started() : "expected started shard but was " + shardRouting;
                        return currentShard == null || shardActive(currentShard);
                .runOnApplierThread("indices_store ([" + shardId + "] active fully on other nodes)", currentState -> {  
                            // nothing to do  
            this.shardId = shardId;  
                    }
import java.util.ArrayList;
                        case FOLDER_FOUND_CAN_DELETE:
                        + "before shard active api call [{}]",  
        List<Tuple<DiscoveryNode, ShardActiveRequest>> requests = new ArrayList<>(indexShardRoutingTable.size());
                return;
        @Override  
        private final long clusterStateVersion;  
    private final IndicesService indicesService;
        }  
 * Store for multiple indexes
                // in general, using a cluster state observer here is a workaround for the fact that we cannot listen on  
 * software distributed under the License is distributed on an
                if (folderNotFoundCache.contains(shardId) == false && shardCanBeDeleted(localNodeId, indexShardRoutingTable)) {
        ClusterService clusterService,
    }
                            break;  
 * under the License.  
        private final DiscoveryNode node;  
import org.opensearch.transport.TransportRequestHandler;
        }
        private final int expectedActiveCopies;
            }  
    private static class ShardActiveRequest extends TransportRequest {  
            }
import org.opensearch.transport.TransportException;  
                activeCopies.incrementAndGet();  
        private final boolean shardActive;
import org.opensearch.common.inject.Inject;  
            ClusterName thisClusterName = clusterService.getClusterName();  
                    clusterService,
            state.getVersion(),
import org.opensearch.cluster.ClusterName;
            if (!thisClusterName.equals(request.clusterName)) {
            indexUUID = in.readString();  
        ClusterName clusterName = state.getClusterName();  
                allNodesResponded();
            if (activeCopies.get() != expectedActiveCopies) {
                            folderNotFoundCache.add(shardId);
            // should not really happen, there should always be at least 1 (primary) shard in a
                    request.clusterName,
    // Cache successful shard deletion checks to prevent unnecessary file system lookups
            requests.add(
            if (clusterStateVersion != latestClusterState.getVersion()) {  
                            break;
    }
     */
            new ShardActiveRequestHandler()
                folderNotFoundCache.remove(routing.shardId());  
        @Override
import org.opensearch.cluster.routing.RoutingNode;
                    expectedActiveCopies,
     * @opensearch.internal
        }
                        indexSettings = indexService.getIndexSettings();  
    }
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
                        @Override
        private final AtomicInteger awaitingResponses;
