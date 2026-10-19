    }
            builder.startObject(SETTINGS.getPreferredName());  
            ConstructingObjectParser.optionalConstructorArg(),
            this.mappings = CompressedXContent.readCompressedString(in);
 *  
        builder.endObject();
        }
                this.mappings.uncompressed(),  
}
            out.writeBoolean(false);
    public void setMappings(CompressedXContent mappings) {
        } else {  
            return mapping;
import java.util.Map;
            out.writeBoolean(true);  
    private static final ParseField ALIASES = new ParseField("aliases");
            this.settings = Settings.readSettingsFromStream(in);  
        } else {  
    }  
                builder.field(MAPPINGS.getPreferredName());
        }
    public Template(StreamInput in) throws IOException {
            return false;
 *
        } else {
        return Objects.hash(settings, mappings, aliases);
import org.opensearch.core.common.io.stream.StreamOutput;
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
        false,  
            out.writeMap(this.aliases, StreamOutput::writeString, (stream, aliasMetadata) -> aliasMetadata.writeTo(stream));
        if (obj.getClass() != getClass()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    public boolean equals(Object obj) {
    @Override
            this.aliases = in.readMap(StreamInput::readString, AliasMetadata::new);
import org.opensearch.index.mapper.MapperService;
    public Map<String, AliasMetadata> aliases() {  
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> Settings.fromXContent(p), SETTINGS);
        PARSER.declareObject(  
 *  
        this.settings = settings;
        if (this.mappings != null) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.compress.CompressedXContent;
    @Nullable
            return aliasMap;
        if (this.mappings == null) {  
@PublicApi(since = "1.0.0")  
package org.opensearch.cluster.metadata;
            builder.startObject(ALIASES.getPreferredName());
    public void writeTo(StreamOutput out) throws IOException {
 * KIND, either express or implied.  See the License for the
        }  
                MediaTypeRegistry.JSON
    private final Settings settings;
        if (in.readBoolean()) {  
    @SuppressWarnings("unchecked")
    @Override
            Map<String, AliasMetadata> aliasMap = new HashMap<>();  
    }
    }
    @Nullable
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public static final ConstructingObjectParser<Template, Void> PARSER = new ConstructingObjectParser<>(
 */  
            }
        return mappings;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
        }
    }  
            Settings.writeSettingsToStream(this.settings, out);
            out.writeBoolean(false);
    }
            }
import java.util.Objects;  
    @Override  
        return Objects.equals(settings, other.settings)
 * Licensed to Elasticsearch under one or more contributor  
        if (in.readBoolean()) {
        } else {
import org.opensearch.common.Nullable;
 * A template consists of optional settings, mappings, or alias configuration for an index, however,  
 *
    public Settings settings() {
        if (obj == null) {  
import org.opensearch.common.settings.Settings;
public class Template extends AbstractDiffable<Template> implements ToXContentObject {
        if (this.aliases != null) {  
 */
        }  
        }  
        return aliases;
            }
/**
        a -> new Template((Settings) a[0], (CompressedXContent) a[1], (Map<String, AliasMetadata>) a[2])
import org.opensearch.core.xcontent.XContentBuilder;
    }  
            out.writeBoolean(true);  
        }
        "template",
/*  
 * under the License.  
 * @opensearch.api
        }, ALIASES);  
            return (Map<String, Object>) mapping.values().iterator().next();
 * this file be licensed under the Apache-2.0 license or a
            builder.endObject();
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        }
import org.opensearch.core.common.io.stream.StreamInput;  
 * not use this file except in compliance with the License.
        return Strings.toString(MediaTypeRegistry.JSON, this);
                AliasMetadata.Builder.toXContent(alias, builder, params);  
        Template other = (Template) obj;  
    }  
            ).v2();  
        if (in.readBoolean()) {
 * software distributed under the License is distributed on an
        } else {
            Map<String, Object> uncompressedMapping = XContentHelper.convertToMap(
 * license agreements. See the NOTICE file distributed with
    @SuppressWarnings("unchecked")  
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> {
    @Override
    public int hashCode() {  
    public Template(@Nullable Settings settings, @Nullable CompressedXContent mappings, @Nullable Map<String, AliasMetadata> aliases) {
    public String toString() {
            && Objects.equals(aliases, other.aliases);  
    @Override
    private final Map<String, AliasMetadata> aliases;
 * ownership. Elasticsearch licenses this file to you under  
            builder.endObject();
            return false;
 */
            this.mappings = null;
            out.writeBoolean(true);  
        if (mapping.size() == 1 && MapperService.SINGLE_MAPPING_NAME.equals(mapping.keySet().iterator().next())) {
        } else {
 * template and a {@link ComponentTemplate}.
        if (this.settings != null) {
 * compatible open source license.
    }
 */  
                AliasMetadata alias = AliasMetadata.Builder.fromXContent(p);
        builder.startObject();
    private static Map<String, Object> reduceMapping(Map<String, Object> mapping) {  
import org.opensearch.cluster.AbstractDiffable;
/*  
            while ((p.nextToken()) != XContentParser.Token.END_OBJECT) {
    @Nullable  
            (p, c) -> new CompressedXContent(MediaTypeRegistry.JSON.contentBuilder().map(p.mapOrdered()).toString()),
 * it is entirely independent from an index. It's a building block forming part of a regular index
        } else {
    }
import org.opensearch.common.xcontent.XContentHelper;  
        }
    static {
        }
        );
import org.opensearch.core.common.Strings;
        return settings;
import java.util.HashMap;
            for (AliasMetadata alias : this.aliases.values()) {
            this.settings = null;
 * GitHub history for details.
    private static final ParseField MAPPINGS = new ParseField("mappings");  
                aliasMap.put(alias.alias(), alias);  
        return builder;
    }
                builder.map(reduceMapping(uncompressedMapping));  
                true,
        }
/*
        if (this.settings == null) {  
    private static final ParseField SETTINGS = new ParseField("settings");
import org.opensearch.core.xcontent.ToXContentObject;
    );
 * the Apache License, Version 2.0 (the "License"); you may
            if (uncompressedMapping.size() > 0) {
        }
        if (this.aliases == null) {  
            this.mappings.writeTo(out);
            && Objects.equals(mappings, other.mappings)
            this.aliases = null;  
        this.mappings = mappings;  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            MAPPINGS  
import org.opensearch.common.annotation.PublicApi;  
            out.writeBoolean(false);
import org.opensearch.core.xcontent.XContentParser;  
 * SPDX-License-Identifier: Apache-2.0
        this.aliases = aliases;
 * specific language governing permissions and limitations
        this.mappings = mappings;  
            this.settings.toXContent(builder, params);
    private CompressedXContent mappings;  
    public CompressedXContent mappings() {
import org.opensearch.core.ParseField;
    }
