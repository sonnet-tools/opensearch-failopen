    /**
 */
 * Unless required by applicable law or agreed to in writing,
}
 * under the License.  
import java.util.Map;
/**
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 */  
     */
import org.opensearch.cluster.ack.ClusterStateUpdateRequest;
     * Returns the index to version map for indices that should be updated  
    }
 *
/*  
 * @opensearch.internal
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        return versions;  
     * Sets the index to version map for indices that should be updated
import org.opensearch.Version;
public class UpgradeSettingsClusterStateUpdateRequest extends ClusterStateUpdateRequest<UpgradeSettingsClusterStateUpdateRequest> {  
 * this file be licensed under the Apache-2.0 license or a
 */
 * Cluster state update request that allows to change minimum compatibility settings for some indices
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 *
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.collect.Tuple;  
 *  
    public UpgradeSettingsClusterStateUpdateRequest() {
    public Map<String, Tuple<Version, String>> versions() {
        return this;
/*  
 * software distributed under the License is distributed on an
    }  
 * specific language governing permissions and limitations
    }  
    /**  
    public UpgradeSettingsClusterStateUpdateRequest versions(Map<String, Tuple<Version, String>> versions) {  
 */  
     */
 *  
 * Modifications Copyright OpenSearch Contributors. See
    private Map<String, Tuple<Version, String>> versions;
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
package org.opensearch.action.admin.indices.upgrade.post;
        this.versions = versions;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
