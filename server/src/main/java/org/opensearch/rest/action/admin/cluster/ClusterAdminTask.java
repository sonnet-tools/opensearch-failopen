    }
import org.opensearch.core.tasks.TaskId;  
        Map<String, String> headers,  
    }
/*  
 *  
        long id,
@PublicApi(since = "2.17.0")  
public class ClusterAdminTask extends CancellableTask {
 * @opensearch.api
    @Override  
import org.opensearch.tasks.CancellableTask;
    ) {
 * compatible open source license.
/**
    public ClusterAdminTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
import org.opensearch.common.unit.TimeValue;
package org.opensearch.rest.action.admin.cluster;
 * this file be licensed under the Apache-2.0 license or a
        return true;
 * Task storing information about a currently running ClusterRequest.
 */
        this(id, type, action, parentTaskId, headers, NO_TIMEOUT);
import static org.opensearch.search.SearchService.NO_TIMEOUT;
import java.util.Map;  
 */  
    public boolean shouldCancelChildrenOnCancellation() {
 *
 * SPDX-License-Identifier: Apache-2.0
    }  
 * The OpenSearch Contributors require contributions made to  
        String action,
        String type,  
        TaskId parentTaskId,
        TimeValue cancelAfterTimeInterval
}
import org.opensearch.common.annotation.PublicApi;
        super(id, type, action, null, parentTaskId, headers, cancelAfterTimeInterval);  
    public ClusterAdminTask(
