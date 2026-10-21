                    froms[i] = values.lookupTerm(ranges[i].from);
            int lo = lowBound, hi = ranges.length - 1; // all candidates are between these indexes
/**
                    throw new IllegalArgumentException("Ranges must be sorted");
            this.sub = sub;
import org.apache.lucene.index.LeafReaderContext;
                    break;
 *
        if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals) {
            SortedSetDocValues values = ((ValuesSource.Bytes.WithOrdinals) valuesSource).ordinalsValues(ctx);
                protected void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException {
                    break;
                    hi = mid - 1;
            this.values = values;
                mid = (lo + hi) >>> 1;
                if (ord < froms[endMid]) {
    }
        boolean keyed,
            if (lo > hi) return lo; // no potential candidate
        );
            while (lo <= hi) {
            return new SortedBinaryRangeLeafCollector(values, ranges, sub) {
import org.opensearch.search.internal.SearchContext;
    public ScoreMode scoreMode() {
            maxTos = new long[ranges.length];
                    collectBucket(sub, doc, bucket);
    }
                } else if (compare(value, maxTos[mid], -1) >= 0) {
                    froms[i] = 0;
}
                    lo = mid + 1;
 * Modifications Copyright OpenSearch Contributors. See
            int startLo = lo, startHi = mid;
     * Leaf collector for the sorted set range
                for (int i = 0; i < values.docValueCount(); i++) {
        CardinalityUpperBound cardinality,
            while (startLo <= startHi) {
        }
                    collectBucket(sub, doc, bucket);
                } else {
        public void collect(int doc, long bucket) throws IOException {
        final LeafBucketCollector sub;
            int mid = (lo + hi) >>> 1;
     */
                }
        this.valuesSource = (ValuesSource.Bytes) valuesSource;
