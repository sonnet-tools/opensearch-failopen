        final Map<Index, CloseIndexResponse.IndexResult> results
 * ownership. Elasticsearch licenses this file to you under  
     */
        final Map<Index, ClusterBlock> blockedIndices,  
import org.opensearch.cluster.block.ClusterBlock;
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Allows to call {@link MetadataIndexStateService#addIndexClosedBlocks(Index[], Map, ClusterState)} which is a protected method.  
     * Allows to call {@link MetadataIndexStateService#closeRoutingTable(ClusterState, Map, Map)} which is a protected method.
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
/*
    }
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
     */  
        final Map<Index, ClusterBlock> blockedIndices,
import java.util.Map;
}
    /**
    public static ClusterState addIndexClosedBlocks(
        final ClusterState state,
    private MetadataIndexStateServiceUtils() {}  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
    public static ClusterState closeRoutingTable(
import org.opensearch.action.admin.indices.close.CloseIndexResponse;  
        final ClusterState state
 * Licensed to Elasticsearch under one or more contributor  
 */  
        return MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, state);
    }
 * Modifications Copyright OpenSearch Contributors. See  
 */
 *
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 */
 *  
/*
import org.opensearch.core.index.Index;  
 * specific language governing permissions and limitations
package org.opensearch.cluster.metadata;
    ) {  
    /**
 * GitHub history for details.
        final Index[] indices,  
import org.opensearch.cluster.ClusterState;
 * license agreements. See the NOTICE file distributed with
    ) {
 * You may obtain a copy of the License at  
        return MetadataIndexStateService.closeRoutingTable(state, blockedIndices, results).v1();  
public class MetadataIndexStateServiceUtils {
