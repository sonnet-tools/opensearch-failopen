            Version.CURRENT
                try {
        closeShards(replica);
            }
                    if (op.seqNo() <= globalCheckpoint) {
        } else {
 * KIND, either express or implied.  See the License for the
        );
        if (randomBoolean()) {
        );  
            "foo",
            indexMetadata = IndexMetadata.builder(shard.indexSettings().getIndexMetadata())
            replica.shardId(),  
 * under the License.  
            Version.CURRENT
    }  
        shard.prepareForIndexRecovery();
        recoveryTarget.cleanFiles(  
        Randomness.shuffle(seqNos);
                                throw new AssertionError(e);
            Version.CURRENT  
import org.opensearch.index.shard.IndexShardTestUtils;
        long globalCheckpoint = populateRandomData(shard).getGlobalCheckpoint();  
        }
import org.opensearch.core.common.bytes.BytesArray;
    public void testWriteFileChunksConcurrently() throws Exception {
                }
        assertThat(replica.recoveryState().getTranslog().recoveredOperations(), equalTo(expectedTotalLocal));  
            mdFiles.stream().map(StoreFileMetadata::name).collect(Collectors.toList()),  
                    pos += length;  
            assertThat(replica.recoveryState().getTranslog().totalLocal(), equalTo(0));  
        assertThat(shard.recoveryState().getTranslog().totalLocal(), equalTo(RecoveryState.Translog.UNKNOWN));
            logger,  
            });
        }  
        // copy with truncated translog
        int expectedTotalLocal = 0;
                        recoveryTarget.writeFileChunk(  
                    byte[] buffer = new byte[length];  
import org.opensearch.index.store.StoreFileMetadata;
        shard.prepareForIndexRecovery();  
        final IndexShard targetShard = newShard(false);
 *
                } catch (Exception e) {
                            r.content(),  
                            ActionListener.wrap(ignored -> {}, e -> {  
import org.opensearch.index.shard.IndexShardTestCase;
                1,  
import org.opensearch.index.translog.Translog;
        assertThat(replica.recoveryState().getTranslog().totalLocal(), equalTo(expectedTotalLocal));
        } else if (randomBoolean()) {  
        );
import static org.hamcrest.Matchers.equalTo;  
        IndexShard sourceShard = newStartedShard(true);  
import java.util.concurrent.CyclicBarrier;  
                            sourceShard.shardId(),  
            ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE)  
        DiscoveryNode pNode = new DiscoveryNode(
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
            senders[i] = new Thread(() -> {
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
            }
        RecoveryTarget recoveryTarget = new RecoveryTarget(shard, null, null, threadPool);
    public void testPrepareIndexForPeerRecovery() throws Exception {
            null
 * GitHub history for details.
                            0,
        IndexShard shard = newShard(false);  
                false,  
            mdFiles.add(md);  
                }
import org.opensearch.cluster.node.DiscoveryNode;
 *
                    }  
        assertThat(replica.getLastKnownGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
        if (randomBoolean()) {
        for (int i = 0; i < numDocs; i++) {
            randomNonNegativeLong()  
            Version.CURRENT
        } else {
        Optional<SequenceNumbers.CommitInfo> safeCommit = shard.store().findSafeIndexCommit(globalCheckpoint);
        globalCheckpoint = randomFrom(UNASSIGNED_SEQ_NO, seqNoStats.getMaxSeqNo());
        } else {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.action.ActionListener;  
                            r.totalTranslogOps(),
                .settings(Settings.builder().put(shard.indexSettings().getSettings()).put(IndexMetadata.SETTING_BLOCKS_WRITE, true))
                while (pos < md.length()) {
        StartRecoveryRequest request = PeerRecoveryTargetService.getStartRecoveryRequest(
        BlockingQueue<FileChunkRequest> queue = new ArrayBlockingQueue<>(requests.size());
            shard.applyIndexOperationOnReplica(  
}
        sourceShard.flush(new FlushRequest());
                    throw new AssertionError(e);  
        closeShards(shard);
        }  
        }
        replica.prepareForIndexRecovery();  
        replica.prepareForIndexRecovery();  
                            r.lastChunk(),
            shard,
            );  
            Collections.emptyMap(),
            mdFiles.stream().map(StoreFileMetadata::length).collect(Collectors.toList()),
    }
            assertThat(replica.recoveryState().getTranslog().totalLocal(), equalTo(RecoveryState.Translog.UNKNOWN));  
                            r.position(),
            indexMetadata,
 * ownership. Elasticsearch licenses this file to you under  
        replica = reinitShard(shard, ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE));
        );
        if (safeCommit.get().localCheckpoint < globalCheckpoint) {  
            senders[i].start();  
        CyclicBarrier barrier = new CyclicBarrier(senders.length);
        assertThat(shard.recoverLocallyAndFetchStartSeqNo(true), equalTo(UNASSIGNED_SEQ_NO));  
            Collections.emptyMap(),
            }
        Store.MetadataSnapshot sourceSnapshot = sourceShard.store().getMetadata();  
            Collections.emptySet(),  
                        );  
        );  
        List<StoreFileMetadata> mdFiles = new ArrayList<>();
    public void testClosedIndexSkipsLocalRecovery() throws Exception {  
import org.apache.lucene.store.IOContext;
import org.opensearch.common.UUIDs;  
        queue.addAll(requests);  
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.empty;
        final PlainActionFuture<Void> receiveFileInfoFuture = new PlainActionFuture<>();
                    );
                seqNoStats.getGlobalCheckpoint(),  
            indexDoc(sourceShard, "_doc", Integer.toString(i));  
            Collections.emptySet(),
        populateRandomData(shard);  
        shard.store().markStoreCorrupted(new IOException("simulated"));
                .state(IndexMetadata.State.CLOSE)
        assertThat(replica.recoverLocallyAndFetchStartSeqNo(true), equalTo(UNASSIGNED_SEQ_NO));
