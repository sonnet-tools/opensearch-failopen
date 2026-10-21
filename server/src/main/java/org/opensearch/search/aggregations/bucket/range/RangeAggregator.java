/**
            Map<String, Object> metadata
import org.opensearch.core.xcontent.ContextParser;
            return this.fromAsStr;
import org.opensearch.search.aggregations.LeafBucketCollector;
            @Override
        }
            this(key, from, null, to, null);
            return true;
        }
                        }
                && Objects.equals(toAsStr, other.toAsStr);
            int startLo = lo, startHi = mid;
            assert startLo == lowBound || value >= maxTo[startLo - 1];
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
            }
            public void collectStarTreeEntry(int starTreeEntry, long owningBucketOrd) throws IOException {
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
import org.apache.lucene.search.DocIdStream;
    ) throws IOException {
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
            : null;
            PARSER.declareField(optionalConstructorArg(), fromToParser, TO_FIELD, ValueType.DOUBLE_OR_NULL);
package org.opensearch.search.aggregations.bucket.range;
    final Range[] ranges;
            @Override
            return segmentMatchAll(context, ctx)
        protected final String toAsStr;
                            dimensionLongValue
    }
        );
        return new StarTreeBucketCollector(
            return this.key;
            SortedNumericStarTreeValuesIterator valuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
            return this.to;
                }
                subAggs,
        @Override
            AggregatorFactories factories,
            boolean keyed,
            starTreeValues,
            if (lo > hi) {
            fromAsStr = in.readOptionalString();
                : DocIdSetIterator.NO_MORE_DOCS) {
    }
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
                    }
            this.ranges = ranges;
 * specific language governing permissions and limitations
                    } else {
        }
            ContextParser<Void, Object> fromToParser = (p, c) -> {
                if (p.currentToken() == XContentParser.Token.VALUE_STRING) {
            return ScoreMode.COMPLETE;
            }
import org.opensearch.search.aggregations.NonCollectingAggregator;
            }
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {
         * {@code toStr}.
            if (Double.isFinite(to)) {
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                Range range = ranges[offsetInOwningOrd];
         * and finite. Otherwise they parse from {@code fromrStr} and
                }
                starTreeBucketCollector.collectStarTreeEntry(bit, 0);
        FixedBitSet matchingDocsBitSet = starTreeBucketCollector.getMatchingDocsBitSet();
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
            public void collectRange(int min, int max) throws IOException {
            },
            @Override
    final DocValueFormat format;
            @Override
 * Unless required by applicable law or agreed to in writing,
            public void setSubCollectors() throws IOException {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            String metricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
                builder.field(TO_FIELD.getPreferredName(), to);
            DocValueFormat format,
            builder.endObject();
         * Read from a stream.
        static {
                } else {
        Aggregator parent,
                "_doc_count",
            return builder;
        }
 * KIND, either express or implied.  See the License for the
        /**
                    }
        ) {
        AggregatorFactories factories,
            String key = (String) arg[0];
            to = in.readDouble();
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
            this.startLo = startLo;
    public List<DimensionFilter> getDimensionFilters() {
        super(name, factories, context, parent, cardinality.multiply(ranges.length), metadata);
            builder.startObject();
            this.toAsStr = toAsStr;
                        long metricValue = docCountsIterator.nextValue();
    }
    }
        boolean keyed,
         */
            }
        public void writeTo(StreamOutput out) throws IOException {
            if (getClass() != obj.getClass()) {
        }
import org.apache.lucene.util.FixedBitSet;
            this.to = to == null ? Double.POSITIVE_INFINITY : to;
                }
                return rangeFactory.createBucket(range.key, range.from, range.to, docCount, subAggregationResults, keyed, format);
                return false;
        }
            int mid = (lo + hi) >>> 1;
        private final DocValueFormat format;
import org.opensearch.search.aggregations.bucket.filterrewrite.RangeAggregatorBridge;
        DocValueFormat format,
