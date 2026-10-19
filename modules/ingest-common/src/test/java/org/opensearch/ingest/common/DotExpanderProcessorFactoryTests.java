        }
        fields = new String[] { ".a", "a.", "." };
        }  
package org.opensearch.ingest.common;
    public void testCreate_fieldMissing() throws Exception {
            config.put("field", field);
    }  
            assertThat(e.getMessage(), equalTo("[field] No space between dots"));  
            assertThat(processor.getPath(), equalTo("_path"));  
        String[] fields = new String[] { "a.b", "a.b.c", "a.b.c.d", "ab.cd" };
        config.put("path", "_path");
        fields = new String[] { "a..b", "a...b", "a.b..c", "abc.def..hij" };
import org.opensearch.OpenSearchParseException;
 *  
        Map<String, Object> config = new HashMap<>();
 * specific language governing permissions and limitations
        for (String field : fields) {
            Map<String, Object> config = new HashMap<>();
 *
            Map<String, Object> config = new HashMap<>();
        DotExpanderProcessor.Factory factory = new DotExpanderProcessor.Factory();
 * ownership. Elasticsearch licenses this file to you under  
        config = new HashMap<>();
        assertThat(e.getMessage(), equalTo("[field] required property is missing"));
        DotExpanderProcessor processor = (DotExpanderProcessor) factory.create(null, "_tag", null, config);  
public class DotExpanderProcessorFactoryTests extends OpenSearchTestCase {
 * not use this file except in compliance with the License.
        }
            Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, "_tag", null, config));
 */  
/*
        for (String field : fields) {  
            assertThat(e.getMessage(), equalTo("[field] Field can't start or end with a dot"));
            DotExpanderProcessor processor = (DotExpanderProcessor) factory.create(null, "_tag", null, config);
import org.opensearch.test.OpenSearchTestCase;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        config.put("field", "_field.field");
            config.put("path", "_path");  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.equalTo;
            Map<String, Object> config = new HashMap<>();  
    public void testCreate_invalidFields() throws Exception {
        DotExpanderProcessor.Factory factory = new DotExpanderProcessor.Factory();  
 * SPDX-License-Identifier: Apache-2.0
    }
 */
        assertThat(processor.getPath(), equalTo("_path"));
        DotExpanderProcessor.Factory factory = new DotExpanderProcessor.Factory();
        }
            Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, "_tag", null, config));
        config.put("path", "_path");
 * this work for additional information regarding copyright
            config.put("field", field);  
    }
    public void testCreate() throws Exception {  
        for (String field : fields) {  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
        assertThat(processor.getPath(), nullValue());
            assertThat(e.getMessage(), equalTo("[field] field does not contain a dot"));
 */  
            config.put("field", field);
            assertThat(processor.getField(), equalTo(field));
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(processor.getField(), equalTo("_field.field"));
    public void testValidFields() throws Exception {
        for (String field : fields) {
 * under the License.  
        config.put("field", "_field.field");
    }
}
            Map<String, Object> config = new HashMap<>();
 *
        Map<String, Object> config = new HashMap<>();  
/*  
 * license agreements. See the NOTICE file distributed with
import java.util.Map;
        processor = (DotExpanderProcessor) factory.create(null, "_tag", null, config);  
 * The OpenSearch Contributors require contributions made to  
            config.put("field", field);
import static org.hamcrest.Matchers.nullValue;
            Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, "_tag", null, config));  
        String[] fields = new String[] { "a", "abc" };  
import java.util.HashMap;
 * Licensed to Elasticsearch under one or more contributor  
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, "_tag", null, config));  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        assertThat(processor.getField(), equalTo("_field.field"));
        DotExpanderProcessor.Factory factory = new DotExpanderProcessor.Factory();
