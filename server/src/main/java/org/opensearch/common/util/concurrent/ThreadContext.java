     * if it can't find the task in memory.
     * but the tasks API will perform a get on their behalf using this method
     * <p>
        @Override
    @FunctionalInterface
    }
        }
    /**
    /**
        }
        private ContextPreservingAbstractRunnable(AbstractRunnable in) {
        /*
            putSingleHeader(key, value, newRequestHeaders);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_COUNT;
import org.opensearch.action.support.ContextPreservingActionListener;
            }
    /**
                if (!propagated.isEmpty()) {
                            + HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_SIZE.getKey()
        }
                    // preserve insertion order
          Otherwise when context is stash, it should be empty.
     */
import org.opensearch.transport.client.OriginSettingClient;
                        "Dropping a warning header, as their total count reached the maximum allowed of ["
 *             threadPool.execute(() -&gt; request.handle()); // inherits context
            // is still executing, we don't want this runnable to fail with an
                if (existingValues != null) {
                in.run();
                return values;
                } else {
        private ThreadContextStruct() {
    public void putHeader(String key, String value) {
        final ThreadContextStruct struct;
                requestHeaders.putAll(propagatedHeaders);
        if (transientHeadersModified == true) {
     * permission org.opensearch.secure_sm.ThreadContextPermission "markAsSystemContext";
        String value = threadLocal.get().requestHeaders.get(key);
        this.propagators = new CopyOnWriteArrayList<>(List.of(new TaskThreadContextStatePropagator()));
        return () -> {
            Map<String, Object> newTransient = new HashMap<>(this.transientHeaders);
 * thread that has a {@link ThreadContext} associated with. Threads spawned from a {@link org.opensearch.threadpool.ThreadPool}
            Map<String, Object> transientHeaders,
    /**
     * @opensearch.internal
    /**
     * Update the {@code value} for the specified {@code key}
            final Map<String, Set<String>> newResponseHeaders = new HashMap<>(this.responseHeaders);
    public static Tuple<Map<String, String>, Map<String, Set<String>>> readHeadersFromStream(StreamInput in) throws IOException {
        public void onRejection(Exception e) {
     * Name for the {@link #stashWithOrigin origin} attribute.
        private final Map<String, String> requestHeaders;
                return this;
import org.opensearch.core.common.io.stream.Writeable;
     * @param value       the header value
        private final long warningHeadersSize;
        private ThreadContextStruct putHeaders(Map<String, String> headers) {
                            + HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_COUNT.getKey()
    }
 * software distributed under the License is distributed on an
        return () -> {
        threadLocal.set(threadLocal.get().putHeaders(header));
            throws IOException {
        threadLocal.set(threadLocal.get().putTransient(key, value));
     * returned supplier is invoked. The context returned from the supplier is a stored version of the
     * {@link ContextPreservingActionListener}. Use {@link OriginSettingClient}
            // check if we can add another warning header - if max size within limits
import org.opensearch.core.common.io.stream.StreamInput;
            long newWarningHeaderSize = warningHeadersSize;
        ThreadContextStruct threadContextStruct = DEFAULT_CONTEXT.putPersistent(context.persistentHeaders);
            return new ThreadContextStruct(
            final Map<String, Set<String>> newResponseHeaders;
    /**
            struct = new ThreadContextStruct(requestHeaders, responseHeaders, Collections.emptyMap(), Collections.emptyMap(), false);
            return in.isForceExecution();
            Map<String, Object> newTransient = new HashMap<>(this.transientHeaders);
            Map<String, String> newHeaders = new HashMap<>();
     */
        }
     */
            }
 * GitHub history for details.
                requestHeaders = new HashMap<>(defaultHeaders);
import java.util.Set;
            );
        }
    }
            in.onFailure(e);
        final ThreadContextStruct originalContext = threadLocal.get();
            try (ThreadContext.StoredContext ignore = stashContext()) {
     *         }
        addResponseHeader(key, value, v -> v);
            }
     * Remove the {@code value} for the specified {@code key}.
    /**
                return new ThreadContextStruct(newHeaders, responseHeaders, transientHeaders, persistentHeaders, isSystemContext);
            long warningHeadersSize
        if (command instanceof WrappedRunnable) {
package org.opensearch.common.util.concurrent;
    private static final class ThreadContextStruct {
            final Function<String, String> uniqueValue,
     * Without security the origin is ignored, but security uses it to authorize
                final Map<String, Object> newPersistentHeaders = new HashMap<>(this.persistentHeaders);
            threadsOriginalContext = stashContext();
            return new ThreadContextStruct(requestHeaders, responseHeaders, transientHeaders, newPersistentHeaders, isSystemContext);
import java.util.concurrent.CopyOnWriteArrayList;
        };
            this.responseHeaders = responseHeaders;
        return command;
    private final long maxWarningHeaderSize;
    @SuppressWarnings("removal")
                }
            return Set::add;
    /**
        private final Map<String, Object> transientHeaders;
        @Override
    }
            }
     */
        public void run() {
        public Function<Set<T>, Set<T>> finisher() {
            Map<String, String> defaultHeader = new HashMap<>();
    }
     * @param key         the header name
            }
            return new ThreadContextStruct(requestHeaders, responseHeaders, newTransient, persistentHeaders, isSystemContext);
    }
     */
    }
        return () -> {
            Map<String, Object> newTransient = new HashMap<>(this.transientHeaders);
    public void updateResponseHeader(final String key, final String value) {
     *
                            + "]!"
     *
            context.writeTo(out, defaultHeader, propagatedHeaders);
            return command;
        protected void doRun() throws Exception {
        return new Tuple<>(requestHeaders, responseHeaders);
        final ThreadContext.StoredContext storedContext = stashContext();
        // clear specific transient headers from the current context
     */
            this.requestHeaders = requestHeaders;
                            + "]!"
                    threadsOriginalContext.restore();
                    );
 * <pre>
 *     }
     * Returns the header for the given key or <code>null</code> if not present
 * have out of the box support for {@link ThreadContext} and all threads spawned will inherit the {@link ThreadContext} from the thread
        final Map<String, Object> transients = new HashMap<>();
        boolean transientHeadersModified = false;
import java.util.Collection;
        }
        @Override
    }
    /**
     * @param preserveResponseHeaders if set to <code>true</code> the response headers of the restore thread will be preserved.
        }
    public StoredContext stashAndMergeHeaders(Map<String, String> headers) {
            if (preserveResponseHeaders && threadLocal.get() != newContext) {
        public Runnable unwrap() {
                for (Map.Entry<String, Object> entry : headers.entrySet()) {
     * Collector based on a linked hash set
            }
            }
            for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
        }
 * </p>
        public Supplier<Set<T>> supplier() {
        final Map<String, String> requestHeaders = in.readMap(StreamInput::readString, StreamInput::readString);
     * Puts all of the given headers into this context
     */
        private static final Set<Characteristics> CHARACTERISTICS = Collections.unmodifiableSet(
         */
 * specific language governing permissions and limitations
            for (String key : headers.names()) {
     */
            this.transientHeaders = transientHeaders;
     * restored by closing the returned {@link StoredContext}.
        } else {
     */
     */
            return ((WrappedRunnable) command).unwrap();
            return LinkedHashSet::new;
            };
         */
     * the credentials have been verified successfully, and which are
        }
        }
     * markAsSystemContext, the codebase needs to explicitly be granted permission in the JSM policy file.
    public <T> T getTransient(String key) {
        final Map<String, String> headers = new HashMap<>();
    }
            if (headers.isEmpty()) {
                return Collections.singleton(input.readString());
    }
        }
                throw new IllegalArgumentException("value for key [" + key + "] already present");
        boolean preserveResponseHeaders,
            } finally {
     * </pre>
        @Override
    /**
            }
     *
            try {
            return new ThreadContextStruct(requestHeaders, responseHeaders, transients, persistentHeaders, true);
/*
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.common.settings.Setting.Property;
 * SPDX-License-Identifier: Apache-2.0
    /**
     * internal to the system, in the sense that they cannot be sent
 * a thread. It allows to store and retrieve header information across method calls, network calls as well as threads spawned from a
    public void putTransient(String key, Object value) {
        private static <T> void putSingleHeader(String key, T value, Map<String, T> newHeaders) {
        if (requestHeaders.isEmpty() && responseHeaders.isEmpty()) {
                        "Dropping a warning header, as their total size reached the maximum allowed of ["
    }
            if (newHeaders.putIfAbsent(key, value) != null) {
            threadLocal.set(threadContextStruct);
    }
import java.util.EnumSet;
            Map<String, String> requestHeaders,
        }
 * the Apache License, Version 2.0 (the "License"); you may
                if (existingValues.contains(uniqueValue.apply(value))) {
                return Collections.emptySet();
     * Add the {@code value} for the specified {@code key} Any duplicate {@code value} is ignored.
        newHeader.putAll(context.requestHeaders);
     */
        }
