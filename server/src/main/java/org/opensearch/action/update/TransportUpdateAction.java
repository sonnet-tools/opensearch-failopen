                }, exception -> handleUpdateFailureWithRetry(listener, request, exception, retryCount))));  
    }
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(TransportUpdateAction.class);
                final BytesReference indexSourceBytes = indexRequest.source();
        stats.inc(ExceptionsHelper.status(e));  
                }
                request.index()
            case CREATED:  
 * specific language governing permissions and limitations
                            UpdateHelper.extractGetResult(  
    }
        int retryCount
                                request,
        ShardRouting shard;
                                sourceAndContent.v1(),
                        response.getVersion(),
                            response.getPrimaryTerm(),  
                            response.getVersion(),
        indicesService.addDocStatusStats(stats);
                        )
        if (autoCreateIndex.shouldAutoCreate(request.index(), clusterService.state())) {  
                    update.setForcedRefresh(response.forcedRefresh());
            case UPDATED:
                        public void onResponse(CreateIndexResponse result) {
import org.opensearch.action.support.AutoCreateIndex;
    }
                            response.getSeqNo(),
                        Tuple<? extends MediaType, Map<String, Object>> sourceAndContent = XContentHelper.convertToMap(  
import org.opensearch.core.action.ActionListener;
 * this work for additional information regarding copyright
 */
        final ActionListener<UpdateResponse> listener,
                        );
    @Override
                        response.getShardId(),  
                        response.getPrimaryTerm(),
            .indexShards(clusterState, request.concreteIndex(), request.id(), request.routing());  
import org.opensearch.core.common.io.stream.StreamInput;
            indexNameExpressionResolver,  
 * license agreements. See the NOTICE file distributed with
                break;
    protected UpdateResponse newResponse(StreamInput in) throws IOException {
    }
                                response.getSeqNo(),  
    }
        shardOperation(request, listener, 0);  
                        response.getSeqNo(),
                    request.retryOnConflict(),  
    private final NodeClient client;  
        request.routing((metadata.resolveWriteIndexRouting(request.routing(), request.index())));
                    listener.onResponse(update);
}  
import org.opensearch.cluster.routing.PlainShardIterator;
                            response.getVersion(),  
import org.opensearch.common.inject.Inject;
            transportService,
                            response.getSeqNo(),
