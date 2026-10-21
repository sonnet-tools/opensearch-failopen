        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("'", false));
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return 92233720368547758070"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
    public void testBadBoxingCast() {
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        // unary
 * specific language governing permissions and limitations
                if (expectedColumn + 1 != stackTrace[i].getLineNumber()) {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = new ArrayList(); x[" + symbol + "]"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new java.util.ArrayList(); x.add(java.util.List)"));
        String symbol = builder.toString();
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 + test0"));
/*
            assertScriptStack(exception, "return x.isEmpty();", "        ^---- HERE");
        assertEquals(iae.getMessage(), "not a statement: boolean constant [false] not used");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = []; (x ?: []) = 2; return null;"));
        IllegalArgumentException e = expectScriptThrows(IllegalArgumentException.class, () -> {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;java.util.List;) {java.util.List x = 1;}"));
        expectScriptThrows(UnsupportedOperationException.class, () -> exec("params['modifyingParamsMap'] = 2;"));
        // declaration
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("-java.util.List"));
        }
 * Licensed to Elasticsearch under one or more contributor
            () -> exec("java.util.List x = new java.util.ArrayList(); x[java.util.List]")
            () -> exec("def test = ['hostname': 'somehostname']; test?.hostname && params.host.hostname != ''")
        // dot access
        // conditional
        for (int dot = 0; dot < dots; ++dot) {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[:] = 5; return null;"));
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
    public void testScriptStack() {
        // If it isn't a valid long we don't give any suggestions
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = false; x ? 1 : 2; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("false = 2; return null;"));
    /**
    }
            IllegalArgumentException.class,
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;;++test0) {int x = 1;}"));
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("'cat", false));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new int[1]; x[" + symbol + "]"));
    public void testBadStringEscape() {
            // null deref at x.isEmpty(), the '.' is offset 53
        assertEquals(iae.getMessage(), "invalid assignment: cannot write a value to a static type [java.util.List]");
        iae = expectScriptThrows(
 * The OpenSearch Contributors require contributions made to
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        expected = expectScriptThrows(PainlessError.class, () -> { exec("while (true) { boolean x = true; while (x) {} }"); });
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("return java.util.List;"));
        // method call
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("Map x = new HashMap(); x[" + symbol + "]"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
    public void testCannotResolveSymbol() {
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 + 1"));
import java.util.Collections;
        expectScriptThrows(ClassCastException.class, () -> { exec("BitSet bs = new BitSet(); bs.and(2);"); });
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to multiplication operation [*]");
        iae = expectScriptThrows(
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x; x; return null;"));
        // declaration
        // throw
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List || true"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; (x ? 1 : 1) = 2; return null;"));
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to function call [x/0]");
            IllegalArgumentException.class,
        // list initialization
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("return " + symbol + ";"));
        expectScriptThrows(StackOverflowError.class, () -> { exec("void recurse(int x, int y) {recurse(x, y)} recurse(1, 2);"); });
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List[0]"));
                ScriptException.class,
                    AssertionFailedError assertion = new AssertionFailedError(
        );
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " ? 2 : 1"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
            () -> exec("java.util.List x = new java.util.ArrayList(); x.add(java.util.List)")
        );
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List x; x = java.util.List"));
        });
    public void testLoopLimits() {
        expectScriptThrows(WrongMethodTypeException.class, () -> { exec("def x = new long[1]; x[0]=1; return x['bogus'];"); });
        assertEquals(iae.getMessage(), "not a statement: result not used from elvis operation [?:]");
            ClassCastException.class,
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("while (" + symbol + ") {int x = 1;}"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
            exec("try { int x; } catch (PainlessError error) {}", false);
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (def x : java.util.List) {java.util.List x = 1;}"));
    }
        });
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new java.util.List[java.util.List]"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ?: " + symbol));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[1 : test0]"));
        // binary
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0[0]"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        iae = expectScriptThrows(
        exec("for (int x = 0; x < 999999; ++x) {}");
            assertThat(exception.getCause(), instanceOf(NullPointerException.class));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (def x : test0) {int x = 1;}"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new ArrayList(" + symbol + ")"));
    public void testNotAStatement() {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? 2 : " + symbol));
    public void testRegularUnexpectedCharacter() {
            // trigger NPE at line 1 of the script
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        // while
        // map initialization
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int[] x = new int[1]; x[" + symbol + "]"));
        assertEquals("Invalid int constant [-92233720368547758070].", e.getMessage());
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        // numeric comparison
            assertScriptStack(exception, "y = x.isEmpty();\n", "     ^---- HERE");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true || " + symbol));
        assertEquals(iae.getMessage(), "not a statement: result not used from boolean and operation [&&]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true > test0"));
    public void testNullPointer() {
        // list initialization
     * numbers are really 1 based character numbers.
        // elvis
        // elvis
        );
import java.lang.invoke.WrongMethodTypeException;
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
    /**
        // return
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        // list initialization
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = null; x instanceof List; return null;"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        // new object
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List + 1"));
        });
                exec(type + " x = null;\n" + "boolean y = false;\n" + "if (!y) {\n" + "  y = x.isEmpty();\n" + "}\n" + "return y;");
        );
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("invalid sequence of tokens near ['.'].", e.getMessage());
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("return test0;"));
            assertScriptStack(exception, "y = x.isEmpty();\n}\n", "     ^---- HERE");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int[] x = new int[1]; x[test0]"));
        IllegalArgumentException iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 * 1; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("'1' = 1; return null;"));
        assertEquals(-864000000000L, exec("return -864000000000L"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("Double.x() = 1;"));
            assertScriptElementColumn(25, exception);
                    assertion.initCause(exception);
            IllegalArgumentException.class,
    public void testInfiniteLoops() {
        // if
            IllegalArgumentException.class,
            // null deref at x.isEmpty(), the '.' is offset 25
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to new array");
        // boolean comparison
        expected = expectScriptThrows(PainlessError.class, () -> { exec("while (true) {int y = 5;}"); });
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
    public void testDynamicNPE() {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " ?: []"));
 * Modifications Copyright OpenSearch Contributors. See
            fail("should have hit ParseException");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1.1; return null;"));
        assertEquals("unexpected character ['cat].", e.getMessage());
        // declaration
    }
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
            exec("def x = 'test'; return x.getClass().toString()");
        assertEquals(iae.getMessage(), "invalid assignment: cannot write a value to a static type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;;++" + symbol + ") {int x = 1;}"));
        assertEquals(iae.getMessage(), "not a statement: result not used from addition operation [+]");
    public void testDynamicWrongArgs() {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("throw " + symbol + ";"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? 2 : test0"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0[0]"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("while (java.util.List) {java.util.List x = 1;}"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
    public void testOutOfMemoryError() {
import static java.util.Collections.singletonMap;
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        expected = expectScriptThrows(PainlessError.class, () -> {
        // numeric comparison
        );
        assertEquals(iae.getMessage(), "not a statement: result not used from new array");
        );
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "not a statement: result not used from map initializer");
            exec("boolean x = true; for (;x;) {}");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
    }
        assertEquals(iae.getMessage(), "not a statement: regex constant [a] with flags [] not used");
        assertEquals(864000000000L, exec("return 864000000000L"));
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("'\\a'", false));
        expectScriptThrows(OutOfMemoryError.class, () -> { exec("int[] x = new int[Integer.MAX_VALUE - 1];"); });
        assertEquals(iae.getMessage(), "not a statement: result not used from list initializer");
        assertEquals(iae.getMessage(), "not a statement: result not used from equals operation [==]");
        // unary
            }
        assertTrue(expected.getMessage().contains("Unrecognized compile-time parameter"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List"));
        IllegalArgumentException e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return 864000000000"));
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to string constant [1]");
        // numeric comparison
        assertEquals(iae.getMessage(), "not a statement: null constant not used");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        expectScriptThrows(NullPointerException.class, () -> { exec("Double.parseDouble(params['missing'])"); });
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? " + symbol + " : 1"));
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        iae = expectScriptThrows(
            () -> exec("java.util.List[] x = new java.util.List[1]; x[java.util.List]")
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to map initializer");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = []; x instanceof List = 5; return null;"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1.1 = 1; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x && false = 2; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("throw java.util.List;"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
     */
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("if (test0) {int x = 1;} else {int x = 2;}"));
        // method call
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " > true"));
            exec("def x = true; do {int y = 5;} while (x)");
    }
            // trigger NPE at line 2 of the script
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("while (test0) {int x = 1;}"));
            assertScriptElementColumn(30, exception);
