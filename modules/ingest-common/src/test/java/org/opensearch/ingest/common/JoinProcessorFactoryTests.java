        JoinProcessor.Factory factory = new JoinProcessor.Factory();
 * Unless required by applicable law or agreed to in writing,
            fail("factory create should have failed");  
        config.put("separator", "-");  
 * specific language governing permissions and limitations
        }  
    }
 *
        try {
    }  
        config.put("target_field", "target");
        assertThat(joinProcessor.getSeparator(), equalTo("-"));
        JoinProcessor.Factory factory = new JoinProcessor.Factory();  
        Map<String, Object> config = new HashMap<>();
 */  
 * this work for additional information regarding copyright
            assertThat(e.getMessage(), equalTo("[separator] required property is missing"));
        config.put("field", "field1");  
 * SPDX-License-Identifier: Apache-2.0
            fail("factory create should have failed");  
    }
/*  
 * under the License.  
        assertThat(joinProcessor.getTag(), equalTo(processorTag));
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
import static org.hamcrest.CoreMatchers.equalTo;
    public void testCreateWithTargetField() throws Exception {  
            assertThat(e.getMessage(), equalTo("[field] required property is missing"));
        config.put("field", "field1");
}
package org.opensearch.ingest.common;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.OpenSearchParseException;
        try {
        JoinProcessor joinProcessor = factory.create(null, processorTag, null, config);
 * license agreements. See the NOTICE file distributed with
        assertThat(joinProcessor.getSeparator(), equalTo("-"));
            factory.create(null, null, null, config);
            factory.create(null, null, null, config);
 *  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testCreateNoSeparatorPresent() throws Exception {  
        }  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
        JoinProcessor.Factory factory = new JoinProcessor.Factory();
import java.util.HashMap;
        JoinProcessor joinProcessor = factory.create(null, processorTag, null, config);
 *
        config.put("separator", "-");
        assertThat(joinProcessor.getTargetField(), equalTo("target"));
        assertThat(joinProcessor.getTargetField(), equalTo("field1"));  
        } catch (OpenSearchParseException e) {
 */  
        String processorTag = randomAlphaOfLength(10);
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    }
/*
import org.opensearch.test.OpenSearchTestCase;
        Map<String, Object> config = new HashMap<>();
        Map<String, Object> config = new HashMap<>();
        assertThat(joinProcessor.getField(), equalTo("field1"));
    public void testCreate() throws Exception {
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        config.put("field", "field1");  
 */
        JoinProcessor.Factory factory = new JoinProcessor.Factory();
        String processorTag = randomAlphaOfLength(10);  
public class JoinProcessorFactoryTests extends OpenSearchTestCase {  
        assertThat(joinProcessor.getTag(), equalTo(processorTag));  
 * You may obtain a copy of the License at  
        Map<String, Object> config = new HashMap<>();
        } catch (OpenSearchParseException e) {
        assertThat(joinProcessor.getField(), equalTo("field1"));  
    public void testCreateNoFieldPresent() throws Exception {  
 * ownership. Elasticsearch licenses this file to you under  
        config.put("separator", "-");  
 * this file be licensed under the Apache-2.0 license or a
