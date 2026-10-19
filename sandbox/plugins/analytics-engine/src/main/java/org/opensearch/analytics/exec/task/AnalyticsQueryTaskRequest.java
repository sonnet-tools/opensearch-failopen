 * @opensearch.internal  
    @Override  
 * The OpenSearch Contributors require contributions made to  
    @Override
 * with {@link TaskManager}. Mirrors how {@code SearchRequest.createTask()} returns  
public final class AnalyticsQueryTaskRequest implements TaskAwareRequest {
    }
import org.opensearch.tasks.Task;
        this.queryId = queryId;  
 * compatible open source license.
    }  
import java.util.Map;
    public void setParentTask(TaskId taskId) {
    }
 */  
import org.opensearch.core.tasks.TaskId;  
    public TaskId getParentTask() {
 */
    private final String queryId;
 *
import org.opensearch.tasks.TaskAwareRequest;
        return new AnalyticsQueryTask(id, type, action, queryId, parentTaskId, headers, cancelAfterTimeInterval);
    private final TimeValue cancelAfterTimeInterval;
/**
package org.opensearch.analytics.exec.task;
    public AnalyticsQueryTaskRequest(String queryId, @Nullable TimeValue cancelAfterTimeInterval) {
 *
 * SPDX-License-Identifier: Apache-2.0
 * Lightweight {@link TaskAwareRequest} for registering an {@link AnalyticsQueryTask}
import org.opensearch.tasks.TaskManager;  
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
    }
/*  
import org.opensearch.common.Nullable;
    private TaskId parentTaskId = TaskId.EMPTY_TASK_ID;  
        this.cancelAfterTimeInterval = cancelAfterTimeInterval;
        return parentTaskId;
 * a {@code SearchTask}.
}  
 * this file be licensed under the Apache-2.0 license or a
        this.parentTaskId = taskId;  
import org.opensearch.common.unit.TimeValue;
    @Override
