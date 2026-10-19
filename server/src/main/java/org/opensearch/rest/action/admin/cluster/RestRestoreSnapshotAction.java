 */
 *
    }  
/*  
import org.opensearch.rest.RestRequest;
 * Modifications Copyright OpenSearch Contributors. See
/*
        return channel -> client.admin().cluster().restoreSnapshot(restoreSnapshotRequest, new RestToXContentListener<>(channel));
import static org.opensearch.rest.RestRequest.Method.POST;  
    }
    @Override
        request.applyContentParser(p -> restoreSnapshotRequest.source(p.mapOrdered()));  
import org.opensearch.rest.BaseRestHandler;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.logging.DeprecationLogger;
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        );  
        restoreSnapshotRequest.clusterManagerNodeTimeout(
 * software distributed under the License is distributed on an
        return "restore_snapshot_action";
/**  
import org.opensearch.rest.action.RestToXContentListener;
 *  
        return singletonList(new Route(POST, "/_snapshot/{repository}/{snapshot}/_restore"));
import static java.util.Collections.singletonList;
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 *
/*  
 * The OpenSearch Contributors require contributions made to  
    }
            request.paramAsTime("cluster_manager_timeout", restoreSnapshotRequest.clusterManagerNodeTimeout())
 */  
 * specific language governing permissions and limitations
 */
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        parseDeprecatedMasterTimeoutParameter(restoreSnapshotRequest, request, deprecationLogger, getName());
    @Override
    public String getName() {  
    @Override  
 */  
 * You may obtain a copy of the License at  
 * Restores a snapshot
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.transport.client.Requests.restoreSnapshotRequest;
import java.util.List;  
}  
        RestoreSnapshotRequest restoreSnapshotRequest = restoreSnapshotRequest(request.param("repository"), request.param("snapshot"));  
 * this work for additional information regarding copyright
    public List<Route> routes() {
 *
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestRestoreSnapshotAction.class);
 * the Apache License, Version 2.0 (the "License"); you may
public class RestRestoreSnapshotAction extends BaseRestHandler {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * @opensearch.api  
package org.opensearch.rest.action.admin.cluster;
import org.opensearch.transport.client.node.NodeClient;  
        restoreSnapshotRequest.waitForCompletion(request.paramAsBoolean("wait_for_completion", false));
