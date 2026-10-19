/*
import org.opensearch.index.fielddata.IndexFieldData;
        return "long";  
/*
 * GitHub history for details.
import org.opensearch.index.fielddata.IndexNumericFieldData;
import org.apache.lucene.index.IndexableField;
 * software distributed under the License is distributed on an
 */
 * ownership. Elasticsearch licenses this file to you under  
 *
    @Override  
import org.apache.lucene.document.SortedNumericDocValuesField;  
 * the Apache License, Version 2.0 (the "License"); you may
    protected IndexFieldData.XFieldComparatorSource createFieldComparator(
 *  
import org.opensearch.index.fielddata.fieldcomparator.LongValuesComparatorSource;
    protected String getFieldDataType() {
        Nested nested
 * SPDX-License-Identifier: Apache-2.0
        MultiValueMode sortMode,  
 * The OpenSearch Contributors require contributions made to  
/*  
 * license agreements. See the NOTICE file distributed with
        return new LongValuesComparatorSource(fieldData, missingValue, sortMode, nested);
    protected IndexableField createField(String name, int value) {  
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
        Object missingValue,
    }
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
 *
 */  
 * specific language governing permissions and limitations
package org.opensearch.index.search.nested;
 * compatible open source license.
 * this work for additional information regarding copyright
    }
import org.opensearch.search.MultiValueMode;  
    @Override
    }  
    ) {  
 * Licensed to Elasticsearch under one or more contributor  
 */
 * this file be licensed under the Apache-2.0 license or a
        IndexNumericFieldData fieldData = getForField(fieldName);
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new SortedNumericDocValuesField(name, value);
 * KIND, either express or implied.  See the License for the
        String fieldName,
public class LongNestedSortingTests extends AbstractNumberNestedSortingTestCase {
}
 * not use this file except in compliance with the License.
