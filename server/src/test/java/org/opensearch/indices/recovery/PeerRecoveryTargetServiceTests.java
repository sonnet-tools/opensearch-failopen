            indexMetadata = IndexMetadata.builder(shard.indexSettings().getIndexMetadata())
                shard.getOperationPrimaryTerm(),
                shard.shardId(),
        // good copy
        recoveryTarget.cleanFiles(
        IndexShard shard = newStartedShard(false);
import org.opensearch.index.seqno.SeqNoStats;
 * Licensed to Elasticsearch under one or more contributor
        Store.MetadataSnapshot sourceSnapshot = sourceShard.store().getMetadata();
import java.util.ArrayList;
        if (safeCommit.isPresent()) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
                            md,
        assertThat(replica.getLastKnownGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
            "foo",
        recoveryTarget.decRef();
            );
            sourceSnapshot,
        shard.markAsRecovering("for testing", new RecoveryState(shard.routingEntry(), localNode, localNode));
        assertThat(replica.recoveryState().getTranslog().totalLocal(), equalTo(expectedTotalLocal));
import org.opensearch.common.util.io.IOUtils;
            indexMetadata = IndexMetadata.builder(shard.indexSettings().getIndexMetadata())
        closeShards(sourceShard, targetShard);
                while ((op = snapshot.next()) != null) {
        queue.addAll(requests);
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
        }
                    requests.add(
        DiscoveryNode localNode = new DiscoveryNode(
                }
        final RecoveryTarget recoveryTarget = new RecoveryTarget(targetShard, null, null, threadPool);
            }
 * ownership. Elasticsearch licenses this file to you under
        long startingSeqNo = shard.recoverLocallyAndFetchStartSeqNo(true);
        );
        List<StoreFileMetadata> mdFiles = new ArrayList<>();
        }
        if (safeCommit.get().localCheckpoint < globalCheckpoint) {
        );
    public void testWriteFileChunksConcurrently() throws Exception {
 * specific language governing permissions and limitations
        List<Long> seqNos = LongStream.range(0, 100).boxed().collect(Collectors.toList());
import org.opensearch.cluster.routing.ShardRoutingHelper;
            logger,
                .build();
        assertThat(replica.recoverLocallyAndFetchStartSeqNo(true), equalTo(safeCommit.get().localCheckpoint + 1));
        }
                1,
                int pos = 0;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        shard = newStartedShard(false);
