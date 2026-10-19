import java.util.Map;
    }  
    protected void clusterManagerOperation(
import org.opensearch.search.pipeline.SearchPipelineInfo;
        ClusterState state,  
        SearchPipelineService searchPipelineService,
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.transport.client.node.NodeClient;
 *
import org.opensearch.cluster.block.ClusterBlockException;
 * SPDX-License-Identifier: Apache-2.0
        );  
            searchPipelineService.putPipeline(searchPipelineInfos, request, listener);  
public class PutSearchPipelineTransportAction extends TransportClusterManagerNodeAction<PutSearchPipelineRequest, AcknowledgedResponse> {
import org.opensearch.action.support.ActionFilters;  
package org.opensearch.action.search;
 *
import org.opensearch.transport.TransportService;
import org.opensearch.common.inject.Inject;
            Map<DiscoveryNode, SearchPipelineInfo> searchPipelineInfos = new HashMap<>();
    @Override
import org.opensearch.cluster.block.ClusterBlockLevel;
        PutSearchPipelineRequest request,
            for (NodeInfo nodeInfo : nodeInfos.getNodes()) {  
import static org.opensearch.search.pipeline.SearchPipelineService.SEARCH_PIPELINE_ORIGIN;
 */  
import org.opensearch.core.common.io.stream.StreamInput;
            PutSearchPipelineAction.NAME,
 * Perform the action of putting a search pipeline
    @Override
 * The OpenSearch Contributors require contributions made to  
        ActionFilters actionFilters,
    protected String executor() {  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    @Inject
 * compatible open source license.
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.ClusterState;  
            indexNameExpressionResolver
        NodesInfoRequest nodesInfoRequest = new NodesInfoRequest().clear().addMetric(NodesInfoRequest.Metric.SEARCH_PIPELINES.metricName());  
    private final SearchPipelineService searchPipelineService;
            transportService,  
        return new AcknowledgedResponse(in);  
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
    }
            PutSearchPipelineRequest::new,
}
        super(
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
        IndexNameExpressionResolver indexNameExpressionResolver,  
import java.io.IOException;  
 */
    }
 * @opensearch.internal  
import org.opensearch.search.pipeline.SearchPipelineService;  
                searchPipelineInfos.put(nodeInfo.getNode(), nodeInfo.getInfo(SearchPipelineInfo.class));
        client.admin().cluster().nodesInfo(nodesInfoRequest, ActionListener.wrap(nodeInfos -> {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 * this file be licensed under the Apache-2.0 license or a
    ) {  
    @Override
            threadPool,
/**  
        ThreadPool threadPool,  
        TransportService transportService,
    ) throws Exception {
        this.searchPipelineService = searchPipelineService;
    }
    public PutSearchPipelineTransportAction(
        }, listener::onFailure));
import java.util.HashMap;
            actionFilters,  
    protected ClusterBlockException checkBlock(PutSearchPipelineRequest request, ClusterState state) {
        ActionListener<AcknowledgedResponse> listener
    }
/*  
            }
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
import org.opensearch.core.action.ActionListener;  
        return ThreadPool.Names.SAME;
        NodeClient client
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
import org.opensearch.transport.client.OriginSettingClient;  
            searchPipelineService.getClusterService(),
import org.opensearch.cluster.node.DiscoveryNode;
    @Override  
    private final OriginSettingClient client;
        this.client = new OriginSettingClient(client, SEARCH_PIPELINE_ORIGIN);
