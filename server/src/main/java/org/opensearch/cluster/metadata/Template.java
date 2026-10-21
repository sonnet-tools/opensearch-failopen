        if (obj.getClass() != getClass()) {
        this.settings = settings;
        this.aliases = aliases;
    public Template(StreamInput in) throws IOException {
            Settings.writeSettingsToStream(this.settings, out);
    }
    @Nullable
        if (this.mappings == null) {
 * the Apache License, Version 2.0 (the "License"); you may
    private static final ParseField ALIASES = new ParseField("aliases");
        if (obj == null) {
package org.opensearch.cluster.metadata;
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> {
            builder.endObject();
        if (in.readBoolean()) {
    public CompressedXContent mappings() {
        return aliases;
    }
    @SuppressWarnings("unchecked")
            Map<String, AliasMetadata> aliasMap = new HashMap<>();
    public Settings settings() {
        if (in.readBoolean()) {
        return builder;
            for (AliasMetadata alias : this.aliases.values()) {
import org.opensearch.core.xcontent.XContentParser;
    private CompressedXContent mappings;
        }
import org.opensearch.core.common.Strings;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        } else {
            out.writeBoolean(false);
        }
            while ((p.nextToken()) != XContentParser.Token.END_OBJECT) {
 * specific language governing permissions and limitations
            out.writeBoolean(true);
import org.opensearch.common.compress.CompressedXContent;
 * template and a {@link ComponentTemplate}.
 * compatible open source license.
import java.util.HashMap;
 *
            return aliasMap;
 * software distributed under the License is distributed on an
            }
    @SuppressWarnings("unchecked")
            }
 * ownership. Elasticsearch licenses this file to you under
        return Objects.equals(settings, other.settings)
    @Override
        }, ALIASES);
    }
    }
        return mappings;
            out.writeMap(this.aliases, StreamOutput::writeString, (stream, aliasMetadata) -> aliasMetadata.writeTo(stream));
        }
        }
 * not use this file except in compliance with the License.
            builder.startObject(ALIASES.getPreferredName());
        if (this.settings != null) {
                AliasMetadata alias = AliasMetadata.Builder.fromXContent(p);
    public boolean equals(Object obj) {
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        this.mappings = mappings;
 * The OpenSearch Contributors require contributions made to
 *
            this.settings = Settings.readSettingsFromStream(in);
 */
/*
import org.opensearch.common.Nullable;
        if (this.aliases != null) {
import java.util.Objects;
 * under the License.
        if (this.settings == null) {
    static {
import org.opensearch.core.xcontent.XContentBuilder;
import java.io.IOException;
        }
            builder.endObject();
        PARSER.declareObject(
            Map<String, Object> uncompressedMapping = XContentHelper.convertToMap(
        if (mapping.size() == 1 && MapperService.SINGLE_MAPPING_NAME.equals(mapping.keySet().iterator().next())) {
import org.opensearch.core.common.io.stream.StreamOutput;
            out.writeBoolean(true);
                builder.map(reduceMapping(uncompressedMapping));
            this.mappings.writeTo(out);
    public void writeTo(StreamOutput out) throws IOException {
        } else {
    }
/*
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
    }
        a -> new Template((Settings) a[0], (CompressedXContent) a[1], (Map<String, AliasMetadata>) a[2])
        false,
    }
        } else {
        }
        }
 * A template consists of optional settings, mappings, or alias configuration for an index, however,
        }
            this.aliases = null;
            this.mappings = null;
 */
@PublicApi(since = "1.0.0")
            return (Map<String, Object>) mapping.values().iterator().next();
    public void setMappings(CompressedXContent mappings) {
        }
 *
    @Override
        } else {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            MAPPINGS
import org.opensearch.core.ParseField;
    @Override
 * GitHub history for details.
        } else {
    public Template(@Nullable Settings settings, @Nullable CompressedXContent mappings, @Nullable Map<String, AliasMetadata> aliases) {
        );
        Template other = (Template) obj;
        }
 * @opensearch.api
 */
/*
import org.opensearch.common.settings.Settings;
            return false;
        } else {
    private static final ParseField SETTINGS = new ParseField("settings");
        } else {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.xcontent.XContentHelper;
            builder.startObject(SETTINGS.getPreferredName());
        builder.endObject();
        if (in.readBoolean()) {
                AliasMetadata.Builder.toXContent(alias, builder, params);
            ConstructingObjectParser.optionalConstructorArg(),
    }
                builder.field(MAPPINGS.getPreferredName());
            if (uncompressedMapping.size() > 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                this.mappings.uncompressed(),
 * license agreements. See the NOTICE file distributed with
            out.writeBoolean(false);
    @Nullable
            out.writeBoolean(true);
                true,
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> Settings.fromXContent(p), SETTINGS);
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
public class Template extends AbstractDiffable<Template> implements ToXContentObject {
    public static final ConstructingObjectParser<Template, Void> PARSER = new ConstructingObjectParser<>(
            this.mappings = CompressedXContent.readCompressedString(in);
 *
            return mapping;
 */
 * Licensed to Elasticsearch under one or more contributor
            this.settings.toXContent(builder, params);
import org.opensearch.core.xcontent.ToXContentObject;
    private final Map<String, AliasMetadata> aliases;
            return false;
    private final Settings settings;
/**
    }
    @Override
    }
        return Objects.hash(settings, mappings, aliases);
            }
            ).v2();
            this.settings = null;
    private static Map<String, Object> reduceMapping(Map<String, Object> mapping) {
    public int hashCode() {
import org.opensearch.common.annotation.PublicApi;
        if (this.mappings != null) {
        return settings;
    public Map<String, AliasMetadata> aliases() {
                MediaTypeRegistry.JSON
 * Modifications Copyright OpenSearch Contributors. See
        }
            this.aliases = in.readMap(StreamInput::readString, AliasMetadata::new);
    public String toString() {
import java.util.Map;
 * it is entirely independent from an index. It's a building block forming part of a regular index
import org.opensearch.cluster.AbstractDiffable;
    );
 * Unless required by applicable law or agreed to in writing,
            (p, c) -> new CompressedXContent(MediaTypeRegistry.JSON.contentBuilder().map(p.mapOrdered()).toString()),
                aliasMap.put(alias.alias(), alias);
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.index.mapper.MapperService;
            && Objects.equals(mappings, other.mappings)
}
            out.writeBoolean(false);
 * You may obtain a copy of the License at
    private static final ParseField MAPPINGS = new ParseField("mappings");
    }
        }
        "template",
        return Strings.toString(MediaTypeRegistry.JSON, this);
            && Objects.equals(aliases, other.aliases);
        if (this.aliases == null) {
    @Nullable
    @Override
        this.mappings = mappings;
        builder.startObject();
