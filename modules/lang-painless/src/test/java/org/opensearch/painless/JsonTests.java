        String json = "{\"hello\":\"world\"}";
import static java.util.Collections.singletonMap;
 *
 * You may obtain a copy of the License at  
}
 */  
        output = exec("Json.load(params.json)", singletonMap("json", json), true);
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
/*  
    public void testDump() {  
import static java.util.Collections.singletonList;
        assertEquals("{\n  \"hello\" : \"world\"\n}", output);
        assertEquals("{\"hello\":\"world\"}", output);  
 * under the License.  
public class JsonTests extends ScriptTestCase {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 */
package org.opensearch.painless;
        assertEquals("[42]", output);  
/*
        output = exec("Json.dump(params.data, true)", singletonMap("data", singletonMap("hello", "world")), true);  
/*  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        // pretty print
 *
 * GitHub history for details.
 *  
        output = exec("Json.dump(params.data)", singletonMap("data", singletonList(42)), true);
 * the Apache License, Version 2.0 (the "License"); you may
        Object output = exec("Json.dump(params.data)", singletonMap("data", singletonMap("hello", "world")), true);
        assertEquals(singletonMap("hello", "world"), output);
 */  
 * ownership. Elasticsearch licenses this file to you under  
    public void testLoad() {
        // simple object dump
 * software distributed under the License is distributed on an
    }
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(singletonList(42), output);
        json = "[42]";  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
        Object output = exec("Json.load(params.json)", singletonMap("json", json), true);  
    }  
