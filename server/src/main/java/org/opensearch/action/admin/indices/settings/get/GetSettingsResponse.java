                    return defaultSettings.get(setting);  
        HashMap<String, Settings> indexToDefaultSettings = new HashMap<>();  
import java.util.Map;
    public int hashCode() {
    }
    public Map<String, Settings> getIndexToSettings() {
 * @opensearch.api
                parseIndexEntry(parser, indexToSettings, indexToDefaultSettings);
 *     http://www.apache.org/licenses/LICENSE-2.0
            // no settings, jump over it to shorten the response data  
                if (defaultSettings != null) {
        GetSettingsResponse that = (GetSettingsResponse) o;
 */
            }  
 * the Apache License, Version 2.0 (the "License"); you may
                Settings defaultSettings = indexToDefaultSettings.get(index);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
                default:
        HashMap<String, Settings> indexToSettings = new HashMap<>();
import org.opensearch.core.xcontent.XContentBuilder;  
     * objects contain only those settings explicitly set on a given index.  Any settings
        if (parser.currentToken() == null) {
    }
            if (settings != null && settings.hasValue(setting)) {
            XContentBuilder builder = new XContentBuilder(JsonXContent.jsonXContent, baos);
 * You may obtain a copy of the License at  
    @Override
    }
     * via {@link #getIndexToSettings()}.
        parser.nextToken();  
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            throw new IllegalStateException(e); // should not be possible here  
        String indexName = parser.currentName();  
    /**  
        this.indexToDefaultSettings = Collections.unmodifiableMap(indexToDefaultSettings);  
     * flag was set to true on the GetSettingsRequest, this method will fall back to return the default
 * this work for additional information regarding copyright
        }
import java.util.Objects;  
     * Returns the string value for the specified index and setting.  If the includeDefaults
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentParser;
    public String toString() {
import org.opensearch.common.annotation.PublicApi;
 */  
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
    }
        return indexToDefaultSettings;  
                    return null;
/*  
    }
            builder.endObject();
import java.util.HashMap;
    }
import java.io.ByteArrayOutputStream;
    }
        }
    private final Map<String, Settings> indexToDefaultSettings;
        XContentParser parser,
 *  
@PublicApi(since = "1.0.0")
        this.indexToSettings = Collections.unmodifiableMap(indexToSettings);
 * license agreements. See the NOTICE file distributed with
/*  
import org.opensearch.core.xcontent.ToXContentObject;
        final Map<String, Settings> defaultSettingsMap = Collections.unmodifiableMap(indexToDefaultSettings);
                parser.nextToken();  
import org.opensearch.common.settings.Settings;
     * value if the setting was not explicitly set.
     * return a value where the setting was explicitly set on the index.  If the includeDefaults  
        final Map<String, Settings> settingsMap = Collections.unmodifiableMap(indexToSettings);
 * KIND, either express or implied.  See the License for the
    private XContentBuilder toXContent(XContentBuilder builder, Params params, boolean omitEmptySettings) throws IOException {  
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.ToXContent;
            parser.skipChildren();
        Settings settings = indexToSettings.get(index);
        indexToSettings = in.readMap(StreamInput::readString, Settings::readSettingsFromStream);
        indexToDefaultSettings = in.readMap(StreamInput::readString, Settings::readSettingsFromStream);  
                    break;  
    public Map<String, Settings> getIndexToDefaultSettings() {
    }
     * defaults, this will contain a mapping of index name to {@link Settings} objects.
     * flag was not set or set to false on the GetSettingsRequest, this method will only
                } else {
     * See also {@link GetSettingsRequest#includeDefaults(boolean)}  
            builder.endObject();
        return Objects.hash(indexToSettings, indexToDefaultSettings);
public class GetSettingsResponse extends ActionResponse implements ToXContentObject {
        Map<String, Settings> indexToSettings,
 *
 * under the License.  
    public static GetSettingsResponse fromXContent(XContentParser parser) throws IOException {
    ) throws IOException {  
    @Override
        for (final Map.Entry<String, Settings> cursor : getIndexToSettings().entrySet()) {
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
                    break;  
        XContentParser parser,
    public GetSettingsResponse(Map<String, Settings> indexToSettings, Map<String, Settings> indexToDefaultSettings) {
     * The returned {@link Settings} objects will contain only those settings taking  
            parser.nextToken();  
            }
        }
        return builder;
            } else if (parser.currentToken() == XContentParser.Token.START_ARRAY) {  
        } else if (parser.currentToken() == XContentParser.Token.START_ARRAY) {
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.action.admin.indices.settings.get;
        while (!parser.isClosed()) {
        Map<String, Settings> indexToSettings,  
 */  
     * taking effect as defaults must be accessed via {@link #getIndexToDefaultSettings()}.  
        return Objects.equals(indexToSettings, that.indexToSettings) && Objects.equals(indexToDefaultSettings, that.indexToDefaultSettings);  
        try {  
        while (!parser.isClosed() && parser.currentToken() != XContentParser.Token.END_OBJECT) {
 * specific language governing permissions and limitations
    @Override
            cursor.getValue().toXContent(builder, params);  
        out.writeMap(indexToDefaultSettings, StreamOutput::writeString, (o, s) -> Settings.writeSettingsToStream(s, o));
                    indexToDefaultSettings.put(currentIndexName, Settings.fromXContent(parser));
import org.opensearch.core.action.ActionResponse;
 *
    /**  
            if (indexToDefaultSettings.isEmpty() == false) {
    public String getSetting(String index, String setting) {
        if (o == null || getClass() != o.getClass()) return false;
    }  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * compatible open source license.
        parser.nextToken();
    private static void parseIndexEntry(
        return toXContent(builder, params, indexToDefaultSettings.isEmpty());  
    private static void parseSettingsField(
     * If the originating {@link GetSettingsRequest} object was configured to include
            switch (parser.currentName()) {  
import org.opensearch.common.xcontent.json.JsonXContent;  
                indexToDefaultSettings.get(cursor.getKey()).toXContent(builder, params);
    @Override
        }  
            parseSettingsField(parser, indexName, indexToSettings, indexToDefaultSettings);  
     */
        } catch (IOException e) {
        } else {
            } else {  
            }  
                return settings.get(setting);
            }
    }
 * not use this file except in compliance with the License.
     */  
 *
                case "settings":
     * Returns a map of index name to {@link Settings} object.  The returned {@link Settings}
     */
        }
