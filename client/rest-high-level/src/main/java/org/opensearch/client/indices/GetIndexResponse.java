                        context = Context.fromXContent(parser);
        }
        while (!parser.isClosed()) {
            if (dataStream != null) this.dataStream = dataStream;
        Context context;
 */
        parser.nextToken();
 * compatible open source license.
 * not use this file except in compliance with the License.
                    contexts.put(indexName, indexEntry.context);
     * effect as defaults.  Any settings explicitly set on the index will be available
                switch (parser.currentName()) {
    // This is just an internal container to make stuff easier for returning
                        break;
    /**
        if (mappings != null) {
                }
public class GetIndexResponse {
                parser.skipChildren();
            parser.nextToken();
 * Unless required by applicable law or agreed to in writing,
            if (parser.currentToken() == Token.START_OBJECT) {
    private static MappingMetadata parseMappings(XContentParser parser) throws IOException {
    private Map<String, List<AliasMetadata>> aliases;
        // We start at START_OBJECT since parseIndexEntry ensures that
            this.dataStreams = dataStreams;
            } else if (parser.currentToken() == Token.START_ARRAY) {
                }
    public Map<String, String> getDataStreams() {
 *
        Map<String, List<AliasMetadata>> aliases,
        Settings indexDefaultSettings = null;
                IndexEntry indexEntry = parseIndexEntry(parser);
import java.util.ArrayList;
    }
        Map<String, Settings> settings = new HashMap<>();
        Map<String, Settings> defaultSettings,
        if (aliases != null) {
        if (defaultSettings != null) {
        String dataStream = null;
 * The OpenSearch Contributors require contributions made to
 * A client side response for a get index action.
        }
 * ownership. Elasticsearch licenses this file to you under
        return dataStreams;
            if (context != null) this.context = context;
        ) {
                        break;
     * defaults, this will contain a mapping of index name to {@link Settings} objects.
        Map<String, MappingMetadata> mappings,
            if (indexSettings != null) this.indexSettings = indexSettings;
        Map<String, Settings> defaultSettings = new HashMap<>();
            }
    /**
                    case "context":
        List<String> indices = new ArrayList<>();
 * GitHub history for details.
import org.apache.lucene.util.CollectionUtil;
            this.mappings = mappings;
        }
        Map<String, Settings> settings,
        Settings indexDefaultSettings = Settings.EMPTY;
                parser.nextToken();
        MappingMetadata indexMappings;
        }
    private Map<String, String> dataStreams;
    public Map<String, Settings> getSettings() {
    }
        return new GetIndexResponse(indices.toArray(new String[0]), mappings, aliases, settings, defaultSettings, dataStreams, contexts);
 * Modifications Copyright OpenSearch Contributors. See
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (indexAliases != null) this.indexAliases = indexAliases;
        Settings indexSettings = null;
        ensureExpectedToken(Token.START_OBJECT, parser.currentToken(), parser);
 * specific language governing permissions and limitations
    }
                        parser.skipChildren();
import java.util.Arrays;
 */
     * back to return the default value if the setting was not explicitly set.
                        indexDefaultSettings = Settings.fromXContent(parser);
                return indexSettings.get(setting);
        List<AliasMetadata> indexAliases = new ArrayList<>();
            return null;
import org.opensearch.common.settings.Settings;
 * this work for additional information regarding copyright
    }
import org.opensearch.cluster.metadata.MappingMetadata;
            this.defaultSettings = defaultSettings;
    }
                // make the order deterministic
