public final class ShardStageTask extends StageTask {  
    public ShardStageTask(StageTaskId id, ExecutionTarget target) {
 * @opensearch.internal
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        this.target = target;  
/*  
/**
 * this file be licensed under the Apache-2.0 license or a
 */
 *  
package org.opensearch.analytics.exec.stage.shard;
    }
import org.opensearch.analytics.exec.stage.StageTask;
import org.opensearch.analytics.exec.stage.StageTaskId;
 *
 * fragment payload the data node needs to set up its input source.
    public ExecutionTarget target() {  
    private final ExecutionTarget target;
 * The {@link ExecutionTarget} carries the routing key and the per-partition
 */  
}  
        super(id);
 * {@link StageTask} variant dispatched to a remote data node via Arrow Flight.  
        return target;
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.analytics.planner.dag.ExecutionTarget;  
