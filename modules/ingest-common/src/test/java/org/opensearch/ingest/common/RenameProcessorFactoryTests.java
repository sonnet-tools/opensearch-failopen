 * Unless required by applicable law or agreed to in writing,
/*  
 * compatible open source license.
    @Before
import java.util.HashMap;
 * license agreements. See the NOTICE file distributed with
        Map<String, Object> config = new HashMap<>();
        assertThat(renameProcessor.isIgnoreMissing(), equalTo(false));  
        } catch (OpenSearchParseException e) {
    private RenameProcessor.Factory factory;
        assertThat(renameProcessor.getTargetField().newInstance(Collections.emptyMap()).execute(), equalTo("new_field"));
    }  
        Map<String, Object> config = new HashMap<>();  
 * under the License.  
/*
        try {
 * Modifications Copyright OpenSearch Contributors. See
        }  
        Map<String, Object> config = new HashMap<>();
    }
    public void testCreateNoFieldPresent() throws Exception {
        assertThat(renameProcessor.isOverrideTarget(), equalTo(true));
 * You may obtain a copy of the License at  
        }
 * ownership. Elasticsearch licenses this file to you under  
public class RenameProcessorFactoryTests extends OpenSearchTestCase {  
        assertThat(renameProcessor.getField().newInstance(Collections.emptyMap()).execute(), equalTo("old_field"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(renameProcessor.getTargetField().newInstance(Collections.emptyMap()).execute(), equalTo("new_field"));  
 * this work for additional information regarding copyright
        RenameProcessor renameProcessor = factory.create(null, processorTag, null, config);  
        config.put("target_field", "new_field");  
            factory.create(null, null, null, config);  
        String processorTag = randomAlphaOfLength(10);
 * Licensed to Elasticsearch under one or more contributor  
    public void testCreateWithIgnoreMissing() throws Exception {  
    }
        RenameProcessor renameProcessor = factory.create(null, processorTag, null, config);
        String processorTag = randomAlphaOfLength(10);  
    public void testCreate() throws Exception {  
 *  
        assertThat(renameProcessor.getField().newInstance(Collections.emptyMap()).execute(), equalTo("old_field"));
import static org.hamcrest.CoreMatchers.equalTo;
        config.put("field", "old_field");
 * this file be licensed under the Apache-2.0 license or a
        assertThat(renameProcessor.getTargetField().newInstance(Collections.emptyMap()).execute(), equalTo("new_field"));
        try {
import org.opensearch.test.OpenSearchTestCase;  
 * specific language governing permissions and limitations
        config.put("target_field", "new_field");  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * software distributed under the License is distributed on an
import java.util.Map;
    public void testCreateWithOverrideTarget() throws Exception {
        RenameProcessor renameProcessor = factory.create(null, processorTag, null, config);
import org.junit.Before;
 */
        assertThat(renameProcessor.isIgnoreMissing(), equalTo(true));
 * KIND, either express or implied.  See the License for the
        config.put("target_field", "new_field");
import org.opensearch.ingest.TestTemplateService;
        String processorTag = randomAlphaOfLength(10);
        assertThat(renameProcessor.getTag(), equalTo(processorTag));
 *
        config.put("field", "old_field");  
import org.opensearch.OpenSearchParseException;
        config.put("ignore_missing", true);
        config.put("field", "old_field");  
        } catch (OpenSearchParseException e) {
        assertThat(renameProcessor.getTag(), equalTo(processorTag));
        Map<String, Object> config = new HashMap<>();
package org.opensearch.ingest.common;
            fail("factory create should have failed");  
            factory.create(null, null, null, config);
    }
        config.put("field", "old_field");
import java.util.Collections;  
        Map<String, Object> config = new HashMap<>();
 * GitHub history for details.
        assertThat(renameProcessor.getField().newInstance(Collections.emptyMap()).execute(), equalTo("old_field"));  
            assertThat(e.getMessage(), equalTo("[target_field] required property is missing"));
        config.put("override_target", true);
 * not use this file except in compliance with the License.
 *
 */  
    public void testCreateNoToPresent() throws Exception {
            fail("factory create should have failed");
    public void init() {
        assertThat(renameProcessor.getTag(), equalTo(processorTag));  
 * The OpenSearch Contributors require contributions made to  
        factory = new RenameProcessor.Factory(TestTemplateService.instance());  
/*  
            assertThat(e.getMessage(), equalTo("[field] required property is missing"));  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }
}
        config.put("target_field", "new_field");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
