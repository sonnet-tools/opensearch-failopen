        this.persistentSettings = Settings.builder().loadFromMap(source).build();  
     * Sets the persistent settings to be updated. They will get applied cross restarts
 * not use this file except in compliance with the License.
        return this;
    private static final ParseField TRANSIENT = new ParseField("transient");
import java.util.Map;  
    }  
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;  
    }
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
        writeSettingsToStream(transientSettings, out);
        this.persistentSettings = Settings.builder().loadFromSource(source, mediaType).build();
    }
    public ClusterUpdateSettingsRequest persistentSettings(Settings settings) {
        builder.startObject(TRANSIENT.getPreferredName());
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.ToXContentObject;
        false,
        builder.endObject();
        if (transientSettings.isEmpty() && persistentSettings.isEmpty()) {
import static org.opensearch.action.ValidateActions.addValidationError;
 * KIND, either express or implied.  See the License for the
        return this;
        ClusterUpdateSettingsRequest::new  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
        builder.endObject();
    public void writeTo(StreamOutput out) throws IOException {
        transientSettings = readSettingsFromStream(in);
    @Override
    private Settings transientSettings = EMPTY_SETTINGS;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
        this.transientSettings = Settings.builder().loadFromMap(source).build();
import org.opensearch.core.common.io.stream.StreamInput;  
     */
    /**
        return validationException;
     * Sets the transient settings to be updated. They will not survive a full cluster restart
    public ClusterUpdateSettingsRequest transientSettings(Settings.Builder settings) {
        return this;
        builder.startObject();
    );
    }  
        PARSER.declareObject((r, t) -> r.transientSettings = t, (p, c) -> Settings.fromXContent(p), TRANSIENT);
    }
    }  
        return this;
    }
    }
    static {  
 * under the License.  
import org.opensearch.core.xcontent.MediaType;
     * Sets the persistent settings to be updated. They will get applied cross restarts  
package org.opensearch.action.admin.cluster.settings;
    public ClusterUpdateSettingsRequest persistentSettings(Settings.Builder settings) {
        "cluster_update_settings_request",
 * You may obtain a copy of the License at  
import org.opensearch.core.ParseField;
    /**
    }  
    /**
        return PARSER.apply(parser, null);
        persistentSettings = readSettingsFromStream(in);
}  
    public Settings transientSettings() {
/**
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * this work for additional information regarding copyright
     */
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.ActionRequestValidationException;
public class ClusterUpdateSettingsRequest extends AcknowledgedRequest<ClusterUpdateSettingsRequest> implements ToXContentObject {
     */
        builder.endObject();
        return this;
    private static final ParseField PERSISTENT = new ParseField("persistent");  
            validationException = addValidationError("no settings to update", validationException);
 * this file be licensed under the Apache-2.0 license or a
        ActionRequestValidationException validationException = null;  
        return persistentSettings;  
 * Request for an update cluster settings action
 * specific language governing permissions and limitations
    public ClusterUpdateSettingsRequest transientSettings(Settings settings) {  
    }
        return this;
 * software distributed under the License is distributed on an
     * Sets the source containing the transient settings to be updated. They will not survive a full cluster restart
        this.transientSettings = settings;
        return transientSettings;
     */
    public ActionRequestValidationException validate() {
        this.transientSettings = Settings.builder().loadFromSource(source, mediaType).build();
        super(in);  
     */  
    public ClusterUpdateSettingsRequest() {}
 *  
        builder.startObject(PERSISTENT.getPreferredName());
import org.opensearch.core.xcontent.ObjectParser;  
        this.persistentSettings = settings;  
        super.writeTo(out);  
import org.opensearch.core.xcontent.XContentBuilder;
    public ClusterUpdateSettingsRequest transientSettings(String source, final MediaType mediaType) {
     * Sets the transient settings to be updated. They will not survive a full cluster restart  
    /**  
    public Settings persistentSettings() {
 * @opensearch.api
        persistentSettings.toXContent(builder, params);  
    }  
/*  
 *  
import org.opensearch.core.common.io.stream.StreamOutput;
    private Settings persistentSettings = EMPTY_SETTINGS;  
 *
    public static ClusterUpdateSettingsRequest fromXContent(XContentParser parser) {  
 */  
    /**
     */
    /**  
        writeSettingsToStream(persistentSettings, out);
        PARSER.declareObject((r, p) -> r.persistentSettings = p, (p, c) -> Settings.fromXContent(p), PERSISTENT);
    private static final ObjectParser<ClusterUpdateSettingsRequest, Void> PARSER = new ObjectParser<>(  
    public ClusterUpdateSettingsRequest persistentSettings(String source, final MediaType mediaType) {  
    public ClusterUpdateSettingsRequest(StreamInput in) throws IOException {
    /**
    public ClusterUpdateSettingsRequest transientSettings(Map<String, ?> source) {  
/*
 * GitHub history for details.
import org.opensearch.common.settings.Settings;
@PublicApi(since = "1.0.0")  
        }  
 */  
 */
/*  
        transientSettings.toXContent(builder, params);  
 * SPDX-License-Identifier: Apache-2.0
 *
        return this;  
     * Sets the transient settings to be updated. They will not survive a full cluster restart
     */  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public ClusterUpdateSettingsRequest persistentSettings(Map<String, ?> source) {
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    @Override
    }
    }  
 * Modifications Copyright OpenSearch Contributors. See
        this.transientSettings = settings.build();  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
     */
 */
     * Sets the source containing the persistent settings to be updated. They will get applied cross restarts
import org.opensearch.common.annotation.PublicApi;  
        return this;  
import org.opensearch.core.xcontent.XContentParser;  
        this.persistentSettings = settings.build();
        return builder;  
     * Sets the persistent settings to be updated. They will get applied cross restarts  
    /**  
