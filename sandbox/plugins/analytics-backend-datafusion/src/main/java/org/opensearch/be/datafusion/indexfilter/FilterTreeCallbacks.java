     * partially-consumed native streams safe.
            try {
                assert false : "createCollector: binding already fully closed for contextId=" + contextId;  
            return -1L;  
 */
     * {@code createCollector(contextId, providerKey, writerGeneration, minDoc, maxDoc) -> collectorKey|-1}.
            }  
    /**  
    }
 *
 * <h2>Lifecycle assertions</h2>
        } catch (Throwable throwable) {  
            }  
     * being silently logged. Under the refcounted lifecycle a missing binding is a
                    writerGeneration,
                return -1L;  
            LOGGER.error(  
 *   <li>Before query execution: {@link #register(long, FilterDelegationHandle, DelegationThreadTracker)}
         */  
     * surfaces in tests (causing the JVM to exit through the FFM stub) rather than  
            assertBindingExists(binding, "collectDocs", contextId);  
     * returns -1 from the caller's null check.
                    refCounter.decRef();
        QueryBinding prev = BINDINGS.put(contextId, new QueryBinding(contextId, handle, tracker));  
                    "collectDocs(contextId={}, collectorKey={}, [{}, {})) failed",
                return key;
                if (created == false) {  
                    maxDoc
        int createProvider(int annotationId) {
            if (handle.isCancelled()) {
                }
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
            );
        /** Runs exactly once, when the last reference (query or native handle) drops. */  
import org.opensearch.analytics.spi.DelegationThreadTracker;
         * delegation handle with it — when the last native handle's reference drops.
            return binding.createProvider(annotationId);  
 * {@link #register} asserts no stale binding is left behind. These catch lifecycle bugs
                return -1L;
import org.opensearch.common.util.concurrent.AbstractRefCounted;  
                new ParameterizedMessage("releaseCollector(contextId={}, collectorKey={}) failed", contextId, collectorKey),
            + BINDINGS.keySet()
/**  
        }  
         * Create a provider via the handle, acquiring one reference for the native  
            if (binding == null) return;  
     * streams happen on DataFusion runtime threads after Java-side teardown returns).
                    collectorKey,  
            LOGGER.error("createProvider failed for contextId=" + contextId + " annotationId=" + annotationId, throwable);
                new ParameterizedMessage(
        }
                created = key >= 0;  
            }  
 * <h2>Error-handling contract</h2>
        // Must never throw — runs OUTSIDE the try/catch in each upcall target, so any
     */
            try {  
import org.opensearch.analytics.spi.FilterDelegationHandle;
            if (binding != null) {
        }
            LOGGER.error(
public final class FilterTreeCallbacks {  
        }  
import org.apache.logging.log4j.message.ParameterizedMessage;  
        if (binding == null) {  
 */  
                throwable  
        assert binding != null : "FilterTreeCallbacks."
            + ": no binding for contextId="
            return -1;
        /**
     * {@link #requestClose(long)}.  
    public static void releaseCollector(long contextId, int collectorKey) {  
            return (t != null) ? t.trackStart() : -1;
        };
                assert false : "createProvider: binding already fully closed for contextId=" + contextId;  
        void releaseCollector(int collectorKey) {
                refCounter.decRef();
     * <p>Asserts no prior binding exists for {@code contextId}. A pre-existing binding  
     *  
    /**
 * an FFM upcall stub crashes the JVM.
        private final DelegationThreadTracker tracker;
            return -1;
            BINDINGS.remove(contextId);
     * (provider or collector) holds one ({@code create*} acquires it, {@code release*}
            this.tracker = tracker;
        } catch (Throwable throwable) {
        } catch (Throwable throwable) {  
    /**
    public static void register(long contextId, FilterDelegationHandle handle, DelegationThreadTracker tracker) {
     * {@code collectDocs(contextId, collectorKey, minDoc, maxDoc, outPtr, outWordCap) -> packed(nextDoc|wordsWritten)|-1}.  
            LOGGER.error(
        }
            QueryBinding binding = BINDINGS.get(contextId);
     * or a duplicate register call.
            return binding.createCollector(providerKey, writerGeneration, minDoc, maxDoc);
     * Idempotent — calling with no current binding is a no-op.
                    maxDoc
        private final AbstractRefCounted refCounter = new AbstractRefCounted("filter-delegation-binding") {  
            }  
            return tracker;
            }  
 * {@code QueryTrackingContext}) as its first argument, which is used to look up the
            QueryBinding binding = BINDINGS.get(contextId);
            }
     * <p>Owns {@code handle.close()} — callers must not close the handle themselves.
                handle.releaseProvider(providerKey);  
                LOGGER.warn(new ParameterizedMessage("FilterDelegationHandle.close() failed for contextId={}", contextId), throwable);
            QueryBinding binding = BINDINGS.get(contextId);
                ),
            }
            boolean created = false;  
            } finally {
        /** Collector twin of {@link #createProvider(int)} — same reference contract. */  
            + ")";
    private static final Logger LOGGER = LogManager.getLogger(FilterTreeCallbacks.class);
        }
            LOGGER.warn("trackEnd failed", throwable);
        } catch (AssertionError e) {
        } finally {
 *   <li>FFM upcalls route to the correct per-query handle via contextId. Each
        } finally {  
        if (threadId < 0) return;
    }
            MemorySegment view = outPtr.reinterpret((long) maxWords * Long.BYTES);  
    }  
    }  
     * <p>Throws {@link AssertionError} when assertions are enabled and binding is null.
    /**  
            trackEnd(contextId, tid);
            } finally {
     */  
 *
     * Per-query binding whose lifetime is reference-counted: the query itself holds
        BINDINGS.remove(contextId);
                binding.releaseProvider(providerKey);
     */
            throw e;
        } catch (AssertionError e) {
        long tid = trackStart(contextId);
        DelegationThreadTracker tracker() {
    }
        QueryBinding(long contextId, FilterDelegationHandle handle, DelegationThreadTracker tracker) {
        } catch (Throwable throwable) {  
     * binding is removed — and the delegation handle closed — exactly once, when the  
        }
         * links the counter to {@link #close()}.
    /**
        /**
         * Owns the binding's lifetime: born at 1 (the query's reference), one more per
package org.opensearch.be.datafusion.indexfilter;
     *  
                created = key >= 0;  
 *       reference. The binding is removed — and the handle closed — when the last
        }  
            }
            + " (registered: "  
                    providerKey,
 * <p>Every method catches all {@link Throwable}s and returns {@code -1}  
     */
     */
     * genuine bug: bindings stay alive until the last native handle is released.
     * last reference drops, which is what keeps late release upcalls from
        }  
        /** Release a provider and drop its reference; the last drop closes the binding. */  
        // escaping exception (e.g. an `assert false` in TaskResourceTrackingService when  
            QueryBinding binding = BINDINGS.get(contextId);
            }  
            DelegationThreadTracker t = binding.tracker();
        assert prev == null : "FilterTreeCallbacks.register: binding already present for contextId=" + contextId;
            assertBindingExists(binding, "releaseProvider", contextId);  
    private static final ConcurrentHashMap<Long, QueryBinding> BINDINGS = new ConcurrentHashMap<>();
     * Per-query binding of handle and tracker, keyed by contextId.
        }
            throw e;
 * <h2>Lifecycle</h2>  
                QueryBinding.this.close();  
        int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {
        /** Release a collector and drop its reference; the last drop closes the binding. */  
            @Override
        }
