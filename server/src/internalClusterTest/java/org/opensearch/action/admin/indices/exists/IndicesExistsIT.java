 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import java.io.IOException;  
 * not use this file except in compliance with the License.
 *
/*
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node)); // shut down node so that test properly cleans up
 * software distributed under the License is distributed on an
        Settings settings = Settings.builder().put(GatewayService.RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 99).build();  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        assertRequestBuilderThrows(  
 */  
    public void testIndexExistsWithBlocksInPlace() throws IOException {
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
    }  
 *
import org.opensearch.gateway.GatewayService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchIntegTestCase;  
/*  
 * compatible open source license.
            client(node).admin().indices().prepareExists("test").setClusterManagerNodeTimeout(TimeValue.timeValueSeconds(0)),
 *  
import org.opensearch.test.InternalTestCluster;
 * ownership. Elasticsearch licenses this file to you under  
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, numClientNodes = 0, autoManageMasterNodes = false)
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
 * Modifications Copyright OpenSearch Contributors. See
public class IndicesExistsIT extends OpenSearchIntegTestCase {
 * You may obtain a copy of the License at  
/*  
}
 * the Apache License, Version 2.0 (the "License"); you may
            ClusterManagerNotDiscoveredException.class
 */  
package org.opensearch.action.admin.indices.exists;
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;  
import org.opensearch.common.unit.TimeValue;
 * this file be licensed under the Apache-2.0 license or a
        );  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Settings;
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
        String node = internalCluster().startNode(settings);
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
