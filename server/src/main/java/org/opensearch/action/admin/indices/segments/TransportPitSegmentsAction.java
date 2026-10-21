        ActionFilters actionFilters,
            return ResolvedIndices.unknown();
                            null,
    protected ClusterBlockException checkGlobalBlock(ClusterState state, PitSegmentsRequest request) {
     * @param clusterState    the cluster state
     * @param request         the underlying request
import org.opensearch.action.search.SearchContextId;
        this.searchService = searchService;
            super(in);
        }
            totalShards,
     */
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.ShardRoutingState;
        return new ShardSegments(in);
import org.opensearch.common.inject.Inject;
     */
    protected ShardSegments shardOperation(PitSegmentsRequest request, ShardRouting shardRouting) {
            PitSegmentsAction.NAME,
 *
                shardId,
     * @param request      the node-level request
        if (isAllPitsRequest(request)) {
     */
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);
    @Override
        this.pitService = pitService;
                            -1L
        PitService pitService
        );
    }
 * this file be licensed under the Apache-2.0 license or a
            shardFailures
 */
            this.pitId = pitId;
    @Override
 * compatible open source license.
        this.indicesService = indicesService;
                            pitId,
            this.pitId = in.readString();
        if (pitReaderContext == null) {
            return new ShardSegments(shardRouting, Collections.emptyList());
     * Execute PIT segments flow for all PITs or request PIT IDs
                recoverySource,
    public OptionallyResolvedIndices resolveIndices(PitSegmentsRequest request) {
    }
        IndexNameExpressionResolver indexNameExpressionResolver,
            clusterService,
import org.opensearch.cluster.routing.RecoverySource;
        int successfulShards,
 */
import org.opensearch.core.common.Strings;
        NamedWriteableRegistry namedWriteableRegistry,
                // check if node is part of local cluster
    @Override
     * @param concreteIndices the concrete indices on which to execute the operation
                    final ShardId shardId = entry.getKey();
    @Override
        return new PlainShardsIterator(iterators);
                unassignedInfo,
        int failedShards,
        TransportService transportService,
import org.opensearch.action.search.SearchContextIdForNode;
    }
        List<DefaultShardOperationFailedException> shardFailures,
        }
        return request.getPitIds().size() == 1 && "_all".equals(request.getPitIds().get(0));
            SearchContextId searchContext = decode(namedWriteableRegistry, pitId);
     * This holds PIT id which is used to perform broadcast operation in PIT shards to retrieve segments information
        int totalShards,
    @Override
    }
                        )
        } else {
    public TransportPitSegmentsAction(
    @Override
                state,
            RecoverySource recoverySource,
                            ShardRoutingState.STARTED,
            indexNameExpressionResolver,
    }
import org.opensearch.action.search.PitService;
import org.opensearch.cluster.metadata.ResolvedIndices;
        PitAwareShardRouting pitAwareShardRouting = (PitAwareShardRouting) shardRouting;
    private final ClusterService clusterService;
    @Inject
import java.util.Map;
    /**
        final ArrayList<ShardRouting> iterators = new ArrayList<>();
        return in.readList(PitAwareShardRouting::new);
            for (Map.Entry<ShardId, SearchContextIdForNode> entry : searchContext.shards().entrySet()) {
            String pitId,
        @Override
            pitService.getAllPits(ActionListener.wrap(response -> {
        PitSegmentsRequest request,
        // remove duplicates from the request
        ClusterState clusterState
import org.opensearch.cluster.service.ClusterService;
        IndicesService indicesService,
        public void writeTo(StreamOutput out) throws IOException {
            super.toXContent(builder, params);
            ShardId shardId,
            String currentNodeId,
            successfulShards,
    }
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
import org.opensearch.core.index.shard.ShardId;
            super.doExecute(task, request, listener);
            boolean primary,
            PitSegmentsRequest::new,
            actionFilters,
        this.clusterService = clusterService;
import org.opensearch.cluster.routing.ShardRouting;
import java.util.List;
        }
     * This retrieves segment details of PIT context
import java.util.ArrayList;
import java.util.Collections;
    @Override
                request.clearAndSetPitIds(response.getPitInfos().stream().map(ListPitInfo::getPitId).collect(Collectors.toList()));
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
                            null,
            return pitId;
            return ResolvedIndices.of(this.pitService.getIndicesForPitsFlat(request.getPitIds()));
            );
import java.util.LinkedHashSet;
        @Override
        );
/*
import java.util.stream.Collectors;
        return new IndicesSegmentResponse(
                    iterators.add(
        ClusterService clusterService,
    private final PitService pitService;
        if (isAllPitsRequest(request)) {
    ) {
        assert shardRouting instanceof PitAwareShardRouting;
    private final TransportService transportService;
import org.opensearch.cluster.block.ClusterBlockException;
        ) {
        return new PitSegmentsRequest(in);
            long expectedShardSize
import org.opensearch.indices.IndicesService;
                            null,
import org.opensearch.tasks.Task;
/**
                allocationId,
    public class PitAwareShardRouting extends ShardRouting {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
     */
    private final IndicesService indicesService;
        PitReaderContext pitReaderContext = searchService.getPitReaderContext(searchContextIdForNode.getSearchContextId());
                            shardId,
    public List<ShardRouting> getShardRoutingsFromInputStream(StreamInput in) throws IOException {
}
                currentNodeId,
                super.doExecute(task, request, listener);
            }, listener::onFailure));
            super(
            .get(shardRouting.shardId());
        }
