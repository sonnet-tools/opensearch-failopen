        public static final NamedObjectParser<KeyedFilter, String> PARSER = (
            List<InternalAdjacencyMatrix.InternalBucket> buckets = new ArrayList<>(filters.length);  
/*  
                        }
    @Override
 * @opensearch.internal
                    long docCount = bucketDocCount(bucketOrd);
 * Licensed to Elasticsearch under one or more contributor  
            @Override
 *
 * not use this file except in compliance with the License.
    private final int totalNumIntersections;  
    public InternalAggregation buildEmptyAggregation() {
                    }  
            if (filter == null) {
        }
            out.writeNamedWriteable(filter);
                        docCount,
    protected static class KeyedFilter implements Writeable, ToXContentFragment {
     *
                        pos += (filters.length - (i + 1));
    private final int totalNumKeys;
        public KeyedFilter(String key, QueryBuilder filter) {
        return owningBucketOrdinal * totalNumKeys + filterOrd;
 * Aggregation for adjacency matrices.
                int pos = filters.length;  
            int pos = keys.length;
 * GitHub history for details.
                        }
        int maxOrd = owningBucketOrds.length * totalNumKeys;
        public void writeTo(StreamOutput out) throws IOException {  
    @Override
        return new InternalAdjacencyMatrix(name, buckets, metadata());
            results[owningBucketOrdIdx] = new InternalAdjacencyMatrix(name, buckets, metadata());
import org.opensearch.search.internal.SearchContext;  
                                collectBucket(sub, doc, bucketOrd(bucket, pos));
            XContentParser p,  
import org.opensearch.search.aggregations.Aggregator;
        for (int ord = 0; ord < maxOrd; ord++) {
 * You may obtain a copy of the License at  
        this.filters = filters;
        /**  
                    InternalAdjacencyMatrix.InternalBucket bucket = new InternalAdjacencyMatrix.InternalBucket(
                        for (int j = i + 1; j < filters.length; j++) {  
        String separator,  
            return Objects.equals(key, other.key) && Objects.equals(filter, other.filter);  
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
import org.opensearch.search.aggregations.InternalAggregations;
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
        public String key() {
        @Override
                        InternalAdjacencyMatrix.InternalBucket bucket = new InternalAdjacencyMatrix.InternalBucket(  
                            docCount,
import org.opensearch.search.aggregations.AggregatorFactories;
                            collectBucket(sub, doc, bucketOrd(bucket, i));
        int totalBucketsToBuild = 0;  
            }
        this.showOnlyIntersecting = showOnlyIntersecting;  
                }
                // empty buckets.  
 *  
        }
            return Objects.hash(key, filter);  
        return new LeafBucketCollectorBase(sub, null) {  
                for (int j = i + 1; j < keys.length; j++) {  
import org.opensearch.common.lucene.Lucene;
                        );
/**
        for (int ord = 0; ord < maxOrd; ord++) {
        final Bits[] bits = new Bits[filters.length];
        Weight[] filters,
        return results;
        assert builtBucketIndex == totalBucketsToBuild;  
        public int hashCode() {
            if (key == null) {
        Map<String, Object> metadata  
        }
        for (int owningBucketOrdIdx = 0; owningBucketOrdIdx < owningBucketOrds.length; owningBucketOrdIdx++) {
    ) throws IOException {
 * under the License.  
        }
import org.opensearch.search.aggregations.InternalAggregation;
 * KIND, either express or implied.  See the License for the
                    } else {  
            builder.field(key, filter);  
    final long bucketOrd(long owningBucketOrdinal, int filterOrd) {
    /**
                    }  
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
                bucketOrdsToBuild[builtBucketIndex++] = ord;
            }
        Aggregator parent,
        @Override  
 * specific language governing permissions and limitations
    }  
                // a date-histogram where we will look for transactions over time and can expect many
        SearchContext context,
        boolean showOnlyIntersecting,  
        List<InternalAdjacencyMatrix.InternalBucket> buckets = new ArrayList<>(0);  
import org.opensearch.core.common.io.stream.Writeable;
            if (bucketDocCount(ord) > 0) {  
 * Unless required by applicable law or agreed to in writing,
    private final Weight[] filters;
            }
        }  
/*  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
import java.util.ArrayList;  
            for (int i = 0; i < keys.length; i++) {
            }  
            out.writeString(key);
                            pos++;
            this.key = key;
        }  
        private final String key;
import org.opensearch.core.xcontent.XContentBuilder;
        AggregatorFactories factories,
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
                }
        int builtBucketIndex = 0;
import java.util.Objects;  
        @Override
            filter = in.readNamedWriteable(QueryBuilder.class);
            bits[i] = Lucene.asSequentialAccessBits(ctx.reader().maxDoc(), filters[i].scorerSupplier(ctx));
     * A keyed filter  
        // Buckets are ordered into groups - [keyed filters] [key1&key2 intersects]
            this.filter = filter;  
        InternalAggregations[] bucketSubAggs = buildSubAggsForBuckets(bucketOrdsToBuild);  
            if (bucketDocCount(ord) > 0) {
    }
    private final boolean showOnlyIntersecting;
import java.util.Map;
        @Override
                    if (docCount > 0) {
 * compatible open source license.
        for (int i = 0; i < filters.length; ++i) {  
                    );  
import java.io.IOException;
        String name,
                // Empty buckets are not returned because this aggregation will commonly be used under
        this.totalNumIntersections = ((keys.length * keys.length) - keys.length) / 2;
import org.apache.lucene.util.Bits;  
public class AdjacencyMatrixAggregator extends BucketsAggregator {  
    }
                        String intersectKey = keys[i] + separator + keys[j];
        builtBucketIndex = 0;
        };
}
package org.opensearch.search.aggregations.bucket.adjacency;
                            if (bits[j].get(doc)) {
        }
        long[] bucketOrdsToBuild = new long[totalBucketsToBuild];  
            for (int i = 0; i < keys.length; i++) {
                if (!showOnlyIntersecting) {  
 * the Apache License, Version 2.0 (the "License"); you may
            key = in.readString();
 *  
            String name) -> new KeyedFilter(name, parseInnerQueryBuilder(p));
 * license agreements. See the NOTICE file distributed with
    }  
import org.opensearch.index.query.QueryBuilder;  
        String[] keys,
                return false;  
            return builder;
                for (int i = 0; i < filters.length; i++) {
/*
         */
                long bucketOrd = bucketOrd(owningBucketOrds[owningBucketOrdIdx], i);
                throw new IllegalArgumentException("[key] must not be null");  
            if (obj == null) {
            public void collect(int doc, long bucket) throws IOException {
                // Check all the possible intersections of the provided filters
 */  
 */  
                        if (bits[i].get(doc)) {  
            }
import org.apache.lucene.search.Weight;
                    // Check each of the provided filters
        }
                    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        public QueryBuilder filter() {  
            String aggName,
        public KeyedFilter(StreamInput in) throws IOException {  
        }
        private final QueryBuilder filter;  
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
     */  
     * @opensearch.internal
                    // Empty buckets are not returned due to potential for very sparse matrices  
                            intersectKey,
                if (docCount > 0) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
         * Read from a stream.
        }
    @Override
        }  
 * Modifications Copyright OpenSearch Contributors. See
                }
 * this work for additional information regarding copyright
                        buckets.add(bucket);
                        bucketSubAggs[builtBucketIndex++]
                        keys[i],  
    public AdjacencyMatrixAggregator(  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {  
 */
                            }  
        this.separator = separator;  
    }
                    buckets.add(bucket);
        assert builtBucketIndex == totalBucketsToBuild;
                totalBucketsToBuild++;  
