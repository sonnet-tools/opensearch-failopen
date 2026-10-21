 * specific language governing permissions and limitations
    @Override
                contextMapBuilder.put(in.readString(), in.readOptionalWriteable(Context::new));
                        builder.field("mappings", indexMappings.sourceAsMap());
        settings = Collections.unmodifiableMap(settingsMapBuilder);
            this.mappings = mappings;
    public String getSetting(String index, String setting) {
 * You may obtain a copy of the License at
     * If the originating {@link GetIndexRequest} object was configured to include
        return Objects.hash(Arrays.hashCode(indices), aliases, mappings, settings, defaultSettings, dataStreams, contexts);
                    throw new IllegalStateException("Expected 0 or 1 mappings but got: " + numMappings);
     * defaults, this will contain a mapping of index name to {@link Settings} objects.
            out.writeOptionalString(indexEntry.getValue());
                    builder.startObject("aliases");
        return mappings();
public class GetIndexResponse extends ActionResponse implements ToXContentObject {
            Settings.writeSettingsToStream(indexEntry.getValue(), out);
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
        builder.startObject();
import java.util.Arrays;
    private final String[] indices;
                    String type = in.readString();
        final Map<String, Settings> defaultSettings,
 * compatible open source license.
            String key = in.readString();
     * effect as defaults.  Any settings explicitly set on the index will be available
                    List<AliasMetadata> indexAliases = aliases.get(index);
    ) {
                    mappingsMapBuilder.put(index, new MappingMetadata(in));
                    MappingMetadata indexMappings = mappings.get(index);
import org.opensearch.common.annotation.PublicApi;
                    builder.endObject();
    }
        }
 * ownership. Elasticsearch licenses this file to you under
        }
        if (dataStreams != null) {
@PublicApi(since = "1.0.0")
    public Map<String, MappingMetadata> mappings() {
        }
 * this work for additional information regarding copyright
import org.opensearch.cluster.metadata.MappingMetadata;
            if (out.getVersion().before(Version.V_2_0_0)) {
        defaultSettings = Collections.unmodifiableMap(defaultSettingsMapBuilder);
        final Map<String, Context> contexts
        }
        builder.endObject();
 * not use this file except in compliance with the License.
                Settings defaultIndexSettings = defaultSettings.get(index);
            if (indexSettings != null && indexSettings.hasValue(setting)) {
        return Arrays.equals(indices, that.indices)
                if (indexEntry.getValue() != MappingMetadata.EMPTY_MAPPINGS) {
    }
                    return null;
 *
     */
    }
        }
                {
import java.util.Map;
            && Objects.equals(settings, that.settings)
        return contexts;
            } else {
    @Override
        }
        final Map<String, List<AliasMetadata>> aliasesMapBuilder = new HashMap<>();
        // to have deterministic order