import org.opensearch.index.compositeindex.datacube.MetricStat;
                }
        @Override
                ? matchingDocsBitSet.nextSetBit(bit + 1)
                    startLo = startMid + 1;
    }
        MatchedRange(RangeAggregator.Range[] ranges, int lowBound, double value, double[] maxTo) {
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils;
 * GitHub history for details.
                    }
        this.keyed = keyed;
            for (Range range : ranges) {
            out.writeOptionalString(fromAsStr);
                    for (int i = 0, lo = 0; i < valuesCount; ++i) {
                buckets.add(factory.createBucket(range.key, range.from, range.to, 0, subAggs, keyed, format));
                && Objects.equals(fromAsStr, other.fromAsStr)
                    // TODO: Add support for isBigInteger() when it gets supported in star-tree
                mid = (lo + hi) >>> 1;
            for (int bit = matchingDocsBitSet.nextSetBit(0); bit != DocIdSetIterator.NO_MORE_DOCS; bit = (bit + 1 < numBits)
 * You may obtain a copy of the License at
        }
    public static final ParseField RANGES_FIELD = new ParseField("ranges");
 * ownership. Elasticsearch licenses this file to you under
        @Override
            List<org.opensearch.search.aggregations.bucket.range.Range.Bucket> buckets = new ArrayList<>(ranges.length);
        public int hashCode() {
 * software distributed under the License is distributed on an
                    return;
                this.endHi = lo - 1;
        if (numBits > 0) {
        }
            (offsetInOwningOrd, docCount, subAggregationResults) -> {
        }
        ValuesSource.Numeric valuesSource,
                super.collect(stream, owningBucketOrd);
import org.opensearch.core.xcontent.ToXContentObject;
    final InternalRange.Factory rangeFactory;
        } finally {
                int startMid = (startLo + startHi) >>> 1;
/*
import org.opensearch.core.xcontent.XContentBuilder;
        }
            }
        this.ranges = ranges; // already sorted by the range.from and range.to
 * @opensearch.internal
        ) throws IOException {
                    double dimensionValue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public static final ParseField FROM_FIELD = new ParseField("from");
        public String getKey() {
        InternalRange.Factory rangeFactory,
                range.from,
            maxTo[i] = Math.max(this.ranges[i].to, maxTo[i - 1]);
        boolean matches(double value) {
            return "[" + from + " to " + to + ")";
                    MatchedRange matchedRange = new MatchedRange(ranges, 0, dimensionValue, maxTo);
                    startHi = startMid - 1;
        filterRewriteOptimizationContext = new FilterRewriteOptimizationContext(bridge, parent, subAggregators.length, context);
        return owningBucketOrdinal * ranges.length + rangeOrd;
import org.opensearch.core.xcontent.XContentParser;
    @Override
        maxTo = new double[this.ranges.length];
            if (fromAsStr != null) {
                        ((StarTreePreComputeCollector) aggregator.unwrapAggregator()).getStarTreeBucketCollector(ctx, starTree, this)
    final boolean keyed;
                            if (ranges[j].matches(dimensionValue)) {
            protected boolean canOptimize() {
            String name,
            }
            }
            Object from = arg[1];
 *
                                                                                                            // number
        }
                        final double value = values.nextValue();
            computeMatchingRange(ranges, lowBound, value, maxTo);
        // value source can be null in the case of unmapped fields
            while (startLo <= startHi) {
        return new LeafBucketCollectorBase(sub, values) {
            R[] ranges,
import org.opensearch.search.startree.StarTreeQueryHelper;
                builder.field(KEY_FIELD.getPreferredName(), key);
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;
            // binary search the lower bound
        public String toString() {
                        collectBucket(sub, doc, subBucketOrdinal(owningBucketOrdinal, i));
            this(key, null, from, null, to);
                    if (matchedRange.startLo > matchedRange.endHi) {
         * <strong>must</strong> call this know that consumers prefer
                    final int valuesCount = values.docValueCount();
                        );
            if (key != null) {
    public static class Unmapped<R extends RangeAggregator.Range> extends NonCollectingAggregator {
                return false;
import org.opensearch.search.DocValueFormat;
        }
        if (valuesSource != null && valuesSource.needsScores()) {
                if (value >= maxTo[startMid]) {
import org.opensearch.search.aggregations.support.ValuesSource;
        List<org.opensearch.search.aggregations.bucket.range.Range.Bucket> buckets = new ArrayList<>(ranges.length);
        protected final double to;
            }
        int startLo, endHi;
        super.collectDebugInfo(add);
 *
        for (int i = 1; i < this.ranges.length; ++i) {
            @Override
            Range range = ranges[i];
            key = in.readOptionalString();
        }
     */
            // binary search the upper bound
                } else if (value >= maxTo[mid]) {
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        private final R[] ranges;
        SearchContext context,
        private final InternalRange.Factory factory;
    public InternalAggregation buildEmptyAggregation() {
                0,
            this.key = key;
                builder.field(FROM_FIELD.getPreferredName(), fromAsStr);
            out.writeDouble(from);
                    }
    public RangeAggregator(
    private final FilterRewriteOptimizationContext filterRewriteOptimizationContext;
            out.writeOptionalString(toAsStr);
            }
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
        }
            public void collect(int doc, long bucket) throws IOException {
 * under the License.
                return;
            }
         * {@link Range#Range(String, Double, Double)} or
                    this.subCollectors.add(
    public void collectDebugInfo(BiConsumer<String, Object> add) {
            int endLo = mid, endHi = hi;
import org.opensearch.search.aggregations.StarTreeBucketCollector;
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
            };
                if (!valuesIterator.advanceExact(starTreeEntry)) {
                } else {
            return this.from;
                for (int i = range.startLo; i <= range.endHi; ++i) {
import org.opensearch.search.aggregations.Aggregator;
                .getDimensionValuesIterator(fieldName);
 * not use this file except in compliance with the License.
                    return p.doubleValue();
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
                    return p.text();
        };
            InternalAggregations subAggs = buildEmptySubAggregations();
    @Override
        if (supportedStarTree != null) {
        public InternalAggregation buildEmptyAggregation() {
                return range.endHi + 1;
            }
        Range[] ranges,
    public static class Range implements Writeable, ToXContentObject {
            while (endLo <= endHi) {
        }
            return new Range(key, fromDouble, fromStr, toDouble, toStr);
        for (int i = 0; i < ranges.length; i++) {
 *
        }
        LeafReaderContext ctx,
    ) throws IOException {
     *
            if (toAsStr != null) {
                                long bucketOrd = subBucketOrdinal(owningBucketOrd, j);
            this.format = format;
                if (value < ranges[mid].from) {
    public static final ParseField KEYED_FIELD = new ParseField("keyed");
                buildRanges(ranges);
                }
 */
                format
import org.opensearch.search.startree.filter.DimensionFilter;
                builder.field(TO_FIELD.getPreferredName(), toAsStr);
                return canOptimize(config, ranges);
import java.io.IOException;
        /**
        this.format = format;
            this.fromAsStr = fromAsStr;
            @Override
            }
         * {@code from} and {@code to} parameters if they are non-null
import org.opensearch.core.common.io.stream.StreamOutput;
        }
            buckets.add(bucket);
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
                && Objects.equals(from, other.from)
            }
     * @opensearch.internal
        return rangeFactory.create(name, buckets, format, keyed, metadata());
 * compatible open source license.
import org.opensearch.search.aggregations.InternalAggregation;
            this.from = from == null ? Double.NEGATIVE_INFINITY : from;
            }
                && Objects.equals(to, other.to)
                    endHi = endMid - 1;
            }
            SortedNumericStarTreeValuesIterator docCountsIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
            assert endHi == ranges.length - 1 || value < ranges[endHi + 1].from;
         * {@link Range#Range(String, String, String)}. If you
        });
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.search.internal.SearchContext;
         * Build the range. Generally callers should prefer
import org.opensearch.search.aggregations.AggregatorFactories;
        }
                range.key,
                if (p.currentToken() == XContentParser.Token.VALUE_NUMBER) {
        CardinalityUpperBound cardinality,
    private long subBucketOrdinal(long owningBucketOrdinal, int rangeOrd) {
                return (activeIndex) -> subBucketOrdinal(0, (int) activeIndex);
import org.opensearch.core.common.io.stream.Writeable;
                        lo = collect(doc, value, bucket, lo);
        return StarTreeQueryHelper.collectDimensionFilters(new MatchAllFilter(fieldName), subAggregators);
                }
        filterRewriteOptimizationContext.populateDebugInfo(add);
/*
    public ScoreMode scoreMode() {
         */
            @Override
            Aggregator parent,
        StarTreeBucketCollector parentCollector
import org.apache.lucene.search.ScoreMode;
        return super.scoreMode();
        try {
                int endMid = (endLo + endHi) >>> 1;
                    if (ranges[i].matches(value)) {
public class RangeAggregator extends BucketsAggregator implements StarTreePreComputeCollector {
            leafCollectorMode = LeafCollectionMode.NORMAL;
            private int collect(int doc, double value, long owningBucketOrdinal, int lowBound) throws IOException {
                MetricStat.DOC_COUNT.getTypeName()
        }
            return Objects.hash(key, from, fromAsStr, to, toAsStr);
                if (value < ranges[endMid].from) {
    }
import java.util.Map;
import static org.opensearch.search.aggregations.bucket.filterrewrite.AggregatorBridge.segmentMatchAll;
        public static final ParseField TO_FIELD = new ParseField("to");
    public final String fieldName;
            while (lo <= hi) {
        InternalAggregations subAggs = buildEmptySubAggregations();
        this.valuesSource = valuesSource;
import java.util.function.BiConsumer;
            // DOUBLE_OR_NULL accepts String, Number, and null
                        dimensionValue = ((NumberFieldMapper.NumberFieldType) context.mapperService().fieldType(fieldName)).toDoubleValue(
        public boolean equals(Object obj) {
import org.apache.lucene.search.DocIdSetIterator;
 * the Apache License, Version 2.0 (the "License"); you may
        private void computeMatchingRange(RangeAggregator.Range[] ranges, int lowBound, double value, double[] maxTo) {
     *
        }
 */
    @Override
 * Licensed to Elasticsearch under one or more contributor
        ValuesSourceConfig config
                    long dimensionLongValue = valuesIterator.nextValue();
        Map<String, Object> metadata,
            }
        public static final ConstructingObjectParser<Range, Void> PARSER = new ConstructingObjectParser<>("range", arg -> {
        public Range(String key, Double from, String fromAsStr, Double to, String toAsStr) {
                if (values.advanceExact(doc)) {
        public Unmapped(
            return value >= from && value < to;
        private final boolean keyed;
                                collectStarTreeBucket(this, metricValue, bucketOrd, starTreeEntry);
     * Unmapped range
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
            String fromStr = from instanceof String ? (String) from : null;
        public static final ParseField KEY_FIELD = new ParseField("key");
    /**
            Object to = arg[2];
    }
 * license agreements. See the NOTICE file distributed with
            int lo = lowBound, hi = ranges.length - 1;
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (Double.isFinite(from)) {
    }
 *
            }
import java.util.function.Function;
     * @opensearch.internal
            PARSER.declareField(optionalConstructorArg(), fromToParser, FROM_FIELD, ValueType.DOUBLE_OR_NULL);
            }
        this.fieldName = (valuesSource instanceof ValuesSource.Numeric.FieldData)
    }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        };
        RangeAggregatorBridge bridge = new RangeAggregatorBridge() {
                        dimensionValue = dimensionLongValue;
                keyed,
/*
                super.collectRange(min, max);
        }
    @Override
            super(name, context, parent, factories, metadata);
            preComputeWithStarTree(ctx, supportedStarTree);
        public double getTo() {
 * this file be licensed under the Apache-2.0 license or a
        @Override
            owningBucketOrds,
                builder.field(FROM_FIELD.getPreferredName(), from);
        }
        }
        protected final String key;
        protected final double from;
                        continue; // No matching range
import java.util.Objects;
            leafCollectorMode = LeafCollectionMode.FILTER_REWRITE;
 * Aggregate all docs that match given ranges.
            out.writeOptionalString(key);
        public String getToAsString() {
                }
    @Override
    final double[] maxTo;
                starTree.getField(),
    public StarTreeBucketCollector getStarTreeBucketCollector(
 * this work for additional information regarding copyright
            }
            Double toDouble = to instanceof Number ? ((Number) to).doubleValue() : null;
        public String getFromAsString() {
     */
        };
 * Modifications Copyright OpenSearch Contributors. See
            this.keyed = keyed;
        protected final String fromAsStr;
                checkCancelled();
import org.opensearch.index.mapper.NumberFieldMapper;
        CompositeIndexFieldInfo starTree,
        this.rangeFactory = rangeFactory;
import org.apache.lucene.index.LeafReaderContext;
            ? ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName()
            SearchContext context,
            parentCollector == null ? StarTreeQueryHelper.getStarTreeResult(starTreeValues, context, getDimensionFilters()) : null
 */
            from = in.readDouble();
            }
    /**
                && filterRewriteOptimizationContext.tryOptimize(ctx, this::incrementBucketDocCount, true, collectableSubAggregators);
    @Override
import org.opensearch.core.ParseField;
                range.to,
                MatchedRange range = new MatchedRange(ranges, lowBound, value, maxTo);
                    );
        String name,
        }
                    }
            @Override
            this.endHi = endHi;
    private void preComputeWithStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
            org.opensearch.search.aggregations.bucket.range.Range.Bucket bucket = rangeFactory.createBucket(
            PARSER.declareField(optionalConstructorArg(), (p, c) -> p.text(), KEY_FIELD, ValueType.DOUBLE); // DOUBLE supports string and
                    lo = mid + 1;
import java.util.List;
        }
        @Override
                }
                return null;
    @Override
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
import org.opensearch.search.aggregations.CardinalityUpperBound;
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
                this.startLo = lo;
            protected void prepare() {
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
    }
            );
            }
        public Range(String key, String from, String to) {
        public double getFrom() {
                    endLo = endMid + 1;
import java.util.ArrayList;
        maxTo[0] = this.ranges[0].to;
                    if (docCountsIterator.advanceExact(starTreeEntry)) {
                }
            protected Function<Object, Long> bucketOrdProducer() {
                    hi = mid - 1;
     * Range for the range aggregator
            return this.toAsStr;
            toAsStr = in.readOptionalString();
}
    }
            return factory.create(name, buckets, format, keyed, metadata());
                } else {
            this.factory = factory;
                for (Aggregator aggregator : subAggregators) {
            }
        StarTreeBucketCollector starTreeBucketCollector = getStarTreeBucketCollector(ctx, starTree, null);
    static class MatchedRange {
                    break;
            String toStr = to instanceof String ? (String) to : null;
        public Range(String key, Double from, Double to) {
    }
            );
                }
            Double fromDouble = from instanceof Number ? ((Number) from).doubleValue() : null;
            if (obj == null) {
            InternalRange.Factory factory,
            buckets -> rangeFactory.create(name, buckets, format, keyed, metadata())
 * SPDX-License-Identifier: Apache-2.0
                        for (int j = matchedRange.startLo; j <= matchedRange.endHi; ++j) {
                    // Only numeric & floating points are supported as of now in star-tree
import org.opensearch.search.aggregations.InternalAggregations;
                .getMetricValuesIterator(metricName);
            Range other = (Range) obj;
            out.writeDouble(to);
        public Range(StreamInput in) throws IOException {
            return Objects.equals(key, other.key)
import org.opensearch.core.common.io.stream.StreamInput;
        int numBits = matchingDocsBitSet.length();
            ranges.length,
    @Override
    final ValuesSource.Numeric valuesSource;
                            }
import org.opensearch.search.startree.filter.MatchAllFilter;
                    if (valuesSource.isFloatingPoint()) {
        // TODO: Evaluate optimizing StarTree traversal filter with specific ranges instead of MATCH_ALL_DEFAULT
        }
    }
        @Override
        assert valuesSource != null;
        return buildAggregationsForFixedBucketCount(
import org.opensearch.core.xcontent.ObjectParser.ValueType;
 */