import org.opensearch.index.seqno.SequenceNumbers;
import org.apache.lucene.store.IndexInput;
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        safeCommit = replica.store().findSafeIndexCommit(globalCheckpoint);
import org.opensearch.common.settings.Settings;
        DiscoveryNode rNode = new DiscoveryNode(
        Randomness.shuffle(requests);
import org.opensearch.cluster.metadata.IndexMetadata;
 * The OpenSearch Contributors require contributions made to  
import java.util.stream.LongStream;
    }
        assertThat(replica.recoveryState().getTranslog().recoveredOperations(), equalTo(0));  
 * specific language governing permissions and limitations
        long startingSeqNo = shard.recoverLocallyAndFetchStartSeqNo(true);  
            Collections.emptySet(),
            rNode,
        int numDocs = between(20, 100);
        closeShards(replica);  
import java.util.List;
        assertTrue(safeCommit.isPresent());
                    while ((r = queue.poll()) != null) {
            Collections.emptyList(),  
            "foo",  
        // empty copy
                    FileChunkRequest r;
        );
            buildNewFakeTransportAddress(),
        shard.markAsRecovering("peer recovery", new RecoveryState(shard.routingEntry(), pNode, rNode));
                Translog.Operation op;
        PlainActionFuture<Void> cleanFilesFuture = new PlainActionFuture<>();
            receiveFileInfoFuture
