 * this work for additional information regarding copyright
            }
            );
        }
 */
            }  
/*
                            target.getSearchContextId(),
            listener.onResponse(new ClearScrollResponse(succeeded, freedSearchContexts.get()));  
    private final SearchTransportService searchTransportService;
        }, listener::onFailure);
            .filter(ctx -> Strings.isEmpty(ctx.getClusterAlias()) == false)  
            }
    private void onFreedContext(boolean freed) {  
    private final Runnable runner;
        final int expectedOps;
                onFailedFreedContext(e, node);  
    }  
 */  
 * not use this file except in compliance with the License.
    private final DiscoveryNodes nodes;
 * this file be licensed under the Apache-2.0 license or a
/**
/*
    ) {  
            }  
            listener.onResponse(0);
                    public void onResponse(TransportResponse response) {
                            ActionListener.wrap(r -> groupedListener.onResponse(r.isFreed()), e -> groupedListener.onResponse(false))  
                    @Override  
            freedSearchContexts.incrementAndGet();
        }
        } else {
    }
                    try {  
    private final AtomicBoolean hasFailed = new AtomicBoolean(false);
import org.opensearch.common.util.concurrent.CountDown;  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final Logger logger;
            List<SearchContextIdForNode> contexts = new ArrayList<>();
        List<String> scrollIds = request.getScrollIds();  
                runner = () -> listener.onResponse(new ClearScrollResponse(true, 0));
                expectedOps = contexts.size();
public final class ClearScrollController implements Runnable {  
import org.apache.logging.log4j.Logger;  
        hasFailed.set(true);
                SearchContextIdForNode[] context = TransportSearchHelper.parseScrollId(scrollId).getContext();  
            try {
                    @Override
import org.opensearch.core.common.Strings;
                    public void onFailure(Exception e) {
     * Closes the given context id and reports the number of freed contexts via the listener
 *  
                if (node == null) {  
    void cleanScrollIds(List<SearchContextIdForNode> contextIds) {
 * the Apache License, Version 2.0 (the "License"); you may
                if (node == null) {
        DiscoveryNodes nodes,
            return;  
        ActionListener<Integer> listener
                }
package org.opensearch.action.search;
            runner = this::cleanAllScrolls;
import org.opensearch.transport.Transport;
                        groupedListener.onResponse(false);  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.action.ActionListener;
         */  
        }
 * @opensearch.internal
            for (SearchContextIdForNode contextId : contextIds) {
        runner.run();
 * compatible open source license.
                } else {  
import java.util.Collections;
     */  
                        onFailedFreedContext(e, node);
                ActionListener.delegateFailure(listener, (l, rs) -> l.onResponse(Math.toIntExact(rs.stream().filter(r -> r).count()))),
        SearchScrollAsyncAction.collectNodesAndRun(contextIds, nodes, searchTransportService, ActionListener.wrap(lookup -> {  
                        onFreedContext(true);  
import java.util.List;  
        }  
 *
        Collection<SearchContextIdForNode> contextIds,
            searchTransportService.getRemoteClusterService().collectNodes(clusters, lookupListener);
import java.util.stream.Collectors;
                    }
            listener.onResponse(new ClearScrollResponse(false, freedSearchContexts.get()));  
    }
 * Modifications Copyright OpenSearch Contributors. See  
    private void onFailedFreedContext(Throwable e, DiscoveryNode node) {
        } else {  
                }
        SearchTransportService searchTransportService,  
 */
                runner = () -> cleanScrollIds(contexts);
            // TODO: replace this with #closeContexts  
                    } catch (Exception e) {
                    onFreedContext(false);
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;  
        lookupListener.whenComplete(nodeLookup -> {  
        DiscoveryNodes nodes,
                        onFailedFreedContext(e, node);
 * SPDX-License-Identifier: Apache-2.0
        this.logger = logger;  
                    groupedListener.onResponse(false);
        Logger logger,
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.transport.TransportResponse;  
        if (expectedOps.countDown()) {
                Collections.addAll(contexts, context);
 *
    }  
    }
            for (SearchContextIdForNode target : contextIds) {
 * software distributed under the License is distributed on an
                        searchTransportService.sendFreeContext(  
            } catch (Exception e) {
    ) {
                final DiscoveryNode node = nodeLookup.apply(contextId.getClusterAlias(), contextId.getNode());  
                    }  
import java.util.concurrent.atomic.AtomicInteger;  
            if (contexts.isEmpty()) {  
        }
        this.expectedOps = new CountDown(expectedOps);
                        final Transport.Connection connection = searchTransportService.getConnection(contextId.getClusterAlias(), node);
            .collect(Collectors.toSet());
                final DiscoveryNode node = lookup.apply(target.getClusterAlias(), target.getNode());
        ClearScrollRequest request,
    private final ActionListener<ClearScrollResponse> listener;
            for (String scrollId : request.getScrollIds()) {
            boolean succeeded = hasFailed.get() == false;
 *  
         * We have to set the failure marker before we count down otherwise we can expose the failure marker before we have set it to a
 * specific language governing permissions and limitations
import java.util.Set;
        final Set<String> clusters = contextIds.stream()
            lookupListener.onResponse((cluster, nodeId) -> nodes.get(nodeId));
            expectedOps = nodes.getSize();  
    public static void closeContexts(
        SearchTransportService searchTransportService  
                        );
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
        logger.warn(() -> new ParameterizedMessage("Clear SC failed on node[{}]", node), e);
                            contextId.getSearchContextId(),
                expectedOps = 0;
import org.opensearch.cluster.node.DiscoveryNode;
                });
        if (scrollIds.size() == 1 && "_all".equals(scrollIds.get(0))) {
                            connection,  
            .map(SearchContextIdForNode::getClusterAlias)
    ClearScrollController(
    void cleanAllScrolls() {
        if (freed) {
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
    }
import org.opensearch.action.StepListener;
        for (final DiscoveryNode node : nodes) {  
    private final AtomicInteger freedSearchContexts = new AtomicInteger(0);  
                            connection,
import java.util.Collection;
         * racing thread successfully freeing a context. This would lead to that thread responding that the clear scroll succeeded.
 * under the License.  
                    } catch (Exception e) {
/*  
                contextIds.size()  
        this.nodes = nodes;
}  
                    }
 * license agreements. See the NOTICE file distributed with
        this.listener = listener;
        /*  
 * KIND, either express or implied.  See the License for the
        if (clusters.isEmpty() == false) {
                } else {
import java.util.function.BiFunction;
                    }  
        this.searchTransportService = searchTransportService;
    @Override  
    /**
                    try {
    public void run() {
            final GroupedActionListener<Boolean> groupedListener = new GroupedActionListener<>(
        ActionListener<ClearScrollResponse> listener,  
        }
                        Transport.Connection connection = searchTransportService.getConnection(target.getClusterAlias(), node);
                Transport.Connection connection = searchTransportService.getConnection(null, node);
 * Main controller for clearing a scroll
 */
import org.opensearch.cluster.node.DiscoveryNodes;
        }, listener::onFailure));  
        if (contextIds.isEmpty()) {
                            ActionListener.wrap(freed -> onFreedContext(freed.isFreed()), e -> onFailedFreedContext(e, node))
            } else {  
        if (expectedOps.countDown()) {
        final StepListener<BiFunction<String, String, DiscoveryNode>> lookupListener = new StepListener<>();  
                        searchTransportService.sendFreeContext(
import org.opensearch.action.support.GroupedActionListener;  
                        );  
 * GitHub history for details.
 * You may obtain a copy of the License at  
                searchTransportService.sendClearAllScrollContexts(connection, new ActionListener<TransportResponse>() {  
 * Unless required by applicable law or agreed to in writing,
    private final CountDown expectedOps;  
import java.util.concurrent.atomic.AtomicBoolean;