import org.opensearch.common.annotation.PublicApi;
            assert headers != null;
            Map<String, String> newRequestHeaders = new HashMap<>(this.requestHeaders);
                final Map<String, String> newHeaders = new HashMap<>(this.requestHeaders);
                originalContext.responseHeaders,
     *
    public void registerThreadContextStatePropagator(final ThreadContextStatePropagator propagator) {
     */
     */
        if (builder.isEmpty() == false) {
            return in;
    public void markAsSystemContext() {
        private final boolean isSystemContext;
         * This represents the default context and it should only ever be called by {@link #DEFAULT_CONTEXT}.
    /**
import org.opensearch.common.settings.Settings;
            Map<String, Object> persistentHeaders,
            // Re-apply propagator-declared transients from the current context back into the
        private final Runnable in;
    /**
public final class ThreadContext implements Writeable {
     * For example, a user might not have permission to GET from the tasks index
            }
        }
    private final int maxWarningHeaderCount;
                if (replaceExistingKey) {
            out.writeVInt(requestHeaders.size());
            } else {
        return value;
    }
                for (int i = 0; i < size; i++) {
        final Map<String, Object> transientHeaders = propagateTransients(originalContext.transientHeaders, originalContext.isSystemContext);
            return (left, right) -> {
                    return this;
        Settings headers = DEFAULT_HEADERS_SETTING.get(settings);
 * Licensed to Elasticsearch under one or more contributor
        @Override
        threadLocal.set(threadLocal.get().putPersistent(persistentHeaders));
        default void restore() {
    @Override
import java.nio.charset.StandardCharsets;
            }
                    newResponseHeaders.put(key, entry.getValue());
                newResponseHeaders.put(key, Collections.unmodifiableSet(newValues));
            }
    boolean isDefaultContext() {
    public interface StoredContext extends AutoCloseable {
        this.threadLocal = ThreadLocal.withInitial(() -> DEFAULT_CONTEXT);
            // If the node and thus the threadLocal get closed while this task
     * Just like {@link #stashContext()} but no default context is set.
        threadLocal.set(threadLocal.get().putResponse(key, value, uniqueValue, maxWarningHeaderCount, maxWarningHeaderSize, true));
     *
    }
    @PublicApi(since = "1.0.0")
    public StoredContext newStoredContext(boolean preserveResponseHeaders, Collection<String> transientHeadersToClear) {
     *
            return Collections.unmodifiableMap(defaultHeader);
     * {@code value} after applying {@code uniqueValue} is ignored.
     */
     * Update the {@code value} for the specified {@code key} with the specified {@code uniqueValue} used for de-duplication. Any duplicate
        });
     * @param key         the header name
    @SuppressWarnings("unchecked") // (T)object
        if (command instanceof ContextPreservingRunnable) {
     * Usage of stashAndMergeHeaders is guarded by a ThreadContextPermission. In order to use
            final int size = input.readVInt();
     */
    }
            in.doRun();
     * Puts a transient header object into this context
     * restore it any listeners, likely with
    public void readHeaders(StreamInput in) throws IOException {
            threadLocal.set(context);
     *     }.start();
    }
     * Removes the current context and resets a default context. The removed context can be
        private final AbstractRunnable in;
     * Add an entry in the grant portion of the policy file like this:
     * Returns a supplier that gathers a {@link #newStoredContext(boolean)} and restores it once the
     * permission org.opensearch.secure_sm.ThreadContextPermission "stashAndMergeHeaders";
import java.util.function.BiConsumer;
 *     try (StoredContext context = threadContext.stashContext()) {
    }
                String key = entry.getKey();
     */
        private ThreadContextStruct putTransient(String key, Object value) {
        }
     * Saves the current thread context and wraps command in a Runnable that restores that context before running command. If
                newResponseHeaders = new HashMap<>(responseHeaders);
 * ownership. Elasticsearch licenses this file to you under
    }
                return this;
        threadLocal.set(threadLocal.get().copyHeaders(headers));
            final Map<String, Object> transients = new HashMap<>();
            Map<String, Object> transientHeaders,
        }
            if (key.equals("Warning") && (maxWarningHeaderSize != -1)) { // if size is NOT unbounded, check its limits
                }
     * those actions on their own.
        };
            Collections.emptyMap(),
                if (warningHeaderCount > maxWarningHeaderCount) {
                left.addAll(right);
            return command;
    private static final Logger logger = LogManager.getLogger(ThreadContext.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
        return transients;
     * Returns a transient header object or <code>null</code> if there is no header for the given key
        for (Map.Entry<String, Set<String>> entry : responseHeaders.entrySet()) {
     *
        }
            boolean isSystemContext,
        @Override
 * Unless required by applicable law or agreed to in writing,
    public void addResponseHeader(final String key, final String value, final Function<String, String> uniqueValue) {
            threadContextStruct = threadContextStruct.putHeaders(builder.immutableMap());
    }
 *         } else {
            if (headers.isEmpty()) {
        private ThreadContextStruct putRequest(String key, String value) {
            close();
                out.writeString(entry.getKey());
                requestHeaders,
                    return new ThreadContextStruct(
            return new ContextPreservingAbstractRunnable((AbstractRunnable) command);
            // snapshot being restored. This ensures that transients written after the snapshot
        /**
        );
        if (value == null) {
     * Puts all of the given headers into this persistent context - persistent headers cannot be stashed
            if (newTransientHeaders.containsKey(transientHeaderToClear)) {
            final boolean replaceExistingKey
        };
     */
        ) {
     * @param uniqueValue the function that produces de-duplication values
        }
            return new ThreadContextStruct(requestHeaders, responseHeaders, newTransient, persistentHeaders, isSystemContext);
    @SuppressWarnings("removal")
    public static Map<String, String> buildDefaultHeaders(Settings settings) {
import org.opensearch.tasks.TaskThreadContextStatePropagator;
     *         public void run() {
    public StoredContext newStoredContext(boolean preserveResponseHeaders, boolean preserveTransients) {
            Map<String, Object> persistentHeaders,
        @Override
            putSingleHeader(key, value, newPersistentHeaders);
     * Wraps a Runnable to preserve the thread context.
            if (context.requestHeaders.containsKey(requestHeader)) {
     */
import org.apache.logging.log4j.LogManager;
        @Override
            }
            Map<String, Set<String>> responseHeaders,
                        transientHeaders,
        threadLocal.set(threadLocal.get().putRequest(key, value));
 *
        threadLocal.set(threadLocal.get().putPersistent(key, value));
        }
     *
    public StoredContext newStoredContext(boolean preserveResponseHeaders) {
        }
            }
import org.opensearch.http.HttpTransportSettings;
        public BinaryOperator<Set<T>> combiner() {
            return Collections.emptyMap();
 * Consumers of ThreadContext usually don't need to interact with adding or stashing contexts. Every opensearch thread is managed by
 */
    /**
    public Map<String, String> getHeaders() {
                final LinkedHashSet<String> values = new LinkedHashSet<>(size);
    }
            final String key,
            // was taken using newStoredContext (e.g. CURRENT_SPAN set by the tracing infrastructure) are not silently
        if (command instanceof ContextPreservingAbstractRunnable) {
            return in.toString();
import java.util.LinkedHashSet;
        return threadLocal.get() == DEFAULT_CONTEXT;
            return new ThreadContextStruct(requestHeaders, newResponseHeaders, transientHeaders, persistentHeaders, isSystemContext);
        map.putAll(threadLocal.get().requestHeaders);
    }
        @Override
    }
        return Collections.unmodifiableMap(map);
                newTransientHeaders.remove(transientHeaderToClear);
                defaultHeader.put(key, headers.get(key));
        }
    /**
        }
            if (defaultHeaders.isEmpty() && propagatedHeaders.isEmpty()) {
    }
            } else {
                }
                    putSingleHeader(entry.getKey(), entry.getValue(), newPersistentHeaders);
    public boolean isSystemContext() {
    @SuppressWarnings("removal")
                newWarningHeaderSize
        for (String transientHeaderToClear : transientHeadersToClear) {
                }
    private static final ThreadContextStruct DEFAULT_CONTEXT = new ThreadContextStruct();
            threadContextStruct = threadContextStruct.putTransient(transientHeaders);
 * compatible open source license.
        @Override
    /**
            // uncaught exception
    public ThreadContext(Settings settings) {
            StoredContext context = newStoredContext(false);
     * Usage of markAsSystemContext is guarded by a ThreadContextPermission. In order to use
                putSingleHeader(entry.getKey(), entry.getValue(), newTransient);
                    logger.warn(
        }
        }
     *
     * The removed context can be restored when closing the returned {@link StoredContext}. The merge strategy is that headers
                            + "] bytes set in ["
 * KIND, either express or implied.  See the License for the
        threadLocal.set(threadLocal.get().putResponse(key, value, uniqueValue, maxWarningHeaderCount, maxWarningHeaderSize, false));
            propagators.forEach(p -> transients.putAll(p.transients(transientHeaders, true)));
     *
                            + maxWarningHeaderSize
        private final Map<String, Set<String>> responseHeaders;
     * <p>
                    );
                        persistentHeaders,
        threadLocal.get().responseHeaders.remove(key);
            } else {
            false
                originalContext.isSystemContext,
        };
     *     new Thread() {
        // saving current warning headers' size not to recalculate the size with every new warning header
        @Override
        }
                    restoredContext = originalContext.putTransientIfAbsent(propagated);
     */
 * @opensearch.api
                newTransient.putIfAbsent(entry.getKey(), entry.getValue());
    }
        @Override
 *
        threadLocal.set(threadContextStruct);
        } else {
                        newWarningHeaderSize
 * <p>
 * </pre>
        return new ContextPreservingRunnable(command);
 * uses a try/with pattern to stash it's current context, read headers into a fresh one and once the request is handled or a handler thread
                return this;
     *     Supplier&lt;ThreadContext.StoredContext&gt; restorable = context.newRestorableContext(true);
            } else {
 */
    public Runnable preserveContext(Runnable command) {
    /**
        @Override
        }
     * Unwraps a command that was previously wrapped by {@link #preserveContext(Runnable)}.
        @Override
        }
    /**
     * Returns the request headers, without the default headers
     * For instance this method should be used like this:
     * restored by closing the returned {@link StoredContext}. Callers should
    /**
    private class ContextPreservingAbstractRunnable extends AbstractRunnable implements WrappedRunnable {
                builder.put(requestHeader, context.requestHeaders.get(requestHeader));
     * that are already existing are preserved unless they are defaults.
     * Just like {@link #stashContext()} but no default context is set. Instead, the {@code transientHeadersToClear} argument can be used
    /**
    }
            this.isSystemContext = isSystemContext;
            ctx = newStoredContext(false);
     * Returns <code>true</code> iff this context is a system context
import java.io.IOException;
                    logger.warn(
            final Map<String, String> propagatedHeaders = propagateHeaders(context.transientHeaders, context.isSystemContext);
        public Set<Characteristics> characteristics() {
     */
    /**
    public void updateResponseHeader(final String key, final String value, final Function<String, String> uniqueValue) {
 * that it is forking from.". Network calls will also preserve the senders headers automatically.
                if (threadsOriginalContext != null) {
    public void putPersistent(Map<String, Object> persistentHeaders) {
    public Object getPersistent(String key) {
            return new ThreadContextStruct(newRequestHeaders, responseHeaders, transientHeaders, persistentHeaders, isSystemContext);
     *             }
    public Supplier<StoredContext> newRestorableContext(boolean preserveResponseHeaders) {
        return threadLocal.get().persistentHeaders.get(key);
        return newStoredContext(preserveResponseHeaders, preserveTransients, Collections.emptyList());
    /**
        MapBuilder<String, String> builder = MapBuilder.newMapBuilder();
        );
            assert value != null;
 *         threadContext.readHeaders(in); // read headers into current context
import java.util.function.BinaryOperator;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Reads the headers from the stream into the current context
                    logger.warn(
    }
                        responseHeaders,
    private final ThreadLocal<ThreadContextStruct> threadLocal;
     * stashAndMergeHeaders, the codebase needs to explicitly be granted permission in the JSM policy file.
     * @param value       the header value
        return newStoredContext(preserveResponseHeaders, Collections.emptyList());
     * Returns all of the request headers from the thread's context.<br>
            if (existingValues != null) {
            }
                originalContext.warningHeadersSize
        return () -> threadLocal.set(context);
            out.writeMap(responseHeaders, StreamOutput::writeString, StreamOutput::writeStringCollection);
            // snapshot, losing any propagated transients that were set after newStoredContext() was called.
    /**
            final Map<String, String> requestHeaders;
     */
        threadLocal.set(threadLocal.get().setSystemContext(propagators));
     * @param key         the header name
            EnumSet.of(Collector.Characteristics.IDENTITY_FINISH)
        private void writeTo(StreamOutput out, Map<String, String> defaultHeaders, Map<String, String> propagatedHeaders)
        }
            for (Map.Entry<String, Object> entry : values.entrySet()) {
     */
     * <code>command</code> has already been passed through this method then it is returned unaltered rather than wrapped twice.
        private ThreadContextStruct putTransient(Map<String, Object> values) {
        boolean preserveTransients,
            Map<String, String> requestHeaders,
                newResponseHeaders,
    }
        final Map<String, Object> newTransientHeaders = new HashMap<>(originalContext.transientHeaders);
    }
            return putHeaders(newHeaders);
    }
     * @param preserveResponseHeaders if set to <code>true</code> the response headers of the restore thread will be preserved.
     */
        @Override
    ) {
            struct = ThreadContextStruct.EMPTY;
    // thread context permissions
     */
        void close();
            if ((key.equals("Warning")) && (maxWarningHeaderCount != -1)) { // if count is NOT unbounded, check its limits
    }
                }
        }
    }
    private Map<String, Object> propagateTransients(Map<String, Object> source, boolean isSystemContext) {
        }
            this.transientHeaders = transientHeaders;
            );
     * @param key         the header name
            this.warningHeadersSize = 0L;
        final Map<String, String> requestHeaders = headerTuple.v1();
    /**
        // this is the context when this method returns
import java.util.ArrayList;
        return out -> {
     * @param value       the header value
     * @param preserveResponseHeaders if set to <code>true</code> the response headers of the restore thread will be preserved.
                final Map<String, Object> propagated = propagateTransients(current.transientHeaders, current.isSystemContext);
        @Override
     * @return a restorable context supplier
                }
            ThreadContextStruct current = threadLocal.get();
import java.util.Collections;
     * Removes the current context and resets a default context marked with as
                            + maxWarningHeaderSize
        }
            this.in = in;
    }
    public Map<String, String> getRequestHeadersOnly() {
    }
 *
        this.maxWarningHeaderSize = SETTING_HTTP_MAX_WARNING_HEADER_SIZE.get(settings).getBytes();
            Collections.emptyMap(),
    /**
    }
        Map<String, Set<String>> responseHeaders = threadLocal.get().responseHeaders;
                }
        updateResponseHeader(key, value, v -> v);
        propagators.forEach(p -> transients.putAll(p.transients(source, isSystemContext)));
        }
        final ThreadContextStruct context = threadLocal.get();
            for (Map.Entry<String, String> header : headers) {
     */
     *
 * The OpenSearch Contributors require contributions made to
     * <pre>
     * actions that are made up of many sub-actions. These actions call
            Map<String, Object> newPersistentHeaders = new HashMap<>(this.persistentHeaders);
     * Add an entry in the grant portion of the policy file like this:
 *     // previous context is restored on StoredContext#close()
 * Modifications Copyright OpenSearch Contributors. See
            newTransientHeaders.putAll(transientHeaders);
     * Get a copy of all <em>response</em> headers.
     *                 // execute with the parents context and restore the threads context afterwards
                        requestHeaders,
        Collection<String> transientHeadersToClear
        propagators.forEach(p -> headers.putAll(p.headers(source, isSystemContext)));
            this.warningHeadersSize = warningHeadersSize;
            }
        private ThreadContextStruct(
    /**
                            + maxWarningHeaderCount
 * this work for additional information regarding copyright
            // Without this, restore() would blindly overwrite the threadLocal with the original
    public void unregisterThreadContextStatePropagator(final ThreadContextStatePropagator propagator) {
            }
        final ThreadContextStruct newContext = threadLocal.get();
    public void setHeaders(Tuple<Map<String, String>, Map<String, Set<String>>> headerTuple) {
                }
     * originating from the supplied string. The removed context can be
    public Map<String, List<String>> getResponseHeaders() {
        }
        return Collections.unmodifiableMap(map);
     * Puts a persistent header into the context - persistent headers cannot be stashed
     * which can be used to do this automatically.
    }
                if (newWarningHeaderSize > maxWarningHeaderSize) {
                        isSystemContext,
    public StoredContext stashContext() {
                        .collect(LINKED_HASH_SET_COLLECTOR);
 * You may obtain a copy of the License at
        }
 */
                newResponseHeaders = new HashMap<>(responseHeaders);
        propagators.add(Objects.requireNonNull(propagator));
            boolean isSystemContext
 * not use this file except in compliance with the License.
import org.apache.logging.log4j.Logger;
        }
    public static final String PREFIX = "request.headers";
    public void copyHeaders(Iterable<Map.Entry<String, String>> headers) {
                in.onAfter();
 */
            return new ThreadContextStruct(requestHeaders, responseHeaders, newTransient, persistentHeaders, isSystemContext);
        }
                isSystemContext,
    }
            this.persistentHeaders = persistentHeaders;
        private ThreadContextStruct putPersistent(Map<String, Object> headers) {
 * under the License.
     * @param key         the header name
    }
            return defaultHeader.get(key);
        private static final ThreadContextStruct EMPTY = new ThreadContextStruct(
                threadLocal.set(restoredContext);
    }
            }
            return in.toString();
        private final ThreadContext.StoredContext ctx;
 * license agreements. See the NOTICE file distributed with
            this.requestHeaders = requestHeaders;
    private static final Collector<String, Set<String>, Set<String>> LINKED_HASH_SET_COLLECTOR = new LinkedHashSetCollector<>();
     * @param storedContext the context to restore
            Collections.emptyMap(),
     * Creates a new ThreadContext instance
        public void onAfter() {
        HashMap<String, List<String>> map = new HashMap<>(responseHeaders.size());
        return storedContext;
     */
            final Set<String> existingValues = responseHeaders.get(key);
import java.util.Objects;
            this.responseHeaders = responseHeaders;
                if (warningHeadersSize > maxWarningHeaderSize) { // if max size has already been reached before
        final Map<String, Set<String>> responseHeaders = in.readMap(StreamInput::readString, input -> {
        }
    public void putHeader(Map<String, String> header) {
                out.writeString(entry.getValue());
     * A stored context
    }
import org.opensearch.common.collect.Tuple;
     */
        if (headers == null) {
            if (isSystemContext) {
     *
        private ThreadContextStruct copyHeaders(Iterable<Map.Entry<String, String>> headers) {
     * @param value       the header value
    private final Map<String, String> defaultHeader;
     * by the system itself rather than by a user action.
     *
                originalContext.persistentHeaders,
            return in;
        public String toString() {
import java.util.function.Supplier;
        }
     */
                requestHeaders = this.requestHeaders;
                final int warningHeaderCount = newResponseHeaders.containsKey("Warning") ? newResponseHeaders.get("Warning").size() : 0;
    }
import java.util.stream.Collector;
                newWarningHeaderSize += "Warning".getBytes(StandardCharsets.UTF_8).length + value.getBytes(StandardCharsets.UTF_8).length;
            creatorsContext = newStoredContext(false);
     * Marks this thread context as an internal system context. This signals that actions in this context are issued
        private ThreadContextStruct setSystemContext(final List<ThreadContextStatePropagator> propagators) {
     */
                for (Map.Entry<String, String> entry : headers.entrySet()) {
        putTransient(ACTION_ORIGIN_TRANSIENT_NAME, origin);
            } else {
                    newValues = Stream.of(value).collect(LINKED_HASH_SET_COLLECTOR);
 * is forked (which in turn inherits the context) it restores the previous context. For instance:
        final ThreadContextStruct context = threadLocal.get();
        return newStoredContext(preserveResponseHeaders, false, transientHeadersToClear);
     * permission org.opensearch.secure_sm.ThreadContextPermission "stashWithOrigin";
 *         }
    /**
    /**
        private ThreadContext.StoredContext threadsOriginalContext = null;
    public StoredContext stashWithOrigin(String origin) {
     * Add an entry in the grant portion of the policy file like this:
                    newValues = Stream.concat(existingValues.stream(), Stream.of(value)).collect(LINKED_HASH_SET_COLLECTOR);
    public String getHeader(String key) {
     *
        setHeaders(readHeadersFromStream(in));
                    putSingleHeader(entry.getKey(), entry.getValue(), newHeaders);
     * Captures the current thread context as writeable, allowing it to be serialized out later
        public String toString() {
        if (!transientHeaders.isEmpty()) {
                }
                }
     * Puts a header into the context
    }
            Map<String, Set<String>> responseHeaders,
    }
     * restored by closing the returned {@link StoredContext}.
            creatorsContext.restore();
     * Copies all header key, value pairs into the current context
            // check if we can add another warning header - if max count within limits
                newResponseHeaders.put(key, Collections.singleton(value));
import java.util.function.Function;
        if (command instanceof AbstractRunnable) {
            this.persistentHeaders = persistentHeaders;
        }
            for (Map.Entry<String, Set<String>> entry : headers.entrySet()) {
import org.opensearch.common.settings.Setting;
/*
        private ContextPreservingRunnable(Runnable in) {
     * stashWithOrigin, the codebase needs to explicitly be granted permission in the JSM policy file.
        for (String requestHeader : Task.REQUEST_HEADERS) {
                newTransientHeaders,
    public static final String ACTION_ORIGIN_TRANSIENT_NAME = "action.origin";
    /**
            this.in = in;
        propagators.remove(Objects.requireNonNull(propagator));
        private ThreadContextStruct putTransientIfAbsent(Map<String, Object> values) {
        if (!transientHeaders.isEmpty()) {
     * Wraps an AbstractRunnable to preserve the thread context.
                            + HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_SIZE.getKey()
import java.util.HashMap;
    private static class LinkedHashSetCollector<T> implements Collector<T, Set<T>, Set<T>> {
                } else {
        public AbstractRunnable unwrap() {
                return new ThreadContextStruct(requestHeaders, responseHeaders, transientHeaders, newPersistentHeaders, isSystemContext);
                            + "]!"
                transientHeaders,
                    final String value = input.readString();
        final ThreadContextStruct context = threadLocal.get();
        final Map<String, String> propagatedHeaders = propagateHeaders(context.transientHeaders, context.isSystemContext);
                    assert added : value;
/**
import org.opensearch.common.collect.MapBuilder;
 *             request.handle();
 *
    /**
                        "Dropping a warning header, as their total size reached the maximum allowed of ["
     * @param settings the settings to read the default request headers from
            for (Map.Entry<String, Object> entry : values.entrySet()) {
     */
            this.isSystemContext = isSystemContext;
import org.opensearch.tasks.Task;
     *
            if (preserveTransients) {
            }
                originalContext.requestHeaders,
    public Runnable unwrap(Runnable command) {
 *         if (fork) {
 * received, all headers are deserialized from the network and directly added as the headers of the threads {@link ThreadContext}
        }
     * by the clients.
 * A ThreadContext is a map of string headers and a transient map of keyed objects that are associated with
            final String value,
            if (size == 0) {
     * it is recommended to instead store security headers that prove
            storedContext.restore();
    public Writeable captureAsWriteable() {
                return this;
        }
    /**
     *             try (ThreadContext.StoredContext ctx = restorable.get()) {
     */
            ThreadContextStruct restoredContext = originalContext;
        public boolean isForceExecution() {
     *
        context.writeTo(out, defaultHeader, propagatedHeaders);
            ThreadContextStruct threadContextStruct = new ThreadContextStruct(
            }
        }
                newHeaders.put(header.getKey(), header.getValue());
    public void removeResponseHeader(final String key) {
import java.util.List;
        return (T) threadLocal.get().transientHeaders.get(key);
        final Map<String, Set<String>> responseHeaders = headerTuple.v2();
 *     // current context is stashed and replaced with a default context
     * Removes the current context and resets a new context that contains a merge of the current headers and the given headers.
        }
     * to clear specific transient headers in the new context. All headers (with the possible exception of {@code responseHeaders}) are
    /**
import java.util.stream.Stream;
    private Map<String, String> propagateHeaders(Map<String, Object> source, boolean isSystemContext) {
     */
        private ThreadContextStruct putPersistent(String key, Object value) {
            this(Collections.emptyMap(), Collections.emptyMap(), Collections.emptyMap(), Collections.emptyMap(), false);
            final int maxWarningHeaderCount,
        final ThreadContextStruct context = threadLocal.get();
            } else if (size == 1) {
            }
        return Collections.unmodifiableMap(new HashMap<>(threadLocal.get().requestHeaders));
            final long maxWarningHeaderSize,
    /**
     * be careful to save the current context before calling this method and
     * Usage of stashWithOrigin is guarded by a ThreadContextPermission. In order to use
            transientHeadersModified = true;
 * a thread pool or executor being responsible for stashing and restoring the threads context. For instance if a network request is
                    newResponseHeaders.put(key, Collections.unmodifiableSet(newValues));
            // dropped when the security plugin (or any other caller) calls storedContext.restore().
        private ThreadContextStruct putResponse(
 * this file be licensed under the Apache-2.0 license or a
        ) {
                    final boolean added = values.add(value);
        ) {
     *
                    final Set<String> newValues = Stream.concat(entry.getValue().stream(), existingValues.stream())
                    );
        }
import org.opensearch.core.common.io.stream.StreamOutput;
                // use a linked hash set to preserve order
            in.onRejection(e);
    public static final Setting<Settings> DEFAULT_HEADERS_SETTING = Setting.groupSetting(PREFIX + ".", Property.NodeScope);
     */
                    );
        }
    }
        public void onFailure(Exception e) {
          This is needed so the DeprecationLogger in another thread can see the value of X-Opaque-ID provided by a user.
                transientHeadersModified = true;
    /**
        private final Map<String, Object> persistentHeaders;
            }
        this.maxWarningHeaderCount = SETTING_HTTP_MAX_WARNING_HEADER_COUNT.get(settings);
/*
        threadLocal.set(struct);
                return left;
    }
                    return this;
    public void putPersistent(String key, Object value) {
        }
            if (headers.isEmpty()) {
            return Function.identity();
                threadLocal.set(restoredContext.putResponseHeaders(threadLocal.get().responseHeaders));
     */
                ctx.restore();
 * (see {@link #readHeaders(StreamInput)}. In order to not modify the context that is currently active on this thread the network code
        public BiConsumer<Set<T>, T> accumulator() {
        this.defaultHeader = buildDefaultHeaders(settings);
     * Same as {@link #newRestorableContext(boolean)} but wraps an existing context to restore.
            }
     * In order to avoid storing, and erroneously exposing, such headers,
        }
     * {@link #stashWithOrigin} before performing on behalf of a user that
    /**
    /**
     * @opensearch.api
     *
     */
            return CHARACTERISTICS;
     * Returns true if the current context is the default context.
                requestHeaders.putAll(this.requestHeaders);
    public Supplier<StoredContext> wrapRestorable(StoredContext storedContext) {
        return headers;
    }
                }
        private final ThreadContext.StoredContext creatorsContext;
                final Set<String> existingValues = newResponseHeaders.get(key);
            map.put(entry.getKey(), Collections.unmodifiableList(new ArrayList<>(entry.getValue())));
                persistentHeaders,
     * Returns the persistent header for the given key or <code>null</code> if not present - persistent headers cannot be stashed
        }
                            + "] set in ["
    }
     *
import java.util.Map;
        private ThreadContextStruct putResponseHeaders(Map<String, Set<String>> headers) {
    private final List<ThreadContextStatePropagator> propagators;
@PublicApi(since = "1.0.0")
        return threadLocal.get().isSystemContext;
     * suppliers callers context that should be restored once the originally gathered context is not needed anymore.
     * @return Never {@code null}.
    private class ContextPreservingRunnable implements WrappedRunnable {
     * @param uniqueValue the function that produces de-duplication values
        Map<String, String> newHeader = new HashMap<>(headers);
     * should be allowed even if the user doesn't have permission to perform
     * Add the {@code value} for the specified {@code key} with the specified {@code uniqueValue} used for de-duplication. Any duplicate
     */
}
     * <b>Be advised, headers might contain credentials.</b>
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_SIZE;
            } else {
     *
                Set<String> newValues;
     * {@code value} after applying {@code uniqueValue} is ignored.
        threadLocal.set(DEFAULT_CONTEXT.putHeaders(newHeader));
            Collections.emptyMap(),
        HashMap<String, String> map = new HashMap<>(defaultHeader);
    /**
        final Map<String, Object> transientHeaders = propagateTransients(context.transientHeaders, context.isSystemContext);
    }
                            + "] bytes set in ["
        return wrapRestorable(newStoredContext(preserveResponseHeaders));
     *
     */
          X-Opaque-ID should be preserved in a threadContext in order to propagate this across threads.
            return context;
    public void addResponseHeader(final String key, final String value) {
        private ThreadContextStruct(
                    return this;
            putSingleHeader(key, value, newTransient);
    public StoredContext newStoredContext(
