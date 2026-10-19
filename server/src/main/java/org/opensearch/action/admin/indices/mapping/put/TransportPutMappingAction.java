            logger.debug(() -> new ParameterizedMessage("failed to put mappings on indices [{}]", Arrays.asList(request.indices())), ex);
            }  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Optional;
        }  
    private final MetadataMappingService metadataMappingService;  
        ).ackTimeout(request.timeout()).clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
import org.apache.logging.log4j.LogManager;
            return ResolvedIndices.Local.Concrete.of(request.getConcreteIndex());
        return ResolvedIndices.of(resolveIndices(clusterService.state(), request, indexNameExpressionResolver));
                            request.indicesOptions().allowNoIndices(),
import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
        return new AcknowledgedResponse(in);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                    );
        this.requestValidators = Objects.requireNonNull(requestValidators);
 */
                    indices.add(
    }  
import java.util.Arrays;
    protected void clusterManagerOperation(
            }  
                }
            clusterService,  
        final PutMappingRequest request,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.IndexNotFoundException;
        final ActionFilters actionFilters,
    @Override
                            indexExpression,  
            }, listener::onFailure);  
/*  
        } else {
 *  
                logger.debug(() -> new ParameterizedMessage("failed to put mappings on indices [{}]", Arrays.asList(concreteIndices)), t);
                        )  
import org.opensearch.action.support.TransportIndicesResolvingAction;  
import org.opensearch.cluster.metadata.MetadataMappingService;
        final MetadataMappingService metadataMappingService,  
import org.opensearch.action.support.ActionFilters;
        PutMappingClusterStateUpdateRequest updateRequest = new PutMappingClusterStateUpdateRequest(request.source()).indices(  
 */
            public void onResponse(ClusterStateUpdateResponse response) {
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
        try {  
 * software distributed under the License is distributed on an
    public TransportPutMappingAction(
 * compatible open source license.
    public ResolvedIndices resolveIndices(PutMappingRequest request) {
 * Put mapping action.
        } catch (IndexNotFoundException ex) {  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
            } else {
    ) {  
        final RequestValidators<PutMappingRequest> requestValidators,  
        });
import org.opensearch.index.mapper.MappingTransformerRegistry;
 */  
 * this work for additional information regarding copyright
            PutMappingAction.NAME,
    @Override  
        this.mappingTransformerRegistry = mappingTransformerRegistry;
import org.opensearch.cluster.block.ClusterBlockException;
            transportService,
            }
    static ResolvedIndices.Local.Concrete resolveIndices(
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            indices = indexNameExpressionResolver.concreteIndexNames(state, request);
        TransportIndicesResolvingAction<PutMappingRequest> {
        PutMappingRequest request,
import org.opensearch.transport.TransportService;
                listener.onFailure(maybeValidationException.get());
    }
    protected ClusterBlockException checkBlock(PutMappingRequest request, ClusterState state) {
        // we go async right away
 *  
    @Inject
    }
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
/*
 * the Apache License, Version 2.0 (the "License"); you may
                return;  
import org.opensearch.threadpool.ThreadPool;  
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
import org.apache.logging.log4j.message.ParameterizedMessage;  
            indices = new String[] { request.getConcreteIndex().getName() };
 * GitHub history for details.
import org.opensearch.core.index.Index;
public class TransportPutMappingAction extends TransportClusterManagerNodeAction<PutMappingRequest, AcknowledgedResponse>  
        final IndexNameExpressionResolver indexNameExpressionResolver,
            final ActionListener<String> mappingTransformListener = ActionListener.wrap(transformedMapping -> {  
        }
 * this file be licensed under the Apache-2.0 license or a
    }
package org.opensearch.action.admin.indices.mapping.put;
                return iner.concreteResolvedIndices(state, request);
import org.opensearch.cluster.ClusterState;  
            @Override
            }  
 * The OpenSearch Contributors require contributions made to  
        );
 * ownership. Elasticsearch licenses this file to you under  
                listener.onFailure(t);
            throw ex;
 *
        if (request.getConcreteIndex() == null) {
        this.metadataMappingService = metadataMappingService;  
            mappingTransformerRegistry.applyTransformers(request.source(), null, mappingTransformListener);
import org.opensearch.action.RequestValidators;
    private static final Logger logger = LogManager.getLogger(TransportPutMappingAction.class);
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, indices);  
    @Override
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        } else {  
import org.opensearch.core.common.io.stream.StreamInput;
                request.source(transformedMapping, MediaTypeRegistry.JSON);
                return ResolvedIndices.Local.Concrete.of(indices.toArray(Index.EMPTY_ARRAY));  
                List<Index> indices = new ArrayList<>();  
            final Index[] concreteIndices = resolveIndices(state, request, indexNameExpressionResolver).concreteIndicesAsArray();
 * not use this file except in compliance with the License.
    implements
        super(  
                            request.includeDataStreams()
            public void onFailure(Exception t) {  
        String[] indices;  
            if (maybeValidationException.isPresent()) {
import java.util.Objects;
    ) {
                for (String indexExpression : request.indices()) {
                performMappingUpdate(concreteIndices, request, listener, metadataMappingService);
        final TransportService transportService,  
        final ClusterState state,  
                            request.indicesOptions(),
    private final MappingTransformerRegistry mappingTransformerRegistry;
    ) {
            @Override  
 * under the License.  
        }  
        return ThreadPool.Names.SAME;
            indexNameExpressionResolver
import org.opensearch.common.inject.Inject;
        if (request.getConcreteIndex() == null) {
        metadataMappingService.putMapping(updateRequest, new ActionListener<ClusterStateUpdateResponse>() {
                            state,
        Index[] concreteIndices,
    }  
        final ClusterService clusterService,
 * license agreements. See the NOTICE file distributed with
        PutMappingRequest request,
        final IndexNameExpressionResolver iner
        final MappingTransformerRegistry mappingTransformerRegistry
    ) {
 * @opensearch.internal
            PutMappingRequest::new,  
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final RequestValidators<PutMappingRequest> requestValidators;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.core.action.ActionListener;  
import java.io.IOException;  
    static void performMappingUpdate(  
    }
            threadPool,
 * Licensed to Elasticsearch under one or more contributor  
        ActionListener<AcknowledgedResponse> listener,  
    }
import org.opensearch.cluster.service.ClusterService;
            actionFilters,
    protected String executor() {  
        MetadataMappingService metadataMappingService
 * You may obtain a copy of the License at  
        final ActionListener<AcknowledgedResponse> listener
                listener.onResponse(new AcknowledgedResponse(response.isAcknowledged()));
    @Override
            if (request.writeIndexOnly()) {
/**
}
    }  
 *
        final ClusterState state,  
        final ThreadPool threadPool,
/*  
                        iner.concreteWriteIndex(  
 */  
            final Optional<Exception> maybeValidationException = requestValidators.validateRequest(request, state, concreteIndices);  
import org.opensearch.cluster.metadata.ResolvedIndices;  
import java.util.List;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.block.ClusterBlockLevel;  
            concreteIndices
