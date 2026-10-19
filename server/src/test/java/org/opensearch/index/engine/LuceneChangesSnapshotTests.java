                        @Override  
                while (op != null) {  
                    .collect(Collectors.toList());  
        }
                } else {  
                }
            final Translog.Operation newOp = op;  
            IOUtils.close(follower.engine, follower.engine.store);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.atomic.AtomicInteger;  
    private static final class CountingSequentialDirectoryReader extends FilterDirectoryReader {  
    private void assertOpsMatch(List<Translog.Operation> ops, Map<Long, ParsedDocument> expectedDocs) {  
        public void checkIntegrity() throws IOException {  
                    fromSeqNo,
                    .map(d -> new DocIdSeqNoAndSource(d.getId(), null, d.getSeqNo(), d.getPrimaryTerm(), d.getVersion()))
            searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return in.getReaderCacheHelper();
                            return reader.getReaderCacheHelper();
            throw failure.get();
                    containsString("Not all operations between from_seqno [" + fromSeqNo + "] and to_seqno [" + toSeqNo + "] found")
/*  
            }
 * compatible open source license.
                    randomBoolean()
        final int numOps = between(LuceneChangesSnapshot.MIN_SEQUENTIAL_ACCESS_BATCH_SIZE, 100);  
        Map<Long, Long> seqNoToTerm = new HashMap<>();  
            } else {  
            );
            try (  
            try {  
        public CacheHelper getReaderCacheHelper() {
                engine.translogManager().rollTranslogGeneration();
                )
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", fromSeqNo, toSeqNo, true, randomBoolean())) {
import org.opensearch.index.IndexSettings;
        private final AtomicInteger documentsRead;
                IOUtils.close(searcher);
                    fromSeqNo,
    private static final class CountingStoredFieldsReader extends StoredFieldsReader {  
            this.engine = createEngine(createStore(), createTempDir());
        }  
        }  
            this.leader = leader;
        for (int i = 0; i < numOps; i++) {
        }
        for (int step = 0; step < 2; step++) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        List<Engine.Operation> operations = new ArrayList<>();  
                searcher = null;
            if (rarely()) {
                result.set(supplier.get());
            try {
            this.readLatch = readLatch;  
            }
    }  
                    toSeqNo,
        void pullOperations(InternalEngine follower) throws IOException {  
                    searcher,
        }  
        } else {
        return new Engine.Searcher(
            if (engine.getLocalCheckpointTracker().hasProcessed(op.seqNo()) == false) {  
            final ParsedDocument expected = expectedDocs.get(op.seqNo());
            assert operations.stream().allMatch(o -> o.seqNo() < newOp.seqNo()) : "Operations [" + operations + "], op [" + op + "]";
        @Override
import java.util.List;
        assertThat("Engine.Delete should carry routing", engineDelete.routing(), equalTo(routingValue));  
        final AtomicInteger acquisitions = new AtomicInteger();  
import static org.hamcrest.Matchers.hasSize;  
            followers[i].start();  
            if (rarely()) {
        final int numOps = batchSize * between(3, 10);
                engine
     */  
            } finally {
        }
            delegate.document(docID, visitor);  
                assertThat(snapshot, SnapshotMatchers.containsSeqNoRange(fromSeqNo, refreshedSeqNo));
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        }
                final ParsedDocument doc = createParsedDoc("id-" + seqNo, null);
                long batchSize = randomLongBetween(0, 100);
            long leaderCheckpoint = leader.getLocalCheckpointTracker().getProcessedCheckpoint();
        CountingStoredFieldsReader(StoredFieldsReader delegate, AtomicInteger documentsRead) {
                } else {
            } finally {
                assertOpsMatch(ops, expectedDocs);
        isDone.set(true);
                if (randomBoolean()) {  
    private Map<Long, ParsedDocument> indexAppendOnly(int numOps) throws IOException {
        return result.get();  
            assertThat(
                assertThat(snapshot, SnapshotMatchers.size(0));  
     * Wraps every leaf in a pass-through {@link SequentialStoredFieldsLeafReader} that counts how many times its  
import java.util.Map;  
                    true,  
        Follower(InternalEngine leader, AtomicBoolean isDone, CountDownLatch readLatch) throws IOException {  
                Translog.Snapshot snapshot = new LuceneChangesSnapshot(
            assertThat(snapshot, SnapshotMatchers.containsSeqNoRange(fromSeqNo, toSeqNo));
import org.apache.lucene.codecs.StoredFieldsReader;
            try (  
                        }
            Translog.Operation op;
            if (followerCheckpoint < leaderCheckpoint) {  
                final List<Translog.Operation> ops = new ArrayList<>();  
        for (int i = 0; i < numOps; i++) {
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.index.VersionType;
                searcher = null;
            0,  
import java.util.HashMap;
        Engine.Delete engineDelete = new Engine.Delete(
            expectedDocs.put(result.getSeqNo(), doc);  
import org.opensearch.common.util.io.IOUtils;  
            System.nanoTime(),
                        @Override
        final Map<Long, ParsedDocument> expectedDocs = new HashMap<>();
            }
        int numOps = scaledRandomIntBetween(1, 1000);
            );  
        );
    private static <T> T callOnNewThread(CheckedSupplier<T, Exception> supplier) throws Exception {  
            }  
 *
        }
            ) {  
                assertTrue(snapshot.useSequentialStoredFieldsReader());
                    searcher,
                    between(1, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE),  
        assertThat(deleteWithRouting.routing(), equalTo(routingValue));
                    op = new Engine.Delete(doc.id(), newUid(doc.id()), primaryTerm.get());
        } finally {
        }
    }  
            delegate.checkIntegrity();
        private final AtomicInteger documentsRead;
                engine.delete(new Engine.Delete(doc.id(), newUid(doc.id()), primaryTerm.get()));  
                    .map(d -> new DocIdSeqNoAndSource(d.getId(), null, d.getSeqNo(), d.getPrimaryTerm(), d.getVersion()))
                seqNoToTerm.put(op.seqNo(), op.primaryTerm());
            }
        @Override  
        assertThat(ops, hasSize(expectedDocs.size()));
        CountDownLatch readyLatch = new CountDownLatch(followers.length + 1);
                try (Translog.Snapshot snapshot = leader.newChangesSnapshot("test", fromSeqNo, toSeqNo, true, randomBoolean())) {
 * this file be licensed under the Apache-2.0 license or a
            IOUtils.close(searcher);
                    searcher,
                assertThat(snapshot, SnapshotMatchers.containsSeqNoRange(fromSeqNo, toSeqNo));
import org.opensearch.test.IndexSettingsModule;
            }
                    engine.flush();
 * license agreements. See the NOTICE file distributed with
                IOUtils.close(searcher);
            this.isDone = isDone;
        final int numOps = between(LuceneChangesSnapshot.MIN_SEQUENTIAL_ACCESS_BATCH_SIZE, 50);
    }
                    fromSeqNo,
        Translog.Operation op;
    public void testUpdateAndReadChangesConcurrently() throws Exception {  
            final Translog.Index index = (Translog.Index) op;
                searcher = null;  
/*  
        final Thread thread = new Thread(() -> {  
                    containsString("Not all operations between from_seqno [" + fromSeqNo + "] and to_seqno [" + toSeqNo + "] found")
            "doc-2",  
        public StoredFieldsReader clone() {
            operations.add(newOp);  
                    return new SequentialStoredFieldsLeafReader(reader) {
    public void testInterleavedSeqNosAcrossSegmentsUseDefaultStoredFieldsReader() throws Exception {  
                    ops.add(op);
    /**  
        } finally {  
            assertThat(
                } else {  
package org.opensearch.index.engine;
    public void testBasics() throws Exception {
        engine.refresh("test");  
    }  
            assertThat(snapshot.totalOperations(), equalTo(numOps));  
            toSeqNo = randomLongBetween(refreshedSeqNo + 1, numOps * 2);  
import org.junit.Before;  
                readLatch.await();
    }
        fromSeqNo = randomLongBetween(0, numOps - 1);
                    between(1, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE),  
        @Override
                assertTrue("contiguous docIDs must use the sequential reader", snapshot.useSequentialStoredFieldsReader());  
                searcher = null; // closed by the snapshot through the counting searcher
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", fromSeqNo, toSeqNo, true, randomBoolean())) {  
 * not use this file except in compliance with the License.
                            return reader.getCoreCacheHelper();
            // a batch size well below the op count forces multiple batches, exercising reader reuse across them
import java.io.IOException;
 */  
                Translog.Snapshot snapshot = new LuceneChangesSnapshot(  
        readyLatch.await();
            logger.error("Reading [{}]", op);
                List<DocIdSeqNoAndSource> docsWithoutSourceOnLeader = getDocIds(leader, true).stream()
    @Override  
                engine.index(indexForDoc(doc));
                    between(1, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE),
        final boolean accurateCount = randomBoolean();
            }  
        @Override  
            this.documentsRead = documentsRead;  
 * SPDX-License-Identifier: Apache-2.0
        public void run() {
        final AtomicInteger acquisitions = new AtomicInteger();
        public void document(int docID, StoredFieldVisitor visitor) throws IOException {
            });
        // Get snapshot via engine will auto refresh
            searcher.getSimilarity(),
import org.apache.lucene.index.DirectoryReader;
            assertThat(index.source(), equalTo(expected.source()));
        for (Engine.Operation op : operations) {
        public void close() throws IOException {
 * GitHub history for details.
    public void testContiguousReadsReuseSequentialStoredFieldsReader() throws Exception {
        }
                refreshedSeqNo = i;
        }
                assertThat("every read must go through the SequentialStoredFieldsLeafReader", documentsRead.get(), equalTo(numOps));  
            }
            }  
/*
import org.opensearch.index.translog.Translog;
        final Map<Long, ParsedDocument> expectedDocs = new HashMap<>();
            engine.flush();  
     */
                    toSeqNo,
        }
        });  
            } catch (Exception e) {  
        try (LuceneChangesSnapshot snapshot = new LuceneChangesSnapshot(searcher, numOps, 0, numOps - 1, true, true)) {
            try (LuceneChangesSnapshot snapshot = new LuceneChangesSnapshot(countingSearcher, numOps, 0, numOps - 1, true, true)) {  
     */
            assertFalse("interleaved segments must not use the sequential reader", snapshot.useSequentialStoredFieldsReader());
                );  
        assertNull("Delete without routing should have null routing", deleteNoRouting.routing());
 * The OpenSearch Contributors require contributions made to  
        }  
                    false,
                while (isDone.get() == false  
                        public CacheHelper getReaderCacheHelper() {  
                )
    }
            final ParsedDocument doc = createParsedDoc("id-" + seqNo, null);
    }  
    /**
        // Delete WITHOUT routing (backward compatibility)
        for (Translog.Operation op : ops) {
            } catch (Exception ex) {
            Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
        Translog.Delete deleteNoRouting = new Translog.Delete("doc-3", 2, 1, 1);  
                        public CacheHelper getCoreCacheHelper() {
                readLatch.countDown();
                );  
        } finally {
                Translog.Snapshot snapshot = new LuceneChangesSnapshot(
            } finally {
    protected Settings indexSettings() {
                        }
                        }  
        final AtomicInteger documentsRead = new AtomicInteger();
            if (randomBoolean()) {  
        private final TranslogHandler translogHandler;
        for (Follower follower : followers) {
                Translog.Snapshot snapshot = new LuceneChangesSnapshot(
     * non-root documents don't have primary term but only sequence numbers. This test verifies that {@link LuceneChangesSnapshot}
            }  
        engine.refresh("test");
import static org.hamcrest.Matchers.not;
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", fromSeqNo, toSeqNo, false, randomBoolean())) {
            fromSeqNo = randomLongBetween(0, refreshedSeqNo);
                public LeafReader wrap(LeafReader reader) {
                IllegalStateException error = expectThrows(IllegalStateException.class, () -> drainAll(snapshot));
                searcher = null; // closed by the snapshot through the counting searcher
    }  
            if (onPrimary) {  
        int refreshedSeqNo = -1;
                )
            for (long seqNo = step; seqNo < numOps; seqNo += 2) {
                engine.index(replicaIndexForDoc(doc, 1, seqNo, false));  
 * You may obtain a copy of the License at  
                }  
                    toSeqNo,
    public void testOutOfOrderSeqNoUsesDefaultStoredFieldsReader() throws Exception {
                long toSeqNo = Math.min(fromSeqNo + batchSize, leaderCheckpoint);  
        toSeqNo = randomLongBetween(fromSeqNo, numOps - 1);  
                error.getMessage(),  
                // every next() runs on a fresh thread; join() gives the happens-before that consumers get from locking
            assertThat(index.id(), equalTo(expected.id()));
            ParsedDocument doc = createParsedDoc(id, randomAlphaOfLengthBetween(1, 5), randomBoolean());
        try (LuceneChangesSnapshot snapshot = new LuceneChangesSnapshot(searcher, numOps, 0, numOps - 1, true, true)) {
import org.opensearch.index.mapper.MapperService;  
     */
            searcher = null;
     * A nested document is indexed into Lucene as multiple documents. While the root document has both sequence number and primary term,
                    between(1, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE),  
        }  
                IndexSettingsModule.newIndexSettings(shardId.getIndexName(), leader.engineConfig.getIndexSettings().getSettings()),
            reader,  
                            return new CountingStoredFieldsReader(storedFieldsReader, documentsRead);  
    private MapperService mapperService;
            long followerCheckpoint = follower.getLocalCheckpointTracker().getProcessedCheckpoint();
            operations.add(op);