import org.apache.logging.log4j.LogManager;
         */
     * indicates a leaked binding from an earlier query (missing {@link #requestClose(long)})
     * {@code createProvider(contextId, annotationId) -> providerKey|-1}.
         * Drop the query's own reference (at most once). The binding closes — and the  
     * Upcall methods catch {@code Throwable} and re-throw {@code AssertionError} so it
        private void close() {
     * immediately if no native handles are outstanding, otherwise defers until the  
            );
    private static final class QueryBinding {
        } finally {
                    refCounter.decRef(); // no native handle exists to release this reference later
         * is already fully closed or the handle refuses.
 * <p>Each callback receives a {@code contextId} (the per-query identifier assigned by  
                refCounter.decRef();
 * <ol>
            throw e;  
     * @param contextId the per-query identifier (from the native {@code QueryTrackingContext})
     * Must be called before query execution begins.
     * @param handle    the delegation handle for this query (must not be null)
import java.util.concurrent.ConcurrentHashMap;  
        } catch (Throwable throwable) {
            return -1;  
            if (binding == null) return -1;  
     * Force-remove the binding without closing the handle. Test-only escape hatch for
     * suites that manage handle lifecycles themselves; production teardown must use
                binding.releaseCollector(collectorKey);
    public static void unregister(long contextId) {  
            return binding.collectDocs(collectorKey, minDoc, maxDoc, outPtr, outWordCap);
 * existed when concurrent queries shared a single AtomicReference.
            }  
                // May run on an FFM upcall thread — must not throw.  
        // with `Unrecoverable uncaught exception encountered`. Swallow everything and
            QueryBinding binding = BINDINGS.get(contextId);  
                if (created == false) {  
 *       stream (e.g. a satisfied LIMIT, whose final drop runs on a DataFusion
            if (binding == null) {
     */
            this.handle = java.util.Objects.requireNonNull(handle, "handle");  
import org.apache.logging.log4j.Logger;
        private final long contextId;
                ),  
                throwable
 * fall back to returning -1 silently.
            trackEnd(contextId, tid);
     * <p>Segments are identified by writer generation.
                int key = handle.createProvider(annotationId);
            if (binding == null) {
     * {@code releaseProvider(contextId, providerKey)}. Never throws.
    }
            LOGGER.error(
        }
                    contextId,  
     * {@code releaseCollector(contextId, collectorKey)}. Never throws.
        /** Delegate a doc-collection call; refuses (-1) when the query is cancelled. */  
        }
     * Request teardown of the binding for {@code contextId}: closes and removes it
        void releaseProvider(int providerKey) {
    }
        try {
 * correct per-query {@link FilterDelegationHandle} and {@link DelegationThreadTracker}
            }
        QueryBinding binding = BINDINGS.get(contextId);
    private FilterTreeCallbacks() {}  
    public static void releaseProvider(long contextId, int providerKey) {  
            if (binding != null) {
 *
     * Register a per-query binding keyed by {@code contextId}.  
     * ConcurrentHashMap provides safe concurrent access across parallel queries.  
                    contextId,
            if (refCounter.tryIncRef() == false) {
            protected void closeInternal() {
            trackEnd(contextId, tid);
 * the callbacks {@code assert} that a binding exists before performing the upcall, and  
     * Asserts a binding exists. Lifecycle bugs (premature teardown, missing register,  
        try {  
            );
     *  
    /**
            int maxWords = (int) Math.min(outWordCap, (long) Integer.MAX_VALUE);
        } catch (AssertionError e) {
    public static void requestClose(long contextId) {
        try {
            return;
            assertBindingExists(binding, "createCollector", contextId);
        binding.requestClose();  
    }  
            try {
    private static void trackEnd(long contextId, long threadId) {  
            if (refCounter.tryIncRef() == false) {
import java.lang.foreign.MemorySegment;
                }
 *       matching {@code release*} upcall drops it.</li>  
     */  
         * handle on success. Returns -1 (without holding a reference) if the binding
        } catch (Throwable throwable) {
            // Propagate so lifecycle bugs surface in tests; in production -ea is off and this branch never runs.
                return -1;
 * The OpenSearch Contributors require contributions made to  
        void requestClose() {  
    /**
            if (binding == null) {  
            long result = handle.collectDocs(collectorKey, minDoc, maxDoc, view);
 * (or silently returns for void methods). A Java exception escaping through
 * SPDX-License-Identifier: Apache-2.0
     *  
    }  
        long tid = trackStart(contextId);  
            assertBindingExists(binding, "createProvider", contextId);
                return -1;
    }  
    private static long trackStart(long contextId) {
 * <p>When assertions are enabled ({@code -ea}, default in tests and {@code ./gradlew run}),
            + op  
            DelegationThreadTracker t = binding.tracker();
                refCounter.decRef();
/*  
         */
            try {
        long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment outPtr, long outWordCap) {
 * Static callback targets invoked by the native engine via FFM upcalls.
    // ── Provider lifecycle (cold path, once per query) ────────────────
        } catch (Throwable throwable) {  
        }  
                int key = handle.createCollector(providerKey, writerGeneration, minDoc, maxDoc);
 * </ol>  
        }  
     * drops it — all through the internal {@code refCounter}). The
            LOGGER.warn("trackStart failed; resource attribution disabled for this upcall", throwable);
            + contextId
     *
    private static void assertBindingExists(QueryBinding binding, String op, long contextId) {
}
     * last {@code release*} upcall arrives (late drops of partially-consumed native
                throwable  
    /**
 *       installs a binding for the query's contextId.</li>  
            }  
                    minDoc,
 * affecting production behavior — assertions are off in production, where the same paths  
            }
        try {
            } finally {
            QueryBinding binding = BINDINGS.get(contextId);
                throwable  
    /**
    }
                new ParameterizedMessage(  
 *
            try {
        /** Ensures {@link #requestClose} drops the query's reference at most once. */
    public static int createCollector(long contextId, int providerKey, long writerGeneration, int minDoc, int maxDoc) {  
        try {
 *       reference drops, so late release upcalls from a partially-consumed native  
            return (result < 0) ? -1L : result;
 * from {@link #BINDINGS}. This eliminates the global-singleton race condition that  
            throw e;
    /**
            if (closeRequested.compareAndSet(false, true)) {
                return key;
    /**  
                return -1;
        // Same FFM safety rule as trackStart — runs in a `finally` block, so any
        }
            boolean created = false;  
import java.util.concurrent.atomic.AtomicBoolean;
     */  
            } catch (Throwable throwable) {
    public static int createProvider(long contextId, int annotationId) {
    // ── Collector lifecycle (hot path, per segment per query) ─────────
     * @param tracker   the thread tracker for this query (may be null)  
 *       runtime thread after Java-side teardown returns) still find the binding.</li>
    public static long collectDocs(long contextId, int collectorKey, int minDoc, int maxDoc, MemorySegment outPtr, long outWordCap) {
            }
    }
        // exception escaping here would mask the actual upcall result and abort the JVM.  
            }
        final AtomicBoolean closeRequested = new AtomicBoolean();  
                return -1;  
     */
 *  
        } catch (AssertionError e) {
            } finally {
 *       successful {@code create*} upcall holds a reference on the binding; the
            assertBindingExists(binding, "releaseCollector", contextId);  
        }
            if (t != null) t.trackEnd(threadId);
            this.contextId = contextId;
     */  
     * one reference (dropped by {@link #requestClose}), and every live native handle  
                    "createCollector(contextId={}, providerKey={}, writerGeneration={}, [{}, {})) failed",
        try {
 * (double-register, premature teardown, leaked bindings) during development without
         * live native handle. Reaching zero closes the binding — {@code closeInternal}  
        private final FilterDelegationHandle handle;  
        // disable tracking for the remainder of this upcall by returning -1.  
                handle.close();
    // VisibleForTesting
        // the thread is already tracked) crosses the FFM boundary and aborts the JVM
     */
        try {
        } catch (AssertionError e) {  
            throw e;  
            );
                handle.releaseCollector(collectorKey);  
                    minDoc,  
        /**
        long tid = trackStart(contextId);
     * stale Rust handle outliving its query) trip this in tests; production silently
            QueryBinding binding = BINDINGS.get(contextId);
 *   <li>After query completion: {@link #requestClose(long)} drops the query's own
                new ParameterizedMessage("releaseProvider(contextId={}, providerKey={}) failed", contextId, providerKey),
