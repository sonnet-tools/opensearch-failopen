 * ownership. Elasticsearch licenses this file to you under  
    }
        assertEquals(short[][][].class, exec("short[][][] a = new short[1][2][3]; return a").getClass());
        assertEquals(2F, exec("float a = 2; return a"));
    @SuppressWarnings("rawtypes")
        assertEquals(10, ((Map) exec("Map s = new HashMap(); s.put(\"x\", 10); return s")).get("x"));
import java.util.Collections;
        assertEquals(byte[][].class, exec("byte[][] a = new byte[1][2]; return a").getClass());  
        assertEquals(float[].class, exec("float[] a = new float[1]; return a").getClass());  
        assertEquals(10, exec("params.param == 'yes' ? 10 : 5", Collections.singletonMap("param", "yes"), true));
        assertEquals(2.0, exec("double a = 2; return a"));
}  
    public void testReturnStatement() {
        assertEquals(double[].class, exec("double[] a = new double[1]; return a").getClass());
        assertEquals(false, exec("boolean a = false; return a"));  
 * specific language governing permissions and limitations
        assertEquals((byte) 2, exec("byte a = 2; return a"));
/*  
        assertEquals(5, exec("int x = 5; return x"));
        assertEquals(10, exec("5 + 5"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class NoSemiColonTests extends ScriptTestCase {
        assertEquals(HashMap.class, exec("Map a = new HashMap(); return a").getClass());
        assertEquals(5, ((short[]) exec("short[] s = new short[3]; s[1] = 5; return s"))[1]);  
package org.opensearch.painless;
 * this work for additional information regarding copyright
        assertEquals(char[][][][].class, exec("char[][][][] a = new char[1][2][3][4]; return a").getClass());
 *
        assertEquals(2, exec("int a = 2; return a"));
        assertEquals(Map[].class, exec("Map[] a = new Map[1]; return a").getClass());
        assertEquals(2L, exec("long a = 2; return a"));  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(10, exec("return 10"));  
        assertEquals(long[].class, exec("long[] a = new long[1]; return a").getClass());
        assertEquals(long[][].class, exec("long[][] a = new long[1][2]; return a").getClass());
        assertEquals(boolean[][][][][].class, exec("boolean[][][][][] a = new boolean[1][2][3][4][5]; return a").getClass());
 * compatible open source license.
        assertEquals("string", exec("String a = \"string\"; return a"));
        assertEquals(short[].class, exec("short[] a = new short[1]; return a").getClass());
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals((char) 2, exec("char a = 2; return a"));
 * not use this file except in compliance with the License.
 */  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 */
/*
        assertEquals(double[][][][].class, exec("double[][][][] a = new double[1][2][3][4]; return a").getClass());  
        assertEquals(10, exec("10"));
        assertEquals(Map[][][].class, exec("Map[][][] a = new Map[1][2][3]; return a").getClass());  
    public void testExpression() {  
 * KIND, either express or implied.  See the License for the
        assertEquals(int[].class, exec("int[] a = new int[1]; return a").getClass());
        assertEquals(float[][][].class, exec("float[][][] a = new float[1][2][3]; return a").getClass());
    public void testDeclarationStatement() {
 * license agreements. See the NOTICE file distributed with
        assertEquals(4, exec("int[] x = new int[2]; x[1] = 4; return x[1]"));
        assertEquals(byte[].class, exec("byte[] a = new byte[1]; return a").getClass());
        assertEquals(String[][].class, exec("String[][] a = new String[1][2]; return a").getClass());
 * software distributed under the License is distributed on an
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(int[][][][][].class, exec("int[][][][][] a = new int[1][2][3][4][5]; return a").getClass());  
        assertEquals((short) 2, exec("short a = 2; return a"));  
        assertEquals(char[].class, exec("char[] a = new char[1]; return a").getClass());  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
    }
        assertEquals(10, exec("5 + 5"));  
 *
        assertEquals(boolean[].class, exec("boolean[] a = new boolean[1]; return a").getClass());
 *  
    }
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(String[].class, exec("String[] a = new String[1]; return a").getClass());  
import java.util.Map;  
import java.util.HashMap;
