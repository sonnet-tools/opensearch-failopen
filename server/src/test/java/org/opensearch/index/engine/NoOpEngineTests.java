        assertThat(noOpEngine.getSeqNoStats(100L).getMaxSeqNo(), equalTo(maxSeqNo));  
        engine.close();  
            shardId.id(),
                    }  
            }  
public class NoOpEngineTests extends EngineTestCase {
                assertEquals(expectedDocStats.getTotalSizeInBytes(), noOpEngine.docStats().getTotalSizeInBytes());
                for (int i = 0; i < numDocs; i++) {
                    expectedSegmentStats.getFileSizes().size(),
 * this work for additional information regarding copyright
        assertThat(noOpEngine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(0));  
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
            noOpEngine.translogManager().getTranslogStats().getTranslogSizeInBytes(),  
                logger.error(config.getMergePolicy());
                assertEquals(expectedDocStats.getCount(), noOpEngine.docStats().getCount());  
        );
 * Unless required by applicable law or agreed to in writing,
        tracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
                    if (randomBoolean()) {
            }
            ShardRoutingState.STARTED,
            null,
                }
        engine.ensureOpen();
            engine.index(indexForDoc(createParsedDoc(Integer.toString(i), null)));
        engine.flush(true, true);  
                expectedDocStats = engine.docStats();
        }
        for (int i = 0; i < numDocs; i++) {  
        final ReplicationTracker tracker = (ReplicationTracker) engine.config().getGlobalCheckpointSupplier();
 * software distributed under the License is distributed on an
}  
        try (NoOpEngine ignored = new NoOpEngine(engineConfig)) {
                        globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        engine.close();
    public void testNoopEngine() throws IOException {
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0);
import org.opensearch.index.seqno.ReplicationTracker;  
package org.opensearch.index.engine;
        try (Store store = createStore()) {
            engine.index(indexForDoc(doc));  
 */
import org.opensearch.index.shard.DocsStats;
import org.opensearch.test.IndexSettingsModule;
            shardId.id(),  
 * GitHub history for details.
import org.opensearch.cluster.metadata.IndexMetadata;  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.concurrent.atomic.AtomicLong;
        }
            EngineConfig config = config(indexSettings, store, translogPath, NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get);  
                throw e;
            }  
 * SPDX-License-Identifier: Apache-2.0
            final int numDocs = scaledRandomIntBetween(10, 3000);
            "node",
    }
        final NoOpEngine engine = new NoOpEngine(noOpConfig(INDEX_SETTINGS, store, primaryTranslogDir));  
                        String delId = Integer.toString(i);  
            ParsedDocument doc = testParsedDocument("" + i, null, testDocumentWithTextField(), B_1, null);
                    engine.index(indexForDoc(createParsedDoc(Integer.toString(i), null)));
                assertEquals(expectedDocStats.getDeleted(), noOpEngine.docStats().getDeleted());
            tracker.updateLocalCheckpoint(allocationId.getId(), i);  
                        Engine.DeleteResult result = engine.delete(new Engine.Delete(delId, newUid(delId), primaryTerm.get()));
 * license agreements. See the NOTICE file distributed with
            true,
            .put(defaultSettings.getSettings())  
                        assertTrue(result.isFound());
                assertEquals(expectedDocStats.getAverageSizeInBytes(), noOpEngine.docStats().getAverageSizeInBytes());  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import java.nio.file.Path;  
            "node",  
        assertThat(engine.refreshNeeded(), equalTo(false));
                assertEquals(0, noOpEngine.segmentsStats(includeFileSize, false).getFileSizes().size());
import java.util.Collections;
            ShardRoutingState.STARTED,  
 * KIND, either express or implied.  See the License for the
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
import org.opensearch.index.IndexSettings;
    }
import org.opensearch.core.common.unit.ByteSizeValue;  
                assertEquals(expectedSegmentStats.getCount(), noOpEngine.segmentsStats(includeFileSize, true).getCount());
    public void testTwoNoopEngines() throws IOException {  
        tracker.updateFromClusterManager(1L, Collections.singleton(allocationId.getId()), table);
import org.apache.lucene.index.NoMergePolicy;
import org.apache.lucene.store.LockObtainFailedException;
        // prevent translog from trimming so we can test trimUnreferencedFiles in NoOpEngine.  
 *
                totalTranslogOps = 0;
            equalTo((long) Translog.DEFAULT_HEADER_SIZE_IN_BYTES)
    }
 */  
            "test",
        );
        );
        Settings.Builder settings = Settings.builder()
