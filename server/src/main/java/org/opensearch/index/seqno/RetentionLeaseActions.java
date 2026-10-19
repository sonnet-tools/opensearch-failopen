     * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
            super.writeTo(out);
import org.opensearch.core.action.ActionListener;
                    request.getId(),
                    transportService,
 */
            }
         *
        }
 * @opensearch.internal
                ThreadPool.Names.MANAGEMENT
 * this file be licensed under the Apache-2.0 license or a
            return shardId;
            @Override
            @Override
            }
        }
        public static final String ACTION_NAME = "indices:admin/seq_no/renew_retention_lease";
                super(
import org.opensearch.core.action.ActionResponse;
                final ThreadPool threadPool,
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
        protected boolean resolveIndex(final T request) {
import org.opensearch.action.support.single.shard.SingleShardRequest;
     * Remove retention lease action
     * @opensearch.internal
                listener.onResponse(new Response());
        public static final Add INSTANCE = new Add();
            return Response::new;
        public static class TransportAction extends TransportRetentionLeaseAction<AddRequest> {
                    RemoveRequest::new
        /**
            }
                final ActionFilters actionFilters,
            final IndexNameExpressionResolver indexNameExpressionResolver,
 * compatible open source license.
            out.writeString(id);
                    indexNameExpressionResolver,
 */
                transportService,
     * Add retention lease action
     */
    /**
    public static class Remove extends ActionType<Response> {
        }
            public TransportAction(
 * not use this file except in compliance with the License.
            super(in);
                    transportService,
 * software distributed under the License is distributed on an
            if (retainingSequenceNumber < 0 && retainingSequenceNumber != RETAIN_ALL) {
     * @opensearch.internal
            final IndexShard indexShard = indexService.getShard(shardId.id());
            super(in);
            super(in);
        @Override
        protected Writeable.Reader<Response> getResponseReader() {
    private abstract static class Request<T extends SingleShardRequest<T>> extends SingleShardRequest<T> {
    /**
        }
     */
        }
        }
                requestSupplier,
            @Override
 * The OpenSearch Contributors require contributions made to
    /**
    }
     *
         */
         * Internal transport action for renew
import org.opensearch.core.index.shard.ShardId;
     */
 * responded with success. Additionally, note the use of
/*
        AddRequest(StreamInput in) throws IOException {
            @Inject
                    threadPool,
                );
        }
     * @opensearch.internal
                    transportService,
    }
                    actionFilters,
            final TransportService transportService,
            public TransportAction(
                final IndexNameExpressionResolver indexNameExpressionResolver,
    public static class RenewRequest extends AddOrRenewRequest<RenewRequest> {
            indexShard.acquirePrimaryOperationPermit(ActionListener.delegateFailure(listener, (delegatedListener, releasable) -> {
 * This class holds all actions related to retention leases. Note carefully that these actions are executed under a primary permit. Care is
                super(
                    RenewRequest::new
            return retainingSequenceNumber;
                    clusterService,
                indexNameExpressionResolver,
        TransportRetentionLeaseAction(
        @Override
        public Response() {}
    }
 *
                    ActionListener.map(listener, r -> new Response())
                    ACTION_NAME,
                final TransportService transportService,
     *
     * Base class for transport retention lease actions
        }
        public static final String ACTION_NAME = "indices:admin/seq_no/remove_retention_lease";
    }
    /**
 * SPDX-License-Identifier: Apache-2.0
        }
        AddOrRenewRequest(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.Writeable;
        public ActionRequestValidationException validate() {
        ) {
        private Remove() {
            shardId.writeTo(out);
import org.opensearch.cluster.ClusterState;
    }
    private abstract static class AddOrRenewRequest<T extends SingleShardRequest<T>> extends Request<T> {
            id = in.readString();
    /**
        }
 *
        }
     *
/**
            final ActionFilters actionFilters,
    /**
            super(in);
        }
     */
            @Override
            ) {
import org.opensearch.cluster.routing.ShardsIterator;
            return source;
                );
