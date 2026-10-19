 * You may obtain a copy of the License at  
import org.opensearch.cloud.azure.classic.AbstractAzureComputeServiceTestCase;
 *
 *  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        );
        final String node1 = internalCluster().startNode(settings);
        logger.info("--> start first node");
import org.opensearch.common.settings.Settings;
 */
    public void testTwoNodesShouldRunUsingPrivateOrPublicIp() {
import org.opensearch.cloud.azure.classic.management.AzureComputeService.Discovery;
        final String hostType = randomFrom(org.opensearch.discovery.azure.classic.AzureSeedHostsProvider.HostType.values()).getType();
        logger.info("--> using azure host type " + hostType);  
        assertNumberOfNodes(2);
 * Licensed to Elasticsearch under one or more contributor  
        registerAzureNode(node1);  
 * license agreements. See the NOTICE file distributed with
            client().admin().cluster().prepareState().setClusterManagerNodeTimeout("1s").get().getState().nodes().getClusterManagerNodeId()
    }
 * the Apache License, Version 2.0 (the "License"); you may
        );  
 */  
        assertNotNull(
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
        logger.info("--> start another node");
 * specific language governing permissions and limitations
            .put(Management.SERVICE_NAME_SETTING.getKey(), "dummy")  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, numClientNodes = 0)
 * this work for additional information regarding copyright
        registerAzureNode(node2);
 *    http://www.apache.org/licenses/LICENSE-2.0
        // We expect having 2 nodes as part of the cluster, let's test that  
package org.opensearch.discovery.azure.classic;
 * Modifications Copyright OpenSearch Contributors. See
/*
 * software distributed under the License is distributed on an
            client().admin().cluster().prepareState().setClusterManagerNodeTimeout("1s").get().getState().nodes().getClusterManagerNodeId()  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        final Settings settings = Settings.builder()
            .build();
 * ownership. Elasticsearch licenses this file to you under  
/*  
 *
import org.opensearch.test.OpenSearchIntegTestCase;
        assertNotNull(
            .put(Discovery.HOST_TYPE_SETTING.getKey(), hostType)
 * not use this file except in compliance with the License.
}  
public class AzureTwoStartedNodesTests extends AbstractAzureComputeServiceTestCase {
import org.opensearch.cloud.azure.classic.management.AzureComputeService.Management;  
/*  
 * GitHub history for details.
 */  
        final String node2 = internalCluster().startNode(settings);  
 * KIND, either express or implied.  See the License for the
