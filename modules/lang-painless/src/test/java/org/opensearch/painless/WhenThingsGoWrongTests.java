        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to regex constant [a] with flags []");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 || true"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("Map x = new HashMap(); x[" + symbol + "]"));  
        // function call
            IllegalArgumentException.class,  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x && false = 2; return null;"));
import java.util.Collections;
        // elvis
            // null deref at x.isEmpty(), the '.' is offset 53
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
            "Invalid int constant [-864000000000]. If you want a long constant then change it to [-864000000000L].",  
                exec(type + " x = null; boolean y = x.isEmpty();\n" + "return y;");
            assertScriptStack(exception, "return y.isEmpty();", "        ^---- HERE");
        });
            assertThat(exception.getCause(), instanceOf(NullPointerException.class));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("staticAddIntsTest(java.util.List, 1)"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[" + symbol + " : 1]"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new ArrayList(); x.add(" + symbol + ")"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("do {java.util.List x = [];} while (java.util.List);"));
        // conditional  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
            exception = expectThrows(ScriptException.class, () -> { exec(type + " x = null;\n" + "return x.isEmpty();"); });  
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("-" + symbol));
 * The OpenSearch Contributors require contributions made to  
    }
        assertEquals(
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to conditional operation [?:]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        // declaration  
            );
        // boolean comparison
        iae = expectScriptThrows(
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = []; x instanceof List = 5; return null;"));
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return -92233720368547758070"));
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int[] x = new int[1]; x[test0]"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = []; (x ?: []) = 2; return null;"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true || java.util.List"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("if (" + symbol + ") {int x = 1;} else {int x = 2;}"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = new ArrayList(); x[" + symbol + "]"));
            });
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true > java.util.List"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        );
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = new ArrayList(); x.add(" + symbol + ")"));  
        );
        // if  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "invalid assignment: cannot write a value to a static type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("x() = 1; return null;"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; (x ? 1 : 1) = 2; return null;"));
        assertEquals("Invalid int constant [-92233720368547758070].", e.getMessage());  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ?: " + symbol));
    private void assertScriptElementColumn(int expectedColumn, ScriptException exception) {  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol));
 * software distributed under the License is distributed on an
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
 *    http://www.apache.org/licenses/LICENSE-2.0
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = false; x ? 1 : 2; return null;"));
    public void testOutOfMemoryError() {
            // trigger NPE at line 1 of the script
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new java.util.ArrayList(java.util.List)"));  
    public void testDynamicWrongArgs() {  
    public void testInfiniteLoops() {  
            IllegalArgumentException.class,
     */
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[java.util.List : 1]"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 + test0"));
    public void testInvalidShift() {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " ?: []"));  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
    }  
        // while
        // boolean comparison
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
     * Test that the scriptStack looks good. By implication this tests that we build proper "line numbers" in stack trace. These line  
        // numeric comparison
            IllegalArgumentException.class,  
    /**
    public void testDynamicNPE() {
    }  
        // while
            fail("should have hit PainlessError");  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
            exec("while (true) { boolean x = false; while (x) {} }");
     * Makes sure that we present a useful error message with a misplaced right-curly. This is important because we do some funky things in
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to addition operation [+]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
 * Licensed to Elasticsearch under one or more contributor  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int[] x = new int[1]; x[" + symbol + "]"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? 2 : " + symbol));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true > test0"));
        }  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        expectScriptThrows(WrongMethodTypeException.class, () -> { exec("def x = new ArrayList(); x.add('foo'); return x['bogus'];"); });  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new int[] {1, 2}; return null;"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = false; x == true; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ?: java.util.List"));
        // assignment
            exec("return 5;", null, Collections.singletonMap("bogusParameterKey", "bogusParameterValue"), true);
        // map initialization
        assertEquals(-864000000000L, exec("return -864000000000L"));  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[test0 : 1]"));
        assertEquals(iae.getMessage(), "not a statement: boolean constant [false] not used");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List x; x = java.util.List"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new java.util.ArrayList(); x.add(java.util.List)"));
        assertEquals(  
        );
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to equals operation [==]");  
        // declaration  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("!" + symbol));
        // while
            "unexpected character ['\\a]. The only valid escape sequences in strings starting with ['] are [\\\\] and [\\'].",
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("-test0"));  
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to decimal constant [1.1]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        // new array
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " || true"));  
        // foreach  
            assertScriptElementColumn(39, exception);  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List ? 2 : 1"));  
        // brace access
            IllegalArgumentException.class,  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("'1'; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("staticAddIntsTest(" + symbol + ", 1)"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("staticAddIntsTest(test0, 1)"));
            exec("try { int x; } catch (PainlessError error) {}", false);
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
    public void testInvalidAssignment() {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[] = 5; return null;"));  
    public void testInvalidFullyQualifiedStaticReferenceType() {
        assertEquals(iae.getMessage(), "not a statement: result not used from instanceof with target type [List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (def x : test0) {int x = 1;}"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new ArrayList(); x.add(test0)"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "not a statement: string constant [1] not used");  
        // return
        // binary
        );
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        iae = expectScriptThrows(
    }
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
     */  
