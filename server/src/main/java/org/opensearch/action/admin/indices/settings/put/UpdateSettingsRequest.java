        this.indicesOptions = indicesOptions;
    }
 * KIND, either express or implied.  See the License for the
        }
        preserveExisting = in.readBoolean();
    }
    @Override
    public int hashCode() {
        UpdateSettingsRequest that = (UpdateSettingsRequest) o;
        indices = in.readStringArray();
    /**
     */
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
        indicesOptions = IndicesOptions.readIndicesOptions(in);
import java.util.Arrays;
import org.opensearch.common.settings.Settings;
        return clusterManagerNodeTimeout.equals(that.clusterManagerNodeTimeout)
    /**
    /**
import org.opensearch.action.IndicesRequest;
            && Objects.equals(indicesOptions, that.indicesOptions)
 * license agreements. See the NOTICE file distributed with
        this.indices = indices;
     * Sets the settings to be updated
    public UpdateSettingsRequest indices(String... indices) {
        return this;
import org.opensearch.core.xcontent.ToXContentObject;
        super.writeTo(out);
            && Arrays.equals(indices, that.indices);
     */
    @Override
    @Override
     * unchanged.
        Object innerBodySettings = bodySettings.get("settings");
     */
        this.indices = indices;
 * SPDX-License-Identifier: Apache-2.0
     * Sets the settings to be updated (either json or yaml format)
        if (o == null || getClass() != o.getClass()) {
    public IndicesOptions indicesOptions() {
    public UpdateSettingsRequest settings(String source, MediaType mediaType) {
    public UpdateSettingsRequest setPreserveExisting(boolean preserveExisting) {
        super(in);
    }
     * Constructs a new request to update settings for one or more indices
    private String[] indices;
    }
    public UpdateSettingsRequest(StreamInput in) throws IOException {
        return Objects.hash(clusterManagerNodeTimeout, timeout, settings, indicesOptions, preserveExisting, Arrays.hashCode(indices));
            && Objects.equals(preserveExisting, that.preserveExisting)
    implements
     * Iff set to <code>true</code> this settings update will only add settings not already set on an index. Existing settings remain
 * not use this file except in compliance with the License.
}
 * Request for an update index settings action
    @Override
@PublicApi(since = "1.0.0")
import static org.opensearch.action.ValidateActions.addValidationError;
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
     */
        return indicesOptions;
        }
 * You may obtain a copy of the License at
        return builder;
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.io.stream.StreamInput;
        out.writeStringArrayNullable(indices);
        ActionRequestValidationException validationException = null;
    }
 * specific language governing permissions and limitations
        settings = readSettingsFromStream(in);
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * software distributed under the License is distributed on an
            && Objects.equals(settings, that.settings)
import java.util.Objects;
    }
 */
    }
        return validationException;
import org.opensearch.core.common.Strings;
        return this;
    }
    }
 */
            return false;
     * Sets the settings to be updated (either json or yaml format)
     * Sets the settings to be updated
import org.opensearch.core.xcontent.MediaType;
            Map<String, Object> innerBodySettingsMap = (Map<String, Object>) innerBodySettings;
    public UpdateSettingsRequest(Settings settings, String... indices) {
    /**
    /**
    public boolean includeDataStreams() {
 *
        this.settings = Settings.builder().loadFromSource(source, mediaType).build();
 * GitHub history for details.
        if (settings.isEmpty()) {
    @Override
    public UpdateSettingsRequest settings(Map<String, ?> source) {
    private Settings settings = EMPTY_SETTINGS;
 * @opensearch.api
        builder.endObject();
    @Override
    public String[] indices() {
import org.opensearch.action.support.IndicesOptions;
 *
        Map<String, Object> bodySettings = parser.map();
     * Sets the indices to apply to settings update to
    public String toString() {
    public boolean isPreserveExisting() {
 * compatible open source license.
            validationException = addValidationError("no settings to update", validationException);
        this.settings = settings;
 */
     */
/**
     */
    @Override
        return preserveExisting;
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Constructs a new request to update settings for one or more indices
        builder.startObject();
            return true;
    /**
import org.opensearch.core.xcontent.XContentParser;
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
    public ActionRequestValidationException validate() {
    }
        return this;
import java.util.Map;
    private boolean preserveExisting = false;
    }
    public UpdateSettingsRequest(String... indices) {
 * The OpenSearch Contributors require contributions made to
            && timeout.equals(that.timeout)
 *
    }
package org.opensearch.action.admin.indices.settings.put;
        }
        this.indices = indices;
    @Override
        ToXContentObject {
        return true;
    }
        this.settings = settings.build();
import org.opensearch.action.ActionRequestValidationException;
        this.settings = Settings.builder().loadFromMap(source).build();
 * Modifications Copyright OpenSearch Contributors. See
/*
    private IndicesOptions indicesOptions = IndicesOptions.fromOptions(false, false, true, true);
     */
/*
    @Override
 * this work for additional information regarding copyright
    public UpdateSettingsRequest fromXContent(XContentParser parser) throws IOException {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.xcontent.XContentBuilder;
    public Settings settings() {
    @Override
        settings.toXContent(builder, params);
import java.io.IOException;
    }
     * Returns <code>true</code> iff the settings update should only add but not update settings. If the setting already exists
    public UpdateSettingsRequest indicesOptions(IndicesOptions indicesOptions) {
public class UpdateSettingsRequest extends AcknowledgedRequest<UpdateSettingsRequest>
        return this;
     */
        return settings;
 * this file be licensed under the Apache-2.0 license or a
        return this;
/*
 *
        return "indices : " + Arrays.toString(indices) + "," + Strings.toString(MediaTypeRegistry.JSON, this);
        IndicesRequest.Replaceable,
    }
    }
        indicesOptions.writeIndicesOptions(out);
import java.util.HashMap;
        return this;
    }
        Map<String, Object> settings = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor
    }
        }
            settings.putAll(innerBodySettingsMap);
        this.settings = settings;
        writeSettingsToStream(settings, out);
     * it should not be overwritten by this update. The default is <code>false</code>
     */
            settings.putAll(bodySettings);
    public UpdateSettingsRequest settings(Settings settings) {
        if (innerBodySettings instanceof Map) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (this == o) {
    }
    public boolean equals(Object o) {
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
        // clean up in case the body is wrapped with "settings" : { ... }
 */
    /**
    /**
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
        } else {
 * under the License.
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
        this.preserveExisting = preserveExisting;
            @SuppressWarnings("unchecked")
        return this;
    public UpdateSettingsRequest() {}
        out.writeBoolean(preserveExisting);
    public UpdateSettingsRequest settings(Settings.Builder settings) {
    public void writeTo(StreamOutput out) throws IOException {
 * Unless required by applicable law or agreed to in writing,
        return this.settings(settings);
        return indices;
