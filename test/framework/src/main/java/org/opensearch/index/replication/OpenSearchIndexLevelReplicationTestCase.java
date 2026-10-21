            maxSeqNoOfUpdatesOrDeletes,
            id,
                        assertThat(replica.getMaxSeqNoOfUpdatesOrDeletes(), greaterThanOrEqualTo(primary.getMaxSeqNoOfUpdatesOrDeletes()));
    void deleteOnReplica(BulkShardRequest request, ReplicationGroup group, IndexShard replica) throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            final DiscoveryNode pNode = getDiscoveryNode(primary.routingEntry().currentNodeId());
            id,
        protected void performOnPrimary(IndexShard primary, ResyncReplicationRequest request, ActionListener<PrimaryResult> listener) {
            }
            ) {
            public PrimaryResult(ReplicaRequest replicaRequest, Response finalResponse) {
        }
            activeIds.addAll(activeIds());
        ResyncReplicationRequest request
        final IndexShard primary;
        }
        RetentionLeaseSyncAction.Response> {
        try (Releasable ignored = acquirePermitFuture.actionGet()) {
            final ShardRouting primaryRouting = this.createShardRouting("s0", true);
            IndexShard replica,
            protected EngineFactory getEngineFactory(ShardRouting routing) {
                final long primaryTerm,
        try (Releasable ignored = permitAcquiredFuture.actionGet()) {
                bulkShardResponse -> bulkShardResponse.getResponses()[0]
import org.opensearch.action.support.replication.TransportReplicationAction.ReplicaResponse;
        return executeReplicationRequestOnPrimary(primary, request);
                replicationTargets.addReplica(replica);
        int replicas,
                    throw response.getFailure().getCause();
    ) throws Exception {
import org.opensearch.index.seqno.RetentionLease;
            request
                startPrimary();
        }
                getPrimaryShard().getPendingPrimaryTerm(),
        protected IndexerFactory getIndexerFactory(ShardRouting routing) {
            }
        replica.acquireReplicaOperationPermit(
                primary.sync();
                IndexShard replica = replicationTargets.findReplicaShard(replicaRouting);
                replica.updateRetentionLeasesOnReplica(request.getRetentionLeases());
import org.opensearch.index.translog.Translog;
import java.util.concurrent.FutureTask;
                primaryRouting,
import org.opensearch.index.engine.EngineConfigFactory;
                final BulkItemResponse response = index(indexRequest);
                primaryRouting,
            return routingTable.build();
                Names.WRITE
            });
            final long newTerm = indexMetadata.primaryTerm(shardId.id()) + 1;
 * Modifications Copyright OpenSearch Contributors. See
                    adaptResponse(result.finalResponse, getPrimaryShard());
            for (IndexShard replica : replicas) {
        );
        }
                EMPTY_EVENT_LISTENER,
            DiscoveryNodes.Builder builder = new DiscoveryNodes.Builder();
        protected void performOnPrimary(IndexShard primary, BulkShardRequest request, ActionListener<PrimaryResult> listener) {
            super(request, listener, group, "sync-retention-leases");
                        } catch (final Exception e) {
                primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE
                getPrimary().getMaxSeqNoOfUpdatesOrDeletes(),
                TransportResyncReplicationAction.performOnPrimary(request),
import org.opensearch.indices.recovery.RecoveryTarget;
        long globalCheckpointOnPrimary,
                threadPool,
        BulkShardRequest request,
                retentionLeaseSyncer,
                noopMappingUpdater,
import java.nio.file.Path;
                shardId,
 *
                if (replicaShard.routingEntry().initializing()) {
import static org.hamcrest.Matchers.empty;
        ReplicationTargets(IndexShard primary, List<IndexShard> replicas) {
import org.opensearch.action.support.replication.ReplicatedWriteRequest;
            }
                recoverySettings,
            );
                return new PrimaryResult(result.replicaRequest(), result.finalResponseIfSuccessful);
                        fut.onFailure(e);
            }
            ThreadPool.Names.SAME,
        ReplicationResponse> {
            computeReplicationTargets();
                new GlobalCheckpointSyncAction.Request(replicationGroup.getPrimary().shardId()),
            request,
        }
                getPrimary().getLastKnownGlobalCheckpoint(),
    }
            return newReplica;
                remotePath
            return getPrimary().addRetentionLease(id, retainingSequenceNumber, source, listener);
            updateAllocationIDsOnPrimary();
            DefaultRecoverySettings.INSTANCE,
        }
            return Collections.unmodifiableList(replicas);
                    final List<DocIdSeqNoAndSource> docsOnPrimary = getDocIdAndSeqNos(primary);
        }
                return new PrimaryResult(request, new ReplicationResponse());
                    }),
            maxSeqNoOfUpdatesOrDeletes,
            operationPrimaryTerm,
        private IndexMetadata indexMetadata;
                null
                shardPath,
        }
    private void executeResyncOnReplica(
        String mappings,
            }
