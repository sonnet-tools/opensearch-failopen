    }
/*
    public void testCreateWithMissingField() throws Exception {
        assertThat(exception.getMessage(), equalTo("[processor] Must specify exactly one processor type"));
        Map<String, Object> config = new HashMap<>();  
 * under the License.  
        ForEachProcessor forEachProcessor = forEachFactory.create(registry, null, null, config);  
        config.put("field", "_field");
        processorTypes.put("_second", Collections.emptyMap());
 * the Apache License, Version 2.0 (the "License"); you may
        ForEachProcessor.Factory forEachFactory = new ForEachProcessor.Factory(scriptService);  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
    public void testCreateWithMissingProcessor() {
    }
/*  
import java.util.HashMap;  
import org.opensearch.ingest.Processor;
import org.opensearch.ingest.TestProcessor;  
import java.util.Collections;
 * Licensed to Elasticsearch under one or more contributor  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
        Map<String, Object> config = new HashMap<>();  
    }  
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(forEachProcessor.isIgnoreMissing());
        config.put("processor", Collections.singletonList(Collections.singletonMap("_name", Collections.emptyMap())));
        Map<String, Object> processorTypes = new HashMap<>();  
        Map<String, Processor.Factory> registry = new HashMap<>();
        assertThat(forEachProcessor.getInnerProcessor(), Matchers.sameInstance(processor));
 *
        config.put("field", "_field");
    private final ScriptService scriptService = mock(ScriptService.class);  
        Map<String, Object> config = new HashMap<>();
        Processor processor = new TestProcessor(ingestDocument -> {});
package org.opensearch.ingest.common;
 * Modifications Copyright OpenSearch Contributors. See
        registry.put("_name", (r, t, description, c) -> processor);  
        ForEachProcessor.Factory forEachFactory = new ForEachProcessor.Factory(scriptService);
            () -> forEachFactory.create(Collections.emptyMap(), null, null, config)  
        Exception exception = expectThrows(Exception.class, () -> forEachFactory.create(registry, null, null, config));  
        ForEachProcessor.Factory forEachFactory = new ForEachProcessor.Factory(scriptService);  
        );
/*  
 * software distributed under the License is distributed on an
        ForEachProcessor.Factory forEachFactory = new ForEachProcessor.Factory(scriptService);
 * Unless required by applicable law or agreed to in writing,
        assertThat(forEachProcessor.getField(), equalTo("_field"));
 * compatible open source license.
        config.put("processor", Collections.singletonMap("_name", Collections.emptyMap()));  
        assertThat(expectedException.getMessage(), equalTo("No processor type exists with name [_name]"));
        registry.put("_second", (r, t, description, c) -> processor);
    public void testCreateWithNonExistingProcessorType() throws Exception {
 * specific language governing permissions and limitations
        assertThat(forEachProcessor, Matchers.notNullValue());  
        ForEachProcessor.Factory forEachFactory = new ForEachProcessor.Factory(scriptService);
        config.put("processor", Collections.singletonMap("_name", Collections.emptyMap()));  
            OpenSearchParseException.class,
        Map<String, Object> config = new HashMap<>();
 */  
 *  
    private final Consumer<Runnable> genericExecutor = Runnable::run;
    }
        Exception exception = expectThrows(Exception.class, () -> forEachFactory.create(Collections.emptyMap(), null, null, config));
        Map<String, Object> config = new HashMap<>();
import java.util.function.Consumer;
        Processor processor = new TestProcessor(ingestDocument -> {});  
}  
        Processor processor = new TestProcessor(ingestDocument -> {});
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
        config.put("field", "_field");
        Map<String, Processor.Factory> registry = new HashMap<>();
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
        Exception expectedException = expectThrows(
        assertThat(exception.getMessage(), equalTo("[field] required property is missing"));
import static org.hamcrest.Matchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
        registry.put("_name", (r, t, description, c) -> processor);
import org.hamcrest.Matchers;  
        ForEachProcessor.Factory forEachFactory = new ForEachProcessor.Factory(scriptService);
        config.put("processor", processorTypes);  
 * ownership. Elasticsearch licenses this file to you under  
        config.put("ignore_missing", true);
import static org.mockito.Mockito.mock;
        Processor processor = new TestProcessor(ingestDocument -> {});
        assertTrue(forEachProcessor.isIgnoreMissing());  
    public void testCreateWithTooManyProcessorTypes() throws Exception {  
        processorTypes.put("_first", Collections.emptyMap());
        config.put("field", "_field");
import org.opensearch.script.ScriptService;
import org.opensearch.OpenSearchParseException;
        assertThat(forEachProcessor.getField(), equalTo("_field"));
 * license agreements. See the NOTICE file distributed with
        Map<String, Processor.Factory> registry = new HashMap<>();
        Map<String, Object> config = new HashMap<>();
        Exception exception = expectThrows(OpenSearchParseException.class, () -> forEachFactory.create(registry, null, null, config));
        assertThat(forEachProcessor, Matchers.notNullValue());
public class ForEachProcessorFactoryTests extends OpenSearchTestCase {
    public void testCreate() throws Exception {  
    }  
        registry.put("_first", (r, t, description, c) -> processor);  
        config.put("processor", Collections.singletonMap("_name", Collections.emptyMap()));
        assertThat(forEachProcessor.getInnerProcessor(), Matchers.sameInstance(processor));  
        config.put("field", "_field");
        Map<String, Processor.Factory> registry = new HashMap<>();  
        ForEachProcessor forEachProcessor = forEachFactory.create(registry, null, null, config);
 */  
    public void testSetIgnoreMissing() throws Exception {
        assertThat(exception.getMessage(), equalTo("[processor] required property is missing"));  
    }
import org.opensearch.test.OpenSearchTestCase;
        registry.put("_name", (r, t, description, c) -> processor);
 */
