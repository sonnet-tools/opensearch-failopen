                }
                            task,
                                    "primary term ["
            String allocationId,
    public static final Setting<Priority> FOLLOW_UP_REROUTE_PRIORITY_SETTING = new Setting<>(
        followUpRerouteTaskPriority = FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(clusterService.getSettings());
        final String message,
                "shard-started " + request,
     */
                                task,
        public NoLongerPrimaryShardException(StreamInput in) throws IOException {
        }
                        r -> logger.trace("{}, reroute completed", reason),
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        public String getAllocationId() {
     * be necessary to raise this higher to recover the older behaviour of rerouting after processing every shard-started task. Deliberately
                        // same as above, this might have been a stale in-flight request, so we just ignore.
                    } else {
        TransportRequest request,
                                task.primaryTerm,
        @Override
     * Send a shard failed request to the cluster-manager node to update the cluster state when a shard on the local node failed.
                        } else {
import java.util.Objects;
import org.opensearch.transport.TransportService;
            out.writeBoolean(markAsStale);
                                + "] but current is ["
    private void setFollowUpRerouteTaskPriority(Priority followUpRerouteTaskPriority) {
    /**
            return batchResultBuilder.build(maybeUpdatedState);
        final String message;
    public static final String SHARD_STARTED_ACTION_NAME = "internal:cluster/shard/started";
            .addSettingsUpdateConsumer(FOLLOW_UP_REROUTE_PRIORITY_SETTING, this::setFollowUpRerouteTaskPriority);
        StartedShardEntry entry = new StartedShardEntry(shardRouting.shardId(), shardRouting.allocationId().getId(), primaryTerm, message);
                components.add("failure [" + ExceptionsHelper.detailedMessage(failure) + "]");
                // we wait indefinitely for a new cluster-manager
            allocationId = in.readString();
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
                        if (currentPrimaryTerm != task.primaryTerm) {
        );
    public static class ShardStartedClusterStateTaskExecutor
            public void onClusterServiceClose() {
        FailedShardEntry(StreamInput in) throws IOException {
    /**
    ) {
        @Nullable
        @Nullable final Exception failure,
                                channelException
                                    "{} failed to send failure [{}] while failing shard [{}]",
            List<StartedShardEntry> tasksToBeApplied = new ArrayList<>();
    public static class StartedShardEntry extends TransportRequest {
                            );
import org.apache.logging.log4j.LogManager;
                            logger.warn(
            channel.sendResponse(TransportResponse.Empty.INSTANCE);
            components.add("primary term [" + primaryTerm + "]");
        implements
                    ShardRouting matched = currentState.getRoutingTable().getByAllocationId(task.shardId, task.allocationId);
                            channel.sendResponse(e);
    public void remoteShardFailed(
        private final ClusterService clusterService;
                batchResultBuilder.successes(tasksToBeApplied);
            rerouteService.reroute(
                    // ignore these requests for now.
                    // The primary term is 0 if the shard failed itself. It is > 0 if a write was done on a primary but was failed to be
    }
        final ShardId shardId,
                    if (matched.initializing() == false) {
            RerouteService rerouteService,
                    builder.success(task);
            "priority [" + priority + "] not supported for [" + FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey() + "]"
    @Inject
        public int hashCode() {
            transportService.sendRequest(clusterManagerNode, actionName, request, new EmptyTransportResponseHandler(ThreadPool.Names.SAME) {
import org.opensearch.cluster.ClusterStateTaskExecutor;
            super(in);
                                ),
            long primaryTerm,
                                    ? exp.getCause()
            this.failure = failure;
            ClusterStateTaskListener {
                        logger.warn(
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
        );
                                + currentPrimaryTerm
    private static boolean isClusterManagerChannelException(TransportException exp) {
                            logger.debug(
            if (numberOfUnassignedShards > 0) {
                                + "])";
     */
        final ActionListener<Void> listener,
        @Nullable final Exception failure,
            0L,
            case HIGH:
        public FailedShardEntry(
                }
            clusterService.submitStateUpdateTask(
        }
    }
    public static class FailedShardEntry extends TransportRequest {
        @Override
 * Unless required by applicable law or agreed to in writing,
            } catch (Exception e) {
                            batchResultBuilder.failure(
                                + "current cluster state (received ["
        final ShardRouting shardRouting,
        ) {
     * @param markAsStale        whether or not to mark a failing shard as stale (eg. removing from in-sync set) when failing the shard.
import org.opensearch.core.common.io.stream.StreamOutput;
        this.followUpRerouteTaskPriority = followUpRerouteTaskPriority;
                "reroute after starting shards",
 */
            List<StaleShard> staleShardsToBeApplied = new ArrayList<>();
        assert primaryTerm > 0L : "primary term should be strictly positive";
                                        + task.primaryTerm
            new FailedShardEntry(shardId, allocationId, primaryTerm, message, failure, markAsStale),
            return String.format(
 */
public class ShardStateAction {
    ) {
 * under the License.
        FailedShardEntry shardEntry = new FailedShardEntry(
    );
import org.opensearch.cluster.ClusterChangedEvent;
                            logger.warn(
            for (StartedShardEntry task : tasks) {
            );
                        final long currentPrimaryTerm = indexMetadata.primaryTerm(task.shardId.id());
                )
import org.apache.logging.log4j.message.ParameterizedMessage;
        public ShardStartedClusterStateTaskExecutor(
                            e
     *
                            tasksToBeApplied.add(task);
package org.opensearch.cluster.action.shard;
                request,
                prioritySupplier.get(),
            ShardFailedClusterStateTaskExecutor shardFailedClusterStateTaskExecutor,
                        );
                batchResultBuilder.failures(tasksToBeApplied, e);
        }
        String actionName,
                                        + "]"
            } else {
import org.opensearch.common.inject.Inject;
            )
        final long primaryTerm;
 *
     *
import org.opensearch.cluster.routing.RerouteService;
 * @opensearch.internal
                logger.debug(() -> new ParameterizedMessage("failure during [{}]", source), e);
        public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {
        final String message,
    }
                new ClusterStateTaskListener() {
                assert false;
                                + "] but current is ["
                            );
            }
     *
            out.writeVLong(primaryTerm);
            List<FailedShardEntry> tasksToBeApplied = new ArrayList<>();
        boolean markAsStale,
            try {
        private final ShardFailedClusterStateTaskExecutor shardFailedClusterStateTaskExecutor;
                                () -> new ParameterizedMessage(
                            shardRoutingsToBeApplied.add(matched);
        final ClusterState currentState
        ) {
            this.shardId = shardId;
                            );
            int numberOfUnassignedShards = clusterChangedEvent.state().getRoutingNodes().unassigned().size();
 *
                            exp
    public ShardStateAction(
    /**
                } else {
        String allocationId,
            // Exclude message and exception from equals and hashCode
        ) {
     * @opensearch.internal
import org.opensearch.threadpool.ThreadPool;
        final String message,
                                    request.shardId,
                        // they were failed is because a write made it into the primary but not to this copy (which corresponds to
        }
                    )
            this.shardId = shardId;
/**
                    if (isClusterManagerChannelException(exp)) {
                                )
            Supplier<Priority> prioritySupplier,
                        assert indexMetadata != null;
                                task.shardId,
                        try {
            assert tasksToBeApplied.size() >= shardRoutingsToBeApplied.size();
        ClusterService clusterService,
        }
            }
                                + "])";
     */
                                task,
            return Objects.hash(shardId, allocationId, primaryTerm, markAsStale);
import java.util.function.Predicate;
            logger.debug(() -> new ParameterizedMessage("{} received shard failed for {}", request.shardId, request), request.failure);
            allocationId = in.readString();
        public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {
        ActionListener<Void> listener,
import org.opensearch.core.index.shard.ShardId;
                public void handleResponse(TransportResponse.Empty response) {
    }
        FailedToCommitClusterStateException.class };
        }
        } else {
            );
     * Adjusts the priority of the followup reroute task. NORMAL is right for reasonable clusters, but in a badly configured cluster it may
                                matched
                maybeUpdatedState = allocationService.applyStartedShards(currentState, shardRoutingsToBeApplied);
            this.prioritySupplier = prioritySupplier;
                                channelException
        final long primaryTerm,
                        }
        );
            public void onTimeout(TimeValue timeout) {
    }
        }
                    // tasks that correspond to non-existent indices are marked as successful
    private static Priority parseReroutePriority(String priorityString) {
        localShardFailed(shardRouting, message, failure, listener, clusterService.state());
     * does not exist anymore but still has an entry in the in-sync set, remove its allocation id from the in-sync set.
import org.apache.logging.log4j.Logger;
        final Exception failure;
                clusterService,
            clusterService.submitStateUpdateTask(
            setShard(shardId);
            this.rerouteService = rerouteService;
                public void handleException(TransportException exp) {
    private final TransportRequestDeduplicator<FailedShardEntry> remoteFailedShardsDeduplicator = new TransportRequestDeduplicator<>();
/*
     */
            ThreadPool.Names.SAME,
                // assign it again, even if that means putting it back on the node on which it previously failed:
     * try for started shard.
            shardId.writeTo(out);
import java.util.ArrayList;
     * @param listener           callback upon completion of the request
            shardRouting.allocationId().getId(),
        transportService.registerRequestHandler(
            super(in);
                                    request
import org.opensearch.transport.ConnectTransportException;
    public static class NoLongerPrimaryShardException extends OpenSearchException {
                    @Override
            components.add("shard id [" + shardId + "]");
        final ActionListener<Void> listener
        private final Logger logger;
import org.opensearch.core.action.ActionListener;
        @Override
                builder.failures(tasksToBeApplied, e);
            components.add("allocation id [" + allocationId + "]");
        final long primaryTerm;
 * this work for additional information regarding copyright
            this.rerouteService = rerouteService;
    }
            }
        ConnectTransportException.class,
        return remoteFailedShardsDeduplicator.size();
            super(in);
        private final Supplier<Priority> prioritySupplier;
    private static class ShardStartedTransportHandler implements TransportRequestHandler<StartedShardEntry> {
                                        + currentPrimaryTerm
                && primaryTerm == that.primaryTerm
    }
import java.util.HashSet;
     * undocumented, since this is a last-resort escape hatch for experts rather than something we want to expose to anyone, and deprecated
 * software distributed under the License is distributed on an
    public void shardStarted(
            SHARD_STARTED_ACTION_NAME,
        }
        }
        public ShardId getShardId() {
    }
        ShardFailedTransportHandler(
                // failures are communicated back to the requester
        }
        ActionListener<Void> listener
import java.util.function.Supplier;
import org.opensearch.cluster.routing.ShardRouting;
        }
     * @opensearch.internal
import org.opensearch.cluster.routing.allocation.AllocationService;
     *
        );
            if (e instanceof FailedToCommitClusterStateException || e instanceof NotClusterManagerException) {
                        } catch (Exception channelException) {
                    // primary unnecessarily fail currently active shards.
            this.logger = logger;
        // visible for testing
        "cluster.routing.allocation.shard_state.reroute.priority",
            shardRouting.shardId(),
            ShardStartedClusterStateTaskExecutor shardStartedClusterStateTaskExecutor,
    /**
                    }
                    listener.onResponse(null);
import java.util.Locale;
            List<FailedShard> failedShardsToBeApplied = new ArrayList<>();
            out.writeVLong(primaryTerm);
                shardId,
        this.transportService = transportService;
                        }
        ActionListener<Void> listener
        }
    /**
                sendShardAction(actionName, state, request, listener);
                        }
                primaryTerm,
            AllocationService allocationService,
                maybeUpdatedState = applyFailedShards(currentState, failedShardsToBeApplied, staleShardsToBeApplied);
                        }
                        Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(task.shardId.id());
                                    request.shardId,
                                + task.primaryTerm
            this.logger = logger;
            new ShardStartedTransportHandler(
            this.markAsStale = markAsStale;
            primaryTerm = in.readVLong();
                    public void onNoLongerClusterManager(String source) {
        }, changePredicate);
                        long currentPrimaryTerm = indexMetadata.primaryTerm(task.shardId.id());
            ShardId shardId,
                                task.shardId,
 *
                        final IndexMetadata indexMetadata = currentState.metadata().index(task.shardId.getIndex());
     * A transport handler for a shard failed action.
            @Nullable Exception failure,
        DiscoveryNode clusterManagerNode = currentState.nodes().getClusterManagerNode();
                                "unexpected failure while sending request [{}]" + " to [{}] for shard entry [{}]",
                        try {
     *
 * license agreements. See the NOTICE file distributed with
    public static class ShardFailedClusterStateTaskExecutor implements ClusterStateTaskExecutor<FailedShardEntry> {
        ClusterStateObserver observer = new ClusterStateObserver(currentState, clusterService, null, logger, threadPool.getThreadContext());
import org.opensearch.transport.TransportRequestHandler;
                    batchResultBuilder.success(task);
            out.writeException(failure);
import java.util.Set;
        public boolean equals(Object o) {
            super(msg);
                        if (seenShardRoutings.contains(matched)) {
        }
import org.opensearch.OpenSearchException;
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.core.transport.TransportResponse;
                && Objects.equals(this.allocationId, that.allocationId)
                            channelException.addSuppressed(e);
            this.shardFailedClusterStateTaskExecutor = shardFailedClusterStateTaskExecutor;
                // cluster state will not be updated in this case
            return shardId;
            ClusterTasksResult.Builder<StartedShardEntry> builder = ClusterTasksResult.builder();
import java.io.IOException;
                    }
            this.allocationId = allocationId;
                            tasksToBeApplied.add(task);
                @Override
            return allocationId;
        public void writeTo(StreamOutput out) throws IOException {
    private static class ShardFailedTransportHandler implements TransportRequestHandler<FailedShardEntry> {
            this.primaryTerm = primaryTerm;
                        // mark shard copies without routing entries that are in in-sync allocations set only as stale if the reason why
     * since we will remove it once we have confirmed from experience that this priority is appropriate in all cases.
            this.message = in.readString();
        private final ClusterService clusterService;
        private final Logger logger;
            String message,
                            matched
                logger
import org.opensearch.transport.EmptyTransportResponseHandler;
                                request
    private static final Logger logger = LogManager.getLogger(ShardStateAction.class);
                            "{} ignoring shard started task [{}] (shard exists but is not initializing: {})",
        Priority.NORMAL.toString(),
        sendShardAction(SHARD_FAILED_ACTION_NAME, currentState, shardEntry, listener);
                final ShardRouting matched = currentState.getRoutingTable().getByAllocationId(task.shardId, task.allocationId);
                if (logger.isTraceEnabled()) {
            StartedShardEntry::new,
     * Error thrown when a shard is no longer primary.
import org.opensearch.cluster.routing.allocation.StaleShard;
                listener.onFailure(new NodeClosedException(clusterService.localNode()));
            );
            this.logger = logger;
            @Override
                        assert matched.active() : "expected active shard routing for task " + task + " but found " + matched;
        ClusterStateObserver observer,
        final String message;
        clusterService.getClusterSettings()
            Logger logger
        RerouteService rerouteService,
            Set<ShardRouting> seenShardRoutings = new HashSet<>(); // to prevent duplicates
                                new NoLongerPrimaryShardException(
     * Entry for a failed shard.
            listener,
 */
        private final Logger logger;
        ShardStateAction::parseReroutePriority,
                            logger.debug("{} marking shard {} as stale (shard failed task: [{}])", task.shardId, task.allocationId, task);
                                : exp
                    // replicated to the shard copy with the provided allocation id. In case where the shard failed itself, it's ok to just
            }
        );
            FailedShardEntry::new,
                            // tasks that correspond to non-existent shards are marked as successful
            out.writeString(allocationId);
        public void onFailure(String source, Exception e) {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.unit.TimeValue;
        final String message,
                        } else {
                // no other options for a failed shard then it is left unassigned. However, absent other options it's better to try and
            return builder.build(maybeUpdatedState);
 * not use this file except in compliance with the License.
            @Override
            List<ShardRouting> shardRoutingsToBeApplied = new ArrayList<>(tasks.size());
            this.allocationService = allocationService;
            primaryTerm = in.readVLong();
            out.writeString(allocationId);
    final ClusterService clusterService;
import org.opensearch.cluster.ClusterStateTaskListener;
        StartedShardEntry(StreamInput in) throws IOException {
                            staleShardsToBeApplied.add(new StaleShard(task.shardId, task.allocationId));
            return allocationService.applyFailedShards(currentState, failedShards, staleShards);
                        }
                        // failing a shard also possibly marks it as stale (see IndexMetadataUpdater)
            this.allocationId = allocationId;
        final ShardId shardId;
        final ClusterState currentState,
        @Override
    }
                            logger.debug("{} ignoring shard failed task [{}] (shard does not exist anymore)", task.shardId, task);
                logger.trace("{}, scheduling a reroute", reason);
                ClusterStateTaskConfig.build(Priority.URGENT),
                            logger.debug(
            Logger logger
            shardId = new ShardId(in);
            this.clusterService = clusterService;
                shardStartedClusterStateTaskExecutor
                        );
            this.logger = logger;
                shardStartedClusterStateTaskExecutor,
     * @param allocationId       allocation id of the shard to fail
    ) {
            ClusterState maybeUpdatedState = currentState;
        final Priority priority = Priority.valueOf(priorityString.toUpperCase(Locale.ROOT));
        ) {
    /**
    }
                @Override
     */
            message = in.readString();
    }
     *
                                clusterManagerNode,
    private void sendShardAction(
                            );
                    r -> logger.trace("reroute after starting shards succeeded"),
     * Executor if shard fails cluster state task.
            shardId.writeTo(out);
                    }
                        tasksToBeApplied.add(task);
