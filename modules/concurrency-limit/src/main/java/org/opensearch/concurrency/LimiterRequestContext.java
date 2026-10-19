    private final String action;
import org.opensearch.tasks.Task;
/**
    /** Returns the action request. */
     */
        this.request = request;  
        return task;
 * partition resolvers can inspect the request (e.g. read a header) to determine which  
    }
 * The OpenSearch Contributors require contributions made to  
 *
 * this file be licensed under the Apache-2.0 license or a
/*  
        return request;  
     * @param request the action request
package org.opensearch.concurrency;
    public ActionRequest request() {
public final class LimiterRequestContext {  
 * Carries per-request context through the concurrency limiter's acquire path so that
 */
    public String action() {  
    /** Returns the transport action name. */
 * SPDX-License-Identifier: Apache-2.0
    /** Returns the task associated with this request. */  
     * @param task the current task
    private final ActionRequest request;  
        return action;
 */  
     * @param action the transport action name  
 * compatible open source license.
import org.opensearch.action.ActionRequest;
    }
     *
    private final Task task;
}
     * Creates a new context for the given request.  
    }
        this.action = action;
    }  
    public LimiterRequestContext(Task task, String action, ActionRequest request) {  
    /**
    public Task task() {
        this.task = task;
 * partition the request belongs to.
