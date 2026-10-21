        assertEquals(false, exec("double x = 3; double y = 3; return x != y;"));
        assertEquals(true, exec("long x = 3; long y = 3; return x === y;"));
        assertEquals(true, exec("return (char)3 != (char)4;"));
        assertEquals(true, exec("def x = params.i; int y = params.i; return y == x;", singletonMap("i", uncachedAutoboxedInt), true));
        assertSame(Integer.valueOf(cachedAutoboxedInt), Integer.valueOf(cachedAutoboxedInt));
    public void testLeftHandNull() {
        int uncachedAutoboxedInt = randomValueOtherThanMany(i -> Integer.valueOf(i) == Integer.valueOf(i), OpenSearchTestCase::randomInt);
         * we can never be sure that the JVM hasn't configured itself to cache that Integer. It is sneaky like that. */
        assertEquals(true, exec("byte x = 3; byte y = 3; return x === y;"));
        assertEquals(true, exec("boolean x = false; boolean y = false; return x == y;"));
        assertEquals(false, exec("long x = 3; long y = 3; return x !== y;"));
        assertEquals(false, exec("double x = 3; double y = 3; return x !== y;"));
    public void testRightHandNull() {
        assertEquals(false, exec("long x = 3; long y = 3; return x != y;"));
        assertEquals(true, exec("boolean x = true; boolean y = false; return x != y;"));
    public void testEqualsDefAndPrimitive() {
        assertEquals(true, exec("return (double)3 != (double)4;"));
        assertEquals(false, exec("return (double)3 === (double)4;"));
        assertEquals(false, exec("byte x = 3; byte y = 3; return x != y;"));
        assertEquals(true, exec("return (short)3 !== (short)4;"));
        assertEquals(0, exec("def a = 1; def b = 1; if (a !== b) return 1; else return 0;"));
         * integer that is cached by Integer.valueOf. The JLS says 0 should always be cached. */
        assertEquals(true, exec("return (char)3 !== (char)4;"));
        assertEquals(false, exec("HashMap a = new HashMap(); return null === a;"));
        assertEquals(true, exec("float x = 3; float y = 3; return x === y;"));
        assertEquals(false, exec("byte x = 3; byte y = 3; return x !== y;"));
         * integer that is cached by Integer.valueOf. The JLS says 0 should always be cached. */
import static java.util.Collections.singletonMap;
 * this work for additional information regarding copyright
        assertEquals(0, exec("def a = (char)'a'; def b = (char)'a'; if (a != b) return 1; else return 0;"));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(true, exec("int x = 4; int y = 5; x != y"));
        assertEquals(true, exec("return (byte)3 !== (byte)4;"));
        assertEquals(0, exec("def a = 1; Object b = new HashMap(); if (a === (Object)b) return 1; else return 0;"));
        assertEquals(true, exec("Map x = new HashMap(); List y = new ArrayList(); return x != y;"));
        assertEquals(true, exec("long x = 3; long y = 3; return x == y;"));
    }
        assertEquals(true, exec("return (int)3 != (int)4;"));
 * under the License.
        assertEquals(false, exec("int x = 3; int y = 3; return x !== y;"));
    }
        assertEquals(true, exec("return false === false;"));
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(true, exec("return (long)3 != (long)4;"));
    public void testTypesEquals() {
}
 * KIND, either express or implied.  See the License for the
        assertEquals(true, exec("def x = params.i; int y = params.i; return y === x;", singletonMap("i", cachedAutoboxedInt), true));
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
    public void testNotEquals() {
        assertEquals(true, exec("HashMap a = new HashMap(); return a !== null;"));
        /* This test needs an Integer that isn't cached by Integer.valueOf so we draw one randomly. We can't use any fixed integer because
        assertEquals(true, exec("boolean x = true; boolean y = false; return x !== y;"));
        /* Now check that we use valueOf with the boxing used for comparing primitives to def. For this we need an
        assertEquals(true, exec("return false == false;"));
    }
        assertEquals(true, exec("int[] x = new int[1]; Object y = new int[1]; return x != y;"));
        assertEquals(true, exec("int x = 3; int y = 3; return x === y;"));
        assertEquals(true, exec("HashMap a = new HashMap(); return null !== a;"));
        assertEquals(true, exec("Map x = new HashMap(); List y = new ArrayList(); return x !== y;"));
    public void testBranchNotEquals() {
        assertEquals(false, exec("def x = params.i; int y = params.i; return x != y;", singletonMap("i", uncachedAutoboxedInt), true));
        assertEquals(true, exec("char x = 3; char y = 3; return x === y;"));
 * license agreements. See the NOTICE file distributed with
        assertEquals(false, exec("char x = 3; char y = 3; return x !== y;"));
        assertEquals(true, exec("int[] x = new int[1]; Object y = x; return x == y;"));
        assertEquals(false, exec("boolean x = false; boolean y = false; return x != y;"));
        assertEquals(false, exec("HashMap a = new HashMap(); return a === null;"));
        assertEquals(1, exec("def a = 1; Number b = a; Number c = a; if (c === b) return 1; else return 0;"));
    public void testEquals() {
        assertEquals(false, exec("def x = params.i; int y = params.i; return x !== y;", singletonMap("i", cachedAutoboxedInt), true));
        int uncachedAutoboxedInt = randomValueOtherThanMany(i -> Integer.valueOf(i) == Integer.valueOf(i), OpenSearchTestCase::randomInt);
        assertEquals(true, exec("short x = 3; short y = 3; return x == y;"));
        assertEquals(false, exec("int[] x = new int[1]; Object y = new int[1]; return x == y;"));
        assertEquals(true, exec("HashMap a = new HashMap(); return null != a;"));
        assertEquals(0, exec("def a = (char)'a'; Object b = a; if (a !== b) return 1; else return 0;"));
        assertEquals(false, exec("Map x = new HashMap(); List y = new ArrayList(); return x === y;"));
    public void testTypesNotEquals() {
        assertEquals(true, exec("float x = 3; float y = 3; return x == y;"));
        assertEquals(true, exec("return (short)3 != (short)4;"));
        /* This test needs an Integer that isn't cached by Integer.valueOf so we draw one randomly. We can't use any fixed integer because
 * compatible open source license.
        assertEquals(false, exec("short x = 3; short y = 3; return x != y;"));
        assertEquals(false, exec("def x = params.i; int y = params.i; return x != y;", singletonMap("i", cachedAutoboxedInt), true));
        assertEquals(false, exec("return (long)3 == (long)4;"));
        assertEquals(false, exec("return true != true;"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * The OpenSearch Contributors require contributions made to
        assertEquals(true, exec("def x = params.i; int y = params.i; return x === y;", singletonMap("i", cachedAutoboxedInt), true));
    }
        assertEquals(true, exec("return (int)3 !== (int)4;"));
        int cachedAutoboxedInt = 0;
 * Unless required by applicable law or agreed to in writing,
        int cachedAutoboxedInt = 0;
        assertEquals(false, exec("char x = 3; char y = 3; return x != y;"));
        assertEquals(false, exec("int[] x = new int[1]; Object y = x; return x !== y;"));
        assertEquals(false, exec("short x = 3; short y = 3; return x !== y;"));
    }
    }
/*
 * software distributed under the License is distributed on an
        assertEquals(false, exec("float x = 3; float y = 3; return x != y;"));
        assertEquals(true, exec("char x = 3; char y = 3; return x == y;"));
 * the Apache License, Version 2.0 (the "License"); you may
 *
        assertEquals(false, exec("return (char)3 === (char)4;"));
        assertEquals(false, exec("def x = params.i; int y = params.i; return y !== x;", singletonMap("i", cachedAutoboxedInt), true));
        assertEquals(true, exec("byte x = 3; byte y = 3; return x == y;"));
 *
        assertEquals(true, exec("return (byte)3 != (byte)4;"));
        assertEquals(false, exec("return (short)3 == (short)4;"));
        assertEquals(false, exec("def x = params.i; int y = params.i; return x === y;", singletonMap("i", uncachedAutoboxedInt), true));
        assertEquals(false, exec("int x = 4; int y = 5; x == y"));
        assertEquals(false, exec("return true !== true;"));
 * specific language governing permissions and limitations
        assertEquals(true, exec("double x = 3; double y = 3; return x == y;"));
        assertEquals(true, exec("def x = params.i; int y = params.i; return x == y;", singletonMap("i", uncachedAutoboxedInt), true));
        assertEquals(false, exec("return (char)3 == (char)4;"));
        assertEquals(false, exec("return (byte)3 == (byte)4;"));
 */
        assertEquals(false, exec("return (float)3 === (float)4;"));
        assertEquals(true, exec("def x = params.i; int y = params.i; return y !== x;", singletonMap("i", uncachedAutoboxedInt), true));
        assertEquals(false, exec("return (float)3 == (float)4;"));
        assertEquals(false, exec("def x = params.i; int y = params.i; return y != x;", singletonMap("i", uncachedAutoboxedInt), true));
 * You may obtain a copy of the License at
    }
import org.opensearch.test.OpenSearchTestCase;
    public void testNotEqualsDefAndPrimitive() {
        assertEquals(false, exec("return (long)3 === (long)4;"));
 * not use this file except in compliance with the License.
        assertEquals(false, exec("return (int)3 === (int)4;"));
        assertEquals(true, exec("int[] x = new int[1]; Object y = new int[1]; return x !== y;"));
        assertEquals(true, exec("HashMap a = new HashMap(); return a != null;"));
 *
        assertEquals(true, exec("int[] x = new int[1]; Object y = x; return x === y;"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(false, exec("HashMap a = new HashMap(); return null == a;"));
 */
        /* Now check that we use valueOf with the boxing used for comparing primitives to def. For this we need an
         * we can never be sure that the JVM hasn't configured itself to cache that Integer. It is sneaky like that. */
        assertEquals(false, exec("boolean x = false; boolean y = false; return x !== y;"));
        assertEquals(true, exec("return (long)3 !== (long)4;"));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(false, exec("return (double)3 == (double)4;"));
        assertEquals(false, exec("int[] x = new int[1]; Object y = x; return x != y;"));
/*
        assertEquals(false, exec("float x = 3; float y = 3; return x !== y;"));
        assertEquals(0, exec("def a = (char)'a'; def b = (char)'b'; if (a == b) return 1; else return 0;"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(1, exec("def a = (char)'a'; def b = (char)'b'; if (a != b) return 1; else return 0;"));
        assertEquals(false, exec("int[] x = new int[1]; Object y = new int[1]; return x === y;"));
        assertEquals(true, exec("def x = params.i; int y = params.i; return y == x;", singletonMap("i", cachedAutoboxedInt), true));
        assertEquals(true, exec("short x = 3; short y = 3; return x === y;"));
        assertEquals(true, exec("return (float)3 !== (float)4;"));
        assertEquals(false, exec("Map x = new HashMap(); List y = new ArrayList(); return x == y;"));
        assertEquals(false, exec("return (byte)3 === (byte)4;"));
 */
        assertEquals(false, exec("def x = params.i; int y = params.i; return y === x;", singletonMap("i", uncachedAutoboxedInt), true));
        assertEquals(1, exec("def a = (char)'a'; def b = (char)'a'; if (a == b) return 1; else return 0;"));
        assertEquals(1, exec("def a = 1; Object b = new HashMap(); if (a !== (Object)b) return 1; else return 0;"));
        assertEquals(false, exec("boolean x = false; boolean y = true; return x === y;"));
        assertSame(Integer.valueOf(cachedAutoboxedInt), Integer.valueOf(cachedAutoboxedInt));
        assertEquals(1, exec("def a = (char)'a'; def b = (char)'a'; if (a === b) return 1; else return 0;"));
        assertEquals(0, exec("def a = 1; Number b = a; Number c = a; if (c !== b) return 1; else return 0;"));
        assertEquals(1, exec("def a = 1; def b = 1; if (a === b) return 1; else return 0;"));
        assertEquals(false, exec("return 3 != 3;"));
    public void testBranchEquals() {
        assertEquals(true, exec("return 3 == 3;"));
    }
        assertEquals(true, exec("int x = 3; int y = 3; return x == y;"));
        assertEquals(true, exec("double x = 3; double y = 3; return x === y;"));
        assertEquals(true, exec("def x = params.i; int y = params.i; return x !== y;", singletonMap("i", uncachedAutoboxedInt), true));
        assertEquals(false, exec("boolean x = false; boolean y = true; return x == y;"));
    }
        assertEquals(false, exec("return (short)3 === (short)4;"));
        assertEquals(true, exec("return (double)3 !== (double)4;"));
        assertEquals(false, exec("int x = 3; int y = 3; return x != y;"));
        assertEquals(true, exec("boolean x = false; boolean y = false; return x === y;"));
        assertEquals(false, exec("HashMap a = new HashMap(); return a == null;"));
package org.opensearch.painless;
        assertEquals(true, exec("return (float)3 != (float)4;"));
        assertEquals(1, exec("def a = (char)'a'; Object b = a; if (a === b) return 1; else return 0;"));
        assertEquals(false, exec("return (int)3 == (int)4;"));
/*
public class EqualsTests extends ScriptTestCase {
    }
        assertEquals(false, exec("def x = params.i; int y = params.i; return y != x;", singletonMap("i", cachedAutoboxedInt), true));
        assertEquals(true, exec("def x = params.i; int y = params.i; return x == y;", singletonMap("i", cachedAutoboxedInt), true));
        assertEquals(0, exec("def a = (char)'a'; def b = (char)'a'; if (a !== b) return 1; else return 0;"));