import org.opensearch.cluster.ClusterState;
                IndexMetadata indexMetadata = currentState.metadata().index(task.shardId.getIndex());
        final ClusterState currentState
                    }
                    // events on every cluster state publishing that does not contain the shard as started yet. This means that old stale
                rerouteService.reroute(
            Supplier<Priority> prioritySupplier,
                        builder.success(task);
        }
                    reason,
                        logger.debug("{} failing shard {} (shard failed task: [{}])", task.shardId, matched, task);
    // a list of shards that failed during replication
                            builder.success(task);
        public StartedShardEntry(final ShardId shardId, final String allocationId, final long primaryTerm, final String message) {
                        // remove duplicate actions as allocation service expects a clean list without duplicates
                                ),
    ) {
        private final Supplier<Priority> prioritySupplier;
        }
     * Handler for a shard started action.
                        failedShardsToBeApplied.add(new FailedShard(matched, task.message, task.failure, task.markAsStale));
            waitForNewClusterManagerAndRetry(actionName, observer, request, listener, changePredicate);
import org.opensearch.cluster.ClusterManagerNodeChangePredicate;
    public void localShardFailed(
 *
                                    "{} failed to send no longer cluster-manager while failing shard [{}]",
        public String toString() {
        ShardStartedTransportHandler(
        Setting.Property.Dynamic,
            }
        @Override
        long primaryTerm,
    public static final String SHARD_FAILED_ACTION_NAME = "internal:cluster/shard/failure";
    protected void waitForNewClusterManagerAndRetry(
        @Override
        final ShardId shardId;
        Setting.Property.Deprecated
                    public void onFailure(String source, Exception e) {
                "shard-failed",
     * @opensearch.internal
                            batchResultBuilder.success(task);
                        }
                                actionName,
            }
 * Registers transport actions that react to shard state changes, such as shard started or shard failed.
                                currentPrimaryTerm
                            () -> new ParameterizedMessage("{} unexpected failure while failing shard [{}]", request.shardId, request),
import org.opensearch.cluster.service.ClusterService;
                    e -> logger.debug("reroute after starting shards failed", e)
                    }
            RerouteService rerouteService,
        }
                        listener.onFailure(
     * Send a shard failed request to the cluster-manager node to update the cluster state with the failure of a shard on another node. This means
            AllocationService allocationService,
                logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
            }
        return ExceptionsHelper.unwrap(exp, CLUSTER_MANAGER_CHANNEL_EXCEPTIONS) != null;
