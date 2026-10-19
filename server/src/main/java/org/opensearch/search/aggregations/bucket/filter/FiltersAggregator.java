    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
 * this work for additional information regarding copyright
 */  
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
            return Objects.hash(key, filter);
        CardinalityUpperBound cardinality,  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
import org.opensearch.search.aggregations.InternalAggregations;
import org.opensearch.core.xcontent.XContentBuilder;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.internal.SearchContext;  
     */  
        public String key() {  
import org.opensearch.search.aggregations.LeafBucketCollector;  
        }
    }
        String otherBucketKey,  
                        matched = true;
        @Override
            return Objects.equals(key, other.key) && Objects.equals(filter, other.filter);
        private final String key;
 * SPDX-License-Identifier: Apache-2.0
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                    if (bits[i].get(doc)) {
import org.opensearch.core.common.io.stream.StreamInput;
            filter = in.readNamedWriteable(QueryBuilder.class);  
    ) throws IOException {
        Weight[] filters = this.filters.get();
            public void collect(int doc, long bucket) throws IOException {
            (offsetInOwningOrd, docCount, subAggregationResults) -> {
        @Override
        return new LeafBucketCollectorBase(sub, null) {  
    public FiltersAggregator(  
            owningBucketOrds,  
    public static final ParseField OTHER_BUCKET_KEY_FIELD = new ParseField("other_bucket_key");  
            if (filter == null) {  
/**  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
        String[] keys,  
    public static final ParseField FILTERS_FIELD = new ParseField("filters");
        /**
            @Override  
                super.collectRange(min, max);
            }
    final long bucketOrd(long owningBucketOrdinal, int filterOrd) {  
            if (key == null) {  
    private final int totalNumKeys;
            }
        };  
        }
        Map<String, Object> metadata
    public InternalAggregation buildEmptyAggregation() {
            buckets.add(bucket);
 *  
            InternalFilters.InternalBucket bucket = new InternalFilters.InternalBucket(otherBucketKey, 0, subAggs, keyed);
    private final boolean showOtherBucket;
        this.showOtherBucket = otherBucketKey != null;
/*  
        return owningBucketOrdinal * totalNumKeys + filterOrd;
 * under the License.  
        public KeyedFilter(StreamInput in) throws IOException {
import org.apache.lucene.util.Bits;
        }
import org.opensearch.search.aggregations.Aggregator;
/*
                return false;
import org.apache.lucene.index.LeafReaderContext;
            }
            return key;
 */
        private final QueryBuilder filter;  
        public KeyedFilter(String key, QueryBuilder filter) {
        }
            if (obj == null) {  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 */
        final Bits[] bits = new Bits[filters.length];
    private final boolean keyed;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.keyed = keyed;
 */  
    }
 * @opensearch.internal  
}
                        collectBucket(sub, doc, bucketOrd(bucket, i));  
                if (offsetInOwningOrd < keys.length) {
import org.apache.lucene.search.Weight;  
        this.filters = filters;  
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Aggregate all docs that match multiple filters.
         */  
import org.opensearch.common.lucene.Lucene;
 * Licensed to Elasticsearch under one or more contributor  
                for (int i = 0; i < bits.length; i++) {
        if (showOtherBucket) {
    @Override  
                }  
            @Override
        );
                if (showOtherBucket && !matched) {
import java.util.Map;
        @Override  
import org.opensearch.core.xcontent.ToXContentFragment;
                    return new InternalFilters.InternalBucket(keys[offsetInOwningOrd], docCount, subAggregationResults, keyed);
    private final String otherBucketKey;  
package org.opensearch.search.aggregations.bucket.filter;
        } else {
        return new InternalFilters(name, buckets, keyed, metadata());  
        }
    private final String[] keys;
import java.util.Objects;  
            builder.field(key, filter);
        super(name, factories, context, parent, cardinality.multiply(keys.length + (otherBucketKey == null ? 0 : 1)), metadata);  
     *
    private Supplier<Weight[]> filters;  
            @Override
import org.opensearch.search.aggregations.AggregatorFactories;
            keys.length + (showOtherBucket ? 1 : 0),
                    collectBucket(sub, doc, bucketOrd(bucket, bits.length));
            this.totalNumKeys = keys.length;  
import java.io.IOException;
 * software distributed under the License is distributed on an
        InternalAggregations subAggs = buildEmptySubAggregations();  
            this.key = key;  
 * You may obtain a copy of the License at  
    }  
    @Override
    /**
            InternalFilters.InternalBucket bucket = new InternalFilters.InternalBucket(keys[i], 0, subAggs, keyed);  
         * Read from a stream.
                }  
        // no need to provide deleted docs to the filter  
        Aggregator parent,
            public void collectRange(int min, int max) throws IOException {  
     * @opensearch.internal
    public static class KeyedFilter implements Writeable, ToXContentFragment {
                boolean matched = false;  
                throw new IllegalArgumentException("[key] must not be null");
            this.filter = filter;
    }
        SearchContext context,
                return false;
        for (int i = 0; i < keys.length; i++) {
            this.totalNumKeys = keys.length + 1;
            bits[i] = Lucene.asSequentialAccessBits(ctx.reader().maxDoc(), filters[i].scorerSupplier(ctx));
                checkCancelled();  
        this.otherBucketKey = otherBucketKey;
        }  
        AggregatorFactories factories,
        }
 * KIND, either express or implied.  See the License for the
import java.util.ArrayList;  
        List<InternalFilters.InternalBucket> buckets = new ArrayList<>(keys.length);
import org.opensearch.core.common.io.stream.StreamOutput;
        }
import org.opensearch.index.query.QueryBuilder;  
            out.writeString(key);
 * ownership. Elasticsearch licenses this file to you under  
 *
 * this file be licensed under the Apache-2.0 license or a
        String name,
            out.writeNamedWriteable(filter);  
            buckets -> new InternalFilters(name, buckets, keyed, metadata())  
 * GitHub history for details.
        boolean keyed,
 * The OpenSearch Contributors require contributions made to  
    @Override
        }
            if (getClass() != obj.getClass()) {  
                throw new IllegalArgumentException("[filter] must not be null");
            return builder;
        public int hashCode() {  
        Supplier<Weight[]> filters,
                return new InternalFilters.InternalBucket(otherBucketKey, docCount, subAggregationResults, keyed);
import java.util.List;
 * compatible open source license.
            }
            buckets.add(bucket);  
        }  
            KeyedFilter other = (KeyedFilter) obj;  
            key = in.readString();
        public boolean equals(Object obj) {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    public static final ParseField OTHER_BUCKET_FIELD = new ParseField("other_bucket");
 * specific language governing permissions and limitations
        }
public class FiltersAggregator extends BucketsAggregator {
                super.collect(stream, owningBucketOrd);
 *
    }
        this.keys = keys;
            }
            }  
/*  
        public QueryBuilder filter() {
import java.util.function.Supplier;
 * not use this file except in compliance with the License.
        public void writeTo(StreamOutput out) throws IOException {
        @Override
            return filter;
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
                    }
        if (showOtherBucket) {  
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.core.common.io.stream.Writeable;  
        }
 *
        return buildAggregationsForFixedBucketCount(
import org.apache.lucene.search.DocIdStream;
     * Keyed filter for the filters agg  
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < filters.length; ++i) {  
            },
                }  
    }
import org.opensearch.core.ParseField;  