import org.opensearch.search.aggregations.Aggregator;
    @Override
                        froms[i] = -1 - froms[i];
 */
                }
        final String key;
                    lo = collect(doc, ord, bucket, lo);
 */
            int endLo = mid, endHi = hi;
                    endHi = endMid - 1;
            }
        if (valuesSource != null && valuesSource.needsScores()) {
     *
                @Override
    /**
                    if (ord < 0) {
                    startLo = startMid + 1;
            };
 * GitHub history for details.
 * this work for additional information regarding copyright
                    doCollect(sub, doc, bucket * froms.length + i);
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
                int lo = 0;
        SortedBinaryRangeLeafCollector(SortedBinaryDocValues values, Range[] ranges, LeafBucketCollector sub) {
            }
            int mid = (lo + hi) >>> 1;
 * Licensed to Elasticsearch under one or more contributor
        final BytesRef[] maxTos;
            return ScoreMode.COMPLETE;
 *
            maxTos[0] = tos[0];
            // binary search the upper bound
        }
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
                    long ord = values.lookupTerm(ranges[i].to);
        @Override
                }
        super(name, factories, context, parent, cardinality.multiply(ranges.size()), metadata);
        } else {
            }
            tos = new long[ranges.length]; // inclusive
import org.opensearch.search.aggregations.AggregatorFactories;
    }
                } else {
                    startHi = startMid - 1;
            this.key = key;
    public BinaryRangeAggregator(
import org.opensearch.search.aggregations.support.ValuesSource;
        DocValueFormat format,
                    maxTos[i] = ranges[i].to;
                }
            }
    }
            this.from = from;
    @Override
     * @opensearch.internal
            for (int i = 1; i < ranges.length; ++i) {
            maxTos = new BytesRef[ranges.length];
            this.values = values;
                if (ord < froms[mid]) {
                }
                } else {
            if (values.advanceExact(doc)) {
            while (startLo <= startHi) {
        }
                mid = (lo + hi) >>> 1;
            int startLo = lo, startHi = mid;
                if (ord > maxTos[startMid]) {
            }
import java.util.Map;
                if (ranges[i].from == null) {
            for (int i = 0; i < ranges.length; ++i) {
                    if (froms[i] < 0) {
                }
    final DocValueFormat format;
                if (compare(value, maxTos[startMid], -1) >= 0) {
/*
                final int endMid = (endLo + endHi) >>> 1;
                    endLo = endMid + 1;
                } else {
 *
    }
                }
     * @opensearch.internal
                return new InternalBinaryRange.Bucket(format, keyed, range.key, range.from, range.to, docCount, subAggregationResults);
        @Override
    abstract static class SortedBinaryRangeLeafCollector extends LeafBucketCollectorBase {
                }
                if (RANGE_COMPARATOR.compare(ranges[i - 1], ranges[i]) > 0) {
        return new InternalBinaryRange(name, format, keyed, emptyList(), metadata());
            this.to = to;
        }
                protected void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException {
            while (lo <= hi) {
            int endLo = mid, endHi = hi;
 * A range aggregator for values that are stored in SORTED_SET doc values.
        if (cmp == 0) {
                }
                if (ord <= tos[i]) {
     *
        Aggregator parent,
        this.format = format;
                    endLo = endMid + 1;
            froms = new long[ranges.length];
                }
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
    ) throws IOException {
            for (int i = 1; i < ranges.length; ++i) {
        return a == null ? b == null ? 0 : -m : b == null ? m : a.compareTo(b);
        this.ranges = ranges.toArray(new Range[0]);
                } else {
            // binary search the lower bound
                    tos[i] = values.getValueCount() - 1;
        }
                } else if (ord > maxTos[mid]) {
public final class BinaryRangeAggregator extends BucketsAggregator {
                }
    static final Comparator<Range> RANGE_COMPARATOR = (a, b) -> {
    public InternalAggregation buildEmptyAggregation() {
                if (compare(value, ranges[mid].from, 1) < 0) {
            cmp = compare(a.to, b.to, -1);
                    }
            return endHi + 1;
import org.opensearch.search.DocValueFormat;
            }
 * compatible open source license.
        }
        return super.scoreMode();
        protected abstract void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException;
                for (int i = 0, lo = 0; i < valuesCount; ++i) {
                    startLo = startMid + 1;
import java.util.Comparator;
 */
 * under the License.
import java.io.IOException;
                Range range = ranges[offsetInOwningOrd];
        protected abstract void doCollect(LeafBucketCollector sub, int doc, long bucket) throws IOException;
                }
        ValuesSource valuesSource,
 * The OpenSearch Contributors require contributions made to
    }
            for (int i = startLo; i <= endHi; ++i) {
            }
        int cmp = compare(a.from, b.from, 1);
                }
            for (int i = startLo; i <= endHi; ++i) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
                final int startMid = (startLo + startHi) >>> 1;
            }
    /**
                    endHi = endMid - 1;
            ranges.length,
    final Range[] ranges;
            super(sub, values);
                    final BytesRef value = values.nextValue();
                        break;
import org.opensearch.search.aggregations.LeafBucketCollector;
                    if (ord == SortedSetDocValues.NO_MORE_DOCS) {
     * Base class for a sorted binary range leaf collector
            this.sub = sub;
        private int collect(int doc, BytesRef value, long bucket, int lowBound) throws IOException {
import org.opensearch.search.aggregations.CardinalityUpperBound;
                if (RANGE_COMPARATOR.compare(ranges[i - 1], ranges[i]) > 0) {
                    } else {
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                } else {
                    throw new IllegalArgumentException("Ranges must be sorted");
        public void collect(int doc, long bucket) throws IOException {
/*
        return buildAggregationsForFixedBucketCount(
    final ValuesSource.Bytes valuesSource;
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
            assert endHi == froms.length - 1 || ord < froms[endHi + 1];
import org.apache.lucene.index.SortedSetDocValues;
            },
                }
            assert endHi == ranges.length - 1 || compare(value, ranges[endHi + 1].from, 1) < 0;
        final long[] froms, tos, maxTos;
import java.util.List;
            super(sub, values);
        final SortedSetDocValues values;
        return cmp;
 * Unless required by applicable law or agreed to in writing,
        public Range(String key, BytesRef from, BytesRef to) {
     */
        }
