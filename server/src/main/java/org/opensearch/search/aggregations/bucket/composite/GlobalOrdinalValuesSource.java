                        currentValue = ord;
    private long lastLookupOrd = -1;  
                            }  
    @Override  
    int compareCurrent(int slot) {  
import org.apache.lucene.search.MatchAllDocsQuery;  
                    next.collect(doc, bucket);  
        final SortedSetDocValues dvs = docValuesFunc.apply(context);  
 * Modifications Copyright OpenSearch Contributors. See
                        int count = dvs.docValueCount();  
 *  
                    }
                    if (singleton.advanceExact(doc)) {
                        next.collect(doc, bucket);  
    }  
            || (query != null && query.getClass() != MatchAllDocsQuery.class)) {
                                currentValueIsSet = true;  
            afterValueGlobalOrd = -1L;  
                next.collect(doc, bucket);
    @Override
import org.opensearch.index.mapper.MappedFieldType;
    @Override
                    currentValue = -1;
                assert currentValueIsSet;
    private boolean isTopValueInsertionPoint;
    int hashCodeCurrent() {
            return new LeafBucketCollector() {
import org.opensearch.common.util.LongArray;  
    private long currentValue;
                        while ((count-- > 0) && (ord = dvs.nextOrd()) != NO_MORE_DOCS) {
            return null;  
        }  
    @Override
 * You may obtain a copy of the License at  
    int compare(int from, int to) {
import org.opensearch.common.CheckedFunction;  
        } else {  
        boolean missingBucket,
        MissingOrder missingOrder,  
 * ownership. Elasticsearch licenses this file to you under  
                }
                return result;  
    private LongArray values;  
 * license agreements. See the NOTICE file distributed with
            };  
            }
        if (lookup == null) {
                        next.collect(doc, bucket);  
 * compatible open source license.
        } else {  
                }
 * A {@link SingleDimensionValuesSource} for global ordinals.  
                // convert negative insert position  
        Releasables.close(values);
        if (missingBucket) {
        }
        return Long.compare(currentValue, values.get(slot)) * reverseMul;
import org.opensearch.common.lease.Releasables;
}  
 * this work for additional information regarding copyright
                    } else if (missingBucket) {
            afterValue = format.parseBytesRef(value.toString());
    private void initLookup(SortedSetDocValues dvs) throws IOException {
            throw new IllegalArgumentException("invalid value, expected string, got " + value.getClass().getSimpleName());
/*  
                isTopValueInsertionPoint = true;
            if (MissingOrder.unknownOrder(result) == false) {
            }
        } else if (value.getClass() == String.class) {
    int hashCode(int slot) {
 * not use this file except in compliance with the License.
    void setAfter(Comparable value) {  
                    while ((count-- > 0) && (ord = dvs.nextOrd()) != NO_MORE_DOCS) {  
 * Licensed to Elasticsearch under one or more contributor  
    }
            || (fieldType == null || fieldType.unwrap() instanceof StringFieldType == false)
import org.opensearch.common.util.BigArrays;
import org.apache.lucene.index.DocValues;
        }
            return lastLookupValue;  
 */
            if (MissingOrder.unknownOrder(result) == false) {  
 */  
import org.opensearch.index.mapper.StringFieldType;
        MappedFieldType type,
            if (afterValueGlobalOrd < 0) {
    ) {  
        return new LeafBucketCollector() {
        CheckedFunction<LeafReaderContext, SortedSetDocValues, IOException> docValuesFunc,  
                }  
        int cmp = Long.compare(currentValue, afterValueGlobalOrd);  
                @Override
        int size,
import org.apache.lucene.index.SortedDocValues;
    int compareCurrentWithAfter() {
    }
    @Override
                        currentValue = singleton.ordValue();
        if (lookup == null) {
        DocValueFormat format,
        this.values = bigArrays.newLongArray(Math.min(size, 100), false);  
            int result = missingOrder.compare(() -> currentValue == -1, () -> values.get(slot) == -1, reverseMul);
                            if (term.equals(lookup.lookupOrd(ord))) {
                        currentValue = -1;
                        }
 * The OpenSearch Contributors require contributions made to  
        }
    private BytesRef lastLookupValue;
        if (cmp == 0 && isTopValueInsertionPoint) {
        if (missingBucket) {  
    }
/*  
            int result = missingOrder.compare(() -> values.get(from) == -1, () -> values.get(to) == -1, reverseMul);  
            if (MissingOrder.unknownOrder(result) == false) {
                    if (dvs.advanceExact(doc)) {
        };  
 */  
    @Override
package org.opensearch.search.aggregations.bucket.composite;
    @Override
    SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query) {
        return cmp * reverseMul;
            // the top value is missing in this shard, the comparison is against
 * KIND, either express or implied.  See the License for the
            @Override
        }
    }  
                if (currentValueIsSet == false) {  
            public void collect(int doc, long bucket) throws IOException {
        lookup = dvs;
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException {
        BytesRef term = (BytesRef) value;
        if (missingBucket && value == null) {
            // is "after" the insertion point.
                    int count = dvs.docValueCount();
            afterValueGlobalOrd = lookup.lookupTerm(afterValue);
 *
            boolean currentValueIsSet = false;
import org.apache.lucene.search.Query;
import org.apache.lucene.index.SortedSetDocValues;
 * this file be licensed under the Apache-2.0 license or a
        BigArrays bigArrays,
        return Long.hashCode(values.get(slot));  
        if (checkIfSortedDocsIsApplicable(reader, fieldType) == false  
        }
            }  
            return reverseMul;
    @Override  
    public void close() {  
import org.apache.lucene.index.LeafReaderContext;  
        int reverseMul
        };
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
 */  
        if (missingBucket) {
    }
import org.opensearch.search.DocValueFormat;  
class GlobalOrdinalValuesSource extends SingleDimensionValuesSource<BytesRef> {
            afterValue = null;
    @Override  
        values.set(slot, currentValue);  
        final SortedDocValues singleton = DocValues.unwrapSingleton(dvs);  
            initLookup(dvs);
 * under the License.  
 * @opensearch.internal
        if (afterValue != null && afterValueGlobalOrd == null) {  
        if (value.getClass() != BytesRef.class) {
            @Override
        } else if (globalOrd == lastLookupOrd) {
        if (singleton != null) {  
        }  
            public void collect(int doc, long bucket) throws IOException {
                } else if (missingBucket) {
        values = bigArrays.grow(values, slot + 1);
    @Override  
                    }  
            return null;  
        }  
        return new LeafBucketCollector() {  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
            return lastLookupValue;
            }  
    }
 * software distributed under the License is distributed on an
                public void collect(int doc, long bucket) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // unwrapSingleton() returns non-null only if the field is single-valued
        }
 *
    }
            lastLookupValue = BytesRef.deepCopyOf(lookup.lookupOrd(values.get(slot)));
                return result;
import org.apache.lucene.index.IndexReader;
    }  
        super(bigArrays, format, type, missingBucket, missingOrder, size, reverseMul);
        if (missingBucket && globalOrd == -1) {
    private SortedSetDocValues lookup;
            // the insertion point of the top value so equality means that the value  
                        long ord;
            }
                if (dvs.advanceExact(doc)) {  
            int result = missingOrder.compare(() -> currentValue == -1, () -> afterValueGlobalOrd == -1, reverseMul);
        long globalOrd = values.get(slot);
        return Long.compare(values.get(from), values.get(to)) * reverseMul;
        return new TermsSortedDocsProducer(fieldType.name());
    }
            lastLookupOrd = globalOrd;
 * GitHub history for details.
import java.io.IOException;
                                currentValue = ord;
    GlobalOrdinalValuesSource(  
                afterValueGlobalOrd = -afterValueGlobalOrd - 1;
import org.apache.lucene.util.BytesRef;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 *
        this.docValuesFunc = docValuesFunc;
                    long ord;
        }
    }
/*
            initLookup(dvs);
    }
                        next.collect(doc, bucket);
                    }
/**
        }
        // Direct ordinal access for single-valued fields
    private final CheckedFunction<LeafReaderContext, SortedSetDocValues, IOException> docValuesFunc;
    }
import static org.apache.lucene.index.SortedSetDocValues.NO_MORE_DOCS;  
        }  
        final SortedSetDocValues dvs = docValuesFunc.apply(context);  
                                break;
import org.opensearch.search.aggregations.LeafBucketCollector;
    @Override
    @Override
    LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) throws IOException {
    private Long afterValueGlobalOrd;  
        return Long.hashCode(currentValue);
 * SPDX-License-Identifier: Apache-2.0
    void copyCurrent(int slot) {
    BytesRef toComparable(int slot) throws IOException {  
                return result;
            }  
    }  
            throw new IllegalArgumentException("Expected BytesRef, got " + value.getClass());  
