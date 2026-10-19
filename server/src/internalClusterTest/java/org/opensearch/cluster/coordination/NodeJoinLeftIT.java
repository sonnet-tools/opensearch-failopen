    }
                return;
        AtomicBoolean succeedFollowerChecker = new AtomicBoolean();
        // start a 3 node cluster with 1 cluster-manager  
                )
            ClusterHealthResponse response2 = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
        assertThat(response.isTimedOut(), is(false));  
 */
 *
    private TestLogsAppender testLogsAppender;  
        // Loop runs 5 times to ensure race condition gets reproduced
                    throw new RuntimeException(e);  
            redNodeName
import org.opensearch.index.MockEngineFactoryPlugin;
    }  
import org.junit.After;
        succeedFollowerChecker.set(true);
            TimeUnit.SECONDS
                30,
            .put(RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(), "100ms")
        loggerContext.updateLoggers();
    public void testRestartCmNode() throws Exception {  
            .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "100ms")
        }
/**
        });  
    @Override
        logger.info("-> restarting stopped node");  
        assertTrue("Expected log was not found within the timeout period", logFound);
            assertThat(response1.isTimedOut(), is(false));  
        boolean logFound = testLogsAppender.waitForLog("failed to join", 30, TimeUnit.SECONDS)
        succeedFollowerChecker.set(true);
import org.opensearch.transport.TransportRequest;
        // Add any other specific messages you want to capture  
            redNodeName
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.apache.logging.log4j.core.config.Configuration;  
            if (event.nodesRemoved()) {
        // create an index only if it doesn't exist  
        LoggerConfig loggerConfig = config.getLoggerConfig(ClusterConnectionManager.class.getName());
 * Unless required by applicable law or agreed to in writing,
        // Loop runs 5 times to ensure race condition gets reproduced  
import org.opensearch.transport.ClusterConnectionManager;
        // Simulate a slow applier on the cm to delay node-left state application
        for (int i = 0; i < 5; i++) {
        MockTransportService redTransportService = (MockTransportService) internalCluster().getInstance(
            } catch (InterruptedException e) {
        });
 * specific language governing permissions and limitations
            assertThat(response2.isTimedOut(), is(false));  
            if (event.nodesRemoved()) {
            MockEngineFactoryPlugin.class
        @Override
                TimeUnit.SECONDS
        LoggerConfig loggerConfig = config.getLoggerConfig(ClusterConnectionManager.class.getName());
            logger.info("--> simulating followerchecker failure to trigger node-left");  
            // checking again to validate stability and ensure node did not leave
        );  
                } catch (InterruptedException e) {
import org.apache.logging.log4j.core.config.LoggerConfig;
 * Modifications Copyright OpenSearch Contributors. See
        loggerContext = (LoggerContext) LogManager.getContext(false);  
    public void testRestartDataNode() throws Exception {
        assertThat(response.isTimedOut(), is(false));
        testLogsAppender.clearCapturedLogs();
        redTransportService.addRequestHandlingBehavior(FOLLOWER_CHECK_ACTION_NAME, simulatedFailureBehaviour);
            TransportChannel channel,  
            Thread.sleep(1000);
        // Toggle to succeed/fail the followerchecker to simulate the initial node leaving.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        internalCluster().stopRandomNode(settings -> settings.get("node.name").equals(redNodeName));
        ) throws Exception {
            clusterManager  
            "IllegalStateException[cannot make a new connection as disconnect to node",  
import java.util.Arrays;
    }
            Thread.sleep(1000);
        super.beforeIndexDeletion();
}
        redTransportService.addRequestHandlingBehavior(FOLLOWER_CHECK_ACTION_NAME, simulatedFailureBehaviour);  
            );  
import org.opensearch.indices.recovery.RecoverySettings;  
        testLogsAppender.clearCapturedLogs();
    private class FollowerCheckerBehaviour implements StubbableTransport.RequestHandlingBehavior<TransportRequest> {
        );
import java.util.concurrent.atomic.AtomicBoolean;
        ensureGreen();
            30,
        internalCluster().assertConsistentHistoryBetweenTranslogAndLuceneIndex();  
        });
        ClusterService clusterManagerClsService = internalCluster().getInstance(ClusterService.class, clusterManager);
                try {  
                "IllegalStateException[cannot make a new connection as disconnect to node",  
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.metadata.IndexMetadata;
            // once we know a node has left, we can re-enable followerchecker to work normally and validate node rejoins
            assertThat(response1.isTimedOut(), is(false));
        );
import org.opensearch.plugins.Plugin;
            }
                }
import org.opensearch.test.transport.MockTransportService;  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        assertTrue("Expected log was not found within the timeout period", logFound);
        testLogsAppender = new TestLogsAppender(messagesToCapture);
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes(">=3").get();  
        // assert that join requests fail with the right exception  
        this.clusterManager = internalCluster().startNode(nodeSettings);
            logger.info(
        final Settings nodeSettings = Settings.builder()
            TransportService.class,
            succeedFollowerChecker.set(false);
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes("2").get();  
import org.opensearch.test.transport.StubbableTransport;
            assertThat(response3.isTimedOut(), is(false));
    private String clusterManager;
        for (int i = 0; i < 5; i++) {
import org.apache.logging.log4j.core.LoggerContext;
        MockTransportService cmTransportService = (MockTransportService) internalCluster().getInstance(
            TransportService.class,  
        loggerContext = (LoggerContext) LogManager.getContext(false);  
            TransportService.class,
        clusterManagerClsService.addStateApplier(event -> {  
                    Thread.sleep(3000);  
        }  
            );
            if (succeedFollowerChecker.get()) {
            .build();
 * software distributed under the License is distributed on an
import java.util.List;  
        // Simulate followerchecker failure on 1 node when succeedFollowerChecker is false  
        internalCluster().assertSameDocIdsOnShards();
import java.util.Collection;
    @Before  
        public void messageReceived(  
                .prepareCreate(indexName)
        logger.info("-> restarting stopped node");  
        // validate the 3 node cluster is up
                return;  
import org.opensearch.common.SuppressForbidden;  
            ClusterHealthResponse response1 = client().admin().cluster().prepareHealth().setWaitForNodes("2").get();
            && testLogsAppender.waitForLog(
        // Toggle to succeed/fail the followerchecker to simulate the initial node leaving.  
            .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "200ms")
    protected void beforeIndexDeletion() throws Exception {
    public void tearDown() throws Exception {
public class NodeJoinLeftIT extends OpenSearchIntegTestCase {
        boolean logFound = testLogsAppender.waitForLog("failed to join", 30, TimeUnit.SECONDS);  
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
            TransportRequestHandler<TransportRequest> handler,
                throw new RuntimeException(e);
 * You may obtain a copy of the License at  
        }  
        Configuration config = loggerContext.getConfiguration();
import org.opensearch.test.TestLogsAppender;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.transport.TransportService;  
                }  
            .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "10s")  
import org.opensearch.cluster.NodeConnectionsService;  
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();  
        private final Runnable connectionBreaker;
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_ACTION_NAME;
                    Settings.builder()  
 */  
 https://github.com/opensearch-project/OpenSearch/pull/15521 for context  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
        // Wait for cluster to stabilize before checking node count  
        MockTransportService redTransportService = (MockTransportService) internalCluster().getInstance(  
        this.redNodeName = internalCluster().startNode(Settings.builder().put("node.attr.color", "red").put(nodeSettings).build());  
            } catch (InterruptedException e) {
    }
        assertThat(response.isTimedOut(), is(false));
        logger.info("-> stopping cluster-manager node");
        Settings cmNodeSettings = internalCluster().dataPathSettings(clusterManager);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        private FollowerCheckerBehaviour(Runnable connectionBreaker) {
        logger.info("-> stopping data node");
 * The OpenSearch Contributors require contributions made to  
            }
                        .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "blue")
 * GitHub history for details.
 * this work for additional information regarding copyright
        FollowerCheckerBehaviour simulatedFailureBehaviour = new FollowerCheckerBehaviour(() -> {
            }  
    private LoggerContext loggerContext;  
        AtomicBoolean succeedFollowerChecker = new AtomicBoolean();
        );  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        super.setUp();
    private String redNodeName;
    }
        // Simulate a slow applier on the cm to delay node-left state application  
