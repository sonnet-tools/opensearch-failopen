        CreateSnapshotRequest that = (CreateSnapshotRequest) o;
 * <li>must not contain invalid file name characters {@link Strings#INVALID_FILENAME_CHARS} </li>
     * @return true if global state should be stored as part of the snapshot  
     */  
        return result;
            int size = BytesReference.bytes(builder).length();  
    @SuppressWarnings("unchecked")  
        if (userMetadata == null) {
        }
        return this;  
     * @return snapshot name  
        ActionRequestValidationException validationException = null;  
            snapshot,  
    }  
        for (Map.Entry<String, Object> entry : source.entrySet()) {
        return this.settings;
        return this;
            + ", repository='"
        partial = in.readBoolean();
        }
    private Map<String, Object> userMetadata;
            builder.value(index);  
    }
            + partial  
        this.snapshot = snapshot;
     * @return this request
        builder.field("metadata", userMetadata);  
            if (settings.isEmpty() == false) {  
            validationException = addValidationError("settings is null", validationException);  
     * @param includeGlobalState true if global state should be stored
 * this file be licensed under the Apache-2.0 license or a
                }
     * @param repository name  
        );
 * under the License.  
import java.util.Map;
import org.opensearch.core.xcontent.ToXContentObject;
    }  
            + ", clusterManagerNodeTimeout="
        return "snapshot [" + repository + ":" + snapshot + "]";
     */  
        snapshot = in.readString();  
     * <p>
 * You may obtain a copy of the License at  
     * @return this request
     * @return repository name
        }
public class CreateSnapshotRequest extends ClusterManagerNodeRequest<CreateSnapshotRequest>
    public CreateSnapshotRequest settings(Map<String, Object> source) {
     * Sets repository name
                settings.toXContent(builder, params);
     * @param settings repository-specific snapshot settings
        return this;
        if (indicesOptions == null) {
     * Sets a list of indices that should be included into the snapshot  
 *  
    }
 * SPDX-License-Identifier: Apache-2.0
        } else {  
    public boolean equals(Object o) {
                    throw new IllegalArgumentException("malformed settings section, should indices an inner object");
 * <li>must not contain comma (',')</li>  
            if (name.equals("indices")) {
    }
    }
                validationException  
     * See repository documentation for more information.  
        repository = in.readString();
     * flag to true.
     * <p>
            + clusterManagerNodeTimeout
    }  
     * See repository documentation for more information.  
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
     */
        this.indices = indices.toArray(new String[0]);  
    /**  
     * <p>  
            + '}';
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
 * not use this file except in compliance with the License.
 */
        }
     *
     * @param indicesOptions the desired behaviour regarding indices options  
            partial,  
    /**  
            + includeGlobalState
            + settings
        if (settings != null) {
        out.writeString(snapshot);
                    validationException = addValidationError("index is null", validationException);  
        return validationException;  
                    indices(Strings.splitStringByCommaToArray((String) entry.getValue()));  
    public CreateSnapshotRequest(StreamInput in) throws IOException {
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
                if (!(entry.getValue() instanceof Map)) {  
    }
        this.settings = settings.build();  
 * ownership. Elasticsearch licenses this file to you under  
            && Objects.equals(repository, that.repository)
        if (indicesOptions != null) {  
    public String snapshot() {
import org.opensearch.action.IndicesRequest;
     * By default, the operation will return as soon as snapshot is initialized. It can be changed by setting this  
        out.writeMap(userMetadata);
    }
 * this work for additional information regarding copyright
    @Override  
        try {  
        builder.startObject();
            + "snapshot='"
            && Arrays.equals(indices, that.indices)
            repository,
                }
        return this;
            && includeGlobalState == that.includeGlobalState
    }
        builder.field("include_global_state", includeGlobalState);
     *
            settings,
                if (entry.getValue() != null && (entry.getValue() instanceof Map == false)) {
import static org.opensearch.core.common.Strings.EMPTY_ARRAY;  
/*  
     * prefix "test" except index "test42". Aliases are supported. An empty list or {"_all"} will snapshot all open  
        this.indicesOptions = indicesOptions;
     * Parses snapshot definition.
import org.opensearch.OpenSearchGenerationException;
 *  
     * Sets the snapshot name  
    public CreateSnapshotRequest indices(List<String> indices) {
     * Specifies the indices options. Like what type of requested indices to ignore. For example indices that don't exist.  
 * software distributed under the License is distributed on an
    public boolean includeDataStreams() {  
 * <li>must be lowercase</li>  
        this.userMetadata = userMetadata;
     * @return this request
     *  
            // This should not be possible as we are just rendering the xcontent in memory  
    public CreateSnapshotRequest partial(boolean partial) {
    }  
    public ActionRequestValidationException validate() {
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
     * See repository documentation for more information.
     * Sets repository-specific snapshot settings.
     * @return this request
     * @return this request
        builder.endObject();
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
import java.util.List;  
                }
     */
