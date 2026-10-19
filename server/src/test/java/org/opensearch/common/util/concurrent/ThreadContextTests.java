        assertEquals(Integer.valueOf(1), threadContext.getTransient("test_transient_propagation_key"));
        ThreadContext threadContext = new ThreadContext(build);
        }  
                threadContext.putTransient("run", true);
            assertNull(threadContext.getHeader("foo"));
            threadContext.putHeader("foo", "bar");
                randomFrom(Arrays.asList("foo", "foo"), Arrays.asList("foo"), Arrays.asList("foo", "acme"))
        }
        final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                public void onAfter() {  
        assertEquals("bar", threadContext.getHeader("foo"));  
        }
        Runnable withContext;
            threadContext.writeTo(outFromSystemContext);
                @Override
        final String origin = randomAlphaOfLengthBetween(4, 16);  
        Map<String, String> headerTransformedMap = Collections.singletonMap("test_transient_propagation_key", "test");
        Settings build = Settings.builder().put("request.headers.default", "1").build();
            // Simulate the tracing infrastructure writing CURRENT_SPAN into the stashed context.
        assertEquals("1", threadContext.getHeader("default"));  
        assertEquals("1", threadContext.getHeader("default"));
            )
    }
        HashMap<String, String> finalToMerge1 = toMerge;
 */  
            threadContext.putTransient("foo", "bar_transient");
        }
            assertEquals("bar", otherThreadContext.getHeader("foo"));
                    assertFalse(threadContext.isDefaultContext());
            assertNull(otherThreadContext.getTransient("ctx.foo"));  
            assertNull(threadContext.getHeader("foo"));
                    assertEquals("bar_transient", threadContext.getTransient("foo"));  
        // create a abstract runnable, add headers and transient objects and verify in the methods
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {  
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
    /**  
    public void testSerializeInDifferentContext() throws IOException {
        assertEquals("bar", threadContext.getResponseHeaders().get("foo").get(0));
                false,
        if (randomBoolean()) {
        }
            ThreadContext.StoredContext stashed = threadContext.newStoredContext(  
import org.mockito.Mockito;
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
                    assertFalse(threadContext.isDefaultContext());
                    assertEquals("bar", threadContext.getHeader("foo"));
                }
        threadContext = new ThreadContext(build);
            assertEquals("bar", threadContext.getHeader("foo"));
                    assertEquals("exception from doRun", ((RuntimeException) threadContext.getTransient("failure")).getMessage());
        assertEquals("test", threadContext.getHeader("test_transient_propagation_key"));
    public void testMarkAsSystemContext() throws IOException {
            public Map<String, String> headers(Map<String, Object> source) {
        }  
    public void testStashAndMerge() {  
        threadContext.putHeader("foo", "bar");  
    private Runnable sometimesAbstractRunnable(Runnable r) {  
            });
                }
        // test preserved response headers  
        threadContext.putTransient("test_transient_propagation_key", "test");  
            threadContext.putHeader("foo", "bar");
            ThreadContext otherThreadContext = new ThreadContext(otherSettings);
                    assertFalse(threadContext.isDefaultContext());
        Settings build = Settings.builder().put("request.headers.default", "1").build();
        // Now attempt to rewrap it
import java.util.HashMap;
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
        threadContext.copyHeaders(Collections.<String, String>emptyMap().entrySet());  
            assertNull(threadContext.getTransient("test_transient_propagation_key"));  
        assertEquals("from onFailure", e.getMessage());
        );
        final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        assertNull(e.getCause());
        threadContext.putTransient("ctx.foo", 1);  
        }  
                public void onAfter() {  
                assertEquals("boom", threadContext.getResponseHeaders().get("resp.header").get(0));  
        final List<String> baz = responseHeaders.get("baz");
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
            assertEquals("acme", threadContext.getTransient("foo"));  
        assertEquals("1", threadContext.getHeader("default"));
            withContext = threadContext.preserveContext(  
import org.opensearch.test.OpenSearchTestCase;  
            if (systemContext) {
    }
                    assertEquals(systemContext, threadContext.isSystemContext());  
                    assertFalse(threadContext.isDefaultContext());  
            assertNull(threadContext.getHeader("foo"));
        assertNull(threadContext.getTransient("acme"));
            assertEquals("1", otherThreadContext.getHeader("default"));
        assertThat(withContext, sameInstance(originalWithContext));  
            if (rarely()) {
        assertNull(threadContext.getTransient("after"));
            Settings build = Settings.builder().put("request.headers.default", "1").build();
            }
            threadContext.addResponseHeader("foo", "baz");
    }
 * this work for additional information regarding copyright
        assertEquals("1", threadContext.getHeader("default"));
 * compatible open source license.
        assertEquals("bar", threadContext.getHeader("foo"));  
/*
            assertEquals("test", threadContext.getTransient("test_transient_propagation_key"));
        // Register a propagator that declares PROPAGATED_KEY as a transient to carry across stashes.
        ThreadContext threadContext = new ThreadContext(build);
        if (random().nextBoolean()) {
        threadContext.putHeader("foo", "bar");
            threadContext.updateResponseHeader("baz", duplicateValue, s -> HeaderWarning.extractWarningValueFromWarningHeader(s, false));
            assertNull(threadContext.getHeader("test_transient_propagation_key"));
            assertEquals("says", threadContext.getHeader("simon"));
        threadContext.addResponseHeader("bar", "qux");  
        if (randomBoolean()) {  
        assertEquals("bar", threadContext.getHeader("foo"));
        assertEquals("bar", threadContext.getHeader("foo"));
                    throw new RuntimeException("from doRun");
import static org.hamcrest.Matchers.sameInstance;
        threadContext.putHeader("foo.bar", "baz");  
            assertEquals("1", threadContext.getHeader("default"));
        final boolean expectThird = randomBoolean();
    public void testSerializeSystemContext() throws IOException {  
        originalWithContext = withContext;
                r.run();  
            assertTrue(threadContext.getResponseHeaders().isEmpty());  
            }
        // repeat with regular runnable  
            assertEquals("1", threadContext.getHeader("default"));
            assertNull(threadContext.getTransient("ctx.foo"));
        assertEquals("bar", foo.get(0));
            assertNull(threadContext.getHeader("foo"));  
            storedContext.close();
            assertNull(threadContext.getHeader("foo"));
            assertEquals("bar", threadContext.getHeader("foo"));
        assertNull(threadContext.getTransient("after"));  
        Mockito.when(mockPropagator.headers(headerMap, true)).thenReturn(headerTransformedMap);
        assertNull(threadContext.getHeader("foo"));
            public Map<String, Object> transients(Map<String, Object> source) {
        assertTrue(threadContext.isDefaultContext());  
        threadContext.putHeader("foo", "bar");
        assertEquals(1, threadContext.getResponseHeaders().get("baz").size());
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);  
        assertEquals("bar", threadContext.getTransient("foo"));  
                }
        assertNull(threadContext.getTransient("baz"));
            assertEquals("bar", threadContext.getHeader("foo"));
        assertEquals(threadContext.getTransient(PROPAGATED_KEY), PROPAGATED_VALUE);
        assertTrue(threadContext.isDefaultContext());  
        assertNull(threadContext.getPersistent("default"));
        }
    public void testPreserveContext() throws IOException {
        assertEquals(Integer.valueOf(1), threadContext.getTransient("test_transient_propagation_key"));
        Map<String, Object> headerMap = Collections.singletonMap("test_transient_propagation_key", "test");
        assertNull(threadContext.getHeader("foo"));
        Map<String, Object> transientHeaderMap = Collections.singletonMap("test_transient_propagation_key", "test");
            threadContext.readHeaders(outFromSystemContext.bytes().streamInput());
            protected void doRun() throws Exception {
import static org.hamcrest.Matchers.equalTo;
     */
    }
                    return Collections.singletonMap(PROPAGATED_KEY, source.get(PROPAGATED_KEY));
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
            @SuppressWarnings("removal")
        Supplier<ThreadContext.StoredContext> contextSupplier = threadContext.newRestorableContext(true);
    public void testStashAndMergeWithModifiedDefaults() {
                randomFrom(Arrays.asList("acme", "acme"), Arrays.asList("acme"))
            ThreadContext threadContext = new ThreadContext(build);  
        ThreadContext finalThreadContext1 = threadContext;  
            storedContext.restore();  
        assertNull(threadContext.getTransient("failure"));
 *     http://www.apache.org/licenses/LICENSE-2.0
        build = Settings.builder().put("request.headers.default", "1").build();
        try (
        ) {  
        toMerge.put("default", "2");
        }
        Settings build = Settings.builder().put("request.headers.default", "1").build();
 * ownership. Elasticsearch licenses this file to you under  
            assertNull(threadContext.getTransient("acme"));
            ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            assertThat(warnings, hasItem(equalTo("234567")));
 *
        assertNull(threadContext.getTransient("foo"));  
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
                @Override
            }
            // other headers are preserved  
        }  
            assertEquals("1", threadContext.getHeader("default"));
        threadContext.putTransient("ctx.foo", 1);
        } catch (Exception e) {
        assertEquals("baaaam", threadContext.getResponseHeaders().get("resp.header").get(0));  
            try (ThreadContext.StoredContext tmp = contextSupplier.get()) {
    }
                assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));  
        assertEquals("baaaam", threadContext.getResponseHeaders().get("resp.header").get(0));
                protected void doRun() throws Exception {
            threadContext.addResponseHeader("Warning", "123456");  
        Runnable withContext;  
    public void testStoreContext() {  
        assertEquals("2", threadContext.getHeader("default"));
            Settings otherSettings = Settings.builder().put("request.headers.default", "5").build();
        }
import org.opensearch.common.io.stream.BytesStreamOutput;  
}
 * GitHub history for details.
        return new AbstractRunnable() {
    public void testPreservesThreadsOriginalContextOnFailureException() throws IOException {  
            assertEquals("qux", threadContext.getResponseHeaders().get("bar").get(0));
        threadContext.addResponseHeader("Warning", "One is the loneliest number");
            threadContext.putHeader("foo", "bar");  
            });
            // try override stashed header
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
            }
        assertThat(foo, hasSize(1));
        assertNull(threadContext.getTransient(ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME));  
                @Override
        contextSupplier = threadContext.newRestorableContext(false);
        assertEquals("1", threadContext.getHeader("default"));  
        assertEquals("test", threadContext.getTransient("test_transient_propagation_key"));
            assertNull(threadContext.getTransient("test_transient_propagation_key"));  
        {
        }
            assertEquals("1", threadContext.getHeader("default"));  
        Mockito.when(mockPropagator.transients(transientHeaderMap, false)).thenReturn(transientHeaderTransformedMap);  
        // verify not seen after
            assertThat(warnings, hasSize(2));
            @Override
        // But we do inside of it
        }
        final Runnable runnable = withContext;  
            );
        Runnable withContext;  
        threadContext.putHeader("foo", "bar");  
        assertNull(threadContext.getHeader("foo"));
                    assertEquals("bar", threadContext.getHeader("foo"));
        {
                true,  
            assertNull(threadContext.getTransient("ctx.foo"));
            @Override  
        threadContext.registerThreadContextStatePropagator(new ThreadContextStatePropagator() {
            assertNotNull(threadContext.getTransient("ctx.foo"));
            return r;
            final List<String> warnings = responseHeaders.get("Warning");
    }
            threadContext.addResponseHeader("Warning", "No is the saddest experience");
        assertNull(threadContext.getTransient("run"));
    // We are simulating behavior that happens in Netty4HttpRequestHeaderVerifier
        Runnable originalWithContext;
        }  
            threadContext.putHeader("bar", "baz");  
 * The OpenSearch Contributors require contributions made to  
        }
        IllegalArgumentException e = expectThrows(
            assertNull(threadContext.getTransient("ctx.foo"));  
            assertNull(threadContext.getTransient("foo"));  
    }
        }
        assertNull(threadContext.getHeader("simon"));  
 *
    }
        }
        assertEquals("bar", threadContext.getHeader("foo"));
                if (source.containsKey(PROPAGATED_KEY)) {  
        // Create a runnable that should run with some header  
                public void onFailure(Exception e) {
                    threadContext.putTransient("failure", e);
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);  
        BytesStreamOutput out = new BytesStreamOutput();
        // We don't see the header outside of the runnable  
        // this is missing or null
        }  
                assertEquals("bar", threadContext.getHeader("foo"));
        assertEquals(value, baz.get(0));
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {  
            @Override  
                    assertEquals("exception from doRun", e.getMessage());
        Map<String, String> headerTransformedMap = Collections.singletonMap("test_transient_propagation_key", "test");
                () -> finalThreadContext1.stashAndMergeHeaders(finalToMerge1)
            assertEquals("baz", threadContext.getTransient("bar"));
            ThreadContext.StoredContext stashed = threadContext.newStoredContext(
    }  
        if (expectThird) {
        threadContext.addResponseHeader("foo", "bar");
        assertEquals("baz", threadContext.getHeader("foo.bar"));
        threadContext.putHeader("foo", "bar");
                assertEquals(2, threadContext.getResponseHeaders().get("resp.header").size());
    }
        // But we do inside of it
            assertNull(threadContext.getHeader("default"));
        final Object PROPAGATED_VALUE = new Object();
        // pretend that another thread created the same response
            assertTrue(threadContext.isSystemContext());
        toMerge.put("simon", "says");
            threadContext.addResponseHeader("baz", "bar");
        assertEquals("value for key [foo] already present", e.getMessage());  
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_ID;  
            assertEquals("1", threadContext.getHeader("default"));
    // later tries to restore the same in SecurityFilter. Any transients added in between are lost
    }  
