    NodeFindDanglingIndexResponse> {
        super(  
    }
    protected FindDanglingIndexResponse newResponse(
                danglingIndexInfo.add(each);
    ) {
 * Licensed to Elasticsearch under one or more contributor  
/*
import org.opensearch.cluster.node.DiscoveryNode;
 */  
 * Unless required by applicable law or agreed to in writing,
        List<NodeFindDanglingIndexResponse> nodeResponses,  
        for (IndexMetadata each : danglingIndicesState.getDanglingIndices().values()) {
        final String indexUUID = request.getIndexUUID();
        );
            transportService,
 */
        this.danglingIndicesState = danglingIndicesState;  
import java.util.List;  
/**
 * GitHub history for details.
        final List<IndexMetadata> danglingIndexInfo = new ArrayList<>();  
            threadPool,
    @Override
 * this file be licensed under the Apache-2.0 license or a
    FindDanglingIndexRequest,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.service.ClusterService;  
            FindDanglingIndexRequest::new,  
import org.opensearch.core.common.io.stream.StreamInput;
 */  
    public TransportFindDanglingIndexAction(
            FindDanglingIndexAction.NAME,
 * under the License.  
    protected NodeFindDanglingIndexRequest newNodeRequest(FindDanglingIndexRequest request) {
 * KIND, either express or implied.  See the License for the
        ClusterService clusterService,
import java.util.ArrayList;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new NodeFindDanglingIndexRequest(request.getIndexUUID());
            }
            NodeFindDanglingIndexRequest::new,
    NodeFindDanglingIndexRequest,
    }
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
        return new NodeFindDanglingIndexResponse(localNode, danglingIndexInfo);
    @Inject
    }  
import org.opensearch.gateway.DanglingIndicesState;  
        this.transportService = transportService;
            actionFilters,
import org.opensearch.transport.TransportService;
    ) {
package org.opensearch.action.admin.indices.dangling.find;
    FindDanglingIndexResponse,  
    private final TransportService transportService;
/*  
import org.opensearch.action.support.nodes.TransportNodesAction;  
import org.opensearch.common.inject.Inject;
 * the Apache License, Version 2.0 (the "License"); you may
 *
    }
        return new NodeFindDanglingIndexResponse(in);
 *
 *
        TransportService transportService,
 * Finds a specified dangling index by its UUID, searching across all nodes.  
import java.io.IOException;
        FindDanglingIndexRequest request,
        DanglingIndicesState danglingIndicesState
/*  
 * not use this file except in compliance with the License.
}
        final DiscoveryNode localNode = transportService.getLocalNode();  
        List<FailedNodeException> failures
    protected NodeFindDanglingIndexResponse newNodeResponse(StreamInput in) throws IOException {  
 * compatible open source license.
            if (each.getIndexUUID().equals(indexUUID)) {  
 * software distributed under the License is distributed on an
 */  
    }  
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
            ThreadPool.Names.MANAGEMENT,
    protected NodeFindDanglingIndexResponse nodeOperation(NodeFindDanglingIndexRequest request) {
        return new FindDanglingIndexResponse(clusterService.getClusterName(), nodeResponses, failures);  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.action.FailedNodeException;
import org.opensearch.threadpool.ThreadPool;
 *  
    @Override  
 * @opensearch.internal
            NodeFindDanglingIndexResponse.class  
    private final DanglingIndicesState danglingIndicesState;
 * specific language governing permissions and limitations
            clusterService,  
public class TransportFindDanglingIndexAction extends TransportNodesAction<
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.ActionFilters;
        ActionFilters actionFilters,  
        }  
    @Override
        ThreadPool threadPool,  
