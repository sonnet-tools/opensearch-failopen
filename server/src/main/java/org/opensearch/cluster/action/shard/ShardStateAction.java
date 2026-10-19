import org.opensearch.transport.TransportService;
        final long primaryTerm,  
            out.writeString(allocationId);
                            exp
                @Override
            Logger logger
        }
                        } catch (Exception channelException) {
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
 */
     */
            case URGENT:
            new ShardFailedTransportHandler(
            return allocationService.applyFailedShards(currentState, failedShards, staleShards);  
                            logger.warn(  
            this.rerouteService = rerouteService;  
                    // ignore these requests for now.
    }  
                clusterService,
        final String message,
        }  
            message,
            message = in.readString();
import java.util.Objects;  
    }
                        logger.debug(  
                        }
            "priority [" + priority + "] not supported for [" + FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey() + "]"
        }
        @Nullable
        }, changePredicate);
            if (e instanceof FailedToCommitClusterStateException || e instanceof NotClusterManagerException) {  
        Predicate<ClusterState> changePredicate = ClusterManagerNodeChangePredicate.build(currentState);
                            );
import org.opensearch.cluster.metadata.IndexMetadata;  
 * You may obtain a copy of the License at  
        Setting.Property.NodeScope,  
 *
                builder.failures(tasksToBeApplied, e);
                        } catch (Exception channelException) {  
                if (logger.isTraceEnabled()) {
import org.opensearch.transport.EmptyTransportResponseHandler;
            markAsStale = in.readBoolean();  
    protected void waitForNewClusterManagerAndRetry(
     * Executor for when shard starts cluster state.
        transportService.registerRequestHandler(  
            true
                logger.debug(() -> new ParameterizedMessage("failure during [{}]", source), e);
                        logger.error("{} no longer cluster-manager while failing shard [{}]", request.shardId, request);
                                    request
            clusterService.submitStateUpdateTask(
                ClusterStateTaskConfig.build(Priority.URGENT),
                            ),
        );  
            primaryTerm = in.readVLong();
                            tasksToBeApplied.add(task);
     * Error thrown when a shard is no longer primary.  
            return batchResultBuilder.build(maybeUpdatedState);
            components.add("message [" + message + "]");
     */
                            continue;  
        throw new IllegalArgumentException(
        final ShardRouting shardRouting,
    }  
    }
            case HIGH:  
        }
        ShardStateAction::parseReroutePriority,
    }
                logger  
        }
            shardId.writeTo(out);
        @Override
        assert primaryTerm > 0L : "primary term should be strictly positive";  
        ClusterStateObserver observer,  
        ClusterService clusterService,  
                        if (task.primaryTerm > 0 && inSyncAllocationIds.contains(task.allocationId)) {
    }
        private final RerouteService rerouteService;  
 * SPDX-License-Identifier: Apache-2.0
            )
                }
                        Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(task.shardId.id());  
                    if (matched == null) {
                }
        private final AllocationService allocationService;
    private final TransportRequestDeduplicator<FailedShardEntry> remoteFailedShardsDeduplicator = new TransportRequestDeduplicator<>();
            super(in);
                    }
    public void localShardFailed(  
        private final Supplier<Priority> prioritySupplier;
import org.opensearch.ExceptionsHelper;
                    if (matched.initializing() == false) {  
        final ActionListener<Void> listener
            ThreadPool.Names.SAME,
                            logger.warn(
                logger.warn(() -> new ParameterizedMessage("failed to apply failed shards {}", failedShardsToBeApplied), e);
        TransportService transportService,
        }
/*  
            }
                )  
            Logger logger  
                if (matched == null) {
        }  
        );
     * Send a shard failed request to the cluster-manager node to update the cluster state when a shard on the local node failed.
     * @param primaryTerm        the primary term associated with the primary shard that is failing the shard. Must be strictly positive.  
import org.opensearch.cluster.ClusterStateObserver;  
        public void messageReceived(StartedShardEntry request, TransportChannel channel, Task task) throws Exception {  
    private static class ShardFailedTransportHandler implements TransportRequestHandler<FailedShardEntry> {
                        long currentPrimaryTerm = indexMetadata.primaryTerm(task.shardId.id());
    }
            this.allocationService = allocationService;  
        public NoLongerPrimaryShardException(StreamInput in) throws IOException {
                        logger.debug("{} failing shard {} (shard failed task: [{}])", task.shardId, matched, task);  
                shardId,  
                batchResultBuilder.successes(tasksToBeApplied);
                    builder.success(task);  
        ) {
        final ShardRouting shardRouting,
            out.writeString(allocationId);
        private final AllocationService allocationService;  
            this.rerouteService = rerouteService;
        final String actionName,
     */
            String message,
    }  
        ActionListener<Void> listener,
                message  
            new FailedShardEntry(shardId, allocationId, primaryTerm, message, failure, markAsStale),
            shardId = new ShardId(in);
            super.writeTo(out);
        ClusterStateObserver observer = new ClusterStateObserver(currentState, clusterService, null, logger, threadPool.getThreadContext());  
import org.opensearch.tasks.Task;
 * The OpenSearch Contributors require contributions made to  
                    // tasks that correspond to non-existent shards are marked as successful. The reason is that we resend shard started  
import java.io.IOException;
}
    }  
                        // the check "primaryTerm > 0").  
                public void handleException(TransportException exp) {  
    /**
                Locale.ROOT,
                                channelException
                            () -> new ParameterizedMessage("{} unexpected failure while failing shard [{}]", request.shardId, request),
                ActionListener.wrap(  
     * @opensearch.internal
                        } else {
    }
                maybeUpdatedState = allocationService.applyStartedShards(currentState, shardRoutingsToBeApplied);  
    public void shardStarted(
     *  
    /**  
        @Override  
            boolean markAsStale  
                // assign it again, even if that means putting it back on the node on which it previously failed:  
            case NORMAL:
    }
            );
                            channel.sendResponse(new NotClusterManagerException(source));  
    private static class ShardStartedTransportHandler implements TransportRequestHandler<StartedShardEntry> {
        @Nullable final Exception failure,  
                    // The primary term is 0 if the shard failed itself. It is > 0 if a write was done on a primary but was failed to be
        }
import org.opensearch.cluster.ClusterStateTaskConfig;
import org.opensearch.cluster.routing.ShardRouting;  
                if (indexMetadata == null) {
    ) {
    /**
            StartedShardEntry::new,
                    // We check here that the primary to which the write happened was not already failed in an earlier cluster state update.  
        @Override  
            shardRouting.shardId(),
                    } else {
            this.shardId = shardId;
                            new ParameterizedMessage(
    private void setFollowUpRerouteTaskPriority(Priority followUpRerouteTaskPriority) {
        shardStarted(shardRouting, primaryTerm, message, listener, clusterService.state());
                    logger.trace("new cluster state [{}] after waiting for cluster-manager election for shard entry [{}]", state, request);  
     */
            this.logger = logger;
                shardStartedClusterStateTaskExecutor
    }  
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.common.unit.TimeValue;  
            this.primaryTerm = primaryTerm;
