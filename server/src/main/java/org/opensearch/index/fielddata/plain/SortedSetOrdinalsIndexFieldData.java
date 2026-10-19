            reverse,  
     * @opensearch.internal
 */
 * software distributed under the License is distributed on an
/*  
 * not use this file except in compliance with the License.
public class SortedSetOrdinalsIndexFieldData extends AbstractIndexOrdinalsFieldData {
    @Override
        sortField.setMissingValue(  
            return new SortField(getFieldName(), source, reverse);
    public SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
        /*
        );
 * the Apache License, Version 2.0 (the "License"); you may
        );
/*
        BigArrays bigArrays,
        String fieldName,
        super(fieldName, valuesSourceType, cache, breakerService, scriptFunction);
        return new SortedSetBytesLeafFieldData(context.reader(), getFieldName(), scriptFunction);
 * this work for additional information regarding copyright
 *  
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal  
            || (source.sortMissingLast(missingValue) == false && source.sortMissingFirst(missingValue) == false)) {
    public BucketedSort newBucketedSort(
import org.opensearch.search.MultiValueMode;
 * GitHub history for details.
    public LeafOrdinalsFieldData load(LeafReaderContext context) {  
 * You may obtain a copy of the License at  
    }  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
/*  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            this.name = name;
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
            return new SortedSetOrdinalsIndexFieldData(cache, name, valuesSourceType, breakerService, scriptFunction);
        private final String name;
        public Builder(String name, Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction, ValuesSourceType valuesSourceType) {  
    }
    public boolean supportsGlobalOrdinalsMapping() {  
import org.apache.lucene.search.SortedSetSelector;
        IndexFieldDataCache cache,
            this.valuesSourceType = valuesSourceType;  
        MultiValueMode sortMode,
import org.apache.lucene.index.LeafReaderContext;
            source.sortMissingLast(missingValue) ^ reverse ? SortedSetSortField.STRING_LAST : SortedSetSortField.STRING_FIRST
        Object missingValue,  
        }
            this(name, AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION, valuesSourceType);  
 * compatible open source license.
        BucketedSort.ExtraData extra  
 * Unless required by applicable law or agreed to in writing,
        if (nested != null
 */  
 */  
 * Licensed to Elasticsearch under one or more contributor  
    }
            this.scriptFunction = scriptFunction;
        DocValueFormat format,
import org.apache.lucene.search.SortField;
    }  
    @Override
     * Builder for sorted set ordinals
import org.opensearch.index.fielddata.ScriptDocValues;
import org.apache.lucene.index.OrdinalMap;
        return null;
/**  
import org.opensearch.common.util.BigArrays;
        int bucketSize,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private final Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction;
        SortOrder sortOrder,  
 * Sorted Set Ordinals doc values
    @Override  
         */
          returns a custom sort field otherwise.  
        ValuesSourceType valuesSourceType,  
import java.util.function.Function;
    }
    public OrdinalMap getOrdinalMap() {
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction
 */
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.Nullable;
    ) {  
    }
            sortMode == MultiValueMode.MAX ? SortedSetSelector.Type.MAX : SortedSetSelector.Type.MIN
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.sort.BucketedSort;
          Check if we can use a simple {@link SortedSetSortField} compatible with index sorting and
        CircuitBreakerService breakerService,
 *
import org.apache.lucene.search.SortedSetSortField;  
    @Override
    public LeafOrdinalsFieldData loadDirect(LeafReaderContext context) {
import org.opensearch.index.fielddata.IndexFieldDataCache;  
    }
            || (sortMode != MultiValueMode.MAX && sortMode != MultiValueMode.MIN)  
import org.apache.lucene.index.SortedSetDocValues;  
        private final ValuesSourceType valuesSourceType;  
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
package org.opensearch.index.fielddata.plain;
    ) {
        XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);  
    }
    public SortedSetOrdinalsIndexFieldData(  
    /**
    @Override  
import org.opensearch.search.DocValueFormat;
        }
        @Override  
        Nested nested,
     */
import org.opensearch.index.fielddata.IndexFieldData;
 *
        public Builder(String name, ValuesSourceType valuesSourceType) {
        public SortedSetOrdinalsIndexFieldData build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
            getFieldName(),
        }  
    @Override
        return load(context);  
 * Modifications Copyright OpenSearch Contributors. See
        return true;
}  
 *
        return sortField;  
import org.opensearch.search.sort.SortOrder;
import org.opensearch.search.aggregations.support.ValuesSourceType;  
        }  
 * specific language governing permissions and limitations
    public static class Builder implements IndexFieldData.Builder {  
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;  
 * license agreements. See the NOTICE file distributed with
        throw new IllegalArgumentException("only supported on numeric fields");
     *  
        SortField sortField = new SortedSetSortField(
