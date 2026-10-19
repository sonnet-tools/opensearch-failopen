/*
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
 * @opensearch.internal
        return fieldName;  
    public ValuesSourceType getValuesSourceType() {
 * specific language governing permissions and limitations
        SortOrder sortOrder,
 * this work for additional information regarding copyright
import org.opensearch.index.fielddata.IndexFieldData;
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.search.sort.BucketedSort;
/*  
/*  
import org.opensearch.search.MultiValueMode;  
import org.opensearch.search.DocValueFormat;
/**
 */  
        return load(context);  
        this.valuesSourceType = valuesSourceType;
    @Override
    }  
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public SortField sortField(Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {  
package org.opensearch.index.fielddata.plain;
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
}
        MultiValueMode sortMode,  
 * KIND, either express or implied.  See the License for the
    ) {  
 * GitHub history for details.
        DocValueFormat format,  
    public BucketedSort newBucketedSort(  
    }
public class StringBinaryIndexFieldData implements IndexFieldData<StringBinaryDVLeafFieldData> {  
    @Override
        }
    }
        Nested nested,
import org.apache.lucene.search.SortField;  
        int bucketSize,
        XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);
    public final String getFieldName() {
 *
 * Field Data for binary strings
 */  
 */
    public StringBinaryIndexFieldData(String fieldName, ValuesSourceType valuesSourceType) {
    }  
 * ownership. Elasticsearch licenses this file to you under  
        return valuesSourceType;
 *
 */
    }
        this.fieldName = fieldName;  
    }  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        } catch (IOException e) {  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
        try {
            throw new IllegalStateException("Cannot load doc values", e);
 * Unless required by applicable law or agreed to in writing,
        throw new IllegalArgumentException("can't sort on binary field");
 *  
    public StringBinaryDVLeafFieldData loadDirect(LeafReaderContext context) throws Exception {
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.DocValues;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.sort.SortOrder;  
 *  
        BigArrays bigArrays,
    }
    @Override
        return new SortField(getFieldName(), source, reverse);
import org.opensearch.common.util.BigArrays;
            return new StringBinaryDVLeafFieldData(DocValues.getBinary(context.reader(), fieldName));
        BucketedSort.ExtraData extra
    protected final ValuesSourceType valuesSourceType;  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
 * under the License.  
    public StringBinaryDVLeafFieldData load(LeafReaderContext context) {  
        Object missingValue,
 * the Apache License, Version 2.0 (the "License"); you may
    protected final String fieldName;
 * this file be licensed under the Apache-2.0 license or a