@SuppressForbidden(reason = "Pending fix: https://github.com/opensearch-project/OpenSearch/issues/18972")  
                Thread.sleep(10);  
            ClusterHealthResponse response1 = client().admin().cluster().prepareHealth().setWaitForNodes("2").get();
import org.junit.Before;
                .setSettings(
import org.opensearch.test.OpenSearchIntegTestCase;
                throw new RuntimeException(e);  
        internalCluster().startNode(Settings.builder().put("node.name", clusterManager).put(cmNodeSettings).build());
        ClusterService clusterManagerClsService = internalCluster().getInstance(ClusterService.class, clusterManager);
            assertThat(response2.isTimedOut(), is(false));
import org.opensearch.transport.TransportRequestHandler;
/*  
        internalCluster().assertSeqNos();
            MockFSIndexStore.TestPlugin.class,  
        response = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();  
import org.opensearch.tasks.Task;
import org.opensearch.transport.TransportChannel;  
        }  
            succeedFollowerChecker.set(false);
 * this file be licensed under the Apache-2.0 license or a
    }
                } catch (InterruptedException e) {
        Settings redNodeDataPathSettings = internalCluster().dataPathSettings(redNodeName);  
            // Trigger a node disconnect while node-left task is still processing
import org.opensearch.common.settings.Settings;
        assertTrue("Expected log was not found within the timeout period", logFound);
 * the Apache License, Version 2.0 (the "License"); you may
            handler.messageReceived(request, channel, task);
            succeedFollowerChecker.set(true);  
            succeedFollowerChecker.set(true);
                "--> triggering a simulated disconnect on red node, after the follower checker failed to see how node-left task deals with this"  
        internalCluster().stopRandomNode(settings -> settings.get("node.name").equals(clusterManager));
        internalCluster().startNode(Settings.builder().put("node.attr.color", "blue").put(nodeSettings).build());
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes("2").get();  
                    throw new RuntimeException(e);
        // assert that join requests fail with the right exception
        response = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
    }
/*  
            ClusterHealthResponse response3 = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
                .indices()  
            try {
            Thread.sleep(1000);
import org.opensearch.test.store.MockFSIndexStore;
        List<String> messagesToCapture = Arrays.asList("failed to join", "IllegalStateException");
 * under the License.  
        loggerConfig.removeAppender(testLogsAppender.getName());  
        FollowerCheckerBehaviour simulatedFailureBehaviour = new FollowerCheckerBehaviour(() -> {
        loggerContext.updateLoggers();
import static org.hamcrest.Matchers.is;
 */  
            ClusterHealthResponse response2 = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
    @After  
        testLogsAppender.clearCapturedLogs();  
        logFound = testLogsAppender.waitForLog(
 * ownership. Elasticsearch licenses this file to you under  
        String indexName = "test";  
    public void testClusterStabilityWhenJoinRequestHappensDuringNodeLeftTask() throws Exception {
                try {
            }
        );  
        clusterManagerClsService.addStateApplier(event -> {
 Check https://github.com/opensearch-project/OpenSearch/issues/4874 and
            assertThat(response3.isTimedOut(), is(false));
            // checking again to validate stability and ensure node did not leave  
            // once we know a node has left, we can re-enable followerchecker to work normally and validate node rejoins
            Task task
            // Fail followerchecker by force to trigger node disconnect and node left
                    Thread.sleep(3000);
            logger.info("--> simulating followerchecker failure to trigger node-left");  
import org.opensearch.cluster.service.ClusterService;
    @Override
    public void testClusterStabilityWhenDisconnectDuringSlowNodeLeftTask() throws Exception {
package org.opensearch.cluster.coordination;
            client().admin()
        super.tearDown();
    }
import org.opensearch.test.InternalSettingsPlugin;  
    public void setUp() throws Exception {
            throw new NodeHealthCheckFailureException("fake followerchecker failure simulated by test to repro race condition");
 *
            connectionBreaker.run();
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
        return Arrays.asList(
        assertThat(response.isTimedOut(), is(false));
        assertThat(response.isTimedOut(), is(false));
/*
            ClusterHealthResponse response3 = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();  
    @Override  
        });  
 * SPDX-License-Identifier: Apache-2.0
            if (succeedFollowerChecker.get()) {  
                Thread.sleep(10);
        if (!client().admin().indices().prepareExists(indexName).get().isExists()) {
        internalCluster().startNode(Settings.builder().put("node.name", redNodeName).put(redNodeDataPathSettings).build());
 * KIND, either express or implied.  See the License for the
        assertThat(response.isTimedOut(), is(false));  
    }  
            throw new NodeHealthCheckFailureException("fake followerchecker failure simulated by test to repro race condition");
 * compatible open source license.
            this.connectionBreaker = connectionBreaker;
            TransportRequest request,
            .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)  
            }
 * license agreements. See the NOTICE file distributed with
            }
 * not use this file except in compliance with the License.
import java.util.concurrent.TimeUnit;
                .get();
            logger.info("--> re-enabling normal followerchecker and validating cluster is stable");  
        // Simulate followerchecker failure on 1 node when succeedFollowerChecker is false
        assertThat(response.isTimedOut(), is(false));
        }  
        Configuration config = loggerContext.getConfiguration();
 */
            InternalSettingsPlugin.class,
            logger.info("--> re-enabling normal followerchecker and validating cluster is stable");
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        loggerConfig.addAppender(testLogsAppender, null, null);  
            cmTransportService.disconnectFromNode(redTransportService.getLocalDiscoNode());
 *    http://www.apache.org/licenses/LICENSE-2.0
            MockTransportService.TestPlugin.class,
            try {  
            .put(FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING.getKey(), "100ms")
 *  
