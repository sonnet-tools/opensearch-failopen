            && Objects.equals(dataStreams, that.dataStreams)
                out.writeString(indexEntry.getKey());
            List<AliasMetadata> aliasEntryBuilder = new ArrayList<>(valueSize);
    }
    public Map<String, List<AliasMetadata>> aliases() {  
 * You may obtain a copy of the License at  
    }
    public Map<String, Context> contexts() {  
            && Objects.equals(mappings, that.mappings)
    }  
    public void writeTo(StreamOutput out) throws IOException {
        return defaultSettings;
    ) {
        out.writeVInt(mappings.size());
        if (settings != null) {
import org.opensearch.common.annotation.PublicApi;
    }  
            && Objects.equals(defaultSettings, that.defaultSettings)
                        builder.endObject();  
 * license agreements. See the NOTICE file distributed with
                        throw new IllegalStateException("Expected " + MapperService.SINGLE_MAPPING_NAME + " but got [" + type + "]");
        final Map<String, List<AliasMetadata>> aliasesMapBuilder = new HashMap<>();  
                        }
            && Objects.equals(contexts, that.contexts);  
        }
        Map<String, MappingMetadata> mappings,
        }  
                    MappingMetadata indexMappings = mappings.get(index);  
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < defaultSettingsSize; i++) {
        builder.startObject();
            }  
 * software distributed under the License is distributed on an
                out.writeOptionalWriteable(indexEntry.getValue());
        for (final Map.Entry<String, Settings> indexEntry : settings.entrySet()) {
        int defaultSettingsSize = in.readVInt();  
                    out.writeString(MapperService.SINGLE_MAPPING_NAME);
    public Map<String, MappingMetadata> mappings() {
            dataStreamsMapBuilder.put(in.readString(), in.readOptionalString());  
            out.writeVInt(indexEntry.getValue().size());
            this.settings = Collections.unmodifiableMap(settings);  
    private Map<String, Settings> settings = Map.of();
    }
                    List<AliasMetadata> indexAliases = aliases.get(index);
    public Map<String, String> getDataStreams() {
            out.writeString(indexEntry.getKey());
    public Map<String, Settings> settings() {
                contextMapBuilder.put(in.readString(), in.readOptionalWriteable(Context::new));
        return indices;  
                    indexEntry.getValue().writeTo(out);
    @Override
        } else {
}
 * Unless required by applicable law or agreed to in writing,
        GetIndexResponse that = (GetIndexResponse) o;
                        defaultIndexSettings.toXContent(builder, params);
 * compatible open source license.
import java.util.Collections;
import org.opensearch.index.mapper.MapperService;
        Settings indexSettings = settings.get(index);
import org.opensearch.Version;
            if (indexSettings != null && indexSettings.hasValue(setting)) {
            String index = in.readString();
        this.indices = in.readStringArray();  
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
            }
     * false on the {@link GetIndexRequest}, this method will only return a value where the setting was explicitly set  
/*  
            for (int j = 0; j < valueSize; j++) {
            int contextSize = in.readVInt();  
                        for (final AliasMetadata alias : indexAliases) {  
                        builder.field("data_stream", dataStream);
     */  
        return mappings;
 * Modifications Copyright OpenSearch Contributors. See
        return Objects.hash(Arrays.hashCode(indices), aliases, mappings, settings, defaultSettings, dataStreams, contexts);
            final Map<String, Context> contextMapBuilder = new HashMap<>();
        return Strings.toString(MediaTypeRegistry.JSON, this);
            } else {  
        return dataStreams;
        }  
        int settingsSize = in.readVInt();  
 * Licensed to Elasticsearch under one or more contributor  
                out.writeOptionalWriteable(indexEntry.getValue());  
                    Context context = contexts.get(index);
            }
     * See also {@link GetIndexRequest#includeDefaults(boolean)}
                    throw new IllegalStateException("Expected 0 or 1 mappings but got: " + numMappings);
 */  
            this.dataStreams = Collections.unmodifiableMap(dataStreams);  
     * on the index.  If the includeDefaults flag was set to true on the {@link GetIndexRequest}, this method will fall
            && Objects.equals(aliases, that.aliases)
     * via {@link #settings()}.
import java.util.Arrays;  
     * The returned {@link Settings} objects will contain only those settings taking
            out.writeString(indexEntry.getKey());  
                    mappingsMapBuilder.put(index, MappingMetadata.EMPTY_MAPPINGS);  
 * ownership. Elasticsearch licenses this file to you under  
        }
    public Map<String, Settings> getSettings() {
        }
        }
    }
        return aliases;
 * @opensearch.api
            aliasesMapBuilder.put(key, Collections.unmodifiableList(aliasEntryBuilder));
            out.writeVInt(contexts.size());  
    }
                    if (dataStream != null) {
            defaultSettingsMapBuilder.put(in.readString(), Settings.readSettingsFromStream(in));
            return null;  
        for (final Map.Entry<String, String> indexEntry : dataStreams.entrySet()) {  
                    if (context != null) {  
                    Settings defaultIndexSettings = defaultSettings.get(index);
                } else {
    private Map<String, MappingMetadata> mappings = Map.of();  
        if (contexts != null) {
                    }
 *  
    @Override
                if (indexEntry.getValue() != MappingMetadata.EMPTY_MAPPINGS) {  
 * KIND, either express or implied.  See the License for the
        aliases = Collections.unmodifiableMap(aliasesMapBuilder);
        }
                    if (MapperService.SINGLE_MAPPING_NAME.equals(type) == false) {  
        return indices();
    public Map<String, Settings> defaultSettings() {
            }
            if (in.getVersion().before(Version.V_2_0_0)) {  
    public String getSetting(String index, String setting) {
        if (defaultSettings != null) {
            settingsMapBuilder.put(key, Settings.readSettingsFromStream(in));
    private Map<String, List<AliasMetadata>> aliases = Map.of();
    public int hashCode() {
    private Map<String, Settings> defaultSettings = Map.of();  
import org.opensearch.cluster.metadata.MappingMetadata;
    GetIndexResponse(StreamInput in) throws IOException {
/**
        for (final Map.Entry<String, MappingMetadata> indexEntry : mappings.entrySet()) {
     * effect as defaults.  Any settings explicitly set on the index will be available  
                    builder.endObject();  
        {
                            AliasMetadata.Builder.toXContent(alias, builder, params);
                return indexSettings.get(setting);
                        builder.startObject("mappings").endObject();
            int valueSize = in.readVInt();  
        final Map<String, List<AliasMetadata>> aliases,
            Settings.writeSettingsToStream(indexEntry.getValue(), out);  
            }
        }
        defaultSettings = Collections.unmodifiableMap(defaultSettingsMapBuilder);
import org.opensearch.core.common.io.stream.StreamInput;  
                    }
                aliasEntryBuilder.add(new AliasMetadata(in));  
        }
        }
                    builder.startObject("aliases");  
 * specific language governing permissions and limitations
                out.writeVInt(indexEntry.getValue() == MappingMetadata.EMPTY_MAPPINGS ? 0 : 1);
                }  
    public boolean equals(Object o) {
import org.opensearch.cluster.metadata.AliasMetadata;
            out.writeString(indexEntry.getKey());  
            this.aliases = Collections.unmodifiableMap(aliases);  
        out.writeVInt(defaultSettings.size());  
        out.writeStringArray(indices);  
    }
        final Map<String, Settings> settingsMapBuilder = new HashMap<>();
                } else {
 *
 *
    }  
                aliasEntry.writeTo(out);
                    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
     * defaults, this will contain a mapping of index name to {@link Settings} objects.
                    return defaultIndexSettings.get(setting);  
    private final String[] indices;  
        return contexts;
            for (final Map.Entry<String, Context> indexEntry : contexts.entrySet()) {
        dataStreams = Collections.unmodifiableMap(dataStreamsMapBuilder);
        }
     */  
            } else {
        for (final Map.Entry<String, Settings> indexEntry : defaultSettings.entrySet()) {
 * under the License.  
        out.writeVInt(settings.size());
        for (int i = 0; i < settingsSize; i++) {
        final Map<String, String> dataStreams,
                {
                final MappingMetadata metadata = in.readOptionalWriteable(MappingMetadata::new);
            out.writeString(indexEntry.getKey());
                    if (indexMappings == null) {
import org.opensearch.common.settings.Settings;  
        super(in);
            String key = in.readString();  
    @Override
        return dataStreams();
            for (final String index : indices) {  
                        indexSettings.toXContent(builder, params);
        for (int i = 0; i < dataStreamsSize; i++) {
        }
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
    /**
    }  
        for (int i = 0; i < mappingsSize; i++) {
    private Map<String, String> dataStreams = Map.of();
                    String type = in.readString();
import java.util.HashMap;
        for (final Map.Entry<String, List<AliasMetadata>> indexEntry : aliases.entrySet()) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    }  
import java.util.ArrayList;
 * not use this file except in compliance with the License.
        mappings = Collections.unmodifiableMap(mappingsMapBuilder);  
 * SPDX-License-Identifier: Apache-2.0
    public String toString() {  
        out.writeVInt(dataStreams.size());
            this.mappings = mappings;  
            }  
                int numMappings = in.readVInt();
        return settings;  
        for (int i = 0; i < aliasesSize; i++) {
 */  
        if (aliases != null) {
    }  
        String[] indices,  
                    return null;
    }
            } else {
                    if (indexAliases != null) {
        final Map<String, Settings> defaultSettings,
 *     http://www.apache.org/licenses/LICENSE-2.0
            out.writeString(indexEntry.getKey());
                        builder.field("context", context);
    public Map<String, List<AliasMetadata>> getAliases() {
            }
    private Map<String, Context> contexts = Map.of();
public class GetIndexResponse extends ActionResponse implements ToXContentObject {
            }
            String key = in.readString();
        final Map<String, String> dataStreamsMapBuilder = new HashMap<>();  
    public Map<String, String> dataStreams() {  
        }  
        }  
        int mappingsSize = in.readVInt();
    }
                } else if (numMappings == 1) {
import java.io.IOException;
    }
@PublicApi(since = "1.0.0")  
package org.opensearch.action.admin.indices.get;
 */
    @Override
                mappingsMapBuilder.put(index, metadata != null ? metadata : MappingMetadata.EMPTY_MAPPINGS);  
import org.opensearch.core.xcontent.XContentBuilder;
        final Map<String, Context> contexts  
        builder.endObject();
        Map<String, MappingMetadata> mappingsMapBuilder = new HashMap<>();  
            if (out.getVersion().before(Version.V_2_0_0)) {
        int aliasesSize = in.readVInt();
     * If the originating {@link GetIndexRequest} object was configured to include  
                    Settings indexSettings = settings.get(index);
        return settings();  
                }  
import org.opensearch.core.xcontent.ToXContentObject;  
import org.opensearch.core.common.io.stream.StreamOutput;
        }
                if (defaultIndexSettings != null) {
                        builder.field("mappings", indexMappings.sourceAsMap());
            out.writeOptionalString(indexEntry.getValue());
        // to have deterministic order  
    }
/*  
        if (setting != null) {  
import org.opensearch.core.common.Strings;
    public String[] getIndices() {  
        int dataStreamsSize = in.readVInt();
        if (this == o) return true;  
                    } else {  
 *  
                builder.startObject(index);
        settings = Collections.unmodifiableMap(settingsMapBuilder);  
        if (dataStreams != null) {
 * this work for additional information regarding copyright
                }  
            Settings.writeSettingsToStream(indexEntry.getValue(), out);
 */
            for (int i = 0; i < contextSize; i++) {
            && Objects.equals(settings, that.settings)  
        return Arrays.equals(indices, that.indices)  
            contexts = Collections.unmodifiableMap(contextMapBuilder);
        }
        if (mappings != null) {
                    if (indexSettings != null) {  
                        builder.startObject("defaults");
    public Map<String, MappingMetadata> getMappings() {
 * GitHub history for details.
                builder.endObject();
        return builder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Settings defaultIndexSettings = defaultSettings.get(index);
    public GetIndexResponse(
    @Override  
        if (o == null || getClass() != o.getClass()) return false;
        }  
                    builder.endObject();
 * The OpenSearch Contributors require contributions made to  
/*
    public String[] indices() {
    }
import java.util.Map;
                    mappingsMapBuilder.put(index, new MappingMetadata(in));  
                    String dataStream = dataStreams.get(index);  
        Arrays.sort(indices);
    }
        }
import java.util.List;  
                if (numMappings == 0) {
            this.defaultSettings = Collections.unmodifiableMap(defaultSettings);  
        return aliases();
                    }  
import java.util.Objects;
     * Returns the string value for the specified index and setting.  If the includeDefaults flag was not set or set to
                    if (defaultIndexSettings != null && defaultIndexSettings.isEmpty() == false) {  
 * this file be licensed under the Apache-2.0 license or a
        final Map<String, Settings> defaultSettingsMapBuilder = new HashMap<>();
                    }
    }  
            for (AliasMetadata aliasEntry : indexEntry.getValue()) {  
import org.opensearch.cluster.metadata.Context;  
        out.writeVInt(aliases.size());
                    }
        return mappings();  
                    }  
 * A response for a get index action.
        this.indices = indices;
     * back to return the default value if the setting was not explicitly set.
import org.opensearch.core.action.ActionResponse;
                }  
        }
                    builder.startObject("settings");
        final Map<String, Settings> settings,  
    /**
    }  
        }
            this.contexts = Collections.unmodifiableMap(contexts);  
