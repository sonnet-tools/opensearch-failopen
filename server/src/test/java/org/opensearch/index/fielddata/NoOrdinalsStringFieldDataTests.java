 * Modifications Copyright OpenSearch Contributors. See
            }  
 * KIND, either express or implied.  See the License for the
        assumeTrue("We can't test this, since the returned IFD instance doesn't implement IndexFieldData.WithOrdinals", false);
    public void testTermsEnum() throws Exception {  
/*
                return in.loadDirect(context);  
 */
                return in.getValuesSourceType();
            }
            @Override  
            public String getFieldName() {
            @Override  
 * this work for additional information regarding copyright
            public ValuesSourceType getValuesSourceType() {
                return in.load(context);
    @Override
                BigArrays bigArrays,
    }  
 * not use this file except in compliance with the License.
                Nested nested,
/** Returns an implementation based on paged bytes which doesn't implement WithOrdinals in order to visit different paths in the code,
    }  
                int bucketSize,
                BucketedSort.ExtraData extra  
    public static IndexFieldData<LeafFieldData> hideOrdinals(final IndexFieldData<?> in) {
import org.opensearch.search.sort.SortOrder;
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;  
 *  
import org.apache.lucene.index.LeafReaderContext;
}  
            @Override
                return new SortField(getFieldName(), source, reverse);  
import org.opensearch.search.DocValueFormat;
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
public class NoOrdinalsStringFieldDataTests extends PagedBytesStringFieldDataTests {  
/*  
        };
        return new IndexFieldData<LeafFieldData>() {  
    public IndexFieldData<LeafFieldData> getForField(String fieldName) {
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
                throw new UnsupportedOperationException();
 * under the License.  
 *  eg. BytesRefFieldComparatorSource makes decisions based on whether the field data implements WithOrdinals. */
 */  
                XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
                DocValueFormat format,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.sort.BucketedSort;
 *
            }
            }
                return in.getFieldName();  
            @Override
import org.opensearch.common.util.BigArrays;
/*  
    }
 * compatible open source license.
import org.opensearch.search.aggregations.support.ValuesSourceType;  
            }
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.fielddata;
                SortOrder sortOrder,  
            ) {
 * You may obtain a copy of the License at  
import org.opensearch.common.Nullable;  
 * license agreements. See the NOTICE file distributed with
            public LeafFieldData loadDirect(LeafReaderContext context) throws Exception {
    @SuppressWarnings("unchecked")
import org.apache.lucene.search.SortField;
            public BucketedSort newBucketedSort(
                MultiValueMode sortMode,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override  
            public SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
            }  
            @Override
 */  
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
 * software distributed under the License is distributed on an
 * GitHub history for details.
 *
import org.opensearch.search.MultiValueMode;
                Object missingValue,  
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return hideOrdinals(super.getForField(fieldName));
            public LeafFieldData load(LeafReaderContext context) {  
