    protected void clusterManagerOperation(
        final IndexNameExpressionResolver iner
        final RequestValidators<PutMappingRequest> requestValidators,
            clusterService,
                List<Index> indices = new ArrayList<>();
    @Override
import org.apache.logging.log4j.Logger;
            PutMappingRequest::new,
 */
    static void performMappingUpdate(
 * compatible open source license.
import org.opensearch.index.IndexNotFoundException;
            transportService,
import org.apache.logging.log4j.message.ParameterizedMessage;
 * SPDX-License-Identifier: Apache-2.0
        final PutMappingRequest request,
 * KIND, either express or implied.  See the License for the
    @Override
        this.metadataMappingService = metadataMappingService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.action.support.ActionFilters;
 *
                performMappingUpdate(concreteIndices, request, listener, metadataMappingService);
            indices = indexNameExpressionResolver.concreteIndexNames(state, request);
            public void onResponse(ClusterStateUpdateResponse response) {
package org.opensearch.action.admin.indices.mapping.put;
import org.opensearch.core.index.Index;
import java.util.Objects;
        final ActionListener<AcknowledgedResponse> listener
                }
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
import org.opensearch.cluster.metadata.ResolvedIndices;
        } catch (IndexNotFoundException ex) {
    }
            public void onFailure(Exception t) {
 * this work for additional information regarding copyright
            mappingTransformerRegistry.applyTransformers(request.source(), null, mappingTransformListener);
    static ResolvedIndices.Local.Concrete resolveIndices(
                logger.debug(() -> new ParameterizedMessage("failed to put mappings on indices [{}]", Arrays.asList(concreteIndices)), t);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this file be licensed under the Apache-2.0 license or a
                        )
        // we go async right away
        ActionListener<AcknowledgedResponse> listener,
 * Licensed to Elasticsearch under one or more contributor
                listener.onResponse(new AcknowledgedResponse(response.isAcknowledged()));
        metadataMappingService.putMapping(updateRequest, new ActionListener<ClusterStateUpdateResponse>() {
                            indexExpression,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.mapper.MappingTransformerRegistry;
        return ThreadPool.Names.SAME;
import java.util.Arrays;
                return;
    implements
    ) {
import java.util.ArrayList;
import org.opensearch.cluster.ClusterState;
    private static final Logger logger = LogManager.getLogger(TransportPutMappingAction.class);
            }
            }, listener::onFailure);
    }
/*
        final ClusterState state,
    private final MetadataMappingService metadataMappingService;
    }
 * The OpenSearch Contributors require contributions made to
 * specific language governing permissions and limitations
        this.requestValidators = Objects.requireNonNull(requestValidators);
    public TransportPutMappingAction(
 */
            final Index[] concreteIndices = resolveIndices(state, request, indexNameExpressionResolver).concreteIndicesAsArray();
        final ThreadPool threadPool,
import org.apache.logging.log4j.LogManager;
        } else {
    private final RequestValidators<PutMappingRequest> requestValidators;
/*
                            request.includeDataStreams()
            actionFilters,
        if (request.getConcreteIndex() == null) {
                    indices.add(
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Optional;
        TransportIndicesResolvingAction<PutMappingRequest> {
    @Override
            } else {
            }
            if (maybeValidationException.isPresent()) {
            final ActionListener<String> mappingTransformListener = ActionListener.wrap(transformedMapping -> {
                request.source(transformedMapping, MediaTypeRegistry.JSON);
    protected String executor() {
        if (request.getConcreteIndex() == null) {
        final ClusterService clusterService,
 *
        try {
        final ActionFilters actionFilters,
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, indices);
        );
import org.opensearch.cluster.block.ClusterBlockLevel;
                listener.onFailure(maybeValidationException.get());
import org.opensearch.core.common.io.stream.StreamInput;
            if (request.writeIndexOnly()) {
        return ResolvedIndices.of(resolveIndices(clusterService.state(), request, indexNameExpressionResolver));
import org.opensearch.core.action.ActionListener;
        MetadataMappingService metadataMappingService
            concreteIndices
    }
        final MetadataMappingService metadataMappingService,
                    );
                            state,
    protected ClusterBlockException checkBlock(PutMappingRequest request, ClusterState state) {
    }
 * under the License.
 *
 *
            final Optional<Exception> maybeValidationException = requestValidators.validateRequest(request, state, concreteIndices);
 * ownership. Elasticsearch licenses this file to you under
 * @opensearch.internal
            @Override
            }
        super(
}
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
 * not use this file except in compliance with the License.
        final TransportService transportService,
                            request.indicesOptions(),
            throw ex;
 * Put mapping action.
        });
                for (String indexExpression : request.indices()) {
 * the Apache License, Version 2.0 (the "License"); you may
        PutMappingClusterStateUpdateRequest updateRequest = new PutMappingClusterStateUpdateRequest(request.source()).indices(
        final MappingTransformerRegistry mappingTransformerRegistry
            logger.debug(() -> new ParameterizedMessage("failed to put mappings on indices [{}]", Arrays.asList(request.indices())), ex);
    ) {
        }
import org.opensearch.cluster.service.ClusterService;
    public ResolvedIndices resolveIndices(PutMappingRequest request) {
            threadPool,
                        iner.concreteWriteIndex(
        ).ackTimeout(request.timeout()).clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
                listener.onFailure(t);
        PutMappingRequest request,
 */
            PutMappingAction.NAME,
    @Override
    }
        }
    }
            indices = new String[] { request.getConcreteIndex().getName() };
    ) {
        this.mappingTransformerRegistry = mappingTransformerRegistry;
import org.opensearch.common.inject.Inject;
                return iner.concreteResolvedIndices(state, request);
            }
 * GitHub history for details.
    @Inject
import org.opensearch.action.support.TransportIndicesResolvingAction;
/*
        final IndexNameExpressionResolver indexNameExpressionResolver,
        } else {
import org.opensearch.action.RequestValidators;
                return ResolvedIndices.Local.Concrete.of(indices.toArray(Index.EMPTY_ARRAY));
    @Override
    }
 */
            return ResolvedIndices.Local.Concrete.of(request.getConcreteIndex());
 * You may obtain a copy of the License at
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.metadata.MetadataMappingService;
import java.io.IOException;
        }
public class TransportPutMappingAction extends TransportClusterManagerNodeAction<PutMappingRequest, AcknowledgedResponse>
 * Unless required by applicable law or agreed to in writing,
        final ClusterState state,
        PutMappingRequest request,
        Index[] concreteIndices,
    private final MappingTransformerRegistry mappingTransformerRegistry;
            @Override
                            request.indicesOptions().allowNoIndices(),
import org.opensearch.core.xcontent.MediaTypeRegistry;
        String[] indices;
 * license agreements. See the NOTICE file distributed with
/**
            indexNameExpressionResolver
        return new AcknowledgedResponse(in);
import java.util.List;
    ) {
 * software distributed under the License is distributed on an
