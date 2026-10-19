    public String getName() {  
 * @opensearch.api
 */  
    @Override
/**
 * Rest action to delete a stored completed task result.  
import org.opensearch.rest.action.RestToXContentListener;
/*  
        return channel -> client.admin().cluster().deleteTask(deleteTaskRequest, new RestToXContentListener<>(channel));
package org.opensearch.rest.action.admin.cluster;
    @Override
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskRequest;
        return singletonList(new Route(DELETE, "/_tasks/{task_id}"));
import org.opensearch.core.tasks.TaskId;
import org.opensearch.rest.RestRequest;
        return "delete_task_action";
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
    public List<Route> routes() {
import org.opensearch.rest.BaseRestHandler;  
 * compatible open source license.
    }
 *
}
 */  
public class RestDeleteTaskAction extends BaseRestHandler {
import static org.opensearch.rest.RestRequest.Method.DELETE;  
import static java.util.Collections.singletonList;
 * SPDX-License-Identifier: Apache-2.0
        deleteTaskRequest.setTaskId(new TaskId(request.param("task_id")));
import org.opensearch.transport.client.node.NodeClient;  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 *
    }  
import java.util.List;  
    }  
        DeleteTaskRequest deleteTaskRequest = new DeleteTaskRequest();  
    @Override  
 * The OpenSearch Contributors require contributions made to  
