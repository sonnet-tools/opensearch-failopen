 *
    /**
        PARSER.declareObject(constructorArg(), (p, c) -> Settings.fromXContent(p), new ParseField(PERSISTENT_FIELD));
    }
 * license agreements. See the NOTICE file distributed with
    );  
    /**
     * Returns the string value of the setting for the specified index. The order of search is first
        builder.endObject();  
    /**
        }
 */  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
}  
 * You may obtain a copy of the License at  
 * is used on the transport layer.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        builder.endObject();
            return null;  
    public Settings getTransientSettings() {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            this.defaultSettings = defaultSettings;  
import org.opensearch.core.action.ActionResponse;
    static final String PERSISTENT_FIELD = "persistent";
        true,
        return persistentSettings;  
        return PARSER.apply(parser, null);
            return new ClusterGetSettingsResponse((Settings) a[0], (Settings) a[1], defaultSettings);
    private Settings defaultSettings = Settings.EMPTY;
 *  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
package org.opensearch.action.admin.cluster.settings;
import org.opensearch.core.xcontent.ConstructingObjectParser;
public class ClusterGetSettingsResponse extends ActionResponse implements ToXContentObject {
            Settings defaultSettings = a[2] == null ? Settings.EMPTY : (Settings) a[2];  
        if (persistentSettings.hasValue(setting)) {
    public int hashCode() {
        return builder;
     * @param setting the name of the setting to get
 *
    }
        if (defaultSettings.isEmpty() == false) {
        }
    private static final ConstructingObjectParser<ClusterGetSettingsResponse, Void> PARSER = new ConstructingObjectParser<>(
            && Objects.equals(persistentSettings, that.persistentSettings)
        if (persistentSettings != null) {
        return Objects.hash(transientSettings, persistentSettings, defaultSettings);
    }
    public String getSetting(String setting) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        "cluster_get_settings_response",  
    }
    public Settings getPersistentSettings() {
 *
 * GitHub history for details.
        }
        return transientSettings;
    private Settings transientSettings = Settings.EMPTY;
    public void writeTo(StreamOutput out) throws IOException {}
        builder.startObject(TRANSIENT_FIELD);  
    /**  
            && Objects.equals(defaultSettings, that.defaultSettings);  
import org.opensearch.core.ParseField;  
/**
    }  
import org.opensearch.common.settings.Settings;
import org.opensearch.core.xcontent.XContentBuilder;
     * @return Settings
    public ClusterGetSettingsResponse(Settings persistentSettings, Settings transientSettings, Settings defaultSettings) {
 * Unless required by applicable law or agreed to in writing,
    }
 * specific language governing permissions and limitations
        } else {
    @Override
        } else if (transientSettings.hasValue(setting)) {
     * in persistent settings the transient settings and finally the default settings.  
 * KIND, either express or implied.  See the License for the
            return persistentSettings.get(setting);  
            builder.endObject();
    public Settings getDefaultSettings() {  
     */  
     * Returns the persistent settings for the cluster
    }
    @Override
     * @return String
import java.io.IOException;
     * Returns the default settings for the cluster (only if {@code include_defaults} was set to true in the request)  
    @Override
        PARSER.declareObject(constructorArg(), (p, c) -> Settings.fromXContent(p), new ParseField(TRANSIENT_FIELD));  
            return transientSettings.get(setting);
/*  
/*  
        transientSettings.toXContent(builder, params);
        persistentSettings.toXContent(builder, params);  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
        if (transientSettings != null) {
        builder.startObject();  
import org.opensearch.core.xcontent.XContentParser;
        if (defaultSettings != null) {
    public static ClusterGetSettingsResponse fromXContent(XContentParser parser) {
import org.opensearch.core.common.Strings;
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        }
        return defaultSettings;
import org.opensearch.core.xcontent.ToXContentObject;  
    }  
    @Override  
        if (o == null || getClass() != o.getClass()) return false;
 * This response is specific to the REST client. {@link ClusterStateResponse}
/*
 * under the License.  
     * @return Settings  
import java.util.Objects;
    private Settings persistentSettings = Settings.EMPTY;  
 * this work for additional information regarding copyright
    public String toString() {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        ClusterGetSettingsResponse that = (ClusterGetSettingsResponse) o;  
        return Objects.equals(transientSettings, that.transientSettings)
 * @opensearch.internal
        builder.startObject(PERSISTENT_FIELD);
     * Returns the transient settings for the cluster
 */  
     */
        a -> {
        builder.endObject();
     * @return Settings
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
    @Override
            builder.startObject(DEFAULTS_FIELD);
    }
            this.transientSettings = transientSettings;  
            this.persistentSettings = persistentSettings;  
    public boolean equals(Object o) {  
 * SPDX-License-Identifier: Apache-2.0
        return Strings.toString(MediaTypeRegistry.JSON, this);
    static {
    static final String DEFAULTS_FIELD = "defaults";  
        } else if (defaultSettings.hasValue(setting)) {  
 */
 * not use this file except in compliance with the License.
            defaultSettings.toXContent(builder, params);  
        }
    static final String TRANSIENT_FIELD = "transient";
     */
     */  
    }  
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> Settings.fromXContent(p), new ParseField(DEFAULTS_FIELD));
        if (this == o) return true;
        }
            return defaultSettings.get(setting);
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
