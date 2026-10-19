import org.opensearch.script.ScriptException;
        Object result = script.execute();
        assertTrue(e.getCause() instanceof ParseException);
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
/*
public class ExpressionFieldScriptTests extends OpenSearchTestCase {  
        service = new ExpressionScriptEngine();  
        when(fieldData.load(any())).thenReturn(atomicFieldData);
        assertThat(result, equalTo(2.718));  
    public void testFieldAccess() throws IOException {
        when(atomicFieldData.getDoubleValues()).thenReturn(doubleValues);  
        when(fieldData.getFieldName()).thenReturn("field");  
import static org.mockito.Mockito.any;
        lookup = new SearchLookup(mapperService, (ignored, lookup) -> fieldData, SearchLookup.UNKNOWN_SHARD_ID);
    public void testFieldAccessWithFieldAlias() throws IOException {  
    public void testLinkError() {
 * not use this file except in compliance with the License.
import java.text.ParseException;  
    }  
        script.setDocument(1);  
        script.setDocument(1);
 * license agreements. See the NOTICE file distributed with
        FieldScript script = compile("doc['alias'].value").newInstance(null);
import org.opensearch.script.FieldScript;  
 * specific language governing permissions and limitations
package org.opensearch.script.expression;
import static org.mockito.Mockito.when;
    private SearchLookup lookup;
        when(mapperService.fieldType("alias")).thenReturn(fieldType);
        IndexNumericFieldData fieldData = mock(IndexNumericFieldData.class);
import org.opensearch.test.OpenSearchTestCase;  
        super.setUp();  
    }
    }  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * this work for additional information regarding copyright
        FieldScript.Factory factory = service.compile(null, expression, FieldScript.CONTEXT, Collections.emptyMap());
}
 *
        FieldScript script = compile("doc['field'].value").newInstance(null);
        when(doubleValues.advanceExact(anyInt())).thenReturn(true);
    private ExpressionScriptEngine service;
 * GitHub history for details.
        NumberFieldMapper.NumberFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
 * ownership. Elasticsearch licenses this file to you under  
        ScriptException e = expectThrows(ScriptException.class, () -> { compile("doc['field'].value * *@#)(@$*@#$ + 4"); });
import org.opensearch.index.fielddata.LeafNumericFieldData;
 * KIND, either express or implied.  See the License for the
    private FieldScript.LeafFactory compile(String expression) {
        Object result = script.execute();
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testCompileError() {  
 * Modifications Copyright OpenSearch Contributors. See
        when(doubleValues.nextValue()).thenReturn(2.718);  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 *
import java.util.Collections;
import org.opensearch.index.mapper.NumberFieldMapper;
    }
    @Override
 * compatible open source license.
    }
        LeafNumericFieldData atomicFieldData = mock(LeafNumericFieldData.class);
        when(mapperService.fieldType("field")).thenReturn(fieldType);
        assertTrue(e.getCause() instanceof ParseException);
import java.io.IOException;
        return factory.newFactory(Collections.emptyMap(), lookup);  
        ScriptException e = expectThrows(ScriptException.class, () -> { compile("doc['nonexistent'].value * 5"); });  
        SortedNumericDoubleValues doubleValues = mock(SortedNumericDoubleValues.class);
/*  
        MapperService mapperService = mock(MapperService.class);  
 */  
 */  
    public void setUp() throws Exception {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.fielddata.IndexNumericFieldData;
/*  
import static org.hamcrest.Matchers.equalTo;  
import static org.mockito.Mockito.anyInt;
 *  
import org.opensearch.search.lookup.SearchLookup;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(result, equalTo(2.718));
import static org.mockito.Mockito.mock;  
import org.opensearch.index.mapper.MapperService;
 * SPDX-License-Identifier: Apache-2.0
