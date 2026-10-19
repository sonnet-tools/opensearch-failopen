        try {
        try {
 *
        }  
            AtomicInteger throttledRequest = new AtomicInteger();
                    successfulRequest.incrementAndGet();
                public void onFailure(Exception e) {  
    private void setPutMappingThrottlingLimit(int throttlingLimit) {
            executePutMappingRequests(totalRequest, node, listener);  
    }
     *
            CountDownLatch latch = new CountDownLatch(totalRequest);
     * This integ test will test end-end cluster manager throttling feature for
            AtomicInteger timedoutRequest = new AtomicInteger();  
            assertEquals(totalRequest + throttledRequest.get(), requestCountOnClusterManager.get());
    /*
            latch.await();
            assertBusy(  
            int throttlingLimit = 0; // throttle all the tasks
            CountDownLatch latch = new CountDownLatch(totalRequest);  
                @Override
                    latch.countDown();
                }
 * SPDX-License-Identifier: Apache-2.0
        Thread[] threads = new Thread[totalRequest];
     *
                        throttledRequest.incrementAndGet();
     * Here we will assert the client behaviour that client's request is not
                public void onRequestReceived(long requestId, String action) {
    private void executePutMappingRequests(int totalRequest, String node, ActionListener listener) throws Exception {  
        } finally {
            createIndex("test");  
}  
     *
                public void onResponse(Object o) {  
     * It also verifies that if limit is set to 0, all tasks are getting timedout.
                    if (action.contains("mapping")) {  
        for (int i = 0; i < totalRequest; i++) {
                    latch.countDown();
            ActionListener listener = new ActionListener() {
            threads[i].run();  
                }  
            int totalRequest = randomIntBetween(throttlingLimit, 5 * throttlingLimit);
                @Override
                    }
            int totalRequest = randomIntBetween(1, 5);
                    if (action.contains("mapping")) {
    public void testTimeoutWhileThrottling() throws Exception {
package org.opensearch.clustermanager;
     * failed with throttling exception but timeout exception.  
        } finally {  
                }
    }  
                @Override
import org.opensearch.test.OpenSearchIntegTestCase;
     * Here we will assert the client behaviour that client's request is not
                        requestCountOnClusterManager.incrementAndGet();  
        Settings settings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", (String) null).build();
        assertAcked(client().admin().cluster().updateSettings(settingsRequest).actionGet());
    /*
                @Override
                public void onResponseSent(long requestId, String action, Exception error) {
                    latch.countDown();  
                }
     * Throttling exception and data node is performing retries on it.
                @Override
        settingsRequest.transientSettings(settings);
                    internalCluster().client(node).admin().indices().putMapping(putMappingRequest, listener);
        }
                public void onFailure(Exception e) {
 * this file be licensed under the Apache-2.0 license or a
            AtomicInteger requestCountOnClusterManager = new AtomicInteger();  
            ActionListener listener = new ActionListener() {
        // We need to remove the throttling limit from setting as part of test cleanup  
            };
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 0)
        ClusterUpdateSettingsRequest settingsRequest = new ClusterUpdateSettingsRequest();
                }  
            });
            executePutMappingRequests(totalRequest, node, listener);
        assertAcked(client().admin().cluster().updateSettings(settingsRequest).actionGet());
    }
import org.opensearch.transport.TransportService;  
            int throttlingLimit = randomIntBetween(1, 5);
/*  
            };
    }
            clusterSettingCleanUp();
    private void clusterSettingCleanUp() {
                public void onResponse(Object o) {  
                    latch.countDown();
 */  
                    assertTrue(e instanceof ProcessClusterEventTimeoutException);  
                    }  
                () -> { assertEquals(clusterService().getClusterManagerService().numberOfThrottledPendingTasks(), throttledRequest.get()); }
    }  
                    latch.countDown();
     */  
        Settings settings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", throttlingLimit).build();  
            internalCluster().beforeTest(random());  
                @Override
            assertEquals(totalRequest, timedoutRequest.get()); // verifying all requests were timed out with 0 throttling limit  
            ActionListener listener = new ActionListener() {
                @Override  
            executePutMappingRequests(totalRequest, dataNode, listener);
            clusterManagerTransportService.addMessageListener(new TransportMessageListener() {
        }
 * compatible open source license.
    public void testThrottlingForRemoteClusterManager() throws Exception {
            setPutMappingThrottlingLimit(throttlingLimit);  
    public void testThrottlingForSingleNode() throws Exception {
     * should be total number of requests + throttled requests from cluster manager.  
            AtomicInteger successfulRequest = new AtomicInteger();  
        }
                @Override
        for (int i = 0; i < totalRequest; i++) {
            internalCluster().beforeTest(random());
            });  
            );
        for (int i = 0; i < totalRequest; i++) {
public class ClusterManagerTaskThrottlingIT extends OpenSearchIntegTestCase {
                }
            PutMappingRequest putMappingRequest = new PutMappingRequest("test").source("field" + i, "type=text");  
            clusterSettingCleanUp();
            String node = internalCluster().startNode();
            assertEquals(totalRequest, successfulRequest.get());
     * Data node will internally do the retry and request should pass.
            String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        settingsRequest.transientSettings(settings);  
     * This will ensure the end-end feature is working as cluster manager is throwing
 * The OpenSearch Contributors require contributions made to  
     *
                    throw new AssertionError(e);
                    latch.countDown();
                public void onResponse(Object o) {  
            threads[i] = new Thread(new Runnable() {
            CountDownLatch latch = new CountDownLatch(totalRequest);
import org.opensearch.core.action.ActionListener;  
                    throw new AssertionError("Request should not succeed");
                }  
     * This will test the throttling feature for single node.  
            setPutMappingThrottlingLimit(throttlingLimit);
        try {  
            };  
     * remote cluster manager.  
            int throttlingLimit = randomIntBetween(1, 5);
            clusterSettingCleanUp();
            String node = internalCluster().startNode();
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;  
            latch.await();  
    }  
        } finally {  
     * This will test the timeout of tasks during throttling.  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            int totalRequest = randomIntBetween(throttlingLimit, 3 * throttlingLimit);
import org.opensearch.transport.TransportMessageListener;
import org.opensearch.common.settings.Settings;
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
                public void onFailure(Exception e) {  
        }
                }
        ClusterUpdateSettingsRequest settingsRequest = new ClusterUpdateSettingsRequest();
                }
            setPutMappingThrottlingLimit(throttlingLimit);
    /*
        }
                @Override
            createIndex("test");
     * failed, i.e. Throttling exception is not passed to the client.  
import java.util.concurrent.atomic.AtomicInteger;  
            threads[i].join();  
     */
                    timedoutRequest.incrementAndGet();
            String dataNode = internalCluster().startDataOnlyNode();  
                        assertEquals(ClusterManagerThrottlingException.class, error.getClass());
                    throw new AssertionError(e);
     */
            TransportService clusterManagerTransportService = (internalCluster().getInstance(TransportService.class, clusterManagerNode));
import org.opensearch.cluster.service.ClusterManagerThrottlingException;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            latch.await();
import java.util.concurrent.CountDownLatch;
            createIndex("test");  
     *  
     * It will check the number of request coming to cluster manager node
                public void run() {  
            internalCluster().beforeTest(random());  
