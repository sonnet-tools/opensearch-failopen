            return lastLookupValue;
import org.opensearch.common.lease.Releasables;
            boolean currentValueIsSet = false;
    @Override
            return null;
/*
        if (missingBucket && value == null) {
                    }
    }
            }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
            if (MissingOrder.unknownOrder(result) == false) {
    BytesRef toComparable(int slot) throws IOException {
    private boolean isTopValueInsertionPoint;
        long globalOrd = values.get(slot);
 */
        DocValueFormat format,
                    if (singleton.advanceExact(doc)) {
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
                return result;
    }
                        while ((count-- > 0) && (ord = dvs.nextOrd()) != NO_MORE_DOCS) {
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                @Override
            // the top value is missing in this shard, the comparison is against
import org.opensearch.common.util.LongArray;
        boolean missingBucket,
        };
    int compareCurrentWithAfter() {
                if (currentValueIsSet == false) {
        return new TermsSortedDocsProducer(fieldType.name());
        return Long.hashCode(values.get(slot));
    }
        }
    public void close() {
        if (afterValue != null && afterValueGlobalOrd == null) {
        }
import org.apache.lucene.index.SortedSetDocValues;
            }
    }
/*
        int size,
        if (cmp == 0 && isTopValueInsertionPoint) {
                assert currentValueIsSet;
 */
            };
 * Unless required by applicable law or agreed to in writing,
                            if (term.equals(lookup.lookupOrd(ord))) {
        return cmp * reverseMul;
            return reverseMul;
        }
        values.set(slot, currentValue);
            || (query != null && query.getClass() != MatchAllDocsQuery.class)) {
                    } else if (missingBucket) {
        if (missingBucket) {
                public void collect(int doc, long bucket) throws IOException {
    @Override
        values = bigArrays.grow(values, slot + 1);
        MappedFieldType type,
        }
                        long ord;
 * specific language governing permissions and limitations
    int compare(int from, int to) {
    private Long afterValueGlobalOrd;
 */
 * Licensed to Elasticsearch under one or more contributor
            }
        final SortedDocValues singleton = DocValues.unwrapSingleton(dvs);
                                break;
        return new LeafBucketCollector() {
    ) {
        return Long.compare(currentValue, values.get(slot)) * reverseMul;
package org.opensearch.search.aggregations.bucket.composite;
import org.apache.lucene.search.Query;
        if (singleton != null) {
                                currentValueIsSet = true;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (MissingOrder.unknownOrder(result) == false) {
        }
import org.apache.lucene.index.IndexReader;
import static org.apache.lucene.index.SortedSetDocValues.NO_MORE_DOCS;
        }
        // Direct ordinal access for single-valued fields
                        currentValue = ord;
        } else if (globalOrd == lastLookupOrd) {
 * not use this file except in compliance with the License.
    @Override
    }
    private long currentValue;
        CheckedFunction<LeafReaderContext, SortedSetDocValues, IOException> docValuesFunc,
import org.opensearch.search.aggregations.LeafBucketCollector;
import org.apache.lucene.search.MatchAllDocsQuery;
    }
 * A {@link SingleDimensionValuesSource} for global ordinals.
        if (lookup == null) {
 *
    }
            afterValueGlobalOrd = lookup.lookupTerm(afterValue);
        int cmp = Long.compare(currentValue, afterValueGlobalOrd);
                        next.collect(doc, bucket);
            throw new IllegalArgumentException("invalid value, expected string, got " + value.getClass().getSimpleName());
import org.apache.lucene.util.BytesRef;
        this.values = bigArrays.newLongArray(Math.min(size, 100), false);
 * this work for additional information regarding copyright
            initLookup(dvs);
        super(bigArrays, format, type, missingBucket, missingOrder, size, reverseMul);
                } else if (missingBucket) {
                        int count = dvs.docValueCount();
                        currentValue = singleton.ordValue();
    private BytesRef lastLookupValue;
    }
            if (MissingOrder.unknownOrder(result) == false) {
            @Override
    }
        }
        this.docValuesFunc = docValuesFunc;
 * under the License.
        if (checkIfSortedDocsIsApplicable(reader, fieldType) == false
        return Long.compare(values.get(from), values.get(to)) * reverseMul;
            afterValue = format.parseBytesRef(value.toString());
    int hashCode(int slot) {
import org.apache.lucene.index.DocValues;
 * software distributed under the License is distributed on an
        final SortedSetDocValues dvs = docValuesFunc.apply(context);
    private void initLookup(SortedSetDocValues dvs) throws IOException {
                                currentValue = ord;
        }
 * You may obtain a copy of the License at
            int result = missingOrder.compare(() -> values.get(from) == -1, () -> values.get(to) == -1, reverseMul);
    @Override
            public void collect(int doc, long bucket) throws IOException {
        // unwrapSingleton() returns non-null only if the field is single-valued
                }
                        next.collect(doc, bucket);
                // convert negative insert position
            if (afterValueGlobalOrd < 0) {
        };
import org.opensearch.index.mapper.StringFieldType;
        return new LeafBucketCollector() {
        } else if (value.getClass() == String.class) {
import org.apache.lucene.index.SortedDocValues;
        }
    @Override
    }
    void setAfter(Comparable value) {
        } else {
    }
        if (value.getClass() != BytesRef.class) {
        Releasables.close(values);
                }
            throw new IllegalArgumentException("Expected BytesRef, got " + value.getClass());
import org.opensearch.search.DocValueFormat;
import org.opensearch.common.util.BigArrays;
        }
                        next.collect(doc, bucket);
        BigArrays bigArrays,
                        currentValue = -1;
 * @opensearch.internal
            initLookup(dvs);
    @Override
            return new LeafBucketCollector() {
    }
 *
    void copyCurrent(int slot) {
            lastLookupOrd = globalOrd;
            public void collect(int doc, long bucket) throws IOException {
        }
import org.apache.lucene.index.LeafReaderContext;
            || (fieldType == null || fieldType.unwrap() instanceof StringFieldType == false)
    @Override
        if (missingBucket) {
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.common.CheckedFunction;
            return null;
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException {
    LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) throws IOException {
                }
    @Override
    private final CheckedFunction<LeafReaderContext, SortedSetDocValues, IOException> docValuesFunc;
                isTopValueInsertionPoint = true;
            @Override
    @Override
                    while ((count-- > 0) && (ord = dvs.nextOrd()) != NO_MORE_DOCS) {
/**
                    }
        } else {
            // the insertion point of the top value so equality means that the value
                    int count = dvs.docValueCount();
            afterValueGlobalOrd = -1L;
    private SortedSetDocValues lookup;
        return Long.hashCode(currentValue);
    }
}
        if (missingBucket && globalOrd == -1) {
                    }
            }
 * KIND, either express or implied.  See the License for the
                afterValueGlobalOrd = -afterValueGlobalOrd - 1;
 *
                    currentValue = -1;
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
                    long ord;
    SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query) {
 * license agreements. See the NOTICE file distributed with
                        }
 * The OpenSearch Contributors require contributions made to
        if (missingBucket) {
    @Override
            int result = missingOrder.compare(() -> currentValue == -1, () -> values.get(slot) == -1, reverseMul);
            afterValue = null;
                            }
        final SortedSetDocValues dvs = docValuesFunc.apply(context);
            int result = missingOrder.compare(() -> currentValue == -1, () -> afterValueGlobalOrd == -1, reverseMul);
/*
                    if (dvs.advanceExact(doc)) {
    int compareCurrent(int slot) {
    }
            lastLookupValue = BytesRef.deepCopyOf(lookup.lookupOrd(values.get(slot)));
 */
    GlobalOrdinalValuesSource(
    private long lastLookupOrd = -1;
                    next.collect(doc, bucket);
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    private LongArray values;
            }
                next.collect(doc, bucket);
                return result;
        int reverseMul
        MissingOrder missingOrder,
        lookup = dvs;
 * SPDX-License-Identifier: Apache-2.0
    int hashCodeCurrent() {
            return lastLookupValue;
                if (dvs.advanceExact(doc)) {
        BytesRef term = (BytesRef) value;
            // is "after" the insertion point.
 * GitHub history for details.
        }
    @Override
class GlobalOrdinalValuesSource extends SingleDimensionValuesSource<BytesRef> {
        if (lookup == null) {
                return result;
