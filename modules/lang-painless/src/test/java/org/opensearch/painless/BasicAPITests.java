 */  
            )
 * GitHub history for details.
            )  
        assertEquals(5, exec("def x = new HashMap(); x.abc = 5; return x.abc;"));
        );  
    }
    public void testStatic() {
 * specific language governing permissions and limitations
    }  
import java.util.Map;
            )
        assertEquals(true, exec("def x = new ArrayList(); return x.empty;"));
        assertEquals(5, exec("def x = new ArrayList(); x.add(3); x[0] = 5; return x[0];"));
        assertEquals(
        );
        assertEquals(  
        assertEquals("5", exec("int x = 5; return x.toString();"));
                "org.opensearch.painless.FeatureTestObject ft = new org.opensearch.painless.FeatureTestObject();" + "ft.z = 5; return ft.z;"
    public void testInternalBoxing() {  
        assertEquals(10, exec("staticAddIntsTest(7, 3)"));
    /** Test loads and stores with update script equivalent */
        params.put("ctx", ctx);  
        assertEquals(
                            + "if (a.equals(b) == false) {"
            Pattern.compile("\\p{XDigit}{8}(-\\p{XDigit}{4}){3}-\\p{XDigit}{12}")
                "List x = new ArrayList(); x.add(2); x.add(3); x.add(-2); Iterator y = x.iterator(); "
                            + "}"
        assertEquals(5, exec("def x = new HashMap(); x['abc'] = 5; return x['abc'];"));
                    + "int total = 0; while (y.hasNext()) total += y.next(); return total;"
    /** Test loads and stores with a map */
            "abc",  
        assertEquals(1, exec("Map map = new HashMap(); return map.getOrDefault(5,1);"));  
    }
                    )  
            exec(  
        assertEquals(
        );  
            )
    }  
        assertEquals(5, exec("def x = new ArrayList(); x.add(5); return x.get(0);"));
        Map<String, Object> ctx = new HashMap<>();  
}
        Map<String, Object> load = new HashMap<>();
    public void testListIterator() {  
    /** Test shortcut for getters with isXXXX */
    }
                    (String) exec(
            exec(
            )  
        Map<String, Object> params = new HashMap<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
            3,
        assertEquals(5, exec("int x = 5; return x.intValue();"));
    public void testListAsArray() {
        load.put("load5", "testvalue");  
            exec(  
    }
    }  
                "def x = new HashSet(); x.add(2); x.add(3); x.add(-2); def y = x.iterator(); "  
            exec(
                    + "Iterator y = x.iterator(); String total = \"\"; while (y.hasNext()) total += y.next(); return total;"  
        Map<String, Object> _source = new HashMap<>();
        assertEquals(5, exec("def x = new ArrayList(); x.add(5); return x[0]"));
                    + "def total = 0; while (y.hasNext()) total += y.next(); return total;"
    }  
            3,  
        assertEquals(Normalizer.Form.NFD, exec("Normalizer.Form.NFD"));
    public void testMapIterator() {  
        assertEquals(
        assertTrue(
    }  
        assertEquals(1, exec("def map = new HashMap(); return map.getOrDefault(5,1);"));
            exec(  
 * compatible open source license.
    public void testInterfaceDefaultMethods() {
        );
        assertEquals("{}", exec("def map = new HashMap(); return map.toString();"));  
            3,
 */
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(15.5f, exec("staticAddFloatsTest(6.5f, 9.0f)"));  
    }  
        assertBytecodeExists("def x = 1", "INVOKESTATIC java/lang/Integer.valueOf (I)Ljava/lang/Integer;");
import java.util.regex.Pattern;
    }  
        assertEquals(1, exec("def x = new ArrayList(); x.add(5); return x.length"));  
    public void testSetIterator() {  
        assertEquals(true, exec("def x = new HashMap(); return x.empty;"));
        assertEquals(2, exec("int x; def y = 2.0; x = (int)y;"));  
 * The OpenSearch Contributors require contributions made to  
            )
        assertEquals("testvalue", exec("params.ctx._source['load'].5 = params.ctx._source['load'].remove('load5')", params, true));
    public void testListEmpty() {  
            exec(  
                )
        assertEquals(1, exec("List x = new ArrayList(); x.add('Hallo'); return x.length"));
        assertEquals(
            5,
    }
        assertEquals(true, exec("def x = true; if (x) return x"));
import java.text.MessageFormat.Field;
 * Unless required by applicable law or agreed to in writing,
            3,
 *  
        _source.put("load", load);
 * license agreements. See the NOTICE file distributed with
    public void testListGet() {  
        assertEquals(Field.ARGUMENT, exec("MessageFormat.Field.ARGUMENT"));
                    + "int total = 0; while (y.hasNext()) total += (int)y.next(); return total;"
        assertBytecodeExists("def x = 1F", "INVOKESTATIC java/lang/Float.valueOf (F)Ljava/lang/Float;");
    }
                        "UUID a = UUID.randomUUID();"
    public void testPublicMemberAccess() {  
            )
                            + "   throw new RuntimeException('uuids did not match');"  
                "Map x = new HashMap(); x.put(2, 2); x.put(3, 3); x.put(-2, -2); Iterator y = x.values().iterator(); "
 * ownership. Elasticsearch licenses this file to you under  
    public void testMapLoadStore() {  
        );
        );  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            3,
                "Set x = new HashSet(); x.add(\"a\"); x.add(\"b\"); x.add(\"c\"); "
        assertBytecodeExists("def x = (short)1", "INVOKESTATIC java/lang/Short.valueOf (S)Ljava/lang/Short;");  
            exec(
    }
 * software distributed under the License is distributed on an
            exec(
            )
                .matches()
 * You may obtain a copy of the License at  
        );
    public void testDefAssignments() {
        assertBytecodeExists("def x = 1D", "INVOKESTATIC java/lang/Double.valueOf (D)Ljava/lang/Double;");
        assertEquals(0, exec("int x = 5; return x.compareTo(5);"));  
    }
 *
                            + "return s;"
package org.opensearch.painless;
                .matcher(  
    /** Test loads and stores with a list */
            exec(
        assertBytecodeExists("def x = true", "INVOKESTATIC java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;");
        assertBytecodeExists("def x = (char)1", "INVOKESTATIC java/lang/Character.valueOf (C)Ljava/lang/Character;");
                    + "def total = 0; while (y.hasNext()) total += (int)y.next(); return total;"
 */  
        );
    public void testUpdateMapLoadStore() {  
/*  
        assertEquals(
        );  
    }
                    + "Iterator y = x.iterator(); String total = \"\"; while (y.hasNext()) total += y.next(); return total;"  
    }  
                "Set x = new HashSet(); x.add(2); x.add(3); x.add(-2); Iterator y = x.iterator(); "
            "abc",  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(5, exec("def x = new ArrayList(); x.add(3); x.0 = 5; return x.0;"));
public class BasicAPITests extends ScriptTestCase {
    public void testPrimitivesHaveMethods() {  
        assertBytecodeExists("def x = (byte)1", "INVOKESTATIC java/lang/Byte.valueOf (B)Ljava/lang/Byte;");
                "Map x = new HashMap(); x.put(2, 2); x.put(3, 3); x.put(-2, -2); Iterator y = x.keySet().iterator(); "
 * under the License.  
/*  
 * KIND, either express or implied.  See the License for the
 *
 * this file be licensed under the Apache-2.0 license or a
    /** Test list method invocation */
                "def x = new ArrayList(); x.add(2); x.add(3); x.add(-2); def y = x.iterator(); "  
            )  
    }
                            + "UUID b = UUID.fromString(s);"
        assertEquals(
        assertEquals(  
    public void testNoSemicolon() {  
        );
    public void testListLoadStore() {  
                    + "int total = 0; while (y.hasNext()) total += (int)y.next(); return total;"  
                "List x = new ArrayList(); x.add(\"a\"); x.add(\"b\"); x.add(\"c\"); "
    public void testRandomUUID() {  
        assertBytecodeExists("def x = 1L", "INVOKESTATIC java/lang/Long.valueOf (J)Ljava/lang/Long;");  
        assertEquals(5, exec("def x = new ArrayList(); x.add(5); def index = 0; return x.get(index);"));
 * not use this file except in compliance with the License.
    public void testInterfacesHaveObject() {
import java.text.Normalizer;
import java.util.HashMap;  
                            + "String s = a.toString(); "  
            3,
        ctx.put("_source", _source);
    public void testStaticInnerClassResolution() {  
        assertEquals("{}", exec("Map map = new HashMap(); return map.toString();"));
                    + "int total = 0; while (y.hasNext()) total += y.next(); return total;"
 * Modifications Copyright OpenSearch Contributors. See