/*  
/*
    public void testCannotResolveSymbol() {
                if (expectedColumn + 1 != stackTrace[i].getLineNumber()) {
import org.apache.lucene.util.Constants;
            e.getMessage()
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 instanceof List"));  
        }  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        // method call
            () -> exec("if (java.util.List) {java.util.List x = 1;} else {java.util.List x = 2;}")
        assertEquals(iae.getMessage(), "not a statement: result not used from boolean and operation [&&]");
    public void testStackOverflowError() {  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " += 1"));
        for (int i = 0; i < stackTrace.length; i++) {
    public void testDynamicListWrongIndex() {
        // conditional
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("(int)test0"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = null; x ?: [2]; return null;"));
        assertEquals(iae.getMessage(), "not a statement: result not used from list initializer");  
        );  
            () -> exec("for (java.util.List x = java.util.List;;) {java.util.List x = 1;}")
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("'\\a'", false));  
        });
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new ArrayList(" + symbol + ")"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("Map x = new HashMap(); x[test0]"));
    public void testBadStringEscape() {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[:] = 5; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int[] x = new int[1]; x[test0]"));
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to map initializer");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new int[test0]"));
/*  
        exec("for (int x = 0; x < 999999; ++x) {}");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0[0]"));
        // method call
            IllegalArgumentException.class,  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to numeric constant [1]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = null; (ArrayList)x; return null;"));
        assertEquals(iae.getMessage(), "not a statement: result not used from addition operation [+]");
        PainlessError expected = expectScriptThrows(PainlessError.class, () -> { exec("for (int x = 0; x < 1000000; ++x) {}"); });  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
    }
import static org.hamcrest.Matchers.instanceOf;
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List x = java.util.List;"));
        // unary
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
    }  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int x = " + symbol + ";"));
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        assertEquals(iae.getMessage(), "not a statement: result not used from equals operation [==]");  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("throw java.util.List;"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to boolean constant [false]");
        expected = expectScriptThrows(PainlessError.class, () -> {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("if (" + symbol + ") {int x = 1;}"));
            if (WriterConstants.CLASS_NAME.equals(stackTrace[i].getClassName())) {  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
            // trigger NPE at line 2 of the script
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        IllegalArgumentException iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List = 1"));  
    }
        // explicit cast
import static java.util.Collections.emptyMap;  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 + " + symbol));
        // list initialization  
        assertEquals(iae.getMessage(), "not a statement: result not used from conditional operation [?:]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " > true"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? 2 : java.util.List"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[]; return null;"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("+1; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? java.util.List : 1"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("throw " + symbol + ";"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List += 1"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "not a statement: result not used from elvis operation [?:]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[1 : java.util.List]"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
    }
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        // method call
    }  
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
                return;
        // assignment  
                    assertion.initCause(exception);
            fail("should have hit ParseException");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("if (test0) {int x = 1;} else {int x = 2;}"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int x = test0;"));
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
     * numbers are really 1 based character numbers.
        // function call
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
    }
    public void testNullPointer() {  
        expectScriptThrows(NullPointerException.class, () -> { exec("def x = null; return x.toString()"); });  
        iae = expectScriptThrows(
            }  
        // new array
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("if (test0) {int x = 1;}"));
        // brace access
 * this file be licensed under the Apache-2.0 license or a
            assertScriptElementColumn(30, exception);
        // foreach
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("null = 1; return null;"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("!java.util.List"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List || true"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        IllegalArgumentException iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 * 1 = 2; return null;"));  
            // trigger NPE at line 3 of the script  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new int[" + symbol + "]"));  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("while (test0) {int x = 1;}"));
    public void testInvalidIntConstantSuggestsLong() {  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (int x = " + symbol + ";;) {int x = 1;}"));  
    public void testCanNotOverrideRegexEnabled() {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 + 1"));
        assumeTrue("test only happens to work for sure on oracle jre", Constants.JAVA_VENDOR.startsWith("Oracle"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        assertEquals(iae.getMessage(), "not a statement: result of brace operator not used");  
            exec("def x = true; do {int y = 5;} while (x)");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + "[0]"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;" + symbol + ";) {int x = 1;}"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("do {int x = 1;} while (test0);"));
            () -> exec("java.util.List x = new java.util.ArrayList(); x[java.util.List]")  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[java.util.List]"));
        // declaration
        assertEquals("invalid sequence of tokens near ['.'].", e.getMessage());
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        assertTrue(expected.getMessage().contains("Unrecognized compile-time parameter"));  
        int dots = randomIntBetween(1, 5);
        // explicit cast
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to function call [x/0]");
            e.getMessage()  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("(int)" + symbol));  
        expectScriptThrows(StackOverflowError.class, () -> { exec("void recurse(int x, int y) {recurse(x, y)} recurse(1, 2);"); });
        // binary
            "unexpected character [\"\\a]. The only valid escape sequences in strings starting with [\"] are [\\\\] and [\\\"].",
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        expectScriptThrows(UnsupportedOperationException.class, () -> exec("params['modifyingParamsMap'] = 2;"));  
 * KIND, either express or implied.  See the License for the
        // boolean comparison
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        // brace access
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? test0 : 1"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        // map initialization
            // null deref at x.isEmpty(), the '.' is offset 30  
            ClassCastException.class,
            assertScriptStack(exception, "return x.isEmpty();", "        ^---- HERE");  
        IllegalArgumentException iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 = 1"));  
        // expression as statement  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[1 : test0]"));
        // right below limit: ok  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List instanceof java.util.List"));  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        // explicit cast
        assertEquals(iae.getMessage(), "not a statement: regex constant [a] with flags [] not used");
    }  
    /**  
    }  
        // elvis
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
 *
        expectScriptThrows(NullPointerException.class, () -> { exec("int x = params['missing']; return x;"); });
    }
            () -> exec("", null, singletonMap(CompilerSettings.REGEX_ENABLED.getKey(), "true"), false)
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("if (java.util.List) {java.util.List x = 1;}"));
        // unary  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to multiplication operation [*]");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        expectScriptThrows(NullPointerException.class, () -> { exec("Double.parseDouble(params['missing'])"); });
    public void testQuestionSpaceDotIsNotNullSafeDereference() {  
            exec("def x = 'test'; return x.getClass().toString()");  
        assertEquals(iae.getMessage(), "not a statement: result not used from explicit cast with target type [ArrayList]");
        assertEquals(iae.getMessage(), "not a statement: decimal constant [1.1] not used");
    }  
        // function call
import static java.util.Collections.singletonMap;
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0"));
            exception = expectThrows(
            ScriptException exception = expectThrows(ScriptException.class, () -> {  
            IllegalArgumentException.class,
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        assertTrue(expected.getMessage().contains("dynamic method [java.lang.String, getClass/0] not found"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("throw test0;"));
 * ownership. Elasticsearch licenses this file to you under  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("!test0"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 + java.util.List"));
        // if
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
    public void testNotAStatement() {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("return " + symbol + ";"));
    public void testPartialType() {  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "not a statement: result not used from map initializer");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 ?: []"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List ?: []"));
        // instanceof
            assertScriptElementColumn(53, exception);  
        );
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("while (" + symbol + ") {int x = 1;}"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[" + symbol + "]"));
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 += 1"));
        assertEquals("[painless.regex.enabled] can only be set on node startup.", e.getMessage());  
        expectScriptThrows(NullPointerException.class, () -> exec("params?.host?.hostname && params.host?.hostname != ''"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1.1; return null;"));  
            () -> exec("java.util.List[] x = new java.util.List[1]; x[java.util.List]")  
            // We don't want PICKY here so we get the normal error message  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true || test0"));
            fail("should have hit PainlessError");  
        // if/else
        // dot access
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? " + symbol + " : 1"));  
        // new object
 */
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new ArrayList(test0)"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("/a/; return null;"));  
    public void testInvalidNullSafeBehavior() {  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List > true"));  
        // numeric comparison  
    }  
        // list initialization
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = new ArrayList(); x.add(test0)"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        iae = expectScriptThrows(
        assertEquals("Invalid int constant [92233720368547758070].", e.getMessage());
            exec("for (;;) {int x = 5;}");
    }  
        // declaration
        PainlessError expected = expectScriptThrows(PainlessError.class, () -> { exec("boolean x = true; while (x) {}"); });
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return params.a? .b", false));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = 15F; x <<= 2; return x;"); });
    public void testRegularUnexpectedCharacter() {  
        expected = expectScriptThrows(PainlessError.class, () -> {
    public void testBogusParameter() {
        // expression as statement
                exec(type + " x = null;\n" + "boolean y = false;\n" + "if (!y) {\n" + "  y = x.isEmpty();\n" + "}\n" + "return y;");  
        // throw
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
 * specific language governing permissions and limitations
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("(java.util.List)java.util.List"));
    }
        });
        assertEquals(iae.getMessage(), "not a statement: result of dot operator [.] not used");
        IllegalArgumentException e = expectScriptThrows(IllegalArgumentException.class, () -> {
        });
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List[0]"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        assertEquals("Invalid int constant [864000000000]. If you want a long constant then change it to [864000000000L].", e.getMessage());
        iae = expectScriptThrows(
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[test0]"));
        // elvis
        IllegalArgumentException expected = expectThrows(IllegalArgumentException.class, () -> {  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
public class WhenThingsGoWrongTests extends ScriptTestCase {
            assertThat(exception.getCause(), instanceOf(NullPointerException.class));  
        expected = expectScriptThrows(PainlessError.class, () -> {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("return java.util.List;"));  
 */  
            // null deref at y.isEmpty(), the '.' is offset 39
        expectScriptThrows(WrongMethodTypeException.class, () -> { exec("def x = new ArrayList(); return x.get('bogus');"); });
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (def x : " + symbol + ") {int x = 1;}"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "not a statement: result not used from new array");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("null; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("+1 = 2; return null;"));
            });
        );
            () -> exec("java.util.List x = new java.util.ArrayList(); x.add(java.util.List)")
        });
        expected = expectScriptThrows(PainlessError.class, () -> { exec("while (true) { boolean x = true; while (x) {} }"); });
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;java.util.List;) {java.util.List x = 1;}"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("false = 2; return null;"));
            assertScriptStack(exception, "y = x.isEmpty();\n}\n", "     ^---- HERE");
        // for
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x; x; return null;"));  
        // dot access
 * GitHub history for details.
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        // list initialization  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        // throw  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[:]; return null;"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
            assertThat(exception.getCause(), instanceOf(NullPointerException.class));
        fail("didn't find script stack element");
        });
        // for
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("Map x = new HashMap(); x[java.util.List]"));
import junit.framework.AssertionFailedError;
        // expression as statement  
        IllegalArgumentException e = expectThrows(
        // if/else
            IllegalArgumentException.class,
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0[0]"));
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
        // new object
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
     * the parser with right-curly brackets to allow statements to be delimited by them at the end of blocks.
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1; return null;"));
        expectScriptThrows(OutOfMemoryError.class, () -> { exec("int[] x = new int[Integer.MAX_VALUE - 1];"); });  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 == 1 = 2; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ?: test0"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("/a/ = 1; return null;"));  
        iae = expectScriptThrows(
 * license agreements. See the NOTICE file distributed with
        // declaration
                    throw assertion;  
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return -864000000000"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        // conditional
        assertEquals(iae.getMessage(), "not a statement: numeric constant [1] not used");
 * this work for additional information regarding copyright
        for (String type : new String[] { "String", "def   " }) {
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 = 1; return null;"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        IllegalArgumentException e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return 864000000000"));
        // map initialization
        assertEquals(864000000000L, exec("return 864000000000L"));  
        expectScriptThrows(
        // foreach
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        for (int dot = 0; dot < dots; ++dot) {  
        RuntimeException parseException = expectScriptThrows(RuntimeException.class, () -> {
    }
        expectScriptThrows(ClassCastException.class, () -> { exec("BitSet bs = new BitSet(); bs.and(2);"); });
    public void testRCurlyNotDelim() {
        // If it isn't a valid long we don't give any suggestions
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = true; x ? 2 : test0"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        // declaration
                    );
 *  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("[1 : " + symbol + "]"));
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int[] x = new int[] {1}; x[0]; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int x; x = test0"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
 * under the License.  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int x; x = " + symbol));  
            // trigger NPE at line 4 in script (inside conditional)
            exec("def i = 1} return 1", emptyMap(), emptyMap(), false);
        });
            () -> exec("def test = ['hostname': 'somehostname']; test?.hostname && params.host.hostname != ''")  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        // unary  
                    AssertionFailedError assertion = new AssertionFailedError(
        // throw  
        assertEquals(
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;;++test0) {int x = 1;}"));  
        // if  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to elvis operation [?:]");  
                }
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (def x : java.util.List) {java.util.List x = 1;}"));  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;;++" + symbol + ") {int x = 1;}"));
 * You may obtain a copy of the License at  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        String symbol = builder.toString();
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true > " + symbol));  
        assertEquals(iae.getMessage(), "invalid assignment: cannot write a value to a static type [java.util.List]");
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
            exec("boolean x = true; for (;x;) {}");
        expected = expectScriptThrows(PainlessError.class, () -> { exec("while (true) {int y = 5;}"); });
    }
        );
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1.1 = 1; return null;"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("boolean x = false; x && true; return null;"));
        // instanceof  
            fail("should have hit PainlessError");  
        assertTrue(expected.getMessage().contains("The maximum number of statements that can be executed in a loop has been reached."));
