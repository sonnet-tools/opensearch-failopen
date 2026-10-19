            );
import org.opensearch.core.common.io.stream.StreamInput;  
                    "PIT creation failed while updating PIT ID for indices [{}]",
            super(in);  
    public static class CreateReaderContextRequest extends TransportRequest {  
import org.opensearch.cluster.metadata.ResolvedIndices;  
    @Override
        @Override
            return keepAlive;
        createPitController.executeCreatePit(request, task, createPitListener, updatePitIdListener);
import org.opensearch.cluster.service.ClusterService;
    private final SearchTransportService searchTransportService;  
        this.transportSearchAction = transportSearchAction;
        }
        }
                    Arrays.toString(request.indices())
            listener.onFailure(e);
 */  
        super(CreatePitAction.NAME, transportService, actionFilters, in -> new CreatePitRequest(in));
    }
    private final TransportSearchAction transportSearchAction;
            logger.error(
    private final NamedWriteableRegistry namedWriteableRegistry;  
import org.opensearch.transport.TransportService;
    }
    public TransportCreatePitAction(
        this.transportService = transportService;
    /**  
    /**
                )  
        this.createPitController = createPitController;
            contextId = new ShardSearchContextId(in);
 *
    public static class CreateReaderContextResponse extends SearchPhaseResult {
            this.shardId = shardId;
import org.opensearch.transport.TransportRequest;  
            this.keepAlive = in.readTimeValue();
        }  
            contextId.writeTo(out);
}  
import org.opensearch.common.inject.Inject;
import org.opensearch.common.unit.TimeValue;  
        TransportService transportService,
        ClusterService clusterService,
        }
public class TransportCreatePitAction extends HandledTransportAction<CreatePitRequest, CreatePitResponse>  
        TransportSearchAction transportSearchAction,  
import org.opensearch.action.support.TransportIndicesResolvingAction;
     * Create pit reader context response which holds the contextId
    @Inject  
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
    }
        public ShardId getShardId() {  
    private final ClusterService clusterService;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        private final TimeValue keepAlive;
        }
    public ResolvedIndices resolveIndices(CreatePitRequest request) {
     */
        final StepListener<SearchResponse> createPitListener = new StepListener<>();  
        });  
    private final TransportService transportService;
import org.opensearch.action.support.ActionFilters;  
        public CreateReaderContextRequest(ShardId shardId, TimeValue keepAlive) {
    }
/**  
    protected void doExecute(Task task, CreatePitRequest request, ActionListener<CreatePitResponse> listener) {
        private final ShardId shardId;
        CreatePitController createPitController
import org.opensearch.search.SearchPhaseResult;  
    @Override
import org.opensearch.search.internal.ShardSearchContextId;
            super.writeTo(out);
        this.clusterService = clusterService;
        return createPitController.resolveIndices(request);  
            super(in);
            this.contextId = shardSearchContextId;  
import org.opensearch.core.action.ActionListener;
 */
 * this file be licensed under the Apache-2.0 license or a
     */  
 * Transport action for creating PIT reader context
            shardId.writeTo(out);
import java.io.IOException;  
        NamedWriteableRegistry namedWriteableRegistry,
    implements
        ActionFilters actionFilters,  
/*  
 * The OpenSearch Contributors require contributions made to  
    public static final String CREATE_PIT_ACTION = "create_pit";
        public void writeTo(StreamOutput out) throws IOException {  
        SearchTransportService searchTransportService,
        TransportIndicesResolvingAction<CreatePitRequest> {
import org.opensearch.action.support.HandledTransportAction;
        }  
package org.opensearch.action.search;
            return shardId;
import org.apache.logging.log4j.message.ParameterizedMessage;
            this.shardId = new ShardId(in);
    private final CreatePitController createPitController;
        @Override
import org.opensearch.core.index.shard.ShardId;
        public TimeValue getKeepAlive() {
        final ActionListener<CreatePitResponse> updatePitIdListener = ActionListener.wrap(r -> listener.onResponse(r), e -> {
        public CreateReaderContextResponse(ShardSearchContextId shardSearchContextId) {
    }
        public CreateReaderContextRequest(StreamInput in) throws IOException {
        }  
import org.opensearch.tasks.Task;
            super.writeTo(out);
        public void writeTo(StreamOutput out) throws IOException {  
     * Request to create pit reader context with keep alive
            this.keepAlive = keepAlive;  
                () -> new ParameterizedMessage(  
        this.namedWriteableRegistry = namedWriteableRegistry;  
        }  
        this.searchTransportService = searchTransportService;  
            out.writeTimeValue(keepAlive);  
 * compatible open source license.
import java.util.Arrays;
    ) {  
import org.opensearch.action.StepListener;
        public CreateReaderContextResponse(StreamInput in) throws IOException {  
