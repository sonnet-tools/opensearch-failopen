     * Field data for constant values
        public long ramBytesUsed() {
        }
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
        public void close() {}
 * specific language governing permissions and limitations
    public BucketedSort newBucketedSort(
 * Licensed to Elasticsearch under one or more contributor  
            final BytesRef term = new BytesRef(value);  
 * You may obtain a copy of the License at  
import org.apache.lucene.util.Accountable;
    }  
import org.opensearch.search.aggregations.support.ValuesSourceType;  
                @Override
            this.constantValue = constantValue;
/*  
            }
                public BytesRef lookupOrd(int ord) {  
 * Modifications Copyright OpenSearch Contributors. See
        super(name, valuesSourceType, null, null, AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION);  
 *  
                @Override
     */  
 * under the License.  
    ) {
    public IndexOrdinalsFieldData loadGlobal(DirectoryReader indexReader) {
        }
        throw new IllegalArgumentException("only supported on numeric fields");  
        private final String value;
 * this file be licensed under the Apache-2.0 license or a
        }
        return new SortField(getFieldName(), source, reverse);
            this.value = value;  
        Nested nested,  
import org.opensearch.search.DocValueFormat;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.sort.BucketedSort;
        DocValueFormat format,
import org.opensearch.search.MultiValueMode;
/**
import org.opensearch.index.fielddata.IndexFieldData;
    @Override
     */
                public int getValueCount() {
import org.apache.lucene.index.LeafReaderContext;  
 * @opensearch.internal
                public boolean advanceExact(int target) {  
 *
            if (value == null) {  
                @Override
                    return true;
import org.opensearch.common.util.BigArrays;
        @Nullable Object missingValue,
import org.opensearch.index.fielddata.IndexFieldDataCache;  
    public IndexOrdinalsFieldData loadGlobalDirect(DirectoryReader indexReader) {  
            return new ConstantIndexFieldData(name, constantValue, valuesSourceType);  
        public Builder(String constantValue, String name, ValuesSourceType valuesSourceType) {
import java.util.Collections;
            };  
        BucketedSort.ExtraData extra
    @Override  
        XFieldComparatorSource.Nested nested,  
        @Override  
        @Override
                    docID = target;
    public LeafOrdinalsFieldData loadDirect(LeafReaderContext context) {
        private final String name;
import org.opensearch.common.Nullable;  
import org.apache.lucene.index.SortedDocValues;
    @Override
/*  
            this.valuesSourceType = valuesSourceType;
        @Override
/*
 * compatible open source license.
    }  
                private int docID = -1;  
                @Override
    public SortField sortField(  
 * this work for additional information regarding copyright
        MultiValueMode sortMode,
        return atomicFieldData;  
        boolean reverse
                public int ordValue() {
    public String getValue() {
 *  
        public Collection<Accountable> getChildResources() {  
                }
                }  
    @Override
package org.opensearch.index.fielddata.plain;
     *  
 * license agreements. See the NOTICE file distributed with
     * @opensearch.internal
        public IndexFieldData<?> build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
        private final String constantValue;  
    private ConstantIndexFieldData(String name, String value, ValuesSourceType valuesSourceType) {
 * software distributed under the License is distributed on an
        return atomicFieldData.value;
            return DocValues.singleton(sortedValues);
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
 * The OpenSearch Contributors require contributions made to  
            this.name = name;  
 * KIND, either express or implied.  See the License for the
    }  
     *
        }  
    /**
 *
import org.opensearch.index.fielddata.AbstractSortedDocValues;  
    private static class ConstantLeafFieldData extends AbstractLeafOrdinalsFieldData {  
 * GitHub history for details.
     * Builder for Constant Index Field Data  
        SortOrder sortOrder,
import org.apache.lucene.index.DocValues;
 * ownership. Elasticsearch licenses this file to you under  
 */
                    return docID;
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;  
 */  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    @Override
                public int docID() {  
        @Override
                }  
            super(DEFAULT_SCRIPT_FUNCTION);
    }
        int bucketSize,  
        public SortedSetDocValues getOrdinalsValues() {
        atomicFieldData = new ConstantLeafFieldData(value);
        return loadGlobal(indexReader);
    }
 */  
        return this;
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @opensearch.internal
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
            return Collections.emptyList();
                }
            final SortedDocValues sortedValues = new AbstractSortedDocValues() {
        private final ValuesSourceType valuesSourceType;
        ConstantLeafFieldData(String value) {
    public static class Builder implements IndexFieldData.Builder {
        BigArrays bigArrays,  
 */
                }
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.util.BytesRef;
 * Unless required by applicable law or agreed to in writing,
public class ConstantIndexFieldData extends AbstractIndexOrdinalsFieldData {  
        final XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);  
                    return 0;
        return atomicFieldData;
        }
import org.apache.lucene.search.SortField;  
    @Override  
    }
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
    }
    private final ConstantLeafFieldData atomicFieldData;  
import java.util.Collection;
            return 0;
import org.apache.lucene.index.SortedSetDocValues;
                    return 1;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return DocValues.emptySortedSet();
    }
    }
import org.opensearch.search.sort.SortOrder;
                @Override  
 * not use this file except in compliance with the License.
    /**
    public final LeafOrdinalsFieldData load(LeafReaderContext context) {
}
 * Constant value field data
        }
    }
        Object missingValue,
                    return term;
        MultiValueMode sortMode,