import org.opensearch.cluster.node.DiscoveryNodes;
            request,
        }
            primary = replica;
            primary,
                this.replicaRequest = replicaRequest;
        if ("true".equals(settings.get(IndexMetadata.SETTING_REMOTE_STORE_ENABLED))) {
        SyncRetentionLeases(
        IndexMetadata metadata = buildIndexMetadata(replicas, settings, mappings);
                primary,
                ActionListener.wrap(r -> {}, e -> {
        try (Releasable ignored = permitAcquiredFuture.actionGet()) {
 * not use this file except in compliance with the License.
    class SyncRetentionLeases extends ReplicationAction<
        );
        }
            ) {
            public void updateGlobalCheckpointForShard(String allocationId, long globalCheckpoint) {
package org.opensearch.index.replication;
            this.opType = opType;
    protected final Index index = new Index("test", "uuid");
        @Override
import org.opensearch.cluster.node.DiscoveryNodeRole;
        synchronized void addReplica(IndexShard replica) {
        // to be overridden by subclasses
        }
        public synchronized void startAll() throws IOException {
            });
import org.opensearch.cluster.routing.ShardRouting;
        public synchronized void refresh(String source) {
        GlobalCheckpointSyncAction.Request,
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
            Collections.emptyMap(),
        ResyncAction(ResyncReplicationRequest request, ActionListener<ResyncReplicationResponse> listener, ReplicationGroup group) {
            super(request, listener, group, "resync");
        ) throws IOException {
        protected abstract void performOnPrimary(IndexShard primary, Request request, ActionListener<PrimaryResult> listener);
                ActionListener.map(listener, r -> new ReplicationResponse())
        public void recoverReplica(IndexShard replica) throws IOException {
            (request, parentTask, primaryAllocationId, primaryTerm, listener) -> {
        EngineFactory engineFactory,
                throw new AssertionError("failed to execute retention lease request on replica [" + replica.routingEntry() + "]", e);
            }
                logger
            for (IndexShard replica : replicas) {
                temp.removeAll(primaryIds);
import org.opensearch.index.mapper.MapperService;
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id(Integer.toString(docId.incrementAndGet()))
            computeReplicationTargets();
                routingTable,
import org.opensearch.index.seqno.RetentionLeases;
            }
                primary.indexSettings().isRemoteTranslogStoreEnabled()
                getPrimary().getOperationPrimaryTerm(),
    BulkShardRequest deleteOnPrimary(DeleteRequest request, IndexShard primary) throws Exception {
                })
            public ShardRouting routingEntry() {
                .filter(ShardRouting::active)
            final IndexShard replica,
            RetentionLeaseSyncAction.Request request,
import org.opensearch.common.settings.ClusterSettings;
        WriteReplicationAction(BulkShardRequest request, ActionListener<BulkShardResponse> listener, ReplicationGroup replicationGroup) {
            final ReplicaRequest replicaRequest;
        );
 * this work for additional information regarding copyright
        public synchronized IndexShard getPrimary() {
                computeReplicationTargets();
                closed = true;
                null,
        return new ReplicationGroup(metadata, recoverySettings, remotePath, mergedSegmentPublisher) {
            ActionListener<RetentionLeaseSyncAction.Response> listener
        public synchronized void removeRetentionLease(String id, ActionListener<ReplicationResponse> listener) {
            MergedSegmentPublisher.EMPTY
/*
            );
        throws IOException {
        }
            public void updateLocalCheckpointForShard(String allocationId, long checkpoint) {
import org.opensearch.index.shard.IndexShardTestUtils;
        }
            request.getRefreshPolicy(),
                generateFakeDiscoveryNodes()
        @Override
            } catch (Exception e) {
        public int indexDocs(final int numOfDoc) throws Exception {
        }
                .map(AllocationId::getId)
            globalCheckpointOnPrimary,
            inRequest.writeTo(out);
            MappingUpdatePerformer noopMappingUpdater = (update, shardId, listener1) -> {};
                }
            primary = reinitShard(primary, remotePath);
                getIndexerFactory(shardRouting),
                } catch (Exception e) {
                replica,
        RetentionLeaseSyncAction.Request,
    private <Request extends ReplicatedWriteRequest & DocWriteRequest> BulkShardRequest executeReplicationRequestOnPrimary(
            );
            replica,
    void indexOnReplica(BulkShardRequest request, ReplicationGroup group, IndexShard replica, long term) throws Exception {
import org.opensearch.common.lease.Releasable;
            Set<String> primaryIds = getShardDocUIDs(primary);
                    );
        protected void performOnReplica(ResyncReplicationRequest request, IndexShard replica) throws Exception {
        ) {
            Version.CURRENT
import org.opensearch.action.bulk.BulkShardResponse;
            try (StreamInput in = out.bytes().streamInput()) {
            this.replicationTargets = group.getReplicationTargets();
                return new IndexRequest(in);
            primary.markAsRecovering("store", new RecoveryState(primary.routingEntry(), pNode, null));
        @Override
        );
        }
                    getPrimaryShard().getPendingPrimaryTerm(),
        public synchronized DiscoveryNode getPrimaryNode() {
                        primary,
                ShardRoutingState.INITIALIZING,
                listener.get();
        public synchronized IndexShard addReplicaWithExistingPath(final ShardPath shardPath, final String nodeId) throws IOException {
        }
        executeShardBulkOnReplica(
            );
                    TransportWriteActionTestHelper.performPostWriteActions(
                temp.removeAll(replicaIds);
                new GlobalCheckpointSync(listener, this).execute();
                if (response.isFailed()) {
import org.opensearch.action.support.replication.ReplicationResponse;
        }
                    threadPool,
            throws IOException {
        private synchronized Set<String> activeIds() {
    }
        private BulkItemResponse executeWriteRequest(DocWriteRequest<?> writeRequest, WriteRequest.RefreshPolicy refreshPolicy)
import org.opensearch.index.IndexSettings;
            threadPool.generic().execute(task);
                .collect(Collectors.toSet());
                closeShards(this);
        protected void performOnReplica(BulkShardRequest request, IndexShard replica) throws Exception {
                return getPrimaryShard().getLastSyncedGlobalCheckpoint();
            primary.updateShardState(
 */
import org.opensearch.indices.recovery.RecoverySettings;
                    }
import org.opensearch.action.bulk.BulkShardRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                ActionListener<Void> listener
import org.opensearch.index.engine.exec.IndexerFactory;
                }
import org.opensearch.action.resync.ResyncReplicationResponse;
                    new ResyncAction(request, listener, ReplicationGroup.this).execute();
import org.opensearch.common.lease.Releasables;
                currentClusterStateVersion.incrementAndGet(),
import org.opensearch.action.support.replication.TransportReplicationAction;
 * the Apache License, Version 2.0 (the "License"); you may
                new ReplicationOperation<>(request, new PrimaryRef(), ActionListener.map(listener, result -> {
            BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier,
                throw new AlreadyClosedException("too bad");
                long primaryTerm,
        }
import org.opensearch.cluster.metadata.IndexMetadata;
        Request request
            }
            IndexShard primary,
            return replica;
            bulkShardRequest,
import java.util.ArrayList;
    protected ReplicationGroup createGroup(int replicas, Settings settings) throws IOException {
            settings,
    protected ReplicationGroup createGroup(int replicas, Settings settings, String mappings, EngineFactory engineFactory)
            }
import org.opensearch.action.support.ActionTestUtils;
                retentionLeases,
                ThreadPool.Names.SAME,
                ShardId shardId,
        protected class PrimaryResult implements ReplicationOperation.PrimaryResult<ReplicaRequest> {
                            delegatedListener.onFailure(e);
        IndexShard replica,
            } catch (Exception e) {
import org.opensearch.tasks.TaskManager;
        ) {
        }
        return executeReplicationRequestOnPrimary(primary, request);
            }
                }
                () -> {},
            final PlainActionFuture<Releasable> acquirePermitFuture = new PlainActionFuture<>();
                shardId,
            @Override
            ActionListener.completeWith(listener, () -> {
import org.opensearch.cluster.node.DiscoveryNode;
                    builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(replica.routingEntry().currentNodeId()));
        final List<IndexShard> replicas;
import java.util.HashSet;
            MergedSegmentPublisher mergedSegmentPublisher
            return new EngineConfigFactory(indexSettings);
    static final class ReplicationTargets {
            int started = 0;
        Request extends ReplicationRequest<Request>,
            indexMetadata = newMetadata.build();
        }
    }
        IndexShard replica,
        return buildIndexMetadata(replicas, indexMapping);
            }
                    maxSeqNoOfUpdatesOrDeletes,
import org.opensearch.common.collect.Iterators;
        Settings settings = Settings.builder()
                replica.persistRetentionLeases();
            public long computedGlobalCheckpoint() {
import java.util.concurrent.Future;
                }),
            mappings,
import static org.hamcrest.Matchers.equalTo;
         */
            ActionListener<PrimaryResult> listener
        Response extends ReplicationResponse> {
import org.opensearch.index.seqno.RetentionLeaseSyncAction;
import org.opensearch.action.support.WriteRequest;
        }
        public synchronized void promoteReplicaToPrimary(
            for (int i = 0; i < indexMetadata.getNumberOfReplicas(); i++) {
        private ReplicationTargets getReplicationTargets() {
        MergedSegmentPublisher mergedSegmentPublisher
                    if (started > numOfReplicasToStart) {
        }
            recoverFromStore(primary);
        }
            final FlushRequest request = new FlushRequest();
         * be able to find this replica to execute write requests on it.
         * promotes the specific replica as the new primary
 * Licensed to Elasticsearch under one or more contributor
        ActionListener<TransportWriteAction.WritePrimaryResult<BulkShardRequest, BulkShardResponse>> listener
            for (int doc = 0; doc < numOfDoc; doc++) {
            final ShardRouting replicaRouting = createShardRouting("s" + replicaId.incrementAndGet(), false);
            }
        }
        return res.get();
        public synchronized RetentionLease renewRetentionLease(String id, long retainingSequenceNumber, String source) {
        public synchronized DiscoveryNodes generateFakeDiscoveryNodes() {
            return getPrimary().renewRetentionLease(id, retainingSequenceNumber, source);
        private IndexShard primary;
            return task;
        final PlainActionFuture<Releasable> acquirePermitFuture = new PlainActionFuture<>();
                if (replica.indexSettings() != null && replica.indexSettings().isAssignedOnRemoteNode()) {
                                new ReplicaResponse(replica.getLocalCheckpoint(), replica.getLastKnownGlobalCheckpoint())
        }
        executeShardBulkOnPrimary(
                throw new UnsupportedOperationException("can't mark " + shardId + ", aid [" + allocationId + "] as stale");
import org.opensearch.action.delete.DeleteRequest;
            }
            return indexMetadata;
                null,
            replicas = new CopyOnWriteArrayList<>();
                    public void onFailure(Exception e) {
        @Override
                getPrimaryShard().getMaxSeqNoOfUpdatesOrDeletes()
                System::currentTimeMillis,
            IndexShardRoutingTable routingTable = routingTable(shr -> shr == primary.routingEntry() ? startedRoutingEntry : shr);
                computeReplicationTargets();
                routingTable,
                    for (IndexShard replica : replicas) {
            return removed;
                    TimeValue.timeValueSeconds(60),
                null,
            IndexShardRoutingTable.Builder routingTable = new IndexShardRoutingTable.Builder(primary.shardId());
                primary,
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        IndexShard primary,
        }
            return Iterators.concat(replicas.iterator(), Collections.singleton(primary).iterator());
                ).execute();
                return getPrimaryShard().routingEntry();
import org.opensearch.index.shard.PrimaryReplicaSyncer;
        }
        final PlainActionFuture<BulkShardRequest> res = new PlainActionFuture<>();
            final boolean removed = replicas.remove(replica);
            .build();
                request,
            public long maxSeqNoOfUpdatesOrDeletes() {
 */
        protected abstract void performOnReplica(ReplicaRequest request, IndexShard replica) throws Exception;
            return replica;
        }
        }
                return replicaRequest;
        final PlainActionFuture<Releasable> permitAcquiredFuture = new PlainActionFuture<>();
        private final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                finalResponse.setShardInfo(shardInfo);
import org.opensearch.action.DocWriteResponse;
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
import org.opensearch.index.engine.InternalEngineFactory;
    /**
     */
import org.opensearch.threadpool.ThreadPool.Names;
            try {
    }
            }
                indexMetadata,
                    throw new AssertionError("failed to background sync retention lease", e);
                getPrimaryShard().updateGlobalCheckpointForShard(allocationId, globalCheckpoint);
            @Override
            );
    ) throws IOException {
        @Override
        }
    }
        private void updateAllocationIDsOnPrimary() throws IOException {
            shardRoutings().stream().map(transformer).forEach(routingTable::addShard);
                recoverReplica(replica, targetSupplier);
import org.opensearch.action.support.replication.ReplicationRequest;
import org.opensearch.index.seqno.RetentionLeaseSyncer;
            OpenSearchIndexLevelReplicationTestCase.this.recoverUnstartedReplica(
            this.replicas = replicas;
import java.util.concurrent.atomic.AtomicInteger;
            ) {
        public synchronized void reinitPrimaryShard(Path remotePath) throws IOException {
                activeIds(),
                    assertEquals(DocWriteResponse.Result.CREATED, response.getResponse().getResult());
    protected ReplicationGroup createGroup(int replicas, Settings settings, String mappings, EngineFactory engineFactory, Path remotePath)
                    primaryTerm,
                recoverySettings,
            replicas.add(replica);
    }
        ) {
        }
                retentionLeaseSyncer,
            }
            final IndexShardRoutingTable routingTable = routingTable(Function.identity());
                if (replica.routingEntry().isSameAllocation(replicaRouting)) {
            if (primary.indexSettings() != null && primary.indexSettings().isAssignedOnRemoteNode()) {
                    public void onResponse(PrimaryReplicaSyncer.ResyncTask resyncTask) {
            });
            assert primary.routingEntry().active() : "only active replicas can be promoted to primary: " + primary.routingEntry();
        }
                        logger
        );
 * The OpenSearch Contributors require contributions made to
        private ShardRouting createShardRouting(String nodeId, boolean primary) {
                replicationTargets.addReplica(newReplica);
                    ThreadPool.Names.WRITE,
            }
        }
        public void syncGlobalCheckpoint() {
    }
            }
        }
    protected class ReplicationGroup implements AutoCloseable, Iterable<IndexShard> {
            (shardId, primaryAllocationId, primaryTerm, retentionLeases, listener) -> syncRetentionLeases(
        protected IndexShard getPrimaryShard() {
        @Override
 * You may obtain a copy of the License at
        }
     * indexes the given requests on the supplied primary, modifying it for replicas
        }
        );
                .map(ShardRouting::allocationId)
        public synchronized void addReplica(IndexShard replica) throws IOException {
                        listener.onFailure(e);
        long maxSeqNoOfUpdatesOrDeletes
        public Iterator<IndexShard> iterator() {
        }
        protected void performOnReplica(final GlobalCheckpointSyncAction.Request request, final IndexShard replica) throws IOException {
import org.opensearch.action.resync.TransportResyncReplicationAction;
            }
                indexMetadata,
            String id,
 * Unless required by applicable law or agreed to in writing,
    class ResyncAction extends ReplicationAction<ResyncReplicationRequest, ResyncReplicationRequest, ResyncReplicationResponse> {
import org.opensearch.common.unit.TimeValue;
        }
        public synchronized void assertAllEqual(int expectedCount) throws IOException {
import org.opensearch.cluster.routing.RecoverySource;
                    ? IndexShardTestUtils.getFakeRemoteEnabledDiscoveryNodes(routingTable(Function.identity()).getShards())
        protected void performOnPrimary(
                getIndexerFactory(replicaRouting),
                primary.getPendingPrimaryTerm(),
            executeShardBulkOnReplica(
        protected synchronized void recoverPrimary(IndexShard primary) {
                getPrimaryShard().getMaxSeqNoOfUpdatesOrDeletes()
        protected ReplicationGroup(final IndexMetadata indexMetadata) throws IOException {
            IndexShard primary,
        protected ReplicationGroup(final IndexMetadata indexMetadata, Path remotePath) throws IOException {
                currentClusterStateVersion.incrementAndGet(),
    protected abstract class ReplicationAction<
        ReplicaRequest extends ReplicationRequest<ReplicaRequest>,
        }
            );
    protected DiscoveryNode getDiscoveryNode(String id) {
            return executeWriteRequest(deleteRequest, deleteRequest.getRefreshPolicy());
            primary.updateShardState(
            );
 *
        }
            @Override
     * Executes the delete request on the primary, and modifies it for replicas.
            @Override
                final long maxSeqNoOfUpdatesOrDeletes,
            primary = newShard(
                builder.add(IndexShardTestUtils.getFakeDiscoNode(primary.routingEntry().currentNodeId()));
            this.replicationTargets = new ReplicationTargets(this.primary, new ArrayList<>(this.replicas));
        public IndexShard addReplica() throws IOException {
import org.opensearch.core.index.Index;
                    request
                primary,
            replicas,
        private final Request request;
                            releasable.close();
        GlobalCheckpointSyncAction.Request,
                retentionLeases,
            BulkShardRequest request = new BulkShardRequest(shardId, refreshPolicy, items);
                }),
    }
import org.opensearch.Version;
        final TransportWriteAction.WritePrimaryResult<ResyncReplicationRequest, ResyncReplicationResponse> result =
            globalCheckpointOnPrimary,
        ) {
        Path remotePath,
            assert shardRoutings().stream().anyMatch(shardRouting -> shardRouting.isSameAllocation(replica.routingEntry())) == false
                ((IndexRequest) itemRequest.request()).process(Version.CURRENT, null, index.getName());
        protected void performOnReplica(RetentionLeaseSyncAction.Request request, IndexShard replica) throws Exception {
        public IndexShard addReplica(Path remotePath) throws IOException {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                routingTable,
    ) {
import org.opensearch.core.action.ActionListener;
            @Override
        public IndexShard addReplica(Path remotePath, RecoverySettings recoverySettings) throws IOException {
            );
    ) throws IOException {
            final IndexMetadata indexMetadata,
                replica,
public abstract class OpenSearchIndexLevelReplicationTestCase extends IndexShardTestCase {
     * indexes the given requests on the supplied replica shard
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                    new ReplicasRef(),
            group.primary.getLastKnownGlobalCheckpoint(),
                false,
    }
            primary.updateShardState(
            replica,
import org.opensearch.action.support.replication.PendingReplicationActions;
    }
            .primaryTerm(0, randomIntBetween(1, 100));
                return getPrimaryShard().getMaxSeqNoOfUpdatesOrDeletes();
import org.opensearch.action.bulk.MappingUpdatePerformer;
import org.opensearch.cluster.routing.ShardRoutingHelper;
        protected void syncRetentionLeases(ShardId shardId, RetentionLeases leases, ActionListener<ReplicationResponse> listener) {
            IndexShardRoutingTable routingTable = routingTable(shr -> shr == replica.routingEntry() ? primaryRouting : shr);
                throw new AssertionError(e);
    class GlobalCheckpointSync extends ReplicationAction<
 */
            location = TransportResyncReplicationAction.performOnReplica(request, replica);
            public void markShardCopyAsStaleIfNeeded(
                }
            );
            RetentionLeaseSyncAction.Request request,
import java.util.stream.Collectors;
                listener.onResponse(null);
            recoverReplica(replica, (r, sourceNode) -> new RecoveryTarget(r, sourceNode, recoveryListener, threadPool));
import org.opensearch.cluster.routing.ShardRoutingState;
                    opType,
            @Override
                targetSupplier,
            @Override
            return new EngineBackedIndexerFactory(getEngineFactory(routing));
        }
            new WriteReplicationAction(request, wrapBulkListener, this).execute();
                primary.getPendingPrimaryTerm(),
        public IndexMetadata getIndexMetadata() {
            }
            if (replicationTargets != null) {
            }
        class ReplicasRef implements ReplicationOperation.Replicas<ReplicaRequest> {
        }
                recoverReplica(replica);
                            );
            for (IndexShard replicaShard : replicas) {
        }
        throws IOException {
     */
    private TransportWriteAction.WritePrimaryResult<ResyncReplicationRequest, ResyncReplicationResponse> executeResyncOnPrimary(
        protected void adaptResponse(Response response, IndexShard indexShard) {
            RecoverySettings recoverySettings,
            try {
            final IndexShard newReplica = newShard(
        long operationPrimaryTerm,
                ActionListener.map(listener, result -> new PrimaryResult(result.replicaRequest(), result.finalResponseIfSuccessful))
                newTerm,
            );
        BulkShardRequest request,
        IndexMetadata.Builder metadata = IndexMetadata.builder(index.getName())
                shard.refresh(source);
                shardId,
            if (removed) {
        protected ReplicationGroup(
import java.util.function.Function;
            return new InternalEngineFactory();
        public Future<PrimaryReplicaSyncer.ResyncTask> promoteReplicaToPrimary(IndexShard replica) throws IOException {
        }
import org.opensearch.action.support.replication.TransportWriteActionTestHelper;
                    : IndexShardTestUtils.getFakeDiscoveryNodes(routingTable(Function.identity()).getShards())
            return numOfDoc;
                builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(primary.routingEntry().currentNodeId()));
        }
            }
            );
        final BulkShardRequest bulkShardRequest = new BulkShardRequest(
            listener.onFailure(e);
            this(indexMetadata, DefaultRecoverySettings.INSTANCE, remotePath, MergedSegmentPublisher.EMPTY);
            items[0] = new BulkItemRequest(0, writeRequest);
            throws Exception {
 * license agreements. See the NOTICE file distributed with
        @Override
            @Override
            }
            return replicationTargets.primary;
                    logger,
        private volatile ReplicationTargets replicationTargets;
        }
 * SPDX-License-Identifier: Apache-2.0
                ActionListener<Void> listener
                inSyncIds,
                primary.persistRetentionLeases();
        return new DiscoveryNode(
        long maxSeqNoOfUpdatesOrDeletes
            ActionListener.completeWith(listener, () -> {
                    @Override
            ActionListener<PrimaryResult> listener
        long operationPrimaryTerm,
            public long localCheckpoint() {
            ShardRouting startedRoutingEntry = ShardRoutingHelper.moveToStarted(primary.routingEntry());
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
            @Override
import org.opensearch.action.bulk.BulkItemRequest;
            BulkItemRequest[] items = new BulkItemRequest[1];
                getIndexerFactory(replicaRouting),
        ) throws IOException {
                () -> {},
            replica.updateRetentionLeasesOnReplica(request.getRetentionLeases());
            @Override
            return listener.get();
                    }
        }
            assertThat(primaryIds.size(), equalTo(expectedCount));
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * compatible open source license.
import java.util.List;
                            delegatedListener.onResponse(
                        }
                getPrimaryShard().getPendingPrimaryTerm(),
        };
 * under the License.
        Settings settings,
import java.util.concurrent.CopyOnWriteArrayList;
            remotePath,
    private final ShardId shardId = new ShardId(index, 0);
    /**
            PlainActionFuture<ReplicationResponse> listener = new PlainActionFuture<>();
/*
            if (primary.routingEntry().initializing()) {
                        listener.onResponse(resyncTask);
                RecoverySource.PeerRecoverySource.INSTANCE
            return numOfDoc;
    }
        return createGroup(replicas, settings, mappings, engineFactory, recoverySettings, remotePath, mergedSegmentPublisher);
        RetentionLeaseSyncAction.Request,
                startedRoutingEntry,
import org.opensearch.index.engine.DocIdSeqNoAndSource;
            ReplicationGroup group,
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000))
        );
        public synchronized void flush() {
 * this file be licensed under the Apache-2.0 license or a
    }
                    }
        }
            closeShards(primary);
            @Override
                    executeResyncOnPrimary(primary, request);
import org.opensearch.common.settings.Settings;
        private final List<IndexShard> replicas;
    protected IndexMetadata buildIndexMetadata(int replicas) throws IOException {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replicas)
            OpenSearchIndexLevelReplicationTestCase.this.startReplicaAfterRecovery(replica, primary, inSyncIds, routingTable);
import org.opensearch.common.io.stream.BytesStreamOutput;
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet()),
            public org.opensearch.index.shard.ReplicationGroup getReplicationGroup() {
                this,
        }
                        ((TransportWriteAction.WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result).location,
            IndexMetadata.Builder newMetadata = IndexMetadata.builder(indexMetadata).primaryTerm(shardId.id(), newTerm);
            }
            HashSet<String> activeIds = new HashSet<>();
                        assertThat(getDocIdAndSeqNos(replica), equalTo(docsOnPrimary));
import org.opensearch.cluster.routing.AllocationId;
                nodeId,
                acquirePermitFuture,
            final Set<String> inSyncIds = activeIds();
                }
    }
                throw new UnsupportedOperationException("failing a primary isn't supported. failure: " + message, exception);
                    @Override
        } catch (Exception e) {
import org.opensearch.index.shard.IndexShard;
        }
            new SyncRetentionLeases(
    }
            public long globalCheckpoint() {
        TransportWriteActionTestHelper.performPostWriteActions(primary, request, result.location, logger);
            group.primary.getMaxSeqNoOfUpdatesOrDeletes()
            }
        public Future<Void> asyncRecoverReplica(
            }
            PlainActionFuture<BulkItemResponse> listener = new PlainActionFuture<>();
                generateFakeDiscoveryNodes()
                return getPrimaryShard().getLastKnownGlobalCheckpoint();
        ) {
                indexMetadata,
    protected IndexMetadata buildIndexMetadata(int replicas, String mappings) throws IOException {
            long retainingSequenceNumber,
        private final AtomicInteger docId = new AtomicInteger();
                shardRouting,
            GlobalCheckpointSyncAction.Request request,
            if (replicationTargets != null) {
            replicas.add(newReplica);
                replicaRouting,
            this.primary = primary;
            group.primary.getMaxSeqNoOfUpdatesOrDeletes()
            public void setShardInfo(ReplicationResponse.ShardInfo shardInfo) {
            // Update the status of the replicas in the routing table to IndexShardState.STARTED.
            return addReplica((Path) null);
                replicationGroup,
            } catch (Exception e) {
                    ActionListener.delegateFailure(listener, (delegatedListener, releasable) -> {
                        fut.onResponse(resyncTask);
            for (IndexShard shard : this) {
        public synchronized RetentionLease addRetentionLease(
         */
        RecoverySettings recoverySettings,
            BiConsumer<IndexShard, ActionListener<PrimaryReplicaSyncer.ResyncTask>> primaryReplicaSyncer
        }
            });
        @Override
            public void performOn(
            @Override
        synchronized IndexShard findReplicaShard(ShardRouting replicaRouting) {
import org.opensearch.action.resync.ResyncReplicationRequest;
            }
import org.opensearch.action.support.replication.FanoutReplicationProxy;
    ) throws Exception {
            return started;
                this.finalResponse = finalResponse;
                Exception exception,
            (shardId, primaryAllocationId, primaryTerm, retentionLeases) -> syncRetentionLeases(
            final FutureTask<Void> task = new FutureTask<>(() -> {
            Path remotePath,
        }
                    globalCheckpoint,
            ShardRouting primaryRouting = replica.routingEntry().moveActiveReplicaToPrimary();
import org.opensearch.core.index.shard.ShardId;
            this.request = request;
                });
                currentClusterStateVersion.incrementAndGet(),
                performOnPrimary(getPrimaryShard(), request, listener);
        }
                    recoverReplica(replicaShard);
            );
                request
            return executeWriteRequest(indexRequest, indexRequest.getRefreshPolicy());
            PlainActionFuture<PrimaryReplicaSyncer.ResyncTask> fut = new PlainActionFuture<>();
        protected ReplicationAction(Request request, ActionListener<Response> listener, ReplicationGroup group, String opType) {
                final ShardRouting replicaRouting,
            .put(indexSettings)
                listener
            permitAcquiredFuture,
                getEngineConfigFactory(new IndexSettings(indexMetadata, indexMetadata.getSettings())),
import java.util.stream.StreamSupport;
        public synchronized List<IndexShard> getReplicas() {
        int replicas,
            computeReplicationTargets();
                replicaRouting,
                activeIds,
    ) throws Exception {
import org.apache.lucene.store.AlreadyClosedException;
import org.opensearch.action.support.replication.TransportWriteAction;
                primaryReplicaSyncer,
            super(request, listener, replicationGroup, "indexing");
            }
                listener.onFailure(e);
            executeShardBulkOnPrimary(
        public synchronized List<ShardRouting> shardRoutings() {
        }
            recoverReplica(replica, targetSupplier, true);
        }
        }
                retentionLeaseSyncer,
         * If the targets is updated to include the given replica, a replication action would
        protected EngineConfigFactory getEngineConfigFactory(IndexSettings indexSettings) {
    protected ReplicationGroup createGroup(
            buildNewFakeTransportAddress(),
                () -> {},
    }
            }
            return shardRoutings().stream()
                final IndexRequest indexRequest = new IndexRequest(index.getName()).source("{}", MediaTypeRegistry.JSON);
        public int appendDocs(final int numOfDoc) throws Exception {
                ActionTestUtils.assertNoFailureListener(result -> {
            @Override
            ActionListener.completeWith(listener, () -> {
                    }
import org.opensearch.indices.recovery.DefaultRecoverySettings;
 * GitHub history for details.
            IndexShard replica,
            acquirePermitFuture,
                listener,
        EngineFactory engineFactory,
                null,
        public void execute() {
                request,
import org.opensearch.action.bulk.BulkItemResponse;
 * ownership. Elasticsearch licenses this file to you under
            replica.persistRetentionLeases();
                } catch (AlreadyClosedException ignored) {}
            replicas.add(replica);
        private ActionListener<Response> listener;
            @Override
        final Translog.Location location;
            final ActionListener<BulkShardResponse> wrapBulkListener = ActionListener.map(
            .putMapping(mappings)
                () -> {},
        private final String opType;
                            Releasables.closeWhileHandlingException(releasable);
        }
    }
            new TransportWriteAction.WritePrimaryResult<>(
            throw new AssertionError("replica [" + replicaRouting + "] is not found; replicas[" + replicas + "] primary[" + primary + "]");
        GlobalCheckpointSync(final ActionListener<ReplicationResponse> listener, final ReplicationGroup replicationGroup) {
                primary.routingEntry(),
                final ActionListener<ReplicationOperation.ReplicaResponse> listener
import java.util.function.BiConsumer;
    protected IndexMetadata buildIndexMetadata(int replicas, Settings indexSettings, String mappings) throws IOException {
            term,
        public BulkItemResponse index(IndexRequest indexRequest) throws Exception {
        );
                    started++;
            group.primary.getPendingPrimaryTerm(),
                try {
            remotePath = createTempDir();
        public synchronized int startReplicas(int numOfReplicasToStart) throws IOException {
    }
                );
        }
        );
        return buildIndexMetadata(replicas, Settings.EMPTY, mappings);
        IndexShard primary,
                request,
                null,
            }
                MergedSegmentPublisher.EMPTY
        @Override
                            performOnReplica(request, replica);
            @Override
            final IndexShard replica = newShard(
            try (Releasable ignored = acquirePermitFuture.actionGet()) {
import org.opensearch.cluster.routing.TestShardRouting;
                        try {
                replica,
        TransportWriteActionTestHelper.performPostWriteActions(replica, request, location, logger);
     * Executes the delete request on the given replica shard.
import org.opensearch.indices.recovery.RecoveryState;
        public void recoverReplica(IndexShard replica, BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier)
        MergedSegmentPublisher mergedSegmentPublisher
                nodeId,
            ActionListener.map(res, TransportReplicationAction.PrimaryResult::replicaRequest)
            );
            }
    public BulkShardRequest indexOnPrimary(IndexRequest request, IndexShard primary) throws Exception {
            }
    protected ReplicationGroup createGroup(int replicas, Settings settings, EngineFactory engineFactory) throws IOException {
                    TimeValue.timeValueMillis(20),
        boolean closed = false;
            final ShardRouting replicaRouting = createShardRouting("s" + replicaId.incrementAndGet(), false);
        public void executeRetentionLeasesSyncRequestOnReplica(RetentionLeaseSyncAction.Request request, IndexShard replica) {
        }
            this.indexMetadata = indexMetadata;
        }
                primary,
        public synchronized boolean removeReplica(IndexShard replica) throws IOException {
     */
                request,
            TransportShardBulkAction.performOnPrimary(
            if (itemRequest.request() instanceof IndexRequest) {
 *
            engineFactory,
        }
        return result;
                return getPrimaryShard().getLocalCheckpoint();
            final ShardRouting shardRouting = TestShardRouting.newShardRouting(
            String source,
            startReplicas(replicas.size());
        }
                } else {
import java.io.IOException;
        }
        primary.acquirePrimaryOperationPermit(permitAcquiredFuture, ThreadPool.Names.SAME, request);
            @Override
            )
                retentionLeaseSyncer,
        IndexMetadata metadata = buildIndexMetadata(replicas, settings, indexMapping);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
                String message,
    }
            replica.acquireReplicaOperationPermit(
                Set<String> replicaIds = getShardDocUIDs(replica);
            public void runPostReplicationActions(ActionListener<Void> listener) {
                getPrimaryShard().updateLocalCheckpointForShard(allocationId, checkpoint);
 * KIND, either express or implied.  See the License for the
        @Override
                final BulkItemResponse response = index(indexRequest);
        ResyncReplicationRequest request,
            operationPrimaryTerm,
            }
        return createGroup(replicas, Settings.EMPTY);
        RecoverySettings recoverySettings,
        Settings settings,
            });
            }
                final long globalCheckpoint,
        final Translog.Location location;
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
                    .source("{}", MediaTypeRegistry.JSON);
            ActionListener<ReplicationResponse> listener
                mergedSegmentPublisher
            }
                return new PrimaryResult(request, new RetentionLeaseSyncAction.Response());
import org.opensearch.index.shard.ShardPath;
                null,
import org.opensearch.threadpool.ThreadPool;
            );
    }
                    return result.finalResponse;
    private void executeShardBulkOnReplica(
import org.opensearch.action.bulk.TransportShardBulkAction;
            return builder.build();
        IndexShard primary,
}
            updateAllocationIDsOnPrimary();
            for (int doc = 0; doc < numOfDoc; doc++) {
            request
        replica.acquireReplicaOperationPermit(
    }
                new RetentionLeaseSyncAction.Request(shardId, leases),
    protected ReplicationGroup createGroup(
                return engineFactory;
                markAsRecovering,
        private final RetentionLeaseSyncer retentionLeaseSyncer = new RetentionLeaseSyncer(
                    throw new AssertionError(e);
                null,
import java.util.Set;
                return getPrimaryShard().getReplicationGroup();
        for (BulkItemRequest itemRequest : request.items()) {
            return TestShardRouting.newShardRouting(
        }
    IndexRequest copyIndexRequest(IndexRequest inRequest) throws IOException {
                shard.flush(request);
            boolean markAsRecovering
    }
            this.listener = listener;
        executeShardBulkOnReplica(
            public PendingReplicationActions getPendingReplicationActions() {
                indexMetadata,
        }
            group.primary.getLastKnownGlobalCheckpoint(),
            .settings(settings)
            final Response finalResponse;
        protected EngineFactory getEngineFactory(ShardRouting routing) {
                assertThat(replica.routingEntry() + " has extra docs", temp, empty());
        }
        return createGroup(replicas, settings, indexMapping, engineFactory);
    }
    }
import org.opensearch.index.seqno.GlobalCheckpointSyncAction;
            executeResyncOnReplica(
            for (IndexShard replica : replicas) {
     */
import org.opensearch.index.shard.IndexShardTestCase;
            shardId,
import org.opensearch.action.index.IndexRequest;
            } else {
            location = TransportShardBulkAction.performOnReplica(request, replica);
import java.util.function.BiFunction;
                }
 * software distributed under the License is distributed on an
            addReplica(replica);
            }
            activeIds.add(primary.routingEntry().allocationId().getId());
            getPrimary().removeRetentionLease(id, listener);
import org.opensearch.action.support.replication.ReplicationOperation;
                remotePath,
                        request,
        private final AtomicInteger replicaId = new AtomicInteger();
    }
            public ReplicaRequest replicaRequest() {
            );
        return createGroup(replicas, settings, mappings, engineFactory, DefaultRecoverySettings.INSTANCE, MergedSegmentPublisher.EMPTY);
        }
            promoteReplicaToPrimary(replica, (shard, listener) -> {
            }
        public BulkItemResponse delete(DeleteRequest deleteRequest) throws Exception {
        }
        private final PrimaryReplicaSyncer primaryReplicaSyncer = new PrimaryReplicaSyncer(
            replica.sync();
                updateAllocationIDsOnPrimary();
    /**
            public void perform(Request request, ActionListener<PrimaryResult> listener) {
                } else {
            return StreamSupport.stream(this.spliterator(), false).map(IndexShard::routingEntry).collect(Collectors.toList());
        private synchronized IndexShardRoutingTable routingTable(Function<ShardRouting, ShardRouting> transformer) {
                replica.acquireReplicaOperationPermit(
        return new ReplicationGroup(metadata);
    ) {
        /**
            );
            }
                null,
            return fut;
            final IndexShard replica = newShard(
            ),
    /**
            }
                    return replica;
    private void executeShardBulkOnPrimary(
                remotePath,
    }
                addReplica(remotePath, recoverySettings);
    class WriteReplicationAction extends ReplicationAction<BulkShardRequest, BulkShardRequest, BulkShardResponse> {
            public void failShardIfNeeded(
        private synchronized void computeReplicationTargets() {
            return replicationTargets;
        indexOnReplica(request, group, replica, group.primary.getPendingPrimaryTerm());
            ).execute();
                getIndexerFactory(primaryRouting),
            return primary;
        Path remotePath = null;
import java.util.Collections;
        return createGroup(
import org.opensearch.core.common.io.stream.StreamInput;
                primary,
                if (response.isFailed()) {
                    builder.add(IndexShardTestUtils.getFakeDiscoNode(replica.routingEntry().currentNodeId()));
                } else if (response.isFailed() == false) {
            if (closed == false) {
            this(indexMetadata, null);
                null,
            computeReplicationTargets();
                    listener.onResponse((TransportWriteAction.WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result);
                getPrimaryShard().getLastKnownGlobalCheckpoint(),
                return getPrimaryShard().getPendingReplicationActions();
    }
                temp = new HashSet<>(replicaIds);
        }
        }
                activeIds(),
    }
            recoverPrimary(primary);
                    throw response.getFailure().getCause();
        private final ReplicationTargets replicationTargets;
        ) throws IOException {
                routingTable(Function.identity()),
            );
/*
            }
                shardId,
            assertTrue(replicas.remove(replica));
        final PlainActionFuture<Releasable> permitAcquiredFuture = new PlainActionFuture<>();
        }
                null,
    }
                assertThat(replica.routingEntry() + " is missing docs", temp, empty());
        }
        protected void performOnPrimary(
        }
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.action.DocWriteRequest;
            }
                null,
        }
                getReplicationFunc(replica)
            } else {
            @Override
                ShardRouting replica,
                final ReplicaRequest request,
        String mappings,
        }
                        assertThat(replica.getMaxSeenAutoIdTimestamp(), equalTo(primary.getMaxSeenAutoIdTimestamp()));
                return null;
                String allocationId,
         * This does not modify the replication targets, but only adds a replica to the list.
import java.util.Iterator;
            ThreadPool.Names.SAME,
                "global_checkpoint_sync"
            public void failShard(String message, Exception exception) {
 * specific language governing permissions and limitations
                    new FanoutReplicationProxy<>(new ReplicasRef())
                : "replica with aId [" + replica.routingEntry().allocationId() + "] already exists";
                try {
                ShardRoutingState.INITIALIZING,
        public synchronized void close() throws Exception {
                final TransportWriteAction.WritePrimaryResult<ResyncReplicationRequest, ResyncReplicationResponse> result =
            addReplica(replica);
        public void startPrimary() throws IOException {
            return getDiscoveryNode(primary.routingEntry().currentNodeId());
    public void indexOnReplica(BulkShardRequest request, ReplicationGroup group, IndexShard replica) throws Exception {
            for (final IndexShard replica : replicas) {
    protected final String indexMapping = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": {} }";
    protected ReplicationGroup createGroup(int replicas) throws IOException {
            updateAllocationIDsOnPrimary();
        }
        return metadata.build();
                Set<String> temp = new HashSet<>(primaryIds);
                listener,
import org.opensearch.action.admin.indices.flush.FlushRequest;
            updateAllocationIDsOnPrimary();
    }
                throw new UnsupportedOperationException("failing shard " + replica + " isn't supported. failure: " + message, exception);
                new ResyncReplicationResponse(),
                        break;
                long primaryTerm,
            );
                primaryReplicaSyncer.resync(shard, new ActionListener<PrimaryReplicaSyncer.ResyncTask>() {
        /**
            super(
        public void recoverReplica(
            for (IndexShard shard : this) {
import org.opensearch.index.engine.EngineFactory;
            final BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier
            @Override
        long globalCheckpointOnPrimary,
                    assertEquals(DocWriteResponse.Result.CREATED, response.getResponse().getResult());
        class PrimaryRef implements ReplicationOperation.Primary<Request, ReplicaRequest, PrimaryResult> {
        }
        }
                getPrimaryShard().getLastKnownGlobalCheckpoint(),
        );
        TransportWriteActionTestHelper.performPostWriteActions(replica, request, location, logger);
            new BulkItemRequest[] { new BulkItemRequest(0, request) }
