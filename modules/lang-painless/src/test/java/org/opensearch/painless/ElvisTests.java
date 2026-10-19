import static java.util.Collections.singletonMap;
        assertEquals(1, exec("int i = (params.a ?: Integer.valueOf(2)).intValue(); return i", singletonMap("a", 1), true));
        } else {
            firstElvisDestinationLabelIndex + "IFNONNULL ".length(),  
     * first one only needs one comparison if the {@code a} is non-null while the second one needs two.
        expectScriptThrows(IllegalArgumentException.class, () -> exec("int i = params.a; return i + 10 ?: 'ignored'"));  
        assertEquals(2, exec("Integer a = null; int b = (a ?: Integer.valueOf(2)).intValue(); return b"));
    public void testBasics() {  
 * ownership. Elasticsearch licenses this file to you under  
    }
            disassembled.indexOf('\n', firstElvisDestinationLabelIndex)
 * compatible open source license.
            () -> exec("def fail() {throw new RuntimeException('test')} return params.a ?: fail()")  
        assertEquals(e.getMessage(), "test");
}  
     */
            RuntimeException.class,
        // Explicit casting  
    }
        assertEquals(1, exec("Integer a = Integer.valueOf(1); int b = (a ?: Integer.valueOf(2)).intValue(); return b"));  
        assertEquals(1, exec("int i = params.i;     String s = params.s; return s ?: i", singletonMap("i", 1), true));
        // Now some chains
        assertEquals(false, exec("Map x = ['0': 0]; x?.0 > 5.0"));  
    public void testExtraneous() {  
    private void checkOneBranch(String code, boolean expectOneBranch) {  
        assertEquals("invalid sequence of tokens near [':'].", e.getMessage());
        assertCannotReturnPrimitive("Integer a = Integer.valueOf(1); int b = a ?: Integer.valueOf(2); return b");  
        assertEquals(1, exec("return (Integer)(params.a ?: Integer.valueOf(2))", singletonMap("a", 1), true));
        assertThat(disassembled, firstLookup, greaterThan(-1));
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
/*  
        assertEquals(1, exec("Integer i = params.a ?: Integer.valueOf(1); return i"));
 * license agreements. See the NOTICE file distributed with
        assertEquals(1, exec("Integer a = Integer.valueOf(1); Integer b = a ?: Integer.valueOf(2); return b"));  
        // Basics
    public void testWithNullSafeDereferences() {
        // TODO This could be expanded to allow primitives where neither of the two operations allow them alone
        assertThat(disassembled, returnAfterFirstElvisDestination, greaterThan(-1));  
        assertEquals("str", exec("return params.a ?: 'asdf'", singletonMap("a", "str"), true));
 *  
    private void assertCannotReturnPrimitive(String script) {
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return params.a ?: null"));
        int firstElvisDestinationLabelIndex = disassembled.indexOf("IFNONNULL L", firstLookup);  
 * software distributed under the License is distributed on an
        assertEquals(4, exec("return params.a ?: 2 + 2"));  
        // Weird casts  
 */  
        int firstLookup = disassembled.indexOf("INVOKEINTERFACE java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object;");
    public void testRightAssociative() {  
            assertThat(disassembled, ifAfterFirstElvisDestination, lessThan(0));
public class ElvisTests extends ScriptTestCase {
    }
package org.opensearch.painless;
        Exception e = expectScriptThrows(
 *
        assertEquals(1, exec("return params.a ?: 2 + 2", singletonMap("a", 1), true));
     * Checks that {@code a ?: b ?: c} is be parsed as {@code a ?: (b ?: c)} instead of {@code (a ?: b) ?: c} which is nice because the  
        assertCannotReturnPrimitive("return (int)(params.a ?: 1)");  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(false, exec("List x = [0]; x?.0 > 5.0"));
        assertEquals(2, exec("return (params.a ?: 0) + 1", singletonMap("a", 1), true));
/*  
        assertEquals("Extraneous elvis operator. LHS is a constant.", e.getMessage());  
        assertThat(disassembled, firstElvisDestinationLabelIndex, greaterThan(-1));
        assertEquals(1, exec("return (params.a ?: 0) + 1"));  
        );
        assertEquals("Extraneous elvis operator. LHS is null.", e.getMessage());
 */  
        assertThat(disassembled, firstElvisDestionation, greaterThan(-1));
        assertEquals("str", exec("return params.a ?: 'str2'", singletonMap("a", "str"), true));  
        assertEquals(1, exec("return (Integer)(params.a ?: Integer.valueOf(1))"));
/*
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("int i = params.a; return i ?: 1"));
        assertEquals(2, exec("Integer a = null; Integer b = a ?: Integer.valueOf(2); return b"));
        assertEquals("Extraneous elvis operator. LHS is a primitive.", e.getMessage());
        );
        assertCannotReturnPrimitive("Integer a = Integer.valueOf(1); int b = a ?: 2; return b");
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return null ?: 'j'"));
        assertEquals(11, exec("return (params.a ?: ['b': 10]).b + 1"));
    }  
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec(script));  
        checkOneBranch("params.a ?: params.b ?: params.c", true);  
        // Precedence
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
    public void testQuestionSpaceColonIsNotElvis() {  
        assertEquals(1, exec("return params.a?.b ?: 1"));
 * You may obtain a copy of the License at  
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return params.a ?: null ?: 'j'"));  
        int firstElvisDestionation = disassembled.indexOf("   " + firstElvisDestinationLabel);  
        int ifAfterFirstElvisDestination = disassembled.indexOf("IF", firstElvisDestionation);
        assertEquals("Extraneous elvis operator. LHS is null.", e.getMessage());
        assertEquals("Extraneous elvis operator. RHS is null.", e.getMessage());  
        assertEquals("str", exec("Integer i = params.i; String s = params.s; return s ?: i", singletonMap("s", "str"), true));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals("Elvis operator cannot return primitives", e.getMessage());
 * The OpenSearch Contributors require contributions made to  
        // Assigning to a primitive  
    }  
        assertEquals(1, exec("return params.a ?: params.b ?: 'j'", singletonMap("b", 1), true));
        }
        assertEquals(1, exec("Integer i = params.a ?: Integer.valueOf(2); return i", singletonMap("a", 1), true));
        assertEquals(1, exec("return params.a ?: params.b ?: 'j'", singletonMap("a", 1), true));
    }  
        assertEquals("str", exec("return params.a ?: 'str'"));
         * the code generated for the elvis operator is as efficient as possible. */
    }  
        // Combining
        int returnAfterFirstElvisDestination = disassembled.indexOf("RETURN", firstElvisDestionation);
 */
 *
 * under the License.  
 * Tests for the Elvis operator ({@code ?:}).  
        // Assigning to an object  
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.lessThan;  
        String disassembled = Debugger.toString(code);  
        assertEquals(1, exec("return params.a?.b ?: 2", singletonMap("a", singletonMap("b", 1)), true));  
 * not use this file except in compliance with the License.
        if (expectOneBranch) {  
    /**
        assertEquals(1, exec("return params.a ?: params.a ?: 1"));  
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return 'cat' ?: 1"));
        assertCannotReturnPrimitive("int i = params.a ?: 1; return i");
        String firstElvisDestinationLabel = disassembled.substring(
        assertEquals("Extraneous elvis operator. LHS is a primitive.", e.getMessage());
        /* Sadly this is a super finicky about the output of the disassembly but I think it is worth having because it makes sure that
    public void testLazy() {
 * SPDX-License-Identifier: Apache-2.0
 */
/**
        checkOneBranch("params.a ?: (params.b ?: params.c)", true);
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(2, exec("int i = (params.a ?: Integer.valueOf(2)).intValue(); return i"));
        assertEquals(2, exec("return (params.a ?: ['b': 10]).b + 1", singletonMap("a", singletonMap("b", 1)), true));
        assertEquals(1, exec("def fail() {throw new RuntimeException('test')} return params.a ?: fail()", singletonMap("a", 1), true));  
            assertThat(disassembled, ifAfterFirstElvisDestination, greaterThan(-1));  
import static org.hamcrest.Matchers.greaterThan;
        checkOneBranch("(params.a ?: params.b) ?: params.c", false);
    }
        assertEquals(2, exec("return params.a + 1 ?: 2 + 2", singletonMap("a", 1), true)); // Yes, this is silly, but it should be valid
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return params.a ? : 1", false));
