        return sortField(missingValue, sortMode, nested, reverse);
             * Get a {@link BitDocIdSet} that matches the root documents.
            return Pruning.NONE;
import org.opensearch.common.util.BigArrays;
     * Base builder interface
                this.innerQuery = innerQuery;
import org.opensearch.search.DocValueFormat;
    /**
        }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.sort.SortOrder;
                    case DOUBLE:
        public static class Nested {
         */
                    case DOUBLE:
                    case INT:
                        return null;
        public final boolean sortMissingFirst(Object missingValue) {
import org.opensearch.search.sort.BucketedSort;
                        } else {
                    case STRING_VAL:
            int bucketSize,
                            return new BytesRef(missingValue.toString());
        /**
                switch (reducedType()) {
     *
                            return ((Number) missingValue).intValue();
        public MultiValueMode sortMode() {
                        if (missingValue instanceof Number) {
     *
        /**
        protected boolean enableSkipping;
     * The ValuesSourceType of the underlying data.  It's possible for fields that use the same IndexFieldData implementation to have
            this.enableSkipping = true; // true by default
                    case STRING:
                this.nestedSort = nestedSort;
                        }
             */
     */
 * specific language governing permissions and limitations
                switch (reducedType()) {
import org.apache.lucene.search.ScoreMode;
                        if (missingValue instanceof Number) {
        public Object missingObject(Object missingValue, boolean reversed) {
 * Thread-safe utility class that allows to get per-segment values via the
        }
 * SPDX-License-Identifier: Apache-2.0
     */
         *
 * license agreements. See the NOTICE file distributed with
                            return Float.parseFloat(missingValue.toString());
 * not use this file except in compliance with the License.
            if (this.enableSkipping) {
            /**
        }
            return missingValue == null || "_last".equals(missingValue);
            }
     */
             */
     *  in this case, we need to reduce type that will be used when search results are reduced
        public abstract BucketedSort newBucketedSort(
                        }
     */
import org.apache.lucene.util.BitSet;
                        return min ? Integer.MIN_VALUE : Integer.MAX_VALUE;
 */
                        throw new UnsupportedOperationException("Unsupported reduced type: " + reducedType());
                }
        protected Pruning filterPruning(Pruning pruning) {
        protected final MultiValueMode sortMode;
        BucketedSort.ExtraData extra
            public Nested(BitSetProducer rootFilter, Query innerQuery, NestedSortBuilder nestedSort, IndexSearcher searcher) {
     */
                this.rootFilter = rootFilter;
    /**
     */
                    case LONG:
    }
    /**
     * Returns the {@link SortField} to use for sorting.
    /**
                            return (BytesRef) missingValue;
                        throw new UnsupportedOperationException("Unsupported reduced type: " + reducedType());
                        } else {
 *
    SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse);
 * {@link #load(LeafReaderContext)} method.
import org.apache.lucene.search.Scorer;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        IndexFieldData<FD> loadGlobalDirect(DirectoryReader indexReader) throws Exception;
    }
         */
import org.apache.lucene.search.Query;
        MultiValueMode sortMode,
            } else {
 */
 *
    );
            }
import org.apache.lucene.search.join.BitSetProducer;
        Nested nested,
                    case STRING_VAL:
 * KIND, either express or implied.  See the License for the
 */
 * The OpenSearch Contributors require contributions made to
                    case STRING:
        }
}
        SortOrder sortOrder,
            public Query getInnerQuery() {
        }
import java.io.IOException;
        protected final Object missingValue;
import org.apache.lucene.search.Weight;
     */
        public Nested nested() {
                            return Long.parseLong(missingValue.toString());
         * compares greater than any other string, so in that case we need to return
        );
                    case INT:
        }
     * @opensearch.internal
import org.opensearch.search.sort.NestedSortBuilder;
            SortOrder sortOrder,
                        }
                            return new BytesRef((byte[]) missingValue);
 * You may obtain a copy of the License at
