}
import org.opensearch.core.common.unit.ByteSizeValue;
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0);
        engine.close();
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.metadata.IndexMetadata;
        }
        int totalTranslogOps = 0;
/*
        ReplicationTracker tracker = (ReplicationTracker) engine.config().getGlobalCheckpointSupplier();
        long localCheckpoint = engine.getPersistedLocalCheckpoint();
        try (GatedCloseable<IndexCommit> wrappedCommit = noOpEngine.acquireLastIndexCommit(false)) {
                assertEquals(expectedDocStats.getCount(), noOpEngine.docStats().getCount());
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
                        String delId = Integer.toString(i);
    public void testTrimUnreferencedTranslogFiles() throws Exception {
import java.io.IOException;
    }
import org.opensearch.common.settings.Settings;
        tracker.updateFromClusterManager(1L, Collections.singleton(allocationId.getId()), table);
 */
import java.nio.file.Path;
        final ReplicationTracker tracker = (ReplicationTracker) engine.config().getGlobalCheckpointSupplier();
public class NoOpEngineTests extends EngineTestCase {
            try (InternalEngine engine = createEngine(config)) {
                        engine.translogManager().syncTranslog(); // advance persisted local checkpoint
 * this work for additional information regarding copyright
            if (rarely()) {
            EngineConfig config = config(indexSettings, store, translogPath, NoMergePolicy.INSTANCE, null, null, globalCheckpoint::get);
            }
            }
            }
 * GitHub history for details.
import org.opensearch.index.store.Store;
    public void testTwoNoopEngines() throws IOException {
                    noOpEngine.segmentsStats(includeFileSize, true).getFileSizes().size()
 * Unless required by applicable law or agreed to in writing,
        assertThat(engine.shouldPeriodicallyFlush(), equalTo(false));
 * Licensed to Elasticsearch under one or more contributor
                        deletions += 1;
                assertEquals(expectedDocStats.getDeleted(), noOpEngine.docStats().getDeleted());
            engine.index(indexForDoc(createParsedDoc(Integer.toString(i), null)));
        }
                        engine.flush();
                assertEquals(
            IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build()
import org.apache.lucene.index.IndexCommit;
        engine.onSettingsChanged(TimeValue.MINUS_ONE, ByteSizeValue.ZERO, randomNonNegativeLong());
        IndexShardRoutingTable table = new IndexShardRoutingTable.Builder(shardId).addShard(routing).build();
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
                expectedSegmentStats = engine.segmentsStats(includeFileSize, true);
        engine.flush(true, true);
                engine.flush();
                for (int i = 0; i < numDocs; i++) {
import org.opensearch.index.translog.Translog;
        assertThat(noOpEngine.translogManager().getTranslogStats().getUncommittedOperations(), equalTo(0));
        engine.close();
                engine.translogManager().rollTranslogGeneration();
import static org.hamcrest.Matchers.equalTo;
                }
        final NoOpEngine noOpEngine = new NoOpEngine(noOpConfig(INDEX_SETTINGS, store, primaryTranslogDir, tracker));
                    engine.index(indexForDoc(createParsedDoc(Integer.toString(i), null)));
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
            if (randomBoolean()) {
                // don't compare memory in bytes since we load the index with term-dict off-heap
                assertEquals(expectedDocStats.getAverageSizeInBytes(), noOpEngine.docStats().getAverageSizeInBytes());
import static org.hamcrest.Matchers.instanceOf;
import org.apache.lucene.index.DirectoryReader;
            true,
 * software distributed under the License is distributed on an
        IOUtils.close(engine, store);
            try (IndexReader reader = DirectoryReader.open(wrappedCommit.get())) {
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            allocationId
package org.opensearch.index.engine;
                engine.flush(true, true);
                }
            assertThat(e.getCause(), instanceOf(LockObtainFailedException.class));
        engine.close();
        final EngineConfig engineConfig = noOpConfig(INDEX_SETTINGS, store, primaryTranslogDir);
 * ownership. Elasticsearch licenses this file to you under
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            null,
            shardId.id(),
        long maxSeqNo = engine.getSeqNoStats(100L).getMaxSeqNo();
    }
            final int numDocs = scaledRandomIntBetween(10, 3000);
                assertEquals(expectedDocStats.getTotalSizeInBytes(), noOpEngine.docStats().getTotalSizeInBytes());
                assertEquals(expectedSegmentStats.getCount(), noOpEngine.segmentsStats(includeFileSize, true).getCount());
 * KIND, either express or implied.  See the License for the
/*
 * You may obtain a copy of the License at
                        assertTrue(result.isFound());
            true,
 *
            allocationId
import org.opensearch.index.shard.DocsStats;
            tracker.updateLocalCheckpoint(allocationId.getId(), i);
                totalTranslogOps = 0;
            null,
                    if (randomBoolean()) {
        }
import org.opensearch.cluster.routing.ShardRoutingState;
        IndexShardRoutingTable table = new IndexShardRoutingTable.Builder(shardId).addShard(routing).build();
            int deletions = 0;
                    }
import org.opensearch.index.seqno.SequenceNumbers;
 * The OpenSearch Contributors require contributions made to
        int docs = randomIntBetween(1, 10);
        engine.close();
/*
import org.opensearch.index.seqno.ReplicationTracker;
import java.util.concurrent.atomic.AtomicLong;
                    globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
            Path translogPath = createTempDir();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        );
                throw e;
        final int numDocs = scaledRandomIntBetween(10, 3000);
                    }
            equalTo((long) Translog.DEFAULT_HEADER_SIZE_IN_BYTES)
        for (int i = 0; i < docs; i++) {
    }
            shardId.id(),
        engine.ensureOpen();
    public void testNoOpEngineStats() throws Exception {
    public void testNoopAfterRegularEngine() throws IOException {
 * under the License.
import java.io.UncheckedIOException;
            final DocsStats expectedDocStats;
                    engine.translogManager().syncTranslog(); // advance persisted local checkpoint
                logger.error(config.getMergePolicy());
        ShardRouting routing = TestShardRouting.newShardRouting(
                expectedDocStats = engine.docStats();
                    if (rarely()) {
import org.opensearch.index.mapper.ParsedDocument;
 */
import java.util.Collections;
        assertThat(engine.refreshNeeded(), equalTo(false));
                    expectedSegmentStats.getFileSizes().size(),
        engine.flush(true, true);
        );
        tracker.updateFromClusterManager(1L, Collections.singleton(allocationId.getId()), table);
 *
        tracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
        ShardRouting routing = TestShardRouting.newShardRouting(
        noOpEngine.translogManager().trimUnreferencedTranslogFiles();
    }
        Settings.Builder settings = Settings.builder()
            totalTranslogOps++;
