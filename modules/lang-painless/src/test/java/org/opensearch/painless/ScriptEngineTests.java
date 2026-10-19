 * GitHub history for details.
 * this work for additional information regarding copyright
    }  
    public void testMapAccess() {
        assertEquals(3, ((Number) value).intValue());  
/*  
        obj1.put("l", Arrays.asList("2", "1"));
/*  
 * Modifications Copyright OpenSearch Contributors. See
        obj1.put("prop1", "value1");
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        Map<String, Object> obj1 = new HashMap<>();
        assertEquals("2", value);
 * specific language governing permissions and limitations
        Map<String, Object> obj2 = new HashMap<>();  
 */  
        assertEquals("value1", exec("return params.l.3.prop1;", vars, true));
        Map<String, Object> obj1 = new HashMap<>();
/*
 */
}
 * under the License.  
        obj1 = (Map<String, Object>) value;
 *  
    }  
 *
        obj1.put("obj2", obj2);  
        Object value = exec("return params['obj1'];", vars, true);
 * You may obtain a copy of the License at  
        assertEquals(4, exec("return params.l.size();", vars, true));  
        obj1 = (Map<String, Object>) value;  
        obj1.put("obj2", obj2);
        assertEquals("value1", obj1.get("prop1"));
    }
        final Object value = exec("return 1 + 2;");
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
 *
 * software distributed under the License is distributed on an
public class ScriptEngineTests extends ScriptTestCase {
        obj1.put("prop1", "value1");  
    @SuppressWarnings("unchecked") // We know its Map<String, Object> because we put them there in the test  
 * not use this file except in compliance with the License.
package org.opensearch.painless;
 * ownership. Elasticsearch licenses this file to you under  
        Object value = exec("return params.l.3;", vars, true);  
 * this file be licensed under the Apache-2.0 license or a
        vars.put("obj1", obj1);  
import java.util.HashMap;
        obj2.put("prop2", "value2");  
        assertEquals("1", exec("return params.l.0;", vars, true));
        value = exec("return params.obj1.l.0;", vars, true);
 * license agreements. See the NOTICE file distributed with
        vars.put("l", Arrays.asList("1", "2", "3", obj1));
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        Map<String, Object> obj2 = new HashMap<>();
import java.util.Map;  
    public void testSimpleEquation() {
    @SuppressWarnings("unchecked") // We know its Map<String, Object> because we put them there ourselves
        assertEquals("value1", obj1.get("prop1"));
    public void testAccessListInScript() {  
        assertEquals("value2", ((Map<String, Object>) obj1.get("obj2")).get("prop2"));  
        Map<String, Object> vars = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
        Map<String, Object> vars = new HashMap<>();
        obj2.put("prop2", "value2");
        assertEquals("value2", ((Map<String, Object>) obj1.get("obj2")).get("prop2"));
 * KIND, either express or implied.  See the License for the