import org.opensearch.core.common.io.stream.StreamInput;
            super(shardId, id);
        abstract void doRetentionLeaseAction(IndexShard indexShard, T request, ActionListener<Response> listener);
    /**
        public ShardId getShardId() {
        protected Response shardOperation(final T request, final ShardId shardId) {
                final ActionFilters actionFilters,
        public void writeTo(final StreamOutput out) throws IOException {
            final ThreadPool threadPool,
            return false;
     * @opensearch.internal
     * @opensearch.internal
        private final ShardId shardId;
                    doRetentionLeaseAction(indexShard, request, delegatedListener);
                final IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.threadpool.ThreadPool;
}
        /**
        protected ShardsIterator shards(final ClusterState state, final InternalRequest request) {
     * @opensearch.internal
                final IndicesService indicesService
            ) {
 * permits goes asynchronous because acquiring permits is blocked
import java.util.Objects;
            }
 * Modifications Copyright OpenSearch Contributors. See
        private final IndicesService indicesService;
            this.id = Objects.requireNonNull(id);
        private final String source;
            return id;
        }
            }), ThreadPool.Names.SAME, request);
            super(ACTION_NAME, Response::new);
 *
            final String name,
            ) {
         * @opensearch.internal
                final ClusterService clusterService,
                    indexNameExpressionResolver,
import org.opensearch.action.ActionType;
            return null;
import org.opensearch.index.shard.IndexShard;
     * The response
 * license agreements. See the NOTICE file distributed with
            return state.routingTable().shardRoutingTable(request.concreteIndex(), request.request().getShardId().id()).primaryShardIt();
    }
                    request.getSource(),
import java.io.IOException;
        public static final Remove INSTANCE = new Remove();
     * Renew the retention lease
            super(ACTION_NAME, Response::new);
            retainingSequenceNumber = in.readZLong();
        }
                return Response::new;
            @Inject
        private final String id;
            }
                final IndicesService indicesService
     * @opensearch.internal
     *
     */
    }
                indexShard.addRetentionLease(
        }
     * @opensearch.internal
     * Base add or renew request
        }
                final ThreadPool threadPool,
            super(Objects.requireNonNull(shardId).getIndexName());
            super.writeTo(out);
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
        RemoveRequest(StreamInput in) throws IOException {
        public void writeTo(StreamOutput out) throws IOException {}
        }
                    clusterService,
            source = in.readString();
                    request.getRetainingSequenceNumber(),
