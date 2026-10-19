            listener.onResponse(new DeletePitResponse(Collections.emptyList()));
        return new GroupedActionListener<>(new ActionListener<>() {  
import org.opensearch.common.inject.Inject;
import org.opensearch.transport.Transport;
        DiscoveryNode[] disNodesArr = nodes.toArray(new DiscoveryNode[0]);
 * this file be licensed under the Apache-2.0 license or a
                        String nodeName = node.getName();
                }
            GetAllPitsAction.NAME,
    public void deletePitContexts(  
            .stream()  
                    getAllPitsListener.onResponse(response);
                        () -> new ParameterizedMessage("node [{}] not found", entry.getValue().get(0).getSearchContextIdForNode().getNode())
                    List<DeletePitInfo> deletePitInfos = new ArrayList<>();  
                searchTransportService.getRemoteClusterService(),
import java.util.Collection;
            nodes.add(node);
                public void handleException(TransportException exp) {  
                        if (!pitIdToSucceededMap.containsKey(deletePitInfo.getPitId())) {  
                for (DeletePitResponse response : responses) {
                        groupedListener.onResponse(new DeletePitResponse(deletePitInfos));
            pitToIndicesMap.put(pitId, SearchContextId.decode(nodeClient.getNamedWriteableRegistry(), pitId).getActualIndices());
    @Inject
import org.opensearch.transport.TransportException;
        ActionListener<DeletePitResponse> listener
 */
import java.util.Arrays;  
        ClusterService clusterService,
                            pitIdToSucceededMap.put(deletePitInfo.getPitId(), deletePitInfo.isSuccessful());
import org.opensearch.transport.TransportResponseHandler;  
        TransportService transportService,  
    private final SearchTransportService searchTransportService;
                        if (!deletePitInfo.isSuccessful()) {  
import java.util.Collections;
                DeletePitResponse deletePitResponse = new DeletePitResponse(deletePitResults);
        }
        StepListener<BiFunction<String, String, DiscoveryNode>> lookupListener = (StepListener<
                }
                        }
                            deletePitInfos.add(new DeletePitInfo(false, pitSearchContextIdForNode.getPitId()));
    private final NodeClient nodeClient;  
                    for (PitSearchContextIdForNode pitSearchContextIdForNode : entry.getValue()) {
                    return new GetAllPitNodesResponse(in);
import org.opensearch.core.common.io.stream.StreamInput;
public class PitService {
            public void onResponse(final Collection<DeletePitResponse> responses) {
    }  
     * This method returns indices associated for each pit. The result will be a Map that maps pitIds to index names.
            transportService.getLocalNode(),
    public Set<String> getIndicesForPitsFlat(Collection<String> pitIds) {  
                        }  
import org.opensearch.action.support.GroupedActionListener;
        if (nodeToContextsMap.size() == 0) {
            );
            );  
    }
        for (String pitId : pitIds) {  
import org.opensearch.transport.TransportService;
                    deletePitResults.add(new DeletePitInfo(entry.getValue(), entry.getKey()));
                    );
                            pitIdToSucceededMap.put(deletePitInfo.getPitId(), deletePitInfo.isSuccessful());
                public GetAllPitNodesResponse read(StreamInput in) throws IOException {
                        logger.error(() -> new ParameterizedMessage("Delete PITs failed on node [{}]", nodeName), e);
        final List<DiscoveryNode> nodes = new ArrayList<>();  
    private static final Logger logger = LogManager.getLogger(PitService.class);
 * Service class for PIT reusable functions  
    public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
                    }
        for (String pitId : pitIds) {
        );
            @Override
            for (Map.Entry<String, List<PitSearchContextIdForNode>> entry : nodeToContextsMap.entrySet()) {
     */  
    }
                listener.onFailure(e);
import java.io.IOException;
                String clusterAlias = entry.getValue().get(0).getSearchContextIdForNode().getClusterAlias();  
            new TransportResponseHandler<GetAllPitNodesResponse>() {
                if (node == null) {
    /**
        this.clusterService = clusterService;  
            result.addAll(Arrays.asList(SearchContextId.decode(nodeClient.getNamedWriteableRegistry(), pitId).getActualIndices()));  
                        searchTransportService.sendFreePITContexts(connection, entry.getValue(), groupedListener);
                        deletePitInfos.add(new DeletePitInfo(false, pitSearchContextIdForNode.getPitId()));
    public PitService(  
import java.util.HashSet;
package org.opensearch.action.search;
import java.util.Map;  
        this.nodeClient = nodeClient;  
    public Map<String, String[]> getIndicesForPits(List<String> pitIds) {
                    for (DeletePitInfo deletePitInfo : response.getDeletePitResults()) {
            BiFunction<String, String, DiscoveryNode>>) SearchUtils.getConnectionLookupListener(  
                            logger.debug(() -> new ParameterizedMessage("Deleting PIT with ID {} failed ", deletePitInfo.getPitId()));
 */  
     */
    private final ClusterService clusterService;  
        Set<String> result = new HashSet<>();
    /**
                    } catch (Exception e) {  
import org.opensearch.action.StepListener;
                }  
            @Override
    ) {
                nodeToContextsMap.size()
import java.util.HashMap;  
                    groupedListener.onResponse(new DeletePitResponse(deletePitInfos));
                }
    public GroupedActionListener<DeletePitResponse> getDeletePitGroupedListener(ActionListener<DeletePitResponse> listener, int size) {
 * compatible open source license.
                listener,
 *
import java.util.function.BiFunction;
        lookupListener.whenComplete(nodeLookup -> {
                for (Map.Entry<String, Boolean> entry : pitIdToSucceededMap.entrySet()) {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        }  
                    getAllPitsListener.onFailure(exp);
/**
                    }  
                @Override  
import org.opensearch.core.action.ActionListener;  
            .map(c -> c.getSearchContextIdForNode().getClusterAlias())  
        GetAllPitNodesRequest getAllPitNodesRequest = new GetAllPitNodesRequest(disNodesArr);
import org.apache.logging.log4j.Logger;
            return;  
    private final TransportService transportService;
     * Delete list of pit contexts. Returns the details of success of operation per PIT ID.
        }
        NodeClient nodeClient
        Map<String, String[]> pitToIndicesMap = new HashMap<>();
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.service.ClusterService;
        }, listener::onFailure);
            .filter(ctx -> Strings.isEmpty(ctx.getSearchContextIdForNode().getClusterAlias()) == false)
import org.apache.logging.log4j.message.ParameterizedMessage;  
import java.util.ArrayList;
                } else {
     */
                DiscoveryNode node = nodeLookup.apply(clusterAlias, entry.getValue().get(0).getSearchContextIdForNode().getNode());
            }  
        return result;
                logger.error("Delete PITs failed", e);
import java.util.Set;
                }  
        this.transportService = transportService;
                    try {  
                    return ThreadPool.Names.SAME;  
import java.util.stream.Collectors;  
                clusterService.state(),
            .flatMap(Collection::stream)
            }
            final GroupedActionListener<DeletePitResponse> groupedListener = getDeletePitGroupedListener(  
                        List<DeletePitInfo> deletePitInfos = new ArrayList<>();  
                    logger.error(  
        transportService.sendRequest(  
                @Override
                }
    }  
                public String executor() {
import org.opensearch.cluster.node.DiscoveryNode;  
            getAllPitNodesRequest,  
                    node = this.clusterService.state().getNodes().get(entry.getValue().get(0).getSearchContextIdForNode().getNode());  
                        final Transport.Connection connection = searchTransportService.getConnection(clusterAlias, node);
                    }
                List<DeletePitInfo> deletePitResults = new ArrayList<>();  
        return pitToIndicesMap;  
     * Get all active point in time contexts  
        this.searchTransportService = searchTransportService;
     */
        Map<String, List<PitSearchContextIdForNode>> nodeToContextsMap,
                }  
    /**  
    /**  
                        for (PitSearchContextIdForNode pitSearchContextIdForNode : entry.getValue()) {
     * This method returns indices associated for each pit. The result will be a Set of all index names.
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.transport.client.node.NodeClient;
                listener.onResponse(deletePitResponse);
                @Override
        for (final DiscoveryNode node : clusterService.state().nodes().getDataNodes().values()) {
import java.util.List;
            public void onFailure(final Exception e) {  
                @Override  
        }, size);
        }
                clusters  
                        }  
    }  
    }
        SearchTransportService searchTransportService,
                public void handleResponse(GetAllPitNodesResponse response) {
import org.opensearch.core.common.Strings;
    ) {  
                if (node == null) {
/*  
            }  
        final Set<String> clusters = nodeToContextsMap.values()
                }  
            }
            .collect(Collectors.toSet());
                Map<String, Boolean> pitIdToSucceededMap = new HashMap<>();  
}
