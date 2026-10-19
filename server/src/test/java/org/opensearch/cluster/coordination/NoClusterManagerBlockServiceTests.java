        createService(Settings.EMPTY);
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
            IllegalArgumentException.class,
        clusterSettings.applySettings(Settings.builder().put(NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "metadata_write").build());
        assertThat(noClusterManagerBlockService.getNoClusterManagerBlock(), sameInstance(NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES));
 * compatible open source license.
        noClusterManagerBlockService = new NoClusterManagerBlockService(settings, clusterSettings);  
 *  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
    public void testBlocksAllIfConfiguredBySetting() {
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES;
        createService(Settings.builder().put(NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "metadata_write").build());
import org.opensearch.common.settings.Settings;
    }  
 * You may obtain a copy of the License at  
    public void testRejectsInvalidSetting() {
    public void testBlocksMetadataWritesIfConfiguredBySetting() {  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.cluster.coordination;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
/*
    }
    }  
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES;
 * Unless required by applicable law or agreed to in writing,
 */
            () -> createService(Settings.builder().put(NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "unknown").build())
 * under the License.  
        createService(Settings.builder().put(NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "write").build());  
        createService(Settings.builder().put(NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "all").build());
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
/*
    }
import static org.hamcrest.Matchers.sameInstance;  
        );  
import org.opensearch.test.OpenSearchTestCase;
    public void testBlocksWritesIfConfiguredBySetting() {
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING;  
    }
        createService(Settings.builder().put(NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "all").build());
        clusterSettings = new ClusterSettings(settings, BUILT_IN_CLUSTER_SETTINGS);
    private void createService(Settings settings) {
    public void testBlocksWritesByDefault() {  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.ClusterSettings;  
        assertThat(noClusterManagerBlockService.getNoClusterManagerBlock(), sameInstance(NO_CLUSTER_MANAGER_BLOCK_ALL));
    private NoClusterManagerBlockService noClusterManagerBlockService;
 */
        assertThat(noClusterManagerBlockService.getNoClusterManagerBlock(), sameInstance(NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES));
        expectThrows(  
    private ClusterSettings clusterSettings;
    public void testSettingCanBeUpdated() {  
        assertThat(noClusterManagerBlockService.getNoClusterManagerBlock(), sameInstance(NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES));
        clusterSettings.applySettings(Settings.builder().put(NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "write").build());
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL;
        assertThat(noClusterManagerBlockService.getNoClusterManagerBlock(), sameInstance(NO_CLUSTER_MANAGER_BLOCK_ALL));  
 * Modifications Copyright OpenSearch Contributors. See  
 *
        assertThat(noClusterManagerBlockService.getNoClusterManagerBlock(), sameInstance(NO_CLUSTER_MANAGER_BLOCK_WRITES));
 * this file be licensed under the Apache-2.0 license or a
public class NoClusterManagerBlockServiceTests extends OpenSearchTestCase {
 *
    }  
}
    }
/*  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(noClusterManagerBlockService.getNoClusterManagerBlock(), sameInstance(NO_CLUSTER_MANAGER_BLOCK_WRITES));
