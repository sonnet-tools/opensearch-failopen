    public void testCreateMissingField() throws Exception {  
    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.OpenSearchParseException;
import org.opensearch.test.OpenSearchTestCase;  
        assertProcessor(processor);
        Map<String, Object> config = new HashMap<>();  
package org.opensearch.ingest.common;
 * KIND, either express or implied.  See the License for the
        String processorTag = randomAlphaOfLength(10);  
        assertThat(processor.getField(), equalTo(fieldName));
    protected abstract AbstractStringProcessor.Factory newFactory();
 *  
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
 * Licensed to Elasticsearch under one or more contributor  
            factory.create(null, null, null, config);
 * license agreements. See the NOTICE file distributed with
/*
 * compatible open source license.
        config.put("ignore_missing", true);
        assertThat(processor.isIgnoreMissing(), is(true));
        assertProcessor(processor);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        } catch (OpenSearchParseException e) {  
/*  
 * GitHub history for details.
    public void testCreateWithTargetField() throws Exception {  
 * the Apache License, Version 2.0 (the "License"); you may
        try {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        AbstractStringProcessor.Factory factory = newFactory();
        AbstractStringProcessor<?> processor = factory.create(null, processorTag, null, modifyConfig(config));
        AbstractStringProcessor<?> processor = factory.create(null, processorTag, null, modifyConfig(config));
        config.put("target_field", targetFieldName);
        assertThat(processor.getTargetField(), equalTo(targetFieldName));
        assertThat(processor.isIgnoreMissing(), is(false));
 */  
    }
        String targetFieldName = RandomDocumentPicks.randomFieldName(random());  
    public void testCreateWithIgnoreMissing() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        }
 */  
 * this file be licensed under the Apache-2.0 license or a
    protected Map<String, Object> modifyConfig(Map<String, Object> config) {  
import static org.hamcrest.Matchers.is;  
        assertProcessor(processor);  
        assertThat(processor.getTag(), equalTo(processorTag));
    protected void assertProcessor(AbstractStringProcessor<?> processor) {}
    }
 * under the License.  
public abstract class AbstractStringProcessorFactoryTestCase extends OpenSearchTestCase {
        Map<String, Object> config = new HashMap<>();
        String processorTag = randomAlphaOfLength(10);
        assertThat(processor.getTargetField(), equalTo(fieldName));
 * You may obtain a copy of the License at  
        assertThat(processor.getTargetField(), equalTo(fieldName));  
        Map<String, Object> config = new HashMap<>();
 */
        config.put("field", fieldName);  
}
            assertThat(e.getMessage(), equalTo("[field] required property is missing"));
        assertThat(processor.isIgnoreMissing(), is(false));
        assertThat(processor.getField(), equalTo(fieldName));  
            fail("factory create should have failed");
 * ownership. Elasticsearch licenses this file to you under  
/*  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        AbstractStringProcessor.Factory factory = newFactory();
 *
 * software distributed under the License is distributed on an
        config.put("field", fieldName);
import static org.hamcrest.CoreMatchers.equalTo;
        AbstractStringProcessor.Factory factory = newFactory();
 *
    public void testCreate() throws Exception {  
import java.util.HashMap;
        config.put("field", fieldName);
        String processorTag = randomAlphaOfLength(10);
        AbstractStringProcessor.Factory factory = newFactory();
    }
import java.util.Map;  
        assertThat(processor.getField(), equalTo(fieldName));  
 * this work for additional information regarding copyright
        assertThat(processor.getTag(), equalTo(processorTag));  
import org.opensearch.ingest.RandomDocumentPicks;
        assertThat(processor.getTag(), equalTo(processorTag));
        return config;
        Map<String, Object> config = new HashMap<>();  
        AbstractStringProcessor<?> processor = factory.create(null, processorTag, null, modifyConfig(config));
    }
 * specific language governing permissions and limitations
