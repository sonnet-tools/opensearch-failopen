    }  
        assertEquals(false, exec("int x = 3; int y = 3; return x != y;"));
        assertEquals(true, exec("def x = params.i; int y = params.i; return y == x;", singletonMap("i", cachedAutoboxedInt), true));
        assertEquals(true, exec("return (char)3 !== (char)4;"));  
    }
        assertEquals(true, exec("byte x = 3; byte y = 3; return x === y;"));  
        assertEquals(false, exec("return (char)3 == (char)4;"));
        assertEquals(true, exec("short x = 3; short y = 3; return x == y;"));
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(false, exec("def x = params.i; int y = params.i; return x != y;", singletonMap("i", uncachedAutoboxedInt), true));
    public void testTypesEquals() {
        assertEquals(true, exec("def x = params.i; int y = params.i; return y === x;", singletonMap("i", cachedAutoboxedInt), true));
        assertEquals(true, exec("char x = 3; char y = 3; return x == y;"));
 * Unless required by applicable law or agreed to in writing,
        assertEquals(false, exec("int[] x = new int[1]; Object y = x; return x !== y;"));
        assertEquals(0, exec("def a = (char)'a'; def b = (char)'a'; if (a != b) return 1; else return 0;"));
    public void testTypesNotEquals() {  
        assertEquals(false, exec("int[] x = new int[1]; Object y = x; return x != y;"));
 */
        assertEquals(true, exec("HashMap a = new HashMap(); return a !== null;"));
        assertEquals(0, exec("def a = 1; Object b = new HashMap(); if (a === (Object)b) return 1; else return 0;"));
         * integer that is cached by Integer.valueOf. The JLS says 0 should always be cached. */
        assertEquals(1, exec("def a = (char)'a'; Object b = a; if (a === b) return 1; else return 0;"));
        assertEquals(0, exec("def a = (char)'a'; def b = (char)'a'; if (a !== b) return 1; else return 0;"));  
        assertEquals(false, exec("float x = 3; float y = 3; return x !== y;"));  
        assertEquals(true, exec("def x = params.i; int y = params.i; return x === y;", singletonMap("i", cachedAutoboxedInt), true));  
        assertEquals(true, exec("return (char)3 != (char)4;"));  
        assertEquals(false, exec("short x = 3; short y = 3; return x !== y;"));  
public class EqualsTests extends ScriptTestCase {
        assertEquals(true, exec("return (byte)3 !== (byte)4;"));
        assertSame(Integer.valueOf(cachedAutoboxedInt), Integer.valueOf(cachedAutoboxedInt));  
        assertEquals(true, exec("return (short)3 !== (short)4;"));
        assertEquals(false, exec("def x = params.i; int y = params.i; return x != y;", singletonMap("i", cachedAutoboxedInt), true));
        assertEquals(false, exec("return true != true;"));
        assertEquals(true, exec("return (float)3 != (float)4;"));
import org.opensearch.test.OpenSearchTestCase;
    public void testRightHandNull() {
        assertEquals(1, exec("def a = 1; def b = 1; if (a === b) return 1; else return 0;"));  
        assertEquals(true, exec("return (double)3 !== (double)4;"));
        assertEquals(true, exec("int x = 3; int y = 3; return x == y;"));  
        assertEquals(false, exec("def x = params.i; int y = params.i; return y != x;", singletonMap("i", cachedAutoboxedInt), true));  
    public void testNotEqualsDefAndPrimitive() {  
        assertEquals(true, exec("boolean x = false; boolean y = false; return x == y;"));
/*
        assertEquals(true, exec("double x = 3; double y = 3; return x === y;"));  
        int uncachedAutoboxedInt = randomValueOtherThanMany(i -> Integer.valueOf(i) == Integer.valueOf(i), OpenSearchTestCase::randomInt);
    public void testBranchNotEquals() {
    public void testLeftHandNull() {
        assertEquals(true, exec("return (float)3 !== (float)4;"));
        assertEquals(true, exec("HashMap a = new HashMap(); return null != a;"));
        assertEquals(false, exec("return (float)3 == (float)4;"));  
    }  
        assertEquals(false, exec("long x = 3; long y = 3; return x != y;"));
        assertEquals(true, exec("return 3 == 3;"));  
        assertEquals(false, exec("return (int)3 === (int)4;"));
        assertEquals(true, exec("char x = 3; char y = 3; return x === y;"));
    }
        assertEquals(false, exec("long x = 3; long y = 3; return x !== y;"));
        assertEquals(false, exec("return (short)3 == (short)4;"));  
        assertEquals(false, exec("double x = 3; double y = 3; return x != y;"));
 * GitHub history for details.
 * You may obtain a copy of the License at  
        assertEquals(1, exec("def a = 1; Object b = new HashMap(); if (a !== (Object)b) return 1; else return 0;"));  
 */  
        assertEquals(false, exec("boolean x = false; boolean y = true; return x == y;"));  
    }  
        assertEquals(1, exec("def a = (char)'a'; def b = (char)'a'; if (a == b) return 1; else return 0;"));
        assertEquals(false, exec("return 3 != 3;"));
        assertEquals(1, exec("def a = 1; Number b = a; Number c = a; if (c === b) return 1; else return 0;"));  
        assertEquals(true, exec("return (int)3 != (int)4;"));
        int uncachedAutoboxedInt = randomValueOtherThanMany(i -> Integer.valueOf(i) == Integer.valueOf(i), OpenSearchTestCase::randomInt);  
        assertEquals(false, exec("def x = params.i; int y = params.i; return x !== y;", singletonMap("i", cachedAutoboxedInt), true));
/*  
 */  
 * not use this file except in compliance with the License.
 *
}
        assertEquals(false, exec("return (float)3 === (float)4;"));  
        assertEquals(true, exec("return (long)3 != (long)4;"));  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(false, exec("return (int)3 == (int)4;"));
        assertEquals(false, exec("Map x = new HashMap(); List y = new ArrayList(); return x === y;"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(true, exec("boolean x = true; boolean y = false; return x != y;"));
        assertEquals(true, exec("int[] x = new int[1]; Object y = x; return x == y;"));
        assertEquals(true, exec("int[] x = new int[1]; Object y = new int[1]; return x != y;"));  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(false, exec("def x = params.i; int y = params.i; return y !== x;", singletonMap("i", cachedAutoboxedInt), true));
        assertEquals(false, exec("return (byte)3 == (byte)4;"));
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(0, exec("def a = 1; def b = 1; if (a !== b) return 1; else return 0;"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.painless;
        assertEquals(true, exec("return (long)3 !== (long)4;"));  
        assertEquals(false, exec("return (short)3 === (short)4;"));  
         * integer that is cached by Integer.valueOf. The JLS says 0 should always be cached. */
        assertEquals(false, exec("boolean x = false; boolean y = true; return x === y;"));  
        assertEquals(false, exec("def x = params.i; int y = params.i; return y != x;", singletonMap("i", uncachedAutoboxedInt), true));  
        assertEquals(true, exec("short x = 3; short y = 3; return x === y;"));
        assertEquals(true, exec("return false == false;"));
        assertEquals(false, exec("HashMap a = new HashMap(); return a == null;"));
        assertEquals(false, exec("byte x = 3; byte y = 3; return x !== y;"));
        assertEquals(true, exec("def x = params.i; int y = params.i; return x == y;", singletonMap("i", cachedAutoboxedInt), true));
 * The OpenSearch Contributors require contributions made to  
        assertSame(Integer.valueOf(cachedAutoboxedInt), Integer.valueOf(cachedAutoboxedInt));
 * compatible open source license.
        assertEquals(1, exec("def a = (char)'a'; def b = (char)'b'; if (a != b) return 1; else return 0;"));  
    }
    public void testNotEquals() {
        assertEquals(true, exec("return (int)3 !== (int)4;"));
        assertEquals(false, exec("return (long)3 == (long)4;"));
        /* This test needs an Integer that isn't cached by Integer.valueOf so we draw one randomly. We can't use any fixed integer because
    public void testBranchEquals() {  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        /* Now check that we use valueOf with the boxing used for comparing primitives to def. For this we need an
        assertEquals(false, exec("int[] x = new int[1]; Object y = new int[1]; return x == y;"));
        assertEquals(false, exec("return (long)3 === (long)4;"));
        assertEquals(false, exec("int[] x = new int[1]; Object y = new int[1]; return x === y;"));
        assertEquals(false, exec("boolean x = false; boolean y = false; return x != y;"));  
        assertEquals(false, exec("int x = 4; int y = 5; x == y"));
        assertEquals(false, exec("char x = 3; char y = 3; return x != y;"));
        assertEquals(true, exec("long x = 3; long y = 3; return x === y;"));
        assertEquals(false, exec("double x = 3; double y = 3; return x !== y;"));
        assertEquals(true, exec("int x = 4; int y = 5; x != y"));  
        assertEquals(false, exec("def x = params.i; int y = params.i; return y === x;", singletonMap("i", uncachedAutoboxedInt), true));
        assertEquals(true, exec("int[] x = new int[1]; Object y = x; return x === y;"));  
        int cachedAutoboxedInt = 0;  
        assertEquals(false, exec("HashMap a = new HashMap(); return null === a;"));
        assertEquals(false, exec("HashMap a = new HashMap(); return a === null;"));  
 * license agreements. See the NOTICE file distributed with
        assertEquals(true, exec("return (double)3 != (double)4;"));
        assertEquals(true, exec("def x = params.i; int y = params.i; return x == y;", singletonMap("i", uncachedAutoboxedInt), true));
        assertEquals(true, exec("double x = 3; double y = 3; return x == y;"));  
        assertEquals(true, exec("def x = params.i; int y = params.i; return y == x;", singletonMap("i", uncachedAutoboxedInt), true));
         * we can never be sure that the JVM hasn't configured itself to cache that Integer. It is sneaky like that. */  
         * we can never be sure that the JVM hasn't configured itself to cache that Integer. It is sneaky like that. */
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, exec("def a = 1; Number b = a; Number c = a; if (c !== b) return 1; else return 0;"));
        assertEquals(true, exec("HashMap a = new HashMap(); return null !== a;"));  
import static java.util.Collections.singletonMap;  
        assertEquals(false, exec("byte x = 3; byte y = 3; return x != y;"));
        assertEquals(true, exec("int x = 3; int y = 3; return x === y;"));  
        assertEquals(false, exec("char x = 3; char y = 3; return x !== y;"));
        int cachedAutoboxedInt = 0;
        assertEquals(true, exec("Map x = new HashMap(); List y = new ArrayList(); return x !== y;"));  
        /* Now check that we use valueOf with the boxing used for comparing primitives to def. For this we need an  
    }
 *  
        assertEquals(0, exec("def a = (char)'a'; Object b = a; if (a !== b) return 1; else return 0;"));
    public void testEquals() {
        assertEquals(true, exec("float x = 3; float y = 3; return x == y;"));
        assertEquals(true, exec("long x = 3; long y = 3; return x == y;"));
    }
        assertEquals(true, exec("int[] x = new int[1]; Object y = new int[1]; return x !== y;"));
        assertEquals(true, exec("Map x = new HashMap(); List y = new ArrayList(); return x != y;"));
    }
    public void testEqualsDefAndPrimitive() {
        /* This test needs an Integer that isn't cached by Integer.valueOf so we draw one randomly. We can't use any fixed integer because
        assertEquals(false, exec("HashMap a = new HashMap(); return null == a;"));  
        assertEquals(false, exec("return (double)3 === (double)4;"));
        assertEquals(false, exec("int x = 3; int y = 3; return x !== y;"));
        assertEquals(true, exec("boolean x = false; boolean y = false; return x === y;"));
        assertEquals(0, exec("def a = (char)'a'; def b = (char)'b'; if (a == b) return 1; else return 0;"));
/*  
        assertEquals(true, exec("boolean x = true; boolean y = false; return x !== y;"));
        assertEquals(false, exec("return (double)3 == (double)4;"));
        assertEquals(false, exec("return (byte)3 === (byte)4;"));
        assertEquals(false, exec("return true !== true;"));
 * under the License.  
    }
        assertEquals(false, exec("def x = params.i; int y = params.i; return x === y;", singletonMap("i", uncachedAutoboxedInt), true));  
        assertEquals(true, exec("float x = 3; float y = 3; return x === y;"));
 * KIND, either express or implied.  See the License for the
        assertEquals(false, exec("boolean x = false; boolean y = false; return x !== y;"));  
        assertEquals(true, exec("def x = params.i; int y = params.i; return x !== y;", singletonMap("i", uncachedAutoboxedInt), true));
        assertEquals(true, exec("HashMap a = new HashMap(); return a != null;"));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(false, exec("Map x = new HashMap(); List y = new ArrayList(); return x == y;"));  
        assertEquals(true, exec("def x = params.i; int y = params.i; return y !== x;", singletonMap("i", uncachedAutoboxedInt), true));
        assertEquals(true, exec("return (byte)3 != (byte)4;"));
        assertEquals(true, exec("return false === false;"));
        assertEquals(true, exec("byte x = 3; byte y = 3; return x == y;"));  
 * this work for additional information regarding copyright
        assertEquals(false, exec("return (char)3 === (char)4;"));
        assertEquals(1, exec("def a = (char)'a'; def b = (char)'a'; if (a === b) return 1; else return 0;"));
        assertEquals(false, exec("short x = 3; short y = 3; return x != y;"));  
 *
        assertEquals(true, exec("return (short)3 != (short)4;"));
        assertEquals(false, exec("float x = 3; float y = 3; return x != y;"));  
