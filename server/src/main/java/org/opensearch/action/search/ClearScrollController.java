 * Main controller for clearing a scroll
        }
    private void onFreedContext(boolean freed) {
        if (clusters.isEmpty() == false) {
                });
 *
            );
        SearchTransportService searchTransportService,
                            connection,
        ClearScrollRequest request,
    }
        }, listener::onFailure);
                }
        this.searchTransportService = searchTransportService;
            listener.onResponse(new ClearScrollResponse(succeeded, freedSearchContexts.get()));
    }
                    } catch (Exception e) {
import java.util.stream.Collectors;
        }
            searchTransportService.getRemoteClusterService().collectNodes(clusters, lookupListener);
                    @Override
            .map(SearchContextIdForNode::getClusterAlias)
import org.opensearch.core.common.Strings;
    private void onFailedFreedContext(Throwable e, DiscoveryNode node) {
    /**
        this.logger = logger;
import org.opensearch.core.transport.TransportResponse;
        hasFailed.set(true);
                } else {
import java.util.concurrent.atomic.AtomicBoolean;
        SearchTransportService searchTransportService
                    }
    ) {
        final Set<String> clusters = contextIds.stream()
                    public void onResponse(TransportResponse response) {
    }
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
        final int expectedOps;
 * ownership. Elasticsearch licenses this file to you under
 *
 * license agreements. See the NOTICE file distributed with
                        Transport.Connection connection = searchTransportService.getConnection(target.getClusterAlias(), node);
                    onFreedContext(false);
    private final ActionListener<ClearScrollResponse> listener;
            if (contexts.isEmpty()) {
            for (String scrollId : request.getScrollIds()) {
}
                    try {
        logger.warn(() -> new ParameterizedMessage("Clear SC failed on node[{}]", node), e);
 * software distributed under the License is distributed on an
        ActionListener<Integer> listener
    ClearScrollController(
            return;
import org.apache.logging.log4j.message.ParameterizedMessage;
     */
    private final DiscoveryNodes nodes;
                final DiscoveryNode node = nodeLookup.apply(contextId.getClusterAlias(), contextId.getNode());
        /*
            }
                            connection,
                            ActionListener.wrap(r -> groupedListener.onResponse(r.isFreed()), e -> groupedListener.onResponse(false))
            List<SearchContextIdForNode> contexts = new ArrayList<>();
import java.util.Set;
        if (expectedOps.countDown()) {
    public static void closeContexts(
        DiscoveryNodes nodes,
import java.util.function.BiFunction;
         */
    }
                        searchTransportService.sendFreeContext(
public final class ClearScrollController implements Runnable {
                expectedOps = 0;
            } else {
 */
            runner = this::cleanAllScrolls;
        this.nodes = nodes;
            listener.onResponse(new ClearScrollResponse(false, freedSearchContexts.get()));
                        onFreedContext(true);
                        searchTransportService.sendFreeContext(
                        );
    }
                SearchContextIdForNode[] context = TransportSearchHelper.parseScrollId(scrollId).getContext();
 * You may obtain a copy of the License at
import java.util.ArrayList;
package org.opensearch.action.search;
    private final AtomicBoolean hasFailed = new AtomicBoolean(false);
                Transport.Connection connection = searchTransportService.getConnection(null, node);
/*
        } else {
                ActionListener.delegateFailure(listener, (l, rs) -> l.onResponse(Math.toIntExact(rs.stream().filter(r -> r).count()))),
    }
import org.opensearch.action.StepListener;
 *
            listener.onResponse(0);
    @Override
         * racing thread successfully freeing a context. This would lead to that thread responding that the clear scroll succeeded.
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.List;
        final StepListener<BiFunction<String, String, DiscoveryNode>> lookupListener = new StepListener<>();
        ActionListener<ClearScrollResponse> listener,
                            contextId.getSearchContextId(),
            }
                    }
        this.expectedOps = new CountDown(expectedOps);
                    try {
            freedSearchContexts.incrementAndGet();
 * Licensed to Elasticsearch under one or more contributor
    void cleanScrollIds(List<SearchContextIdForNode> contextIds) {
        if (expectedOps.countDown()) {
                        final Transport.Connection connection = searchTransportService.getConnection(contextId.getClusterAlias(), node);
        runner.run();
                expectedOps = contexts.size();
 */
            } catch (Exception e) {
import org.opensearch.core.action.ActionListener;
            for (SearchContextIdForNode contextId : contextIds) {
        lookupListener.whenComplete(nodeLookup -> {
                runner = () -> listener.onResponse(new ClearScrollResponse(true, 0));
 */
                    }
        }
        if (contextIds.isEmpty()) {
        }
        for (final DiscoveryNode node : nodes) {
            try {
        }
        DiscoveryNodes nodes,
                if (node == null) {
            }
                            ActionListener.wrap(freed -> onFreedContext(freed.isFreed()), e -> onFailedFreedContext(e, node))
        }
                contextIds.size()
        this.listener = listener;
    void cleanAllScrolls() {
 * this work for additional information regarding copyright
    ) {
                        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                final DiscoveryNode node = lookup.apply(target.getClusterAlias(), target.getNode());
     * Closes the given context id and reports the number of freed contexts via the listener
        } else {
                if (node == null) {
        Logger logger,
 * under the License.
/**
 * the Apache License, Version 2.0 (the "License"); you may
        if (scrollIds.size() == 1 && "_all".equals(scrollIds.get(0))) {
/*
                    @Override
                        groupedListener.onResponse(false);
                        onFailedFreedContext(e, node);
 * specific language governing permissions and limitations
    private final CountDown expectedOps;
import java.util.Collections;
import org.opensearch.action.support.GroupedActionListener;
            }
import org.opensearch.cluster.node.DiscoveryNodes;
 *
            // TODO: replace this with #closeContexts
                            target.getSearchContextId(),
    }
import org.apache.logging.log4j.Logger;
                }
import java.util.concurrent.atomic.AtomicInteger;
            boolean succeeded = hasFailed.get() == false;
import java.util.Collection;
    private final Runnable runner;
            expectedOps = nodes.getSize();
 * @opensearch.internal
                onFailedFreedContext(e, node);
        Collection<SearchContextIdForNode> contextIds,
            lookupListener.onResponse((cluster, nodeId) -> nodes.get(nodeId));
        }
    private final SearchTransportService searchTransportService;
import org.opensearch.transport.Transport;
                    groupedListener.onResponse(false);
            }
        List<String> scrollIds = request.getScrollIds();
                Collections.addAll(contexts, context);
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
                    }
 */
 * The OpenSearch Contributors require contributions made to
 *     http://www.apache.org/licenses/LICENSE-2.0
        }, listener::onFailure));
import org.opensearch.common.util.concurrent.CountDown;
                    public void onFailure(Exception e) {
            final GroupedActionListener<Boolean> groupedListener = new GroupedActionListener<>(
            for (SearchContextIdForNode target : contextIds) {
    private final AtomicInteger freedSearchContexts = new AtomicInteger(0);
    public void run() {
                runner = () -> cleanScrollIds(contexts);
/*
                        onFailedFreedContext(e, node);
 * KIND, either express or implied.  See the License for the
                searchTransportService.sendClearAllScrollContexts(connection, new ActionListener<TransportResponse>() {
    private final Logger logger;
         * We have to set the failure marker before we count down otherwise we can expose the failure marker before we have set it to a
                    } catch (Exception e) {
        if (freed) {
            .filter(ctx -> Strings.isEmpty(ctx.getClusterAlias()) == false)
        SearchScrollAsyncAction.collectNodesAndRun(contextIds, nodes, searchTransportService, ActionListener.wrap(lookup -> {
                } else {
 * not use this file except in compliance with the License.
            .collect(Collectors.toSet());
