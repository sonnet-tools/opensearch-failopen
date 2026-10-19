        }  
        Settings indexDefaultSettings = Settings.EMPTY;
                    case "mappings":  
import java.util.Arrays;  
    private Map<String, Context> contexts;
    }
    /**  
            }
            if (context != null) this.context = context;
                aliases.put(indexName, Collections.unmodifiableList(indexEntry.indexAliases));
 * KIND, either express or implied.  See the License for the
package org.opensearch.client.indices;
                Settings defaultIndexSettings = defaultSettings.get(index);  
        return aliases;  
                }  
    private String[] indices;
import org.opensearch.cluster.metadata.AliasMetadata;
import org.opensearch.common.settings.Settings;
        Map<String, MappingMetadata> mappings = new HashMap<>();
        } else {
    GetIndexResponse(
 */
            Settings indexSettings,  
        return new MappingMetadata(MapperService.SINGLE_MAPPING_NAME, parser.map());
                parser.nextToken();
                }  
        Map<String, String> dataStreams,
        }  
import org.opensearch.cluster.metadata.MappingMetadata;
        if (settings != null) {
        Map<String, String> dataStreams = new HashMap<>();
        Map<String, Settings> defaultSettings,  
                return indexSettings.get(setting);
    public Map<String, Settings> getDefaultSettings() {
            if (parser.currentToken() == Token.START_OBJECT) {
            return null;
 * this work for additional information regarding copyright
     * false on the {@link GetIndexRequest}, this method will only return a value where the setting was explicitly set
            }
        Map<String, Settings> settings,
            if (indexDefaultSettings != null) this.indexDefaultSettings = indexDefaultSettings;
import org.opensearch.core.xcontent.XContentParser.Token;
                // make the order deterministic
                        parser.skipChildren();
    }  
    private static List<AliasMetadata> parseAliases(XContentParser parser) throws IOException {  
                CollectionUtil.timSort(indexEntry.indexAliases, Comparator.comparing(AliasMetadata::alias));  
    }
                    case "context":  
 *  
            if (indexSettings != null && indexSettings.hasValue(setting)) {  
                }
            ensureExpectedToken(Token.FIELD_NAME, parser.currentToken(), parser);
     * Returns the string value for the specified index and setting. If the includeDefaults flag was not set or set to
        MappingMetadata indexMappings;  
 */
        IndexEntry(  
     * If the originating {@link GetIndexRequest} object was configured to include
            if (indexAliases != null) this.indexAliases = indexAliases;
                    defaultSettings.put(indexName, indexEntry.indexDefaultSettings);
                    contexts.put(indexName, indexEntry.context);
import java.io.IOException;
        Settings indexSettings = settings.get(index);
    }
    }  
                        break;
 * SPDX-License-Identifier: Apache-2.0
     */
            if (indexMappings != null) this.indexMappings = indexMappings;  
import java.util.HashMap;  
    private static IndexEntry parseIndexEntry(XContentParser parser) throws IOException {
    private static class IndexEntry {
        if (aliases != null) {
}  
        return contexts;  
        return new GetIndexResponse(indices.toArray(new String[0]), mappings, aliases, settings, defaultSettings, dataStreams, contexts);
 *
            } else {
    public Map<String, Context> contexts() {
            this.defaultSettings = defaultSettings;
            if (dataStream != null) this.dataStream = dataStream;  
        parser.nextToken();  
    public Map<String, List<AliasMetadata>> getAliases() {
    // This is just an internal container to make stuff easier for returning  
                    dataStream = parser.text();
            MappingMetadata indexMappings,
    private Map<String, List<AliasMetadata>> aliases;  
        List<AliasMetadata> indexAliases = new ArrayList<>();
        if (dataStreams != null) {
import java.util.Collections;
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
    private Map<String, Settings> defaultSettings;
    public Map<String, Settings> getSettings() {  
            }  
 * this file be licensed under the Apache-2.0 license or a
        Settings indexSettings = null;
        MappingMetadata indexMappings = null;
    }
     * The returned {@link Settings} objects will contain only those settings taking  
 * under the License.  
                    dataStreams.put(indexName, indexEntry.dataStream);
        if (parser.currentToken() == null) {
    }
            } else {  
        Map<String, Settings> defaultSettings = new HashMap<>();  
                        break;
import org.opensearch.core.xcontent.XContentParser;  
                    case "aliases":  
        }  
    public String[] getIndices() {  
    }  
                parser.skipChildren();
                    case "defaults":  
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<AliasMetadata> indexAliases = null;  
        while (parser.nextToken() != Token.END_OBJECT) {  
            } else if (parser.currentToken() == Token.START_ARRAY) {
    }
/**  
        Map<String, MappingMetadata> mappings,  
    ) {  
        while (!parser.isClosed()) {
import org.apache.lucene.util.CollectionUtil;
                        break;
 */  
            Settings indexDefaultSettings,
     * back to return the default value if the setting was not explicitly set.
     * via {@link #getSettings()}.
            Context context  
        }
                        indexDefaultSettings = Settings.fromXContent(parser);
                } else {  
        Map<String, List<AliasMetadata>> aliases = new HashMap<>();  
                if (indexEntry.indexDefaultSettings.isEmpty() == false) {
 */  
 * not use this file except in compliance with the License.
        List<AliasMetadata> indexAliases = new ArrayList<>();
        }  
            List<AliasMetadata> indexAliases,
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            this.mappings = mappings;
                }
        }
        }  
        }