import org.opensearch.core.xcontent.ToXContentObject;
    }
        if (setting != null) {
            for (int i = 0; i < contextSize; i++) {
 * A response for a get index action.
            out.writeString(indexEntry.getKey());
    }
        return settings();
        for (final Map.Entry<String, Settings> indexEntry : settings.entrySet()) {
import org.opensearch.core.common.Strings;
        int settingsSize = in.readVInt();
import org.opensearch.cluster.metadata.AliasMetadata;
import java.util.HashMap;
        return defaultSettings;
        GetIndexResponse that = (GetIndexResponse) o;
    public Map<String, List<AliasMetadata>> getAliases() {
        return dataStreams;
            Settings.writeSettingsToStream(indexEntry.getValue(), out);
import org.opensearch.cluster.metadata.Context;
        out.writeVInt(mappings.size());
        return dataStreams();
                out.writeVInt(indexEntry.getValue() == MappingMetadata.EMPTY_MAPPINGS ? 0 : 1);
        out.writeVInt(aliases.size());
/*
            defaultSettingsMapBuilder.put(in.readString(), Settings.readSettingsFromStream(in));
        if (this == o) return true;
                    if (indexAliases != null) {
                    out.writeString(MapperService.SINGLE_MAPPING_NAME);
    }
            out.writeString(indexEntry.getKey());
import java.io.IOException;
        }
                if (defaultIndexSettings != null) {
                } else {
            settingsMapBuilder.put(key, Settings.readSettingsFromStream(in));
            && Objects.equals(dataStreams, that.dataStreams)
 *     http://www.apache.org/licenses/LICENSE-2.0
            && Objects.equals(contexts, that.contexts);
     * Returns the string value for the specified index and setting.  If the includeDefaults flag was not set or set to
        int mappingsSize = in.readVInt();
     * via {@link #settings()}.
                    }
        } else {
    @Override
 */
 * under the License.
    }
 * @opensearch.api
                aliasEntry.writeTo(out);
            out.writeString(indexEntry.getKey());
    }
            this.contexts = Collections.unmodifiableMap(contexts);
        }
     * on the index.  If the includeDefaults flag was set to true on the {@link GetIndexRequest}, this method will fall
            && Objects.equals(mappings, that.mappings)
            out.writeVInt(indexEntry.getValue().size());
    GetIndexResponse(StreamInput in) throws IOException {
        mappings = Collections.unmodifiableMap(mappingsMapBuilder);
                    }
    private Map<String, List<AliasMetadata>> aliases = Map.of();
        return Strings.toString(MediaTypeRegistry.JSON, this);
            this.defaultSettings = Collections.unmodifiableMap(defaultSettings);
                    Settings defaultIndexSettings = defaultSettings.get(index);
        Arrays.sort(indices);
 *
    /**
                out.writeOptionalWriteable(indexEntry.getValue());
        }
     * false on the {@link GetIndexRequest}, this method will only return a value where the setting was explicitly set
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (numMappings == 0) {
/*
                    if (context != null) {
            List<AliasMetadata> aliasEntryBuilder = new ArrayList<>(valueSize);
                mappingsMapBuilder.put(index, metadata != null ? metadata : MappingMetadata.EMPTY_MAPPINGS);
package org.opensearch.action.admin.indices.get;
        aliases = Collections.unmodifiableMap(aliasesMapBuilder);
 */
    }
            if (in.getVersion().before(Version.V_2_0_0)) {
        final Map<String, List<AliasMetadata>> aliases,
        for (final Map.Entry<String, String> indexEntry : dataStreams.entrySet()) {
        }
                out.writeString(indexEntry.getKey());
 */
            }
                        defaultIndexSettings.toXContent(builder, params);
    }
    public Map<String, Settings> getSettings() {
            int contextSize = in.readVInt();
            for (AliasMetadata aliasEntry : indexEntry.getValue()) {
            this.settings = Collections.unmodifiableMap(settings);
            int valueSize = in.readVInt();
    private Map<String, String> dataStreams = Map.of();
    public String[] getIndices() {
                    builder.endObject();
import org.opensearch.core.action.ActionResponse;
                } else {
    /**
            }
    public Map<String, Context> contexts() {
        this.indices = in.readStringArray();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    if (indexMappings == null) {
        }
    public Map<String, List<AliasMetadata>> aliases() {
import org.opensearch.core.common.io.stream.StreamOutput;
        int defaultSettingsSize = in.readVInt();
                        builder.startObject("mappings").endObject();
        for (int i = 0; i < dataStreamsSize; i++) {
     * See also {@link GetIndexRequest#includeDefaults(boolean)}
        final Map<String, String> dataStreamsMapBuilder = new HashMap<>();
                return indexSettings.get(setting);
 * GitHub history for details.
                builder.endObject();
                aliasEntryBuilder.add(new AliasMetadata(in));
/**
import org.opensearch.Version;
        return builder;
            }
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        super(in);
        for (final Map.Entry<String, MappingMetadata> indexEntry : mappings.entrySet()) {
            } else {
                    String dataStream = dataStreams.get(index);
 * this file be licensed under the Apache-2.0 license or a
 */
        {
            && Objects.equals(aliases, that.aliases)
                        builder.field("context", context);
            }
        Map<String, MappingMetadata> mappingsMapBuilder = new HashMap<>();
    public GetIndexResponse(
                final MappingMetadata metadata = in.readOptionalWriteable(MappingMetadata::new);
    private Map<String, MappingMetadata> mappings = Map.of();
     * The returned {@link Settings} objects will contain only those settings taking
                    Context context = contexts.get(index);
                    indexEntry.getValue().writeTo(out);
                        builder.field("data_stream", dataStream);
                    return defaultIndexSettings.get(setting);
    }
    }
                builder.startObject(index);
 * The OpenSearch Contributors require contributions made to
        out.writeVInt(dataStreams.size());
            for (int j = 0; j < valueSize; j++) {
                    }
    public Map<String, String> dataStreams() {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }
    public void writeTo(StreamOutput out) throws IOException {
import java.util.ArrayList;
        out.writeVInt(defaultSettings.size());
    public int hashCode() {
                    builder.startObject("settings");
    public String toString() {
        }
            for (final Map.Entry<String, Context> indexEntry : contexts.entrySet()) {
    }
     */
        }
import org.opensearch.core.xcontent.XContentBuilder;
        return mappings;
    public Map<String, Settings> defaultSettings() {
        if (defaultSettings != null) {
        if (mappings != null) {
                        builder.endObject();
                        for (final AliasMetadata alias : indexAliases) {
                            AliasMetadata.Builder.toXContent(alias, builder, params);
                    }
 * Modifications Copyright OpenSearch Contributors. See
 *
                int numMappings = in.readVInt();
        return aliases;
        out.writeVInt(settings.size());
        for (int i = 0; i < defaultSettingsSize; i++) {
    }
            String index = in.readString();
        }
    }
        }
            return null;
                    if (defaultIndexSettings != null && defaultIndexSettings.isEmpty() == false) {
    @Override
                    } else {
        for (int i = 0; i < aliasesSize; i++) {
        final Map<String, Settings> defaultSettingsMapBuilder = new HashMap<>();
import org.opensearch.index.mapper.MapperService;
/*
        dataStreams = Collections.unmodifiableMap(dataStreamsMapBuilder);
        for (final Map.Entry<String, Settings> indexEntry : defaultSettings.entrySet()) {
    }
            contexts = Collections.unmodifiableMap(contextMapBuilder);
        }
                    if (dataStream != null) {
    }
    private Map<String, Context> contexts = Map.of();
                }
import java.util.List;
            aliasesMapBuilder.put(key, Collections.unmodifiableList(aliasEntryBuilder));
                    if (indexSettings != null) {
                    if (MapperService.SINGLE_MAPPING_NAME.equals(type) == false) {
                    mappingsMapBuilder.put(index, MappingMetadata.EMPTY_MAPPINGS);
        Settings indexSettings = settings.get(index);
        String[] indices,
                        throw new IllegalStateException("Expected " + MapperService.SINGLE_MAPPING_NAME + " but got [" + type + "]");
        int aliasesSize = in.readVInt();
        for (int i = 0; i < mappingsSize; i++) {
        if (settings != null) {
                    }
        this.indices = indices;
    public String[] indices() {
    public Map<String, Settings> settings() {
            }
import java.util.Collections;
            out.writeString(indexEntry.getKey());
        if (contexts != null) {
                } else if (numMappings == 1) {
        if (aliases != null) {
                out.writeOptionalWriteable(indexEntry.getValue());
        }
                }
    @Override
        final Map<String, Settings> settingsMapBuilder = new HashMap<>();
                }
            }
        return settings;
import org.opensearch.common.settings.Settings;
        return aliases();
            && Objects.equals(defaultSettings, that.defaultSettings)
import org.opensearch.core.common.io.stream.StreamInput;
                        builder.startObject("defaults");
        final Map<String, String> dataStreams,
            out.writeVInt(contexts.size());
        }
                        indexSettings.toXContent(builder, params);
                }
    public boolean equals(Object o) {
        }
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
    private Map<String, Settings> defaultSettings = Map.of();
     * back to return the default value if the setting was not explicitly set.
 * license agreements. See the NOTICE file distributed with
    }
        if (o == null || getClass() != o.getClass()) return false;
 * KIND, either express or implied.  See the License for the
 *
    }
                    Settings indexSettings = settings.get(index);
 * SPDX-License-Identifier: Apache-2.0
        for (final Map.Entry<String, List<AliasMetadata>> indexEntry : aliases.entrySet()) {
    private Map<String, Settings> settings = Map.of();
            } else {
    public Map<String, MappingMetadata> getMappings() {
            String key = in.readString();
        return indices;
            }
                        }
    public Map<String, String> getDataStreams() {
            out.writeString(indexEntry.getKey());
        return indices();
                    }
            this.aliases = Collections.unmodifiableMap(aliases);
        int dataStreamsSize = in.readVInt();
        Map<String, MappingMetadata> mappings,
}
            for (final String index : indices) {
        final Map<String, Settings> settings,
import java.util.Objects;
        out.writeStringArray(indices);
                    }
 * Licensed to Elasticsearch under one or more contributor
            dataStreamsMapBuilder.put(in.readString(), in.readOptionalString());
    }
            this.dataStreams = Collections.unmodifiableMap(dataStreams);
        for (int i = 0; i < settingsSize; i++) {
            final Map<String, Context> contextMapBuilder = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
