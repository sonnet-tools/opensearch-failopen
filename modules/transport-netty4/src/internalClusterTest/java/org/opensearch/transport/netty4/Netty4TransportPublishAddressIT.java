                        // IPv4 address is preferred publish address for _local_
        for (NodeInfo nodeInfo : nodesInfoResponse.getNodes()) {
 * Unless required by applicable law or agreed to in writing,
    }
 * this file be licensed under the Apache-2.0 license or a
 *  
                    assertThat(boundAddress, instanceOf(TransportAddress.class));
        ensureStableCluster(2); // fails if port of publish address does not match corresponding bound address
        internalCluster().startNode(bothSettings); // should bind [::1]:XYZ and 127.0.0.1:XYZ+1
public class Netty4TransportPublishAddressIT extends OpenSearchNetty4IntegTestCase {  
import org.opensearch.transport.TransportInfo;
        logger.info("--> starting a node on ipv4 only");
 * KIND, either express or implied.  See the License for the
        }  
        logger.info("--> waiting for the cluster to declare itself stable");  
            }
        logger.info("--> checking if boundAddress matching publishAddress has same port");  
import org.opensearch.common.network.NetworkUtils;
            .put(super.nodeSettings(nodeOrdinal))
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    protected Settings nodeSettings(int nodeOrdinal) {
    }
import org.opensearch.core.common.transport.BoundTransportAddress;
                for (TransportAddress boundAddress : boundTransportAddress.boundAddresses()) {  
 * specific language governing permissions and limitations
            } else {
 * The OpenSearch Contributors require contributions made to  
            .put(NetworkModule.TRANSPORT_TYPE_KEY, Netty4ModulePlugin.NETTY_TRANSPORT_NAME)
                }
/*
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchIntegTestCase;  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
import java.net.Inet4Address;
 * under the License.  
            if (nodeInfo.getNode().getName().equals(ipv4OnlyNode)) {
                        assertThat(inetBoundAddress.getPort(), equalTo(boundTransportAddress.publishAddress().getPort()));
        return Settings.builder()  
package org.opensearch.transport.netty4;
import org.opensearch.OpenSearchNetty4IntegTestCase;
 * compatible open source license.
import org.opensearch.common.network.NetworkModule;
 *
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.transport.TransportAddress;
 */
                    }  
        String ipv4OnlyNode = internalCluster().startNode(ipv4Settings); // should bind 127.0.0.1:XYZ  
 * You may obtain a copy of the License at  
    public void testDifferentPorts() throws Exception {  
import org.opensearch.common.settings.Settings;  
        NodesInfoResponse nodesInfoResponse = client().admin().cluster().prepareNodesInfo().get();
 * the Apache License, Version 2.0 (the "License"); you may
                    if (inetBoundAddress.address().getAddress() instanceof Inet4Address) {  
 * different ports on ipv4 and ipv6.  
 */  
    @Override
 * this work for additional information regarding copyright
import org.opensearch.transport.Netty4ModulePlugin;
        }  
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
        logger.info("--> starting a node on ipv4 and ipv6");
import static org.hamcrest.Matchers.greaterThan;
                assertThat(boundTransportAddress.boundAddresses().length, greaterThan(1));
        if (!NetworkUtils.SUPPORTS_V6) {
                assertThat(boundTransportAddress.boundAddresses().length, equalTo(1));
            BoundTransportAddress boundTransportAddress = nodeInfo.getInfo(TransportInfo.class).getAddress();  
        Settings bothSettings = Settings.builder().put("network.host", "_local_").build();  
                    TransportAddress inetBoundAddress = boundAddress;
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
            .build();  
        Settings ipv4Settings = Settings.builder().put("network.host", "127.0.0.1").build();
/*  
 * Checks that OpenSearch produces a sane publish_address when it binds to
/**
import static org.hamcrest.Matchers.instanceOf;
 */
 */  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
                assertThat(boundTransportAddress.boundAddresses()[0].getPort(), equalTo(boundTransportAddress.publishAddress().getPort()));  
            return;
import static org.hamcrest.Matchers.equalTo;  
/*  
 *
 * ownership. Elasticsearch licenses this file to you under  
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
