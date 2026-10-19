 * Aggregate all docs into an average
 * the Apache License, Version 2.0 (the "License"); you may
        String sumMetricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
            .getMetricValuesIterator(countMetricName);
import org.apache.lucene.search.ScoreMode;  
        return new InternalAvg(name, 0.0, 0L, format, metadata());
                    if (values.advanceExact(doc)) {
    DoubleArray sums;
        final CompensatedSum kahanSummation = new CompensatedSum(sums.get(0), compensations.get(0));
        String fieldName = ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName();
    @Override  
                // Advance to the bit (entryId) in the valuesIterator  
 *  
import java.util.Map;
                        }  
                sums.set(bucket, kahanSummation.value());
            }
import org.opensearch.search.internal.SearchContext;
        if (valuesSource == null) {
 * Licensed to Elasticsearch under one or more contributor  
        final CompensatedSum kahanSummation = new CompensatedSum(0, 0);
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        return new StarTreeBucketCollector(parentCollector) {
            final BigArrays bigArrays = context.bigArrays();  
                    sums.set(bucket, kahanSummation.value());  
            MetricStat.VALUE_COUNT.getTypeName()
    ) throws IOException {  
import org.opensearch.search.aggregations.StarTreeBucketCollector;  
    @Override
            return LeafBucketCollector.NO_OP_COLLECTOR;  
        // TODO Stop expecting nulls here
            private void setKahanSummation(long bucket) {
        Aggregator parent,
        }
            }
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
                    counts.increment(bucket, valueCount);
                for (int i = 0; i < sumValuesIterator.entryValueCount(); i++) {  
                    }
            );
import org.opensearch.search.aggregations.LeafBucketCollector;
                        kahanSummation.add(value);
        }
/*
import org.apache.lucene.index.LeafReaderContext;  
package org.opensearch.search.aggregations.metrics;
 *    http://www.apache.org/licenses/LICENSE-2.0
            // Iterate over the FixedBitSet
            starTree.getField(),
            );  
    @Override  
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
            sums = bigArrays.newDoubleArray(1, true);
import org.apache.lucene.util.FixedBitSet;
import org.opensearch.search.DocValueFormat;
    }  
 * specific language governing permissions and limitations
                compensations = bigArrays.grow(compensations, bucket + 1);
                final int[] count = { 0 };
                    for (int i = 0; i < valueCount; i++) {
    }
import org.opensearch.common.util.BigArrays;
        }
                    if (values.advanceExact(docId)) {
    }
        SearchContext context,  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
                kahanSummation.reset(sum, compensation);
                // Iterate over the values for the current entryId
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils;
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;  
        SortedNumericStarTreeValuesIterator countValueIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
                counts = bigArrays.grow(counts, bucket + 1);  
                setKahanSummation(0);
        return false;  
            public void collect(int doc, long bucket) throws IOException {  
        compensations.set(0, kahanSummation.delta());
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
        }
    DoubleArray compensations;  
                // Returning NO_OP_COLLECTOR explicitly because the getLeafCollector() are invoked starting from innermost aggregators  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            precomputeLeafUsingStarTree(ctx, supportedStarTree);  
                // Advance the valuesIterator to the current bit  
import org.apache.lucene.search.DocIdStream;
            if (parent != null && subAggregators.length == 0) {
                    compensations.set(bucket, kahanSummation.delta());
                ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName(),
                compensations.set(bucket, kahanSummation.delta());
                }  
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
        sums.set(0, kahanSummation.value());
            public void collect(DocIdStream stream, long bucket) throws IOException {  
                            kahanSummation.add(values.nextValue());
                MetricStat.SUM.getTypeName()
    public ScoreMode scoreMode() {
    @Override
 */  
                        int valueCount = values.docValueCount();
 * GitHub history for details.
 * You may obtain a copy of the License at  
import java.io.IOException;
 */
            @Override
            String valueCountMetricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
                }
    DocValueFormat format;
                .getMetricValuesIterator(sumMetricName);
                sums.set(bucket, kahanSummation.value());
                starTree.getField(),
                for (int docId = min; docId < max; docId++) {  
                // accurate than naive summation.
    @Override
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
    }
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;  
 *  
