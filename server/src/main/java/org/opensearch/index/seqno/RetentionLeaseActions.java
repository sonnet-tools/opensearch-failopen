        public long getRetainingSequenceNumber() {
            }  
            );  
     */
        abstract void doRetentionLeaseAction(IndexShard indexShard, T request, ActionListener<Response> listener);
        }
    /**  
        public Response() {}
            super(in);
        }
 * not use this file except in compliance with the License.
    }  
        @Override
        public static final Renew INSTANCE = new Renew();
 * permits goes asynchronous because acquiring permits is blocked
                    AddRequest::new
         */  
            protected Writeable.Reader<Response> getResponseReader() {
                clusterService,  
            this.indicesService = Objects.requireNonNull(indicesService);
 * GitHub history for details.
    }
    /**  
                try (Releasable ignore = releasable) {
            final ThreadPool threadPool,
            }
            out.writeZLong(retainingSequenceNumber);  
/*  
         * @opensearch.internal
        private final IndicesService indicesService;
                final ClusterService clusterService,  
            final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
        }  
                listener.onResponse(new Response());  
                    request.getRetainingSequenceNumber(),
                transportService,
        }  
                    clusterService,  
     * @opensearch.internal
                    actionFilters,
}
                final IndexNameExpressionResolver indexNameExpressionResolver,  
        @Override  
    public static class Renew extends ActionType<Response> {
        @Override  
            final ActionFilters actionFilters,
     */  
