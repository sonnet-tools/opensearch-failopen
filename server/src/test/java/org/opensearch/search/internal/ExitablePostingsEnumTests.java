 * SPDX-License-Identifier: Apache-2.0
        delegate.afterBulk = () -> cancellation.cancelled = true;
        }  
        private final int end;  
     * call must check cancellation before consuming any more postings.
        public void checkCancelled() {
        }
                LeafReader leaf = reader.leaves().getFirst().reader();  
                throw new TaskCancelledException("cancelled");
            try (DirectoryReader reader = DirectoryReader.open(writer)) {
        for (int doc = 2; doc <= 8192; doc++) {
        private final int batchSize;
            maxBitSetSpan = Math.max(maxBitSetSpan, upTo - doc);
            cancellation.cancelled = true;
                    assertEquals(next >= 30000 ? NO_MORE_DOCS : next, postings.docID());
                    assertEquals(expected, bits);  
        postings.intoBitSet(budget + 200, bits, 0);
    public void testCancellationBetweenBitSetCalls() throws IOException {
                expected.set(30001 - offset);
import org.apache.lucene.util.BytesRef;
            return 1 + doc % 3;  
        }  
    /**  
    private static class Cancellation implements ExitableDirectoryReader.QueryCancellation {  
import org.apache.lucene.store.Directory;
                    Term term = new Term("field", text);
                int first = NO_MORE_DOCS - 30000;
    /** Computing a cancellation chunk's endpoint must not overflow near Lucene's end-of-iteration sentinel. */
        }
        postings.intoBitSet(1000, bits, 0);
 */  
                    for (int doc = 37; doc < Math.min(upTo, 30000); doc += step) {  
            }  
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 30000, 1, 256);
        assertEquals(256, buffer.size);
    public void testNextPostingsPreservesDocsFrequenciesAndCursor() throws IOException {  
                buffer.docs[buffer.size] = doc;
                assertEquals(0, delegate.scalarCalls);
        assertEquals(1 << 20, postings.docID());
                    DocAndFloatFeatureBuffer buffer = new DocAndFloatFeatureBuffer();
import org.apache.lucene.document.Field;
    /** Run metadata must reach Lucene unchanged without advancing the postings cursor. */
import org.apache.lucene.index.PostingsEnum;
                            assertTrue(expected < upTo);  
        assertEquals(1, cancellation.checks);  
                        assertTrue(buffer.size <= batchSize);
    }  
        public BytesRef getPayload() {
        }
    /**
        assertEquals(NO_MORE_DOCS, postings.docID());
        }
    }
            return doc = next >= end ? NO_MORE_DOCS : (int) next;  
        int batchCalls;
 * compatible open source license.
                    }
        cancellation.cancelled = true;
            assertEquals(expected, postings.docID());  
            bitSetCalls++;
    public void testCodecPostings() throws IOException {  
        @Override
            buffer.growNoCopy(batchSize);
                    }  
                        assertEquals(expected.docID(), actual.docID());
    public void testIntoBitSetNearNoMoreDocs() throws IOException {  
    public void testScalarSampling() throws IOException {
                Document document = new Document();  
        assertEquals(8192, delegate.scalarCalls);
        }  
        @Override  
        assertEquals(2, delegate.scalarCalls);  
        assertEquals(2550000, buffer.docs[255]);
    }
                            assertEquals(expected.freq(), buffer.features[i], 0);
        PostingsEnum postings = wrap(delegate, cancellation);
        BulkPostingsEnum delegate = new BulkPostingsEnum(first, NO_MORE_DOCS, 1, 256);
                assertTrue(delegate.maxBitSetSpan <= 1 << 20);  
        assertTrue(delegate.maxBitSetSpan <= 1 << 20);
                    int next = 37 + Math.max(0, (Math.min(upTo, 30000) - 37 + step - 1) / step) * step;
            for (int i = 0; i < 20000; i++) {
        int first = NO_MORE_DOCS - 20000;
    private static class BulkPostingsEnum extends PostingsEnum {
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;  
            DocAndFloatFeatureBuffer buffer = new DocAndFloatFeatureBuffer();  
        FixedBitSet bits = new FixedBitSet(20000);  
        assertEquals(1, cancellation.checks);  
        public int endOffset() {
    private static PostingsEnum wrap(PostingsEnum delegate, Cancellation cancellation) {
                FixedBitSet expected = new FixedBitSet(bits.length());
            buffer.size = 0;
        @Override  
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 30000, 1, 256);  
            this.step = step;  
                        assertTrue(bits.getAndClear(doc));
            scalarCalls++;
            assertEquals(doc, doc % 2 == 0 ? postings.advance(doc) : postings.nextDoc());
                buffer.features[buffer.size++] = freq();
        PostingsEnum postings = wrap(delegate, cancellation);
        assertEquals(1, cancellation.checks);
                BulkPostingsEnum delegate = new BulkPostingsEnum(37, 30000, step, 256);
            assertEquals(1, cancellation.checks);  
                        expected.set(doc - offset);
                bits.set(doc - offset);
        BulkPostingsEnum(int first, int end, int step, int batchSize) {  
                int expected = first;
        assertEquals(37, postings.docID());  
    /** Cancellation after the first chunk must stop a large bitset fill before the second chunk begins. */  
        assertEquals(1, postings.nextDoc());
            return step == 1 ? end : doc + 1;
        }
    public void testIntoBitSetPreservesDocsAndCursor() throws IOException {
                    postings.intoBitSet(upTo, bits, offset);
        assertEquals(10000, postings.docIDRunEnd());
                for (int upTo : new int[] { 37, 38, 20000, 30000, NO_MORE_DOCS }) {
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 5_000_000, 1, 256);
    }  
        public void nextPostings(int upTo, DocAndFloatFeatureBuffer buffer) {
    /** Already positioned postings with observable bulk methods, independent of a codec's block layout. */  
    public void testSparseNextPostingsPreservesBatchSize() throws IOException {
    }
        assertEquals(0, delegate.bitSetCalls);  
            return true;  
        PostingsEnum postings = wrap(delegate, new Cancellation());
     */  
    }
        PostingsEnum postings = wrap(delegate, cancellation);  
                        }
            }
        assertEquals(1, postings.nextDoc());
        public int docID() {  
        Cancellation cancellation = new Cancellation();
        while (postings.docID() < 8192) {
}
        @Override  
        int scalarCalls;  
        assertEquals(1, cancellation.checks);
            while (postings.docID() < 8192) {
            scalarCalls++;  
        assertEquals(2, cancellation.checks);  
            expectThrows(TaskCancelledException.class, () -> postings.nextPostings(NO_MORE_DOCS, buffer));
            this.batchSize = batchSize;
        public boolean isEnabled() {
        PostingsEnum postings = wrap(delegate, cancellation);
                PostingsEnum postings = wrap(delegate, new Cancellation());  
        }
            }
            assertEquals(expected, postings.docID());  
                bits.set(40 - offset);
                    assertEquals(expected.docIDRunEnd(), actual.docIDRunEnd());  
            }
    /** An already-cancelled query must stop before entering either codec bulk operation. */
        public int nextDoc() {
        @Override
                for (int upTo : new int[] { first, first + 10000, NO_MORE_DOCS }) {  
                assertTrue(delegate.bitSetCalls > 0);
        postings.nextPostings(NO_MORE_DOCS, new DocAndFloatFeatureBuffer());
            long next = doc + ((long) target - doc + step - 1) / step * step;
        postings.intoBitSet(NO_MORE_DOCS, bits, first);
                writer.addDocument(document);
                bits.set(30001 - offset);
        expectThrows(TaskCancelledException.class, postings::nextDoc);  
            afterBulk.run();
                        assertTrue(buffer.size > 0);  
 * The OpenSearch Contributors require contributions made to  
        expectThrows(TaskCancelledException.class, () -> postings.nextPostings(NO_MORE_DOCS, new DocAndFloatFeatureBuffer()));
                move();  
                FixedBitSet bits = new FixedBitSet(30002 - offset);  
            writer.forceMerge(1);
        private void move() {
            for (int offset : new int[] { -11, 23 }) {  
import org.apache.lucene.index.Term;
        postings.nextPostings(NO_MORE_DOCS, buffer);  
                }
        @Override
        assertEquals(1, delegate.batchCalls);
        assertEquals(0, delegate.batchCalls);
                }
                BulkPostingsEnum delegate = new BulkPostingsEnum(first, NO_MORE_DOCS, step, batchSize);
                    buffer.size = 7;
        for (int batchSize : new int[] { 16, 256, 20000 }) {
    /**  
    public void testMixedScalarAndBatchCancellation() throws IOException {
            doc = (long) doc + step >= end ? NO_MORE_DOCS : doc + step;
                    postings.nextPostings(upTo, buffer);
                }  
     */  
                assertEquals(0, delegate.scalarCalls);
        assertEquals(20000, bits.cardinality());  
        @Override
            return doc;
        // The final native batch may overshoot the remaining budget.
                    actual.intoBitSet(13000, bits, 0);  
        private final int step;
            while (doc < upTo && buffer.size < batchSize) {  
        assertEquals(1 << 20, bits.cardinality());  
        assertEquals(258, postings.docID());
import org.opensearch.test.OpenSearchTestCase;
                    }  
            }
    public void testCancellationDuringIntoBitSet() throws IOException {
     * Native batches must preserve document IDs, frequencies, exclusive bounds, and cursor position  
            move();
                    assertEquals(expected.freq(), actual.freq());  
            postings.nextPostings(NO_MORE_DOCS, new DocAndFloatFeatureBuffer());
        assertEquals(0, postings.docID());
import org.apache.lucene.document.TextField;  
                PostingsEnum postings = wrap(delegate, new Cancellation());
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 30000, 1, 256);  
        int bitSetCalls;
import org.apache.lucene.index.DirectoryReader;
                        postings.nextPostings(upTo, buffer);
                    }  
        cancellation.cancelled = true;
        FixedBitSet bits = new FixedBitSet(3000000);  
                document.add(new TextField("field", i % 17 == 0 ? "a a a b b" : "a a", Field.Store.NO));
     * for dense and sparse postings, including near the end-of-iteration sentinel.
            }
        @Override
            for (int batchSize : new int[] { 16, 256, 20000 }) {  
                            assertEquals(expected, buffer.docs[i]);
    /** Scalar and batch operations must share a sampling budget so switching APIs cannot postpone cancellation. */  
                    FixedBitSet bits = new FixedBitSet(20000);
        }  
    }
        boolean cancelled;
                    assertEquals(expected, postings.docID());
            while (doc < upTo) {  
    }
     * on the first unconsumed document while using the delegate's bulk implementation.
        }  
        }
                            assertEquals(expected.docID(), buffer.docs[i]);
        for (int step : new int[] { 1, 17, 10000 }) {
                    assertEquals(0, bits.cardinality());
    /** Preserve the first-call check and 8192-call interval across interleaved nextDoc and advance operations. */  
            if (cancelled) {  
import org.apache.lucene.index.LeafReader;  
        public int freq() {
    public void testNextPostingsSamplesByWork() throws IOException {
        @Override
        PostingsEnum postings = wrap(delegate, new Cancellation());
        assertEquals(0, delegate.scalarCalls);  
            Cancellation cancellation = new Cancellation();  
        PostingsEnum postings = wrap(delegate, cancellation);
        }
                    for (int doc = expected.docID(); doc < 13000; doc = expected.nextDoc()) {
        expectThrows(TaskCancelledException.class, postings::nextDoc);
        }  
            return end / step;
        assertEquals(0, delegate.scalarCalls);
    }  
import org.apache.lucene.util.FixedBitSet;  
        try (Directory directory = newDirectory(); IndexWriter writer = new IndexWriter(directory, newIndexWriterConfig())) {
            PostingsEnum postings = wrap(delegate, cancellation);
        PostingsEnum postings = wrap(delegate, new Cancellation());
        int maxBitSetSpan;  
        @Override
        }  
                move();
    }
            return doc;
        public int docIDRunEnd() {
                    while (actual.docID() != NO_MORE_DOCS) {  
            BulkPostingsEnum delegate = new BulkPostingsEnum(0, 30000, 1, batchSize);
        }  
        FixedBitSet bits = new FixedBitSet(5_000_000);  
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 10000000, 10000, 256);  
        assertEquals(8192, postings.docID());  
        }
            batchCalls++;  
                for (String text : new String[] { "a", "b" }) {
                postings.nextPostings(NO_MORE_DOCS, buffer);
import org.opensearch.core.tasks.TaskCancelledException;
        }
            return -1;
        cancellation.cancelled = true;  
    /** Even short bitset fills must check cancellation at the next call, regardless of the scalar sampling counter. */  
            return null;
        assertEquals(2560000, postings.docID());  
                    assertEquals(expected.nextDoc(), actual.nextDoc());
    }
                    PostingsEnum actual = wrap(leaf.postings(term, PostingsEnum.FREQS), new Cancellation());
            }  
        assertEquals(0, delegate.scalarCalls);
        Runnable afterBulk = () -> {};
 * this file be licensed under the Apache-2.0 license or a
        public void intoBitSet(int upTo, FixedBitSet bits, int offset) {  
                        }
        public int nextPosition() {
        @Override
import org.apache.lucene.index.IndexWriter;
        int checks;
        postings.intoBitSet(budget, bits, 0);
        public int advance(int target) {  
        for (int step : new int[] { 1, 17 }) {
            return -1;
    public void testDocIDRunEndDelegates() throws IOException {
        }  
     */
                            expected.nextDoc();  
        Cancellation cancellation = new Cancellation();  
    }
                        for (int i = 0; i < buffer.size; i++) {
                assertEquals(1, cancellation.checks);  
        DocAndFloatFeatureBuffer buffer = new DocAndFloatFeatureBuffer();
        private int doc;
            checks++;
        }
            int expected = Math.max(8192, batchSize);
                        assertTrue(buffer.size > 0);
        assertEquals(1, delegate.bitSetCalls);
    }  
    /** Compare wrapped and raw codec postings across bitset and batch operations on both dense and sparse terms. */
        Cancellation cancellation = new Cancellation();
                        actual.nextPostings(NO_MORE_DOCS, buffer);
        assertEquals(2, cancellation.checks);
import org.apache.lucene.document.Document;
        }  
        assertEquals(2, postings.advance(2));  
        BulkPostingsEnum delegate = new BulkPostingsEnum(37, 10000, 1, 256);  
        }
        expectThrows(TaskCancelledException.class, () -> postings.intoBitSet(NO_MORE_DOCS, bits, 0));
     * Sampling counts returned postings. A native batch may overshoot the budget, but the following
                    assertEquals(expected.docID(), actual.docID());
