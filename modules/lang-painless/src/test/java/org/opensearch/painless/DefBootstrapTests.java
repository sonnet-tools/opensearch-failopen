 * KIND, either express or implied.  See the License for the
        assertEquals(2, (Object) handle.invokeExact((Object) 1, (Object) 1));
            MethodType.methodType(Object.class, int.class, Object.class),
            0,
            new FunctionTable(),
 */
            return e.getMethodName().equals("computeValue") && e.getClassName().startsWith("org.opensearch.painless.DefBootstrap$PIC$");
            "add",
 * software distributed under the License is distributed on an
    }
            new FunctionTable(),
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
            0,
 * not use this file except in compliance with the License.
        assertFalse((boolean) handle.invokeExact((Object) null, (Object) "test"));
        );
        );
        assertEquals("5", (String) handle.invokeExact((Object) 5));
            Collections.emptyMap(),
        site.depth = DefBootstrap.PIC.MAX_DEPTH; // mark megamorphic
        assertEquals("5", (String) handle.invokeExact((Object) 5));
 * You may obtain a copy of the License at
    }
        );
            new FunctionTable(),
        assertEquals("1.5", (String) handle.invokeExact((Object) 1.5f));
        expectThrows(NullPointerException.class, () -> { assertNotNull((Object) handle.invokeExact(5, (Object) null)); });
import static org.hamcrest.Matchers.instanceOf;
    }
            Collections.emptyMap(),
            DefBootstrap.OPERATOR_ALLOWS_NULL
            painlessLookup,
        assertDepthEquals(site, 0);
            DefBootstrap.METHOD_CALL,
