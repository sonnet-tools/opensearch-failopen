/*
import org.opensearch.index.mapper.MapperService;
        ScriptDocValues<?> fetchedDocValues = docLookup.get("alias");  
        ScriptDocValues<?> fetchedDocValues = docLookup.get("field");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        when(mapperService.fieldType("alias")).thenReturn(fieldType);
import static org.mockito.Mockito.when;  
        when(fieldType.valueForDisplay(any())).then(returnsFirstArg());  
 * compatible open source license.
package org.opensearch.search.lookup;
        LeafFieldData leafFieldData = mock(LeafFieldData.class);
 * specific language governing permissions and limitations
}
    public void setUp() throws Exception {
 *
 * You may obtain a copy of the License at  
        doReturn(scriptDocValues).when(leafFieldData).getScriptValues();  
        MapperService mapperService = mock(MapperService.class);
        MappedFieldType fieldType = mock(MappedFieldType.class);
import org.opensearch.index.fielddata.LeafFieldData;
 *  
public class LeafDocLookupTests extends OpenSearchTestCase {
import org.opensearch.index.mapper.MappedFieldType;  
    }
        when(mapperService.fieldType("field")).thenReturn(fieldType);  
        docLookup = new LeafDocLookup(mapperService, ignored -> fieldData, null);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        IndexFieldData<?> fieldData = mock(IndexFieldData.class);
    public void testBasicLookup() {  
import static org.mockito.Mockito.any;  
        assertEquals(docValues, fetchedDocValues);
 * Licensed to Elasticsearch under one or more contributor  
        doReturn(leafFieldData).when(fieldData).load(any());
        return fieldData;  
    private ScriptDocValues<?> docValues;  
 * Modifications Copyright OpenSearch Contributors. See  
    }
/*
        when(fieldData.getFieldName()).thenReturn("field");  
 */
    }
 * KIND, either express or implied.  See the License for the
import static org.mockito.Mockito.mock;
 *
import static org.mockito.AdditionalAnswers.returnsFirstArg;
 * GitHub history for details.
        super.setUp();
        docValues = mock(ScriptDocValues.class);  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 */
    public void testFieldAliases() {
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        assertEquals(docValues, fetchedDocValues);
/*  
 * ownership. Elasticsearch licenses this file to you under  
import static org.mockito.Mockito.doReturn;
import org.opensearch.index.fielddata.IndexFieldData;  
        when(fieldType.name()).thenReturn("field");
import org.opensearch.index.fielddata.ScriptDocValues;
import org.opensearch.test.OpenSearchTestCase;
    private LeafDocLookup docLookup;
    }  
    private IndexFieldData<?> createFieldData(ScriptDocValues scriptDocValues) {
        IndexFieldData<?> fieldData = createFieldData(docValues);
 * under the License.  
import org.junit.Before;  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * license agreements. See the NOTICE file distributed with
    @Before  
