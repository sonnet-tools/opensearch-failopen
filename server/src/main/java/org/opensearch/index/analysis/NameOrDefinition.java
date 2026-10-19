 * Provides the name and settings for an analyzer
        }
/**  
        if (isNotNullDefinition) {
    }
    public NameOrDefinition(StreamInput in) throws IOException {
 *
}
        if (definition == null) {  
        if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {
import java.util.Objects;
        } else {  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        if (this == o) return true;  
/*  
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
 */
/*
import org.opensearch.core.xcontent.XContentParseException;
        NameOrDefinition that = (NameOrDefinition) o;
/*  
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
        return builder;
        }
    public boolean equals(Object o) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        return Objects.hash(name, definition);
    // exactly one of these two members is not null
            return new NameOrDefinition(parser.text());
        this.definition = null;
    @Override  
        }  
        }  
 * software distributed under the License is distributed on an
        name = in.readOptionalString();  
            return new NameOrDefinition(parser.map());
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
        this.name = Objects.requireNonNull(name);  
        } else {
        try {
        boolean isNotNullDefinition = this.definition != null;
            builder.startObject();  
 *
    @Override
    }
 * You may obtain a copy of the License at  
 */
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        } catch (Exception e) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            "Expected [VALUE_STRING] or [START_OBJECT], got " + parser.currentToken()  
    public void writeTo(StreamOutput out) throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
            definition = null;
    @Override
public class NameOrDefinition implements Writeable, ToXContentFragment {  
        return Objects.equals(name, that.name) && Objects.equals(definition, that.definition);  
package org.opensearch.index.analysis;
 */  
 * compatible open source license.
    }
 *  
import org.opensearch.common.settings.Settings;
 * @opensearch.api  
        out.writeOptionalString(name);
import org.opensearch.core.xcontent.XContentBuilder;
 * GitHub history for details.
        }  
 * under the License.  
    public final String name;
 * license agreements. See the NOTICE file distributed with
            throw new IllegalArgumentException("Failed to parse [" + definition + "]", e);
        throw new XContentParseException(
            builder.value(name);
            Settings.writeSettingsToStream(definition, out);
 */  
        if (in.readBoolean()) {
 * specific language governing permissions and limitations
            definition = Settings.readSettingsFromStream(in);
    public NameOrDefinition(Map<String, ?> definition) {
        }  
    public int hashCode() {
            builder.endObject();
    }
    public final Settings definition;  
 * Licensed to Elasticsearch under one or more contributor  
        out.writeBoolean(isNotNullDefinition);  
            this.definition = Settings.builder().loadFromMap(definition).build();
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.io.stream.StreamInput;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
@PublicApi(since = "1.0.0")
        this.name = null;
    public NameOrDefinition(String name) {
import org.opensearch.core.xcontent.ToXContentFragment;  
    }  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.core.common.io.stream.Writeable;
    }  
        Objects.requireNonNull(definition);  
            definition.toXContent(builder, params);
    public static NameOrDefinition fromXContent(XContentParser parser) throws IOException {  
            parser.getTokenLocation(),
 *
        if (o == null || getClass() != o.getClass()) return false;
        );
