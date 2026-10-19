        ConvertProcessor.Factory factory = new ConvertProcessor.Factory();  
 * Licensed to Elasticsearch under one or more contributor  
            fail("factory create should have failed");
        Map<String, Object> config = new HashMap<>();  
        assertThat(convertProcessor.getTag(), equalTo(processorTag));
        ConvertProcessor.Type type = randomFrom(ConvertProcessor.Type.values());  
 *  
        Map<String, Object> config = new HashMap<>();
        assertThat(convertProcessor.getTargetField(), equalTo("field1"));
        Map<String, Object> config = new HashMap<>();
        }
/*  
        } catch (OpenSearchParseException e) {
        config.put("field", "field1");  
            factory.create(null, null, null, config);
import org.opensearch.test.OpenSearchTestCase;
        ConvertProcessor convertProcessor = factory.create(null, processorTag, null, config);  
 * You may obtain a copy of the License at  
    }
        config.put("type", type);
        config.put("field", "field1");
            assertThat(e.getMessage(), Matchers.equalTo("[type] required property is missing"));
    public void testCreateNoTypePresent() throws Exception {
        ConvertProcessor convertProcessor = factory.create(null, processorTag, null, config);
        assertThat(convertProcessor.getConvertType(), equalTo(type));
 * not use this file except in compliance with the License.
        assertThat(convertProcessor.getTag(), equalTo(processorTag));  
 * the Apache License, Version 2.0 (the "License"); you may
        try {
            assertThat(e.getMetadata("opensearch.processor_type").get(0), equalTo(ConvertProcessor.TYPE));
 * The OpenSearch Contributors require contributions made to  
        assertThat(convertProcessor.getTargetField(), equalTo("field1"));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ConvertProcessor.Factory factory = new ConvertProcessor.Factory();
    public void testCreateNoFieldPresent() throws Exception {
 * KIND, either express or implied.  See the License for the
        try {  
        assertThat(convertProcessor.getTag(), equalTo(processorTag));
        }
 * this work for additional information regarding copyright
            assertThat(e.getMetadata("opensearch.processor_tag"), nullValue());  
        Map<String, Object> config = new HashMap<>();
 *
 * Unless required by applicable law or agreed to in writing,
 */  
 * this file be licensed under the Apache-2.0 license or a
    }  
        } catch (OpenSearchParseException e) {  
import java.util.Map;  
        config.put("type", type.toString());
        assertThat(convertProcessor.getConvertType(), equalTo(type));  
        try {  
        config.put("field", "field1");  
/*
    }
        String processorTag = randomAlphaOfLength(10);
        ConvertProcessor.Factory factory = new ConvertProcessor.Factory();  
import org.opensearch.OpenSearchParseException;
import static org.hamcrest.CoreMatchers.equalTo;
        assertThat(convertProcessor.isIgnoreMissing(), is(false));
        String type = "type-" + randomAlphaOfLengthBetween(1, 10);
            factory.create(null, null, null, config);
        assertThat(convertProcessor.getField(), equalTo("field1"));
        String processorTag = randomAlphaOfLength(10);
public class ConvertProcessorFactoryTests extends OpenSearchTestCase {  
        ConvertProcessor.Factory factory = new ConvertProcessor.Factory();  
 * GitHub history for details.
    }  
    public void testCreate() throws Exception {
import org.hamcrest.Matchers;  
    public void testCreateWithExplicitTargetField() throws Exception {
        ConvertProcessor.Factory factory = new ConvertProcessor.Factory();
        config.put("type", type.toString());
        assertThat(convertProcessor.isIgnoreMissing(), is(true));
            assertThat(e.getMessage(), Matchers.equalTo("[type] type [" + type + "] not supported, cannot convert field."));  
package org.opensearch.ingest.common;
        assertThat(convertProcessor.getConvertType(), equalTo(type));
            fail("factory create should have failed");
        config.put("ignore_missing", true);  
/*  
 * software distributed under the License is distributed on an
        Map<String, Object> config = new HashMap<>();
 */  
        assertThat(convertProcessor.getField(), equalTo("field1"));
 *
import static org.hamcrest.Matchers.nullValue;
            assertThat(e.getMetadata("opensearch.property_name").get(0), equalTo("type"));
 * specific language governing permissions and limitations
        ConvertProcessor.Type type = randomFrom(ConvertProcessor.Type.values());
        Map<String, Object> config = new HashMap<>();
        config.put("target_field", "field2");
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        config.put("type", type.toString());
 * under the License.  
            assertThat(e.getMessage(), Matchers.equalTo("[field] required property is missing"));
    public void testCreateUnsupportedType() throws Exception {
        } catch (OpenSearchParseException e) {  
        config.put("type", type);
        ConvertProcessor convertProcessor = factory.create(null, processorTag, null, config);
            fail("factory create should have failed");
        }
        assertThat(convertProcessor.getField(), equalTo("field1"));  
        String type = "type-" + randomAlphaOfLengthBetween(1, 10);
        ConvertProcessor.Factory factory = new ConvertProcessor.Factory();  
        assertThat(convertProcessor.getTargetField(), equalTo("field2"));
        assertThat(convertProcessor.isIgnoreMissing(), is(false));  
    public void testCreateWithIgnoreMissing() throws Exception {  
}  
        config.put("field", "field1");  
        String processorTag = randomAlphaOfLength(10);  
 */
 * ownership. Elasticsearch licenses this file to you under  
            factory.create(null, null, null, config);  
        config.put("field", "field1");
        ConvertProcessor.Type type = randomFrom(ConvertProcessor.Type.values());
 * license agreements. See the NOTICE file distributed with
import java.util.HashMap;
    }  
import static org.hamcrest.Matchers.is;  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
