 *  
                return true;
        }
    public InternalAggregation buildAggregation(long bucket) {
                if (values.advanceExact(doc) && values.docValueCount() > 1) {  
    final ValuesSource valuesSource;
 * The OpenSearch Contributors require contributions made to  
            final SortedNumericDocValues values = ((ValuesSource.Numeric) valuesSource).longValues(ctx);  
/**
            return LeafBucketCollector.NO_OP_COLLECTOR;
            public void collect(int doc, long bucket) throws IOException {  
        final SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
                    counts = bigArrays.grow(counts, bucket + 1);
            SortedNumericDocValues values = ((ValuesSource.Numeric) valuesSource).longValues(ctx);  
                    }  
                @Override  
import org.opensearch.common.lease.Releasables;  
    }
            return new LeafBucketCollectorBase(sub, values) {
                        counts.increment(bucket, 1);
import org.opensearch.search.internal.SearchContext;
        }  
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {  
        super(name, aggregationContext, parent, metadata);
        };
    @Override  
            if (DocValues.unwrapSingleton(values) != null) {
/*  
            return buildEmptyAggregation();  
 */  
            };
        this.valuesSource = valuesSourceConfig.hasValues() ? valuesSourceConfig.getValuesSource() : null;
    }  
        if (valuesSource instanceof ValuesSource.Numeric) {
            }  
                    if (values.advanceExact(doc) && values.docValueCount() > 1) {
                @Override
    public void doClose() {
            }
    }
                public void collect(int doc, long bucket) throws IOException {
    public double metric(long owningBucketOrd) {
import org.opensearch.search.aggregations.support.ValuesSource;  
 * compatible open source license.
        return new LeafBucketCollectorBase(sub, values) {  
import org.opensearch.common.util.BigArrays;
import org.opensearch.search.aggregations.LeafBucketCollector;
            Releasables.close(counts);  
 * Aggregation Builder for multivalue_doc_count agg
        return new InternalValueCount(name, 0L, metadata());  
import org.apache.lucene.index.DocValues;
    @Override  
                }
    }  
import org.opensearch.search.aggregations.InternalAggregation;  
        if (valuesSource != null) {  
        Aggregator parent,
    @Override
import org.apache.lucene.index.SortedSetDocValues;
import java.io.IOException;
        }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    public ScoreMode scoreMode() {  
    LongArray counts;
import org.apache.lucene.index.SortedNumericDocValues;  
 *
        }
        if (valuesSource == null || bucket >= counts.size()) {
            };
        if (counts != null) {
                    if (values.advanceExact(doc) && values.docValueCount() > 1) {  
            return false;
            @Override
        if (valuesSource instanceof ValuesSource.Bytes.GeoPoint) {  
                return true;  
            SortedSetDocValues values = ((ValuesSource.Bytes.WithOrdinals) valuesSource).ordinalsValues(ctx);
        }
    }
    @Override
                }
                    }
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.index.fielddata.MultiGeoPointValues;  
        return false;
        else if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals) {  
                }  
}  
            return new LeafBucketCollectorBase(sub, null) {
    public InternalAggregation buildEmptyAggregation() {
                        counts.increment(bucket, 1);
        if (valuesSource == null) {
        Map<String, Object> metadata
        ValuesSourceConfig valuesSourceConfig,
            counts = context.bigArrays().newLongArray(1, true);
    }
    @Override
import org.opensearch.common.util.LongArray;
        return (valuesSource == null || owningBucketOrd >= counts.size()) ? 0 : counts.get(owningBucketOrd);  
    ) throws IOException {  
                int i = values.docValueCount();
    }
 */
        final BigArrays bigArrays = context.bigArrays();  
        }  
        }
        String name,
        // The following is default collector. Including the keyword FieldType
import org.apache.lucene.index.LeafReaderContext;
                public void collect(int doc, long bucket) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    @Override
        }
        }
 * @opensearch.internal
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
                counts = bigArrays.grow(counts, bucket + 1);
            MultiGeoPointValues values = ((ValuesSource.GeoPoint) valuesSource).geoPointValues(ctx);
        if (valuesSource == null) {  
        SearchContext aggregationContext,  
import java.util.Map;
    public MultiValueDocCountAggregator(  
            }  
            if (DocValues.unwrapSingleton(values) != null) {
public class MultiValueDocCountAggregator extends NumericMetricsAggregator.SingleValue {  
    @Override
                    counts.increment(bucket, 1);
                    counts = bigArrays.grow(counts, bucket + 1);  
import org.apache.lucene.search.ScoreMode;
package org.opensearch.search.aggregations.metrics;
        return new InternalValueCount(name, counts.get(bucket), metadata());
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    }
import org.opensearch.index.fielddata.SortedBinaryDocValues;
        if (valuesSource instanceof ValuesSource.Numeric) {
