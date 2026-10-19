            return new Range(key, fromDouble, fromStr, toDouble, toStr);  
    @Override  
 *  
                MatchedRange range = new MatchedRange(ranges, lowBound, value, maxTo);  
                && Objects.equals(from, other.from)
import org.opensearch.search.aggregations.NonCollectingAggregator;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
    ) throws IOException {  
        InternalAggregations subAggs = buildEmptySubAggregations();
        private final R[] ranges;  
package org.opensearch.search.aggregations.bucket.range;
         * {@code toStr}.
/*  
            if (Double.isFinite(to)) {  
    final double[] maxTo;  
            }
        }
                if (value < ranges[mid].from) {
        boolean matches(double value) {  
import org.opensearch.search.aggregations.bucket.BucketsAggregator;  
        }
        }  
    public static final ParseField KEYED_FIELD = new ParseField("keyed");  
    @Override
            @Override
            toAsStr = in.readOptionalString();
                super.collect(stream, owningBucketOrd);  
    ) throws IOException {
/*
            }  
        }
            out.writeOptionalString(fromAsStr);
        }
            Range other = (Range) obj;  
                    startLo = startMid + 1;
            return builder;
            }  
    /**
                        collectBucket(sub, doc, subBucketOrdinal(owningBucketOrdinal, i));  
            }  
            private int collect(int doc, double value, long owningBucketOrdinal, int lowBound) throws IOException {
            for (Range range : ranges) {
            @Override
                    endLo = endMid + 1;
                    }
        if (numBits > 0) {
            computeMatchingRange(ranges, lowBound, value, maxTo);  
            }
            return factory.create(name, buckets, format, keyed, metadata());
                }  
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;  
                int endMid = (endLo + endHi) >>> 1;
                            if (ranges[j].matches(dimensionValue)) {  
            PARSER.declareField(optionalConstructorArg(), fromToParser, TO_FIELD, ValueType.DOUBLE_OR_NULL);
    @Override  
        maxTo[0] = this.ranges[0].to;  
         */  
import org.opensearch.search.aggregations.InternalAggregation;
        protected final String key;
    }  
        }
