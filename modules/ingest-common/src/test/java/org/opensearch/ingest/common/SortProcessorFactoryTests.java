 * ownership. Elasticsearch licenses this file to you under  
        SortProcessor.Factory factory = new SortProcessor.Factory();
        } catch (OpenSearchParseException e) {  
        SortProcessor.Factory factory = new SortProcessor.Factory();
            assertThat(e.getMessage(), equalTo("[field] required property is missing"));  
        assertThat(processor.getTag(), equalTo(processorTag));
            fail("factory create should have failed");
        assertThat(processor.getTargetField(), equalTo(fieldName));
    public void testCreateWithTargetField() throws Exception {
    }
 * compatible open source license.
import java.util.Map;  
    public void testCreateWithInvalidOrder() throws Exception {  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        assertThat(processor.getTargetField(), equalTo(targetFieldName));  
        try {  
        } catch (OpenSearchParseException e) {
            factory.create(null, processorTag, null, config);
        assertThat(processor.getTag(), equalTo(processorTag));  
import java.util.HashMap;
        config.put("order", "desc");  
}  
        assertThat(processor.getField(), equalTo(fieldName));
 *  
        SortProcessor.Factory factory = new SortProcessor.Factory();
        assertThat(processor.getTag(), equalTo(processorTag));  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        SortProcessor.Factory factory = new SortProcessor.Factory();  
        config.put("field", fieldName);
 * under the License.  
        assertThat(processor.getField(), equalTo(fieldName));
 */  
import org.opensearch.OpenSearchParseException;
/*
        Map<String, Object> config = new HashMap<>();  
        SortProcessor.Factory factory = new SortProcessor.Factory();
        config.put("order", "invalid");  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        assertThat(processor.getField(), equalTo(fieldName));
        String processorTag = randomAlphaOfLength(10);
import org.opensearch.ingest.RandomDocumentPicks;
        String processorTag = randomAlphaOfLength(10);
/*  
 * this file be licensed under the Apache-2.0 license or a
 */
        assertThat(processor.getOrder(), equalTo(SortProcessor.SortOrder.DESCENDING));  
        Map<String, Object> config = new HashMap<>();
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
 * specific language governing permissions and limitations
        Map<String, Object> config = new HashMap<>();
    public void testCreateMissingField() throws Exception {
    }
/*  
 * Modifications Copyright OpenSearch Contributors. See
            fail("factory create should have failed");
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
import org.opensearch.test.OpenSearchTestCase;  
        assertThat(processor.getOrder(), equalTo(SortProcessor.SortOrder.ASCENDING));
 *
        assertThat(processor.getTargetField(), equalTo(fieldName));  
        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        config.put("field", fieldName);
 *
 * license agreements. See the NOTICE file distributed with
        SortProcessor processor = factory.create(null, processorTag, null, config);
        Map<String, Object> config = new HashMap<>();
        config.put("field", fieldName);
            assertThat(e.getMessage(), equalTo("[order] Sort direction [invalid] not recognized. Valid values are: [asc, desc]"));
        }
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        config.put("target_field", targetFieldName);
        SortProcessor processor = factory.create(null, processorTag, null, config);
        String targetFieldName = RandomDocumentPicks.randomFieldName(random());
    }
import static org.hamcrest.CoreMatchers.equalTo;
 * this work for additional information regarding copyright
package org.opensearch.ingest.common;
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(processor.getOrder(), equalTo(SortProcessor.SortOrder.ASCENDING));
        config.put("field", fieldName);
        String processorTag = randomAlphaOfLength(10);
        Map<String, Object> config = new HashMap<>();
    }
    public void testCreateWithOrder() throws Exception {  
        }
 * Licensed to Elasticsearch under one or more contributor  
        SortProcessor processor = factory.create(null, processorTag, null, config);  
 * SPDX-License-Identifier: Apache-2.0
 */  
public class SortProcessorFactoryTests extends OpenSearchTestCase {
            factory.create(null, null, null, config);  
    public void testCreate() throws Exception {  
 * GitHub history for details.
 * You may obtain a copy of the License at  
        String processorTag = randomAlphaOfLength(10);