import java.util.Map;
        if (cause instanceof VersionConflictEngineException) {
public class TransportUpdateAction extends TransportInstanceSingleOperationAction<UpdateRequest, UpdateResponse> {
                            request,  
        ActionFilters actionFilters,  
    protected void shardOperation(final UpdateRequest request, final ActionListener<UpdateResponse> listener) {
                IndexRequest indexRequest = result.action();
import org.opensearch.core.rest.RestStatus;
import org.opensearch.action.delete.DeleteResponse;
                DeleteRequest deleteRequest = result.action();
package org.opensearch.action.update;
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        }
        TransportService transportService,
        } else {  
    ) {
                }, exception -> handleUpdateFailureWithRetry(listener, request, exception, retryCount))));
                                // we have the index, do it
        if (request.isRequireAlias() && (clusterService.state().getMetadata().hasAlias(request.index()) == false)) {
                    update.setForcedRefresh(response.forcedRefresh());
        resolveAndValidateRouting(state.metadata(), request.concreteIndex(), request);
                    );  
    private void handleUpdateFailureWithRetry(  
                "[" + DocWriteRequest.REQUIRE_ALIAS + "] request flag is [true] and [" + request.index() + "] is not an alias",
                return;
        super.doExecute(task, request, ActionListener.wrap(listener::onResponse, e -> {  
            default:
                        update.setGetResult(
    @Override  
import static org.opensearch.ExceptionsHelper.unwrapCause;
        final UpdateRequest request,
import org.opensearch.common.collect.Tuple;  
        this.updateHelper = updateHelper;  
                        UpdateHelper.extractGetResult(
                            result.updatedSourceAsMap(),
            clusterService,  
                                sourceAndContent.v2(),  
    protected String executor(ShardId shardId) {
import org.opensearch.core.common.bytes.BytesReference;  
                            true,
                    if (request.fetchSource() != null && request.fetchSource().fetchSource()) {
                        response.getId(),
    public TransportUpdateAction(
            throw e;  
    protected boolean retryOnFailure(Exception e) {
    public static void resolveAndValidateRouting(Metadata metadata, String concreteIndex, UpdateRequest request) {
import org.opensearch.threadpool.ThreadPool.Names;
                                    innerExecute(task, request, listener);
            }
import org.opensearch.action.delete.DeleteRequest;  
                .create(  
                            } else {  
import org.opensearch.cluster.routing.ShardIterator;  
    private void incDocStatusStats(final Exception e) {
                        )
                        response.getVersion(),  
                                try {  
    }
            listener.onFailure(e);
    }  
 * software distributed under the License is distributed on an
    protected ShardIterator shards(ClusterState clusterState, UpdateRequest request) {
        return new UpdateResponse(in);  
            incDocStatusStats(e);
import org.opensearch.indices.IndicesService;
    protected void shardOperation(final UpdateRequest request, final ActionListener<UpdateResponse> listener, final int retryCount) {  
                        shard.noopUpdate();
                UpdateResponse update = result.action();  
        DocStatusStats stats = new DocStatusStats();
                }
        if (request.routing() == null && metadata.routingRequired(concreteIndex)) {
    private final AutoCreateIndex autoCreateIndex;  
                        response.getShardId(),
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.IndexNotFoundException;  
 * Unless required by applicable law or agreed to in writing,
            if (shard.primary()) {  
                            innerExecute(task, request, listener);
 */  
                    IndexShard shard = indexService.getShardOrNull(shardId.getId());  
import org.opensearch.core.xcontent.MediaType;
                            )  
                            result.updateSourceContentType(),  
        final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());  
    @Inject  
                            response.getPrimaryTerm(),
import org.opensearch.threadpool.ThreadPool;
/**
                                    listener.onFailure(inner);
                        response.getSeqNo(),  
 * GitHub history for details.
import org.opensearch.tasks.Task;  
                                    inner.addSuppressed(e);  
import org.opensearch.core.index.shard.ShardId;  
                    request.index(),
        }));  
 */  
 * You may obtain a copy of the License at  
        return indexService.getIndexSettings().getIndexMetadata().isSystem() ? Names.SYSTEM_WRITE : Names.WRITE;
                            if (unwrapCause(e) instanceof ResourceAlreadyExistsException) {
    private final IndicesService indicesService;
        }  
        // Fail fast on the node that received the request, rather than failing when translating on the index or delete request.  
        ThreadPool threadPool,
import org.opensearch.index.IndexSettings;
import org.opensearch.action.index.IndexResponse;  
                            request.concreteIndex(),
import org.opensearch.cluster.routing.ShardRouting;
 * under the License.  
                    UpdateResponse update = new UpdateResponse(
                    request.id()  
        }
                break;  
                        "update_operation_with_ingest_pipeline",
                DocStatusStats stats = new DocStatusStats();  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.xcontent.XContentHelper;
                        response.getId(),
        if (request.getShardId() != null) {
                return new PlainShardIterator(shardIterator.shardId(), Collections.singletonList(shard));
                    } else {
                        public void onFailure(Exception e) {  
            throw new RoutingMissingException(concreteIndex, request.id());
                            }
                // we fetch it from the index request so we don't generate the bytes twice, its already done in the index request
    protected void resolveRequest(ClusterState state, UpdateRequest request) {  
 * this file be licensed under the Apache-2.0 license or a
    @Override
                    listener.onResponse(update);  
                    );
        listener.onFailure(cause instanceof Exception ? (Exception) cause : new NotSerializableExceptionWrapper(cause));
 *
        this.autoCreateIndex = autoCreateIndex;
 * KIND, either express or implied.  See the License for the
                            + indexRequest.index()
 *     http://www.apache.org/licenses/LICENSE-2.0
                            + "] has a default ingest pipeline or a final ingest pipeline, the support of the ingest pipelines for update operation causes unexpected result and will be removed in 3.0.0"
 * not use this file except in compliance with the License.
import static org.opensearch.action.bulk.TransportSingleItemBulkWriteAction.toSingleItemBulkRequest;
                IndexService indexServiceOrNull = indicesService.indexService(shardId.getIndex());
                    update.setGetResult(
                final Settings indexSettings = indexService.getIndexSettings().getSettings();
            }
        ClusterService clusterService,  
                        response.getPrimaryTerm(),
        final UpdateHelper.Result result = updateHelper.prepare(request, indexShard, threadPool::absoluteTimeInMillis);
        }  
 *  
import org.opensearch.action.RoutingMissingException;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            UpdateAction.NAME,
        return TransportActions.isShardNotAvailableException(e);
        AutoCreateIndex autoCreateIndex,  
import org.opensearch.common.logging.DeprecationLogger;
import org.opensearch.core.common.io.stream.NotSerializableExceptionWrapper;
import org.opensearch.common.settings.Settings;  
 * compatible open source license.
                break;  
            case DELETED:
                        response.getResult()
                listener.onResponse(update);
        final IndexShard indexShard = indexService.getShard(shardId.getId());  
                    if (shard != null) {
 *
import org.opensearch.action.admin.indices.create.CreateIndexRequest;  
                IndexRequest upsertRequest = result.action();
                        response.getVersion(),
    @Override
import org.opensearch.index.engine.VersionConflictEngineException;  
                        @Override  
import org.opensearch.action.support.single.instance.TransportInstanceSingleOperationAction;
                                }
                        "the index ["  
                    new ActionListener<CreateIndexResponse>() {
                    .execute(ActionRunnable.wrap(listener, l -> shardOperation(request, l, retryCount + 1)));  
        NodeClient client
        final Exception failure,  
                        );
import org.opensearch.ExceptionsHelper;
                    }
                        UpdateHelper.extractGetResult(
                                listener.onFailure(e);
                                request.concreteIndex(),
        this.clusterService = clusterService;
                    update.setGetResult(  
        // if we don't have a master, we don't have metadata, that's fine, let it find a cluster-manager using create index API
import org.opensearch.cluster.service.ClusterService;
 * @opensearch.internal
import static org.opensearch.action.bulk.TransportSingleItemBulkWriteAction.wrapBulkResponse;  
import org.opensearch.transport.TransportService;  
 * ownership. Elasticsearch licenses this file to you under  
                            null
                    );
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
                stats.inc(RestStatus.OK);
    }
        final ShardId shardId = request.getShardId();
        }  
                threadPool.executor(executor(request.getShardId()))
    @Override  
 */  
        switch (result.getResponseResult()) {
                                upsertSourceBytes
                final BytesReference upsertSourceBytes = upsertRequest.source();  
import org.opensearch.cluster.metadata.Metadata;
        this.client = client;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.ResourceAlreadyExistsException;
        UpdateHelper updateHelper,
                            indexSourceBytes  
    }
                                response.getPrimaryTerm(),
            if (retryCount < request.retryOnConflict()) {
                            result.updateSourceContentType(),
    @Override  
                        @Override
/*  
        return new PlainShardIterator(shardIterator.shardId(), Collections.emptyList());
                // we fetch it from the index request so we don't generate the bytes twice, its already done in the index request  
import org.opensearch.action.support.ActionFilters;
                                response.getVersion(),
import org.opensearch.action.DocWriteRequest;
                        }  
                        response.getShardId(),
    }
    private final ClusterService clusterService;
 * Transport action for updating an index  
        );
                        response.getSeqNo(),
                logger.trace(  
                    deprecationLogger.deprecate(
            incDocStatusStats(e);
                    );
                    request.getShardId(),
import org.opensearch.transport.client.node.NodeClient;
        }
        IndexNameExpressionResolver indexNameExpressionResolver,
        this.indicesService = indicesService;
                    listener.onResponse(update);
                                } catch (Exception inner) {
                break;  
            threadPool,
        final Throwable cause = unwrapCause(failure);  
                indicesService.addDocStatusStats(stats);  
                .indices()
                            request,
                    UpdateResponse update = new UpdateResponse(
 * The OpenSearch Contributors require contributions made to  
                            result.updatedSourceAsMap(),
            UpdateRequest::new
                        response.getShardInfo(),  
import org.opensearch.index.shard.IndexShard;
            client.admin()
            return clusterState.routingTable().index(request.concreteIndex()).shard(request.getShardId().getId()).primaryShardIt();  
import org.opensearch.action.index.IndexRequest;
            innerExecute(task, request, listener);
        super(  
        final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
import org.opensearch.action.ActionRunnable;  
    @Override
            IndexNotFoundException e = new IndexNotFoundException(  
 *
                            upsertRequest.getContentType()  
                if (indexServiceOrNull != null) {
                            request.concreteIndex(),  
/*  
                    UpdateResponse update = new UpdateResponse(  
import org.opensearch.index.IndexService;
/*
import org.opensearch.action.admin.indices.stats.DocStatusStats;
                throw new IllegalStateException("Illegal result " + result.getResponseResult());
import java.util.Collections;
                        response.getResult()
import org.opensearch.action.support.TransportActions;  
                );
                        response.getShardInfo(),
        ShardIterator shardIterator = clusterService.operationRouting()
            );  
            case NOOP:
    private final UpdateHelper updateHelper;
    ) {
                        response.getShardInfo(),
                client.bulk(toSingleItemBulkRequest(indexRequest), wrapBulkResponse(ActionListener.<IndexResponse>wrap(response -> {
                );
                        }  
        while ((shard = shardIterator.nextOrNull()) != null) {
                    "Retry attempt [{}] of [{}] on version conflict on [{}][{}][{}]",
                    update.setForcedRefresh(response.forcedRefresh());  
                        response.getId(),  
                client.bulk(toSingleItemBulkRequest(deleteRequest), wrapBulkResponse(ActionListener.<DeleteResponse>wrap(response -> {  
                client.bulk(toSingleItemBulkRequest(upsertRequest), wrapBulkResponse(ActionListener.<IndexResponse>wrap(response -> {
                }, exception -> handleUpdateFailureWithRetry(listener, request, exception, retryCount))));
import org.opensearch.cluster.ClusterState;
    private void innerExecute(final Task task, final UpdateRequest request, final ActionListener<UpdateResponse> listener) {
                        response.getPrimaryTerm(),  
    }
                    );  
                    );  
                    }  
                if (IndexSettings.DEFAULT_PIPELINE.exists(indexSettings) || IndexSettings.FINAL_PIPELINE.exists(indexSettings)) {  
        }  
                    new CreateIndexRequest().index(request.index()).cause("auto(update api)").clusterManagerNodeTimeout(request.timeout()),
                        update.setGetResult(null);  
        IndicesService indicesService,
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
                    retryCount + 1,
    protected void doExecute(Task task, final UpdateRequest request, final ActionListener<UpdateResponse> listener) {
                        response.getResult()  
                    }
                            upsertSourceBytes,
            actionFilters,
    }
