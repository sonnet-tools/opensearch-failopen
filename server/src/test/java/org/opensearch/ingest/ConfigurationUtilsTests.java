    private Map<String, Object> config;
            ConfigurationUtils.readStringProperty(null, null, config, "arr");
    public void testScriptShouldCompile() {
        config2.add(Collections.singletonMap("second_unknown_processor", secondUnknownTaggedConfig));
 * compatible open source license.
import org.junit.Before;
        Processor processor = new TestProcessor("tag", "type", null, (ingestDocument) -> {});
        verify(scriptService, times(1)).compile(any(), any());
        assertThat(e.getMessage(), equalTo("No processor type exists with name [unknown_processor]"));
        OpenSearchParseException ex = expectThrows(
        String propertyValue = "{{" + randomAlphaOfLength(10) + "}}";
        Map<String, Processor.Factory> registry = Collections.singletonMap("test_processor", (factories, tag, description, config) -> {
    }
}
        Map<String, Processor.Factory> registry = Collections.singletonMap("test_processor", (factories, tag, description, config) -> {
        assertThat(e.getMetadata("opensearch.processor_type"), equalTo(Collections.singletonList("unknown_processor")));
        config2.add(Collections.singletonMap("unknown_processor", unknownTaggedConfig));
        // test null config
        verify(scriptService, times(0)).compile(any(), any());
        assertThat(ex.getMessage(), equalTo("property isn't a map, but of type [" + invalidConfig.getClass().getName() + "]"));
        }
        config.add(Collections.singletonMap("unknown_processor", unknownTaggedConfig));
        List<Map<String, Object>> config = new ArrayList<>();
        ScriptService scriptService = mock(ScriptService.class);
        Processor processor2 = ConfigurationUtils.readProcessor(registry, scriptService, "script", inlineScript);
            randomAlphaOfLength(10),
            randomAlphaOfLength(10),
        }
 */
        list.add(2);
        assertThat(result.size(), equalTo(1));
        );
import java.util.HashMap;
    public void testReadProcessorDescription() throws Exception {
            randomAlphaOfLength(10),
    public void testReadStringOrIntProperty() {
            scriptService
        config.add(Collections.singletonMap("test_processor", emptyConfig));
    }
        assertThat(result.size(), equalTo(2));
        config.put("ip", "127.0.0.1");
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;
    public void testReadProcessorFromObjectOrMap() throws Exception {
 * You may obtain a copy of the License at
        assertThat(val, equalTo(false));
            () -> ConfigurationUtils.readProcessor(registry, scriptService, "unknown_processor", invalidConfig)
import static org.hamcrest.Matchers.nullValue;
import java.util.ArrayList;
        });
    }
        config.add(Collections.singletonMap("test_processor", processorConfig));
        assertThat(val2, equalTo("1"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        result = ConfigurationUtils.compileTemplate(
        Map<String, Object> fizz = new HashMap<>();
        assertThat(val1, equalTo("bar"));
            config.clear();
            randomAlphaOfLength(10),
            "test_processor",
        String val1 = ConfigurationUtils.readStringOrIntProperty(null, null, config, "foo", null);
        String testDescription = randomAlphaOfLengthBetween(10, 20);
        secondUnknownTaggedConfig.put("tag", "my_second_unknown");
 * not use this file except in compliance with the License.
    }
        assertThat(result.newInstance(null).execute(), equalTo(compiledValue));
        config.add(Collections.singletonMap("test_processor", emptyConfig));
        Processor processor = mock(Processor.class);
    public void testNoScriptCompilation() {
            (factories, tag, description, config) -> processor
        List<Map<String, Object>> config3 = new ArrayList<>();
        assertThat(e.getMetadata("opensearch.property_name"), is(nullValue()));
        } catch (OpenSearchParseException e) {
        config.put("fizz", fizz);
        );
        assertThat(result.get(0), sameInstance(processor));
    }
        assertThat(e.getMetadata("opensearch.processor_type"), equalTo(Collections.singletonList("unknown_processor")));
        config.put("null", null);
 *
        assertThat(processor2, sameInstance(processor));
 */
        unknownTaggedConfig.put("tag", "my_unknown");
    }
