 * the Apache License, Version 2.0 (the "License"); you may
    }
/**
                    setSourceRemoteStoreRepository((String) entry.getValue());
     */
                } else if (entry.getValue() instanceof ArrayList) {
        this.repository = repository;
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
/*
     * @return rename alias replacement
     *
     * Sets the list of index settings and index settings groups that shouldn't be restored from snapshot
import java.util.ArrayList;
     */
        this.renameAliasReplacement = renameAliasReplacement;
            builder.field("rename_alias_replacement", renameAliasReplacement);
    public RestoreSnapshotRequest repository(String repository) {
     */
import java.nio.charset.StandardCharsets;
    private String renamePattern;
 * Modifications Copyright OpenSearch Contributors. See
        return this;
     */
    public RestoreSnapshotRequest ignoreIndexSettings(List<String> ignoreIndexSettings) {
    public IndicesOptions indicesOptions() {
    /**
            String name = entry.getKey();
     *
    private boolean waitForCompletion;
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
    /**
     * rename pattern is applied according to the {@link java.util.regex.Matcher#appendReplacement(StringBuffer, String)}
     * See {@link #renamePattern(String)} for more information.
    }
                    throw new IllegalArgumentException("Unknown parameter " + name);
     *
                } else {
     */
    @Override
     * <p>
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.
        }
        return renameReplacement;
        if (out.getVersion().onOrAfter(Version.V_3_3_0)) {
    }
     */
            && Objects.equals(renamePattern, that.renamePattern)
     * The request will fail if two or more indices will be renamed into the same name.
     */
        snapshotUuid = in.readOptionalString();
    }
        return includeAliases;
                    "rename_replacement string size exceeds max allowed size of %s bytes",
            && partial == that.partial
        out.writeStringArray(indices);
            out.writeBoolean(attachToDataStream);
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
    }
    public String renameAliasReplacement() {
        }
     * @return true if the operation will wait for completion
        return renameAliasReplacement;
        }
                }
     * <p>
     * @return rename pattern
            out.writeOptionalString(sourceRemoteTranslogRepository);
        return this.snapshot;
    public boolean attachToDataStream() {
            aliasWriteIndexPolicy = in.readEnum(AliasWriteIndexPolicy.class);
        ignoreIndexSettings = in.readStringArray();
        result = 31 * result + Arrays.hashCode(indices);
            && includeAliases == that.includeAliases
        }
        this.indexSettings = settings;
    }
                aliasWriteIndexPolicy(AliasWriteIndexPolicy.fromString((String) entry.getValue()));
                    "RestoreSnapshotRequest#settings",
        return this;
            }
     * Sets repository name
     * @return this request
     * @return snapshot name
                indexSettings.toXContent(builder, params);
        builder.field("attach_to_data_stream", attachToDataStream);
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
     * Set to true to allow indices with failed to snapshot shards should be partially restored.
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();
    @Override
                partial(nodeBooleanValue(entry.getValue(), "partial"));
     * @param indices list of indices
     * @return source Remote Translog Repository
        return partial;
     * @param renameReplacement rename replacement
    /**
        if (o == null || getClass() != o.getClass()) return false;
            && Objects.equals(repository, that.repository)
    /**
        result = Objects.hash(
    /**
    /**
     * @return source Remote Store Repository
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.
                if (entry.getValue() instanceof String) {
    }
            && Objects.equals(sourceRemoteStoreRepository, that.sourceRemoteStoreRepository)
        indices = in.readStringArray();
    }
    private Settings indexSettings = EMPTY_SETTINGS;
    /**
     * @return this request
            repository,
        if (indexSettings == null) {
                    throw new IllegalArgumentException("malformed rename_pattern");
                } else {
import org.opensearch.common.annotation.PublicApi;
    /**
            && Objects.equals(indicesOptions, that.indicesOptions)
     * Sets Source Remote Store Repository for all the restored indices
            renameAliasReplacement,
    public RestoreSnapshotRequest() {}
     * @param snapshot snapshot name
     */
        REMOTE_SNAPSHOT("remote_snapshot");
            && Objects.equals(snapshotUuid, that.snapshotUuid)
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        }
    /**
    public String[] indices() {
    /**
        }
        out.writeBoolean(includeGlobalState);
     * The global cluster state includes persistent settings and index template definitions.
        builder.endArray();
     * @param attachToDataStream whether to attach matching restored indices to their data stream
import org.opensearch.core.xcontent.XContentBuilder;
    }
    public boolean waitForCompletion() {
        if (in.getVersion().onOrAfter(Version.V_2_7_0)) {
    public String snapshotUuid() {
            } else if (name.equals("include_global_state")) {
        private static StorageType fromString(String string) {
    public RestoreSnapshotRequest indices(List<String> indices) {
                    throw new IllegalArgumentException("malformed storage_type");
     * @param sourceRemoteTranslogRepository name of the remote translog repository that should be used for all restored indices.
        includeAliases = in.readBoolean();
        this.storageType = storageType;
        indicesOptions = IndicesOptions.readIndicesOptions(in);
            } else if (name.equals("partial")) {
    }
     */
        int result;
     *
                    return type;
    public RestoreSnapshotRequest includeGlobalState(boolean includeGlobalState) {
    public Settings indexSettings() {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            out.writeOptionalString(sourceRemoteStoreRepository);
     *
        }
    }
    public RestoreSnapshotRequest indexSettings(Map<String, Object> source) {
    /**
     * Returns settings that should be added/changed in all restored indices
            } else if (name.equals("rename_alias_pattern")) {
     */
    }
        return this;
 */
    }
     * Sets rename alias replacement
        }
