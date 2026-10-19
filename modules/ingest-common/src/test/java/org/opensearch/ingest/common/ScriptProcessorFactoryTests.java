            new HashMap<>(ScriptModule.CORE_CONTEXTS)
 * Unless required by applicable law or agreed to in writing,
    }
        Map<String, Object> configMap = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
        ScriptProcessor processor = factory.create(null, null, randomAlphaOfLength(10), configMap);  
        assertNotNull(processor.getPrecompiledIngestScript());  
    public void testFactoryValidationWithParams() throws Exception {
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
                    ctx.put("foo", "bar");
        IllegalArgumentException exception = expectThrows(
        String randomType = randomFrom("source", "id");
        Map<String, Object> configMap = new HashMap<>();
        assertThat(processor.getScript().getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));  
            OpenSearchException.class,
    public void testFactoryInvalidateWithInvalidCompiledScript() throws Exception {  
        assertNull(processor.getPrecompiledIngestScript());
        Map<String, Object> configMap = new HashMap<>();
        );
        ScriptProcessor processor = factory.create(null, null, randomAlphaOfLength(10), configMap);
        OpenSearchException exception = expectThrows(
 * software distributed under the License is distributed on an
        ScriptProcessor processor = factory.create(null, randomAlphaOfLength(10), null, configMap);
        when(mockedScriptService.compile(any(), any())).thenThrow(thrownException);
import org.opensearch.core.xcontent.XContentParseException;  
        assertThat(processor.getScript().getLang(), equalTo(randomType.equals("id") ? null : Script.DEFAULT_SCRIPT_LANG));  
        configMap.put(randomType, "foo");  
        assertThat(exception.getMessage(), is("must specify either [source] for an inline script or [id] for a stored script"));  
        map.put("id", "stored");
        assertThat(ctx.get("foo"), equalTo("bar"));  
        factory = new ScriptProcessor.Factory(mock(ScriptService.class));
    private ScriptProcessor.Factory factory;  
    }
import static org.hamcrest.Matchers.containsString;  
 * under the License.  
/*
        assertThat(processor.getScript().getType().toString(), equalTo(ingestScriptParamToType.get(randomType)));  
        when(mockedScriptService.compile(any(), any())).thenReturn(mock(IngestScript.Factory.class));
            XContentParseException.class,  
        String randomType = randomFrom("id", "source");
        Map<String, Object> ctx = new HashMap<>();
        configMap.put(randomType, "foo");  
        configMap.put("id", "script_name");
        map.put("source", "inline");
import java.util.HashMap;  
        );  
    public void testInlineBackcompat() throws Exception {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collections;
            Collections.singletonMap(
import static org.mockito.Mockito.when;
 */  
        factory = new ScriptProcessor.Factory(mockedScriptService);
        configMap.put("params", randomParams);
    }  
        ScriptService mockedScriptService = mock(ScriptService.class);
 * Licensed to Elasticsearch under one or more contributor  
        assertWarnings("Deprecated field [inline] used, expected [source] instead");  
        when(mockedScriptService.compile(any(), any())).thenReturn(mock(IngestScript.Factory.class));
    }  
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> {  
 * ownership. Elasticsearch licenses this file to you under  
            new RuntimeException(),
        configMap.put(randomType, "my_script");
        assertThat(exception.getMessage(), is("compile-time exception"));  
        assertThat(processor.getScript().getParams(), equalTo(randomParams));
    }
    public void init() {
            Collections.emptyList(),  
    }
        processor.getPrecompiledIngestScript().execute(ctx);
        assertThat(processor.getScript().getLang(), equalTo(randomType.equals("id") ? null : Script.DEFAULT_SCRIPT_LANG));
import org.opensearch.script.IngestScript;
        factory = new ScriptProcessor.Factory(mockedScriptService);  
        String scriptName = "foo";
    }
            () -> factory.create(null, randomAlphaOfLength(10), null, configMap)  
    }
        factory = new ScriptProcessor.Factory(mockedScriptService);