import java.lang.invoke.WrongMethodTypeException;
}
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new java.util.List[java.util.List]"));
                () -> { exec(type + " x = null;\n" + type + " y = x;\n" + "return y.isEmpty();"); }  
        // binary
        // if/else
        StringBuilder builder = new StringBuilder("test0");
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("'cat", false));  
            () -> exec("java.util.List[] x = new java.util.List[1]; x[java.util.List]")  
        });
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        );
        // instanceof
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
 */  
        StackTraceElement[] stackTrace = exception.getCause().getStackTrace();
        // return  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("return 92233720368547758070"));  
                ScriptException.class,
        assertEquals(iae.getMessage(), "not a statement: null constant not used");  
        // new object  
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to instanceof with target type [List]");
        assertEquals(iae.getMessage(), "not a statement: result not used from multiplication operation [*]");  
        IllegalArgumentException iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " = 1"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new int[1]; x[test0]"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = 15F; x <<= 2; return x;"); });  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;;++java.util.List) {java.util.List x = 1;}"));  
        // new array
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("Double.x() = 1;"));  
        // for
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
            fail("should have hit PainlessError");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " ? 2 : 1"));
        // numeric comparison
            builder.append(".test");
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("\"\\a\"", false));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (;test0;) {int x = 1;}"));
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
            exception = expectThrows(ScriptException.class, () -> {
    public void testLoopLimits() {
        );
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
 * Unless required by applicable law or agreed to in writing,
    public void testIllegalDynamicMethod() {
        }
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        // assignment
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("for (int x = test0;;) {int x = 1;}"));
            // null deref at x.isEmpty(), the '.' is offset 25
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to list initializer");
            assertThat(exception.getCause(), instanceOf(NullPointerException.class));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new java.util.List[1]; x[java.util.List]"));  
        expectScriptThrows(UnsupportedOperationException.class, () -> exec("params.modifyingParamsMap = 2;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("'1' = 1; return null;"));
        assertEquals(iae.getMessage(), "not a statement: variable [x] not used");
    }
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("while (java.util.List) {java.util.List x = 1;}"));
        assertEquals("unexpected character ['cat].", e.getMessage());
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List[0]"));
    public void testBadBoxingCast() {  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
    }
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");  
            assertScriptStack(exception, "y = x.isEmpty();\n", "     ^---- HERE");
package org.opensearch.painless;
 * Modifications Copyright OpenSearch Contributors. See
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("int[] x = new int[1]; x[" + symbol + "]"));
        assertEquals("unexpected token ['}'] was expecting one of [{<EOF>, ';'}].", e.getMessage());  
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to null constant");  
        IllegalArgumentException iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("1 * 1; return null;"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 ? 2 : 1"));  
        // dot access
 * the Apache License, Version 2.0 (the "License"); you may
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("do {int x = 1;} while (" + symbol + ");"));  
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("true || " + symbol));
        assertEquals("unexpected character ['].", e.getMessage());
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
 * compatible open source license.
    public void testScriptStack() {  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("return test0;"));  
                        "Expected column to be [" + expectedColumn + "] but was [" + stackTrace[i].getLineNumber() + "]"  
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("'", false));
        // return
 *
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("Integer.MAX_VALUE; return null;"));
            builder.append(dot + 1);
        assertEquals(iae.getMessage(), "cannot resolve symbol [" + symbol + "]");
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");  
        expectScriptThrows(WrongMethodTypeException.class, () -> { exec("def x = new long[1]; x[0]=1; return x['bogus'];"); });
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new int[] {} = 5; return null;"));
    public void testDynamicArrayWrongIndex() {
        assertEquals(iae.getMessage(), "invalid assignment: cannot write a value to a static type [java.util.List]");
 * not use this file except in compliance with the License.
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to new array");
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to method call [x/0]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("java.util.List + 1"));
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to string constant [1]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " instanceof List"));
            e.getMessage()
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("new ArrayList() = 1; return null;"));  
            assertScriptElementColumn(25, exception);
        assertEquals(iae.getMessage(), "value required: instead found unexpected type [java.util.List]");
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("-java.util.List"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("false; return null;"));  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + " + 1"));  
        assertEquals(iae.getMessage(), "invalid assignment: cannot assign a value to boolean and operation [&&]");  
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec(symbol + "[0]"));  
        assertEquals(iae.getMessage(), "invalid assignment cannot assign a value to new object with constructor [ArrayList/0]");
import org.opensearch.script.ScriptException;
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("def x = new int[1]; x[" + symbol + "]"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = new ArrayList(); x[test0]"));
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("List x = null; x instanceof List; return null;"));  
        assertTrue(parseException.getMessage().contains("cannot resolve type [PainlessError]"));
        expected = expectScriptThrows(PainlessError.class, () -> {
        assertEquals(iae.getMessage(), "cannot resolve symbol [test0]");
        );
        iae = expectScriptThrows(IllegalArgumentException.class, () -> exec("test0 > true"));  
