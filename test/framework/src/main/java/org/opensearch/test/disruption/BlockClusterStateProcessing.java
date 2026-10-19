        return TimeValue.timeValueMinutes(0);
 * license agreements. See the NOTICE file distributed with
    }
package org.opensearch.test.disruption;
import java.util.concurrent.atomic.AtomicReference;
            return;
        if (latch != null) {
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
        removeFromCluster(cluster);  
 * compatible open source license.
        try {
/*
 * under the License.  
 * GitHub history for details.
        logger.info("delaying cluster state updates on node [{}]", disruptionNodeCopy);
            return;  
    public void stopDisrupting() {
        CountDownLatch latch = disruptionLatch.get();  
public class BlockClusterStateProcessing extends SingleNodeDisruption {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
            latch.countDown();
    }
 *
            }  
        final String disruptionNodeCopy = disruptedNode;  
    }  
        }, (source, e) -> logger.error("unexpected error during disruption", e), Priority.IMMEDIATE);
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.Priority;
 * The OpenSearch Contributors require contributions made to  
                    latch.await();
 */
    }
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
            if (latch != null) {  
        final CountDownLatch started = new CountDownLatch(1);
 *  
    @Override
 * software distributed under the License is distributed on an
        }  
            CountDownLatch latch = disruptionLatch.get();
                    Throwables.rethrow(e);
    public BlockClusterStateProcessing(String disruptedNode, Random random) {
    public TimeValue expectedTimeToHeal() {
        assert success : "startDisrupting called without waiting on stopDisrupting to complete";
                } catch (InterruptedException e) {  
        if (disruptionNodeCopy == null) {
    public void startDisrupting() {
        } catch (InterruptedException e) {}
import org.opensearch.test.InternalTestCluster;
 * this work for additional information regarding copyright
        clusterService.getClusterApplierService().runOnApplierThread("service_disruption_block", currentState -> {  
 */
/*
import java.util.concurrent.CountDownLatch;
        }
import org.apache.logging.log4j.core.util.Throwables;  
import org.opensearch.common.unit.TimeValue;  
 * not use this file except in compliance with the License.
        ClusterService clusterService = cluster.getInstance(ClusterService.class, disruptionNodeCopy);
            started.await();  
        if (clusterService == null) {
    public void removeAndEnsureHealthy(InternalTestCluster cluster) {
 * specific language governing permissions and limitations
        boolean success = disruptionLatch.compareAndSet(null, new CountDownLatch(1));  
        this.disruptedNode = disruptedNode;
 */  
 * Modifications Copyright OpenSearch Contributors. See  
/*  
    }
    @Override
}
            started.countDown();
                try {
import java.util.Random;  
        super(random);  
 * ownership. Elasticsearch licenses this file to you under  
        }  
                }
 * Licensed to Elasticsearch under one or more contributor  
    private final AtomicReference<CountDownLatch> disruptionLatch = new AtomicReference<>();  