import org.opensearch.transport.TransportRequest;
                    // tasks that correspond to non-existent shards are marked as successful. The reason is that we resend shard started
import org.opensearch.common.Priority;
                                "{} ignoring shard started task [{}] (primary term {} does not match current term {})",
                                channelException
import org.opensearch.common.Nullable;
    /**
 * ownership. Elasticsearch licenses this file to you under
            this.message = message;
                    @Override
    ) {
            ThreadPool.Names.SAME,
            this.primaryTerm = primaryTerm;
import org.opensearch.ExceptionsHelper;
        public void messageReceived(StartedShardEntry request, TransportChannel channel, Task task) throws Exception {
            SHARD_FAILED_ACTION_NAME,
        }
import org.opensearch.transport.TransportChannel;
            out.writeString(message);
                }
        @Override
                    }
            ClusterStateTaskExecutor<StartedShardEntry>,
                            channel.sendResponse(TransportResponse.Empty.INSTANCE);
        @Override
                );
                            ),
            ClusterService clusterService,
        AllocationService allocationService,
        if (clusterManagerNode == null) {
                                + currentPrimaryTerm
            )
    public void shardStarted(
            @Override
                                "{} ignoring shard started task [{}] (already scheduled to start {})",
            }
                                        + "] did not match current primary term ["
        Predicate<ClusterState> changePredicate
            true
                                () -> new ParameterizedMessage(
        }
            super.writeTo(out);
            if (failure != null) {
            logger.debug("sending [{}] to [{}] for shard entry [{}]", actionName, clusterManagerNode.getId(), request);
            failure = in.readException();
            components.add("markAsStale [" + markAsStale + "]");
    // we keep track of these shards in order to avoid sending duplicate failed shard requests for a single failing shard.
 * You may obtain a copy of the License at
                    } else {
    /**
        }
                        );
                            new ParameterizedMessage(
     * @opensearch.internal
            case URGENT:
            FailedShardEntry that = (FailedShardEntry) o;
import org.opensearch.transport.RemoteTransportException;
     *
                // The reroute called after failing some shards will not assign any shard back to the node on which it failed. If there were
 * KIND, either express or implied.  See the License for the
     * @param shardId            shard id of the shard to fail
 * GitHub history for details.
                    logger.debug("{} ignoring shard started task [{}] (shard does not exist anymore)", task.shardId, task);
            return Objects.equals(this.shardId, that.shardId)
                                task.shardId,
                        }
    }
    private static Class[] CLUSTER_MANAGER_CHANNEL_EXCEPTIONS = new Class[] {
        switch (priority) {
                            tasksToBeApplied.add(task);
                            assert currentPrimaryTerm > task.primaryTerm : "received a primary term with a higher term than in the "
    }
        private final RerouteService rerouteService;
                        if (task.primaryTerm > 0 && inSyncAllocationIds.contains(task.allocationId)) {
                            assert currentPrimaryTerm > task.primaryTerm : "received a primary term with a higher term than in the "
        public void writeTo(StreamOutput out) throws IOException {
            return String.join(", ", components);
                ClusterStateTaskConfig.build(Priority.HIGH),
                message
     */
            for (FailedShardEntry task : tasks) {
     * @opensearch.internal
                            seenShardRoutings.add(matched);
        public String toString() {
        shardStarted(shardRouting, primaryTerm, message, listener, clusterService.state());
    /**
            message,
     */
                        logger.debug(
        }
                                task.primaryTerm,
    }
import org.opensearch.cluster.NotClusterManagerException;
        private final AllocationService allocationService;
                                ),
                logger
                        logger.error("{} no longer cluster-manager while failing shard [{}]", request.shardId, request);
        ActionListener<Void> listener,
    /**
     * Send a shard failed request to the cluster-manager node to update the cluster state when a shard on the local node failed.
        }
        final String allocationId;
        @Override
import org.opensearch.node.NodeClosedException;
    }
     *
import org.opensearch.core.common.io.stream.StreamInput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            ClusterState maybeUpdatedState = currentState;
 * The OpenSearch Contributors require contributions made to
                                "{} failing shard failed task [{}] (primary term {} does not match current term {})",
                if (indexMetadata == null) {
                        );
                                    request
                if (matched == null) {
     * @opensearch.internal
            assert tasksToBeApplied.size() == failedShardsToBeApplied.size() + staleShardsToBeApplied.size();
            (req, reqListener) -> sendShardAction(SHARD_FAILED_ACTION_NAME, clusterService.state(), req, reqListener)
                new ShardFailedClusterStateTaskExecutor(allocationService, rerouteService, () -> followUpRerouteTaskPriority, logger),
        Setting.Property.NodeScope,
        sendShardAction(SHARD_STARTED_ACTION_NAME, currentState, entry, listener);
        observer.waitForNextChange(new ClusterStateObserver.Listener() {
        @Override
                    prioritySupplier.get(),
import org.opensearch.tasks.Task;
        public ClusterTasksResult<StartedShardEntry> execute(ClusterState currentState, List<StartedShardEntry> tasks) throws Exception {
 */
        TransportService transportService,
                            task.shardId,
        private final AllocationService allocationService;
        final String allocationId;
            new ShardFailedTransportHandler(
    ) {
                    // requests might still be in flight even after the shard has already been started or failed on the cluster-manager. We
                "StartedShardEntry{shardId [%s], allocationId [%s], primary term [%d], message [%s]}",
                    logger.trace("new cluster state [{}] after waiting for cluster-manager election for shard entry [{}]", state, request);
 * the Apache License, Version 2.0 (the "License"); you may
                                ? (Exception) (exp.getCause() instanceof Exception
                                    e,
        remoteFailedShardsDeduplicator.executeOnce(
                            logger.warn(
            shardId = new ShardId(in);
                        } catch (Exception channelException) {
import java.util.List;
    public void localShardFailed(
                    // however, it is important to ensure that the shard copy with the missing write is considered as stale from that point
        public NoLongerPrimaryShardException(ShardId shardId, String msg) {
                new ShardStartedClusterStateTaskExecutor(allocationService, rerouteService, () -> followUpRerouteTaskPriority, logger),
            List<String> components = new ArrayList<>(6);
            logger.warn("no cluster-manager known for action [{}] for shard entry [{}]", actionName, request);
                ActionListener.wrap(
 * this file be licensed under the Apache-2.0 license or a
                    if (matched == null) {
import org.opensearch.transport.TransportRequestDeduplicator;
    int remoteShardFailedCacheSize() {
        final ShardRouting shardRouting,
                            channel.sendResponse(new NotClusterManagerException(source));
        final TransportRequest request,
        public void messageReceived(FailedShardEntry request, TransportChannel channel, Task task) throws Exception {
            ClusterTasksResult.Builder<FailedShardEntry> batchResultBuilder = ClusterTasksResult.builder();
    }
    private volatile Priority followUpRerouteTaskPriority;
        ThreadPool threadPool
                        } catch (Exception channelException) {
 * Modifications Copyright OpenSearch Contributors. See
                    // just
     * @param message            the reason for the failure
                }
                        try {
                    } else {
        @Override
        public ClusterTasksResult<FailedShardEntry> execute(ClusterState currentState, List<FailedShardEntry> tasks) throws Exception {
        this.threadPool = threadPool;
                            );
        public ShardFailedClusterStateTaskExecutor(
            boolean markAsStale
                                    "{} failed to send response while failing shard [{}]",
        final String message,
                        logger.error(
            ClusterService clusterService,
            markAsStale = in.readBoolean();
                    if (task.primaryTerm > 0) {
                            );
        ) {
                shardFailedClusterStateTaskExecutor,
    private final ThreadPool threadPool;
        throw new IllegalArgumentException(
     */
                logger.warn(() -> new ParameterizedMessage("failed to apply started shards {}", shardRoutingsToBeApplied), e);
            });
    }
            this.allocationService = allocationService;
     * Executor for when shard starts cluster state.
                        if (currentPrimaryTerm != task.primaryTerm) {
        final String actionName,
                                    : new OpenSearchException(exp.getCause()))
            );
                return priority;
        final ActionListener<Void> listener
                                    request
                clusterService,
                }
                            continue;
                    // We check here that the primary to which the write happened was not already failed in an earlier cluster state update.
    }
            super.writeTo(out);
 * compatible open source license.
        }
        private final RerouteService rerouteService;
                    // remove the corresponding routing entry from the routing table. In case where a write could not be replicated,
import org.opensearch.transport.TransportException;
        NotClusterManagerException.class,
            public void onNewClusterState(ClusterState state) {
import org.opensearch.cluster.routing.allocation.FailedShard;
                    ActionListener.wrap(
        @Override
        }
        final ShardRouting shardRouting,
/*
        transportService.registerRequestHandler(
                } else {
    }
                    // This prevents situations where a new primary has already been selected and replication failures from an old stale
                        e -> logger.debug(new ParameterizedMessage("{}, reroute failed", reason), e)
                            );
                                + "current cluster state (received ["
import org.opensearch.cluster.ClusterStateObserver;
     */
}
 * specific language governing permissions and limitations
        Predicate<ClusterState> changePredicate = ClusterManagerNodeChangePredicate.build(currentState);
                                indexMetadata.primaryTerm(task.shardId.id())
     * that the shard should be failed because a write made it into the primary but was not replicated to this shard copy. If the shard
            }
                            logger.debug("{} starting shard {} (shard started task: [{}])", task.shardId, matched, task);
            this.clusterService = clusterService;
                request,
            try {
                }
                                    task.shardId,
                            logger.trace(
     * @param failure            the underlying cause of the failure
    /**
                                + task.primaryTerm
            if (this == o) return true;
            logger.debug("{} received shard started for [{}]", request.shardId, request);
        this.clusterService = clusterService;
            Logger logger
                    @Override
            this.shardStartedClusterStateTaskExecutor = shardStartedClusterStateTaskExecutor;
                && markAsStale == that.markAsStale;
                            exp instanceof RemoteTransportException
        }
    ) {
     */
                                task,
        private final ShardStartedClusterStateTaskExecutor shardStartedClusterStateTaskExecutor;
/*
    ) {
                    // on, which is implemented by removing the allocation id of the shard copy from the in-sync allocations set.
 * SPDX-License-Identifier: Apache-2.0
        @Override
                    }
                                task,
                            continue;
                        waitForNewClusterManagerAndRetry(actionName, observer, request, listener, changePredicate);
            if (o == null || getClass() != o.getClass()) return false;
            components.add("message [" + message + "]");
        }
                final String reason = String.format(Locale.ROOT, "[%d] unassigned shards after failing shards", numberOfUnassignedShards);
            Logger logger
        private final Logger logger;
                allocationId,
     * @opensearch.internal
                    if (matched.primary() && task.primaryTerm > 0) {
                                () -> new ParameterizedMessage(
import org.opensearch.common.settings.Setting;
        final boolean markAsStale;
            failure,
            this.message = message;
        final long primaryTerm,
                    logger.debug("{} ignoring shard failed task [{}] (unknown index {})", task.shardId, task, task.shardId.getIndex());
import org.opensearch.cluster.ClusterStateTaskConfig;
                                    request.shardId,
            this.prioritySupplier = prioritySupplier;
                logger.warn(() -> new ParameterizedMessage("failed to apply failed shards {}", failedShardsToBeApplied), e);
        }
        }
        final ShardRouting shardRouting,
    // visible for testing
                        // the check "primaryTerm > 0").
     */
        }
                    }
            } catch (Exception e) {
            out.writeString(message);
        @Nullable final Exception failure,
        ClusterState applyFailedShards(ClusterState currentState, List<FailedShard> failedShards, List<StaleShard> staleShards) {
                Locale.ROOT,
     * @param primaryTerm        the primary term associated with the primary shard that is failing the shard. Must be strictly positive.
                logger.warn("node closed while execution action [{}] for shard entry [{}]", actionName, request);
 * Licensed to Elasticsearch under one or more contributor
            case NORMAL:
                builder.successes(tasksToBeApplied);
    private final TransportService transportService;
