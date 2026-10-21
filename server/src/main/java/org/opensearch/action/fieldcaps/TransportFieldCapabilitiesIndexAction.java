public class TransportFieldCapabilitiesIndexAction extends HandledTransportAction<
        FieldCapabilitiesIndexResponse::new
        }
        private AsyncShardsAction(FieldCapabilitiesIndexRequest request, ActionListener<FieldCapabilitiesIndexResponse> listener) {
                        }
    }
import org.opensearch.action.ActionRunnable;
 */
import org.opensearch.action.support.HandledTransportAction;
        transportService.registerRequestHandler(
                                null,
/**
            return new FieldCapabilitiesIndexResponse(request.index(), Collections.emptyMap(), false);
    private final Executor executor;
        TransportService transportService,
            }
        }
                            onFailure(shardRouting, exp);
                            )
            if (next != null) {
                            parentField,
import org.opensearch.transport.TransportException;
            if (logger.isTraceEnabled()) {
import org.opensearch.transport.TransportChannel;
import org.opensearch.index.IndexService;
                        @Override
import static org.opensearch.action.support.TransportActions.isShardNotAvailableException;
    }
 * software distributed under the License is distributed on an
import java.util.function.Predicate;
            tryNext(null, true);
                    if (responseMap.containsKey(parentField)) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.logging.LoggerMessageFormat;
                        }
    private ClusterBlockException checkGlobalBlock(ClusterState state) {
 */
    private final TransportService transportService;
/*
                while (dotIndex > -1) {
import org.opensearch.cluster.routing.ShardIterator;
                    }
                    node,
                            return ThreadPool.Names.SAME;
     * @opensearch.internal
        ThreadPool threadPool,
import org.opensearch.search.internal.ShardSearchRequest;
        Predicate<String> fieldPredicate = indicesService.getFieldFilter().apply(shardId.getIndexName());
import org.opensearch.tasks.Task;
                }
            if (blockException != null) {
                return null;
import org.apache.logging.log4j.Logger;
            ++shardIndex;
        this.transportService = transportService;
            if (blockException != null) {
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
            nodes = clusterState.nodes();
        private ShardRouting nextRoutingOrNull(Exception failure) {
    private static final String ACTION_SHARD_NAME = ACTION_NAME + "[s]";
    private boolean canMatchShard(FieldCapabilitiesIndexRequest req) throws IOException {
                if (canMatchShard == false) {
 *
                        );
}
        private void onFailure(ShardRouting shardRouting, Exception e) {
 * compatible open source license.
        IndexSettings indexSettings = indexService.getIndexSettings();
                        @Override
 * Licensed to Elasticsearch under one or more contributor
                            // parentField is part of a literal dotted field name under a disable_objects=true parent
                    if (lastFailure == null || isShardNotAvailableException(lastFailure)) {
                    // On a pluggable data format index, doc-values-backed fields can be searched, so
import org.opensearch.search.internal.AliasFilter;
     * to create the final {@link FieldCapabilitiesIndexResponse}.
 * Modifications Copyright OpenSearch Contributors. See
                onFailure(shardRouting, new NoShardAvailableActionException(shardRouting.shardId()));
import org.opensearch.action.NoShardAvailableActionException;
                        break;
                    // checks if the parent field contains sub-fields
            new ShardTransportHandler()
 * this file be licensed under the Apache-2.0 license or a
                    }
        private void tryNext(@Nullable final Exception lastFailure, boolean canMatchShard) {
    @Override
                        String type = mapper.nested().isNested() ? "nested" : "object";
            tryNext(e, false);
     */
    private static final String ACTION_NAME = FieldCapabilitiesAction.NAME + "[index]";
        ShardSearchRequest searchRequest = new ShardSearchRequest(req.shardId(), req.nowInMillis(), AliasFilter.EMPTY);
                }
            ShardRouting next = FailAwareWeightedRouting.getInstance()
                                LoggerMessageFormat.format("No shard available for [{}]", request),
 * GitHub history for details.
                        searchable = ft.isSearchableViaDocValues(indexSettings);
        searchRequest.source(new SearchSourceBuilder().query(req.indexFilter()));
        Set<String> fieldNames = new HashSet<>();
