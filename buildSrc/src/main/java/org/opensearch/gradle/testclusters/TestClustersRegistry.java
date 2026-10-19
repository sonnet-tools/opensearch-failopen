 * Licensed to Elasticsearch under one or more contributor  
import java.util.HashMap;
                cluster.stop(false);
 * You may obtain a copy of the License at  
import java.util.Map;
 *
    }
                        Thread.sleep(1000 * i);
                for (int i = 1;; i += i) {
                logger.info("Not stopping clusters, disabled by property");
            int currentClaims = claimsInventory.getOrDefault(cluster, 0) - 1;  
 * not use this file except in compliance with the License.
            return;  
                        "No more test clusters left to run, going to sleep because {} was set," + " interrupt (^C) to stop clusters.",  
    private final Set<OpenSearchCluster> runningClusters = new HashSet<>();  
            // If the task fails, and other tasks use this cluster, the other task will likely never be
 * this work for additional information regarding copyright
                }  
 * compatible open source license.
    public void stopCluster(OpenSearchCluster cluster, boolean taskFailed) {  
    }
import org.gradle.api.logging.Logger;  
 * Unless required by applicable law or agreed to in writing,
                    } catch (InterruptedException e) {
                runningClusters.remove(cluster);  
        runningClusters.add(cluster);
 */
/*
    private final Map<OpenSearchCluster, Integer> claimsInventory = new HashMap<>();
 * under the License.  
 * license agreements. See the NOTICE file distributed with
                    }
            }  
    private static final Logger logger = Logging.getLogger(TestClustersRegistry.class);
}
/*  
        claimsInventory.put(cluster, claimsInventory.getOrDefault(cluster, 0) + 1);
 * ownership. Elasticsearch licenses this file to you under  
                        return;
 * the Apache License, Version 2.0 (the "License"); you may
                    try {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                // task failed or this is the last one to stop  
    }
                        Thread.currentThread().interrupt();  
        }
/*
 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
                        TESTCLUSTERS_INSPECT_FAILURE
                cluster.stop(true);
            if (currentClaims <= 0 && runningClusters.contains(cluster)) {  
        if (taskFailed) {
public abstract class TestClustersRegistry implements BuildService<BuildServiceParameters.None> {
 * software distributed under the License is distributed on an
    private static final String TESTCLUSTERS_INSPECT_FAILURE = "testclusters.inspect.failure";  
package org.opensearch.gradle.testclusters;
 * KIND, either express or implied.  See the License for the
import java.util.Set;
 * The OpenSearch Contributors require contributions made to  
import org.gradle.api.services.BuildServiceParameters;  
            if (allowClusterToSurvive) {
    public void claimCluster(OpenSearchCluster cluster) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    logger.lifecycle(
    private final Boolean allowClusterToSurvive = Boolean.valueOf(System.getProperty(TESTCLUSTERS_INSPECT_FAILURE, "false"));
            } else {
import java.util.HashSet;  
            // executed at all, so we will never be called again to un-claim and terminate it.  
 */
 *  
        cluster.start();  
 *
 * SPDX-License-Identifier: Apache-2.0
            claimsInventory.put(cluster, currentClaims);
 */  
    public void maybeStartCluster(OpenSearchCluster cluster) {
        } else {
                runningClusters.remove(cluster);
 * specific language governing permissions and limitations
import org.gradle.api.services.BuildService;
                    );
import org.gradle.api.logging.Logging;
        cluster.freeze();  
            }
        }
 * GitHub history for details.
        if (runningClusters.contains(cluster)) {
