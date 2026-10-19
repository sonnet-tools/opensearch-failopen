    ClusterUpdateSettingsResponse,
/**  
 * not use this file except in compliance with the License.
    }  
 * under the License.  
     * Sets the source containing the transient settings to be updated. They will not survive a full cluster restart
        return this;
    /**  
    public ClusterUpdateSettingsRequestBuilder setPersistentSettings(Map<String, ?> settings) {
    }
package org.opensearch.action.admin.cluster.settings;
        return this;  
    public ClusterUpdateSettingsRequestBuilder setTransientSettings(Settings.Builder settings) {
    public ClusterUpdateSettingsRequestBuilder setPersistentSettings(Settings settings) {
    }
public class ClusterUpdateSettingsRequestBuilder extends AcknowledgedRequestBuilder<  
    /**  
 * Licensed to Elasticsearch under one or more contributor  
}  
     */
    }
    public ClusterUpdateSettingsRequestBuilder setTransientSettings(String settings, XContentType xContentType) {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.annotation.PublicApi;
     * Sets the transient settings to be updated. They will not survive a full cluster restart
        return this;
        request.persistentSettings(settings);  
/*  
    /**
import java.util.Map;
 */  
    /**
 * Builder for a cluster update settings request
        request.persistentSettings(settings);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public ClusterUpdateSettingsRequestBuilder setPersistentSettings(Settings.Builder settings) {
 * The OpenSearch Contributors require contributions made to  
    }
     * Sets the source containing the persistent settings to be updated. They will get applied cross restarts
 */
 * license agreements. See the NOTICE file distributed with
import org.opensearch.transport.client.OpenSearchClient;
     */
    ClusterUpdateSettingsRequest,
 */  
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")
import org.opensearch.common.settings.Settings;  
    ClusterUpdateSettingsRequestBuilder> {  
        return this;
 *  
 * SPDX-License-Identifier: Apache-2.0
        super(client, action, new ClusterUpdateSettingsRequest());  
    public ClusterUpdateSettingsRequestBuilder setTransientSettings(Map<String, ?> settings) {  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
     */  
        return this;
     */
        request.persistentSettings(settings);
     */
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        request.transientSettings(settings);
import org.opensearch.common.xcontent.XContentType;
     * Sets the transient settings to be updated. They will not survive a full cluster restart  
 *
 * Modifications Copyright OpenSearch Contributors. See
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
        request.transientSettings(settings);  
        request.transientSettings(settings);
/*
     */  
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
    /**
    /**  
 *     http://www.apache.org/licenses/LICENSE-2.0
        request.persistentSettings(settings, xContentType);
    }
    public ClusterUpdateSettingsRequestBuilder setTransientSettings(Settings settings) {  
     * Sets the persistent settings to be updated. They will get applied cross restarts  
 */
 * @opensearch.api  
    }
 *
        return this;
     */
 *
        request.transientSettings(settings, xContentType);
    }  
    }  
     */
    public ClusterUpdateSettingsRequestBuilder(OpenSearchClient client, ClusterUpdateSettingsAction action) {
     * Sets the persistent settings to be updated. They will get applied cross restarts
 * this file be licensed under the Apache-2.0 license or a
/*  
    public ClusterUpdateSettingsRequestBuilder setPersistentSettings(String settings, XContentType xContentType) {  
 * software distributed under the License is distributed on an
     * Sets the transient settings to be updated. They will not survive a full cluster restart
    /**
    /**
     * Sets the persistent settings to be updated. They will get applied cross restarts  
        return this;  
 * specific language governing permissions and limitations
 * compatible open source license.
