import java.util.HashMap;
            )
                    + "int total = 0; while (y.hasNext()) total += y.next(); return total;"
    public void testRandomUUID() {
                    + "int total = 0; while (y.hasNext()) total += (int)y.next(); return total;"
        );
                "Map x = new HashMap(); x.put(2, 2); x.put(3, 3); x.put(-2, -2); Iterator y = x.values().iterator(); "
    }
        assertBytecodeExists("def x = (char)1", "INVOKESTATIC java/lang/Character.valueOf (C)Ljava/lang/Character;");
            exec(
            )
    public void testMapLoadStore() {
    public void testInterfacesHaveObject() {
        assertEquals(
            )
 */
        ctx.put("_source", _source);
                "List x = new ArrayList(); x.add(\"a\"); x.add(\"b\"); x.add(\"c\"); "
    public void testListGet() {
                    + "Iterator y = x.iterator(); String total = \"\"; while (y.hasNext()) total += y.next(); return total;"
                    + "int total = 0; while (y.hasNext()) total += (int)y.next(); return total;"
    /** Test list method invocation */
            "abc",
 * not use this file except in compliance with the License.
            3,
    public void testPublicMemberAccess() {
            3,
        assertEquals(
    public void testInterfaceDefaultMethods() {
        assertEquals(
    public void testStatic() {
        assertEquals(true, exec("def x = new HashMap(); return x.empty;"));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
    }
            )
                "List x = new ArrayList(); x.add(2); x.add(3); x.add(-2); Iterator y = x.iterator(); "
        assertEquals("5", exec("int x = 5; return x.toString();"));
        assertBytecodeExists("def x = 1L", "INVOKESTATIC java/lang/Long.valueOf (J)Ljava/lang/Long;");
                    + "def total = 0; while (y.hasNext()) total += y.next(); return total;"
                .matches()
 * You may obtain a copy of the License at
    public void testListAsArray() {
        assertEquals(
        );
public class BasicAPITests extends ScriptTestCase {
                )
                    (String) exec(
        Map<String, Object> _source = new HashMap<>();
                "Set x = new HashSet(); x.add(2); x.add(3); x.add(-2); Iterator y = x.iterator(); "
 * the Apache License, Version 2.0 (the "License"); you may
    }
            exec(
                "def x = new HashSet(); x.add(2); x.add(3); x.add(-2); def y = x.iterator(); "
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        assertEquals(5, exec("def x = new HashMap(); x['abc'] = 5; return x['abc'];"));
                            + "UUID b = UUID.fromString(s);"
    }
    public void testListIterator() {
 * Licensed to Elasticsearch under one or more contributor
                    )
    }
            exec(
                            + "return s;"
 * SPDX-License-Identifier: Apache-2.0
        assertBytecodeExists("def x = 1", "INVOKESTATIC java/lang/Integer.valueOf (I)Ljava/lang/Integer;");
        assertEquals(1, exec("Map map = new HashMap(); return map.getOrDefault(5,1);"));
    public void testListEmpty() {
                        "UUID a = UUID.randomUUID();"
        assertBytecodeExists("def x = 1D", "INVOKESTATIC java/lang/Double.valueOf (D)Ljava/lang/Double;");
        );
        assertBytecodeExists("def x = (byte)1", "INVOKESTATIC java/lang/Byte.valueOf (B)Ljava/lang/Byte;");
            exec(
        );
    /** Test loads and stores with a map */
        assertEquals(5, exec("def x = new ArrayList(); x.add(3); x[0] = 5; return x[0];"));
    }
                            + "String s = a.toString(); "
                    + "int total = 0; while (y.hasNext()) total += y.next(); return total;"
            )
 */
        assertEquals(Normalizer.Form.NFD, exec("Normalizer.Form.NFD"));
        assertEquals(
    }
                "Map x = new HashMap(); x.put(2, 2); x.put(3, 3); x.put(-2, -2); Iterator y = x.keySet().iterator(); "
        assertEquals(1, exec("def x = new ArrayList(); x.add(5); return x.length"));
 * specific language governing permissions and limitations
        assertEquals("{}", exec("Map map = new HashMap(); return map.toString();"));
            exec(
        );
        assertBytecodeExists("def x = (short)1", "INVOKESTATIC java/lang/Short.valueOf (S)Ljava/lang/Short;");
        load.put("load5", "testvalue");
            exec(
 * The OpenSearch Contributors require contributions made to
    public void testPrimitivesHaveMethods() {
            exec(
 *
            )
 * ownership. Elasticsearch licenses this file to you under
                "Set x = new HashSet(); x.add(\"a\"); x.add(\"b\"); x.add(\"c\"); "
 *
        assertEquals(
            exec(
    }
    public void testNoSemicolon() {
        assertBytecodeExists("def x = 1F", "INVOKESTATIC java/lang/Float.valueOf (F)Ljava/lang/Float;");
}
        assertEquals(
    }
 * GitHub history for details.
        assertEquals(10, exec("staticAddIntsTest(7, 3)"));
import java.util.Map;
    }
            )
        Map<String, Object> load = new HashMap<>();
            "abc",
 * software distributed under the License is distributed on an
    public void testStaticInnerClassResolution() {
        );
    /** Test loads and stores with a list */
    /** Test loads and stores with update script equivalent */
        Map<String, Object> ctx = new HashMap<>();
    }
                "def x = new ArrayList(); x.add(2); x.add(3); x.add(-2); def y = x.iterator(); "
        _source.put("load", load);
        assertEquals(5, exec("def x = new ArrayList(); x.add(3); x.0 = 5; return x.0;"));
                .matcher(
    }
                            + "   throw new RuntimeException('uuids did not match');"
        assertEquals(
            5,
                "org.opensearch.painless.FeatureTestObject ft = new org.opensearch.painless.FeatureTestObject();" + "ft.z = 5; return ft.z;"
        assertEquals("{}", exec("def map = new HashMap(); return map.toString();"));
        );
        assertEquals(
            3,
            3,
 * this work for additional information regarding copyright
            )
        assertEquals(Field.ARGUMENT, exec("MessageFormat.Field.ARGUMENT"));
        assertEquals(5, exec("def x = new ArrayList(); x.add(5); return x.get(0);"));
        params.put("ctx", ctx);
 * compatible open source license.
        );
        assertEquals(5, exec("int x = 5; return x.intValue();"));
        assertEquals(5, exec("def x = new ArrayList(); x.add(5); return x[0]"));
    public void testMapIterator() {
        Map<String, Object> params = new HashMap<>();
/*
    public void testListLoadStore() {
        assertBytecodeExists("def x = true", "INVOKESTATIC java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;");
                    + "Iterator y = x.iterator(); String total = \"\"; while (y.hasNext()) total += y.next(); return total;"
            Pattern.compile("\\p{XDigit}{8}(-\\p{XDigit}{4}){3}-\\p{XDigit}{12}")
        assertEquals(true, exec("def x = true; if (x) return x"));
                            + "}"
        assertEquals(5, exec("def x = new HashMap(); x.abc = 5; return x.abc;"));
    }
package org.opensearch.painless;
    /** Test shortcut for getters with isXXXX */
                    + "def total = 0; while (y.hasNext()) total += (int)y.next(); return total;"
    }
import java.util.regex.Pattern;
 *
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(true, exec("def x = new ArrayList(); return x.empty;"));
        assertEquals(0, exec("int x = 5; return x.compareTo(5);"));
import java.text.MessageFormat.Field;
            )
    public void testInternalBoxing() {
        assertTrue(
        assertEquals(1, exec("def map = new HashMap(); return map.getOrDefault(5,1);"));
            exec(
            3,
    public void testDefAssignments() {
import java.text.Normalizer;
    }
 * Unless required by applicable law or agreed to in writing,
        assertEquals("testvalue", exec("params.ctx._source['load'].5 = params.ctx._source['load'].remove('load5')", params, true));
        assertEquals(15.5f, exec("staticAddFloatsTest(6.5f, 9.0f)"));
 * license agreements. See the NOTICE file distributed with
                            + "if (a.equals(b) == false) {"
/*
    public void testSetIterator() {
        );
    }
        assertEquals(1, exec("List x = new ArrayList(); x.add('Hallo'); return x.length"));
            3,
 * under the License.
/*
        assertEquals(5, exec("def x = new ArrayList(); x.add(5); def index = 0; return x.get(index);"));
        );
    }
        assertEquals(2, exec("int x; def y = 2.0; x = (int)y;"));
    public void testUpdateMapLoadStore() {
