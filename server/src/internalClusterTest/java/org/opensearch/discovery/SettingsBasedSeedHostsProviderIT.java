import org.opensearch.transport.TransportInfo;
    protected Settings nodeSettings(int nodeOrdinal) {
            Settings.builder().putList(DISCOVERY_SEED_HOSTS_SETTING.getKey(), seedNodeAddress).build()
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
        Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));  
 * license agreements. See the NOTICE file distributed with
        return builder.build();  
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
            .get(0)
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        );  
 * KIND, either express or implied.  See the License for the
            .getAddress()  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
            extraNodes,
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 */
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
        if (randomBoolean()) {  
package org.opensearch.discovery;
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
        }
            .cluster()  
 *  
        final String seedNodeAddress = nodesInfoResponse.getNodes()  
            builder.putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey());
        final NodesInfoResponse nodesInfoResponse = client(seedNodeName).admin()
        } else {
    public void testClusterFormsWithSingleSeedHostInSettings() {  
            .nodesInfo(new NodesInfoRequest("_local"))
 * GitHub history for details.
 * compatible open source license.
import org.opensearch.common.settings.Settings;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final String seedNodeName = internalCluster().startNode();
/*  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.test.OpenSearchIntegTestCase;
 */  
        logger.info("--> using seed node address {}", seedNodeAddress);  
/*
        // super.nodeSettings enables file-based discovery, but here we disable it again so we can test the static list:
 *
 * Modifications Copyright OpenSearch Contributors. See
            builder.remove(DISCOVERY_SEED_PROVIDERS_SETTING.getKey());  
            .actionGet();
 * Licensed to Elasticsearch under one or more contributor  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, numClientNodes = 0)
        internalCluster().startNodes(  
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
 * software distributed under the License is distributed on an
public class SettingsBasedSeedHostsProviderIT extends OpenSearchIntegTestCase {
}
        // super.nodeSettings sets this to an empty list, which disables any search for other nodes, but here we want this to happen:  
        ensureStableCluster(extraNodes + 1);
    @Override
            .getInfo(TransportInfo.class)
        int extraNodes = randomIntBetween(1, 5);
            .publishAddress()
    }  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
            .toString();
        builder.remove(DISCOVERY_SEED_HOSTS_SETTING.getKey());
 */  
 *
