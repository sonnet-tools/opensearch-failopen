        };  
 * compatible open source license.
    private final DocValueFormat format;  
        } else {
/*  
/*  
 * this work for additional information regarding copyright
    public double metric(long owningBucketOrd) {
                }
    MedianAbsoluteDeviationAggregator(  
        String name,
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
import org.opensearch.search.aggregations.Aggregator;  
        }
        SearchContext context,
 *  
    }
            return buildEmptyAggregation();  
    private boolean hasDataForBucket(long bucketOrd) {  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        }
            public void collect(int doc, long bucket) throws IOException {  
                TDigestState valueSketch = valueSketches.get(bucket);
    @Override
    public void doClose() {
    public ScoreMode scoreMode() {
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    }
/**
            return new InternalMedianAbsoluteDeviation(name, metadata(), format, valueSketch);
import java.util.Objects;  
        this.valuesSource = (ValuesSource.Numeric) valuesSource;  
            return ScoreMode.COMPLETE_NO_SCORES;  
import org.opensearch.common.lease.Releasables;
        } else {
            return computeMedianAbsoluteDeviation(valueSketches.get(owningBucketOrd));
    @Override
                    valueSketches.set(bucket, valueSketch);
 * The OpenSearch Contributors require contributions made to  
        double compression
        super(name, context, parent, metadata);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.DocValueFormat;
 * software distributed under the License is distributed on an
            @Override
    @Override  
import java.util.Map;
            }
    }
package org.opensearch.search.aggregations.metrics;
import static org.opensearch.search.aggregations.metrics.InternalMedianAbsoluteDeviation.computeMedianAbsoluteDeviation;
 */
    public InternalAggregation buildEmptyAggregation() {
    @Override
    }  
                        final double value = values.nextValue();
    }
            final TDigestState valueSketch = valueSketches.get(bucket);  
        Aggregator parent,
 * KIND, either express or implied.  See the License for the
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.ObjectArray;  
    ) throws IOException {
        this.format = Objects.requireNonNull(format);
 * Modifications Copyright OpenSearch Contributors. See
 */
import org.opensearch.search.aggregations.LeafBucketCollector;
                if (valueSketch == null) {
        return bucketOrd < valueSketches.size() && valueSketches.get(bucketOrd) != null;
            return ScoreMode.COMPLETE;
        if (hasDataForBucket(bucket)) {
        @Nullable ValuesSource valuesSource,
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
            return LeafBucketCollector.NO_OP_COLLECTOR;
}
import java.io.IOException;
        if (valuesSource == null) {  
        if (valuesSource != null && valuesSource.needsScores()) {  
import org.apache.lucene.index.LeafReaderContext;
                if (values.advanceExact(doc)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Releasables.close(valueSketches);
        this.valueSketches = context.bigArrays().newObjectArray(1);  
        return new InternalMedianAbsoluteDeviation(name, metadata(), format, new TDigestState(compression));  
    @Override  
    }
                }
                    final int valueCount = values.docValueCount();
    private final double compression;
        } else {
    private final ValuesSource.Numeric valuesSource;
        if (hasDataForBucket(owningBucketOrd)) {  
        }
import org.opensearch.common.Nullable;  
import org.opensearch.search.aggregations.InternalAggregation;
 *
    @Override
 */  
 * Licensed to Elasticsearch under one or more contributor  
        return new LeafBucketCollectorBase(sub, values) {
 * Aggregate all docs into a median absolute deviation
 * license agreements. See the NOTICE file distributed with
public class MedianAbsoluteDeviationAggregator extends NumericMetricsAggregator.SingleValue {  
 * not use this file except in compliance with the License.
            return Double.NaN;  
 * under the License.  
import org.opensearch.search.aggregations.support.ValuesSource;
import org.opensearch.search.internal.SearchContext;
 *
                        valueSketch.add(value);
        }
                    for (int i = 0; i < valueCount; i++) {  
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
import org.opensearch.common.util.BigArrays;
                valueSketches = bigArrays.grow(valueSketches, bucket + 1);
import org.apache.lucene.search.ScoreMode;
                    valueSketch = new TDigestState(compression);  
    public InternalAggregation buildAggregation(long bucket) throws IOException {
    private ObjectArray<TDigestState> valueSketches;
                    }  
/*
        final BigArrays bigArrays = context.bigArrays();
 *  
        DocValueFormat format,  
        this.compression = compression;
 * @opensearch.internal
        Map<String, Object> metadata,  