import org.opensearch.index.engine.EngineConfigFactory;  
            assertThat(replica.recoverLocallyAndFetchStartSeqNo(true), equalTo(UNASSIGNED_SEQ_NO));
                        new FileChunkRequest(  
                .settings(shard.indexSettings().getSettings())  
        receiveFileInfoFuture.actionGet();
 *     http://www.apache.org/licenses/LICENSE-2.0
        return shard.seqNoStats();
import org.opensearch.common.util.io.IOUtils;
            shard.store().associateIndexWithNewTranslog(UUIDs.randomBase64UUID());
        shard.sync();
            buildNewFakeTransportAddress(),
        Store.RecoveryDiff diff = sourceSnapshot.recoveryDiff(targetSnapshot);  
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            Version.CURRENT
        DiscoveryNode pNode = new DiscoveryNode(
                    in.readBytes(buffer, 0, length);
 * software distributed under the License is distributed on an
        shard = newStartedShard(false);
 * license agreements. See the NOTICE file distributed with
            replica.shardPath().resolveTranslog(),
        assertThat(request.startingSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
        StartRecoveryRequest request = PeerRecoveryTargetService.getStartRecoveryRequest(logger, rNode, recoveryTarget, startingSeqNo);  
        Thread[] senders = new Thread[between(1, 4)];
            Collections.emptyList(),
            new EngineBackedIndexerFactory(NoOpEngine::new),  
        // corrupted copy
        long globalCheckpoint = populateRandomData(shard).getGlobalCheckpoint();
import org.opensearch.index.mapper.SourceToParse;  
 * You may obtain a copy of the License at  
        );
            shard,  
import org.opensearch.index.store.Store;  
            indexMetadata = IndexMetadata.builder(shard.indexSettings().getIndexMetadata())
        final IndexMetadata indexMetadata;  
                UUID.randomUUID().toString(),
                .build();
            buildNewFakeTransportAddress(),
            cleanFilesFuture
        for (StoreFileMetadata md : sourceSnapshot) {
        Store.MetadataSnapshot targetSnapshot = targetShard.snapshotStoreMetadata();
        shard.updateGlobalCheckpointOnReplica(globalCheckpoint, "test");  
        assertThat(shard.recoveryState().getTranslog().recoveredOperations(), equalTo(0));
        IndexShard shard = newStartedShard(false);
                shard.getOperationPrimaryTerm()
            populateRandomData(shard);
        shard = newStartedShard(false);
        assertThat(replica.getLastKnownGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
import org.opensearch.index.seqno.SeqNoStats;
import java.util.concurrent.ArrayBlockingQueue;
        if (randomBoolean()) {  
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
                shard.getOperationPrimaryTerm(),
                    }
import java.util.stream.Collectors;
        shard = newStartedShard(false);
        closeShards(shard);
 * Licensed to Elasticsearch under one or more contributor  
        replica.store().associateIndexWithNewTranslog(translogUUID);  
        assertThat(request.metadataSnapshot().size(), equalTo(0));
 * this work for additional information regarding copyright
/*  
/*
            );
            Collections.emptyMap(),
import java.util.UUID;  
 * compatible open source license.
                new SourceToParse(shard.shardId().getIndexName(), UUIDs.randomBase64UUID(), new BytesArray("{}"), MediaTypeRegistry.JSON)
import java.util.Collections;  
        shard.markAsRecovering("peer recovery", new RecoveryState(shard.routingEntry(), pNode, rNode));
        shard.markAsRecovering("for testing", new RecoveryState(shard.routingEntry(), localNode, localNode));
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
                shard.flush(new FlushRequest().waitIfOngoing(true));
            0,
        assertThat(request.metadataSnapshot(), sameInstance(Store.MetadataSnapshot.EMPTY));  
import org.opensearch.action.index.IndexRequest;
            Translog.createEmptyTranslog(
        assertThat(replica.recoveryState().getTranslog().recoveredOperations(), equalTo(0));  
public class PeerRecoveryTargetServiceTests extends IndexShardTestCase {  
        }
            "foo",
        assertThat(replica.recoveryState().getStage(), equalTo(RecoveryState.Stage.TRANSLOG));
        assertThat(diff.different, empty());
            Collections.emptyMap(),  
        }
            recoveryTarget,
        replica.prepareForIndexRecovery();  
            Collections.emptyMap(),  
        long seqNo = 0;  
        closeShards(shard);
        IndexShard replica = reinitShard(
        cleanFilesFuture.actionGet();  
        Optional<SequenceNumbers.CommitInfo> safeCommit = shard.store().findSafeIndexCommit(globalCheckpoint);  
        );
        assertThat(replica.getLastKnownGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
            "foo",
        assertThat(replica.recoverLocallyAndFetchStartSeqNo(true), equalTo(safeCommit.get().localCheckpoint + 1));  
        assertThat(replica.recoveryState().getTranslog().totalLocal(), equalTo(0));
            "foo",  
import org.opensearch.Version;  
            Version.CURRENT  
        recoveryTarget.decRef();  
        assertThat(shard.getLastKnownGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));  
            replica.getPendingPrimaryTerm()
                shard.shardPath().resolveTranslog(),
    }  
        assertThat(replica.recoveryState().getTranslog().recoveredOperations(), equalTo(0));
        replica.prepareForIndexRecovery();
import org.opensearch.cluster.routing.RecoverySource;  
        shard.close("test", false, false);  
        shard.store().markStoreCorrupted(new IOException("test"));  
        recoveryTarget.receiveFileInfo(
        for (long seqNo : seqNos) {
import static org.hamcrest.Matchers.sameInstance;
        recoveryTarget.decRef();
            "foo",
import java.io.IOException;
                    int length = between(1, Math.toIntExact(md.length() - pos));
        closeShards(sourceShard, targetShard);
        String translogUUID = Translog.createEmptyTranslog(  
/*  
        assertThat(replica.recoveryState().getTranslog().totalLocal(), equalTo(RecoveryState.Translog.UNKNOWN));
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
        List<FileChunkRequest> requests = new ArrayList<>();
                int pos = 0;  
                            pos,
    public void testResetStartingSeqNoIfLastCommitCorrupted() throws Exception {
                    requests.add(
import org.opensearch.action.admin.indices.flush.FlushRequest;
        IndexShard shard = newStartedShard(false);
 */
        assertThat(request.startingSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
        );  
        }  
                }
            assertThat(replica.recoverLocallyAndFetchStartSeqNo(true), equalTo(safeCommit.get().localCheckpoint + 1));
        shard.prepareForIndexRecovery();
        targetShard.markAsRecovering("test-peer-recovery", new RecoveryState(targetShard.routingEntry(), rNode, pNode));
                            seqNo++,
        );
                    barrier.await();  
 *  
            sourceSnapshot,  
        if (safeCommit.isPresent()) {
        IndexShard replica = reinitShard(
import org.opensearch.action.support.PlainActionFuture;  
        RecoveryTarget recoveryTarget = new RecoveryTarget(shard, null, null, threadPool);
                            pos + length == md.length(),
 * Modifications Copyright OpenSearch Contributors. See
        }
        shard = reinitShard(shard, ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE));  
            try (Translog.Snapshot snapshot = getTranslog(shard).newSnapshot(safeCommit.get().localCheckpoint + 1, globalCheckpoint)) {
                while ((op = snapshot.next()) != null) {  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
                        expectedTotalLocal++;
        SeqNoStats seqNoStats = populateRandomData(shard);  
        }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.Randomness;
                shard.shardId(),
        for (StoreFileMetadata md : mdFiles) {
                seqNo,
            if (randomInt(100) < 5) {  
import java.util.Optional;
            Collections.emptySet(),
        shard = reinitShard(shard, ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE));
        final DiscoveryNode rNode = IndexShardTestUtils.getFakeDiscoNode(targetShard.routingEntry().currentNodeId());
import java.util.ArrayList;
            sender.join();  
            buildNewFakeTransportAddress(),  
                        )
            0,
                            1  
        replica = reinitShard(shard, ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE));
import org.opensearch.index.engine.NoOpEngine;
 * the Apache License, Version 2.0 (the "License"); you may
            new EngineConfigFactory(shard.indexSettings()),
        );
 */  
            globalCheckpoint,
        final RecoveryTarget recoveryTarget = new RecoveryTarget(targetShard, null, null, threadPool);  
    public void testResetStartRequestIfTranslogIsCorrupted() throws Exception {
        assertThat(replica.recoverLocallyAndFetchStartSeqNo(true), equalTo(globalCheckpoint + 1));
            IOUtils.rm(shard.shardPath().resolveTranslog());
        final SeqNoStats seqNoStats = populateRandomData(shard);
        assertTrue(safeCommit.isPresent());
        final DiscoveryNode pNode = IndexShardTestUtils.getFakeDiscoNode(sourceShard.routingEntry().currentNodeId());  
        closeShards(replica);
                            })
        // good copy  
            buildNewFakeTransportAddress(),  
            Collections.emptySet(),
 */  
