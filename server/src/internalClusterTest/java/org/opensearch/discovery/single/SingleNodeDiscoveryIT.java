            .build();
import org.opensearch.test.MockLogAppender;  
}  
                    @Override  
        };  
import org.apache.logging.log4j.LogManager;
                public Settings nodeSettings(int nodeOrdinal) {
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(first.metadata().clusterUUID(), not(equalTo(second.metadata().clusterUUID())));
                    }
    @Override
                        .put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), "0s")
                        return event.getThrown() != null
                    .put("discovery.type", "single-node")
                                .contains("cannot join node with [discovery.type] set to [single-node]");  
                    0,
            public Settings nodeSettings(int nodeOrdinal) {
                false,  
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(clusterLogger)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    false,
import org.opensearch.test.NodeConfigurationSource;
                }
 * not use this file except in compliance with the License.
                Function.identity()
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.coordination.JoinHelper;  
                            && event.getThrown().getClass() == RemoteTransportException.class  
        Logger clusterLogger = LogManager.getLogger(JoinHelper.class);
 * ownership. Elasticsearch licenses this file to you under  
                @Override
                @Override
import static org.hamcrest.Matchers.not;  
            final ClusterState second = other.getInstance(ClusterService.class).state();
 * KIND, either express or implied.  See the License for the
                    "other",
import org.opensearch.common.settings.Settings;
                new MockLogAppender.SeenEventExpectation("test", JoinHelper.class.getCanonicalName(), Level.INFO, "failed to join") {
    protected Settings nodeSettings(int nodeOrdinal) {  
                    public boolean innerMatch(final LogEvent event) {
import static org.hamcrest.Matchers.equalTo;
 * Unless required by applicable law or agreed to in writing,
                    false,
 * this work for additional information regarding copyright
                            && event.getThrown().getCause() != null
                0,
 *  
            )  
    }
                    .build();
                final ClusterState first = internalCluster().getInstance(ClusterService.class).state();
 * software distributed under the License is distributed on an
                }
 * under the License.  
        return Settings.builder()
import java.nio.file.Path;
 *
                return Settings.builder()
                1,
 * Modifications Copyright OpenSearch Contributors. See
 */
import org.opensearch.cluster.ClusterState;
import org.apache.logging.log4j.Level;
                        .put("transport.port", port + "-" + (port + 5 - 1))  
    }  
        }  
        final TransportService service = internalCluster().getInstance(TransportService.class);  
 * specific language governing permissions and limitations
                Arrays.asList(getTestTransportPlugin(), MockHttpTransport.TestPlugin.class),
        final NodeConfigurationSource configurationSource = new NodeConfigurationSource() {
 */  
                    internalCluster().getClusterName(),
                        .build();
                    .put("transport.type", getTestTransportType())
 * Licensed to Elasticsearch under one or more contributor  
                configurationSource,
            assertThat(first.nodes().getClusterManagerNodeId(), not(equalTo(second.nodes().getClusterManagerNodeId())));
                false,
import java.io.IOException;  
            .put(super.nodeSettings(nodeOrdinal))
                        .put("discovery.type", "zen")
import java.util.function.Function;  
            public Path nodeConfigPath(int nodeOrdinal) {  
public class SingleNodeDiscoveryIT extends OpenSearchIntegTestCase {  
            mockAppender.addExpectation(  
        internalCluster().fullRestart();
            };
        final int port = service.boundAddress().publishAddress().getPort();
                                .getCause()
import org.opensearch.test.OpenSearchIntegTestCase;
import org.apache.logging.log4j.core.LogEvent;
import org.opensearch.cluster.service.ClusterService;
            try (  
                "other",  
                }
            @Override  
            final NodeConfigurationSource configurationSource = new NodeConfigurationSource() {  
import java.util.Arrays;
                    .put(featureFlagSettings())  
                        .put(featureFlagSettings())
                     * nodes would find each other.
                    createTempDir(),  
    public void testStatePersistence() throws Exception {  
                         */
import org.opensearch.transport.TransportService;
 */  
        assertTrue(client().admin().indices().prepareExists("test").get().isExists());  
            .put("transport.port", getPortRange())
                    return Settings.builder()  
                    /*  
 * compatible open source license.
                assertThat(first.nodes().getSize(), equalTo(1));  
                    configurationSource,  
import org.opensearch.transport.RemoteTransportException;  
                    randomLong(),
                            && event.getThrown()  
import org.opensearch.test.MockHttpTransport;
                    return null;  
                        .put("transport.type", getTestTransportType())  
        }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.InternalTestCluster;
        try (
            final int port = service.boundAddress().publishAddress().getPort();
/*  
 * this file be licensed under the Apache-2.0 license or a
                1,
                        /*
                    1,  
            .put("discovery.type", "single-node")  
import org.apache.logging.log4j.Logger;  
 *
package org.opensearch.discovery.single;
 * license agreements. See the NOTICE file distributed with
                other.beforeTest(random());
            @Override
            other.beforeTest(random());
                            && event.getThrown().getCause().getClass() == IllegalStateException.class
                    1,
            ) {  
    }
import org.opensearch.node.Node.DiscoverySettings;  
            final TransportService service = internalCluster().getInstance(TransportService.class);
            final ClusterState first = internalCluster().getInstance(ClusterService.class).state();  
                randomLong(),  
 * GitHub history for details.
                InternalTestCluster other = new InternalTestCluster(
            );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(first.nodes().getSize(), equalTo(1));
                                .getMessage()
            assertThat(second.nodes().getSize(), equalTo(1));  
    public void testSingleNodesDoNotDiscoverEachOther() throws IOException, InterruptedException {
    public void testCannotJoinNodeWithSingleNodeDiscovery() throws Exception {  
        createIndex("test");
/*
                internalCluster().getClusterName(),  
                public Path nodeConfigPath(int nodeOrdinal) {
                     */  
                return null;
            InternalTestCluster other = new InternalTestCluster(
                    Function.identity()
                )
                         * nodes would find each other.
                     * We align the port ranges of the two as then with zen discovery these two
            }  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false, autoManageMasterNodes = false)
        ) {
                assertBusy(() -> mockAppender.assertAllExpectationsMatched());
                         * We align the port ranges of the two as then with zen discovery these two  
            }
                createTempDir(),
            }
                    .put("transport.port", port + "-" + (port + 5 - 1))
    }
/*  
                    Arrays.asList(getTestTransportPlugin(), MockHttpTransport.TestPlugin.class),  