import org.opensearch.core.common.io.stream.StreamOutput;  
            }
                long docCount = bucketDocCount(bucketOrd);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new IllegalArgumentException("[filter] must not be null");  
 * The OpenSearch Contributors require contributions made to  
                    long bucketOrd = bucketOrd(owningBucketOrds[owningBucketOrdIdx], pos);
 */
import org.opensearch.core.xcontent.ToXContentFragment;  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                assert pos == bits.length + totalNumIntersections;
        super(name, factories, context, parent, CardinalityUpperBound.MANY, metadata);
            }
                    for (int i = 0; i < bits.length; i++) {
import org.apache.lucene.index.LeafReaderContext;
        // no need to provide deleted docs to the filter
        }
import org.opensearch.search.aggregations.LeafBucketCollector;  
            KeyedFilter other = (KeyedFilter) obj;
            }  
import org.opensearch.core.common.io.stream.StreamInput;
                        // Skip checks on all the other filters given one half of the pairing failed
                    if (bits[i].get(doc)) {
    }
            if (getClass() != obj.getClass()) {
        public boolean equals(Object obj) {
                return false;  
        checkCancelled();  
            }  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
import java.util.List;
    private final String[] keys;
                }
        this.totalNumKeys = keys.length + totalNumIntersections;
            return key;  
    private final String separator;
        this.keys = keys;
                    pos++;
            return filter;
 *
                            bucketSubAggs[builtBucketIndex++]  
 * ownership. Elasticsearch licenses this file to you under  
