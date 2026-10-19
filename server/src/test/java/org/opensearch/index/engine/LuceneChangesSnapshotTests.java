        final int numOps = batchSize * between(3, 10);
                    error.getMessage(),
    }
            ) {
        // Verify toString includes routing
        }
                }
        );
                if (randomBoolean()) {
    }
                IOUtils.close(searcher);
            try (
        thread.start();
                        public CacheHelper getReaderCacheHelper() {
        }
                IOUtils.close(searcher);
                searcher = null;
        private final InternalEngine leader;
import org.opensearch.common.settings.Settings;
                List<DocIdSeqNoAndSource> docsWithoutSourceOnFollower = getDocIds(engine, true).stream()
        } finally {
                    searcher,
 *
        CountingSequentialDirectoryReader(DirectoryReader in, AtomicInteger acquisitions, AtomicInteger documentsRead) throws IOException {
                    between(1, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE),
    public void testSkipNonRootOfNestedDocuments() throws Exception {
            this.delegate = delegate;
                IndexSettingsModule.newIndexSettings(shardId.getIndexName(), leader.engineConfig.getIndexSettings().getSettings()),
            assertOpsMatch(drainAll(snapshot), expectedDocs);
            }
    }
            return new CountingSequentialDirectoryReader(in, acquisitions, documentsRead);
        final AtomicInteger documentsRead = new AtomicInteger();
import static org.hamcrest.Matchers.equalTo;
            if (followerCheckpoint < leaderCheckpoint) {
        }
            follower.join();
    }
                            return reader.getReaderCacheHelper();
    }
            ParsedDocument doc = createParsedDoc(id, null, randomBoolean());
    }
        public CacheHelper getReaderCacheHelper() {
            expectedDocs.put(seqNo, doc);
import org.opensearch.index.seqno.SequenceNumbers;
            Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
            final Engine.Operation op;
                    .map(d -> new DocIdSeqNoAndSource(d.getId(), null, d.getSeqNo(), d.getPrimaryTerm(), d.getVersion()))
        concurrentlyApplyOps(operations, engine);
 * Unless required by applicable law or agreed to in writing,
            reader,
        }
                    toSeqNo,
            IllegalStateException error = expectThrows(IllegalStateException.class, () -> drainAll(snapshot));
        private final StoredFieldsReader delegate;
            IllegalStateException error = expectThrows(IllegalStateException.class, () -> drainAll(snapshot));
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", fromSeqNo, toSeqNo, false, randomBoolean())) {
                // have to verify without source since we are randomly testing without _source
            routingValue
                long batchSize = randomLongBetween(0, 100);
                assertThat(documentsRead.get(), equalTo(numOps));
        }
            final ParsedDocument expected = expectedDocs.get(op.seqNo());
            if (randomBoolean()) {
                engine
            throw failure.get();
                }
        Translog.Operation op;
        final AtomicReference<T> result = new AtomicReference<>();
                assertTrue("contiguous docIDs must use the sequential reader", snapshot.useSequentialStoredFieldsReader());
        final DirectoryReader reader = new CountingSequentialDirectoryReader(searcher.getDirectoryReader(), acquisitions, documentsRead);
    public void testSequentialStoredFieldsReaderIsReacquiredOnThreadChange() throws Exception {
        for (Follower follower : followers) {
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", fromSeqNo, toSeqNo, true, randomBoolean())) {
                containsString("Not all operations between from_seqno [" + fromSeqNo + "] and to_seqno [" + toSeqNo + "] found")
                    || engine.getLocalCheckpointTracker().getProcessedCheckpoint() < leader.getLocalCheckpointTracker()
     */
            this.translogHandler = new TranslogHandler(
                Translog.Snapshot snapshot = new LuceneChangesSnapshot(
                result.set(supplier.get());
        assertThat(deleteWithRouting.routing(), equalTo(routingValue));
                    .collect(Collectors.toList());
            final Engine.IndexResult result = engine.index(indexForDoc(doc));
            }
        }
                )
        final Thread thread = new Thread(() -> {
            );
                    searcher,
/*
                    return new SequentialStoredFieldsLeafReader(reader) {
        if (refreshedSeqNo == -1) {
            try (LuceneChangesSnapshot snapshot = new LuceneChangesSnapshot(countingSearcher, batchSize, 0, numOps - 1, true, true)) {
 * the Apache License, Version 2.0 (the "License"); you may
            }
        final String routingValue = "tenant-abc";
 * Modifications Copyright OpenSearch Contributors. See
                    searcher,
 * ownership. Elasticsearch licenses this file to you under
    /**
     * Wraps every leaf in a pass-through {@link SequentialStoredFieldsLeafReader} that counts how many times its
        }
                            acquisitions.incrementAndGet();
            String id = Integer.toString(randomIntBetween(1, 10));
            final long seqNo = numOps - 1 - i;
        assertThat(deleteWithRouting.id(), equalTo("doc-1"));
                    between(1, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE),
        }
     * Verifies that routing values round-trip correctly through Translog.Delete serialization.
                while (isDone.get() == false
        );
        }
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
        for (int i = 0; i < numOps; i++) {
            assertThat(index.source(), equalTo(expected.source()));
            }
    }
                    randomBoolean()
import org.opensearch.common.CheckedSupplier;
        }
 * SPDX-License-Identifier: Apache-2.0
        }
        private final TranslogHandler translogHandler;
        // Delete WITHOUT routing (backward compatibility)
     */
                    searcher,
/*
            if (rarely()) {
        Translog.Delete deleteWithRouting = new Translog.Delete("doc-1", 1, 1, 1, routingValue);
            try {
    @Before
                    fromSeqNo,
        for (Translog.Operation op : ops) {
        try {
    private Map<Long, ParsedDocument> indexAppendOnly(int numOps) throws IOException {
            }
    protected Settings indexSettings() {
                readLatch.countDown();
            }
                    op = new Engine.Index(newUid(doc), primaryTerm.get(), doc);
        thread.join();
            searcher
            newUid("doc-2"),
        final Map<Long, ParsedDocument> expectedDocs = new HashMap<>();
            IOUtils.close(searcher);
    private void assertOpsMatch(List<Translog.Operation> ops, Map<Long, ParsedDocument> expectedDocs) {
            operations.add(op);
            this.leader = leader;
                engine.refresh("test");
            assert operations.stream().allMatch(o -> o.seqNo() < newOp.seqNo()) : "Operations [" + operations + "], op [" + op + "]";
                IOUtils.close(searcher);
                assertThat(
            delegate.document(docID, visitor);
 * Licensed to Elasticsearch under one or more contributor
        mapperService = createMapperService();
        Translog.Delete deleteNoRouting = new Translog.Delete("doc-3", 2, 1, 1);
        for (Engine.Operation op : operations) {
    private static Engine.Searcher countingSearcher(Engine.Searcher searcher, AtomicInteger acquisitions, AtomicInteger documentsRead)
        readyLatch.await();
                assertOpsMatch(ops, expectedDocs);
                    between(1, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE),
        Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
    }
                engine.translogManager().rollTranslogGeneration();
        for (int i = 0; i < numOps; i++) {
    private static <T> T callOnNewThread(CheckedSupplier<T, Exception> supplier) throws Exception {
import java.util.stream.Collectors;
                assertThat(snapshot.totalOperations(), equalTo(seqNoToTerm.size()));
                Translog.Snapshot snapshot = new LuceneChangesSnapshot(
            }
                long toSeqNo = Math.min(fromSeqNo + batchSize, leaderCheckpoint);
                throw new AssertionError(ex);
        void pullOperations(InternalEngine follower) throws IOException {
            try (
            IOUtils.close(searcher);
                searcher = null; // closed by the snapshot through the counting searcher
                error.getMessage(),
    }
            ) {
            } finally {
            } catch (Exception ex) {
                final List<Translog.Operation> ops = new ArrayList<>();
        long maxSeqNo = engine.getLocalCheckpointTracker().getMaxSeqNo();
        fromSeqNo = randomLongBetween(0, numOps - 1);
import org.opensearch.test.IndexSettingsModule;
import java.util.concurrent.atomic.AtomicReference;
        return expectedDocs;
            System.nanoTime(),
                            return reader.getCoreCacheHelper();
import org.apache.lucene.index.FilterDirectoryReader;
import java.io.IOException;
        public void checkIntegrity() throws IOException {
                refreshedSeqNo = i;
            VersionType.INTERNAL,
        try (Translog.Snapshot snapshot = new LuceneChangesSnapshot(searcher, between(1, 100), 0, maxSeqNo, false, accurateCount)) {
            }
    /**
        final Map<Long, ParsedDocument> expectedDocs = indexAppendOnly(numOps);
                    op = callOnNewThread(snapshot::next);
 * compatible open source license.
                assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
            });
            }
        private final AtomicBoolean isDone;
                if (randomBoolean()) {
            logger.error("Reading [{}]", op);
                List<DocIdSeqNoAndSource> docsWithoutSourceOnLeader = getDocIds(leader, true).stream()
        public void close() throws IOException {
    }
        final int numOps = 2 * between(LuceneChangesSnapshot.MIN_SEQUENTIAL_ACCESS_BATCH_SIZE, 50);
            }
 *
                    .map(d -> new DocIdSeqNoAndSource(d.getId(), null, d.getSeqNo(), d.getPrimaryTerm(), d.getVersion()))
            }
            ) {
        for (int step = 0; step < 2; step++) {
                        .getProcessedCheckpoint()) {
        int refreshedSeqNo = -1;
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
        }
        final Map<Long, ParsedDocument> expectedDocs = new HashMap<>();
        }
        public void document(int docID, StoredFieldVisitor visitor) throws IOException {
        Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
                    randomBoolean()
                failure.set(e);
                try (Translog.Snapshot snapshot = leader.newChangesSnapshot("test", fromSeqNo, toSeqNo, true, randomBoolean())) {
                assertThat(
            final Translog.Index index = (Translog.Index) op;
                    containsString("Not all operations between from_seqno [" + fromSeqNo + "] and to_seqno [" + toSeqNo + "] found")
            delegate.checkIntegrity();
        final AtomicInteger acquisitions = new AtomicInteger();
                    toSeqNo,
    public void testDeleteRoutingSerialization() throws Exception {
                assertThat(docsWithoutSourceOnFollower, equalTo(docsWithoutSourceOnLeader));
            searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
        Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
        }
                    between(1, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE),
    public void testOverFlow() throws Exception {
        Engine.Delete engineDelete = new Engine.Delete(
    public void testUpdateAndReadChangesConcurrently() throws Exception {
    private List<Translog.Operation> drainAll(Translog.Snapshot snapshot) throws IOException {
            // the flag is computed for the first batch by the constructor; a single batch holds every op here
            toSeqNo = randomLongBetween(fromSeqNo, numOps * 2);
            IOUtils.close(follower.engine, follower.engine.store);
 * specific language governing permissions and limitations
            searcher = null;
                    fromSeqNo,
            } else {
import java.util.HashMap;
     * sequential stored fields reader is acquired, and how many documents that reader serves.
 * under the License.
                    };
        }
        } else {
                    op = replicaIndexForDoc(doc, randomNonNegativeLong(), i, randomBoolean());
                searcher = null; // closed by the snapshot through the counting searcher
import org.opensearch.index.mapper.MapperService;
            followers[i] = new Follower(engine, isDone, readyLatch);
                        }
        assertThat("Engine.Delete should carry routing", engineDelete.routing(), equalTo(routingValue));
import org.opensearch.common.util.io.IOUtils;
import static org.hamcrest.Matchers.not;
            if (accurateCount == true) {
import java.util.concurrent.CountDownLatch;
 */
                    between(1, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE),
                xContentRegistry(),
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.IndexSettings;
                    toSeqNo,
        AtomicBoolean isDone = new AtomicBoolean();
                    true,
            final Engine.Searcher countingSearcher = countingSearcher(searcher, acquisitions, documentsRead);
        return result.get();
            .build();
        }
        private final AtomicInteger acquisitions;
 */
                assertThat(op.toString(), op.primaryTerm(), equalTo(seqNoToTerm.get(op.seqNo())));
            primaryTerm.get(),
        }
        toSeqNo = randomLongBetween(fromSeqNo, numOps - 1);
                @Override
                    op = replicaDeleteForDoc(doc.id(), randomNonNegativeLong(), i, randomNonNegativeLong());
        CountDownLatch readyLatch = new CountDownLatch(followers.length + 1);
                error.getMessage(),
            }
