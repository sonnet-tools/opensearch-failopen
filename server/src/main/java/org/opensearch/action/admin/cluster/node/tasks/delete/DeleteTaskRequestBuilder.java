package org.opensearch.action.admin.cluster.node.tasks.delete;
import org.opensearch.action.ActionRequestBuilder;
 * The OpenSearch Contributors require contributions made to  
        return this;
/*  
    }
        request.setTaskId(taskId);
import org.opensearch.common.annotation.PublicApi;  
     */
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    public final DeleteTaskRequestBuilder setTaskId(TaskId taskId) {  
 * this file be licensed under the Apache-2.0 license or a
 * Builder for the request to delete a stored completed task result.
        super(client, action, new DeleteTaskRequest());  
    /**  
 *  
 */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.client.OpenSearchClient;
 * @opensearch.api
     * Set the TaskId to delete. Required.
@PublicApi(since = "3.8.0")  
import org.opensearch.core.tasks.TaskId;
    }  
/**
}
 */  
 * compatible open source license.
    public DeleteTaskRequestBuilder(OpenSearchClient client, DeleteTaskAction action) {
public class DeleteTaskRequestBuilder extends ActionRequestBuilder<DeleteTaskRequest, AcknowledgedResponse> {
 *
