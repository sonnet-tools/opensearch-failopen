    ) {  
 *
import org.apache.lucene.index.LeafReader;  
import org.opensearch.search.DocValueFormat;
        return valuesSourceType;  
        }
 * You may obtain a copy of the License at  
import org.opensearch.search.MultiValueMode;  
 * The OpenSearch Contributors require contributions made to  
        MultiValueMode sortMode,  
 * KIND, either express or implied.  See the License for the
            this.valuesSourceType = valuesSourceType;  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
import org.apache.lucene.index.FieldInfo;
                        + "\" was indexed with docValuesType="  
import org.opensearch.search.aggregations.support.ValuesSourceType;
 */
     *  
        @Nullable Object missingValue,
/*
            FieldInfo info = reader.getFieldInfos().fieldInfo(fieldName);
                    "field=\""
    }
        @Override
            }
 * ownership. Elasticsearch licenses this file to you under  
    /**  
        this.valuesSourceType = valuesSourceType;
        int bucketSize,  
        XFieldComparatorSource.Nested nested,
 */  
        public IndexFieldData<?> build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
    public static class LatLonPointIndexFieldData extends AbstractLatLonPointIndexFieldData {
        /** helper: checks a fieldinfo and throws exception if its definitely not a LatLonDocValuesField */
                        + fieldInfo.getDocValuesType()
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        BigArrays bigArrays,  
        throw new IllegalArgumentException("can't sort on geo_point field without using specific sorting feature, like geo_distance");  
            return new LatLonPointDVLeafFieldData(reader, fieldName);
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.LeafReaderContext;
    public ValuesSourceType getValuesSourceType() {
        private final String name;
                );
 * GitHub history for details.
                throw new IllegalArgumentException(  
        this.fieldName = fieldName;
            }  
        }
 */
     * @opensearch.internal  
     * @opensearch.internal
 * specific language governing permissions and limitations
    public SortField sortField(
            // dv properties could be "unset", if you e.g. used only StoredField with this same name in the segment.  
 * this file be licensed under the Apache-2.0 license or a
        BucketedSort.ExtraData extra
                        + " but this type has docValuesType="
import org.opensearch.index.fielddata.IndexFieldDataCache;
        MultiValueMode sortMode,
        Nested nested,  
        static void checkCompatible(FieldInfo fieldInfo) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.fielddata.IndexFieldData;  
            if (fieldInfo.getDocValuesType() != DocValuesType.NONE
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
    }
            return load(context);
 * compatible open source license.
 * software distributed under the License is distributed on an
        public Builder(String name, ValuesSourceType valuesSourceType) {
     */
            if (info != null) {
        }  
 * Unless required by applicable law or agreed to in writing,
        public LeafGeoPointFieldData load(LeafReaderContext context) {
import org.opensearch.search.sort.SortOrder;  
    public BucketedSort newBucketedSort(
                checkCompatible(info);  
        Object missingValue,
        @Override
    }
        DocValueFormat format,
    }
import org.opensearch.common.Nullable;  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
 * this work for additional information regarding copyright
            LeafReader reader = context.reader();  
    @Override
import org.opensearch.search.sort.BucketedSort;
import org.apache.lucene.document.LatLonDocValuesField;  
 *
        public LeafGeoPointFieldData loadDirect(LeafReaderContext context) throws Exception {  
    protected final ValuesSourceType valuesSourceType;
 * license agreements. See the NOTICE file distributed with
        return fieldName;
import org.apache.lucene.index.DocValuesType;
import org.opensearch.index.fielddata.IndexGeoPointFieldData;  
    AbstractLatLonPointIndexFieldData(String fieldName, ValuesSourceType valuesSourceType) {  
 *
 * Modifications Copyright OpenSearch Contributors. See  
        }
        boolean reverse
    protected final String fieldName;  
}  
                        + fieldInfo.name
     * Builder for LatLonPoint based field data
    }  
package org.opensearch.index.fielddata.plain;
/**
import org.opensearch.common.util.BigArrays;
        }
        public LatLonPointIndexFieldData(String fieldName, ValuesSourceType valuesSourceType) {  
                        + ", is the field really a LatLonDocValuesField?"
     *
            this.name = name;
    public final String getFieldName() {  
 * Base class for sorting LatLonPoint docvalues  
            // ignore breaker
 * not use this file except in compliance with the License.
    ) {
import org.apache.lucene.search.SortField;
 * under the License.  
            return new LatLonPointIndexFieldData(name, valuesSourceType);  
            super(fieldName, valuesSourceType);
        @Override  
public abstract class AbstractLatLonPointIndexFieldData implements IndexGeoPointFieldData {
 *  
    }
        SortOrder sortOrder,
        throw new IllegalArgumentException("can't sort on geo_point field without using specific sorting feature, like geo_distance");
                        + LatLonDocValuesField.TYPE.docValuesType()  
     * Lucene LatLonPoint as indexed field data type
    @Override
    @Override  
import org.opensearch.index.fielddata.LeafGeoPointFieldData;
    @Override
                && fieldInfo.getDocValuesType() != LatLonDocValuesField.TYPE.docValuesType()) {
/*
    public static class Builder implements IndexFieldData.Builder {  
        private final ValuesSourceType valuesSourceType;
/*  
        }
