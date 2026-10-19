            if (shardsIt.size() == 0 || shardIndex >= shardsIt.size()) {
     * @opensearch.internal
                            new NoShardAvailableActionException(
import org.opensearch.cluster.block.ClusterBlockException;  
                        String type = mapper.nested().isNested() ? "nested" : "object";
 *  
                            }
        }
 * Transport action for field capabilities request in an index  
                        );  
        searchRequest.source(new SearchSourceBuilder().query(req.indexFilter()));
import org.opensearch.search.builder.SearchSourceBuilder;
            shardsIt = clusterService.operationRouting().searchShards(clusterService.state(), new String[] { request.index() }, null, null);
        private void tryNext(@Nullable final Exception lastFailure, boolean canMatchShard) {  
 * specific language governing permissions and limitations
            return nextRoutingOrNull(failure);
        ShardId shardId = request.shardId();
            this.request = request;
        return new FieldCapabilitiesIndexResponse(request.index(), responseMap, true);
                        }
    protected void doExecute(Task task, FieldCapabilitiesIndexRequest request, ActionListener<FieldCapabilitiesIndexResponse> listener) {  
import org.opensearch.cluster.routing.ShardIterator;
                        IndexFieldCapabilities fieldCap = new IndexFieldCapabilities(  
        private void onFailure(ShardRouting shardRouting, Exception e) {
import org.apache.logging.log4j.Logger;
                } else {
import java.util.concurrent.Executor;  
                    // report searchability accordingly; otherwise use the plain indexed flag.
    /**
                        if (mapper == null) {
 * compatible open source license.
            tryNext(null, true);
import org.apache.logging.log4j.message.ParameterizedMessage;  
    }
        }
        for (String field : fieldNames) {  
                            parentField,
    private boolean canMatchShard(FieldCapabilitiesIndexRequest req) throws IOException {
    private ClusterBlockException checkGlobalBlock(ClusterState state) {
        if (req.indexFilter() == null || req.indexFilter() instanceof MatchAllQueryBuilder) {
        private void moveToNextShard() {
import org.opensearch.cluster.metadata.ResolvedIndices;  
                        logger.debug(() -> new ParameterizedMessage("{}: failed to execute [{}]", null, request), lastFailure);  
                    boolean searchable;  
    private static final Logger logger = LogManager.getLogger(TransportFieldCapabilitiesIndexAction.class);
                }
     * to create the final {@link FieldCapabilitiesIndexResponse}.  
            }
                        ObjectMapper mapper = mapperService.getObjectMapper(parentField);
                        ft.familyTypeName(),
            }  
                        public FieldCapabilitiesIndexResponse read(StreamInput in) throws IOException {  
            }  
    }
                        }
import java.util.HashMap;
}  
                throw blockException;
     * An action that executes on each shard sequentially until it finds one that can match the provided
                                listener.onResponse(response);  
/**
    ) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.HandledTransportAction;  
import org.apache.logging.log4j.LogManager;
        return searchService.canMatch(searchRequest).canMatch();
                    );  
                        public void handleException(TransportException exp) {
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
                    // checks if the parent field contains sub-fields
        ACTION_NAME,
            ++shardIndex;  
 *
            this.listener = listener;
    private final IndicesService indicesService;
            return true;  
    }
                    } else {  
                        responseMap.put(parentField, fieldCap);
        public void messageReceived(final FieldCapabilitiesIndexRequest request, final TransportChannel channel, Task task)  
        TransportService transportService,
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.service.ClusterService;
                        searchable = ft.isSearchableViaDocValues(indexSettings);
        Set<String> fieldNames = new HashSet<>();  
                return;
/*  
import org.opensearch.transport.TransportService;
    public ResolvedIndices resolveIndices(FieldCapabilitiesIndexRequest request) {
 * this work for additional information regarding copyright
    private final Executor executor;  
                        break;
        this.searchService = searchService;  
                            Collections.emptyMap()
 *
import org.opensearch.action.support.ChannelActionListener;
        return state.blocks().indexBlockedException(ClusterBlockLevel.READ, concreteIndex);
                    // On a pluggable data format index, doc-values-backed fields can be searched, so
                return null;
 * The OpenSearch Contributors require contributions made to  
                        @Override
                    if (lastFailure == null || isShardNotAvailableException(lastFailure)) {  
                            return new FieldCapabilitiesIndexResponse(in);
    /**  
    private final TransportService transportService;  
                        );
                logger.trace("executing [{}] based on cluster state version [{}]", request, clusterState.version());
                    new TransportResponseHandler<FieldCapabilitiesIndexResponse>() {  
import org.opensearch.search.SearchService;  
                    node,  
                            false,  
            if (next != null) {
            ClusterBlockException blockException = checkGlobalBlock(clusterState);
    FieldCapabilitiesIndexResponse> implements TransportIndicesResolvingAction<FieldCapabilitiesIndexRequest> {  
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.fieldcaps;
                request.shardId(shardRouting.shardId());
import org.opensearch.transport.TransportChannel;  
            }
                return next;
     *
     */  
                            false,
import org.opensearch.core.index.shard.ShardId;
                        ft.isAggregatable(),
                // add nested and object fields
                }
    }
import java.io.IOException;  
import org.opensearch.index.mapper.MappedFieldType;
            if (shardRouting == null) {
        assert req.nowInMillis() != 0L;
    private ClusterBlockException checkRequestBlock(ClusterState state, String concreteIndex) {  
import org.opensearch.cluster.node.DiscoveryNodes;
            fieldNames.addAll(mapperService.simpleMatchToFullName(field));
public class TransportFieldCapabilitiesIndexAction extends HandledTransportAction<
     *
            ThreadPool.Names.SAME,
import org.opensearch.cluster.node.DiscoveryNode;
                            // parentField is part of a literal dotted field name under a disable_objects=true parent  
                        }
            if (ft != null) {
            ActionListener<FieldCapabilitiesIndexResponse> listener = new ChannelActionListener<>(channel, ACTION_SHARD_NAME, request);
                    }
            nodes = clusterState.nodes();
        private final FieldCapabilitiesIndexRequest request;
            if (logger.isTraceEnabled()) {
            throws Exception {
                throw blockException;
            ShardRouting shardRouting = nextRoutingOrNull(lastFailure);
                                moveToNextShard();
import java.util.Set;
     */  
        transportService.registerRequestHandler(  
                        ft.meta()
    @Override
            } else {  
                            } else {
import org.opensearch.transport.TransportResponseHandler;  
                    }
                        field,
                            continue;  
        IndexNameExpressionResolver indexNameExpressionResolver
     * @opensearch.internal
import org.opensearch.cluster.routing.FailAwareWeightedRouting;  
import org.opensearch.search.internal.ShardSearchRequest;  
        FieldCapabilitiesIndexResponse::new
        Predicate<String> fieldPredicate = indicesService.getFieldFilter().apply(shardId.getIndexName());
import org.opensearch.action.support.ActionFilters;
                            return ThreadPool.Names.SAME;  
    }
 * GitHub history for details.
        MapperService mapperService = indexService.mapperService();
import org.opensearch.tasks.Task;
                        @Override
            ShardRouting next = FailAwareWeightedRouting.getInstance()
    private class ShardTransportHandler implements TransportRequestHandler<FieldCapabilitiesIndexRequest> {
        ShardSearchRequest searchRequest = new ShardSearchRequest(req.shardId(), req.nowInMillis(), AliasFilter.EMPTY);  
                        }
        IndexSettings indexSettings = indexService.getIndexSettings();
 * software distributed under the License is distributed on an
                        searchable = ft.isSearchable();
        super(ACTION_NAME, transportService, actionFilters, FieldCapabilitiesIndexRequest::new);  
            ClusterState clusterState = clusterService.state();  
            }
        SearchService searchService,
        return ResolvedIndices.of(request.index());  
    private FieldCapabilitiesIndexResponse shardOperation(final FieldCapabilitiesIndexRequest request) throws IOException {
                        listener.onFailure(lastFailure);
        }  
                    }  
                        @Override
import org.opensearch.indices.IndicesService;
import org.opensearch.common.inject.Inject;  
                } else {
 * this file be licensed under the Apache-2.0 license or a
                    if (mapperService.fieldType(parentField) == null) {
    }  
                    IndexFieldCapabilities fieldCap = new IndexFieldCapabilities(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        new AsyncShardsAction(request, listener).start();
        private final GroupShardsIterator<ShardIterator> shardsIt;
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.common.Nullable;
        }  
            return new FieldCapabilitiesIndexResponse(request.index(), Collections.emptyMap(), false);  
            if (node == null) {
                    listener.onResponse(new FieldCapabilitiesIndexResponse(request.index(), Collections.emptyMap(), false));
import org.opensearch.transport.TransportException;
import org.opensearch.core.common.logging.LoggerMessageFormat;  
                            )  
                int dotIndex = ft.name().lastIndexOf('.');  
                    logger.trace("sending request [{}] on node [{}]", request, node);  
        private ShardRouting nextRoutingOrNull(Exception failure) {  
                    continue;  
import org.opensearch.cluster.routing.ShardRouting;  
                                null,  
import org.opensearch.index.mapper.ObjectMapper;  
    public static final ActionType<FieldCapabilitiesIndexResponse> TYPE = new ActionType<>(  
        @Override
 * Unless required by applicable law or agreed to in writing,
    class AsyncShardsAction {
        return state.blocks().globalBlockedException(ClusterBlockLevel.READ);  
 * the Apache License, Version 2.0 (the "License"); you may
                            if (response.canMatch()) {
        }
    private final ClusterService clusterService;
                                tryNext(null, false);  
     * Shard transport handler for field capabilities index action  
            if (logger.isTraceEnabled()) {
                }
    @Inject
        IndicesService indicesService,  
 * not use this file except in compliance with the License.
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());  
        );
                    if (responseMap.containsKey(parentField)) {  
                logger.trace(() -> new ParameterizedMessage("{}: failed to execute [{}]", shardRouting, request), e);
                    }
        private final ActionListener<FieldCapabilitiesIndexResponse> listener;
 */  
                    ACTION_SHARD_NAME,
                    }
            tryNext(e, false);  
 * You may obtain a copy of the License at  
import org.opensearch.search.internal.AliasFilter;
                }  
        ThreadPool threadPool,
            moveToNextShard();
        this.clusterService = clusterService;
            if (blockException != null) {  
                .findNext(shardsIt.get(shardIndex), clusterService.state(), failure, this::moveToNextShard);
            }
