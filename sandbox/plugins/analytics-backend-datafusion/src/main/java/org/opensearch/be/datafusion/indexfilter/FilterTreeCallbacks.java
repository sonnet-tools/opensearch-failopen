         * delegation handle with it — when the last native handle's reference drops.
            boolean created = false;
         * Owns the binding's lifetime: born at 1 (the query's reference), one more per
            assertBindingExists(binding, "createProvider", contextId);
     * <p>Segments are identified by writer generation.
        int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {
                ),
     * indicates a leaked binding from an earlier query (missing {@link #requestClose(long)})
                handle.releaseCollector(collectorKey);
    }
            QueryBinding binding = BINDINGS.get(contextId);
     *
        }
        binding.requestClose();
import java.util.concurrent.atomic.AtomicBoolean;
     * (provider or collector) holds one ({@code create*} acquires it, {@code release*}
    // ── Collector lifecycle (hot path, per segment per query) ─────────
            LOGGER.warn("trackStart failed; resource attribution disabled for this upcall", throwable);
        } catch (Throwable throwable) {
import java.util.concurrent.ConcurrentHashMap;
 * this file be licensed under the Apache-2.0 license or a
                binding.releaseProvider(providerKey);
     * {@code collectDocs(contextId, collectorKey, minDoc, maxDoc, outPtr, outWordCap) -> packed(nextDoc|wordsWritten)|-1}.
 *   <li>After query completion: {@link #requestClose(long)} drops the query's own
        /** Runs exactly once, when the last reference (query or native handle) drops. */
     * Force-remove the binding without closing the handle. Test-only escape hatch for
}
            );
            if (handle.isCancelled()) {
    /**
            return binding.createCollector(providerKey, writerGeneration, minDoc, maxDoc);
    /**
                return -1;
     * Per-query binding whose lifetime is reference-counted: the query itself holds
        /** Release a provider and drop its reference; the last drop closes the binding. */
     * {@code createCollector(contextId, providerKey, writerGeneration, minDoc, maxDoc) -> collectorKey|-1}.
                }
        if (threadId < 0) return;
 *
        }
                int key = handle.createCollector(providerKey, writerGeneration, minDoc, maxDoc);
        // with `Unrecoverable uncaught exception encountered`. Swallow everything and
                refCounter.decRef();
     */
        /** Ensures {@link #requestClose} drops the query's reference at most once. */
                return -1L;
            throw e;
                    providerKey,
 * </ol>
            LOGGER.error(
            );
            // Propagate so lifecycle bugs surface in tests; in production -ea is off and this branch never runs.
            boolean created = false;
         */
        try {
            + " (registered: "
            }
            protected void closeInternal() {
        } finally {
    }
                return -1;
        private void close() {
        QueryBinding binding = BINDINGS.get(contextId);
     * @param handle    the delegation handle for this query (must not be null)
        } catch (Throwable throwable) {
            assertBindingExists(binding, "releaseProvider", contextId);
        } catch (AssertionError e) {
     */
     * returns -1 from the caller's null check.
 *       stream (e.g. a satisfied LIMIT, whose final drop runs on a DataFusion
     *
                    refCounter.decRef(); // no native handle exists to release this reference later
        private final long contextId;
    }
                if (created == false) {
    /**
        }
            return -1;
    }
    public static void releaseProvider(long contextId, int providerKey) {
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.analytics.spi.FilterDelegationHandle;
                new ParameterizedMessage("releaseCollector(contextId={}, collectorKey={}) failed", contextId, collectorKey),
            long result = handle.collectDocs(collectorKey, minDoc, maxDoc, view);
                throwable
        // escaping exception (e.g. an `assert false` in TaskResourceTrackingService when
                    writerGeneration,
        try {
        try {
            trackEnd(contextId, tid);
            QueryBinding binding = BINDINGS.get(contextId);
    public static void requestClose(long contextId) {
            }
                ),
            }
 * compatible open source license.
            LOGGER.error(
                throwable
            throw e;
                    refCounter.decRef();
            @Override
            throw e;
            this.tracker = tracker;
     * drops it — all through the internal {@code refCounter}). The
            try {
 * (double-register, premature teardown, leaked bindings) during development without
 * <p>When assertions are enabled ({@code -ea}, default in tests and {@code ./gradlew run}),
        int createProvider(int annotationId) {
            assertBindingExists(binding, "collectDocs", contextId);
     *
            );
        /**
     * Per-query binding of handle and tracker, keyed by contextId.
     */
        }
    private FilterTreeCallbacks() {}
            + BINDINGS.keySet()
    /**
            + ")";
 * <h2>Lifecycle</h2>
     * binding is removed — and the delegation handle closed — exactly once, when the
            QueryBinding binding = BINDINGS.get(contextId);
        private final AbstractRefCounted refCounter = new AbstractRefCounted("filter-delegation-binding") {
        void requestClose() {
        long tid = trackStart(contextId);
 * affecting production behavior — assertions are off in production, where the same paths
                    "collectDocs(contextId={}, collectorKey={}, [{}, {})) failed",
     * Register a per-query binding keyed by {@code contextId}.
            );
        } finally {
            LOGGER.error(
     * stale Rust handle outliving its query) trip this in tests; production silently
        try {
        try {
     * <p>Throws {@link AssertionError} when assertions are enabled and binding is null.
    }
            return (result < 0) ? -1L : result;
            this.contextId = contextId;
 * an FFM upcall stub crashes the JVM.
         * handle on success. Returns -1 (without holding a reference) if the binding
     */
                LOGGER.warn(new ParameterizedMessage("FilterDelegationHandle.close() failed for contextId={}", contextId), throwable);
    public static long collectDocs(long contextId, int collectorKey, int minDoc, int maxDoc, MemorySegment outPtr, long outWordCap) {
import org.opensearch.common.util.concurrent.AbstractRefCounted;
        // the thread is already tracked) crosses the FFM boundary and aborts the JVM
    }
 * <ol>
     * ConcurrentHashMap provides safe concurrent access across parallel queries.
    /**
     * {@link #requestClose(long)}.
 * Static callback targets invoked by the native engine via FFM upcalls.
            return -1;
     * partially-consumed native streams safe.
                    maxDoc
                    contextId,
        }
     * <p>Asserts no prior binding exists for {@code contextId}. A pre-existing binding
        };
     * Must be called before query execution begins.
        } catch (AssertionError e) {
 *       reference. The binding is removed — and the handle closed — when the last
            return tracker;
        long tid = trackStart(contextId);
            + op
        // disable tracking for the remainder of this upcall by returning -1.
            + ": no binding for contextId="
            if (binding != null) {
                // May run on an FFM upcall thread — must not throw.
            MemorySegment view = outPtr.reinterpret((long) maxWords * Long.BYTES);
                return key;
            }
        } catch (Throwable throwable) {
            return -1L;
 *   <li>Before query execution: {@link #register(long, FilterDelegationHandle, DelegationThreadTracker)}
            + contextId
import org.apache.logging.log4j.LogManager;
 * <h2>Error-handling contract</h2>
            return -1;
        final AtomicBoolean closeRequested = new AtomicBoolean();
        /**
    private static final ConcurrentHashMap<Long, QueryBinding> BINDINGS = new ConcurrentHashMap<>();
            if (refCounter.tryIncRef() == false) {
            QueryBinding binding = BINDINGS.get(contextId);
 * The OpenSearch Contributors require contributions made to
                QueryBinding.this.close();
        private final DelegationThreadTracker tracker;
        private final FilterDelegationHandle handle;
     * {@code releaseCollector(contextId, collectorKey)}. Never throws.
    public static void unregister(long contextId) {
        // Same FFM safety rule as trackStart — runs in a `finally` block, so any
                return -1;
            QueryBinding binding = BINDINGS.get(contextId);
            return binding.createProvider(annotationId);
 *
     * @param tracker   the thread tracker for this query (may be null)
            if (binding == null) return -1;
/**
     * suites that manage handle lifecycles themselves; production teardown must use
        /** Collector twin of {@link #createProvider(int)} — same reference contract. */
            return binding.collectDocs(collectorKey, minDoc, maxDoc, outPtr, outWordCap);
        }
                assert false : "createCollector: binding already fully closed for contextId=" + contextId;
            throw e;
            this.handle = java.util.Objects.requireNonNull(handle, "handle");
                refCounter.decRef();
     */
        }
    /**
            } finally {
     * {@code releaseProvider(contextId, providerKey)}. Never throws.
        // Must never throw — runs OUTSIDE the try/catch in each upcall target, so any
        long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment outPtr, long outWordCap) {
     * immediately if no native handles are outstanding, otherwise defers until the
            if (binding != null) {
        /** Delegate a doc-collection call; refuses (-1) when the query is cancelled. */
        }
            LOGGER.error("createProvider failed for contextId=" + contextId + " annotationId=" + annotationId, throwable);
        } catch (AssertionError e) {
                    contextId,
 *
            BINDINGS.remove(contextId);
                return -1L;
            LOGGER.warn("trackEnd failed", throwable);
    public static void register(long contextId, FilterDelegationHandle handle, DelegationThreadTracker tracker) {
            if (binding == null) {
                new ParameterizedMessage(
    }
 * <p>Every method catches all {@link Throwable}s and returns {@code -1}
 * (or silently returns for void methods). A Java exception escaping through
     */
            }
    }
         */
 *       matching {@code release*} upcall drops it.</li>
    public static void releaseCollector(long contextId, int collectorKey) {
            int maxWords = (int) Math.min(outWordCap, (long) Integer.MAX_VALUE);
        } catch (AssertionError e) {
                return -1;
                    minDoc,
            trackEnd(contextId, tid);
 * SPDX-License-Identifier: Apache-2.0
                refCounter.decRef();
    }
    // VisibleForTesting
                handle.releaseProvider(providerKey);
     * Request teardown of the binding for {@code contextId}: closes and removes it
        } catch (Throwable throwable) {
        }
        // exception escaping here would mask the actual upcall result and abort the JVM.
            }
        BINDINGS.remove(contextId);
            if (t != null) t.trackEnd(threadId);
     *
            } finally {
/*
 * from {@link #BINDINGS}. This eliminates the global-singleton race condition that
            }
 */
 * {@link #register} asserts no stale binding is left behind. These catch lifecycle bugs
                handle.close();
            try {
     */
    }
            trackEnd(contextId, tid);
                new ParameterizedMessage("releaseProvider(contextId={}, providerKey={}) failed", contextId, providerKey),
            } catch (Throwable throwable) {
                throwable
     * Asserts a binding exists. Lifecycle bugs (premature teardown, missing register,
         * links the counter to {@link #close()}.
     */
                created = key >= 0;
        void releaseProvider(int providerKey) {
            try {
    /**
 *   <li>FFM upcalls route to the correct per-query handle via contextId. Each
    private static final class QueryBinding {
    /**
    public static int createCollector(long contextId, int providerKey, long writerGeneration, int minDoc, int maxDoc) {
     * last {@code release*} upcall arrives (late drops of partially-consumed native
                    "createCollector(contextId={}, providerKey={}, writerGeneration={}, [{}, {})) failed",
                    minDoc,
            }
        }
    // ── Provider lifecycle (cold path, once per query) ────────────────
 *       successful {@code create*} upcall holds a reference on the binding; the
 *       reference drops, so late release upcalls from a partially-consumed native
     * being silently logged. Under the refcounted lifecycle a missing binding is a
    private static void trackEnd(long contextId, long threadId) {
        }
        }
            if (refCounter.tryIncRef() == false) {
        QueryBinding prev = BINDINGS.put(contextId, new QueryBinding(contextId, handle, tracker));
     * Upcall methods catch {@code Throwable} and re-throw {@code AssertionError} so it
 *
     * {@code createProvider(contextId, annotationId) -> providerKey|-1}.
     * Idempotent — calling with no current binding is a no-op.
     * or a duplicate register call.
                created = key >= 0;
     * <p>Owns {@code handle.close()} — callers must not close the handle themselves.
        } catch (Throwable throwable) {
                }
    /**
            }
         * Create a provider via the handle, acquiring one reference for the native
            }
 * {@code QueryTrackingContext}) as its first argument, which is used to look up the
                binding.releaseCollector(collectorKey);
 * correct per-query {@link FilterDelegationHandle} and {@link DelegationThreadTracker}
        } catch (AssertionError e) {
        QueryBinding(long contextId, FilterDelegationHandle handle, DelegationThreadTracker tracker) {
                if (created == false) {
        /**
                    maxDoc
     * one reference (dropped by {@link #requestClose}), and every live native handle
public final class FilterTreeCallbacks {
    }
                assert false : "createProvider: binding already fully closed for contextId=" + contextId;
        } finally {
        assert binding != null : "FilterTreeCallbacks."
        } catch (Throwable throwable) {
     * @param contextId the per-query identifier (from the native {@code QueryTrackingContext})
    }
 *
        try {
            LOGGER.error(
 * <p>Each callback receives a {@code contextId} (the per-query identifier assigned by
        try {
        void releaseCollector(int collectorKey) {
import java.lang.foreign.MemorySegment;
     * surfaces in tests (causing the JVM to exit through the FFM stub) rather than
                    collectorKey,
            if (binding == null) {
    public static int createProvider(long contextId, int annotationId) {
package org.opensearch.be.datafusion.indexfilter;
     * genuine bug: bindings stay alive until the last native handle is released.
            }
 * fall back to returning -1 silently.
    /**
            QueryBinding binding = BINDINGS.get(contextId);
                return key;
                new ParameterizedMessage(
import org.opensearch.analytics.spi.DelegationThreadTracker;
                throwable
            try {
            DelegationThreadTracker t = binding.tracker();
            }
            try {
            return (t != null) ? t.trackStart() : -1;
            QueryBinding binding = BINDINGS.get(contextId);
 * <h2>Lifecycle assertions</h2>
 * the callbacks {@code assert} that a binding exists before performing the upcall, and
            if (binding == null) {
     */
        }
 * existed when concurrent queries shared a single AtomicReference.
        }
            assertBindingExists(binding, "releaseCollector", contextId);
            } finally {
            }
    private static long trackStart(long contextId) {
     *
    private static void assertBindingExists(QueryBinding binding, String op, long contextId) {
        if (binding == null) {
            } finally {
            DelegationThreadTracker t = binding.tracker();
import org.apache.logging.log4j.Logger;
        }
     * last reference drops, which is what keeps late release upcalls from
         * Drop the query's own reference (at most once). The binding closes — and the
            return;
        long tid = trackStart(contextId);
        }
 */
            }
     */
         * live native handle. Reaching zero closes the binding — {@code closeInternal}
 *       installs a binding for the query's contextId.</li>
    /**
         */
            if (binding == null) return;
            }
     * streams happen on DataFusion runtime threads after Java-side teardown returns).
        }
    private static final Logger LOGGER = LogManager.getLogger(FilterTreeCallbacks.class);
         * is already fully closed or the handle refuses.
        /** Release a collector and drop its reference; the last drop closes the binding. */
                int key = handle.createProvider(annotationId);
            assertBindingExists(binding, "createCollector", contextId);
 *       runtime thread after Java-side teardown returns) still find the binding.</li>
            throw e;
            if (closeRequested.compareAndSet(false, true)) {
        DelegationThreadTracker tracker() {
     */
        } catch (Throwable throwable) {
        assert prev == null : "FilterTreeCallbacks.register: binding already present for contextId=" + contextId;
