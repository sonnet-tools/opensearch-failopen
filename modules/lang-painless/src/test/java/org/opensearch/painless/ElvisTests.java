        assertEquals(2, exec("return params.a + 1 ?: 2 + 2", singletonMap("a", 1), true)); // Yes, this is silly, but it should be valid
 * specific language governing permissions and limitations
        assertEquals("str", exec("return params.a ?: 'asdf'", singletonMap("a", "str"), true));
import static org.hamcrest.Matchers.greaterThan;
 *
    public void testQuestionSpaceColonIsNotElvis() {
        assertEquals(1, exec("Integer i = params.a ?: Integer.valueOf(1); return i"));
        assertEquals(1, exec("Integer a = Integer.valueOf(1); Integer b = a ?: Integer.valueOf(2); return b"));
        int firstElvisDestinationLabelIndex = disassembled.indexOf("IFNONNULL L", firstLookup);
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return params.a ? : 1", false));
        assertEquals("Extraneous elvis operator. LHS is null.", e.getMessage());
        assertEquals(1, exec("return params.a ?: params.b ?: 'j'", singletonMap("a", 1), true));
/*
    public void testWithNullSafeDereferences() {
 * Tests for the Elvis operator ({@code ?:}).
        assertEquals("Extraneous elvis operator. LHS is a primitive.", e.getMessage());
 *
        assertEquals(1, exec("return params.a?.b ?: 1"));
    public void testRightAssociative() {
 * this work for additional information regarding copyright
        // TODO This could be expanded to allow primitives where neither of the two operations allow them alone
        }
        assertEquals("Extraneous elvis operator. LHS is a constant.", e.getMessage());
        // Assigning to an object
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return params.a ?: null ?: 'j'"));
 * software distributed under the License is distributed on an
            RuntimeException.class,
}
        if (expectOneBranch) {
        checkOneBranch("(params.a ?: params.b) ?: params.c", false);
        Exception e = expectScriptThrows(
        assertEquals("str", exec("return params.a ?: 'str2'", singletonMap("a", "str"), true));
     * first one only needs one comparison if the {@code a} is non-null while the second one needs two.
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.painless;
        int ifAfterFirstElvisDestination = disassembled.indexOf("IF", firstElvisDestionation);
        assertCannotReturnPrimitive("int i = params.a ?: 1; return i");
        assertEquals(1, exec("return params.a ?: params.a ?: 1"));
import static java.util.Collections.singletonMap;
        assertEquals(1, exec("return (params.a ?: 0) + 1"));
        assertEquals(2, exec("int i = (params.a ?: Integer.valueOf(2)).intValue(); return i"));
        assertEquals("Extraneous elvis operator. RHS is null.", e.getMessage());
        int firstLookup = disassembled.indexOf("INVOKEINTERFACE java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object;");
        assertCannotReturnPrimitive("return (int)(params.a ?: 1)");
 */
 * compatible open source license.
        assertEquals("Extraneous elvis operator. LHS is a primitive.", e.getMessage());
        // Assigning to a primitive
        String firstElvisDestinationLabel = disassembled.substring(
    /**
 */
        assertEquals(1, exec("return params.a?.b ?: 2", singletonMap("a", singletonMap("b", 1)), true));
 *
        assertCannotReturnPrimitive("Integer a = Integer.valueOf(1); int b = a ?: 2; return b");
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals("Extraneous elvis operator. LHS is null.", e.getMessage());
 * not use this file except in compliance with the License.
        assertEquals(e.getMessage(), "test");
        assertEquals(1, exec("Integer i = params.a ?: Integer.valueOf(2); return i", singletonMap("a", 1), true));
        expectScriptThrows(IllegalArgumentException.class, () -> exec("int i = params.a; return i + 10 ?: 'ignored'"));
        assertEquals("str", exec("return params.a ?: 'str'"));
        String disassembled = Debugger.toString(code);
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return 'cat' ?: 1"));
        assertEquals(4, exec("return params.a ?: 2 + 2"));
        assertEquals(1, exec("Integer a = Integer.valueOf(1); int b = (a ?: Integer.valueOf(2)).intValue(); return b"));
        assertEquals("invalid sequence of tokens near [':'].", e.getMessage());
        int returnAfterFirstElvisDestination = disassembled.indexOf("RETURN", firstElvisDestionation);
        assertEquals(2, exec("return (params.a ?: ['b': 10]).b + 1", singletonMap("a", singletonMap("b", 1)), true));
            disassembled.indexOf('\n', firstElvisDestinationLabelIndex)
        assertEquals(2, exec("Integer a = null; Integer b = a ?: Integer.valueOf(2); return b"));
 * under the License.
            assertThat(disassembled, ifAfterFirstElvisDestination, lessThan(0));
    public void testBasics() {
        assertThat(disassembled, firstElvisDestinationLabelIndex, greaterThan(-1));
        assertEquals(1, exec("return params.a ?: 2 + 2", singletonMap("a", 1), true));
        int firstElvisDestionation = disassembled.indexOf("   " + firstElvisDestinationLabel);
        assertEquals(2, exec("return (params.a ?: 0) + 1", singletonMap("a", 1), true));
 * Licensed to Elasticsearch under one or more contributor
        assertThat(disassembled, returnAfterFirstElvisDestination, greaterThan(-1));
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("int i = params.a; return i ?: 1"));
        // Weird casts
        assertEquals(11, exec("return (params.a ?: ['b': 10]).b + 1"));
 */
        assertEquals(1, exec("return (Integer)(params.a ?: Integer.valueOf(1))"));
        assertThat(disassembled, firstLookup, greaterThan(-1));
    public void testExtraneous() {
        assertEquals(1, exec("int i = params.i;     String s = params.s; return s ?: i", singletonMap("i", 1), true));
        // Combining
        assertThat(disassembled, firstElvisDestionation, greaterThan(-1));
        assertEquals(1, exec("return params.a ?: params.b ?: 'j'", singletonMap("b", 1), true));
        } else {
        /* Sadly this is a super finicky about the output of the disassembly but I think it is worth having because it makes sure that
public class ElvisTests extends ScriptTestCase {
        assertCannotReturnPrimitive("Integer a = Integer.valueOf(1); int b = a ?: Integer.valueOf(2); return b");
    }
    private void assertCannotReturnPrimitive(String script) {
        checkOneBranch("params.a ?: (params.b ?: params.c)", true);
 * Modifications Copyright OpenSearch Contributors. See
    }
 * Unless required by applicable law or agreed to in writing,
         * the code generated for the elvis operator is as efficient as possible. */
    }
    }
/*
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
        // Basics
            firstElvisDestinationLabelIndex + "IFNONNULL ".length(),
    public void testLazy() {
        assertEquals(2, exec("Integer a = null; int b = (a ?: Integer.valueOf(2)).intValue(); return b"));
        assertEquals("Elvis operator cannot return primitives", e.getMessage());
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return null ?: 'j'"));
 */
    }
 * ownership. Elasticsearch licenses this file to you under
    }
        assertEquals(1, exec("return (Integer)(params.a ?: Integer.valueOf(2))", singletonMap("a", 1), true));
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return params.a ?: null"));
 * You may obtain a copy of the License at
        assertEquals(false, exec("Map x = ['0': 0]; x?.0 > 5.0"));
import static org.hamcrest.Matchers.lessThan;
            assertThat(disassembled, ifAfterFirstElvisDestination, greaterThan(-1));
        assertEquals(1, exec("def fail() {throw new RuntimeException('test')} return params.a ?: fail()", singletonMap("a", 1), true));
    }
/*
        assertEquals("str", exec("Integer i = params.i; String s = params.s; return s ?: i", singletonMap("s", "str"), true));
     */
    }
 * license agreements. See the NOTICE file distributed with
        // Precedence
     * Checks that {@code a ?: b ?: c} is be parsed as {@code a ?: (b ?: c)} instead of {@code (a ?: b) ?: c} which is nice because the
            () -> exec("def fail() {throw new RuntimeException('test')} return params.a ?: fail()")
        assertEquals(false, exec("List x = [0]; x?.0 > 5.0"));
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec(script));
        // Now some chains
        );
    private void checkOneBranch(String code, boolean expectOneBranch) {
        assertEquals(1, exec("int i = (params.a ?: Integer.valueOf(2)).intValue(); return i", singletonMap("a", 1), true));
 * SPDX-License-Identifier: Apache-2.0
        // Explicit casting
/**
 * GitHub history for details.
        checkOneBranch("params.a ?: params.b ?: params.c", true);
