            .put(Management.SERVICE_NAME_SETTING.getKey(), "dummy")
public class AzureSimpleTests extends AbstractAzureComputeServiceTestCase {
}
 * GitHub history for details.
        registerAzureNode(node1);  
            .put(Discovery.HOST_TYPE_SETTING.getKey(), "public_ip");  
 */  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, numClientNodes = 0)  
 * ownership. Elasticsearch licenses this file to you under  
 *
        assertNotNull(
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * compatible open source license.
    public void testOneNodeShouldRunUsingPublicIp() {  
        final String node1 = internalCluster().startNode(settings);
 *  
 * KIND, either express or implied.  See the License for the
 *
        assertNumberOfNodes(1);  
    public void testOneNodeShouldRunUsingPrivateIp() {  
            .put(Management.SERVICE_NAME_SETTING.getKey(), "dummy")
        Settings.Builder settings = Settings.builder()
 */  
            .put(Discovery.HOST_TYPE_SETTING.getKey(), "private_ip");  
import org.opensearch.cloud.azure.classic.AbstractAzureComputeServiceTestCase;
 * The OpenSearch Contributors require contributions made to  
/*  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.common.settings.Settings;
        );  
import static org.hamcrest.Matchers.containsString;
        assertNotNull(
            .put(Discovery.HOST_TYPE_SETTING.getKey(), "do_not_exist");  
        assertNumberOfNodes(1);  
import org.opensearch.cloud.azure.classic.management.AzureComputeService.Discovery;
 *    http://www.apache.org/licenses/LICENSE-2.0
        // We expect having 1 node as part of the cluster, let's test that
            client().admin().cluster().prepareState().setClusterManagerNodeTimeout("1s").get().getState().nodes().getClusterManagerNodeId()
    }
 * You may obtain a copy of the License at  
package org.opensearch.discovery.azure.classic;
        Settings.Builder settings = Settings.builder()
 * under the License.  
            .put(Management.SERVICE_NAME_SETTING.getKey(), "dummy")
            client().admin().cluster().prepareState().setClusterManagerNodeTimeout("1s").get().getState().nodes().getClusterManagerNodeId()
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 */
import org.opensearch.cloud.azure.classic.management.AzureComputeService.Management;  
        assertThat(e.getMessage(), containsString("invalid value for host type [do_not_exist]"));  
 * Modifications Copyright OpenSearch Contributors. See
    public void testOneNodeShouldRunUsingWrongSettings() {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> internalCluster().startNode(settings));
 * this work for additional information regarding copyright
        final String node1 = internalCluster().startNode(settings);
import org.opensearch.test.OpenSearchIntegTestCase;
    }
        registerAzureNode(node1);  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
        // We expect having 1 node as part of the cluster, let's test that
        Settings.Builder settings = Settings.builder()
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * software distributed under the License is distributed on an
