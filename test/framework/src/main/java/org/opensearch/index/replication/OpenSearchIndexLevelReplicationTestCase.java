        }  
 * compatible open source license.
        }
                if (replica.indexSettings() != null && replica.indexSettings().isAssignedOnRemoteNode()) {
                }
    private final ShardId shardId = new ShardId(index, 0);
                mergedSegmentPublisher
            updateAllocationIDsOnPrimary();
            .put(indexSettings)
            }
        protected ReplicationAction(Request request, ActionListener<Response> listener, ReplicationGroup group, String opType) {  
        throws IOException {  
import org.opensearch.index.seqno.RetentionLease;
            ) {  
 *
            computeReplicationTargets();
package org.opensearch.index.replication;
            RecoverySettings recoverySettings,
 */  
                Exception exception,
        ) {  
        }  
                remotePath,  
import org.opensearch.action.bulk.TransportShardBulkAction;
        public BulkItemResponse delete(DeleteRequest deleteRequest) throws Exception {
                null,
            buildNewFakeTransportAddress(),  
        IndexMetadata metadata = buildIndexMetadata(replicas, settings, indexMapping);  
        ResyncReplicationRequest request
            final ShardRouting shardRouting = TestShardRouting.newShardRouting(
                generateFakeDiscoveryNodes()  
import org.opensearch.index.engine.exec.IndexerFactory;
                activeIds,
                replicaRouting,  
        protected abstract void performOnReplica(ReplicaRequest request, IndexShard replica) throws Exception;
        }
import org.opensearch.index.seqno.RetentionLeases;
        synchronized void addReplica(IndexShard replica) {
            .primaryTerm(0, randomIntBetween(1, 100));  
    protected ReplicationGroup createGroup(int replicas, Settings settings, String mappings, EngineFactory engineFactory, Path remotePath)
import org.opensearch.index.engine.DocIdSeqNoAndSource;  
        }  
import org.opensearch.cluster.metadata.IndexMetadata;  
            }
            return numOfDoc;  
                () -> {},
                return getPrimaryShard().getPendingReplicationActions();
            final FlushRequest request = new FlushRequest();
            }
                } else {
        }  
            final IndexMetadata indexMetadata,
            try (StreamInput in = out.bytes().streamInput()) {
                startPrimary();
            return shardRoutings().stream()  
            );
                return null;
    ) {
            final PlainActionFuture<Releasable> acquirePermitFuture = new PlainActionFuture<>();
                final BulkItemResponse response = index(indexRequest);
        private final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            boolean markAsRecovering
        private IndexShard primary;
    }  
                RecoverySource.PeerRecoverySource.INSTANCE  
                getPrimaryShard().getPendingPrimaryTerm(),
                routingTable(Function.identity()),  
            }
        class ReplicasRef implements ReplicationOperation.Replicas<ReplicaRequest> {
            computeReplicationTargets();
                throw new UnsupportedOperationException("failing a primary isn't supported. failure: " + message, exception);
            });
        public synchronized DiscoveryNode getPrimaryNode() {  
            @Override  
            });
            );
 * ownership. Elasticsearch licenses this file to you under  
        }
    }
    void deleteOnReplica(BulkShardRequest request, ReplicationGroup group, IndexShard replica) throws Exception {
        RetentionLeaseSyncAction.Request,
            }  
            throws Exception {
        );
            closeShards(primary);  
                if (replica.routingEntry().isSameAllocation(replicaRouting)) {
                listener.get();
    }
        public synchronized void startAll() throws IOException {
            IndexShard primary,  
            replica.sync();
        }
            OpenSearchIndexLevelReplicationTestCase.this.startReplicaAfterRecovery(replica, primary, inSyncIds, routingTable);
import org.opensearch.action.support.replication.TransportWriteAction;
        protected abstract void performOnPrimary(IndexShard primary, Request request, ActionListener<PrimaryResult> listener);  
                    TimeValue.timeValueSeconds(60),
            .putMapping(mappings)
        }  
