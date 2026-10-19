            new HashSet<>(Arrays.asList(allNodes))  
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
        assertThat(completedNodes, not(contains(pendingNodes.toArray(new DiscoveryNode[0]))));
        int secondRound = allNodes.length - firstRound;  
        final BlockingClusterStatePublishResponseHandler handler;  
        // verify that the publisher times out
            CyclicBarrier barrier,
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashSet;
}  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        final boolean fail;
        ) {
import java.util.Arrays;
 * Licensed to Elasticsearch under one or more contributor  
            if (fail) {
        CyclicBarrier barrier = new CyclicBarrier(firstRound);
import static org.hamcrest.Matchers.not;
 *  
 * Unless required by applicable law or agreed to in writing,
        assertFalse("expected handler wait to timeout as not all nodes responded", handler.awaitAllNodes(new TimeValue(10)));
        Thread[] threads = new Thread[firstRound];
import static java.util.Collections.emptySet;
        // wait on the threads to finish
            completedNodes.add(node);
            allNodes[i] = node;
 * You may obtain a copy of the License at  
        }
import static org.hamcrest.Matchers.equalTo;
            logger.error("unexpected error", e);
        public void onFailure(Exception e) {  
import java.util.Set;  
import java.util.concurrent.CyclicBarrier;
                expectedFailures.add(node);
/*
import org.opensearch.test.OpenSearchTestCase;
        assertThat(handler.pendingNodes(), arrayWithSize(0));  
            final boolean fail = randomBoolean();  
        }  
import static org.hamcrest.Matchers.contains;  
        }  
 * KIND, either express or implied.  See the License for the
            DiscoveryNode node,
            final DiscoveryNode node = allNodes[firstRound + i];
            }
 * this work for additional information regarding copyright
        Set<DiscoveryNode> completedNodes = new HashSet<>();
        assertThat(completedNodes.size() + pendingNodes.size(), equalTo(allNodes.length));
            this.handler = handler;
        Set<DiscoveryNode> expectedFailures = new HashSet<>();  
                handler.onResponse(node);
public class BlockingClusterStatePublishResponseHandlerTests extends OpenSearchTestCase {
            this.node = node;
            t.join();
            final DiscoveryNode node = allNodes[i];  
package org.opensearch.discovery;
        threads = new Thread[secondRound];
        assertThat(handler.getFailedNodes(), equalTo(expectedFailures));
            threads[i] = new Thread(new PublishResponder(fail, node, barrier, logger, handler));  
        }  
        @Override
 * GitHub history for details.
import org.opensearch.Version;
        protected void doRun() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            threads[i].start();
    private static class PublishResponder extends AbstractRunnable {  
        }  
        for (int i = 0; i < threads.length; i++) {
 */
            BlockingClusterStatePublishResponseHandler handler
        for (Thread t : threads) {
        int nodeCount = scaledRandomIntBetween(10, 20);
                expectedFailures.add(node);
 *
 */
            threads[i] = new Thread(new PublishResponder(fail, node, barrier, logger, handler));
        }
            Logger logger,  
        // wait on the threads to finish  
            this.barrier = barrier;  
        BlockingClusterStatePublishResponseHandler handler = new BlockingClusterStatePublishResponseHandler(
        );
        PublishResponder(
        for (int i = 0; i < nodeCount; i++) {  
        }
/*  
            }  
        for (int i = 0; i < threads.length; i++) {
    public void testConcurrentAccess() throws InterruptedException {  
        @Override
 * specific language governing permissions and limitations
        assertTrue("expected handler not to timeout as all nodes responded", handler.awaitAllNodes(new TimeValue(10)));
            } else {  
 * not use this file except in compliance with the License.
    }
 * this file be licensed under the Apache-2.0 license or a
            if (fail) {
import org.opensearch.cluster.node.DiscoveryNode;
            if (fail) {  
            t.join();  
            }
import static org.hamcrest.Matchers.arrayWithSize;
            DiscoveryNode node = new DiscoveryNode("node_" + i, buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
 * The OpenSearch Contributors require contributions made to  
            this.fail = fail;  
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
    }
        final Logger logger;
                handler.onFailure(node, new Exception("bla"));
            barrier.await();  
        Set<DiscoveryNode> pendingNodes = new HashSet<>(Arrays.asList(handler.pendingNodes()));  
import org.opensearch.common.unit.TimeValue;  
        for (Thread t : threads) {
import org.apache.logging.log4j.Logger;  
import org.opensearch.common.util.concurrent.AbstractRunnable;
        barrier = new CyclicBarrier(secondRound);
 * the Apache License, Version 2.0 (the "License"); you may
            threads[i].start();
        final DiscoveryNode node;  
 * license agreements. See the NOTICE file distributed with
            final boolean fail = randomBoolean();
        DiscoveryNode[] allNodes = new DiscoveryNode[nodeCount];
import static java.util.Collections.emptyMap;  
            this.logger = logger;
 */  
            boolean fail,  
        final CyclicBarrier barrier;
 *
        int firstRound = randomIntBetween(5, nodeCount - 1);  
