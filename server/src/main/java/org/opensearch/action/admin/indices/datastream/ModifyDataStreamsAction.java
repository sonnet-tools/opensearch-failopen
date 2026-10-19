     *
     */
    public static final String NAME = "indices:admin/data_stream/modify";
            return ThreadPool.Names.SAME;
            ActionRequestValidationException validationException = null;  
    @ExperimentalApi  
        }
            ThreadPool threadPool,  
            ActionFilters actionFilters,
            MetadataDataStreamsService metadataDataStreamsService  
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
import org.opensearch.action.support.TransportIndicesResolvingAction;  
            ClusterService clusterService,
        }
import java.io.IOException;
import java.util.Objects;
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.cluster.metadata.ResolvedIndices;
 * Applies a batch of {@link DataStreamAction} operations (add/remove backing index) to data-stream metadata atomically.
        }
            // Names are already concrete data stream and backing index names, matching Request#indices().  
package org.opensearch.action.admin.indices.datastream;
         */
import org.opensearch.transport.TransportService;  
            TransportIndicesResolvingAction<Request> {
        /**  
    /**  
        @Override
 * compatible open source license.
import org.opensearch.core.action.ActionListener;
        @Override
 *  
import static org.opensearch.action.ValidateActions.addValidationError;
 */
            return actions.stream().flatMap(action -> Stream.of(action.dataStream(), action.index())).distinct().toArray(String[]::new);
                validationException = addValidationError("at least one data stream action must be specified", validationException);
}
            IndexNameExpressionResolver indexNameExpressionResolver,
            super.writeTo(out);
        @Override
    public static final ModifyDataStreamsAction INSTANCE = new ModifyDataStreamsAction();  
    public static class Request extends AcknowledgedRequest<Request> implements IndicesRequest {
import org.opensearch.cluster.block.ClusterBlockException;
        }  
import org.opensearch.cluster.block.ClusterBlockLevel;  
        public int hashCode() {
                request.clusterManagerNodeTimeout(),
import java.util.ArrayList;  
        }
import java.util.List;
    }
        public Request(StreamInput in) throws IOException {  
            this.metadataDataStreamsService = metadataDataStreamsService;  
        @Override
            return Objects.hash(actions);
        @Override  
 *
     * Transport action for modifying data streams.
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
    }
 * @opensearch.experimental
            return actions;  
        }
                request.timeout()  
import java.util.stream.Stream;  
    }  
            }  
 * this file be licensed under the Apache-2.0 license or a
            out.writeList(actions);
        }
        }  
        @Inject
        }  
        public TransportAction(  
            ModifyDataStreamsClusterStateUpdateRequest updateRequest = new ModifyDataStreamsClusterStateUpdateRequest(  
     * @opensearch.internal  
        private final List<DataStreamAction> actions;  
        public ActionRequestValidationException validate() {
 */  
import org.opensearch.cluster.service.ClusterService;
            if (actions == null || actions.isEmpty()) {
import org.opensearch.core.common.io.stream.StreamInput;  
     * Request carrying the data-stream actions to apply.
import org.opensearch.common.annotation.ExperimentalApi;  
@ExperimentalApi  
 * SPDX-License-Identifier: Apache-2.0
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, AcknowledgedResponse>
        public ResolvedIndices resolveIndices(Request request) {
     *  
            metadataDataStreamsService.modifyDataStream(updateRequest, listener);
/*  
            super(in);
import org.opensearch.action.IndicesRequest;  
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.cluster.metadata.MetadataDataStreamsService;
        public List<DataStreamAction> getActions() {
import org.opensearch.threadpool.ThreadPool;
        super(NAME, AcknowledgedResponse::new);
        public IndicesOptions indicesOptions() {
import org.opensearch.cluster.metadata.MetadataDataStreamsService.ModifyDataStreamsClusterStateUpdateRequest;  
            return ResolvedIndices.of(request.indices());
        public boolean equals(Object o) {
        protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<AcknowledgedResponse> listener) {
        ) {
        @Override
import org.opensearch.cluster.ClusterState;
        public Request(List<DataStreamAction> actions) {
            TransportService transportService,
        protected String executor() {
            this.actions = new ArrayList<>(Objects.requireNonNull(actions, "actions must not be null"));  
        @Override  
    private ModifyDataStreamsAction() {  
        implements  
            if (o == null || getClass() != o.getClass()) return false;
     * @opensearch.experimental
            // Names are always concrete (data stream names and ".ds-" backing index names); no wildcard expansion.  
         * cluster action and could not restrict which data streams or indices a caller may modify.  
        }  
                request.getActions(),
        @Override
        @Override
import org.opensearch.action.support.ActionFilters;
        protected AcknowledgedResponse read(StreamInput in) throws IOException {  
        }
import org.opensearch.action.ActionType;
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
/**
        }
            this.actions = in.readList(DataStreamAction::new);
            return validationException;
     */
            if (this == o) return true;  
 * The OpenSearch Contributors require contributions made to  
            super(NAME, transportService, clusterService, threadPool, actionFilters, Request::new, indexNameExpressionResolver);
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
         * authorization can be enforced. Without this, the security layer would evaluate the request as a bare
import org.opensearch.common.inject.Inject;
        }
        public void writeTo(StreamOutput out) throws IOException {  
            );
        }  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            return actions.equals(request.actions);  
         * Exposes every data stream and backing index referenced by this request's actions so that index-level
public class ModifyDataStreamsAction extends ActionType<AcknowledgedResponse> {
        public String[] indices() {  
        }
    /**
            return IndicesOptions.fromOptions(false, true, true, true, false, false, true, false);
        @Override
        private final MetadataDataStreamsService metadataDataStreamsService;  
            return new AcknowledgedResponse(in);
            Request request = (Request) o;
import org.opensearch.action.ActionRequestValidationException;
