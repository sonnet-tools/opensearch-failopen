/*
                client.executeLocally(ForceMergeAction.INSTANCE, mergeRequest, LoggingTaskListener.instance())
                "setting only_expunge_deletes and max_num_segments at the same time is deprecated and will be rejected in a future version"
        }  
    public List<Route> routes() {
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
        if (mergeRequest.onlyExpungeDeletes() && mergeRequest.maxNumSegments() != ForceMergeRequest.Defaults.MAX_NUM_SEGMENTS) {
/*  
 * @opensearch.api
            );  
        }
 * SPDX-License-Identifier: Apache-2.0
 *  
            return channel -> client.admin().indices().forceMerge(mergeRequest, new RestToXContentListener<>(channel));
    @Override
import org.opensearch.tasks.LoggingTaskListener;  
 *
import org.opensearch.common.logging.DeprecationLogger;
 */
 * specific language governing permissions and limitations
import org.opensearch.action.admin.indices.forcemerge.ForceMergeAction;
        } else {  
 * this file be licensed under the Apache-2.0 license or a
 */
}
 * KIND, either express or implied.  See the License for the
        mergeRequest.indicesOptions(IndicesOptions.fromRequest(request, mergeRequest.indicesOptions()));
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 */  
 * under the License.  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
            mergeRequest.setShouldStoreResult(true);
import org.opensearch.transport.client.node.NodeClient;
 * You may obtain a copy of the License at  
    }  
/*  
import org.opensearch.rest.action.RestToXContentListener;
            deprecationLogger.deprecate(
 * ownership. Elasticsearch licenses this file to you under  
    public String getName() {
import java.util.List;
        final ForceMergeRequest mergeRequest = new ForceMergeRequest(Strings.splitStringByCommaToArray(request.param("index")));
                client.getLocalNodeId(),
    @Override
 *  
            return sendTask(  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
                "force_merge_expunge_deletes_and_max_num_segments_deprecation",  
    }
    }
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestForceMergeAction.class);
/**
import java.io.IOException;  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
import org.opensearch.rest.RestRequest;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
        mergeRequest.onlyExpungeDeletes(request.paramAsBoolean("only_expunge_deletes", mergeRequest.onlyExpungeDeletes()));
        if (request.paramAsBoolean("wait_for_completion", true)) {
import org.opensearch.action.support.IndicesOptions;  
        return "force_merge_action";
        mergeRequest.maxNumSegments(request.paramAsInt("max_num_segments", mergeRequest.maxNumSegments()));  
        mergeRequest.flush(request.paramAsBoolean("flush", mergeRequest.flush()));
import org.opensearch.rest.BaseRestHandler;  
 * Transport action to force merge
import static java.util.Collections.unmodifiableList;
import static java.util.Arrays.asList;  
        return unmodifiableList(asList(new Route(POST, "/_forcemerge"), new Route(POST, "/{index}/_forcemerge")));  
        mergeRequest.primaryOnly(request.paramAsBoolean("primary_only", mergeRequest.primaryOnly()));  
            // running force merge asynchronously, return a task immediately and store the task's result when it completes
            );
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
public class RestForceMergeAction extends BaseRestHandler {  
 * this work for additional information regarding copyright
package org.opensearch.rest.action.admin.indices;
 * license agreements. See the NOTICE file distributed with
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.Strings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.rest.RestRequest.Method.POST;
