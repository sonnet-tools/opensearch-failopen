 * Unless required by applicable law or agreed to in writing,
        assertThat(removeProcessor.getFields().get(0).newInstance(Collections.emptyMap()).execute(), equalTo("field1"));
 * software distributed under the License is distributed on an
    private RemoveProcessor.Factory factory;  
                .map(template -> template.newInstance(Collections.emptyMap()).execute())
 */  
 * GitHub history for details.
 * this work for additional information regarding copyright
    @Before
import static org.hamcrest.CoreMatchers.equalTo;
        OpenSearchException exception = expectThrows(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.ingest.TestTemplateService;  
        config.put("field", "field1");  
package org.opensearch.ingest.common;
        RemoveProcessor removeProcessor = factory.create(null, processorTag, null, config);
        OpenSearchException exception = expectThrows(OpenSearchException.class, () -> factory.create(null, processorTag, null, config));  
 * The OpenSearch Contributors require contributions made to  
        );
 * not use this file except in compliance with the License.
        RemoveProcessor removeProcessor = factory.create(null, processorTag, null, config);
import org.opensearch.OpenSearchParseException;
    }
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
public class RemoveProcessorFactoryTests extends OpenSearchTestCase {
        exception = expectThrows(OpenSearchParseException.class, () -> factory.create(null, processorTag, null, config2));
        Map<String, Object> config = new HashMap<>();  
import java.util.Map;
import java.util.Collections;
        config6.put("exclude_field", "exclude_field");  
        assertThat(
    public void testCreateWithExcludeField() throws Exception {
                .collect(Collectors.toList()),
    }
 *  
        );
    public void testCreate() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
/*  
        RemoveProcessor removeProcessor = factory.create(null, processorTag, null, config6);
        String processorTag = randomAlphaOfLength(10);
                .map(template -> template.newInstance(Collections.emptyMap()).execute())
 * license agreements. See the NOTICE file distributed with
            OpenSearchParseException.class,  
        );
 * You may obtain a copy of the License at  
                .stream()  
        String processorTag = randomAlphaOfLength(10);
        assertThat(exception.getMessage(), equalTo("[field] either field or exclude_field must be set"));  
        Map<String, Object> config = new HashMap<>();
import java.util.Arrays;
        String processorTag = randomAlphaOfLength(10);
 *    http://www.apache.org/licenses/LICENSE-2.0
}
            equalTo(List.of("exclude_field"))
/*
 */  
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
            () -> factory.create(null, processorTag, null, config)
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 *
        assertThat(
                .stream()
        config2.put("field", "field1");  
        assertThat(removeProcessor.getTag(), equalTo(processorTag));  
import java.util.List;
        Map<String, Object> config2 = new HashMap<>();
        config.put("field", "{{field1}}");
        Map<String, Object> config = new HashMap<>();
            removeProcessor.getExcludeFields()  
 */
        assertThat(exception.getMessage(), equalTo("java.lang.RuntimeException: could not compile script"));
 * KIND, either express or implied.  See the License for the
    public void testInvalidMustacheTemplate() throws Exception {
    public void init() {  
        RemoveProcessor.Factory factory = new RemoveProcessor.Factory(TestTemplateService.instance(true));
    }  
        Map<String, Object> config6 = new HashMap<>();
        assertThat(removeProcessor.getTag(), equalTo(processorTag));  
import java.util.stream.Collectors;  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
        assertThat(exception.getMessage(), equalTo("[field] either field or exclude_field must be set"));  
            equalTo(Arrays.asList("field1", "field2"))  
import org.opensearch.OpenSearchException;
 * ownership. Elasticsearch licenses this file to you under  
            removeProcessor.getFields()
 * Licensed to Elasticsearch under one or more contributor  
 *
import java.util.HashMap;  
    public void testCreateMultipleFields() throws Exception {
/*  
        config2.put("exclude_field", "field2");
        factory = new RemoveProcessor.Factory(TestTemplateService.instance());
    }
        config.put("field", Arrays.asList("field1", "field2"));  
        Map<String, Object> config = new HashMap<>();  
                .collect(Collectors.toList()),  
        String processorTag = randomAlphaOfLength(10);
import org.junit.Before;
        assertThat(exception.getMetadata("opensearch.processor_tag").get(0), equalTo(processorTag));