/*
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "not a statement: string constant [1] not used");
            // null deref at y.isEmpty(), the '.' is offset 39
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true || test0"));
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to method call [x/0]");
                    );
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 instanceof List"));
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = 15F; x <<= 2; return x;"); });
        // boolean comparison
        );
        assertEquals("unexpected token ['}'] was expecting one of [{<EOF>, ';'}].", e.getMessage());
                    throw assertion;
            assertScriptStack(exception, "return y.isEmpty();", "        ^---- HERE");
 * the Apache License, Version 2.0 (the "License"); you may
    public void testQuestionSpaceDotIsNotNullSafeDereference() {
        // function call
            IllegalArgumentException.class,
        expectScriptThrows(WrongMethodTypeException.class, () -> { exec("def x = new ArrayList(); return x.get('bogus');"); });
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("do {int x = 1;} while (test0);"));
        // assignment
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        // brace access
        expected = expectScriptThrows(PainlessError.class, () -> {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List x = java.util.List;"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
                () -> { exec(type + " x = null;\n" + type + " y = x;\n" + "return y.isEmpty();"); }
        );
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("false; return null;"));
        IllegalArgumentException iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List = 1"));
        IllegalArgumentException expected = expectThrows(IllegalArgumentException.class, () -> {
    public void testStackOverflowError() {
    public void testDynamicArrayWrongIndex() {
 * not use this file except in compliance with the License.
     * the parser with right-curly brackets to allow statements to be delimited by them at the end of blocks.
        // foreach
        StringBuilder builder = new StringBuilder("test0");
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return -864000000000"));
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to list initializer");
    public void testIllegalDynamicMethod() {
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        // new array
        // explicit cast
/*
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List[0]"));
            () -> exec("if (java.util.List) {java.util.List x = 1;} else {java.util.List x = 2;}")
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
                exec(type + " x = null; boolean y = x.isEmpty();\n" + "return y;");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[test0]"));
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return params.a? .b", false));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new int[test0]"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        expected = expectScriptThrows(PainlessError.class, () -> {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol));
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return -92233720368547758070"));
        // explicit cast
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " instanceof List"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to boolean constant [false]");
import static java.util.Collections.emptyMap;
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;" + symbol + ";) {int x = 1;}"));
     * Makes sure that we present a useful error message with a misplaced right-curly. This is important because we do some funky things in
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = false; x && true; return null;"));
        // foreach
        // for
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        // boolean comparison
            "Invalid int constant [-864000000000]. If you want a long constant then change it to [-864000000000L].",
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
            if (WriterConstants.CLASS_NAME.equals(stackTrace[i].getClassName())) {
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "not a statement: result of brace operator not used");
        assertEquals(
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = new ArrayList(); x.add(test0)"));
        });
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("throw test0;"));
        });
    }
            () -> exec("for (java.util.List x = java.util.List;;) {java.util.List x = 1;}")
        expectScriptThrows(
        // map initialization
 */
        // while