import org.opensearch.index.shard.IndexShardTestCase;
import org.apache.lucene.store.IOContext;
import java.util.UUID;
        long globalCheckpoint = populateRandomData(shard).getGlobalCheckpoint();
        // copy with truncated translog
        final SeqNoStats seqNoStats = populateRandomData(shard);
            Version.CURRENT
 * Modifications Copyright OpenSearch Contributors. See
        for (StoreFileMetadata md : sourceSnapshot) {
 *
            Collections.emptyList(),
                .build();
 *
 * software distributed under the License is distributed on an
            replica.getPendingPrimaryTerm()
            "foo",
        assertThat(replica.recoveryState().getTranslog().recoveredOperations(), equalTo(0));
            new EngineConfigFactory(shard.indexSettings()),
import org.opensearch.common.Randomness;
        RecoveryTarget recoveryTarget = new RecoveryTarget(shard, null, null, threadPool);
        shard.store().markStoreCorrupted(new IOException("test"));
            try (Translog.Snapshot snapshot = getTranslog(shard).newSnapshot(safeCommit.get().localCheckpoint + 1, globalCheckpoint)) {
                    if (op.seqNo() <= globalCheckpoint) {
        for (long seqNo : seqNos) {
            replica.shardId(),
        long globalCheckpoint = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, shard.getLocalCheckpoint());
import org.opensearch.index.engine.EngineConfigFactory;
                            r.position(),
        shard.prepareForIndexRecovery();
                    FileChunkRequest r;
 * The OpenSearch Contributors require contributions made to
        shard.prepareForIndexRecovery();
                shard.getOperationPrimaryTerm()
            buildNewFakeTransportAddress(),
        Randomness.shuffle(seqNos);
            shard,
import org.opensearch.core.action.ActionListener;
        IndexShard replica = reinitShard(
import java.util.List;
            cleanFilesFuture
                            1
        assertThat(replica.recoveryState().getTranslog().totalLocal(), equalTo(0));
            assertThat(replica.recoveryState().getTranslog().totalLocal(), equalTo(0));
        recoveryTarget.receiveFileInfo(
        IndexShard shard = newShard(false);
/*
            populateRandomData(shard);
                    int length = between(1, Math.toIntExact(md.length() - pos));
        closeShards(shard);
        Store.RecoveryDiff diff = sourceSnapshot.recoveryDiff(targetSnapshot);
        Store.MetadataSnapshot targetSnapshot = targetShard.snapshotStoreMetadata();
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            Collections.emptySet(),
            );
            null
    }
 * SPDX-License-Identifier: Apache-2.0
        }
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(replica.recoverLocallyAndFetchStartSeqNo(true), equalTo(UNASSIGNED_SEQ_NO));
}
    }
            buildNewFakeTransportAddress(),
        final IndexMetadata indexMetadata;
            randomNonNegativeLong()
                    pos += length;
        shard.markAsRecovering("peer recovery", new RecoveryState(shard.routingEntry(), pNode, rNode));
        assertThat(replica.recoveryState().getStage(), equalTo(RecoveryState.Stage.TRANSLOG));
    }
            "foo",
        final DiscoveryNode pNode = IndexShardTestUtils.getFakeDiscoNode(sourceShard.routingEntry().currentNodeId());
                shard.shardPath().resolveTranslog(),
                            })
            globalCheckpoint,
                                throw new AssertionError(e);
            recoveryTarget,
            shard.applyIndexOperationOnReplica(
        recoveryTarget.decRef();
 * compatible open source license.
            Collections.emptyList(),
                .settings(shard.indexSettings().getSettings())
        }
            buildNewFakeTransportAddress(),
            }
        }
import org.apache.lucene.store.IndexInput;
        shard.updateGlobalCheckpointOnReplica(globalCheckpoint, "test");
        assertThat(replica.recoveryState().getTranslog().recoveredOperations(), equalTo(expectedTotalLocal));
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            }
        final DiscoveryNode rNode = IndexShardTestUtils.getFakeDiscoNode(targetShard.routingEntry().currentNodeId());
import org.opensearch.index.store.Store;
        );
        replica.prepareForIndexRecovery();
        assertThat(shard.recoveryState().getTranslog().recoveredOperations(), equalTo(0));
        assertThat(replica.recoverLocallyAndFetchStartSeqNo(true), equalTo(UNASSIGNED_SEQ_NO));
            Version.CURRENT
            ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE)
        assertThat(replica.getLastKnownGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
import org.opensearch.action.index.IndexRequest;
import static org.hamcrest.Matchers.sameInstance;
                try {
                new SourceToParse(shard.shardId().getIndexName(), UUIDs.randomBase64UUID(), new BytesArray("{}"), MediaTypeRegistry.JSON)
import org.opensearch.index.mapper.SourceToParse;
import org.opensearch.Version;
import java.util.Optional;
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.index.shard.IndexShardTestUtils;
        closeShards(replica);
 * under the License.
        assertThat(replica.getLastKnownGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
import org.opensearch.index.shard.IndexShard;
        for (int i = 0; i < numDocs; i++) {
        IndexShard shard = newStartedShard(false);
        receiveFileInfoFuture.actionGet();
        RecoveryTarget recoveryTarget = new RecoveryTarget(shard, null, null, threadPool);
        DiscoveryNode localNode = new DiscoveryNode(
        assertThat(replica.recoveryState().getTranslog().recoveredOperations(), equalTo(0));
            shard,
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
                            r.content(),
                    throw new AssertionError(e);
package org.opensearch.indices.recovery;
        long seqNo = 0;
/*
 * KIND, either express or implied.  See the License for the
        SeqNoStats seqNoStats = populateRandomData(shard);
    public void testPrepareIndexForPeerRecovery() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        final PlainActionFuture<Void> receiveFileInfoFuture = new PlainActionFuture<>();
            if (randomInt(100) < 5) {
            "foo",
                Translog.Operation op;
            mdFiles.add(md);
import org.opensearch.action.admin.indices.flush.FlushRequest;
        );
        assertTrue(safeCommit.isPresent());
                            pos + length == md.length(),
            indexMetadata,
        final IndexShard targetShard = newShard(false);
        );
        replica = reinitShard(shard, ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE));
            "foo",
        shard = reinitShard(shard, ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE));
            indexDoc(sourceShard, "_doc", Integer.toString(i));
        assertThat(request.metadataSnapshot(), sameInstance(Store.MetadataSnapshot.EMPTY));
 *
        }
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.empty;
        recoveryTarget.decRef();
                }
import org.opensearch.index.translog.Translog;
                seqNo,
        sourceShard.flush(new FlushRequest());
            Collections.emptyMap(),
        PlainActionFuture<Void> cleanFilesFuture = new PlainActionFuture<>();
        cleanFilesFuture.actionGet();
        closeShards(replica);
                            1,
            senders[i] = new Thread(() -> {
        Randomness.shuffle(requests);
        int expectedTotalLocal = 0;
        return shard.seqNoStats();
            Collections.emptyMap(),
        assertThat(replica.recoveryState().getTranslog().recoveredOperations(), equalTo(0));
            buildNewFakeTransportAddress(),
                            pos,
        assertTrue(safeCommit.isPresent());
                    barrier.await();
        shard.sync();
        if (randomBoolean()) {
                    }
            receiveFileInfoFuture
                            new BytesArray(buffer),
        shard.sync();
            sender.join();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        int numDocs = between(20, 100);
            buildNewFakeTransportAddress(),
            Long.parseLong(sourceSnapshot.getCommitUserData().get(SequenceNumbers.MAX_SEQ_NO)),
        assertThat(request.startingSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
        targetShard.markAsRecovering("test-peer-recovery", new RecoveryState(targetShard.routingEntry(), rNode, pNode));
        } else {
import java.util.concurrent.BlockingQueue;
        for (int i = 0; i < senders.length; i++) {
        );
        }
        String translogUUID = Translog.createEmptyTranslog(
        if (randomBoolean()) {
                    }
import java.util.concurrent.ArrayBlockingQueue;
                    in.readBytes(buffer, 0, length);
        DiscoveryNode pNode = new DiscoveryNode(
        shard = reinitShard(shard, ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE));
    public void testResetStartRequestIfTranslogIsCorrupted() throws Exception {
                UUID.randomUUID().toString(),
            Translog.createEmptyTranslog(
                    while ((r = queue.poll()) != null) {
            Collections.emptyMap(),
                            sourceShard.shardId(),
        assertThat(replica.recoveryState().getStage(), equalTo(RecoveryState.Stage.TRANSLOG));
        assertThat(diff.different, empty());
        // corrupted copy
            mdFiles.stream().map(StoreFileMetadata::length).collect(Collectors.toList()),
 * GitHub history for details.
                while (pos < md.length()) {
                    );
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
        assertThat(replica.recoverLocallyAndFetchStartSeqNo(true), equalTo(globalCheckpoint + 1));
        replica.store().associateIndexWithNewTranslog(translogUUID);
            0,
            Collections.emptySet(),
        assertThat(shard.recoverLocallyAndFetchStartSeqNo(true), equalTo(UNASSIGNED_SEQ_NO));
        shard.store().markStoreCorrupted(new IOException("simulated"));
    public void testResetStartingSeqNoIfLastCommitCorrupted() throws Exception {
            Collections.emptySet(),
        );
        assertThat(shard.recoveryState().getTranslog().totalLocal(), equalTo(RecoveryState.Translog.UNKNOWN));
            new EngineBackedIndexerFactory(NoOpEngine::new),
    private SeqNoStats populateRandomData(IndexShard shard) throws IOException {
    public void testClosedIndexSkipsLocalRecovery() throws Exception {
 */
import java.util.concurrent.CyclicBarrier;
            rNode,
            Version.CURRENT
                } catch (Exception e) {
 * not use this file except in compliance with the License.
        BlockingQueue<FileChunkRequest> queue = new ArrayBlockingQueue<>(requests.size());
        for (StoreFileMetadata md : mdFiles) {
                        expectedTotalLocal++;
    }
        closeShards(shard);
            Collections.emptySet(),
                            ActionListener.wrap(ignored -> {}, e -> {
                            r.totalTranslogOps(),
import java.util.stream.LongStream;
 * You may obtain a copy of the License at
        assertThat(replica.recoveryState().getTranslog().totalLocal(), equalTo(RecoveryState.Translog.UNKNOWN));
import org.opensearch.index.engine.NoOpEngine;
import org.opensearch.common.UUIDs;
        shard = newStartedShard(false);
        assertThat(replica.getLastKnownGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
                            r.metadata(),
            replica.shardPath().resolveTranslog(),
        replica.prepareForIndexRecovery();
            Version.CURRENT
public class PeerRecoveryTargetServiceTests extends IndexShardTestCase {
        shard.close("test", false, false);
        List<FileChunkRequest> requests = new ArrayList<>();
            mdFiles.stream().map(StoreFileMetadata::name).collect(Collectors.toList()),
    }
                            r.lastChunk(),
        }
        closeShards(replica);
                    byte[] buffer = new byte[length];
                            0,
        );
        } else if (randomBoolean()) {
        );
        closeShards(shard);
/*
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
            Version.CURRENT
            Collections.emptyMap(),
        );
                        new FileChunkRequest(
        Optional<SequenceNumbers.CommitInfo> safeCommit = shard.store().findSafeIndexCommit(globalCheckpoint);
        globalCheckpoint = randomFrom(UNASSIGNED_SEQ_NO, seqNoStats.getMaxSeqNo());
            Version.CURRENT
 */
        replica = reinitShard(shard, ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE));
        long globalCheckpoint = populateRandomData(shard).getGlobalCheckpoint();
        IndexShard replica = reinitShard(
        }
        if (randomBoolean()) {
        for (Thread sender : senders) {
        shard = newStartedShard(false);
    }
            0,
        Optional<SequenceNumbers.CommitInfo> safeCommit = shard.store().findSafeIndexCommit(globalCheckpoint);
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(request.metadataSnapshot().size(), equalTo(0));
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
                false,
 * this work for additional information regarding copyright
            Collections.emptyMap(),
        );
import org.opensearch.index.seqno.SequenceNumbers;
        IndexShard sourceShard = newStartedShard(true);
        } else {
        IndexShard shard = newStartedShard(false);
        shard.markAsRecovering("peer recovery", new RecoveryState(shard.routingEntry(), pNode, rNode));
                            seqNo++,
            senders[i].start();
        DiscoveryNode rNode = new DiscoveryNode(
            "foo",
        }
        safeCommit = replica.store().findSafeIndexCommit(globalCheckpoint);
        StartRecoveryRequest request = PeerRecoveryTargetService.getStartRecoveryRequest(logger, rNode, recoveryTarget, startingSeqNo);
                seqNoStats.getGlobalCheckpoint(),
        assertThat(shard.getLastKnownGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
        replica.prepareForIndexRecovery();
        shard.prepareForIndexRecovery();
                shard.flush(new FlushRequest().waitIfOngoing(true));
        Thread[] senders = new Thread[between(1, 4)];
                }
            shard.store().associateIndexWithNewTranslog(UUIDs.randomBase64UUID());
        // empty copy
        assertThat(request.startingSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
        populateRandomData(shard);
                        recoveryTarget.writeFileChunk(
            assertThat(replica.recoveryState().getTranslog().totalLocal(), equalTo(RecoveryState.Translog.UNKNOWN));
            ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE),
import org.opensearch.index.store.StoreFileMetadata;
        CyclicBarrier barrier = new CyclicBarrier(senders.length);
import org.opensearch.core.common.bytes.BytesArray;
import java.util.Collections;
        } else {
                .state(IndexMetadata.State.CLOSE)
            assertThat(replica.recoverLocallyAndFetchStartSeqNo(true), equalTo(safeCommit.get().localCheckpoint + 1));
        DiscoveryNode rNode = new DiscoveryNode(
            Collections.emptySet(),
import java.util.stream.Collectors;
        StartRecoveryRequest request = PeerRecoveryTargetService.getStartRecoveryRequest(
            Collections.emptyMap(),
            });
            IOUtils.rm(shard.shardPath().resolveTranslog());
import org.opensearch.cluster.routing.RecoverySource;
            buildNewFakeTransportAddress(),
 * this file be licensed under the Apache-2.0 license or a
        closeShards(replica);
                .settings(Settings.builder().put(shard.indexSettings().getSettings()).put(IndexMetadata.SETTING_BLOCKS_WRITE, true))
import org.opensearch.action.support.PlainActionFuture;
                        );
        DiscoveryNode pNode = new DiscoveryNode(
        );
                        )
import static org.hamcrest.Matchers.equalTo;
        replica.prepareForIndexRecovery();
            Collections.emptySet(),
import org.opensearch.cluster.metadata.IndexMetadata;
            try (IndexInput in = sourceShard.store().directory().openInput(md.name(), IOContext.READONCE)) {
 */
