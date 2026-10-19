        TransportService transportService,  
    protected final boolean localExecute(Request request) {
            clusterService,
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * Can also be executed on the local node if needed.  
        IndexNameExpressionResolver indexNameExpressionResolver,
        );  
import org.opensearch.transport.TransportService;
        TransportService transportService,
        String actionName,
        ActionFilters actionFilters,
        ClusterService clusterService,
/**
        return localExecuteSupported;  
        ThreadPool threadPool,
            actionFilters,  
 * under the License.  
            true,
            transportService,  
/*  
 * this file be licensed under the Apache-2.0 license or a
        ActionFilters actionFilters,
    }  
    }
 * ownership. Elasticsearch licenses this file to you under  
            request,
 * software distributed under the License is distributed on an
    protected TransportClusterManagerNodeReadAction(
            checkSizeLimit,
    protected boolean localExecuteSupportedByAction() {
 *     http://www.apache.org/licenses/LICENSE-2.0
            checkSizeLimit,
    protected TransportClusterManagerNodeReadAction(  
        ThreadPool threadPool,
            AdmissionControlActionType.CLUSTER_ADMIN,
        );  
            threadPool,
            clusterService,
 *  
        TransportService transportService,
        String actionName,
        this(actionName, transportService, clusterService, threadPool, actionFilters, request, indexNameExpressionResolver, false);
        this(
        this.localExecuteSupported = localExecuteSupported;
 */  
import org.opensearch.action.support.ActionFilters;
 */  
 * specific language governing permissions and limitations
            admissionControlActionType,
            threadPool,
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;  
            clusterService,
        ThreadPool threadPool,  
 * A base class for read operations that needs to be performed on the cluster-manager node.
 *
import org.opensearch.cluster.service.ClusterService;  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    }
        boolean localExecuteSupported  
            actionName,  
import org.opensearch.core.common.io.stream.Writeable;
 * not use this file except in compliance with the License.
        IndexNameExpressionResolver indexNameExpressionResolver  
 *
        Writeable.Reader<Request> request,
    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    ) {  
            actionFilters,  
            transportService,  
            threadPool,
        IndexNameExpressionResolver indexNameExpressionResolver
 *
        String actionName,
        ActionFilters actionFilters,  
        ActionFilters actionFilters,  
        ClusterService clusterService,
}  
        boolean checkSizeLimit,  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(
    Request extends ClusterManagerNodeReadRequest<Request>,
 * Modifications Copyright OpenSearch Contributors. See
    protected TransportClusterManagerNodeReadAction(
        Writeable.Reader<Request> request,
        ClusterService clusterService,
    }
 * KIND, either express or implied.  See the License for the
    Response extends ActionResponse> extends TransportClusterManagerNodeAction<Request, Response> {  
 */
        ThreadPool threadPool,  
        boolean checkSizeLimit,
 * the Apache License, Version 2.0 (the "License"); you may
        TransportService transportService,  
import org.opensearch.core.action.ActionResponse;
    ) {
            indexNameExpressionResolver
        );  
        Writeable.Reader<Request> request,
    ) {
            request,
            indexNameExpressionResolver
        ClusterService clusterService,
        return request.local();
        AdmissionControlActionType admissionControlActionType,  
    @Override  
        IndexNameExpressionResolver indexNameExpressionResolver  
        super(
        Writeable.Reader<Request> request,
import org.opensearch.threadpool.ThreadPool;
/*  
        String actionName,
 * license agreements. See the NOTICE file distributed with
            indexNameExpressionResolver
    protected TransportClusterManagerNodeReadAction(
 */  
            actionName,  
public abstract class TransportClusterManagerNodeReadAction<
 * this work for additional information regarding copyright
    }
            request,
package org.opensearch.action.support.clustermanager;
 * Licensed to Elasticsearch under one or more contributor  
/*
            transportService,  
 * compatible open source license.
            actionFilters,  
            actionName,  
    protected boolean localExecuteSupported = false;
    ) {
            null,
