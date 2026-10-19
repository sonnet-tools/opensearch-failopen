 * <b>Core ships exactly one implementation:</b> {@link DefaultPrimaryOperationPolicy}, which is  
 * <p>  
    DeletionStrategy planDelete(OperationStrategyPlanner<Engine.Delete, DeletionStrategy> planner, Engine.Delete delete) throws IOException;
 * A policy may plan an operation with non-primary rather than primary semantics, which is how a
     * Plans an index operation that arrived on the primary.
     * Planning with non-primary semantics carries the
     * <p>  
     * {@link Engine#fillSeqNoGaps(long)} becomes a no-op, because recording promotion no-ops could
     * {@code max_seq_no_of_updates_or_deletes} precondition described on this interface.
     * @return the plan the engine should execute
     * space, which carries a second consequence beyond sequence-number assignment:
 * The OpenSearch Contributors require contributions made to  
     * Returning {@code true} declares that this shard is not the authority for its sequence-number  
     * @return the plan the engine should execute  
 * this file be licensed under the Apache-2.0 license or a
     * Planning with non-primary semantics carries the
     * Only an operation that reaches the engine with its sequence number already set can satisfy
 * SPDX-License-Identifier: Apache-2.0
 * {@link Engine#advanceMaxSeqNoOfUpdatesOrDeletes(long)} (normally through  
 * Policy describing how a writable primary shard sources sequence numbers and plans operations.  
package org.opensearch.index.engine;
 * shard whose sequence numbers are assigned upstream avoids re-evaluating a compare-and-swap that
     * {@code max_seq_no_of_updates_or_deletes} precondition described on this interface.  
     * assign the sequence number locally.
 * <p>
     * @param planner the engine's delete-operation planner
    /**
     * Plans a delete operation that arrived on the primary.  
     * <p>
    /**
}
     *  
     * <p>
 * document for the same {@code _id} instead of replacing the first.
public interface PrimaryOperationPolicy {  
 * <p>
 * compatible open source license.
     * {@link Engine.Operation.Origin#PRIMARY}.
     * {@link Engine.Operation.Origin#PRIMARY}.  
 * update to an existing document can be planned as an append-only insert, writing a second Lucene  
@ExperimentalApi
 * Implementations are consulted on the indexing hot path. They must be stateless and thread-safe.
 */
     */  
     * @throws IOException if planning performs I/O that fails
 *
     * @throws IOException if planning performs I/O that fails
     * shard that generates its own sequence numbers must fill gaps, since that is what lets its
/*  
     * @return {@code true} if pre-assigned sequence numbers are expected on the primary  
     * @param delete the operation to plan  
 *
 * applying each operation, exactly as the replica path does. If that marker is left behind, an
    IndexingStrategy planIndex(OperationStrategyPlanner<Engine.Index, IndexingStrategy> planner, Engine.Index index) throws IOException;  
/**
import java.io.IOException;  
     *
 * @opensearch.experimental  
     * The engine handles non-primary origins itself; this method is consulted only for
    /**
     */
     * The engine handles non-primary origins itself; this method is consulted only for
 * on the operation's behalf: whatever replays operations onto the primary must call
 * the upstream authority has already resolved. Non-primary planning reads  
     * collide with sequence numbers the upstream authority has not yet replicated to this shard. A  
 * core's own behavior and the fallback when no plugin supplies a policy.
    boolean acceptsPreAssignedSeqNos();
     * <p>  
import org.opensearch.common.annotation.ExperimentalApi;
     * is the entry point that preserves one; the primary entry points used for client writes always  
 */  
     * @param index the operation to plan
     * this. {@code IndexShard#applyTranslogOperation} with {@link Engine.Operation.Origin#PRIMARY}
     * Whether a primary shard accepts sequence numbers pre-assigned by an upstream authority  
     */
     * local checkpoint advance past an operation that never completed.
     *
 * {@link Engine#getMaxSeqNoOfUpdatesOrDeletes()}, and neither the policy nor the engine advances it
     * @param planner the engine's index-operation planner
     * <p>  
 * {@code IndexShard#advanceMaxSeqNoOfUpdatesOrDeletes}) with the upstream authority's value before
     * <p>
     * instead of generating them locally.
