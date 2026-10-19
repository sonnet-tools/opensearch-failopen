        String processorTag = randomAlphaOfLength(10);
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<String, Object> config = new HashMap<>();  
            factory.create(null, null, null, config);
        if (randomBoolean()) {  
 * The OpenSearch Contributors require contributions made to  
        Map<String, Object> config = new HashMap<>();
        } catch (OpenSearchParseException e) {
    }  
package org.opensearch.ingest.common;
        config.put("value", value);
        AppendProcessor appendProcessor = factory.create(null, processorTag, null, config);
    }
public class AppendProcessorFactoryTests extends OpenSearchTestCase {
        Map<String, Object> config = new HashMap<>();  
            fail("factory create should have failed");  
        factory = new AppendProcessor.Factory(TestTemplateService.instance());
 */  
        }
            value = "value1";
        assertThat(appendProcessor.getValue().copyAndResolve(Collections.emptyMap()), equalTo(value));
        assertThat(appendProcessor.getTag(), equalTo(processorTag));
 * software distributed under the License is distributed on an
import static org.hamcrest.CoreMatchers.equalTo;  
        } catch (OpenSearchParseException e) {  
 *
 * the Apache License, Version 2.0 (the "License"); you may
            factory.create(null, null, null, config);
        OpenSearchException exception = expectThrows(OpenSearchException.class, () -> factory.create(null, processorTag, null, config));
 *    http://www.apache.org/licenses/LICENSE-2.0
        config.put("field", "field1");
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.OpenSearchParseException;
    private AppendProcessor.Factory factory;
 */
            fail("factory create should have failed");
        config.put("field", "field1");
import java.util.Map;
import org.opensearch.ingest.TestTemplateService;  
import java.util.Collections;
import java.util.Arrays;
        try {  
        assertThat(exception.getMessage(), equalTo("java.lang.RuntimeException: could not compile script"));  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
        config.put("value", null);
        String processorTag = randomAlphaOfLength(10);  
 * ownership. Elasticsearch licenses this file to you under  
            value = Arrays.asList("value1", "value2", "value3");  
            assertThat(e.getMessage(), equalTo("[value] required property is missing"));
 * Modifications Copyright OpenSearch Contributors. See
    public void init() {
        config.put("value", "value1");  
 *  
 * under the License.  
            factory.create(null, null, null, config);
 * compatible open source license.
 * You may obtain a copy of the License at  
            assertThat(e.getMessage(), equalTo("[value] required property is missing"));
        assertThat(appendProcessor.getField().newInstance(Collections.emptyMap()).execute(), equalTo("field1"));  
    }  
        assertThat(exception.getMetadata("opensearch.processor_tag").get(0), equalTo(processorTag));
/*  
            assertThat(e.getMessage(), equalTo("[field] required property is missing"));
        try {
    @Before  
import java.util.HashMap;  
        try {  
import org.junit.Before;
 */  
    public void testCreateNullValue() throws Exception {
 * GitHub history for details.
        config.put("value", "value1");  
        }
        } catch (OpenSearchParseException e) {  
 * license agreements. See the NOTICE file distributed with
    public void testCreate() throws Exception {
 * Unless required by applicable law or agreed to in writing,
    public void testInvalidMustacheTemplate() throws Exception {
 *
        AppendProcessor.Factory factory = new AppendProcessor.Factory(TestTemplateService.instance(true));  
    public void testCreateNoValuePresent() throws Exception {  
    }
        Map<String, Object> config = new HashMap<>();
        Object value;
 * not use this file except in compliance with the License.
            fail("factory create should have failed");
        Map<String, Object> config = new HashMap<>();
    }
 * this work for additional information regarding copyright
import org.opensearch.OpenSearchException;
    }  
 * this file be licensed under the Apache-2.0 license or a
        }  
    public void testCreateNoFieldPresent() throws Exception {
        } else {
        config.put("field", "field1");
}  
/*
        config.put("field", "{{field1}}");
        }
/*  
 * SPDX-License-Identifier: Apache-2.0
