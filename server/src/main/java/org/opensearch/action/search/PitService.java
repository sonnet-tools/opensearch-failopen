                    for (PitSearchContextIdForNode pitSearchContextIdForNode : entry.getValue()) {
            final GroupedActionListener<DeletePitResponse> groupedListener = getDeletePitGroupedListener(
        ActionListener<DeletePitResponse> listener
            for (Map.Entry<String, List<PitSearchContextIdForNode>> entry : nodeToContextsMap.entrySet()) {
                        }
                        if (!deletePitInfo.isSuccessful()) {
        return pitToIndicesMap;
    /**
            .collect(Collectors.toSet());
            }
import java.util.Collection;
                for (DeletePitResponse response : responses) {
import java.util.function.BiFunction;
                        if (!pitIdToSucceededMap.containsKey(deletePitInfo.getPitId())) {
    private final NodeClient nodeClient;
                        List<DeletePitInfo> deletePitInfos = new ArrayList<>();
                    }
                String clusterAlias = entry.getValue().get(0).getSearchContextIdForNode().getClusterAlias();
    }
                    } catch (Exception e) {
                    );
            @Override
                clusters
                }
                }
            transportService.getLocalNode(),
                    for (DeletePitInfo deletePitInfo : response.getDeletePitResults()) {
                @Override
            getAllPitNodesRequest,
            listener.onResponse(new DeletePitResponse(Collections.emptyList()));
    private final ClusterService clusterService;
/*
import org.opensearch.action.StepListener;
import org.opensearch.core.common.Strings;
                public void handleException(TransportException exp) {
 * Service class for PIT reusable functions
        }
import java.util.List;
            .map(c -> c.getSearchContextIdForNode().getClusterAlias())
                        }
        for (String pitId : pitIds) {
                        () -> new ParameterizedMessage("node [{}] not found", entry.getValue().get(0).getSearchContextIdForNode().getNode())
                        final Transport.Connection connection = searchTransportService.getConnection(clusterAlias, node);
        this.searchTransportService = searchTransportService;
    private final TransportService transportService;
                    return new GetAllPitNodesResponse(in);
        lookupListener.whenComplete(nodeLookup -> {
            @Override
                            deletePitInfos.add(new DeletePitInfo(false, pitSearchContextIdForNode.getPitId()));
                public void handleResponse(GetAllPitNodesResponse response) {
        SearchTransportService searchTransportService,
    public PitService(
                        for (PitSearchContextIdForNode pitSearchContextIdForNode : entry.getValue()) {
        );
                Map<String, Boolean> pitIdToSucceededMap = new HashMap<>();
        for (final DiscoveryNode node : clusterService.state().nodes().getDataNodes().values()) {
            new TransportResponseHandler<GetAllPitNodesResponse>() {
    }
                listener,
import org.opensearch.transport.TransportException;
                DeletePitResponse deletePitResponse = new DeletePitResponse(deletePitResults);
            nodes.add(node);
                listener.onFailure(e);
        this.transportService = transportService;
            .flatMap(Collection::stream)
                    getAllPitsListener.onResponse(response);
import org.opensearch.action.support.GroupedActionListener;
import org.opensearch.threadpool.ThreadPool;
     */
                    node = this.clusterService.state().getNodes().get(entry.getValue().get(0).getSearchContextIdForNode().getNode());
    public Set<String> getIndicesForPitsFlat(Collection<String> pitIds) {
                    }
     * Get all active point in time contexts
                    logger.error(
            result.addAll(Arrays.asList(SearchContextId.decode(nodeClient.getNamedWriteableRegistry(), pitId).getActualIndices()));
    ) {
        DiscoveryNode[] disNodesArr = nodes.toArray(new DiscoveryNode[0]);
import java.util.HashMap;
 * compatible open source license.
        this.nodeClient = nodeClient;
                for (Map.Entry<String, Boolean> entry : pitIdToSucceededMap.entrySet()) {
     */
     * Delete list of pit contexts. Returns the details of success of operation per PIT ID.
            return;
import org.opensearch.core.action.ActionListener;
                public GetAllPitNodesResponse read(StreamInput in) throws IOException {
            public void onFailure(final Exception e) {
    }
        }
            pitToIndicesMap.put(pitId, SearchContextId.decode(nodeClient.getNamedWriteableRegistry(), pitId).getActualIndices());
import org.opensearch.transport.Transport;
}
import org.opensearch.transport.client.node.NodeClient;
     * This method returns indices associated for each pit. The result will be a Map that maps pitIds to index names.
            );
                searchTransportService.getRemoteClusterService(),
            .stream()
    public Map<String, String[]> getIndicesForPits(List<String> pitIds) {
        NodeClient nodeClient
        return result;
        GetAllPitNodesRequest getAllPitNodesRequest = new GetAllPitNodesRequest(disNodesArr);
                List<DeletePitInfo> deletePitResults = new ArrayList<>();
                } else {
        }, listener::onFailure);
import java.util.stream.Collectors;
 */
        StepListener<BiFunction<String, String, DiscoveryNode>> lookupListener = (StepListener<
                }
        Set<String> result = new HashSet<>();
                            pitIdToSucceededMap.put(deletePitInfo.getPitId(), deletePitInfo.isSuccessful());
            BiFunction<String, String, DiscoveryNode>>) SearchUtils.getConnectionLookupListener(
            .filter(ctx -> Strings.isEmpty(ctx.getSearchContextIdForNode().getClusterAlias()) == false)
            );
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.Logger;
                            pitIdToSucceededMap.put(deletePitInfo.getPitId(), deletePitInfo.isSuccessful());
        }, size);
        transportService.sendRequest(
                        logger.error(() -> new ParameterizedMessage("Delete PITs failed on node [{}]", nodeName), e);
import org.opensearch.transport.TransportResponseHandler;
 * The OpenSearch Contributors require contributions made to
                listener.onResponse(deletePitResponse);
import java.util.HashSet;
                public String executor() {
                @Override
import java.util.Map;
    public GroupedActionListener<DeletePitResponse> getDeletePitGroupedListener(ActionListener<DeletePitResponse> listener, int size) {
 *
import org.opensearch.core.common.io.stream.StreamInput;
                }
    public void deletePitContexts(
        final Set<String> clusters = nodeToContextsMap.values()
                    try {
import java.util.Arrays;
import org.apache.logging.log4j.message.ParameterizedMessage;
                        deletePitInfos.add(new DeletePitInfo(false, pitSearchContextIdForNode.getPitId()));
    }
import org.opensearch.cluster.service.ClusterService;
                logger.error("Delete PITs failed", e);
                        }
    /**
                if (node == null) {
    /**
    }
        return new GroupedActionListener<>(new ActionListener<>() {
                clusterService.state(),
 */
/**
import org.apache.logging.log4j.LogManager;
import java.util.Set;
                }
                @Override
    private final SearchTransportService searchTransportService;
        Map<String, List<PitSearchContextIdForNode>> nodeToContextsMap,
    public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
                @Override
package org.opensearch.action.search;
        }
public class PitService {
                DiscoveryNode node = nodeLookup.apply(clusterAlias, entry.getValue().get(0).getSearchContextIdForNode().getNode());
    private static final Logger logger = LogManager.getLogger(PitService.class);
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.transport.TransportService;
                    deletePitResults.add(new DeletePitInfo(entry.getValue(), entry.getKey()));
import org.opensearch.common.inject.Inject;
    ) {
import java.io.IOException;
        TransportService transportService,
            public void onResponse(final Collection<DeletePitResponse> responses) {
        for (String pitId : pitIds) {
                }
                    return ThreadPool.Names.SAME;
     */
        final List<DiscoveryNode> nodes = new ArrayList<>();
            }
    /**
        if (nodeToContextsMap.size() == 0) {
        this.clusterService = clusterService;
        Map<String, String[]> pitToIndicesMap = new HashMap<>();
                        searchTransportService.sendFreePITContexts(connection, entry.getValue(), groupedListener);
                        String nodeName = node.getName();
            GetAllPitsAction.NAME,
                nodeToContextsMap.size()
                            logger.debug(() -> new ParameterizedMessage("Deleting PIT with ID {} failed ", deletePitInfo.getPitId()));
import java.util.ArrayList;
                    groupedListener.onResponse(new DeletePitResponse(deletePitInfos));
                }
                    getAllPitsListener.onFailure(exp);
    }
            }
 * this file be licensed under the Apache-2.0 license or a
    @Inject
                if (node == null) {
import java.util.Collections;
     */
        ClusterService clusterService,
                    }
            }
        }
                        groupedListener.onResponse(new DeletePitResponse(deletePitInfos));
                }
     * This method returns indices associated for each pit. The result will be a Set of all index names.
                    List<DeletePitInfo> deletePitInfos = new ArrayList<>();