import org.opensearch.common.settings.Settings;
            final Engine.Searcher countingSearcher = countingSearcher(searcher, acquisitions, documentsRead);  
    private static Engine.Searcher countingSearcher(Engine.Searcher searcher, AtomicInteger acquisitions, AtomicInteger documentsRead)
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
            final ParsedDocument doc = createParsedDoc("id-" + i, null);
        Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
        }
            try (
            this.acquisitions = acquisitions;  
        for (int i = 0; i < followers.length; i++) {
        // Delete WITH routing
                    || engine.getLocalCheckpointTracker().getProcessedCheckpoint() < leader.getLocalCheckpointTracker()
            } else {
                }
                assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
 */  
        Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);  
    }
 * KIND, either express or implied.  See the License for the
        while ((op = snapshot.next()) != null) {
        final String routingValue = "tenant-abc";  
            } finally {  
                    randomBoolean()
                    toSeqNo,
            routingValue
                )
        }  
        assertThat(deleteNoRouting.toString(), not(containsString("routing=")));
            toSeqNo = randomLongBetween(fromSeqNo, refreshedSeqNo);
                assertThat(documentsRead.get(), equalTo(numOps));  
        } finally {
                    between(1, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE),
        thread.start();
        Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);  
                    op = replicaIndexForDoc(doc, randomNonNegativeLong(), i, randomBoolean());
 * this work for additional information regarding copyright
            }  
        try {  
    }  
            } finally {
            searcher.getQueryCachingPolicy(),  
        }  
            }
            String id = Integer.toString(randomIntBetween(1, 10));  
                IOUtils.close(searcher);
                            acquisitions.incrementAndGet();
                error.getMessage(),
        boolean onPrimary = randomBoolean();
        final Map<Long, ParsedDocument> expectedDocs = indexAppendOnly(numOps);
                failure.set(e);
            assertThat(snapshot.totalOperations(), equalTo(numOps));  
                    true,  
        final AtomicReference<T> result = new AtomicReference<>();
                    searcher,  
        assertThat(engine.getLocalCheckpointTracker().getProcessedCheckpoint(), equalTo(operations.size() - 1L));  
            }  
        }
                // have to verify without source since we are randomly testing without _source  
        final int batchSize = LuceneChangesSnapshot.MIN_SEQUENTIAL_ACCESS_BATCH_SIZE;  
            super(in, new SubReaderWrapper() {
            this.documentsRead = documentsRead;
        private final InternalEngine engine;
        if (failure.get() != null) {  
            ParsedDocument doc = createParsedDoc(id, null, randomBoolean());
        List<Engine.Operation> operations = generateHistoryOnReplica(between(1, 100), randomBoolean(), randomBoolean(), randomBoolean());
            }  
                xContentRegistry(),  
            fromSeqNo = between(0, numOps);  
                assertThat(docsWithoutSourceOnFollower, equalTo(docsWithoutSourceOnLeader));
 * Licensed to Elasticsearch under one or more contributor  
                }
    public void testSkipNonRootOfNestedDocuments() throws Exception {
        return operations;
        }
                assertThat(  
            searcher.source(),
        final Map<Long, ParsedDocument> expectedDocs = indexAppendOnly(numOps);  
     * Verifies that routing values round-trip correctly through Translog.Delete serialization.  
        Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
        // Round-trip through Engine.Delete → Translog.Delete
        }
            assertThat(snapshot.skippedOperations(), equalTo(0));
            Engine.Operation.Origin.PRIMARY,  
        }  
