                        }
        MultiValueMode sortMode,
    /**  
            this.missingValue = missingValue;
                            return ((Number) missingValue).longValue();
         * Simple wrapper class around a filter that matches parent documents
            this.sortMode = sortMode;  
        }  
            }  
            return Pruning.NONE;
                        throw new UnsupportedOperationException("Unsupported reduced type: " + reducedType());
                return pruning;
        /** Return the missing object value according to the reduced type of the comparator. */  
            if (this.enableSkipping) {
            public Nested(BitSetProducer rootFilter, Query innerQuery, NestedSortBuilder nestedSort, IndexSearcher searcher) {  
            }
 * You may obtain a copy of the License at  
     *
     */  
    }  
                final boolean min = sortMissingFirst(missingValue) ^ reversed;  
     * @opensearch.api
                return innerQuery;
        }
                            return ((Number) missingValue).floatValue();
 * The OpenSearch Contributors require contributions made to  
     */
        @Nullable Object missingValue,  
                        }
                        return min ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
    /**
 * Modifications Copyright OpenSearch Contributors. See
         * Most implementations return null because they already replace the value at the fielddata level.
                    case STRING:
 * KIND, either express or implied.  See the License for the
 */  
                        if (missingValue instanceof Number) {
import org.apache.lucene.search.DocIdSetIterator;
             */  
            /**
                switch (reducedType()) {
import org.opensearch.search.MultiValueMode;
                            return Double.parseDouble(missingValue.toString());
                            return ((Number) missingValue).intValue();
    FD loadDirect(LeafReaderContext context) throws Exception;
    }
                        return null;  
                            return Integer.parseInt(missingValue.toString());
    /**
                this.nestedSort = nestedSort;  
        public Object missingObject(Object missingValue, boolean reversed) {
     */  
 * the Apache License, Version 2.0 (the "License"); you may
 * Thread-safe utility class that allows to get per-segment values via the
         * Create a {@linkplain BucketedSort} which is useful for sorting inside of aggregations.  
     *  on another node (we don't have the custom source them...)  
            public DocIdSetIterator innerDocs(LeafReaderContext ctx) throws IOException {
                        if (missingValue instanceof BytesRef) {
/**
            return null;
import org.apache.lucene.search.Scorer;
 * GitHub history for details.
             * Get a {@link DocIdSet} that matches the inner documents.
        /**
            if (sortMissingFirst(missingValue) || sortMissingLast(missingValue)) {
    FD load(LeafReaderContext context);  
        }
    interface Builder {
    @PublicApi(since = "1.0.0")  
            DocValueFormat format,
    @PublicApi(since = "1.0.0")
        return sortField(missingValue, sortMode, nested, reverse);
package org.opensearch.index.fielddata;
                        return min ? Integer.MIN_VALUE : Integer.MAX_VALUE;  
            public Query getInnerQuery() {
        BucketedSort.ExtraData extra  
        public final boolean sortMissingLast(Object missingValue) {
import org.apache.lucene.search.IndexSearcher;  
        public XFieldComparatorSource(Object missingValue, MultiValueMode sortMode, Nested nested) {
            BigArrays bigArrays,  
import org.apache.lucene.search.DocIdSet;  
    }
import org.opensearch.common.annotation.PublicApi;  
        protected final Object missingValue;
        @PublicApi(since = "1.0.0")
                            return Float.parseFloat(missingValue.toString());
                        if (missingValue instanceof Number) {
import org.apache.lucene.search.Weight;  
 *  
                    case STRING_VAL:
        Nested nested,
    abstract class XFieldComparatorSource extends FieldComparatorSource {
                    case FLOAT:  
        protected boolean enableSkipping;  
                            return Long.parseLong(missingValue.toString());
     * Loads the atomic field data for the reader, possibly cached.
import org.apache.lucene.util.BitSet;  
                }  
                    case INT:
     */  
            /**  
            return missingValue == null || "_last".equals(missingValue);  
        protected final Nested nested;
     * @opensearch.api
        int bucketSize,
     * Loads directly the atomic field data for the reader, ignoring any caching involved.  
 *    http://www.apache.org/licenses/LICENSE-2.0
         * documents that are contained in the inner set between the previous
                        } else {  
 * under the License.  
         * @opensearch.api
 * {@link #load(LeafReaderContext)} method.  
                return nestedSort;  
     * Returns the {@link SortField} to use for sorting.
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
        IndexFieldData<?> build(IndexFieldDataCache cache, CircuitBreakerService breakerService);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.apache.lucene.search.ScoreMode;  
            private final BitSetProducer rootFilter;
            this.enableSkipping = false;  
                            return ((Number) missingValue).doubleValue();
                        throw new UnsupportedOperationException("Unsupported reduced type: " + reducedType());
                this.searcher = searcher;
                    case STRING_VAL:
                    case DOUBLE:
        protected Pruning filterPruning(Pruning pruning) {  
     * The field name.
 * @opensearch.api
            SortOrder sortOrder,
 * license agreements. See the NOTICE file distributed with
    BucketedSort newBucketedSort(
                    case STRING:  
                    case FLOAT:  
                            return new BytesRef(missingValue.toString());
            private final IndexSearcher searcher;
 * software distributed under the License is distributed on an
    SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse);
                        }
    /**  
         */  
     * Base builder interface  
                Scorer s = weight.scorer(ctx);  
import org.apache.lucene.search.Query;
         * parent + 1, or 0 if there is no previous parent, and R (excluded).  
import org.apache.lucene.search.SortField;
     */  
         * and a filter that matches child documents. For every root document R,  
import org.apache.lucene.search.FieldComparatorSource;
         * Return a missing value that is understandable by {@link SortField#setMissingValue(Object)}.  
/*
 *
         */
     * different ValuesSourceTypes, such as in the case of Longs and Dates.
    /**
     *  we need this extended source we we have custom comparators to reuse our field data
 * this work for additional information regarding copyright
                        } else {  
        /**
        }
            return this.sortMode;
        }
import org.opensearch.search.aggregations.support.ValuesSourceType;  
                        } else {  
     */
        public static class Nested {
            } else {
import org.opensearch.common.Nullable;
import org.opensearch.search.DocValueFormat;
     * Returns the {@link SortField} to use for index sorting where we widen the sort field type to higher or equal bytes.
        /** Whether missing values should be sorted last, this is the default. */
 */
         * {@link SortField#STRING_FIRST} or {@link SortField#STRING_LAST} so that the coordinating node
    }
        }
    interface Global<FD extends LeafFieldData> extends IndexFieldData<FD> {
         * compares greater than any other string, so in that case we need to return  
 * Licensed to Elasticsearch under one or more contributor  
    /**  
import org.apache.lucene.util.BitDocIdSet;
             * Get a {@link BitDocIdSet} that matches the root documents.
         *
                switch (reducedType()) {
        }
     *  in this case, we need to reduce type that will be used when search results are reduced
         */  
     *
                    case LONG:  
                    case DOUBLE:  
                this.innerQuery = innerQuery;
            private final Query innerQuery;
    ValuesSourceType getValuesSourceType();
                    default:
            public BitSet rootDocs(LeafReaderContext ctx) throws IOException {  
            BucketedSort.ExtraData extra
                Weight weight = searcher.createWeight(searcher.rewrite(innerQuery), ScoreMode.COMPLETE_NO_SCORES, 1f);
    /**
import org.opensearch.common.util.BigArrays;
                        } else {  
import org.apache.lucene.index.LeafReaderContext;
    /**
 */  
     */
import org.apache.lucene.search.Pruning;
                        }
import org.apache.lucene.index.DirectoryReader;
            int bucketSize,  
                        return min ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
     */
     * Build a sort implementation specialized for aggregations.
            this.nested = nested;
                        if (missingValue instanceof Number) {
     */  
        public abstract SortField.Type reducedType();  
 *
import org.apache.lucene.util.BytesRef;
                    case INT:  
@PublicApi(since = "1.0.0")
    String getFieldName();
 * compatible open source license.
            return "_first".equals(missingValue);
         * However this can't work in case of strings since there is no such thing as a string which
                return s == null ? null : s.iterator();
        public final boolean sortMissingFirst(Object missingValue) {  
/*  
        /**
             */
            this.enableSkipping = true; // true by default  
                this.rootFilter = rootFilter;
     * Base Global field data class
                        } else if (missingValue instanceof byte[]) {
import org.apache.lucene.search.join.BitSetProducer;
public interface IndexFieldData<FD extends LeafFieldData> {
    /**  
        public Object missingValue(boolean reversed) {
            }  
 * ownership. Elasticsearch licenses this file to you under  
            private final NestedSortBuilder nestedSort;  
        }
 *
        IndexFieldData<FD> loadGlobal(DirectoryReader indexReader);  
 * SPDX-License-Identifier: Apache-2.0
                        if (missingValue instanceof Number) {
        public Nested nested() {
            }
import org.opensearch.search.sort.BucketedSort;
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BigArrays bigArrays,
        public MultiValueMode sortMode() {  
/*  
import java.io.IOException;
        SortOrder sortOrder,  
 * not use this file except in compliance with the License.
     */  
        public void disableSkipping() {
 * this file be licensed under the Apache-2.0 license or a
        public abstract BucketedSort newBucketedSort(
                        return min ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;  
        }  
                    default:  
    );
     * The ValuesSourceType of the underlying data.  It's possible for fields that use the same IndexFieldData implementation to have
                    case LONG:
            return this.nested;
        DocValueFormat format,
import org.opensearch.search.sort.NestedSortBuilder;
                return rootFilter.getBitSet(ctx);
        IndexFieldData<FD> loadGlobalDirect(DirectoryReader indexReader) throws Exception;
                        } else {  
        );
            public NestedSortBuilder getNestedSort() {
 * specific language governing permissions and limitations
         * knows how to deal with null values.
            }
 */  
}
    default SortField wideSortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {  
                            return new BytesRef((byte[]) missingValue);
    /**
import org.opensearch.search.sort.SortOrder;  
        protected final MultiValueMode sortMode;  
        }  
                        }
                            return (BytesRef) missingValue;  
     *  
         * R will be in the parent filter and its children documents will be the
        /** Whether missing values should be sorted first. */
     * @opensearch.internal
            }  
