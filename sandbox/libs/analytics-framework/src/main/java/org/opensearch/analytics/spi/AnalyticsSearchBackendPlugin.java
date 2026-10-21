     * When {@code null}, the framework falls back to one {@link DelegatedExpression} per leaf.
    default FilterDelegationHandle getFilterDelegationHandle(List<DelegatedExpression> expressions, CommonExecutionContext ctx) {
     * data nodes that hold any shard of the joined indices.
    /**
        Reader reader,
        throw new UnsupportedOperationException("getFragmentConvertor not implemented for [" + name() + "]");
 * <ul>
     * @param columns column names to read
        public static CanMatchResult matched(ShardSortBounds bounds) {
     * Returns the backend's subtree convertor for combining multiple delegated predicates
    /**
     * Row IDs are passed as a BigIntVector for zero-copy transfer to native.
    default BackendCapabilityProvider getCapabilityProvider() {
     * Returns the capability provider for this backend.
    default Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        return null;
     * Install a thread tracker for attribution of delegation callbacks executing on foreign threads.
     * QTF fetch phase: reads specific rows by global row ID.
     * Cooperatively cancels in-flight backend work for {@code contextId} (e.g. fire the per-context
    }
     */
    }
     * @param expressions the delegated expressions (annotationId + serialized query bytes)
     * cannot act as a coordinator-side executor (i.e., cannot accept Arrow Record Batches
        /** Probe couldn't run — the {@code true} here is a fail-open default, not an answer. */
     * cluster setting. The setting takes precedence when set to a positive value.
     * and potentially at the data node for final executable conversion.
     * <p>The two fields fail open in opposite directions because their risks differ.
     */
 * backends fail fast if a component tries to use a capability the backend has not implemented.
        return new CanMatchResult(canMatch(shard, filterBytes), null);
     * to create handlers that apply instructions to the execution context.
    }
     * <p>Default returns true (fail-open: shard is kept). Backends that store data with
     * Returns the execution engine provider for this backend.
     * answers and skip the fold for a shard it just pruned.
     * fail-open answer for both is therefore {@code (true, null)}.
        return null;
     * @param rowIdVector Arrow BigIntVector containing global row IDs
    }
    /**
    }
     *
    default boolean canMatch(IndexShard shard, byte[] filterBytes) {
    }
     * @param canMatch true if the shard may match, false if it provably cannot
 * <p>All three getter methods throw {@link UnsupportedOperationException} by default so that
        throw new UnsupportedOperationException("getFilterDelegationHandle not implemented for [" + name() + "]");
     * @param original the exception from fragment execution
     * @param ctx the shared execution context (Reader, MapperService, IndexSettings)
     * Returns a snapshot of this backend's currently-tracked queries, keyed by {@code contextId}.
 * </ul>
        public static CanMatchResult pruned() {
     * Configure the driving backend to use the given delegation handle during execution.
     */
    default Map<Long, QueryExecutionMetrics> getTopQueriesByMemory() {
 *       at the data node to convert resolved RelNode fragments into backend-native form.</li>
     * <p>Returning {@code 1} (the default) effectively opts the backend out of HASH_SHUFFLE
     */
     * Returns the fragment convertor for this backend.
 *
    default FragmentConvertor getFragmentConvertor() {
     * @param handle         the delegation handle from the accepting backend
     * serializer during fragment conversion when a predicate is delegated to this backend.
     *
     * {@link FilterDelegationHandle#LIVE_DOCS_MATCH_ALL_ANNOTATION_ID}). Default {@code false};
     * Called by Core after obtaining the handle from the accepting backend.
     * Prepare a filter delegation handle for the given delegated expressions.
     * <p>Called by the engine when a fragment execution fails. If the backend recognizes
        DelegationThreadTracker tracker,
 * <p>A backend plugin is registered via {@link org.opensearch.plugins.ExtensiblePlugin} and
     * Converts a backend-specific exception into an appropriate OpenSearch exception type.
     *
     *
     * Implementations must signal the native execution to unwind, not close the stream cross-thread
     * @param shard the target index shard
     * MPP hash-shuffle. Consulted by the strategy advisor when no explicit partition count is
package org.opensearch.analytics.spi;
        /** Shard may match; {@code bounds} may be null if none were requested or available. */
     * <p>The map is a point-in-time view — entries can register or drain concurrently on the
 * The OpenSearch Contributors require contributions made to
/**
    /**
     *
     * <p>Implementations MAY cap the result to a top-N subset by current memory usage to bound
     * backends with a native hasDeletions signal (e.g. Lucene) override.
    default Runnable configureFilterDelegation(
     * @param contextId      the per-query identifier (task ID), threaded through every FFM upcall
 * exposes three provider interfaces, each covering a distinct concern:
        throw new UnsupportedOperationException("getCapabilityProvider not implemented for [" + name() + "]");
     * Returns the exchange sink provider for this backend, or {@code null} if the backend
     *
    }
     * <p>One method rather than two so the backend can acquire the shard reader once for both
        FilterDelegationHandle handle,
     *
     */
     * exception with correct HTTP status semantics. Otherwise returns the original unchanged.
        BackendExecutionContext backendContext
     *
    }
    record CanMatchResult(boolean canMatch, ShardSortBounds bounds) {
     * @return a cleanup action that must be called (in a finally block) after query execution
     * (createProvider, createCollector, collectDocs) route to the correct per-query binding.
import org.opensearch.analytics.backend.EngineResultStream;
     * @return a result stream containing the requested rows
    /**
    default void setDelegationThreadTracker(DelegationThreadTracker tracker) {}
     * and by the Scheduler to create the sink when the query executes.
     *
     * unlike the query path's {@code SearchExecEngine} — returns an opaque {@link EngineResultStream}.
     * {@code canMatch=false} says "don't run this shard" — wrong means lost data, so uncertainty
     * Called by Core after all instruction handlers have run, when the plan has delegation.
     */
     * backends) override this to return a real partition count — typically the number of
        return 1;
     * <p>Backends that declare {@code supportedDelegations} or participate in multi-stage
     * @param shard       the target index shard
 *       run a plan fragment and stream results.</li>
 *   <li>{@link SearchExecEngineProvider} — execution engine factory used at the data node to
        long contextId,
    /**
    /**
    default EngineResultStream fetchByRowIds(
     */
     * @return converted exception, or {@code original} if no conversion applies
    /**
        throw new UnsupportedOperationException("fetchByRowIds not implemented for [" + name() + "]");
        return true;
     * filter range.
     * @param tracker        the thread tracker for resource attribution, or {@code null}
     *
    /**
     * @param filterBytes serialized filter list (see CanMatchFilterSerializer)
import org.apache.arrow.memory.BufferAllocator;
}
        }
     */
    default DelegatedSubtreeConvertor getDelegatedSubtreeConvertor() {
    /**
    /**
     * execution MUST implement this. Validation at startup ensures consistency.
        return false;
     * @param bounds   min/max of the requested sort column, or {@code null}
     */
     *
        }
     *
    /**
    default void cancelByContext(long contextId) {}
     * @param backendContext the driving backend's execution context (from instruction handlers)
     * Evaluates whether a shard can possibly match the given serialized filter predicates.
     * Returns the instruction handler factory for this backend. Used at the coordinator
     * Outcome of a can-match probe.
     * <p>Default implementation returns an empty map so backends that do not track per-query
     */
import org.opensearch.index.shard.IndexShard;
     * <p>Used by the planner to determine which backend handles the coordinator stage,
     * Keyed by {@link ScalarFunction} — the framework dispatches to the matching
     * configured via {@code analytics.mpp.shuffle.partitions}.
        return Map.of();
     *
import java.util.List;
     * cancellation token). Called from a task cancellation listener for the fetch path, which —
        long contextId,
     */
     *
     * Whether the shard has segments with deleted documents that need filtering at query time.
    default FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
     * <p>The accepting backend initializes its internal state (e.g., DirectoryReader,
            return new CanMatchResult(true, null);
     * must yield {@code true}. {@code bounds} is only a hint, so {@code null} costs nothing. The
        }
        throw new UnsupportedOperationException("configureFilterDelegation not implemented for [" + name() + "]");
     * @param state cluster state at the time of advisor invocation; backends may inspect the
        BufferAllocator allocator,
     * @param sortColumn  column to fold min/max for, or {@code null} to skip that work
     *
     * <p>Implementations must fail open everywhere: uncertainty yields {@code canMatch=true}
     */
import org.opensearch.cluster.ClusterState;
     *        {@link org.opensearch.analytics.backend.ShardScanExecutionContext#getImportStagingAllocator()}
     *
        /** Shard provably cannot match; bounds aren't collected for a pruned shard. */
            return new CanMatchResult(false, null);
import org.apache.arrow.vector.BigIntVector;
     * fall through to BROADCAST or COORDINATOR_CENTRIC. Backends that have a streaming engine
    /**
        public static CanMatchResult unavailable() {
     * shards through the indexed deleted-doc filtering path (see
    ) {
    default boolean hasDeletedDocs(ShardScanExecutionContext ctx) {
     */
     *
import java.util.Collections;
 *       planner to determine which backends can handle each operator, predicate, and expression.</li>
    }
            return new CanMatchResult(true, bounds);
     */
     *
    /** Unique backend name (e.g., "datafusion", "lucene"). */
     * into a single serialized expression, or {@code null} if the backend cannot combine.
     * Used by the planner to serialize resolved plan fragments into backend-native form,
    default CanMatchResult canMatchWithBounds(IndexShard shard, byte[] filterBytes, String sortColumn) {
 */
     *
     */
        BigIntVector rowIdVector,
public interface AnalyticsSearchBackendPlugin {
     * @param filterBytes serialized filter list (see CanMatchFilterSerializer)
     * backend side. Implementations MUST return a non-null map (empty when nothing is tracked)
     * will call into during execution.
     *
     * Used by the coordinator-side planner ({@code CapabilityRegistry}) to determine
 * SPI extension point for backend query engine plugins.
 * this file be licensed under the Apache-2.0 license or a
     * (that races the in-flight pull). No-op for an unknown {@code contextId}; default no-op.
     * need a complete enumeration should not rely on this method.
import java.util.Map;
    default ExchangeSinkProvider getExchangeSinkProvider() {
 *   <li>{@link BackendCapabilityProvider} — capability declarations used by the coordinator-side
     * and SHOULD make it unmodifiable so callers cannot mutate backend state.
        throw new UnsupportedOperationException("getInstructionHandlerFactory not implemented for [" + name() + "]");
     * which backends can handle each operator, predicate, aggregate call, and expression.
    }
     * @return desired partition count (≥ 1); {@code 1} disables shuffle for this backend.
     * the FFI cost (the DataFusion backend caps at the heaviest 10 live queries). Callers that
import org.opensearch.analytics.backend.ShardScanExecutionContext;
     * <p>Default implementation performs no conversion.
     * Used at the data node to create a {@link SearchExecEngineProvider} bound to an execution context.
     * <p>The driving backend registers the handle so that FFM upcalls from Rust
        String[] columns,
     * and/or null bounds, never a wrong prune or a guessed range.
     * Called at the data node before execution so instruction handlers can route deletion-bearing
     */
    }
     * @return true if the shard can possibly match, false if provably cannot
    }
    /**
     * to create instruction nodes (backend attaches custom config) and at the data node
    }
     * the error (e.g., memory limit exceeded, admission rejected), it returns a converted
     * @param reader the index reader for the target shard
    /**
    default Exception convertException(Exception original) {
        // Backends without statistics have no bounds to give.
        return Collections.emptyMap();
 *
    default SearchExecEngineProvider getSearchExecEngineProvider() {
     * capable of consuming hash-partitioned input (DataFusion today; future Velox-style
    }
     * because the split rule refuses to fire when partitionCount ≤ 1; joins on this backend
     * metrics don't have to opt in.
     * @param allocator Arrow buffer allocator for result import
    default int defaultShuffleParallelism(ClusterState state) {
 * SPDX-License-Identifier: Apache-2.0
     *
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;
    ) {
 *   <li>{@link FragmentConvertor} — plan serialization used by the planner and potentially
     */
     * from data nodes and run computation over them).
        BufferAllocator importStagingAllocator
     * @param importStagingAllocator node-scoped allocator to stage Arrow C Data imports on; see
     * Called after {@link #configureFilterDelegation}. Pass {@code null} to clear.
    /**
     * <p>This is the engine-level default; an operator can still pin a specific N via the
     * Returns the default number of hash-shuffle output partitions this backend recommends
     *              routing table to size partition count to the relevant node set.
     * Evaluates the prune predicate and, for surviving shards, folds the sort column's min/max.
    /**
        return original;
    /**
        throw new UnsupportedOperationException("getSearchExecEngineProvider not implemented for [" + name() + "]");
     * @return a handle the driving backend calls into via FFM upcalls
 */
 *
 * compatible open source license.
     */
     * rich metadata statistics should override to check row-group min/max against the
    String name();
     *
     */
    }
     *
 *
    }
     * QueryShardContext, compiled Queries) and returns a handle that the driving backend
     * Per-function serializers for delegated predicates this backend can accept.
     * for the current cluster topology, or {@code 1} if the backend does not participate in
 * @opensearch.internal
     * Used by the can-match pre-filter phase to prune shards before fragment dispatch.
/*
    }
    /**