import org.opensearch.action.support.TransportIndicesResolvingAction;
 *
    private final ClusterService clusterService;
                    listener.onResponse(new FieldCapabilitiesIndexResponse(request.index(), Collections.emptyMap(), false));
            }
                            continue;
                        public String executor() {
                    if (mapperService.fieldType(parentField) == null) {
    /**
            throws Exception {
    private class ShardTransportHandler implements TransportRequestHandler<FieldCapabilitiesIndexRequest> {
                    new TransportResponseHandler<FieldCapabilitiesIndexResponse>() {
                        // we added this path on another field already
            DiscoveryNode node = nodes.get(shardRouting.currentNodeId());
        }
import org.opensearch.search.SearchService;
                        public FieldCapabilitiesIndexResponse read(StreamInput in) throws IOException {
                );
                        responseMap.put(parentField, fieldCap);
            ClusterBlockException blockException = checkGlobalBlock(clusterState);
                    IndexFieldCapabilities fieldCap = new IndexFieldCapabilities(
                            return new FieldCapabilitiesIndexResponse(in);
            }
                        public void handleResponse(final FieldCapabilitiesIndexResponse response) {
        private void moveToNextShard() {
                }
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.metadata.ResolvedIndices;
import org.opensearch.cluster.block.ClusterBlockException;
 */
            }
                            } else {
        ClusterService clusterService,
                    // report searchability accordingly; otherwise use the plain indexed flag.
            ActionListener<FieldCapabilitiesIndexResponse> listener = new ChannelActionListener<>(channel, ACTION_SHARD_NAME, request);
package org.opensearch.action.fieldcaps;
 * license agreements. See the NOTICE file distributed with
            if (ft != null) {
import org.opensearch.common.inject.Inject;
import java.util.Collections;
                throw blockException;
    ) {
import org.opensearch.action.support.ActionFilters;
            } else {
                        searchable = ft.isSearchable();
 */
            }
                    );
        private final ActionListener<FieldCapabilitiesIndexResponse> listener;
    private final SearchService searchService;
     *
                        listener.onFailure(lastFailure);
     * @opensearch.internal
                logger.trace("executing [{}]", request);
    FieldCapabilitiesIndexRequest,
                        }
                            if (response.canMatch()) {
    private final IndicesService indicesService;
import org.opensearch.index.mapper.ObjectMapper;
                    }
    }
import org.apache.logging.log4j.message.ParameterizedMessage;
     *
        IndexNameExpressionResolver indexNameExpressionResolver
        public void messageReceived(final FieldCapabilitiesIndexRequest request, final TransportChannel channel, Task task)
            ACTION_SHARD_NAME,
            if (shardRouting == null) {
 * specific language governing permissions and limitations
        }
                            false,
