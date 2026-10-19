                String.format(  
        if (snapshot == null) {  
            } else {
    }  
        this.includeAliases = includeAliases;
 * ownership. Elasticsearch licenses this file to you under  
    public RestoreSnapshotRequest indexSettings(Settings settings) {
     */  
        }
        for (String index : indices) {  
            renameAliasReplacement,
        this.snapshotUuid = snapshotUuid;
            throw new IllegalArgumentException("Invalid storage_type: " + string);
            attachToDataStream = in.readBoolean();
                    "Unknown alias_write_index_policy [" + value + "]. Valid values are: " + Arrays.toString(values())
     */
 */  
    /**  
                }
     * Returns rename replacement  
        this.indexSettings = Settings.builder().loadFromMap(source).build();  
        return this;
     * @param attachToDataStream whether to attach matching restored indices to their data stream
        if (out.getVersion().onOrAfter(Version.V_3_8_0)) {
        return snapshotUuid;  
        }
        includeGlobalState = in.readBoolean();
        indicesOptions(IndicesOptions.fromMap(source, indicesOptions));
        }  
     * method lets us fail the restore if the precise snapshot we want is not available.  
        builder.field("alias_write_index_policy", aliasWriteIndexPolicy.name().toLowerCase(Locale.ROOT));
    public RestoreSnapshotRequest source(Map<String, Object> source) {
     * Alias write index policy for controlling how writeIndex attribute is handled during restore  
    }
     *
    @Nullable // if any snapshot UUID will do
 * Modifications Copyright OpenSearch Contributors. See
        return waitForCompletion;
    public RestoreSnapshotRequest aliasWriteIndexPolicy(AliasWriteIndexPolicy policy) {  
import org.opensearch.common.settings.Settings;  
    }  
 * software distributed under the License is distributed on an
    public RestoreSnapshotRequest indexSettings(String source, XContentType xContentType) {  
    /**
                partial(nodeBooleanValue(entry.getValue(), "partial"));
     *
        indices = in.readStringArray();
    }
        }
        writeSettingsToStream(indexSettings, out);
            out.writeEnum(aliasWriteIndexPolicy);
     * The global cluster state includes persistent settings and index template definitions.
            validationException = addValidationError("indexSettings are missing", validationException);
    /**
     * Returns rename alias replacement  
            && Objects.equals(indexSettings, that.indexSettings)
 *
        this.storageType = storageType;
        out.writeOptionalString(renameReplacement);
    public String renamePattern() {
        StorageType(String text) {
     *
     */
     * Sets alias write index policy for controlling how writeIndex attribute is handled during restore
            && Objects.equals(repository, that.repository)
    /**
    public String renameReplacement() {
     * @opensearch.api
        if (renameReplacement != null) {
    /**
        return Strings.toString(MediaTypeRegistry.JSON, this);
     * Returns rename pattern  
import org.opensearch.common.annotation.PublicApi;
        }  
        if (indicesOptions != null) {
        this.snapshot = snapshot;  
        REMOTE_SNAPSHOT("remote_snapshot");  
        builder.field("attach_to_data_stream", attachToDataStream);
        return includeGlobalState;  
                    throw new IllegalArgumentException("Unknown parameter " + name);  
            return text;
    @Nullable
                if (entry.getValue() instanceof String) {  
                    indices(Strings.splitStringByCommaToArray((String) entry.getValue()));
            renamePattern,
import java.util.ArrayList;
        boolean equals = waitForCompletion == that.waitForCompletion
        out.writeString(repository);
            builder.endObject();  
    public boolean attachToDataStream() {  
        return this;  
     */
    public ActionRequestValidationException validate() {
    }  
            } else if (name.equals("rename_pattern")) {  
 * license agreements. See the NOTICE file distributed with
        this.aliasWriteIndexPolicy = Objects.requireNonNull(policy);
                    ignoreIndexSettings(Strings.splitStringByCommaToArray((String) entry.getValue()));
     * @return true if global state should be restored  
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
    public RestoreSnapshotRequest repository(String repository) {
                }
        public static AliasWriteIndexPolicy fromString(String value) {  
    /**  
                if (entry.getValue() instanceof String) {  
     * Returns true if global state should be restored from this snapshot
    @Override  
            && Objects.equals(renameAliasReplacement, that.renameAliasReplacement)
        int result;  
    private AliasWriteIndexPolicy aliasWriteIndexPolicy = AliasWriteIndexPolicy.PRESERVE;
import java.nio.charset.StandardCharsets;
        return this;
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
        for (Map.Entry<String, Object> entry : source.entrySet()) {  
                    return type;
     *
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with  
     * Alias that match the rename pattern will be renamed according to {@link #renameAliasReplacement(String)}. The
    /**
    private String sourceRemoteTranslogRepository = null;  
        ActionRequestValidationException validationException = null;
     * @return this request
        this.renameReplacement = renameReplacement;
            snapshotUuid,
        if (in.getVersion().onOrAfter(Version.V_2_7_0)) {
        includeAliases = in.readBoolean();  
        if (indexSettings == null) {  
    }  
    }
                attachToDataStream(nodeBooleanValue(entry.getValue(), "attach_to_data_stream"));  
    public String repository() {
        renameReplacement = in.readOptionalString();
import java.io.IOException;  
                    throw new IllegalArgumentException("malformed rename_replacement");
            } else if (name.equals("rename_alias_replacement")) {  
     *  
                } else {  
        out.writeBoolean(waitForCompletion);  
                    throw new IllegalArgumentException("malformed rename_pattern");
    public RestoreSnapshotRequest setSourceRemoteStoreRepository(String sourceRemoteStoreRepository) {  
            this.text = text;
                    ignoreIndexSettings((List<String>) entry.getValue());  
                    storageType(StorageType.fromString((String) entry.getValue()));
            out.writeOptionalString(renameAliasReplacement);
    private boolean includeGlobalState = false;  
     * Sets the list of indices that should be restored from snapshot
    public RestoreSnapshotRequest waitForCompletion(boolean waitForCompletion) {
        return this;  
     * @param renamePattern rename pattern  
            && aliasWriteIndexPolicy == that.aliasWriteIndexPolicy
            && Objects.equals(renameAliasPattern, that.renameAliasPattern)  
 * not use this file except in compliance with the License.
    @Override
        }
     *
import org.opensearch.core.common.io.stream.StreamOutput;
 * You may obtain a copy of the License at  
        return this;  
        }  
        this.indexSettings = settings;  
    }  
     * Returns settings that should be added/changed in all restored indices
    /**
    public String renameAliasReplacement() {
     *  
     * @param renameAliasPattern rename pattern  
    @Override
     * @return rename pattern
        builder.endArray();  
                }
            aliasWriteIndexPolicy,  
     * <p>
     */
     * this is the snapshot that this request restores. If the client can only identify a snapshot by its name then there is a risk that the
     * If this parameter is set to true the operation will wait for completion of restore process before returning.  
import java.util.List;
    /**
     * @param renameAliasReplacement rename replacement
    private String snapshotUuid;  
 * Licensed to Elasticsearch under one or more contributor  
            } else if (name.equals("rename_alias_pattern")) {  
     * @return rename alias pattern
            waitForCompletion,  
        return sourceRemoteStoreRepository;  
            attachToDataStream
    public RestoreSnapshotRequest includeGlobalState(boolean includeGlobalState) {
            builder.field("storage_type", text);
     *  
    /**
        }  
            out.writeOptionalString(renameAliasPattern);
     */
        }  
     */  
     */  
            renameAliasReplacement = in.readOptionalString();
        }  
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.
            out.writeEnum(storageType);
                DEPRECATION_LOGGER.deprecate(
        }  
                    "rename_replacement string size exceeds max allowed size of %s bytes",
        return this;
    @SuppressWarnings("unchecked")
        }  
     * @param partial true if indices with failed to snapshot shards should be partially restored.
