}  
import org.opensearch.search.aggregations.InternalAggregation;
import java.util.Map;
                        if (bucket >= counts.maxOrd()) {  
                                if (counts.cardinality(i) > 0) {  
 */
    }
    @Override
import org.apache.logging.log4j.LogManager;
        String name,  
                    if (sketch != null) {
        return new InternalCardinality(name, null, metadata());
                        sketch.close();
        Map<String, Object> metadata
import org.opensearch.search.aggregations.LeafBucketCollector;  
                        e.getMessage()
        this.counts = null; // Lazy initialization
 * This aggregator merges HLL++ sketches stored in documents to produce a combined cardinality estimate.
        int precision,
        }
import org.apache.logging.log4j.Logger;
                }  
 * compatible open source license.
                            counts = newCounts;
    ) throws IOException {  
        Releasables.close(counts);
 *
    private static final Logger logger = LogManager.getLogger(HllCardinalityAggregator.class);
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
    public InternalAggregation buildAggregation(long owningBucketOrdinal) {
 * An aggregator that computes cardinality from pre-aggregated HLL++ sketch fields.
        HllFieldData fieldData,
    public double metric(long owningBucketOrd) {  
                    logger.warn(
    protected void doClose() {  
        // Build a copy because the returned Aggregation needs to remain usable after  
                        doc,
                        "Failed to merge HLL++ sketch for field [{}] in document {}: {}",
        super(name, context, parent, metadata);
        final HllFieldData.HllLeafFieldData leafData = fieldData.load(ctx);
        if (counts == null || owningBucketOrdinal >= counts.maxOrd() || counts.cardinality(owningBucketOrdinal) == 0) {  
                        counts.merge(bucket, sketch, 0);  
    @Override  
                        }  
    public org.apache.lucene.search.ScoreMode scoreMode() {
        // this Aggregator (and its HLL++ counters) is released
import org.opensearch.search.internal.SearchContext;
                        if (counts == null) {
                } finally {
    private HyperLogLogPlusPlus counts;  
        SearchContext context,  
        AbstractHyperLogLogPlusPlus copy = counts.clone(owningBucketOrdinal, BigArrays.NON_RECYCLING_INSTANCE);
import org.apache.lucene.index.LeafReaderContext;  
    private final HllFieldData fieldData;
public class HllCardinalityAggregator extends NumericMetricsAggregator.SingleValue {  
                    sketch = leafData.getSketch(doc);  
        Aggregator parent,
    public InternalAggregation buildEmptyAggregation() {
        this.precision = precision;  
 */  
import org.opensearch.common.lease.Releasables;
import java.io.IOException;  
    @Override  
            }
 *  
 * SPDX-License-Identifier: Apache-2.0
                            }  
import org.opensearch.search.aggregations.Aggregator;
            public void collect(int doc, long bucket) throws IOException {  
    }
                    // Log precision mismatch or other merge errors  
package org.opensearch.search.aggregations.metrics;
 * @opensearch.internal
                        fieldData.getFieldName(),  
                                }
                        // Lazy initialize counts on first sketch
                        // Grow if needed to accommodate this bucket
 * The OpenSearch Contributors require contributions made to  
                            HyperLogLogPlusPlus newCounts = new HyperLogLogPlusPlus(precision, context.bigArrays(), bucket + 1);
import org.opensearch.common.util.BigArrays;
                        }  
    @Override
                        // Initialize with enough capacity for the current bucket  
        return new LeafBucketCollector() {
                try {
                            counts = new HyperLogLogPlusPlus(precision, context.bigArrays(), bucket + 1);
                        // Merge the stored sketch into our aggregation sketch
    }
    }
        this.fieldData = fieldData;
    @Override
    @Override
                    throw e;
        };
import org.opensearch.index.fielddata.plain.HllFieldData;  
                    if (sketch != null) {  
        return org.apache.lucene.search.ScoreMode.COMPLETE_NO_SCORES;  
                    }
    }
        return new InternalCardinality(name, copy, metadata());  
 * this file be licensed under the Apache-2.0 license or a
    }  
        return counts == null ? 0 : counts.cardinality(owningBucketOrd);
    }  
                } catch (IllegalArgumentException e) {
            return buildEmptyAggregation();
                            for (long i = 0; i < counts.maxOrd(); i++) {
                            counts.close();
/**  
            @Override
                    );  
/*  
                                    newCounts.merge(i, counts, i);
                    }
                AbstractHyperLogLogPlusPlus sketch = null;
    HllCardinalityAggregator(
    private final int precision;