import org.opensearch.index.translog.Translog;
    public void testInterleavedSeqNosAcrossSegmentsUseDefaultStoredFieldsReader() throws Exception {
            Engine.Operation.Origin.PRIMARY,
        readyLatch.countDown();
        }
import org.junit.Before;
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true) // always enable soft-deletes
            return in.getReaderCacheHelper();
        CountingStoredFieldsReader(StoredFieldsReader delegate, AtomicInteger documentsRead) {
        throws IOException {
     */
        @Override
                        @Override
        engine.refresh("test");
                IllegalStateException error = expectThrows(IllegalStateException.class, () -> drainAll(snapshot));
        List<Engine.Operation> operations = new ArrayList<>();
                    searcher,
                    toSeqNo,
    /**
                        @Override
import static org.hamcrest.Matchers.containsString;
            if (onPrimary) {
                searcher = null;
            fromSeqNo = randomLongBetween(0, refreshedSeqNo);
                } else {
            // a batch size well below the op count forces multiple batches, exercising reader reuse across them
                assertThat(snapshot, SnapshotMatchers.containsSeqNoRange(fromSeqNo, refreshedSeqNo));
        });
        assertThat(deleteNoRouting.toString(), not(containsString("routing=")));
                assertThat(snapshot, SnapshotMatchers.size(0));
        Follower[] followers = new Follower[between(1, 3)];
        @Override
import java.util.concurrent.atomic.AtomicBoolean;
            operations.add(newOp);
        engine.refresh("test");
        assertThat(deleteWithRouting.toString(), containsString("routing=" + routingValue));
                assertTrue(snapshot.useSequentialStoredFieldsReader());
            1L,
            assertThat(snapshot.totalOperations(), equalTo(numOps));
public class LuceneChangesSnapshotTests extends EngineTestCase {
        return Settings.builder()
        for (int i = 0; i < followers.length; i++) {
                } else {
            try {
                searcher = null;
            assertThat(
        // Empty engine
            }
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", fromSeqNo, toSeqNo, randomBoolean(), randomBoolean())) {
     * non-root documents don't have primary term but only sequence numbers. This test verifies that {@link LuceneChangesSnapshot}
        @Override
                    engine.refresh("test");
        while ((op = snapshot.next()) != null) {
            documentsRead.incrementAndGet();
import java.util.List;
        Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
                    randomBoolean()
            }
    public void testBasics() throws Exception {
            }
                    op = new Engine.Delete(doc.id(), newUid(doc.id()), primaryTerm.get());
    private static final class CountingSequentialDirectoryReader extends FilterDirectoryReader {
    class Follower extends Thread {
        assertThat(ops, hasSize(expectedDocs.size()));
        @Override
    public void testOutOfOrderSeqNoUsesDefaultStoredFieldsReader() throws Exception {
            }
    public void testContiguousReadsReuseSequentialStoredFieldsReader() throws Exception {
                    false,
        try (LuceneChangesSnapshot snapshot = new LuceneChangesSnapshot(searcher, numOps, 0, numOps - 1, true, true)) {
                        }
            assertThat(snapshot, SnapshotMatchers.containsSeqNoRange(fromSeqNo, toSeqNo));
import java.util.Map;
            searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
        int numOps = scaledRandomIntBetween(1, 1000);
    }
     * Wraps the searcher's reader so that every leaf sits behind a counting {@link SequentialStoredFieldsLeafReader}.
            Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
                } else {
                    pullOperations(engine);
            this.documentsRead = documentsRead;
     * The returned searcher takes ownership of {@code searcher}.
        engine.refresh("test");
                assertThat(snapshot, SnapshotMatchers.containsSeqNoRange(fromSeqNo, toSeqNo));
            searcher.getQueryCachingPolicy(),
            delegate.close();
        assertNull("Delete without routing should have null routing", deleteNoRouting.routing());
            final ParsedDocument doc = createParsedDoc("id-" + seqNo, null);
        Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
            super(in, new SubReaderWrapper() {
import org.apache.lucene.index.DirectoryReader;
                seqNoToTerm.put(op.seqNo(), op.primaryTerm());
    private static final class CountingStoredFieldsReader extends StoredFieldsReader {
                while (op != null) {
            searcher = null;
import org.apache.lucene.index.LeafReader;
                assertThat("every read must go through the SequentialStoredFieldsLeafReader", documentsRead.get(), equalTo(numOps));
        long toSeqNo = randomLongBetween(fromSeqNo, Long.MAX_VALUE);
        }
        }
            if (rarely()) {
     */
        final int numOps = between(LuceneChangesSnapshot.MIN_SEQUENTIAL_ACCESS_BATCH_SIZE, 50);
        @Override
            assertThat(snapshot.totalOperations(), equalTo(numOps));
        } finally {
            }
            toSeqNo = randomLongBetween(refreshedSeqNo + 1, numOps * 2);
                    containsString("Not all operations between from_seqno [" + fromSeqNo + "] and to_seqno [" + toSeqNo + "] found")
            } finally {
                    ops.add(op);
        List<Translog.Operation> operations = new ArrayList<>();
        }
     * A nested document is indexed into Lucene as multiple documents. While the root document has both sequence number and primary term,