import org.apache.lucene.search.ScoreMode;
                if (compare(value, ranges[i].to, -1) < 0) {
            assert startLo == lowBound || ord > maxTos[startLo - 1];
    final boolean keyed;
                } else {
        private int collect(int doc, long ord, long bucket, int lowBound) throws IOException {
            (offsetInOwningOrd, docCount, subAggregationResults) -> {
                        tos[i] = ord - 1;
package org.opensearch.search.aggregations.bucket.range;
        SortedSetRangeLeafCollector(SortedSetDocValues values, Range[] ranges, LeafBucketCollector sub) throws IOException {
            buckets -> new InternalBinaryRange(name, format, keyed, buckets, metadata())
     */
                maxTos[0] = ranges[0].to;
    abstract static class SortedSetRangeLeafCollector extends LeafBucketCollectorBase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        tos[i] = -2 - ord;
        if (valuesSource == null) {
                if (ranges[i].to == null) {
    };
                maxTos[i] = Math.max(maxTos[i - 1], tos[i]);
 * not use this file except in compliance with the License.
            return LeafBucketCollector.NO_OP_COLLECTOR;
import org.opensearch.index.fielddata.SortedBinaryDocValues;
 * You may obtain a copy of the License at
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
            // binary search the upper bound
                    doCollect(sub, doc, bucket * ranges.length + i);
        SearchContext context,
                } else {
            return new SortedSetRangeLeafCollector(values, ranges, sub) {
                } else {
        this.keyed = keyed;
            }
                final int valuesCount = values.docValueCount();
                }
            this.ranges = ranges;
            while (endLo <= endHi) {
    /**
     * @opensearch.internal
        }
import org.opensearch.search.aggregations.InternalAggregation;
 * @opensearch.internal
            }
                    }
            }
            while (endLo <= endHi) {
            }
                if (compare(value, ranges[endMid].from, 1) < 0) {
import static java.util.Collections.emptyList;
        String name,
                @Override
    }
            if (values.advanceExact(doc)) {
        final Range[] ranges;
        final SortedBinaryDocValues values;
                }
        Arrays.sort(this.ranges, RANGE_COMPARATOR);
                final int endMid = (endLo + endHi) >>> 1;
    @Override
 *
     *
                    hi = mid - 1;
    }
    private static int compare(BytesRef a, BytesRef b, int m) {
            // binary search the lower bound
        }
            assert startLo == lowBound || compare(value, maxTos[startLo - 1], -1) >= 0;
            if (lo > hi) return lo; // no potential candidate
/*
        Map<String, Object> metadata
 * software distributed under the License is distributed on an
        final BytesRef from, to;
                    }
 * ownership. Elasticsearch licenses this file to you under
            return endHi + 1;
                final int startMid = (startLo + startHi) >>> 1;
 * license agreements. See the NOTICE file distributed with
        }
            }
 */
                    startHi = startMid - 1;
            }
    public static class Range {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            if (ranges.length > 0) {
import java.util.Arrays;
            for (int i = 1; i < ranges.length; ++i) {
    @Override
     * Range for the binary range agg
        List<Range> ranges,
            for (int i = 1; i < tos.length; ++i) {
                    lo = mid + 1;
            };
import org.apache.lucene.util.BytesRef;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            int lo = lowBound, hi = froms.length - 1; // all candidates are between these indexes
            }
                    maxTos[i] = maxTos[i - 1];
            owningBucketOrds,
                    lo = collect(doc, value, bucket, lo);
        final LeafBucketCollector sub;
        AggregatorFactories factories,
        }
                    long ord = values.nextOrd();
                if (compare(ranges[i].to, maxTos[i - 1], -1) >= 0) {