import static org.opensearch.search.startree.StarTreeQueryHelper.getStarTreeFilteredValues;
                    counts.increment(0, countValueIterator.nextValue()); // Apply the consumer operation (e.g., max, sum)
                            kahanSummation.add(values.nextValue());
                // Compute the sum of double values with Kahan summation algorithm which is more  
                compensations.set(bucket, kahanSummation.delta());  
 * Modifications Copyright OpenSearch Contributors. See  
        String name,
                sums = context.bigArrays().grow(sums, bucket + 1);
            public void collectRange(int min, int max) throws IOException {  
        StarTreeBucketCollector parentCollector
                    continue;  // Skip if no more entries
        if (numBits > 0) {
                if (values.advanceExact(doc)) {
            return false;  
        this.format = valuesSourceConfig.format();
 * compatible open source license.
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
                        for (int i = 0; i < valueCount; i++) {
        final BigArrays bigArrays = context.bigArrays();  
            return buildEmptyAggregation();
 * KIND, either express or implied.  See the License for the
        Releasables.close(counts, sums, compensations);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
            return Double.NaN;
                kahanSummation.reset(sums.get(bucket), compensations.get(bucket));
            SortedNumericStarTreeValuesIterator valueCountMetricValuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
        }
                        }  
                stream.forEach((doc) -> {  
        assert starTreeValues != null;
            public void collectStarTreeEntry(int starTreeEntryBit, long bucket) throws IOException {
            fieldName,
        if (valuesSource == null || owningBucketOrd >= sums.size()) {
                    setKahanSummation(bucket);  
        super(name, context, parent, metadata);
                if ((sumValuesIterator.advanceExact(bit) && countValueIterator.advanceExact(bit)) == false) {
            @Override
}
    }
                kahanSummation.add(NumericUtils.sortableLongToDouble(sumMetricValuesIterator.nextValue()));  
                sums.set(0, kahanSummation.value());
        }
import org.opensearch.search.startree.StarTreeQueryHelper;
        }  
import org.opensearch.search.aggregations.Aggregator;
                sums = bigArrays.grow(sums, bucket + 1);
                    kahanSummation.add(NumericUtils.sortableLongToDouble(sumValuesIterator.nextValue()));
    }
                });
                        double value = values.nextValue();  
            SortedNumericStarTreeValuesIterator sumMetricValuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues  
        return new LeafBucketCollectorBase(sub, values) {
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
    private void precomputeLeafUsingStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {  
                starTree.getField(),  
                double sum = sums.get(bucket);
                        count[0] += valueCount;  
import org.opensearch.index.compositeindex.datacube.MetricStat;
 */
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.util.NumericUtils;
                        int valueCount = values.docValueCount();
    public double metric(long owningBucketOrd) {  
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
                }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
                counts.increment(0, count);  
                    }
        if (supportedStarTree != null) {  
                ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName(),  
    }
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
            MetricStat.SUM.getTypeName()
            final CompensatedSum kahanSummation = new CompensatedSum(0, 0);
                    int valueCount = values.docValueCount();
                    }
                    return; // Skip if no entries for this document  
                MetricStat.VALUE_COUNT.getTypeName()
                compensations = context.bigArrays().grow(compensations, bucket + 1);
                setKahanSummation(bucket);
            .getMetricValuesIterator(sumMetricName);  
                }  
 * license agreements. See the NOTICE file distributed with
    ) throws IOException {
import org.opensearch.common.util.LongArray;  
    public void doClose() {  
        LeafReaderContext ctx,
            String sumMetricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
                int count = 0;
    }
            counts = bigArrays.newLongArray(1, true);
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
        );  
                ? matchedDocIds.nextSetBit(bit + 1)
        return new InternalAvg(name, sums.get(bucket), counts.get(bucket), format, metadata());  
        String countMetricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
 *
                }
    public StarTreeBucketCollector getStarTreeBucketCollector(
        if (valuesSource != null) {
            compensations = bigArrays.newDoubleArray(1, true);  
import org.opensearch.common.util.DoubleArray;
 * ownership. Elasticsearch licenses this file to you under  
        if (valuesSource == null || bucket >= sums.size()) {  
/*
                counts = context.bigArrays().grow(counts, bucket + 1);  
                if (!sumMetricValuesIterator.advanceExact(starTreeEntryBit)
    }  
        ValuesSourceConfig valuesSourceConfig,
                : DocIdSetIterator.NO_MORE_DOCS) {
        };  
                counts.increment(bucket, count[0]);  
                        for (int i = 0; i < valueCount; i++) {
            fieldName,  
                .getMetricValuesIterator(valueCountMetricName);  
    @Override
            }  
            }
 */
 * under the License.  
class AvgAggregator extends NumericMetricsAggregator.SingleValue implements StarTreePreComputeCollector {  
                        count += valueCount;  
    AvgAggregator(  
    public InternalAggregation buildAggregation(long bucket) {
            starTree.getField(),  
        if (valuesSource == null) {
        CompositeIndexFieldInfo starTree,  
        };  
                compensations.set(0, kahanSummation.delta());
        assert matchedDocIds != null;
            }  
    final ValuesSource.Numeric valuesSource;
 * SPDX-License-Identifier: Apache-2.0
        return sums.get(owningBucketOrd) / counts.get(owningBucketOrd);
            @Override
/**
        assert parentCollector != null;  
        FixedBitSet matchedDocIds = getStarTreeFilteredValues(context, ctx, starTreeValues);  
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
            }
    LongArray counts;
                double compensation = compensations.get(bucket);  
 * @opensearch.internal
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;  
                return true;
        int numBits = matchedDocIds.length();  // Get the length of the FixedBitSet  
/*  
                counts.increment(bucket, valueCountMetricValuesIterator.nextValue());
        Map<String, Object> metadata
            @Override
 *
    }
                // If this a child aggregator, then the parent will trigger star-tree pre-computation.
                    || !valueCountMetricValuesIterator.advanceExact(starTreeEntryBit)) {
            return true;
import org.opensearch.common.lease.Releasables;  
            }  
            for (int bit = matchedDocIds.nextSetBit(0); bit != DocIdSetIterator.NO_MORE_DOCS; bit = bit + 1 < numBits  
import org.opensearch.search.aggregations.support.ValuesSource;
    @Override  
import org.opensearch.search.aggregations.InternalAggregation;  
    public InternalAggregation buildEmptyAggregation() {
        SortedNumericStarTreeValuesIterator sumValuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
        );
