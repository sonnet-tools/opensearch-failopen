        @Override  
import org.opensearch.common.annotation.ExperimentalApi;
     * {@link SortedNumericDocValues} that returns sequential values where each doc's
        super(delegate.getName());  
 * This allows the reorder merge and the row ID rewrite to happen in a single pass during
            delegate.addNumericField(field, valuesProducer);  
            this.maxDoc = maxDoc;  
            return null;  
            return ++docID < maxDoc ? docID : NO_MORE_DOCS;
 *
        }
import org.apache.lucene.index.FieldInfo;  
        }
            return null;  
import java.io.IOException;  
        public NumericDocValues getNumeric(FieldInfo field) {  
        public boolean advanceExact(int target) {
        private final int maxDoc;  
        @Override
     * {@code ___row_id} field and replaces the values with sequential 0..maxDoc.  
import org.apache.lucene.index.SortedDocValues;
            docID = target;
        @Override  
        }  
    }  
        SequentialRowIdDocValues(int maxDoc) {
 * {@link LuceneWriter#flush}, ensuring that after a sorted merge the Lucene doc IDs align
}  
import org.apache.lucene.codecs.DocValuesProducer;  
        public void addSortedSetField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
            return null;
    static class SequentialRowIdProducer extends DocValuesProducer {
     */  
            return docID < maxDoc ? docID : NO_MORE_DOCS;
 */  
        @Override
        }
            this.maxDoc = maxDoc;
            }
        }
     * @param delegate the underlying doc values format to delegate operations to  
        public void addSortedNumericField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
import org.apache.lucene.index.DocValuesSkipper;
        @Override  
     * row ID equals its doc ID (0, 1, 2, ...).  
        @Override  
        }  
        public long cost() {
            return maxDoc;  
 * is enabled. All other fields are delegated unchanged to the underlying format.
    /**
    }  
        @Override
import org.apache.lucene.index.SegmentReadState;
    public DocValuesConsumer fieldsConsumer(SegmentWriteState state) throws IOException {  
            return null;
        }
        return new RowIdRewritingDocValuesConsumer(delegateConsumer, state);
        @Override  
        }
        }
        public BinaryDocValues getBinary(FieldInfo field) {
            return docID;
 * <p>  
        private final DocValuesConsumer delegate;
    }
            this.delegate = delegate;  
        }
        }  
        }
        private int docID = -1;
        }
        }  
        public DocValuesSkipper getSkipper(FieldInfo field) {
    private static final String ROW_ID = LuceneDocumentInput.ROW_ID_FIELD;
        @Override  
            return true;  
 * this file be licensed under the Apache-2.0 license or a
        @Override
        DocValuesConsumer delegateConsumer = delegate.fieldsConsumer(state);
 * The OpenSearch Contributors require contributions made to  
        public void close() {}
     * Returns the delegate format.
     * for the {@code ___row_id} sorted numeric field.
 * SPDX-License-Identifier: Apache-2.0
/**
        @Override
    static class RowIdRewritingDocValuesConsumer extends DocValuesConsumer {  
        @Override  
        public SortedDocValues getSorted(FieldInfo field) {
        }
    @Override
import org.apache.lucene.index.SegmentWriteState;  
        }
 * compatible open source license.
import org.apache.lucene.index.NumericDocValues;
            if (ROW_ID.equals(field.name)) {  
    /**
import org.apache.lucene.codecs.DocValuesFormat;
        RowIdRewritingDocValuesConsumer(DocValuesConsumer delegate, SegmentWriteState state) {
        @Override
    /**
        @Override
            return null;
            delegate.addBinaryField(field, valuesProducer);
        public void close() throws IOException {
            return 1;  
import org.apache.lucene.index.SortedSetDocValues;  
 * {@code ___row_id} field and replaces the values with sequential 0..N when row ID rewriting
    public DocValuesProducer fieldsProducer(SegmentReadState state) throws IOException {  
            delegate.addSortedField(field, valuesProducer);
        return delegate;
    DocValuesFormat getDelegate() {
        @Override
     * A {@link DocValuesProducer} that produces sequential row IDs (0, 1, 2, ..., maxDoc-1)
        public int docID() {
import org.apache.lucene.codecs.DocValuesConsumer;
     * Creates a new doc values format that wraps the given delegate and rewrites  
    }
        public long nextValue() {  
        }
    public LuceneWriterDocValuesFormat(DocValuesFormat delegate) {
        public void addBinaryField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
        @Override
import org.apache.lucene.index.SortedNumericDocValues;
        public int advance(int target) {
            delegate.addSortedSetField(field, valuesProducer);  
        public void checkIntegrity() {}
    /**
        this.delegate = delegate;
        public void addNumericField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
@ExperimentalApi
        @Override
        public int nextDoc() {  
    @Override
     * All other fields are passed through to the delegate consumer unchanged.
        }
        private final int maxDoc;
/*  
        @Override
        public SortedSetDocValues getSortedSet(FieldInfo field) {  
    private final DocValuesFormat delegate;  
            return docID;
        private final SegmentWriteState state;  
            delegate.close();
    }
        public void addSortedField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {  
            docID = target;  
package org.opensearch.be.lucene.index;
        @Override  
     * the {@code ___row_id} field with sequential values.
                delegate.addSortedNumericField(field, new SequentialRowIdProducer(state.segmentInfo.maxDoc()));
        @Override
            return new SequentialRowIdDocValues(maxDoc);
    }
        public SortedNumericDocValues getSortedNumeric(FieldInfo field) {
     *
        }  
 * with the new sequential row IDs.  
public class LuceneWriterDocValuesFormat extends DocValuesFormat {
    /**  
        SequentialRowIdProducer(int maxDoc) {
     */
     */
 *
import org.apache.lucene.index.BinaryDocValues;
 * A {@link DocValuesFormat} used by {@link LuceneWriterCodec} that intercepts writes to the  
    }
 * @opensearch.experimental
        @Override
 */  
            } else {
        }
     * A {@link DocValuesConsumer} that intercepts {@code addSortedNumericField} for the
        }
     */  
        public int docValueCount() {
        }  
                delegate.addSortedNumericField(field, valuesProducer);  
            this.state = state;
        return delegate.fieldsProducer(state);
     */
    static class SequentialRowIdDocValues extends SortedNumericDocValues {