import java.util.stream.Collectors;
        long toSeqNo = randomLongBetween(fromSeqNo, Long.MAX_VALUE);
    /**
            primaryTerm.get(),  
            }
        // Empty engine
 * specific language governing permissions and limitations
            follower.join();  
        @Override
        }  
        @Override
                    fromSeqNo,
            }  
        Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);  
        List<Translog.Operation> operations = new ArrayList<>();  
            final Engine.Searcher countingSearcher = countingSearcher(searcher, acquisitions, documentsRead);
            }  
                assertThat("sequential reader must be acquired once per leaf and reused", acquisitions.get(), equalTo(numLeaves));
            try (
            if (rarely()) {
            assertOpsMatch(drainAll(snapshot), expectedDocs);  
            IllegalStateException error = expectThrows(IllegalStateException.class, () -> drainAll(snapshot));
            documentsRead.incrementAndGet();
        long fromSeqNo = randomNonNegativeLong();  
                assertOpsMatch(drainAll(snapshot), expectedDocs);
        engine.refresh("test");
                }
 * Unless required by applicable law or agreed to in writing,
    class Follower extends Thread {
import java.util.ArrayList;  
            applyOperation(engine, op);  
        AtomicBoolean isDone = new AtomicBoolean();  
            ) {
    /**  
            expectedDocs.put(seqNo, doc);  
            IOUtils.close(searcher);  
                    false,
        long toSeqNo = randomLongBetween(Long.MAX_VALUE - 5, Long.MAX_VALUE);
    }
                    };  
            assertNotNull("unexpected seqNo [" + op.seqNo() + "]", expected);  
     * sequential stored fields reader is acquired, and how many documents that reader serves.
            newUid("doc-2"),
            .put(super.indexSettings())  
        private final CountDownLatch readLatch;
            );
            final Engine.Operation op;
            if (rarely()) {
            while ((op = snapshot.next()) != null) {
            searcher = null;
                List<DocIdSeqNoAndSource> docsWithoutSourceOnFollower = getDocIds(engine, true).stream()
                IOUtils.close(searcher);
                }
 * under the License.  
                    .collect(Collectors.toList());  
public class LuceneChangesSnapshotTests extends EngineTestCase {
            final Engine.IndexResult result = engine.index(indexForDoc(doc));
                    randomBoolean()
            this.delegate = delegate;
            final long seqNo = numOps - 1 - i;  
    private List<Translog.Operation> drainAll(Translog.Snapshot snapshot) throws IOException {
                long fromSeqNo = followerCheckpoint + 1;
            }
                        protected StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader storedFieldsReader) {
        assertThat(deleteWithRouting.toString(), containsString("routing=" + routingValue));
import static org.hamcrest.Matchers.instanceOf;
        }
                engine.refresh("test");
                containsString("Not all operations between from_seqno [" + fromSeqNo + "] and to_seqno [" + toSeqNo + "] found")
 * ownership. Elasticsearch licenses this file to you under  
            return new CountingSequentialDirectoryReader(in, acquisitions, documentsRead);  
            engine.index(replicaIndexForDoc(doc, 1, seqNo, false));
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true) // always enable soft-deletes
        }
    public void testDeleteRoutingSerialization() throws Exception {
        final AtomicReference<Exception> failure = new AtomicReference<>();
                }  
        thread.join();
                Translog.Snapshot snapshot = new LuceneChangesSnapshot(
     * The returned searcher takes ownership of {@code searcher}.
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
                expectedDocs.put(seqNo, doc);
                    op = new Engine.Index(newUid(doc), primaryTerm.get(), doc);
                        @Override  
            }
            searcher.getQueryCache(),
            ) {  
    @Before
                        .getProcessedCheckpoint()) {
        CountingSequentialDirectoryReader(DirectoryReader in, AtomicInteger acquisitions, AtomicInteger documentsRead) throws IOException {
import org.apache.lucene.index.LeafReader;
    public void testOverFlow() throws Exception {
import org.opensearch.index.translog.SnapshotMatchers;  
                IOUtils.close(searcher);  
                )  
        }
        final int numOps = 2 * between(LuceneChangesSnapshot.MIN_SEQUENTIAL_ACCESS_BATCH_SIZE, 50);
        }
import org.apache.lucene.index.FilterDirectoryReader;  
                if (randomBoolean()) {
    }
    }
        long fromSeqNo = randomLongBetween(0, 5);  
        }
            IllegalStateException error = expectThrows(IllegalStateException.class, () -> drainAll(snapshot));  
                engine.flush();
        @Override  
        for (int i = 0; i < numOps; i++) {  
            try (LuceneChangesSnapshot snapshot = new LuceneChangesSnapshot(countingSearcher, batchSize, 0, numOps - 1, true, true)) {
            String id = Integer.toString(randomIntBetween(i, i + 5));
            IOUtils.close(searcher);
import org.apache.lucene.index.StoredFieldVisitor;
            assertFalse("descending docIDs must not use the sequential reader", snapshot.useSequentialStoredFieldsReader());
 */
        final Map<Long, ParsedDocument> expectedDocs = new HashMap<>();
        throws IOException {
        private final InternalEngine leader;  
                @Override  
                throw new AssertionError(ex);  
        // Verify toString includes routing  
                    engine.refresh("test");  
import java.util.concurrent.atomic.AtomicReference;
            .build();
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        }
                searcher = null;
        concurrentlyApplyOps(operations, engine);
                assertThat(op.toString(), op.primaryTerm(), equalTo(seqNoToTerm.get(op.seqNo())));  
                IllegalStateException error = expectThrows(IllegalStateException.class, () -> drainAll(snapshot));
                    op = replicaDeleteForDoc(doc.id(), randomNonNegativeLong(), i, randomNonNegativeLong());
        assertThat(deleteWithRouting.id(), equalTo("doc-1"));
                    error.getMessage(),
                    translogHandler.run(snapshot);
            searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
                containsString("Not all operations between from_seqno [" + fromSeqNo + "] and to_seqno [" + toSeqNo + "] found")  
                assertThat("reader must be re-acquired for every reading thread", acquisitions.get(), equalTo(numOps));
                assertThat(  
    }  
     * correctly skip non-root documents and returns at most one operation per sequence number.  
            Engine.Searcher searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);  
        if (refreshedSeqNo == -1) {
            assertThat(snapshot, SnapshotMatchers.size(0));
     * Wraps the searcher's reader so that every leaf sits behind a counting {@link SequentialStoredFieldsLeafReader}.
            }
            delegate.close();  
            this.translogHandler = new TranslogHandler(
        engine.refresh("test");
        try {
        }
            ) {
    }  
