 * Modifications Copyright OpenSearch Contributors. See
            incDocStatusStats(e);
        final Exception failure,
                break;
                break;
    protected void shardOperation(final UpdateRequest request, final ActionListener<UpdateResponse> listener) {
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        }
    protected UpdateResponse newResponse(StreamInput in) throws IOException {
        final UpdateRequest request,
                        response.getPrimaryTerm(),
                    UpdateResponse update = new UpdateResponse(
 *
                        update.setGetResult(
                    update.setGetResult(
                        response.getId(),
                if (indexServiceOrNull != null) {
        if (request.isRequireAlias() && (clusterService.state().getMetadata().hasAlias(request.index()) == false)) {
                                response.getVersion(),
    @Override
                            if (unwrapCause(e) instanceof ResourceAlreadyExistsException) {
import org.opensearch.action.support.AutoCreateIndex;
            default:
                return;
            }
                        @Override
                        response.getShardId(),
                    new CreateIndexRequest().index(request.index()).cause("auto(update api)").clusterManagerNodeTimeout(request.timeout()),
import org.opensearch.action.index.IndexRequest;
                                } catch (Exception inner) {
                    listener.onResponse(update);
    }
                            upsertRequest.getContentType()
                            response.getSeqNo(),
import org.opensearch.action.delete.DeleteResponse;
import org.opensearch.cluster.routing.ShardIterator;
 */
import java.io.IOException;
                        Tuple<? extends MediaType, Map<String, Object>> sourceAndContent = XContentHelper.convertToMap(
import org.opensearch.cluster.ClusterState;
                    } else {
    private final AutoCreateIndex autoCreateIndex;
                                sourceAndContent.v2(),
import org.opensearch.core.rest.RestStatus;
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.index.shard.IndexShard;
import org.opensearch.action.DocWriteRequest;
    private final IndicesService indicesService;
                );
                        response.getSeqNo(),
 */
                logger.trace(
                                }
        switch (result.getResponseResult()) {
 * software distributed under the License is distributed on an
        if (cause instanceof VersionConflictEngineException) {
import org.opensearch.common.xcontent.XContentHelper;
        }));
                                // we have the index, do it
                listener.onResponse(update);
 * ownership. Elasticsearch licenses this file to you under
                                try {
        resolveAndValidateRouting(state.metadata(), request.concreteIndex(), request);
                        @Override
                    UpdateResponse update = new UpdateResponse(
    private final UpdateHelper updateHelper;
                    deprecationLogger.deprecate(
 * specific language governing permissions and limitations
                                response.getSeqNo(),
 *
            .indexShards(clusterState, request.concreteIndex(), request.id(), request.routing());
 */
        ShardRouting shard;
                        response.getVersion(),
    private void innerExecute(final Task task, final UpdateRequest request, final ActionListener<UpdateResponse> listener) {
        listener.onFailure(cause instanceof Exception ? (Exception) cause : new NotSerializableExceptionWrapper(cause));
        final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
    }
        final ActionListener<UpdateResponse> listener,
                    update.setForcedRefresh(response.forcedRefresh());
                            response.getVersion(),
    @Override
                            result.updateSourceContentType(),
/*
                    update.setForcedRefresh(response.forcedRefresh());
                                sourceAndContent.v1(),
import org.opensearch.core.index.shard.ShardId;
    @Override
    }
        indicesService.addDocStatusStats(stats);
                    update.setGetResult(
                        response.getShardInfo(),
import org.opensearch.core.common.io.stream.NotSerializableExceptionWrapper;
                        UpdateHelper.extractGetResult(
                            innerExecute(task, request, listener);
                    "Retry attempt [{}] of [{}] on version conflict on [{}][{}][{}]",
    }
            throw e;
                        response.getShardInfo(),
                        UpdateHelper.extractGetResult(
        // Fail fast on the node that received the request, rather than failing when translating on the index or delete request.
import org.opensearch.common.settings.Settings;
                                response.getPrimaryTerm(),
                    UpdateResponse update = new UpdateResponse(
            indexNameExpressionResolver,
                // we fetch it from the index request so we don't generate the bytes twice, its already done in the index request
    }
                DocStatusStats stats = new DocStatusStats();
                        response.getResult()
                );
                final BytesReference upsertSourceBytes = upsertRequest.source();
                                upsertSourceBytes
import org.opensearch.cluster.metadata.Metadata;
        int retryCount
            if (retryCount < request.retryOnConflict()) {
import org.opensearch.common.collect.Tuple;
            case UPDATED:
/**
                        response.getVersion(),
                    listener.onResponse(update);
        if (request.getShardId() != null) {
                        )
                throw new IllegalStateException("Illegal result " + result.getResponseResult());
            clusterService,
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                        response.getPrimaryTerm(),
        shardOperation(request, listener, 0);
                        update.setGetResult(null);
                client.bulk(toSingleItemBulkRequest(upsertRequest), wrapBulkResponse(ActionListener.<IndexResponse>wrap(response -> {
 */
                            request.concreteIndex(),
                                    innerExecute(task, request, listener);
import org.opensearch.common.inject.Inject;
                            + indexRequest.index()
                        response.getSeqNo(),
                }, exception -> handleUpdateFailureWithRetry(listener, request, exception, retryCount))));
                    request.id()
        IndicesService indicesService,
                    request.index(),
 * not use this file except in compliance with the License.
import org.opensearch.transport.client.node.NodeClient;
                return new PlainShardIterator(shardIterator.shardId(), Collections.singletonList(shard));
        return TransportActions.isShardNotAvailableException(e);
        DocStatusStats stats = new DocStatusStats();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    request.retryOnConflict(),
    @Override
                            response.getVersion(),
 * this file be licensed under the Apache-2.0 license or a
/*
/*
                        }
                        public void onFailure(Exception e) {
        }
    }
import org.opensearch.index.IndexSettings;
    private final ClusterService clusterService;
                                request.concreteIndex(),
                    IndexShard shard = indexService.getShardOrNull(shardId.getId());
import org.opensearch.common.logging.DeprecationLogger;
                stats.inc(RestStatus.OK);
 * Transport action for updating an index
                final Settings indexSettings = indexService.getIndexSettings().getSettings();
import org.opensearch.index.engine.VersionConflictEngineException;
    private void incDocStatusStats(final Exception e) {
                            request,
                IndexService indexServiceOrNull = indicesService.indexService(shardId.getIndex());
        ShardIterator shardIterator = clusterService.operationRouting()
import org.opensearch.action.ActionRunnable;
            IndexNotFoundException e = new IndexNotFoundException(
        // if we don't have a master, we don't have metadata, that's fine, let it find a cluster-manager using create index API
 * compatible open source license.
                    if (request.fetchSource() != null && request.fetchSource().fetchSource()) {
                    }
        this.indicesService = indicesService;
    public TransportUpdateAction(
                            + "] has a default ingest pipeline or a final ingest pipeline, the support of the ingest pipelines for update operation causes unexpected result and will be removed in 3.0.0"
 * the Apache License, Version 2.0 (the "License"); you may
        final Throwable cause = unwrapCause(failure);
 * under the License.
                }, exception -> handleUpdateFailureWithRetry(listener, request, exception, retryCount))));
import org.opensearch.ExceptionsHelper;
            );
                indicesService.addDocStatusStats(stats);
 *
                        );
            case NOOP:
import static org.opensearch.action.bulk.TransportSingleItemBulkWriteAction.wrapBulkResponse;
        );
        UpdateHelper updateHelper,
                .indices()
import java.util.Collections;
            threadPool,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * SPDX-License-Identifier: Apache-2.0
            listener.onFailure(e);
                            null
                        );
                        )
    @Override
                        response.getVersion(),
import org.opensearch.index.IndexService;
        final ShardId shardId = request.getShardId();
                    }
import org.opensearch.indices.IndicesService;
            incDocStatusStats(e);
                    update.setForcedRefresh(response.forcedRefresh());
                request.index()
import java.util.Map;
public class TransportUpdateAction extends TransportInstanceSingleOperationAction<UpdateRequest, UpdateResponse> {
 * GitHub history for details.
        this.client = client;
import org.opensearch.core.xcontent.MediaType;
                            response.getSeqNo(),
                    );
        return indexService.getIndexSettings().getIndexMetadata().isSystem() ? Names.SYSTEM_WRITE : Names.WRITE;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(TransportUpdateAction.class);
                            upsertSourceBytes,
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.cluster.service.ClusterService;
                break;
package org.opensearch.action.update;
import static org.opensearch.action.bulk.TransportSingleItemBulkWriteAction.toSingleItemBulkRequest;
                UpdateResponse update = result.action();
                IndexRequest upsertRequest = result.action();
                    }
            actionFilters,
    @Inject
        if (request.routing() == null && metadata.routingRequired(concreteIndex)) {
            transportService,
                        response.getSeqNo(),
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.cluster.routing.ShardRouting;
                }
                        response.getPrimaryTerm(),
 *
                            response.getPrimaryTerm(),
import org.opensearch.threadpool.ThreadPool.Names;
                client.bulk(toSingleItemBulkRequest(deleteRequest), wrapBulkResponse(ActionListener.<DeleteResponse>wrap(response -> {
                DeleteRequest deleteRequest = result.action();
                final BytesReference indexSourceBytes = indexRequest.source();
            throw new RoutingMissingException(concreteIndex, request.id());
                        response.getResult()
                }
 * this work for additional information regarding copyright
    }
        super.doExecute(task, request, ActionListener.wrap(listener::onResponse, e -> {
                        response.getId(),
                            } else {
        this.updateHelper = updateHelper;
                        response.getId(),
                    new ActionListener<CreateIndexResponse>() {
        ActionFilters actionFilters,
                        response.getShardInfo(),
        } else {
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
    public static void resolveAndValidateRouting(Metadata metadata, String concreteIndex, UpdateRequest request) {
import org.opensearch.core.action.ActionListener;
                        response.getShardId(),
    }
import org.opensearch.transport.TransportService;
                        shard.noopUpdate();
import static org.opensearch.ExceptionsHelper.unwrapCause;
                                request,
                if (IndexSettings.DEFAULT_PIPELINE.exists(indexSettings) || IndexSettings.FINAL_PIPELINE.exists(indexSettings)) {
import org.opensearch.core.common.io.stream.StreamInput;
        this.clusterService = clusterService;
    }
 * Licensed to Elasticsearch under one or more contributor
                    retryCount + 1,
                            result.updatedSourceAsMap(),
}
                }, exception -> handleUpdateFailureWithRetry(listener, request, exception, retryCount))));
                threadPool.executor(executor(request.getShardId()))
        stats.inc(ExceptionsHelper.status(e));
                            request,
    protected ShardIterator shards(ClusterState clusterState, UpdateRequest request) {
import org.opensearch.action.delete.DeleteRequest;
                client.bulk(toSingleItemBulkRequest(indexRequest), wrapBulkResponse(ActionListener.<IndexResponse>wrap(response -> {
        }
import org.opensearch.cluster.routing.PlainShardIterator;
                            request.concreteIndex(),
    protected String executor(ShardId shardId) {
            innerExecute(task, request, listener);
import org.opensearch.action.support.TransportActions;
    protected boolean retryOnFailure(Exception e) {
                        "the index ["
                    .execute(ActionRunnable.wrap(listener, l -> shardOperation(request, l, retryCount + 1)));
        AutoCreateIndex autoCreateIndex,
        if (autoCreateIndex.shouldAutoCreate(request.index(), clusterService.state())) {
 * You may obtain a copy of the License at
            client.admin()
                            UpdateHelper.extractGetResult(
                                    listener.onFailure(inner);
    ) {
    protected void shardOperation(final UpdateRequest request, final ActionListener<UpdateResponse> listener, final int retryCount) {
        request.routing((metadata.resolveWriteIndexRouting(request.routing(), request.index())));
    }
                        response.getResult()
 * Unless required by applicable law or agreed to in writing,
        return new UpdateResponse(in);
                    );
                            result.updatedSourceAsMap(),
                "[" + DocWriteRequest.REQUIRE_ALIAS + "] request flag is [true] and [" + request.index() + "] is not an alias",
                            result.updateSourceContentType(),
        }
        final IndexShard indexShard = indexService.getShard(shardId.getId());
                IndexRequest indexRequest = result.action();
import org.opensearch.action.support.single.instance.TransportInstanceSingleOperationAction;
import org.opensearch.action.support.ActionFilters;
                    );
        }
                    listener.onResponse(update);
    }
                        response.getShardId(),
            return clusterState.routingTable().index(request.concreteIndex()).shard(request.getShardId().getId()).primaryShardIt();
                        }
        NodeClient client
                        "update_operation_with_ingest_pipeline",
                    );
            UpdateAction.NAME,
    ) {
import org.opensearch.action.admin.indices.stats.DocStatusStats;
                            response.getPrimaryTerm(),
    private final NodeClient client;
        ClusterService clusterService,
 * @opensearch.internal
                    request.getShardId(),
    @Override
        super(
        return new PlainShardIterator(shardIterator.shardId(), Collections.emptyList());
            case CREATED:
        }
import org.opensearch.action.index.IndexResponse;
            }
                    );
                            }
        final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
    @Override
                                listener.onFailure(e);
            case DELETED:
    }
        TransportService transportService,
                break;
                        public void onResponse(CreateIndexResponse result) {
 * The OpenSearch Contributors require contributions made to
    protected void doExecute(Task task, final UpdateRequest request, final ActionListener<UpdateResponse> listener) {
    private void handleUpdateFailureWithRetry(
                                    inner.addSuppressed(e);
                            )
        final UpdateHelper.Result result = updateHelper.prepare(request, indexShard, threadPool::absoluteTimeInMillis);
        this.autoCreateIndex = autoCreateIndex;
import org.opensearch.action.RoutingMissingException;
        ThreadPool threadPool,
import org.opensearch.ResourceAlreadyExistsException;
                    if (shard != null) {
            UpdateRequest::new
import org.opensearch.threadpool.ThreadPool;
 * KIND, either express or implied.  See the License for the
        while ((shard = shardIterator.nextOrNull()) != null) {
    protected void resolveRequest(ClusterState state, UpdateRequest request) {
                    );
            if (shard.primary()) {
 * license agreements. See the NOTICE file distributed with
                            indexSourceBytes
                            true,
import org.opensearch.tasks.Task;
                .create(
                // we fetch it from the index request so we don't generate the bytes twice, its already done in the index request
