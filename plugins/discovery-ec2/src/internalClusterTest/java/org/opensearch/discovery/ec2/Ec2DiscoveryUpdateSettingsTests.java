 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 */  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
 * under the License.  
 * You may obtain a copy of the License at  
}  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        final ClusterUpdateSettingsResponse response = client().admin()  
/*  
 *
        assertThat(value, is(expectedValue));
 * software distributed under the License is distributed on an
@ClusterScope(scope = Scope.TEST, numDataNodes = 0, numClientNodes = 0)  
            .prepareUpdateSettings()
        Settings nodeSettings = Settings.builder().put(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "ec2").build();  
 */
public class Ec2DiscoveryUpdateSettingsTests extends AbstractAwsTestCase {
    }
package org.opensearch.discovery.ec2;
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * compatible open source license.
 * Just an empty Node Start test to check everything if fine when
            .get();
            .cluster()
 * Licensed to Elasticsearch under one or more contributor  
 */  
        // We try to update a setting now  
 * GitHub history for details.
        final String value = response.getPersistentSettings().get(settingName);  
 *
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 *  
 */
/**
 * starting.  
/*
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.common.UUIDs;
 * This test requires AWS to run.
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.CoreMatchers.is;
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
        internalCluster().startNode(nodeSettings);
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
/*  
import org.opensearch.common.settings.Settings;  
            .setPersistentSettings(Settings.builder().put(settingName, expectedValue))  
        final String settingName = "cluster.routing.allocation.exclude.any_attribute";
        final String expectedValue = UUIDs.randomBase64UUID(random());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.discovery.DiscoveryModule;
    public void testMinimumClusterManagerNodesStart() {
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
