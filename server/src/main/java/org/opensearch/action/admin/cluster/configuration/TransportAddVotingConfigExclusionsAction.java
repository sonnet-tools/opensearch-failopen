 *
    private static final Logger logger = LogManager.getLogger(TransportAddVotingConfigExclusionsAction.class);  
 * software distributed under the License is distributed on an
import org.opensearch.cluster.ClusterState;  
                        listener.onResponse(new AddVotingConfigExclusionsResponse());  
    ) throws Exception {
        maxVotingConfigExclusions = MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.get(settings);
            @Override  
                final Listener clusterStateListener = new Listener() {  
                );
import org.opensearch.common.unit.TimeValue;  
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
        ClusterService clusterService,
                    return excludedNodeIds.stream().noneMatch(votingConfigNodeIds::contains);  
        this.maxVotingConfigExclusions = maxVotingConfigExclusions;
            }  
import org.opensearch.threadpool.ThreadPool;  
 *  
        10,
                    }
                            )
 * Transport endpoint action for adding exclusions to voting config
    public static final Setting<Integer> MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING = Setting.intSetting(
                    observer.waitForNextChange(clusterStateListener, allNodesRemoved);  
                    request.getTimeout(),
/*
 *
 * Unless required by applicable law or agreed to in writing,
        ThreadPool threadPool,  
                                "timed out waiting for voting config exclusions " + resolvedExclusions + " to take effect"  
            }
import java.util.function.Predicate;  
    private void setMaxVotingConfigExclusions(int maxVotingConfigExclusions) {  
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.addExclusionAndGetState;  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
                    }  
        resolveVotingConfigExclusionsAndCheckMaximum(request, state, maxVotingConfigExclusions);  
            AddVotingConfigExclusionsAction.NAME,
    public TransportAddVotingConfigExclusionsAction(
    @Override  
}
import org.opensearch.threadpool.ThreadPool.Names;
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.action.support.ActionFilters;
        ClusterState state,
    protected ClusterBlockException checkBlock(AddVotingConfigExclusionsRequest request, ClusterState state) {
import org.opensearch.cluster.ClusterStateUpdateTask;  
 *     http://www.apache.org/licenses/LICENSE-2.0
                final ClusterStateObserver observer = new ClusterStateObserver(
            AddVotingConfigExclusionsRequest::new,
                    public void onClusterServiceClose() {
                final Predicate<ClusterState> allNodesRemoved = clusterState -> {
    protected void clusterManagerOperation(  
 * You may obtain a copy of the License at  
 * @opensearch.internal  
    @Override
                        );
 * The OpenSearch Contributors require contributions made to  
                        );
        "cluster.max_voting_config_exclusions",  
                    .collect(Collectors.toSet());
        1,
            @Override
    protected AddVotingConfigExclusionsResponse read(StreamInput in) throws IOException {
import org.opensearch.common.settings.Settings;
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
        });  
                if (allNodesRemoved.test(newState)) {  
        TransportService transportService,
        Property.NodeScope
                    logger,
        ActionFilters actionFilters,
import java.util.Set;
    private volatile int maxVotingConfigExclusions;
        clusterSettings.addSettingsUpdateConsumer(MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING, this::setMaxVotingConfigExclusions);  
        IndexNameExpressionResolver indexNameExpressionResolver
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
                listener.onFailure(e);
    }  
                                    + resolvedExclusions
    @Override  
package org.opensearch.action.admin.cluster.configuration;
    }
                    public void onTimeout(TimeValue timeout) {  
                };
import org.opensearch.common.Priority;  
 */
import org.opensearch.cluster.service.ClusterService;
 * under the License.  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    final Set<String> votingConfigNodeIds = clusterState.getLastCommittedConfiguration().getNodeIds();
    @Override
import org.opensearch.core.action.ActionListener;
                    @Override  
                };
import org.opensearch.common.inject.Inject;
                            )
 */  
    }  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.transport.TransportService;
            @Override
    }
                    .map(VotingConfigExclusion::getNodeId)
                                "cluster service closed while waiting for voting config exclusions "
                            new OpenSearchTimeoutException(
                resolvedExclusions = resolveVotingConfigExclusionsAndCheckMaximum(request, currentState, finalMaxVotingConfigExclusions);
 * ownership. Elasticsearch licenses this file to you under  
                }
 * this work for additional information regarding copyright
    ) {  
        );  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.ClusterStateObserver;
            transportService,  
                        listener.onFailure(
                    public void onNewClusterState(ClusterState state) {
import org.opensearch.cluster.ClusterStateObserver.Listener;
import java.util.stream.Collectors;
 */
        ActionListener<AddVotingConfigExclusionsResponse> listener  
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.resolveVotingConfigExclusionsAndCheckMaximum;
            clusterService,
/**  
                    threadPool.getThreadContext()  
 * this file be licensed under the Apache-2.0 license or a
                assert resolvedExclusions == null : resolvedExclusions;  
import org.apache.logging.log4j.Logger;
import org.opensearch.OpenSearchException;
                    clusterStateListener.onNewClusterState(newState);
            actionFilters,  
    );
                return addExclusionAndGetState(currentState, resolvedExclusions, finalMaxVotingConfigExclusions);  
        // throws IAE if no nodes matched or maximum exceeded
    @Inject  
                                    + " to take effect"  
        Property.Dynamic,  
                final Set<String> excludedNodeIds = resolvedExclusions.stream()  
        return Names.SAME;  
                            new OpenSearchException(  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        ClusterSettings clusterSettings,  
import org.opensearch.common.settings.Setting;  
 * Licensed to Elasticsearch under one or more contributor  
                final int finalMaxVotingConfigExclusions = TransportAddVotingConfigExclusionsAction.this.maxVotingConfigExclusions;
    AddVotingConfigExclusionsResponse> {
        Settings settings,
        AddVotingConfigExclusionsRequest request,
 * KIND, either express or implied.  See the License for the
            }
                    @Override
                    }  
            indexNameExpressionResolver
                        listener.onFailure(
 * GitHub history for details.
import org.opensearch.OpenSearchTimeoutException;  
    protected String executor() {
        super(
                    clusterService,  
        clusterService.submitStateUpdateTask("add-voting-config-exclusions", new ClusterStateUpdateTask(Priority.URGENT) {  
import org.opensearch.common.settings.ClusterSettings;
            public void onFailure(String source, Exception e) {
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
/*  
                } else {
 * SPDX-License-Identifier: Apache-2.0
            private Set<VotingConfigExclusion> resolvedExclusions;
            public ClusterState execute(ClusterState currentState) {
 * compatible open source license.
            threadPool,
import org.opensearch.common.settings.Setting.Property;
 */
public class TransportAddVotingConfigExclusionsAction extends TransportClusterManagerNodeAction<
    AddVotingConfigExclusionsRequest,  
import org.apache.logging.log4j.LogManager;  
 *
                    @Override
        return new AddVotingConfigExclusionsResponse(in);
/*
import org.opensearch.cluster.block.ClusterBlockException;
 * Modifications Copyright OpenSearch Contributors. See  
