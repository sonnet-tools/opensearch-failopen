                if (ord < froms[endMid]) {
     *  
            while (startLo <= startHi) {
            int endLo = mid, endHi = hi;  
import org.opensearch.index.fielddata.SortedBinaryDocValues;
import java.util.Map;
                        tos[i] = ord - 1;
                    endHi = endMid - 1;
                    startLo = startMid + 1;
        }
            froms = new long[ranges.length];  
/*
        Aggregator parent,
        return buildAggregationsForFixedBucketCount(  
                if (ranges[i].to == null) {  
            while (lo <= hi) {  
                mid = (lo + hi) >>> 1;  
                maxTos[0] = ranges[0].to;
     * @opensearch.internal
                        froms[i] = -1 - froms[i];  
            while (startLo <= startHi) {  
                final int endMid = (endLo + endHi) >>> 1;  
                    endLo = endMid + 1;  
                } else {
    final DocValueFormat format;
                    doCollect(sub, doc, bucket * ranges.length + i);  
                    }
            }
        DocValueFormat format,  
        Arrays.sort(this.ranges, RANGE_COMPARATOR);
import org.opensearch.search.aggregations.CardinalityUpperBound;
                    endHi = endMid - 1;
            owningBucketOrds,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.bucket.BucketsAggregator;  
 * A range aggregator for values that are stored in SORTED_SET doc values.
        final String key;
import java.util.List;
        boolean keyed,
            int mid = (lo + hi) >>> 1;  
 */
                @Override
        Map<String, Object> metadata  
                }  
        private int collect(int doc, long ord, long bucket, int lowBound) throws IOException {
            assert endHi == froms.length - 1 || ord < froms[endHi + 1];  
                    } else {  
/*  
                    collectBucket(sub, doc, bucket);
        SortedSetRangeLeafCollector(SortedSetDocValues values, Range[] ranges, LeafBucketCollector sub) throws IOException {  
            }  
                if (compare(ranges[i].to, maxTos[i - 1], -1) >= 0) {
import org.opensearch.search.aggregations.LeafBucketCollector;
                    froms[i] = 0;
            this.from = from;
        if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals) {  
        }  
            this.key = key;  
                final int startMid = (startLo + startHi) >>> 1;
                for (int i = 0; i < values.docValueCount(); i++) {  
            cmp = compare(a.to, b.to, -1);  
     * @opensearch.internal
 *
            }  
                    throw new IllegalArgumentException("Ranges must be sorted");  
                } else {
                @Override  
                final int endMid = (endLo + endHi) >>> 1;
 * the Apache License, Version 2.0 (the "License"); you may
            buckets -> new InternalBinaryRange(name, format, keyed, buckets, metadata())
                if (compare(value, ranges[i].to, -1) < 0) {
            };  
                    lo = mid + 1;
            this.values = values;  
        return a == null ? b == null ? 0 : -m : b == null ? m : a.compareTo(b);  
                        tos[i] = -2 - ord;
import static java.util.Collections.emptyList;
/**  
        }
            this.ranges = ranges;
     * Base class for a sorted binary range leaf collector  
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                Range range = ranges[offsetInOwningOrd];
public final class BinaryRangeAggregator extends BucketsAggregator {
        }
            assert startLo == lowBound || compare(value, maxTos[startLo - 1], -1) >= 0;
        this.format = format;
import org.opensearch.search.aggregations.support.ValuesSource;
 * Modifications Copyright OpenSearch Contributors. See  
        return cmp;
                    lo = mid + 1;
package org.opensearch.search.aggregations.bucket.range;
     * @opensearch.internal
                if (compare(value, ranges[mid].from, 1) < 0) {
                final int valuesCount = values.docValueCount();
            super(sub, values);
        protected abstract void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException;
import org.apache.lucene.util.BytesRef;  
            this.values = values;
                mid = (lo + hi) >>> 1;
                    throw new IllegalArgumentException("Ranges must be sorted");
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * specific language governing permissions and limitations
            maxTos = new BytesRef[ranges.length];  
            return new SortedSetRangeLeafCollector(values, ranges, sub) {
                if (RANGE_COMPARATOR.compare(ranges[i - 1], ranges[i]) > 0) {  
            while (lo <= hi) {
            SortedSetDocValues values = ((ValuesSource.Bytes.WithOrdinals) valuesSource).ordinalsValues(ctx);
     *
            if (lo > hi) return lo; // no potential candidate
                    endLo = endMid + 1;
            int mid = (lo + hi) >>> 1;
                }  
            for (int i = 1; i < tos.length; ++i) {  
            for (int i = 1; i < ranges.length; ++i) {
                } else if (compare(value, maxTos[mid], -1) >= 0) {  
    public static class Range {  
        }  
                    maxTos[i] = maxTos[i - 1];
 * ownership. Elasticsearch licenses this file to you under  
    /**
        }
        this.valuesSource = (ValuesSource.Bytes) valuesSource;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    final BytesRef value = values.nextValue();  
        final LeafBucketCollector sub;
                } else {  
        ValuesSource valuesSource,
                    if (ord == SortedSetDocValues.NO_MORE_DOCS) {
                    break;  
                }
                final int startMid = (startLo + startHi) >>> 1;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            tos = new long[ranges.length]; // inclusive
            for (int i = 1; i < ranges.length; ++i) {
    }
                if (ranges[i].from == null) {
    private static int compare(BytesRef a, BytesRef b, int m) {
    }  
import org.apache.lucene.index.SortedSetDocValues;
        }  
 * Licensed to Elasticsearch under one or more contributor  
        CardinalityUpperBound cardinality,
                    collectBucket(sub, doc, bucket);
                } else {
            return endHi + 1;
        final SortedSetDocValues values;  
                }
            for (int i = 0; i < ranges.length; ++i) {  
                    startHi = startMid - 1;
        protected abstract void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException;
                    doCollect(sub, doc, bucket * froms.length + i);
        @Override
                    }
                }
        AggregatorFactories factories,
        final long[] froms, tos, maxTos;
                } else {
            }  
        private int collect(int doc, BytesRef value, long bucket, int lowBound) throws IOException {  
        return super.scoreMode();
            ranges.length,
                }  
                } else {  
    @Override
                    maxTos[i] = ranges[i].to;  
/*
                }
        if (cmp == 0) {
 * this work for additional information regarding copyright
        final SortedBinaryDocValues values;
            // binary search the lower bound  
                protected void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException {  
import java.util.Comparator;  
                }
        SearchContext context,  
            super(sub, values);  
        } else {
 * KIND, either express or implied.  See the License for the
                }
    }
                for (int i = 0, lo = 0; i < valuesCount; ++i) {
        @Override
 */  
            }  
            }
 * this file be licensed under the Apache-2.0 license or a
        int cmp = compare(a.from, b.from, 1);
 * software distributed under the License is distributed on an
            this.sub = sub;
                }
     *  
