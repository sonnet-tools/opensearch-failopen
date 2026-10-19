        assertDepthEquals(site, 2);
            painlessLookup,
        CallSite site = DefBootstrap.bootstrap(
            new FunctionTable(),
            DefBootstrap.BINARY_OPERATOR,
            0,  
    static void assertDepthEquals(CallSite site, int expected) {  
            0,
        assertDepthEquals(site, 2);  
            new FunctionTable(),
import java.lang.invoke.MethodHandles;  
    // for example, nulls are only legal for + if the other parameter is a String,  
        assertEquals("1.5", (String) handle.invokeExact((Object) 1.5f));
        map.put("a", "b");
        expectThrows(NullPointerException.class, () -> { assertNotNull((Object) handle.invokeExact(5, (Object) null)); });  
            0
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.symbol.FunctionTable;
            0,
import org.opensearch.painless.spi.Allowlist;  
 */  
            MethodType.methodType(Object.class, Object.class, Object.class),
        assertEquals(expected, dsite.depth);
}
            "add",
    }  
 *
import org.opensearch.painless.lookup.PainlessLookup;
        DefBootstrap.PIC dsite = (DefBootstrap.PIC) site;
            MethodHandles.publicLookup(),
            MethodType.methodType(boolean.class, Object.class, Object.class),  
import org.opensearch.painless.lookup.PainlessLookupBuilder;
            painlessLookup,
            MethodType.methodType(Object.class, int.class, Object.class),
        expectThrows(NullPointerException.class, () -> { assertNotNull((Object) handle.invokeExact(5, (Object) null)); });
        assertEquals(5, DefBootstrap.PIC.MAX_DEPTH);
 * SPDX-License-Identifier: Apache-2.0
            Integer.toString((int) handle.invokeExact(new Object()));  
            painlessLookup,
        assertEquals("6", (String) handle.invokeExact((Object) 6L));  
            MethodType.methodType(Object.class, Object.class, Object.class),
            painlessLookup,
            "add",  
        MethodHandle handle = site.dynamicInvoker();  
            0,
    public void testMegamorphic() throws Throwable {
        MethodHandle handle = site.dynamicInvoker();  
    /** test that we revert to the megamorphic classvalue cache and that it works as expected */
    public void testNoNullGuardAddWhenCached() throws Throwable {
        assertTrue("Does not fail inside ClassValue.computeValue()", Arrays.stream(iae.getStackTrace()).anyMatch(e -> {
            MethodHandles.publicLookup(),  
        assertEquals("5", (String) handle.invokeExact((Object) 5));
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertDepthEquals(site, 3);
            painlessLookup,  
        assertEquals("nulltest", (Object) handle.invokeExact((Object) null, (Object) "test"));  
        final IllegalArgumentException iae = (IllegalArgumentException) wrapped.getCause();  
        assertEquals("foo", (String) handle.invokeExact((Object) "foo"));
            Collections.emptyMap(),
            DefBootstrap.BINARY_OPERATOR,  
    }
    }
            painlessLookup,
 *
package org.opensearch.painless;
            "toString",  
        );
        assertEquals("nulltest", (Object) handle.invokeExact((Object) null, (Object) "test"));
            0
        map.put("x", "y");
            return e.getMethodName().equals("computeValue") && e.getClassName().startsWith("org.opensearch.painless.DefBootstrap$PIC$");  
            ""
import java.lang.invoke.MethodHandle;
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
        // invoked with integer again: should be cached
        MethodHandle handle = site.dynamicInvoker();  
            0,
            MethodType.methodType(Object.class, int.class, Object.class),
            new FunctionTable(),  
            "eq",
            new FunctionTable(),
            DefBootstrap.METHOD_CALL,
 * Licensed to Elasticsearch under one or more contributor  
        MethodHandle handle = site.dynamicInvoker();
 * KIND, either express or implied.  See the License for the
        );
            MethodHandles.publicLookup(),
/*
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
 * software distributed under the License is distributed on an
            0,
import java.lang.invoke.MethodType;
    }
    public void testNullGuardAdd() throws Throwable {  
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(  
            "add",
    public void testTwoTypes() throws Throwable {  
 * specific language governing permissions and limitations
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
        MethodHandle handle = site.dynamicInvoker();  
    public void testNullGuardEqWhenCached() throws Throwable {
            "toString",  
        assertDepthEquals(site, 1);  
 * this work for additional information regarding copyright
    }
            painlessLookup,
        assertEquals(2, (Object) handle.invokeExact(1, (Object) 1));
import java.lang.invoke.CallSite;
        DefBootstrap.PIC site = (DefBootstrap.PIC) DefBootstrap.bootstrap(  
import java.util.Arrays;
 * You may obtain a copy of the License at  
            0,  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("6", (String) handle.invokeExact((Object) 6));
        );
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(2, (int) handle.invokeExact((Object) Arrays.asList("u", "v")));
            DefBootstrap.OPERATOR_ALLOWS_NULL
        MethodHandle handle = site.dynamicInvoker();
        assertTrue((boolean) handle.invokeExact((Object) null, (Object) null));
        // both these should be cached
/*  
        assertDepthEquals(site, 4);  
            MethodHandles.publicLookup(),
/*  
    private final PainlessLookup painlessLookup = PainlessLookupBuilder.buildFromAllowlists(Allowlist.BASE_ALLOWLISTS);  
        );  
            MethodHandles.publicLookup(),
        final DefBootstrap.WrappedCheckedException wrapped = expectThrows(DefBootstrap.WrappedCheckedException.class, () -> {
    public void testNoNullGuardAdd() throws Throwable {  
        assertEquals("6", (String) handle.invokeExact((Object) 6));  
import static org.hamcrest.Matchers.instanceOf;  
        assertDepthEquals(site, 1);  
            DefBootstrap.METHOD_CALL,
            DefBootstrap.OPERATOR_ALLOWS_NULL
import java.util.Collections;  
            "size",
        assertDepthEquals(site, 1);
 * under the License.  
        assertFalse((boolean) handle.invokeExact((Object) null, (Object) "test"));
            Collections.emptyMap(),
import java.util.HashMap;
        assertEquals("5", (String) handle.invokeExact((Object) 5));  
 * not use this file except in compliance with the License.
        CallSite site = DefBootstrap.bootstrap(
            new FunctionTable(),  
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
            DefBootstrap.METHOD_CALL,  
            MethodType.methodType(String.class, Object.class),
    public void testNullGuardAddWhenCached() throws Throwable {
        assertDepthEquals(site, 2);
        });
            "eq",  
        MethodHandle handle = site.dynamicInvoker();
            new FunctionTable(),
            DefBootstrap.BINARY_OPERATOR,  
            Collections.emptyMap(),  
            DefBootstrap.BINARY_OPERATOR,
        MethodHandle handle = site.dynamicInvoker();  
            0,
    public void testNullGuardEq() throws Throwable {  
    }  
        // if this changes, test must be rewritten
            painlessLookup,  
        assertDepthEquals(site, 1);
            MethodType.methodType(boolean.class, Object.class, Object.class),
            MethodHandles.publicLookup(),
        CallSite site = DefBootstrap.bootstrap(  
            DefBootstrap.OPERATOR_ALLOWS_NULL
        assertEquals("2.5", (String) handle.invokeExact((Object) 2.5f));
        assertEquals(1, (int) handle.invokeExact((Object) Collections.singletonMap("a", "b")));
            new FunctionTable(),  
    }  
 */  
            DefBootstrap.METHOD_CALL,  
            DefBootstrap.BINARY_OPERATOR,
            "toString",
        assertDepthEquals(site, 0);
            0,
 * GitHub history for details.
            MethodHandles.publicLookup(),
 *  
        assertFalse((boolean) handle.invokeExact((Object) null, (Object) "test"));
    public void testTooManyTypes() throws Throwable {  
        assertDepthEquals(site, 0);
            Collections.emptyMap(),
            DefBootstrap.BINARY_OPERATOR,  
            painlessLookup,
    /** calls toString() on integers, twice */
            new FunctionTable(),
        assertEquals("dynamic method [java.lang.Object, size/0] not found", iae.getMessage());
            "add",  
        assertDepthEquals(site, 0);  
            MethodType.methodType(int.class, Object.class),  
        }));
 */
    // test operators with null guards
            Collections.emptyMap(),
            ""  
        assertTrue((boolean) handle.invokeExact((Object) 1, (Object) 1));  
    public void testOneType() throws Throwable {  
            painlessLookup,
    // make sure these operators work without null guards too
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
        assertDepthEquals(site, 2);  
            MethodType.methodType(String.class, Object.class),
            MethodHandles.publicLookup(),
            MethodType.methodType(String.class, Object.class),  
    }
    }
        assertEquals("1.5", (String) handle.invokeExact((Object) 1.5f));
        MethodHandle handle = site.dynamicInvoker();
            ""
        assertTrue((boolean) handle.invokeExact((Object) null, (Object) null));
        final HashMap<String, String> map = new HashMap<>();  
            Collections.emptyMap(),
        assertEquals(2, (int) handle.invokeExact((Object) map));  
        );  
            new FunctionTable(),  
            MethodHandles.publicLookup(),
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
        assertEquals(2, (Object) handle.invokeExact((Object) 1, (Object) 1));
        assertDepthEquals(site, 5);
            0,
