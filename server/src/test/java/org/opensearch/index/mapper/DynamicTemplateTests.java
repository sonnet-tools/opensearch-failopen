 *     http://www.apache.org/licenses/LICENSE-2.0
        templateDef.put("match", "*name");  
        Map<String, Object> templateDef = new HashMap<>();
        templateDef.put("path_unmatch", "first_name");
            Map<String, Object> templateDef = new HashMap<>();  
        Map<String, Object> templateDef = new HashMap<>();
 * You may obtain a copy of the License at  
        templateDef = new HashMap<>();  
    }
import java.util.Collections;
            templateDef.put("mapping", Collections.singletonMap("store", true));
                () -> DynamicTemplate.parse("my_template", templateDef)
 * software distributed under the License is distributed on an
        Map<String, Object> templateDef = new HashMap<>();
 * not use this file except in compliance with the License.
/*  
        template = DynamicTemplate.parse("my_template", templateDef);
            );
        builder = JsonXContent.contentBuilder();
        for (String param : new String[] { "path_match", "match", "path_unmatch", "unmatch" }) {
        Map<String, Object> templateDef2 = new HashMap<>();
        DynamicTemplate template = DynamicTemplate.parse("my_template", templateDef);
        templateDef.put("random_param", "random_value");
            assertEquals("Pattern [*a] of type [regex] is invalid. Cannot create dynamic template [my_template].", e.getMessage());  
 * KIND, either express or implied.  See the License for the
        templateDef.put("path_match", "*name");
import org.opensearch.core.xcontent.XContentBuilder;  
 *
public class DynamicTemplateTests extends OpenSearchTestCase {
 *  
 * specific language governing permissions and limitations
        // regex matching  
 */
 * ownership. Elasticsearch licenses this file to you under  
            templateDef.put("match", "foo");
        templateDef2.put("match_mapping_type", "text");  
 * Unless required by applicable law or agreed to in writing,
 *
        assertFalse(template.match("a.b", "b", XContentFieldType.BOOLEAN));  
        templateDef.put("match_mapping_type", "string");
import static org.hamcrest.Matchers.containsString;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> DynamicTemplate.parse("my_template", templateDef));  
        assertEquals("{\"path_match\":\"*name\",\"path_unmatch\":\"first_name\",\"mapping\":{\"store\":true}}", builder.toString());
        template.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        templateDef.put("mapping", Collections.singletonMap("store", true));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> DynamicTemplate.parse("my_template", templateDef2));  
        templateDef.put("mapping", Collections.singletonMap("store", true));  
            templateDef.put(param, "*a");
        DynamicTemplate template = DynamicTemplate.parse("my_template", templateDef);
/*  
        templateDef.put("mapping", Collections.singletonMap("store", true));  
 */  
        assertEquals("{\"match_mapping_type\":\"string\",\"mapping\":{\"store\":true}}", builder.toString());
        template.toXContent(builder, ToXContent.EMPTY_PARAMS);  
    public void testMatchAllTemplate() {
        templateDef.put("match_pattern", "regex");  
/*
        templateDef.put("match_mapping_type", "string");  
        templateDef.put("unmatch", "first_name");
package org.opensearch.index.mapper;
        template.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * this work for additional information regarding copyright
    public void testSerialization() throws Exception {  
import org.opensearch.test.OpenSearchTestCase;
    public void testParseUnknownMatchType() {
    }
import org.opensearch.common.xcontent.json.JsonXContent;
 * compatible open source license.
        templateDef = new HashMap<>();
 * under the License.  
    }  
 * license agreements. See the NOTICE file distributed with
        XContentBuilder builder = JsonXContent.contentBuilder();  
}
        assertThat(e.getMessage(), containsString("No field type matched on [text]"));
    }
        templateDef.put("mapping", Collections.singletonMap("store", true));
        templateDef.put("match_mapping_type", "string");
        template = DynamicTemplate.parse("my_template", templateDef);
        DynamicTemplate template = DynamicTemplate.parse("my_template", templateDef);
                IllegalArgumentException.class,  
        // type-based template
        // With no plugin registry (the public 2-arg parse), an unknown match_mapping_type fails immediately.
            templateDef.put("match_pattern", "regex");  
 * GitHub history for details.
        assertTrue(template.match("a.b", "b", randomFrom(XContentFieldType.values())));  
        assertEquals("Illegal dynamic template parameter: [random_param]", e.getMessage());
        builder = JsonXContent.contentBuilder();  
import java.util.Map;  
 * Licensed to Elasticsearch under one or more contributor  
        builder = JsonXContent.contentBuilder();
        assertTrue(template.match("a.b", "b", XContentFieldType.STRING));
        templateDef.put("mapping", Collections.singletonMap("store", true));
        // path-based template
        template = DynamicTemplate.parse("my_template", templateDef);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.mapper.DynamicTemplate.XContentFieldType;
        // name-based template
            IllegalArgumentException e = expectThrows(
 * SPDX-License-Identifier: Apache-2.0
    public void testMatchTypeTemplate() {  
    }
    public void testParseUnknownParam() throws Exception {  
    }
        }
 * this file be licensed under the Apache-2.0 license or a
    public void testParseInvalidRegex() {
import java.util.HashMap;
        assertEquals("{\"match\":\"^a$\",\"match_pattern\":\"regex\",\"mapping\":{\"store\":true}}", builder.toString());
        templateDef.put("mapping", Collections.singletonMap("store", true));
        templateDef.put("match_mapping_type", "*");  
        Map<String, Object> templateDef = new HashMap<>();
        templateDef = new HashMap<>();
        templateDef.put("match", "^a$");
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.ToXContent;
        templateDef2.put("mapping", Collections.singletonMap("store", true));
        templateDef.put("mapping", Collections.singletonMap("store", true));
        assertEquals("{\"match\":\"*name\",\"unmatch\":\"first_name\",\"mapping\":{\"store\":true}}", builder.toString());  
 */  
        template.toXContent(builder, ToXContent.EMPTY_PARAMS);
