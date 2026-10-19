                assertThat(transportAddress, instanceOf(TransportAddress.class));
            // bound addresses
public class Netty4TransportMultiPortIntegrationIT extends OpenSearchNetty4IntegTestCase {  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            for (TransportAddress transportAddress : boundTransportAddress.boundAddresses()) {
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.allOf;  
            }  
            randomPort = randomIntBetween(49152, 65525);
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
            // publish address
 * ownership. Elasticsearch licenses this file to you under  
            .put(super.nodeSettings(nodeOrdinal))  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import static org.hamcrest.Matchers.hasSize;  
    @Network  
            assertThat(nodeInfo.getInfo(TransportInfo.class).getProfileAddresses().keySet(), hasSize(1));
 * under the License.  
    }
import org.opensearch.common.network.NetworkAddress;  
/*
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
 *  
    public void testThatInfosAreExposed() throws Exception {
        if (randomPort == -1) {
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 *
package org.opensearch.transport.netty4;
 */
            .put("transport.profiles.client1.port", randomPortRange)
                assertThat(transportAddress, instanceOf(TransportAddress.class));
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * GitHub history for details.
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
import org.opensearch.transport.TransportInfo;
            assertThat(publishAddress.address().getPort(), is(4321));  
import static org.hamcrest.Matchers.instanceOf;
    private static String randomPortRange;  
            .put("transport.profiles.client1.reuse_address", true);
/*  
    private static int randomPort = -1;
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.hasKey;
    @Override
 */  
                    is(allOf(greaterThanOrEqualTo(randomPort), lessThanOrEqualTo(randomPort + 10)))
 * the Apache License, Version 2.0 (the "License"); you may
        for (NodeInfo nodeInfo : response.getNodes()) {  
            .put("transport.profiles.client1.publish_port", "4321")
            assertThat(nodeInfo.getInfo(TransportInfo.class).getProfileAddresses(), hasKey("client1"));
import static org.hamcrest.Matchers.is;
 */
            .put("transport.profiles.client1.publish_host", "127.0.0.7")  
import org.opensearch.test.junit.annotations.Network;  
 * Modifications Copyright OpenSearch Contributors. See  
 *
import static org.opensearch.action.admin.cluster.node.info.NodesInfoRequest.Metric.TRANSPORT;
import java.util.Locale;  
            TransportAddress publishAddress = boundTransportAddress.publishAddress();
                );
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
                    transportAddress.address().getPort(),  
    protected Settings nodeSettings(int nodeOrdinal) {  
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1, numClientNodes = 0)
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.transport.TransportAddress;  
        NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().clear().addMetric(TRANSPORT.metricName()).get();
    }
        return builder.build();  
            randomPortRange = String.format(Locale.ROOT, "%s-%s", randomPort, randomPort + 10);  
            assertThat(boundTransportAddress.publishAddress(), instanceOf(TransportAddress.class));  
            BoundTransportAddress boundTransportAddress = nodeInfo.getInfo(TransportInfo.class).getProfileAddresses().get("client1");  
}  
            assertThat(NetworkAddress.format(publishAddress.address().getAddress()), is("127.0.0.7"));
import org.opensearch.core.common.transport.BoundTransportAddress;
        }
            }  
 * Unless required by applicable law or agreed to in writing,
                assertThat(
        Settings.Builder builder = Settings.builder()
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
            for (TransportAddress transportAddress : boundTransportAddress.boundAddresses()) {  
import org.opensearch.OpenSearchNetty4IntegTestCase;  
 * compatible open source license.
            .put("network.host", "127.0.0.1")
        }
