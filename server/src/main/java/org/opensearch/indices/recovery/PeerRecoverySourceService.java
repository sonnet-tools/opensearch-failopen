                        handler = existingHandler;
                }
                        throw new DelayRecoveryException(  
        synchronized void remove(IndexShard shard, RecoverySourceHandler handler) {  
            ThreadPool.Names.GENERIC,
        private final class ShardRecoveryContext {  
                    emptyListeners = new ArrayList<>();
        );
                StartRecoveryRequest request,
                StartRecoveryRequest request,
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
                    }  
                nodeToHandlers.computeIfPresent(removed.targetNode(), (k, handlersForNode) -> {
 * this file be licensed under the Apache-2.0 license or a
                }  
                    if (existingHandler.getRequest().recoveryId() == request.recoveryId()
        }
                return handlers;
        if (request.isPrimaryRelocation()  
 * The OpenSearch Contributors require contributions made to  
            IndexShard shard,
import org.opensearch.ExceptionsHelper;  
                for (RecoverySourceHandler handlers : shardRecoveryContext.recoveryHandlers.keySet()) {
                    final List<ActionListener<Void>> onEmptyListeners = emptyListeners;
        }  
        }
import org.opensearch.common.Nullable;  
            if (removed != null) {
            final ShardRecoveryContext shardRecoveryContext = ongoingRecoveries.get(shard);
import java.util.Collection;
 */  
        }
        );
        );
            final Map<RecoverySourceHandler, RemoteRecoveryTargetHandler> recoveryHandlers = new HashMap<>();
    }  
 * Licensed to Elasticsearch under one or more contributor  
            indicesService.clusterService().removeListener(this);  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
                    return handlersForNode;  
                assert nodeToHandlers.getOrDefault(removed.targetNode(), Collections.emptySet()).contains(removed)
    @Override
            Actions.START_RECOVERY,  
                    throw new ResourceNotFoundException(  
import org.opensearch.action.support.PlainActionFuture;  
    private final RecoverySettings recoverySettings;  
            assert lifecycle.started();
import java.util.HashSet;
                for (RemoteRecoveryTargetHandler handler : handlers) {
                final Tuple<RecoverySourceHandler, RemoteRecoveryTargetHandler> handlers = createRecoverySourceHandler(request, shard);  
            }
             */
                for (RecoverySourceHandler existingHandler : recoveryHandlers.keySet()) {
            ThreadPool.Names.GENERIC,
                if (emptyListeners == null) {
    @Override
import org.opensearch.index.shard.IndexShard;
                RecoverySourceHandler handler;
            ongoingRecoveries.awaitEmpty();
    }  
        transportService.registerRequestHandler(
                request.targetNode()
    protected void doStart() {  
    public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
    private static final Logger logger = LogManager.getLogger(PeerRecoverySourceService.class);
    public static class Actions {
    }
            request.shardId().id(),
                        handlers.cancel(reason);  
    private void recover(StartRecoveryRequest request, ActionListener<RecoveryResponse> listener) {
            final ShardRecoveryContext shardContext = ongoingRecoveries.computeIfAbsent(shard, s -> new ShardRecoveryContext());  
                future = new PlainActionFuture<>();  
                final List<Exception> failures = new ArrayList<>();  
             */
                                + "previous recovery attempt to be cancelled or completed"
            clusterService.addListener(this);  
                throw new PeerRecoveryNotFound(request.recoveryId(), request.shardId(), request.targetAllocationId());
            && (routingEntry.relocating() == false || routingEntry.relocatingNodeId().equals(request.targetNode().getId()) == false)) {
            assert shardRecoveryContext != null : "Shard was not registered [" + shard + "]";
            "[{}][{}] reestablishing recovery {}",
        // node. Upon receiving START_RECOVERY, the source node will initiate the peer recovery.
            final RemoteRecoveryTargetHandler recoveryTargetHandler = handlers.v2();
                    emptyListeners = null;  
            request.shardId().getIndex().getName(),
            synchronized void reestablishRecovery(ReestablishRecoveryRequest request, ActionListener<RecoveryResponse> listener) {
    // exposed for testing
        if (DiscoveryNode.isDataNode(clusterService.getSettings())) {
        transportService.registerRequestHandler(  
                removed.cancel();
        logger.trace(  
/*  
    }
        }
 */
        RecoverySourceHandler handler = ongoingRecoveries.addNewRecovery(request, shard);
                }
            FutureUtils.get(future);  
                        break;
            if (ongoingRecoveries.isEmpty()) {  
            shardContext.reestablishRecovery(request, listener);  
import org.opensearch.transport.TransportChannel;
        final IndexService indexService = indicesService.indexServiceSafe(request.shardId().getIndex());  
        );
import org.opensearch.cluster.routing.ShardRouting;
import java.util.Map;  
            }  
 * You may obtain a copy of the License at  
        if (routingEntry.primary() == false || routingEntry.active() == false) {
            StartRecoveryRequest::new,
    }  
            ) {
                if (ongoingRecoveries.isEmpty()) {  
            }
        }
import org.opensearch.index.IndexService;
 * not use this file except in compliance with the License.
                for (RecoverySourceHandler existingHandler : recoveryHandlers.keySet()) {
        }  
                ExceptionsHelper.maybeThrowRuntimeAndSuppress(failures);
        // action will fail and the target node will send a new START_RECOVERY request.
/*  
        final IndexService indexService = indicesService.indexServiceSafe(request.shardId().getIndex());  
    final class OngoingRecoveries {
 *
        // send a REESTABLISH_RECOVERY. This attempts to reconnect to an existing recovery process taking  
                ongoingRecoveries.remove(shard);
                        shard.recoveryStats().decCurrentAsSource();
    @Override
            for (DiscoveryNode removedNode : event.nodesDelta().removedNodes()) {
                handler = RecoverySourceHandlerFactory.create(shard, recoveryTarget, request, recoverySettings);  
        synchronized void reestablishRecovery(
                }
        }
                if (handler == null) {
    }
    /**  
        }
             * Adds recovery source handler.  
            if (shardContext == null) {  
                RecoverySourceHandler handler = null;  
                    : "Remote recovery was not properly tracked [" + removed + "]";  
 * software distributed under the License is distributed on an
/*
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.util.concurrent.FutureUtils;
import org.opensearch.tasks.Task;  
        final IndexShard shard = indexService.getShard(request.shardId().id());
            private Tuple<RecoverySourceHandler, RemoteRecoveryTargetHandler> createRecoverySourceHandler(
            }  
        ) {  
                recoveryHandlers.put(handlers.v1(), handlers.v2());
            }
        // place on the source node. If the recovery process no longer exists, then the REESTABLISH_RECOVERY
            /**  
package org.opensearch.indices.recovery;
            assert removed != null : "Handler was not registered [" + handler + "]";
        // When the target node wants to start a peer recovery it sends a START_RECOVERY request to the source  
        synchronized void cancel(IndexShard shard, String reason) {  
                        failures.add(ex);
                        "Cannot reestablish recovery, recovery id [" + request.recoveryId() + "] not found."
    private final IndicesService indicesService;
        }  
            new StartRecoveryTransportRequestHandler()  
            }
            final ShardRecoveryContext shardContext = ongoingRecoveries.get(shard);
import org.apache.logging.log4j.Logger;
            ReestablishRecoveryRequest request,  
        void awaitEmpty() {
                        return null;
                return Tuple.tuple(handler, recoveryTarget);
        if (indexShard != null) {  
        final ClusterService clusterService = indicesService.clusterService();  
import org.opensearch.cluster.ClusterChangedEvent;
            ongoingRecoveries.cancel(indexShard, "shard is closed");
    private void reestablish(ReestablishRecoveryRequest request, ActionListener<RecoveryResponse> listener) {
 * KIND, either express or implied.  See the License for the
        public void messageReceived(final ReestablishRecoveryRequest request, final TransportChannel channel, Task task) throws Exception {  
            final PlainActionFuture<Void> future;
    @Inject
            }
import org.opensearch.cluster.node.DiscoveryNode;  
 * SPDX-License-Identifier: Apache-2.0
/**
     *
                if (emptyListeners != null) {
                }  
 *
        ongoingRecoveries.reestablishRecovery(request, shard, listener);  
                final RemoteRecoveryTargetHandler recoveryTarget = new RemoteRecoveryTargetHandler(  
                }  
        private final Map<DiscoveryNode, Collection<RemoteRecoveryTargetHandler>> nodeToHandlers = new HashMap<>();
 */
                "delaying recovery of {} as source shard is not marked yet as relocating to {}",  
            throw new DelayRecoveryException("source shard [" + routingEntry + "] is not an active primary");  
import org.apache.logging.log4j.LogManager;
                    }
    protected void doStop() {
        }  
        @Nullable
            }
        // When the target node's START_RECOVERY request has failed due to a network disconnection, it will
                IndexShard shard
import java.util.HashMap;  
    }
import org.opensearch.transport.TransportRequestHandler;  
                    shard.isRemoteTranslogEnabled() || request.targetNode().isRemoteTranslogStoreNode()
            if (shardRecoveryContext.recoveryHandlers.isEmpty()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    request.shardId(),
    class ReestablishRecoveryTransportRequestHandler implements TransportRequestHandler<ReestablishRecoveryRequest> {
            request.targetNode()  
 * @opensearch.internal  
        logger.trace(
 *
        handler.recoverToTarget(ActionListener.runAfter(listener, () -> ongoingRecoveries.remove(shard, handler)));
        synchronized RecoverySourceHandler addNewRecovery(StartRecoveryRequest request, IndexShard shard) {
        this.recoverySettings = recoverySettings;
            if (handlers != null) {
            reestablish(request, new ChannelActionListener<>(channel, Actions.REESTABLISH_RECOVERY, request));
            return handlers.v1();
                );
 *  
            final Tuple<RecoverySourceHandler, RemoteRecoveryTargetHandler> handlers = shardContext.addNewRecovery(request, shard);
import org.opensearch.common.collect.Tuple;
            synchronized (this) {
        public void messageReceived(final StartRecoveryRequest request, final TransportChannel channel, Task task) throws Exception {
     * The internal actions
import org.opensearch.cluster.ClusterStateListener;
        }
            ReestablishRecoveryRequest::new,  
 * The source recovery accepts recovery requests from other peer shards and start the recovery process from this  
                    try {
            final Collection<RemoteRecoveryTargetHandler> handlers = nodeToHandlers.get(node);  
        private List<ActionListener<Void>> emptyListeners;
        this.indicesService = indicesService;
 * Unless required by applicable law or agreed to in writing,
            logger.debug(
import java.util.List;
import org.opensearch.index.shard.IndexEventListener;  
            synchronized Tuple<RecoverySourceHandler, RemoteRecoveryTargetHandler> addNewRecovery(  
                    } finally {  
                    recoverySettings,
        }
}
    }  
    }
        this.transportService = transportService;  
        }
 * license agreements. See the NOTICE file distributed with
            final RemoteRecoveryTargetHandler removed = shardRecoveryContext.recoveryHandlers.remove(handler);  
        }
            ActionListener<RecoveryResponse> listener
public class PeerRecoverySourceService extends AbstractLifecycleComponent implements IndexEventListener, ClusterStateListener {
     */
            new ReestablishRecoveryTransportRequestHandler()
    final int numberOfOngoingRecoveries() {  
            if (shardRecoveryContext != null) {
        private final Map<IndexShard, ShardRecoveryContext> ongoingRecoveries = new HashMap<>();  
    protected void doClose() {}
                ongoingRecoveries.cancelOnNodeLeft(removedNode);  
        if (DiscoveryNode.isDataNode(clusterService.getSettings())) {
        synchronized void cancelOnNodeLeft(DiscoveryNode node) {
            shard.recoveryStats().incCurrentAsSource();
    public void clusterChanged(ClusterChangedEvent event) {  
        @Override
                    } catch (Exception ex) {
                });
        final IndexShard shard = indexService.getShard(request.shardId().id());
 * ownership. Elasticsearch licenses this file to you under  
            Actions.REESTABLISH_RECOVERY,
             * Adds recovery source handler.
import org.opensearch.ResourceNotFoundException;
                }
            );  
        if (event.nodesRemoved()) {
                        && existingHandler.getRequest().targetAllocationId().equals(request.targetAllocationId())) {  
                    handlersForNode.remove(removed);
            nodeToHandlers.computeIfAbsent(recoveryTargetHandler.targetNode(), k -> new HashSet<>()).add(recoveryTargetHandler);  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
 * compatible open source license.
 * source shard to the target shard.
                    );
                    }
    }
            request.recoveryId()
                    throttleTime -> shard.recoveryStats().addThrottleTime(throttleTime),  
    public PeerRecoverySourceService(TransportService transportService, IndicesService indicesService, RecoverySettings recoverySettings) {
            request.shardId().id(),  
        final ClusterService clusterService = indicesService.clusterService();
                            "recovery with same target already registered, waiting for "
        public static final String START_RECOVERY = "internal:index/shard/recovery/start_recovery";  
        public static final String REESTABLISH_RECOVERY = "internal:index/shard/recovery/reestablish_recovery";
 */  
            recover(request, new ChannelActionListener<>(channel, Actions.START_RECOVERY, request));  
            ) {  
import org.opensearch.cluster.service.ClusterService;
            assert lifecycle.started();
            /**
                    request.recoveryId(),
                    request.targetNode(),
                handler.addListener(listener);
import org.opensearch.common.settings.Settings;
                    if (handlersForNode.isEmpty()) {  
                    }
import org.opensearch.core.action.ActionListener;  
    }  
import org.opensearch.indices.IndicesService;
        return ongoingRecoveries.ongoingRecoveries.size();
                    ActionListener.onResponse(onEmptyListeners, null);
 * GitHub history for details.
            throw new DelayRecoveryException("source shard is not marked yet as relocating to [" + request.targetNode() + "]");
    @Override
            final ShardRecoveryContext shardRecoveryContext = ongoingRecoveries.get(shard);
    }
    final OngoingRecoveries ongoingRecoveries = new OngoingRecoveries();
            request.shardId().getIndex().getName(),
import org.opensearch.common.inject.Inject;
            }
        @Override
                    if (existingHandler.getRequest().targetAllocationId().equals(request.targetAllocationId())) {
            "[{}][{}] starting recovery to {}",  
        final ShardRouting routingEntry = shard.routingEntry();  
    class StartRecoveryTransportRequestHandler implements TransportRequestHandler<StartRecoveryRequest> {  
            }
import org.opensearch.action.support.ChannelActionListener;
import org.opensearch.core.index.shard.ShardId;
 *    http://www.apache.org/licenses/LICENSE-2.0
                shard.recoveryStats().decCurrentAsSource();  
                }
                        );  
            assert lifecycle.stoppedOrClosed();  
                    handler.cancel();  
                    return;
import java.util.Collections;
import java.util.ArrayList;  
import org.opensearch.transport.TransportService;
                    transportService,  
    private final TransportService transportService;
 * specific language governing permissions and limitations
                emptyListeners.add(future);
                IndexShard shard  
            }
                request.shardId(),
 * this work for additional information regarding copyright
     * @opensearch.internal  
