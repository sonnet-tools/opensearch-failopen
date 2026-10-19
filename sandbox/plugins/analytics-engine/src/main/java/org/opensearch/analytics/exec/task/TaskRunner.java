    void run(T task, ActionListener<Void> listener);  
 */  
        throw new IllegalStateException("TaskRunner.NONE invoked for task " + task.id());
 * dispatch is statically typed end-to-end.
     * Run {@code task}. Invoke exactly one of {@link ActionListener#onResponse} (signalling  
package org.opensearch.analytics.exec.task;
 * compatible open source license.
 * @opensearch.internal
    /** Sentinel for stages with empty {@code tasks()}; throws if invoked. */
 *  
 * The OpenSearch Contributors require contributions made to  
public interface TaskRunner<T extends StageTask> {  
/**
 * variants in the future. A stage owns both its task variant and its runner, so
import org.opensearch.core.action.ActionListener;
    TaskRunner<StageTask> NONE = (task, listener) -> {  
     */
    };
/*  
 */
 * Per-stage transport mechanism for a {@link StageTask} variant. Arrow Flight stream
}  
 * this file be licensed under the Apache-2.0 license or a
 * for shard fragments, virtual-thread executor for local work, shuffle / broadcast  
 *
import org.opensearch.analytics.exec.stage.StageTask;
     * task completion — payload is unused) or {@link ActionListener#onFailure}.
 * SPDX-License-Identifier: Apache-2.0
    /**