import org.opensearch.index.mapper.ParsedDocument;
    }
            if (accurateCount == true) {
    public void createMapper() throws Exception {
            IOUtils.close(searcher);  
            assertThat(op.toString(), op, instanceOf(Translog.Index.class));  
            assertOpsMatch(drainAll(snapshot), expectedDocs);
        final AtomicInteger documentsRead = new AtomicInteger();
            // the flag is computed for the first batch by the constructor; a single batch holds every op here
 * Modifications Copyright OpenSearch Contributors. See
                    searcher,
            final int numLeaves = searcher.getDirectoryReader().leaves().size();
        private final StoredFieldsReader delegate;
        private final AtomicInteger acquisitions;
        try (Translog.Snapshot snapshot = engine.newChangesSnapshot("test", fromSeqNo, toSeqNo, randomBoolean(), randomBoolean())) {
        final DirectoryReader reader = new CountingSequentialDirectoryReader(searcher.getDirectoryReader(), acquisitions, documentsRead);  
        }
        int numOps = between(1, 100);
        mapperService = createMapperService();  
import static org.hamcrest.Matchers.containsString;
            1L,
}  
                    pullOperations(engine);  
            VersionType.INTERNAL,
        }
                    true,  
            toSeqNo = randomLongBetween(fromSeqNo, numOps * 2);
