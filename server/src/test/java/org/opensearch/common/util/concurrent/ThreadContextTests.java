        }
            assertEquals("qux", threadContext.getResponseHeaders().get("bar").get(0));
    }
        ThreadContext threadContext = new ThreadContext(build);
        // In fact the second wrapping didn't even change it
import static org.hamcrest.Matchers.sameInstance;
                randomFrom(Arrays.asList("foo", "foo"), Arrays.asList("foo"), Arrays.asList("foo", "acme"))
 */
 * this file be licensed under the Apache-2.0 license or a
        threadContext.putTransient("test_transient_propagation_key", "test");
        assertEquals("1", threadContext.getHeader("default"));
            assertEquals("bar", threadContext.getHeader("foo"));
            });
        threadContext.copyHeaders(Collections.<String, String>singletonMap("foo", "bar").entrySet());
        threadContext.registerThreadContextStatePropagator(new ThreadContextStatePropagator() {
        ThreadContext threadContext = new ThreadContext(build);
            @SuppressWarnings("removal")
        threadContext.putHeader("foo", "bar");
            if (systemContext) {
    public void testResponseHeaders() {
        threadContext.registerThreadContextStatePropagator(mockPropagator);
        threadContext.putHeader("foo", "bar");
        threadContext.registerThreadContextStatePropagator(mockPropagator);
        assertEquals("baaaam", threadContext.getResponseHeaders().get("resp.header").get(0));
        Settings build = Settings.builder().put("request.headers.default", "1").build();
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
        assertNull(threadContext.getHeader("foo.bar"));
            assertEquals("bar", threadContext.getHeader("baz"));
    public void testStashAndMerge() {
        assertEquals(1, threadContext.getResponseHeaders().get("resp.header").size());
        }
        }
        assertEquals("test", threadContext.getTransient("test_transient_propagation_key"));
        threadContext.putHeader("default", "2");
        assertEquals("bar", threadContext.getHeader("foo"));
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
            threadContext.addResponseHeader("foo", "bar");
    public void testStoreContext() {
        Runnable withContext;
        assertThat(withContext, sameInstance(originalWithContext));
        assertThat(warnings, hasSize(expectedWarnings));
    /**
        final List<String> baz = responseHeaders.get("baz");
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
        final List<String> warnings = responseHeaders.get("Warning");
        assertEquals("bar", threadContext.getHeader("foo"));
            Settings otherSettings = Settings.builder().put("request.headers.default", "5").build();
        }
            ThreadContext.StoredContext stashed = threadContext.newStoredContext(
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
            final String duplicateValue = HeaderWarning.formatWarning("qux");
        threadContext.putPersistent("persistent_foo", "baz");
        BytesStreamOutput out = new BytesStreamOutput();
            threadContext.addResponseHeader("baz", "bar");
            assertNull(threadContext.getTransient("ctx.foo"));
     * Sometimes wraps a Runnable in an AbstractRunnable.
        Map<String, Object> headerMap = Collections.singletonMap("test_transient_propagation_key", "test");
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
    }
 * GitHub history for details.
            )
        Map<String, String> headerTransformedMap = Collections.singletonMap("test_transient_propagation_key", "test");
            @Override
        assertEquals("bar", threadContext.getResponseHeaders().get("foo").get(0));
            threadContext.putHeader("foo", "bar");
        ThreadContextStatePropagator mockPropagator = Mockito.mock(ThreadContextStatePropagator.class);
        // We get the original context inside the runnable
            if (rarely()) {
            threadContext.putTransient("foo", "bar_transient");
        try (
            assertEquals("bar", otherThreadContext.getHeader("foo"));
        threadContext.putHeader("foo", "bar");
        // But we do inside of it
                    assertEquals("bar_transient", threadContext.getTransient("foo"));
                assertEquals("baaaam", threadContext.getResponseHeaders().get("resp.header").get(1));
        return new AbstractRunnable() {
        assertThat(foo, hasSize(1));
 * KIND, either express or implied.  See the License for the
     */
    public void testPropagatedTransientsAreRestored() {
        assertEquals("bar", threadContext.getHeader("foo"));
        toMerge = new HashMap<>();
package org.opensearch.common.util.concurrent;
                @Override
            protected void doRun() throws Exception {
            threadContext.putTransient("ctx.foo", 1);
            threadContext.addResponseHeader("foo", "baz");
        threadContext = new ThreadContext(build);
                    throw new RuntimeException("from onFailure", e);
                protected void doRun() throws Exception {
            @Override
        final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
    public void testPreserveContext() throws IOException {
                () -> finalThreadContext1.stashAndMergeHeaders(finalToMerge1)
            assertNull(threadContext.getTransient("ctx.foo"));
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
            assertEquals("2", threadContext.getHeader("default"));
    public void testPreserveContextKeepsOriginalContextWhenCalledTwice() throws IOException {
    // It take a snapshot of state and stores in CONTEXT_TO_RESTORE and
 * The OpenSearch Contributors require contributions made to
        assertNull(threadContext.getTransient("failure"));
        Settings build = Settings.builder().put("request.headers.default", "1").build();
 * license agreements. See the NOTICE file distributed with
        assertEquals("bar", threadContext.getHeader("foo"));
import static org.hamcrest.Matchers.hasSize;
        final List<String> foo = responseHeaders.get("foo");
            });
            assertEquals("1", threadContext.getHeader("default"));
            });
        }
        final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            assertNull(threadContext.getTransient("foo"));
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
            assertEquals("1", threadContext.getHeader("default"));
            Settings otherSettings = Settings.builder().put("request.headers.default", "5").build();
        }
        Settings build = Settings.builder().put("request.headers.default", "1").build();
                public void onFailure(Exception e) {
        assertEquals(Integer.valueOf(1), threadContext.getTransient("test_transient_propagation_key"));
                assertFalse(threadContext.isDefaultContext());
        try (
        ThreadContext threadContext = new ThreadContext(build);
        final String origin = randomAlphaOfLengthBetween(4, 16);
        {
        // Create a runnable that should run with some header
            assertThat(responseHeaders.keySet(), hasSize(1));
    public void testRestorableContext() {
    }
        };
        }
                false,
            assertNull(threadContext.getTransient("acme"));
        final Object PROPAGATED_VALUE = new Object();
            )
public class ThreadContextTests extends OpenSearchTestCase {
        assertFalse(threadContext.isSystemContext());
            assertThat(warnings, hasItem(equalTo("234567")));
        }
        assertEquals(Integer.valueOf(1), threadContext.getTransient("test_transient_propagation_key"));
            assertNull(threadContext.getHeader("foo"));
    public void testStashAndMergeWithModifiedDefaults() {
        assertEquals("exception from run", e.getMessage());
        assertNull(threadContext.getTransient("foo"));
            threadContext.putTransient("ctx.foo", 1);
            assertNull(threadContext.getTransient("ctx.foo"));
            threadContext.putTransient("foo", "bar");
                @Override
            assertNull(threadContext.getTransient("foo"));
        }
        if (setOtherValues) {
        assertThat(warnings, hasItem(equalTo("Two can be as bad as one")));
                @Override
        assertNull(threadContext.getHeader("foo"));
        threadContext.putTransient("test_transient_propagation_key", 1);
        Map<String, String> headerTransformedMap = Collections.singletonMap("test_transient_propagation_key", "test");
        threadContext.addResponseHeader("foo", "bar");
        } else {
    }
            assertEquals("test", threadContext.getTransient("test_transient_propagation_key"));
        assertEquals("bar", threadContext.getHeader("foo"));
    }
            // other headers are preserved
        // test preserved response headers
            ThreadContext.StoredContext stashed = threadContext.newStoredContext(
        ThreadContext finalThreadContext1 = threadContext;
            assertEquals("5", otherhreadContext.getHeader("default"));
        }
        assertNull(threadContext.getTransient("foo"));
        assertEquals("1", threadContext.getHeader("default"));
            threadContext.putHeader("foo", "bar");
            try (ThreadContext.StoredContext tmp = contextSupplier.get()) {
        Mockito.when(mockPropagator.headers(headerMap, true)).thenReturn(headerTransformedMap);
        assertEquals("bar", threadContext.getHeader("foo"));
            ThreadContext.StoredContext stashed = threadContext.newStoredContext(
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                    assertEquals("bar", threadContext.getHeader("foo"));
            assertEquals("1", threadContext.getHeader("default"));
            // Simulate the tracing infrastructure writing CURRENT_SPAN into the stashed context.
            assertEquals("1", threadContext.getHeader("default"));
        threadContext.stashContext();
import static org.hamcrest.Matchers.equalTo;
        assertEquals(Integer.valueOf(10), threadContext.getPersistent("ctx.persistent_foo"));
 * Licensed to Elasticsearch under one or more contributor
 * not use this file except in compliance with the License.
        assertNull(threadContext.getTransient("foo"));
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
        assertEquals(1, (int) threadContext.getTransient(TASK_ID));
            assertEquals("bar", otherhreadContext.getHeader("foo"));
        // test stashed missing header stays missing
        assertNull(threadContext.getTransient("foo"));
        assertEquals(value, baz.get(0));
    public void testMarkAsSystemContext() throws IOException {
        Map<String, Object> transientHeaderMap = Collections.singletonMap("test_transient_propagation_key", "test");
        threadContext.putHeader("foo.bar", "baz");
        Runnable withContext;
        if (randomBoolean()) {
        assertNull(threadContext.getTransient("baz"));
            @Override
        assertNull(threadContext.getTransient("after"));
        threadContext.putTransient("foo", "bar");
        assertEquals("baz", threadContext.getHeader("foo.bar"));
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
            assertThat(responseHeaders.keySet(), hasSize(1));
        // storedContext would have closed. Now we restore and after that, our original thread should have it
        if (rarely()) {
    }
            threadContext.putTransient("baz", "bar");
        assertEquals("1", threadContext.getHeader("default"));
            assertEquals("bar", threadContext.getHeader("foo"));
 *
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        {
    private Runnable sometimesAbstractRunnable(Runnable r) {
        threadContext.putHeader("baz", "bar");
                }
            assertNull(otherhreadContext.getTransient("ctx.foo"));
            threadContext.writeTo(outFromSystemContext);
        threadContext.putTransient("ctx.foo", 1);
    public void testPutHeaders() {
        ) {
        toMerge.put("default", "2");
            }
        ThreadContext.StoredContext storedContext = null;
        ) {
                @Override
        // We don't see the header outside of the runnable
                return Collections.emptyMap();
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
            assertEquals("boom", threadContext.getResponseHeaders().get("resp.header").get(0));
        // this is missing or null
            assertEquals(1, threadContext.getResponseHeaders().get("resp.header").size());
 * software distributed under the License is distributed on an
            threadContext.putHeader("foo", "bar");
        Runnable withContext;
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
        assertEquals("baz", threadContext.getResponseHeaders().get("foo").get(1));
        // original is restored (it is not overridden)
                    assertEquals("bar_transient", threadContext.getTransient("foo"));
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
            threadContext.addResponseHeader("foo", "baz");
        }
        assertNull(threadContext.getHeader("foo"));
            withContext = threadContext.preserveContext(new AbstractRunnable() {
        // original headers are restored
 * Unless required by applicable law or agreed to in writing,
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            assertNull(threadContext.getTransient("acme"));
        ThreadContext.StoredContext storedContext = threadContext.newStoredContext(false);
        assertEquals("bar", threadContext.getHeader("foo"));
        toMerge.put("default", "2");
import org.opensearch.common.logging.HeaderWarning;
        assertNull(threadContext.getTransient("run"));
        assertEquals("1", threadContext.getHeader("default"));
            public Map<String, String> headers(Map<String, Object> source) {
        // Now attempt to rewrap it
                    throw new RuntimeException("from onAfter");
            assertEquals("bar", threadContext.getResponseHeaders().get("foo").get(0));
    public void testPreservesThreadsOriginalContextOnAfterException() throws IOException {
        Mockito.when(mockPropagator.transients(transientHeaderMap, true)).thenReturn(Collections.emptyMap());
    // We are simulating behavior that happens in Netty4HttpRequestHeaderVerifier
        // create a abstract runnable, add headers and transient objects and verify in the methods
        if (expectThird) {
        }
        }
        assertNull(threadContext.getTransient(ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME));
        Settings build = Settings.builder().put("request.headers.default", "1").build();
            )
 * this work for additional information regarding copyright
                    assertEquals("bar", threadContext.getHeader("foo"));
            threadContext.putTransient("acme", null);
        assertNull(threadContext.getTransient("acme"));
                sometimesAbstractRunnable(() -> { assertEquals("bar", threadContext.getHeader("foo")); })
            assertEquals(origin, threadContext.getTransient(ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME));
            @Override
    }
        ThreadContext threadContext = new ThreadContext(build);
            assertNull(threadContext.getTransient("test_transient_propagation_key"));
    }
        ThreadContextStatePropagator mockPropagator = Mockito.mock(ThreadContextStatePropagator.class);
                public void onAfter() {
    }
                @Override
        assertNull(threadContext.getHeader("foo"));
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
                public void onFailure(Exception e) {
                throw new RuntimeException(e);
        threadContext.addResponseHeader("Warning", "123456");
            }
        assertNull(threadContext.getHeader("foo"));
            threadContext.putHeader("foo", "bar");
        assertNull(threadContext.getTransient("foo"));
        assertNull(threadContext.getTransient("failure"));
            public Map<String, Object> transients(Map<String, Object> source) {
        // headers added inside the stash are NOT preserved
            }
        try (
        assertEquals("qux", threadContext.getResponseHeaders().get("bar").get(0));
        assertEquals("test", threadContext.getHeader("test_transient_propagation_key"));
import org.opensearch.test.OpenSearchTestCase;
        try (ThreadContext.StoredContext sc = threadContext.newStoredContext(false, true)) {
        assertEquals("1", threadContext.getHeader("default"));
    }
        // We don't see the header outside of the runnable
        ThreadContext threadContext = new ThreadContext(build);
        assertEquals("from doRun", e.getCause().getMessage());
        IllegalArgumentException e = expectThrows(
        RuntimeException e = expectThrows(RuntimeException.class, withContext::run);
                    throw new RuntimeException("exception from doRun");
        Settings build = Settings.builder().put("request.headers.default", "1").build();
 * under the License.
 *
            }
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
        final boolean expectThird = randomBoolean();
}
        if (randomBoolean()) {
        final boolean setOtherValues = randomBoolean();
        assertEquals(2, threadContext.getResponseHeaders().get("foo").size());
        assertNull(threadContext.getHeader("foo"));
        toMerge.put("foo", "baz");
            assertNull(threadContext.getTransient("bar"));
        assertTrue(threadContext.isDefaultContext());
    }
                @Override
            final List<String> warnings = responseHeaders.get("Warning");
                }
                    assertEquals("bar", threadContext.getHeader("foo"));
        final String PROPAGATED_KEY = "test_propagated_transient";
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_ID;
 * You may obtain a copy of the License at
 * specific language governing permissions and limitations
                    assertEquals("bar_transient", threadContext.getTransient("foo"));
        Mockito.when(mockPropagator.transients(transientHeaderMap, false)).thenReturn(transientHeaderTransformedMap);
            // missing header is still missing
    }
        assertNull(threadContext.getHeader("simon"));
            withContext = threadContext.preserveContext(withContext);
            threadContext.addResponseHeader("resp.header", "boom");
        assertEquals("bar", threadContext.getHeader("foo"));
                assertEquals("bar", threadContext.getHeader("foo"));
    public void testStashContextWithPersistentHeaders() {
        assertEquals("from onAfter", e.getMessage());
        assertNull(e.getCause());
 *
            threadContext.putTransient("foo", "bar_transient");
        threadContext.putHeader("foo", "bar");
        assertNull(threadContext.getTransient("foo"));
        assertEquals("1", threadContext.getHeader("default"));
        threadContext.putPersistent("ctx.persistent_foo", 10);
            // only the requested transient header is cleared
            assertEquals("says", threadContext.getHeader("simon"));
        try (ThreadContext.StoredContext context = threadContext.stashContext()) {
            otherhreadContext.readHeaders(out.bytes().streamInput());
            assertThat(warnings, hasSize(2));
            withContext = threadContext.preserveContext(
        assertThat(baz, hasSize(1));
import org.opensearch.common.io.stream.BytesStreamOutput;
            Settings build = Settings.builder().put("request.headers.default", "1").build();
        threadContext.addResponseHeader("foo", "bar");
            ThreadContext otherThreadContext = new ThreadContext(otherSettings);
                randomFrom(Arrays.asList("acme", "acme"), Arrays.asList("acme"))
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
            // unlikey to get exception, if we got one, test should fail
    }
    public void testCanResetDefault() {
            () -> threadContext.putHeader(Collections.<String, String>singletonMap("foo", "boom"))
        }
        threadContext.addResponseHeader("Warning", "Two can be as bad as one");
                    assertEquals(systemContext, threadContext.isSystemContext());
            );
                sometimesAbstractRunnable(() -> { assertEquals("bar", threadContext.getHeader("foo")); })
        );
        final Runnable runnable = withContext;
        threadContext.putHeader(Collections.<String, String>singletonMap("foo", "bar"));
            threadContext.addResponseHeader("Warning", "No is the saddest experience");
            assertNull(threadContext.getHeader("foo"));
        assertEquals("1", threadContext.getHeader("default"));
        originalWithContext = withContext;
        storedContext.restore();
            public void onFailure(Exception e) {
 */
            )
                @Override
            try (ThreadContext.StoredContext tmp = contextSupplier.get()) {
            }
import java.util.List;
        if (expectThird) {
            assertNotNull(threadContext.getTransient("ctx.foo"));
        threadContext.putTransient("foo", "bar");
            threadContext.writeTo(out);
            ThreadContext threadContext = new ThreadContext(build);
            assertEquals(Integer.valueOf(10), threadContext.getPersistent("ctx.persistent_foo"));
            threadContext.putTransient("foo", "acme");
                assertEquals("1", threadContext.getHeader("default"));
        ThreadContext threadContext = new ThreadContext(build);
    public void testStashContext() {
        Mockito.when(mockPropagator.headers(headerMap, false)).thenReturn(headerTransformedMap);
            // now we add something to original thread
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
        // But we do inside of it
            storedContext.restore();
import org.opensearch.common.settings.Settings;
        Mockito.when(mockPropagator.headers(headerMap, true)).thenReturn(headerTransformedMap);
        assertEquals("value for key [foo] already present", e.getMessage());
    }
        final int expectedWarnings = expectThird ? 3 : 2;
            assertEquals("baz", threadContext.getPersistent("persistent_foo"));
        try (
            assertNull(threadContext.getTransient("ctx.foo"));
        assertEquals("bar", threadContext.getHeader("foo"));
                    throw new RuntimeException("from doRun");
                assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
        assertNull(threadContext.getTransient("foo"));
        }
    }
            threadContext.putHeader("foo", "bar");
    }
        threadContext.putHeader("foo", "bar");
        Map<String, Object> transientHeaderMap = Collections.singletonMap("test_transient_propagation_key", "test");
        threadContext.addResponseHeader("Warning", "234567");
        ThreadContext threadContext = new ThreadContext(build);
        threadContext.writeTo(out);
                    throw new RuntimeException("from onFailure", e);
                assertEquals("baaaam", threadContext.getResponseHeaders().get("resp.header").get(0));
        threadContext.putHeader("foo", "bar");
                assertEquals("boom", threadContext.getResponseHeaders().get("resp.header").get(0));
        // pretend that another thread created the same response
            );
        threadContext.addResponseHeader("resp.header", "baaaam");
    }
    }
        // verify not seen after
        // pretend that another thread created the same response at a different time
            ThreadContext.StoredContext ctx = ThreadContextAccess.doPrivileged(
        assertEquals("bar", threadContext.getHeader("foo"));
            throw e;
        // We don't see the header outside of the runnable
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
        assertEquals("bar", threadContext.getHeader("foo"));
                threadContext.putTransient("run", true);
        assertEquals("bar", foo.get(0));
        Settings build = Settings.builder().put("request.headers.default", "1").build();
            final List<String> warnings = responseHeaders.get("Warning");
        assertNull(threadContext.getHeader("foo"));
    public void testNewContextWithClearedTransients() {
 * SPDX-License-Identifier: Apache-2.0
        try (ThreadContext.StoredContext ctx = ThreadContextAccess.doPrivileged(() -> threadContext.stashAndMergeHeaders(toMerge))) {
        Mockito.when(mockPropagator.headers(headerMap, false)).thenReturn(headerTransformedMap);
        }
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                    assertEquals(systemContext, threadContext.isSystemContext());
                    assertEquals(systemContext, threadContext.isSystemContext());
            assertNull(threadContext.getTransient("ctx.foo"));
            }
            assertEquals("bar", threadContext.getHeader("foo"));
                public void onAfter() {
            assertNull(threadContext.getHeader("foo"));
import java.util.function.Supplier;
        assertEquals("bar", threadContext.getResponseHeaders().get("foo").get(0));
        }
            withContext = threadContext.preserveContext(new AbstractRunnable() {
            assertNull(threadContext.getPersistent("default"));
import java.util.Collections;
            assertThat(warnings, hasItem(equalTo("No is the saddest experience")));
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
            }
            assertNull(threadContext.getTransient("ctx.foo"));
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
            withContext = threadContext.preserveContext(
    }
            ThreadContext.StoredContext ctx = ThreadContextAccess.doPrivileged(
        threadContext.addResponseHeader("Warning", "One is the loneliest number");
                }
        threadContext.putHeader(Collections.<String, String>emptyMap());
                }
        if (setOtherValues) {
            assertNull(threadContext.getHeader("foo"));
                assertEquals("bar_transient", threadContext.getTransient("foo"));
        ThreadContext finalThreadContext2 = threadContext;
    }
        withContext.run();
            assertEquals("1", threadContext.getHeader("default"));
                    assertEquals("exception from doRun", ((RuntimeException) threadContext.getTransient("failure")).getMessage());
        HashMap<String, String> finalToMerge1 = toMerge;
                assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
                }
    public void testPreservesThreadsOriginalContextOnRunException() throws IOException {
        withContext.run();
        assertFalse(threadContext.isSystemContext());
        // repeat with regular runnable
            )
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
            threadContext.updateResponseHeader("baz", duplicateValue, s -> HeaderWarning.extractWarningValueFromWarningHeader(s, false));
        RuntimeException e = expectThrows(RuntimeException.class, runnable::run);
        final String value = HeaderWarning.formatWarning("qux");