import org.opensearch.core.common.io.stream.StreamOutput;
            } else if (name.equals("settings")) {
     * The snapshot name
     * Returns true if global state should be stored as part of the snapshot
 * </ul>
        }  
import org.opensearch.core.xcontent.MediaType;
    @Override
     * prefix "test" except index "test42". Aliases are supported. An empty list or {"_all"} will snapshot all open  
            + userMetadata
            + snapshot
            + ", partial="
    public CreateSnapshotRequest indices(String... indices) {  
        }  
            + ", indices="
     *  
package org.opensearch.action.admin.cluster.snapshots.create;
    }  
        }
     * @return this request
     */
        this.snapshot = snapshot;  
    /**  
    }  
    @Override
        this.repository = repository;
    public int hashCode() {
        if (metadataSize > MAXIMUM_METADATA_BYTES) {  
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return 0;
import org.opensearch.core.common.io.stream.StreamInput;  
/**
     */  
     *
     */
        int result = Objects.hash(
        indicesOptions = IndicesOptions.readIndicesOptions(in);  
        return partial == that.partial  
     *
        return this;  
            }  
    public CreateSnapshotRequest includeGlobalState(boolean includeGlobalState) {
 * <ul>  
@PublicApi(since = "1.0.0")  
     * <p>
 * compatible open source license.
            && Objects.equals(settings, that.settings)
            validationException = addValidationError("indicesOptions is null", validationException);  
     *  
        out.writeBoolean(waitForCompletion);
        includeGlobalState = in.readBoolean();
    public CreateSnapshotRequest repository(String repository) {  
    private boolean waitForCompletion;
import org.opensearch.common.settings.Settings;
     * @param source repository-specific snapshot settings
 * <li>must not start with underscore ('_')</li>
    public CreateSnapshotRequest userMetadata(Map<String, Object> userMetadata) {
            waitForCompletion,  
    }
            }
            + ", settings="
    /**
        this.waitForCompletion = waitForCompletion;
    public CreateSnapshotRequest settings(Settings.Builder settings) {
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpenHidden();  
import org.opensearch.common.xcontent.XContentFactory;  
    /**  
            userMetadata
     *  
    /**
        return partial;
 * The only mandatory parameter is repository name. The repository name has to satisfy the following requirements
     */
    @Override
                } else if (entry.getValue() instanceof List) {
        } catch (IOException e) {
    public String repository() {
            String name = entry.getKey();  
            builder.endObject();  
    /**
    public String toString() {
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
 * GitHub history for details.
    }
    public String[] indices() {
    @Override  
    public boolean partial() {  
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        final int metadataSize = metadataSize(userMetadata);
     * <p>
import java.io.IOException;
            builder.startObject("settings");
        return true;
        return this;  
            && waitForCompletion == that.waitForCompletion
     * @param snapshot snapshot name
    @Override
     * @param mediaType the content type of the source
            && Objects.equals(clusterManagerNodeTimeout, that.clusterManagerNodeTimeout)
    private boolean includeGlobalState = true;  
     *
            validationException = addValidationError("indices is null", validationException);
     * Returns repository name  
            + indicesOptions
     * indices in the cluster.
    public static int metadataSize(Map<String, Object> userMetadata) {  
        }  
        result = 31 * result + Arrays.hashCode(indices);  
     */
                    throw new IllegalArgumentException("malformed metadata, should be an object");
     */
        for (String index : indices) {
            } else if (name.equals("partial")) {  
     * See repository documentation for more information.
                includeGlobalState = nodeBooleanValue(entry.getValue(), "include_global_state");
     */
     *
     */  
    public String getDescription() {  
            return size;
import static org.opensearch.action.ValidateActions.addValidationError;
     * @return this request
        } catch (IOException e) {
     * @param source repository-specific snapshot settings  
     */  
     */
            } else if (name.equals("include_global_state")) {
    private boolean partial = false;
    public Map<String, Object> userMetadata() {  
            validationException = addValidationError("repository is missing", validationException);
                    throw new IllegalArgumentException("malformed indices section, should be an array of strings");
                userMetadata((Map<String, Object>) entry.getValue());
    /**
        ToXContentObject {
    /**
        return this;
    public CreateSnapshotRequest indicesOptions(IndicesOptions indicesOptions) {  
            + repository
     * @return the desired behaviour regarding indices options
     * Set to true to allow indices with unavailable shards to be partially snapshotted.
        }
                } else {  
    /**  
        this.includeGlobalState = includeGlobalState;
     */
import org.opensearch.common.annotation.PublicApi;
        out.writeString(repository);  
     * @param settings repository-specific snapshot settings
import java.util.Arrays;
    public CreateSnapshotRequest settings(String source, MediaType mediaType) {
    }  
     * @return true if the request should wait for completion
    }
        writeSettingsToStream(settings, out);  
        return this;
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
    }
            } else if (name.equals("metadata")) {  
     * @return this request
     *
        out.writeBoolean(includeGlobalState);
        builder.endArray();
 * The OpenSearch Contributors require contributions made to  
     * indices in the cluster.
        }
                }  
        settings = readSettingsFromStream(in);
        indicesOptions.writeIndicesOptions(out);
        return this.repository;
        return indicesOptions;  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param snapshot   snapshot name  
            builder.value(userMetadata);
    @Override
        this.indices = indices;
    /**
                partial(nodeBooleanValue(entry.getValue(), "partial"));
     * Sets a list of indices that should be included into the snapshot  
            + ", waitForCompletion="
     *
        IndicesRequest.Replaceable,  
        out.writeStringArray(indices);
        super(in);
            }
     * @param partial true if indices with unavailable shards should be be partially snapshotted.
 *
            settings(builder.toString(), builder.contentType());  
            + waitForCompletion  
        return builder;
/*
     * @param waitForCompletion true if operation should wait for the snapshot completion  
     */
     * <p>
    }  
        return indices;