import org.opensearch.core.xcontent.ToXContentObject;
     */
                } else {
            && Objects.equals(snapshot, that.snapshot)
     * Sets settings that should be added/changed in all restored indices
     * Returns the list of index settings and index settings groups that shouldn't be restored from snapshot
        return snapshotUuid;
            storageType,
        return this;
        }
     * When {@code true}, a restored index whose name matches the data stream backing-index convention
    /**
     */
        this.indexSettings = settings.build();
        out.writeString(snapshot);
    }
     * @param renameAliasPattern rename pattern
    }
     * @return this request
    /**
        if (renameAliasReplacement != null) {
    public RestoreSnapshotRequest setSourceRemoteTranslogRepository(String sourceRemoteTranslogRepository) {
            storageType.toXContent(builder);
 * SPDX-License-Identifier: Apache-2.0
        if (Strings.isNullOrEmpty(renameReplacement) == false
        this.includeGlobalState = includeGlobalState;
        return waitForCompletion;
                } else {
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
        ActionRequestValidationException validationException = null;
    /**
    public String getDescription() {
     */
                attachToDataStream(nodeBooleanValue(entry.getValue(), "attach_to_data_stream"));
            } else if ("alias_write_index_policy".equals(name)) {
            } catch (IllegalArgumentException e) {
        this.renameAliasPattern = renameAliasPattern;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Sets settings that should be added/changed in all restored indices
     */
    public RestoreSnapshotRequest waitForCompletion(boolean waitForCompletion) {
    public String snapshot() {
            sourceRemoteTranslogRepository = in.readOptionalString();
     *
            }
            }
    private StorageType storageType = StorageType.LOCAL;
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
        if (sourceRemoteTranslogRepository != null) {
    /**
/*
        private void toXContent(XContentBuilder builder) throws IOException {
    /**
    /**
    @Nullable
    public RestoreSnapshotRequest renameAliasPattern(String renameAliasPattern) {
     * prefix "test" except index "test42". Aliases are not supported. An empty list or {"_all"} will restore all open
    /**
    public String renameAliasPattern() {
        return builder;
                    renameAliasPattern((String) entry.getValue());
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
     * ({@code .ds-<dataStream>-NNNNNN}) is attached to a pre-existing data stream of the same name as part of the
        }
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
    }
     */
    @PublicApi(since = "3.3.0")
                    throw new IllegalArgumentException("malformed index_settings section");
     *
        result = 31 * result + Arrays.hashCode(ignoreIndexSettings);
            validationException = addValidationError("indexSettings are missing", validationException);
    }
        return this;
        return includeGlobalState;
                    Locale.ROOT,
     * Parses restore definition
                    throw new IllegalArgumentException("malformed rename_replacement");
        if (renamePattern != null) {
    public RestoreSnapshotRequest renameAliasReplacement(String renameAliasReplacement) {
     *
            indicesOptions.toXContent(builder, params);
     * @return this request
            builder.field("rename_pattern", renamePattern);
     * implicit default if not overridden.
import org.opensearch.core.common.Strings;
        public static AliasWriteIndexPolicy fromString(String value) {
        boolean equals = waitForCompletion == that.waitForCompletion
     * Returns list of indices that should be restored from snapshot
     * Returns repository name
            } else if (name.equals("settings")) {
        }
        writeSettingsToStream(indexSettings, out);
            && Objects.equals(storageType, that.storageType)
    private String renameAliasPattern;
     * @param sourceRemoteStoreRepository name of the remote store repository that should be used for all restored indices.
            && Objects.equals(renameAliasPattern, that.renameAliasPattern)
        this.indices = indices;
        builder.field("partial", partial);
     * Sets rename replacement
        builder.field("alias_write_index_policy", aliasWriteIndexPolicy.name().toLowerCase(Locale.ROOT));
     * Returns rename pattern
     * If set to true the restore procedure will restore aliases
        waitForCompletion = in.readBoolean();
        indicesOptions(IndicesOptions.fromMap(source, indicesOptions));
        return this;
    /**
        this.waitForCompletion = waitForCompletion;
        }
 * ownership. Elasticsearch licenses this file to you under
        private final String text;
        if (ignoreIndexSettings == null) {
    public StorageType storageType() {
    }
    }
    /**
    }
                if (type.text.equals(string)) {
        PRESERVE,
        out.writeBoolean(includeAliases);
 * The OpenSearch Contributors require contributions made to
    public boolean includeAliases() {
                } else {
     *
        LOCAL("local"),
            } else if (name.equals("source_remote_translog_repository")) {
        partial = in.readBoolean();
        this.indexSettings = Settings.builder().loadFromMap(source).build();
            snapshot,
    }
     * Sets rename pattern that should be applied to restored indices' alias.
 * specific language governing permissions and limitations
     * rename pattern is applied according to the {@link java.util.regex.Matcher#appendReplacement(StringBuffer, String)}
                    throw new IllegalArgumentException("malformed source_remote_translog_repository");
        }
     */
     * @param indices list of indices
     * @param renamePattern rename pattern
     * method lets us fail the restore if the precise snapshot we want is not available.
        }
    public boolean equals(Object o) {
     * Sometimes a client has identified precisely which snapshot is to be restored via a separate mechanism and wishes to guarantee that
            builder.field("source_remote_translog_repository", sourceRemoteTranslogRepository);
    }
 *
                if (entry.getValue() instanceof String) {
     *
                ),
            builder.value(ignoreIndexSetting);
        }
        }
     *
     *
                    "specifying [settings] when restoring a snapshot has no effect and will not be supported in a future version"