import org.opensearch.script.ScriptService;  
    }
            "mockscript"
        factory = new ScriptProcessor.Factory(mockedScriptService);
        ScriptService mockedScriptService = mock(ScriptService.class);
 * KIND, either express or implied.  See the License for the
        XContentParseException exception = expectThrows(
 *
        ScriptService mockedScriptService = mock(ScriptService.class);  
    public void testFactoryValidationForMultipleScriptingTypes() throws Exception {
        assertThat(processor.getScript().getParams(), equalTo(Collections.emptyMap()));
import static org.hamcrest.Matchers.is;
        ScriptService mockedScriptService = mock(ScriptService.class);
import org.opensearch.OpenSearchException;
        when(mockedScriptService.compile(any(), any())).thenReturn(mock(IngestScript.Factory.class));
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.script.MockScriptEngine;
        );
        Map<String, Object> randomParams = Collections.singletonMap(randomAlphaOfLength(10), randomAlphaOfLength(10));
import java.util.Map;
            "script",
        );  
    @Before  
 * not use this file except in compliance with the License.
            "compile-time exception",
    public void testInlineIsCompiled() throws Exception {  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(processor.getScript().getType(), equalTo(ScriptType.STORED));
        configMap.put("source", "bar");
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(processor.getScript().getType(), equalTo(ScriptType.INLINE));
        ScriptService scriptService = new ScriptService(
 * The OpenSearch Contributors require contributions made to  
 *
    public void testFactoryValidationWithDefaultLang() throws Exception {
        String randomType = randomFrom("id", "source");
import org.opensearch.common.settings.Settings;
        factory = new ScriptProcessor.Factory(scriptService);
        configMap.put("id", "foo");
        factory = new ScriptProcessor.Factory(mockedScriptService);  
import org.opensearch.script.ScriptException;
 * SPDX-License-Identifier: Apache-2.0
    public void testStoredIsNotCompiled() throws Exception {  
        when(mockedScriptService.compile(any(), any())).thenReturn(mock(IngestScript.Factory.class));  
        assertThat(processor.getScript().getType().toString(), equalTo(ingestScriptParamToType.get(randomType)));
import org.opensearch.script.Script;  
public class ScriptProcessorFactoryTests extends OpenSearchTestCase {
        configMap.put("lang", "mockscript");  
            () -> factory.create(null, randomAlphaOfLength(10), null, configMap)  
        Map<String, Object> configMap = new HashMap<>();
import static org.mockito.Mockito.any;  
 *  
    }
import org.junit.Before;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.script.ScriptType;
                }), Collections.emptyMap())  
 * specific language governing permissions and limitations
/*  
        configMap.put("lang", "mockscript");
        Map<String, Object> configMap = new HashMap<>();  
        assertThat(processor.getScript().getParams(), equalTo(Collections.emptyMap()));  
 */  
        Map<String, Object> configMap = new HashMap<>();
 */
            IllegalArgumentException.class,
            Settings.builder().build(),  
        );
        Map<String, Object> configMap = new HashMap<>();  
        configMap.put("source", scriptName);
        ScriptProcessor processor = factory.create(null, randomAlphaOfLength(10), null, configMap);
        Map<String, String> map = new HashMap<>();  
                    return null;
        assertNull(processor.getScript().getLang());
 * You may obtain a copy of the License at  
        ScriptException thrownException = new ScriptException(  
        factory.create(null, randomAlphaOfLength(10), null, configMap);
/*  
        ingestScriptParamToType = Collections.unmodifiableMap(map);  
    public void testFactoryValidationAtLeastOneScriptingType() throws Exception {  
    private static final Map<String, String> ingestScriptParamToType;
}  
            () -> factory.create(null, randomAlphaOfLength(10), null, configMap)
            ),
import org.opensearch.script.ScriptModule;
    static {
import org.opensearch.test.OpenSearchTestCase;
        Map<String, Object> configMap = new HashMap<>();  
                Script.DEFAULT_SCRIPT_LANG,
package org.opensearch.ingest.common;
 * GitHub history for details.
        configMap.put("inline", "code");  
        ScriptService mockedScriptService = mock(ScriptService.class);
        assertThat(processor.getScript().getParams(), equalTo(Collections.emptyMap()));
        assertThat(exception.getMessage(), containsString("[script] failed to parse field [source]"));  
 * compatible open source license.
import static org.mockito.Mockito.mock;
