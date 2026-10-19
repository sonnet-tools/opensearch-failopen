        assertThat(exception.getMessage(), equalTo("[value_split] required property is missing"));  
        assertThat(exception.getMessage(), equalTo("[field_split] required property is missing"));  
import org.opensearch.test.OpenSearchTestCase;
        assertThat(processor.getField().newInstance(Collections.emptyMap()).execute(), equalTo("field1"));
        Map<String, Object> config = new HashMap<>();
 * not use this file except in compliance with the License.
public class KeyValueProcessorFactoryTests extends OpenSearchTestCase {
import static org.hamcrest.CoreMatchers.equalTo;
/*  
        assertThat(processor.getValueSplit(), equalTo("="));
import java.util.Arrays;
 *  
 * license agreements. See the NOTICE file distributed with
        String processorTag = randomAlphaOfLength(10);  
        config.put("include_keys", Arrays.asList("a", "b"));  
        assertThat(processor.getTargetField(), is(nullValue()));
    }
 */
        assertThat(processor.getExcludeKeys(), equalTo(Collections.emptySet()));
 */  
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getFieldSplit(), equalTo("&"));
        assertThat(exception.getMessage(), equalTo("[field] required property is missing"));
    }
        String processorTag = randomAlphaOfLength(10);
        config.put("field_split", "&");
        assertFalse(processor.isIgnoreMissing());  
/*
import java.util.Collections;  
        KeyValueProcessor processor = factory.create(null, processorTag, null, config);
        assertThat(processor.getField().newInstance(Collections.emptyMap()).execute(), equalTo("field1"));  
        config.put("field", "field1");  
            OpenSearchParseException.class,
    private KeyValueProcessor.Factory factory;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testCreateWithMissingValueSplit() {  
import org.opensearch.OpenSearchException;
        config.put("field_split", "&");  
        config.put("field_split", "&");  
    public void testCreateWithMissingField() {  
package org.opensearch.ingest.common;
        OpenSearchException exception = expectThrows(
import org.opensearch.ingest.TestTemplateService;
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
        config.put("exclude_keys", Collections.emptyList());
    public void testCreateWithAllFieldsSet() throws Exception {  
 * GitHub history for details.
            () -> factory.create(null, processorTag, null, config)
/*  
        assertThat(processor.getTag(), equalTo(processorTag));  
        Map<String, Object> config = new HashMap<>();  
    }
import org.opensearch.OpenSearchParseException;
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.nullValue;  
 * KIND, either express or implied.  See the License for the
 */  
            OpenSearchParseException.class,  
    public void testCreateWithMissingFieldSplit() {
 * The OpenSearch Contributors require contributions made to  
        assertThat(processor.getFieldSplit(), equalTo("&"));
 * this file be licensed under the Apache-2.0 license or a
        String processorTag = randomAlphaOfLength(10);
        );
        assertTrue(processor.isIgnoreMissing());  
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        String processorTag = randomAlphaOfLength(10);
        Map<String, Object> config = new HashMap<>();
        Map<String, Object> config = new HashMap<>();
import static org.hamcrest.Matchers.is;
 *
        assertThat(processor.getTargetField().newInstance(Collections.emptyMap()).execute(), equalTo("target"));
    }
        assertThat(processor.getValueSplit(), equalTo("="));  
        factory = new KeyValueProcessor.Factory(TestTemplateService.instance());
        OpenSearchException exception = expectThrows(  
        config.put("ignore_missing", true);
 * Licensed to Elasticsearch under one or more contributor  
        config.put("value_split", "=");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        );
 * You may obtain a copy of the License at  
    @Before  
import java.util.Map;
    public void testCreateWithDefaults() throws Exception {
        config.put("field", "field1");
    }  
        config.put("target_field", "target");
        String processorTag = randomAlphaOfLength(10);
    public void init() {
        config.put("field", "field1");
import org.opensearch.common.util.set.Sets;  
 * under the License.  
import org.junit.Before;  
 * Modifications Copyright OpenSearch Contributors. See
}
 * this work for additional information regarding copyright
        KeyValueProcessor processor = factory.create(null, processorTag, null, config);
        assertThat(processor.getTag(), equalTo(processorTag));
        config.put("field", "field1");
        config.put("value_split", "=");
        OpenSearchException exception = expectThrows(
 * software distributed under the License is distributed on an
            () -> factory.create(null, processorTag, null, config)
        assertThat(processor.getIncludeKeys(), equalTo(Sets.newHashSet("a", "b")));  
        assertThat(processor.getIncludeKeys(), is(nullValue()));
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
import java.util.HashMap;
    }
            OpenSearchParseException.class,  
            () -> factory.create(null, processorTag, null, config)