import org.opensearch.cluster.routing.allocation.AllocationService;
            Supplier<Priority> prioritySupplier,
 * specific language governing permissions and limitations
            }
    public void shardStarted(
                            matched
        Predicate<ClusterState> changePredicate  
            }
                                    request.shardId,
        public void onFailure(String source, Exception e) {
                "shard-failed",
                            seenShardRoutings.add(matched);  
        private final Supplier<Priority> prioritySupplier;  
                // failures are communicated back to the requester
            for (StartedShardEntry task : tasks) {  
            public void onTimeout(TimeValue timeout) {  
        private final ShardStartedClusterStateTaskExecutor shardStartedClusterStateTaskExecutor;
        final long primaryTerm;
        localShardFailed(shardRouting, message, failure, listener, clusterService.state());  
        @Nullable final Exception failure,  
    }
                    )  
                // we wait indefinitely for a new cluster-manager
                            );
        ) {
    /**  
        private final Logger logger;
        }
            FailedShardEntry::new,  
        final ClusterState currentState,
                        // mark shard copies without routing entries that are in in-sync allocations set only as stale if the reason why
     * @param shardId            shard id of the shard to fail
            shardId.writeTo(out);  
 * the Apache License, Version 2.0 (the "License"); you may
     *
    ) {  
        ActionListener<Void> listener
            for (FailedShardEntry task : tasks) {  
        }
            List<FailedShard> failedShardsToBeApplied = new ArrayList<>();  
        public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {
    public static class StartedShardEntry extends TransportRequest {
                components.add("failure [" + ExceptionsHelper.detailedMessage(failure) + "]");
     * Handler for a shard started action.
            assert tasksToBeApplied.size() >= shardRoutingsToBeApplied.size();
import org.opensearch.transport.TransportRequestDeduplicator;  
        @Override
 * Modifications Copyright OpenSearch Contributors. See
            } else {
                    prioritySupplier.get(),
                            channel.sendResponse(e);
        final String message;
                    batchResultBuilder.success(task);
import org.opensearch.node.NodeClosedException;  
    // visible for testing  
    }
                builder.successes(tasksToBeApplied);
        ThreadPool threadPool
        public FailedShardEntry(  
            }
                            );  
                                + "])";  
                        // remove duplicate actions as allocation service expects a clean list without duplicates
            try {
 * ownership. Elasticsearch licenses this file to you under  
                }
                    // This prevents situations where a new primary has already been selected and replication failures from an old stale
        final ActionListener<Void> listener,
     *
        public ShardStartedClusterStateTaskExecutor(  
    }
                            logger.debug("{} ignoring shard failed task [{}] (shard does not exist anymore)", task.shardId, task);
                    // remove the corresponding routing entry from the routing table. In case where a write could not be replicated,  
        final ClusterState currentState  
                            );
     * @param listener           callback upon completion of the request
                logger.trace("{}, scheduling a reroute", reason);
        ConnectTransportException.class,
    private void sendShardAction(  
            }
        public void messageReceived(FailedShardEntry request, TransportChannel channel, Task task) throws Exception {
     * that the shard should be failed because a write made it into the primary but was not replicated to this shard copy. If the shard
            @Nullable Exception failure,
     * Adjusts the priority of the followup reroute task. NORMAL is right for reasonable clusters, but in a badly configured cluster it may  
        final ShardId shardId;
import org.opensearch.common.inject.Inject;
                    e -> logger.debug("reroute after starting shards failed", e)
            transportService.sendRequest(clusterManagerNode, actionName, request, new EmptyTransportResponseHandler(ThreadPool.Names.SAME) {
                            task.shardId,
 * GitHub history for details.
     * @opensearch.internal
                            );  
    private volatile Priority followUpRerouteTaskPriority;
                                indexMetadata.primaryTerm(task.shardId.id())
            super(in);  
            ClusterState maybeUpdatedState = currentState;
                                + currentPrimaryTerm
     */
        StartedShardEntry entry = new StartedShardEntry(shardRouting.shardId(), shardRouting.allocationId().getId(), primaryTerm, message);
                    if (isClusterManagerChannelException(exp)) {
        }
            channel.sendResponse(TransportResponse.Empty.INSTANCE);  
            assert tasksToBeApplied.size() == failedShardsToBeApplied.size() + staleShardsToBeApplied.size();  
        @Override
                                )
            out.writeVLong(primaryTerm);  
        }
                            continue;  
                            e
     * A transport handler for a shard failed action.  
            this.primaryTerm = primaryTerm;  
                                channelException  
    /**
import org.opensearch.cluster.node.DiscoveryNode;
                } else {
        final ShardRouting shardRouting,
                                        + currentPrimaryTerm
                // The reroute called after failing some shards will not assign any shard back to the node on which it failed. If there were
                                "{} failing shard failed task [{}] (primary term {} does not match current term {})",
                shardFailedClusterStateTaskExecutor,
            components.add("markAsStale [" + markAsStale + "]");  
                                task.primaryTerm,
                    }
        public int hashCode() {
     * Send a shard failed request to the cluster-manager node to update the cluster state when a shard on the local node failed.
    ) {
        }  
            if (failure != null) {  
                        logger.error(  
                rerouteService.reroute(  
            this.shardStartedClusterStateTaskExecutor = shardStartedClusterStateTaskExecutor;
        }  
            clusterService.submitStateUpdateTask(
        this.clusterService = clusterService;
            setShard(shardId);
            List<ShardRouting> shardRoutingsToBeApplied = new ArrayList<>(tasks.size());
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashSet;  
    private static boolean isClusterManagerChannelException(TransportException exp) {
        private final Logger logger;
        FailedShardEntry shardEntry = new FailedShardEntry(
    ) {
                    }  
            return Objects.equals(this.shardId, that.shardId)
                                    ? exp.getCause()
        }
                                + currentPrimaryTerm
                    }
        // visible for testing
        transportService.registerRequestHandler(
                "reroute after starting shards",
                batchResultBuilder.failures(tasksToBeApplied, e);
                    ActionListener.wrap(  
    private final TransportService transportService;  
                                    request  
    }  
            }  
 * this work for additional information regarding copyright
                            task,  
     * @param allocationId       allocation id of the shard to fail
import org.opensearch.cluster.NotClusterManagerException;
                public void handleResponse(TransportResponse.Empty response) {
                request,
        ShardFailedTransportHandler(  
 * compatible open source license.
            }  
        this.transportService = transportService;  
            ClusterStateTaskListener {  
        public String getAllocationId() {
                        }
                        } catch (Exception channelException) {
import org.opensearch.cluster.ClusterState;
                listener.onFailure(new NodeClosedException(clusterService.localNode()));
import java.util.function.Supplier;  
                                task.shardId,  
                        } else {
import org.opensearch.transport.TransportRequestHandler;
                    }
     */
        @Override
                        if (currentPrimaryTerm != task.primaryTerm) {  
                // no other options for a failed shard then it is left unassigned. However, absent other options it's better to try and
 *  
                "StartedShardEntry{shardId [%s], allocationId [%s], primary term [%d], message [%s]}",
            out.writeException(failure);
     * @opensearch.internal  
        clusterService.getClusterSettings()
    public void remoteShardFailed(  
            List<StartedShardEntry> tasksToBeApplied = new ArrayList<>();  
 * not use this file except in compliance with the License.
            rerouteService.reroute(  
            this.clusterService = clusterService;
    ) {
                        listener.onFailure(
                        try {
        ) {
            this.message = message;
                                + "])";
     * Executor if shard fails cluster state task.
                    // just  
    ) {
                        // failing a shard also possibly marks it as stale (see IndexMetadataUpdater)
        final String allocationId;
            @Override
            try {  
        sendShardAction(SHARD_STARTED_ACTION_NAME, currentState, entry, listener);  
        followUpRerouteTaskPriority = FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(clusterService.getSettings());
                logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);  
        }  
                    public void onFailure(String source, Exception e) {
                        try {
     * @param failure            the underlying cause of the failure  
            Supplier<Priority> prioritySupplier,  
            logger.warn("no cluster-manager known for action [{}] for shard entry [{}]", actionName, request);
            ClusterService clusterService,
                                ),
import org.opensearch.transport.ConnectTransportException;  
                new ClusterStateTaskListener() {  
    final ClusterService clusterService;
    /**
        Setting.Property.Deprecated
                                + "] but current is ["  
            listener,  
     *
            public void onClusterServiceClose() {  
        }
            this.logger = logger;
                                new NoLongerPrimaryShardException(  
/*  
import org.opensearch.transport.TransportRequest;
                new ShardStartedClusterStateTaskExecutor(allocationService, rerouteService, () -> followUpRerouteTaskPriority, logger),
            this.clusterService = clusterService;  
 * under the License.  
                            builder.success(task);
                clusterService,
            this.allocationId = allocationId;
        final long primaryTerm,  
                    // tasks that correspond to non-existent indices are marked as successful  
            return Objects.hash(shardId, allocationId, primaryTerm, markAsStale);  
                final ShardRouting matched = currentState.getRoutingTable().getByAllocationId(task.shardId, task.allocationId);
        return ExceptionsHelper.unwrap(exp, CLUSTER_MANAGER_CHANNEL_EXCEPTIONS) != null;
    int remoteShardFailedCacheSize() {
        private final ShardFailedClusterStateTaskExecutor shardFailedClusterStateTaskExecutor;  
            return String.join(", ", components);
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        final String allocationId;  
        switch (priority) {
        public ClusterTasksResult<FailedShardEntry> execute(ClusterState currentState, List<FailedShardEntry> tasks) throws Exception {  
    ) {
            }  
                        failedShardsToBeApplied.add(new FailedShard(matched, task.message, task.failure, task.markAsStale));
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.ClusterStateTaskListener;  
        RerouteService rerouteService,  
            new ShardStartedTransportHandler(  
                                + task.primaryTerm
                        builder.success(task);  
        final String message,
                        }
                            logger.trace(
                    if (task.primaryTerm > 0) {  
import org.apache.logging.log4j.LogManager;
            ShardStartedClusterStateTaskExecutor shardStartedClusterStateTaskExecutor,  
                            assert currentPrimaryTerm > task.primaryTerm : "received a primary term with a higher term than in the "  
                    listener.onResponse(null);
            this.allocationId = allocationId;  
     * since we will remove it once we have confirmed from experience that this priority is appropriate in all cases.  
import org.opensearch.cluster.ClusterManagerNodeChangePredicate;
        @Override  
            out.writeString(message);  
                "shard-started " + request,  
    public void localShardFailed(  
import org.opensearch.transport.TransportException;
        final TransportRequest request,  
                        );  
                shardStartedClusterStateTaskExecutor,  
            super(in);  
        final String message,
import org.apache.logging.log4j.message.ParameterizedMessage;  
        public ShardFailedClusterStateTaskExecutor(
                assert false;
                                "unexpected failure while sending request [{}]" + " to [{}] for shard entry [{}]",  
            int numberOfUnassignedShards = clusterChangedEvent.state().getRoutingNodes().unassigned().size();
import org.apache.logging.log4j.Logger;
            logger.debug("sending [{}] to [{}] for shard entry [{}]", actionName, clusterManagerNode.getId(), request);
            @Override
        private final ClusterService clusterService;  
            });
                                    request.shardId,
                        }
 */  
                                currentPrimaryTerm  
                            channelException.addSuppressed(e);
            } catch (Exception e) {  
     * does not exist anymore but still has an entry in the in-sync set, remove its allocation id from the in-sync set.
    public ShardStateAction(
    /**
        public ClusterTasksResult<StartedShardEntry> execute(ClusterState currentState, List<StartedShardEntry> tasks) throws Exception {
                                    : new OpenSearchException(exp.getCause()))
                        r -> logger.trace("{}, reroute completed", reason),
    private final ThreadPool threadPool;
            Set<ShardRouting> seenShardRoutings = new HashSet<>(); // to prevent duplicates
import org.opensearch.cluster.routing.allocation.FailedShard;
                        e -> logger.debug(new ParameterizedMessage("{}, reroute failed", reason), e)
                    @Override
            this.message = in.readString();  
                maybeUpdatedState = applyFailedShards(currentState, failedShardsToBeApplied, staleShardsToBeApplied);
                        // they were failed is because a write made it into the primary but not to this copy (which corresponds to
    /**  
                        if (currentPrimaryTerm != task.primaryTerm) {
            allocationId = in.readString();
        @Override
                                ),
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
            ClusterState maybeUpdatedState = currentState;
import org.opensearch.common.settings.Setting;
            RerouteService rerouteService,
        }
    ) {  
            if (o == null || getClass() != o.getClass()) return false;
        );
        public ShardId getShardId() {
     * @opensearch.internal
    public static class NoLongerPrimaryShardException extends OpenSearchException {
                        try {  
    );  
 *     http://www.apache.org/licenses/LICENSE-2.0
        "cluster.routing.allocation.shard_state.reroute.priority",  
                }  
     * @opensearch.internal
        }
            this.allocationService = allocationService;
                        assert indexMetadata != null;
     * @opensearch.internal  
            out.writeBoolean(markAsStale);
                                + "current cluster state (received ["
            logger.debug(() -> new ParameterizedMessage("{} received shard failed for {}", request.shardId, request), request.failure);  
                    if (matched.primary() && task.primaryTerm > 0) {
            this.logger = logger;
        final Exception failure;
import org.opensearch.cluster.ClusterStateTaskExecutor;
 * Licensed to Elasticsearch under one or more contributor  
                logger.warn("node closed while execution action [{}] for shard entry [{}]", actionName, request);
import java.util.ArrayList;
            if (numberOfUnassignedShards > 0) {  
                            exp instanceof RemoteTransportException
        public String toString() {  
                                actionName,
     */
                    r -> logger.trace("reroute after starting shards succeeded"),
        public NoLongerPrimaryShardException(ShardId shardId, String msg) {  
                            logger.debug("{} marking shard {} as stale (shard failed task: [{}])", task.shardId, task.allocationId, task);
                    // on, which is implemented by removing the allocation id of the shard copy from the in-sync allocations set.
                    reason,
        final ShardId shardId,
            List<StaleShard> staleShardsToBeApplied = new ArrayList<>();
            if (this == o) return true;  
import org.opensearch.core.transport.TransportResponse;
        final String message,
        final long primaryTerm;
            this.failure = failure;  
        private final RerouteService rerouteService;
                                + task.primaryTerm  
                            // tasks that correspond to non-existent shards are marked as successful  
            logger.debug("{} received shard started for [{}]", request.shardId, request);
        sendShardAction(SHARD_FAILED_ACTION_NAME, currentState, shardEntry, listener);  
                            logger.debug("{} starting shard {} (shard started task: [{}])", task.shardId, matched, task);  
                        tasksToBeApplied.add(task);
                                    "{} failed to send response while failing shard [{}]",
            FailedShardEntry that = (FailedShardEntry) o;
            ClusterTasksResult.Builder<FailedShardEntry> batchResultBuilder = ClusterTasksResult.builder();
                                clusterManagerNode,
            } catch (Exception e) {
    private static Class[] CLUSTER_MANAGER_CHANNEL_EXCEPTIONS = new Class[] {
    @Inject
                    public void onNoLongerClusterManager(String source) {  
        implements
        final boolean markAsStale;  
            return allocationId;  
                                ),
            shardRouting.allocationId().getId(),  
                            channel.sendResponse(TransportResponse.Empty.INSTANCE);
            Logger logger  
        }  
            failure,  
        ShardStartedTransportHandler(
                final String reason = String.format(Locale.ROOT, "[%d] unassigned shards after failing shards", numberOfUnassignedShards);
     * Send a shard failed request to the cluster-manager node to update the cluster state with the failure of a shard on another node. This means  
        }
                        }
                        );
        ) {
public class ShardStateAction {
            this.shardId = shardId;
                            "{} ignoring shard started task [{}] (shard exists but is not initializing: {})",
                                task.primaryTerm,
            AllocationService allocationService,
                                task,
     */  
                primaryTerm,
 *
                            logger.debug(  
import org.opensearch.core.action.ActionListener;
                            );
    private static Priority parseReroutePriority(String priorityString) {
            out.writeVLong(primaryTerm);
    // a list of shards that failed during replication  
                } else {  
        StartedShardEntry(StreamInput in) throws IOException {
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
                                request  
                            logger.debug(
                sendShardAction(actionName, state, request, listener);
    private static final Logger logger = LogManager.getLogger(ShardStateAction.class);  
                && Objects.equals(this.allocationId, that.allocationId)
import java.util.Locale;
     * @param markAsStale        whether or not to mark a failing shard as stale (eg. removing from in-sync set) when failing the shard.
            failure = in.readException();
                                    e,  
        }  
                                    task.shardId,
                    // requests might still be in flight even after the shard has already been started or failed on the cluster-manager. We
                        final long currentPrimaryTerm = indexMetadata.primaryTerm(task.shardId.id());
        Priority.NORMAL.toString(),
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.transport.TransportChannel;  
                                task,  
        @Nullable final Exception failure,  
     */  
     *
                    }
    // we keep track of these shards in order to avoid sending duplicate failed shard requests for a single failing shard.
                            shardRoutingsToBeApplied.add(matched);
                        // same as above, this might have been a stale in-flight request, so we just ignore.
                allocationId,
                                "{} ignoring shard started task [{}] (primary term {} does not match current term {})",
        NotClusterManagerException.class,  
                    } else {  
        this.followUpRerouteTaskPriority = followUpRerouteTaskPriority;
            components.add("primary term [" + primaryTerm + "]");
        final ShardId shardId;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ClusterChangedEvent;  
            String allocationId,
        final ClusterState currentState
    }
        @Override
        this.threadPool = threadPool;
        DiscoveryNode clusterManagerNode = currentState.nodes().getClusterManagerNode();
        FailedToCommitClusterStateException.class };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final String message,
                    // primary unnecessarily fail currently active shards.
    public static class ShardStartedClusterStateTaskExecutor  
import java.util.function.Predicate;
                                    request.shardId,  
            ThreadPool.Names.SAME,
                                task,
                                        + task.primaryTerm  
 */  
                    ShardRouting matched = currentState.getRoutingTable().getByAllocationId(task.shardId, task.allocationId);
                && markAsStale == that.markAsStale;
                                        + "] did not match current primary term ["
            .addSettingsUpdateConsumer(FOLLOW_UP_REROUTE_PRIORITY_SETTING, this::setFollowUpRerouteTaskPriority);  
     *
            @Override  
                    // however, it is important to ensure that the shard copy with the missing write is considered as stale from that point
                            tasksToBeApplied.add(task);  
            );
import org.opensearch.common.Nullable;
                                + "] but current is ["
                        );  
        String allocationId,
            super(msg);
/*
        }
                        final IndexMetadata indexMetadata = currentState.metadata().index(task.shardId.getIndex());  
                        if (seenShardRoutings.contains(matched)) {  
        AllocationService allocationService,
 *
        final Priority priority = Priority.valueOf(priorityString.toUpperCase(Locale.ROOT));  
        );  
        return remoteFailedShardsDeduplicator.size();  
import org.opensearch.cluster.routing.allocation.StaleShard;  
                );
            Logger logger
                                    request
        @Override
        ClusterState applyFailedShards(ClusterState currentState, List<FailedShard> failedShards, List<StaleShard> staleShards) {
            ClusterService clusterService,
            )
            this.prioritySupplier = prioritySupplier;  
                logger
        ) {
            allocationId = in.readString();
            return builder.build(maybeUpdatedState);
            (req, reqListener) -> sendShardAction(SHARD_FAILED_ACTION_NAME, clusterService.state(), req, reqListener)
            this.message = message;
        final String message;  
                IndexMetadata indexMetadata = currentState.metadata().index(task.shardId.getIndex());
        final ActionListener<Void> listener
    public static final Setting<Priority> FOLLOW_UP_REROUTE_PRIORITY_SETTING = new Setting<>(
        @Override
                        assert matched.active() : "expected active shard routing for task " + task + " but found " + matched;
                logger.warn(() -> new ParameterizedMessage("failed to apply started shards {}", shardRoutingsToBeApplied), e);  
     * try for started shard.  
        }
                                        + "]"  
     * @param message            the reason for the failure
                            );  
        String actionName,
                prioritySupplier.get(),
                                : exp  
/**
        final ShardRouting shardRouting,
 * software distributed under the License is distributed on an
        ActionListener<Void> listener
    public static final String SHARD_STARTED_ACTION_NAME = "internal:cluster/shard/started";
            // Exclude message and exception from equals and hashCode  
                        logger.warn(
        public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {
            RerouteService rerouteService,
    }  
                    } else {
     * undocumented, since this is a last-resort escape hatch for experts rather than something we want to expose to anyone, and deprecated
 * @opensearch.internal
            ShardId shardId,
        }
                        }  
import java.util.Set;
 * Registers transport actions that react to shard state changes, such as shard started or shard failed.  
                }  
        ActionListener<Void> listener,
                                    "primary term ["
                return priority;
            }
                        );
    }
                        }
     * be necessary to raise this higher to recover the older behaviour of rerouting after processing every shard-started task. Deliberately
            components.add("allocation id [" + allocationId + "]");  
     *  
import org.opensearch.cluster.routing.RerouteService;
        }
            super.writeTo(out);  
                    // replicated to the shard copy with the provided allocation id. In case where the shard failed itself, it's ok to just
import org.opensearch.core.common.io.stream.StreamOutput;  
        TransportRequest request,
            List<FailedShardEntry> tasksToBeApplied = new ArrayList<>();
     */
                    @Override
        remoteFailedShardsDeduplicator.executeOnce(
                @Override  
                                "{} ignoring shard started task [{}] (already scheduled to start {})",
                    @Override
import org.opensearch.common.Priority;  
                                () -> new ParameterizedMessage(  
                request,  
            ClusterStateTaskExecutor<StartedShardEntry>,
                // cluster state will not be updated in this case  
                new ShardFailedClusterStateTaskExecutor(allocationService, rerouteService, () -> followUpRerouteTaskPriority, logger),  
        Setting.Property.Dynamic,
                            tasksToBeApplied.add(task);
        FailedShardEntry(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
                            logger.warn(
            shardId = new ShardId(in);  
                        waitForNewClusterManagerAndRetry(actionName, observer, request, listener, changePredicate);
    /**  
        }
                                task.shardId,  
            AllocationService allocationService,  
            this.logger = logger;
                                + "current cluster state (received ["
        }  
import org.opensearch.OpenSearchException;
                    logger.debug("{} ignoring shard started task [{}] (shard does not exist anymore)", task.shardId, task);
                                ? (Exception) (exp.getCause() instanceof Exception  
            );
            this.markAsStale = markAsStale;
    /**
    public static final String SHARD_FAILED_ACTION_NAME = "internal:cluster/shard/failure";  
 */  
     * @opensearch.internal  
                    }  
package org.opensearch.cluster.action.shard;
    public static class ShardFailedClusterStateTaskExecutor implements ClusterStateTaskExecutor<FailedShardEntry> {
                            staleShardsToBeApplied.add(new StaleShard(task.shardId, task.allocationId));
     * Entry for a failed shard.
            return String.format(  
            waitForNewClusterManagerAndRetry(actionName, observer, request, listener, changePredicate);
            ClusterTasksResult.Builder<StartedShardEntry> builder = ClusterTasksResult.builder();
 * Unless required by applicable law or agreed to in writing,
            public void onNewClusterState(ClusterState state) {
                ClusterStateTaskConfig.build(Priority.HIGH),
import java.util.List;
            this.shardFailedClusterStateTaskExecutor = shardFailedClusterStateTaskExecutor;  
            }
    /**  
                                    "{} failed to send failure [{}] while failing shard [{}]",
            out.writeString(message);
                }  
                && primaryTerm == that.primaryTerm  
                    }  
import org.opensearch.transport.RemoteTransportException;
                                () -> new ParameterizedMessage(
            List<String> components = new ArrayList<>(6);
                                channelException  
        );
            ShardFailedClusterStateTaskExecutor shardFailedClusterStateTaskExecutor,
            return shardId;
            this.prioritySupplier = prioritySupplier;
import org.opensearch.cluster.service.ClusterService;
            long primaryTerm,  
                    // events on every cluster state publishing that does not contain the shard as started yet. This means that old stale
            SHARD_STARTED_ACTION_NAME,  
                    logger.debug("{} ignoring shard failed task [{}] (unknown index {})", task.shardId, task, task.shardId.getIndex());
            );
                                () -> new ParameterizedMessage(  
                                matched
                            batchResultBuilder.failure(
        private final Logger logger;
                                    "{} failed to send no longer cluster-manager while failing shard [{}]",
     *
                                task.shardId,
        boolean markAsStale,
            components.add("shard id [" + shardId + "]");
     */  
        @Override
                            batchResultBuilder.success(task);
        long primaryTerm,  
            0L,
        public StartedShardEntry(final ShardId shardId, final String allocationId, final long primaryTerm, final String message) {  
        public String toString() {
            SHARD_FAILED_ACTION_NAME,
    public static class FailedShardEntry extends TransportRequest {
                            assert currentPrimaryTerm > task.primaryTerm : "received a primary term with a higher term than in the "
        private final ClusterService clusterService;
import org.opensearch.threadpool.ThreadPool;
        } else {  
        if (clusterManagerNode == null) {  
        public boolean equals(Object o) {
            primaryTerm = in.readVLong();  
                                task,
        private final Logger logger;
