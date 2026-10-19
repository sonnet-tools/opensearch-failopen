import org.opensearch.analytics.planner.dag.WorkerExecutionTarget;  
    }
        this.target = target;  
import org.opensearch.analytics.exec.stage.StageTask;
import org.opensearch.analytics.exec.stage.StageTaskId;
package org.opensearch.analytics.exec.stage.worker;
        return target;
    private final WorkerExecutionTarget target;
 * SPDX-License-Identifier: Apache-2.0
 */  
 * this file be licensed under the Apache-2.0 license or a
    }
 * compatible open source license.
 * @opensearch.internal
 * {@link WorkerExecutionTarget} carrying the destination node + partition index; the runner
/*  
 *
    public WorkerExecutionTarget target() {  
    public WorkerStageTask(StageTaskId id, WorkerExecutionTarget target) {
 * The OpenSearch Contributors require contributions made to  
 */
/**
 * builds the per-task fragment request from the target's partition.
}  
public final class WorkerStageTask extends StageTask {  
        super(id);
 *  
 * {@link StageTask} variant for hash-shuffle workers. Each task is bound to a single  