import org.opensearch.cluster.routing.UnassignedInfo;
            results.toArray(new ShardSegments[0]),
import org.opensearch.cluster.routing.PlainShardsIterator;
    @Override
                            perNode.getNode(),
    /**
import org.opensearch.cluster.block.ClusterBlockLevel;
    private boolean isAllPitsRequest(PitSegmentsRequest request) {
                        new PitAwareShardRouting(
    private final NamedWriteableRegistry namedWriteableRegistry;
    }
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
    protected ClusterBlockException checkRequestBlock(ClusterState state, PitSegmentsRequest countRequest, String[] concreteIndices) {
                            true,
                            null,
    }
     * @param shardRouting the shard on which to execute the operation
        SearchContextIdForNode searchContextIdForNode = decode(namedWriteableRegistry, pitAwareShardRouting.getPitId()).shards()
                    );
 * The OpenSearch Contributors require contributions made to
                }
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.threadpool.ThreadPool;
        }
        Set<String> uniquePitIds = new LinkedHashSet<>(request.getPitIds());
            transportService,
            String relocatingNodeId,
            ThreadPool.Names.MANAGEMENT
        for (String pitId : uniquePitIds) {
            return builder.endObject();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.transportService = transportService;
    /**
public class TransportPitSegmentsAction extends TransportBroadcastByNodeAction<PitSegmentsRequest, IndicesSegmentResponse, ShardSegments> {
    protected ShardSegments readShardResult(StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            out.writeString(pitId);
            ShardRoutingState state,
    @Override
            AllocationId allocationId,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                final SearchContextIdForNode perNode = entry.getValue();
    }
        public String getPitId() {
        }
import java.io.IOException;
    @Override
        } else {
    }
import org.opensearch.cluster.routing.AllocationId;
    protected PitSegmentsRequest readRequestFrom(StreamInput in) throws IOException {
        }
import org.opensearch.search.SearchService;
            builder.field("pit_id", pitId);
    }
                if (Strings.isEmpty(perNode.getClusterAlias())) {
    /**
            UnassignedInfo unassignedInfo,
        }
import org.opensearch.core.xcontent.XContentBuilder;
        public PitAwareShardRouting(StreamInput in) throws IOException {
    protected IndicesSegmentResponse newResponse(
        this.namedWriteableRegistry = namedWriteableRegistry;
import java.util.Set;
                expectedShardSize
    }
import org.opensearch.core.action.ActionListener;
                relocatingNodeId,
            }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.routing.ShardsIterator;
        super(
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
    protected ShardsIterator shards(ClusterState clusterState, PitSegmentsRequest request, String[] concreteIndices) {
            failedShards,
     * This adds list of shards on which we need to retrieve pit segments details
        }
        private final String pitId;
        return new ShardSegments(pitReaderContext.getShardRouting(), pitReaderContext.getSegments());
        SearchService searchService,
                primary,
    }
import org.opensearch.transport.TransportService;
import static org.opensearch.action.search.SearchContextId.decode;
    private final SearchService searchService;
import org.opensearch.action.search.ListPitInfo;
package org.opensearch.action.admin.indices.segments;
    ) {
 * Transport action for retrieving segment information of PITs
    protected void doExecute(Task task, PitSegmentsRequest request, ActionListener<IndicesSegmentResponse> listener) {
        List<ShardSegments> results,
import org.opensearch.search.internal.PitReaderContext;
import org.opensearch.action.support.ActionFilters;
        public PitAwareShardRouting(
            super.writeTo(out);