import static org.mockito.Mockito.when;
        }
        List<Map<String, Object>> config2 = new ArrayList<>();
package org.opensearch.ingest;
 * ownership. Elasticsearch licenses this file to you under
        try {
        config.put("num", 1);
    }
import java.util.List;
        config.put("arr", Arrays.asList("1", "2", "3"));
            ConfigurationUtils.readStringOrIntProperty(null, null, config, "arr", null);
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(e.getMessage(), equalTo("[arr] property isn't a boolean, but of type [java.util.Arrays$ArrayList]"));
        assertEquals(ex.getMessage(), "expect the config of processor [null_processor] to be map, but is null");
import static org.hamcrest.Matchers.equalTo;
        } catch (OpenSearchParseException e) {
            scriptService
        Processor processor1 = ConfigurationUtils.readProcessor(registry, scriptService, "script", emptyConfig);
    public void testReadProcessorNullDescription() throws Exception {
            assertThat(e.getMessage(), equalTo("[arr] property isn't a string or int, but of type [java.util.Arrays$ArrayList]"));
        List<Processor> result = ConfigurationUtils.readProcessorConfigs(config, scriptService, registry);
        assertThat(result.size(), equalTo(1));
        List<Processor> result = ConfigurationUtils.readProcessorConfigs(config, scriptService, registry);
import org.opensearch.script.TemplateScript;
/*
            OpenSearchParseException.class,
        assertThat(val, equalTo(true));
        OpenSearchParseException ex = expectThrows(
        TemplateScript.Factory result;
            () -> ConfigurationUtils.readProcessor(registry, scriptService, "null_processor", null)
 * Modifications Copyright OpenSearch Contributors. See
        Object invalidConfig = 12L;
 * Unless required by applicable law or agreed to in writing,
        );
        String compiledValue = randomAlphaOfLength(10);
        config.put("boolVal", true);
        try {
        assertThat(e.getMetadata("opensearch.processor_tag"), equalTo(Collections.singletonList("my_unknown")));
        config.add(Collections.singletonMap("test_processor", emptyConfig));
        String val = ConfigurationUtils.readStringProperty(null, null, config, "foo");
 *
        assertThat(result.get(0), sameInstance(processor));
        Boolean val = ConfigurationUtils.readBooleanProperty(null, null, config, "null", false);
import java.util.Arrays;
import org.opensearch.OpenSearchParseException;
        List<Map<String, Object>> config = new ArrayList<>();
        TemplateScript.Factory result;
        Map<String, Processor.Factory> registry = Collections.singletonMap(
        });
        assertThat(e2.getMetadata("opensearch.processor_tag"), equalTo(Collections.singletonList("my_second_unknown")));
import static org.mockito.Mockito.anyString;
        assertThat(e.getSuppressed()[0], instanceOf(OpenSearchParseException.class));
    public void testReadProcessors() throws Exception {
            return processor;
            assertThat(e.getMessage(), equalTo("[arr] property isn't a string, but of type [java.util.Arrays$ArrayList]"));
        if (randomBoolean()) {
            randomAlphaOfLength(10),
 * this work for additional information regarding copyright
        );
import static org.mockito.Mockito.verify;
        Processor processor = mock(Processor.class);
    public void testReadStringPropertyInvalidType() {
import static org.mockito.Mockito.times;
        when(scriptService.compile(any(), any())).thenReturn(new TestTemplateService.MockTemplateScript.Factory(compiledValue));
        OpenSearchParseException e = expectThrows(
        ex = expectThrows(
            unknownTaggedConfig.put("description", "my_description");
import static org.mockito.Mockito.any;
        Processor processor = new TestProcessor("tag", "type", testDescription, (ingestDocument) -> {});
        config.put("int", list);
    }
    public void testReadBooleanPropertyInvalidType() {
    @Before
        config3.add(Collections.singletonMap("null_processor", null));
    public void testReadStringProperty() {
    }
        assertThat(e2.getMetadata("opensearch.processor_type"), equalTo(Collections.singletonList("second_unknown_processor")));
    public void testReadStringOrIntPropertyInvalidType() {
 * SPDX-License-Identifier: Apache-2.0
            () -> ConfigurationUtils.readProcessorConfigs(config3, scriptService, registry)
        assertThat(processor1, sameInstance(processor));
        });
        processorConfig.put(ConfigurationUtils.DESCRIPTION_KEY, testDescription);
import static org.hamcrest.Matchers.sameInstance;
        Object inlineScript = "test_script";
        assertThat(e2.getMessage(), equalTo("No processor type exists with name [second_unknown_processor]"));
 * Licensed to Elasticsearch under one or more contributor
            return processor;
import static org.hamcrest.Matchers.is;
        String val2 = ConfigurationUtils.readStringOrIntProperty(null, null, config, "num", null);
        List<Processor> result = ConfigurationUtils.readProcessorConfigs(config, scriptService, registry);
        assertThat(result.get(0), sameInstance(processor));
            OpenSearchParseException.class,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(e.getMetadata("opensearch.property_name"), is(nullValue()));
 * The OpenSearch Contributors require contributions made to
        unknownTaggedConfig.put("tag", "my_unknown");
        );
    public void testReadNullBooleanProperty() {
    }
/*
        try {
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    private final ScriptService scriptService = mock(ScriptService.class);
    }
        Object emptyConfig = Collections.emptyMap();
        );
        fizz.put("buzz", "hello world");
        ScriptService scriptService = mock(ScriptService.class);
        );
/*
            propertyValue,
        when(scriptService.isLangSupported(anyString())).thenReturn(true);
        assertThat(result.newInstance(null).execute(), equalTo(propertyValue));
        when(scriptService.isLangSupported(anyString())).thenReturn(true);
        config.put("foo", "bar");
    }
            OpenSearchParseException.class,
            () -> ConfigurationUtils.readProcessorConfigs(config, scriptService, registry)
        Map<String, Object> secondUnknownTaggedConfig = new HashMap<>();
import java.util.Collections;
        Map<String, Object> processorConfig = new HashMap<>();
        assertEquals(ex.getMessage(), "the config of processor [null_processor] cannot be null");
 * GitHub history for details.
    }
 */
            OpenSearchParseException.class,
        Boolean val = ConfigurationUtils.readBooleanProperty(null, null, config, "boolVal", false);
            propertyValue,
        assertThat(e.getMetadata("opensearch.processor_description"), is(nullValue()));
            assertThat(description, equalTo(processor.getDescription()));
        Map<String, Object> emptyConfig = Collections.emptyMap();
            ConfigurationUtils.readBooleanProperty(null, null, config, "arr", true);
    }
            assertNull(description);
        config = new HashMap<>();
        assertThat(val, equalTo("bar"));
        assertThat(e.getSuppressed().length, equalTo(1));
 * license agreements. See the NOTICE file distributed with
 * under the License.
        List<Integer> list = new ArrayList<>();
        e = expectThrows(OpenSearchParseException.class, () -> ConfigurationUtils.readProcessorConfigs(config2, scriptService, registry));
        Map<String, Processor.Factory> registry = Collections.singletonMap("script", (processorFactories, tag, description, config) -> {
        assertThat(e.getMessage(), equalTo("No processor type exists with name [unknown_processor]"));
        }
        Map<String, Object> unknownTaggedConfig = new HashMap<>();
        Map<String, Object> emptyConfig = Collections.emptyMap();
        } catch (OpenSearchParseException e) {
        result = ConfigurationUtils.compileTemplate(
            randomAlphaOfLength(10),
import static org.mockito.Mockito.mock;
        unknownTaggedConfig = new HashMap<>();
        assertThat(e2.getMetadata("opensearch.property_name"), is(nullValue()));
        List<Map<String, Object>> config = new ArrayList<>();
        OpenSearchParseException e2 = (OpenSearchParseException) e.getSuppressed()[0];
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.script.ScriptService;
        String propertyValue = randomAlphaOfLength(10);
        assertThat(e.getMetadata("opensearch.processor_tag"), equalTo(Collections.singletonList("my_unknown")));
        assertThat(result.get(1), sameInstance(processor));
    public void testReadBooleanProperty() {
public class ConfigurationUtilsTests extends OpenSearchTestCase {
import java.util.Map;
import static org.hamcrest.Matchers.instanceOf;
            return processor;
    public void setConfig() {
 *
