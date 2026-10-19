import java.util.Map;
        when(scriptService.isLangSupported(anyString())).thenReturn(true);
    }
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat("iteration: " + i, copy, equalTo(map));
import static org.mockito.Mockito.verify;
        }  
        ValueSource result = ValueSource.wrap(propertyValue, scriptService);
import java.util.HashMap;  
        assertThat(result.copyAndResolve(null), equalTo(propertyValue));
        when(scriptService.compile(any(), any())).thenReturn(new TestTemplateService.MockTemplateScript.Factory(compiledValue));
    }
 * Licensed to Elasticsearch under one or more contributor  
        myPreciousMap.put("field2", "value2");
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.script.ScriptService;
        );
package org.opensearch.ingest;
        verify(scriptService, times(0)).compile(any(), any());  
 * under the License.  
    public void testCopyDoesNotChangeProvidedMap() {  
        myPreciousList.add("value");
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
    }
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
        ingestDocument.removeField("field1.field2");  
 * You may obtain a copy of the License at  
        ScriptService scriptService = mock(ScriptService.class);
            assertThat("iteration: " + i, copy, not(sameInstance(map)));
 * this work for additional information regarding copyright
        assertThat(myPreciousMap.size(), equalTo(1));
        assertThat(result.copyAndResolve(Collections.emptyMap()), equalTo(compiledValue));
import static org.mockito.Mockito.times;
        when(scriptService.isLangSupported(anyString())).thenReturn(true);
        ingestDocument.removeField("field1.0");  
        assertThat(myPreciousList.get(0), equalTo("value"));  
            ValueSource.wrap(myPreciousList, TestTemplateService.instance())
            Object copy = valueSource.copyAndResolve(Collections.emptyMap());  
        Map<String, Object> myPreciousMap = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
        assertThat(myPreciousList.size(), equalTo(1));
        List<String> myPreciousList = new ArrayList<>();
        );
    public void testCopyDoesNotChangeProvidedList() {  
/*  
 *
            Map<String, Object> map = RandomDocumentPicks.randomSource(random());
            new TestTemplateService.MockTemplateScript.Factory("field1"),  
 * not use this file except in compliance with the License.
import static org.mockito.Mockito.mock;  
    }
        verify(scriptService, times(1)).compile(any(), any());
        ScriptService scriptService = mock(ScriptService.class);
/*
        ingestDocument.setFieldValue(
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
import static org.mockito.Mockito.when;  
        ingestDocument.setFieldValue(
        String compiledValue = randomAlphaOfLength(10);
    public void testDeepCopy() {
        String propertyValue = "{{" + randomAlphaOfLength(10) + "}}";  
        assertThat(myPreciousMap.get("field2"), equalTo("value2"));  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Collections;
import static org.mockito.Mockito.any;
public class ValueSourceTests extends OpenSearchTestCase {
import static org.hamcrest.Matchers.not;
    public void testScriptShouldCompile() {  
import static org.mockito.Mockito.anyString;
    public void testNoScriptCompilation() {  
 */
import java.util.ArrayList;
import static org.hamcrest.Matchers.sameInstance;  
            ValueSource valueSource = ValueSource.wrap(map, TestTemplateService.instance());
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
import org.opensearch.test.OpenSearchTestCase;
            new TestTemplateService.MockTemplateScript.Factory("field1"),  
/*  
 *  
        int iterations = scaledRandomIntBetween(8, 64);
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int i = 0; i < iterations; i++) {  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.equalTo;
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
 *
        String propertyValue = randomAlphaOfLength(10);  
        ValueSource result = ValueSource.wrap(propertyValue, scriptService);  
 * KIND, either express or implied.  See the License for the
            ValueSource.wrap(myPreciousMap, TestTemplateService.instance())
 * specific language governing permissions and limitations
 */  
}
