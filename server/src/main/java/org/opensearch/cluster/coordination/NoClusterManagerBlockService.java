 * Unless required by applicable law or agreed to in writing,
    );
        RestStatus.SERVICE_UNAVAILABLE,
 */
                return NO_CLUSTER_MANAGER_BLOCK_ALL;
            case "write":
 * @opensearch.internal
 * Service to block the master node
        this.noClusterManagerBlock = noClusterManagerBlock;  
        "metadata_write",
 *     http://www.apache.org/licenses/LICENSE-2.0
        Property.Dynamic,
        clusterSettings.addSettingsUpdateConsumer(NO_CLUSTER_MANAGER_BLOCK_SETTING, this::setNoClusterManagerBlock);
 * Modifications Copyright OpenSearch Contributors. See  
        }
import org.opensearch.cluster.block.ClusterBlockLevel;
import java.util.EnumSet;
                return NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES;
 *
 * The OpenSearch Contributors require contributions made to  
        false,  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        "cluster.no_cluster_manager_block",
                return NO_CLUSTER_MANAGER_BLOCK_WRITES;  
    // The setting below is going to replace the above.
        NoClusterManagerBlockService::parseNoClusterManagerBlock,
    public static final int NO_CLUSTER_MANAGER_BLOCK_ID = 2;
 */  
 * SPDX-License-Identifier: Apache-2.0
        ClusterBlockLevel.ALL  
 *
        Property.NodeScope,
    }
                );  
 * specific language governing permissions and limitations
        true,
        "cluster.no_master_block",
    public static final ClusterBlock NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES = new ClusterBlock(
        NoClusterManagerBlockService::parseNoClusterManagerBlock,  
        true,  
        "no cluster-manager",
    public static final Setting<ClusterBlock> NO_MASTER_BLOCK_SETTING = new Setting<>(  
 * software distributed under the License is distributed on an
    );
        NO_CLUSTER_MANAGER_BLOCK_ID,  
    private void setNoClusterManagerBlock(ClusterBlock noClusterManagerBlock) {
    }
    public NoClusterManagerBlockService(Settings settings, ClusterSettings clusterSettings) {
        "no cluster-manager",
        false,
        Property.Dynamic,
/*  
/*
 * You may obtain a copy of the License at  
 * compatible open source license.
/*
        NO_CLUSTER_MANAGER_BLOCK_ID,  
/**
        RestStatus.SERVICE_UNAVAILABLE,
    );
    private static ClusterBlock parseNoClusterManagerBlock(String value) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.block.ClusterBlock;  
    public ClusterBlock getNoClusterManagerBlock() {
import org.opensearch.core.rest.RestStatus;  
    public static final ClusterBlock NO_CLUSTER_MANAGER_BLOCK_ALL = new ClusterBlock(
                throw new IllegalArgumentException(
 */
import org.opensearch.common.settings.Setting;  
        NO_CLUSTER_MANAGER_BLOCK_ID,  
package org.opensearch.cluster.coordination;
        NO_MASTER_BLOCK_SETTING,  
 * this file be licensed under the Apache-2.0 license or a
                    "invalid no-cluster-manager block [" + value + "], must be one of [all, write, metadata_write]"
        Property.Deprecated  
 * ownership. Elasticsearch licenses this file to you under  
            case "all":  
        return noClusterManagerBlock;
 *  
        false,  
public class NoClusterManagerBlockService {  
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor  
    private volatile ClusterBlock noClusterManagerBlock;  
    public static final ClusterBlock NO_CLUSTER_MANAGER_BLOCK_WRITES = new ClusterBlock(
import org.opensearch.common.settings.Setting.Property;
        false,
        switch (value) {
 */
            default:  
    );
        true,
    // To keep backwards compatibility, the old usage is remained, and it's also used as the fallback for the new usage.  
        "no cluster-manager",
 *  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    public static final Setting<ClusterBlock> NO_CLUSTER_MANAGER_BLOCK_SETTING = new Setting<>(
        Property.NodeScope  
 * GitHub history for details.
 * under the License.  
        true,
    }  
        this.noClusterManagerBlock = NO_CLUSTER_MANAGER_BLOCK_SETTING.get(settings);  
        false,
        EnumSet.of(ClusterBlockLevel.WRITE, ClusterBlockLevel.METADATA_WRITE)  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
            case "metadata_write":
        EnumSet.of(ClusterBlockLevel.METADATA_WRITE)  
    );
import org.opensearch.common.settings.ClusterSettings;
        RestStatus.SERVICE_UNAVAILABLE,
