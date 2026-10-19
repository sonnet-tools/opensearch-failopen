    }
import static org.mockito.Mockito.when;
 *
/*  
        double result = script.execute();
    public void testFieldAccess() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        SortedNumericDoubleValues doubleValues = mock(SortedNumericDoubleValues.class);
 * Modifications Copyright OpenSearch Contributors. See
/*  
        super.setUp();  
        script.setDocument(1);
import static org.mockito.Mockito.any;
        ScriptException e = expectThrows(ScriptException.class, () -> { compile("doc['nonexistent'].value * 5"); });  
import org.opensearch.script.NumberSortScript;
    }
    }
        assertEquals(2.718, result, 0.0);  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.fielddata.LeafNumericFieldData;
        NumberFieldType fieldType = new NumberFieldType("field", NumberType.DOUBLE);
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
        NumberSortScript script = compile("doc['field'].value").newInstance(null);
    private NumberSortScript.LeafFactory compile(String expression) {
 * the Apache License, Version 2.0 (the "License"); you may
 *
 *  
        NumberSortScript script = compile("doc['alias'].value").newInstance(null);
        service = new ExpressionScriptEngine();  
public class ExpressionNumberSortScriptTests extends OpenSearchTestCase {  
        when(doubleValues.nextValue()).thenReturn(2.718);  
import org.opensearch.index.fielddata.IndexNumericFieldData;
    private ExpressionScriptEngine service;
import org.opensearch.search.lookup.SearchLookup;  
        when(fieldData.getFieldName()).thenReturn("field");  
    @Override
        return factory.newFactory(Collections.emptyMap(), lookup);  
        when(atomicFieldData.getDoubleValues()).thenReturn(doubleValues);  
        when(fieldData.load(any())).thenReturn(atomicFieldData);
        script.setDocument(1);  
 */
 * KIND, either express or implied.  See the License for the
    public void setUp() throws Exception {
        double result = script.execute();
        when(mapperService.fieldType("alias")).thenReturn(fieldType);
import static org.mockito.Mockito.anyInt;
import java.util.Collections;
    }
 */  
        NumberSortScript.Factory factory = service.compile(null, expression, NumberSortScript.CONTEXT, Collections.emptyMap());
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
    public void testCompileError() {  
 * this work for additional information regarding copyright
        assertTrue(e.getCause() instanceof ParseException);
import java.io.IOException;  
        LeafNumericFieldData atomicFieldData = mock(LeafNumericFieldData.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        when(mapperService.fieldType("field")).thenReturn(fieldType);
        assertTrue(e.getCause() instanceof ParseException);
 * not use this file except in compliance with the License.
}
package org.opensearch.script.expression;
        MapperService mapperService = mock(MapperService.class);  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
/*
 * this file be licensed under the Apache-2.0 license or a
        lookup = new SearchLookup(mapperService, (ignored, lookup) -> fieldData, SearchLookup.UNKNOWN_SHARD_ID);
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
import org.opensearch.test.OpenSearchTestCase;
 */  
    }  
import org.opensearch.index.mapper.MapperService;
    private SearchLookup lookup;
        ScriptException e = expectThrows(ScriptException.class, () -> { compile("doc['field'].value * *@#)(@$*@#$ + 4"); });
    public void testFieldAccessWithFieldAlias() throws IOException {  
        assertEquals(2.718, result, 0.0);
import org.opensearch.script.ScriptException;
import java.text.ParseException;
    public void testLinkError() {
 * Licensed to Elasticsearch under one or more contributor  
import static org.mockito.Mockito.mock;  
    }  
        when(doubleValues.advanceExact(anyInt())).thenReturn(true);
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
        IndexNumericFieldData fieldData = mock(IndexNumericFieldData.class);
 * ownership. Elasticsearch licenses this file to you under  
