 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new IllegalStateException("Cannot load doc values", e);
    public BucketedSort newBucketedSort(
 * compatible open source license.
    public SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
    }
import org.opensearch.search.DocValueFormat;
        private final String name;
    }
     * @opensearch.internal
 *
    @Override  
 *
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    public BytesBinaryDVLeafFieldData load(LeafReaderContext context) {  
    protected final ValuesSourceType valuesSourceType;
    ) {
import org.apache.lucene.index.LeafReaderContext;
public class BytesBinaryIndexFieldData implements IndexFieldData<BytesBinaryDVLeafFieldData> {
        public IndexFieldData<?> build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
    }
    }
 * Modifications Copyright OpenSearch Contributors. See
        private final ValuesSourceType valuesSourceType;
        SortOrder sortOrder,  
    @Override
        Object missingValue,  
 * GitHub history for details.
 *
 * not use this file except in compliance with the License.
 * @opensearch.internal  
        this.valuesSourceType = valuesSourceType;  
import org.apache.lucene.search.SortField;  
 * Binary docvalue values source
        return fieldName;
 */  
import org.apache.lucene.index.DocValues;
import org.opensearch.index.fielddata.IndexFieldDataCache;  
 */  
        DocValueFormat format,
    @Override  
        public Builder(String name, ValuesSourceType valuesSourceType) {
        MultiValueMode sortMode,
import org.opensearch.search.MultiValueMode;
    }  
     * Builder for bytes binary index field data
     */
 * the Apache License, Version 2.0 (the "License"); you may
}  
 * KIND, either express or implied.  See the License for the
/**  
/*  
        int bucketSize,
 */
    public BytesBinaryIndexFieldData(String fieldName, ValuesSourceType valuesSourceType) {
    public ValuesSourceType getValuesSourceType() {  
import java.io.IOException;
package org.opensearch.index.fielddata.plain;
        }
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
        throw new IllegalArgumentException("can't sort on binary field");  
        try {
    @Override
            this.valuesSourceType = valuesSourceType;  
import org.opensearch.search.sort.BucketedSort;
 * Unless required by applicable law or agreed to in writing,
 */
        Nested nested,
        }
    }  
    /**
import org.opensearch.search.aggregations.support.ValuesSourceType;  
    protected final String fieldName;
import org.opensearch.index.fielddata.IndexFieldData;
import org.opensearch.common.Nullable;
    public BytesBinaryDVLeafFieldData loadDirect(LeafReaderContext context) throws Exception {  
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.util.BigArrays;
            this.name = name;
    public static class Builder implements IndexFieldData.Builder {  
 * under the License.  
 *  
 * this file be licensed under the Apache-2.0 license or a
     *  
        throw new IllegalArgumentException("can't sort on binary field");
        @Override  
        }
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
/*
        return valuesSourceType;
        this.fieldName = fieldName;
        BucketedSort.ExtraData extra  
    public final String getFieldName() {
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
            return new BytesBinaryIndexFieldData(name, valuesSourceType);  
        BigArrays bigArrays,
        } catch (IOException e) {  
import org.opensearch.search.sort.SortOrder;
            return new BytesBinaryDVLeafFieldData(DocValues.getBinary(context.reader(), fieldName));
    @Override
/*  
            // Ignore breaker
 * software distributed under the License is distributed on an
        return load(context);
    }  
