import org.opensearch.common.unit.TimeValue;  
                Thread.sleep(duration.millis());
    volatile boolean disrupting;  
    }
        }  
    @Override  
                ;  
                } catch (InterruptedException e) {} catch (Exception e) {
 * The OpenSearch Contributors require contributions made to  
        this.delayDurationMax = delayDurationMax;
        this.delayDurationMin = delayDurationMin;
        worker.setDaemon(true);
import java.util.concurrent.atomic.AtomicInteger;
            }  
    ) {  
import java.util.Random;  
            }
            logger.info("background thread failed to stop");
        }
            return;  
            logger.info("node [{}] resumes from GC", disruptedNode);
    public IntermittentLongGCDisruption(
 */
 * SPDX-License-Identifier: Apache-2.0
                    );  
        public void run() {
 */
/**
                        intervalBetweenDelaysMin + random.nextInt((int) (intervalBetweenDelaysMax - intervalBetweenDelaysMin))
 * license agreements. See the NOTICE file distributed with
        try {
        long intervalBetweenDelaysMin,
    public void startDisrupting() {
                    logger.error("error in background worker", e);
 * under the License.  
                    duration = new TimeValue(
 *  
                try {  
        worker.interrupt();
    final long delayDurationMin;
 * this file be licensed under the Apache-2.0 license or a
        long delayDurationMin,
 */  
    }
        String disruptedNode,
        worker = new Thread(new BackgroundWorker(), "long_gc_simulation_" + thread_ids.incrementAndGet());
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
/*
    class BackgroundWorker implements Runnable {
                    if (disrupting) {
 * compatible open source license.
        long intervalBetweenDelaysMax,  
    }
public class IntermittentLongGCDisruption extends LongGCDisruption {
        } finally {
        logger.info("node [{}] goes into GC for for [{}]", disruptedNode, duration);
        }
 * KIND, either express or implied.  See the License for the
 *
 * specific language governing permissions and limitations
        final Set<Thread> nodeThreads = new HashSet<>();  
import java.util.HashSet;
 * Licensed to Elasticsearch under one or more contributor  
    }  
                    simulateLongGC(duration);
 * Simulates irregular long gc intervals.
 * software distributed under the License is distributed on an
    }  
        Random random,  
 */  
        if (worker == null) {
        }
            worker.join(2 * (intervalBetweenDelaysMax + delayDurationMax));  
 * not use this file except in compliance with the License.
                    }  
        disrupting = true;  
package org.opensearch.test.disruption;
/*
    final long intervalBetweenDelaysMin;  
            resumeThreads(nodeThreads);  
        this.intervalBetweenDelaysMin = intervalBetweenDelaysMin;
    private void simulateLongGC(final TimeValue duration) throws InterruptedException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *
                        Thread.sleep(duration.millis());
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
        worker = null;
        worker.start();  
 * Unless required by applicable law or agreed to in writing,
            if (!nodeThreads.isEmpty()) {
    final long delayDurationMax;  
        super(random, disruptedNode);
    final long intervalBetweenDelaysMax;
        disrupting = false;  
            while (suspendThreads(nodeThreads))
        this.intervalBetweenDelaysMax = intervalBetweenDelaysMax;  
    volatile Thread worker;
        try {
    @Override
        @Override  
        long delayDurationMax
                }  
import java.util.Set;
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("stopping long GCs on [{}]", disruptedNode);
    public void stopDisrupting() {
        } catch (InterruptedException e) {
}
                    TimeValue duration = new TimeValue(delayDurationMin + random.nextInt((int) (delayDurationMax - delayDurationMin)));
    static final AtomicInteger thread_ids = new AtomicInteger();
 * You may obtain a copy of the License at  
            while (disrupting) {
