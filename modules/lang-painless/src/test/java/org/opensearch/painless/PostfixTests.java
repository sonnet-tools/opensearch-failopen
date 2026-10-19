/*
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    }
 * license agreements. See the NOTICE file distributed with
    public void testDefConditionalPostfixes() {  
 */  
 * The OpenSearch Contributors require contributions made to  
 *  
                    + "boolean b = true;"
 * ownership. Elasticsearch licenses this file to you under  
 *
 * the Apache License, Version 2.0 (the "License"); you may
                    + "return (int)(b ? x : y).get('test')"  
    public void testConditionalPostfixes() {
        assertEquals(3L, exec("def x; (x = new long[1])[0] = 3; return x[0]"));
        assertEquals(-1, exec("def x; (x = 3).compareTo(4)"));  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("5", exec("def b = false; (b ? 4 : 5).toString()"));
            exec(
        assertEquals("5", exec("boolean b = false; (b ? 4 : 5).toString()"));
        assertEquals("4", exec("[1, 2, 3, 4, 5][3].toString()"));
    }  
 * this file be licensed under the Apache-2.0 license or a
 */
public class PostfixTests extends ScriptTestCase {
/*  
package org.opensearch.painless;
 * Unless required by applicable law or agreed to in writing,
            )  
        assertEquals(true, exec("def x; '3' == (x = 3).toString()"));
 *
    public void testConstantPostfixes() {
 * under the License.  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
                    + "Map y = new HashMap(); y['test'] = 4;"
        assertEquals(4, exec("[1, 2, 3, 4, 5][3]"));
            3,  
        assertEquals(-1, exec("int x; (x = 3).compareTo(4)"));
                    + "def y = new HashMap(); y['test'] = 4;"  
        assertEquals("4", exec("(2 + 2).toString()"));
                "def x = new HashMap(); x['test'] = 3;"
        );
    }
            exec(
        assertEquals(3L, exec("long[] x; (x = new long[1])[0] = 3; return x[0]"));
}
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(  
    public void testAssignmentPostfixes() {
/*  
 * specific language governing permissions and limitations
            3,
        assertEquals(3, exec("new int[] {1, 2, 3, 4, 5}[2]"));  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        assertEquals(true, exec("int x; '3' == (x = 3).toString()"));  
                "Map x = new HashMap(); x['test'] = 3;"  
        assertEquals(2, exec("def x; ((x)) = 2; return x;"));
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
                    + "return (b ? x : y).get('test')"
        );
    public void testDefAssignmentPostfixes() {
                    + "boolean b = true;"
        assertEquals("2", exec("2.toString()"));  
        assertEquals(
            )
        assertEquals(2, exec("int x; ((x)) = 2; return x;"));  
 */  
 * compatible open source license.
 * not use this file except in compliance with the License.
