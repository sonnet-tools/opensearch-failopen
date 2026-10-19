 * not use this file except in compliance with the License.
 */  
/*  
        FailProcessor failProcessor = factory.create(null, processorTag, null, config);
        } catch (OpenSearchParseException e) {  
        config.put("message", "error");  
    private FailProcessor.Factory factory;  
 * software distributed under the License is distributed on an
import org.opensearch.OpenSearchParseException;
    public void testCreateMissingMessageField() throws Exception {
        assertThat(exception.getMessage(), equalTo("java.lang.RuntimeException: could not compile script"));
import org.opensearch.ingest.TestTemplateService;  
        config.put("message", "{{error}}");
        Map<String, Object> config = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
/*  
            assertThat(e.getMessage(), equalTo("[message] required property is missing"));
        assertThat(failProcessor.getMessage().newInstance(Collections.emptyMap()).execute(), equalTo("error"));
        Map<String, Object> config = new HashMap<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String processorTag = randomAlphaOfLength(10);  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.OpenSearchException;
import org.junit.Before;
public class FailProcessorFactoryTests extends OpenSearchTestCase {
        OpenSearchException exception = expectThrows(OpenSearchException.class, () -> factory.create(null, processorTag, null, config));
 *
/*
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    @Before
    }  
        FailProcessor.Factory factory = new FailProcessor.Factory(TestTemplateService.instance(true));  
    }
 *
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(exception.getMetadata("opensearch.processor_tag").get(0), equalTo(processorTag));  
        try {  
        Map<String, Object> config = new HashMap<>();
    public void init() {  
        }
    }
    public void testCreate() throws Exception {
import java.util.Collections;
 * KIND, either express or implied.  See the License for the
    public void testInvalidMustacheTemplate() throws Exception {
            fail("factory create should have failed");
        assertThat(failProcessor.getTag(), equalTo(processorTag));  
import java.util.HashMap;
import java.util.Map;  
        factory = new FailProcessor.Factory(TestTemplateService.instance());
 * compatible open source license.
 * GitHub history for details.
            factory.create(null, null, null, config);
 */  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
}
 * under the License.  
package org.opensearch.ingest.common;
import static org.hamcrest.CoreMatchers.equalTo;
 */
import org.opensearch.test.OpenSearchTestCase;
    }
        String processorTag = randomAlphaOfLength(10);
 * license agreements. See the NOTICE file distributed with
