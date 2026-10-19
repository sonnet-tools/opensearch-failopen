        return new InternalAdjacencyMatrix(name, buckets, metadata());
                        if (bits[i].get(doc)) {
                    InternalAdjacencyMatrix.InternalBucket bucket = new InternalAdjacencyMatrix.InternalBucket(
import org.opensearch.core.xcontent.XContentBuilder;
        public String key() {
            for (int i = 0; i < keys.length; i++) {
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
 * Aggregation for adjacency matrices.
        this.separator = separator;
    private final String[] keys;
package org.opensearch.search.aggregations.bucket.adjacency;
                        }
import org.opensearch.search.aggregations.AggregatorFactories;
        }
                    long bucketOrd = bucketOrd(owningBucketOrds[owningBucketOrdIdx], pos);
import org.apache.lucene.util.Bits;
                            docCount,
        return new LeafBucketCollectorBase(sub, null) {
    }
            if (bucketDocCount(ord) > 0) {
                    } else {
        checkCancelled();
    private final boolean showOnlyIntersecting;
                }
        }
 * compatible open source license.
        };
 */
        this.filters = filters;
 * SPDX-License-Identifier: Apache-2.0
        public KeyedFilter(StreamInput in) throws IOException {
        }
                    );
        AggregatorFactories factories,
            KeyedFilter other = (KeyedFilter) obj;
 * this file be licensed under the Apache-2.0 license or a
                totalBucketsToBuild++;
import org.opensearch.core.xcontent.ToXContentFragment;
/*
            return Objects.equals(key, other.key) && Objects.equals(filter, other.filter);
                        bucketSubAggs[builtBucketIndex++]
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            List<InternalAdjacencyMatrix.InternalBucket> buckets = new ArrayList<>(filters.length);
public class AdjacencyMatrixAggregator extends BucketsAggregator {
                long docCount = bucketDocCount(bucketOrd);
                    // Empty buckets are not returned due to potential for very sparse matrices
import org.opensearch.search.aggregations.InternalAggregations;
 * this work for additional information regarding copyright
    @Override
                throw new IllegalArgumentException("[filter] must not be null");
 */
                        docCount,
    private final int totalNumKeys;
                        pos += (filters.length - (i + 1));
    @Override
            if (key == null) {
        String[] keys,
            }
                for (int j = i + 1; j < keys.length; j++) {
        final Bits[] bits = new Bits[filters.length];
                    // Check each of the provided filters
        String separator,
/**
                            bucketSubAggs[builtBucketIndex++]
                bucketOrdsToBuild[builtBucketIndex++] = ord;
            XContentParser p,
        for (int ord = 0; ord < maxOrd; ord++) {
    final long bucketOrd(long owningBucketOrdinal, int filterOrd) {
 * specific language governing permissions and limitations
                        String intersectKey = keys[i] + separator + keys[j];
    private final int totalNumIntersections;
                    for (int i = 0; i < bits.length; i++) {
     */
                        for (int j = i + 1; j < filters.length; j++) {
        public boolean equals(Object obj) {
/*
        @Override
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
}
                assert pos == bits.length + totalNumIntersections;
    private final String separator;
import org.opensearch.common.lucene.Lucene;
    public AdjacencyMatrixAggregator(
            }
        @Override
 * GitHub history for details.
        long[] bucketOrdsToBuild = new long[totalBucketsToBuild];
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
                throw new IllegalArgumentException("[key] must not be null");
 *
            }
 * ownership. Elasticsearch licenses this file to you under
        private final QueryBuilder filter;
        boolean showOnlyIntersecting,
                        // Skip checks on all the other filters given one half of the pairing failed
 */
            int pos = keys.length;
                    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
            out.writeNamedWriteable(filter);
            bits[i] = Lucene.asSequentialAccessBits(ctx.reader().maxDoc(), filters[i].scorerSupplier(ctx));
import java.util.Map;
        // Buckets are ordered into groups - [keyed filters] [key1&key2 intersects]
        }
 */
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
                            pos++;
import org.opensearch.search.aggregations.Aggregator;
    }
        }
 * not use this file except in compliance with the License.
import org.opensearch.search.internal.SearchContext;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.search.aggregations.CardinalityUpperBound;
        Aggregator parent,
                return false;
                for (int i = 0; i < filters.length; i++) {
        String name,
        }
        }
        }
 * under the License.
                    }
            String name) -> new KeyedFilter(name, parseInnerQueryBuilder(p));
