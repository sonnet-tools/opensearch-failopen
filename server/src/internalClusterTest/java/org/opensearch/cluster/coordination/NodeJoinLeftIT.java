        logger.info("-> restarting stopped node");
import org.opensearch.transport.TransportRequest;
        MockTransportService redTransportService = (MockTransportService) internalCluster().getInstance(
        }
import org.opensearch.index.MockEngineFactoryPlugin;
                    throw new RuntimeException(e);
        testLogsAppender = new TestLogsAppender(messagesToCapture);
            ClusterHealthResponse response1 = client().admin().cluster().prepareHealth().setWaitForNodes("2").get();
    private TestLogsAppender testLogsAppender;
        ClusterService clusterManagerClsService = internalCluster().getInstance(ClusterService.class, clusterManager);
            assertThat(response2.isTimedOut(), is(false));
                } catch (InterruptedException e) {
import org.opensearch.test.transport.StubbableTransport;
                } catch (InterruptedException e) {
                "IllegalStateException[cannot make a new connection as disconnect to node",
        AtomicBoolean succeedFollowerChecker = new AtomicBoolean();
    }
        response = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
 * GitHub history for details.
            logger.info("--> re-enabling normal followerchecker and validating cluster is stable");
            TransportRequestHandler<TransportRequest> handler,
