    }
 * Unless required by applicable law or agreed to in writing,
 */  
                listener.onResponse((Response) response);  
        return bulkRequest;
import org.opensearch.core.action.ActionListener;  
 *
    }
    }  
    public ResolvedIndices resolveIndices(Request request) {  
    private final IndexNameExpressionResolver indexNameExpressionResolver;  
        bulkRequest.setRefreshPolicy(request.getRefreshPolicy());
 * software distributed under the License is distributed on an
@Deprecated
    protected void doExecute(Task task, final Request request, final ActionListener<Response> listener) {
import org.opensearch.action.support.TransportIndicesResolvingAction;
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
        ActionListener<Response> listener
 *
        TransportIndicesResolvingAction<Request> {  
import org.opensearch.action.support.WriteRequest;  
    public static BulkRequest toSingleItemBulkRequest(ReplicatedWriteRequest<?> request) {
        return ResolvedIndices.of(indexNameExpressionResolver.resolveDateMathExpression(request.index()));
        TransportService transportService,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
}
import org.opensearch.cluster.metadata.ResolvedIndices;
    }
            BulkItemResponse bulkItemResponse = bulkItemResponses.getItems()[0];  
import org.opensearch.core.common.io.stream.Writeable;
 * use transport bulk action directly  
        super(actionName, transportService, actionFilters, requestReader);
    ) {  
        BulkRequest bulkRequest = new BulkRequest();
            }  
package org.opensearch.action.bulk;
 * this work for additional information regarding copyright
import org.opensearch.action.DocWriteResponse;
import org.opensearch.action.support.WriteResponse;
 * not use this file except in compliance with the License.
 * GitHub history for details.
 */  
    private final TransportBulkAction bulkAction;
import org.opensearch.transport.TransportService;  
 * KIND, either express or implied.  See the License for the
            } else {
 * license agreements. See the NOTICE file distributed with
        bulkRequest.timeout(request.timeout());
 * the Apache License, Version 2.0 (the "License"); you may
        bulkRequest.waitForActiveShards(request.waitForActiveShards());  
        request.setRefreshPolicy(WriteRequest.RefreshPolicy.NONE);
        return ActionListener.wrap(bulkItemResponses -> {
    @Override
        this.bulkAction = bulkAction;
 * specific language governing permissions and limitations
import org.opensearch.action.support.replication.ReplicationResponse;  
    protected TransportSingleItemBulkWriteAction(
    Request extends ReplicatedWriteRequest<Request>,  
/*
        ActionFilters actionFilters,
 */
import org.opensearch.action.support.HandledTransportAction;
        bulkRequest.add(((DocWriteRequest<?>) request));  
 * this file be licensed under the Apache-2.0 license or a
        bulkAction.execute(task, toSingleItemBulkRequest(request), wrapBulkResponse(listener));
/*  
    ) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
    Response extends ReplicationResponse & WriteResponse> extends HandledTransportAction<Request, Response>
 * The OpenSearch Contributors require contributions made to  
        IndexNameExpressionResolver indexNameExpressionResolver
 * ownership. Elasticsearch licenses this file to you under  
    implements
 *
import org.opensearch.action.support.ActionFilters;  
 * under the License.  
            assert bulkItemResponses.getItems().length == 1 : "expected only one item in bulk request";
 * @opensearch.internal
import org.opensearch.action.DocWriteRequest;
            if (bulkItemResponse.isFailed() == false) {
    }  
/**
    @Override  
        TransportBulkAction bulkAction,
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.replication.ReplicatedWriteRequest;
 *  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.tasks.Task;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                final DocWriteResponse response = bulkItemResponse.getResponse();
 * You may obtain a copy of the License at  
public abstract class TransportSingleItemBulkWriteAction<
        Writeable.Reader<Request> requestReader,  
        }, listener::onFailure);
    public static <Response extends ReplicationResponse & WriteResponse> ActionListener<BulkResponse> wrapBulkResponse(
        String actionName,  
 */  
 * compatible open source license.
/*  
                listener.onFailure(bulkItemResponse.getFailure().getCause());
