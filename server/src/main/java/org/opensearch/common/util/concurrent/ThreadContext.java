            } else if (size == 1) {
        public Runnable unwrap() {
        }
                } else {
        final Map<String, Object> transients = new HashMap<>();  
import org.opensearch.core.common.io.stream.StreamInput;  
                if (warningHeadersSize > maxWarningHeaderSize) { // if max size has already been reached before  
        }
        }
    /**  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public boolean isForceExecution() {  
                if (existingValues != null) {
        }  
            return command;  
                return new ThreadContextStruct(newHeaders, responseHeaders, transientHeaders, persistentHeaders, isSystemContext);  
        private ThreadContextStruct(
     *         }  
    }
        final Map<String, Object> newTransientHeaders = new HashMap<>(originalContext.transientHeaders);
     */
    public StoredContext stashAndMergeHeaders(Map<String, String> headers) {
    @SuppressWarnings("unchecked") // (T)object
                }
     * {@link ContextPreservingActionListener}. Use {@link OriginSettingClient}  
        threadLocal.set(threadLocal.get().putPersistent(persistentHeaders));
          Otherwise when context is stash, it should be empty.
    /**
        }  
            }
        HashMap<String, List<String>> map = new HashMap<>(responseHeaders.size());
            this.responseHeaders = responseHeaders;
            threadContextStruct = threadContextStruct.putHeaders(builder.immutableMap());
    }
                if (threadsOriginalContext != null) {  
import org.opensearch.common.annotation.PublicApi;  
    }
            for (String key : headers.names()) {
            };  
                return new ThreadContextStruct(requestHeaders, responseHeaders, transientHeaders, newPersistentHeaders, isSystemContext);  
            ThreadContextStruct threadContextStruct = new ThreadContextStruct(
        }
     * For instance this method should be used like this:  
            Collections.emptyMap(),
        protected void doRun() throws Exception {
 * <pre>  
     *                 // execute with the parents context and restore the threads context afterwards
            }  
     * Copies all header key, value pairs into the current context  
                newResponseHeaders = new HashMap<>(responseHeaders);
     * @param preserveResponseHeaders if set to <code>true</code> the response headers of the restore thread will be preserved.
        @Override  
                }
     * @param key         the header name  
     * Unwraps a command that was previously wrapped by {@link #preserveContext(Runnable)}.  
    public Supplier<StoredContext> newRestorableContext(boolean preserveResponseHeaders) {
     *
                String key = entry.getKey();
         */
        private ContextPreservingRunnable(Runnable in) {  
        return out -> {  
 * a thread. It allows to store and retrieve header information across method calls, network calls as well as threads spawned from a  
     * Just like {@link #stashContext()} but no default context is set. Instead, the {@code transientHeadersToClear} argument can be used
 * software distributed under the License is distributed on an
                        responseHeaders,  
    /**  
            this.in = in;
        return headers;
     * returned supplier is invoked. The context returned from the supplier is a stored version of the
        if (command instanceof ContextPreservingAbstractRunnable) {
        private final Runnable in;  
    }
                    );  
            }
     * Creates a new ThreadContext instance  
                            + "]!"
     * @param storedContext the context to restore
    }  
     * actions that are made up of many sub-actions. These actions call
import java.nio.charset.StandardCharsets;  
                final Map<String, Object> propagated = propagateTransients(current.transientHeaders, current.isSystemContext);
        propagators.remove(Objects.requireNonNull(propagator));
    }  
            }  
                        isSystemContext,  
        final ThreadContextStruct context = threadLocal.get();
    @FunctionalInterface
 * Unless required by applicable law or agreed to in writing,
            false  
    @SuppressWarnings("removal")  
            this.persistentHeaders = persistentHeaders;
 * </pre>
 *
        @Override  
            in.onRejection(e);
        @Override
            // is still executing, we don't want this runnable to fail with an
            }
                return this;  
            Map<String, Set<String>> responseHeaders,
        private final long warningHeadersSize;  
    /**  
                    putSingleHeader(entry.getKey(), entry.getValue(), newHeaders);
/*
        final ThreadContext.StoredContext storedContext = stashContext();
import java.util.EnumSet;
        return threadLocal.get().isSystemContext;  
            return in.toString();  
    }  
        }  
            assert headers != null;
        MapBuilder<String, String> builder = MapBuilder.newMapBuilder();  
            return new ThreadContextStruct(requestHeaders, newResponseHeaders, transientHeaders, persistentHeaders, isSystemContext);  
        Settings headers = DEFAULT_HEADERS_SETTING.get(settings);
    }  
     * those actions on their own.
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
            );
        return newStoredContext(preserveResponseHeaders, Collections.emptyList());
        private ThreadContextStruct setSystemContext(final List<ThreadContextStatePropagator> propagators) {
            if (isSystemContext) {  
            Collections.emptyMap(),
        return new ContextPreservingRunnable(command);
                        transientHeaders,
            }  
 */  
        public Function<Set<T>, Set<T>> finisher() {
        boolean preserveResponseHeaders,  
                        .collect(LINKED_HASH_SET_COLLECTOR);  
            Map<String, Object> newPersistentHeaders = new HashMap<>(this.persistentHeaders);
    public static final String PREFIX = "request.headers";  
     * Returns a transient header object or <code>null</code> if there is no header for the given key  
            for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
            final Map<String, Set<String>> newResponseHeaders = new HashMap<>(this.responseHeaders);  
            if (key.equals("Warning") && (maxWarningHeaderSize != -1)) { // if size is NOT unbounded, check its limits
import org.opensearch.http.HttpTransportSettings;  
        return newStoredContext(preserveResponseHeaders, false, transientHeadersToClear);
    }
        propagators.forEach(p -> transients.putAll(p.transients(source, isSystemContext)));
 *  
    }  
            // Re-apply propagator-declared transients from the current context back into the
     * In order to avoid storing, and erroneously exposing, such headers,  
     */
                for (Map.Entry<String, String> entry : headers.entrySet()) {  
     */  
     */
        @Override  
        private ThreadContextStruct putResponse(  
        }
     * <code>command</code> has already been passed through this method then it is returned unaltered rather than wrapped twice.
            out.writeVInt(requestHeaders.size());
     * Puts a persistent header into the context - persistent headers cannot be stashed  
            } else {
        if (transientHeadersModified == true) {
        final Map<String, String> propagatedHeaders = propagateHeaders(context.transientHeaders, context.isSystemContext);  
        }
            this.requestHeaders = requestHeaders;  
                final Map<String, String> newHeaders = new HashMap<>(this.requestHeaders);
                transientHeaders,
            close();  
        Map<String, String> newHeader = new HashMap<>(headers);  
        private ThreadContextStruct copyHeaders(Iterable<Map.Entry<String, String>> headers) {  
            return new ThreadContextStruct(
     *
    /**  
    /**
        }
     * Usage of stashWithOrigin is guarded by a ThreadContextPermission. In order to use
            for (Map.Entry<String, Object> entry : values.entrySet()) {  
 * Licensed to Elasticsearch under one or more contributor  
     */
    /**  
     *
            final String key,
                return Collections.singleton(input.readString());  
    }
            struct = ThreadContextStruct.EMPTY;
            return new ThreadContextStruct(requestHeaders, responseHeaders, transientHeaders, newPersistentHeaders, isSystemContext);
                newHeaders.put(header.getKey(), header.getValue());  
    private static final ThreadContextStruct DEFAULT_CONTEXT = new ThreadContextStruct();
    /**  
        @Override
import java.util.Objects;  
        private ThreadContextStruct() {  
        private static final ThreadContextStruct EMPTY = new ThreadContextStruct(
                // use a linked hash set to preserve order
    /**  
                return this;
        return Collections.unmodifiableMap(new HashMap<>(threadLocal.get().requestHeaders));
 *         threadContext.readHeaders(in); // read headers into current context  
                requestHeaders = this.requestHeaders;  
     * Same as {@link #newRestorableContext(boolean)} but wraps an existing context to restore.
            return Set::add;
 * compatible open source license.
 *     // current context is stashed and replaced with a default context
            }
            in.doRun();
     */
     */
        /*
    /**
                final Set<String> existingValues = newResponseHeaders.get(key);  
                    threadsOriginalContext.restore();
 * have out of the box support for {@link ThreadContext} and all threads spawned will inherit the {@link ThreadContext} from the thread
    @SuppressWarnings("removal")  
        if (value == null) {
        @Override
    public void putTransient(String key, Object value) {
     * Wraps a Runnable to preserve the thread context.  
     * Add an entry in the grant portion of the policy file like this:
        };
        final Map<String, String> requestHeaders = in.readMap(StreamInput::readString, StreamInput::readString);  
 * </p>
    public void registerThreadContextStatePropagator(final ThreadContextStatePropagator propagator) {
    private class ContextPreservingRunnable implements WrappedRunnable {
        setHeaders(readHeadersFromStream(in));
    public Writeable captureAsWriteable() {
import java.util.Collection;
            final int maxWarningHeaderCount,
        if (command instanceof WrappedRunnable) {  
            // If the node and thus the threadLocal get closed while this task  
        ) {  
                        requestHeaders,
                            + HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_SIZE.getKey()
    /**  
     * </pre>  
                            + "] set in ["  
    /**
     * <b>Be advised, headers might contain credentials.</b>
        private ContextPreservingAbstractRunnable(AbstractRunnable in) {  
    private static final Collector<String, Set<String>, Set<String>> LINKED_HASH_SET_COLLECTOR = new LinkedHashSetCollector<>();
            return CHARACTERISTICS;
        // saving current warning headers' size not to recalculate the size with every new warning header
        }
        return () -> {
            if (headers.isEmpty()) {
        }
    /**  
        this.maxWarningHeaderCount = SETTING_HTTP_MAX_WARNING_HEADER_COUNT.get(settings);  
            this(Collections.emptyMap(), Collections.emptyMap(), Collections.emptyMap(), Collections.emptyMap(), false);
                return this;
        }  
        }
    public StoredContext newStoredContext(boolean preserveResponseHeaders, Collection<String> transientHeadersToClear) {  
    private static class LinkedHashSetCollector<T> implements Collector<T, Set<T>, Set<T>> {
public final class ThreadContext implements Writeable {
            for (Map.Entry<String, Set<String>> entry : headers.entrySet()) {
    public StoredContext newStoredContext(boolean preserveResponseHeaders) {
    public void markAsSystemContext() {
                newTransientHeaders,
     * Removes the current context and resets a new context that contains a merge of the current headers and the given headers.
        @Override
    public void putHeader(Map<String, String> header) {
     *     Supplier&lt;ThreadContext.StoredContext&gt; restorable = context.newRestorableContext(true);  
            final Map<String, String> propagatedHeaders = propagateHeaders(context.transientHeaders, context.isSystemContext);
     * should be allowed even if the user doesn't have permission to perform  
        threadLocal.set(threadLocal.get().setSystemContext(propagators));
        ) {
     */
            } else {  
                }
        final Map<String, Object> transientHeaders = propagateTransients(context.transientHeaders, context.isSystemContext);
            if ((key.equals("Warning")) && (maxWarningHeaderCount != -1)) { // if count is NOT unbounded, check its limits  
                    return new ThreadContextStruct(
    /**
            ThreadContextStruct restoredContext = originalContext;
    /**
        public Supplier<Set<T>> supplier() {
     *
        }  
                requestHeaders.putAll(this.requestHeaders);  
            return in;
 *    http://www.apache.org/licenses/LICENSE-2.0
    boolean isDefaultContext() {  
            Map<String, String> requestHeaders,  
     * internal to the system, in the sense that they cannot be sent  
        );
                transientHeadersModified = true;  
     * @return a restorable context supplier  
        final ThreadContextStruct originalContext = threadLocal.get();
            return Collections.unmodifiableMap(defaultHeader);
        public String toString() {
    public void putHeader(String key, String value) {  
    }
    public void updateResponseHeader(final String key, final String value, final Function<String, String> uniqueValue) {
        propagators.add(Objects.requireNonNull(propagator));  
    public ThreadContext(Settings settings) {  
                            + maxWarningHeaderCount
    /**
 * under the License.  
            return (left, right) -> {  
                            + maxWarningHeaderSize
    /**
            out.writeMap(responseHeaders, StreamOutput::writeString, StreamOutput::writeStringCollection);
    private final List<ThreadContextStatePropagator> propagators;  
     *
            // Without this, restore() would blindly overwrite the threadLocal with the original
    }  
            if (newTransientHeaders.containsKey(transientHeaderToClear)) {
        return (T) threadLocal.get().transientHeaders.get(key);
            Map<String, Object> transientHeaders,
            }
            return new ThreadContextStruct(requestHeaders, responseHeaders, newTransient, persistentHeaders, isSystemContext);  
        if (command instanceof AbstractRunnable) {
        }
                if (existingValues.contains(uniqueValue.apply(value))) {  
     * restored by closing the returned {@link StoredContext}.  
        }
            putSingleHeader(key, value, newRequestHeaders);  
                }  
 * A ThreadContext is a map of string headers and a transient map of keyed objects that are associated with
        threadLocal.set(threadContextStruct);  
 *         }
    /**  
    public void updateResponseHeader(final String key, final String value) {
    }  
     * @param key         the header name
 *         if (fork) {
            final Set<String> existingValues = responseHeaders.get(key);
        }
        }
            Map<String, Object> newTransient = new HashMap<>(this.transientHeaders);
                    logger.warn(
                in.onAfter();
     * {@code value} after applying {@code uniqueValue} is ignored.
                if (replaceExistingKey) {
        private void writeTo(StreamOutput out, Map<String, String> defaultHeaders, Map<String, String> propagatedHeaders)
     * <p>
    ) {  
     * Marks this thread context as an internal system context. This signals that actions in this context are issued
        }
        this.defaultHeader = buildDefaultHeaders(settings);
    }
            long newWarningHeaderSize = warningHeadersSize;  
        return () -> {  
            storedContext.restore();
            return in.toString();
        private ThreadContextStruct putTransient(String key, Object value) {  
    }
                out.writeString(entry.getKey());  
            threadsOriginalContext = stashContext();  
            }
                    newResponseHeaders.put(key, entry.getValue());  
     */  
     * @param value       the header value  
        @Override  
        private static <T> void putSingleHeader(String key, T value, Map<String, T> newHeaders) {
 * <p>
     *  
         * This represents the default context and it should only ever be called by {@link #DEFAULT_CONTEXT}.
     * Add an entry in the grant portion of the policy file like this:
import java.util.Set;
    public StoredContext stashWithOrigin(String origin) {  
 * a thread pool or executor being responsible for stashing and restoring the threads context. For instance if a network request is  
                    newValues = Stream.of(value).collect(LINKED_HASH_SET_COLLECTOR);
     */
            return new ThreadContextStruct(newRequestHeaders, responseHeaders, transientHeaders, persistentHeaders, isSystemContext);
    public static final String ACTION_ORIGIN_TRANSIENT_NAME = "action.origin";  
        }  
            return Collections.emptyMap();
                return Collections.emptySet();
            // dropped when the security plugin (or any other caller) calls storedContext.restore().
     * but the tasks API will perform a get on their behalf using this method
    }  
            putSingleHeader(key, value, newPersistentHeaders);  
     * @param key         the header name
     *
                    final String value = input.readString();
    public static final Setting<Settings> DEFAULT_HEADERS_SETTING = Setting.groupSetting(PREFIX + ".", Property.NodeScope);
            if (size == 0) {  
                    );
            threadLocal.set(context);  
    }
            return new ThreadContextStruct(requestHeaders, responseHeaders, transients, persistentHeaders, true);
     * which can be used to do this automatically.
    }
            threadContextStruct = threadContextStruct.putTransient(transientHeaders);  
                in.run();  
    }  
                        persistentHeaders,
        void close();  
        addResponseHeader(key, value, v -> v);
        updateResponseHeader(key, value, v -> v);  
          X-Opaque-ID should be preserved in a threadContext in order to propagate this across threads.
        threadLocal.set(threadLocal.get().putTransient(key, value));
        final Map<String, String> headers = new HashMap<>();  
     * stashAndMergeHeaders, the codebase needs to explicitly be granted permission in the JSM policy file.  
    /**  
        putTransient(ACTION_ORIGIN_TRANSIENT_NAME, origin);
     *  
    /**  
 * uses a try/with pattern to stash it's current context, read headers into a fresh one and once the request is handled or a handler thread  
        @Override  
import java.util.function.BiConsumer;  
        this.maxWarningHeaderSize = SETTING_HTTP_MAX_WARNING_HEADER_SIZE.get(settings).getBytes();
     * Returns all of the request headers from the thread's context.<br>
    }
            this.isSystemContext = isSystemContext;
            if (preserveTransients) {  
                requestHeaders.putAll(propagatedHeaders);
import org.opensearch.common.collect.Tuple;
         */
     * Name for the {@link #stashWithOrigin origin} attribute.
        if (!transientHeaders.isEmpty()) {  
     * Remove the {@code value} for the specified {@code key}.
    }
                ctx.restore();
        final Map<String, Object> transientHeaders = propagateTransients(originalContext.transientHeaders, originalContext.isSystemContext);
            this.requestHeaders = requestHeaders;
     */  
            this.warningHeadersSize = 0L;
import java.util.function.Function;
        return () -> threadLocal.set(context);  
        );
    }
            ThreadContextStruct current = threadLocal.get();
        }
import org.apache.logging.log4j.LogManager;  
import java.util.ArrayList;
    public Object getPersistent(String key) {
     * Returns true if the current context is the default context.
            this.warningHeadersSize = warningHeadersSize;  
        private ThreadContextStruct putResponseHeaders(Map<String, Set<String>> headers) {
     *
    public void readHeaders(StreamInput in) throws IOException {
import org.opensearch.tasks.Task;
            // snapshot being restored. This ensures that transients written after the snapshot
     *             }
            Map<String, String> newHeaders = new HashMap<>();
        };
    private final long maxWarningHeaderSize;
            final int size = input.readVInt();
            }
        private ThreadContextStruct putPersistent(String key, Object value) {
    }
            }
                            + "]!"  
     *
     */
import java.util.function.BinaryOperator;
    /**
     * it is recommended to instead store security headers that prove
        }  
        // clear specific transient headers from the current context
                            + HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_SIZE.getKey()
        /**  
        threadLocal.set(DEFAULT_CONTEXT.putHeaders(newHeader));
        HashMap<String, String> map = new HashMap<>(defaultHeader);
     */
            Map<String, Set<String>> responseHeaders,
            this.isSystemContext = isSystemContext;
                for (int i = 0; i < size; i++) {
@PublicApi(since = "1.0.0")  
     * Get a copy of all <em>response</em> headers.
                }  
        final ThreadContextStruct context = threadLocal.get();
                Set<String> newValues;  
     */
                builder.put(requestHeader, context.requestHeaders.get(requestHeader));  
                return left;
                originalContext.persistentHeaders,  
        private ThreadContextStruct putRequest(String key, String value) {
import org.opensearch.action.support.ContextPreservingActionListener;
     *  
    public Runnable preserveContext(Runnable command) {
                            + "] bytes set in ["
            boolean isSystemContext,
            return new ThreadContextStruct(requestHeaders, responseHeaders, newTransient, persistentHeaders, isSystemContext);  
        }
        private final Map<String, String> requestHeaders;  
        final ThreadContextStruct context = threadLocal.get();
    /**
     * Add an entry in the grant portion of the policy file like this:
        for (String requestHeader : Task.REQUEST_HEADERS) {
            final Function<String, String> uniqueValue,  
    }
        });
     *  
        return value;
                throw new IllegalArgumentException("value for key [" + key + "] already present");  
    }  
                }  
import org.opensearch.transport.client.OriginSettingClient;  
        private final boolean isSystemContext;
        private ThreadContextStruct putTransient(Map<String, Object> values) {
                isSystemContext,  
        }  
            // uncaught exception
     */  
    private static final class ThreadContextStruct {
            this.responseHeaders = responseHeaders;
                originalContext.requestHeaders,  
            final boolean replaceExistingKey  
    }
            // was taken using newStoredContext (e.g. CURRENT_SPAN set by the tracing infrastructure) are not silently  
    }  
     *  
                originalContext.responseHeaders,
 *             threadPool.execute(() -&gt; request.handle()); // inherits context
    public StoredContext stashContext() {
     * Returns <code>true</code> iff this context is a system context  
            return in.isForceExecution();
                final LinkedHashSet<String> values = new LinkedHashSet<>(size);  
import java.io.IOException;
     */
                    assert added : value;
                if (newWarningHeaderSize > maxWarningHeaderSize) {
    }
          This is needed so the DeprecationLogger in another thread can see the value of X-Opaque-ID provided by a user.  
                } else {  
                    putSingleHeader(entry.getKey(), entry.getValue(), newPersistentHeaders);
     * Puts all of the given headers into this persistent context - persistent headers cannot be stashed
            map.put(entry.getKey(), Collections.unmodifiableList(new ArrayList<>(entry.getValue())));
        @Override
     * Puts a header into the context
                newResponseHeaders = new HashMap<>(responseHeaders);
     * Update the {@code value} for the specified {@code key}  
 * Consumers of ThreadContext usually don't need to interact with adding or stashing contexts. Every opensearch thread is managed by
            try (ThreadContext.StoredContext ignore = stashContext()) {
import org.apache.logging.log4j.Logger;
     * to clear specific transient headers in the new context. All headers (with the possible exception of {@code responseHeaders}) are  
     */
            ctx = newStoredContext(false);
        ThreadContextStruct threadContextStruct = DEFAULT_CONTEXT.putPersistent(context.persistentHeaders);
        return new Tuple<>(requestHeaders, responseHeaders);  
     */  
    @SuppressWarnings("removal")
                            + "]!"
import java.util.stream.Stream;
            return new ContextPreservingAbstractRunnable((AbstractRunnable) command);  
    /**  
            this.persistentHeaders = persistentHeaders;  
    public void copyHeaders(Iterable<Map.Entry<String, String>> headers) {
 */
            threadLocal.set(threadContextStruct);
    public Supplier<StoredContext> wrapRestorable(StoredContext storedContext) {
import java.util.HashMap;
    }
    /**  
     * Add the {@code value} for the specified {@code key} Any duplicate {@code value} is ignored.
     * restored by closing the returned {@link StoredContext}.
     *     }.start();
     * Just like {@link #stashContext()} but no default context is set.
            try {  
            if (headers.isEmpty()) {  
            Map<String, String> defaultHeader = new HashMap<>();  
import java.util.Map;
    }
    private final int maxWarningHeaderCount;
                }
        }
    public void putPersistent(String key, Object value) {
     * by the system itself rather than by a user action.  
            for (Map.Entry<String, Object> entry : values.entrySet()) {
/*  
    public StoredContext newStoredContext(
            this.in = in;
     *             try (ThreadContext.StoredContext ctx = restorable.get()) {  
            this.transientHeaders = transientHeaders;  
    public interface StoredContext extends AutoCloseable {
        }  
        @Override
            }
                return this;  
            }
     * restore it any listeners, likely with
    public StoredContext newStoredContext(boolean preserveResponseHeaders, boolean preserveTransients) {
            long warningHeadersSize
                originalContext.warningHeadersSize
    }
                    logger.warn(  
                final int warningHeaderCount = newResponseHeaders.containsKey("Warning") ? newResponseHeaders.get("Warning").size() : 0;
                newResponseHeaders,  
    }
                requestHeaders,
/*
import org.opensearch.core.common.io.stream.Writeable;
                    newResponseHeaders.put(key, Collections.unmodifiableSet(newValues));
        }
                    );  
            // check if we can add another warning header - if max count within limits
            transientHeadersModified = true;
     */
     * Without security the origin is ignored, but security uses it to authorize  
        boolean transientHeadersModified = false;
     * Puts all of the given headers into this context
    }
            throws IOException {  
 * specific language governing permissions and limitations
     * {@code value} after applying {@code uniqueValue} is ignored.
     * @opensearch.api  
        private final AbstractRunnable in;
                    final boolean added = values.add(value);  
        private ThreadContextStruct putPersistent(Map<String, Object> headers) {
        map.putAll(threadLocal.get().requestHeaders);
 *     }  
     */
     * @param uniqueValue the function that produces de-duplication values  
            Map<String, String> requestHeaders,  
            if (context.requestHeaders.containsKey(requestHeader)) {
    /**
        threadLocal.set(struct);
     */
     */
            }
     * Puts a transient header object into this context
            }
    }  
    public <T> T getTransient(String key) {  
                newWarningHeaderSize += "Warning".getBytes(StandardCharsets.UTF_8).length + value.getBytes(StandardCharsets.UTF_8).length;
     * @param preserveResponseHeaders if set to <code>true</code> the response headers of the restore thread will be preserved.  
    /**  
     *
        final Map<String, Set<String>> responseHeaders = in.readMap(StreamInput::readString, input -> {
            }
        return command;  
        if (requestHeaders.isEmpty() && responseHeaders.isEmpty()) {  
        threadLocal.get().responseHeaders.remove(key);  
     * {@link #stashWithOrigin} before performing on behalf of a user that
        public void onFailure(Exception e) {
     */
    public String getHeader(String key) {  
    /**
        }
     * Add the {@code value} for the specified {@code key} with the specified {@code uniqueValue} used for de-duplication. Any duplicate
                    );
        if (command instanceof ContextPreservingRunnable) {
            // snapshot, losing any propagated transients that were set after newStoredContext() was called.  
            } else {
            );  
    }
                        newWarningHeaderSize
    // thread context permissions
                if (!propagated.isEmpty()) {
                            + maxWarningHeaderSize  
            in.onFailure(e);
            } else {
                    final Set<String> newValues = Stream.concat(entry.getValue().stream(), existingValues.stream())
     *
    /**  
 *         } else {  
        } else {
     */  
import org.opensearch.common.settings.Setting.Property;
     * the credentials have been verified successfully, and which are
        };  
        }  
     * permission org.opensearch.secure_sm.ThreadContextPermission "stashAndMergeHeaders";
     * if it can't find the task in memory.
        return Collections.unmodifiableMap(map);
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.tasks.TaskThreadContextStatePropagator;
        }
        }
     */
     * originating from the supplied string. The removed context can be
     */
        final ThreadContextStruct context = threadLocal.get();  
            return context;
        this.threadLocal = ThreadLocal.withInitial(() -> DEFAULT_CONTEXT);
     * Returns the header for the given key or <code>null</code> if not present
        } else {
        threadLocal.set(threadLocal.get().putResponse(key, value, uniqueValue, maxWarningHeaderCount, maxWarningHeaderSize, true));  
            Collections.emptyMap(),
     * @param value       the header value
                            + "] bytes set in ["  
    public void putPersistent(Map<String, Object> persistentHeaders) {  
                    restoredContext = originalContext.putTransientIfAbsent(propagated);  
     * Removes the current context and resets a default context marked with as
        private final ThreadContext.StoredContext ctx;
            }  
     * Captures the current thread context as writeable, allowing it to be serialized out later
    }
