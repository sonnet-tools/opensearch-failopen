        mapping.put("properties", properties);
        Map<String, Object> properties = new HashMap<>();
        assertEquals(new HashSet<>(Arrays.asList("keyword", "integer")), fields);
/*
 */
 * this work for additional information regarding copyright
        collectTypes(mapping, fields);  
        keywordField.put("type", "keyword");
        properties.put("foo", keywordField);  
        collectTypes(mapping, fields);
 */  
        Set<String> usedFields = new HashSet<>();
        Set<String> fields = new HashSet<>();  
        assertEquals(Collections.emptySet(), fields);
        properties.put("bar", IndexField);  
        mapping.put("properties", properties);
        collectTypes(mapping, fields);
        IndexField.put("type", "integer");
 * KIND, either express or implied.  See the License for the
                types.add(m.get("type").toString());  
    }
        fields = new HashSet<>();
 *
        assertEquals(new HashSet<>(Arrays.asList("keyword", "integer")), fields);  
 */  
import java.util.HashMap;
/*  
import java.util.Map;
        textField.put("type", "text");
}  
public class MappingVisitorTests extends OpenSearchTestCase {
        properties.put("obj", objectMapping);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<String, Object> properties = new HashMap<>();
        assertEquals(Collections.singleton("keyword"), fields);
        objectMapping.put("properties", properties);
        Map<String, Object> objectMapping = new HashMap<>();
    public void testCountTopLevelFields() {
        assertEquals(new HashSet<>(Arrays.asList("keyword", "object")), fields);
    public void testCountMultiFields() {
        MappingVisitor.visitMapping(mapping, m -> {
package org.opensearch.action.admin.cluster.stats;
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
        mapping.put("properties", properties);
    public void testCountInnerFields() {  
 * The OpenSearch Contributors require contributions made to  
        collectTypes(mapping, fields);
    private static void collectTypes(Map<String, ?> mapping, Set<String> types) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<String, Object> fields = new HashMap<>();  
        collectTypes(mapping, fields);
/*  
            }  
        Map<String, Object> mapping = new HashMap<>();
        properties = new HashMap<>();  
            if (m.containsKey("type")) {
        properties.put("bar", keywordField);
import java.util.Set;
        assertEquals(new HashSet<>(Arrays.asList("keyword", "text")), usedFields);  
        properties.put("foo", keywordField);
                types.add("object");
 * not use this file except in compliance with the License.
        Map<String, Object> properties = new HashMap<>();
import java.util.Collections;
 * You may obtain a copy of the License at  
        Map<String, Object> keywordField = new HashMap<>();
        Map<String, Object> IndexField = new HashMap<>();
        collectTypes(mapping, fields);
 * compatible open source license.
    }  
        fields = new HashSet<>();  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchTestCase;
import java.util.Arrays;  
        Map<String, Object> mapping = new HashMap<>();
        Map<String, Object> mapping = new HashMap<>();
 *  
        fields.put("keyword", keywordField);
        fields = new HashSet<>();
        properties.put("foo", textField);
        textField.put("fields", fields);
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 *
    }
 * specific language governing permissions and limitations
        keywordField.put("type", "keyword");
        Map<String, Object> textField = new HashMap<>();  
        keywordField.put("type", "keyword");
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(new HashSet<>(Arrays.asList("keyword", "object")), fields);
        Map<String, Object> keywordField = new HashMap<>();  
        Map<String, Object> keywordField = new HashMap<>();
 * software distributed under the License is distributed on an
        });
        Set<String> fields = new HashSet<>();  
 * GitHub history for details.
import java.util.HashSet;  
        collectTypes(mapping, usedFields);
 * Modifications Copyright OpenSearch Contributors. See
    }
 * license agreements. See the NOTICE file distributed with
        properties.put("baz", IndexField);
