     * @param importStagingAllocator node-scoped allocator to stage Arrow C Data imports on; see
     *
import java.util.List;
    }  
     * @param allocator Arrow buffer allocator for result import  
     * Returns the capability provider for this backend.
import java.util.Map;
import org.opensearch.analytics.backend.ShardScanExecutionContext;
        throw new UnsupportedOperationException("getCapabilityProvider not implemented for [" + name() + "]");
    /** Unique backend name (e.g., "datafusion", "lucene"). */
     */
     * <p>Implementations must fail open everywhere: uncertainty yields {@code canMatch=true}
     *
     * @param contextId      the per-query identifier (task ID), threaded through every FFM upcall
        FilterDelegationHandle handle,
     *  
            return new CanMatchResult(true, null);
        throw new UnsupportedOperationException("getFragmentConvertor not implemented for [" + name() + "]");  
     */  
    }
    /**
     * @return true if the shard can possibly match, false if provably cannot  
    default DelegatedSubtreeConvertor getDelegatedSubtreeConvertor() {
    ) {
     *
     */
     * exception with correct HTTP status semantics. Otherwise returns the original unchanged.  
     * @param reader the index reader for the target shard  
     * Implementations must signal the native execution to unwind, not close the stream cross-thread
     * capable of consuming hash-partitioned input (DataFusion today; future Velox-style
     * Used by the can-match pre-filter phase to prune shards before fragment dispatch.
     * @param original the exception from fragment execution
        Reader reader,  
    /**
     *
     */
        return false;
        /** Shard may match; {@code bounds} may be null if none were requested or available. */
     * Evaluates whether a shard can possibly match the given serialized filter predicates.  
package org.opensearch.analytics.spi;
        long contextId,  
     *
     * @param filterBytes serialized filter list (see CanMatchFilterSerializer)
     * will call into during execution.  
 * <ul>  
     * @return desired partition count (≥ 1); {@code 1} disables shuffle for this backend.
     * backends with a native hasDeletions signal (e.g. Lucene) override.
     * rich metadata statistics should override to check row-group min/max against the
    }
     * @param handle         the delegation handle from the accepting backend  
     * Returns the default number of hash-shuffle output partitions this backend recommends
     * fail-open answer for both is therefore {@code (true, null)}.  
    /**  
 * </ul>
     * <p>Default returns true (fail-open: shard is kept). Backends that store data with  
 *   <li>{@link BackendCapabilityProvider} — capability declarations used by the coordinator-side
     *
    /**
     * data nodes that hold any shard of the joined indices.  
     *
 * <p>A backend plugin is registered via {@link org.opensearch.plugins.ExtensiblePlugin} and
     * <p>The accepting backend initializes its internal state (e.g., DirectoryReader,
    }
     */  
     */
 */
     * @return a result stream containing the requested rows  
    default FragmentConvertor getFragmentConvertor() {
     * Outcome of a can-match probe.
    default SearchExecEngineProvider getSearchExecEngineProvider() {
     * <p>The map is a point-in-time view — entries can register or drain concurrently on the
    }  
        long contextId,
     * @param backendContext the driving backend's execution context (from instruction handlers)
     * Evaluates the prune predicate and, for surviving shards, folds the sort column's min/max.  
    /**
     *
        return null;
        return 1;
     * Returns the exchange sink provider for this backend, or {@code null} if the backend
import java.util.Collections;  
 *
    /**  
     *
     * @param columns column names to read
import org.apache.arrow.memory.BufferAllocator;
     *
        return Collections.emptyMap();
    /**
     * <p>Default implementation returns an empty map so backends that do not track per-query
        return null;  
     * Used by the planner to serialize resolved plan fragments into backend-native form,
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;  
     * @param state cluster state at the time of advisor invocation; backends may inspect the
        throw new UnsupportedOperationException("fetchByRowIds not implemented for [" + name() + "]");
}  
    }
    /**
        public static CanMatchResult matched(ShardSortBounds bounds) {
    }  
    /**
     * and SHOULD make it unmodifiable so callers cannot mutate backend state.
 * this file be licensed under the Apache-2.0 license or a
    }
     */
    /**  
     */
    default Runnable configureFilterDelegation(
    /**
    }
     * answers and skip the fold for a shard it just pruned.  
     * filter range.
     * <p>Implementations MAY cap the result to a top-N subset by current memory usage to bound  
    }  
     * <p>This is the engine-level default; an operator can still pin a specific N via the
     * @param shard       the target index shard
     * Called after {@link #configureFilterDelegation}. Pass {@code null} to clear.  
 *
     *  
    default FilterDelegationHandle getFilterDelegationHandle(List<DelegatedExpression> expressions, CommonExecutionContext ctx) {  
        /** Probe couldn't run — the {@code true} here is a fail-open default, not an answer. */
     * cluster setting. The setting takes precedence when set to a positive value.  
     */
        }  
    /**  
        /** Shard provably cannot match; bounds aren't collected for a pruned shard. */  
import org.opensearch.index.shard.IndexShard;
    default EngineResultStream fetchByRowIds(
    default boolean canMatch(IndexShard shard, byte[] filterBytes) {
import org.apache.arrow.vector.BigIntVector;
 * @opensearch.internal  
     * from data nodes and run computation over them).  
     * Keyed by {@link ScalarFunction} — the framework dispatches to the matching
        BackendExecutionContext backendContext  
    record CanMatchResult(boolean canMatch, ShardSortBounds bounds) {
        }
public interface AnalyticsSearchBackendPlugin {
     * Called at the data node before execution so instruction handlers can route deletion-bearing
    /**
     * @param bounds   min/max of the requested sort column, or {@code null}  
 *       run a plan fragment and stream results.</li>
     * for the current cluster topology, or {@code 1} if the backend does not participate in  
    /**
     * Returns the execution engine provider for this backend.
     * MPP hash-shuffle. Consulted by the strategy advisor when no explicit partition count is
     *
        String[] columns,
     *
 *       planner to determine which backends can handle each operator, predicate, and expression.</li>
        BigIntVector rowIdVector,
     *  
/*  
     * Configure the driving backend to use the given delegation handle during execution.
     * which backends can handle each operator, predicate, aggregate call, and expression.
     */
import org.opensearch.cluster.ClusterState;
     * Returns the backend's subtree convertor for combining multiple delegated predicates  
 *   <li>{@link SearchExecEngineProvider} — execution engine factory used at the data node to  
            return new CanMatchResult(false, null);
     * Returns the instruction handler factory for this backend. Used at the coordinator
     *              routing table to size partition count to the relevant node set.  
     * to create instruction nodes (backend attaches custom config) and at the data node
     * configured via {@code analytics.mpp.shuffle.partitions}.
     * Called by Core after all instruction handlers have run, when the plan has delegation.
     * unlike the query path's {@code SearchExecEngine} — returns an opaque {@link EngineResultStream}.
     * Install a thread tracker for attribution of delegation callbacks executing on foreign threads.
        public static CanMatchResult pruned() {
     * <p>Returning {@code 1} (the default) effectively opts the backend out of HASH_SHUFFLE
     * QueryShardContext, compiled Queries) and returns a handle that the driving backend
     * {@code canMatch=false} says "don't run this shard" — wrong means lost data, so uncertainty
     */  
/**
     * must yield {@code true}. {@code bounds} is only a hint, so {@code null} costs nothing. The
     * because the split rule refuses to fire when partitionCount ≤ 1; joins on this backend
     */
 * backends fail fast if a component tries to use a capability the backend has not implemented.
     */
        return Map.of();
 * <p>All three getter methods throw {@link UnsupportedOperationException} by default so that  
        return new CanMatchResult(canMatch(shard, filterBytes), null);
     * Prepare a filter delegation handle for the given delegated expressions.
    /**
        BufferAllocator allocator,  
     * shards through the indexed deleted-doc filtering path (see
     * cancellation token). Called from a task cancellation listener for the fetch path, which —  
 * exposes three provider interfaces, each covering a distinct concern:
            return new CanMatchResult(true, bounds);  
        throw new UnsupportedOperationException("getInstructionHandlerFactory not implemented for [" + name() + "]");  
     * @param expressions the delegated expressions (annotationId + serialized query bytes)
     * @param ctx the shared execution context (Reader, MapperService, IndexSettings)  
     * Row IDs are passed as a BigIntVector for zero-copy transfer to native.
    }
     * Used at the data node to create a {@link SearchExecEngineProvider} bound to an execution context.  
     *  
     * Called by Core after obtaining the handle from the accepting backend.  
    default boolean hasDeletedDocs(ShardScanExecutionContext ctx) {  
     * serializer during fragment conversion when a predicate is delegated to this backend.
    }
     * <p>The driving backend registers the handle so that FFM upcalls from Rust
     * @param filterBytes serialized filter list (see CanMatchFilterSerializer)  
     * the FFI cost (the DataFusion backend caps at the heaviest 10 live queries). Callers that
 * compatible open source license.
     */
    String name();
        throw new UnsupportedOperationException("getFilterDelegationHandle not implemented for [" + name() + "]");
     * need a complete enumeration should not rely on this method.
    default void setDelegationThreadTracker(DelegationThreadTracker tracker) {}
    }  
        DelegationThreadTracker tracker,
     * Whether the shard has segments with deleted documents that need filtering at query time.  
    /**
        }
    /**
     * and by the Scheduler to create the sink when the query executes.  
    }  
     * <p>Called by the engine when a fragment execution fails. If the backend recognizes
     * fall through to BROADCAST or COORDINATOR_CENTRIC. Backends that have a streaming engine  
     * Converts a backend-specific exception into an appropriate OpenSearch exception type.
     * into a single serialized expression, or {@code null} if the backend cannot combine.
     */
     * and/or null bounds, never a wrong prune or a guessed range.  
        throw new UnsupportedOperationException("getSearchExecEngineProvider not implemented for [" + name() + "]");  
     * <p>Backends that declare {@code supportedDelegations} or participate in multi-stage
     * {@link FilterDelegationHandle#LIVE_DOCS_MATCH_ALL_ANNOTATION_ID}). Default {@code false};  
    }
     * execution MUST implement this. Validation at startup ensures consistency.  
     * <p>One method rather than two so the backend can acquire the shard reader once for both
     * (that races the in-flight pull). No-op for an unknown {@code contextId}; default no-op.  
    /**
     * <p>Used by the planner to determine which backend handles the coordinator stage,
     * Returns a snapshot of this backend's currently-tracked queries, keyed by {@code contextId}.  
     *
     * metrics don't have to opt in.
     * @return a handle the driving backend calls into via FFM upcalls
     */
import org.opensearch.analytics.backend.EngineResultStream;  
        return true;  
     * and potentially at the data node for final executable conversion.  
    default BackendCapabilityProvider getCapabilityProvider() {  
     * the error (e.g., memory limit exceeded, admission rejected), it returns a converted
     * to create handlers that apply instructions to the execution context.  
    }
 * SPI extension point for backend query engine plugins.
    /**  
     * <p>Default implementation performs no conversion.
     */
     * <p>The two fields fail open in opposite directions because their risks differ.  
     * (createProvider, createCollector, collectDocs) route to the correct per-query binding.  
     * Returns the fragment convertor for this backend.
     */  
 * The OpenSearch Contributors require contributions made to  
    default Exception convertException(Exception original) {
     *  
 *   <li>{@link FragmentConvertor} — plan serialization used by the planner and potentially
     * @param rowIdVector Arrow BigIntVector containing global row IDs
     */
    default int defaultShuffleParallelism(ClusterState state) {  
    default ExchangeSinkProvider getExchangeSinkProvider() {
     *
     * @return a cleanup action that must be called (in a finally block) after query execution  
 *  
        throw new UnsupportedOperationException("configureFilterDelegation not implemented for [" + name() + "]");
        public static CanMatchResult unavailable() {  
     * backend side. Implementations MUST return a non-null map (empty when nothing is tracked)  
     *        {@link org.opensearch.analytics.backend.ShardScanExecutionContext#getImportStagingAllocator()}
    default Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
    default FragmentInstructionHandlerFactory getInstructionHandlerFactory() {
 */  
 *       at the data node to convert resolved RelNode fragments into backend-native form.</li>  
     *
     * QTF fetch phase: reads specific rows by global row ID.  
 *
        BufferAllocator importStagingAllocator
     * Cooperatively cancels in-flight backend work for {@code contextId} (e.g. fire the per-context
     * @param shard the target index shard
     * @param sortColumn  column to fold min/max for, or {@code null} to skip that work
     * @param tracker        the thread tracker for resource attribution, or {@code null}
    default CanMatchResult canMatchWithBounds(IndexShard shard, byte[] filterBytes, String sortColumn) {  
    }  
        return original;
 * SPDX-License-Identifier: Apache-2.0
     *  
     * @return converted exception, or {@code original} if no conversion applies
    default Map<Long, QueryExecutionMetrics> getTopQueriesByMemory() {
     * Used by the coordinator-side planner ({@code CapabilityRegistry}) to determine  
     *
    ) {  
     * backends) override this to return a real partition count — typically the number of
     * Per-function serializers for delegated predicates this backend can accept.  
        // Backends without statistics have no bounds to give.
     *
     * cannot act as a coordinator-side executor (i.e., cannot accept Arrow Record Batches
    default void cancelByContext(long contextId) {}
     * @param canMatch true if the shard may match, false if it provably cannot
     * When {@code null}, the framework falls back to one {@link DelegatedExpression} per leaf.