import java.io.IOException;
                    assertNotNull(threadContext.getTransient("failure"));
 */
        RuntimeException e = expectThrows(RuntimeException.class, withContext::run);  
        toMerge.put("foo", "baz");  
            assertEquals("boom", threadContext.getResponseHeaders().get("resp.header").get(0));  
                assertEquals("baaaam", threadContext.getResponseHeaders().get("resp.header").get(0));
        BytesStreamOutput out = new BytesStreamOutput();
        assertNull(threadContext.getHeader("foo"));
            assertEquals("bar", threadContext.getResponseHeaders().get("foo").get(0));
                assertEquals("bar_transient", threadContext.getTransient("foo"));  
            threadContext.putHeader("foo", "bar");
    }
        assertEquals("bar", threadContext.getHeader("foo"));
                    assertEquals("bar_transient", threadContext.getTransient("foo"));  
import static org.hamcrest.Matchers.hasItem;
        assertNull(threadContext.getHeader("foo"));  
        // a runnable that throws from onFailure
        threadContext.putHeader("baz", "bar");
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
            assertEquals("boom", threadContext.getResponseHeaders().get("resp.header").get(0));  
                randomBoolean(),  
            storedContext = sc;
        BytesStreamOutput out = new BytesStreamOutput();
            assertNull(otherhreadContext.getTransient("ctx.foo"));
    }  
        // a runnable that throws from onAfter
            assertEquals("1", threadContext.getHeader("default"));  
            assertFalse(threadContext.isSystemContext());
        ThreadContext.StoredContext storedContext = threadContext.newStoredContext(false);
        ThreadContext finalThreadContext2 = threadContext;  
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {  
        assertEquals("1", threadContext.getHeader("default"));  
        assertTrue(threadContext.isDefaultContext());  
            // missing header is still missing
        // We don't see the header outside of the runnable  
 * this file be licensed under the Apache-2.0 license or a
                assertEquals("bar", threadContext.getHeader("foo"));  
                }  
 * Modifications Copyright OpenSearch Contributors. See  
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
            () -> threadContext.putHeader(Collections.<String, String>singletonMap("foo", "boom"))
        Map<String, Object> headerMap = Collections.singletonMap("test_transient_propagation_key", "test");
        assertNull(threadContext.getTransient("foo"));
                    assertEquals("bar", threadContext.getHeader("foo"));
        }  
                @Override
        ThreadContext threadContext = new ThreadContext(build);
            threadContext.addResponseHeader("resp.header", "boom");
        Mockito.when(mockPropagator.headers(headerMap, true)).thenReturn(headerTransformedMap);
            }
    // It take a snapshot of state and stores in CONTEXT_TO_RESTORE and  
        assertEquals("1", threadContext.getHeader("default"));  
                    throw new RuntimeException("from onAfter");
            threadContext.putTransient(PROPAGATED_KEY, PROPAGATED_VALUE);  
            threadContext.putTransient("foo", "bar_transient");  
            assertThat(warnings, hasItem(equalTo("123456")));
            ThreadContext.StoredContext stashed = threadContext.newStoredContext(
            assertEquals("bar", threadContext.getHeader("baz"));  
        assertEquals(1, threadContext.getResponseHeaders().get("resp.header").size());  
        ThreadContext threadContext = new ThreadContext(build);
            threadContext.putTransient("foo", "bar_transient");
            threadContext.addResponseHeader("baz", "bar");
        threadContext.readHeaders(out.bytes().streamInput());
        Runnable withContext;
            threadContext.putTransient("acme", null);
        assertEquals(2, threadContext.getResponseHeaders().get("foo").size());  
        try (ThreadContext.StoredContext storedContext = ThreadContextAccess.doPrivileged(() -> threadContext.stashWithOrigin(origin))) {
            threadContext.addResponseHeader("Warning", "234567");
        assertTrue(threadContext.isDefaultContext());
        assertEquals("1", threadContext.getHeader("default"));  
            threadContext.addResponseHeader("resp.header", "boom");  
        ) {  
            }
        assertEquals("bar", threadContext.getHeader("foo"));
        assertEquals("bar", threadContext.getHeader("foo"));
import java.util.Collections;
        withContext.run();  
        threadContext.writeTo(out);  
        }  
        assertNull(threadContext.getHeader("foo"));  
        Map<String, Object> transientHeaderMap = Collections.singletonMap("test_transient_propagation_key", "test");
        Settings build = Settings.builder().put("request.headers.default", "1").build();  
        // But we do inside of it
        Mockito.when(mockPropagator.transients(transientHeaderMap, false)).thenReturn(transientHeaderTransformedMap);  
        // storedContext would have closed. Now we restore and after that, our original thread should have it
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
            assertNull(threadContext.getTransient("foo"));  
        assertEquals("bar", threadContext.getHeader("foo"));
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
        // test stashed missing header stays missing  
            assertEquals("4", threadContext.getHeader("default"));
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
                    assertEquals("bar", threadContext.getHeader("foo"));
            assertNull(threadContext.getTransient("ctx.foo"));
                assertEquals("baaaam", threadContext.getResponseHeaders().get("resp.header").get(1));
        threadContext.addResponseHeader("Warning", "123456");
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));  
                }  
        try (ThreadContext.StoredContext sc = threadContext.newStoredContext(false, true)) {
        }
        storedContext.restore();  
            threadContext.putTransient("baz", "bar");
                }
        assertTrue(threadContext.isDefaultContext());
    public void testCopyHeaders() {  
                sometimesAbstractRunnable(() -> { assertEquals("bar", threadContext.getHeader("foo")); })
        }  
        ThreadContextStatePropagator mockPropagator = Mockito.mock(ThreadContextStatePropagator.class);
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {  
        assertEquals("1", threadContext.getHeader("default"));
        final String value = HeaderWarning.formatWarning("qux");  
        // pretend that another thread created the same response at a different time
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
            threadContext.putHeader("foo", "zot");
        threadContext.putTransient("test_transient_propagation_key", 1);  
        assertThat(warnings, hasItem(equalTo("Two can be as bad as one")));
        RuntimeException e = expectThrows(RuntimeException.class, withContext::run);  
            assertNull(threadContext.getTransient("ctx.foo"));
                }
        assertEquals("bar", threadContext.getHeader("foo"));
        assertEquals("1", threadContext.getHeader("default"));
    }
        assertNull(threadContext.getTransient("run"));  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                @Override
        ) {
        }
    public void testSystemContextWithPropagator() {  
    }  
        }
        RuntimeException e = expectThrows(RuntimeException.class, runnable::run);
        assertEquals("bar", threadContext.getHeader("foo"));
    }  
            }
            }  
        // but not after
    public void testSerializeInDifferentContextNoDefaults() throws IOException {
        assertEquals("from onAfter", e.getMessage());
            ThreadContext otherhreadContext = new ThreadContext(otherSettings);  
        if (randomBoolean()) {
    public void testNewContextWithClearedTransients() {
    }  
        assertEquals("bar", threadContext.getHeader("foo"));
            assertEquals("bar", threadContext.getTransient("foo"));
            assertEquals("bar", threadContext.getHeader("foo"));  
        assertNull(threadContext.getTransient("foo"));
        // but not after
        threadContext.putTransient("ctx.foo", 1);
            assertNull(threadContext.getHeader("foo"));
public class ThreadContextTests extends OpenSearchTestCase {  
        final String PROPAGATED_KEY = "test_propagated_transient";
            assertNull(threadContext.getTransient("ctx.foo"));  
                () -> finalThreadContext2.stashAndMergeHeaders(finalToMerge2)
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
            assertEquals(1, threadContext.getResponseHeaders().get("resp.header").size());
                return Collections.emptyMap();  
        // We don't see the header outside of the runnable
        try (
        assertNull(threadContext.getTransient("foo"));
        threadContext.putPersistent("ctx.persistent_foo", 10);  
        Settings build = Settings.builder().put("request.headers.default", "1").build();
        assertNull(threadContext.getHeader("bar"));  
                    threadContext.putTransient("after", "after");
        final boolean setOtherValues = randomBoolean();  
        assertNull(threadContext.getTransient("foo"));  
        });
    public void testResponseHeaders() {
            assertThat(responseHeaders.keySet(), hasSize(1));  
    public void testStashContext() {
        }
            // now we add something to original thread  
        assertEquals("bar", threadContext.getResponseHeaders().get("baz").get(0));
    public void testPropagatedTransientsAreRestored() {
        assertEquals("bar", threadContext.getHeader("baz"));
            otherThreadContext.readHeaders(out.bytes().streamInput());  
        }
            threadContext.putTransient("foo", "acme");
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
        assertNull(threadContext.getHeader("foo"));  
        };
        threadContext.putTransient("foo", "bar");
        ThreadContext threadContext = new ThreadContext(build);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        Mockito.when(mockPropagator.transients(transientHeaderMap, true)).thenReturn(Collections.emptyMap());
            Settings otherSettings = Settings.builder().put("request.headers.default", "5").build();
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {  
        threadContext.putHeader("default", "4");  
        ThreadContextStatePropagator mockPropagator = Mockito.mock(ThreadContextStatePropagator.class);
            assertEquals("2", threadContext.getHeader("default"));
        }  
        // but not after
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
        threadContext.putTransient("ctx.foo", 1);  
            withContext = threadContext.preserveContext(() -> {
            final List<String> warnings = responseHeaders.get("Warning");
                @Override  
            assertNull(threadContext.getTransient("bar"));
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
        assertEquals("1", threadContext.getHeader("default"));
        assertEquals("bar", threadContext.getHeader("foo"));
        assertEquals("exception from run", e.getMessage());
        assertNull(threadContext.getHeader("foo"));
    }
                @Override  
        assertTrue(threadContext.isDefaultContext());
        Settings build = Settings.builder().put("request.headers.default", "1").build();
        assertNull(threadContext.getTransient("foo"));  
                    throw new RuntimeException("from onFailure", e);
                    assertEquals("bar", threadContext.getHeader("foo"));
        if (setOtherValues) {  
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));  
            threadContext.putHeader("foo", "bar");
            assertThat(warnings, hasItem(equalTo("No is the saddest experience")));
        threadContext.putHeader("foo", "bar");  
    public void testPreserveContextKeepsOriginalContextWhenCalledTwice() throws IOException {  
        assertEquals("baz", threadContext.getResponseHeaders().get("foo").get(1));
        assertTrue(threadContext.isDefaultContext());  
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        assertNull(threadContext.getHeader("foo"));  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        assertEquals("1", threadContext.getHeader("default"));  
    public void testRestorableContext() {
                threadContext.addResponseHeader("Warning", "123456");
        threadContext.addResponseHeader("resp.header", "baaaam");  
        assertEquals(1, (int) threadContext.getTransient(TASK_ID));
            threadContext.addResponseHeader("foo", "bar");  
        }  
        }  
        threadContext.addResponseHeader("Warning", "234567");
        try (
            threadContext.putTransient("foo", "bar");
        // foo is the only existing transient header that is cleared
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {  
            withContext = threadContext.preserveContext(new AbstractRunnable() {
    public void testSerialize() throws IOException {
        threadContext.addResponseHeader("Warning", "Two can be as bad as one");  
            threadContext.putTransient("foo", "bar_transient");
            IllegalArgumentException.class,  
        threadContext.writeTo(out);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
 *  
 * You may obtain a copy of the License at  
            assertNull(threadContext.getTransient("ctx.foo"));  
        Settings build = Settings.builder().put("request.headers.default", "1").build();
        assertNull(threadContext.getHeader("foo"));
        ThreadContext threadContext = new ThreadContext(build);
        final List<String> foo = responseHeaders.get("foo");  
        {  
        Map<String, Object> transientHeaderTransformedMap = Collections.singletonMap("test_transient_propagation_key", "test");  
            assertNull(threadContext.getHeader("foo"));  
            assertNull(threadContext.getTransient("ctx.foo"));
        threadContext.addResponseHeader("foo", "bar");  
    public void testPreservesThreadsOriginalContextOnAfterException() throws IOException {
            );
        assertEquals("bar", threadContext.getHeader("foo"));  
            final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        assertEquals("qux", threadContext.getResponseHeaders().get("bar").get(0));
            try (ThreadContext.StoredContext tmp = contextSupplier.get()) {
        threadContext.putHeader(Collections.<String, String>emptyMap());
        }
    }  
            threadContext.writeTo(out);
                }  
    }
        ) {  
        threadContext.putTransient("bar", "baz");
            withContext = threadContext.preserveContext(new AbstractRunnable() {  
            // only the requested transient header is cleared
        withContext.run();  
            // unlikey to get exception, if we got one, test should fail
            ThreadContext.StoredContext ctx = ThreadContextAccess.doPrivileged(  
        HashMap<String, String> toMerge = new HashMap<>();
            threadContext.writeTo(out);
        } else {
            threadContext.putTransient("ctx.foo", 1);  
        }
            threadContext.readHeaders(out.bytes().streamInput());  
        final int expectedWarnings = expectThird ? 3 : 2;  
 * Unless required by applicable law or agreed to in writing,
        threadContext.stashContext();  
        assertTrue(threadContext.isDefaultContext());
 * SPDX-License-Identifier: Apache-2.0
        threadContext.copyHeaders(Collections.<String, String>singletonMap("foo", "bar").entrySet());
 * the Apache License, Version 2.0 (the "License"); you may
        try (ThreadContext.StoredContext context = threadContext.stashContext()) {
    public void testStashWithOrigin() {
        assertNull(threadContext.getTransient("foo"));
                    assertEquals(systemContext, threadContext.isSystemContext());
        assertEquals("from doRun", e.getCause().getMessage());
        assertNull(threadContext.getTransient("foo"));
        Settings build = Settings.builder().put("request.headers.default", "1").build();  
                assertEquals("1", threadContext.getHeader("default"));
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
        assertEquals("baz", threadContext.getPersistent("persistent_foo"));  
package org.opensearch.common.util.concurrent;
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
        ThreadContext threadContext = new ThreadContext(build);  
        toMerge = new HashMap<>();
        assertNull(threadContext.getTransient(ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME));
                assertEquals(1, threadContext.getResponseHeaders().get("resp.header").size());  
    public void testPreservesThreadsOriginalContextOnRunException() throws IOException {  
        }
            assertNotNull(threadContext.getTransient("ctx.foo"));  
            assertEquals(Integer.valueOf(10), threadContext.getPersistent("ctx.persistent_foo"));
        ThreadContext threadContext = new ThreadContext(build);
            ThreadContext.StoredContext ctx = ThreadContextAccess.doPrivileged(  
            otherhreadContext.readHeaders(out.bytes().streamInput());
                    assertEquals("bar_transient", threadContext.getTransient("foo"));  
                public void onFailure(Exception e) {
            assertThat(responseHeaders.keySet(), hasSize(1));
        HashMap<String, String> toMerge = new HashMap<>();
                    throw new RuntimeException("from onFailure", e);  
        Mockito.when(mockPropagator.headers(headerMap, false)).thenReturn(headerTransformedMap);  
            // add new headers
import static org.hamcrest.Matchers.hasSize;  
                @Override
        threadContext.putTransient("ctx.foo", 1);
        assertNull(threadContext.getTransient("failure"));
        ThreadContext threadContext = new ThreadContext(build);  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            threadContext.putTransient("acme", "foo");
                throw new RuntimeException(e);
import java.util.Arrays;  
        threadContext.putTransient("ctx.foo", 1);
            assertNull(threadContext.getHeader("foo"));
        assertEquals(1, threadContext.getResponseHeaders().get("resp.header").size());
        try (ThreadContext.StoredContext ctx = threadContext.stashContext()) {
    }
        assertNull(threadContext.getHeader("foo.bar"));
        assertEquals("1", threadContext.getHeader("default"));
                protected void doRun() throws Exception {  
import org.opensearch.common.logging.HeaderWarning;
        threadContext.putHeader("foo", "bar");  
            withContext = threadContext.preserveContext(
    public void testStashContextWithPersistentHeaders() {  
            boolean systemContext = randomBoolean();
            assertThat(warnings, hasItem(equalTo("234567")));  
        Settings build = Settings.builder().put("request.headers.default", "1").build();
        Settings build = Settings.builder().put("request.headers.default", "1").build();  
    }
        assertEquals(Integer.valueOf(10), threadContext.getPersistent("ctx.persistent_foo"));
    }  
            assertNull(threadContext.getPersistent("default"));
        HashMap<String, String> finalToMerge2 = toMerge;
            final Map<String, List<String>> responseHeaders = otherThreadContext.getResponseHeaders();  
        withContext.run();  
        threadContext.registerThreadContextStatePropagator(mockPropagator);
        try (
        threadContext.putHeader("foo", "bar");
                sometimesAbstractRunnable(() -> { assertEquals("bar", threadContext.getHeader("foo")); })  
            assertEquals("1", threadContext.getHeader("default"));
        {  
        assertEquals("1", threadContext.getHeader("default"));  
        if (setOtherValues) {
        threadContext.putTransient(TASK_ID, 1);
        assertEquals("bar", threadContext.getHeader("foo"));
        assertThat(warnings, hasSize(expectedWarnings));  
        // In fact the second wrapping didn't even change it
            public void onFailure(Exception e) {  
        Mockito.when(mockPropagator.transients(transientHeaderMap, true)).thenReturn(Collections.emptyMap());
                    assertEquals(systemContext, threadContext.isSystemContext());
        Mockito.when(mockPropagator.headers(headerMap, false)).thenReturn(headerTransformedMap);  
            )  
import java.util.List;  
        BytesStreamOutput outFromSystemContext = new BytesStreamOutput();
            assertThat(threadContext.getResponseHeaders().keySet(), hasSize(1));  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
    }  
                }
        assertThat(warnings, hasItem(equalTo("One is the loneliest number")));
            assertEquals(origin, threadContext.getTransient(ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME));
        threadContext.putHeader("default", "2");  
        ) {  
        assertNull(threadContext.getTransient("foo"));
        assertEquals("bar", threadContext.getHeader("foo"));  
                assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));
            threadContext.putHeader("foo", "bar");
        BytesStreamOutput out = new BytesStreamOutput();  
        final List<String> warnings = responseHeaders.get("Warning");
            assertEquals(1, threadContext.getResponseHeaders().get("resp.header").size());
        threadContext.putHeader("foo", "bar");
        // headers added inside the stash are NOT preserved
        // We get the original context inside the runnable
            });  
        assertEquals("bar", threadContext.getResponseHeaders().get("foo").get(0));
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));  
                assertFalse(threadContext.isDefaultContext());
        assertFalse(threadContext.isSystemContext());  
import java.util.function.Supplier;
        // Create a runnable that should run with some header
                    throw new RuntimeException("exception from doRun");
 * Licensed to Elasticsearch under one or more contributor  
            assertEquals("baz", threadContext.getPersistent("persistent_foo"));  
            )
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            threadContext.putHeader("foo", "bar");  
            assertEquals("1", threadContext.getHeader("default"));
            final String duplicateValue = HeaderWarning.formatWarning("qux");
        }  
 * license agreements. See the NOTICE file distributed with
        threadContext.putTransient("foo", "bar");
        assertEquals("bar", threadContext.getHeader("foo"));
        assertNull(threadContext.getResponseHeaders().get("baz"));
        threadContext.registerThreadContextStatePropagator(mockPropagator);
            });  
            assertNull(threadContext.getTransient("acme"));
                    assertEquals("bar_transient", threadContext.getTransient("foo"));
 * under the License.  
            @Override
            assertEquals("bar", otherhreadContext.getHeader("foo"));  
    }
        if (randomBoolean()) {  
 */
        assertFalse(threadContext.isSystemContext());  
        }
        if (expectThird) {
        threadContext.putHeader(Collections.<String, String>singletonMap("foo", "bar"));  
            assertEquals("1", threadContext.getHeader("default"));
        }  
            throw e;  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
        // But we do inside of it
        // we should be able to find the key now
        }
        }
            @SuppressWarnings("removal")
                    assertEquals("bar_transient", threadContext.getTransient("foo"));  
        assertEquals(1, threadContext.getResponseHeaders().get("foo").size());  
            )
    public void testPutHeaders() {
            assertEquals("5", otherhreadContext.getHeader("default"));
        threadContext.putPersistent("persistent_foo", "baz");
        Map<String, Object> transientHeaderTransformedMap = Collections.singletonMap("test_transient_propagation_key", "test");  
            assertEquals("bar", threadContext.getHeader("foo"));
        // We don't see the header outside of the runnable
    public void testCanResetDefault() {  
            assertThat(warnings, hasItem(equalTo("123456")));  
/*
        ThreadContext threadContext = new ThreadContext(build);
                assertEquals("1", threadContext.getHeader("default"));
 * software distributed under the License is distributed on an
    public void testStashContextWithPreservedTransients() {
                protected void doRun() throws Exception {  
                assertEquals("bar", threadContext.getHeader("foo"));
        Settings build = Settings.builder().put("request.headers.default", "1").build();
 * not use this file except in compliance with the License.
                    assertFalse(threadContext.isDefaultContext());  
            threadContext.addResponseHeader("Warning", "123456");  
        }  
        // original headers are restored
            assertNull(threadContext.getHeader("foo"));
        if (rarely()) {
        toMerge.put("default", "2");
        ThreadContext threadContext = new ThreadContext(build);  
            assertNull(threadContext.getHeader("foo"));
            threadContext.putHeader("foo", "bar");
        threadContext.updateResponseHeader("baz", value, s -> HeaderWarning.extractWarningValueFromWarningHeader(s, false));
        Settings build = Settings.builder().put("request.headers.default", "1").build();
            withContext = threadContext.preserveContext(new AbstractRunnable() {  
        try (
            threadContext.putTransient("ctx.foo", 1);
                return Collections.emptyMap();  
        assertEquals("bar", threadContext.getHeader("foo"));
        try (ThreadContext.StoredContext ctx = ThreadContextAccess.doPrivileged(() -> threadContext.stashAndMergeHeaders(toMerge))) {
            assertThat(warnings, hasSize(2));
                ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);  
        Runnable withContext;
            )
        assertThat(baz, hasSize(1));  
            assertEquals("bar", threadContext.getHeader("foo"));  
/*  
    }
        // original is restored (it is not overridden)
     * Sometimes wraps a Runnable in an AbstractRunnable.
            threadContext.addResponseHeader("foo", "baz");
            withContext = threadContext.preserveContext(withContext);
        ThreadContext threadContext = new ThreadContext(build);  
        ThreadContext.StoredContext storedContext = null;
                public void onFailure(Exception e) {
                randomFrom(Arrays.asList("foo", "foo"), Arrays.asList("foo"), Arrays.asList("foo", "acme"))
import org.opensearch.common.settings.Settings;
        assertEquals(Integer.valueOf(1), threadContext.getTransient("ctx.foo"));  
                throw new RuntimeException("exception from run");  
            threadContext.putHeader("foo", "bar");  