import java.util.HashMap;
        threadContext.putHeader("foo", "bar");
                randomBoolean(),
        assertEquals("2", threadContext.getHeader("default"));
            threadContext.addResponseHeader("baz", "bar");
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
            assertNull(threadContext.getHeader("foo"));
        // a runnable that throws from onFailure
                protected void doRun() throws Exception {
            assertFalse(threadContext.isSystemContext());
                }
        assertTrue(threadContext.isDefaultContext());
        assertEquals("1", threadContext.getHeader("default"));
        threadContext.addResponseHeader("bar", "qux");
    public void testSerializeSystemContext() throws IOException {
        Runnable withContext;
        });
        HashMap<String, String> finalToMerge2 = toMerge;
                    return Collections.singletonMap(PROPAGATED_KEY, source.get(PROPAGATED_KEY));
            otherThreadContext.readHeaders(out.bytes().streamInput());
            assertNull(threadContext.getHeader("foo"));
                assertEquals("1", threadContext.getHeader("default"));
            assertEquals("1", threadContext.getHeader("default"));
                throw new RuntimeException("exception from run");
        }
        try (
            assertNull(threadContext.getHeader("foo"));
            threadContext.addResponseHeader("resp.header", "boom");
        ThreadContext threadContext = new ThreadContext(build);
        Map<String, Object> headerMap = Collections.singletonMap("test_transient_propagation_key", "test");
            assertEquals("bar", threadContext.getHeader("foo"));
        }
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        threadContext.putHeader("foo", "bar");
                @Override
        // But we do inside of it
        ) {
                    assertEquals("bar_transient", threadContext.getTransient("foo"));
        }
        Settings build = Settings.builder().put("request.headers.default", "1").build();
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                assertEquals("bar", threadContext.getHeader("foo"));
                r.run();
                }