import org.opensearch.cluster.routing.TestShardRouting;
        // prevent translog from trimming so we can test trimUnreferencedFiles in NoOpEngine.
    }
        assertThat(noOpEngine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(totalTranslogOps));
            try (InternalEngine engine = createEngine(config)) {
        try (Store store = createStore()) {
        final Translog.Snapshot snapshot = assertAndGetInternalTranslogManager(engine.translogManager()).getTranslog().newSnapshot();
        snapshot.close();
        );
        engine.close();
            boolean includeFileSize = randomBoolean();
        assertThat(noOpEngine.getPersistedLocalCheckpoint(), equalTo(localCheckpoint));
        try (NoOpEngine ignored = new NoOpEngine(engineConfig)) {
    public void testNoopEngine() throws IOException {
        // Ensure that we can't open two noop engines for the same store
        }
import org.opensearch.index.IndexSettings;
        noOpEngine.close();
            ShardRoutingState.STARTED,
                for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.index.IndexReader;
                assertEquals(0, noOpEngine.segmentsStats(includeFileSize, false).getFileSizes().size());
            tracker.updateLocalCheckpoint(allocationId.getId(), i);
            try (NoOpEngine noOpEngine = new NoOpEngine(config)) {
            }
        assertThat(noOpEngine.getSeqNoStats(100L).getMaxSeqNo(), equalTo(maxSeqNo));
                engine.getLocalCheckpointTracker().waitForProcessedOpsToComplete(numDocs + deletions - 1);
            ParsedDocument doc = testParsedDocument("" + i, null, testDocumentWithTextField(), B_1, null);
            UncheckedIOException e = expectThrows(UncheckedIOException.class, () -> new NoOpEngine(engineConfig));
                        Engine.DeleteResult result = engine.delete(new Engine.Delete(delId, newUid(delId), primaryTerm.get()));
import org.opensearch.test.IndexSettingsModule;
        assertThat(noOpEngine.translogManager().getTranslogStats().estimatedNumberOfOperations(), equalTo(0));
            "node",
            final SegmentsStats expectedSegmentStats;
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.common.concurrent.GatedCloseable;
            "node",
import org.apache.lucene.index.NoMergePolicy;
 * compatible open source license.
import org.opensearch.common.unit.TimeValue;
        final NoOpEngine noOpEngine = new NoOpEngine(noOpConfig(INDEX_SETTINGS, store, primaryTranslogDir, tracker));
import org.opensearch.cluster.routing.ShardRouting;
            } catch (AssertionError e) {
            "test",
            "test",
            engine.index(indexForDoc(doc));
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
        assertThat(
import org.opensearch.common.util.io.IOUtils;
 * this file be licensed under the Apache-2.0 license or a
        tracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
                assertThat(reader.numDocs(), equalTo(docs));
            .put(defaultSettings.getSettings())
        final NoOpEngine engine = new NoOpEngine(noOpConfig(INDEX_SETTINGS, store, primaryTranslogDir));
import org.apache.lucene.store.LockObtainFailedException;
 * the Apache License, Version 2.0 (the "License"); you may
            }
            noOpEngine.translogManager().getTranslogStats().getTranslogSizeInBytes(),
 */
        );
        noOpEngine.close();
                        globalCheckpoint.set(engine.getPersistedLocalCheckpoint());
 *
            ShardRoutingState.STARTED,
                );
