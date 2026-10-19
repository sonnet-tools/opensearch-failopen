        messageFields.put("start_time_millis", task.getStartTime());  
 */  
            .append(task.getDescription())
            .append("], ")  
        return messageFields;
    private static Map<String, Object> prepareMap(SearchShardTask task) {  
 * this file be licensed under the Apache-2.0 license or a
        messageFields.put("parentTaskId", task.getParentTaskId());
 * compatible open source license.
            .append(task.getId())
        messageFields.put("type", task.getType());  
 */  
        sb.append("taskId:[")
 *
package org.opensearch.tasks.consumer;
    }
/**
    private static String message(SearchShardTask task) {
import java.util.HashMap;
            .append("description:[")
 *
/*  
import org.opensearch.common.logging.OpenSearchLogMessage;
        return sb.toString();
            .append("]");  
            .append("metadata:[")
        messageFields.put("description", task.getDescription());
    }
            .append(task.getAction())
        messageFields.put("metadata", task.getTaskMetadata());  
            .append(task.getType())
        super(prepareMap(task), message(task));  
    }
 * Search shard task information that will be extracted from Task and converted into
            .append("type:[")
        StringBuilder sb = new StringBuilder();  
            .append(task.getStartTime())
        messageFields.put("taskId", task.getId());
            .append("], ")  
    // Message will be used in plaintext logs
            .append("], ")  
    SearchShardTaskDetailsLogMessage(SearchShardTask task) {
            .append(task.getResourceStats())
}  
public final class SearchShardTaskDetailsLogMessage extends OpenSearchLogMessage {
 * SPDX-License-Identifier: Apache-2.0
            .append("], ")  
        messageFields.put("resource_stats", task.getResourceStats());
            .append("resource_stats:[")
            .append("], ")  
 * The OpenSearch Contributors require contributions made to  
            .append("start_time_millis:[")
        Map<String, Object> messageFields = new HashMap<>();
            .append("action:[")
import java.util.Map;
            .append(task.getTaskMetadata())
            .append("], ")  
import org.opensearch.action.search.SearchShardTask;
 * format that will be logged  
 * @opensearch.internal
        messageFields.put("action", task.getAction());
