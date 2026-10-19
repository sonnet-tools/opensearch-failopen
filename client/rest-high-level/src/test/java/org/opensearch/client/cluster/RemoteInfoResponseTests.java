            int numSocketsConnected = randomInt(5);  
/*
                assertThat(clientModeInfo.getServerName(), equalTo(serverModeInfo.getServerName()));  
import static java.util.stream.Collectors.toMap;  
    }
            assertThat(clientRemoteInfo.isSkipUnavailable(), equalTo(serverRemoteInfo.isSkipUnavailable()));  
/*  
            assertThat(clientRemoteInfo.isConnected(), equalTo(serverRemoteInfo.isConnected()));
            assertThat(clientRemoteInfo.getClusterAlias(), equalTo(serverRemoteInfo.getClusterAlias()));  
                    .getModeInfo();  
    @Override
    private static RemoteConnectionInfo createRandomRemoteConnectionInfo() {  
    }
            modeInfo = new SniffConnectionStrategy.SniffModeInfo(seedNodes, maxConnectionsPerCluster, numNodesConnected);  
 * ownership. Elasticsearch licenses this file to you under  
        List<RemoteConnectionInfo> remoteInfos = new ArrayList<>();
            .collect(toMap(RemoteConnectionInfo::getClusterAlias, identity()));  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
            List<String> seedNodes = randomList(randomInt(8), () -> randomAlphaOfLength(8));  
package org.opensearch.client.cluster;
    protected void assertInstances(
        RemoteInfoResponse clientInstance
                assertThat(clientModeInfo.getMaxConnectionsPerCluster(), equalTo(serverModeInfo.getMaxConnectionsPerCluster()));
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
            int maxConnectionsPerCluster = randomInt(5);
import java.util.ArrayList;
        assertThat(clientInstance.getInfos().size(), equalTo(serverTestInstance.getInfos().size()));  
                ProxyModeInfo clientModeInfo = (ProxyModeInfo) clientRemoteInfo.getModeInfo();
            }
    @Override
import java.io.IOException;  
                SniffConnectionStrategy.SniffModeInfo serverModeInfo = (SniffConnectionStrategy.SniffModeInfo) serverRemoteInfo
import org.opensearch.core.xcontent.XContentParser;
    }  
        Map<String, RemoteConnectionInfo> serverInfos = serverTestInstance.getInfos()
/*  
 * software distributed under the License is distributed on an
import org.opensearch.transport.SniffConnectionStrategy;
        org.opensearch.action.admin.cluster.remote.RemoteInfoResponse serverTestInstance,  
    }  
                equalTo(serverRemoteInfo.getInitialConnectionTimeout().toString())  
        boolean skipUnavailable = randomBoolean();
        RemoteConnectionInfo.ModeInfo modeInfo;
                SniffModeInfo clientModeInfo = (SniffModeInfo) clientRemoteInfo.getModeInfo();
 *
        }
            assertThat(clientRemoteInfo.getModeInfo().modeName(), equalTo(serverRemoteInfo.getModeInfo().modeName()));
                assertThat(clientModeInfo.getSeedNodes(), equalTo(serverModeInfo.getSeedNodes()));  
                fail("impossible case");
            remoteInfos.add(createRandomRemoteConnectionInfo());  
 * this work for additional information regarding copyright
        for (org.opensearch.client.cluster.RemoteConnectionInfo clientRemoteInfo : clientInstance.getInfos()) {
                assertThat(clientModeInfo.getMaxSocketConnections(), equalTo(serverModeInfo.getMaxSocketConnections()));
 */
        if (randomBoolean()) {
                    .getModeInfo();
        TimeValue initialConnectionTimeout = TimeValue.parseTimeValue(randomTimeValue(), "randomInitialConnectionTimeout");  
        return new org.opensearch.action.admin.cluster.remote.RemoteInfoResponse(remoteInfos);
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertThat(clientModeInfo.getNumNodesConnected(), equalTo(serverModeInfo.getNumNodesConnected()));
import java.util.List;
 * under the License.  
            .stream()
        } else {
            String serverName = randomAlphaOfLength(8);
import org.opensearch.common.xcontent.XContentType;  
import java.util.Map;  
    RemoteInfoResponse> {
                assertThat(clientModeInfo.getNumSocketsConnected(), equalTo(serverModeInfo.getNumSocketsConnected()));
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.client.AbstractResponseTestCase;
    ) {
                assertThat(clientModeInfo.getAddress(), equalTo(serverModeInfo.getAddress()));
        for (int i = 0; i < numRemoteInfos; i++) {
            assertThat(
    protected org.opensearch.action.admin.cluster.remote.RemoteInfoResponse createServerTestInstance(XContentType xContentType) {
        return RemoteInfoResponse.fromXContent(parser);
            int numNodesConnected = randomInt(5);
import org.opensearch.common.unit.TimeValue;
            RemoteConnectionInfo serverRemoteInfo = serverInfos.get(clientRemoteInfo.getClusterAlias());
 * KIND, either express or implied.  See the License for the
    org.opensearch.action.admin.cluster.remote.RemoteInfoResponse,
 *
            } else if (clientRemoteInfo.getModeInfo().modeName().equals(ProxyModeInfo.NAME)) {
 *  
 * specific language governing permissions and limitations
    protected RemoteInfoResponse doParseToClientInstance(XContentParser parser) throws IOException {  
            );
        }  
 */  
import org.opensearch.transport.RemoteConnectionInfo;  
import org.opensearch.transport.ProxyConnectionStrategy;
public class RemoteInfoResponseTests extends AbstractResponseTestCase<  
            if (clientRemoteInfo.getModeInfo().modeName().equals(SniffModeInfo.NAME)) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
        return new RemoteConnectionInfo(clusterAlias, modeInfo, initialConnectionTimeout, skipUnavailable);
                ProxyConnectionStrategy.ProxyModeInfo serverModeInfo = (ProxyConnectionStrategy.ProxyModeInfo) serverRemoteInfo  
        String clusterAlias = randomAlphaOfLength(8);
                clientRemoteInfo.getInitialConnectionTimeoutString(),
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
import static java.util.function.Function.identity;
        int numRemoteInfos = randomIntBetween(0, 8);  
            int maxSocketConnections = randomInt(5);
            modeInfo = new ProxyConnectionStrategy.ProxyModeInfo(address, serverName, maxSocketConnections, numSocketsConnected);
            } else {  
            assertThat(clientRemoteInfo.getModeInfo().isConnected(), equalTo(serverRemoteInfo.getModeInfo().isConnected()));
        }
            String address = randomAlphaOfLength(8);  
import static org.hamcrest.Matchers.equalTo;
}
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 */  