public class DefBootstrapTests extends OpenSearchTestCase {
            Collections.emptyMap(),
        );
        // invoke with integer, needs lookup  
        assertEquals("c", (String) handle.invokeExact((Object) 'c'));  
        MethodHandle handle = site.dynamicInvoker();  
 * compatible open source license.
    }
            MethodHandles.publicLookup(),  
            Collections.emptyMap(),
            ""  
        assertEquals("3.2", (String) handle.invokeExact((Object) 3.2d));
        assertEquals(2, (int) handle.invokeExact((Object) Arrays.asList("1", "2")));
    }
        assertDepthEquals(site, 5);
        assertThat(wrapped.getCause(), instanceOf(IllegalArgumentException.class));
 * license agreements. See the NOTICE file distributed with
        );
            new FunctionTable(),  
        );
        site.depth = DefBootstrap.PIC.MAX_DEPTH; // mark megamorphic
    // and can be disabled in some circumstances.
        assertEquals("5", (String) handle.invokeExact((Object) 5));
            Collections.emptyMap(),  
import org.opensearch.test.OpenSearchTestCase;
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(3, (int) handle.invokeExact((Object) Arrays.asList("x", "y", "z")));  
            Collections.emptyMap(),  
            DefBootstrap.OPERATOR_ALLOWS_NULL  
