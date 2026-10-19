        this.includeDefaults = includeDefaults;
package org.opensearch.action.admin.cluster.settings;
    private boolean includeDefaults = false;  
 */  
 *
    /**
    public ActionRequestValidationException validate() {  
        return this;  
 *
 * under the License.  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
/**
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    }
 * compatible open source license.
        return includeDefaults;
public class ClusterGetSettingsRequest extends ClusterManagerNodeReadRequest<ClusterGetSettingsRequest> {
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;  
 */
/*  
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
 * GitHub history for details.
    }
 * ownership. Elasticsearch licenses this file to you under  
    public ClusterGetSettingsRequest includeDefaults(boolean includeDefaults) {
 */  
     */  
}  
 * SPDX-License-Identifier: Apache-2.0
     * When include_defaults is set, return default settings which are normally suppressed.
 * specific language governing permissions and limitations
 * This request is specific to the REST client. {@link ClusterStateRequest}  
 * is used on the transport layer.
        return null;
 * KIND, either express or implied.  See the License for the
/*  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean includeDefaults() {  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * @opensearch.internal  
    }
