    private static final Logger logger = LogManager.getLogger(TransportPutIndexFieldDomainsAction.class);
        return new AcknowledgedResponse(in);
import org.apache.logging.log4j.LogManager;
        }  
        if (request.targetIndex() == null) {
    AcknowledgedResponse> implements TransportIndicesResolvingAction<PutIndexFieldDomainsRequest> {  
import org.opensearch.action.support.TransportIndicesResolvingAction;
        this.fieldDomainService = fieldDomainService;
    ) {
            }
            .clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
import org.opensearch.cluster.ClusterState;
            @Override
        );
    }  
 * SPDX-License-Identifier: Apache-2.0
                logger.debug(() -> new ParameterizedMessage("failed to publish field domains for index [{}]", request.targetIndex()), e);  
import org.opensearch.action.support.ActionFilters;
        final ActionListener<AcknowledgedResponse> listener
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
package org.opensearch.action.admin.indices.fielddomain;
        ClusterService clusterService,
            @Override
import org.opensearch.cluster.metadata.MetadataIndexFieldDomainService;
        });  
import org.opensearch.cluster.service.ClusterService;
 *
            public void onResponse(ClusterStateUpdateResponse response) {  
            .targetIndex(request.targetIndex())
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, new String[] { request.targetIndex().getName() });
    }  
        fieldDomainService.putFieldDomains(clusterStateUpdateRequest, new ActionListener<>() {
    @Override
import org.opensearch.threadpool.ThreadPool;
/*  
        ClusterBlockException globalBlock = state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
        TransportService transportService,
    protected String executor() {  
        return ThreadPool.Names.SAME;
        return ResolvedIndices.of(request.targetIndex());
        ActionFilters actionFilters,
}
 * this file be licensed under the Apache-2.0 license or a
    }  
 * Transport action for publishing field-domain metadata to one concrete index.
            actionFilters,
                listener.onResponse(new AcknowledgedResponse(response.isAcknowledged()));
        final PutIndexFieldDomainsRequest request,  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import org.opensearch.cluster.metadata.ResolvedIndices;  
import org.opensearch.transport.TransportService;  
    @Inject
        if (globalBlock != null) {
    }
import org.opensearch.core.common.io.stream.StreamInput;
    public TransportPutIndexFieldDomainsAction(  
import org.apache.logging.log4j.Logger;
    @Override
            .ackTimeout(request.timeout())
        if (request.targetIndex() == null) {
            .fieldDomainCustomData(request.fieldDomainCustomData())  
/**
    public OptionallyResolvedIndices resolveIndices(PutIndexFieldDomainsRequest request) {
 */  
        final ClusterState state,
            PutIndexFieldDomainsRequest::new,
    private final MetadataIndexFieldDomainService fieldDomainService;  
    }
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;  
    protected void clusterManagerOperation(
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
 * compatible open source license.
        MetadataIndexFieldDomainService fieldDomainService,
        // The transport action only submits a cluster state update task.
            clusterService,
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
 * The OpenSearch Contributors require contributions made to  
    PutIndexFieldDomainsRequest,
import java.io.IOException;
            public void onFailure(Exception e) {
    @Override  
 */  
import org.opensearch.common.inject.Inject;
            transportService,
public class TransportPutIndexFieldDomainsAction extends TransportClusterManagerNodeAction<
        }
    @Override
        }  
    }
            return ResolvedIndices.unknown();  
import org.opensearch.core.action.ActionListener;  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            return null;
        IndexNameExpressionResolver indexNameExpressionResolver  
        PutIndexFieldDomainsClusterStateUpdateRequest clusterStateUpdateRequest = new PutIndexFieldDomainsClusterStateUpdateRequest()
        super(
            PutIndexFieldDomainsAction.NAME,  
            }
import org.opensearch.cluster.block.ClusterBlockLevel;
        ThreadPool threadPool,  
            return globalBlock;
    @Override
            threadPool,  
                listener.onFailure(e);
    ) {  
import org.opensearch.cluster.block.ClusterBlockException;
    protected ClusterBlockException checkBlock(PutIndexFieldDomainsRequest request, ClusterState state) {
            indexNameExpressionResolver  
import org.apache.logging.log4j.message.ParameterizedMessage;  
