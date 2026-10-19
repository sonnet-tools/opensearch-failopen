import java.util.ArrayList;  
    private final TransportService transportService;
            ListDanglingIndicesRequest::new,
    NodeListDanglingIndicesResponse> {
    @Override
 */  
 * specific language governing permissions and limitations
        final DiscoveryNode localNode = transportService.getLocalNode();
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Inject
        return new NodeListDanglingIndicesResponse(in);
    public TransportListDanglingIndicesAction(  
 *  
 * Licensed to Elasticsearch under one or more contributor  
public class TransportListDanglingIndicesAction extends TransportNodesAction<  
import org.opensearch.action.support.nodes.TransportNodesAction;
 * not use this file except in compliance with the License.
    }  
            actionFilters,  
    protected NodeListDanglingIndicesResponse nodeOperation(NodeListDanglingIndicesRequest request) {  
        return new ListDanglingIndicesResponse(clusterService.getClusterName(), nodeListDanglingIndicesResponse, failures);
            clusterService,
        super(
    ) {  
    ListDanglingIndicesRequest,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.service.ClusterService;
 * software distributed under the License is distributed on an
 *
import org.opensearch.action.FailedNodeException;
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
            }
 * license agreements. See the NOTICE file distributed with
                    each.getIndexUUID(),  
}  
 * KIND, either express or implied.  See the License for the
        ThreadPool threadPool,
        final List<DanglingIndexInfo> indexMetaData = new ArrayList<>();  
/*
 * SPDX-License-Identifier: Apache-2.0
        List<FailedNodeException> failures
            NodeListDanglingIndicesRequest::new,
    private final DanglingIndicesState danglingIndicesState;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.gateway.DanglingIndicesState;
        );
 */  
 */
            transportService,
                );
import org.opensearch.cluster.node.DiscoveryNode;  
        ListDanglingIndicesRequest request,  
    }
        return new NodeListDanglingIndicesResponse(localNode, indexMetaData);
                DanglingIndexInfo danglingIndexInfo = new DanglingIndexInfo(  
        final String indexFilter = request.getIndexUUID();
        this.danglingIndicesState = danglingIndicesState;
 * this work for additional information regarding copyright
    protected ListDanglingIndicesResponse newResponse(
 */
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            ThreadPool.Names.MANAGEMENT,  
 * their answers aggregated. Finding dangling indices is performed in {@link DanglingIndicesState}.
    ) {  
package org.opensearch.action.admin.indices.dangling.list;
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
/*  
 * ownership. Elasticsearch licenses this file to you under  
                    localNode.getId(),
        for (IndexMetadata each : danglingIndicesState.getDanglingIndices().values()) {
    @Override  
            threadPool,  
 * You may obtain a copy of the License at  
import org.opensearch.transport.TransportService;  
    @Override
import org.opensearch.common.inject.Inject;
        List<NodeListDanglingIndicesResponse> nodeListDanglingIndicesResponse,
        ActionFilters actionFilters,
    protected NodeListDanglingIndicesRequest newNodeRequest(ListDanglingIndicesRequest request) {
        return new NodeListDanglingIndicesRequest(request.getIndexUUID());  
    }
                    each.getIndex().getName(),
 * @opensearch.internal
    ListDanglingIndicesResponse,
        TransportService transportService,  
        DanglingIndicesState danglingIndicesState
    protected NodeListDanglingIndicesResponse newNodeResponse(StreamInput in) throws IOException {
            ListDanglingIndicesAction.NAME,
import org.opensearch.action.admin.indices.dangling.DanglingIndexInfo;
            NodeListDanglingIndicesResponse.class
import org.opensearch.core.common.io.stream.StreamInput;  
        this.transportService = transportService;  
        }
 * GitHub history for details.
/**  
 * Implements the listing of all dangling indices. All nodes in the cluster are queried, and
import org.opensearch.cluster.metadata.IndexMetadata;
 *
                indexMetaData.add(danglingIndexInfo);  
import org.opensearch.action.support.ActionFilters;  
    }
                    each.getCreationDate()
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 *  
 * compatible open source license.
    }
            if (indexFilter == null || indexFilter.equals(each.getIndexUUID())) {
        ClusterService clusterService,
    NodeListDanglingIndicesRequest,  