import org.opensearch.core.common.io.stream.StreamInput;
        this.sourceRemoteStoreRepository = sourceRemoteStoreRepository;
    }
                }
            } else if (name.equals("rename_replacement")) {
    }
     * @return this request
    @Override
     * @param includeGlobalState true if global state should be restored from the snapshot
     */
     */
     * Alias that match the rename pattern will be renamed according to {@link #renameAliasReplacement(String)}. The
            sourceRemoteTranslogRepository,
                }
                    ignoreIndexSettings(Strings.splitStringByCommaToArray((String) entry.getValue()));
 *
    public boolean includeGlobalState() {
    }
                    throw new IllegalArgumentException("malformed rename_alias_replacement");
    }
        for (String ignoreIndexSetting : ignoreIndexSettings) {
    /**
     */
     */
        }
                    ignoreIndexSettings((List<String>) entry.getValue());
import org.opensearch.common.xcontent.XContentType;
    public String getSourceRemoteStoreRepository() {
     * @return true if global state should be restored
    public RestoreSnapshotRequest(StreamInput in) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {
    public RestoreSnapshotRequest aliasWriteIndexPolicy(AliasWriteIndexPolicy policy) {
     *
                    renameAliasReplacement((String) entry.getValue());
        }
        this.renamePattern = renamePattern;
 * Licensed to Elasticsearch under one or more contributor
    /**
        out.writeString(repository);
    @Nullable
        this.attachToDataStream = attachToDataStream;
        return sourceRemoteTranslogRepository;
    /**
     * @param source restore definition
            sourceRemoteStoreRepository,
 * KIND, either express or implied.  See the License for the
                } else {
        return this;
    private String sourceRemoteTranslogRepository = null;
     * prefix "test" except index "test42". Aliases are not supported. An empty list or {"_all"} will restore all open
     *
                if (entry.getValue() instanceof String) {
     *
     * Sets Source Remote Translog Repository for all the restored indices
                    throw new IllegalArgumentException("malformed rename_alias_pattern");
     *
            if (name.equals("indices")) {
            builder.field("rename_alias_pattern", renameAliasPattern);
     * For example indices that don't exist.
    /**
    }
                    MetadataCreateIndexService.MAX_INDEX_NAME_BYTES
    /**
                } else {
        }
            }
     * Returns rename replacement
     * this is the snapshot that this request restores. If the client can only identify a snapshot by its name then there is a risk that the
                }
     *
    }
     *
        }
        }
     * @param policy the policy to apply
     */
                    throw new IllegalArgumentException("malformed source_remote_store_repository");
     * @return this request
                DEPRECATION_LOGGER.deprecate(
                }
                }
    }
     *
     */
     * @return this request
    }
            out.writeOptionalString(renameAliasReplacement);
        out.writeBoolean(partial);
     * @return this request
     *
     * @return rename replacement
        return indices;
     * desired snapshot may be deleted and replaced by a new snapshot with the same name which is inconsistent with the original one. This
                    "Unknown alias_write_index_policy [" + value + "]. Valid values are: " + Arrays.toString(values())
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
            renamePattern,
    /**
     */
            validationException = addValidationError("indicesOptions is missing", validationException);
                if (!(entry.getValue() instanceof Map)) {
        return indicesOptions;
            builder.startObject("index_settings");
        this.ignoreIndexSettings = ignoreIndexSettings;
     *
            waitForCompletion,
            validationException = addValidationError("indices are missing", validationException);
    public RestoreSnapshotRequest indicesOptions(IndicesOptions indicesOptions) {
            attachToDataStream
        out.writeBoolean(waitForCompletion);
            validationException = addValidationError("repository is missing", validationException);
        @Override
     * Constructs a new put repository request with the provided repository and snapshot names.
    /**
    }
        return this;
     */
     * <p>
    public String repository() {
        return this.indexSettings;
    @Override
    @Override
        return storageType;
        if (indices == null) {
     * This is for internal use only and is not exposed in the REST layer.
            builder.field("storage_type", text);
    /**
        builder.field("include_aliases", includeAliases);
 *
    public String getSourceRemoteTranslogRepository() {
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
        return Strings.toString(MediaTypeRegistry.JSON, this);
        return this;
    }
            out.writeEnum(storageType);
            } else if (name.equals("storage_type")) {
    }
        return this;
 *
    }
            && Arrays.equals(ignoreIndexSettings, that.ignoreIndexSettings)
     * @return true if aliases should be restored
    /**
            builder.field("rename_replacement", renameReplacement);
                } else {
        super.writeTo(out);
     * Sets settings that should be added/changed in all restored indices
        }
    }
            } else if (name.equals("source_remote_store_repository")) {
    public RestoreSnapshotRequest source(Map<String, Object> source) {
        }
            validationException = addValidationError("name is missing", validationException);
                );
 * You may obtain a copy of the License at
        return this;
        return attachToDataStream;
                }
import org.opensearch.Version;
    public RestoreSnapshotRequest renamePattern(String renamePattern) {
     * @return rename alias pattern
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
    public RestoreSnapshotRequest indices(String... indices) {
    public ActionRequestValidationException validate() {
    /**
        this.indicesOptions = indicesOptions;
    /**
        for (String index : indices) {
    /**
    public RestoreSnapshotRequest snapshot(String snapshot) {
    private AliasWriteIndexPolicy aliasWriteIndexPolicy = AliasWriteIndexPolicy.PRESERVE;
            sourceRemoteStoreRepository = in.readOptionalString();
     */
                } else {
                    throw new IllegalArgumentException("malformed indices section, should be an array of strings");
    }
    }
     * indices in the snapshot.
import java.util.Map;
    public String[] ignoreIndexSettings() {
     *
    public String toString() {
    }
     *
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
     * <p>
    public RestoreSnapshotRequest(String repository, String snapshot) {
    }
     * Enumeration of possible storage types
 * Unless required by applicable law or agreed to in writing,
        renamePattern = in.readOptionalString();
            } else if (name.equals("attach_to_data_stream")) {
        snapshot = in.readString();
     * @param repository repository name
     */
        return validationException;
        return this;
        return this;
    /**
        }
    /**
     * @param renameAliasReplacement rename replacement
    }
     * <p>
    private String snapshot;
                }
                includeGlobalState = nodeBooleanValue(entry.getValue(), "include_global_state");
    private String sourceRemoteStoreRepository = null;
                    indices((ArrayList<String>) entry.getValue());
     * Sets rename pattern that should be applied to restored indices.
                } else if (entry.getValue() instanceof List) {
     * @return this request
    }
    private String renameReplacement;
            throw new IllegalArgumentException("Invalid storage_type: " + string);
import org.opensearch.action.support.IndicesOptions;
import static org.opensearch.action.ValidateActions.addValidationError;
    /**
import org.opensearch.common.Nullable;
        return this;
            aliasWriteIndexPolicy,
     * Sets the list of indices that should be restored from snapshot
    }
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions
        StorageType(String text) {
    private String snapshotUuid;
 */
                if (entry.getValue() instanceof String) {
        }
     *
                return valueOf(value.toUpperCase(Locale.ROOT));
        if (this == o) return true;
            renameAliasPattern = in.readOptionalString();
        renameReplacement = in.readOptionalString();
     * Returns wait for completion setting
    public String renamePattern() {
     */
        }
    public AliasWriteIndexPolicy aliasWriteIndexPolicy() {
        this.snapshotUuid = snapshotUuid;
     * Returns rename alias pattern
        }
    private String renameAliasReplacement;
            renameReplacement,
    private boolean attachToDataStream = false;
            renameAliasPattern,
     * @opensearch.api
            out.writeEnum(aliasWriteIndexPolicy);
            && includeGlobalState == that.includeGlobalState
    @Override
            includeAliases,
 */
     */
            && renameReplacement.getBytes(StandardCharsets.UTF_8).length > MetadataCreateIndexService.MAX_INDEX_NAME_BYTES) {
    public RestoreSnapshotRequest ignoreIndexSettings(String... ignoreIndexSettings) {
    }
    /**
     * <p>
     * @param snapshot   snapshot name
                if (entry.getValue() instanceof String) {
     * Returns the name of the snapshot.
     * Returns true if aliases should be restored from this snapshot
            } else {
     */
    public int hashCode() {
     * Returns true if indices with failed to snapshot shards should be partially restored.
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
        return renamePattern;
        return ignoreIndexSettings;
        }
    }
     * @return true if indices with failed to snapshot shards should be partially restored
            } else if (name.equals("ignore_index_settings")) {
 * under the License.
import org.opensearch.action.ActionRequestValidationException;
        builder.endArray();
     * @return the desired behaviour regarding indices to ignore and wildcard indices expression
        return result;
        return this;
    @Nullable
        return "snapshot [" + repository + ":" + snapshot + "]";
        super(in);
            validationException = addValidationError(
import org.opensearch.common.logging.DeprecationLogger;
                    setSourceRemoteTranslogRepository((String) entry.getValue());
    private boolean includeGlobalState = false;
        if (repository == null) {
     * @opensearch.api
        }
                if (entry.getValue() instanceof String) {
    }
        this.snapshot = snapshot;
                String.format(
     *
                }
            out.writeOptionalString(renameAliasPattern);
        builder.startArray("ignore_index_settings");
        if (in.getVersion().onOrAfter(Version.V_3_8_0)) {
        this.sourceRemoteTranslogRepository = sourceRemoteTranslogRepository;
     * a sufficient identifier.
        return this;
     *
        this.repository = repository;
     *
import java.util.Arrays;
        RestoreSnapshotRequest that = (RestoreSnapshotRequest) o;
     */
    }
    /**
 */
     */
     */
            } else if (name.equals("rename_pattern")) {
     * See {@link #renameAliasPattern(String)} for more information.
     */
        this.snapshot = snapshot;
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
        for (Map.Entry<String, Object> entry : source.entrySet()) {
        builder.endObject();
            partial,
            validationException = addValidationError("ignoreIndexSettings are missing", validationException);
        return this;
        return this;
package org.opensearch.action.admin.cluster.snapshots.restore;
    public RestoreSnapshotRequest partial(boolean partial) {
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(RestoreSnapshotRequest.class);
    @Nullable // if any snapshot UUID will do
    /**
     * @return this request
        this.indexSettings = Settings.builder().loadFromSource(source, xContentType).build();
        includeGlobalState = in.readBoolean();
     *
        STRIP_WRITE_INDEX;
        return this.repository;
            storageType = in.readEnum(StorageType.class);
     * Indices that match the rename pattern will be renamed according to {@link #renameReplacement(String)}. The
                }
import java.util.Objects;
        this.indices = indices.toArray(new String[0]);
        return this;
        return sourceRemoteStoreRepository;
     */
            && Objects.equals(renameReplacement, that.renameReplacement)
    }
        this.includeAliases = includeAliases;
     * @return this request
    public RestoreSnapshotRequest indexSettings(String source, XContentType xContentType) {
    public RestoreSnapshotRequest attachToDataStream(boolean attachToDataStream) {
     */
            } else if (name.equals("index_settings")) {
    public RestoreSnapshotRequest indexSettings(Settings.Builder settings) {
    }
        }
     * Sets alias write index policy for controlling how writeIndex attribute is handled during restore
}
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
                    throw new IllegalArgumentException("malformed ignore_index_settings section, should be an array of strings");
    }
            && Objects.equals(indexSettings, that.indexSettings)
     */
        return this;
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        if (sourceRemoteStoreRepository != null) {
                    indices(Strings.splitStringByCommaToArray((String) entry.getValue()));
        return this;
    public RestoreSnapshotRequest includeAliases(boolean includeAliases) {
    private boolean includeAliases = true;
    public RestoreSnapshotRequest setSourceRemoteStoreRepository(String sourceRemoteStoreRepository) {
    @SuppressWarnings("unchecked")
     */
        );
            );
    /**
                }
        if (indexSettings != null) {
            builder.endObject();
        builder.field("include_global_state", includeGlobalState);
            } else if (name.equals("include_aliases")) {
        if (in.getVersion().onOrAfter(Version.V_3_3_0)) {
    /**
    }
        out.writeOptionalString(renameReplacement);
            for (StorageType type : values()) {
        indexSettings = readSettingsFromStream(in);
        }
                if (!(entry.getValue() instanceof Map)) {
        }
     * @param includeAliases true if aliases should be restored from the snapshot
        if (indicesOptions == null) {
            && Arrays.equals(indices, that.indices)
                if (entry.getValue() instanceof String) {
        builder.startArray("indices");
    /**
                    storageType(StorageType.fromString((String) entry.getValue()));
        builder.startObject();
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
     * @return alias write index policy
     * Returns true if global state should be restored from this snapshot
        }
        }
     * For example indices that don't exist.
     * Sets settings that should be added/changed in all restored indices
            builder.value(index);
    public RestoreSnapshotRequest storageType(StorageType storageType) {
    public enum AliasWriteIndexPolicy {
        this.ignoreIndexSettings = ignoreIndexSettings.toArray(new String[0]);
    private String repository;
            attachToDataStream = in.readBoolean();
     */
     * If two or more aliases are renamed into the same name, they will be merged.
     * @return this request
            this.text = text;
            && Objects.equals(sourceRemoteTranslogRepository, that.sourceRemoteTranslogRepository)
@PublicApi(since = "1.0.0")
            && attachToDataStream == that.attachToDataStream;
                );
            builder.field("source_remote_store_repository", sourceRemoteStoreRepository);
        if (out.getVersion().onOrAfter(Version.V_3_8_0)) {
    /**
                if (IndicesOptions.isIndicesOptions(name) == false) {
        if (storageType != null) {
     * Sets the list of index settings and index settings groups that shouldn't be restored from snapshot
     * @return this request
     * <p>
        return this;
    public RestoreSnapshotRequest indexSettings(Settings settings) {
                throw new IllegalArgumentException(
     * Returns whether matching restored indices are attached to their data stream.
                    throw new IllegalArgumentException("malformed settings section");
     * Alias write index policy for controlling how writeIndex attribute is handled during restore
    /**
    private String[] indices = Strings.EMPTY_ARRAY;
        if (renameAliasPattern != null) {
    public String renameReplacement() {
     */
                }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
            renameAliasReplacement = in.readOptionalString();
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Sets the storage type for this request.
    @PublicApi(since = "1.0.0")
            && aliasWriteIndexPolicy == that.aliasWriteIndexPolicy
 * GitHub history for details.
        return this;
     * indices in the snapshot.
            includeGlobalState,
    public enum StorageType {
                if (entry.getValue() instanceof String) {
     * Sets the list of indices that should be restored from snapshot
     *
     *
            indexSettings,
     * restore. Defaults to {@code false}, in which case such an index is restored as a standalone index.
import java.util.List;
        return renameAliasPattern;
        }
            if (indexSettings.isEmpty() == false) {
     */
 * license agreements. See the NOTICE file distributed with
     */
     * <p>
            } else if (name.equals("rename_alias_replacement")) {
     * @return the UUID that identifies the specific snapshot in the repository to be restored, or {@code null} if the snapshot name is
        if (snapshot == null) {
/*
        if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
     * Returns alias write index policy
    /**
     */
public class RestoreSnapshotRequest extends ClusterManagerNodeRequest<RestoreSnapshotRequest> implements ToXContentObject {
        }
        }
     *
 * @opensearch.api
                validationException
                if (entry.getValue() instanceof String) {
     */
     *
    }
import java.util.Locale;
     *
            indicesOptions,
        return this;
    /**
                    renameReplacement((String) entry.getValue());
        if (indicesOptions != null) {
     * Returns Source Remote Store Repository for all the restored indices
    public RestoreSnapshotRequest snapshotUuid(String snapshotUuid) {
     * Returns rename alias replacement
     */
            && Objects.equals(renameAliasReplacement, that.renameAliasReplacement)
     * Gets the storage type for this request. {@link StorageType#LOCAL} is the
     * If set to true the restore procedure will restore global cluster state.
     * @param partial true if indices with failed to snapshot shards should be partially restored.
     * Returns Source Remote Translog Repository for all the restored indices
            snapshotUuid,
    public boolean partial() {
        this.aliasWriteIndexPolicy = Objects.requireNonNull(policy);
                includeAliases = nodeBooleanValue(entry.getValue(), "include_aliases");
        return this;
        public String toString() {
 * Restore snapshot request
                }
    public RestoreSnapshotRequest renameReplacement(String renameReplacement) {
 * not use this file except in compliance with the License.
        out.writeStringArray(ignoreIndexSettings);
            return text;
        out.writeOptionalString(renamePattern);
    }
        }
     */
        indicesOptions.writeIndicesOptions(out);
    private String[] ignoreIndexSettings = Strings.EMPTY_ARRAY;
     *
import org.opensearch.common.settings.Settings;
    @Override
    private boolean partial = false;
    /**
     *
        return equals;
    }
    }
     */
        this.renameReplacement = renameReplacement;
     * @param repository repository name
        return aliasWriteIndexPolicy;
        repository = in.readString();
            try {
    }
     * @return this request
                indexSettings((Map<String, Object>) entry.getValue());
     * @param waitForCompletion if true the operation will wait for completion
    /**
import java.io.IOException;
     * If this parameter is set to true the operation will wait for completion of restore process before returning.
     */
     * Sets the name of the snapshot.
        return this;
     * @return repository name
        out.writeOptionalString(snapshotUuid);
    /**
        if (renameReplacement != null) {
     */
                    renamePattern((String) entry.getValue());
        this.partial = partial;
