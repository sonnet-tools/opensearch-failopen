        );
            }
import org.opensearch.tasks.Task;
         */
    public static final Setting<TimeValue> PIT_INIT_KEEP_ALIVE = Setting.positiveTimeSetting(
                    );
    }
 * fail user request if any of the updates in this phase are failed - we clean up PITs in case of such failures.
    private StepListener<BiFunction<String, String, DiscoveryNode>> getConnectionLookupListener(SearchContextId contextId) {
            updatePitIdListener::onFailure
            creationTime,
    }
        ActionListener<CreatePitResponse> updatePitIdListener,
    /**
public class CreatePitController {
                    );
        );
        Setting.Property.NodeScope
                                + "] failed because node["
}
        );
        pitService.deletePitContexts(nodeToContextsMap, deleteListener);
            final ActionListener<UpdatePitContextResponse> groupedActionListener = getGroupedListener(
                    logger.error(
        logger.debug(
import org.opensearch.action.support.GroupedActionListener;
    public CreatePitController(
                        connection,
                            creationTime
import org.opensearch.cluster.node.DiscoveryNode;
                    groupedActionListener.onFailure(
                    searchTransportService.createPitContext(
            for (Map.Entry<ShardId, SearchContextIdForNode> entry : contextId.shards().entrySet()) {
                        searchTask,
import org.opensearch.transport.Transport;
                logger.warn(() -> new ParameterizedMessage("Failed to delete PIT IDs {}", failedPitsStringBuilder.toString()));
                        groupedActionListener
 * compatible open source license.
    ResolvedIndices resolveIndices(CreatePitRequest request) {
            clusters
        SearchRequest searchRequest,
import java.util.Collection;
        /*
import org.opensearch.core.action.ActionListener;
            System::nanoTime
        this.namedWriteableRegistry = namedWriteableRegistry;
    ) {
                if (logger.isDebugEnabled()) {
        searchRequest.setCcsMinimizeRoundtrips(false);
            .stream()
                    );
                            e
                        new OpenSearchException(
import java.util.HashMap;
            .map(SearchContextIdForNode::getClusterAlias)
        SearchTask searchTask = searchRequest.createTask(
        final long creationTime = timeProvider.getAbsoluteStartMillis();
                public void executeOnShardTarget(
                    logger.debug(() -> new ParameterizedMessage("Deleted PIT with IDs {}", successfulPitsStringBuilder.toString()));
            List<PitSearchContextIdForNode> contextIdsForNode = nodeToContextsMap.getOrDefault(context.getNode(), new ArrayList<>());
            relativeStartNanos,
import org.apache.logging.log4j.message.ParameterizedMessage;
        );
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
/**
            () -> new ParameterizedMessage(
    ) {
            searchResponse.getSkippedShards(),
     * Creates PIT reader context with temporary keep alive
        TransportSearchAction transportSearchAction,
            .values()
        return (StepListener<BiFunction<String, String, DiscoveryNode>>) SearchUtils.getConnectionLookupListener(
    );
                }
package org.opensearch.action.search;
        CreatePitRequest request,
                            "Create pit update phase for PIT ID [" + searchResponse.pointInTimeId() + "] failed on node[" + node + "]",
            public void onResponse(final Collection<UpdatePitContextResponse> responses) {
import java.util.stream.Collectors;
                logger.error("Cleaning up PIT contexts failed ", e);
                        new OpenSearchException(
import java.util.Collections;
import org.opensearch.common.unit.TimeValue;
    ) {
                final StringBuilder failedPitsStringBuilder = new StringBuilder();
import org.opensearch.core.index.shard.ShardId;
                ) {
            @Override
                    ActionListener<SearchPhaseResult> searchPhaseResultActionListener
    /**
import org.opensearch.cluster.ClusterState;
            new TransportSearchAction.SinglePhaseSearchAction() {
        for (SearchContextIdForNode context : contexts) {
                    searchTransportService.updatePitContext(
                contextId.shards().values()
        final Set<String> clusters = contextId.shards()
                                + searchResponse.pointInTimeId()
                createPITResponse,
                    .filter(r -> !r.isSuccessful())
     */
                    logger.error(
        int size,
        );
            public void onFailure(final Exception e) {
                                + entry.getValue().getNode()
        SearchTransportService searchTransportService,
    void executeUpdatePitId(
            );
                        ActionListener.wrap(r -> searchPhaseResultActionListener.onResponse(r), searchPhaseResultActionListener::onFailure)
        executeCreatePit(searchTask, searchRequest, createPitListener);
        }
            searchResponse.pointInTimeId(),
    }
            task.getId(),
            @Override
