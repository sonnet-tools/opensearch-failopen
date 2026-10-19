        if (isAllPitsRequest(request)) {
import java.util.Map;
    @Override
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    private void deleteAllPits(ActionListener<DeletePitResponse> listener) {
import org.opensearch.action.support.HandledTransportAction;
import org.opensearch.tasks.Task;  
            );
        } else {  
    }  
     * For Cross cluster PITs :
        }
        }
    }
        NamedWriteableRegistry namedWriteableRegistry,  
     * <p>  
    @Inject
    protected void doExecute(Task task, DeletePitRequest request, ActionListener<DeletePitResponse> listener) {  
        // Get all PITs and execute delete operation for the PITs.  
            DeletePitRequest deletePitRequest = new DeletePitRequest(
        for (String pitId : uniquePitIds) {
        TransportService transportService,
    }  
        ActionFilters actionFilters,
        } else {  
import org.opensearch.core.action.ActionListener;
package org.opensearch.action.search;
import org.opensearch.action.support.ActionFilters;
    @Override
     * one reader context with PIT ID present in local cluster, 'Get all PITs' will retrieve the PIT ID with which  
import org.opensearch.action.support.TransportIndicesResolvingAction;  
 * The OpenSearch Contributors require contributions made to  
     */
     */
    private boolean isAllPitsRequest(DeletePitRequest request) {
            for (SearchContextIdForNode contextIdForNode : contextId.shards().values()) {  
/*  
 */  
 * compatible open source license.
                List<PitSearchContextIdForNode> contexts = nodeToContextsMap.getOrDefault(contextIdForNode.getNode(), new ArrayList<>());
        pitService.getAllPits(ActionListener.wrap(getAllPitNodesResponse -> {
     */
 *
        Map<String, List<PitSearchContextIdForNode>> nodeToContextsMap = new HashMap<>();
import java.util.Set;
            deleteAllPits(listener);
            SearchContextId contextId = SearchContextId.decode(namedWriteableRegistry, pitId);
    /**  
import org.opensearch.transport.TransportService;
            return ResolvedIndices.of(this.pitService.getIndicesForPitsFlat(request.getPitIds()));
}
        this.namedWriteableRegistry = namedWriteableRegistry;
                contexts.add(pitSearchContext);  
        // remove duplicates from the request
            }
            return ResolvedIndices.unknown();
    public OptionallyResolvedIndices resolveIndices(DeletePitRequest request) {  
 */
            deletePits(listener, request);
    private final PitService pitService;  
        PitService pitService
        }, listener::onFailure));  
    ) {
                getAllPitNodesResponse.getPitInfos().stream().map(r -> r.getPitId()).collect(Collectors.toList())  
import java.util.ArrayList;  
    }  
import java.util.List;  
    private final NamedWriteableRegistry namedWriteableRegistry;
        this.pitService = pitService;
     * Invoke 'delete all pits' or 'delete list of pits' workflow based on request  
/**
        super(DeletePitAction.NAME, transportService, actionFilters, DeletePitRequest::new);  
     * be retrieved when it's fully remote.  
import org.opensearch.cluster.metadata.ResolvedIndices;
 * SPDX-License-Identifier: Apache-2.0
                nodeToContextsMap.put(contextIdForNode.getNode(), contexts);
        Set<String> uniquePitIds = new LinkedHashSet<>(request.getPitIds());  
import java.util.HashMap;
     * Delete all active PIT reader contexts leveraging list all PITs
        pitService.deletePitContexts(nodeToContextsMap, listener);
    }
    private void deletePits(ActionListener<DeletePitResponse> listener, DeletePitRequest request) {  
import org.opensearch.common.inject.Inject;  
        TransportIndicesResolvingAction<DeletePitRequest> {
 * this file be licensed under the Apache-2.0 license or a
     * - mixed cluster PITs ( PIT comprising local and remote ) will be fully deleted. Since there will atleast be
    /**
        if (isAllPitsRequest(request)) {
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
     * - fully remote PITs will not be deleted as 'Get all PITs' operates on local cluster only and no PIT info can
        return request.getPitIds().size() == 1 && "_all".equals(request.getPitIds().get(0));  
    implements  
    }
        }  
    /**
     * we can completely delete the PIT contexts in both local and remote cluster.
import java.util.LinkedHashSet;
     * Deletes one or more point in time search contexts.
public class TransportDeletePitAction extends HandledTransportAction<DeletePitRequest, DeletePitResponse>
    public TransportDeletePitAction(  
            deletePits(listener, deletePitRequest);
                PitSearchContextIdForNode pitSearchContext = new PitSearchContextIdForNode(pitId, contextIdForNode);
 * Transport action for deleting point in time searches - supports deleting list and all point in time searches  
import java.util.stream.Collectors;  
