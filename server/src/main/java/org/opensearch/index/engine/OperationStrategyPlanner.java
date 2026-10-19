/**
public interface OperationStrategyPlanner<T extends Engine.Operation, V extends OperationStrategy> {
     *
     */  
 *  
     * @return the strategy for executing this operation on the primary
}
import org.opensearch.common.annotation.ExperimentalApi;
        return true;
 *
     * @param operation the operation to plan (index or delete)  
 * differently depending on whether the shard is acting as a primary or replica.
@ExperimentalApi  
     * @throws IOException if an I/O error occurs during planning
 * This interface defines how operations (indexing, deletion) should be processed
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 */  
     *
 * this file be licensed under the Apache-2.0 license or a
     * @throws IOException if an I/O error occurs during planning
    /**  
package org.opensearch.index.engine;
     * @return the strategy for executing this operation on the replica
    V planOperationAsNonPrimary(T operation) throws IOException;
 * Plans the execution strategy for engine operations based on the shard's role.  
     * Plans the execution strategy for an operation on a primary shard.
 */
    V planOperationAsPrimary(T operation) throws IOException;
/*  
        assert operation.origin() != Engine.Operation.Origin.PRIMARY : "planing as primary but got " + operation.origin();
     */  
    /**  
    default boolean assertNonPrimaryOrigin(final T operation) {  
 * @opensearch.experimental
     * @param operation the operation to plan (index or delete)  
import java.io.IOException;  
     * Plans the execution strategy for an operation on a non-primary (replica) shard.
    }  
