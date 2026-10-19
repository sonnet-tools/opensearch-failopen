import org.opensearch.core.common.io.stream.StreamInput;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 */
/**
/*
 * Licensed to Elasticsearch under one or more contributor  
            clusterService,  
import java.io.IOException;
        TransportService transportService,
    }
        }  
import org.opensearch.indices.IndicesService;  
        try {
        String[] concreteIndices,
    @Inject  
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * SPDX-License-Identifier: Apache-2.0
        this.indicesService = indicesService;  
    }  
        } catch (IOException e) {
 * Transport action to get field mappings.
 * this file be licensed under the Apache-2.0 license or a
            GetMappingsAction.NAME,
 * license agreements. See the NOTICE file distributed with
import org.apache.logging.log4j.LogManager;
        super(  
 * this work for additional information regarding copyright
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 */  
import org.opensearch.cluster.metadata.MappingMetadata;
        );
 * software distributed under the License is distributed on an
 * under the License.  
}
 * compatible open source license.
    @Override
 * KIND, either express or implied.  See the License for the
import org.opensearch.threadpool.ThreadPool;
        final GetMappingsRequest request,
 * specific language governing permissions and limitations
            threadPool,
    private final IndicesService indicesService;
 * GitHub history for details.
    protected void doClusterManagerOperation(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IndexNameExpressionResolver indexNameExpressionResolver,  
        ActionFilters actionFilters,
            final Map<String, MappingMetadata> result = state.metadata().findMappings(concreteIndices, indicesService.getFieldFilter());
/*  
        return new GetMappingsResponse(in);
    protected GetMappingsResponse read(StreamInput in) throws IOException {
import org.opensearch.action.support.ActionFilters;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.support.clustermanager.info.TransportClusterInfoAction;
import org.opensearch.cluster.service.ClusterService;
 *  
package org.opensearch.action.admin.indices.mapping.get;
    ) {
    }
        ClusterService clusterService,  
 *  
 * not use this file except in compliance with the License.
        IndicesService indicesService
            GetMappingsRequest::new,  
        final ActionListener<GetMappingsResponse> listener
import org.opensearch.common.inject.Inject;  
    ) {
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 *
    @Override  
            listener.onResponse(new GetMappingsResponse(result));  
        logger.trace("serving getMapping request based on version {}", state.version());  
    private static final Logger logger = LogManager.getLogger(TransportGetMappingsAction.class);
            actionFilters,
            listener.onFailure(e);
        final ClusterState state,  
            indexNameExpressionResolver
 */  
            transportService,
    public TransportGetMappingsAction(
import org.opensearch.cluster.ClusterState;
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
import org.apache.logging.log4j.Logger;
import org.opensearch.core.action.ActionListener;
public class TransportGetMappingsAction extends TransportClusterInfoAction<GetMappingsRequest, GetMappingsResponse> {  
 *
        ThreadPool threadPool,
import org.opensearch.transport.TransportService;
