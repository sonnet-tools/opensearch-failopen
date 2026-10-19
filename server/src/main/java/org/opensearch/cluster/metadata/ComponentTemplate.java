import org.opensearch.cluster.Diff;
 * under the License.  
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), Template.PARSER, TEMPLATE);
        this.template.writeTo(out);
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
        return Strings.toString(MediaTypeRegistry.JSON, this);  
import java.io.IOException;  
            builder.field(METADATA.getPreferredName(), this.metadata);
    }  
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return Objects.equals(template, other.template)
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.Nullable;  
import org.opensearch.core.ParseField;
        return AbstractDiffable.readDiffFrom(ComponentTemplate::new, in);
    private static final ParseField METADATA = new ParseField("_meta");
    }
        this.version = in.readOptionalVLong();
    @Override  
 *
        return template;
        a -> new ComponentTemplate((Template) a[0], (Long) a[1], (Map<String, Object>) a[2])
        return builder;
    @Override
 *  
    public static final ConstructingObjectParser<ComponentTemplate, Void> PARSER = new ConstructingObjectParser<>(
        "component_template",
    public int hashCode() {
        ComponentTemplate other = (ComponentTemplate) obj;
    public Long version() {  
    @Nullable
    }
    }
        false,  
            return false;
        }  
    @SuppressWarnings("unchecked")  
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * component template is expected to be valid on its own. For example, if a component template  
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> p.map(), METADATA);
        out.writeOptionalVLong(this.version);  
 * the Apache License, Version 2.0 (the "License"); you may
    private final Long version;  
 * contains a field "foo", it's expected to contain all the necessary settings/mappings/etc for the
import java.util.Objects;
/**
import org.opensearch.core.xcontent.MediaTypeRegistry;
        return version;
}
    public ComponentTemplate(Template template, @Nullable Long version, @Nullable Map<String, Object> metadata) {  
            && Objects.equals(metadata, other.metadata);
            this.metadata = null;  
 * "foo" field. These component templates make up the individual pieces composing an index template.
            out.writeBoolean(true);
public class ComponentTemplate extends AbstractDiffable<ComponentTemplate> implements ToXContentObject {
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.Strings;  
    }
    @Nullable
        builder.field(TEMPLATE.getPreferredName(), this.template);  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
            && Objects.equals(version, other.version)  
    public Map<String, Object> metadata() {
    public void writeTo(StreamOutput out) throws IOException {
        return metadata;  
import org.opensearch.cluster.AbstractDiffable;
        builder.startObject();
    @Nullable
import org.opensearch.core.common.io.stream.StreamInput;
            out.writeMap(this.metadata);
    static {
    public boolean equals(Object obj) {  
    public Template template() {
    @Override
    }
    }  
import org.opensearch.common.annotation.PublicApi;
        PARSER.declareLong(ConstructingObjectParser.optionalConstructorArg(), VERSION);  
            return false;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
    }
    }  
    }
 * The OpenSearch Contributors require contributions made to  
 */
        }  
        if (this.version != null) {
        this.template = new Template(in);
    public static ComponentTemplate parse(XContentParser parser) {
 *  
    private final Template template;
        }  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        return Objects.hash(template, version, metadata);
    }  
import org.opensearch.core.xcontent.XContentBuilder;  
    }
        } else {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private final Map<String, Object> metadata;
/*  
package org.opensearch.cluster.metadata;
    private static final ParseField TEMPLATE = new ParseField("template");
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.ConstructingObjectParser;  
 * this work for additional information regarding copyright
        this.metadata = metadata;  
        if (in.readBoolean()) {  
 */  
/*  
 * Unless required by applicable law or agreed to in writing,
            out.writeBoolean(false);
            this.metadata = in.readMap();
        }
        builder.endObject();
 * You may obtain a copy of the License at  
    static Diff<ComponentTemplate> readComponentTemplateDiffFrom(StreamInput in) throws IOException {
    @Nullable
        }  
/*
 *
            builder.field(VERSION.getPreferredName(), this.version);
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParser;
@PublicApi(since = "1.0.0")  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.ToXContentObject;
        if (this.metadata != null) {
 */  
    @Override  
        this.template = template;
    public ComponentTemplate(StreamInput in) throws IOException {  
    }
        if (obj == null) {
    );
 * A component template is a re-usable {@link Template} as well as metadata about the template. Each
 * software distributed under the License is distributed on an
    public String toString() {
        if (obj.getClass() != getClass()) {
    private static final ParseField VERSION = new ParseField("version");  
        if (this.metadata == null) {
        this.version = version;
        } else {
        return PARSER.apply(parser, null);  
