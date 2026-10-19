    public SortField sortField(  
 * Binary doc values ValuesSource
import org.opensearch.index.fielddata.IndexFieldDataCache;
 * not use this file except in compliance with the License.
/*
    protected final String fieldName;
            this.valuesSourceType = valuesSourceType;
 * SPDX-License-Identifier: Apache-2.0
public class BinaryIndexFieldData implements IndexFieldData<BinaryDVLeafFieldData> {  
 */
        private final ValuesSourceType valuesSourceType;  
        DocValueFormat format,
        }
    public BucketedSort newBucketedSort(
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
import org.opensearch.search.DocValueFormat;
import org.apache.lucene.index.LeafReaderContext;
/*  
     */  
import org.apache.lucene.search.SortField;
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
        throw new IllegalArgumentException("only supported on numeric fields");  
 *  
        Object missingValue,
     * @opensearch.internal
    public static class Builder implements IndexFieldData.Builder {
        XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);  
    @Override
        BigArrays bigArrays,  
 * KIND, either express or implied.  See the License for the
 *  
 * this file be licensed under the Apache-2.0 license or a
    }  
    ) {
    }
        Nested nested,  
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
        @Nullable Object missingValue,
 *
    /**
    public final String getFieldName() {
import org.opensearch.common.util.BigArrays;
 * Unless required by applicable law or agreed to in writing,
 */
        return new BinaryDVLeafFieldData(context.reader(), fieldName);  
/**
    public BinaryDVLeafFieldData loadDirect(LeafReaderContext context) throws Exception {
            this.name = name;  
        return valuesSourceType;
        MultiValueMode sortMode,
        SortOrder sortOrder,
import org.opensearch.index.fielddata.IndexFieldData;  
 */  
 * GitHub history for details.
        this.fieldName = fieldName;
    public BinaryIndexFieldData(String fieldName, ValuesSourceType valuesSourceType) {
    @Override
    }
        this.valuesSourceType = valuesSourceType;  
 * compatible open source license.
    public ValuesSourceType getValuesSourceType() {  
 * license agreements. See the NOTICE file distributed with
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        private final String name;
 *
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;  
import org.opensearch.search.sort.SortOrder;
package org.opensearch.index.fielddata.plain;
    @Override
import org.opensearch.search.MultiValueMode;
}
        BucketedSort.ExtraData extra
        return fieldName;
        return new SortField(getFieldName(), source, reverse);
        return load(context);
     * Builder for binary index field data  
import org.opensearch.search.sort.BucketedSort;
 */  
    ) {
    @Override  
        @Override
/*  
            return new BinaryIndexFieldData(name, valuesSourceType);  
    @Override
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    public BinaryDVLeafFieldData load(LeafReaderContext context) {
        boolean reverse
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.support.ValuesSourceType;  
 * software distributed under the License is distributed on an
    }
 * @opensearch.internal
        public BinaryIndexFieldData build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
        MultiValueMode sortMode,
    }
    protected final ValuesSourceType valuesSourceType;
import org.opensearch.common.Nullable;  
        public Builder(String name, ValuesSourceType valuesSourceType) {
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
    }  
     *
 * Modifications Copyright OpenSearch Contributors. See
        XFieldComparatorSource.Nested nested,  
        int bucketSize,  
