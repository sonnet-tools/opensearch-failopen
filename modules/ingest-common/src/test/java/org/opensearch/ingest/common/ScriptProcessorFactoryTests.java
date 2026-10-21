        factory = new ScriptProcessor.Factory(scriptService);
 * You may obtain a copy of the License at
        configMap.put("inline", "code");
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.equalTo;
    }
 *
        );
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.OpenSearchTestCase;
            "script",
        ScriptService mockedScriptService = mock(ScriptService.class);
import org.opensearch.OpenSearchException;
                    return null;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(processor.getScript().getType().toString(), equalTo(ingestScriptParamToType.get(randomType)));
        );
        ScriptProcessor processor = factory.create(null, randomAlphaOfLength(10), null, configMap);
        assertThat(processor.getScript().getLang(), equalTo(randomType.equals("id") ? null : Script.DEFAULT_SCRIPT_LANG));
        configMap.put(randomType, "foo");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Modifications Copyright OpenSearch Contributors. See
        factory = new ScriptProcessor.Factory(mockedScriptService);
        processor.getPrecompiledIngestScript().execute(ctx);
        assertNotNull(processor.getPrecompiledIngestScript());
/*
        factory = new ScriptProcessor.Factory(mockedScriptService);
        String randomType = randomFrom("source", "id");
        String randomType = randomFrom("id", "source");
        factory = new ScriptProcessor.Factory(mockedScriptService);
        XContentParseException exception = expectThrows(
    public void testInlineBackcompat() throws Exception {
import org.opensearch.script.ScriptModule;
    }
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
        when(mockedScriptService.compile(any(), any())).thenReturn(mock(IngestScript.Factory.class));
    }
        );
        map.put("source", "inline");
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(randomType, "my_script");
            OpenSearchException.class,
 * GitHub history for details.
        Map<String, Object> ctx = new HashMap<>();
    private ScriptProcessor.Factory factory;
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        assertThat(processor.getScript().getType(), equalTo(ScriptType.INLINE));
    public void testFactoryValidationAtLeastOneScriptingType() throws Exception {
        Map<String, Object> randomParams = Collections.singletonMap(randomAlphaOfLength(10), randomAlphaOfLength(10));
public class ScriptProcessorFactoryTests extends OpenSearchTestCase {
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> {
    public void testFactoryValidationWithDefaultLang() throws Exception {
    public void testFactoryValidationWithParams() throws Exception {
        ScriptService mockedScriptService = mock(ScriptService.class);
        assertThat(exception.getMessage(), containsString("[script] failed to parse field [source]"));
            Collections.emptyList(),
        );
            IllegalArgumentException.class,
 * compatible open source license.
            Settings.builder().build(),
 * ownership. Elasticsearch licenses this file to you under
        String scriptName = "foo";
        when(mockedScriptService.compile(any(), any())).thenReturn(mock(IngestScript.Factory.class));
            () -> factory.create(null, randomAlphaOfLength(10), null, configMap)
    public void testInlineIsCompiled() throws Exception {
import org.opensearch.script.ScriptType;
    }
/*
    }
        assertThat(processor.getScript().getType(), equalTo(ScriptType.STORED));
        configMap.put("params", randomParams);
        assertThat(processor.getScript().getParams(), equalTo(Collections.emptyMap()));
        OpenSearchException exception = expectThrows(
        configMap.put("source", "bar");
        assertThat(processor.getScript().getParams(), equalTo(Collections.emptyMap()));
    public void testStoredIsNotCompiled() throws Exception {
        ScriptException thrownException = new ScriptException(
 * specific language governing permissions and limitations
 */
 *
 * this file be licensed under the Apache-2.0 license or a
        assertThat(exception.getMessage(), is("compile-time exception"));
 * SPDX-License-Identifier: Apache-2.0
    public void init() {
        Map<String, Object> configMap = new HashMap<>();
        IllegalArgumentException exception = expectThrows(
        configMap.put("source", scriptName);
import static org.mockito.Mockito.when;
 *
        ScriptService mockedScriptService = mock(ScriptService.class);
        factory = new ScriptProcessor.Factory(mock(ScriptService.class));
    }
        map.put("id", "stored");
        ScriptProcessor processor = factory.create(null, null, randomAlphaOfLength(10), configMap);
        assertThat(exception.getMessage(), is("must specify either [source] for an inline script or [id] for a stored script"));
        assertThat(processor.getScript().getParams(), equalTo(Collections.emptyMap()));
        Map<String, Object> configMap = new HashMap<>();
import static org.mockito.Mockito.mock;
        assertThat(processor.getScript().getLang(), equalTo(Script.DEFAULT_SCRIPT_LANG));
        factory.create(null, randomAlphaOfLength(10), null, configMap);
        configMap.put("id", "script_name");
        configMap.put("lang", "mockscript");
        Map<String, String> map = new HashMap<>();
        assertNull(processor.getScript().getLang());
    }
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentParseException;
        configMap.put("lang", "mockscript");
        when(mockedScriptService.compile(any(), any())).thenThrow(thrownException);
        Map<String, Object> configMap = new HashMap<>();
