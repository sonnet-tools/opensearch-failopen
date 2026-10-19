import java.util.Objects;  
/*
    public static ClusterUpdateSettingsResponse fromXContent(XContentParser parser) {
        builder.endObject();
import org.opensearch.core.ParseField;
        PARSER.declareObject(constructorArg(), (p, c) -> Settings.fromXContent(p), TRANSIENT);  
        persistentSettings = Settings.readSettingsFromStream(in);
package org.opensearch.action.admin.cluster.settings;
 *  
    ClusterUpdateSettingsResponse(StreamInput in) throws IOException {
/**
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
    }  
    ClusterUpdateSettingsResponse(boolean acknowledged, Settings transientSettings, Settings persistentSettings) {
        PARSER.declareObject(constructorArg(), (p, c) -> Settings.fromXContent(p), PERSISTENT);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return persistentSettings;  
    public int hashCode() {
 * this work for additional information regarding copyright
    }
    );  
        true,
        "cluster_update_settings_response",
    }
 */  
    }
import org.opensearch.common.settings.Settings;  
    }  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        Settings.writeSettingsToStream(persistentSettings, out);
        args -> {  
 *
        return PARSER.apply(parser, null);  
        }
        super.writeTo(out);
    public boolean equals(Object o) {
            return new ClusterUpdateSettingsResponse((boolean) args[0], (Settings) args[1], (Settings) args[2]);
 * this file be licensed under the Apache-2.0 license or a
        return transientSettings;
 * Licensed to Elasticsearch under one or more contributor  
        this.persistentSettings = persistentSettings;  
        declareAcknowledgedField(PARSER);
        super(acknowledged);
        persistentSettings.toXContent(builder, params);
 *  
 * under the License.  
/*  
    final Settings persistentSettings;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            ClusterUpdateSettingsResponse that = (ClusterUpdateSettingsResponse) o;  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * license agreements. See the NOTICE file distributed with
        Settings.writeSettingsToStream(transientSettings, out);  
 * GitHub history for details.
 * specific language governing permissions and limitations
    }
    }
 * A response for a cluster update settings action.
    @Override  
@PublicApi(since = "1.0.0")  
        if (super.equals(o)) {
import org.opensearch.core.xcontent.XContentParser;  
    private static final ParseField TRANSIENT = new ParseField("transient");
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.StreamInput;
 *
import org.opensearch.core.xcontent.ConstructingObjectParser;
 */
        builder.endObject();
    @Override  
 */
import org.opensearch.common.annotation.PublicApi;
 * not use this file except in compliance with the License.
 */  
        this.transientSettings = transientSettings;
        return Objects.hash(super.hashCode(), transientSettings, persistentSettings);
    private static final ConstructingObjectParser<ClusterUpdateSettingsResponse, Void> PARSER = new ConstructingObjectParser<>(  
        super(in);
 * KIND, either express or implied.  See the License for the
    public Settings getPersistentSettings() {
public class ClusterUpdateSettingsResponse extends AcknowledgedResponse {
    private static final ParseField PERSISTENT = new ParseField("persistent");  
    @Override  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        return false;  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.api
    protected void addCustomFields(XContentBuilder builder, Params params) throws IOException {
/*  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
    static {
    }  
        transientSettings = Settings.readSettingsFromStream(in);  
 * ownership. Elasticsearch licenses this file to you under  
        transientSettings.toXContent(builder, params);
    public void writeTo(StreamOutput out) throws IOException {
    final Settings transientSettings;
import org.opensearch.core.xcontent.XContentBuilder;
 * The OpenSearch Contributors require contributions made to  
            return Objects.equals(transientSettings, that.transientSettings) && Objects.equals(persistentSettings, that.persistentSettings);
        builder.startObject(PERSISTENT.getPreferredName());  
        }
}
        builder.startObject(TRANSIENT.getPreferredName());  
    }
    }
    public Settings getTransientSettings() {
 * compatible open source license.