/*  
            + (indices == null ? null : Arrays.asList(indices))
    /**
            && Objects.equals(indicesOptions, that.indicesOptions)  
     * Constructs a new put repository request with the provided snapshot and repository names  
     *
    public CreateSnapshotRequest snapshot(String snapshot) {
     * @param repository repository name
     * Returns true if the request should wait for the snapshot completion before returning  
            );
    implements
     *
     * If set to true the operation should wait for the snapshot completion before returning.
    }  
     *
     */
     * Sets repository-specific snapshot settings.  
        this.settings = settings;
    @Override
 * <li>must not contain hash sign ('#')</li>
import org.opensearch.core.common.Strings;
            indicesOptions.toXContent(builder, params);
            + '\''  
                    break;
        if (this == o) return true;  
        if (snapshot == null) {
        this.repository = repository;
     * @return this request  
 * Create snapshot request  
    /**
     * @return this request  
import org.opensearch.core.common.bytes.BytesReference;
    /**  
    public CreateSnapshotRequest(String repository, String snapshot) {
     *
 */  
     * Sets repository-specific snapshot settings.
                if (index == null) {
 */
        return userMetadata;
    public boolean waitForCompletion() {
            + ", indicesOptions="  
                settings((Map<String, Object>) entry.getValue());  
            indicesOptions,
            throw new OpenSearchException(e);
        return this;
    }  
     *
    /**
        indices = in.readStringArray();
        return this;
        if (repository == null) {
     *
 * the Apache License, Version 2.0 (the "License"); you may
     * @return the desired behaviour regarding indices options
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
        super.writeTo(out);
     * @return this request  
     * <p>
        indicesOptions(IndicesOptions.fromMap(source, indicesOptions));
 * Modifications Copyright OpenSearch Contributors. See
    public static int MAXIMUM_METADATA_BYTES = 1024; // chosen arbitrarily
                "metadata must be smaller than 1024 bytes, but was [" + metadataSize + "]",
        return this;  
        builder.field("repository", repository);
        return this;  
    public Settings settings() {  
            + '\''  
     * @param source snapshot definition  
     * Set to true if global state should be stored as part of the snapshot
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        return "CreateSnapshotRequest{"  
    }
    @Override
        this.settings = Settings.builder().loadFromSource(source, mediaType).build();
 * license agreements. See the NOTICE file distributed with
    }
 * Unless required by applicable law or agreed to in writing,
    private String[] indices = EMPTY_ARRAY;
     * @return this request  
     * Returns a list of indices that should be included into the snapshot
    public CreateSnapshotRequest() {}  
     * @return repository-specific snapshot settings
    }
            includeGlobalState,
    }
                if (entry.getValue() instanceof String) {
 */  
        return this;
     * Specifies the indices options. Like what type of requested indices to ignore. For example indices that don't exist.
import static org.opensearch.common.settings.Settings.readSettingsFromStream;  
 * <li>be a non-empty string</li>
    }
            validationException = addValidationError("snapshot is missing", validationException);
    /**
    /**
            && Objects.equals(snapshot, that.snapshot)  
        return waitForCompletion;
    public void writeTo(StreamOutput out) throws IOException {  
    /**  
        builder.field("snapshot", snapshot);  
        if (o == null || getClass() != o.getClass()) return false;
    private String repository;  
 * specific language governing permissions and limitations
            builder.map(source);
    @Override
        if (settings == null) {
     */  
        builder.field("partial", partial);  
     *
     */
            for (String index : indices) {
        }
        return this.snapshot;  
     *  
     * Sets repository-specific snapshot settings in JSON or YAML format
 *
        waitForCompletion = in.readBoolean();  
     * Returns repository-specific snapshot settings
}
    }
        builder.startArray("indices");
            + ", includeGlobalState="  
        }  
        if (indices == null) {
    }  
    /**
     * Returns true if indices with unavailable shards should be be partially snapshotted.
    }
            && Objects.equals(userMetadata, that.userMetadata);  
import org.opensearch.action.ActionRequestValidationException;  
        out.writeBoolean(partial);  
     */
    }
import java.util.Objects;
import org.opensearch.core.xcontent.XContentBuilder;
    private Settings settings = EMPTY_SETTINGS;
 * KIND, either express or implied.  See the License for the
     *
    /**
    /**
     */  
     */  
    private String snapshot;
        userMetadata = in.readMap();
    }  
    public CreateSnapshotRequest settings(Settings settings) {
    /**  
import org.opensearch.action.support.IndicesOptions;
    public boolean includeGlobalState() {
        this.partial = partial;
    public CreateSnapshotRequest source(Map<String, Object> source) {
            + ", metadata="  
    public CreateSnapshotRequest waitForCompletion(boolean waitForCompletion) {  
    }
        return this;  
 * <li>must not contain whitespace (tabs or spaces)</li>
    public IndicesOptions indicesOptions() {
        return includeGlobalState;  
import org.opensearch.OpenSearchException;
 * @opensearch.api
    }
 * <p>
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                    indices((List<String>) entry.getValue());
        }  
 * Licensed to Elasticsearch under one or more contributor  
     * @return array of index names
    @Override
            validationException = addValidationError(
    }
