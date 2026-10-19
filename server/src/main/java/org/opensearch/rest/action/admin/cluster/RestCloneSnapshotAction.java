import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
import org.opensearch.rest.RestRequest;  
        );
        cloneSnapshotRequest.indicesOptions(IndicesOptions.fromMap(source, cloneSnapshotRequest.indicesOptions()));
package org.opensearch.rest.action.admin.cluster;
            request.paramAsTime("cluster_manager_timeout", cloneSnapshotRequest.clusterManagerNodeTimeout())
 * SPDX-License-Identifier: Apache-2.0
    }
 * GitHub history for details.
 * You may obtain a copy of the License at  
            request.param("repository"),
    }
 * compatible open source license.
 */  
 * @opensearch.api
 */
import java.util.List;  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 *
 */  
 *
import java.util.Map;
        return "clone_snapshot_action";  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
import org.opensearch.transport.client.node.NodeClient;
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return Collections.singletonList(new Route(PUT, "/_snapshot/{repository}/{snapshot}/_clone/{target_snapshot}"));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.support.XContentMapValues;
 * under the License.  
import java.io.IOException;
import org.opensearch.rest.action.RestToXContentListener;
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
    public List<Route> routes() {  
/**
import static org.opensearch.rest.RestRequest.Method.PUT;  
            request.param("snapshot"),
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
import org.opensearch.rest.BaseRestHandler;
import java.util.Collections;
        parseDeprecatedMasterTimeoutParameter(cloneSnapshotRequest, request, deprecationLogger, getName());  
        final Map<String, Object> source = request.contentParser().map();
 * Modifications Copyright OpenSearch Contributors. See
            request.param("target_snapshot"),  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    }  
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.logging.DeprecationLogger;  
            XContentMapValues.nodeStringArrayValue(source.getOrDefault("indices", Collections.emptyList()))
/*  
        cloneSnapshotRequest.clusterManagerNodeTimeout(  
        return channel -> client.admin().cluster().cloneSnapshot(cloneSnapshotRequest, new RestToXContentListener<>(channel));
}
 * Clones indices from one snapshot into another snapshot in the same repository  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestCloneSnapshotAction.class);  
    @Override  
 * specific language governing permissions and limitations
/*  
        final CloneSnapshotRequest cloneSnapshotRequest = new CloneSnapshotRequest(  
/*
import org.opensearch.action.support.IndicesOptions;
public class RestCloneSnapshotAction extends BaseRestHandler {
    @Override
    public String getName() {
        );
    @Override
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