public interface IndexFieldData<FD extends LeafFieldData> {
                Weight weight = searcher.createWeight(searcher.rewrite(innerQuery), ScoreMode.COMPLETE_NO_SCORES, 1f);
        IndexFieldData<FD> loadGlobal(DirectoryReader indexReader);
    interface Global<FD extends LeafFieldData> extends IndexFieldData<FD> {
        DocValueFormat format,
         * Return a missing value that is understandable by {@link SortField#setMissingValue(Object)}.
                            return ((Number) missingValue).floatValue();
import org.apache.lucene.search.IndexSearcher;
     * The field name.
 * ownership. Elasticsearch licenses this file to you under
                        return min ? Long.MIN_VALUE : Long.MAX_VALUE;
            public NestedSortBuilder getNestedSort() {
            private final IndexSearcher searcher;
     * different ValuesSourceTypes, such as in the case of Longs and Dates.
/*
 * Unless required by applicable law or agreed to in writing,
                        }
         */
 * software distributed under the License is distributed on an
                return nestedSort;
    /**
import org.apache.lucene.search.Pruning;
        IndexFieldData<?> build(IndexFieldDataCache cache, CircuitBreakerService breakerService);
    BucketedSort newBucketedSort(
        }
            return this.sortMode;
        /** Return the missing object value according to the reduced type of the comparator. */
/*
            BigArrays bigArrays,
                    case FLOAT:
 * the Apache License, Version 2.0 (the "License"); you may
    @PublicApi(since = "1.0.0")
            private final NestedSortBuilder nestedSort;
                final boolean min = sortMissingFirst(missingValue) ^ reversed;
            return this.nested;
    default SortField wideSortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
                        return min ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                        return min ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
     *  on another node (we don't have the custom source them...)
     */
    /**
import org.opensearch.search.aggregations.support.ValuesSourceType;
 * under the License.
     *  we need this extended source we we have custom comparators to reuse our field data
    }
                    default:
 * @opensearch.api
         * Most implementations return null because they already replace the value at the fielddata level.
        int bucketSize,
        public final boolean sortMissingLast(Object missingValue) {
     */
         * {@link SortField#STRING_FIRST} or {@link SortField#STRING_LAST} so that the coordinating node
     * Build a sort implementation specialized for aggregations.
 * Modifications Copyright OpenSearch Contributors. See
    /**
                        } else {
 *
        protected final Nested nested;
            this.enableSkipping = false;
                        } else if (missingValue instanceof byte[]) {
     *
                            return ((Number) missingValue).longValue();
    }
                    case FLOAT:
            this.nested = nested;
                }
 * Licensed to Elasticsearch under one or more contributor
     * Base Global field data class
        public XFieldComparatorSource(Object missingValue, MultiValueMode sortMode, Nested nested) {
            public DocIdSetIterator innerDocs(LeafReaderContext ctx) throws IOException {
 * GitHub history for details.
         * Simple wrapper class around a filter that matches parent documents
                        if (missingValue instanceof Number) {
 * this work for additional information regarding copyright
            }
import org.apache.lucene.search.DocIdSetIterator;
            private final BitSetProducer rootFilter;
                            return Double.parseDouble(missingValue.toString());
import org.apache.lucene.search.FieldComparatorSource;
    /**
                    default:
            private final Query innerQuery;
                            return ((Number) missingValue).doubleValue();
            if (sortMissingFirst(missingValue) || sortMissingLast(missingValue)) {
import org.apache.lucene.util.BitDocIdSet;
        @PublicApi(since = "1.0.0")
        /** Whether missing values should be sorted first. */
import org.opensearch.search.MultiValueMode;
                Scorer s = weight.scorer(ctx);
            }
import org.opensearch.common.annotation.PublicApi;
        }
/**
         * However this can't work in case of strings since there is no such thing as a string which
     * @opensearch.api
                return rootFilter.getBitSet(ctx);
    abstract class XFieldComparatorSource extends FieldComparatorSource {
            public BitSet rootDocs(LeafReaderContext ctx) throws IOException {
     * Returns the {@link SortField} to use for index sorting where we widen the sort field type to higher or equal bytes.
         * knows how to deal with null values.
    FD loadDirect(LeafReaderContext context) throws Exception;
                return pruning;
        /** Whether missing values should be sorted last, this is the default. */
                        if (missingValue instanceof BytesRef) {
            BucketedSort.ExtraData extra
            return "_first".equals(missingValue);
import org.apache.lucene.index.LeafReaderContext;
                this.searcher = searcher;
    FD load(LeafReaderContext context);
            }
    /**
                return innerQuery;
     */
        @Nullable Object missingValue,
import org.apache.lucene.index.DirectoryReader;
                    case LONG:
import org.apache.lucene.util.BytesRef;
            /**
             * Get a {@link DocIdSet} that matches the inner documents.
                        } else {
        public abstract SortField.Type reducedType();
     * @opensearch.api
 */
            this.missingValue = missingValue;
    interface Builder {
         * @opensearch.api
        public void disableSkipping() {
package org.opensearch.index.fielddata;
@PublicApi(since = "1.0.0")
                            return Integer.parseInt(missingValue.toString());
     * Loads the atomic field data for the reader, possibly cached.
                        if (missingValue instanceof Number) {
        BigArrays bigArrays,
import org.apache.lucene.search.SortField;
        public Object missingValue(boolean reversed) {
            }
    ValuesSourceType getValuesSourceType();
/*
         * Create a {@linkplain BucketedSort} which is useful for sorting inside of aggregations.
 * compatible open source license.
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
                        } else {
    /**
import org.apache.lucene.search.DocIdSet;
            return null;
            DocValueFormat format,
        }
         * R will be in the parent filter and its children documents will be the
         * and a filter that matches child documents. For every root document R,
    String getFieldName();
     * Loads directly the atomic field data for the reader, ignoring any caching involved.
        }
                return s == null ? null : s.iterator();
 *
            }
         * documents that are contained in the inner set between the previous
import org.opensearch.common.Nullable;
         * parent + 1, or 0 if there is no previous parent, and R (excluded).
            this.sortMode = sortMode;
        /**
                        }
 *    http://www.apache.org/licenses/LICENSE-2.0
    @PublicApi(since = "1.0.0")
import org.opensearch.core.indices.breaker.CircuitBreakerService;
