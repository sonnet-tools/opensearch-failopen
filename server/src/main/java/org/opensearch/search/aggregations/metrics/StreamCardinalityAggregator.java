            streamCollector = new OrdinalsCollector(counts, ordinalValues, context.bigArrays());  
        if (counts != null) {  
 *
            streamCollector.close();
package org.opensearch.search.aggregations.metrics;
    }  
        ValuesSourceConfig valuesSourceConfig,  
 * A streaming aggregator that computes approximate counts of unique values.
        Map<String, Object> metadata,
 * compatible open source license.
    @Override  
import org.opensearch.search.internal.SearchContext;
import java.util.Map;
        // HyperLogLog doesn't have a public reset method, so we need to recreate it
                streamCollector.postCollect();  
    @Override  
        }
            counts = valuesSource == null ? null : new HyperLogLogPlusPlus(precision, context.bigArrays(), 1);
        // Handle ordinal value sources - always use OrdinalsCollector
    protected void doPostCollection() throws IOException {
        }  
            streamCollector = null;
            emptyCollectorsUsed++;  
            }
        super.doReset();
    private Collector streamCollector;
        final long maxOrd = ordinalValues.getValueCount();  
 */
    @Override  
        if (streamCollector != null) {
        CardinalityAggregatorFactory.ExecutionMode executionMode
            streamCollector = new EmptyCollector();
import org.opensearch.search.aggregations.Aggregator;  
            streamCollector = new EmptyCollector();  
                streamCollector = null;  
        if (valuesSource == null) {
                streamCollector.close();
import org.apache.lucene.index.LeafReaderContext;
        if (maxOrd == 0) {
        Aggregator parent,  
import java.util.function.BiConsumer;
 * SPDX-License-Identifier: Apache-2.0
            emptyCollectorsUsed++;
            throw new IllegalStateException("StreamCardinalityAggregator only supports ordinal value sources");
        // Handle null values source
public class StreamCardinalityAggregator extends CardinalityAggregator {  
        String name,
    }
    }  
 */  
import java.io.IOException;  
 *  
                streamCollector.postCollect();
 * The OpenSearch Contributors require contributions made to  
            }
        }  
    public void collectDebugInfo(BiConsumer<String, Object> add) {
        if (streamCollector != null) {  
        }
            streamCollector = null;
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
import org.opensearch.search.aggregations.LeafBucketCollector;
        int precision,
    public void doReset() {  
/**
            try {
            ordinalsCollectorsUsed++;
        final SortedSetDocValues ordinalValues = ((ValuesSource.Bytes.WithOrdinals) valuesSource).ordinalsValues(ctx);
        if (!(valuesSource instanceof ValuesSource.Bytes.WithOrdinals)) {  
            streamCollector.close();
        super(name, valuesSourceConfig, precision, context, parent, metadata, executionMode);
                streamCollector = null;
        // Close and recreate the HyperLogLog counts for the next batch
        // Clean up the stream collector for the next batch
    @Override
        return streamCollector;
/*  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
        if (streamCollector != null) {  
    }
        if (streamCollector != null) {
 * @opensearch.internal
        } else {
            } finally {
        // Only support ordinal value sources for streaming
    public StreamCardinalityAggregator(
    @Override
    protected void doClose() {
        }  
    }
                streamCollector.close();  
            counts.close();
    }
            try {  
        // Clean up previous collector if it exists  
    ) throws IOException {  
        }  
        SearchContext context,
 * this file be licensed under the Apache-2.0 license or a
        }
}
            } finally {
        super.collectDebugInfo(add);
        }  
        super.doClose();
import org.opensearch.search.aggregations.support.ValuesSource;
import org.apache.lucene.index.SortedSetDocValues;
            return streamCollector;