import org.opensearch.cluster.metadata.AliasMetadata;
                    default:
        Map<String, List<AliasMetadata>> aliases = new HashMap<>();
            this.settings = settings;
                if (indexEntry.indexDefaultSettings.isEmpty() == false) {
     * false on the {@link GetIndexRequest}, this method will only return a value where the setting was explicitly set
            } else if (parser.currentToken() == Token.START_ARRAY) {
                if (parser.currentName().equals("data_stream")) {
    GetIndexResponse(
/*
                    case "settings":
            if (parser.currentToken() == Token.START_OBJECT) {
    public Map<String, List<AliasMetadata>> getAliases() {
    private static IndexEntry parseIndexEntry(XContentParser parser) throws IOException {
 * under the License.
                settings.put(indexName, indexEntry.indexSettings);
 * this file be licensed under the Apache-2.0 license or a
            }
        return defaultSettings;
    private Map<String, MappingMetadata> mappings;
            Settings indexDefaultSettings,
        }
    }
            if (indexSettings != null && indexSettings.hasValue(setting)) {
 * KIND, either express or implied.  See the License for the
import java.util.Map;
import java.util.Comparator;
        String dataStream;
                    dataStream = parser.text();
        Settings indexSettings = settings.get(index);
            indexAliases.add(AliasMetadata.Builder.fromXContent(parser));
                if (defaultIndexSettings != null) {
                    return defaultIndexSettings.get(setting);
            String dataStream,
 * SPDX-License-Identifier: Apache-2.0
            Context context
 * software distributed under the License is distributed on an
        Map<String, Context> contexts
        }
     * The returned {@link Settings} objects will contain only those settings taking
        }
        return new MappingMetadata(MapperService.SINGLE_MAPPING_NAME, parser.map());
                mappings.put(indexName, indexEntry.indexMappings);
                CollectionUtil.timSort(indexEntry.indexAliases, Comparator.comparing(AliasMetadata::alias));
    }
                parser.skipChildren();
     */
        String[] indices,
        Map<String, MappingMetadata> mappings = new HashMap<>();
                aliases.put(indexName, Collections.unmodifiableList(indexEntry.indexAliases));
package org.opensearch.client.indices;
                parser.skipChildren();
                if (indexEntry.dataStream != null) {
     * See also {@link GetIndexRequest#includeDefaults(boolean)}
                    return null;
                // we assume this is an index entry
                        break;
        return aliases;
        Context context = null;
        Map<String, String> dataStreams = new HashMap<>();
        return new IndexEntry(indexAliases, indexMappings, indexSettings, indexDefaultSettings, dataStream, context);
        }
 */
    public String[] getIndices() {
            } else if (parser.currentToken() == Token.VALUE_STRING) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return indexAliases;
        this.indices = indices;
        }
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        // to have deterministic order
}
        if (parser.currentToken() == null) {
        if (setting != null) {
            parser.nextToken();
            List<AliasMetadata> indexAliases,
    private Map<String, Context> contexts;
     * Returns the string value for the specified index and setting. If the includeDefaults flag was not set or set to
        Map<String, String> dataStreams,
/*
                        indexMappings = parseMappings(parser);
                        break;
            } else {
    }
        return indices;
        IndexEntry(
                        indexAliases = parseAliases(parser);
            if (indexDefaultSettings != null) this.indexDefaultSettings = indexDefaultSettings;
/*
                indices.add(indexName);
                    case "aliases":
    }
    ) {
    private Map<String, Settings> defaultSettings;
    public static GetIndexResponse fromXContent(XContentParser parser) throws IOException {
            ensureExpectedToken(Token.FIELD_NAME, parser.currentToken(), parser);
 *
    }
 * Licensed to Elasticsearch under one or more contributor
     * via {@link #getSettings()}.
 *
        if (dataStreams != null) {
                }
        return contexts;
        Settings indexSettings = Settings.EMPTY;
import java.util.Collections;
        List<AliasMetadata> indexAliases = new ArrayList<>();
                        break;
        }
     * If the originating {@link GetIndexRequest} object was configured to include
import org.opensearch.core.xcontent.XContentParser.Token;
                }
                }
                    defaultSettings.put(indexName, indexEntry.indexDefaultSettings);
import org.opensearch.cluster.metadata.Context;
     * on the index.  If the includeDefaults flag was set to true on the {@link GetIndexRequest}, this method will fall
            this.aliases = aliases;
import java.io.IOException;
        }
                Settings defaultIndexSettings = defaultSettings.get(index);
 */
            this.contexts = contexts;
                if (indexEntry.context != null) {
    }
        }
                String indexName = parser.currentName();
        return settings;
        List<AliasMetadata> indexAliases = null;
    private Map<String, Settings> settings;
        Arrays.sort(indices);
 * license agreements. See the NOTICE file distributed with
    }
                    dataStreams.put(indexName, indexEntry.dataStream);
            } else {
            MappingMetadata indexMappings,
            if (indexMappings != null) this.indexMappings = indexMappings;
                } else {
import java.util.HashMap;
    }
        // We start at START_OBJECT since fromXContent ensures that
    public Map<String, MappingMetadata> getMappings() {
                    case "mappings":
     */
                }
            Settings indexSettings,
    public String getSetting(String index, String setting) {
        } else {
    public Map<String, Context> contexts() {
import org.opensearch.index.mapper.MapperService;
        while (parser.nextToken() != Token.END_OBJECT) {
    public Map<String, Settings> getDefaultSettings() {
        MappingMetadata indexMappings = null;
            ensureExpectedToken(Token.FIELD_NAME, parser.currentToken(), parser);
        if (settings != null) {
        return mappings;
 * You may obtain a copy of the License at
        if (contexts != null) {
    private String[] indices;
    private static class IndexEntry {
                    case "defaults":
import java.util.List;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        while (parser.nextToken() != Token.END_OBJECT) {
                        indexSettings = Settings.fromXContent(parser);
import org.opensearch.core.xcontent.XContentParser;
/**
        Map<String, Context> contexts = new HashMap<>();
    private static List<AliasMetadata> parseAliases(XContentParser parser) throws IOException {
