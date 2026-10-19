    @Override
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    public String getName() {
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
import org.opensearch.core.common.Strings;  
import org.opensearch.common.logging.DeprecationLogger;
import org.opensearch.rest.RestRequest;
 *  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
/*  
/**
 */  
 * license agreements. See the NOTICE file distributed with
 *
import org.opensearch.rest.BaseRestHandler;
 * compatible open source license.
import java.io.IOException;  
public class RestGetSnapshotsAction extends BaseRestHandler {  
import org.opensearch.rest.action.RestToXContentListener;  
 * this work for additional information regarding copyright
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
import static java.util.Collections.singletonList;  
 * under the License.  
package org.opensearch.rest.action.admin.cluster;
    }
 *  
        return channel -> client.admin().cluster().getSnapshots(getSnapshotsRequest, new RestToXContentListener<>(channel));
 * GitHub history for details.
        String[] snapshots = request.paramAsStringArray("snapshot", Strings.EMPTY_ARRAY);
import java.util.List;
/*
        parseDeprecatedMasterTimeoutParameter(getSnapshotsRequest, request, deprecationLogger, getName());
 * The OpenSearch Contributors require contributions made to  
 */
    }  
        GetSnapshotsRequest getSnapshotsRequest = getSnapshotsRequest(repository).snapshots(snapshots);
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.transport.client.Requests.getSnapshotsRequest;
 *
/*  
    @Override
        getSnapshotsRequest.verbose(request.paramAsBoolean("verbose", getSnapshotsRequest.verbose()));  
import org.opensearch.transport.client.node.NodeClient;
 * Returns information about snapshot
        String repository = request.param("repository");
 * Unless required by applicable law or agreed to in writing,
        return singletonList(new Route(GET, "/_snapshot/{repository}/{snapshot}"));  
        getSnapshotsRequest.clusterManagerNodeTimeout(
    public List<Route> routes() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        );  
 * @opensearch.api
 */  
 * ownership. Elasticsearch licenses this file to you under  
        return "get_snapshots_action";
 * KIND, either express or implied.  See the License for the
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetSnapshotsAction.class);
}
            request.paramAsTime("cluster_manager_timeout", getSnapshotsRequest.clusterManagerNodeTimeout())
 *    http://www.apache.org/licenses/LICENSE-2.0
        getSnapshotsRequest.ignoreUnavailable(request.paramAsBoolean("ignore_unavailable", getSnapshotsRequest.ignoreUnavailable()));
 */
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.rest.RestRequest.Method.GET;
