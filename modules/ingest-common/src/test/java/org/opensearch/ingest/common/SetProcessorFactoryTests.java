        factory = new SetProcessor.Factory(TestTemplateService.instance());
            fail("factory create should have failed");
        OpenSearchException exception = expectThrows(OpenSearchException.class, () -> factory.create(null, processorTag, null, config));
 *
        }
 */  
        config.put("value", null);
 * not use this file except in compliance with the License.
        try {
 *
import java.util.HashMap;
 * compatible open source license.
        SetProcessor setProcessor = factory.create(null, processorTag, null, config);
        assertThat(setProcessor.getField().newInstance(Collections.emptyMap()).execute(), equalTo("field1"));
        Map<String, Object> config = new HashMap<>();  
    public void testCreate() throws Exception {
        config.put("value", "value1");
/*
        String processorTag = randomAlphaOfLength(10);
            fail("factory create should have failed");
        config.put("field", "field1");  
 * Licensed to Elasticsearch under one or more contributor  
        String processorTag = randomAlphaOfLength(10);  
 * software distributed under the License is distributed on an
        config.put("field", "{{field1}}");
 * The OpenSearch Contributors require contributions made to  
        Map<String, Object> config = new HashMap<>();  
        } catch (OpenSearchParseException e) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(setProcessor.getValue().copyAndResolve(Collections.emptyMap()), equalTo("value1"));  
        } catch (OpenSearchParseException e) {
    }  
        assertThat(setProcessor.getTag(), equalTo(processorTag));
        config.put("override", overrideEnabled);  
        Map<String, Object> config = new HashMap<>();
        config.put("value", "value1");
import java.util.Collections;
            factory.create(null, null, null, config);  
    public void testCreateNoFieldPresent() throws Exception {  
    public void testCreateWithOverride() throws Exception {
 * license agreements. See the NOTICE file distributed with
        boolean overrideEnabled = randomBoolean();
        Map<String, Object> config = new HashMap<>();
        try {
import java.util.Map;  
        assertThat(exception.getMessage(), equalTo("java.lang.RuntimeException: could not compile script"));
            assertThat(e.getMessage(), equalTo("[field] required property is missing"));
            factory.create(null, null, null, config);  
        Map<String, Object> config = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
        config.put("field", "field1");
    }
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
    public void init() {  
    @Before
        assertThat(setProcessor.isOverrideEnabled(), equalTo(overrideEnabled));  
import org.opensearch.ingest.TestTemplateService;  
            assertThat(e.getMessage(), equalTo("[value] required property is missing"));  
        try {  
/*  
import org.opensearch.OpenSearchParseException;
        }
import org.opensearch.test.OpenSearchTestCase;
    }
        assertThat(setProcessor.getField().newInstance(Collections.emptyMap()).execute(), equalTo("field1"));
        config.put("field", "field1");
    }
            factory.create(null, null, null, config);
    private SetProcessor.Factory factory;  
        assertThat(setProcessor.isOverrideEnabled(), equalTo(true));
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, Object> config = new HashMap<>();  
    }
 * GitHub history for details.
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.junit.Before;
            fail("factory create should have failed");
        } catch (OpenSearchParseException e) {  
        String processorTag = randomAlphaOfLength(10);
 */
        SetProcessor.Factory factory = new SetProcessor.Factory(TestTemplateService.instance(true));
 * You may obtain a copy of the License at  
        assertThat(exception.getMetadata("opensearch.processor_tag").get(0), equalTo(processorTag));  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
}  
        SetProcessor setProcessor = factory.create(null, processorTag, null, config);  
        }
 * Unless required by applicable law or agreed to in writing,
        config.put("field", "field1");  
    public void testCreateNoValuePresent() throws Exception {
        assertThat(setProcessor.getValue().copyAndResolve(Collections.emptyMap()), equalTo("value1"));
        config.put("value", "value1");
 *  
            assertThat(e.getMessage(), equalTo("[value] required property is missing"));  
    public void testCreateNullValue() throws Exception {
    public void testInvalidMustacheTemplate() throws Exception {
import static org.hamcrest.CoreMatchers.equalTo;
 * KIND, either express or implied.  See the License for the
        assertThat(setProcessor.getTag(), equalTo(processorTag));  
 * the Apache License, Version 2.0 (the "License"); you may
public class SetProcessorFactoryTests extends OpenSearchTestCase {
import org.opensearch.OpenSearchException;
/*  
        config.put("value", "value1");
package org.opensearch.ingest.common;