import java.util.function.Function;
import org.opensearch.action.resync.TransportResyncReplicationAction;
 *     http://www.apache.org/licenses/LICENSE-2.0
                "global_checkpoint_sync"
                null,
    }  
                    opType,
 * specific language governing permissions and limitations
        }  
                } catch (Exception e) {
            return getPrimary().addRetentionLease(id, retainingSequenceNumber, source, listener);
        final TransportWriteAction.WritePrimaryResult<ResyncReplicationRequest, ResyncReplicationResponse> result =  
            maxSeqNoOfUpdatesOrDeletes,
            final Response finalResponse;
            this.replicationTargets = new ReplicationTargets(this.primary, new ArrayList<>(this.replicas));
            final ShardRouting replicaRouting = createShardRouting("s" + replicaId.incrementAndGet(), false);
                ActionListener<Void> listener  
            permitAcquiredFuture,
                replica.updateRetentionLeasesOnReplica(request.getRetentionLeases());  
import java.util.stream.StreamSupport;
    class WriteReplicationAction extends ReplicationAction<BulkShardRequest, BulkShardRequest, BulkShardResponse> {  
        public void recoverReplica(IndexShard replica) throws IOException {
            addReplica(replica);
        RetentionLeaseSyncAction.Request,
        MergedSegmentPublisher mergedSegmentPublisher  
            group.primary.getLastKnownGlobalCheckpoint(),
            assertTrue(replicas.remove(replica));
        private final PrimaryReplicaSyncer primaryReplicaSyncer = new PrimaryReplicaSyncer(
import org.opensearch.index.engine.EngineFactory;
                replica,  
            );
            engineFactory,
            public long maxSeqNoOfUpdatesOrDeletes() {
    protected ReplicationGroup createGroup(int replicas) throws IOException {
        RecoverySettings recoverySettings,
    ) {
        protected void performOnPrimary(IndexShard primary, BulkShardRequest request, ActionListener<PrimaryResult> listener) {
            String source,
    class GlobalCheckpointSync extends ReplicationAction<  
                replica.acquireReplicaOperationPermit(
            this.primary = primary;
            protected EngineFactory getEngineFactory(ShardRouting routing) {
                recoverySettings,
        return createGroup(replicas, Settings.EMPTY);
        return metadata.build();
        primary.acquirePrimaryOperationPermit(permitAcquiredFuture, ThreadPool.Names.SAME, request);
            @Override  
        }  
            new WriteReplicationAction(request, wrapBulkListener, this).execute();
            @Override
            replicas.add(replica);
    private TransportWriteAction.WritePrimaryResult<ResyncReplicationRequest, ResyncReplicationResponse> executeResyncOnPrimary(
                null,
            startReplicas(replicas.size());  
                request,  
     */  
                routingTable,
                shard.flush(request);  
        }
        @Override
import java.util.concurrent.Future;  
                    started++;
            }
        return new ReplicationGroup(metadata, recoverySettings, remotePath, mergedSegmentPublisher) {  
            });  
            for (IndexShard replica : replicas) {
        }
        boolean closed = false;
    }  
        public synchronized void promoteReplicaToPrimary(
            recoverFromStore(primary);  
import org.opensearch.Version;
                shardPath,
        }
                        assertThat(replica.getMaxSeqNoOfUpdatesOrDeletes(), greaterThanOrEqualTo(primary.getMaxSeqNoOfUpdatesOrDeletes()));
            if (primary.routingEntry().initializing()) {  
                final long globalCheckpoint,  
import org.opensearch.action.bulk.BulkShardResponse;  
        }  
        synchronized IndexShard findReplicaShard(ShardRouting replicaRouting) {
 */
    /**
        }
     * indexes the given requests on the supplied replica shard
    }  
                try {  
                    throw response.getFailure().getCause();
    }  
        @Override
        }
                null,  
/*
                ActionListener.wrap(r -> {}, e -> {
    ) throws Exception {
import org.opensearch.cluster.routing.TestShardRouting;
                new GlobalCheckpointSyncAction.Request(replicationGroup.getPrimary().shardId()),
            IndexShard primary,
    }  
        int replicas,  
                        assertThat(replica.getMaxSeenAutoIdTimestamp(), equalTo(primary.getMaxSeenAutoIdTimestamp()));  
                    public void onFailure(Exception e) {
         * This does not modify the replication targets, but only adds a replica to the list.  
                null,
        }  
                        assertThat(getDocIdAndSeqNos(replica), equalTo(docsOnPrimary));
            }
                .map(AllocationId::getId)  
    static final class ReplicationTargets {
                        listener.onResponse(resyncTask);
            ThreadPool.Names.SAME,  
        );
        if ("true".equals(settings.get(IndexMetadata.SETTING_REMOTE_STORE_ENABLED))) {
            final DiscoveryNode pNode = getDiscoveryNode(primary.routingEntry().currentNodeId());
            MergedSegmentPublisher mergedSegmentPublisher
                    }
                    new ResyncAction(request, listener, ReplicationGroup.this).execute();  
        ActionListener<TransportWriteAction.WritePrimaryResult<BulkShardRequest, BulkShardResponse>> listener  
import org.opensearch.index.translog.Translog;
         * promotes the specific replica as the new primary
        return executeReplicationRequestOnPrimary(primary, request);
                    @Override  
import org.opensearch.index.seqno.RetentionLeaseSyncAction;  
            } else {  
                false,
        public void recoverReplica(IndexShard replica, BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier)
            updateAllocationIDsOnPrimary();  
            }
    void indexOnReplica(BulkShardRequest request, ReplicationGroup group, IndexShard replica, long term) throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
                () -> {},
        final BulkShardRequest bulkShardRequest = new BulkShardRequest(  
                final ShardRouting replicaRouting,  
            return started;  
            );
            primary = newShard(
    public BulkShardRequest indexOnPrimary(IndexRequest request, IndexShard primary) throws Exception {
import org.opensearch.action.support.replication.ReplicationOperation;
        WriteReplicationAction(BulkShardRequest request, ActionListener<BulkShardResponse> listener, ReplicationGroup replicationGroup) {
            replica.persistRetentionLeases();
    }
                long primaryTerm,
            for (IndexShard replicaShard : replicas) {
                currentClusterStateVersion.incrementAndGet(),
            public long localCheckpoint() {
            public long globalCheckpoint() {
        Response extends ReplicationResponse> {  
            final IndexShard newReplica = newShard(  
                getIndexerFactory(primaryRouting),
        try (Releasable ignored = permitAcquiredFuture.actionGet()) {  
                getPrimary().getLastKnownGlobalCheckpoint(),
            try {  
        public BulkItemResponse index(IndexRequest indexRequest) throws Exception {
            }  
            group.primary.getMaxSeqNoOfUpdatesOrDeletes()
            final BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier  
        private final Request request;
            IndexShard replica,
                throw new AlreadyClosedException("too bad");
            );
 * software distributed under the License is distributed on an
            Set<String> primaryIds = getShardDocUIDs(primary);
        long operationPrimaryTerm,
            return replicationTargets.primary;  
                            Releasables.closeWhileHandlingException(releasable);
                }
            PlainActionFuture<PrimaryReplicaSyncer.ResyncTask> fut = new PlainActionFuture<>();
                primary.sync();  
                recoverySettings,  
                    new ReplicasRef(),
    protected ReplicationGroup createGroup(int replicas, Settings settings) throws IOException {
            @Override  
            Collections.emptyMap(),
            return getPrimary().renewRetentionLease(id, retainingSequenceNumber, source);  
        int replicas,
            operationPrimaryTerm,
                closeShards(this);
            String id,  
        public synchronized boolean removeReplica(IndexShard replica) throws IOException {
        ) throws IOException {
        Request extends ReplicationRequest<Request>,
        // to be overridden by subclasses  
import org.opensearch.cluster.node.DiscoveryNodeRole;
            }
        long maxSeqNoOfUpdatesOrDeletes
    }
        @Override  
        final Translog.Location location;  
            return Iterators.concat(replicas.iterator(), Collections.singleton(primary).iterator());
                getPrimaryShard().getLastKnownGlobalCheckpoint(),  
        }
        indexOnReplica(request, group, replica, group.primary.getPendingPrimaryTerm());
        public void recoverReplica(
                ShardRoutingState.INITIALIZING,
            globalCheckpointOnPrimary,  
            }
            getPrimary().removeRetentionLease(id, listener);
            );  
            IndexShardRoutingTable.Builder routingTable = new IndexShardRoutingTable.Builder(primary.shardId());
            public PrimaryResult(ReplicaRequest replicaRequest, Response finalResponse) {
                ActionListener<Void> listener
            return StreamSupport.stream(this.spliterator(), false).map(IndexShard::routingEntry).collect(Collectors.toList());
    }  
            globalCheckpointOnPrimary,  
                    assertEquals(DocWriteResponse.Result.CREATED, response.getResponse().getResult());  
    }  
         */  
            }  
import org.opensearch.indices.recovery.RecoverySettings;
import org.opensearch.action.support.PlainActionFuture;  
 * Unless required by applicable law or agreed to in writing,
        }  
                    request
                    }
    }  
                routingTable,
import org.opensearch.action.bulk.BulkItemRequest;  
                return getPrimaryShard().getReplicationGroup();
        );
            final IndexShard replica,
        Path remotePath = null;  
        }  
                bulkShardResponse -> bulkShardResponse.getResponses()[0]
                recoverReplica(replica, targetSupplier);  