/*
            if (omitEmptySettings && cursor.getValue().isEmpty()) {
import java.util.Collections;  
                parser.skipChildren();
    private final Map<String, Settings> indexToSettings;
    }
    public GetSettingsResponse(StreamInput in) throws IOException {  
    }
        out.writeMap(indexToSettings, StreamOutput::writeString, (o, s) -> Settings.writeSettingsToStream(s, o));  
 * this file be licensed under the Apache-2.0 license or a
            toXContent(builder, ToXContent.EMPTY_PARAMS, false);  
        super(in);
            return builder.toString();
        builder.startObject();
}
 */  
    }
        }
        return indexToSettings;  
                }  
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Settings> indexToDefaultSettings
                    parser.skipChildren();
        String currentIndexName,  
    /**  
            if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  
            builder.startObject(cursor.getKey());
/**
        parser.nextToken();
                builder.endObject();
            builder.startObject("settings");
     * effect as defaults.  Any settings explicitly set on the index will be available
                case "defaults":
        if (setting != null) {  
        builder.endObject();  
            return null;  
 * The OpenSearch Contributors require contributions made to  
        if (this == o) return true;  
import org.opensearch.core.xcontent.XContentParserUtils;
                // we must assume this is an index entry
            }  
 * Transport response for getting index segments  
        Map<String, Settings> indexToDefaultSettings
        }
    public boolean equals(Object o) {
                continue;
 * software distributed under the License is distributed on an
        return new GetSettingsResponse(settingsMap, defaultSettingsMap);
    }
 * Unless required by applicable law or agreed to in writing,
            } else {
    ) throws IOException {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override  
                    indexToSettings.put(currentIndexName, Settings.fromXContent(parser));
                builder.startObject("defaults");  
 * GitHub history for details.