import java.util.function.BiConsumer;  
                } else if (value >= maxTo[mid]) {
            }
         * {@code from} and {@code to} parameters if they are non-null  
            InternalAggregations subAggs = buildEmptySubAggregations();
 * Aggregate all docs that match given ranges.
                builder.field(FROM_FIELD.getPreferredName(), fromAsStr);
        public String getToAsString() {
            return value >= from && value < to;
        public double getTo() {
        return buildAggregationsForFixedBucketCount(
import java.io.IOException;
        this.valuesSource = valuesSource;
                .getMetricValuesIterator(metricName);  
     */
                }
            assert endHi == ranges.length - 1 || value < ranges[endHi + 1].from;
        return new StarTreeBucketCollector(
        StarTreeBucketCollector parentCollector
import java.util.function.Function;
            while (startLo <= startHi) {
            }
            public void setSubCollectors() throws IOException {  
                }  
import org.opensearch.search.startree.filter.DimensionFilter;
                    endHi = endMid - 1;  
        String name,
    @Override
        ValuesSource.Numeric valuesSource,
                mid = (lo + hi) >>> 1;  
    @Override
            SearchContext context,
        if (supportedStarTree != null) {
import org.apache.lucene.search.DocIdSetIterator;
            R[] ranges,
                MetricStat.DOC_COUNT.getTypeName()
        public void writeTo(StreamOutput out) throws IOException {
                buckets.add(factory.createBucket(range.key, range.from, range.to, 0, subAggs, keyed, format));
        this.fieldName = (valuesSource instanceof ValuesSource.Numeric.FieldData)
        public int hashCode() {  
        }  
            builder.endObject();  
                builder.field(TO_FIELD.getPreferredName(), to);
    static class MatchedRange {
            };
                        );
import org.apache.lucene.search.ScoreMode;  
                range.to,
                    return p.doubleValue();
import org.apache.lucene.util.FixedBitSet;
            int startLo = lo, startHi = mid;  
    private long subBucketOrdinal(long owningBucketOrdinal, int rangeOrd) {
        }
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {  
    final InternalRange.Factory rangeFactory;
 * license agreements. See the NOTICE file distributed with
            return this.toAsStr;
        ) {
            return this.fromAsStr;
        boolean keyed,
import org.opensearch.search.internal.SearchContext;
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;
    public ScoreMode scoreMode() {
        this.ranges = ranges; // already sorted by the range.from and range.to  
                    return p.text();
            public void collect(int doc, long bucket) throws IOException {  
        }
        @Override  
                builder.field(TO_FIELD.getPreferredName(), toAsStr);
            }
            AggregatorFactories factories,
         */
            buckets.add(bucket);
        }
        int startLo, endHi;  
        public Range(String key, Double from, Double to) {  
                for (Aggregator aggregator : subAggregators) {
                return rangeFactory.createBucket(range.key, range.from, range.to, docCount, subAggregationResults, keyed, format);
        try {
        };
        for (int i = 0; i < ranges.length; i++) {  
        super.collectDebugInfo(add);
        this.rangeFactory = rangeFactory;
            fromAsStr = in.readOptionalString();
        @Override
                checkCancelled();  
                && Objects.equals(toAsStr, other.toAsStr);
    @Override
            }
 * the Apache License, Version 2.0 (the "License"); you may
         * and finite. Otherwise they parse from {@code fromrStr} and
            key = in.readOptionalString();  
                    } else {  
                    }
            String metricName = StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
                buildRanges(ranges);
 */
    }
                            }  
                return false;
    public static final ParseField RANGES_FIELD = new ParseField("ranges");
            }
                        dimensionValue = ((NumberFieldMapper.NumberFieldType) context.mapperService().fieldType(fieldName)).toDoubleValue(  
                return;
        AggregatorFactories factories,  
                for (int i = range.startLo; i <= range.endHi; ++i) {
        List<org.opensearch.search.aggregations.bucket.range.Range.Bucket> buckets = new ArrayList<>(ranges.length);
        public static final ParseField TO_FIELD = new ParseField("to");
                    // Only numeric & floating points are supported as of now in star-tree  
            while (lo <= hi) {
                int startMid = (startLo + startHi) >>> 1;
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
    }  
            Map<String, Object> metadata
            this.keyed = keyed;
 * @opensearch.internal
            );  
            protected Function<Object, Long> bucketOrdProducer() {
                range.key,  
import org.opensearch.core.common.io.stream.Writeable;
    }
/*
 * Modifications Copyright OpenSearch Contributors. See  
            return "[" + from + " to " + to + ")";  
                }  
            }
            protected void prepare() {  
            this.ranges = ranges;  
                super.collectRange(min, max);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
     * Range for the range aggregator
                && Objects.equals(to, other.to)
                ? matchingDocsBitSet.nextSetBit(bit + 1)
        ValuesSourceConfig config
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
        public String getKey() {
        public String toString() {
            Double fromDouble = from instanceof Number ? ((Number) from).doubleValue() : null;
            this.from = from == null ? Double.NEGATIVE_INFINITY : from;  
import org.opensearch.search.startree.StarTreeQueryHelper;  
            return Objects.equals(key, other.key)
        }
            builder.startObject();
            return true;
    }  
        return rangeFactory.create(name, buckets, format, keyed, metadata());
import org.opensearch.core.xcontent.ToXContentObject;  
        protected final String toAsStr;
            return segmentMatchAll(context, ctx)  
            this.key = key;
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);  
        }
                "_doc_count",
            }
import org.opensearch.search.aggregations.Aggregator;
            leafCollectorMode = LeafCollectionMode.FILTER_REWRITE;
                }
        );
            String key = (String) arg[0];
                    return;
import org.apache.lucene.index.LeafReaderContext;  
        CompositeIndexFieldInfo starTree,
            Aggregator parent,  
                if (p.currentToken() == XContentParser.Token.VALUE_STRING) {
            PARSER.declareField(optionalConstructorArg(), fromToParser, FROM_FIELD, ValueType.DOUBLE_OR_NULL);
        MatchedRange(RangeAggregator.Range[] ranges, int lowBound, double value, double[] maxTo) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            int lo = lowBound, hi = ranges.length - 1;
            }
/**
        }
            starTreeValues,
                if (value < ranges[endMid].from) {
                    lo = mid + 1;
                starTreeBucketCollector.collectStarTreeEntry(bit, 0);  
        public double getFrom() {
            }  
        };
            }
        this.format = format;  
         * Build the range. Generally callers should prefer
 */  
        assert valuesSource != null;
        public boolean equals(Object obj) {
        }
     * Unmapped range  
            @Override  
            this.fromAsStr = fromAsStr;
                        continue; // No matching range  
                } else {
            for (int bit = matchingDocsBitSet.nextSetBit(0); bit != DocIdSetIterator.NO_MORE_DOCS; bit = (bit + 1 < numBits)  
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
            }
        }  
        public String getFromAsString() {  
        private void computeMatchingRange(RangeAggregator.Range[] ranges, int lowBound, double value, double[] maxTo) {  
    @Override
            this.to = to == null ? Double.POSITIVE_INFINITY : to;
         * {@link Range#Range(String, Double, Double)} or  
import org.opensearch.index.compositeindex.datacube.MetricStat;
            @Override
        return StarTreeQueryHelper.collectDimensionFilters(new MatchAllFilter(fieldName), subAggregators);
            Object to = arg[2];
     *
                    // TODO: Add support for isBigInteger() when it gets supported in star-tree
        };
            int mid = (lo + hi) >>> 1;
    private final FilterRewriteOptimizationContext filterRewriteOptimizationContext;
                    startHi = startMid - 1;  
            out.writeOptionalString(key);  
            if (getClass() != obj.getClass()) {  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            assert startLo == lowBound || value >= maxTo[startLo - 1];  
 * compatible open source license.
            if (lo > hi) {
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    final DocValueFormat format;
        }
        Aggregator parent,
            preComputeWithStarTree(ctx, supportedStarTree);  
 * not use this file except in compliance with the License.
        return owningBucketOrdinal * ranges.length + rangeOrd;  
     * @opensearch.internal
        static {  
    final boolean keyed;  
                    if (ranges[i].matches(value)) {
                        lo = collect(doc, value, bucket, lo);
    }
        return super.scoreMode();
        FixedBitSet matchingDocsBitSet = starTreeBucketCollector.getMatchingDocsBitSet();
            public void collectStarTreeEntry(int starTreeEntry, long owningBucketOrd) throws IOException {  
        return new LeafBucketCollectorBase(sub, values) {
        /**
                return canOptimize(config, ranges);
import static org.opensearch.search.aggregations.bucket.filterrewrite.AggregatorBridge.segmentMatchAll;
import java.util.List;  
        // TODO: Evaluate optimizing StarTree traversal filter with specific ranges instead of MATCH_ALL_DEFAULT  
        protected final double from;
            if (Double.isFinite(from)) {  
    final ValuesSource.Numeric valuesSource;  
 * software distributed under the License is distributed on an
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
        Map<String, Object> metadata,  
            this(key, from, null, to, null);
        // value source can be null in the case of unmapped fields
        filterRewriteOptimizationContext = new FilterRewriteOptimizationContext(bridge, parent, subAggregators.length, context);  
            ? ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName()
            if (fromAsStr != null) {  
                && filterRewriteOptimizationContext.tryOptimize(ctx, this::incrementBucketDocCount, true, collectableSubAggregators);
 */
            while (endLo <= endHi) {  
 * KIND, either express or implied.  See the License for the
                if (values.advanceExact(doc)) {
        public Range(String key, String from, String to) {
    public static class Unmapped<R extends RangeAggregator.Range> extends NonCollectingAggregator {
            );
        public static final ConstructingObjectParser<Range, Void> PARSER = new ConstructingObjectParser<>("range", arg -> {
                keyed,
 * under the License.  
            }  
import org.opensearch.index.mapper.NumberFieldMapper;  
import org.opensearch.core.common.io.stream.StreamOutput;
    public RangeAggregator(
    }
import java.util.Objects;
 *
     * @opensearch.internal  
            this.format = format;
            }
            out.writeDouble(from);  
            // binary search the upper bound
            return Objects.hash(key, from, fromAsStr, to, toAsStr);
            // DOUBLE_OR_NULL accepts String, Number, and null  
import org.opensearch.core.xcontent.XContentParser;
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            return this.key;  
                return null;
     *
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        }
            this.toAsStr = toAsStr;  
                    break;
            owningBucketOrds,  
                    double dimensionValue;
            if (obj == null) {  
        }
            : null;  
            public void collectRange(int min, int max) throws IOException {
    public final String fieldName;
    }
                subAggs,
                        dimensionValue = dimensionLongValue;
    }  
     */  
        public Unmapped(
            leafCollectorMode = LeafCollectionMode.NORMAL;  
        @Override  
import org.opensearch.search.aggregations.CardinalityUpperBound;
                                                                                                            // number
                this.endHi = lo - 1;
            boolean keyed,  
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 1; i < this.ranges.length; ++i) {
    }  
 * specific language governing permissions and limitations
                this.startLo = lo;  
                }
import java.util.ArrayList;
                if (value >= maxTo[startMid]) {  
        this.keyed = keyed;
                        ((StarTreePreComputeCollector) aggregator.unwrapAggregator()).getStarTreeBucketCollector(ctx, starTree, this)  
    }  
        }  
            PARSER.declareField(optionalConstructorArg(), (p, c) -> p.text(), KEY_FIELD, ValueType.DOUBLE); // DOUBLE supports string and
        /**
                range.from,
import org.opensearch.search.aggregations.support.ValuesSource;  
                builder.field(KEY_FIELD.getPreferredName(), key);
            parentCollector == null ? StarTreeQueryHelper.getStarTreeResult(starTreeValues, context, getDimensionFilters()) : null  
                }  
    final Range[] ranges;
            SortedNumericStarTreeValuesIterator docCountsIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
import org.opensearch.core.common.io.stream.StreamInput;  
        ) throws IOException {  
                }
 * You may obtain a copy of the License at  
        int numBits = matchingDocsBitSet.length();  
 * ownership. Elasticsearch licenses this file to you under  
                        }
import org.opensearch.search.DocValueFormat;
        }  
import org.opensearch.search.aggregations.StarTreeBucketCollector;
        @Override
            @Override
 * SPDX-License-Identifier: Apache-2.0
        protected final String fromAsStr;  
            protected boolean canOptimize() {
 * Licensed to Elasticsearch under one or more contributor  
        if (valuesSource != null && valuesSource.needsScores()) {
         * <strong>must</strong> call this know that consumers prefer
 * Unless required by applicable law or agreed to in writing,
                return range.endHi + 1;  
                format  
                }
import org.opensearch.core.xcontent.ObjectParser.ValueType;
            ranges.length,
public class RangeAggregator extends BucketsAggregator implements StarTreePreComputeCollector {  
        }
 * this work for additional information regarding copyright
            buckets -> rangeFactory.create(name, buckets, format, keyed, metadata())
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils;  
                }  
            return ScoreMode.COMPLETE;  
}
        Range[] ranges,
        protected final double to;
                        for (int j = matchedRange.startLo; j <= matchedRange.endHi; ++j) {
                                collectStarTreeBucket(this, metricValue, bucketOrd, starTreeEntry);
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
        }  
import org.opensearch.search.aggregations.bucket.filterrewrite.RangeAggregatorBridge;
    public StarTreeBucketCollector getStarTreeBucketCollector(
        super(name, factories, context, parent, cardinality.multiply(ranges.length), metadata);  
                0,  
import org.opensearch.core.xcontent.ContextParser;
import org.opensearch.core.xcontent.XContentBuilder;
            Double toDouble = to instanceof Number ? ((Number) to).doubleValue() : null;  
                    }
    public void collectDebugInfo(BiConsumer<String, Object> add) {  
 *
            String toStr = to instanceof String ? (String) to : null;
        }  
            Range range = ranges[i];
                    MatchedRange matchedRange = new MatchedRange(ranges, 0, dimensionValue, maxTo);
            ContextParser<Void, Object> fromToParser = (p, c) -> {  
            from = in.readDouble();  
        public Range(String key, Double from, String fromAsStr, Double to, String toAsStr) {
        SearchContext context,  
                builder.field(FROM_FIELD.getPreferredName(), from);
 *  
        public static final ParseField FROM_FIELD = new ParseField("from");
                return (activeIndex) -> subBucketOrdinal(0, (int) activeIndex);  
                return false;
 * The OpenSearch Contributors require contributions made to  
        }
    public static class Range implements Writeable, ToXContentObject {
                    hi = mid - 1;  
            super(name, context, parent, factories, metadata);
                .getDimensionValuesIterator(fieldName);  
        }
            }
            },  
            DocValueFormat format,
        maxTo = new double[this.ranges.length];
            this.endHi = endHi;
            if (key != null) {  
        private final DocValueFormat format;  
import org.opensearch.search.aggregations.LeafBucketCollector;
            out.writeOptionalString(toAsStr);
            this.factory = factory;  
                Range range = ranges[offsetInOwningOrd];
            Object from = arg[1];  
            @Override  
                && Objects.equals(fromAsStr, other.fromAsStr)  
        @Override
                if (!valuesIterator.advanceExact(starTreeEntry)) {
                    this.subCollectors.add(
                if (p.currentToken() == XContentParser.Token.VALUE_NUMBER) {
import org.opensearch.search.aggregations.AggregatorFactories;  
        }
                } else {
            (offsetInOwningOrd, docCount, subAggregationResults) -> {
                } else {  
        DocValueFormat format,
            List<org.opensearch.search.aggregations.bucket.range.Range.Bucket> buckets = new ArrayList<>(ranges.length);  
                    }
                    if (docCountsIterator.advanceExact(starTreeEntry)) {  
                    long dimensionLongValue = valuesIterator.nextValue();  
import org.apache.lucene.search.DocIdStream;
        public static final ParseField KEY_FIELD = new ParseField("key");  
            }
            @Override
            SortedNumericStarTreeValuesIterator valuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
         * {@link Range#Range(String, String, String)}. If you
            return this.to;  
    }  
                    if (matchedRange.startLo > matchedRange.endHi) {
        });
        @Override
            this.startLo = startLo;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.search.aggregations.InternalAggregations;  
    }  
        filterRewriteOptimizationContext.populateDebugInfo(add);
            String fromStr = from instanceof String ? (String) from : null;
                            dimensionLongValue
                                long bucketOrd = subBucketOrdinal(owningBucketOrd, j);
    public InternalAggregation buildEmptyAggregation() {  
        CardinalityUpperBound cardinality,
 */
            to = in.readDouble();
            String name,  
                        final double value = values.nextValue();
                    for (int i = 0, lo = 0; i < valuesCount; ++i) {  
        private final boolean keyed;
        private final InternalRange.Factory factory;
                starTree.getField(),  
import java.util.Map;
 * GitHub history for details.
                    }  
                    );
            if (toAsStr != null) {  
            }
    /**  
            return this.from;
    @Override
            InternalRange.Factory factory,
        LeafReaderContext ctx,  
            org.opensearch.search.aggregations.bucket.range.Range.Bucket bucket = rangeFactory.createBucket(
            // binary search the lower bound
        RangeAggregatorBridge bridge = new RangeAggregatorBridge() {
                    final int valuesCount = values.docValueCount();
import org.opensearch.search.startree.filter.MatchAllFilter;
            maxTo[i] = Math.max(this.ranges[i].to, maxTo[i - 1]);
            @Override
        public InternalAggregation buildEmptyAggregation() {
    }  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
                        long metricValue = docCountsIterator.nextValue();
            int endLo = mid, endHi = hi;
            this(key, null, from, null, to);
import org.opensearch.core.ParseField;
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
         * Read from a stream.  
            out.writeDouble(to);
                    if (valuesSource.isFloatingPoint()) {
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
        } finally {
        StarTreeBucketCollector starTreeBucketCollector = getStarTreeBucketCollector(ctx, starTree, null);  
        public Range(StreamInput in) throws IOException {
    private void preComputeWithStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
                : DocIdSetIterator.NO_MORE_DOCS) {
    public List<DimensionFilter> getDimensionFilters() {  
        InternalRange.Factory rangeFactory,  