import org.opensearch.cluster.service.ClusterService;
                    indexNameExpressionResolver,
            shardId = new ShardId(in);
 * KIND, either express or implied.  See the License for the
     * @opensearch.internal
            void doRetentionLeaseAction(final IndexShard indexShard, final RenewRequest request, final ActionListener<Response> listener) {
     */
            protected Writeable.Reader<Response> getResponseReader() {
            this.indicesService = Objects.requireNonNull(indicesService);
                    clusterService,
                throw new IllegalArgumentException("retaining sequence number [" + retainingSequenceNumber + "] out of range");
                );
        }
    }
 * Licensed to Elasticsearch under one or more contributor
         */
                try (Releasable ignore = releasable) {
    public static class AddRequest extends AddOrRenewRequest<AddRequest> {
 */
        Request(StreamInput in) throws IOException {
            final ClusterService clusterService,
package org.opensearch.index.seqno;
        public RenewRequest(final ShardId shardId, final String id, final long retainingSequenceNumber, final String source) {
                final TransportService transportService,
                final ClusterService clusterService,
     *
                name,
            @Inject
        /**
         */
     * Add retention lease request
            }
        }
        }
import org.opensearch.transport.TransportService;
     *
                threadPool,
 * under the License.
        private Renew() {
        @Override
                final ThreadPool threadPool,
 *
    public static class Renew extends ActionType<Response> {
        public long getRetainingSequenceNumber() {
            throw new UnsupportedOperationException();
 * You may obtain a copy of the License at
                final TransportService transportService,
            super(in);
     * Renew Request action
                super(
         * Internal transport action
        @Override
        private Add() {
            super(shardId, id, retainingSequenceNumber, source);
        public static class TransportAction extends TransportRetentionLeaseAction<RemoveRequest> {
        protected void asyncShardOperation(T request, ShardId shardId, final ActionListener<Response> listener) {
                    indicesService,
public class RetentionLeaseActions {
     */
            out.writeString(source);
            out.writeZLong(retainingSequenceNumber);
         *
 * {@link TransportSingleShardAction#asyncShardOperation(SingleShardRequest, ShardId, ActionListener)} to handle the case when acquiring
     */
import org.opensearch.common.lease.Releasable;
    public static class Response extends ActionResponse {
            this.source = Objects.requireNonNull(source);
                final ClusterService clusterService,
            final Writeable.Reader<T> requestSupplier
        public RemoveRequest(final ShardId shardId, final String id) {
                    actionFilters,
/*
        }
            void doRetentionLeaseAction(final IndexShard indexShard, final RemoveRequest request, final ActionListener<Response> listener) {
import org.opensearch.common.inject.Inject;
    public static class Add extends ActionType<Response> {
    /**
        public String getSource() {
import org.opensearch.index.IndexService;
     * Remove request
     *
        }
                }
        @Override
            }
        public AddRequest(final ShardId shardId, final String id, final long retainingSequenceNumber, final String source) {
        private final long retainingSequenceNumber;
    public static final long RETAIN_ALL = -1;
        }
 * specific language governing permissions and limitations
     */
                    threadPool,
 */
                final IndexNameExpressionResolver indexNameExpressionResolver,
        AddOrRenewRequest(final ShardId shardId, final String id, final long retainingSequenceNumber, final String source) {
            void doRetentionLeaseAction(final IndexShard indexShard, final AddRequest request, final ActionListener<Response> listener) {
         *
    public static class RemoveRequest extends Request<RemoveRequest> {
        Request(final ShardId shardId, final String id) {
     * Base request
            super(
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
                    ACTION_NAME,
         * @opensearch.internal
            super(shardId, id);
        }
                final ActionFilters actionFilters,
            final IndicesService indicesService,
/*
                    actionFilters,
     *
        @Inject
                indexShard.renewRetentionLease(request.getId(), request.getRetainingSequenceNumber(), request.getSource());
            }
        RenewRequest(StreamInput in) throws IOException {
                    ACTION_NAME,
    abstract static class TransportRetentionLeaseAction<T extends Request<T>> extends TransportSingleShardAction<T, Response> {
 *    http://www.apache.org/licenses/LICENSE-2.0
                );
import org.opensearch.indices.IndicesService;
        }
        Response(final StreamInput in) throws IOException {
            );
 * taken to thread the listener through the invocations so that for the sync APIs we do not notify the listener until these APIs have
 * this work for additional information regarding copyright
                    AddRequest::new
        }
        public static final Renew INSTANCE = new Renew();
    }
import org.opensearch.action.support.ActionFilters;
     *
        }
        }
        public static final String ACTION_NAME = "indices:admin/seq_no/add_retention_lease";
        }
                    threadPool,
            this.shardId = shardId;
         * Internal transport action for remove
            public TransportAction(
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    indicesService,
        public void writeTo(final StreamOutput out) throws IOException {
    /**
                indexShard.removeRetentionLease(request.getId(), ActionListener.map(listener, r -> new Response()));
                final IndicesService indicesService
     */
            super(shardId, id, retainingSequenceNumber, source);
            super(in);
                clusterService,
    }
         * @opensearch.internal
        @Override
            super(ACTION_NAME, Response::new);
            final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
                    indicesService,
                actionFilters,
        @Override
        public String getId() {
     *
        public static class TransportAction extends TransportRetentionLeaseAction<RenewRequest> {
            this.retainingSequenceNumber = retainingSequenceNumber;