import java.util.Set;
         */
        "point_in_time.init.keep_alive",
import org.opensearch.common.settings.Setting;
        Collection<SearchContextIdForNode> contexts
 *
 * Controller for creating PIT reader context
                    final StringBuilder successfulPitsStringBuilder = new StringBuilder();
        );
    private final SearchTransportService searchTransportService;
                }
                        .stream()
        timeValueSeconds(30),
                }
            @Override
            }
            createPitListener
 */
        CreatePitResponse createPITResponse,
    private final ClusterService clusterService;
                    String nodeName = node.getName();
                        () -> new ParameterizedMessage(
 * This two phase approach is used to save PIT ID as part of context which is later used for other use cases like list PIT etc.
                    .stream()
        logger.debug(
                    final Transport.Connection connection = searchTransportService.getConnection(entry.getValue().getClusterAlias(), node);
                    groupedActionListener.onFailure(
            .filter(ctx -> Strings.isEmpty(ctx.getClusterAlias()) == false)
        SearchRequest searchRequest = request.toSearchRequest();
    }
        createPitListener.whenComplete(
     * Cleanup all created PIT contexts in case of failure
    public void executeCreatePit(
                updatePitIdListener,
        ClusterService clusterService,
                @Override
        SearchContextId contextId = SearchContextId.decode(namedWriteableRegistry, createPITResponse.getId());
import org.opensearch.search.SearchPhaseResult;
        /*
    /**
                                + "] "
        this.clusterService = clusterService;
                        )
        this.searchTransportService = searchTransportService;
            public void onResponse(DeletePitResponse response) {
                        .forEach(r -> successfulPitsStringBuilder.append(r.getPitId()).append(","));
     * Updates PIT ID, keep alive and createdTime of PIT reader context
          This is needed for cross cluster functionality to work with PITs and current ccsMinimizeRoundTrips is
                    );
    }
            searchTransportService.getRemoteClusterService(),
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
                        () -> new ParameterizedMessage(
    private final TransportSearchAction transportSearchAction;
        }, size);
import org.opensearch.action.StepListener;
        final long relativeStartNanos = System.nanoTime();
            }
        Map<String, List<PitSearchContextIdForNode>> nodeToContextsMap = new HashMap<>();
            task.getParentTaskId(),
        NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.OpenSearchException;
    }
     */
            .collect(Collectors.toSet());
            searchRequest,
            searchRequest.getOrCreateAbsoluteStartMillis(),
        SearchResponse searchResponse,
        /*
                            searchResponse.pointInTimeId(),
          Phase 1 of create PIT
                        ),
                    );
import java.util.ArrayList;
    private void cleanupContexts(Collection<SearchContextIdForNode> contexts, String pitId) {
        ActionListener<CreatePitResponse> updatePitIdListener
                            "Create pit update phase for PIT ID ["
            searchResponse.getFailedShards(),
    private final PitService pitService;
                if (node == null) {
          for list PIT api
                                + "not found"
                searchResponse.pointInTimeId()
            state,
                updatePitIdListener.onResponse(createPITResponse);
                cleanupContexts(contexts, createPITResponse.getId());
import java.util.List;
        }, updatePitIdListener::onFailure);
 * Phase 2 of create PIT : Update PIT reader context with PIT ID and keep alive from request and
                        ),
        transportSearchAction.executeRequest(
        );
            },
        ClusterState state = clusterService.state();
                DiscoveryNode node = nodelookup.apply(entry.getValue().getClusterAlias(), entry.getValue().getNode());
            TransportCreatePitAction.CREATE_PIT_ACTION,
        };
                        connection,
                            nodeName
        ActionListener<CreatePitResponse> updatePitIdListener
            public void onFailure(Exception e) {
        PitService pitService
                        ),
            nodeToContextsMap.put(context.getNode(), contextIdsForNode);
        this.transportSearchAction = transportSearchAction;
                } catch (Exception e) {
            task,
    /**
            searchResponse.getTotalShards(),
 * SPDX-License-Identifier: Apache-2.0
     */
import org.opensearch.cluster.metadata.ResolvedIndices;
        );
                    Transport.Connection connection,
                "Updating PIT context with PIT ID [{}], creation time and keep alive",
                        .filter(r -> r.isSuccessful())
            }
            task.getAction(),
import java.util.Map;
                        new TransportCreatePitAction.CreateReaderContextRequest(
        Task task,
            () -> new ParameterizedMessage("Executing creation of PIT context for indices [{}]", Arrays.toString(searchRequest.indices()))
    private static final Logger logger = LogManager.getLogger(CreatePitController.class);
                    node = this.clusterService.state().getNodes().get(entry.getValue().getNode());
                    return;
                try {
                // this is invoke and forget call
import org.opensearch.search.SearchShardTarget;
import org.opensearch.common.inject.Inject;
                }
          not supported for point in time
         */
import org.opensearch.core.common.Strings;
                    SearchShardTarget target,
                            entry.getValue().getNode()
            Collections.emptyMap()
            searchResponse.getShardFailures()
    }
                            "Create pit update phase failed for PIT ID [{}] on node [{}]",
 * this file be licensed under the Apache-2.0 license or a
                    .forEach(r -> failedPitsStringBuilder.append(r.getPitId()).append(","));
    ) {
        this.pitService = pitService;
                        )
/*
                            createPITResponse.getId(),
                    );
 */
          Phase 2 of create PIT where we update pit id in pit contexts
                if (node == null) {
            )
            @Override
                            request.getKeepAlive().millis(),
    void executeCreatePit(Task task, SearchRequest searchRequest, StepListener<SearchResponse> createPitListener) {
                            target.getShardId(),
 * The OpenSearch Contributors require contributions made to
import java.util.function.BiFunction;
     * This method creates PIT reader context
                }
                        new UpdatePitContextRequest(
                        e
        CreatePitRequest request,
                    SearchTask searchTask,
            contextIdsForNode.add(new PitSearchContextIdForNode(pitId, context));
        /*
        return transportSearchAction.resolveIndices(request.toSearchRequest());
    private ActionListener<UpdatePitContextResponse> getGroupedListener(
        ActionListener<DeletePitResponse> deleteListener = new ActionListener<>() {
        lookupListener.whenComplete(nodelookup -> {
                    response.getDeletePitResults()
 * Phase 1 of create PIT request : Create PIT reader contexts in the associated shards with a temporary keep alive
                        )
    private final NamedWriteableRegistry namedWriteableRegistry;
                contextId.shards().size(),
        StepListener<SearchResponse> createPitListener,
                            "Create pit update phase for PIT ID [{}] failed " + "because node [{}] not found",
            searchResponse.getSuccessfulShards(),
        return new GroupedActionListener<>(new ActionListener<>() {
import org.apache.logging.log4j.Logger;
                            entry.getValue().getSearchContextId(),
         */
          store the create time ( same create time for all PIT contexts across shards ) to be used
                            PIT_INIT_KEEP_ALIVE.get(clusterService.getSettings())
            }
                updatePitIdListener.onFailure(e);
import org.opensearch.cluster.service.ClusterService;
            searchResponse -> { executeUpdatePitId(request, searchRequest, searchResponse, updatePitIdListener); },
            true,
                response.getDeletePitResults()
        final StepListener<BiFunction<String, String, DiscoveryNode>> lookupListener = getConnectionLookupListener(contextId);
    @Inject
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
            task.getType(),
     */
        CreatePitResponse createPITResponse = new CreatePitResponse(
import org.apache.logging.log4j.LogManager;
    }
                            searchResponse.pointInTimeId(),
import java.util.Arrays;
