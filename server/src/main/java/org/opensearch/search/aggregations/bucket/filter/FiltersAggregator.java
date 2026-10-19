        Aggregator parent,
        }
import org.opensearch.search.aggregations.AggregatorFactories;
        public boolean equals(Object obj) {
        this.showOtherBucket = otherBucketKey != null;
 * this file be licensed under the Apache-2.0 license or a
    private final String[] keys;
        return buildAggregationsForFixedBucketCount(
            buckets -> new InternalFilters(name, buckets, keyed, metadata())
        boolean keyed,
        final Bits[] bits = new Bits[filters.length];
         * Read from a stream.
            (offsetInOwningOrd, docCount, subAggregationResults) -> {
import org.opensearch.common.lucene.Lucene;
                    }
            public void collect(int doc, long bucket) throws IOException {
    private final boolean keyed;
import org.opensearch.search.internal.SearchContext;
public class FiltersAggregator extends BucketsAggregator {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
     * Keyed filter for the filters agg
package org.opensearch.search.aggregations.bucket.filter;
 *
        SearchContext context,
            @Override
        @Override
 * not use this file except in compliance with the License.
    public static class KeyedFilter implements Writeable, ToXContentFragment {
            this.key = key;
 * You may obtain a copy of the License at
            owningBucketOrds,
 */
            key = in.readString();
 * Unless required by applicable law or agreed to in writing,
    public static final ParseField OTHER_BUCKET_KEY_FIELD = new ParseField("other_bucket_key");
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * the Apache License, Version 2.0 (the "License"); you may
            keys.length + (showOtherBucket ? 1 : 0),
     * @opensearch.internal
        return new LeafBucketCollectorBase(sub, null) {
                }
import org.opensearch.core.xcontent.XContentBuilder;
            }
                    collectBucket(sub, doc, bucketOrd(bucket, bits.length));
    }
        }
 * software distributed under the License is distributed on an
import org.opensearch.core.ParseField;
    private final boolean showOtherBucket;
            out.writeNamedWriteable(filter);
        @Override
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
        public KeyedFilter(StreamInput in) throws IOException {
                throw new IllegalArgumentException("[key] must not be null");
        }
    private final String otherBucketKey;
        Map<String, Object> metadata
        return new InternalFilters(name, buckets, keyed, metadata());
                    return new InternalFilters.InternalBucket(keys[offsetInOwningOrd], docCount, subAggregationResults, keyed);
            this.filter = filter;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        );
            public void collectRange(int min, int max) throws IOException {
    public InternalAggregation buildEmptyAggregation() {
        return owningBucketOrdinal * totalNumKeys + filterOrd;
            if (getClass() != obj.getClass()) {
        } else {
            }
    final long bucketOrd(long owningBucketOrdinal, int filterOrd) {
/*
            @Override
        InternalAggregations subAggs = buildEmptySubAggregations();
import java.util.function.Supplier;
import org.apache.lucene.index.LeafReaderContext;
                return false;
 * KIND, either express or implied.  See the License for the
            return Objects.hash(key, filter);
}
    }
                return false;
            filter = in.readNamedWriteable(QueryBuilder.class);
            bits[i] = Lucene.asSequentialAccessBits(ctx.reader().maxDoc(), filters[i].scorerSupplier(ctx));
        private final String key;
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
    private Supplier<Weight[]> filters;
        private final QueryBuilder filter;
    ) throws IOException {
    @Override
            buckets.add(bucket);
            KeyedFilter other = (KeyedFilter) obj;
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.common.io.stream.StreamInput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (offsetInOwningOrd < keys.length) {
            InternalFilters.InternalBucket bucket = new InternalFilters.InternalBucket(keys[i], 0, subAggs, keyed);
        }
    @Override
        Weight[] filters = this.filters.get();
        public KeyedFilter(String key, QueryBuilder filter) {
            }
            }
        if (showOtherBucket) {
import org.opensearch.search.aggregations.LeafBucketCollector;
import org.opensearch.core.xcontent.ToXContentFragment;
            if (filter == null) {
            buckets.add(bucket);
 * under the License.
import org.opensearch.index.query.QueryBuilder;
import org.apache.lucene.search.Weight;
        public String key() {
import org.opensearch.search.aggregations.InternalAggregation;
        for (int i = 0; i < keys.length; i++) {
    }
    public FiltersAggregator(
            this.totalNumKeys = keys.length;
        this.filters = filters;
        Supplier<Weight[]> filters,
            if (key == null) {
 * compatible open source license.
            }
    @Override
                    if (bits[i].get(doc)) {
import org.opensearch.core.common.io.stream.StreamOutput;
        public QueryBuilder filter() {
        @Override
            if (obj == null) {
/*
            builder.field(key, filter);
        }
 * this work for additional information regarding copyright
 *
                }
import org.opensearch.search.aggregations.InternalAggregations;
                for (int i = 0; i < bits.length; i++) {
        public int hashCode() {
import java.util.Map;
import org.opensearch.search.aggregations.CardinalityUpperBound;
            InternalFilters.InternalBucket bucket = new InternalFilters.InternalBucket(otherBucketKey, 0, subAggs, keyed);
    public static final ParseField OTHER_BUCKET_FIELD = new ParseField("other_bucket");
            return key;
        }
 * GitHub history for details.
            return filter;
 * ownership. Elasticsearch licenses this file to you under
    public static final ParseField FILTERS_FIELD = new ParseField("filters");
 * @opensearch.internal
 */
import java.util.ArrayList;
            return Objects.equals(key, other.key) && Objects.equals(filter, other.filter);
        };
            out.writeString(key);
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    }
        // no need to provide deleted docs to the filter
        }
                boolean matched = false;
import org.apache.lucene.util.Bits;
import org.apache.lucene.search.DocIdStream;
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
import java.util.Objects;
    }
 * The OpenSearch Contributors require contributions made to
 * specific language governing permissions and limitations
        }
        }
        String otherBucketKey,
        super(name, factories, context, parent, cardinality.multiply(keys.length + (otherBucketKey == null ? 0 : 1)), metadata);
 *
        public void writeTo(StreamOutput out) throws IOException {
        }
        String name,
 * SPDX-License-Identifier: Apache-2.0
        this.keys = keys;
        this.otherBucketKey = otherBucketKey;
        this.keyed = keyed;
            }
        CardinalityUpperBound cardinality,
     *
            }
        }
        String[] keys,
        AggregatorFactories factories,
import java.util.List;
         */
        /**
        if (showOtherBucket) {
    /**
import org.opensearch.search.aggregations.Aggregator;
            return builder;
/*
            @Override
 */
 */
     */
                return new InternalFilters.InternalBucket(otherBucketKey, docCount, subAggregationResults, keyed);
 * license agreements. See the NOTICE file distributed with
                super.collect(stream, owningBucketOrd);
                checkCancelled();
                super.collectRange(min, max);
            this.totalNumKeys = keys.length + 1;
/**
        for (int i = 0; i < filters.length; ++i) {
                throw new IllegalArgumentException("[filter] must not be null");
 * Aggregate all docs that match multiple filters.
    private final int totalNumKeys;
            },
        List<InternalFilters.InternalBucket> buckets = new ArrayList<>(keys.length);
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
                if (showOtherBucket && !matched) {
                        matched = true;
    }
                        collectBucket(sub, doc, bucketOrd(bucket, i));
                }
        }
 * Licensed to Elasticsearch under one or more contributor
