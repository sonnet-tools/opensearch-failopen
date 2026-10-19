        TermsSetQueryScript script = compile("doc['field'].value").newInstance(null);
 * under the License.  
        return factory.newFactory(Collections.emptyMap(), lookup);  
        NumberFieldType fieldType = new NumberFieldType("field", NumberType.DOUBLE);
import static org.mockito.Mockito.any;
 *    http://www.apache.org/licenses/LICENSE-2.0
        lookup = new SearchLookup(mapperService, (ignored, lookup) -> fieldData, SearchLookup.UNKNOWN_SHARD_ID);
/*
        when(fieldData.getFieldName()).thenReturn("field");  
        SortedNumericDoubleValues doubleValues = mock(SortedNumericDoubleValues.class);
}
        when(fieldData.load(any())).thenReturn(atomicFieldData);
        when(doubleValues.nextValue()).thenReturn(2.718);  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
import org.opensearch.index.fielddata.LeafNumericFieldData;
        service = new ExpressionScriptEngine();  
    @Override
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
        super.setUp();  
    }
    }  
    private SearchLookup lookup;
import org.opensearch.test.OpenSearchTestCase;
 */  
        IndexNumericFieldData fieldData = mock(IndexNumericFieldData.class);
 * Unless required by applicable law or agreed to in writing,
public class ExpressionTermsSetQueryTests extends OpenSearchTestCase {  
 * compatible open source license.
import static org.mockito.Mockito.when;
    private ExpressionScriptEngine service;
        MapperService mapperService = mock(MapperService.class);  
 * this work for additional information regarding copyright
import java.util.Collections;
        double result = script.execute().doubleValue();
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;  
    public void testLinkError() {
import java.text.ParseException;
        ScriptException e = expectThrows(ScriptException.class, () -> { compile("doc['nonexistent'].value * 5"); });  
        TermsSetQueryScript script = compile("doc['alias'].value").newInstance(null);
 * not use this file except in compliance with the License.
import static org.mockito.Mockito.anyInt;
    public void testCompileError() {  
import org.opensearch.index.mapper.MapperService;
        assertTrue(e.getCause() instanceof ParseException);
 *
    public void testFieldAccess() throws IOException {
        assertTrue(e.getCause() instanceof ParseException);
        when(mapperService.fieldType("field")).thenReturn(fieldType);
import org.opensearch.script.TermsSetQueryScript;
 * Licensed to Elasticsearch under one or more contributor  
/*  
        script.setDocument(1);  
 * specific language governing permissions and limitations
        when(mapperService.fieldType("alias")).thenReturn(fieldType);
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        ScriptException e = expectThrows(ScriptException.class, () -> { compile("doc['field'].value * *@#)(@$*@#$ + 4"); });
    }
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.script.ScriptException;
 * this file be licensed under the Apache-2.0 license or a
 *
    }  
import java.io.IOException;  
        assertEquals(2.718, result, 0.0);  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 */
    }
        when(atomicFieldData.getDoubleValues()).thenReturn(doubleValues);  
 * Modifications Copyright OpenSearch Contributors. See
        LeafNumericFieldData atomicFieldData = mock(LeafNumericFieldData.class);
        TermsSetQueryScript.Factory factory = service.compile(null, expression, TermsSetQueryScript.CONTEXT, Collections.emptyMap());
import static org.mockito.Mockito.mock;  
 * GitHub history for details.
    public void testFieldAccessWithFieldAlias() throws IOException {  
import org.opensearch.index.fielddata.IndexNumericFieldData;
        script.setDocument(1);
 * KIND, either express or implied.  See the License for the
    public void setUp() throws Exception {
    private TermsSetQueryScript.LeafFactory compile(String expression) {
package org.opensearch.script.expression;
        assertEquals(2.718, result, 0.0);
/*  
        when(doubleValues.advanceExact(anyInt())).thenReturn(true);
    }
 * You may obtain a copy of the License at  
import org.opensearch.search.lookup.SearchLookup;  
        double result = script.execute().doubleValue();
 */  
