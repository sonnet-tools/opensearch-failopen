 * GitHub history for details.
    public boolean isPreserveExisting() {
 * under the License.  
        return this;
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 *
 */
 * Cluster state update request that allows to update settings for some indices
/**
     * it should not be overwritten by this update. The default is <code>false</code>
    }  
 *
    public UpdateSettingsClusterStateUpdateRequest settings(Settings settings) {  
/*  
 *  
 * @opensearch.internal
    /**
 * Unless required by applicable law or agreed to in writing,
        return settings;  
     */
        return preserveExisting;
 */  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
     * Sets the {@link Settings} to update
 * specific language governing permissions and limitations
        this.settings = settings;
     * Returns the {@link Settings} to update  
     */  
     */
 * software distributed under the License is distributed on an
    public UpdateSettingsClusterStateUpdateRequest setPreserveExisting(boolean preserveExisting) {  
     * Returns <code>true</code> iff the settings update should only add but not update settings. If the setting already exists
 *  
import org.opensearch.common.settings.Settings;
    private boolean preserveExisting = false;
import org.opensearch.cluster.ack.IndicesClusterStateUpdateRequest;
    }
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
public class UpdateSettingsClusterStateUpdateRequest extends IndicesClusterStateUpdateRequest<UpdateSettingsClusterStateUpdateRequest> {  
    /**  
     * unchanged.
    }  
    /**
/*  
    public Settings settings() {
    }  
}
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
    private Settings settings;
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Iff set to <code>true</code> this settings update will only add settings not already set on an index. Existing settings remain  
 */
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
        this.preserveExisting = preserveExisting;
        return this;
/*
 * KIND, either express or implied.  See the License for the
    /**  
package org.opensearch.action.admin.indices.settings.put;
 * ownership. Elasticsearch licenses this file to you under  