import org.opensearch.common.settings.Setting;  
                newTransientHeaders.remove(transientHeaderToClear);
    /**
                        "Dropping a warning header, as their total count reached the maximum allowed of ["
     * @param uniqueValue the function that produces de-duplication values  
        return Collections.unmodifiableMap(map);  
    /**  
        private ThreadContextStruct putHeaders(Map<String, String> headers) {
            }  
                newResponseHeaders.put(key, Collections.unmodifiableSet(newValues));
        ) {
 * ownership. Elasticsearch licenses this file to you under  
        }  
    private final ThreadLocal<ThreadContextStruct> threadLocal;  
     *
    private Map<String, Object> propagateTransients(Map<String, Object> source, boolean isSystemContext) {
     * The removed context can be restored when closing the returned {@link StoredContext}. The merge strategy is that headers
import org.opensearch.common.collect.MapBuilder;
        this.propagators = new CopyOnWriteArrayList<>(List.of(new TaskThreadContextStatePropagator()));
        }
     * A stored context
     *     new Thread() {
 * not use this file except in compliance with the License.
        @Override
     * For example, a user might not have permission to GET from the tasks index  
 * (see {@link #readHeaders(StreamInput)}. In order to not modify the context that is currently active on this thread the network code
        }
    }
        private final Map<String, Object> transientHeaders;
import java.util.function.Supplier;  
        propagators.forEach(p -> headers.putAll(p.headers(source, isSystemContext)));
        private ThreadContextStruct(
        newHeader.putAll(context.requestHeaders);
            return ((WrappedRunnable) command).unwrap();
            if (defaultHeaders.isEmpty() && propagatedHeaders.isEmpty()) {
        threadLocal.set(threadLocal.get().putPersistent(key, value));  
        return threadLocal.get().persistentHeaders.get(key);  
        }  
        return transients;
 * GitHub history for details.
    public void addResponseHeader(final String key, final String value, final Function<String, String> uniqueValue) {
            creatorsContext.restore();
            return Function.identity();
                }
                originalContext.isSystemContext,
        private final Map<String, Object> persistentHeaders;  
            final Map<String, String> requestHeaders;
        public AbstractRunnable unwrap() {
        }
    }  
            return in;  
        private ThreadContext.StoredContext threadsOriginalContext = null;
 *  
import java.util.Collections;  
        Map<String, Set<String>> responseHeaders = threadLocal.get().responseHeaders;
                    return this;
            } finally {
            for (Map.Entry<String, String> header : headers) {
                putSingleHeader(entry.getKey(), entry.getValue(), newTransient);
                for (Map.Entry<String, Object> entry : headers.entrySet()) {  
            Collections.emptyMap(),  
                persistentHeaders,
    /**
                threadLocal.set(restoredContext);  
     */
    }  
            if (headers.isEmpty()) {
        public void onAfter() {
        context.writeTo(out, defaultHeader, propagatedHeaders);
     * @param value       the header value
    public boolean isSystemContext() {
        for (Map.Entry<String, Set<String>> entry : responseHeaders.entrySet()) {
    public Map<String, String> getHeaders() {  
 *             request.handle();
    public void setHeaders(Tuple<Map<String, String>, Map<String, Set<String>>> headerTuple) {
            final Map<String, Object> transients = new HashMap<>();  
                return values;  
        };  
            final String value,
                }
        String value = threadLocal.get().requestHeaders.get(key);
     * permission org.opensearch.secure_sm.ThreadContextPermission "stashWithOrigin";  
     */
    private class ContextPreservingAbstractRunnable extends AbstractRunnable implements WrappedRunnable {  
     *
 *
 * license agreements. See the NOTICE file distributed with
            }
 * thread that has a {@link ThreadContext} associated with. Threads spawned from a {@link org.opensearch.threadpool.ThreadPool}
     * by the clients.
     * Usage of stashAndMergeHeaders is guarded by a ThreadContextPermission. In order to use
    }
     * Wraps an AbstractRunnable to preserve the thread context.
        threadLocal.set(threadLocal.get().putHeaders(header));
        if (headers == null) {  
                }
        }
        final ThreadContextStruct struct;
    public Runnable unwrap(Runnable command) {
        public Set<Characteristics> characteristics() {
            Map<String, String> newRequestHeaders = new HashMap<>(this.requestHeaders);
            }
                newTransient.putIfAbsent(entry.getKey(), entry.getValue());
    public static Map<String, String> buildDefaultHeaders(Settings settings) {
import java.util.concurrent.CopyOnWriteArrayList;
     */
            Map<String, Object> newTransient = new HashMap<>(this.transientHeaders);
        if (!transientHeaders.isEmpty()) {
    private Map<String, String> propagateHeaders(Map<String, Object> source, boolean isSystemContext) {
     * Saves the current thread context and wraps command in a Runnable that restores that context before running command. If
            this.transientHeaders = transientHeaders;
    private static final Logger logger = LogManager.getLogger(ThreadContext.class);  
     * Returns the persistent header for the given key or <code>null</code> if not present - persistent headers cannot be stashed  
        }  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_COUNT;
        return () -> {
    /**  
     */
     * @param preserveResponseHeaders if set to <code>true</code> the response headers of the restore thread will be preserved.
            Map<String, Object> newTransient = new HashMap<>(this.transientHeaders);  
     *         public void run() {
            Map<String, Object> persistentHeaders,  
                    return this;
        final Map<String, Set<String>> responseHeaders = headerTuple.v2();
     * permission org.opensearch.secure_sm.ThreadContextPermission "markAsSystemContext";
 * @opensearch.api
 */
     */
        return storedContext;  
        public void run() {  
    public void addResponseHeader(final String key, final String value) {
 *     // previous context is restored on StoredContext#close()
     *
                defaultHeader.put(key, headers.get(key));
        // this is the context when this method returns  
     * be careful to save the current context before calling this method and
 * is forked (which in turn inherits the context) it restores the previous context. For instance:
        }  
            struct = new ThreadContextStruct(requestHeaders, responseHeaders, Collections.emptyMap(), Collections.emptyMap(), false);  
     *  
import java.util.stream.Collector;
/**
    public void writeTo(StreamOutput out) throws IOException {
    /**
            if (preserveResponseHeaders && threadLocal.get() != newContext) {  
                newWarningHeaderSize
            return command;  
        @Override
     */
     *  
    /**
        }
    public static Tuple<Map<String, String>, Map<String, Set<String>>> readHeadersFromStream(StreamInput in) throws IOException {
        private ThreadContextStruct putTransientIfAbsent(Map<String, Object> values) {
    /**
        public void onRejection(Exception e) {  
     * Removes the current context and resets a default context. The removed context can be
        Collection<String> transientHeadersToClear
 */
package org.opensearch.common.util.concurrent;
        final Map<String, String> requestHeaders = headerTuple.v1();  
            // check if we can add another warning header - if max size within limits
    }
        }
     * @opensearch.internal  
        return newStoredContext(preserveResponseHeaders, preserveTransients, Collections.emptyList());  
    private final Map<String, String> defaultHeader;
}  
    }  
        for (String transientHeaderToClear : transientHeadersToClear) {  
    }
    @PublicApi(since = "1.0.0")  
            final Map<String, Set<String>> newResponseHeaders;  
    }  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_SIZE;
        }
            return putHeaders(newHeaders);
    @Override  
        if (builder.isEmpty() == false) {  
        default void restore() {
     * Update the {@code value} for the specified {@code key} with the specified {@code uniqueValue} used for de-duplication. Any duplicate
import org.opensearch.common.settings.Settings;
    public void removeResponseHeader(final String key) {
    public Map<String, List<String>> getResponseHeaders() {  
                    newValues = Stream.concat(existingValues.stream(), Stream.of(value)).collect(LINKED_HASH_SET_COLLECTOR);
            return defaultHeader.get(key);  
     */  
            final long maxWarningHeaderSize,
        public BiConsumer<Set<T>, T> accumulator() {  
     * <p>
     * @param value       the header value
     * Returns a supplier that gathers a {@link #newStoredContext(boolean)} and restores it once the  
     *  
            context.writeTo(out, defaultHeader, propagatedHeaders);
            return new ThreadContextStruct(requestHeaders, responseHeaders, newTransient, persistentHeaders, isSystemContext);
            StoredContext context = newStoredContext(false);  
    public void unregisterThreadContextStatePropagator(final ThreadContextStatePropagator propagator) {  
     * <pre>
        }
 * this file be licensed under the Apache-2.0 license or a
                requestHeaders = new HashMap<>(defaultHeaders);
import java.util.LinkedHashSet;  
        final ThreadContextStruct newContext = threadLocal.get();
 * The OpenSearch Contributors require contributions made to  
                }
        @Override
 * that it is forking from.". Network calls will also preserve the senders headers automatically.  
                newResponseHeaders.put(key, Collections.singleton(value));
    }
        return wrapRestorable(newStoredContext(preserveResponseHeaders));  
     * Usage of markAsSystemContext is guarded by a ThreadContextPermission. In order to use
 * this work for additional information regarding copyright
    }
     * Reads the headers from the stream into the current context
        threadLocal.set(threadLocal.get().putResponse(key, value, uniqueValue, maxWarningHeaderCount, maxWarningHeaderSize, false));  
        public BinaryOperator<Set<T>> combiner() {
                left.addAll(right);
                    // preserve insertion order
import java.util.List;
            assert value != null;
    /**
     */
            newTransientHeaders.putAll(transientHeaders);
            if (newHeaders.putIfAbsent(key, value) != null) {
            return LinkedHashSet::new;
            } else {
     */  
     * that are already existing are preserved unless they are defaults.  
                final Map<String, Object> newPersistentHeaders = new HashMap<>(this.persistentHeaders);
    /**
                            + HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_COUNT.getKey()
        public String toString() {  
            if (existingValues != null) {
     * @return Never {@code null}.
        }
            creatorsContext = newStoredContext(false);
            }
     * Returns the request headers, without the default headers
        }
 *     try (StoredContext context = threadContext.stashContext()) {
            }
 * the Apache License, Version 2.0 (the "License"); you may
     * @param key         the header name
                threadLocal.set(restoredContext.putResponseHeaders(threadLocal.get().responseHeaders));
        }
        private final Map<String, Set<String>> responseHeaders;
     * suppliers callers context that should be restored once the originally gathered context is not needed anymore.
            propagators.forEach(p -> transients.putAll(p.transients(transientHeaders, true)));
                        "Dropping a warning header, as their total size reached the maximum allowed of ["
     * restored by closing the returned {@link StoredContext}. Callers should  
            putSingleHeader(key, value, newTransient);
            } else {
                        "Dropping a warning header, as their total size reached the maximum allowed of ["
        boolean preserveTransients,
        @Override
     * Collector based on a linked hash set
        private static final Set<Characteristics> CHARACTERISTICS = Collections.unmodifiableSet(
        threadLocal.set(threadLocal.get().copyHeaders(headers));  
                    logger.warn(  
        return threadLocal.get() == DEFAULT_CONTEXT;
     */
     * @param key         the header name
     * @param settings the settings to read the default request headers from
 * received, all headers are deserialized from the network and directly added as the headers of the threads {@link ThreadContext}
            Map<String, Object> transientHeaders,
     */
                if (warningHeaderCount > maxWarningHeaderCount) {
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
            EnumSet.of(Collector.Characteristics.IDENTITY_FINISH)  
        private final ThreadContext.StoredContext creatorsContext;
     * markAsSystemContext, the codebase needs to explicitly be granted permission in the JSM policy file.  
        }
     * stashWithOrigin, the codebase needs to explicitly be granted permission in the JSM policy file.
                    return this;
                out.writeString(entry.getValue());
    public Map<String, String> getRequestHeadersOnly() {  
        threadLocal.set(threadLocal.get().putRequest(key, value));
            Map<String, Object> persistentHeaders,  
            boolean isSystemContext