import java.util.concurrent.Executor;
 * SPDX-License-Identifier: Apache-2.0
                            }
                    } else {
    protected void doExecute(Task task, FieldCapabilitiesIndexRequest request, ActionListener<FieldCapabilitiesIndexResponse> listener) {
                                tryNext(null, false);
        return state.blocks().globalBlockedException(ClusterBlockLevel.READ);
 * @opensearch.internal
            moveToNextShard();
            this.listener = listener;
import org.opensearch.cluster.node.DiscoveryNode;
 * KIND, either express or implied.  See the License for the
    private FieldCapabilitiesIndexResponse shardOperation(final FieldCapabilitiesIndexRequest request) throws IOException {
    FieldCapabilitiesIndexResponse> implements TransportIndicesResolvingAction<FieldCapabilitiesIndexRequest> {
        private final DiscoveryNodes nodes;
        }
            this.request = request;
            FieldCapabilitiesIndexRequest::new,
import org.apache.logging.log4j.LogManager;
                    ACTION_SHARD_NAME,
                        // no field type, it must be an object field
        this.executor = threadPool.executor(ThreadPool.Names.MANAGEMENT);
import org.opensearch.index.query.MatchAllQueryBuilder;
 * ownership. Elasticsearch licenses this file to you under
     * {@link FieldCapabilitiesIndexRequest#indexFilter()}. In which case the shard is used
                return;
import org.opensearch.transport.TransportResponseHandler;
        private final GroupShardsIterator<ShardIterator> shardsIt;
            return nextRoutingOrNull(failure);
                        ft.meta()
        for (String field : request.fields()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * the Apache License, Version 2.0 (the "License"); you may
                        listener.onFailure(
import java.io.IOException;
    public ResolvedIndices resolveIndices(FieldCapabilitiesIndexRequest request) {
                return next;
                    } else {
                    continue;
        private volatile int shardIndex = 0;
            return true;
                    boolean searchable;
import java.util.HashMap;
import org.opensearch.cluster.routing.ShardRouting;
                    }
 * You may obtain a copy of the License at
        }
                    }
                        @Override
                        public void handleException(TransportException exp) {
                        );
 *
                .findNext(shardsIt.get(shardIndex), clusterService.state(), failure, this::moveToNextShard);
                        }
import org.opensearch.transport.TransportRequestHandler;
        if (canMatchShard(request) == false) {
import org.opensearch.cluster.routing.FailAwareWeightedRouting;
 *
                } else {
        ShardId shardId = request.shardId();
                        field,
        private final FieldCapabilitiesIndexRequest request;
    public TransportFieldCapabilitiesIndexAction(
            MappedFieldType ft = mapperService.fieldType(field);
import org.opensearch.core.index.shard.ShardId;
                        @Override
                        }
        public void start() {
        this.clusterService = clusterService;
            if (logger.isTraceEnabled()) {
        }
            }
            ClusterState clusterState = clusterService.state();
    @Inject
    }
                                moveToNextShard();
            if (node == null) {
                            false,
            fieldNames.addAll(mapperService.simpleMatchToFullName(field));
                    request,
        @Override
     * Shard transport handler for field capabilities index action
                                listener.onResponse(response);
                // add nested and object fields
import org.opensearch.index.IndexSettings;
                } else {
        ActionFilters actionFilters,
                            Collections.emptyMap()
        }
/*
                    String parentField = ft.name().substring(0, dotIndex);
                request.shardId(shardRouting.shardId());
import java.util.Set;
                logger.trace(() -> new ParameterizedMessage("{}: failed to execute [{}]", shardRouting, request), e);
    }
        this.indicesService = indicesService;
import org.opensearch.cluster.routing.GroupShardsIterator;
                    dotIndex = parentField.lastIndexOf('.');
        new AsyncShardsAction(request, listener).start();
        return ResolvedIndices.of(request.index());
                            dotIndex = parentField.lastIndexOf('.');
 * The OpenSearch Contributors require contributions made to
                        logger.debug(() -> new ParameterizedMessage("{}: failed to execute [{}]", null, request), lastFailure);
                        if (mapper == null) {
        assert req.nowInMillis() != 0L;
    public static final ActionType<FieldCapabilitiesIndexResponse> TYPE = new ActionType<>(
                transportService.sendRequest(
                        ft.isAggregatable(),
    class AsyncShardsAction {
        }
    private ClusterBlockException checkRequestBlock(ClusterState state, String concreteIndex) {
            shardsIt = clusterService.operationRouting().searchShards(clusterService.state(), new String[] { request.index() }, null, null);
                        ObjectMapper mapper = mapperService.getObjectMapper(parentField);
                    logger.trace("sending request [{}] on node [{}]", request, node);
    }
     */
                            // No ObjectMapper exists for this intermediate path so skip it and continue up the chain
    private static final Logger logger = LogManager.getLogger(TransportFieldCapabilitiesIndexAction.class);
                        searchable,
                        IndexFieldCapabilities fieldCap = new IndexFieldCapabilities(
import org.opensearch.indices.IndicesService;
            ShardRouting shardRouting = nextRoutingOrNull(lastFailure);
 * Transport action for field capabilities request in an index
            }
            ThreadPool.Names.SAME,
        );
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
     * An action that executes on each shard sequentially until it finds one that can match the provided
        this.searchService = searchService;
import org.opensearch.action.support.ChannelActionListener;
            if (shardsIt.size() == 0 || shardIndex >= shardsIt.size()) {
    }
        MapperService mapperService = indexService.mapperService();
                    responseMap.put(field, fieldCap);
                                lastFailure
        ACTION_NAME,
    /**
    }
import org.opensearch.index.mapper.MapperService;
import org.opensearch.index.mapper.MappedFieldType;
            }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
        IndicesService indicesService,
        return new FieldCapabilitiesIndexResponse(request.index(), responseMap, true);
        }
import org.opensearch.action.ActionType;
        SearchService searchService,
                throw blockException;
                int dotIndex = ft.name().lastIndexOf('.');
                if (logger.isTraceEnabled()) {
        for (String field : fieldNames) {
import java.util.Map;
import org.opensearch.cluster.node.DiscoveryNodes;
                        ft.familyTypeName(),
            blockException = checkRequestBlock(clusterState, request.index());
 * not use this file except in compliance with the License.
            }
                            new NoShardAvailableActionException(
import org.opensearch.transport.TransportService;
 * this work for additional information regarding copyright
        }
import org.opensearch.core.common.io.stream.StreamInput;
                logger.trace("executing [{}] based on cluster state version [{}]", request, clusterState.version());
                    if (indexSettings.isPluggableDataFormatEnabled()) {
import org.opensearch.common.Nullable;
    );
            if (e != null) {
            }
    @Override
        if (req.indexFilter() == null || req.indexFilter() instanceof MatchAllQueryBuilder) {
import org.opensearch.search.builder.SearchSourceBuilder;
import java.util.HashSet;
                            type,
import org.opensearch.cluster.service.ClusterService;
        return searchService.canMatch(searchRequest).canMatch();
                if (indicesService.isMetadataField(field) || fieldPredicate.test(ft.name())) {
/*
import org.opensearch.threadpool.ThreadPool;
 * under the License.
        return state.blocks().indexBlockedException(ClusterBlockLevel.READ, concreteIndex);
        Map<String, IndexFieldCapabilities> responseMap = new HashMap<>();
            executor.execute(ActionRunnable.supply(listener, () -> shardOperation(request)));
        super(ACTION_NAME, transportService, actionFilters, FieldCapabilitiesIndexRequest::new);
import org.opensearch.cluster.block.ClusterBlockLevel;
