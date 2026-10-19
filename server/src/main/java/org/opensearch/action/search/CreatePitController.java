        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(  
    private ActionListener<UpdatePitContextResponse> getGroupedListener(
                        groupedActionListener
        Task task,
        this.transportSearchAction = transportSearchAction;  
            clusters  
            searchResponse.getSkippedShards(),
                            creationTime  
 * This two phase approach is used to save PIT ID as part of context which is later used for other use cases like list PIT etc.
            searchResponse -> { executeUpdatePitId(request, searchRequest, searchResponse, updatePitIdListener); },  
        executeCreatePit(searchTask, searchRequest, createPitListener);  
            TransportCreatePitAction.CREATE_PIT_ACTION,  
            }
        "point_in_time.init.keep_alive",  
import java.util.Collection;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    logger.debug(() -> new ParameterizedMessage("Deleted PIT with IDs {}", successfulPitsStringBuilder.toString()));
         */
        timeValueSeconds(30),
import org.apache.logging.log4j.Logger;
        /*
                    Transport.Connection connection,
    void executeUpdatePitId(
            searchTransportService.getRemoteClusterService(),
                    .forEach(r -> failedPitsStringBuilder.append(r.getPitId()).append(","));  
import org.opensearch.cluster.metadata.ResolvedIndices;
                            createPITResponse.getId(),
            for (Map.Entry<ShardId, SearchContextIdForNode> entry : contextId.shards().entrySet()) {  
                    groupedActionListener.onFailure(
                        ActionListener.wrap(r -> searchPhaseResultActionListener.onResponse(r), searchPhaseResultActionListener::onFailure)
                    );
 * Phase 2 of create PIT : Update PIT reader context with PIT ID and keep alive from request and  
 * this file be licensed under the Apache-2.0 license or a
            createPitListener  
    }  
            System::nanoTime  
     * Updates PIT ID, keep alive and createdTime of PIT reader context
 * fail user request if any of the updates in this phase are failed - we clean up PITs in case of such failures.
         */
            searchResponse.getFailedShards(),  
        searchRequest.setCcsMinimizeRoundtrips(false);
        final Set<String> clusters = contextId.shards()  
 * SPDX-License-Identifier: Apache-2.0
        this.pitService = pitService;
import org.opensearch.core.action.ActionListener;
            creationTime,
            task.getType(),
        logger.debug(
                        e  
        SearchTask searchTask = searchRequest.createTask(  
                        () -> new ParameterizedMessage(
            task.getAction(),  
     * This method creates PIT reader context  
        transportSearchAction.executeRequest(  
        /*
    private final ClusterService clusterService;  
        ActionListener<CreatePitResponse> updatePitIdListener  
     */
    private final NamedWriteableRegistry namedWriteableRegistry;
        return transportSearchAction.resolveIndices(request.toSearchRequest());  
                        ),  
                createPITResponse,
                    );  
        this.searchTransportService = searchTransportService;
        SearchResponse searchResponse,
import org.opensearch.transport.Transport;  
        SearchContextId contextId = SearchContextId.decode(namedWriteableRegistry, createPITResponse.getId());  
                    logger.error(  
            public void onResponse(DeletePitResponse response) {  
        );
     * Cleanup all created PIT contexts in case of failure
        );
        final long relativeStartNanos = System.nanoTime();
                ) {  
import org.opensearch.action.support.GroupedActionListener;  
                            entry.getValue().getNode()
import org.opensearch.tasks.Task;
        pitService.deletePitContexts(nodeToContextsMap, deleteListener);
import org.opensearch.common.unit.TimeValue;
        SearchRequest searchRequest = request.toSearchRequest();
        NamedWriteableRegistry namedWriteableRegistry,
        }, updatePitIdListener::onFailure);
            .map(SearchContextIdForNode::getClusterAlias)
                }
import java.util.function.BiFunction;
public class CreatePitController {
        PitService pitService
                    .filter(r -> !r.isSuccessful())
                    );
                            searchResponse.pointInTimeId(),  
import org.opensearch.core.index.shard.ShardId;
                                + entry.getValue().getNode()  
            state,
        ClusterService clusterService,
        final StepListener<BiFunction<String, String, DiscoveryNode>> lookupListener = getConnectionLookupListener(contextId);
