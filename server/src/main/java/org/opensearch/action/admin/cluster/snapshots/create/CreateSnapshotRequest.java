 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (name.equals("indices")) {
 * ownership. Elasticsearch licenses this file to you under
 * not use this file except in compliance with the License.
        return includeGlobalState;
            + ", clusterManagerNodeTimeout="
 *
            int size = BytesReference.bytes(builder).length();
            + repository
     * By default, the operation will return as soon as snapshot is initialized. It can be changed by setting this
        out.writeString(snapshot);
import static org.opensearch.action.ValidateActions.addValidationError;
        int result = Objects.hash(
        builder.field("snapshot", snapshot);
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
/*
    @Override
        return partial;
        snapshot = in.readString();
     * <p>
     * prefix "test" except index "test42". Aliases are supported. An empty list or {"_all"} will snapshot all open
    /**
            } else if (name.equals("partial")) {
            for (String index : indices) {
            + '\''
            && Arrays.equals(indices, that.indices)
            + indicesOptions
    }
 * Modifications Copyright OpenSearch Contributors. See
     * @return the desired behaviour regarding indices options
    }
     */
    public CreateSnapshotRequest includeGlobalState(boolean includeGlobalState) {
     * @param snapshot   snapshot name
                }
    }
     * @param includeGlobalState true if global state should be stored
        waitForCompletion = in.readBoolean();
            builder.map(source);
 * <li>must be lowercase</li>
        indicesOptions = IndicesOptions.readIndicesOptions(in);
     * Sets repository name
                if (entry.getValue() instanceof String) {
    public String[] indices() {
import org.opensearch.core.xcontent.XContentBuilder;
     */
     */
        return indicesOptions;
        return this;
        return partial == that.partial
 * <li>be a non-empty string</li>
     *
        return result;
import org.opensearch.OpenSearchGenerationException;
    public CreateSnapshotRequest userMetadata(Map<String, Object> userMetadata) {
    @SuppressWarnings("unchecked")
        builder.startArray("indices");
        settings = readSettingsFromStream(in);
        return this;
            + clusterManagerNodeTimeout
     * Set to true if global state should be stored as part of the snapshot
     */
        }
            + ", repository='"
     * @param snapshot snapshot name
 * SPDX-License-Identifier: Apache-2.0
    @Override
     *
    }
        return this;
    }
     *
        return validationException;
     * @return snapshot name
    /**
            + '\''
        this.settings = settings;
    @Override
     *
            repository,
            return 0;
        if (settings == null) {
 */
            validationException = addValidationError("indicesOptions is null", validationException);
     * @param settings repository-specific snapshot settings
     * The snapshot name
        return true;
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Arrays;
            validationException = addValidationError("snapshot is missing", validationException);
    public CreateSnapshotRequest(String repository, String snapshot) {
 */
 * Licensed to Elasticsearch under one or more contributor
    @Override
     * <p>
     * Constructs a new put repository request with the provided snapshot and repository names
    }
        if (indicesOptions == null) {
 * <p>
    }
        this.partial = partial;
    private String[] indices = EMPTY_ARRAY;
        this.settings = settings.build();
            + settings
import org.opensearch.OpenSearchException;
    @Override
    /**
        }
            + "snapshot='"
    private boolean waitForCompletion;
        } else {
import java.io.IOException;
    }
     * @return this request
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpenHidden();
     * @param indicesOptions the desired behaviour regarding indices options
    @Override
     * @param mediaType the content type of the source
            + ", indicesOptions="
        includeGlobalState = in.readBoolean();
            builder.endObject();
        return this;
            && Objects.equals(clusterManagerNodeTimeout, that.clusterManagerNodeTimeout)
     * <p>
    }
        }
    }
public class CreateSnapshotRequest extends ClusterManagerNodeRequest<CreateSnapshotRequest>
     * Sets repository-specific snapshot settings in JSON or YAML format
 * software distributed under the License is distributed on an
        return builder;
     * prefix "test" except index "test42". Aliases are supported. An empty list or {"_all"} will snapshot all open
     */
        this.repository = repository;
        builder.endArray();
    implements
     * @param settings repository-specific snapshot settings
            && waitForCompletion == that.waitForCompletion
import org.opensearch.action.ActionRequestValidationException;
            if (settings.isEmpty() == false) {
     * Returns repository-specific snapshot settings
        out.writeBoolean(includeGlobalState);
            + ", waitForCompletion="
    }
     */
        }
 * <li>must not contain invalid file name characters {@link Strings#INVALID_FILENAME_CHARS} </li>
        if (o == null || getClass() != o.getClass()) return false;
            String name = entry.getKey();
     *
        }
        return this;
        this.settings = Settings.builder().loadFromSource(source, mediaType).build();
                } else if (entry.getValue() instanceof List) {
     * Returns a list of indices that should be included into the snapshot
    }
 */
        this.snapshot = snapshot;
        } catch (IOException e) {
        return this;
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
        for (Map.Entry<String, Object> entry : source.entrySet()) {
     */
     * <p>
     */
 * this work for additional information regarding copyright
import static org.opensearch.core.common.Strings.EMPTY_ARRAY;
     */
     * Parses snapshot definition.
     * @return this request
    public String snapshot() {
        return this;
        this.includeGlobalState = includeGlobalState;
        ActionRequestValidationException validationException = null;
        return this;
        out.writeString(repository);
        writeSettingsToStream(settings, out);
                if (!(entry.getValue() instanceof Map)) {
    public CreateSnapshotRequest partial(boolean partial) {
    public String getDescription() {
import org.opensearch.core.common.io.stream.StreamInput;
                }
                } else {
    public Settings settings() {
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
package org.opensearch.action.admin.cluster.snapshots.create;
     * See repository documentation for more information.
        result = 31 * result + Arrays.hashCode(indices);
    }
        userMetadata = in.readMap();
 * <li>must not start with underscore ('_')</li>
     * See repository documentation for more information.
        if (repository == null) {
     *
@PublicApi(since = "1.0.0")
     * @return this request
/**
     * @return repository-specific snapshot settings
        indices = in.readStringArray();
                if (index == null) {
        repository = in.readString();
            + '}';
            snapshot,
    }
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
    public CreateSnapshotRequest waitForCompletion(boolean waitForCompletion) {
                }
     * @return this request
        return "snapshot [" + repository + ":" + snapshot + "]";
 * <li>must not contain hash sign ('#')</li>
        if (userMetadata == null) {
        builder.field("metadata", userMetadata);
     * @param waitForCompletion true if operation should wait for the snapshot completion
        return this;
            }
     * @param partial true if indices with unavailable shards should be be partially snapshotted.
 * You may obtain a copy of the License at
    public CreateSnapshotRequest indices(String... indices) {
            includeGlobalState,
     *
        return this;
    /**
     */
    }
    }
            + ", settings="
                    throw new IllegalArgumentException("malformed settings section, should indices an inner object");
     */
     */
import java.util.Map;
    public ActionRequestValidationException validate() {
    /**
 * the Apache License, Version 2.0 (the "License"); you may
}
    /**
     */
            + snapshot
import org.opensearch.core.common.Strings;
     *
/*
    }
 * The OpenSearch Contributors require contributions made to
     * See repository documentation for more information.
     *
import org.opensearch.core.xcontent.MediaType;
            && Objects.equals(settings, that.settings)
        return userMetadata;
        return this.settings;
    }
     * Specifies the indices options. Like what type of requested indices to ignore. For example indices that don't exist.
        }
            && includeGlobalState == that.includeGlobalState
            );
        this.waitForCompletion = waitForCompletion;
            }
        this.repository = repository;
            builder.value(index);
                partial(nodeBooleanValue(entry.getValue(), "partial"));
    @Override
    public CreateSnapshotRequest(StreamInput in) throws IOException {
            settings,
 * this file be licensed under the Apache-2.0 license or a
     * Returns true if indices with unavailable shards should be be partially snapshotted.
    public static int MAXIMUM_METADATA_BYTES = 1024; // chosen arbitrarily
                settings.toXContent(builder, params);
     * If set to true the operation should wait for the snapshot completion before returning.
            + includeGlobalState
        try {
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
     * Set to true to allow indices with unavailable shards to be partially snapshotted.
        if (indices == null) {
            validationException = addValidationError("indices is null", validationException);
     */
        }
    public String repository() {
 * Create snapshot request
     */
            && Objects.equals(snapshot, that.snapshot)
     * <p>
        this.userMetadata = userMetadata;
        CreateSnapshotRequest that = (CreateSnapshotRequest) o;
    /**
    /**
    /**
            builder.startObject("settings");
            + userMetadata
     * Returns repository name
    public CreateSnapshotRequest settings(Settings.Builder settings) {
     * <p>
     * @return true if global state should be stored as part of the snapshot
                    indices(Strings.splitStringByCommaToArray((String) entry.getValue()));
        builder.field("include_global_state", includeGlobalState);
     *
        return indices;
        return "CreateSnapshotRequest{"
    public CreateSnapshotRequest indicesOptions(IndicesOptions indicesOptions) {
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
     * @return this request
    }
        builder.field("partial", partial);
        ToXContentObject {
            } else if (name.equals("include_global_state")) {
        out.writeBoolean(waitForCompletion);
    /**
            settings(builder.toString(), builder.contentType());
            validationException = addValidationError(
        }
     *
    /**
    }
     *
     *
     * @return this request
/*
 * compatible open source license.
     * indices in the cluster.
            }
        out.writeStringArray(indices);
    }
            validationException = addValidationError("settings is null", validationException);
    public IndicesOptions indicesOptions() {
    @Override
        return this;
    public void writeTo(StreamOutput out) throws IOException {
        this.indices = indices;
    public CreateSnapshotRequest settings(Map<String, Object> source) {
     */
    /**
import org.opensearch.core.xcontent.MediaTypeRegistry;
            throw new OpenSearchException(e);
                    indices((List<String>) entry.getValue());
    public boolean waitForCompletion() {
    public boolean equals(Object o) {
        }
        builder.endObject();
     * @return this request
                userMetadata((Map<String, Object>) entry.getValue());
import java.util.Objects;
     */
            } else if (name.equals("settings")) {
     *
                validationException
            indicesOptions.toXContent(builder, params);
     */
     * Sets repository-specific snapshot settings.
        if (this == o) return true;
     *
            waitForCompletion,
import org.opensearch.common.xcontent.XContentFactory;
    @Override
                    validationException = addValidationError("index is null", validationException);
     */
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
    }
     * Returns true if the request should wait for the snapshot completion before returning
        }
        if (metadataSize > MAXIMUM_METADATA_BYTES) {
                }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
    private String repository;
    }
            + partial
 *
        return waitForCompletion;
            + waitForCompletion
            + ", partial="
     * <p>
 */
    }
     * @param source snapshot definition
                settings((Map<String, Object>) entry.getValue());
        this.snapshot = snapshot;
    }
    public boolean includeDataStreams() {
    /**
        return this.repository;
    public CreateSnapshotRequest repository(String repository) {
     */
    }
    @Override
            partial,
    public boolean includeGlobalState() {
     * Sets a list of indices that should be included into the snapshot
 * The only mandatory parameter is repository name. The repository name has to satisfy the following requirements
    public static int metadataSize(Map<String, Object> userMetadata) {
    /**
    public CreateSnapshotRequest settings(Settings settings) {
     *
 * @opensearch.api
     * @return the desired behaviour regarding indices options
     * @return this request
    public CreateSnapshotRequest snapshot(String snapshot) {
     * @return array of index names
            + (indices == null ? null : Arrays.asList(indices))
    }
    public CreateSnapshotRequest source(Map<String, Object> source) {
    /**
            userMetadata
import org.opensearch.core.common.io.stream.StreamOutput;
    public boolean partial() {
        }
     * Sets repository-specific snapshot settings.
 * under the License.
                if (entry.getValue() != null && (entry.getValue() instanceof Map == false)) {
     * @param source repository-specific snapshot settings
        );
     *
 * <ul>
     * Specifies the indices options. Like what type of requested indices to ignore. For example indices that don't exist.
    public CreateSnapshotRequest() {}
            && Objects.equals(repository, that.repository)
     *
            // This should not be possible as we are just rendering the xcontent in memory
        if (indicesOptions != null) {
     *
        indicesOptions(IndicesOptions.fromMap(source, indicesOptions));
        out.writeMap(userMetadata);
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
        indicesOptions.writeIndicesOptions(out);
import org.opensearch.common.settings.Settings;
     * @param repository name
    }
    private boolean includeGlobalState = true;
                "metadata must be smaller than 1024 bytes, but was [" + metadataSize + "]",
            + ", indices="
     * indices in the cluster.
        builder.startObject();
        out.writeBoolean(partial);
     * Returns true if global state should be stored as part of the snapshot
                includeGlobalState = nodeBooleanValue(entry.getValue(), "include_global_state");
     * Sets the snapshot name
                    throw new IllegalArgumentException("malformed indices section, should be an array of strings");
import org.opensearch.core.xcontent.ToXContentObject;
    }
    /**
            indicesOptions,
        if (snapshot == null) {
        return this.snapshot;
        super(in);
        } catch (IOException e) {
 * </ul>
 *
    /**
            validationException = addValidationError("repository is missing", validationException);
    /**
    public String toString() {
 * license agreements. See the NOTICE file distributed with
     *
        for (String index : indices) {
     * @return repository name
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public Map<String, Object> userMetadata() {
 * <li>must not contain comma (',')</li>
     * See repository documentation for more information.
     * @return this request
    /**
        if (settings != null) {
    public CreateSnapshotRequest settings(String source, MediaType mediaType) {
     * flag to true.
        super.writeTo(out);
     * Sets a list of indices that should be included into the snapshot
        }
 * GitHub history for details.
        IndicesRequest.Replaceable,
            + ", includeGlobalState="
     * @return true if the request should wait for completion
 *
import java.util.List;
    /**
 * KIND, either express or implied.  See the License for the
        this.indicesOptions = indicesOptions;
 * <li>must not contain whitespace (tabs or spaces)</li>
    @Override
            } else if (name.equals("metadata")) {
        final int metadataSize = metadataSize(userMetadata);
            builder.value(userMetadata);
        this.indices = indices.toArray(new String[0]);
     * @return this request
    }
            && Objects.equals(userMetadata, that.userMetadata);
    }
            + ", metadata="
     * @return this request
    }
     * @param source repository-specific snapshot settings
     */
     */
import org.opensearch.core.common.bytes.BytesReference;
     *
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    private Settings settings = EMPTY_SETTINGS;
     * Sets repository-specific snapshot settings.
    public CreateSnapshotRequest indices(List<String> indices) {
        }
import org.opensearch.action.IndicesRequest;
                    break;
    private String snapshot;
import org.opensearch.common.annotation.PublicApi;
     * @param repository repository name
    /**
        return this;
                    throw new IllegalArgumentException("malformed metadata, should be an object");
            && Objects.equals(indicesOptions, that.indicesOptions)
            return size;
    }
        return this;
    }
import org.opensearch.action.support.IndicesOptions;
        builder.field("repository", repository);
     *
        partial = in.readBoolean();
    private Map<String, Object> userMetadata;
    public int hashCode() {
 * Unless required by applicable law or agreed to in writing,
    /**
     * @return this request
    private boolean partial = false;