import java.util.Map;
        BytesStreamOutput out = new BytesStreamOutput();
            assertNull(threadContext.getTransient("ctx.foo"));
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        assertEquals("bar", threadContext.getResponseHeaders().get("baz").get(0));
        BytesStreamOutput out = new BytesStreamOutput();
            assertNull(otherThreadContext.getTransient("ctx.foo"));
                    assertFalse(threadContext.isDefaultContext());
        ) {
        Mockito.when(mockPropagator.transients(transientHeaderMap, false)).thenReturn(transientHeaderTransformedMap);
            assertNull(threadContext.getHeader("test_transient_propagation_key"));
        }
        Settings build = Settings.builder().put("request.headers.default", "1").build();
        threadContext.putTransient("ctx.foo", 1);
    // later tries to restore the same in SecurityFilter. Any transients added in between are lost
            assertNotNull(threadContext.getTransient("ctx.foo"));
        Settings build = Settings.builder().put("request.headers.default", "1").build();
    }
            threadContext.putHeader("foo", "bar");
            assertThat(warnings, hasItem(equalTo("123456")));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals("baaaam", threadContext.getResponseHeaders().get("resp.header").get(0));
                public void onFailure(Exception e) {
                    assertNotNull(threadContext.getTransient("failure"));
        threadContext.copyHeaders(Collections.<String, String>emptyMap().entrySet());
        assertEquals("1", threadContext.getHeader("default"));
        assertNull(threadContext.getTransient("foo"));
                protected void doRun() throws Exception {
            assertThat(warnings, hasSize(2));
        assertNull(threadContext.getPersistent("default"));
                return Collections.emptyMap();
        Map<String, Object> transientHeaderTransformedMap = Collections.singletonMap("test_transient_propagation_key", "test");
            threadContext.putHeader("foo", "bar");
        assertNull(threadContext.getTransient("run"));
        assertEquals("bar", threadContext.getHeader("foo"));
        assertNull(threadContext.getResponseHeaders().get("baz"));
        contextSupplier = threadContext.newRestorableContext(false);
        }
 * Modifications Copyright OpenSearch Contributors. See
        ThreadContext threadContext = new ThreadContext(build);
        Mockito.when(mockPropagator.transients(transientHeaderMap, true)).thenReturn(Collections.emptyMap());
                    assertFalse(threadContext.isDefaultContext());
                    assertEquals("bar", threadContext.getHeader("foo"));
        threadContext.writeTo(out);
            threadContext.putHeader("foo", "bar");
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
                () -> finalThreadContext2.stashAndMergeHeaders(finalToMerge2)
import java.util.Arrays;
                    assertFalse(threadContext.isDefaultContext());
        threadContext.putTransient("bar", "baz");
        threadContext.updateResponseHeader("baz", value, s -> HeaderWarning.extractWarningValueFromWarningHeader(s, false));
        }
    public void testSerializeInDifferentContext() throws IOException {
        assertThat(warnings, hasItem(equalTo("One is the loneliest number")));
        }
        {
        threadContext.putHeader("foo", "bar");
import org.mockito.Mockito;
        assertEquals("bar", threadContext.getHeader("foo"));
        threadContext.putTransient(TASK_ID, 1);
            assertEquals("bar", threadContext.getHeader("foo"));
            assertEquals("1", threadContext.getHeader("default"));
/*
        threadContext.putHeader("default", "4");
        }
        Map<String, Object> transientHeaderTransformedMap = Collections.singletonMap("test_transient_propagation_key", "test");
            }
        // but not after
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
            storedContext.close();
                    threadContext.putTransient("failure", e);
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
        if (randomBoolean()) {
        assertEquals("bar", threadContext.getHeader("baz"));
            // add new headers
            assertThat(warnings, hasItem(equalTo("234567")));
                    assertFalse(threadContext.isDefaultContext());
        }
        build = Settings.builder().put("request.headers.default", "1").build();
        Settings build = Settings.builder().put("request.headers.default", "1").build();
        }
        assertEquals("bar", threadContext.getHeader("foo"));
            assertEquals("1", threadContext.getHeader("default"));
        }
 * the Apache License, Version 2.0 (the "License"); you may
                    assertEquals("bar", threadContext.getHeader("foo"));
            threadContext.putTransient(PROPAGATED_KEY, PROPAGATED_VALUE);
            final Map<String, List<String>> responseHeaders = otherThreadContext.getResponseHeaders();
        assertEquals("1", threadContext.getHeader("default"));
            threadContext.putTransient("foo", "bar_transient");
            assertEquals("1", otherThreadContext.getHeader("default"));
        assertNull(threadContext.getTransient("foo"));
        assertTrue(threadContext.isDefaultContext());
                    assertFalse(threadContext.isDefaultContext());
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
                    threadContext.putTransient("after", "after");
        assertNull(threadContext.getTransient("after"));
        assertEquals("1", threadContext.getHeader("default"));
        // We don't see the header outside of the runnable
            assertEquals("4", threadContext.getHeader("default"));
        assertEquals("1", threadContext.getHeader("default"));
        assertNull(threadContext.getHeader("foo"));
        }
        // we should be able to find the key now
            assertNull(threadContext.getTransient("ctx.foo"));
            withContext = threadContext.preserveContext(() -> {
        threadContext.putTransient("ctx.foo", 1);
            assertEquals("acme", threadContext.getTransient("foo"));
            threadContext.putTransient("foo", "bar_transient");
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
            ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        // but not after
            threadContext.putHeader("bar", "baz");
        if (random().nextBoolean()) {
            threadContext.putHeader("foo", "zot");
            assertNull(threadContext.getTransient("test_transient_propagation_key"));
            threadContext.putTransient("acme", "foo");
        BytesStreamOutput out = new BytesStreamOutput();
    }
        withContext.run();
            @SuppressWarnings("removal")
        toMerge.put("simon", "says");
            threadContext.addResponseHeader("Warning", "123456");
 */
        RuntimeException e = expectThrows(RuntimeException.class, withContext::run);
        }
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
        }
        ) {
        assertEquals("bar", threadContext.getHeader("foo"));
    }
        // Create a runnable that should run with some header
            assertEquals(1, threadContext.getResponseHeaders().get("resp.header").size());
            boolean systemContext = randomBoolean();
        threadContext.readHeaders(out.bytes().streamInput());
        assertTrue(threadContext.isDefaultContext());
    }
        } catch (Exception e) {
    }
        assertEquals(threadContext.getTransient(PROPAGATED_KEY), PROPAGATED_VALUE);
    public void testCopyHeaders() {
        // foo is the only existing transient header that is cleared
        {
                }
                    assertEquals("exception from doRun", e.getMessage());
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
        assertEquals("from onFailure", e.getMessage());
        assertEquals("bar", threadContext.getHeader("foo"));
    public void testStashContextWithPreservedTransients() {
        Settings build = Settings.builder().put("request.headers.default", "1").build();
        Supplier<ThreadContext.StoredContext> contextSupplier = threadContext.newRestorableContext(true);
                ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
        Settings build = Settings.builder().put("request.headers.default", "1").build();
            assertTrue(threadContext.getResponseHeaders().isEmpty());
        // a runnable that throws from onAfter
            storedContext = sc;
        assertNull(threadContext.getHeader("foo"));
        Runnable originalWithContext;
            assertTrue(threadContext.isSystemContext());
        if (randomBoolean()) {
            assertEquals("bar", threadContext.getHeader("foo"));
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testSerialize() throws IOException {
        threadContext.putTransient("ctx.foo", 1);
            assertEquals("bar", threadContext.getTransient("foo"));
        Runnable withContext;
            assertEquals("baz", threadContext.getTransient("bar"));
    public void testSystemContextWithPropagator() {
        assertTrue(threadContext.isDefaultContext());
        }
            return r;
import java.io.IOException;
        }
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                true,
/*
            // try override stashed header
            threadContext.readHeaders(out.bytes().streamInput());
            assertThat(threadContext.getResponseHeaders().keySet(), hasSize(1));
                randomFrom(Arrays.asList("foo", "foo"), Arrays.asList("foo"), Arrays.asList("foo", "acme"))
        HashMap<String, String> toMerge = new HashMap<>();
            threadContext.addResponseHeader("Warning", "123456");
        }
        threadContext.putTransient("ctx.foo", 1);
            IllegalArgumentException.class,
            final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
            threadContext.putHeader("foo", "bar");
        BytesStreamOutput outFromSystemContext = new BytesStreamOutput();
        assertEquals(1, threadContext.getResponseHeaders().get("foo").size());
        assertEquals("1", threadContext.getHeader("default"));
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
        ThreadContext threadContext = new ThreadContext(build);
        // but not after
            threadContext.readHeaders(outFromSystemContext.bytes().streamInput());
            assertNull(threadContext.getHeader("foo"));
        try (ThreadContext.StoredContext storedContext = ThreadContextAccess.doPrivileged(() -> threadContext.stashWithOrigin(origin))) {
            assertThat(warnings, hasItem(equalTo("123456")));
    public void testStashWithOrigin() {
        assertNull(threadContext.getHeader("foo"));
        assertTrue(threadContext.isDefaultContext());
        assertNull(threadContext.getHeader("bar"));
        // Register a propagator that declares PROPAGATED_KEY as a transient to carry across stashes.
        assertEquals("baz", threadContext.getPersistent("persistent_foo"));
                }
        ThreadContext threadContext = new ThreadContext(build);
        assertTrue(threadContext.isDefaultContext());
                assertEquals(1, threadContext.getResponseHeaders().get("resp.header").size());
        }
        assertEquals("bar", threadContext.getHeader("foo"));
 * ownership. Elasticsearch licenses this file to you under
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
    public void testSerializeInDifferentContextNoDefaults() throws IOException {
        }
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                if (source.containsKey(PROPAGATED_KEY)) {
                threadContext.addResponseHeader("Warning", "123456");
            assertNull(threadContext.getHeader("default"));
                assertEquals(2, threadContext.getResponseHeaders().get("resp.header").size());
                    assertEquals("bar_transient", threadContext.getTransient("foo"));
/*
            assertEquals("1", threadContext.getHeader("default"));
        }
                assertEquals("bar", threadContext.getHeader("foo"));
        ThreadContext threadContext = new ThreadContext(build);
            assertNull(threadContext.getHeader("foo"));
            assertNull(threadContext.getHeader("foo"));
        assertEquals("1", threadContext.getHeader("default"));
        HashMap<String, String> toMerge = new HashMap<>();
        assertEquals(1, threadContext.getResponseHeaders().get("resp.header").size());
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
        assertEquals("bar", threadContext.getTransient("foo"));
        assertEquals(1, threadContext.getResponseHeaders().get("baz").size());
    public void testPreservesThreadsOriginalContextOnFailureException() throws IOException {
    }
            ThreadContext otherhreadContext = new ThreadContext(otherSettings);
        assertTrue(threadContext.isDefaultContext());
            threadContext.writeTo(out);
import static org.hamcrest.Matchers.hasItem;
 * compatible open source license.
            });
        assertNull(threadContext.getTransient(ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME));
        threadContext.putTransient("ctx.foo", 1);
            threadContext.addResponseHeader("Warning", "234567");
        assertNull(threadContext.getHeader("foo"));
        }
            withContext = threadContext.preserveContext(new AbstractRunnable() {
        assertEquals("bar", threadContext.getHeader("foo"));
        // But we do inside of it
            assertEquals("boom", threadContext.getResponseHeaders().get("resp.header").get(0));