import java.lang.invoke.MethodType;
 *
        assertDepthEquals(site, 4);
        assertEquals(2, (int) handle.invokeExact((Object) Arrays.asList("u", "v")));
            Collections.emptyMap(),
        // invoked with integer again: should be cached
        final DefBootstrap.WrappedCheckedException wrapped = expectThrows(DefBootstrap.WrappedCheckedException.class, () -> {
        MethodHandle handle = site.dynamicInvoker();
        assertTrue("Does not fail inside ClassValue.computeValue()", Arrays.stream(iae.getStackTrace()).anyMatch(e -> {
 * GitHub history for details.
        // both these should be cached
            painlessLookup,
 * Unless required by applicable law or agreed to in writing,
        assertEquals(3, (int) handle.invokeExact((Object) Arrays.asList("x", "y", "z")));
        );
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(2, (int) handle.invokeExact((Object) Arrays.asList("1", "2")));
            "toString",
    // for example, nulls are only legal for + if the other parameter is a String,
 */
        DefBootstrap.PIC site = (DefBootstrap.PIC) DefBootstrap.bootstrap(
            MethodHandles.publicLookup(),
    public void testNoNullGuardAddWhenCached() throws Throwable {
import java.lang.invoke.CallSite;
        assertTrue((boolean) handle.invokeExact((Object) null, (Object) null));
import java.lang.invoke.MethodHandle;
            painlessLookup,
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final PainlessLookup painlessLookup = PainlessLookupBuilder.buildFromAllowlists(Allowlist.BASE_ALLOWLISTS);
            Collections.emptyMap(),
        // invoke with integer, needs lookup
        assertDepthEquals(site, 3);
 * SPDX-License-Identifier: Apache-2.0
 */
        assertDepthEquals(site, 5);
            DefBootstrap.BINARY_OPERATOR,
            0,
        MethodHandle handle = site.dynamicInvoker();
            DefBootstrap.METHOD_CALL,
        assertDepthEquals(site, 1);
            new FunctionTable(),
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
    }
    public void testNullGuardEq() throws Throwable {
    }
    }
 *
        assertEquals("5", (String) handle.invokeExact((Object) 5));
        MethodHandle handle = site.dynamicInvoker();
            Collections.emptyMap(),
            "toString",
            DefBootstrap.OPERATOR_ALLOWS_NULL
            Collections.emptyMap(),
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
        assertEquals("6", (String) handle.invokeExact((Object) 6L));
    public void testMegamorphic() throws Throwable {
 * the Apache License, Version 2.0 (the "License"); you may
            new FunctionTable(),
 *
        assertEquals(expected, dsite.depth);
            MethodHandles.publicLookup(),
        assertDepthEquals(site, 5);
            painlessLookup,
        assertEquals(1, (int) handle.invokeExact((Object) Collections.singletonMap("a", "b")));
            new FunctionTable(),
            MethodHandles.publicLookup(),
    // make sure these operators work without null guards too
            DefBootstrap.OPERATOR_ALLOWS_NULL
            MethodType.methodType(boolean.class, Object.class, Object.class),
            ""
            MethodType.methodType(String.class, Object.class),
            Collections.emptyMap(),
 * license agreements. See the NOTICE file distributed with
            0,
            DefBootstrap.METHOD_CALL,
        assertEquals("foo", (String) handle.invokeExact((Object) "foo"));
 * Licensed to Elasticsearch under one or more contributor
            "add",
    public void testTwoTypes() throws Throwable {
    public void testOneType() throws Throwable {
        );
import java.util.Collections;
        MethodHandle handle = site.dynamicInvoker();
        assertEquals("nulltest", (Object) handle.invokeExact((Object) null, (Object) "test"));
            DefBootstrap.BINARY_OPERATOR,
        assertEquals(2, (Object) handle.invokeExact(1, (Object) 1));
    public void testTooManyTypes() throws Throwable {
        }));
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
            0,
            MethodHandles.publicLookup(),
 * this work for additional information regarding copyright
            new FunctionTable(),
        );
            ""
            painlessLookup,
 * Modifications Copyright OpenSearch Contributors. See
            "eq",
        // if this changes, test must be rewritten
            0,
            new FunctionTable(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            painlessLookup,
            MethodType.methodType(boolean.class, Object.class, Object.class),
    public void testNullGuardAddWhenCached() throws Throwable {
        MethodHandle handle = site.dynamicInvoker();
            "add",
        DefBootstrap.PIC dsite = (DefBootstrap.PIC) site;
}
        final IllegalArgumentException iae = (IllegalArgumentException) wrapped.getCause();
    }
        map.put("x", "y");
            Collections.emptyMap(),
        map.put("a", "b");
        assertDepthEquals(site, 2);
            MethodHandles.publicLookup(),
        );
public class DefBootstrapTests extends OpenSearchTestCase {
    // and can be disabled in some circumstances.
        assertThat(wrapped.getCause(), instanceOf(IllegalArgumentException.class));
        assertEquals("nulltest", (Object) handle.invokeExact((Object) null, (Object) "test"));
            DefBootstrap.BINARY_OPERATOR,
 * under the License.
            0,
        assertDepthEquals(site, 0);
        assertEquals(2, (int) handle.invokeExact((Object) map));
/*
import org.opensearch.painless.lookup.PainlessLookup;
        );
            0,
            MethodHandles.publicLookup(),
import org.opensearch.painless.lookup.PainlessLookupBuilder;
        assertDepthEquals(site, 1);
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
            "add",
        expectThrows(NullPointerException.class, () -> { assertNotNull((Object) handle.invokeExact(5, (Object) null)); });
        assertEquals("c", (String) handle.invokeExact((Object) 'c'));
        assertDepthEquals(site, 2);
        assertEquals("3.2", (String) handle.invokeExact((Object) 3.2d));
            DefBootstrap.BINARY_OPERATOR,
            0,
            "size",
        assertDepthEquals(site, 1);
        MethodHandle handle = site.dynamicInvoker();
        assertEquals("1.5", (String) handle.invokeExact((Object) 1.5f));
 * ownership. Elasticsearch licenses this file to you under
            painlessLookup,
            Collections.emptyMap(),
package org.opensearch.painless;
    static void assertDepthEquals(CallSite site, int expected) {
            "toString",
            painlessLookup,
            Integer.toString((int) handle.invokeExact(new Object()));
            painlessLookup,
        assertEquals("6", (String) handle.invokeExact((Object) 6));
        assertDepthEquals(site, 2);
        assertFalse((boolean) handle.invokeExact((Object) null, (Object) "test"));
            MethodType.methodType(Object.class, Object.class, Object.class),
            "eq",
        MethodHandle handle = site.dynamicInvoker();
        assertEquals("dynamic method [java.lang.Object, size/0] not found", iae.getMessage());
        assertDepthEquals(site, 1);
        CallSite site = DefBootstrap.bootstrap(
        assertTrue((boolean) handle.invokeExact((Object) null, (Object) null));
            DefBootstrap.METHOD_CALL,
        MethodHandle handle = site.dynamicInvoker();
    }
            DefBootstrap.BINARY_OPERATOR,
            0
 * specific language governing permissions and limitations
        DefBootstrap.MIC site = (DefBootstrap.MIC) DefBootstrap.bootstrap(
    public void testNullGuardEqWhenCached() throws Throwable {
            DefBootstrap.BINARY_OPERATOR,
    /** calls toString() on integers, twice */
        assertEquals("6", (String) handle.invokeExact((Object) 6));
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
            MethodType.methodType(Object.class, Object.class, Object.class),
            MethodHandles.publicLookup(),
        CallSite site = DefBootstrap.bootstrap(
            ""
        );
        CallSite site = DefBootstrap.bootstrap(
    }
    }
        assertEquals(5, DefBootstrap.PIC.MAX_DEPTH);
            MethodHandles.publicLookup(),
import java.util.Arrays;
            new FunctionTable(),
    // test operators with null guards
            new FunctionTable(),
            MethodHandles.publicLookup(),
            MethodType.methodType(String.class, Object.class),
 * this file be licensed under the Apache-2.0 license or a
            Collections.emptyMap(),
            MethodType.methodType(String.class, Object.class),
            painlessLookup,
            MethodType.methodType(int.class, Object.class),
    public void testNullGuardAdd() throws Throwable {
import org.opensearch.painless.symbol.FunctionTable;
import org.opensearch.painless.spi.Allowlist;
import java.lang.invoke.MethodHandles;
            0
        final HashMap<String, String> map = new HashMap<>();
    /** test that we revert to the megamorphic classvalue cache and that it works as expected */
    }
            MethodHandles.publicLookup(),
            ""
        });
            DefBootstrap.OPERATOR_ALLOWS_NULL
        );
    public void testNoNullGuardAdd() throws Throwable {
        assertEquals("2.5", (String) handle.invokeExact((Object) 2.5f));
import java.util.HashMap;
        MethodHandle handle = site.dynamicInvoker();
        assertDepthEquals(site, 0);
            MethodType.methodType(Object.class, int.class, Object.class),
            0,
        assertDepthEquals(site, 2);
        MethodHandle handle = site.dynamicInvoker();
/*
        assertTrue((boolean) handle.invokeExact((Object) 1, (Object) 1));
/*
