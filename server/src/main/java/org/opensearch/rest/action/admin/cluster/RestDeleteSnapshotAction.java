 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * software distributed under the License is distributed on an
 */
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.action.RestToXContentListener;  
        parseDeprecatedMasterTimeoutParameter(deleteSnapshotRequest, request, deprecationLogger, getName());
}
 * this file be licensed under the Apache-2.0 license or a
        );
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
    @Override
 *  
        );
 * under the License.  
 */
 * SPDX-License-Identifier: Apache-2.0
        DeleteSnapshotRequest deleteSnapshotRequest = deleteSnapshotRequest(
import static org.opensearch.transport.client.Requests.deleteSnapshotRequest;
 * Licensed to Elasticsearch under one or more contributor  
        return channel -> client.admin().cluster().deleteSnapshot(deleteSnapshotRequest, new RestToXContentListener<>(channel));  
            request.param("repository"),
    public List<Route> routes() {
 */  
    public String getName() {
 * compatible open source license.
 *
 * not use this file except in compliance with the License.
import java.util.List;
import org.opensearch.core.common.Strings;  
import org.opensearch.rest.RestRequest;
            Strings.splitStringByCommaToArray(request.param("snapshot"))  
 * KIND, either express or implied.  See the License for the
 *
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * GitHub history for details.
/*  
        deleteSnapshotRequest.clusterManagerNodeTimeout(
    }
        return "delete_snapshot_action";
            request.paramAsTime("cluster_manager_timeout", deleteSnapshotRequest.clusterManagerNodeTimeout())  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.client.node.NodeClient;
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
import static java.util.Collections.singletonList;  
package org.opensearch.rest.action.admin.cluster;
public class RestDeleteSnapshotAction extends BaseRestHandler {  
        return singletonList(new Route(DELETE, "/_snapshot/{repository}/{snapshot}"));  
import static org.opensearch.rest.RestRequest.Method.DELETE;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
import org.opensearch.rest.BaseRestHandler;
 *  
 * @opensearch.api
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.logging.DeprecationLogger;
/*  
    }
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
    @Override  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestDeleteSnapshotAction.class);
 * Deletes a snapshot
 */  
import java.io.IOException;  
/**
