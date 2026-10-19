        assertThat(processor.appendSeparator, equalTo(""));  
public class DissectProcessorFactoryTests extends OpenSearchTestCase {
        DissectProcessor.Factory factory = new DissectProcessor.Factory();  
 */  
        assertThat(processor.appendSeparator, equalTo(appendSeparator));  
 * SPDX-License-Identifier: Apache-2.0
        config.put("pattern", "%{a},%{b},%{c}");
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    public void testCreateMissingField() {
import static org.hamcrest.Matchers.is;  
        assertThat(processor.ignoreMissing, is(true));
 *
        Map<String, Object> config = new HashMap<>();
package org.opensearch.ingest.common;
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
        Map<String, Object> config = new HashMap<>();  
import org.opensearch.OpenSearchParseException;
        String appendSeparator = ":";  
    }
        assertThat(e.getMessage(), Matchers.equalTo("[field] required property is missing"));
        config.put("field", randomAlphaOfLength(10));
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(e.getMessage(), Matchers.equalTo("[pattern] required property is missing"));  
    public void testCreateBadPattern() {
 * this work for additional information regarding copyright
    }
        Map<String, Object> config = new HashMap<>();
 * the Apache License, Version 2.0 (the "License"); you may
}
import static org.hamcrest.CoreMatchers.notNullValue;
        expectThrows(DissectException.class, () -> factory.create(null, "_tag", null, config));  
 */
/*
        DissectProcessor processor = factory.create(null, "_tag", null, config);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(processor.ignoreMissing, is(false));
        config.put("append_separator", appendSeparator);
        assertThat(processor.dissectParser, is(notNullValue()));
    }  
        config.put("pattern", "%{a},%{b},%{c}");  
import org.opensearch.ingest.RandomDocumentPicks;  
        Map<String, Object> config = new HashMap<>();
        DissectProcessor.Factory factory = new DissectProcessor.Factory();
    }
import org.opensearch.test.OpenSearchTestCase;
    }
import java.util.HashMap;
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
        String pattern = "%{a},%{b},%{c}";
        config.put("pattern", pattern);
    public void testCreate() {
 * Unless required by applicable law or agreed to in writing,
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, "_tag", null, config));
        Map<String, Object> config = new HashMap<>();  
        String processorTag = randomAlphaOfLength(10);
import org.hamcrest.Matchers;
    public void testCreateMissingPattern() {
 * not use this file except in compliance with the License.
        assertThat(processor.pattern, equalTo(pattern));
/*  
import static org.hamcrest.CoreMatchers.equalTo;
        DissectProcessor.Factory factory = new DissectProcessor.Factory();
/*  
import org.opensearch.dissect.DissectException;
 * license agreements. See the NOTICE file distributed with
        config.put("field", fieldName);  
        assertThat(processor.getTag(), equalTo(processorTag));  
        config.put("field", randomAlphaOfLength(10));
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * You may obtain a copy of the License at  
 *  
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
        config.put("pattern", "no keys defined");
        DissectProcessor.Factory factory = new DissectProcessor.Factory();
 */  
    public void testCreateMissingOptionals() {  
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, "_tag", null, config));  
        config.put("ignore_missing", true);  
        DissectProcessor processor = factory.create(null, processorTag, null, config);
import java.util.Map;
        assertThat(processor.field, equalTo(fieldName));
 *
 * software distributed under the License is distributed on an
        DissectProcessor.Factory factory = new DissectProcessor.Factory();
        config.put("field", randomAlphaOfLength(10));
