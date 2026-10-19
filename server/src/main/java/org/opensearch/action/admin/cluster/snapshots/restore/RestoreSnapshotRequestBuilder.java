    public RestoreSnapshotRequestBuilder setRenameReplacement(String renameReplacement) {  
     * @return this builder  
    public RestoreSnapshotRequestBuilder(OpenSearchClient client, RestoreSnapshotAction action, String repository, String name) {
        super(client, action, new RestoreSnapshotRequest(repository, name));  
        request.indexSettings(source, xContentType);
import org.opensearch.common.annotation.PublicApi;  
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
import java.util.Map;  
        return this;
    /**
 */  
     */
     * Indices that match the rename pattern will be renamed according to {@link #setRenameReplacement(String)}. The
     * @return this builder  
/**
        return this;
 *
package org.opensearch.action.admin.cluster.snapshots.restore;
     * If set to true the restore procedure will restore partially snapshotted indices
    }
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 *  
     * Sets index settings that should be added or replaced during restore  
 *
        request.storageType(storageType);  
    }  
     * @param settings index settings  
    RestoreSnapshotRequestBuilder> {
/*
     * If this parameter is set to true the operation will wait for completion of restore process before returning.
     * indices in the snapshot.  
        return this;
    public RestoreSnapshotRequestBuilder setPartial(boolean partial) {  
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions
        super(client, action, new RestoreSnapshotRequest());
    }  
 * ownership. Elasticsearch licenses this file to you under  
    public RestoreSnapshotRequestBuilder setRenameAliasPattern(String renameAliasPattern) {  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    public RestoreSnapshotRequestBuilder setIndexSettings(Settings.Builder settings) {  
     * @return this builder  
     * @param renameAliasPattern rename alias pattern  
     * Aliases that match the rename pattern will be renamed according to {@link #setRenameAliasReplacement(String)}. The
     * @param settings index settings
     * Sets index settings that should be added or replaced during restore
     * <p>
        return this;
     * @param repository repository name
        return this;
    public RestoreSnapshotRequestBuilder setRepository(String repository) {
    public RestoreSnapshotRequestBuilder setSourceRemoteStoreRepository(String repositoryName) {
        return this;
     * Sets the list of index settings and index settings groups that shouldn't be restored from snapshot
     * @return this builder
    }  
    }
    }
    public RestoreSnapshotRequestBuilder setWaitForCompletion(boolean waitForCompletion) {  
    /**
     * <p>  
     *
    }
    public RestoreSnapshotRequestBuilder setSnapshot(String snapshot) {  
    /**
    /**
     * @param source index settings
    public RestoreSnapshotRequestBuilder(OpenSearchClient client, RestoreSnapshotAction action) {
     *
    /**
     * @param renamePattern rename pattern
     */
     * @param restoreAliases true if aliases should be restored from the snapshot
     * @return this builder
     * @param source index settings
     * Sets snapshot name
     */  
     * @return this builder
     *
    /**
    }
     * @param indices list of indices
 * software distributed under the License is distributed on an
     *
    public RestoreSnapshotRequestBuilder setIgnoreIndexSettings(String... ignoreIndexSettings) {
 * GitHub history for details.
        request.renameAliasPattern(renameAliasPattern);
        return this;
        request.setSourceRemoteTranslogRepository(repositoryName);
    }  
        request.attachToDataStream(attachToDataStream);
    }
     * Sets rename replacement
    /**  
        return this;  
import org.opensearch.common.settings.Settings;
     * Sets rename pattern that should be applied to restored indices' aliases.  
    /**
    /**
    }  
        return this;
 * @opensearch.api
    }  
    /**
    /**  
     */
        request.setSourceRemoteStoreRepository(repositoryName);
     * rename pattern is applied according to the {@link java.util.regex.Matcher#appendReplacement(StringBuffer, String)}  
        return this;  
    public RestoreSnapshotRequestBuilder setRestoreGlobalState(boolean restoreGlobalState) {
 * under the License.  
        request.indicesOptions(indicesOptions);  
     */  
     * If set to true, a restored index whose name matches the data stream backing-index convention is attached to a  
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@PublicApi(since = "1.0.0")
    /**  
    }  
     */
     * Sets the storage type  
        return this;
     * @return this builder
     * The request will fail if two or more alias will be renamed into the same name.
 */  
 * license agreements. See the NOTICE file distributed with
    /**  
     * @param snapshot snapshot name  
}
    /**
        return this;
import org.opensearch.common.xcontent.XContentType;
     * <p>  
    public RestoreSnapshotRequestBuilder setStorageType(RestoreSnapshotRequest.StorageType storageType) {
     */
     */
        request.indexSettings(settings);
     * @param xContentType the content type of the source  
 */  
    }
     * If set to true the restore procedure will restore global cluster state.  
     * <p>
    public RestoreSnapshotRequestBuilder setRenamePattern(String renamePattern) {
     * See {@link #setRenamePattern(String)} for more information.
        return this;  
        request.renamePattern(renamePattern);  
public class RestoreSnapshotRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
 * not use this file except in compliance with the License.
    public RestoreSnapshotRequestBuilder setIndices(String... indices) {
     */
        return this;
     */  
     */
 *
    public RestoreSnapshotRequestBuilder setSourceRemoteTranslogRepository(String repositoryName) {  
     *  
     * @return this builder
     *
     * Sets the source remote store repository name
     *
    public RestoreSnapshotRequestBuilder setIndexSettings(Map<String, Object> source) {
     *  
     * @return this builder
        request.renameAliasReplacement(renameAliasReplacement);
     * @return this builder
    }  
     * rename pattern is applied according to the {@link java.util.regex.Matcher#appendReplacement(StringBuffer, String)}
     * @param waitForCompletion if true the operation will wait for completion  
    /**  
    }
    }  
     * prefix "test" except index "test42". Aliases are not supported. An empty list or {"_all"} will restore all open
    public RestoreSnapshotRequestBuilder setAttachToDataStream(boolean attachToDataStream) {  
     * @param partial true if partially snapshotted indices should be restored  
    public RestoreSnapshotRequestBuilder setIndexSettings(Settings settings) {
        return this;
 */
     *
        request.snapshot(snapshot);
    RestoreSnapshotRequest,  
     * Sets the source remote translog repository name
        return this;  
     * @param renameReplacement rename replacement  
     */
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.
     * @return this builder
 * specific language governing permissions and limitations
/*  
    /**  
     */
    /**
        return this;
    }  
 * The OpenSearch Contributors require contributions made to  
        request.repository(repository);  
        request.waitForCompletion(waitForCompletion);
    }
     * Sets the list of index settings and index settings groups that shouldn't be restored from snapshot
 * KIND, either express or implied.  See the License for the
        return this;
     */  
    }
        request.includeAliases(restoreAliases);  
    public RestoreSnapshotRequestBuilder setIgnoreIndexSettings(List<String> ignoreIndexSettings) {  
        request.indexSettings(source);  
     */
    /**
        return this;  
     * Constructs new restore snapshot request builder with specified repository and snapshot names  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        request.ignoreIndexSettings(ignoreIndexSettings);
    /**
     * Sets index settings that should be added or replaced during restore
     * The request will fail if two or more indices will be renamed into the same name.  
     * <p>  
     */
 * this file be licensed under the Apache-2.0 license or a
     *  
import org.opensearch.action.support.IndicesOptions;
        request.partial(partial);
     *
     *
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
     * See {@link #setRenameAliasPattern(String)} for more information.
     * The global cluster state includes persistent settings and index template definitions.
    /**
 * compatible open source license.
     * @return this builder
     *
 *     http://www.apache.org/licenses/LICENSE-2.0
     * If set to true the restore procedure will restore aliases  
     * @return this builder  
     * For example indices that don't exist.  
     */
     * Sets index settings that should be added or replaced during restore  
     * Sets rename pattern that should be applied to restored indices.
    /**
     * Constructs new restore snapshot request builder
     *
        return this;
    public RestoreSnapshotRequestBuilder setIndexSettings(String source, XContentType xContentType) {  
     * Sets repository name  
     */
     * @return this builder
    RestoreSnapshotResponse,
        request.ignoreIndexSettings(ignoreIndexSettings);
     * Sets rename replacement  
     * Sets the list of indices that should be restored from snapshot
    }  
    }
     * pre-existing data stream of the same name instead of being restored as a standalone index.
     */  
 * You may obtain a copy of the License at  
     * @param renameAliasReplacement rename alias replacement
    /**
 * Modifications Copyright OpenSearch Contributors. See
     */
        return this;
    }
    public RestoreSnapshotRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
     */
        request.renameReplacement(renameReplacement);
        request.indexSettings(settings);
        request.indices(indices);  
     *
    public RestoreSnapshotRequestBuilder setRenameAliasReplacement(String renameAliasReplacement) {
     */  
     * @param restoreGlobalState true if global state should be restored from the snapshot
     */
    /**
/*  
    }
        return this;
import org.opensearch.transport.client.OpenSearchClient;  
    public RestoreSnapshotRequestBuilder setIncludeAliases(boolean restoreAliases) {
 * Restore snapshot request builder  
     * @return this builder  
     * <p>
        request.includeGlobalState(restoreGlobalState);
     * @return this builder  
     */
     *
