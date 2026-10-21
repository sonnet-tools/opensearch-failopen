                        }
        cancellation.cancelled = true;
        assertEquals(2, delegate.scalarCalls);
        assertEquals(258, postings.docID());
            doc = (long) doc + step >= end ? NO_MORE_DOCS : doc + step;
     * Native batches must preserve document IDs, frequencies, exclusive bounds, and cursor position
        Cancellation cancellation = new Cancellation();
                move();
            this.batchSize = batchSize;
        public int freq() {
    private static class Cancellation implements ExitableDirectoryReader.QueryCancellation {
            return doc;
            this.doc = first;
                            assertEquals(expected.docID(), buffer.docs[i]);
     * for dense and sparse postings, including near the end-of-iteration sentinel.
                            assertTrue(expected < upTo);
                FixedBitSet expected = new FixedBitSet(bits.length());
        assertEquals(0, delegate.scalarCalls);
        }
                    DocAndFloatFeatureBuffer buffer = new DocAndFloatFeatureBuffer();
        public void nextPostings(int upTo, DocAndFloatFeatureBuffer buffer) {
    }
                    }
        public void intoBitSet(int upTo, FixedBitSet bits, int offset) {
                            assertEquals(1 + expected % 3, buffer.features[i], 0);
        postings.intoBitSet(budget + 100, bits, 0);
        assertEquals(2550000, buffer.docs[255]);
                assertTrue(delegate.bitSetCalls > 0);
        assertTrue(delegate.maxBitSetSpan <= 1 << 20);
                            expected = (long) expected + step >= NO_MORE_DOCS ? NO_MORE_DOCS : expected + step;
        assertEquals(20000, bits.cardinality());
                for (int upTo : new int[] { 37, 38, 20000, 30000, NO_MORE_DOCS }) {
import org.apache.lucene.document.Field;
import org.opensearch.test.OpenSearchTestCase;
        expectThrows(TaskCancelledException.class, () -> postings.intoBitSet(NO_MORE_DOCS, new FixedBitSet(30000), 0));
     */
                            assertEquals(expected.freq(), buffer.features[i], 0);
            PostingsEnum postings = wrap(delegate, cancellation);
            }
        return new ExitableDirectoryReader.ExitablePostingsEnum(delegate, cancellation);
        public int endOffset() {
                        assertTrue(buffer.size <= batchSize);
        }
import org.apache.lucene.util.FixedBitSet;
        postings.intoBitSet(NO_MORE_DOCS, bits, first);
import org.apache.lucene.index.DirectoryReader;
                    actual.intoBitSet(13000, bits, 0);
        int scalarCalls;
    /** Compare wrapped and raw codec postings across bitset and batch operations on both dense and sparse terms. */
            if (cancelled) {
        public int nextDoc() {
     */
        public int docID() {
        int checks;
                    postings.nextPostings(upTo, buffer);
        PostingsEnum postings = wrap(delegate, new Cancellation());
     * Sampling counts returned postings. A native batch may overshoot the budget, but the following
    public void testDocIDRunEndDelegates() throws IOException {
        PostingsEnum postings = wrap(delegate, cancellation);
    public void testIntoBitSetPreservesDocsAndCursor() throws IOException {
            long next = doc + ((long) target - doc + step - 1) / step * step;
        }
            }
        }
        public int advance(int target) {
        assertEquals(0, postings.docID());
     */
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 10000000, 10000, 256);
        public int docIDRunEnd() {
                    Term term = new Term("field", text);
            }
        cancellation.cancelled = true;
                        assertEquals(expected.docID(), actual.docID());
            }
        DocAndFloatFeatureBuffer buffer = new DocAndFloatFeatureBuffer();
                        assertTrue(buffer.size > 0);
    public void testNextPostingsSamplesByWork() throws IOException {
            return null;
        assertEquals(0, delegate.bitSetCalls);
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 3000000, 1, 256);
                            expected.nextDoc();
        Cancellation cancellation = new Cancellation();
        }
            return -1;
    /** Bounding batches by document-ID distance would fragment sparse postings and lose native batching. */
        assertEquals(1, cancellation.checks);
                    assertEquals(0, buffer.size);
            maxBitSetSpan = Math.max(maxBitSetSpan, upTo - doc);
            while (doc < upTo && buffer.size < batchSize) {
        }
        while (postings.docID() < 8192) {
        }
                }
                bits.set(40 - offset);
        @Override
            for (int i = 0; i < 20000; i++) {
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 5_000_000, 1, 256);
    }
        public int nextPosition() {
        PostingsEnum postings = wrap(delegate, new Cancellation());
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 30000, 1, 256);
        assertEquals(2, cancellation.checks);
            for (int offset : new int[] { -11, 23 }) {
    }
        Cancellation cancellation = new Cancellation();
                throw new TaskCancelledException("cancelled");
    /** Cancellation after the first chunk must stop a large bitset fill before the second chunk begins. */
        @Override
        assertEquals(256, buffer.size);
        expectThrows(TaskCancelledException.class, () -> postings.intoBitSet(NO_MORE_DOCS, bits, 0));
        @Override
        @Override
                int expected = first;
                BulkPostingsEnum delegate = new BulkPostingsEnum(37, 30000, step, 256);
    }
                        assertTrue(buffer.size > 0);
    public void testCancelledBeforeBulkWork() throws IOException {
    /**
 * The OpenSearch Contributors require contributions made to
                document.add(new TextField("field", i % 17 == 0 ? "a a a b b" : "a a", Field.Store.NO));
        }
                assertEquals(0, delegate.scalarCalls);
        for (int step : new int[] { 1, 17, 10000 }) {
import org.apache.lucene.index.PostingsEnum;
    /** Even short bitset fills must check cancellation at the next call, regardless of the scalar sampling counter. */
            assertEquals(expected, postings.docID());
        Runnable afterBulk = () -> {};
        postings.intoBitSet(1000, bits, 0);
            assertEquals(expected, postings.docID());
        int first = NO_MORE_DOCS - 20000;
        for (int step : new int[] { 1, 17 }) {
    private static PostingsEnum wrap(PostingsEnum delegate, Cancellation cancellation) {
        postings.nextPostings(NO_MORE_DOCS, new DocAndFloatFeatureBuffer());
            DocAndFloatFeatureBuffer buffer = new DocAndFloatFeatureBuffer();
                BulkPostingsEnum delegate = new BulkPostingsEnum(first, NO_MORE_DOCS, step, batchSize);
            return doc = next >= end ? NO_MORE_DOCS : (int) next;
        assertEquals(0, delegate.batchCalls);
        public boolean isEnabled() {
     * call must check cancellation before consuming any more postings.
                    assertEquals(expected.docID(), actual.docID());
        expectThrows(TaskCancelledException.class, postings::nextDoc);
    /** An already-cancelled query must stop before entering either codec bulk operation. */
        assertEquals(1, cancellation.checks);
import java.io.IOException;
                    assertEquals(0, bits.cardinality());
        }
            return -1;
                buffer.docs[buffer.size] = doc;
            return 1 + doc % 3;
        assertEquals(2, cancellation.checks);
    }
            }
    public void testScalarSampling() throws IOException {
     * on the first unconsumed document while using the delegate's bulk implementation.
        for (int doc = 2; doc <= 8192; doc++) {
                        assertEquals(expected, postings.docID());
import org.apache.lucene.index.Term;
        }
                        assertTrue(bits.getAndClear(doc));
            Cancellation cancellation = new Cancellation();
    }
            return doc;
    /** Run metadata must reach Lucene unchanged without advancing the postings cursor. */
    public void testNextPostingsPreservesDocsFrequenciesAndCursor() throws IOException {
        postings.intoBitSet(budget + 200, bits, 0);
            buffer.growNoCopy(batchSize);
    }
        BulkPostingsEnum delegate = new BulkPostingsEnum(37, 10000, 1, 256);
                postings.nextPostings(NO_MORE_DOCS, buffer);
        assertEquals(2560000, postings.docID());
                    assertEquals(expected, postings.docID());
            for (int batchSize : new int[] { 16, 256, 20000 }) {
        public int startOffset() {
                assertTrue(delegate.batchCalls > 0);
                    assertEquals(expected.freq(), actual.freq());
        try (Directory directory = newDirectory(); IndexWriter writer = new IndexWriter(directory, newIndexWriterConfig())) {
            }
            // Include a custom codec whose batches are larger than the cancellation interval.
    private static class BulkPostingsEnum extends PostingsEnum {
        }
        assertEquals(8192, delegate.scalarCalls);
        private void move() {
        assertEquals(1, delegate.batchCalls);
        private final int end;
        }
                    assertEquals(expected, bits);
        assertEquals(2, postings.advance(2));
            this.end = end;
    public void testMixedScalarAndBatchCancellation() throws IOException {
 *
        }
        private final int step;
    public void testSparseNextPostingsPreservesBatchSize() throws IOException {
        @Override
        Cancellation cancellation = new Cancellation();
        BulkPostingsEnum delegate = new BulkPostingsEnum(first, NO_MORE_DOCS, 1, 256);
        @Override
            return step == 1 ? end : doc + 1;
     * Bulk fills must honor offsets and exclusive bounds, retain existing bits, and leave the cursor
import org.apache.lucene.index.LeafReader;
            return -1;
        }
        assertEquals(8192, postings.docID());
                }
                    postings.intoBitSet(upTo, bits, offset);
package org.opensearch.search.internal;
                for (String text : new String[] { "a", "b" }) {
        assertEquals(0, delegate.scalarCalls);
                Document document = new Document();
    /** Preserve the first-call check and 8192-call interval across interleaved nextDoc and advance operations. */
    /**
                    int next = 37 + Math.max(0, (Math.min(upTo, 30000) - 37 + step - 1) / step) * step;
            assertEquals(1, cancellation.checks);
                    buffer.size = 7;
        @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.tasks.TaskCancelledException;
        FixedBitSet bits = new FixedBitSet(20000);
                move();
    /** Scalar and batch operations must share a sampling budget so switching APIs cannot postpone cancellation. */
        assertEquals(1, cancellation.checks);
            }
        @Override
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
                expected.set(40 - offset);
                int first = NO_MORE_DOCS - 30000;
import org.apache.lucene.store.Directory;
        PostingsEnum postings = wrap(delegate, new Cancellation());
        assertEquals(0, delegate.scalarCalls);
                assertTrue(delegate.maxBitSetSpan <= 1 << 20);
    public void testIntoBitSetNearNoMoreDocs() throws IOException {
                    FixedBitSet bits = new FixedBitSet(20000);
        postings.nextPostings(NO_MORE_DOCS, buffer);
    /** Computing a cancellation chunk's endpoint must not overflow near Lucene's end-of-iteration sentinel. */
                    for (int doc = 37; doc < Math.min(upTo, 30000); doc += step) {
                assertEquals(0, delegate.scalarCalls);
        }
    }
            move();
/*
public class ExitablePostingsEnumTests extends OpenSearchTestCase {
        public void checkCancelled() {
        }
    }
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 30000, 1, 256);
        assertEquals(1, delegate.bitSetCalls);
 * SPDX-License-Identifier: Apache-2.0
                }
        FixedBitSet bits = new FixedBitSet(3000000);
        expectThrows(TaskCancelledException.class, () -> postings.nextPostings(NO_MORE_DOCS, new DocAndFloatFeatureBuffer()));
                        }
                        postings.nextPostings(upTo, buffer);
            try (DirectoryReader reader = DirectoryReader.open(writer)) {
                LeafReader leaf = reader.leaves().getFirst().reader();
    }
        }
        assertEquals(1 << 20, postings.docID());
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 30000, 1, 256);
import org.apache.lucene.document.Document;
        @Override
import org.apache.lucene.search.DocAndFloatFeatureBuffer;
            int expected = Math.max(8192, batchSize);
        int maxBitSetSpan;
    /**
        assertEquals(1, cancellation.checks);
    }
        }
                bits.set(doc - offset);
            while (postings.docID() < 8192) {
        delegate.afterBulk = () -> cancellation.cancelled = true;
                        expected.set(doc - offset);
                expected.set(30001 - offset);
        BulkPostingsEnum(int first, int end, int step, int batchSize) {
            batchCalls++;
        }
        assertEquals(37, postings.docID());
                    PostingsEnum expected = leaf.postings(term, PostingsEnum.FREQS);
        @Override
    public void testCodecPostings() throws IOException {
        private final int batchSize;
        }
        @Override
            afterBulk.run();
                PostingsEnum postings = wrap(delegate, new Cancellation());
        public BytesRef getPayload() {
}
        FixedBitSet bits = new FixedBitSet(5_000_000);
                    while (expected < upTo) {
        assertEquals(1, postings.nextDoc());
                    assertEquals(expected.nextDoc(), actual.nextDoc());
                writer.addDocument(document);
        assertEquals(1 << 20, bits.cardinality());
            assertEquals(doc, doc % 2 == 0 ? postings.advance(doc) : postings.nextDoc());
                assertEquals(1, cancellation.checks);
            scalarCalls++;
        final int budget = 1 << 20; // MAX_DOCS_PER_BITSET_CHECK
                DocAndFloatFeatureBuffer buffer = new DocAndFloatFeatureBuffer();
                    assertEquals(expected.docIDRunEnd(), actual.docIDRunEnd());
                bits.set(30001 - offset);
        int bitSetCalls;
        }
        @Override
import org.apache.lucene.document.TextField;
            scalarCalls++;
        PostingsEnum postings = wrap(delegate, cancellation);
                            assertEquals(expected, buffer.docs[i]);
        public long cost() {
    public void testCancellationBetweenBitSetCalls() throws IOException {
                        for (int i = 0; i < buffer.size; i++) {
        assertEquals(8194, postings.docID());
                    }
                    for (int doc = expected.docID(); doc < 13000; doc = expected.nextDoc()) {
                    while (actual.docID() != NO_MORE_DOCS) {
        assertEquals(1, postings.nextDoc());
            this.step = step;
                    PostingsEnum actual = wrap(leaf.postings(term, PostingsEnum.FREQS), new Cancellation());
            BulkPostingsEnum delegate = new BulkPostingsEnum(0, 30000, 1, batchSize);
    /** Already positioned postings with observable bulk methods, independent of a codec's block layout. */
                        for (int i = 0; i < buffer.size; i++) {
        }
            expectThrows(TaskCancelledException.class, () -> postings.nextPostings(NO_MORE_DOCS, buffer));
    }
                PostingsEnum postings = wrap(delegate, new Cancellation());
        expectThrows(TaskCancelledException.class, postings::nextDoc);
            while (doc < upTo) {
        // The final native batch may overshoot the remaining budget.
        assertEquals(NO_MORE_DOCS, postings.docID());
            bitSetCalls++;
        PostingsEnum postings = wrap(delegate, cancellation);
import org.apache.lucene.index.IndexWriter;
                FixedBitSet bits = new FixedBitSet(30002 - offset);
            postings.nextPostings(NO_MORE_DOCS, new DocAndFloatFeatureBuffer());
                for (int upTo : new int[] { first, first + 10000, NO_MORE_DOCS }) {
        int batchCalls;
            return true;
                    assertEquals(next >= 30000 ? NO_MORE_DOCS : next, postings.docID());
        boolean cancelled;
import org.apache.lucene.util.BytesRef;
        PostingsEnum postings = wrap(delegate, cancellation);
            checks++;
            afterBulk.run();
            buffer.size = 0;
        for (int batchSize : new int[] { 16, 256, 20000 }) {
        PostingsEnum postings = wrap(delegate, cancellation);
            return end / step;
                    }
        Cancellation cancellation = new Cancellation();
 */
    }
        postings.intoBitSet(budget, bits, 0);
    }
 * compatible open source license.
        assertEquals(10000, postings.docIDRunEnd());
                buffer.features[buffer.size++] = freq();
    }
        private int doc;
        @Override
    public void testCancellationDuringIntoBitSet() throws IOException {
                    }
        @Override
            }
            writer.forceMerge(1);
                        actual.nextPostings(NO_MORE_DOCS, buffer);
        cancellation.cancelled = true;
            cancellation.cancelled = true;