import org.opensearch.action.support.replication.ReplicationRequest;  
            request.getRefreshPolicy(),
            executeShardBulkOnReplica(
        public synchronized void flush() {  
                })  
            super(request, listener, group, "resync");
                getPrimaryShard().updateGlobalCheckpointForShard(allocationId, globalCheckpoint);
        String mappings,
         * If the targets is updated to include the given replica, a replication action would
            final IndexShardRoutingTable routingTable = routingTable(Function.identity());  
            ActionListener.completeWith(listener, () -> {
            );
                    ? IndexShardTestUtils.getFakeRemoteEnabledDiscoveryNodes(routingTable(Function.identity()).getShards())
            replica.updateRetentionLeasesOnReplica(request.getRetentionLeases());  
import java.util.concurrent.CopyOnWriteArrayList;
            primary = reinitShard(primary, remotePath);  
        public void syncGlobalCheckpoint() {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replicas)
        }  
        return result;
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * The OpenSearch Contributors require contributions made to  
            if (primary.indexSettings() != null && primary.indexSettings().isAssignedOnRemoteNode()) {
        private final String opType;
import org.opensearch.cluster.routing.ShardRoutingState;  
        return res.get();
                    adaptResponse(result.finalResponse, getPrimaryShard());
                listener.onResponse(null);  
            public void failShardIfNeeded(  
import org.opensearch.core.index.shard.ShardId;  
                request,  
import java.util.List;  
                .map(ShardRouting::allocationId)
                markAsRecovering,  
            return executeWriteRequest(indexRequest, indexRequest.getRefreshPolicy());
                replica.persistRetentionLeases();
            }
        IndexShard primary,
            }
            }  
                String message,  
        ResyncAction(ResyncReplicationRequest request, ActionListener<ResyncReplicationResponse> listener, ReplicationGroup group) {
            try (Releasable ignored = acquirePermitFuture.actionGet()) {
            final ShardRouting replicaRouting = createShardRouting("s" + replicaId.incrementAndGet(), false);
    protected ReplicationGroup createGroup(int replicas, Settings settings, EngineFactory engineFactory) throws IOException {
                threadPool,  
            shardRoutings().stream().map(transformer).forEach(routingTable::addShard);  
            IndexMetadata.Builder newMetadata = IndexMetadata.builder(indexMetadata).primaryTerm(shardId.id(), newTerm);  
import org.opensearch.action.support.WriteRequest;
    protected final String indexMapping = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": {} }";
            }
                throw new UnsupportedOperationException("failing shard " + replica + " isn't supported. failure: " + message, exception);
            public void setShardInfo(ReplicationResponse.ShardInfo shardInfo) {  
            id,
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        }
        Request request
            });
            replica,
            public ReplicaRequest replicaRequest() {
                        request,  
        }  
 *
            super(request, listener, replicationGroup, "indexing");  
        }  
            primary.updateShardState(  
        long operationPrimaryTerm,
            GlobalCheckpointSyncAction.Request request,
            return numOfDoc;
            this.replicas = replicas;
import org.opensearch.common.settings.ClusterSettings;  
import org.opensearch.action.bulk.BulkItemResponse;
 * not use this file except in compliance with the License.
            request
public abstract class OpenSearchIndexLevelReplicationTestCase extends IndexShardTestCase {
            remotePath,  
        class PrimaryRef implements ReplicationOperation.Primary<Request, ReplicaRequest, PrimaryResult> {
        }
        try (Releasable ignored = permitAcquiredFuture.actionGet()) {
        private synchronized Set<String> activeIds() {
            MergedSegmentPublisher.EMPTY
        /**
            return replicationTargets;  
        IndexMetadata.Builder metadata = IndexMetadata.builder(index.getName())  
        }
        ResyncReplicationRequest request,  
            } catch (Exception e) {  
import org.opensearch.action.support.replication.FanoutReplicationProxy;
                listener
        protected void performOnReplica(BulkShardRequest request, IndexShard replica) throws Exception {
import org.opensearch.core.action.ActionListener;  
        }
            }
import org.opensearch.action.support.replication.ReplicationResponse;
import org.opensearch.index.shard.IndexShard;  
                closed = true;
            return task;
    private <Request extends ReplicatedWriteRequest & DocWriteRequest> BulkShardRequest executeReplicationRequestOnPrimary(
                    primaryTerm,
            return routingTable.build();
    }  
                request  
            new BulkItemRequest[] { new BulkItemRequest(0, request) }  
                return replicaRequest;
        replica.acquireReplicaOperationPermit(
                }),  
        EngineFactory engineFactory,  
        public IndexShard addReplica(Path remotePath) throws IOException {  
    public void indexOnReplica(BulkShardRequest request, ReplicationGroup group, IndexShard replica) throws Exception {  
            replicas = new CopyOnWriteArrayList<>();  
                indexMetadata,
            primary,
                listener,
        private void updateAllocationIDsOnPrimary() throws IOException {
            return TestShardRouting.newShardRouting(  
    }
                recoverReplica(replica);  
                    return replica;
                noopMappingUpdater,
        @Override
        }
import org.opensearch.core.index.Index;
            );  
        }
        final PlainActionFuture<Releasable> permitAcquiredFuture = new PlainActionFuture<>();  
        IndexShard replica,
                getPrimaryShard().getLastKnownGlobalCheckpoint(),
            return replica;
                shardId,
    protected final Index index = new Index("test", "uuid");  
        public synchronized RetentionLease renewRetentionLease(String id, long retainingSequenceNumber, String source) {
                new RetentionLeaseSyncAction.Request(shardId, leases),
            );
                String allocationId,
                    threadPool,  
 */  
    private void executeShardBulkOnReplica(
        IndexMetadata metadata = buildIndexMetadata(replicas, settings, mappings);
                new ReplicationOperation<>(request, new PrimaryRef(), ActionListener.map(listener, result -> {  
            (shardId, primaryAllocationId, primaryTerm, retentionLeases, listener) -> syncRetentionLeases(
import org.opensearch.indices.recovery.RecoveryState;
                replica,
import java.util.Set;
        }
                throw new AssertionError("failed to execute retention lease request on replica [" + replica.routingEntry() + "]", e);  
     * Executes the delete request on the given replica shard.  
            return fut;
                ActionTestUtils.assertNoFailureListener(result -> {  
                return new PrimaryResult(result.replicaRequest(), result.finalResponseIfSuccessful);
            ActionListener<PrimaryResult> listener
        public IndexMetadata getIndexMetadata() {  
        }  
            );
 * You may obtain a copy of the License at  
                return getPrimaryShard().getMaxSeqNoOfUpdatesOrDeletes();  
            acquirePermitFuture,
            computeReplicationTargets();  
                primary,  
import java.util.Iterator;
                    final List<DocIdSeqNoAndSource> docsOnPrimary = getDocIdAndSeqNos(primary);
                primaryReplicaSyncer.resync(shard, new ActionListener<PrimaryReplicaSyncer.ResyncTask>() {
        Settings settings = Settings.builder()
    class ResyncAction extends ReplicationAction<ResyncReplicationRequest, ResyncReplicationRequest, ResyncReplicationResponse> {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                    public void onResponse(PrimaryReplicaSyncer.ResyncTask resyncTask) {
    }  
            });
            }
    }
            @Override
                getPrimaryShard().updateLocalCheckpointForShard(allocationId, checkpoint);
import org.opensearch.cluster.routing.ShardRoutingHelper;
                return getPrimaryShard().routingEntry();
            term,
        }  
 *  
            IndexShardRoutingTable routingTable = routingTable(shr -> shr == replica.routingEntry() ? primaryRouting : shr);
            public void markShardCopyAsStaleIfNeeded(
 * SPDX-License-Identifier: Apache-2.0
        private final AtomicInteger docId = new AtomicInteger();  
            public void updateGlobalCheckpointForShard(String allocationId, long globalCheckpoint) {  
                } catch (AlreadyClosedException ignored) {}
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet()),  
            @Override
        }
        public Future<Void> asyncRecoverReplica(
    protected ReplicationGroup createGroup(
                } else if (response.isFailed() == false) {  
import org.opensearch.action.resync.ResyncReplicationResponse;  
            remotePath = createTempDir();
            ).execute();
                    throw new AssertionError(e);
                replicationGroup,  
import java.util.function.BiConsumer;  
                    builder.add(IndexShardTestUtils.getFakeDiscoNode(replica.routingEntry().currentNodeId()));
            @Override
        }
        }  
                replicationTargets.addReplica(replica);
    ) throws IOException {
        }
        public synchronized void refresh(String source) {  
        }  
            try {
            }  
        executeShardBulkOnReplica(  
            if (removed) {  
                primaryReplicaSyncer,  
    }
            @Override
                    ActionListener.delegateFailure(listener, (delegatedListener, releasable) -> {  
        }
import org.opensearch.common.settings.Settings;
     */
import org.opensearch.index.shard.IndexShardTestCase;
            PlainActionFuture<ReplicationResponse> listener = new PlainActionFuture<>();
            primary.updateShardState(
        GlobalCheckpointSyncAction.Request,
        /**
            super(  
        protected EngineFactory getEngineFactory(ShardRouting routing) {  
        GlobalCheckpointSyncAction.Request,
            executeResyncOnReplica(
            recoverPrimary(primary);
            ActionListener.completeWith(listener, () -> {
            public long computedGlobalCheckpoint() {  
        }  
            for (IndexShard replica : replicas) {
        protected IndexerFactory getIndexerFactory(ShardRouting routing) {
            public org.opensearch.index.shard.ReplicationGroup getReplicationGroup() {
        }
            recoverReplica(replica, targetSupplier, true);
                null,
                getPrimaryShard().getPendingPrimaryTerm(),
                primary.routingEntry(),
        public synchronized IndexShard addReplicaWithExistingPath(final ShardPath shardPath, final String nodeId) throws IOException {  
        private synchronized void computeReplicationTargets() {
            }
        return createGroup(replicas, settings, indexMapping, engineFactory);
import java.util.stream.Collectors;  
                this.finalResponse = finalResponse;  
            for (int i = 0; i < indexMetadata.getNumberOfReplicas(); i++) {  
            group.primary.getPendingPrimaryTerm(),  
                acquirePermitFuture,
            DefaultRecoverySettings.INSTANCE,
            final FutureTask<Void> task = new FutureTask<>(() -> {
            indexMetadata = newMetadata.build();
    ) throws Exception {
            return new EngineConfigFactory(indexSettings);  
        protected IndexShard getPrimaryShard() {
        protected ReplicationGroup(final IndexMetadata indexMetadata, Path remotePath) throws IOException {
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            promoteReplicaToPrimary(replica, (shard, listener) -> {  
            }  
            final IndexShard replica = newShard(
            }
import static org.hamcrest.Matchers.equalTo;
        private ReplicationTargets getReplicationTargets() {
                new ResyncReplicationResponse(),  
                activeIds(),
            }  
            public void updateLocalCheckpointForShard(String allocationId, long checkpoint) {
                newTerm,
     * indexes the given requests on the supplied primary, modifying it for replicas
    }  
                final long maxSeqNoOfUpdatesOrDeletes,
        ReplicationResponse> {  
            MappingUpdatePerformer noopMappingUpdater = (update, shardId, listener1) -> {};
        }
                nodeId,
        }
            for (IndexShard shard : this) {
            mappings,  
                primary.getPendingPrimaryTerm(),
        };
        );
        @Override
            replica,
                generateFakeDiscoveryNodes()
            public ShardRouting routingEntry() {
            BulkShardRequest request = new BulkShardRequest(shardId, refreshPolicy, items);  
                new GlobalCheckpointSync(listener, this).execute();
            final long newTerm = indexMetadata.primaryTerm(shardId.id()) + 1;
                ((IndexRequest) itemRequest.request()).process(Version.CURRENT, null, index.getName());
            replicas.add(newReplica);
        }
        return executeReplicationRequestOnPrimary(primary, request);  
            }
            primary.markAsRecovering("store", new RecoveryState(primary.routingEntry(), pNode, null));
            shardId,
    protected IndexMetadata buildIndexMetadata(int replicas) throws IOException {
            }
                if (replicaShard.routingEntry().initializing()) {
                    }),
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000))  
    }
        Settings settings,  
                final TransportWriteAction.WritePrimaryResult<ResyncReplicationRequest, ResyncReplicationResponse> result =
        return buildIndexMetadata(replicas, indexMapping);  
        }
                MergedSegmentPublisher.EMPTY
                finalResponse.setShardInfo(shardInfo);
import org.opensearch.action.support.replication.TransportReplicationAction.ReplicaResponse;  
import org.opensearch.cluster.node.DiscoveryNodes;  
 * the Apache License, Version 2.0 (the "License"); you may
            public void perform(Request request, ActionListener<PrimaryResult> listener) {
                temp = new HashSet<>(replicaIds);  
import org.opensearch.index.IndexSettings;
import org.opensearch.tasks.TaskManager;
            ActionListener<ReplicationResponse> listener  
            this.replicationTargets = group.getReplicationTargets();  
                ShardRouting replica,
                    logger,
        protected void performOnPrimary(  
        public synchronized void addReplica(IndexShard replica) throws IOException {
        return new ReplicationGroup(metadata);
            ActionListener<PrimaryResult> listener  
import java.io.IOException;  
                        fut.onResponse(resyncTask);  
                ShardId shardId,  
            throw new AssertionError("replica [" + replicaRouting + "] is not found; replicas[" + replicas + "] primary[" + primary + "]");
                primary,  
                null,
                getReplicationFunc(replica)  
            if (replicationTargets != null) {
                            );  
            maxSeqNoOfUpdatesOrDeletes,
            }
        }
                ShardRoutingState.INITIALIZING,
            DiscoveryNodes.Builder builder = new DiscoveryNodes.Builder();
            @Override
                    ThreadPool.Names.WRITE,  
        ) {
            RetentionLeaseSyncAction.Request request,  
            }
        protected void syncRetentionLeases(ShardId shardId, RetentionLeases leases, ActionListener<ReplicationResponse> listener) {  
    IndexRequest copyIndexRequest(IndexRequest inRequest) throws IOException {
        EngineFactory engineFactory,
                                new ReplicaResponse(replica.getLocalCheckpoint(), replica.getLastKnownGlobalCheckpoint())
            }  
                        try {
            }
        return createGroup(replicas, settings, mappings, engineFactory, DefaultRecoverySettings.INSTANCE, MergedSegmentPublisher.EMPTY);
                retentionLeases,
                shardId,
            }
    protected IndexMetadata buildIndexMetadata(int replicas, Settings indexSettings, String mappings) throws IOException {
                );
    protected IndexMetadata buildIndexMetadata(int replicas, String mappings) throws IOException {  
            }  
            return builder.build();
        protected class PrimaryResult implements ReplicationOperation.PrimaryResult<ReplicaRequest> {  
}
        }
            long retainingSequenceNumber,
            IndexShardRoutingTable routingTable = routingTable(shr -> shr == primary.routingEntry() ? startedRoutingEntry : shr);
        MergedSegmentPublisher mergedSegmentPublisher
        RecoverySettings recoverySettings,  
            );
                }),
                getPrimary().getMaxSeqNoOfUpdatesOrDeletes(),  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        GlobalCheckpointSync(final ActionListener<ReplicationResponse> listener, final ReplicationGroup replicationGroup) {
                primary,
            @Override  
import org.opensearch.index.seqno.RetentionLeaseSyncer;
            computeReplicationTargets();
                computeReplicationTargets();
import java.util.function.BiFunction;
import org.opensearch.action.support.replication.TransportWriteActionTestHelper;
                getIndexerFactory(replicaRouting),  
         * be able to find this replica to execute write requests on it.
        private BulkItemResponse executeWriteRequest(DocWriteRequest<?> writeRequest, WriteRequest.RefreshPolicy refreshPolicy)  
            group.primary.getMaxSeqNoOfUpdatesOrDeletes()
/*  
    }
    /**
            return removed;
        private synchronized IndexShardRoutingTable routingTable(Function<ShardRouting, ShardRouting> transformer) {
            @Override
        }
                request,  
        ReplicaRequest extends ReplicationRequest<ReplicaRequest>,
            return newReplica;  
                TransportResyncReplicationAction.performOnPrimary(request),
        public synchronized RetentionLease addRetentionLease(
                currentClusterStateVersion.incrementAndGet(),
        protected void performOnPrimary(
        public synchronized void removeRetentionLease(String id, ActionListener<ReplicationResponse> listener) {  
        final PlainActionFuture<BulkShardRequest> res = new PlainActionFuture<>();
            }
                retentionLeaseSyncer,  
        }
                        } catch (final Exception e) {
        TransportWriteActionTestHelper.performPostWriteActions(replica, request, location, logger);
                remotePath  
        private final RetentionLeaseSyncer retentionLeaseSyncer = new RetentionLeaseSyncer(
            IndexShard replica,
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
            id,
            primary = replica;
                () -> {},  
            new SyncRetentionLeases(
import org.opensearch.core.common.io.stream.StreamInput;
     * Executes the delete request on the primary, and modifies it for replicas.  
        protected void performOnReplica(RetentionLeaseSyncAction.Request request, IndexShard replica) throws Exception {
                getPrimary().getOperationPrimaryTerm(),
            }
            items[0] = new BulkItemRequest(0, writeRequest);
                if (response.isFailed()) {  
                primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE
                primary,
            ) {  
            return listener.get();
        ) throws IOException {
                try {
        private volatile ReplicationTargets replicationTargets;
            replicas,
        ) {  
            listener.onFailure(e);
        }
        @Override
            group.primary.getLastKnownGlobalCheckpoint(),  
        final Translog.Location location;
        public void startPrimary() throws IOException {  
                        logger
        BulkShardRequest request,  
        for (BulkItemRequest itemRequest : request.items()) {
import org.opensearch.action.support.replication.TransportReplicationAction;
            BiConsumer<IndexShard, ActionListener<PrimaryReplicaSyncer.ResyncTask>> primaryReplicaSyncer  
import org.opensearch.index.shard.IndexShardTestUtils;
            this(indexMetadata, null);
                } else {
                this.replicaRequest = replicaRequest;
            updateAllocationIDsOnPrimary();
        IndexShard primary,  
                Set<String> temp = new HashSet<>(primaryIds);  
        public synchronized List<ShardRouting> shardRoutings() {
                () -> {},
            final ShardRouting primaryRouting = this.createShardRouting("s0", true);  
                return new IndexRequest(in);  
                return new PrimaryResult(request, new RetentionLeaseSyncAction.Response());  
        }
        }
        executeShardBulkOnReplica(
                indexMetadata,
            }  
    protected ReplicationGroup createGroup(
        long maxSeqNoOfUpdatesOrDeletes  
        return createGroup(  
        protected void performOnPrimary(IndexShard primary, ResyncReplicationRequest request, ActionListener<PrimaryResult> listener) {  
        RetentionLeaseSyncAction.Response> {  
            recoverReplica(replica, (r, sourceNode) -> new RecoveryTarget(r, sourceNode, recoveryListener, threadPool));
    private void executeShardBulkOnPrimary(  
        private IndexMetadata indexMetadata;  
                return new PrimaryResult(request, new ReplicationResponse());
        public int appendDocs(final int numOfDoc) throws Exception {  
import java.util.HashSet;
                        break;  
        @Override
        @Override
            .build();
                            delegatedListener.onResponse(
            );  
 * license agreements. See the NOTICE file distributed with
        long globalCheckpointOnPrimary,  
import org.opensearch.common.lease.Releasables;
        }
        public Future<PrimaryReplicaSyncer.ResyncTask> promoteReplicaToPrimary(IndexShard replica) throws IOException {
            this.listener = listener;
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            );  
            }  
            );
                listener.onFailure(e);
    BulkShardRequest deleteOnPrimary(DeleteRequest request, IndexShard primary) throws Exception {
                retentionLeaseSyncer,
                replicationTargets.addReplica(newReplica);  
        private final AtomicInteger replicaId = new AtomicInteger();
        public IndexShard addReplica(Path remotePath, RecoverySettings recoverySettings) throws IOException {  
            updateAllocationIDsOnPrimary();
                }  
            if (replicationTargets != null) {  
                replicaRouting,  
            }  
        TransportWriteActionTestHelper.performPostWriteActions(replica, request, location, logger);  
        public synchronized void close() throws Exception {  
        }  
        public synchronized List<IndexShard> getReplicas() {  
                    listener.onResponse((TransportWriteAction.WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result);
            ShardRouting primaryRouting = replica.routingEntry().moveActiveReplicaToPrimary();  
                    TimeValue.timeValueMillis(20),  
        ) throws IOException {
import org.opensearch.index.seqno.GlobalCheckpointSyncAction;
            replicas.add(replica);
                ThreadPool.Names.SAME,
            @Override
import org.opensearch.cluster.routing.ShardRouting;
            BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier,  
            throws IOException {  
                IndexShard replica = replicationTargets.findReplicaShard(replicaRouting);
            addReplica(replica);
                    recoverReplica(replicaShard);  
        );  
import org.opensearch.action.DocWriteResponse;
        protected ReplicationGroup(final IndexMetadata indexMetadata) throws IOException {
                final long primaryTerm,
            public void runPostReplicationActions(ActionListener<Void> listener) {
            final ReplicaRequest replicaRequest;
        }
                    throw new AssertionError("failed to background sync retention lease", e);
                EMPTY_EVENT_LISTENER,
import org.opensearch.index.shard.ShardPath;
                primary,  
        } catch (Exception e) {  
    }
        public synchronized void reinitPrimaryShard(Path remotePath) throws IOException {
        TransportWriteActionTestHelper.performPostWriteActions(primary, request, result.location, logger);  
        replica.acquireReplicaOperationPermit(
            ActionListener.completeWith(listener, () -> {
                Set<String> replicaIds = getShardDocUIDs(replica);
        public synchronized DiscoveryNodes generateFakeDiscoveryNodes() {  
                listener,
import org.opensearch.indices.recovery.RecoveryTarget;  
            return addReplica((Path) null);  
import org.opensearch.cluster.routing.RecoverySource;  
 * Modifications Copyright OpenSearch Contributors. See
        return buildIndexMetadata(replicas, Settings.EMPTY, mappings);
                long primaryTerm,
            executeShardBulkOnPrimary(
        }
            location = TransportResyncReplicationAction.performOnReplica(request, replica);
import org.opensearch.action.support.replication.PendingReplicationActions;  
                    return result.finalResponse;
        final PlainActionFuture<Releasable> permitAcquiredFuture = new PlainActionFuture<>();
import java.nio.file.Path;
                return getPrimaryShard().getLastKnownGlobalCheckpoint();
                        listener.onFailure(e);
                final IndexRequest indexRequest = new IndexRequest(index.getName()).source("{}", MediaTypeRegistry.JSON);
        throws IOException {
        return createGroup(replicas, settings, mappings, engineFactory, recoverySettings, remotePath, mergedSegmentPublisher);
            ShardRouting startedRoutingEntry = ShardRoutingHelper.moveToStarted(primary.routingEntry());  
        }  
import org.opensearch.cluster.routing.AllocationId;
                    }
        ) {
                primaryRouting,
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.action.support.ActionTestUtils;
    protected DiscoveryNode getDiscoveryNode(String id) {
                            releasable.close();  
            (shardId, primaryAllocationId, primaryTerm, retentionLeases) -> syncRetentionLeases(
        private ShardRouting createShardRouting(String nodeId, boolean primary) {
            );
            this.request = request;
        @Override  
        final IndexShard primary;  
            PlainActionFuture<BulkItemResponse> listener = new PlainActionFuture<>();
                updateAllocationIDsOnPrimary();
import org.opensearch.action.support.replication.ReplicatedWriteRequest;
    protected class ReplicationGroup implements AutoCloseable, Iterable<IndexShard> {
                retentionLeaseSyncer,
            @Override
        }
                        ((TransportWriteAction.WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result).location,
                targetSupplier,
                routingTable,  
                        primary,
        }
            return indexMetadata;
            request,
            return primary;
        final PlainActionFuture<Releasable> acquirePermitFuture = new PlainActionFuture<>();  
            ReplicationGroup group,
            operationPrimaryTerm,
import org.opensearch.common.collect.Iterators;
                : "replica with aId [" + replica.routingEntry().allocationId() + "] already exists";
            .settings(settings)
                primary.persistRetentionLeases();
                    .source("{}", MediaTypeRegistry.JSON);
            settings,
        protected ReplicationGroup(  
                    }  
            @Override  
    }
import org.opensearch.threadpool.ThreadPool.Names;
            primary.updateShardState(  
                retentionLeaseSyncer,
        }
            if (itemRequest.request() instanceof IndexRequest) {  
            return executeWriteRequest(deleteRequest, deleteRequest.getRefreshPolicy());  
            final Set<String> inSyncIds = activeIds();
            request
            }
import org.opensearch.index.engine.EngineConfigFactory;
import org.opensearch.common.lease.Releasable;
                indexMetadata,  
                ).execute();  
            } else {
                currentClusterStateVersion.incrementAndGet(),  
                request,
                    builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(replica.routingEntry().currentNodeId()));  
                }  
        IndexShard primary,  
    }
 * GitHub history for details.
        String mappings,
        public void executeRetentionLeasesSyncRequestOnReplica(RetentionLeaseSyncAction.Request request, IndexShard replica) {
        public synchronized int startReplicas(int numOfReplicasToStart) throws IOException {
                null,
                });
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
        protected synchronized void recoverPrimary(IndexShard primary) {  
    private void executeResyncOnReplica(
            for (IndexShard replica : replicas) {  
                if (response.isFailed()) {
        SyncRetentionLeases(
                .filter(ShardRouting::active)
                primary.indexSettings().isRemoteTranslogStoreEnabled()
                            delegatedListener.onFailure(e);  
    /**  
            @Override
        }
            ActionListener.map(res, TransportReplicationAction.PrimaryResult::replicaRequest)  
            }  
            request,  
        }  
                this,  
            }  
    }
    class SyncRetentionLeases extends ReplicationAction<  
                    for (IndexShard replica : replicas) {
                    );  
            final ActionListener<BulkShardResponse> wrapBulkListener = ActionListener.map(  
            if (closed == false) {
     */
        }
                final ReplicaRequest request,
import org.opensearch.index.engine.InternalEngineFactory;  
        protected void performOnReplica(ResyncReplicationRequest request, IndexShard replica) throws Exception {  
            );
        ReplicationTargets(IndexShard primary, List<IndexShard> replicas) {  
                performOnPrimary(getPrimaryShard(), request, listener);  
import org.opensearch.action.bulk.BulkShardRequest;
                null
import org.opensearch.action.bulk.MappingUpdatePerformer;
                computeReplicationTargets();
        return new DiscoveryNode(  
import java.util.concurrent.FutureTask;
            HashSet<String> activeIds = new HashSet<>();  
        }  
        }
        );
                shardRouting,
                    TransportWriteActionTestHelper.performPostWriteActions(
            ThreadPool.Names.SAME,  
    ) throws IOException {
                assertThat(replica.routingEntry() + " has extra docs", temp, empty());
            public void failShard(String message, Exception exception) {  
                remotePath,
            return getDiscoveryNode(primary.routingEntry().currentNodeId());
                        }
        try (Releasable ignored = acquirePermitFuture.actionGet()) {  
     */
            public void performOn(
        BulkShardRequest request,
                    new FanoutReplicationProxy<>(new ReplicasRef())
            location = TransportShardBulkAction.performOnReplica(request, replica);
            inRequest.writeTo(out);
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id(Integer.toString(docId.incrementAndGet()))  
        );
import org.opensearch.action.index.IndexRequest;
                replica,
            this.opType = opType;
            this.indexMetadata = indexMetadata;
        Settings settings,
                null,
            assert primary.routingEntry().active() : "only active replicas can be promoted to primary: " + primary.routingEntry();
                return getPrimaryShard().getLocalCheckpoint();  
                    throw response.getFailure().getCause();
                primaryRouting,
                assertThat(replica.routingEntry() + " is missing docs", temp, empty());
                    @Override  
         */  
 * this file be licensed under the Apache-2.0 license or a
                startedRoutingEntry,  
        }  
import org.opensearch.indices.recovery.DefaultRecoverySettings;  
        public synchronized IndexShard getPrimary() {
            replica.acquireReplicaOperationPermit(  
                final BulkItemResponse response = index(indexRequest);  
 * KIND, either express or implied.  See the License for the
            for (int doc = 0; doc < numOfDoc; doc++) {
        }  
                ActionListener.map(listener, result -> new PrimaryResult(result.replicaRequest(), result.finalResponseIfSuccessful))
            return new InternalEngineFactory();
            ActionListener<RetentionLeaseSyncAction.Response> listener
            RetentionLeaseSyncAction.Request request,
        protected void adaptResponse(Response response, IndexShard indexShard) {
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
    protected abstract class ReplicationAction<  
/*  
            assert shardRoutings().stream().anyMatch(shardRouting -> shardRouting.isSameAllocation(replica.routingEntry())) == false  
import org.opensearch.action.DocWriteRequest;  
        }  
 * this work for additional information regarding copyright
            for (IndexShard shard : this) {
        }
import java.util.concurrent.atomic.AtomicInteger;
            Version.CURRENT  
    }
        public synchronized void assertAllEqual(int expectedCount) throws IOException {
            return replica;  
                final ActionListener<ReplicationOperation.ReplicaResponse> listener
                getIndexerFactory(replicaRouting),  
        }
                    globalCheckpoint,
                logger
            } catch (Exception e) {
            @Override
                .collect(Collectors.toSet());
import org.opensearch.action.delete.DeleteRequest;  
        }  
        final List<IndexShard> replicas;
                shardId,  
        }  
                return getPrimaryShard().getLastSyncedGlobalCheckpoint();
                activeIds(),
import org.opensearch.action.admin.indices.flush.FlushRequest;
            }
            ) {
                    getPrimaryShard().getPendingPrimaryTerm(),  
                getEngineConfigFactory(new IndexSettings(indexMetadata, indexMetadata.getSettings())),
                addReplica(remotePath, recoverySettings);
                retentionLeases,  
            final boolean removed = replicas.remove(replica);
        }
                    if (started > numOfReplicasToStart) {
    protected ReplicationGroup createGroup(int replicas, Settings settings, String mappings, EngineFactory engineFactory)
    }  
                null,
            public PendingReplicationActions getPendingReplicationActions() {  
        private ActionListener<Response> listener;
            ),  
        ) {
                    assertEquals(DocWriteResponse.Result.CREATED, response.getResponse().getResult());
                indexMetadata,  
        );
            final IndexShard replica = newShard(
            TransportShardBulkAction.performOnPrimary(
        private final List<IndexShard> replicas;
            assertThat(primaryIds.size(), equalTo(expectedCount));  
                    maxSeqNoOfUpdatesOrDeletes,
        public int indexDocs(final int numOfDoc) throws Exception {
                System::currentTimeMillis,  
            activeIds.addAll(activeIds());
            threadPool.generic().execute(task);  
                primary.getPendingPrimaryTerm(),
                    executeResyncOnPrimary(primary, request);  
        public Iterator<IndexShard> iterator() {  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        public void execute() {
import org.opensearch.threadpool.ThreadPool;  
            }
            );
                getPrimaryShard().getMaxSeqNoOfUpdatesOrDeletes()
            } catch (Exception e) {
            for (final IndexShard replica : replicas) {
            // Update the status of the replicas in the routing table to IndexShardState.STARTED.
                getIndexerFactory(shardRouting),  
                builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(primary.routingEntry().currentNodeId()));  
                }  
        protected void performOnReplica(final GlobalCheckpointSyncAction.Request request, final IndexShard replica) throws IOException {  
            for (int doc = 0; doc < numOfDoc; doc++) {
                temp.removeAll(primaryIds);
                        fut.onFailure(e);  
            new TransportWriteAction.WritePrimaryResult<>(
            this(indexMetadata, DefaultRecoverySettings.INSTANCE, remotePath, MergedSegmentPublisher.EMPTY);  
        public IndexShard addReplica() throws IOException {
            return new EngineBackedIndexerFactory(getEngineFactory(routing));
        protected EngineConfigFactory getEngineConfigFactory(IndexSettings indexSettings) {
        }
        private final ReplicationTargets replicationTargets;  
import org.opensearch.index.mapper.MapperService;  
        Path remotePath,
                throw new AssertionError(e);
            @Override
                }
        executeShardBulkOnPrimary(  
    }
    }  
            int started = 0;  
                nodeId,  
import org.opensearch.common.unit.TimeValue;
            );  
            super(request, listener, group, "sync-retention-leases");
import java.util.Collections;  
import static org.hamcrest.Matchers.empty;  
            )
                builder.add(IndexShardTestUtils.getFakeDiscoNode(primary.routingEntry().currentNodeId()));
        }
                    : IndexShardTestUtils.getFakeDiscoveryNodes(routingTable(Function.identity()).getShards())  
import org.opensearch.cluster.node.DiscoveryNode;
        long globalCheckpointOnPrimary,
        );
                            performOnReplica(request, replica);
        @Override
            return Collections.unmodifiableList(replicas);
import org.opensearch.index.shard.PrimaryReplicaSyncer;  
            bulkShardRequest,
import org.apache.lucene.store.AlreadyClosedException;
                null,
        IndexShard replica,
            activeIds.add(primary.routingEntry().allocationId().getId());
            BulkItemRequest[] items = new BulkItemRequest[1];
        }  
            OpenSearchIndexLevelReplicationTestCase.this.recoverUnstartedReplica(
    ) throws Exception {
import java.util.ArrayList;
                Names.WRITE
            (request, parentTask, primaryAllocationId, primaryTerm, listener) -> {
                inSyncIds,
import org.opensearch.action.resync.ResyncReplicationRequest;
        }
            @Override
                getPrimaryShard().getMaxSeqNoOfUpdatesOrDeletes()  
            Path remotePath,  
                ActionListener.map(listener, r -> new ReplicationResponse())
                temp.removeAll(replicaIds);
                return engineFactory;  
                shard.refresh(source);
        }
                shardId,
        }  
                throw new UnsupportedOperationException("can't mark " + shardId + ", aid [" + allocationId + "] as stale");
