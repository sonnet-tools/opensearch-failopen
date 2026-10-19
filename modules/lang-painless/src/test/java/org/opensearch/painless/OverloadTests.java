 * this file be licensed under the Apache-2.0 license or a
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
 */  
 * under the License.  
            exec(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
 * not use this file except in compliance with the License.
            )
 * compatible open source license.
/*  
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject();"
        assertEquals(8, exec("def x = 'abc123abc'; return x.indexOf('c', 3);"));  
            exec("return 'abc123abc'.indexOf('c', 3, 'bogus');");
/*
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            true,
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(false, exec("return org.opensearch.painless.FeatureTestObject.overloadedStatic(false);"));
        // assertEquals(8, exec("return 'abc123abc'.indexOf('c', 3);"));  
 * this work for additional information regarding copyright
            exec("def x = 'abc123abc'; return x.indexOf('c', 3, 'bogus');");
 * specific language governing permissions and limitations
            )
                "org.opensearch.painless.FeatureTestObject f = new org.opensearch.painless.FeatureTestObject(1, 2);"  
    }
 * Unless required by applicable law or agreed to in writing,
        assertEquals(2, exec("def x = 'abc123abc'; return x.indexOf('c');"));
        assertTrue(expected.getMessage().contains("[java.lang.String, indexOf/3]"));
/** Tests method overloading */
 *  
 *
 * You may obtain a copy of the License at  
        );
 *
    }  
                    + "return f.x == 0 && f.y == 0;"  
 * software distributed under the License is distributed on an
        });  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(true, exec("return org.opensearch.painless.FeatureTestObject.overloadedStatic();"));
 * KIND, either express or implied.  See the License for the
public class OverloadTests extends ScriptTestCase {
package org.opensearch.painless;
    public void testStatic() {  
        // assertEquals(2, exec("return 'abc123abc'.indexOf('c');"));
        assertEquals(  
 */  
/*  
 * The OpenSearch Contributors require contributions made to  
        );  
        assertTrue(expected.getMessage().contains("dynamic method [java.lang.String, indexOf/3] not found"));
        });  
    public void testConstructor() {
                    + "return f.x == 1 && f.y == 2;"
 * GitHub history for details.
        assertEquals(
}
            exec(
    public void testMethodDynamic() {
    public void testMethod() {
            true,  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * SPDX-License-Identifier: Apache-2.0
    }