import org.opensearch.Version;
     * @return true if aliases should be restored
            );  
        }  
     */  
    /**
                }
     * For example indices that don't exist.  
        return result;
            snapshot,
     * @return this request
        builder.field("partial", partial);
        this.indices = indices;
        }
    public RestoreSnapshotRequest indices(String... indices) {
                    Locale.ROOT,
    public enum AliasWriteIndexPolicy {
                }
 * @opensearch.api  
        return partial;
    }  
    private String renameAliasReplacement;
     * <p>
        return this;
            && renameReplacement.getBytes(StandardCharsets.UTF_8).length > MetadataCreateIndexService.MAX_INDEX_NAME_BYTES) {
     */
    @Nullable  
     */  
            builder.startObject("index_settings");
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    @Override  
    }  
    /**
     */
    }
    }  
        builder.startArray("ignore_index_settings");
            sourceRemoteTranslogRepository,
     *
 * Unless required by applicable law or agreed to in writing,
            out.writeOptionalString(sourceRemoteTranslogRepository);
    public String snapshot() {  
    }
            }
    }  
     *
            storageType.toXContent(builder);
        }  
     */
                }
    }  
    @PublicApi(since = "1.0.0")  
        this.attachToDataStream = attachToDataStream;
        result = Objects.hash(
     */  
     * @param includeAliases true if aliases should be restored from the snapshot  
        return this;
     * Sets rename pattern that should be applied to restored indices' alias.  
        out.writeStringArray(ignoreIndexSettings);
            if (name.equals("indices")) {
    /**  
 *
    }
package org.opensearch.action.admin.cluster.snapshots.restore;
        return this;
     */  
     * When {@code true}, a restored index whose name matches the data stream backing-index convention  
     * Sets repository name
    private String renameReplacement;
        snapshotUuid = in.readOptionalString();  
                validationException
    public boolean equals(Object o) {
            validationException = addValidationError("indicesOptions is missing", validationException);
    }
     */
     * Returns the name of the snapshot.
     * <p>
        out.writeString(snapshot);  
                if (entry.getValue() instanceof String) {
            } else if (name.equals("source_remote_translog_repository")) {  
     */
            } else if (name.equals("storage_type")) {
                if (entry.getValue() instanceof String) {
        return this;
        builder.startArray("indices");
        this.waitForCompletion = waitForCompletion;  
        return ignoreIndexSettings;
        if (renameAliasPattern != null) {
     *  
     */
                    throw new IllegalArgumentException("malformed settings section");
            validationException = addValidationError("ignoreIndexSettings are missing", validationException);
}  
            }
        }  
    }
     */
            && attachToDataStream == that.attachToDataStream;  
/*  
            sourceRemoteStoreRepository,
            repository,  
     */
import org.opensearch.core.xcontent.ToXContentObject;  
    public RestoreSnapshotRequest snapshotUuid(String snapshotUuid) {
     * Returns Source Remote Store Repository for all the restored indices
        }  
        if (indexSettings != null) {
            includeGlobalState,
    /**
     * Returns Source Remote Translog Repository for all the restored indices
        if (ignoreIndexSettings == null) {  
    public int hashCode() {
     * @return this request
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
     *
    /**  
     *  
     *  
        if (renamePattern != null) {
            builder.field("rename_pattern", renamePattern);
    public RestoreSnapshotRequest indicesOptions(IndicesOptions indicesOptions) {  
 * the Apache License, Version 2.0 (the "License"); you may
            && Arrays.equals(indices, that.indices)
    }  
     */
    public String getSourceRemoteTranslogRepository() {
    public RestoreSnapshotRequest renameReplacement(String renameReplacement) {  
    public RestoreSnapshotRequest(StreamInput in) throws IOException {
        this.repository = repository;
        }  
                    renamePattern((String) entry.getValue());
                if (type.text.equals(string)) {
     * Sets settings that should be added/changed in all restored indices  
            validationException = addValidationError("name is missing", validationException);
     * Returns whether matching restored indices are attached to their data stream.
 * KIND, either express or implied.  See the License for the
     * <p>
        if (storageType != null) {
    }
     *  
        out.writeOptionalString(snapshotUuid);  
        builder.field("include_aliases", includeAliases);  
        this.includeGlobalState = includeGlobalState;
     * a sufficient identifier.
    }
     * @return true if the operation will wait for completion
    }  
                }  
        if (indicesOptions == null) {  
    /**
     */  
        return this;  
        indicesOptions.writeIndicesOptions(out);  
        if (sourceRemoteTranslogRepository != null) {
     * Constructs a new put repository request with the provided repository and snapshot names.  
                return valueOf(value.toUpperCase(Locale.ROOT));
     */  
        snapshot = in.readString();  
     *
        @Override
     */  
    /**
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
     * This is for internal use only and is not exposed in the REST layer.
    }  
    }  
     * @param repository repository name
        return this;  
     * Sets the list of index settings and index settings groups that shouldn't be restored from snapshot  
    public boolean includeAliases() {
        }
     * Parses restore definition
     * Returns list of indices that should be restored from snapshot
        return validationException;
     * Sets Source Remote Translog Repository for all the restored indices  
    }
        PRESERVE,  
     *
    /**
        return renameAliasReplacement;
                    MetadataCreateIndexService.MAX_INDEX_NAME_BYTES  
    /**
        this.partial = partial;
     * @return repository name  
                } else {
            out.writeBoolean(attachToDataStream);
     */  
            && Arrays.equals(ignoreIndexSettings, that.ignoreIndexSettings)  
    }
    private StorageType storageType = StorageType.LOCAL;
        if (o == null || getClass() != o.getClass()) return false;  
     * <p>
     * @return this request
        }
            builder.value(ignoreIndexSetting);
     * rename pattern is applied according to the {@link java.util.regex.Matcher#appendReplacement(StringBuffer, String)}  
        waitForCompletion = in.readBoolean();  
        if (sourceRemoteStoreRepository != null) {
import org.opensearch.common.Nullable;  
        STRIP_WRITE_INDEX;
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.  
    /**  
                } else if (entry.getValue() instanceof ArrayList) {
                    throw new IllegalArgumentException("malformed rename_alias_replacement");
            builder.field("rename_alias_replacement", renameAliasReplacement);
            validationException = addValidationError("repository is missing", validationException);
     *
                    setSourceRemoteTranslogRepository((String) entry.getValue());
     *
            && includeGlobalState == that.includeGlobalState  
    }  
    }  
     * Sets settings that should be added/changed in all restored indices
    /**  
    public String[] ignoreIndexSettings() {
     *
                throw new IllegalArgumentException(
            validationException = addValidationError("indices are missing", validationException);
        return this;  
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
    private String renamePattern;
                    throw new IllegalArgumentException("malformed rename_alias_pattern");
        if (Strings.isNullOrEmpty(renameReplacement) == false  
import org.opensearch.common.logging.DeprecationLogger;
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();  
            includeAliases,  
            } else if (name.equals("include_aliases")) {
     */
    }
        renamePattern = in.readOptionalString();
     * Set to true to allow indices with failed to snapshot shards should be partially restored.
    /**
            } else if (name.equals("attach_to_data_stream")) {
        this.ignoreIndexSettings = ignoreIndexSettings.toArray(new String[0]);  
        if (in.getVersion().onOrAfter(Version.V_3_3_0)) {
     * @return this request  
        LOCAL("local"),
    public boolean partial() {  
    }
        }  
        }  
import org.opensearch.action.support.IndicesOptions;  
     * @param includeGlobalState true if global state should be restored from the snapshot
        this.sourceRemoteStoreRepository = sourceRemoteStoreRepository;
     * restore. Defaults to {@code false}, in which case such an index is restored as a standalone index.
    }  
        public String toString() {  
     * Sometimes a client has identified precisely which snapshot is to be restored via a separate mechanism and wishes to guarantee that  
                    throw new IllegalArgumentException("malformed source_remote_translog_repository");
     * Returns alias write index policy  
     */  
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
                } else {
        return this;
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
    }  
    public String snapshotUuid() {
                    "RestoreSnapshotRequest#settings",
     * Sets rename alias replacement  
     * @return this request
    public String[] indices() {  
     * @return rename replacement
            aliasWriteIndexPolicy = in.readEnum(AliasWriteIndexPolicy.class);
     * Sets rename pattern that should be applied to restored indices.  
        return indicesOptions;
        return renameReplacement;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }  
            indexSettings,
    /**
    }
        return storageType;
                if (!(entry.getValue() instanceof Map)) {
     * Returns repository name
            partial,
 */
        }  
    public RestoreSnapshotRequest setSourceRemoteTranslogRepository(String sourceRemoteTranslogRepository) {
            && Objects.equals(renamePattern, that.renamePattern)
     * @opensearch.api
                includeGlobalState = nodeBooleanValue(entry.getValue(), "include_global_state");  
    public RestoreSnapshotRequest renameAliasPattern(String renameAliasPattern) {  
            && Objects.equals(storageType, that.storageType)
            try {
    }  
import static org.opensearch.action.ValidateActions.addValidationError;  
            String name = entry.getKey();
     *  
     */
        return this;
        indicesOptions = IndicesOptions.readIndicesOptions(in);  
                } else {
            validationException = addValidationError(
    /**
    }
        return this;
        return indices;
    }
     * @return source Remote Translog Repository  
    /**
     * See {@link #renameAliasPattern(String)} for more information.
        super(in);
    }
    private Settings indexSettings = EMPTY_SETTINGS;  
                    indices((ArrayList<String>) entry.getValue());  
                }  
        super.writeTo(out);
        }  
     * Sets settings that should be added/changed in all restored indices
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        repository = in.readString();
 * this file be licensed under the Apache-2.0 license or a
    /**  
            }
        return includeAliases;
        this.renamePattern = renamePattern;
    public String getSourceRemoteStoreRepository() {
                    renameAliasReplacement((String) entry.getValue());
        this.sourceRemoteTranslogRepository = sourceRemoteTranslogRepository;
    }
                if (entry.getValue() instanceof String) {  
 * compatible open source license.
    public RestoreSnapshotRequest() {}  
     */  
     * The request will fail if two or more indices will be renamed into the same name.
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
     */
                    throw new IllegalArgumentException("malformed ignore_index_settings section, should be an array of strings");
                includeAliases = nodeBooleanValue(entry.getValue(), "include_aliases");
    @Override  
    /**  
     * @return this request
    private String[] indices = Strings.EMPTY_ARRAY;
                    throw new IllegalArgumentException("malformed index_settings section");
    }
     *  
                    renameReplacement((String) entry.getValue());
    public RestoreSnapshotRequest includeAliases(boolean includeAliases) {  
                if (entry.getValue() instanceof String) {
     */
            && Objects.equals(renameReplacement, that.renameReplacement)
/*
    }  
    /**
        return builder;
            } else if (name.equals("rename_replacement")) {  
     * @return this request
     */  
        return this.indexSettings;
     */
     * Sets the list of indices that should be restored from snapshot
     * indices in the snapshot.
     * <p>
    private boolean includeAliases = true;
    @Nullable
    public void writeTo(StreamOutput out) throws IOException {
        }  
        return this;
 * The OpenSearch Contributors require contributions made to  
    /**  
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
                if (entry.getValue() instanceof String) {
    private String renameAliasPattern;  
import org.opensearch.action.ActionRequestValidationException;
    }
        for (String ignoreIndexSetting : ignoreIndexSettings) {  
 */
     * Returns wait for completion setting
     * @param repository repository name
     */
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
     * Sets the list of index settings and index settings groups that shouldn't be restored from snapshot
        return "snapshot [" + repository + ":" + snapshot + "]";  
                } else {  
                    throw new IllegalArgumentException("malformed source_remote_store_repository");
        out.writeBoolean(includeAliases);  
     * @return source Remote Store Repository  
        this.indexSettings = Settings.builder().loadFromSource(source, xContentType).build();
     *  
                if (!(entry.getValue() instanceof Map)) {
    private String repository;
            renameAliasPattern = in.readOptionalString();
        private final String text;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
    }
     * @param policy the policy to apply  
        if (in.getVersion().onOrAfter(Version.V_3_8_0)) {
        out.writeBoolean(includeGlobalState);
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(RestoreSnapshotRequest.class);
    }  
        out.writeStringArray(indices);
    /**
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with  
    public RestoreSnapshotRequest indexSettings(Settings.Builder settings) {
     * implicit default if not overridden.
    public String toString() {  
    }
    private boolean attachToDataStream = false;
 * SPDX-License-Identifier: Apache-2.0
     * @return true if indices with failed to snapshot shards should be partially restored
        return this.repository;  
@PublicApi(since = "1.0.0")
        private static StorageType fromString(String string) {
     *
            && Objects.equals(snapshot, that.snapshot)  
        this.indicesOptions = indicesOptions;
     * ({@code .ds-<dataStream>-NNNNNN}) is attached to a pre-existing data stream of the same name as part of the
     * If set to true the restore procedure will restore global cluster state.  
                }  
                    throw new IllegalArgumentException("malformed indices section, should be an array of strings");
    /**  
        );
        if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
                if (entry.getValue() instanceof String) {
                );
     * Sets Source Remote Store Repository for all the restored indices
     * indices in the snapshot.
    }  
     */
     */
    }
        return sourceRemoteTranslogRepository;  
 * under the License.  
     * Returns true if indices with failed to snapshot shards should be partially restored.
            builder.value(index);
        if (out.getVersion().onOrAfter(Version.V_3_3_0)) {
    }
            builder.field("rename_replacement", renameReplacement);
     * @return the desired behaviour regarding indices to ignore and wildcard indices expression
                ),
     * @return this request
     * @param indices list of indices
            if (indexSettings.isEmpty() == false) {  
    }
        }
    public StorageType storageType() {  
        if (this == o) return true;
                } else {  
            sourceRemoteTranslogRepository = in.readOptionalString();
    }
    /**  
    public RestoreSnapshotRequest indices(List<String> indices) {
     *
        }  
    }
        this.renameAliasPattern = renameAliasPattern;
     * @param indices list of indices
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentBuilder;
    public RestoreSnapshotRequest attachToDataStream(boolean attachToDataStream) {
            && Objects.equals(sourceRemoteTranslogRepository, that.sourceRemoteTranslogRepository)
        return this;
        return equals;
     *  
     * Indices that match the rename pattern will be renamed according to {@link #renameReplacement(String)}. The
        }  
    public boolean waitForCompletion() {  
    /**
     */
    public Settings indexSettings() {
                } else {  
        return this.snapshot;
        return aliasWriteIndexPolicy;
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
import java.util.Locale;
import java.util.Objects;
     */
                }
        out.writeOptionalString(renamePattern);
        this.repository = repository;
    public AliasWriteIndexPolicy aliasWriteIndexPolicy() {
     * Sets settings that should be added/changed in all restored indices  
                }
            renameReplacement,  
    private String snapshot;  
        builder.field("include_global_state", includeGlobalState);
    /**
    /**
                    throw new IllegalArgumentException("malformed storage_type");  
     * Enumeration of possible storage types
     * @param source restore definition
                }  
            && Objects.equals(snapshotUuid, that.snapshotUuid)
     * @return this request
            builder.field("source_remote_translog_repository", sourceRemoteTranslogRepository);
     * <p>
     *  
    }
            }
        return this;
    public String getDescription() {
    public RestoreSnapshotRequest storageType(StorageType storageType) {  
        private void toXContent(XContentBuilder builder) throws IOException {
     * rename pattern is applied according to the {@link java.util.regex.Matcher#appendReplacement(StringBuffer, String)}  
     */  
     *
        return renameAliasPattern;
    public RestoreSnapshotRequest indexSettings(Map<String, Object> source) {
                if (IndicesOptions.isIndicesOptions(name) == false) {
            && partial == that.partial
     * @return this request
    }
     * @param waitForCompletion if true the operation will wait for completion
    /**
     * @return the UUID that identifies the specific snapshot in the repository to be restored, or {@code null} if the snapshot name is
 *
        this.ignoreIndexSettings = ignoreIndexSettings;
            } catch (IllegalArgumentException e) {  
        out.writeBoolean(partial);
        return this;  
     * For example indices that don't exist.
     */  
            } else if (name.equals("source_remote_store_repository")) {  
    public RestoreSnapshotRequest ignoreIndexSettings(String... ignoreIndexSettings) {  
    /**
        this.snapshot = snapshot;  
            builder.field("rename_alias_pattern", renameAliasPattern);
import org.opensearch.common.xcontent.XContentType;
                aliasWriteIndexPolicy(AliasWriteIndexPolicy.fromString((String) entry.getValue()));
    public RestoreSnapshotRequest renameAliasReplacement(String renameAliasReplacement) {  
    private boolean waitForCompletion;
    }  
                    "specifying [settings] when restoring a snapshot has no effect and will not be supported in a future version"  
     * Sets rename replacement  
    /**
     */  
     */  
        partial = in.readBoolean();
                indexSettings((Map<String, Object>) entry.getValue());
    @Override
     * @return this request
    /**
     */
            && includeAliases == that.includeAliases
        }  
        result = 31 * result + Arrays.hashCode(ignoreIndexSettings);
public class RestoreSnapshotRequest extends ClusterManagerNodeRequest<RestoreSnapshotRequest> implements ToXContentObject {  
    /**
        return renamePattern;
        }  
    private String sourceRemoteStoreRepository = null;
        builder.endArray();  
        }  
     */
            } else if (name.equals("partial")) {
    }
     * @param sourceRemoteTranslogRepository name of the remote translog repository that should be used for all restored indices.
    /**  
 * Restore snapshot request
    public IndicesOptions indicesOptions() {
     * @param snapshot   snapshot name  
     * <p>
        }  
import static org.opensearch.common.settings.Settings.writeSettingsToStream;  
     * Sets the name of the snapshot.  
     *  
import org.opensearch.core.common.io.stream.StreamInput;  
    /**
     * @return this request  
        }
            indicesOptions.toXContent(builder, params);
            for (StorageType type : values()) {  
        RestoreSnapshotRequest that = (RestoreSnapshotRequest) o;
     * If two or more aliases are renamed into the same name, they will be merged.
     * Returns rename alias pattern  
        this.indices = indices.toArray(new String[0]);
        return attachToDataStream;
                indexSettings.toXContent(builder, params);
     */  
     * @param snapshot snapshot name
     * Sets the storage type for this request.
     * @param sourceRemoteStoreRepository name of the remote store repository that should be used for all restored indices.
            } else if (name.equals("ignore_index_settings")) {
    public RestoreSnapshotRequest ignoreIndexSettings(List<String> ignoreIndexSettings) {
 * specific language governing permissions and limitations
                }  
    public boolean includeGlobalState() {
            storageType,  
/**  
    public RestoreSnapshotRequest(String repository, String snapshot) {
            out.writeOptionalString(sourceRemoteStoreRepository);
        }
            sourceRemoteStoreRepository = in.readOptionalString();
        if (renameAliasReplacement != null) {
        this.renameAliasReplacement = renameAliasReplacement;
    /**
        }  
        builder.endObject();  
     * prefix "test" except index "test42". Aliases are not supported. An empty list or {"_all"} will restore all open
                    renameAliasPattern((String) entry.getValue());
     */  
     *  
        return this;
        return this;
import org.opensearch.core.common.Strings;
            } else if (name.equals("include_global_state")) {
            renameAliasPattern,
    @Override
     *
                if (entry.getValue() instanceof String) {
     * @param renameReplacement rename replacement
import java.util.Map;  
            storageType = in.readEnum(StorageType.class);
            } else if (name.equals("settings")) {  
/*  
import java.util.Arrays;  
    public String renameAliasPattern() {
     * @return alias write index policy
        return this;  
            builder.field("source_remote_store_repository", sourceRemoteStoreRepository);
    public RestoreSnapshotRequest renamePattern(String renamePattern) {  
                } else {  
     * @return this request
    }
     *
    /**  
 */  
     * prefix "test" except index "test42". Aliases are not supported. An empty list or {"_all"} will restore all open
    public enum StorageType {
        return this;  
            && Objects.equals(indicesOptions, that.indicesOptions)  
     * Returns the list of index settings and index settings groups that shouldn't be restored from snapshot
     * @return snapshot name
     */  
                );  
        indexSettings = readSettingsFromStream(in);
    /**
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
        this.indexSettings = settings.build();
        return this;
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions  
     * If set to true the restore procedure will restore aliases
    /**  
    public RestoreSnapshotRequest partial(boolean partial) {
 * GitHub history for details.
            && Objects.equals(sourceRemoteStoreRepository, that.sourceRemoteStoreRepository)  
     */
                } else {  
        result = 31 * result + Arrays.hashCode(indices);  
        }
     * Returns true if aliases should be restored from this snapshot  
        }
     * See {@link #renamePattern(String)} for more information.
     */
        if (repository == null) {  
            indicesOptions,
     * desired snapshot may be deleted and replaced by a new snapshot with the same name which is inconsistent with the original one. This
        if (indices == null) {  
    private String[] ignoreIndexSettings = Strings.EMPTY_ARRAY;
                } else if (entry.getValue() instanceof List) {
            } else if ("alias_write_index_policy".equals(name)) {  
     * @return rename alias replacement
    public RestoreSnapshotRequest snapshot(String snapshot) {
    /**
    /**
     * Gets the storage type for this request. {@link StorageType#LOCAL} is the  
            } else if (name.equals("index_settings")) {  
    }
    private boolean partial = false;
                    setSourceRemoteStoreRepository((String) entry.getValue());
    @PublicApi(since = "3.3.0")
     *
        return this;
     *
     *
        builder.startObject();
        ignoreIndexSettings = in.readStringArray();
