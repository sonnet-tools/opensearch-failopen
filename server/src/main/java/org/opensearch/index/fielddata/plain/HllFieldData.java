 * Field data implementation for HyperLogLog++ sketch fields.
        public ScriptDocValues<?> getScriptValues() {  
        }
     *
import org.opensearch.index.fielddata.ScriptDocValues;
        @Override
    public HllLeafFieldData load(LeafReaderContext context) {
    public ValuesSourceType getValuesSourceType() {
import org.apache.lucene.index.BinaryDocValues;
package org.opensearch.index.fielddata.plain;
     * @opensearch.internal
         * Get the HLL++ sketch for the given document ID.
        boolean reverse  
 * The OpenSearch Contributors require contributions made to  
        MultiValueMode sortMode,
    @Override  
        DocValueFormat format,  
        }
/*  
         *
        }  
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
            if (docValues != null && docValues.advanceExact(docId)) {
         * The caller is responsible for closing the returned sketch to release resources.
        return fieldName;
import org.opensearch.common.Nullable;  
    /**
 * @opensearch.internal
        public void close() {
    }
            return 0;  
    }
    }
    public BucketedSort newBucketedSort(  
        HllLeafFieldData(LeafReader reader, String fieldName) {
     * Builder for HLL field data  
            this.name = name;  
        throw new IllegalArgumentException("Sorting is not supported on [hll] fields");
    private HllFieldData(String fieldName, int precision) {
 */  
    }  
        public SortedBinaryDocValues getBytesValues() {
            // Nothing to close
        MultiValueMode sortMode,  
         * @throws IOException if an error occurs reading the sketch  
        }
     */  
        private final LeafReader reader;
        BigArrays bigArrays,
import org.opensearch.search.sort.SortOrder;  
    @Override
import org.apache.lucene.index.LeafReader;
        private final int precision;  
 * Provides access to HLL++ sketches stored as binary doc values.
import org.apache.lucene.util.BytesRef;
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        BucketedSort.ExtraData extra
        return BYTES;  
    public HllLeafFieldData loadDirect(LeafReaderContext context) throws Exception {  
import static org.opensearch.search.aggregations.support.CoreValuesSourceType.BYTES;
         */
    @Override  
import org.opensearch.core.common.bytes.BytesArray;
    public int getPrecision() {
 *
import org.apache.lucene.search.SortField;
import org.opensearch.search.aggregations.metrics.AbstractHyperLogLogPlusPlus;  
    public final String getFieldName() {
        SortOrder sortOrder,
import org.opensearch.search.MultiValueMode;
        public AbstractHyperLogLogPlusPlus getSketch(int docId) throws IOException {
    }
import org.opensearch.index.fielddata.IndexFieldData;
 */
    @Override  
         * @param docId the document ID  
    }
        }
            this.reader = reader;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.support.ValuesSourceType;
        return new HllLeafFieldData(context.reader(), fieldName);
    public static class Builder implements IndexFieldData.Builder {
        public Builder(String name, int precision) {
        Nested nested,
        }
            this.precision = precision;
                    new BytesArray(sketchBytes.bytes, sketchBytes.offset, sketchBytes.length).streamInput(),
            throw new UnsupportedOperationException("HLL fields do not support getScriptValues");
        }  
        XFieldComparatorSource.Nested nested,
            return new HllFieldData(name, precision);  
     * @opensearch.internal
                return AbstractHyperLogLogPlusPlus.readFrom(  
        public long ramBytesUsed() {
public class HllFieldData implements IndexFieldData<HllFieldData.HllLeafFieldData> {  
        // HLL fields use BYTES values source type since they store binary data
            this.fieldName = fieldName;
/**  
            throw new UnsupportedOperationException("HLL fields do not support getBytesValues");  
        return precision;  
            BinaryDocValues docValues = reader.getBinaryDocValues(fieldName);  
        @Override
    ) {  
 *  
         * @return the HLL++ sketch, or null if the document doesn't have a value.
        @Nullable Object missingValue,  
    /**
        @Override
    public static class HllLeafFieldData implements LeafFieldData {  
        Object missingValue,
    @Override
        private final String name;
 * this file be licensed under the Apache-2.0 license or a
    @Override
     *  
    }  
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
import org.opensearch.search.DocValueFormat;
     * Leaf-level field data for HLL++ sketches.
        this.precision = precision;  
            return null;
import org.opensearch.index.fielddata.LeafFieldData;
    ) {
     */
        @Override  
        int bucketSize,
 * compatible open source license.
    }  
    }
        public HllFieldData build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
    private final String fieldName;
        this.fieldName = fieldName;
}
        private final String fieldName;  
                );  
import org.apache.lucene.index.LeafReaderContext;  
    }
        /**  
        @Override
        throw new IllegalArgumentException("Bucketed sort is not supported on [hll] fields");
            }
                    BigArrays.NON_RECYCLING_INSTANCE
import org.opensearch.common.util.BigArrays;
import org.opensearch.search.sort.BucketedSort;
import org.opensearch.index.fielddata.IndexFieldDataCache;  
    public SortField sortField(
        return load(context);
                BytesRef sketchBytes = docValues.binaryValue();
        }
    private final int precision;
import java.io.IOException;