/*  
        @Override
        assertEquals(8194, postings.docID());
        return new ExitableDirectoryReader.ExitablePostingsEnum(delegate, cancellation);  
            afterBulk.run();
    public void testCancelledBeforeBulkWork() throws IOException {
            this.end = end;
                DocAndFloatFeatureBuffer buffer = new DocAndFloatFeatureBuffer();
                        for (int i = 0; i < buffer.size; i++) {  
        Cancellation cancellation = new Cancellation();  
        expectThrows(TaskCancelledException.class, () -> postings.intoBitSet(NO_MORE_DOCS, new FixedBitSet(30000), 0));
                            expected = (long) expected + step >= NO_MORE_DOCS ? NO_MORE_DOCS : expected + step;  
        public long cost() {  
     * Bulk fills must honor offsets and exclusive bounds, retain existing bits, and leave the cursor
                assertTrue(delegate.batchCalls > 0);  
                    PostingsEnum expected = leaf.postings(term, PostingsEnum.FREQS);  
                    assertEquals(0, buffer.size);  
        postings.intoBitSet(budget + 100, bits, 0);  
            return -1;  
 *
            }
                    while (expected < upTo) {
            // Include a custom codec whose batches are larger than the cancellation interval.
        @Override  
public class ExitablePostingsEnumTests extends OpenSearchTestCase {
        Cancellation cancellation = new Cancellation();
                            assertEquals(1 + expected % 3, buffer.features[i], 0);
import org.apache.lucene.search.DocAndFloatFeatureBuffer;  
        final int budget = 1 << 20; // MAX_DOCS_PER_BITSET_CHECK
        @Override
    /** Bounding batches by document-ID distance would fragment sparse postings and lose native batching. */
                        assertEquals(expected, postings.docID());
    }
        public int startOffset() {  
import java.io.IOException;
        BulkPostingsEnum delegate = new BulkPostingsEnum(0, 3000000, 1, 256);  
                expected.set(40 - offset);  
            this.doc = first;
package org.opensearch.search.internal;
    }
