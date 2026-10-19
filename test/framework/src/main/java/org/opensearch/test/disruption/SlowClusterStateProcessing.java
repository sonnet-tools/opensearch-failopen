            logger.info("background thread failed to stop");
        Random random,
    }
            }  
        this.disruptedNode = disruptedNode;
        long intervalBetweenDelaysMax,
import java.util.concurrent.atomic.AtomicBoolean;
        }  
        long intervalBetweenDelaysMin,  
                    if (!interruptClusterStateProcessing(duration)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        disrupting = false;
 * Unless required by applicable law or agreed to in writing,
                ExceptionsHelper.reThrowIfNotNull(e);  
                            intervalBetweenDelaysMin + random.nextInt((int) (intervalBetweenDelaysMax - intervalBetweenDelaysMin))  
                    }  
    public SlowClusterStateProcessing(String disruptedNode, Random random) {  
                countDownLatch.countDown();
        worker.interrupt();  
                            Thread.sleep(duration.millis());  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 */
                    TimeValue duration = new TimeValue(delayDurationMin + random.nextInt((int) (delayDurationMax - delayDurationMin)));  
    final long delayDurationMin;
        this(random, intervalBetweenDelaysMin, intervalBetweenDelaysMax, delayDurationMin, delayDurationMax);  
    }  
            // try to wait again, we really want the cluster state thread to be freed up when stopping disruption
    }
        this.delayDurationMax = delayDurationMax;  
    final long delayDurationMax;  
    private boolean interruptClusterStateProcessing(final TimeValue duration) throws InterruptedException {  
    @Override
        disrupting = true;
    ) {
                }  
    final long intervalBetweenDelaysMax;
import org.opensearch.cluster.service.ClusterService;
    @Override
                        if (disrupting && disruptedNode != null) {
import java.util.concurrent.CountDownLatch;
                }
    }
        public void run() {  
    public void removeAndEnsureHealthy(InternalTestCluster cluster) {
        } catch (InterruptedException e) {
/*  
 * You may obtain a copy of the License at  
    }
import org.opensearch.ExceptionsHelper;  
    }
 * compatible open source license.
        }
        this.intervalBetweenDelaysMin = intervalBetweenDelaysMin;  
        ensureNodeCount(cluster);
import org.opensearch.common.unit.TimeValue;  
            }
 * Licensed to Elasticsearch under one or more contributor  
public class SlowClusterStateProcessing extends SingleNodeDisruption {
 * The OpenSearch Contributors require contributions made to  
                    Thread.sleep(duration.millis() % 200);
        @Override
                    Thread.sleep(200);
                long count = duration.millis() / 200;
/*
        logger.info("stopping to slow down cluster state processing on [{}]", disruptedNode);
    public SlowClusterStateProcessing(
        this.intervalBetweenDelaysMax = intervalBetweenDelaysMax;
        long delayDurationMax  
    @Override
            return false;  
        removeFromCluster(cluster);  
    @Override  
        try {  
                        );
        }  
 */
    }
        worker = null;  
        super(random);
            return false;  
    volatile boolean disrupting;  
    public TimeValue expectedTimeToHeal() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        ClusterService clusterService = cluster.getInstance(ClusterService.class, disruptionNodeCopy);
}
                // wait while checking for a stopped  
import org.opensearch.common.Priority;
        this.delayDurationMin = delayDurationMin;
    public SlowClusterStateProcessing(
import java.util.Random;  
        String disruptedNode,
            stopped.set(true);  
        }
 *
        long intervalBetweenDelaysMin,
    }
                } catch (InterruptedException e) {} catch (Exception e) {  
        logger.info("delaying cluster state updates on node [{}] for [{}]", disruptionNodeCopy, duration);
        worker = new Thread(new BackgroundWorker());  
        return true;
    public SlowClusterStateProcessing(Random random) {
 * ownership. Elasticsearch licenses this file to you under  
        long delayDurationMin,
        } catch (InterruptedException e) {  
            worker.join(2 * (intervalBetweenDelaysMax + delayDurationMax));
 * specific language governing permissions and limitations
        if (clusterService == null) {
        clusterService.getClusterApplierService().runOnApplierThread("service_disruption_delay", currentState -> {  
                    logger.error("error in background worker", e);
package org.opensearch.test.disruption;
                        duration = new TimeValue(
    public void startDisrupting() {
 * this work for additional information regarding copyright
        long delayDurationMin,  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
        this(disruptedNode, random, 100, 200, 300, 20000);
                        }
        }, (source, e) -> countDownLatch.countDown(), Priority.IMMEDIATE);
        worker.start();
    ) {
            countDownLatch.await();
        long intervalBetweenDelaysMax,
    }
                for (; count > 0 && !stopped.get(); count--) {
            while (disrupting && disruptedNode != null) {
            countDownLatch.await();
 *
        final AtomicBoolean stopped = new AtomicBoolean(false);
        long delayDurationMax
        Random random,  
import org.opensearch.test.InternalTestCluster;
                if (!stopped.get()) {
        worker.setDaemon(true);
                try {
 * license agreements. See the NOTICE file distributed with
            } catch (InterruptedException e) {
        if (disruptionNodeCopy == null) {
 */  
 * software distributed under the License is distributed on an
            try {
        }
        }
        final String disruptionNodeCopy = disruptedNode;
    class BackgroundWorker implements Runnable {  
        this(null, random);  
/*
                    }
        if (worker == null) {
                        continue;
        try {
    public void stopDisrupting() {  
 * under the License.  
 * KIND, either express or implied.  See the License for the
    final long intervalBetweenDelaysMin;  
    volatile Thread worker;
 * GitHub history for details.
        final CountDownLatch countDownLatch = new CountDownLatch(1);  
                }  
    }
            return;
        return TimeValue.timeValueMillis(0);  
                    if (intervalBetweenDelaysMax > 0) {
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
