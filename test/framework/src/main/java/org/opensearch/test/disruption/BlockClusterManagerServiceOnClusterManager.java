                return Priority.IMMEDIATE;
 */
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    }
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
            public void onFailure(String source, Exception e) {
    }  
import org.opensearch.common.unit.TimeValue;
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Random;
 * SPDX-License-Identifier: Apache-2.0
        boolean success = disruptionLatch.compareAndSet(null, new CountDownLatch(1));
 * this work for additional information regarding copyright
            public ClusterState execute(ClusterState currentState) throws Exception {  
 */  
        }  
            @Override  
                        Throwables.rethrow(e);
            return;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    public void startDisrupting() {  
                return currentState;
import org.opensearch.common.Priority;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        CountDownLatch latch = disruptionLatch.get();
    public void removeAndEnsureHealthy(InternalTestCluster cluster) {  
            }
        if (clusterService == null) {
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.test.InternalTestCluster;  
    @Override
            @Override
package org.opensearch.test.disruption;
import org.apache.logging.log4j.core.util.Throwables;  
            @Override
    @Override
        }
                        latch.await();
                    } catch (InterruptedException e) {  
        if (latch != null) {
        final String disruptionNodeCopy = disruptedNode;
        clusterService.getClusterManagerService().submitStateUpdateTask("service_disruption_block", new ClusterStateUpdateTask() {
 * specific language governing permissions and limitations
import org.opensearch.cluster.ClusterStateUpdateTask;
 */
        final CountDownLatch started = new CountDownLatch(1);
        logger.info("blocking cluster-manager service on node [{}]", disruptionNodeCopy);
    public void stopDisrupting() {  
    @Override
import org.opensearch.cluster.service.ClusterService;  
 * KIND, either express or implied.  See the License for the
 *
            }
        if (disruptionNodeCopy == null) {  
            latch.countDown();  
        }
                CountDownLatch latch = disruptionLatch.get();
 *
    @Override
 * not use this file except in compliance with the License.
        ClusterService clusterService = cluster.getInstance(ClusterService.class, disruptionNodeCopy);  
    public BlockClusterManagerServiceOnClusterManager(Random random) {
            return;
    }
 * You may obtain a copy of the License at  
/*  
            started.await();
import java.util.concurrent.atomic.AtomicReference;
 * ownership. Elasticsearch licenses this file to you under  
                    }
    public TimeValue expectedTimeToHeal() {
        return TimeValue.timeValueMinutes(0);  
 * Unless required by applicable law or agreed to in writing,
/*
 * under the License.  
        assert success : "startDisrupting called without waiting on stopDisrupting to complete";  
                if (latch != null) {  
        });
                    try {
                logger.error("unexpected error during disruption", e);  
import java.util.concurrent.CountDownLatch;  
                }  
                started.countDown();
            }  
        disruptedNode = cluster.getClusterManagerName();
        } catch (InterruptedException e) {}
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
        removeFromCluster(cluster);
/*
 * GitHub history for details.
        super(random);
    AtomicReference<CountDownLatch> disruptionLatch = new AtomicReference<>();
        try {  
}
import org.opensearch.cluster.ClusterState;
public class BlockClusterManagerServiceOnClusterManager extends SingleNodeDisruption {  
 *  
            public Priority priority() {