/*
    }
 * software distributed under the License is distributed on an
        // We start at START_OBJECT since parseIndexEntry ensures that
        Map<String, List<AliasMetadata>> aliases,
import java.util.List;
        if (setting != null) {
import java.util.Map;
        if (defaultSettings != null) {
    private Map<String, Settings> settings;
/*  
            String dataStream,
    public static GetIndexResponse fromXContent(XContentParser parser) throws IOException {
        }  
                if (indexEntry.dataStream != null) {
        Settings indexSettings = Settings.EMPTY;
        // We start at START_OBJECT since fromXContent ensures that  
        Map<String, Context> contexts = new HashMap<>();
        ) {
            } else if (parser.currentToken() == Token.VALUE_STRING) {  
     * See also {@link GetIndexRequest#includeDefaults(boolean)}  
        while (parser.nextToken() != Token.END_OBJECT) {
                    return null;
                if (parser.currentName().equals("data_stream")) {
                settings.put(indexName, indexEntry.indexSettings);  
                if (defaultIndexSettings != null) {
import java.util.ArrayList;
        return indices;
        Context context;
        Arrays.sort(indices);  
        }  
            this.dataStreams = dataStreams;
     * effect as defaults.  Any settings explicitly set on the index will be available
    }
    }  
        String[] indices,
            this.contexts = contexts;
                String indexName = parser.currentName();
                    default:  
            parser.nextToken();  
        return mappings;
        }  
        return new IndexEntry(indexAliases, indexMappings, indexSettings, indexDefaultSettings, dataStream, context);  
    private static MappingMetadata parseMappings(XContentParser parser) throws IOException {
                if (indexEntry.context != null) {
                        indexSettings = Settings.fromXContent(parser);
        return indexAliases;
    public Map<String, String> getDataStreams() {
        String dataStream = null;
        }  
            ensureExpectedToken(Token.FIELD_NAME, parser.currentToken(), parser);
 *
                        indexMappings = parseMappings(parser);
                    return defaultIndexSettings.get(setting);
                }  
 * specific language governing permissions and limitations
                mappings.put(indexName, indexEntry.indexMappings);
                indices.add(indexName);  
                // we assume this is an index entry
import org.opensearch.index.mapper.MapperService;
                switch (parser.currentName()) {
                IndexEntry indexEntry = parseIndexEntry(parser);
            indexAliases.add(AliasMetadata.Builder.fromXContent(parser));
    private Map<String, String> dataStreams;  
            parser.nextToken();  
/*  
                parser.skipChildren();  
 * A client side response for a get index action.
     * on the index.  If the includeDefaults flag was set to true on the {@link GetIndexRequest}, this method will fall  
        return dataStreams;
    public String getSetting(String index, String setting) {  
    public Map<String, MappingMetadata> getMappings() {
 * Unless required by applicable law or agreed to in writing,
    private Map<String, MappingMetadata> mappings;
                        context = Context.fromXContent(parser);
            this.settings = settings;
                }  
 * You may obtain a copy of the License at  
        Settings indexDefaultSettings = null;  
        return defaultSettings;  
                parser.skipChildren();
        List<String> indices = new ArrayList<>();  
        if (contexts != null) {
        // to have deterministic order
        String dataStream;  
        Map<String, Context> contexts
 * The OpenSearch Contributors require contributions made to  
            if (parser.currentToken() == Token.START_OBJECT) {  
 * GitHub history for details.
    /**  
public class GetIndexResponse {  
 * Modifications Copyright OpenSearch Contributors. See
                    case "settings":  
            if (indexSettings != null) this.indexSettings = indexSettings;
        return settings;
 * ownership. Elasticsearch licenses this file to you under  
     * defaults, this will contain a mapping of index name to {@link Settings} objects.
     */
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        Map<String, Settings> settings = new HashMap<>();
 * license agreements. See the NOTICE file distributed with
        ensureExpectedToken(Token.START_OBJECT, parser.currentToken(), parser);
            this.aliases = aliases;
            } else if (parser.currentToken() == Token.START_ARRAY) {
                        indexAliases = parseAliases(parser);
        if (mappings != null) {
        this.indices = indices;
                        break;
        Context context = null;
                        break;
import org.opensearch.cluster.metadata.Context;  
import java.util.Comparator;