import org.opensearch.cluster.service.ClusterService;
import java.util.Collections;
    private static final Logger logger = LogManager.getLogger(CreatePitController.class);
    }  
    }
                @Override  
import org.opensearch.search.SearchShardTarget;
}
        Collection<SearchContextIdForNode> contexts
            .filter(ctx -> Strings.isEmpty(ctx.getClusterAlias()) == false)  
                        new OpenSearchException(  
            public void onFailure(final Exception e) {
        this.namedWriteableRegistry = namedWriteableRegistry;
        );
                if (node == null) {
    /**
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
                try {
                            "Create pit update phase for PIT ID [{}] failed " + "because node [{}] not found",
                    .stream()
                updatePitIdListener.onResponse(createPITResponse);
            }
                        new OpenSearchException(
                // this is invoke and forget call
                    groupedActionListener.onFailure(
    private void cleanupContexts(Collection<SearchContextIdForNode> contexts, String pitId) {  
                            "Create pit update phase for PIT ID [" + searchResponse.pointInTimeId() + "] failed on node[" + node + "]",
        lookupListener.whenComplete(nodelookup -> {
    /**
                    final StringBuilder successfulPitsStringBuilder = new StringBuilder();  
                        () -> new ParameterizedMessage(
    public CreatePitController(  
/*  
         */
        );
    /**  
                        new UpdatePitContextRequest(
                            e
        };
            );
                cleanupContexts(contexts, createPITResponse.getId());  
                    );  
                    node = this.clusterService.state().getNodes().get(entry.getValue().getNode());  
        ActionListener<DeletePitResponse> deleteListener = new ActionListener<>() {
          Phase 1 of create PIT
                    );
    ) {
                searchResponse.pointInTimeId()
        ActionListener<CreatePitResponse> updatePitIdListener,
import java.util.stream.Collectors;
import java.util.Set;  
        );  
        }, size);  
import org.opensearch.cluster.node.DiscoveryNode;  
                    SearchTask searchTask,
                        connection,
    private StepListener<BiFunction<String, String, DiscoveryNode>> getConnectionLookupListener(SearchContextId contextId) {
     * Creates PIT reader context with temporary keep alive  
    ) {  
    private final TransportSearchAction transportSearchAction;
        for (SearchContextIdForNode context : contexts) {  
import org.opensearch.common.inject.Inject;
                        )  
            searchResponse.getSuccessfulShards(),
import org.apache.logging.log4j.message.ParameterizedMessage;  
          not supported for point in time  
            @Override
                updatePitIdListener.onFailure(e);
    /**
 */  
        ClusterState state = clusterService.state();
    ) {  
     */
                        .forEach(r -> successfulPitsStringBuilder.append(r.getPitId()).append(","));
                }
            () -> new ParameterizedMessage("Executing creation of PIT context for indices [{}]", Arrays.toString(searchRequest.indices()))
                    logger.error(  
                            searchResponse.pointInTimeId(),  
package org.opensearch.action.search;
    }
                    searchTransportService.createPitContext(
        return (StepListener<BiFunction<String, String, DiscoveryNode>>) SearchUtils.getConnectionLookupListener(  
            searchRequest.getOrCreateAbsoluteStartMillis(),
                }  
import org.opensearch.cluster.ClusterState;
import java.util.Map;
        TransportSearchAction transportSearchAction,  
            final ActionListener<UpdatePitContextResponse> groupedActionListener = getGroupedListener(  
         */
 * compatible open source license.
        logger.debug(  
            },
                            request.getKeepAlive().millis(),
            @Override
        SearchRequest searchRequest,  
import org.opensearch.core.common.Strings;  
                            nodeName
            Collections.emptyMap()
            .values()
import org.opensearch.search.SearchPhaseResult;  
        );
                            entry.getValue().getSearchContextId(),  
            List<PitSearchContextIdForNode> contextIdsForNode = nodeToContextsMap.getOrDefault(context.getNode(), new ArrayList<>());
            )
          This is needed for cross cluster functionality to work with PITs and current ccsMinimizeRoundTrips is
 * The OpenSearch Contributors require contributions made to  
    public static final Setting<TimeValue> PIT_INIT_KEEP_ALIVE = Setting.positiveTimeSetting(
            .collect(Collectors.toSet());
            }
                        )  
                                + "] failed because node["
            }  
                "Updating PIT context with PIT ID [{}], creation time and keep alive",  
            updatePitIdListener::onFailure
        this.clusterService = clusterService;
    }
                }
                                + searchResponse.pointInTimeId()
    }
                                + "] "
     */
                            "Create pit update phase for PIT ID ["  
            task.getId(),
                    SearchShardTarget target,  
            .stream()
        Map<String, List<PitSearchContextIdForNode>> nodeToContextsMap = new HashMap<>();
        /*  
                    final Transport.Connection connection = searchTransportService.getConnection(entry.getValue().getClusterAlias(), node);
 *
            @Override
                    response.getDeletePitResults()
                logger.error("Cleaning up PIT contexts failed ", e);
                logger.warn(() -> new ParameterizedMessage("Failed to delete PIT IDs {}", failedPitsStringBuilder.toString()));
                            "Create pit update phase failed for PIT ID [{}] on node [{}]",
                    return;
        CreatePitRequest request,  
    private final PitService pitService;  
            relativeStartNanos,
                    ActionListener<SearchPhaseResult> searchPhaseResultActionListener
 * Controller for creating PIT reader context
                    searchTransportService.updatePitContext(  
import org.opensearch.common.settings.Setting;  
        /*
            nodeToContextsMap.put(context.getNode(), contextIdsForNode);  
        Setting.Property.NodeScope
                        .stream()
                contextId.shards().size(),  
                        connection,
                    );  
          store the create time ( same create time for all PIT contexts across shards ) to be used
import org.opensearch.action.StepListener;
                        new TransportCreatePitAction.CreateReaderContextRequest(  
        }
                } catch (Exception e) {
import java.util.Arrays;  
    @Inject
            searchRequest,
            task.getParentTaskId(),
            public void onFailure(Exception e) {
    );  
    ResolvedIndices resolveIndices(CreatePitRequest request) {
                if (logger.isDebugEnabled()) {
    void executeCreatePit(Task task, SearchRequest searchRequest, StepListener<SearchResponse> createPitListener) {
    }
                if (node == null) {
        final long creationTime = timeProvider.getAbsoluteStartMillis();
        StepListener<SearchResponse> createPitListener,
          for list PIT api  
import org.apache.logging.log4j.LogManager;
                response.getDeletePitResults()  
            }  
            new TransportSearchAction.SinglePhaseSearchAction() {
            task,
            contextIdsForNode.add(new PitSearchContextIdForNode(pitId, context));
                DiscoveryNode node = nodelookup.apply(entry.getValue().getClusterAlias(), entry.getValue().getNode());
        );
                contextId.shards().values()
                }  
import java.util.ArrayList;
            public void onResponse(final Collection<UpdatePitContextResponse> responses) {  
        );  
        CreatePitRequest request,
        CreatePitResponse createPITResponse = new CreatePitResponse(  
            searchResponse.pointInTimeId(),
            () -> new ParameterizedMessage(
                        ),
/**  
                final StringBuilder failedPitsStringBuilder = new StringBuilder();
                            PIT_INIT_KEEP_ALIVE.get(clusterService.getSettings())
                        .filter(r -> r.isSuccessful())  
          Phase 2 of create PIT where we update pit id in pit contexts  
                        searchTask,
 * Phase 1 of create PIT request : Create PIT reader contexts in the associated shards with a temporary keep alive
     */  
import java.util.List;
        createPitListener.whenComplete(
        CreatePitResponse createPITResponse,  
            searchResponse.getShardFailures()
            true,
    }  
        return new GroupedActionListener<>(new ActionListener<>() {
                            target.getShardId(),
                updatePitIdListener,
            @Override  
    ) {  
                                + "not found"
                        ),
    private final SearchTransportService searchTransportService;
        int size,
        SearchTransportService searchTransportService,
                    String nodeName = node.getName();
import org.opensearch.OpenSearchException;
        ActionListener<CreatePitResponse> updatePitIdListener
import java.util.HashMap;  
    public void executeCreatePit(
 */  
                public void executeOnShardTarget(
                        )
            searchResponse.getTotalShards(),  
