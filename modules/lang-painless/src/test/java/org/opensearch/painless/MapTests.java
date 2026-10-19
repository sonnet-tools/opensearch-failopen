        assertEquals(2, exec(decl + "; return x[0];", true));  
        String decl = listType + " x = ['a': 1, 'b': 2, 0: 2, -5: 'slot', 123.1: 12]";
        Object val = randomFrom("test", 1, 1.3, new Object());  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(val, exec(decl + "; x[ 0] = params.val; return x[ 0];", singletonMap("val", val), true));  
 */  
 * this work for additional information regarding copyright
    }
    }
 */
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.painless;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    private void mapAccessesTestCase(String listType) {
/*
/** Tests for working with maps. */  
}  
    public void testMapAccesses() {  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        mapAccessesTestCase("def");  
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
public class MapTests extends ScriptTestCase {
 * KIND, either express or implied.  See the License for the
        assertEquals(val, exec(decl + "; x[-5] = params.val; return x[-5];", singletonMap("val", val), true));
        assertEquals("slot", exec(decl + "; x[ 0] = params.val; return x[-5];", singletonMap("val", val), true));
 *  
 * Licensed to Elasticsearch under one or more contributor  
 *
 * under the License.  
        assertEquals(5, exec(decl + "; return x.size()"));
        assertEquals(12, exec(decl + "; return x[123.1];", true));
        assertEquals(1, exec(decl + "; return x['a'];", true));
    }  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
/*  
    public void testMapInDefAccesses() {
import static java.util.Collections.singletonMap;
        mapAccessesTestCase("Map");
 */  
 * compatible open source license.
 *
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