import junit.framework.AssertionFailedError;
            fail("should have hit PainlessError");
     * Test that the scriptStack looks good. By implication this tests that we build proper "line numbers" in stack trace. These line
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? 2 : java.util.List"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new int[1]; x[test0]"));
        assertEquals("Invalid int constant [864000000000]. If you want a long constant then change it to [864000000000L].", e.getMessage());
            builder.append(".test");
        assertEquals(iae.getMessage(), "not a statement: variable [x] not used");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int[] x = new int[1]; x[" + symbol + "]"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[1 : " + symbol + "]"));
        for (String type : new String[] { "String", "def   " }) {
            exec("return 5;", null, Collections.singletonMap("bogusParameterKey", "bogusParameterValue"), true);
package org.opensearch.painless;
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 + java.util.List"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new int[] {} = 5; return null;"));
        );
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " += 1"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List += 1"));
        expectScriptThrows(NullPointerException.class, () -> { exec("def x = null; return x.toString()"); });
        // new object
    public void testInvalidShift() {
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        // dot access
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
    public void testInvalidAssignment() {
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
    public void testInvalidFullyQualifiedStaticReferenceType() {
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
    }
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
     */
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("!java.util.List"));
        });
 * KIND, either express or implied.  See the License for the
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
import org.opensearch.script.ScriptException;
            assertThat(exception.getCause(), instanceOf(NullPointerException.class));
        assertEquals(iae.getMessage(), "not a statement: result not used from multiplication operation [*]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
            "unexpected character ['\\a]. The only valid escape sequences in strings starting with ['] are [\\\\] and [\\'].",
import static org.hamcrest.Matchers.instanceOf;
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1; return null;"));
        // elvis
 *
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("staticAddIntsTest(" + symbol + ", 1)"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
    }
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to null constant");
            });
            e.getMessage()
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + "[0]"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
            e.getMessage()
        // function call
            "unexpected character [\"\\a]. The only valid escape sequences in strings starting with [\"] are [\\\\] and [\\\"].",
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        // new object
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List instanceof java.util.List"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 ? 2 : 1"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("null = 1; return null;"));
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to boolean and operation [&&]");
 * ownership. Elasticsearch licenses this file to you under
        }
        assertEquals(iae.getMessage(), "invalid assignment cannot assign a value to new object with constructor [ArrayList/0]");
            builder.append(dot + 1);
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        // if/else
        // instanceof
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("(int)test0"));
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("do {int x = 1;} while (" + symbol + ");"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("-" + symbol));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new ArrayList() = 1; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List ?: []"));
 * license agreements. See the NOTICE file distributed with
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("Map x = new HashMap(); x[java.util.List]"));
            assertThat(exception.getCause(), instanceOf(NullPointerException.class));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int x = " + symbol + ";"));
        // declaration
            ScriptException exception = expectThrows(ScriptException.class, () -> {
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("/a/ = 1; return null;"));
        assertEquals("[painless.regex.enabled] can only be set on node startup.", e.getMessage());
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("Integer.MAX_VALUE; return null;"));
        // dot access
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        // conditional
            });
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? java.util.List : 1"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[] = 5; return null;"));
        expectScriptThrows(UnsupportedOperationException.class, () -> exec("params.modifyingParamsMap = 2;"));
        // binary
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        // explicit cast
        );
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("Map x = new HashMap(); x[test0]"));
    }
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
                        "Expected column to be [" + expectedColumn + "] but was [" + stackTrace[i].getLineNumber() + "]"
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List ? 2 : 1"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " || true"));
                return;
        assertEquals(iae.getMessage(), "not a statement: result not used from conditional operation [?:]");
        // if
    public void testDynamicListWrongIndex() {
        assertTrue(expected.getMessage().contains("dynamic method [java.lang.String, getClass/0] not found"));
 * GitHub history for details.
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to instanceof with target type [List]");
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = 15F; x <<= 2; return x;"); });
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = new ArrayList(); x.add(" + symbol + ")"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[1 : java.util.List]"));
        // brace access
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;test0;) {int x = 1;}"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
 * under the License.