import org.apache.lucene.index.LeafReaderContext;  
    public ScoreMode scoreMode() {  
            if (lo > hi) return lo; // no potential candidate
            },  
        if (valuesSource == null) {  
                    lo = collect(doc, value, bucket, lo);
                    if (ord < 0) {
 */
                }
        final LeafBucketCollector sub;  
                    startLo = startMid + 1;  
 * @opensearch.internal  
                }  
     * Range for the binary range agg
            // binary search the upper bound  
            // binary search the upper bound
            };
}  
            int startLo = lo, startHi = mid;
            }
        final BytesRef from, to;  
            int lo = lowBound, hi = froms.length - 1; // all candidates are between these indexes
    static final Comparator<Range> RANGE_COMPARATOR = (a, b) -> {  
    /**
import java.util.Arrays;
import org.opensearch.search.aggregations.Aggregator;  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
 * GitHub history for details.
        public Range(String key, BytesRef from, BytesRef to) {
    abstract static class SortedSetRangeLeafCollector extends LeafBucketCollectorBase {  
 *
 * compatible open source license.
            }  
            }
import org.opensearch.search.internal.SearchContext;
                if (ord < froms[mid]) {
                    long ord = values.nextOrd();
    };  
                return new InternalBinaryRange.Bucket(format, keyed, range.key, range.from, range.to, docCount, subAggregationResults);
        );
import org.opensearch.search.DocValueFormat;
            int lo = lowBound, hi = ranges.length - 1; // all candidates are between these indexes
                    if (froms[i] < 0) {
            maxTos[0] = tos[0];
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);  
        }  
        super(name, factories, context, parent, cardinality.multiply(ranges.size()), metadata);
                if (ord > maxTos[startMid]) {
            this.to = to;
    }
    final boolean keyed;
            }
    /**
import org.opensearch.search.aggregations.InternalAggregation;  
            }
 * Unless required by applicable law or agreed to in writing,
            }
import org.opensearch.search.aggregations.AggregatorFactories;
                } else if (ord > maxTos[mid]) {
 *
                    froms[i] = values.lookupTerm(ranges[i].from);
                if (RANGE_COMPARATOR.compare(ranges[i - 1], ranges[i]) > 0) {
        public void collect(int doc, long bucket) throws IOException {
                } else {  
    final ValuesSource.Bytes valuesSource;  
    }
    final Range[] ranges;  
        List<Range> ranges,
        String name,  
                if (ord <= tos[i]) {  
            int endLo = mid, endHi = hi;
    ) throws IOException {
                maxTos[i] = Math.max(maxTos[i - 1], tos[i]);
    }  
 */
            if (ranges.length > 0) {
import java.io.IOException;
            return ScoreMode.COMPLETE;
    }
    public InternalAggregation buildEmptyAggregation() {  
    @Override
            return new SortedBinaryRangeLeafCollector(values, ranges, sub) {
                if (compare(value, maxTos[startMid], -1) >= 0) {
 * under the License.  
        final Range[] ranges;  
     */  
                    break;
                }
                if (compare(value, ranges[endMid].from, 1) < 0) {  
            assert startLo == lowBound || ord > maxTos[startLo - 1];
            (offsetInOwningOrd, docCount, subAggregationResults) -> {  
    public BinaryRangeAggregator(
                int lo = 0;
            for (int i = startLo; i <= endHi; ++i) {
        SortedBinaryRangeLeafCollector(SortedBinaryDocValues values, Range[] ranges, LeafBucketCollector sub) {
                    tos[i] = values.getValueCount() - 1;
        final BytesRef[] maxTos;
        }
            }
        this.ranges = ranges.toArray(new Range[0]);  
                }  
            int startLo = lo, startHi = mid;
            for (int i = 1; i < ranges.length; ++i) {
            }  
        this.keyed = keyed;
        public void collect(int doc, long bucket) throws IOException {  
     * Leaf collector for the sorted set range
                    lo = collect(doc, ord, bucket, lo);
 * The OpenSearch Contributors require contributions made to  
                        break;  
            while (endLo <= endHi) {
            for (int i = startLo; i <= endHi; ++i) {
     */
            maxTos = new long[ranges.length];
            this.sub = sub;
                }
                    startHi = startMid - 1;
            // binary search the lower bound
        if (valuesSource != null && valuesSource.needsScores()) {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
        }
    }  
            while (endLo <= endHi) {
                }
            return endHi + 1;
            if (values.advanceExact(doc)) {
    @Override
                } else {
 * You may obtain a copy of the License at  
    abstract static class SortedBinaryRangeLeafCollector extends LeafBucketCollectorBase {
    }
                    }
                } else {  
            if (values.advanceExact(doc)) {  
                protected void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException {
            return LeafBucketCollector.NO_OP_COLLECTOR;
     */
            }  
                    hi = mid - 1;  
 *  
        return new InternalBinaryRange(name, format, keyed, emptyList(), metadata());
            }
 * not use this file except in compliance with the License.
                    hi = mid - 1;
            assert endHi == ranges.length - 1 || compare(value, ranges[endHi + 1].from, 1) < 0;
import org.apache.lucene.search.ScoreMode;
        }
                }
                    long ord = values.lookupTerm(ranges[i].to);  