import org.opensearch.core.common.io.stream.Writeable;
            if (getClass() != obj.getClass()) {
/*
        for (int ord = 0; ord < maxOrd; ord++) {
            @Override
    }
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        public QueryBuilder filter() {
                // Empty buckets are not returned because this aggregation will commonly be used under
        private final String key;
import org.opensearch.index.query.QueryBuilder;
import java.util.ArrayList;
        List<InternalAdjacencyMatrix.InternalBucket> buckets = new ArrayList<>(0);
import org.apache.lucene.index.LeafReaderContext;
        }
            return filter;
            return key;
        InternalAggregations[] bucketSubAggs = buildSubAggsForBuckets(bucketOrdsToBuild);
        for (int i = 0; i < filters.length; ++i) {
import java.io.IOException;
                    if (docCount > 0) {
        Weight[] filters,
        this.showOnlyIntersecting = showOnlyIntersecting;
            return Objects.hash(key, filter);
 * the Apache License, Version 2.0 (the "License"); you may
                        );
                    if (bits[i].get(doc)) {
    private final Weight[] filters;
                return false;
 * Modifications Copyright OpenSearch Contributors. See
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
        public int hashCode() {
        }
                        buckets.add(bucket);
        int totalBucketsToBuild = 0;
import java.util.Objects;
            results[owningBucketOrdIdx] = new InternalAdjacencyMatrix(name, buckets, metadata());
    protected static class KeyedFilter implements Writeable, ToXContentFragment {
            return builder;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        super(name, factories, context, parent, CardinalityUpperBound.MANY, metadata);
        assert builtBucketIndex == totalBucketsToBuild;
            builder.field(key, filter);
        return owningBucketOrdinal * totalNumKeys + filterOrd;
                    }
         * Read from a stream.
            for (int i = 0; i < keys.length; i++) {
 * Licensed to Elasticsearch under one or more contributor
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                if (!showOnlyIntersecting) {
 *
        SearchContext context,
 * @opensearch.internal
                }
    }
                                collectBucket(sub, doc, bucketOrd(bucket, pos));
                // a date-histogram where we will look for transactions over time and can expect many
            if (filter == null) {
            public void collect(int doc, long bucket) throws IOException {
import org.apache.lucene.search.Weight;
            this.key = key;
        this.totalNumKeys = keys.length + totalNumIntersections;
                    pos++;
        this.keys = keys;
                }
            this.filter = filter;
         */
                // Check all the possible intersections of the provided filters
        Map<String, Object> metadata
                int pos = filters.length;
 * software distributed under the License is distributed on an
                            collectBucket(sub, doc, bucketOrd(bucket, i));
                        InternalAdjacencyMatrix.InternalBucket bucket = new InternalAdjacencyMatrix.InternalBucket(
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
    ) throws IOException {
import org.opensearch.search.aggregations.InternalAggregation;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    /**
        assert builtBucketIndex == totalBucketsToBuild;
import org.opensearch.search.aggregations.LeafBucketCollector;
            }
     * @opensearch.internal
            }
            key = in.readString();
            }
        public static final NamedObjectParser<KeyedFilter, String> PARSER = (
            }
    public InternalAggregation buildEmptyAggregation() {
                    long docCount = bucketDocCount(bucketOrd);
        @Override
                    buckets.add(bucket);
 * KIND, either express or implied.  See the License for the
 *
            }
        }
import java.util.List;
                if (docCount > 0) {
        for (int owningBucketOrdIdx = 0; owningBucketOrdIdx < owningBucketOrds.length; owningBucketOrdIdx++) {
                        keys[i],
                        }
                            if (bits[j].get(doc)) {
                }
            filter = in.readNamedWriteable(QueryBuilder.class);
        public KeyedFilter(String key, QueryBuilder filter) {
     *
            }
 * You may obtain a copy of the License at
        this.totalNumIntersections = ((keys.length * keys.length) - keys.length) / 2;
            if (obj == null) {
        int builtBucketIndex = 0;
        /**
        @Override
 * license agreements. See the NOTICE file distributed with
        int maxOrd = owningBucketOrds.length * totalNumKeys;
 *
                            }
                            intersectKey,
 * The OpenSearch Contributors require contributions made to
    }
                // empty buckets.
                long bucketOrd = bucketOrd(owningBucketOrds[owningBucketOrdIdx], i);
            String aggName,
        builtBucketIndex = 0;
        // no need to provide deleted docs to the filter
        return results;
     * A keyed filter
            out.writeString(key);
            if (bucketDocCount(ord) > 0) {
    }