import org.opensearch.common.CheckedSupplier;  
            searcher = engine.acquireSearcher("test", Engine.SearcherScope.INTERNAL);
                    error.getMessage(),
                assertThat(snapshot.totalOperations(), equalTo(seqNoToTerm.size()));
        long maxSeqNo = engine.getLocalCheckpointTracker().getMaxSeqNo();
                    op = callOnNewThread(snapshot::next);
            ) {  
        return expectedDocs;  
                    randomBoolean()  
        try (Translog.Snapshot snapshot = new LuceneChangesSnapshot(searcher, between(1, 100), 0, maxSeqNo, false, accurateCount)) {  
        for (int i = 0; i < numOps; i++) {  
                Translog.Operation op = callOnNewThread(snapshot::next);
        Translog.Delete deleteWithRouting = new Translog.Delete("doc-1", 1, 1, 1, routingValue);  
            try (  
import java.util.concurrent.CountDownLatch;
            return new CountingStoredFieldsReader(delegate.clone(), documentsRead);
            followers[i] = new Follower(engine, isDone, readyLatch);
                searcher = null;
                if (randomBoolean()) {
    }
    }
import static org.hamcrest.Matchers.equalTo;
                    fromSeqNo,  
 * software distributed under the License is distributed on an
        );
            searcher
        private final AtomicBoolean isDone;  
import java.util.concurrent.atomic.AtomicBoolean;
        return Settings.builder()
        Follower[] followers = new Follower[between(1, 3)];
    public void testSequentialStoredFieldsReaderIsReacquiredOnThreadChange() throws Exception {
                    toSeqNo,  
                    randomBoolean()
        readyLatch.countDown();  
 *
    }
 *  