import org.opensearch.index.shard.IndexShard;  
                            r.metadata(),
                            md,
        DiscoveryNode rNode = new DiscoveryNode(  
                .build();  
    }
    }  
        );  
        IndexShard shard = newStartedShard(false);
                            1,
        for (Thread sender : senders) {
import java.util.concurrent.BlockingQueue;
        closeShards(replica);
        }  
        recoveryTarget.decRef();
        DiscoveryNode localNode = new DiscoveryNode(  
        assertThat(replica.getLastKnownGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));  
        List<Long> seqNos = LongStream.range(0, 100).boxed().collect(Collectors.toList());  
            try (IndexInput in = sourceShard.store().directory().openInput(md.name(), IOContext.READONCE)) {
import org.opensearch.cluster.routing.ShardRoutingHelper;
        long globalCheckpoint = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, shard.getLocalCheckpoint());
        shard.sync();
package org.opensearch.indices.recovery;
            buildNewFakeTransportAddress(),
        assertThat(replica.recoveryState().getStage(), equalTo(RecoveryState.Stage.TRANSLOG));
            Collections.emptyMap(),
        DiscoveryNode localNode = new DiscoveryNode(
                            new BytesArray(buffer),  
            Long.parseLong(sourceSnapshot.getCommitUserData().get(SequenceNumbers.MAX_SEQ_NO)),
            Collections.emptySet(),  
    private SeqNoStats populateRandomData(IndexShard shard) throws IOException {
        for (int i = 0; i < senders.length; i++) {  
        }
            ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.PeerRecoverySource.INSTANCE),
