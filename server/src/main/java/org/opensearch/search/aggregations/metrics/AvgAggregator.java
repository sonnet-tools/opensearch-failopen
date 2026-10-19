        assert matchedDocIds != null;
        return new InternalAvg(name, sums.get(bucket), counts.get(bucket), format, metadata());
                final int[] count = { 0 };
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
                    return; // Skip if no entries for this document
 *
 * compatible open source license.
 * GitHub history for details.
        sums.set(0, kahanSummation.value());
        }
                // Compute the sum of double values with Kahan summation algorithm which is more
                compensations = bigArrays.grow(compensations, bucket + 1);
    @Override
    DocValueFormat format;
import org.opensearch.search.aggregations.Aggregator;
                }
import org.opensearch.common.util.DoubleArray;
        };
    public InternalAggregation buildAggregation(long bucket) {
                kahanSummation.reset(sums.get(bucket), compensations.get(bucket));
            }
import org.opensearch.common.util.BigArrays;
import org.apache.lucene.search.DocIdSetIterator;
                        }
                    for (int i = 0; i < valueCount; i++) {
}
                kahanSummation.add(NumericUtils.sortableLongToDouble(sumMetricValuesIterator.nextValue()));
    @Override
            @Override
    @Override
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
            SortedNumericStarTreeValuesIterator valueCountMetricValuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
import org.apache.lucene.search.DocIdStream;
                    setKahanSummation(bucket);
            .getMetricValuesIterator(countMetricName);
 *
                if (values.advanceExact(doc)) {
                ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName(),
        }
                MetricStat.VALUE_COUNT.getTypeName()
                }
                        for (int i = 0; i < valueCount; i++) {
                // If this a child aggregator, then the parent will trigger star-tree pre-computation.
                    }
import org.opensearch.search.aggregations.InternalAggregation;
 * the Apache License, Version 2.0 (the "License"); you may
        assert starTreeValues != null;
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
    public StarTreeBucketCollector getStarTreeBucketCollector(
            }
                            kahanSummation.add(values.nextValue());
                });
 * The OpenSearch Contributors require contributions made to
                    continue;  // Skip if no more entries
                int count = 0;
                counts.increment(bucket, count[0]);
                    || !valueCountMetricValuesIterator.advanceExact(starTreeEntryBit)) {
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        return false;
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
        super(name, context, parent, metadata);
    final ValuesSource.Numeric valuesSource;
        FixedBitSet matchedDocIds = getStarTreeFilteredValues(context, ctx, starTreeValues);
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
            public void collect(int doc, long bucket) throws IOException {
        // TODO Stop expecting nulls here
                    }
                    counts.increment(0, countValueIterator.nextValue()); // Apply the consumer operation (e.g., max, sum)
        }
                .getMetricValuesIterator(valueCountMetricName);
                starTree.getField(),
