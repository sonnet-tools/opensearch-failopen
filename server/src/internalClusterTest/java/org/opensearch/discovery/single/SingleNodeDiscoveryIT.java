            final int port = service.boundAddress().publishAddress().getPort();
 * license agreements. See the NOTICE file distributed with
public class SingleNodeDiscoveryIT extends OpenSearchIntegTestCase {
                Function.identity()
        assertTrue(client().admin().indices().prepareExists("test").get().isExists());
            assertThat(first.nodes().getSize(), equalTo(1));
                         */
                            && event.getThrown().getCause().getClass() == IllegalStateException.class
import java.util.function.Function;
                @Override
            assertThat(first.metadata().clusterUUID(), not(equalTo(second.metadata().clusterUUID())));
                         * We align the port ranges of the two as then with zen discovery these two
                        return event.getThrown() != null
        final TransportService service = internalCluster().getInstance(TransportService.class);
            .put("discovery.type", "single-node")
                }
                assertBusy(() -> mockAppender.assertAllExpectationsMatched());
        return Settings.builder()
                other.beforeTest(random());
                public Settings nodeSettings(int nodeOrdinal) {
    public void testCannotJoinNodeWithSingleNodeDiscovery() throws Exception {
                    .build();
 * The OpenSearch Contributors require contributions made to
                createTempDir(),
                }
                    }
 */
 *
                    internalCluster().getClusterName(),
            final ClusterState second = other.getInstance(ClusterService.class).state();
            final ClusterState first = internalCluster().getInstance(ClusterService.class).state();
                        .put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), "0s")
    protected Settings nodeSettings(int nodeOrdinal) {
                    public boolean innerMatch(final LogEvent event) {
                assertThat(first.nodes().getSize(), equalTo(1));
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.not;
 */
        try (
import java.util.Arrays;
            assertThat(first.nodes().getClusterManagerNodeId(), not(equalTo(second.nodes().getClusterManagerNodeId())));
 * ownership. Elasticsearch licenses this file to you under
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(clusterLogger)) {
                                .getCause()
}
                public Path nodeConfigPath(int nodeOrdinal) {
 */
                    configurationSource,
                new MockLogAppender.SeenEventExpectation("test", JoinHelper.class.getCanonicalName(), Level.INFO, "failed to join") {
 * this work for additional information regarding copyright
                "other",
                            && event.getThrown()
import org.opensearch.test.InternalTestCluster;
import org.opensearch.transport.RemoteTransportException;
                    /*
    }
                return Settings.builder()
                    Arrays.asList(getTestTransportPlugin(), MockHttpTransport.TestPlugin.class),
 * under the License.
                    .put("discovery.type", "single-node")
                     * nodes would find each other.
        createIndex("test");
import org.opensearch.cluster.coordination.JoinHelper;
import org.opensearch.transport.TransportService;
import static org.hamcrest.Matchers.equalTo;
        ) {
                        .put("transport.type", getTestTransportType())
                internalCluster().getClusterName(),
                    false,
                InternalTestCluster other = new InternalTestCluster(
/*
            @Override
 *
                            && event.getThrown().getClass() == RemoteTransportException.class
import org.opensearch.cluster.service.ClusterService;
                        .put("transport.port", port + "-" + (port + 5 - 1))
                                .contains("cannot join node with [discovery.type] set to [single-node]");
                    0,
    }
                    randomLong(),
import org.opensearch.node.Node.DiscoverySettings;
                1,
        Logger clusterLogger = LogManager.getLogger(JoinHelper.class);
                    "other",
                return null;
                randomLong(),
import org.opensearch.common.settings.Settings;
import org.opensearch.test.NodeConfigurationSource;
 * Modifications Copyright OpenSearch Contributors. See
            final TransportService service = internalCluster().getInstance(TransportService.class);
                        .put("discovery.type", "zen")
 *
/*
                configurationSource,
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
                )
        };
import org.apache.logging.log4j.LogManager;
 *    http://www.apache.org/licenses/LICENSE-2.0
                                .getMessage()
 * Licensed to Elasticsearch under one or more contributor
                false,
            ) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.ClusterState;
        final NodeConfigurationSource configurationSource = new NodeConfigurationSource() {
                    .put("transport.port", port + "-" + (port + 5 - 1))
            try (
import org.apache.logging.log4j.core.LogEvent;
                    return null;
        internalCluster().fullRestart();
            };
            );
 * specific language governing permissions and limitations
 * compatible open source license.
                    1,
                    .put("transport.type", getTestTransportType())
package org.opensearch.discovery.single;
import org.opensearch.test.MockHttpTransport;
            public Path nodeConfigPath(int nodeOrdinal) {
                            && event.getThrown().getCause() != null
    }
            }
import java.io.IOException;
 * not use this file except in compliance with the License.
            assertThat(second.nodes().getSize(), equalTo(1));
    }
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        }
                final ClusterState first = internalCluster().getInstance(ClusterService.class).state();
 * this file be licensed under the Apache-2.0 license or a
    public void testSingleNodesDoNotDiscoverEachOther() throws IOException, InterruptedException {
import org.apache.logging.log4j.Logger;
            .put("transport.port", getPortRange())
                    1,
                @Override
import org.apache.logging.log4j.Level;
            final NodeConfigurationSource configurationSource = new NodeConfigurationSource() {
import org.opensearch.test.MockLogAppender;
 * You may obtain a copy of the License at
            mockAppender.addExpectation(
    public void testStatePersistence() throws Exception {
                    createTempDir(),
                    return Settings.builder()
                        /*
                     */
            }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false, autoManageMasterNodes = false)
            }
                Arrays.asList(getTestTransportPlugin(), MockHttpTransport.TestPlugin.class),
                        .build();
import java.nio.file.Path;
                        .put(featureFlagSettings())
                     * We align the port ranges of the two as then with zen discovery these two
                    Function.identity()
            public Settings nodeSettings(int nodeOrdinal) {
            .put(super.nodeSettings(nodeOrdinal))
                    .put(featureFlagSettings())
                    @Override
import org.opensearch.test.OpenSearchIntegTestCase;
                }
                false,
                    false,
                1,
            )
                         * nodes would find each other.
            .build();
                0,
            @Override
    @Override
            InternalTestCluster other = new InternalTestCluster(
 * SPDX-License-Identifier: Apache-2.0
/*
        }
        final int port = service.boundAddress().publishAddress().getPort();
            other.beforeTest(random());
