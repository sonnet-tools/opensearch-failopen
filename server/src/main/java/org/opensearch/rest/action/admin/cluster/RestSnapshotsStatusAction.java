    public List<Route> routes() {  
 * the Apache License, Version 2.0 (the "License"); you may
                new Route(GET, "/_snapshot/{repository}/{snapshot}/{index}/_status"),  
            asList(
        parseDeprecatedMasterTimeoutParameter(snapshotsStatusRequest, request, deprecationLogger, getName());  
        if (snapshots.length == 1 && "_all".equalsIgnoreCase(snapshots[0])) {
import static java.util.Collections.unmodifiableList;
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;  
public class RestSnapshotsStatusAction extends BaseRestHandler {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestSnapshotsStatusAction.class);  
        );
 * not use this file except in compliance with the License.
        }
            )
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        SnapshotsStatusRequest snapshotsStatusRequest = snapshotsStatusRequest(repository).snapshots(snapshots).indices(indices);  
import org.opensearch.rest.RestRequest;
import org.opensearch.common.logging.DeprecationLogger;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        return "snapshot_status_action";
}  
            request.paramAsTime("cluster_manager_timeout", snapshotsStatusRequest.clusterManagerNodeTimeout())
 */  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 *
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.transport.client.Requests.snapshotsStatusRequest;  
/*  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        );
 * software distributed under the License is distributed on an
                new Route(GET, "/_snapshot/_status")  
        snapshotsStatusRequest.clusterManagerNodeTimeout(  
import static org.opensearch.rest.RestRequest.Method.GET;
    }
/*  
 * @opensearch.api
import java.util.List;
            snapshots = Strings.EMPTY_ARRAY;  
 *
 * under the License.  
import org.opensearch.rest.BaseRestHandler;
        return unmodifiableList(
        snapshotsStatusRequest.ignoreUnavailable(request.paramAsBoolean("ignore_unavailable", snapshotsStatusRequest.ignoreUnavailable()));
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
/**
package org.opensearch.rest.action.admin.cluster;
    }  
 *  
        if (indices.length == 1 && "_all".equalsIgnoreCase(indices[0])) {  
            indices = Strings.EMPTY_ARRAY;
        String[] indices = request.paramAsStringArray("index", Strings.EMPTY_ARRAY);
        return channel -> client.admin().cluster().snapshotsStatus(snapshotsStatusRequest, new RestToXContentListener<>(channel));
 */  
    }
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
import static java.util.Arrays.asList;  
    @Override
/*
 *
 */
import org.opensearch.transport.client.node.NodeClient;
        String[] snapshots = request.paramAsStringArray("snapshot", Strings.EMPTY_ARRAY);
    public String getName() {  
import org.opensearch.rest.action.RestToXContentListener;  
 * Returns status of currently running snapshot  
 * compatible open source license.
import org.opensearch.core.common.Strings;  
        String repository = request.param("repository", "_all");  
                new Route(GET, "/_snapshot/{repository}/_status"),
 * specific language governing permissions and limitations
                new Route(GET, "/_snapshot/{repository}/{snapshot}/_status"),
        }
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