import org.apache.lucene.util.Constants;
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (int x = " + symbol + ";;) {int x = 1;}"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to elvis operation [?:]");
            // null deref at x.isEmpty(), the '.' is offset 30
            exception = expectThrows(ScriptException.class, () -> { exec(type + " x = null;\n" + "return x.isEmpty();"); });
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        // method call
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("+1; return null;"));
        fail("didn't find script stack element");
        expected = expectScriptThrows(PainlessError.class, () -> {
            assertScriptElementColumn(53, exception);
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = new ArrayList(); x[test0]"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(iae.getMessage(), "not a statement: numeric constant [1] not used");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (int x = test0;;) {int x = 1;}"));
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 = 1; return null;"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
            exec("while (true) { boolean x = false; while (x) {} }");
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[:]; return null;"));
 * You may obtain a copy of the License at
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = false; x == true; return null;"));
        // for
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new java.util.ArrayList(java.util.List)"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        });
            e.getMessage()
        assertEquals(iae.getMessage(), "not a statement: decimal constant [1.1] not used");
        // conditional
    }
        expectScriptThrows(NullPointerException.class, () -> exec("params?.host?.hostname && params.host?.hostname != ''"));
            // trigger NPE at line 3 of the script
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("if (test0) {int x = 1;}"));
        );
    public void testBogusParameter() {
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
            exception = expectThrows(
    private void assertScriptElementColumn(int expectedColumn, ScriptException exception) {
            fail("should have hit PainlessError");
}
        // if/else
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List > true"));
        // binary
    public void testInvalidIntConstantSuggestsLong() {
            );
            assertThat(exception.getCause(), instanceOf(NullPointerException.class));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(
        // instanceof
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("'1'; return null;"));
        iae = expectScriptThrows(
        // new array
        // if/else
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
    }
    public void testCanNotOverrideRegexEnabled() {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new int[] {1, 2}; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[" + symbol + " : 1]"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
 * this work for additional information regarding copyright
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        // return
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int x; x = test0"));
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to decimal constant [1.1]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " + 1"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        PainlessError expected = expectScriptThrows(PainlessError.class, () -> { exec("boolean x = true; while (x) {}"); });
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
    }
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        // if
        IllegalArgumentException iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 = 1"));
        // expression as statement
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
    }
        assertEquals(iae.getMessage(), "not a statement: result not used from explicit cast with target type [ArrayList]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = null; (ArrayList)x; return null;"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        expectScriptThrows(NullPointerException.class, () -> { exec("int x = params['missing']; return x;"); });
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to conditional operation [?:]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
                }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = null; x ?: [2]; return null;"));
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("if (" + symbol + ") {int x = 1;}"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ?: test0"));
    }
        // brace access
        assertEquals(
        // expression as statement
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to regex constant [a] with flags []");
            assertScriptElementColumn(39, exception);
        assertEquals("unexpected character ['].", e.getMessage());
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ?: java.util.List"));
        });
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertTrue(parseException.getMessage().contains("cannot resolve type [PainlessError]"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("staticAddIntsTest(java.util.List, 1)"));
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int x = test0;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new ArrayList(); x.add(test0)"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("+1 = 2; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("(int)" + symbol));
        assumeTrue("test only happens to work for sure on oracle jre", Constants.JAVA_VENDOR.startsWith("Oracle"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        // throw
        assertEquals("Invalid int constant [92233720368547758070].", e.getMessage());
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        PainlessError expected = expectScriptThrows(PainlessError.class, () -> { exec("for (int x = 0; x < 1000000; ++x) {}"); });
 *
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to equals operation [==]");
        assertEquals(iae.getMessage(), "not a statement: result not used from instanceof with target type [List]");
        IllegalArgumentException iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 * 1 = 2; return null;"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        expectScriptThrows(WrongMethodTypeException.class, () -> { exec("def x = new ArrayList(); x.add('foo'); return x['bogus'];"); });
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("staticAddIntsTest(test0, 1)"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        // map initialization
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new ArrayList(test0)"));
    public void testPartialType() {
        // declaration
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
 *
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("do {java.util.List x = [];} while (java.util.List);"));
    }
        // instanceof
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int[] x = new int[] {1}; x[0]; return null;"));
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("!" + symbol));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int x; x = " + symbol));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true || java.util.List"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("-test0"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("if (" + symbol + ") {int x = 1;} else {int x = 2;}"));
    public void testInvalidNullSafeBehavior() {
            exec("for (;;) {int x = 5;}");
    }
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (def x : " + symbol + ") {int x = 1;}"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
    }
            () -> exec("java.util.List[] x = new java.util.List[1]; x[java.util.List]")
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;;++java.util.List) {java.util.List x = 1;}"));
            // We don't want PICKY here so we get the normal error message
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 + " + symbol));
        StackTraceElement[] stackTrace = exception.getCause().getStackTrace();
    }
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[java.util.List : 1]"));
        assertEquals(iae.getMessage(), "not a statement: result of dot operator [.] not used");
            () -> exec("", null, singletonMap(CompilerSettings.REGEX_ENABLED.getKey(), "true"), false)
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 += 1"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("/a/; return null;"));
    public void testRCurlyNotDelim() {
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new java.util.List[1]; x[java.util.List]"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[test0 : 1]"));
        IllegalArgumentException e = expectThrows(
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to numeric constant [1]");
 */
        // right below limit: ok
        IllegalArgumentException iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " = 1"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new ArrayList(); x.add(" + symbol + ")"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("null; return null;"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
    }
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("x() = 1; return null;"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
            fail("should have hit PainlessError");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        // unary
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 ?: []"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[]; return null;"));
            // trigger NPE at line 4 in script (inside conditional)
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("!test0"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("(java.util.List)java.util.List"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true > java.util.List"));
        // expression as statement
public class WhenThingsGoWrongTests extends ScriptTestCase {
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
            fail("should have hit PainlessError");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[" + symbol + "]"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
            IllegalArgumentException.class,
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? test0 : 1"));
        RuntimeException parseException = expectScriptThrows(RuntimeException.class, () -> {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int[] x = new int[1]; x[test0]"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
 * Unless required by applicable law or agreed to in writing,
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 > true"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        int dots = randomIntBetween(1, 5);
        // assignment
        // foreach
            exception = expectThrows(ScriptException.class, () -> {
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true > " + symbol));
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("\"\\a\"", false));
        // while
        // new array
        // for
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        for (int i = 0; i < stackTrace.length; i++) {
        // assignment
 * compatible open source license.
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to addition operation [+]");
        // function call
        }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new int[" + symbol + "]"));
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
            IllegalArgumentException.class,
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 == 1 = 2; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + "[0]"));
        // return
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("if (java.util.List) {java.util.List x = 1;}"));
 */
            exec("def i = 1} return 1", emptyMap(), emptyMap(), false);
        // throw
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "invalid assignment: cannot write a value to a static type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[java.util.List]"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
 * software distributed under the License is distributed on an
        // declaration
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 || true"));
