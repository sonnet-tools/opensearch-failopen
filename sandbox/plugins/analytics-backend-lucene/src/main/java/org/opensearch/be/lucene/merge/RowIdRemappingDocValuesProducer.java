        public long nextValue() throws IOException {  
        public long cost() {
                // TODO check how this will work for primary engine when rowIdMapping will be null.
    private final long generation;  
     * @param delegate     the original doc values producer
 */  
        }
            return delegate.docValueCount();
 * SPDX-License-Identifier: Apache-2.0
        @Override
        return delegate.getSortedNumeric(field);
package org.opensearch.be.lucene.merge;
/*  
        this.rowIdMapping = rowIdMapping;
        @Override
/**  
import org.opensearch.index.engine.dataformat.RowIdMapping;
    }
    @Override
 * global row IDs (0..n-1) rather than the original per-segment local values.  
     * @param maxDoc       the maximum document count in the source segment
            }  
    @Override
    @Override  
    public DocValuesSkipper getSkipper(FieldInfo field) throws IOException {  
            if (rowIdMapping != null) {  
        private final long generation;  
        this.generation = generation;
 * {@link DocValuesProducer} that intercepts the {@code ___row_id} field and returns
        this.rowIdOffset = rowIdOffset;
        private final RowIdMapping rowIdMapping;
     * Reads the original {@code ___row_id} and maps it through the {@link RowIdMapping}.  
import org.apache.lucene.index.DocValuesSkipper;  
 * <p>This ensures the merged segment's {@code ___row_id} doc values contain the new
    public SortedDocValues getSorted(FieldInfo field) throws IOException {
        }  
        }  
    private static class MappedRowIdDocValues extends SortedNumericDocValues {
            this.generation = generation;
    @Override  
        @Override
    /**
 * this file be licensed under the Apache-2.0 license or a
    }  
    @Override
        delegate.close();
 * compatible open source license.
    }  
import org.opensearch.index.engine.dataformat.DocumentInput;
    public NumericDocValues getNumeric(FieldInfo field) throws IOException {
 * The OpenSearch Contributors require contributions made to  
        public int nextDoc() throws IOException {  
import org.apache.lucene.index.NumericDocValues;
        this.maxDoc = maxDoc;  
    RowIdRemappingDocValuesProducer(DocValuesProducer delegate, RowIdMapping rowIdMapping, long generation, int maxDoc, int rowIdOffset) {
    @Override  
    @Override
            long oldRowId = delegate.nextValue();
        @Override  
            return delegate.cost();
                throw new UnsupportedOperationException("Lucene as Primary Format is not supported yet");
    }
                return new MappedRowIdDocValues(delegate.getSortedNumeric(field), rowIdMapping, generation);
    private final RowIdMapping rowIdMapping;
    public void close() throws IOException {
    public BinaryDocValues getBinary(FieldInfo field) throws IOException {  
        public boolean advanceExact(int target) throws IOException {
 *
                // https://github.com/opensearch-project/OpenSearch/issues/21508  
@ExperimentalApi
        return delegate.getSortedSet(field);
    }
        MappedRowIdDocValues(SortedNumericDocValues delegate, RowIdMapping rowIdMapping, long generation) {
import org.apache.lucene.codecs.DocValuesProducer;
 * remapped row ID values from a {@link RowIdMapping}. All other fields are delegated
    /**
     */
    private final DocValuesProducer delegate;
     */
 */  
 * @opensearch.experimental
     * @param rowIdOffset  the starting row ID offset for sequential assignment (used when rowIdMapping is null)  
 *
    private final int rowIdOffset;
 *
    public SortedNumericDocValues getSortedNumeric(FieldInfo field) throws IOException {
import org.apache.lucene.index.FieldInfo;
        }
        @Override  
 * unchanged to the wrapped producer.  
        }  
        return delegate.getSkipper(field);
            return delegate.docID();
        private final SortedNumericDocValues delegate;
    }
        }  
        }
            this.rowIdMapping = rowIdMapping;
        }
class RowIdRemappingDocValuesProducer extends DocValuesProducer {
}
        public int advance(int target) throws IOException {
    private final int maxDoc;
    @Override
        if (DocumentInput.ROW_ID_FIELD.equals(field.name)) {
        @Override
import org.apache.lucene.index.BinaryDocValues;
        }
        return delegate.getNumeric(field);  
            return delegate.advanceExact(target);  
            return delegate.nextDoc();
        this.delegate = delegate;  
import org.apache.lucene.index.SortedDocValues;  
        public int docValueCount() {  
import java.io.IOException;
        return delegate.getSorted(field);  
    }
        delegate.checkIntegrity();  
    public void checkIntegrity() throws IOException {
        @Override
            return delegate.advance(target);  
     * @param generation   the writer generation of the source segment
     * @param rowIdMapping the mapping from old to new row IDs, or null for sequential assignment  
import org.opensearch.common.annotation.ExperimentalApi;  
import org.apache.lucene.index.SortedNumericDocValues;
        public int docID() {
            return rowIdMapping.getNewRowId(oldRowId, generation);
    }
            this.delegate = delegate;  
import org.apache.lucene.index.SortedSetDocValues;
    }
            } else {
    public SortedSetDocValues getSortedSet(FieldInfo field) throws IOException {
        return delegate.getBinary(field);
    }  
