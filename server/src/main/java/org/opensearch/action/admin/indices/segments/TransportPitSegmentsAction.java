        return new PitSegmentsRequest(in);
import org.opensearch.search.SearchService;  
import java.util.stream.Collectors;
            builder.field("pit_id", pitId);
    }
        }
            clusterService,
     * @param request         the underlying request  
import org.opensearch.action.search.PitService;
                            null,
        return new PlainShardsIterator(iterators);
        }  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.service.ClusterService;
    public OptionallyResolvedIndices resolveIndices(PitSegmentsRequest request) {  
        int totalShards,
package org.opensearch.action.admin.indices.segments;
            totalShards,
import org.opensearch.cluster.routing.RecoverySource;
    public TransportPitSegmentsAction(
                allocationId,  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.metadata.ResolvedIndices;
            UnassignedInfo unassignedInfo,  
            actionFilters,
            return builder.endObject();
    }
    }
                            null,
            for (Map.Entry<ShardId, SearchContextIdForNode> entry : searchContext.shards().entrySet()) {
import org.opensearch.core.index.shard.ShardId;  
                        new PitAwareShardRouting(
        NamedWriteableRegistry namedWriteableRegistry,  
            PitSegmentsRequest::new,  
            results.toArray(new ShardSegments[0]),
        this.indicesService = indicesService;
    /**
import org.opensearch.indices.IndicesService;
            failedShards,
                state,  
 * this file be licensed under the Apache-2.0 license or a
            indexNameExpressionResolver,
                expectedShardSize
    @Override
                if (Strings.isEmpty(perNode.getClusterAlias())) {
        SearchService searchService,
        Set<String> uniquePitIds = new LinkedHashSet<>(request.getPitIds());
 * Transport action for retrieving segment information of PITs  
            }  
        }
import org.opensearch.core.action.ActionListener;  
/**
                super.doExecute(task, request, listener);
            ShardRoutingState state,
        }
            super(in);  
    @Override  
        private final String pitId;  
        public PitAwareShardRouting(StreamInput in) throws IOException {
        );
        this.namedWriteableRegistry = namedWriteableRegistry;  
        assert shardRouting instanceof PitAwareShardRouting;
            pitService.getAllPits(ActionListener.wrap(response -> {
            return new ShardSegments(shardRouting, Collections.emptyList());
    }
import org.opensearch.action.search.ListPitInfo;  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
import org.opensearch.cluster.routing.PlainShardsIterator;
        }
                            pitId,
        // remove duplicates from the request  
import org.opensearch.action.support.ActionFilters;
        IndexNameExpressionResolver indexNameExpressionResolver,
                recoverySource,
    private final PitService pitService;
            long expectedShardSize
            this.pitId = pitId;  
                request.clearAndSetPitIds(response.getPitInfos().stream().map(ListPitInfo::getPitId).collect(Collectors.toList()));  
    protected ClusterBlockException checkRequestBlock(ClusterState state, PitSegmentsRequest countRequest, String[] concreteIndices) {
        this.transportService = transportService;
            super.doExecute(task, request, listener);
                    iterators.add(  
        List<DefaultShardOperationFailedException> shardFailures,  
    /**
                        )  
            shardFailures
import org.opensearch.transport.TransportService;
        }  
        PitService pitService
                            null,  
    protected ShardsIterator shards(ClusterState clusterState, PitSegmentsRequest request, String[] concreteIndices) {
    private boolean isAllPitsRequest(PitSegmentsRequest request) {
            successfulShards,  
                relocatingNodeId,
            boolean primary,  
 * The OpenSearch Contributors require contributions made to  
                    );
            .get(shardRouting.shardId());
            PitSegmentsAction.NAME,
public class TransportPitSegmentsAction extends TransportBroadcastByNodeAction<PitSegmentsRequest, IndicesSegmentResponse, ShardSegments> {
}
        TransportService transportService,
        PitReaderContext pitReaderContext = searchService.getPitReaderContext(searchContextIdForNode.getSearchContextId());  
                    final ShardId shardId = entry.getKey();
    }  
    @Override  
        PitSegmentsRequest request,
        public PitAwareShardRouting(
    }  
        } else {  
        @Override
            String currentNodeId,
    protected ShardSegments shardOperation(PitSegmentsRequest request, ShardRouting shardRouting) {
 */  
import org.opensearch.cluster.routing.UnassignedInfo;  
    protected void doExecute(Task task, PitSegmentsRequest request, ActionListener<IndicesSegmentResponse> listener) {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        if (isAllPitsRequest(request)) {
                final SearchContextIdForNode perNode = entry.getValue();
import java.util.List;
            return pitId;
     * This retrieves segment details of PIT context
    /**
    protected PitSegmentsRequest readRequestFrom(StreamInput in) throws IOException {
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.common.inject.Inject;
        ) {  
import org.opensearch.cluster.block.ClusterBlockLevel;
 */
        IndicesService indicesService,
     * This holds PIT id which is used to perform broadcast operation in PIT shards to retrieve segments information
                            ShardRoutingState.STARTED,
            super(
     */
                primary,
            ShardId shardId,  
        int failedShards,
        ActionFilters actionFilters,  
            transportService,  
                            -1L
                unassignedInfo,
    @Override
/*  
import org.opensearch.cluster.routing.ShardRoutingState;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
        List<ShardSegments> results,
 * SPDX-License-Identifier: Apache-2.0
    ) {
    private final TransportService transportService;
 * compatible open source license.
                            true,  
    }  
 *
        PitAwareShardRouting pitAwareShardRouting = (PitAwareShardRouting) shardRouting;  
                shardId,
            }, listener::onFailure));
     * Execute PIT segments flow for all PITs or request PIT IDs  
     */
    }  
            this.pitId = in.readString();
     * @param shardRouting the shard on which to execute the operation
            String pitId,
                currentNodeId,  
        }
    ) {
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.cluster.routing.ShardsIterator;
    private final IndicesService indicesService;
            return ResolvedIndices.of(this.pitService.getIndicesForPitsFlat(request.getPitIds()));
        this.pitService = pitService;
        @Override
    @Override
import java.util.Map;
            ThreadPool.Names.MANAGEMENT
            out.writeString(pitId);
        }
        ClusterService clusterService,  
        );  
    protected ShardSegments readShardResult(StreamInput in) throws IOException {
import org.opensearch.action.search.SearchContextId;
    @Inject
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.opensearch.cluster.ClusterState;  
     */  
import org.opensearch.cluster.routing.ShardRouting;  
    @Override
    private final ClusterService clusterService;  
import java.util.ArrayList;
                // check if node is part of local cluster  
        if (pitReaderContext == null) {
            String relocatingNodeId,
        }
import org.opensearch.tasks.Task;
import org.opensearch.action.search.SearchContextIdForNode;  
        super(  
        final ArrayList<ShardRouting> iterators = new ArrayList<>();
                }
        if (isAllPitsRequest(request)) {
            );
    public class PitAwareShardRouting extends ShardRouting {
        return new ShardSegments(pitReaderContext.getShardRouting(), pitReaderContext.getSegments());
    }  
     * @param clusterState    the cluster state
import org.opensearch.core.common.Strings;
import org.opensearch.cluster.routing.AllocationId;  
     * @param concreteIndices the concrete indices on which to execute the operation
                            null,
        this.clusterService = clusterService;  
     */
            RecoverySource recoverySource,
    protected IndicesSegmentResponse newResponse(  
        SearchContextIdForNode searchContextIdForNode = decode(namedWriteableRegistry, pitAwareShardRouting.getPitId()).shards()
    }
        return new ShardSegments(in);
    @Override  
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
        public String getPitId() {  
import org.opensearch.core.xcontent.XContentBuilder;
        this.searchService = searchService;
            AllocationId allocationId,
import org.opensearch.search.internal.PitReaderContext;
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
            SearchContextId searchContext = decode(namedWriteableRegistry, pitId);  
import java.io.IOException;  
        for (String pitId : uniquePitIds) {
    public List<ShardRouting> getShardRoutingsFromInputStream(StreamInput in) throws IOException {  
import java.util.LinkedHashSet;  
    @Override  
import static org.opensearch.action.search.SearchContextId.decode;  
import org.opensearch.cluster.block.ClusterBlockException;
    }  
        int successfulShards,  
            return ResolvedIndices.unknown();
    @Override
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);  
import java.util.Collections;
            super.writeTo(out);  
            super.toXContent(builder, params);  
    protected ClusterBlockException checkGlobalBlock(ClusterState state, PitSegmentsRequest request) {  
     * @param request      the node-level request  
        return request.getPitIds().size() == 1 && "_all".equals(request.getPitIds().get(0));  
        ClusterState clusterState
import java.util.Set;  
    private final NamedWriteableRegistry namedWriteableRegistry;  
     * This adds list of shards on which we need to retrieve pit segments details
    /**  
        return new IndicesSegmentResponse(  
        return in.readList(PitAwareShardRouting::new);
                            perNode.getNode(),
    private final SearchService searchService;
                            shardId,  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        } else {  
