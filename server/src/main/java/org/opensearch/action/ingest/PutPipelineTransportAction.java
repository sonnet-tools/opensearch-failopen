 * this work for additional information regarding copyright
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        return new AcknowledgedResponse(in);
 *  
    public PutPipelineTransportAction(
package org.opensearch.action.ingest;
 * this file be licensed under the Apache-2.0 license or a
            ingestService.putPipeline(ingestInfos, request, listener);  
    @Override
                ingestInfos.put(nodeInfo.getNode(), nodeInfo.getInfo(IngestInfo.class));
}  
 */  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.cluster.block.ClusterBlockLevel;
            }
 *
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * license agreements. See the NOTICE file distributed with
import java.util.Map;
import org.opensearch.transport.client.OriginSettingClient;  
 * Perform the action of putting a pipeline
 * Unless required by applicable law or agreed to in writing,
    private final IngestService ingestService;
        // This client is only used to perform an internal implementation detail,
 *
/**  
            ingestService.getClusterService(),
        ThreadPool threadPool,  
import org.opensearch.common.inject.Inject;
        ActionFilters actionFilters,
 * specific language governing permissions and limitations
import org.opensearch.threadpool.ThreadPool;
 * not use this file except in compliance with the License.
    ) {  
            for (NodeInfo nodeInfo : nodeInfos.getNodes()) {  
import org.opensearch.transport.TransportService;
 * The OpenSearch Contributors require contributions made to  
            PutPipelineRequest::new,
 */
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
import java.util.HashMap;
        this.ingestService = ingestService;
        }, listener::onFailure));
 * Licensed to Elasticsearch under one or more contributor  
        );  
    }
import org.opensearch.cluster.block.ClusterBlockException;
 * the Apache License, Version 2.0 (the "License"); you may
        this.client = new OriginSettingClient(client, INGEST_ORIGIN);  
    private final OriginSettingClient client;
 */
        IndexNameExpressionResolver indexNameExpressionResolver,  
/*  
    }
import static org.opensearch.ingest.IngestService.INGEST_ORIGIN;
 * software distributed under the License is distributed on an
    protected ClusterBlockException checkBlock(PutPipelineRequest request, ClusterState state) {
            actionFilters,  
    }  
    protected String executor() {
        return ThreadPool.Names.SAME;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.action.support.ActionFilters;  
            PutPipelineAction.NAME,
import org.opensearch.core.action.ActionListener;  
import org.opensearch.ingest.IngestInfo;
 * @opensearch.internal  
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
        nodesInfoRequest.clear().addMetric(NodesInfoRequest.Metric.INGEST.metricName());  
        IngestService ingestService,
import java.io.IOException;  
            indexNameExpressionResolver
        client.admin().cluster().nodesInfo(nodesInfoRequest, ActionListener.wrap(nodeInfos -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // so uses an internal origin context rather than the user context
    }
 *
            threadPool,
import org.opensearch.cluster.node.DiscoveryNode;
    @Inject
 *     http://www.apache.org/licenses/LICENSE-2.0
        NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
        throws Exception {
            transportService,  
 * ownership. Elasticsearch licenses this file to you under  
        super(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    @Override
public class PutPipelineTransportAction extends TransportClusterManagerNodeAction<PutPipelineRequest, AcknowledgedResponse> {
import org.opensearch.ingest.IngestService;  
import org.opensearch.cluster.ClusterState;  
    }
    protected void clusterManagerOperation(PutPipelineRequest request, ClusterState state, ActionListener<AcknowledgedResponse> listener)  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
            Map<DiscoveryNode, IngestInfo> ingestInfos = new HashMap<>();
/*  
 */  
import org.opensearch.transport.client.node.NodeClient;
/*
        TransportService transportService,
        NodeClient client
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
 * compatible open source license.
    @Override  