import static org.hamcrest.Matchers.hasSize;
            this.engine = createEngine(createStore(), createTempDir());
            0,
            assertFalse("descending docIDs must not use the sequential reader", snapshot.useSequentialStoredFieldsReader());
        }
                Translog.Operation op = callOnNewThread(snapshot::next);
            assertThat(
        int numOps = between(1, 100);
import java.util.concurrent.atomic.AtomicInteger;
        return operations;
                containsString("Not all operations between from_seqno [" + fromSeqNo + "] and to_seqno [" + toSeqNo + "] found")
                searcher = null;
                    toSeqNo,
            "doc-2",
        private final InternalEngine engine;
        final AtomicInteger acquisitions = new AtomicInteger();
                assertThat("sequential reader must be acquired once per leaf and reused", acquisitions.get(), equalTo(numLeaves));
            }
        return new Engine.Searcher(
        }
                assertOpsMatch(drainAll(snapshot), expectedDocs);
    @Override
                final ParsedDocument doc = createParsedDoc("id-" + seqNo, null);
                if (randomBoolean()) {
        if (failure.get() != null) {
                engine.delete(new Engine.Delete(doc.id(), newUid(doc.id()), primaryTerm.get()));
            searcher.getSimilarity(),
            }
        List<Engine.Operation> operations = generateHistoryOnReplica(between(1, 100), randomBoolean(), randomBoolean(), randomBoolean());
                    randomBoolean()
        }
        }
            assertOpsMatch(drainAll(snapshot), expectedDocs);
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            final Engine.Searcher countingSearcher = countingSearcher(searcher, acquisitions, documentsRead);
    }
            IOUtils.close(searcher);
            this.documentsRead = documentsRead;
            assertThat(index.id(), equalTo(expected.id()));
        } finally {
                        public CacheHelper getCoreCacheHelper() {
    }
                    fromSeqNo,
            searcher.getQueryCache(),
                searcher = null;
            assertFalse("interleaved segments must not use the sequential reader", snapshot.useSequentialStoredFieldsReader());
                expectedDocs.put(seqNo, doc);
            if (engine.getLocalCheckpointTracker().hasProcessed(op.seqNo()) == false) {
    private MapperService mapperService;
            searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
        }
            if (rarely()) {
    }
    }
    }
        boolean onPrimary = randomBoolean();
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", fromSeqNo, toSeqNo, true, randomBoolean())) {
 * this file be licensed under the Apache-2.0 license or a
            this.readLatch = readLatch;
                    .collect(Collectors.toList());
                }
                        @Override
