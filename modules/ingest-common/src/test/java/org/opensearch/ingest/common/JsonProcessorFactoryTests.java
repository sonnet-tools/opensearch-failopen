 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        OpenSearchException exception = expectThrows(  
        String randomField = randomAlphaOfLength(10);  
 * under the License.  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
    private static final JsonProcessor.Factory FACTORY = new JsonProcessor.Factory();  
        config.put("field", randomField);
    public void testCreateWithMissingField() throws Exception {  
    }
 *  
            OpenSearchParseException.class,
        assertThat(jsonProcessor.getTargetField(), equalTo(randomTargetField));  
        assertThat(exception.getMessage(), equalTo("[target_field] Cannot set a target field while also setting `add_to_root` to true"));  
/*  
        Map<String, Object> config = new HashMap<>();  
 * software distributed under the License is distributed on an
        Map<String, Object> config = new HashMap<>();  
 * Licensed to Elasticsearch under one or more contributor  
        String randomField = randomAlphaOfLength(10);
 * compatible open source license.
        String processorTag = randomAlphaOfLength(10);
        Map<String, Object> config = new HashMap<>();
 * the Apache License, Version 2.0 (the "License"); you may
        config.put("target_field", randomTargetField);  
        );  
}
        assertThat(jsonProcessor.getTargetField(), equalTo(randomField));  
        String processorTag = randomAlphaOfLength(10);  
import static org.hamcrest.CoreMatchers.equalTo;
        assertThat(jsonProcessor.getTag(), equalTo(processorTag));
        String processorTag = randomAlphaOfLength(10);
    }
 */
    public void testCreateWithDefaultTarget() throws Exception {
        String processorTag = randomAlphaOfLength(10);
        assertThat(jsonProcessor.getTag(), equalTo(processorTag));
        assertThat(jsonProcessor.getField(), equalTo(randomField));
        );
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(jsonProcessor.getTag(), equalTo(processorTag));
    public void testCreateWithAddToRoot() throws Exception {  
        assertThat(jsonProcessor.getTargetField(), equalTo(randomField));  
        config.put("field", randomField);
 * GitHub history for details.
            () -> FACTORY.create(null, processorTag, null, config)
        assertTrue(jsonProcessor.isAddToRoot());
        JsonProcessor jsonProcessor = FACTORY.create(null, processorTag, null, config);  
    public void testCreateWithBothTargetFieldAndAddToRoot() throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
 *
 */  
        config.put("field", randomField);
    public void testCreate() throws Exception {
import org.opensearch.test.OpenSearchTestCase;  
 * not use this file except in compliance with the License.
        assertThat(exception.getMessage(), equalTo("[field] required property is missing"));
import org.opensearch.OpenSearchParseException;
    }
        Map<String, Object> config = new HashMap<>();
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
            OpenSearchParseException.class,  
/*  
        assertThat(jsonProcessor.getField(), equalTo(randomField));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        config.put("add_to_root", true);
        String randomTargetField = randomAlphaOfLength(5);  
import org.opensearch.OpenSearchException;
package org.opensearch.ingest.common;
        config.put("field", randomField);
    }
public class JsonProcessorFactoryTests extends OpenSearchTestCase {
/*
        String randomTargetField = randomAlphaOfLength(5);
    }
        Map<String, Object> config = new HashMap<>();
        String randomField = randomAlphaOfLength(10);
 * Unless required by applicable law or agreed to in writing,
        JsonProcessor jsonProcessor = FACTORY.create(null, processorTag, null, config);  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 *
        String randomField = randomAlphaOfLength(10);
        JsonProcessor jsonProcessor = FACTORY.create(null, processorTag, null, config);  
        config.put("add_to_root", true);
        config.put("target_field", randomTargetField);
            () -> FACTORY.create(null, randomAlphaOfLength(10), null, config)
import java.util.Map;  
        assertThat(jsonProcessor.getField(), equalTo(randomField));
        OpenSearchException exception = expectThrows(
import java.util.HashMap;
