             */
        }
            return channel -> client.admin().indices().open(openIndexRequest, new RestToXContentListener<>(channel));
        openIndexRequest.indicesOptions(IndicesOptions.fromRequest(request, openIndexRequest.indicesOptions()));
 *
import static java.util.Collections.unmodifiableList;  
import java.io.IOException;
 * this work for additional information regarding copyright
 * compatible open source license.
            openIndexRequest.waitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));
        return unmodifiableList(asList(new Route(POST, "/_open"), new Route(POST, "/{index}/_open")));  
                client.executeLocally(OpenIndexAction.INSTANCE, openIndexRequest, LoggingTaskListener.instance())
import org.opensearch.tasks.LoggingTaskListener;
import static java.util.Arrays.asList;
        if (request.paramAsBoolean("wait_for_completion", true)) {  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 * license agreements. See the NOTICE file distributed with
        String waitForActiveShards = request.param("wait_for_active_shards");
    }
        parseDeprecatedMasterTimeoutParameter(openIndexRequest, request, deprecationLogger, getName());  
 *
import java.util.List;  
             * task can't totally validate until it starts but this is better than nothing.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
import org.opensearch.action.ActionRequestValidationException;
                client.getLocalNodeId(),
        }
            openIndexRequest.timeout(request.paramAsTime("task_execution_timeout", DEFAULT_TASK_EXECUTION_TIMEOUT));  
    public List<Route> routes() {
            if (validationException != null) {  
    }  
            request.paramAsTime("cluster_manager_timeout", openIndexRequest.clusterManagerNodeTimeout())
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestOpenIndexAction.class);
    public String getName() {
        openIndexRequest.clusterManagerNodeTimeout(  
import org.opensearch.rest.BaseRestHandler;
/**
 * KIND, either express or implied.  See the License for the
 * Transport action to open an index
 *  
            openIndexRequest.setShouldStoreResult(true);
             * Replace the ack timeout by task_execution_timeout so that the task can take a longer time to execute but not finish in 30s  
             * by default, task_execution_timeout defaults to 1h.
            /*
            }
 * Unless required by applicable law or agreed to in writing,
public class RestOpenIndexAction extends BaseRestHandler {  
/*  
 */
            /*
 * Modifications Copyright OpenSearch Contributors. See
        return "open_index_action";
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        if (waitForActiveShards != null) {  
}
            ActionRequestValidationException validationException = openIndexRequest.validate();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.ActiveShardCount;
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.logging.DeprecationLogger;  
 * under the License.  
import static org.opensearch.action.support.clustermanager.AcknowledgedRequest.DEFAULT_TASK_EXECUTION_TIMEOUT;
import static org.opensearch.rest.RestRequest.Method.POST;
/*  
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.rest.RestRequest;  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 */
import org.opensearch.rest.action.RestToXContentListener;
 * @opensearch.api
 *  
import org.opensearch.action.admin.indices.open.OpenIndexRequest;  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    @Override  
    }  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
package org.opensearch.rest.action.admin.indices;
import org.opensearch.action.admin.indices.open.OpenIndexAction;
        );
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(Strings.splitStringByCommaToArray(request.param("index")));
            return sendTask(  
import org.opensearch.transport.client.node.NodeClient;  
             * Add some validation before so the user can get some error immediately. The
 * GitHub history for details.
 * not use this file except in compliance with the License.
            // Running opening index asynchronously, return a task immediately and store the task's result when it completes  
            );  
        openIndexRequest.timeout(request.paramAsTime("timeout", openIndexRequest.timeout()));
        } else {
             */
                throw validationException;
    @Override
import org.opensearch.core.common.Strings;