import java.util.Map;
                        }
import org.opensearch.cluster.routing.GroupShardsIterator;
                while (dotIndex > -1) {
        }
            }
                    dotIndex = parentField.lastIndexOf('.');  
 *
    }
            }
        }  
                    String parentField = ft.name().substring(0, dotIndex);
import org.opensearch.action.support.TransportIndicesResolvingAction;
                logger.trace("executing [{}]", request);  
import org.opensearch.index.query.MatchAllQueryBuilder;
import org.opensearch.index.IndexSettings;  
import org.opensearch.cluster.ClusterState;
        Map<String, IndexFieldCapabilities> responseMap = new HashMap<>();
                        listener.onFailure(
                            dotIndex = parentField.lastIndexOf('.');
import org.opensearch.index.IndexService;
import java.util.Collections;
            if (blockException != null) {  
                    request,
                        searchable,  
        public void start() {
                            // No ObjectMapper exists for this intermediate path so skip it and continue up the chain
     * {@link FieldCapabilitiesIndexRequest#indexFilter()}. In which case the shard is used
        ClusterService clusterService,
        for (String field : request.fields()) {
                if (indicesService.isMetadataField(field) || fieldPredicate.test(ft.name())) {  
            DiscoveryNode node = nodes.get(shardRouting.currentNodeId());  
import org.opensearch.threadpool.ThreadPool;
            FieldCapabilitiesIndexRequest::new,  
            }
    );  
            ACTION_SHARD_NAME,
            executor.execute(ActionRunnable.supply(listener, () -> shardOperation(request)));  
 */  
                onFailure(shardRouting, new NoShardAvailableActionException(shardRouting.shardId()));
    }  
import org.opensearch.core.common.io.stream.StreamInput;
                        public void handleResponse(final FieldCapabilitiesIndexResponse response) {
        }
                        public String executor() {
    @Override
/*  
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        private final DiscoveryNodes nodes;  
        this.indicesService = indicesService;
import java.util.HashSet;  
        this.transportService = transportService;
            if (e != null) {  
        }  
    FieldCapabilitiesIndexRequest,
import static org.opensearch.action.support.TransportActions.isShardNotAvailableException;  
                        // no field type, it must be an object field  
                        @Override  
            new ShardTransportHandler()
 * under the License.  
    }  
                            onFailure(shardRouting, exp);  
                );  
    private final SearchService searchService;
import org.opensearch.index.mapper.MapperService;
        this.executor = threadPool.executor(ThreadPool.Names.MANAGEMENT);
                    if (indexSettings.isPluggableDataFormatEnabled()) {
        }
            }  
import org.opensearch.action.NoShardAvailableActionException;  
        ActionFilters actionFilters,  
import org.opensearch.transport.TransportRequestHandler;
    private static final String ACTION_NAME = FieldCapabilitiesAction.NAME + "[index]";
import org.opensearch.core.action.ActionListener;
 * license agreements. See the NOTICE file distributed with
                transportService.sendRequest(
import org.opensearch.action.ActionRunnable;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
            MappedFieldType ft = mapperService.fieldType(field);
        private volatile int shardIndex = 0;
                        // we added this path on another field already
        private AsyncShardsAction(FieldCapabilitiesIndexRequest request, ActionListener<FieldCapabilitiesIndexResponse> listener) {  
        if (canMatchShard(request) == false) {
import org.opensearch.action.ActionType;
    public TransportFieldCapabilitiesIndexAction(  
import java.util.function.Predicate;
                if (canMatchShard == false) {  
            blockException = checkRequestBlock(clusterState, request.index());
                    responseMap.put(field, fieldCap);
    private static final String ACTION_SHARD_NAME = ACTION_NAME + "[s]";
                                LoggerMessageFormat.format("No shard available for [{}]", request),
 */  
 * @opensearch.internal
                            type,
                if (logger.isTraceEnabled()) {
                    } else {
                                lastFailure
