    public void removeAndEnsureHealthy(InternalTestCluster cluster) {
        active.set(false);  
 * Unless required by applicable law or agreed to in writing,
                logger.error("unexpected error during disruption", e);
                    submitTask(clusterService);
            }  
        return TimeValue.timeValueMinutes(0);
 * ownership. Elasticsearch licenses this file to you under  
    public BusyClusterManagerServiceDisruption(Random random, Priority priority) {
 * the Apache License, Version 2.0 (the "License"); you may
    private final Priority priority;  
 * KIND, either express or implied.  See the License for the
        logger.info("making cluster-manager service busy on node [{}] at priority [{}]", disruptionNodeCopy, priority);  
        submitTask(clusterService);
 * SPDX-License-Identifier: Apache-2.0
    }  
        ClusterService clusterService = cluster.getInstance(ClusterService.class, disruptionNodeCopy);
/*  
        super(random);  
}  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 */
 *  
 * under the License.  
        this.priority = priority;
public class BusyClusterManagerServiceDisruption extends SingleNodeDisruption {
package org.opensearch.test.disruption;
                return currentState;  
        }
    }
    @Override
    }  
    public void stopDisrupting() {
import org.opensearch.common.Priority;  
 */
    private void submitTask(ClusterService clusterService) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            public void onFailure(String source, Exception e) {
    }
    private final AtomicBoolean active = new AtomicBoolean();
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Random;
            }
 *
 * compatible open source license.
import org.opensearch.cluster.ClusterStateUpdateTask;
                }
import org.opensearch.cluster.service.ClusterService;
import java.util.concurrent.atomic.AtomicBoolean;
            @Override
        active.set(true);
        disruptedNode = cluster.getClusterManagerName();  
        });
import org.opensearch.cluster.ClusterState;  
            return;
        if (disruptionNodeCopy == null) {
            @Override  
 * this file be licensed under the Apache-2.0 license or a
    public TimeValue expectedTimeToHeal() {  
        clusterService.getClusterManagerService().submitStateUpdateTask("service_disruption_block", new ClusterStateUpdateTask(priority) {  
    public void startDisrupting() {
    @Override
/*
/*
        }
 *
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 */  
    @Override
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    }
        final String disruptionNodeCopy = disruptedNode;
 * Modifications Copyright OpenSearch Contributors. See  
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (clusterService == null) {  
import org.opensearch.test.InternalTestCluster;
    }
 * software distributed under the License is distributed on an
 * GitHub history for details.
import org.opensearch.common.unit.TimeValue;
            return;  
                if (active.get()) {  
            public ClusterState execute(ClusterState currentState) {
        removeFromCluster(cluster);
