            ConfigurationUtils.readBooleanProperty(null, null, config, "arr", true);
    }
        try {
    public void testReadStringProperty() {
        config.put("fizz", fizz);  
            return processor;
        Object emptyConfig = Collections.emptyMap();
            return processor;  
            assertThat(description, equalTo(processor.getDescription()));
        verify(scriptService, times(1)).compile(any(), any());
import static org.hamcrest.Matchers.instanceOf;  
import org.junit.Before;
        );
            unknownTaggedConfig.put("description", "my_description");
    public void testReadBooleanProperty() {
import static org.mockito.Mockito.times;
        config.put("int", list);
    public void testReadProcessorFromObjectOrMap() throws Exception {  
 * ownership. Elasticsearch licenses this file to you under  
            ConfigurationUtils.readStringOrIntProperty(null, null, config, "arr", null);
    }
        assertThat(result.size(), equalTo(2));  
        } catch (OpenSearchParseException e) {  
        config.put("null", null);
package org.opensearch.ingest;
        );
    }
        Map<String, Object> unknownTaggedConfig = new HashMap<>();
        processorConfig.put(ConfigurationUtils.DESCRIPTION_KEY, testDescription);
        assertThat(result.size(), equalTo(1));
        assertThat(result.get(0), sameInstance(processor));  
        String propertyValue = "{{" + randomAlphaOfLength(10) + "}}";
        Map<String, Object> fizz = new HashMap<>();
    public void testReadStringOrIntProperty() {
        );
        config = new HashMap<>();
        OpenSearchParseException e2 = (OpenSearchParseException) e.getSuppressed()[0];
        List<Map<String, Object>> config2 = new ArrayList<>();
            randomAlphaOfLength(10),
            propertyValue,  
        );
        assertThat(val, equalTo(false));  
        Processor processor = mock(Processor.class);
    public void testScriptShouldCompile() {
 * compatible open source license.
import java.util.List;
        assertThat(result.newInstance(null).execute(), equalTo(compiledValue));  
        unknownTaggedConfig = new HashMap<>();  
        OpenSearchParseException ex = expectThrows(
        assertThat(e2.getMetadata("opensearch.property_name"), is(nullValue()));  
        List<Processor> result = ConfigurationUtils.readProcessorConfigs(config, scriptService, registry);
import org.opensearch.test.OpenSearchTestCase;
        verify(scriptService, times(0)).compile(any(), any());
        Map<String, Processor.Factory> registry = Collections.singletonMap("test_processor", (factories, tag, description, config) -> {
        ScriptService scriptService = mock(ScriptService.class);
            randomAlphaOfLength(10),
        assertThat(e.getMessage(), equalTo("No processor type exists with name [unknown_processor]"));
        config.put("ip", "127.0.0.1");  
        assertThat(val, equalTo(true));
            OpenSearchParseException.class,  
import static org.hamcrest.Matchers.equalTo;
            "test_processor",
import org.opensearch.OpenSearchParseException;
        assertThat(val1, equalTo("bar"));
        }
        TemplateScript.Factory result;
        assertEquals(ex.getMessage(), "the config of processor [null_processor] cannot be null");
    }
        config.put("arr", Arrays.asList("1", "2", "3"));
        Map<String, Object> secondUnknownTaggedConfig = new HashMap<>();  
        Map<String, Object> emptyConfig = Collections.emptyMap();
 * GitHub history for details.
 * under the License.  
            assertNull(description);
import java.util.ArrayList;
        Processor processor = mock(Processor.class);  
    public void testReadProcessorNullDescription() throws Exception {
        Object invalidConfig = 12L;  
        assertThat(e2.getMetadata("opensearch.processor_type"), equalTo(Collections.singletonList("second_unknown_processor")));
        assertThat(val, equalTo("bar"));  
        try {
    public void testNoScriptCompilation() {  
        List<Map<String, Object>> config = new ArrayList<>();
    @Before
 * specific language governing permissions and limitations
        TemplateScript.Factory result;
    }
import static org.hamcrest.Matchers.nullValue;
        unknownTaggedConfig.put("tag", "my_unknown");
        assertThat(result.get(0), sameInstance(processor));
/*  
        config3.add(Collections.singletonMap("null_processor", null));
 *
        List<Integer> list = new ArrayList<>();  
            () -> ConfigurationUtils.readProcessor(registry, scriptService, "null_processor", null)
        Processor processor1 = ConfigurationUtils.readProcessor(registry, scriptService, "script", emptyConfig);
        String val1 = ConfigurationUtils.readStringOrIntProperty(null, null, config, "foo", null);  
        } catch (OpenSearchParseException e) {  
        assertThat(e2.getMessage(), equalTo("No processor type exists with name [second_unknown_processor]"));  
        try {
        assertThat(e.getMessage(), equalTo("No processor type exists with name [unknown_processor]"));
        }
        fizz.put("buzz", "hello world");
 * this work for additional information regarding copyright
        config.put("foo", "bar");
        e = expectThrows(OpenSearchParseException.class, () -> ConfigurationUtils.readProcessorConfigs(config2, scriptService, registry));  
        Processor processor2 = ConfigurationUtils.readProcessor(registry, scriptService, "script", inlineScript);  
        );
        when(scriptService.compile(any(), any())).thenReturn(new TestTemplateService.MockTemplateScript.Factory(compiledValue));  
    private final ScriptService scriptService = mock(ScriptService.class);
        unknownTaggedConfig.put("tag", "my_unknown");
    }
            ConfigurationUtils.readStringProperty(null, null, config, "arr");
            assertThat(e.getMessage(), equalTo("[arr] property isn't a string or int, but of type [java.util.Arrays$ArrayList]"));
            scriptService
            propertyValue,  
 * this file be licensed under the Apache-2.0 license or a
        ex = expectThrows(
        String val = ConfigurationUtils.readStringProperty(null, null, config, "foo");
import static org.hamcrest.Matchers.is;
        assertThat(processor2, sameInstance(processor));
        config2.add(Collections.singletonMap("second_unknown_processor", secondUnknownTaggedConfig));
    public void testReadStringOrIntPropertyInvalidType() {  
        });
            randomAlphaOfLength(10),
    public void testReadProcessorDescription() throws Exception {
        assertThat(e.getMetadata("opensearch.property_name"), is(nullValue()));
        );  
        when(scriptService.isLangSupported(anyString())).thenReturn(true);  
        when(scriptService.isLangSupported(anyString())).thenReturn(true);
            randomAlphaOfLength(10),
        List<Processor> result = ConfigurationUtils.readProcessorConfigs(config, scriptService, registry);
        if (randomBoolean()) {  
        result = ConfigurationUtils.compileTemplate(
 */
        Map<String, Object> processorConfig = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
 */  
        assertThat(e.getSuppressed().length, equalTo(1));  
        config.add(Collections.singletonMap("test_processor", emptyConfig));  
    public void testReadStringPropertyInvalidType() {  
 * KIND, either express or implied.  See the License for the
        Map<String, Object> emptyConfig = Collections.emptyMap();  
            assertThat(e.getMessage(), equalTo("[arr] property isn't a boolean, but of type [java.util.Arrays$ArrayList]"));
        config.add(Collections.singletonMap("test_processor", emptyConfig));
        result = ConfigurationUtils.compileTemplate(
        config2.add(Collections.singletonMap("unknown_processor", unknownTaggedConfig));
 *  
        });  
    }
 */  
        assertEquals(ex.getMessage(), "expect the config of processor [null_processor] to be map, but is null");  
        Map<String, Processor.Factory> registry = Collections.singletonMap(
import static org.mockito.Mockito.when;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * not use this file except in compliance with the License.
            () -> ConfigurationUtils.readProcessor(registry, scriptService, "unknown_processor", invalidConfig)
    private Map<String, Object> config;  
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
            () -> ConfigurationUtils.readProcessorConfigs(config3, scriptService, registry)
        assertThat(val2, equalTo("1"));  
        config.add(Collections.singletonMap("test_processor", processorConfig));  
            randomAlphaOfLength(10),  
            OpenSearchParseException.class,
        assertThat(e.getMetadata("opensearch.processor_type"), equalTo(Collections.singletonList("unknown_processor")));
        assertThat(e.getMetadata("opensearch.processor_tag"), equalTo(Collections.singletonList("my_unknown")));
 *
        String val2 = ConfigurationUtils.readStringOrIntProperty(null, null, config, "num", null);
        config.put("boolVal", true);  
/*
        assertThat(e.getSuppressed()[0], instanceOf(OpenSearchParseException.class));
        String propertyValue = randomAlphaOfLength(10);  
 * license agreements. See the NOTICE file distributed with
        String compiledValue = randomAlphaOfLength(10);
        List<Map<String, Object>> config = new ArrayList<>();  
        String testDescription = randomAlphaOfLengthBetween(10, 20);
        assertThat(result.size(), equalTo(1));  
        } catch (OpenSearchParseException e) {  
        assertThat(result.get(0), sameInstance(processor));
import static org.hamcrest.Matchers.sameInstance;  
        Map<String, Processor.Factory> registry = Collections.singletonMap("script", (processorFactories, tag, description, config) -> {
        Processor processor = new TestProcessor("tag", "type", testDescription, (ingestDocument) -> {});  
        OpenSearchParseException e = expectThrows(
        config.put("num", 1);
 * Modifications Copyright OpenSearch Contributors. See
/*  
        assertThat(e.getMetadata("opensearch.property_name"), is(nullValue()));
public class ConfigurationUtilsTests extends OpenSearchTestCase {
        Object inlineScript = "test_script";
import java.util.Collections;  
        );
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(processor1, sameInstance(processor));  
            return processor;
 * You may obtain a copy of the License at  
        assertThat(e.getMetadata("opensearch.processor_tag"), equalTo(Collections.singletonList("my_unknown")));  
        secondUnknownTaggedConfig.put("tag", "my_second_unknown");
        Boolean val = ConfigurationUtils.readBooleanProperty(null, null, config, "null", false);
        assertThat(e.getMetadata("opensearch.processor_description"), is(nullValue()));  
            () -> ConfigurationUtils.readProcessorConfigs(config, scriptService, registry)  
    public void testReadBooleanPropertyInvalidType() {  
    }  
            randomAlphaOfLength(10),  
    public void testReadProcessors() throws Exception {
        config.add(Collections.singletonMap("unknown_processor", unknownTaggedConfig));  
 * Licensed to Elasticsearch under one or more contributor  
        list.add(2);
    }
        assertThat(result.newInstance(null).execute(), equalTo(propertyValue));  
    }
import org.opensearch.script.ScriptService;
    }  
        ScriptService scriptService = mock(ScriptService.class);
import static org.mockito.Mockito.anyString;
}  
    public void testReadNullBooleanProperty() {
 * Unless required by applicable law or agreed to in writing,
        OpenSearchParseException ex = expectThrows(  
            assertThat(e.getMessage(), equalTo("[arr] property isn't a string, but of type [java.util.Arrays$ArrayList]"));
            scriptService
        Map<String, Processor.Factory> registry = Collections.singletonMap("test_processor", (factories, tag, description, config) -> {  
        });
        }
import static org.mockito.Mockito.mock;  
    public void setConfig() {  
            config.clear();  
        }
        Processor processor = new TestProcessor("tag", "type", null, (ingestDocument) -> {});
        Boolean val = ConfigurationUtils.readBooleanProperty(null, null, config, "boolVal", false);  
            OpenSearchParseException.class,  
        List<Processor> result = ConfigurationUtils.readProcessorConfigs(config, scriptService, registry);
            (factories, tag, description, config) -> processor  
import org.opensearch.script.TemplateScript;  
        List<Map<String, Object>> config = new ArrayList<>();  
        config.add(Collections.singletonMap("test_processor", emptyConfig));
import java.util.HashMap;
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    }
        List<Map<String, Object>> config3 = new ArrayList<>();  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        assertThat(e.getMetadata("opensearch.processor_type"), equalTo(Collections.singletonList("unknown_processor")));  
        assertThat(ex.getMessage(), equalTo("property isn't a map, but of type [" + invalidConfig.getClass().getName() + "]"));  
            OpenSearchParseException.class,
        assertThat(e2.getMetadata("opensearch.processor_tag"), equalTo(Collections.singletonList("my_second_unknown")));
        // test null config
import java.util.Map;  
        assertThat(result.get(1), sameInstance(processor));
