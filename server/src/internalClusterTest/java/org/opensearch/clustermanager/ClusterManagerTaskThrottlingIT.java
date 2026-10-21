            executePutMappingRequests(totalRequest, node, listener);
            latch.await();
            executePutMappingRequests(totalRequest, dataNode, listener);
        assertAcked(client().admin().cluster().updateSettings(settingsRequest).actionGet());
                @Override
            AtomicInteger requestCountOnClusterManager = new AtomicInteger();
    }
package org.opensearch.clustermanager;
            ActionListener listener = new ActionListener() {
    }
        }
                    internalCluster().client(node).admin().indices().putMapping(putMappingRequest, listener);
                public void onResponse(Object o) {
                @Override
import org.opensearch.transport.TransportMessageListener;
            CountDownLatch latch = new CountDownLatch(totalRequest);
 * SPDX-License-Identifier: Apache-2.0
            String node = internalCluster().startNode();
            AtomicInteger successfulRequest = new AtomicInteger();
        // We need to remove the throttling limit from setting as part of test cleanup
        } finally {
        }
        }
    }
    public void testThrottlingForRemoteClusterManager() throws Exception {
            ActionListener listener = new ActionListener() {
            String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
                        assertEquals(ClusterManagerThrottlingException.class, error.getClass());
     * This will ensure the end-end feature is working as cluster manager is throwing
        settingsRequest.transientSettings(settings);
        try {
                }
     * It will check the number of request coming to cluster manager node
                }
    public void testTimeoutWhileThrottling() throws Exception {
            String dataNode = internalCluster().startDataOnlyNode();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            threads[i].join();
     * Here we will assert the client behaviour that client's request is not
        }
            CountDownLatch latch = new CountDownLatch(totalRequest);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 0)
                    throw new AssertionError(e);
 * compatible open source license.
                    timedoutRequest.incrementAndGet();
            );
            });
                @Override
        ClusterUpdateSettingsRequest settingsRequest = new ClusterUpdateSettingsRequest();
                public void onRequestReceived(long requestId, String action) {
                public void onResponse(Object o) {
            PutMappingRequest putMappingRequest = new PutMappingRequest("test").source("field" + i, "type=text");
        for (int i = 0; i < totalRequest; i++) {
            executePutMappingRequests(totalRequest, node, listener);
            };
                public void run() {
                    throw new AssertionError("Request should not succeed");
import org.opensearch.transport.TransportService;
                @Override
            latch.await();
                        requestCountOnClusterManager.incrementAndGet();
                    latch.countDown();
        for (int i = 0; i < totalRequest; i++) {
     * should be total number of requests + throttled requests from cluster manager.
 * this file be licensed under the Apache-2.0 license or a
                    }
    /*
        assertAcked(client().admin().cluster().updateSettings(settingsRequest).actionGet());
            String node = internalCluster().startNode();
                    }
import org.opensearch.cluster.service.ClusterManagerThrottlingException;
     * Data node will internally do the retry and request should pass.
    /*
    private void executePutMappingRequests(int totalRequest, String node, ActionListener listener) throws Exception {
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;
    /*
                    latch.countDown();
import org.opensearch.core.action.ActionListener;
                () -> { assertEquals(clusterService().getClusterManagerService().numberOfThrottledPendingTasks(), throttledRequest.get()); }
            clusterSettingCleanUp();
 */
        try {
            };
     * Here we will assert the client behaviour that client's request is not
                    if (action.contains("mapping")) {
        ClusterUpdateSettingsRequest settingsRequest = new ClusterUpdateSettingsRequest();
                    successfulRequest.incrementAndGet();
            int totalRequest = randomIntBetween(throttlingLimit, 3 * throttlingLimit);
                @Override
                public void onFailure(Exception e) {
        Settings settings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", (String) null).build();
        } finally {
            int totalRequest = randomIntBetween(1, 5);
                }
     * remote cluster manager.
            });
            TransportService clusterManagerTransportService = (internalCluster().getInstance(TransportService.class, clusterManagerNode));
            int throttlingLimit = randomIntBetween(1, 5);
            ActionListener listener = new ActionListener() {
            setPutMappingThrottlingLimit(throttlingLimit);
                    latch.countDown();
            clusterSettingCleanUp();
     *
            clusterManagerTransportService.addMessageListener(new TransportMessageListener() {
    }
                @Override
            AtomicInteger throttledRequest = new AtomicInteger();
                    throw new AssertionError(e);
                public void onFailure(Exception e) {
            CountDownLatch latch = new CountDownLatch(totalRequest);
            threads[i].run();
        Thread[] threads = new Thread[totalRequest];
            createIndex("test");
     */
    public void testThrottlingForSingleNode() throws Exception {
import java.util.concurrent.atomic.AtomicInteger;
                }
                public void onResponse(Object o) {
import org.opensearch.common.settings.Settings;
    private void clusterSettingCleanUp() {
        for (int i = 0; i < totalRequest; i++) {
import org.opensearch.test.OpenSearchIntegTestCase;
            int throttlingLimit = randomIntBetween(1, 5);
        }
            threads[i] = new Thread(new Runnable() {
            assertBusy(
                    latch.countDown();
/*
                    latch.countDown();
     * failed with throttling exception but timeout exception.
     * This integ test will test end-end cluster manager throttling feature for
            AtomicInteger timedoutRequest = new AtomicInteger();
import java.util.concurrent.CountDownLatch;
                        throttledRequest.incrementAndGet();
 * The OpenSearch Contributors require contributions made to
        }
     */
     * This will test the timeout of tasks during throttling.
    }
        } finally {
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
            assertEquals(totalRequest, successfulRequest.get());
                public void onFailure(Exception e) {
     */
            setPutMappingThrottlingLimit(throttlingLimit);
            internalCluster().beforeTest(random());
     *
    }
    private void setPutMappingThrottlingLimit(int throttlingLimit) {
        Settings settings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", throttlingLimit).build();
}
     * failed, i.e. Throttling exception is not passed to the client.
     *
                }
                }
     * It also verifies that if limit is set to 0, all tasks are getting timedout.
                    latch.countDown();
                @Override
            latch.await();
                }
     * Throttling exception and data node is performing retries on it.
     *
     * This will test the throttling feature for single node.
            clusterSettingCleanUp();
     *
            assertEquals(totalRequest, timedoutRequest.get()); // verifying all requests were timed out with 0 throttling limit
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            createIndex("test");
public class ClusterManagerTaskThrottlingIT extends OpenSearchIntegTestCase {
                    if (action.contains("mapping")) {
                }
            internalCluster().beforeTest(random());
            };
 *
                    assertTrue(e instanceof ProcessClusterEventTimeoutException);
        try {
                @Override
            setPutMappingThrottlingLimit(throttlingLimit);
                }
            internalCluster().beforeTest(random());
            assertEquals(totalRequest + throttledRequest.get(), requestCountOnClusterManager.get());
        settingsRequest.transientSettings(settings);
            int throttlingLimit = 0; // throttle all the tasks
                public void onResponseSent(long requestId, String action, Exception error) {
            int totalRequest = randomIntBetween(throttlingLimit, 5 * throttlingLimit);
            createIndex("test");
                @Override