import org.apache.lucene.codecs.StoredFieldsReader;
        // Get snapshot via engine will auto refresh
            final int numLeaves = searcher.getDirectoryReader().leaves().size();
                public LeafReader wrap(LeafReader reader) {
            try (
import static org.hamcrest.Matchers.instanceOf;
        Follower(InternalEngine leader, AtomicBoolean isDone, CountDownLatch readLatch) throws IOException {
    /**
            searcher.source(),
     * correctly skip non-root documents and returns at most one operation per sequence number.
                )
        @Override
            .put(super.indexSettings())
        long fromSeqNo = randomNonNegativeLong();
        for (int i = 0; i < numOps; i++) {
        public void run() {
                IOUtils.close(searcher);
        try {
                )
        }
            toSeqNo = randomLongBetween(fromSeqNo, refreshedSeqNo);
    }
            } finally {
                    fromSeqNo,
        } finally {
    }
        isDone.set(true);
        // Delete WITH routing
        @Override
                engine.index(replicaIndexForDoc(doc, 1, seqNo, false));
            if (rarely()) {
                    fromSeqNo,
                    engine.flush();
        for (int i = 0; i < numOps; i++) {
        public StoredFieldsReader clone() {
            }
import org.opensearch.index.mapper.ParsedDocument;
        final int batchSize = LuceneChangesSnapshot.MIN_SEQUENTIAL_ACCESS_BATCH_SIZE;
                );
        }
 * You may obtain a copy of the License at
            } else {
                Translog.Snapshot snapshot = new LuceneChangesSnapshot(
 * not use this file except in compliance with the License.
        final AtomicReference<Exception> failure = new AtomicReference<>();
 */
        private final AtomicInteger documentsRead;
                );
                }
            assertThat(snapshot, SnapshotMatchers.size(0));
                    true,
        engine.refresh("test");
            String id = Integer.toString(randomIntBetween(i, i + 5));
            assertThat(op.toString(), op, instanceOf(Translog.Index.class));
            for (long seqNo = step; seqNo < numOps; seqNo += 2) {
            long leaderCheckpoint = leader.getLocalCheckpointTracker().getProcessedCheckpoint();
import org.apache.lucene.index.StoredFieldVisitor;
        private final AtomicInteger documentsRead;
            engine.index(replicaIndexForDoc(doc, 1, seqNo, false));
        private final CountDownLatch readLatch;
                long fromSeqNo = followerCheckpoint + 1;
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        }
import org.opensearch.index.translog.SnapshotMatchers;
        final boolean accurateCount = randomBoolean();
                assertThat("reader must be re-acquired for every reading thread", acquisitions.get(), equalTo(numOps));
package org.opensearch.index.engine;
 * this work for additional information regarding copyright
        }
            try (LuceneChangesSnapshot snapshot = new LuceneChangesSnapshot(countingSearcher, numOps, 0, numOps - 1, true, true)) {
        final int numOps = between(LuceneChangesSnapshot.MIN_SEQUENTIAL_ACCESS_BATCH_SIZE, 100);
                )
                // every next() runs on a fresh thread; join() gives the happens-before that consumers get from locking
                engine.index(indexForDoc(doc));
            IOUtils.close(searcher);
 *     http://www.apache.org/licenses/LICENSE-2.0
                readLatch.await();
 *
                )
        }
 * license agreements. See the NOTICE file distributed with
            engine.flush();
 * GitHub history for details.
        final Map<Long, ParsedDocument> expectedDocs = indexAppendOnly(numOps);
                    false,
        final Map<Long, ParsedDocument> expectedDocs = new HashMap<>();
        // Round-trip through Engine.Delete → Translog.Delete
            final Translog.Operation newOp = op;
            assertNotNull("unexpected seqNo [" + op.seqNo() + "]", expected);
            this.isDone = isDone;
                        }
        Map<Long, Long> seqNoToTerm = new HashMap<>();
            return new CountingStoredFieldsReader(delegate.clone(), documentsRead);
            final ParsedDocument doc = createParsedDoc("id-" + i, null);
                        protected StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader storedFieldsReader) {
        assertThat(engine.getLocalCheckpointTracker().getProcessedCheckpoint(), equalTo(operations.size() - 1L));
                    error.getMessage(),
 * KIND, either express or implied.  See the License for the
            while ((op = snapshot.next()) != null) {
        long fromSeqNo = randomLongBetween(0, 5);
            followers[i].start();
            long followerCheckpoint = follower.getLocalCheckpointTracker().getProcessedCheckpoint();
import java.util.ArrayList;
            ) {
                engine.flush();
            );
}
                Translog.Snapshot snapshot = new LuceneChangesSnapshot(
                }
            } finally {
        try (LuceneChangesSnapshot snapshot = new LuceneChangesSnapshot(searcher, numOps, 0, numOps - 1, true, true)) {
            this.acquisitions = acquisitions;
                    randomBoolean()
            ParsedDocument doc = createParsedDoc(id, randomAlphaOfLengthBetween(1, 5), randomBoolean());
        long toSeqNo = randomLongBetween(Long.MAX_VALUE - 5, Long.MAX_VALUE);
import org.opensearch.index.VersionType;
        }
            try (
            } finally {
            expectedDocs.put(result.getSeqNo(), doc);
            assertThat(snapshot.skippedOperations(), equalTo(0));
    public void createMapper() throws Exception {
            try (
            Translog.Operation op;
                    translogHandler.run(snapshot);
            applyOperation(engine, op);
                IOUtils.close(searcher);
        final AtomicInteger documentsRead = new AtomicInteger();
            fromSeqNo = between(0, numOps);
                }
                    true,
            ) {
            );
                IllegalStateException error = expectThrows(IllegalStateException.class, () -> drainAll(snapshot));
 * software distributed under the License is distributed on an
            } catch (Exception e) {
                }
                            return new CountingStoredFieldsReader(storedFieldsReader, documentsRead);
                Translog.Snapshot snapshot = new LuceneChangesSnapshot(
/*
