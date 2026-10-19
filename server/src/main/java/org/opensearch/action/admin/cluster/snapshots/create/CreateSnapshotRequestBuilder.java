public class CreateSnapshotRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
    public CreateSnapshotRequestBuilder setIncludeGlobalState(boolean includeGlobalState) {
 * Licensed to Elasticsearch under one or more contributor  
     *
     *  
     *  
     * Sets the snapshot name  
    }
        request.indices(indices);
    public CreateSnapshotRequestBuilder setWaitForCompletion(boolean waitForCompletion) {
        request.snapshot(snapshot);  
 * GitHub history for details.
        return this;
     * @param xContentType the content type of the source
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
     * <p>
    /**
     * @param snapshot snapshot name
 */
     * @param waitForCompletion true if
     * prefix "test" except index "test42". Aliases are supported. An empty list or {"_all"} will snapshot all open
    public CreateSnapshotRequestBuilder setSettings(String source, XContentType xContentType) {
     */  
        request.settings(source, xContentType);
    CreateSnapshotRequest,
 * not use this file except in compliance with the License.
     * Sets repository-specific snapshot settings.  
        return this;
        request.settings(settings);  
 * @opensearch.api
    }
     * Sets repository-specific snapshot settings.
 * The OpenSearch Contributors require contributions made to  
        request.partial(partial);
        request.indicesOptions(indicesOptions);  
        return this;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        return this;  
        return this;  
    /**  
        super(client, action, new CreateSnapshotRequest(repository, snapshot));
     * See repository documentation for more information.
import org.opensearch.common.annotation.PublicApi;  
     * @param settings repository-specific snapshot settings
    public CreateSnapshotRequestBuilder setSettings(Settings.Builder settings) {
     * @return this builder
     *  
     */  
    }
     */
    public CreateSnapshotRequestBuilder(OpenSearchClient client, CreateSnapshotAction action) {  
     * @return this builder
    /**
    }  
        return this;
    /**
/*  
 * Modifications Copyright OpenSearch Contributors. See
    /**
    }
     *
     * indices in the cluster.
 *  
     * @param partial true if request should snapshot indices with unavailable shards  
        return this;  
    CreateSnapshotRequestBuilder> {
     * @param repository repository name
     */
     *
     * @return this builder
     * Sets a list of indices that should be included into the snapshot
 *  
     * Constructs a new create snapshot request builder
    public CreateSnapshotRequestBuilder(OpenSearchClient client, CreateSnapshotAction action, String repository, String snapshot) {
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
/**
     * @return this builder
    CreateSnapshotResponse,  
 * the Apache License, Version 2.0 (the "License"); you may
        return this;
/*  
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with  
}
@PublicApi(since = "1.0.0")  
     * Specifies the indices options. Like what type of requested indices to ignore. For example indices that don't exist.  
 * You may obtain a copy of the License at  
    /**
     * Sets the repository name
     * @return this builder
     */
     * @param source repository-specific snapshot settings  
    public CreateSnapshotRequestBuilder setSettings(Settings settings) {
    }
 */  
        request.repository(repository);
     * <p>
     *
     * If set to true the request should snapshot indices with unavailable shards
import org.opensearch.common.settings.Settings;
     * Set to true if snapshot should include global cluster state
 * compatible open source license.
        request.settings(settings);
    }
     * @param settings repository-specific snapshot settings
     * If set to true the request should wait for the snapshot completion before returning.
    }
        request.waitForCompletion(waitForCompletion);
    /**  
     * See repository documentation for more information.  
        super(client, action, new CreateSnapshotRequest());
     * <p>  
     *
     * @param settings repository-specific snapshot settings
     * @return this builder  
     */
    public CreateSnapshotRequestBuilder setPartial(boolean partial) {  
     */
     * Sets repository-specific snapshot settings.
     * @param indicesOptions the desired behaviour regarding indices options
    /**  
     * Sets repository-specific snapshot settings in YAML or JSON format
        return this;
    /**  
     */  
     * <p>
    public CreateSnapshotRequestBuilder setSettings(Map<String, Object> settings) {
        return this;  
     * @return this builder  
     */  
package org.opensearch.action.admin.cluster.snapshots.create;
     *
    /**
     * @return this request  
     * See repository documentation for more information.  
     */  
     */
    }
        request.includeGlobalState(includeGlobalState);
     */
 * Create snapshot request builder
     * @return this builder  
import org.opensearch.action.support.IndicesOptions;
    public CreateSnapshotRequestBuilder setIndices(String... indices) {  
 */  
     * Constructs a new create snapshot request builder with specified repository and snapshot names
import org.opensearch.common.xcontent.XContentType;
 * this work for additional information regarding copyright
        return this;
 * software distributed under the License is distributed on an
/*
    }  
 * specific language governing permissions and limitations
     * @param includeGlobalState true if snapshot should include global cluster state
 * this file be licensed under the Apache-2.0 license or a
    public CreateSnapshotRequestBuilder setRepository(String repository) {
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
    }  
     *  
    /**
import org.opensearch.transport.client.OpenSearchClient;  
    public CreateSnapshotRequestBuilder setSnapshot(String snapshot) {
     * <p>
    }
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
    public CreateSnapshotRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
     */  
     * See repository documentation for more information.
     * @return this builder
        request.settings(settings);  
     * @return this builder
 *
    /**  
     *  
 */
    }
import java.util.Map;
    /**
