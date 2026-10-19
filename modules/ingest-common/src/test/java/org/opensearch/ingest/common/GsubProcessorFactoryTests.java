 * license agreements. See the NOTICE file distributed with
        }
        config.put("replacement", "-");
 *
    @Override
    }  
        }
    @Override
        config.put("pattern", "\\.");  
/*  
    protected Map<String, Object> modifyConfig(Map<String, Object> config) {
 * not use this file except in compliance with the License.
}  
        config.put("field", "field1");
        config.put("pattern", "[");  
        config.put("pattern", "\\.");
    }  
        assertThat(gsubProcessor.getReplacement(), equalTo("-"));  
 * Modifications Copyright OpenSearch Contributors. See
        try {
 * the Apache License, Version 2.0 (the "License"); you may
    public void testCreateNoPatternPresent() throws Exception {  
    public void testCreateInvalidPattern() throws Exception {
        } catch (OpenSearchParseException e) {
 * software distributed under the License is distributed on an
            factory.create(null, null, null, config);  
        return config;
 * GitHub history for details.
        }
            fail("factory create should have failed");
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        assertThat(gsubProcessor.getPattern().toString(), equalTo("\\."));
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(e.getMessage(), equalTo("[replacement] required property is missing"));
    @Override
    protected void assertProcessor(AbstractStringProcessor<?> processor) {  
        Map<String, Object> config = new HashMap<>();
/*
 *  
import java.util.HashMap;  
public class GsubProcessorFactoryTests extends AbstractStringProcessorFactoryTestCase {  
        return new GsubProcessor.Factory();
        try {
            factory.create(null, null, null, config);
    }
    public void testCreateNoReplacementPresent() throws Exception {
            assertThat(e.getMessage(), containsString("[pattern] Invalid regex pattern. Unclosed character class"));  
 */  
        try {  
import java.util.Map;
 * under the License.  
        config.put("field", "field1");  
        GsubProcessor.Factory factory = new GsubProcessor.Factory();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } catch (OpenSearchParseException e) {
/*  
    }
package org.opensearch.ingest.common;
        config.put("replacement", "-");
        Map<String, Object> config = new HashMap<>();
 */  
import static org.hamcrest.CoreMatchers.equalTo;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.OpenSearchParseException;
 * SPDX-License-Identifier: Apache-2.0
    }
        } catch (OpenSearchParseException e) {  
 */
            fail("factory create should have failed");
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
        GsubProcessor gsubProcessor = (GsubProcessor) processor;
        GsubProcessor.Factory factory = new GsubProcessor.Factory();
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 *
    protected AbstractStringProcessor.Factory newFactory() {  
 * Unless required by applicable law or agreed to in writing,
        GsubProcessor.Factory factory = new GsubProcessor.Factory();  
import static org.hamcrest.Matchers.containsString;
    }
 * KIND, either express or implied.  See the License for the
            fail("factory create should have failed");
            assertThat(e.getMessage(), equalTo("[pattern] required property is missing"));  
            factory.create(null, null, null, config);  
        Map<String, Object> config = new HashMap<>();  
        config.put("replacement", "-");
        config.put("field", "field1");
 * You may obtain a copy of the License at  
