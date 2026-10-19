    public DeletionStrategy planDelete(OperationStrategyPlanner<Engine.Delete, DeletionStrategy> planner, Engine.Delete delete)  
/**  
 */
        throws IOException {
 * The OpenSearch Contributors require contributions made to  
    }  
    }
public final class DefaultPrimaryOperationPolicy implements PrimaryOperationPolicy {
import java.io.IOException;
}  
 * <p>  
    @Override  
 *
    public static final DefaultPrimaryOperationPolicy INSTANCE = new DefaultPrimaryOperationPolicy();
package org.opensearch.index.engine;
    public String toString() {  
        return planner.planOperationAsPrimary(delete);
        return "default";
 * compatible open source license.
    private DefaultPrimaryOperationPolicy() {}
    }  
 *  
 * The standard primary indexing policy: the primary generates its own sequence numbers, plans
 * This is the provider used when no plugin supplies one, and it reproduces the behavior
    @Override
    /** Shared stateless instance. */
    @Override
    @Override
 * {@link InternalEngine} had before {@link PrimaryOperationPolicy} existed.
 */  
/*  
 * operations with full primary semantics, and fills sequence-number gaps on promotion.
    public IndexingStrategy planIndex(OperationStrategyPlanner<Engine.Index, IndexingStrategy> planner, Engine.Index index)  
        throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    }  
        return false;
    public boolean acceptsPreAssignedSeqNos() {
        return planner.planOperationAsPrimary(index);
 * SPDX-License-Identifier: Apache-2.0