/*
        this.clusterManager = internalCluster().startNode(nodeSettings);
            logger.info("--> re-enabling normal followerchecker and validating cluster is stable");
            Task task
                throw new RuntimeException(e);
    @Override
 * Unless required by applicable law or agreed to in writing,
                )
    }
        loggerContext.updateLoggers();
                        .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "blue")
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue("Expected log was not found within the timeout period", logFound);
        });
    private String redNodeName;
 * You may obtain a copy of the License at
import org.apache.logging.log4j.core.config.Configuration;
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes("2").get();
            ClusterHealthResponse response3 = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
            clusterManager
            ClusterHealthResponse response3 = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.metadata.IndexMetadata;
    public void setUp() throws Exception {
        testLogsAppender.clearCapturedLogs();
        // Simulate followerchecker failure on 1 node when succeedFollowerChecker is false
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        LoggerConfig loggerConfig = config.getLoggerConfig(ClusterConnectionManager.class.getName());
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
                30,
                Thread.sleep(10);
        super.setUp();
            MockFSIndexStore.TestPlugin.class,
            .put(RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(), "100ms")
        logFound = testLogsAppender.waitForLog(
            TransportRequest request,
                "--> triggering a simulated disconnect on red node, after the follower checker failed to see how node-left task deals with this"
        logger.info("-> stopping cluster-manager node");
        Settings cmNodeSettings = internalCluster().dataPathSettings(clusterManager);
import org.opensearch.test.InternalSettingsPlugin;
    }
        testLogsAppender.clearCapturedLogs();
        );
            assertThat(response2.isTimedOut(), is(false));
        loggerConfig.addAppender(testLogsAppender, null, null);
            logger.info(
        Configuration config = loggerContext.getConfiguration();
            }
    }
                    Thread.sleep(3000);
            logger.info("--> simulating followerchecker failure to trigger node-left");
            && testLogsAppender.waitForLog(
        internalCluster().assertConsistentHistoryBetweenTranslogAndLuceneIndex();
    private LoggerContext loggerContext;
        for (int i = 0; i < 5; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        List<String> messagesToCapture = Arrays.asList("failed to join", "IllegalStateException");
        clusterManagerClsService.addStateApplier(event -> {
public class NodeJoinLeftIT extends OpenSearchIntegTestCase {
                .setSettings(
            // once we know a node has left, we can re-enable followerchecker to work normally and validate node rejoins
        );
            succeedFollowerChecker.set(false);
        internalCluster().startNode(Settings.builder().put("node.name", redNodeName).put(redNodeDataPathSettings).build());
import org.opensearch.transport.TransportChannel;
        assertThat(response.isTimedOut(), is(false));
import org.opensearch.transport.TransportRequestHandler;
            try {
/*
package org.opensearch.cluster.coordination;
        ) throws Exception {
        assertThat(response.isTimedOut(), is(false));
        // assert that join requests fail with the right exception
            // Fail followerchecker by force to trigger node disconnect and node left
import org.opensearch.plugins.Plugin;
        succeedFollowerChecker.set(true);
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        logger.info("-> stopping data node");
import org.opensearch.indices.recovery.RecoverySettings;
        boolean logFound = testLogsAppender.waitForLog("failed to join", 30, TimeUnit.SECONDS);
            .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)
 * this file be licensed under the Apache-2.0 license or a
        // Toggle to succeed/fail the followerchecker to simulate the initial node leaving.
        Settings redNodeDataPathSettings = internalCluster().dataPathSettings(redNodeName);
        }
            InternalSettingsPlugin.class,
        // Toggle to succeed/fail the followerchecker to simulate the initial node leaving.
import java.util.concurrent.TimeUnit;
 *
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            connectionBreaker.run();
        MockTransportService redTransportService = (MockTransportService) internalCluster().getInstance(
            }
        private final Runnable connectionBreaker;
            }
 */
 * license agreements. See the NOTICE file distributed with
            Thread.sleep(1000);
        assertTrue("Expected log was not found within the timeout period", logFound);
 */
        internalCluster().startNode(Settings.builder().put("node.attr.color", "blue").put(nodeSettings).build());
                .get();
            );
 https://github.com/opensearch-project/OpenSearch/pull/15521 for context
        final Settings nodeSettings = Settings.builder()
    @Override
            assertThat(response3.isTimedOut(), is(false));
            ClusterHealthResponse response2 = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
                Thread.sleep(10);
            ClusterHealthResponse response2 = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
 *
            }
 * this work for additional information regarding copyright
            // Trigger a node disconnect while node-left task is still processing
                    Settings.builder()
            try {
    protected void beforeIndexDeletion() throws Exception {
            // once we know a node has left, we can re-enable followerchecker to work normally and validate node rejoins
        @Override
        public void messageReceived(
import org.opensearch.transport.ClusterConnectionManager;
 Check https://github.com/opensearch-project/OpenSearch/issues/4874 and
        // Add any other specific messages you want to capture
        // Loop runs 5 times to ensure race condition gets reproduced
                .indices()
        for (int i = 0; i < 5; i++) {
            if (succeedFollowerChecker.get()) {
import java.util.concurrent.atomic.AtomicBoolean;
                return;
            cmTransportService.disconnectFromNode(redTransportService.getLocalDiscoNode());
 * SPDX-License-Identifier: Apache-2.0
        assertThat(response.isTimedOut(), is(false));
        internalCluster().assertSeqNos();
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
            TransportService.class,
            TransportService.class,
            succeedFollowerChecker.set(false);
    @After
        FollowerCheckerBehaviour simulatedFailureBehaviour = new FollowerCheckerBehaviour(() -> {
        assertThat(response.isTimedOut(), is(false));
import org.junit.After;
import org.opensearch.transport.TransportService;
}
        loggerContext.updateLoggers();
    @Override
        internalCluster().assertSameDocIdsOnShards();
/**
        });
            } catch (InterruptedException e) {
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes(">=3").get();
import org.opensearch.common.settings.Settings;
                return;
        super.tearDown();
                .prepareCreate(indexName)
import org.apache.logging.log4j.LogManager;
            logger.info("--> simulating followerchecker failure to trigger node-left");
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
        clusterManagerClsService.addStateApplier(event -> {
            if (succeedFollowerChecker.get()) {
    @Before
 * KIND, either express or implied.  See the License for the
            throw new NodeHealthCheckFailureException("fake followerchecker failure simulated by test to repro race condition");
        );
            "IllegalStateException[cannot make a new connection as disconnect to node",
            if (event.nodesRemoved()) {
        if (!client().admin().indices().prepareExists(indexName).get().isExists()) {
            client().admin()
                TimeUnit.SECONDS
        assertThat(response.isTimedOut(), is(false));
 * specific language governing permissions and limitations
        assertThat(response.isTimedOut(), is(false));
                    throw new RuntimeException(e);
            this.connectionBreaker = connectionBreaker;
import org.opensearch.test.OpenSearchIntegTestCase;
        // Simulate followerchecker failure on 1 node when succeedFollowerChecker is false
    public void testRestartDataNode() throws Exception {
            handler.messageReceived(request, channel, task);
            assertThat(response1.isTimedOut(), is(false));
import static org.hamcrest.Matchers.is;
    }
            Thread.sleep(1000);
import java.util.Collection;
        // create an index only if it doesn't exist
        // start a 3 node cluster with 1 cluster-manager
        // validate the 3 node cluster is up
import org.apache.logging.log4j.core.config.LoggerConfig;
        testLogsAppender.clearCapturedLogs();
import org.opensearch.test.TestLogsAppender;
    public void testClusterStabilityWhenDisconnectDuringSlowNodeLeftTask() throws Exception {
            .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "10s")
import org.opensearch.cluster.NodeConnectionsService;
 * The OpenSearch Contributors require contributions made to
        // Simulate a slow applier on the cm to delay node-left state application
        private FollowerCheckerBehaviour(Runnable connectionBreaker) {
            Thread.sleep(1000);
        loggerContext = (LoggerContext) LogManager.getContext(false);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
@SuppressForbidden(reason = "Pending fix: https://github.com/opensearch-project/OpenSearch/issues/18972")
    public void tearDown() throws Exception {
 */
import org.opensearch.test.store.MockFSIndexStore;
            }
        redTransportService.addRequestHandlingBehavior(FOLLOWER_CHECK_ACTION_NAME, simulatedFailureBehaviour);
 * ownership. Elasticsearch licenses this file to you under
        ClusterService clusterManagerClsService = internalCluster().getInstance(ClusterService.class, clusterManager);
    private class FollowerCheckerBehaviour implements StubbableTransport.RequestHandlingBehavior<TransportRequest> {
        logger.info("-> restarting stopped node");
        response = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
            // checking again to validate stability and ensure node did not leave
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_ACTION_NAME;
 *
    }
            } catch (InterruptedException e) {
        loggerConfig.removeAppender(testLogsAppender.getName());
            throw new NodeHealthCheckFailureException("fake followerchecker failure simulated by test to repro race condition");
        }
        assertThat(response.isTimedOut(), is(false));
        String indexName = "test";
 * not use this file except in compliance with the License.
import java.util.List;
        MockTransportService cmTransportService = (MockTransportService) internalCluster().getInstance(
                    Thread.sleep(3000);
            MockTransportService.TestPlugin.class,
        redTransportService.addRequestHandlingBehavior(FOLLOWER_CHECK_ACTION_NAME, simulatedFailureBehaviour);
            // checking again to validate stability and ensure node did not leave
            succeedFollowerChecker.set(true);
        Configuration config = loggerContext.getConfiguration();
        // Simulate a slow applier on the cm to delay node-left state application
        internalCluster().stopRandomNode(settings -> settings.get("node.name").equals(redNodeName));
import org.apache.logging.log4j.core.LoggerContext;
            .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "200ms")
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.service.ClusterService;
 */
        return Arrays.asList(
        internalCluster().stopRandomNode(settings -> settings.get("node.name").equals(clusterManager));
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes("2").get();
/*
        super.beforeIndexDeletion();
 * compatible open source license.
                try {
        LoggerConfig loggerConfig = config.getLoggerConfig(ClusterConnectionManager.class.getName());
        FollowerCheckerBehaviour simulatedFailureBehaviour = new FollowerCheckerBehaviour(() -> {
            .put(FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING.getKey(), "100ms")
        AtomicBoolean succeedFollowerChecker = new AtomicBoolean();
    }
        });
        assertTrue("Expected log was not found within the timeout period", logFound);
    }
            if (event.nodesRemoved()) {
            }
        // assert that join requests fail with the right exception
    public void testClusterStabilityWhenJoinRequestHappensDuringNodeLeftTask() throws Exception {
        this.redNodeName = internalCluster().startNode(Settings.builder().put("node.attr.color", "red").put(nodeSettings).build());
        succeedFollowerChecker.set(true);
        loggerContext = (LoggerContext) LogManager.getContext(false);
        boolean logFound = testLogsAppender.waitForLog("failed to join", 30, TimeUnit.SECONDS)
        // Wait for cluster to stabilize before checking node count
            assertThat(response3.isTimedOut(), is(false));
    private String clusterManager;
        );
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
            TransportService.class,
            TimeUnit.SECONDS
            redNodeName
import org.opensearch.common.SuppressForbidden;
        );
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
    public void testRestartCmNode() throws Exception {
                try {
        });
    }
        }
        // Loop runs 5 times to ensure race condition gets reproduced
import java.util.Arrays;
            succeedFollowerChecker.set(true);
                }
            redNodeName
import org.opensearch.tasks.Task;
        ensureGreen();
            30,
            assertThat(response1.isTimedOut(), is(false));
                throw new RuntimeException(e);
 * under the License.
import org.opensearch.test.transport.MockTransportService;
            );
            ClusterHealthResponse response1 = client().admin().cluster().prepareHealth().setWaitForNodes("2").get();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.junit.Before;
        internalCluster().startNode(Settings.builder().put("node.name", clusterManager).put(cmNodeSettings).build());
            TransportChannel channel,
            .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "100ms")
            MockEngineFactoryPlugin.class
            .build();
