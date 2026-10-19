                listener.onFailure(e);  
        this.clusterService = clusterService;
/*  
            @Override
    private final ClusterService clusterService;
 *    http://www.apache.org/licenses/LICENSE-2.0
    );
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    @Inject  
        });
            public void onResponse(Void v) {  
    public static Optional<RemoteReindexExtension> remoteExtension = Optional.empty();  
            public void onFailure(Exception e) {
public class TransportReindexAction extends HandledTransportAction<ReindexRequest, BulkByScrollResponse>
import org.opensearch.core.action.ActionListener;  
import org.opensearch.cluster.service.ClusterService;  
 * this work for additional information regarding copyright
        Property.NodeScope  
        "reindex.remote.allowlist",  
import org.opensearch.action.support.TransportIndicesResolvingAction;  
            request.setRetryBackoffInitialTime(clusterService.getClusterSettings().get(REMOTE_REINDEX_RETRY_INITIAL_BACKOFF));
        15,
 * license agreements. See the NOTICE file distributed with
import java.util.Optional;  
    private final TransportSearchAction transportSearchAction;  
        "reindex.remote.retry.max_count",
        Property.Dynamic,
 * this file be licensed under the Apache-2.0 license or a
        AutoCreateIndex autoCreateIndex,
        ActionFilters actionFilters,
 */  
import org.opensearch.cluster.metadata.ResolvedIndices;
        this.transportSearchAction = transportSearchAction;  
        return transportSearchAction.resolveIndices(request.getSearchRequest())
    private final Reindexer reindexer;  
    private final ReindexValidator reindexValidator;
        emptyList(),
        Property.Dynamic,
        1,  
 * You may obtain a copy of the License at  
    @Override
        ScriptService scriptService,
    private final IndexNameExpressionResolver indexNameExpressionResolver;
}
import org.opensearch.action.support.ActionFilters;  
        TransportSearchAction transportSearchAction  
import static java.util.Collections.emptyList;  
    }
import org.opensearch.script.ScriptService;
        this.reindexValidator = new ReindexValidator(settings, clusterService, indexNameExpressionResolver, autoCreateIndex);  
            }
        super(ReindexAction.NAME, transportService, actionFilters, ReindexRequest::new);
        BulkByScrollTask bulkByScrollTask = (BulkByScrollTask) task;  
 * specific language governing permissions and limitations
import org.opensearch.transport.TransportService;
 */
        reindexer.initTask(bulkByScrollTask, request, new ActionListener<Void>() {
        Property.NodeScope  
 *
import org.opensearch.action.index.IndexAction;
import org.opensearch.common.settings.Settings;
        ReindexSslConfig sslConfig,
    );
        }  
import org.opensearch.threadpool.ThreadPool;
    }  
 * GitHub history for details.
import org.opensearch.common.settings.Setting;
            request.setMaxRetries(clusterService.getClusterSettings().get(REMOTE_REINDEX_RETRY_MAX_COUNT));
        TransportIndicesResolvingAction<ReindexRequest> {
 * compatible open source license.
        Client client,  
    }  
        ClusterService clusterService,  
                IndexAction.INSTANCE,  
            @Override
    public static final Setting<List<String>> REMOTE_CLUSTER_ALLOWLIST = Setting.listSetting(
 * Modifications Copyright OpenSearch Contributors. See
        "reindex.remote.retry.initial_backoff",
import java.util.function.Function;
            );
import org.opensearch.action.support.AutoCreateIndex;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
/*
    public ResolvedIndices resolveIndices(ReindexRequest request) {  
                reindexer.execute(bulkByScrollTask, request, listener);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
/*  
        TimeValue.timeValueMillis(500),
        100,
import org.opensearch.transport.client.Client;  
import org.opensearch.tasks.Task;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.unit.TimeValue;
    protected void doExecute(Task task, ReindexRequest request, ActionListener<BulkByScrollResponse> listener) {
        IndexNameExpressionResolver indexNameExpressionResolver,
 */  
            .withLocalSubActions(
        Settings settings,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.indexNameExpressionResolver = indexNameExpressionResolver;
 * software distributed under the License is distributed on an
import org.opensearch.common.inject.Inject;
    public TransportReindexAction(
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
    public static final Setting<Integer> REMOTE_REINDEX_RETRY_MAX_COUNT = Setting.intSetting(  
                ResolvedIndices.Local.of(indexNameExpressionResolver.resolveDateMathExpression(request.getDestination().index()))
    );
 * not use this file except in compliance with the License.
        TransportService transportService,
            }
import org.opensearch.index.reindex.spi.RemoteReindexExtension;
    public static final Setting<TimeValue> REMOTE_REINDEX_RETRY_INITIAL_BACKOFF = Setting.timeSetting(  
    @Override
package org.opensearch.index.reindex;
 *
import org.opensearch.action.support.HandledTransportAction;
        Function.identity(),
        this.reindexer = new Reindexer(clusterService, client, threadPool, scriptService, sslConfig, remoteExtension);
import org.opensearch.action.search.TransportSearchAction;
import org.opensearch.common.settings.Setting.Property;  
        if (request.getRemoteInfo() != null) {  
 *  
        reindexValidator.initialValidation(request);
        Property.NodeScope  
    implements  
        ThreadPool threadPool,  
        TimeValue.timeValueMillis(5000),
import java.util.List;
 * KIND, either express or implied.  See the License for the
    ) {
        TimeValue.timeValueMillis(50),  
