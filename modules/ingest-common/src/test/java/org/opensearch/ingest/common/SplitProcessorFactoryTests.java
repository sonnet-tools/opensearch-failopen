/*
        config.put("separator", "\\.");  
 * specific language governing permissions and limitations
        SplitProcessor.Factory factory = new SplitProcessor.Factory();
        assertFalse(splitProcessor.isPreserveTrailing());
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testCreateWithPreserveTrailing() throws Exception {
    }
 */  
        config.put("field", "field1");
 * SPDX-License-Identifier: Apache-2.0
    public void testCreate() throws Exception {
        SplitProcessor.Factory factory = new SplitProcessor.Factory();
/*  
            factory.create(null, null, null, config);  
            factory.create(null, null, null, config);  
        } catch (OpenSearchParseException e) {
        assertThat(splitProcessor.getField(), equalTo("field1"));
        Map<String, Object> config = new HashMap<>();
    public void testCreateWithTargetField() throws Exception {
        assertThat(splitProcessor.getSeparator(), equalTo("\\."));
    }
        String processorTag = randomAlphaOfLength(10);
        assertFalse(splitProcessor.isIgnoreMissing());  
        SplitProcessor.Factory factory = new SplitProcessor.Factory();  
        config.put("field", "field1");
        Map<String, Object> config = new HashMap<>();
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(e.getMessage(), equalTo("[field] required property is missing"));  
    }
import java.util.Map;
        assertThat(splitProcessor.getTag(), equalTo(processorTag));  
import java.util.HashMap;
        SplitProcessor splitProcessor = factory.create(null, processorTag, null, config);
        assertThat(splitProcessor.getField(), equalTo("field1"));
        config.put("field", "field1");
        Map<String, Object> config = new HashMap<>();  
        } catch (OpenSearchParseException e) {
        String processorTag = randomAlphaOfLength(10);  
        }
        assertThat(splitProcessor.getSeparator(), equalTo("\\."));
        assertThat(splitProcessor.getTargetField(), equalTo("target"));  
 * software distributed under the License is distributed on an
        assertThat(splitProcessor.getTargetField(), equalTo("target"));
        try {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.OpenSearchParseException;
 *  
        assertThat(splitProcessor.getTag(), equalTo(processorTag));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(splitProcessor.getSeparator(), equalTo("\\."));
        Map<String, Object> config = new HashMap<>();  
 * KIND, either express or implied.  See the License for the
        SplitProcessor splitProcessor = factory.create(null, processorTag, null, config);
import static org.hamcrest.CoreMatchers.equalTo;
    }  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    public void testCreateNoFieldPresent() throws Exception {
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        try {
 * Licensed to Elasticsearch under one or more contributor  
        }
public class SplitProcessorFactoryTests extends OpenSearchTestCase {  
        config.put("preserve_trailing", true);
        SplitProcessor.Factory factory = new SplitProcessor.Factory();
 * this work for additional information regarding copyright
 * compatible open source license.
 */  
        config.put("separator", "\\.");
 * You may obtain a copy of the License at  
        assertThat(splitProcessor.getTag(), equalTo(processorTag));  
}  
        Map<String, Object> config = new HashMap<>();  
        SplitProcessor splitProcessor = factory.create(null, processorTag, null, config);
        config.put("target_field", "target");  
        config.put("target_field", "target");
            assertThat(e.getMessage(), equalTo("[separator] required property is missing"));  
        config.put("field", "field1");
        assertThat(splitProcessor.getTargetField(), equalTo("field1"));
    public void testCreateNoSeparatorPresent() throws Exception {
 *
 * GitHub history for details.
        String processorTag = randomAlphaOfLength(10);
/*  
 *
        assertThat(splitProcessor.getField(), equalTo("field1"));  
        assertFalse(splitProcessor.isIgnoreMissing());
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(splitProcessor.isIgnoreMissing());  
        config.put("separator", "\\.");
package org.opensearch.ingest.common;
            fail("factory create should have failed");
        SplitProcessor.Factory factory = new SplitProcessor.Factory();  
        config.put("separator", "\\.");  
            fail("factory create should have failed");
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 */
