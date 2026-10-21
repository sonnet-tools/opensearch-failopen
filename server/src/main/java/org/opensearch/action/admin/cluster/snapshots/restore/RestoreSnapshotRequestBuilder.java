        return this;
     *
     */
     */
     */
        return this;
     * @return this builder
        request.includeGlobalState(restoreGlobalState);
        return this;
        return this;
    public RestoreSnapshotRequestBuilder setIndexSettings(Map<String, Object> source) {
        request.setSourceRemoteStoreRepository(repositoryName);
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
        super(client, action, new RestoreSnapshotRequest(repository, name));
 * specific language governing permissions and limitations
@PublicApi(since = "1.0.0")
    /**
     * @return this builder
     */
 *
     * Sets index settings that should be added or replaced during restore
import org.opensearch.common.annotation.PublicApi;
     * @return this builder
     * Sets the list of index settings and index settings groups that shouldn't be restored from snapshot
    }
    public RestoreSnapshotRequestBuilder setRepository(String repository) {
     *
import org.opensearch.common.settings.Settings;
 * the Apache License, Version 2.0 (the "License"); you may
     * @param snapshot snapshot name
 * GitHub history for details.
     * @return this builder
     *
     * @return this builder
    public RestoreSnapshotRequestBuilder setIndexSettings(Settings settings) {
 * Restore snapshot request builder
    }
    /**
        return this;
     * @param waitForCompletion if true the operation will wait for completion
        request.attachToDataStream(attachToDataStream);
    RestoreSnapshotResponse,
     * Sets the source remote translog repository name
     * @param indices list of indices
     * Sets repository name
     * rename pattern is applied according to the {@link java.util.regex.Matcher#appendReplacement(StringBuffer, String)}
     * @param settings index settings
        request.indexSettings(settings);
    }
     */
        request.storageType(storageType);
        request.waitForCompletion(waitForCompletion);
    /**
     * @return this builder
        request.indexSettings(source, xContentType);
        return this;
     * <p>
     */
    }
    /**
        return this;
     * pre-existing data stream of the same name instead of being restored as a standalone index.
 * license agreements. See the NOTICE file distributed with
        request.renameReplacement(renameReplacement);
    }
     * Constructs new restore snapshot request builder with specified repository and snapshot names
     * The request will fail if two or more indices will be renamed into the same name.
     *
     * <p>
     * @param renamePattern rename pattern
        return this;
     * Sets index settings that should be added or replaced during restore
     * @param source index settings
     */
     *
     * If this parameter is set to true the operation will wait for completion of restore process before returning.
    public RestoreSnapshotRequestBuilder setSourceRemoteStoreRepository(String repositoryName) {
     * @param restoreAliases true if aliases should be restored from the snapshot
    /**
     *
 */
        request.renameAliasReplacement(renameAliasReplacement);
     */
        request.ignoreIndexSettings(ignoreIndexSettings);
 * under the License.
     *
        request.partial(partial);
     */
    /**
     *
     * Sets snapshot name
        return this;
     * The global cluster state includes persistent settings and index template definitions.
     * @param restoreGlobalState true if global state should be restored from the snapshot
 * Licensed to Elasticsearch under one or more contributor
     * For example indices that don't exist.
 *     http://www.apache.org/licenses/LICENSE-2.0
    RestoreSnapshotRequestBuilder> {
     * Sets rename replacement
     * The request will fail if two or more alias will be renamed into the same name.
     * @param source index settings
package org.opensearch.action.admin.cluster.snapshots.restore;
import java.util.Map;
 * Modifications Copyright OpenSearch Contributors. See
     */
     */
    public RestoreSnapshotRequestBuilder setStorageType(RestoreSnapshotRequest.StorageType storageType) {
     * Sets the storage type
 * @opensearch.api
     * @param renameReplacement rename replacement
     */
    public RestoreSnapshotRequestBuilder(OpenSearchClient client, RestoreSnapshotAction action, String repository, String name) {
        return this;
    public RestoreSnapshotRequestBuilder setIncludeAliases(boolean restoreAliases) {
import org.opensearch.action.support.IndicesOptions;
    }
     */
    /**
    public RestoreSnapshotRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
    public RestoreSnapshotRequestBuilder setPartial(boolean partial) {
        return this;
import org.opensearch.common.xcontent.XContentType;
     * Sets index settings that should be added or replaced during restore
     */
    public RestoreSnapshotRequestBuilder setIndexSettings(Settings.Builder settings) {
     */
/*
     * See {@link #setRenamePattern(String)} for more information.
    }
     * @return this builder
     * <p>
    }
 * KIND, either express or implied.  See the License for the
 */
     * If set to true the restore procedure will restore global cluster state.
    /**
        request.renamePattern(renamePattern);
    public RestoreSnapshotRequestBuilder setIgnoreIndexSettings(String... ignoreIndexSettings) {
        request.includeAliases(restoreAliases);
     *
     */
    }
     * Sets the list of indices that should be restored from snapshot
        return this;
    public RestoreSnapshotRequestBuilder setWaitForCompletion(boolean waitForCompletion) {
    public RestoreSnapshotRequestBuilder setAttachToDataStream(boolean attachToDataStream) {
    }
        return this;
    public RestoreSnapshotRequestBuilder setRenameAliasPattern(String renameAliasPattern) {
     * See {@link #setRenameAliasPattern(String)} for more information.
     */
}
     * prefix "test" except index "test42". Aliases are not supported. An empty list or {"_all"} will restore all open
     * Indices that match the rename pattern will be renamed according to {@link #setRenameReplacement(String)}. The
    /**
        return this;
    /**
    }
        return this;
        request.indexSettings(settings);
    /**
    public RestoreSnapshotRequestBuilder setIndexSettings(String source, XContentType xContentType) {
     */
    /**
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
     * Sets the list of index settings and index settings groups that shouldn't be restored from snapshot
     * @param repository repository name
    public RestoreSnapshotRequestBuilder(OpenSearchClient client, RestoreSnapshotAction action) {
 * this work for additional information regarding copyright
    /**
    public RestoreSnapshotRequestBuilder setRenamePattern(String renamePattern) {
    /**
 */
        request.repository(repository);
    }
    }
     * rename pattern is applied according to the {@link java.util.regex.Matcher#appendReplacement(StringBuffer, String)}
    /**
/*
     *
     * <p>
    public RestoreSnapshotRequestBuilder setRenameReplacement(String renameReplacement) {
 */
/**
     * @param xContentType the content type of the source
 * not use this file except in compliance with the License.
     * @return this builder
     * Constructs new restore snapshot request builder
    }
     * @return this builder
 *
     * Sets rename pattern that should be applied to restored indices' aliases.
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
     *
     * @return this builder
     * @return this builder
 *
    /**
    public RestoreSnapshotRequestBuilder setIgnoreIndexSettings(List<String> ignoreIndexSettings) {
    /**
     * If set to true the restore procedure will restore aliases
        return this;
    public RestoreSnapshotRequestBuilder setRenameAliasReplacement(String renameAliasReplacement) {
     * @return this builder
    /**
    /**
 * SPDX-License-Identifier: Apache-2.0
    }
        return this;
 * this file be licensed under the Apache-2.0 license or a
    public RestoreSnapshotRequestBuilder setRestoreGlobalState(boolean restoreGlobalState) {
     * @param partial true if partially snapshotted indices should be restored
     * Aliases that match the rename pattern will be renamed according to {@link #setRenameAliasReplacement(String)}. The
     * @return this builder
     *
    }
     * Sets rename pattern that should be applied to restored indices.
     */
     */
     * Sets rename replacement
 * software distributed under the License is distributed on an
     */
     * indices in the snapshot.
    /**
     * @param renameAliasReplacement rename alias replacement
     *
     * @param settings index settings
     * <p>
     *
     *
        request.setSourceRemoteTranslogRepository(repositoryName);
 * The OpenSearch Contributors require contributions made to
     * @return this builder
     */
        return this;
     * @return this builder
        return this;
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
    }
/*
    public RestoreSnapshotRequestBuilder setSourceRemoteTranslogRepository(String repositoryName) {
    }
     * If set to true, a restored index whose name matches the data stream backing-index convention is attached to a
    }
    /**
 *
    /**
     */
     * @return this builder
    }
     *
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions
 * Unless required by applicable law or agreed to in writing,
        return this;
    /**
    /**
        return this;
    }
     * Sets index settings that should be added or replaced during restore
        request.ignoreIndexSettings(ignoreIndexSettings);
    }
        request.indicesOptions(indicesOptions);
        request.snapshot(snapshot);
public class RestoreSnapshotRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
    public RestoreSnapshotRequestBuilder setIndices(String... indices) {
    public RestoreSnapshotRequestBuilder setSnapshot(String snapshot) {
        return this;
    }
        super(client, action, new RestoreSnapshotRequest());
     * If set to true the restore procedure will restore partially snapshotted indices
     */
     * @param renameAliasPattern rename alias pattern
        request.renameAliasPattern(renameAliasPattern);
import org.opensearch.transport.client.OpenSearchClient;
        request.indices(indices);
     * Sets the source remote store repository name
     * <p>
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.
    RestoreSnapshotRequest,
    }
        request.indexSettings(source);
