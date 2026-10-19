 */  
        taskResourceTrackingService.refreshResourceStats(context.getTask());
    @Override  
 * upon request completion.  
    public SearchTaskRequestOperationsListener(TaskResourceTrackingService taskResourceTrackingService) {  
    public void onRequestFailure(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
/**  
 */
    public void onRequestEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
 * SPDX-License-Identifier: Apache-2.0
    private final TaskResourceTrackingService taskResourceTrackingService;
public final class SearchTaskRequestOperationsListener extends SearchRequestOperationsListener {  
 *
import org.opensearch.tasks.TaskResourceTrackingService;
    @Override
        this.taskResourceTrackingService = taskResourceTrackingService;
    }
 * The OpenSearch Contributors require contributions made to  
        // Remove the shard level resource usages from thread context
    }
 * SearchTaskRequestOperationsListener subscriber for operations on search tasks resource usages.
/*  
 * Listener ensures to refreshResourceStats on request end capturing the search task resource usage
}
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.search;
        // Refresh the coordinator node level resource usages  
        taskResourceTrackingService.removeTaskResourceUsage();
        taskResourceTrackingService.removeTaskResourceUsage();  
 *
 * compatible open source license.
    }  