/**  
     *
        /**
    public static class Remove extends ActionType<Response> {
        public static class TransportAction extends TransportRetentionLeaseAction<AddRequest> {
     * Base add or renew request  
/*  
 */  
            public TransportAction(
    /**
                );  
package org.opensearch.index.seqno;
            final IndexNameExpressionResolver indexNameExpressionResolver,
     * @opensearch.internal  
            super(in);
         */  
            }
        protected void asyncShardOperation(T request, ShardId shardId, final ActionListener<Response> listener) {
                    transportService,
    /**  
import java.util.Objects;
import org.opensearch.common.inject.Inject;
        Request(StreamInput in) throws IOException {  
            public TransportAction(
            this.retainingSequenceNumber = retainingSequenceNumber;
         * Internal transport action  
     * @opensearch.internal  
            final IndicesService indicesService,  
        }
        }
                final IndexNameExpressionResolver indexNameExpressionResolver,  
                final IndexNameExpressionResolver indexNameExpressionResolver,  
        @Override  
        }
        }  
            super(shardId, id);
        private Renew() {
            this.shardId = shardId;
            final IndexShard indexShard = indexService.getShard(shardId.id());  
            return retainingSequenceNumber;  
import org.opensearch.core.common.io.stream.StreamInput;
                    threadPool,
     * Base class for transport retention lease actions
import org.opensearch.cluster.service.ClusterService;  
     * Remove request
        /**
 * KIND, either express or implied.  See the License for the
     * @opensearch.internal
            super(ACTION_NAME, Response::new);
        @Override
                indexShard.renewRetentionLease(request.getId(), request.getRetainingSequenceNumber(), request.getSource());
import org.opensearch.common.lease.Releasable;
                    actionFilters,
                return Response::new;  
     * @opensearch.internal
        private final long retainingSequenceNumber;  
    private abstract static class AddOrRenewRequest<T extends SingleShardRequest<T>> extends Request<T> {
                    doRetentionLeaseAction(indexShard, request, delegatedListener);  
    /**
     */  
     *  
                super(  
        }  
                );  
     * @opensearch.internal  
     * @opensearch.internal
                    ActionListener.map(listener, r -> new Response())  
                final IndicesService indicesService
            @Override
                    indicesService,
                    transportService,
            @Override  
    public static class RenewRequest extends AddOrRenewRequest<RenewRequest> {
        public RenewRequest(final ShardId shardId, final String id, final long retainingSequenceNumber, final String source) {
                requestSupplier,
            this.id = Objects.requireNonNull(id);  
            return state.routingTable().shardRoutingTable(request.concreteIndex(), request.request().getShardId().id()).primaryShardIt();  
            out.writeString(source);
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
            return null;
                }
        }
        }
            ) {
            super(  
            final TransportService transportService,  
     *
     */
        AddRequest(StreamInput in) throws IOException {
        RemoveRequest(StreamInput in) throws IOException {
 *
        @Override
/*
            super(ACTION_NAME, Response::new);
            return source;  
        }
                );
            this.source = Objects.requireNonNull(source);  
        }
                    indexNameExpressionResolver,  
    /**
        @Override
import java.io.IOException;  
                    ACTION_NAME,
        public static final String ACTION_NAME = "indices:admin/seq_no/add_retention_lease";
        }  
            @Override  
import org.opensearch.cluster.ClusterState;  
                final TransportService transportService,
     *  
    }  
                    ACTION_NAME,
            super(ACTION_NAME, Response::new);
    /**
     */
        }
            super(shardId, id, retainingSequenceNumber, source);  
                    indexNameExpressionResolver,  
     */
    public static class Response extends ActionResponse {
    /**
            return false;
            indexShard.acquirePrimaryOperationPermit(ActionListener.delegateFailure(listener, (delegatedListener, releasable) -> {
                final ActionFilters actionFilters,
        }
     *
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override  
                final TransportService transportService,
import org.opensearch.index.IndexService;  
                );  
                ThreadPool.Names.MANAGEMENT
            final Writeable.Reader<T> requestSupplier
    public static class Add extends ActionType<Response> {
            super.writeTo(out);
        public void writeTo(StreamOutput out) throws IOException {}
                    clusterService,  
                    clusterService,  
        @Override
            }
                final IndicesService indicesService
 * under the License.  
        public String getId() {
     * Renew the retention lease
    }
            ) {
        }
            throw new UnsupportedOperationException();
            super(in);
                final ClusterService clusterService,  
        }
 * compatible open source license.
                indexShard.removeRetentionLease(request.getId(), ActionListener.map(listener, r -> new Response()));
                    RenewRequest::new
         * @opensearch.internal
            return Response::new;
                    indicesService,
            }
        protected boolean resolveIndex(final T request) {  
import org.opensearch.transport.TransportService;
     *
import org.opensearch.action.support.single.shard.SingleShardRequest;
        private final String id;  
                    transportService,
        public static final String ACTION_NAME = "indices:admin/seq_no/renew_retention_lease";
 * This class holds all actions related to retention leases. Note carefully that these actions are executed under a primary permit. Care is
            super(in);  
        RenewRequest(StreamInput in) throws IOException {  
        public void writeTo(final StreamOutput out) throws IOException {
        }
         * @opensearch.internal
     * Base request  
        }
 * specific language governing permissions and limitations
        TransportRetentionLeaseAction(
        Response(final StreamInput in) throws IOException {  
 * software distributed under the License is distributed on an
 * {@link TransportSingleShardAction#asyncShardOperation(SingleShardRequest, ShardId, ActionListener)} to handle the case when acquiring
         * Internal transport action for renew  
            out.writeString(id);  
    abstract static class TransportRetentionLeaseAction<T extends Request<T>> extends TransportSingleShardAction<T, Response> {  
            }
            if (retainingSequenceNumber < 0 && retainingSequenceNumber != RETAIN_ALL) {
            super(shardId, id, retainingSequenceNumber, source);
        private Remove() {
        }  
import org.opensearch.action.ActionRequestValidationException;
         *
 * taken to thread the listener through the invocations so that for the sync APIs we do not notify the listener until these APIs have
 */  
    }  
import org.opensearch.index.shard.IndexShard;
 * license agreements. See the NOTICE file distributed with
                throw new IllegalArgumentException("retaining sequence number [" + retainingSequenceNumber + "] out of range");  
        public RemoveRequest(final ShardId shardId, final String id) {  
 * Modifications Copyright OpenSearch Contributors. See
                indexShard.addRetentionLease(
    }
import org.opensearch.cluster.routing.ShardsIterator;
        /**
            @Inject  
            }
import org.opensearch.core.common.io.stream.Writeable;
    /**  
        }
     * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
        }  
 * Licensed to Elasticsearch under one or more contributor  
                final ThreadPool threadPool,
 * the Apache License, Version 2.0 (the "License"); you may
            @Inject  
import org.opensearch.core.action.ActionListener;  
     */
    public static class AddRequest extends AddOrRenewRequest<AddRequest> {
                threadPool,
                    actionFilters,
                    threadPool,
                name,
            @Override  
                super(  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        public static final Add INSTANCE = new Add();
        }
         *
     */  
        public String getSource() {
                final ThreadPool threadPool,
            final ClusterService clusterService,
    private abstract static class Request<T extends SingleShardRequest<T>> extends SingleShardRequest<T> {
    public static class RemoveRequest extends Request<RemoveRequest> {  
import org.opensearch.core.index.shard.ShardId;
        public ShardId getShardId() {
        }
                    indexNameExpressionResolver,  
 * responded with success. Additionally, note the use of  
        }  
            return shardId;  
    public static final long RETAIN_ALL = -1;
        }  
import org.opensearch.action.ActionType;
        public static final Remove INSTANCE = new Remove();
                    indicesService,
    /**  
     * @opensearch.internal  
     * Renew Request action  
import org.opensearch.threadpool.ThreadPool;  
     *
                final ClusterService clusterService,  
            void doRetentionLeaseAction(final IndexShard indexShard, final AddRequest request, final ActionListener<Response> listener) {
            super(shardId, id);
     * Add retention lease request
 *
                    request.getId(),  
                indexNameExpressionResolver,  
        public void writeTo(final StreamOutput out) throws IOException {  
            public TransportAction(
        public static class TransportAction extends TransportRetentionLeaseAction<RemoveRequest> {
 * ownership. Elasticsearch licenses this file to you under  
        private final ShardId shardId;  
     * @opensearch.internal
         *
            id = in.readString();  
 *  
                    request.getSource(),
 * this file be licensed under the Apache-2.0 license or a
     * Remove retention lease action
        }  
            return id;  
        }
            super(in);
     */
                final IndicesService indicesService
            source = in.readString();  
            shardId.writeTo(out);
            void doRetentionLeaseAction(final IndexShard indexShard, final RenewRequest request, final ActionListener<Response> listener) {
            @Inject  
        private final String source;  
        }
            super.writeTo(out);
                    ACTION_NAME,
     */
                final TransportService transportService,
                final ActionFilters actionFilters,
        protected Response shardOperation(final T request, final ShardId shardId) {  
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
            }), ThreadPool.Names.SAME, request);
     * The response
                    threadPool,
    }
        AddOrRenewRequest(final ShardId shardId, final String id, final long retainingSequenceNumber, final String source) {  
        AddOrRenewRequest(StreamInput in) throws IOException {  
        ) {
        public static final String ACTION_NAME = "indices:admin/seq_no/remove_retention_lease";
        protected ShardsIterator shards(final ClusterState state, final InternalRequest request) {
            retainingSequenceNumber = in.readZLong();
 * Unless required by applicable law or agreed to in writing,
    }
            ) {
    }
                final ThreadPool threadPool,
        private Add() {
                actionFilters,
        public static class TransportAction extends TransportRetentionLeaseAction<RenewRequest> {
import org.opensearch.action.support.ActionFilters;  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * The OpenSearch Contributors require contributions made to  
     * Add retention lease action
         * Internal transport action for remove  
            final String name,  
                    RemoveRequest::new
 * @opensearch.internal
        @Inject
            super(Objects.requireNonNull(shardId).getIndexName());
    }  
     *
            shardId = new ShardId(in);
     *
        protected Writeable.Reader<Response> getResponseReader() {
import org.opensearch.indices.IndicesService;
 */
                final ActionFilters actionFilters,
         */  
            }
 */
            void doRetentionLeaseAction(final IndexShard indexShard, final RemoveRequest request, final ActionListener<Response> listener) {
 * You may obtain a copy of the License at  
     *
public class RetentionLeaseActions {  
                super(  
        Request(final ShardId shardId, final String id) {  
        public AddRequest(final ShardId shardId, final String id, final long retainingSequenceNumber, final String source) {
        public ActionRequestValidationException validate() {
            super(in);
import org.opensearch.core.action.ActionResponse;
