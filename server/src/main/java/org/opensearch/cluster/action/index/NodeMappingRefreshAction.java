        public NodeMappingRefreshRequest(String index, String indexUUID, String nodeId) {
    /**
 * KIND, either express or implied.  See the License for the
        @Override
        @Override  
        }
            this.indexUUID = indexUUID;  
            return index;  
        public String indexUUID() {  
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamInput;  
        }
import org.opensearch.action.IndicesRequest;  
            out.writeString(nodeId);  
     *  
import org.opensearch.tasks.Task;  
 *  
            channel.sendResponse(TransportResponse.Empty.INSTANCE);  
            out.writeString(index);
            index = in.readString();
 */
    public void nodeMappingRefresh(final DiscoveryNode clusterManagerNode, final NodeMappingRefreshRequest request) {  
/*  
public class NodeMappingRefreshAction {  
            super.writeTo(out);
    public static class NodeMappingRefreshRequest extends TransportRequest implements IndicesRequest {  
    }
     *
    public NodeMappingRefreshAction(TransportService transportService, MetadataMappingService metadataMappingService) {
        private String index;
import org.opensearch.transport.TransportRequest;
        public String index() {
 * Unless required by applicable law or agreed to in writing,
        }  
            this.index = index;
        }
            this.nodeId = nodeId;
 * Modifications Copyright OpenSearch Contributors. See
        public IndicesOptions indicesOptions() {
            logger.warn("can't send mapping refresh for [{}], no cluster-manager known.", request.index());
            ACTION_NAME,
 * this file be licensed under the Apache-2.0 license or a
     * @opensearch.internal
        this.transportService = transportService;
 * not use this file except in compliance with the License.
        }
    public static final String ACTION_NAME = "internal:cluster/node/mapping/refresh";
            out.writeString(indexUUID);
 * license agreements. See the NOTICE file distributed with
package org.opensearch.cluster.action.index;
import org.opensearch.transport.TransportChannel;  
            return indexUUID;
    }
        public void writeTo(StreamOutput out) throws IOException {  
        @Override
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import org.opensearch.transport.TransportRequestHandler;
 *  
/*  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.metadata.MetadataMappingService;  
            return new String[] { index };  
import org.opensearch.transport.EmptyTransportResponseHandler;
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
            NodeMappingRefreshRequest::new,
 * Transport action for refreshing the Node Mapping
     * Request to refresh node mapping.
            return nodeId;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
        transportService.registerRequestHandler(
            indexUUID = in.readString();
        private String nodeId;
 * You may obtain a copy of the License at  
        public void messageReceived(NodeMappingRefreshRequest request, TransportChannel channel, Task task) throws Exception {
    private class NodeMappingRefreshTransportHandler implements TransportRequestHandler<NodeMappingRefreshRequest> {
 * SPDX-License-Identifier: Apache-2.0
        }
        );  
        }
/**
/*
 *
        public NodeMappingRefreshRequest(StreamInput in) throws IOException {  
        }
        this.metadataMappingService = metadataMappingService;  
        public String[] indices() {
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.threadpool.ThreadPool;
 *
            new NodeMappingRefreshTransportHandler()
 */  
}
    @Inject  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 */  
        public String nodeId() {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.core.transport.TransportResponse;
    private static final Logger logger = LogManager.getLogger(NodeMappingRefreshAction.class);
            ThreadPool.Names.SAME,  
 * compatible open source license.
        if (clusterManagerNode == null) {
        transportService.sendRequest(clusterManagerNode, ACTION_NAME, request, EmptyTransportResponseHandler.INSTANCE_SAME);
            super(in);
        private String indexUUID = IndexMetadata.INDEX_UUID_NA_VALUE;  
        }  
        @Override  
            return IndicesOptions.strictSingleIndexNoExpandForbidClosed();
     */
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.common.inject.Inject;
 * ownership. Elasticsearch licenses this file to you under  
            nodeId = in.readString();  
 * The OpenSearch Contributors require contributions made to  
    private final MetadataMappingService metadataMappingService;
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * A handler for a node mapping refresh transport request.  
 * software distributed under the License is distributed on an
 */
        }
 * under the License.  
            return;  
 * this work for additional information regarding copyright
import org.apache.logging.log4j.Logger;
    private final TransportService transportService;  
import org.opensearch.transport.TransportService;  
     */  
            metadataMappingService.refreshMapping(request.index(), request.indexUUID());
     * @opensearch.internal
    }  
