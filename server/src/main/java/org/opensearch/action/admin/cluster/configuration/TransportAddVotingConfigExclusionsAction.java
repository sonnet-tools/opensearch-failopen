import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.ClusterStateUpdateTask;
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
/*
 * compatible open source license.
public class TransportAddVotingConfigExclusionsAction extends TransportClusterManagerNodeAction<
import org.opensearch.cluster.ClusterStateObserver.Listener;
        clusterSettings.addSettingsUpdateConsumer(MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING, this::setMaxVotingConfigExclusions);
import org.opensearch.cluster.block.ClusterBlockLevel;
                listener.onFailure(e);
import org.opensearch.core.common.io.stream.StreamInput;
 * this work for additional information regarding copyright
 */
 * The OpenSearch Contributors require contributions made to
                        );
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
                return addExclusionAndGetState(currentState, resolvedExclusions, finalMaxVotingConfigExclusions);
 * software distributed under the License is distributed on an
                        listener.onFailure(
        ActionFilters actionFilters,
import org.opensearch.threadpool.ThreadPool.Names;
 *
    }
        10,
    protected String executor() {
                resolvedExclusions = resolveVotingConfigExclusionsAndCheckMaximum(request, currentState, finalMaxVotingConfigExclusions);
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
    ) throws Exception {
 */
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
        1,
    private volatile int maxVotingConfigExclusions;
import org.opensearch.common.settings.Setting;
                    clusterService,
 * specific language governing permissions and limitations
 *
import org.opensearch.common.Priority;
import org.opensearch.cluster.ClusterState;
        );
                            new OpenSearchTimeoutException(
        Property.NodeScope
                                "timed out waiting for voting config exclusions " + resolvedExclusions + " to take effect"
            @Override
/*
    @Override
        TransportService transportService,
        Property.Dynamic,
    AddVotingConfigExclusionsRequest,
        return new AddVotingConfigExclusionsResponse(in);
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.addExclusionAndGetState;
                    observer.waitForNextChange(clusterStateListener, allNodesRemoved);
 * Transport endpoint action for adding exclusions to voting config
            @Override
                    public void onClusterServiceClose() {
        ClusterState state,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
                    request.getTimeout(),
            @Override
                    public void onTimeout(TimeValue timeout) {
            indexNameExpressionResolver
                        listener.onFailure(
            }
            clusterService,
    @Override
            private Set<VotingConfigExclusion> resolvedExclusions;
        maxVotingConfigExclusions = MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.get(settings);
 *
 * this file be licensed under the Apache-2.0 license or a
    protected AddVotingConfigExclusionsResponse read(StreamInput in) throws IOException {
                final Listener clusterStateListener = new Listener() {
    }
import org.opensearch.cluster.ClusterStateObserver;
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.resolveVotingConfigExclusionsAndCheckMaximum;
    }
                                    + " to take effect"
    public TransportAddVotingConfigExclusionsAction(
                    .map(VotingConfigExclusion::getNodeId)
            AddVotingConfigExclusionsAction.NAME,
    );
import org.opensearch.transport.TransportService;
            public ClusterState execute(ClusterState currentState) {
    private void setMaxVotingConfigExclusions(int maxVotingConfigExclusions) {
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
                                    + resolvedExclusions
                };
        ThreadPool threadPool,
import org.opensearch.cluster.block.ClusterBlockException;
    public static final Setting<Integer> MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING = Setting.intSetting(
import org.opensearch.OpenSearchException;
            public void onFailure(String source, Exception e) {
                    }
        "cluster.max_voting_config_exclusions",
                    }
            AddVotingConfigExclusionsRequest::new,
                    clusterStateListener.onNewClusterState(newState);
                if (allNodesRemoved.test(newState)) {
import org.opensearch.common.settings.Settings;
 * under the License.
                    return excludedNodeIds.stream().noneMatch(votingConfigNodeIds::contains);
import org.opensearch.action.support.ActionFilters;
    @Override
import org.opensearch.core.action.ActionListener;
                };
        IndexNameExpressionResolver indexNameExpressionResolver
                    }
                        listener.onResponse(new AddVotingConfigExclusionsResponse());
 * Unless required by applicable law or agreed to in writing,
        AddVotingConfigExclusionsRequest request,
        return Names.SAME;
                            )
                }
                );
                final int finalMaxVotingConfigExclusions = TransportAddVotingConfigExclusionsAction.this.maxVotingConfigExclusions;
                                "cluster service closed while waiting for voting config exclusions "
 *
    ) {
    protected ClusterBlockException checkBlock(AddVotingConfigExclusionsRequest request, ClusterState state) {
                    @Override
 */
 */
        ActionListener<AddVotingConfigExclusionsResponse> listener
            transportService,
 * Licensed to Elasticsearch under one or more contributor
                            )
                } else {
        super(
import org.opensearch.common.settings.Setting.Property;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
}
                    logger,
/**
        clusterService.submitStateUpdateTask("add-voting-config-exclusions", new ClusterStateUpdateTask(Priority.URGENT) {
 * ownership. Elasticsearch licenses this file to you under
import java.util.stream.Collectors;
    private static final Logger logger = LogManager.getLogger(TransportAddVotingConfigExclusionsAction.class);
package org.opensearch.action.admin.cluster.configuration;
import org.opensearch.cluster.service.ClusterService;
            }
        // throws IAE if no nodes matched or maximum exceeded
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.inject.Inject;
                    final Set<String> votingConfigNodeIds = clusterState.getLastCommittedConfiguration().getNodeIds();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        });
        this.maxVotingConfigExclusions = maxVotingConfigExclusions;
                final Predicate<ClusterState> allNodesRemoved = clusterState -> {
                    threadPool.getThreadContext()
                    .collect(Collectors.toSet());
                final Set<String> excludedNodeIds = resolvedExclusions.stream()
                        );
    protected void clusterManagerOperation(
                    public void onNewClusterState(ClusterState state) {
    }
    @Override
                    @Override
/*
        ClusterService clusterService,
                            new OpenSearchException(
        Settings settings,
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
                    @Override
    }
    AddVotingConfigExclusionsResponse> {
import java.util.Set;
 * You may obtain a copy of the License at
                final ClusterStateObserver observer = new ClusterStateObserver(
    @Inject
        ClusterSettings clusterSettings,
                assert resolvedExclusions == null : resolvedExclusions;
    }
import java.util.function.Predicate;
            }
            threadPool,
 * GitHub history for details.
import org.opensearch.OpenSearchTimeoutException;
import org.apache.logging.log4j.Logger;
 * the Apache License, Version 2.0 (the "License"); you may
        resolveVotingConfigExclusionsAndCheckMaximum(request, state, maxVotingConfigExclusions);
            actionFilters,
import org.apache.logging.log4j.LogManager;
import org.opensearch.threadpool.ThreadPool;