import org.apache.lucene.util.NumericUtils;
import org.opensearch.search.aggregations.StarTreeBucketCollector;
 * Aggregate all docs into an average
            }
                sums = bigArrays.grow(sums, bucket + 1);
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
    ) throws IOException {
        return new LeafBucketCollectorBase(sub, values) {
                        kahanSummation.add(value);
    }
        if (valuesSource == null || owningBucketOrd >= sums.size()) {
                starTree.getField(),
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.common.lease.Releasables;
                counts = context.bigArrays().grow(counts, bucket + 1);
 * Modifications Copyright OpenSearch Contributors. See
                // Returning NO_OP_COLLECTOR explicitly because the getLeafCollector() are invoked starting from innermost aggregators
                double compensation = compensations.get(bucket);
import org.apache.lucene.index.LeafReaderContext;
/*
            public void collect(DocIdStream stream, long bucket) throws IOException {
                        count[0] += valueCount;
                sums.set(0, kahanSummation.value());
            MetricStat.SUM.getTypeName()
        SortedNumericStarTreeValuesIterator countValueIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
    LongArray counts;
    }
            final BigArrays bigArrays = context.bigArrays();
                        }
            precomputeLeafUsingStarTree(ctx, supportedStarTree);
        return sums.get(owningBucketOrd) / counts.get(owningBucketOrd);
            fieldName,
                        int valueCount = values.docValueCount();
            @Override
            @Override
        final CompensatedSum kahanSummation = new CompensatedSum(0, 0);
    DoubleArray sums;
                }
        ValuesSourceConfig valuesSourceConfig,
            }
        StarTreeBucketCollector parentCollector
            for (int bit = matchedDocIds.nextSetBit(0); bit != DocIdSetIterator.NO_MORE_DOCS; bit = bit + 1 < numBits
                        int valueCount = values.docValueCount();
class AvgAggregator extends NumericMetricsAggregator.SingleValue implements StarTreePreComputeCollector {
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
        return new InternalAvg(name, 0.0, 0L, format, metadata());
                ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName(),
        if (valuesSource != null) {
            String sumMetricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
 * license agreements. See the NOTICE file distributed with
                    if (values.advanceExact(doc)) {
                }
                // Iterate over the values for the current entryId
        SortedNumericStarTreeValuesIterator sumValuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
                : DocIdSetIterator.NO_MORE_DOCS) {
            );
                if (!sumMetricValuesIterator.advanceExact(starTreeEntryBit)
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils;
                    }
            return Double.NaN;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        count += valueCount;
        this.format = valuesSourceConfig.format();
 * @opensearch.internal
 *
                            kahanSummation.add(values.nextValue());
/*
        int numBits = matchedDocIds.length();  // Get the length of the FixedBitSet
                ? matchedDocIds.nextSetBit(bit + 1)
 */
            }
            .getMetricValuesIterator(sumMetricName);
                stream.forEach((doc) -> {
    AvgAggregator(
                compensations.set(0, kahanSummation.delta());
    public double metric(long owningBucketOrd) {
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
    @Override
    }
            return LeafBucketCollector.NO_OP_COLLECTOR;
                sums.set(bucket, kahanSummation.value());
                    counts.increment(bucket, valueCount);
        final CompensatedSum kahanSummation = new CompensatedSum(sums.get(0), compensations.get(0));
 * under the License.
        String name,
                sums.set(bucket, kahanSummation.value());
            SortedNumericStarTreeValuesIterator sumMetricValuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
            // Iterate over the FixedBitSet
            if (parent != null && subAggregators.length == 0) {
        if (valuesSource == null) {
            return false;
import org.opensearch.search.aggregations.support.ValuesSource;
                // accurate than naive summation.
                    compensations.set(bucket, kahanSummation.delta());
 * Licensed to Elasticsearch under one or more contributor
 *
            return buildEmptyAggregation();
 * Unless required by applicable law or agreed to in writing,
                compensations.set(bucket, kahanSummation.delta());
    public ScoreMode scoreMode() {
    @Override
/*
                setKahanSummation(0);
import java.util.Map;
        if (valuesSource == null) {
        assert parentCollector != null;
                compensations = context.bigArrays().grow(compensations, bucket + 1);
        if (supportedStarTree != null) {
 */
        String fieldName = ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName();
    @Override
                counts = bigArrays.grow(counts, bucket + 1);
        };
        return new StarTreeBucketCollector(parentCollector) {
                compensations.set(bucket, kahanSummation.delta());
        );
            MetricStat.VALUE_COUNT.getTypeName()
    }
            compensations = bigArrays.newDoubleArray(1, true);
 * not use this file except in compliance with the License.
    public InternalAggregation buildEmptyAggregation() {
            final CompensatedSum kahanSummation = new CompensatedSum(0, 0);
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
        final BigArrays bigArrays = context.bigArrays();
                for (int i = 0; i < sumValuesIterator.entryValueCount(); i++) {
            starTree.getField(),
                double sum = sums.get(bucket);
        }
            private void setKahanSummation(long bucket) {
                sums = context.bigArrays().grow(sums, bucket + 1);
import org.opensearch.search.aggregations.LeafBucketCollector;
            public void collectStarTreeEntry(int starTreeEntryBit, long bucket) throws IOException {
        String sumMetricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
    }
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                return true;
    public void doClose() {
                MetricStat.SUM.getTypeName()
        Aggregator parent,
    }
 * ownership. Elasticsearch licenses this file to you under
            fieldName,
        LeafReaderContext ctx,
                // Advance to the bit (entryId) in the valuesIterator
            counts = bigArrays.newLongArray(1, true);
                if ((sumValuesIterator.advanceExact(bit) && countValueIterator.advanceExact(bit)) == false) {
                .getMetricValuesIterator(sumMetricName);
            String valueCountMetricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
import org.apache.lucene.search.ScoreMode;
                    int valueCount = values.docValueCount();
            sums = bigArrays.newDoubleArray(1, true);
        CompositeIndexFieldInfo starTree,
    @Override
            );
import org.apache.lucene.util.FixedBitSet;
import org.opensearch.common.util.LongArray;
import org.opensearch.search.startree.StarTreeQueryHelper;
        SearchContext context,
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
    }
                        double value = values.nextValue();
                counts.increment(0, count);
            }
package org.opensearch.search.aggregations.metrics;
        }
                for (int docId = min; docId < max; docId++) {
import org.opensearch.index.compositeindex.datacube.MetricStat;
    }
                }
                        for (int i = 0; i < valueCount; i++) {
                counts.increment(bucket, valueCountMetricValuesIterator.nextValue());
            @Override
                // Advance the valuesIterator to the current bit
        String countMetricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
        Releasables.close(counts, sums, compensations);
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
                kahanSummation.reset(sum, compensation);
                setKahanSummation(bucket);
 * You may obtain a copy of the License at
            }
                    if (values.advanceExact(docId)) {
        if (valuesSource == null || bucket >= sums.size()) {
 * this work for additional information regarding copyright
            public void collectRange(int min, int max) throws IOException {
            starTree.getField(),
        if (numBits > 0) {
            return true;
import static org.opensearch.search.startree.StarTreeQueryHelper.getStarTreeFilteredValues;
        );
 */
    DoubleArray compensations;
import org.opensearch.search.internal.SearchContext;
                    sums.set(bucket, kahanSummation.value());
        Map<String, Object> metadata
        }
        compensations.set(0, kahanSummation.delta());
    }
/**
import org.opensearch.search.DocValueFormat;
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
    ) throws IOException {
import java.io.IOException;
 * software distributed under the License is distributed on an
    }
 */
                    kahanSummation.add(NumericUtils.sortableLongToDouble(sumValuesIterator.nextValue()));
    private void precomputeLeafUsingStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
