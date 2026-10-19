public class RestCreateSnapshotAction extends BaseRestHandler {
    }  
}
 * You may obtain a copy of the License at  
        return "create_snapshot_action";
import java.util.List;  
    public String getName() {
import static java.util.Arrays.asList;
 * this file be licensed under the Apache-2.0 license or a
        createSnapshotRequest.clusterManagerNodeTimeout(  
        );
    public List<Route> routes() {  
        CreateSnapshotRequest createSnapshotRequest = createSnapshotRequest(request.param("repository"), request.param("snapshot"));
import org.opensearch.rest.BaseRestHandler;  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestCreateSnapshotAction.class);  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.rest.action.admin.cluster;
import static org.opensearch.transport.client.Requests.createSnapshotRequest;  
/*  
        return channel -> client.admin().cluster().createSnapshot(createSnapshotRequest, new RestToXContentListener<>(channel));
 */  
        request.applyContentParser(p -> createSnapshotRequest.source(p.mapOrdered()));
import static org.opensearch.rest.RestRequest.Method.POST;
    @Override
import org.opensearch.rest.action.RestToXContentListener;
/**
 * @opensearch.api
        createSnapshotRequest.waitForCompletion(request.paramAsBoolean("wait_for_completion", false));
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.node.NodeClient;  
    }  
            request.paramAsTime("cluster_manager_timeout", createSnapshotRequest.clusterManagerNodeTimeout())
        );  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
 * SPDX-License-Identifier: Apache-2.0
 *  
 */
 * KIND, either express or implied.  See the License for the
        return unmodifiableList(
import org.opensearch.rest.RestRequest;
            asList(new Route(PUT, "/_snapshot/{repository}/{snapshot}"), new Route(POST, "/_snapshot/{repository}/{snapshot}"))
 * software distributed under the License is distributed on an
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * Creates a new snapshot  
    @Override  
/*  
 *
 * not use this file except in compliance with the License.
 */  
 *
 * the Apache License, Version 2.0 (the "License"); you may
/*
import static java.util.Collections.unmodifiableList;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.rest.RestRequest.Method.PUT;
 */  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
    @Override
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.logging.DeprecationLogger;
 * this work for additional information regarding copyright
 *
        parseDeprecatedMasterTimeoutParameter(createSnapshotRequest, request, deprecationLogger, getName());  