/*  
            }
 * You may obtain a copy of the License at  
        ShardRouting routing = TestShardRouting.newShardRouting(  
        assertThat(noOpEngine.getPersistedLocalCheckpoint(), equalTo(localCheckpoint));
import org.opensearch.cluster.routing.TestShardRouting;
            IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build()  
                assertEquals(  
            allocationId
    public void testNoopAfterRegularEngine() throws IOException {
import org.opensearch.index.seqno.SequenceNumbers;
                for (int i = 0; i < numDocs; i++) {
        int totalTranslogOps = 0;
    public void testTrimUnreferencedTranslogFiles() throws Exception {
            }
                        deletions += 1;
 * ownership. Elasticsearch licenses this file to you under  
            UncheckedIOException e = expectThrows(UncheckedIOException.class, () -> new NoOpEngine(engineConfig));
                engine.getLocalCheckpointTracker().waitForProcessedOpsToComplete(numDocs + deletions - 1);
        final Translog.Snapshot snapshot = assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().newSnapshot();
        final NoOpEngine noOpEngine = new NoOpEngine(noOpConfig(INDEX_SETTINGS, store, primaryTranslogDir, tracker));  
/*
        engine.close();
import static org.hamcrest.Matchers.equalTo;
            try (InternalEngine engine = createEngine(config)) {  
import org.opensearch.index.store.Store;  
        noOpEngine.translogManager().trimUnreferencedTranslogFiles();
                    engine.translogManager().syncTranslog(); // advance persisted local checkpoint  
        engine.flush(true, true);
                        engine.translogManager().syncTranslog(); // advance persisted local checkpoint  
            if (randomBoolean()) {
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.ShardRoutingState;  
        engine.onSettingsChanged(TimeValue.MINUS_ONE, ByteSizeValue.ZERO, randomNonNegativeLong());  
        snapshot.close();  
        tracker.updateFromClusterManager(1L, Collections.singleton(allocationId.getId()), table);
        final NoOpEngine noOpEngine = new NoOpEngine(noOpConfig(INDEX_SETTINGS, store, primaryTranslogDir, tracker));
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );  
 *
            Path translogPath = createTempDir();
            try (IndexReader reader = DirectoryReader.open(wrappedCommit.get())) {
 * not use this file except in compliance with the License.
        final int numDocs = scaledRandomIntBetween(10, 3000);
                    }
        assertThat(engine.shouldPeriodicallyFlush(), equalTo(false));
                assertThat(reader.numDocs(), equalTo(docs));  
            tracker.updateLocalCheckpoint(allocationId.getId(), i);
            assertThat(e.getCause(), instanceOf(LockObtainFailedException.class));  
    public void testNoOpEngineStats() throws Exception {  
import static org.hamcrest.Matchers.instanceOf;
        }
            null,
        assertThat(noOpEngine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(0));
        assertThat(
            true,  
import org.opensearch.index.translog.Translog;
            } catch (AssertionError e) {  
        for (int i = 0; i < docs; i++) {
        IndexShardRoutingTable table = new IndexShardRoutingTable.Builder(shardId).addShard(routing).build();  
 */  
        final EngineConfig engineConfig = noOpConfig(INDEX_SETTINGS, store, primaryTranslogDir);  
            final SegmentsStats expectedSegmentStats;
                    globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
import org.opensearch.common.concurrent.GatedCloseable;
import org.opensearch.common.settings.Settings;  
        engine.close();
        ShardRouting routing = TestShardRouting.newShardRouting(
                engine.flush(true, true);  
            final DocsStats expectedDocStats;  
            try (NoOpEngine noOpEngine = new NoOpEngine(config)) {
        noOpEngine.close();
        IOUtils.close(engine, store);
        }
        // Ensure that we can't open two noop engines for the same store
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
        }
 * under the License.  
        IndexShardRoutingTable table = new IndexShardRoutingTable.Builder(shardId).addShard(routing).build();
        engine.close();
            totalTranslogOps++;
    }
            "test",
            allocationId
import org.opensearch.index.mapper.ParsedDocument;
 * specific language governing permissions and limitations
import java.io.UncheckedIOException;
        int docs = randomIntBetween(1, 10);
                expectedSegmentStats = engine.segmentsStats(includeFileSize, true);
            }
import org.apache.lucene.index.DirectoryReader;
                engine.flush();  
                // don't compare memory in bytes since we load the index with term-dict off-heap
        long maxSeqNo = engine.getSeqNoStats(100L).getMaxSeqNo();
        ReplicationTracker tracker = (ReplicationTracker) engine.config().getGlobalCheckpointSupplier();  
        );  
 * this file be licensed under the Apache-2.0 license or a
        tracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);  
            int deletions = 0;
import org.opensearch.common.unit.TimeValue;
/*  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.IndexCommit;
import org.opensearch.common.util.io.IOUtils;
 *     http://www.apache.org/licenses/LICENSE-2.0
        noOpEngine.close();  
        assertThat(noOpEngine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(totalTranslogOps));
                }
    }
                engine.translogManager().rollTranslogGeneration();  
        long localCheckpoint = engine.getPersistedLocalCheckpoint();  
                    noOpEngine.segmentsStats(includeFileSize, true).getFileSizes().size()
            if (rarely()) {
                    if (rarely()) {  
import org.apache.lucene.index.IndexReader;  
            boolean includeFileSize = randomBoolean();
        try (GatedCloseable<IndexCommit> wrappedCommit = noOpEngine.acquireLastIndexCommit(false)) {
                        engine.flush();
import java.io.IOException;
            try (InternalEngine engine = createEngine(config)) {  
 * the Apache License, Version 2.0 (the "License"); you may
