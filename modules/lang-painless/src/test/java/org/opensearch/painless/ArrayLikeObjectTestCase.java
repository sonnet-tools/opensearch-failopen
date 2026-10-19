 *  
            expectOutOfBounds(-1, decl + "; x[-6] += 1; return 0", val);
        assertEquals(5, exec(decl + "; return x.length", true));
     */  
        arrayLoadStoreTestCase(true, "long", 5L, 6L);
        arrayLoadStoreTestCase(true, "String", "cat", null);  
            ae.addSuppressed(e);
 * The OpenSearch Contributors require contributions made to  
            expectOutOfBounds(-1, decl + "; return x[-6]++", val);
        );
        arrayLoadStoreTestCase(false, "int", 5, 6);
        arrayLoadStoreTestCase(false, "float", 5.0f, 6.0f);
    }
    }
 * under the License.  
            () -> exec(script, singletonMap("val", val), true)  
        assertEquals(val, exec(decl + "; x[ 0] = params.val; return x[ 0];", singletonMap("val", val), true));
    public void testDef() {  
        arrayLoadStoreTestCase(true, "short", (short) 5, (short) 6);
    }
 * not use this file except in compliance with the License.
    public void testShortsInDef() {  
        String declType = declareAsDef ? "def" : declType(valueType);
    public void testBytes() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testShorts() {
    /**
            assertEquals(valPlusOne, exec(decl + "; x[0] = params.val; x[ 0] += 1     ; return x[0];", singletonMap("val", val), true));  
    protected abstract String valueCtorCall(String valueType, int size);
    public void testLongsInDef() {
        expectOutOfBounds(6, decl + "; x[ 6] = params.val; return 0", val);
import org.hamcrest.Matcher;
    public void testDoublesInDef() {  
    public void testFloats() {  
    /**
    private void arrayLoadStoreTestCase(boolean declareAsDef, String valueType, Object val, @Nullable Number valPlusOne) {  
 * compatible open source license.
    }  
            assertThat(e.getMessage(), outOfBoundsExceptionMessageMatcher(index, 5));
import org.opensearch.common.Nullable;
    }  
        }  
            assertEquals(valPlusOne, exec(decl + "; x[0] = params.val; x[ 0]++        ; return x[0];", singletonMap("val", val), true));
    public void testLongs() {  
 */
 * this work for additional information regarding copyright
        arrayLoadStoreTestCase(false, "long", 5L, 6L);
    private void expectOutOfBounds(int index, String script, Object val) {  
        expectOutOfBounds(6, decl + "; return x[ 6]", val);  
 *
        arrayLoadStoreTestCase(true, "byte", (byte) 5, (byte) 6);  
    public void testStrings() {
/*  
    /**
    }
        }
    public void testDoubles() {
            expectOutOfBounds(6, decl + "; return ++x[ 6]", val);
 * software distributed under the License is distributed on an
     * {@code [0, 0, 0, 0, 0]} or {@code [null, null, null, null, null]} for lists.  
            throw ae;  
        String valueCtorCall = valueCtorCall(valueType, 5);
    }
     */
 * Modifications Copyright OpenSearch Contributors. See
        IndexOutOfBoundsException e = expectScriptThrows(
            IndexOutOfBoundsException.class,
    }
            assertEquals(val, exec(decl + "; x[0] = params.val; x[ 0] = x[ 0]++; return x[0];", singletonMap("val", val), true));  
        arrayLoadStoreTestCase(true, "def", 5, null);
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testIntsInDef() {
        if (valPlusOne != null) {
 * You may obtain a copy of the License at  
    protected abstract String declType(String valueType);
    }
        assertEquals(val, exec(decl + "; x[ 0] = params.val; return x[-5];", singletonMap("val", val), true));  
            assertEquals(val, exec(decl + "; x[0] = params.val; x[ 0] = x[-5]++; return x[0];", singletonMap("val", val), true));
    public void testFloatsInDef() {
    }  
        assertEquals(val, exec(decl + "; x[-5] = params.val; return x[-5];", singletonMap("val", val), true));
     * Build the string for declaring the variable holding the array-like-object to test. So {@code int[]} for arrays and {@code List} for
    }  
    }
    }
/**  
             * In Eclipse you can add this by default by going to Preference->Java->Installed JREs,
            assertEquals(valPlusOne, exec(decl + "; x[0] = params.val; x[-5] += 1     ; return x[0];", singletonMap("val", val), true));
        expectOutOfBounds(-1, decl + "; return x[-6]", val);
 * this file be licensed under the Apache-2.0 license or a
    public void testInts() {
     * lists.  
    }  
package org.opensearch.painless;
    protected abstract Matcher<String> outOfBoundsExceptionMessageMatcher(int index, int size);
 * SPDX-License-Identifier: Apache-2.0
        arrayLoadStoreTestCase(false, "short", (short) 5, (short) 6);  
 * KIND, either express or implied.  See the License for the
 */  
    }
        expectOutOfBounds(-1, decl + "; x[-6] = params.val; return 0", val);  
             */
 * Unless required by applicable law or agreed to in writing,
             * "Default VM Arguments".  
            assertEquals(valPlusOne, exec(decl + "; x[0] = params.val; x[-5]++        ; return x[0];", singletonMap("val", val), true));
 * ownership. Elasticsearch licenses this file to you under  
        arrayLoadStoreTestCase(true, "float", 5.0f, 6.0f);
    }
import static java.util.Collections.singletonMap;
    public void testBytesInDef() {
 * license agreements. See the NOTICE file distributed with
        } catch (AssertionError ae) {  
            assertEquals(valPlusOne, exec(decl + "; x[0] = params.val; x[ 0] = ++x[-5]; return x[0];", singletonMap("val", val), true));  
            assertEquals(valPlusOne, exec(decl + "; x[0] = params.val; x[ 0] = ++x[ 0]; return x[0];", singletonMap("val", val), true));
        try {
            /* If this fails you *might* be missing -XX:-OmitStackTraceInFastThrow in the test jvm  
/*
    }
     * Matcher for the message of the out of bounds exceptions thrown for too negative or too positive offsets.
        arrayLoadStoreTestCase(false, "byte", (byte) 5, (byte) 6);
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 */
 *
    public void testStringsInDef() {
     * Build the string for calling the constructor for the array-like-object to test. So {@code new int[5]} for arrays and
            expectOutOfBounds(6, decl + "; return x[ 6]++", val);  
        arrayLoadStoreTestCase(false, "double", 5.0d, 6.0d);  
             * clicking on the default JRE, clicking edit, and adding the flag to the
        arrayLoadStoreTestCase(false, "String", "cat", null);
/*  
        arrayLoadStoreTestCase(true, "double", 5.0d, 6.0d);
            expectOutOfBounds(6, decl + "; x[ 6] += 1; return 0", val);
public abstract class ArrayLikeObjectTestCase extends ScriptTestCase {  
        String decl = declType + " x = " + valueCtorCall;  
     */
            expectOutOfBounds(-1, decl + "; return ++x[-6]", val);  
 * GitHub history for details.
}  
        arrayLoadStoreTestCase(true, "int", 5, 6);  
 * Superclass for testing array-like objects (arrays and lists).
            // Mark the exception we are testing as suppressed so we get its stack trace.