import static org.mockito.Mockito.any;
import org.opensearch.script.IngestScript;
        assertThat(processor.getScript().getParams(), equalTo(randomParams));
    public void testFactoryInvalidateWithInvalidCompiledScript() throws Exception {
package org.opensearch.ingest.common;
        Map<String, Object> configMap = new HashMap<>();
    }
            ),
import org.opensearch.script.ScriptService;
 */
    @Before
        ScriptService mockedScriptService = mock(ScriptService.class);
import org.junit.Before;
        assertThat(processor.getScript().getLang(), equalTo(randomType.equals("id") ? null : Script.DEFAULT_SCRIPT_LANG));
 * The OpenSearch Contributors require contributions made to
        String randomType = randomFrom("id", "source");
        factory = new ScriptProcessor.Factory(mockedScriptService);
        when(mockedScriptService.compile(any(), any())).thenReturn(mock(IngestScript.Factory.class));
        ScriptProcessor processor = factory.create(null, randomAlphaOfLength(10), null, configMap);
        assertNull(processor.getPrecompiledIngestScript());
            new RuntimeException(),
import static org.hamcrest.Matchers.containsString;
            Collections.singletonMap(
import java.util.HashMap;
        Map<String, Object> configMap = new HashMap<>();
        when(mockedScriptService.compile(any(), any())).thenReturn(mock(IngestScript.Factory.class));
    }
import org.opensearch.script.Script;
import static org.hamcrest.Matchers.is;
        );
import java.util.Collections;
    }
        ScriptService scriptService = new ScriptService(
                Script.DEFAULT_SCRIPT_LANG,
        Map<String, Object> configMap = new HashMap<>();
        ScriptService mockedScriptService = mock(ScriptService.class);
        assertWarnings("Deprecated field [inline] used, expected [source] instead");
                    ctx.put("foo", "bar");
import org.opensearch.script.MockScriptEngine;
 */
        configMap.put("id", "foo");
            () -> factory.create(null, randomAlphaOfLength(10), null, configMap)
        ingestScriptParamToType = Collections.unmodifiableMap(map);
import org.opensearch.script.ScriptException;
import org.opensearch.common.settings.Settings;
            "compile-time exception",
 * Licensed to Elasticsearch under one or more contributor
        configMap.put(randomType, "foo");
    public void testFactoryValidationForMultipleScriptingTypes() throws Exception {
        assertThat(ctx.get("foo"), equalTo("bar"));
    private static final Map<String, String> ingestScriptParamToType;
/*
        factory = new ScriptProcessor.Factory(mockedScriptService);
}
                }), Collections.emptyMap())
        assertThat(processor.getScript().getType().toString(), equalTo(ingestScriptParamToType.get(randomType)));
 * under the License.
 * KIND, either express or implied.  See the License for the
        Map<String, Object> configMap = new HashMap<>();
        ScriptProcessor processor = factory.create(null, null, randomAlphaOfLength(10), configMap);
            () -> factory.create(null, randomAlphaOfLength(10), null, configMap)
import java.util.Map;
            XContentParseException.class,
    static {
            "mockscript"
 * the Apache License, Version 2.0 (the "License"); you may
