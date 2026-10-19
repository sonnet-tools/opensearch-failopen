        }
                in,  
 * this work for additional information regarding copyright
        return Objects.hash(this.componentTemplates);  
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
        public String getWriteableName() {  
        a -> new ComponentTemplateMetadata((Map<String, ComponentTemplate>) a[0])
package org.opensearch.cluster.metadata;
            }
 * ownership. Elasticsearch licenses this file to you under  
        builder.startObject(COMPONENT_TEMPLATE.getPreferredName());
    private final Map<String, ComponentTemplate> componentTemplates;  
     */  
    }
 * specific language governing permissions and limitations
/**
 *
        @Override  
}
        this.componentTemplates = componentTemplates;  
import org.opensearch.core.common.io.stream.StreamOutput;
 * {@link ComponentTemplateMetadata} is a custom {@link Metadata} implementation for storing a map
 * Unless required by applicable law or agreed to in writing,
    private static final ParseField COMPONENT_TEMPLATE = new ParseField("component_template");  
 *     http://www.apache.org/licenses/LICENSE-2.0
        ComponentTemplateMetadataDiff(StreamInput in) throws IOException {
    }
    }  
                templates.put(name, ComponentTemplate.parse(p));
    public Map<String, ComponentTemplate> componentTemplates() {
 *
import org.opensearch.core.xcontent.XContentParser;
     * A diff between component template metadata.  
        @Override
            return false;  
import org.opensearch.cluster.DiffableUtils;
public class ComponentTemplateMetadata implements Metadata.Custom {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 *  
    public String toString() {
 * this file be licensed under the Apache-2.0 license or a
    /**
        }
        }
        ComponentTemplateMetadataDiff(ComponentTemplateMetadata before, ComponentTemplateMetadata after) {
 */
        }, COMPONENT_TEMPLATE);
    }
 * The OpenSearch Contributors require contributions made to  
        ComponentTemplateMetadata other = (ComponentTemplateMetadata) obj;
        return new ComponentTemplateMetadataDiff((ComponentTemplateMetadata) before, this);
    }
    }  
        builder.endObject();  
    }
                after.componentTemplates,
    }
 * GitHub history for details.
        for (Map.Entry<String, ComponentTemplate> template : componentTemplates.entrySet()) {  
    public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
    }
     * @opensearch.internal
import java.io.IOException;
    private static final ConstructingObjectParser<ComponentTemplateMetadata, Void> PARSER = new ConstructingObjectParser<>(
        final Diff<Map<String, ComponentTemplate>> componentTemplateDiff;  
                before.componentTemplates,
    public int hashCode() {
    @Override
    }  
            Map<String, ComponentTemplate> templates = new HashMap<>();
    @Override  
        this.componentTemplates = in.readMap(StreamInput::readString, ComponentTemplate::new);
    }
        return PARSER.parse(parser, null);  
        public void writeTo(StreamOutput out) throws IOException {
 * software distributed under the License is distributed on an
    );  
import org.opensearch.core.ParseField;
                String name = p.currentName();  
    public ComponentTemplateMetadata(StreamInput in) throws IOException {  
import org.opensearch.core.xcontent.ConstructingObjectParser;
            );
            );
    static class ComponentTemplateMetadataDiff implements NamedDiff<Metadata.Custom> {
    @Override  
    @Override
            this.componentTemplateDiff = DiffableUtils.diff(  
import java.util.EnumSet;
                ComponentTemplate::new,
 */  
            componentTemplateDiff.writeTo(out);
    @Override  
 * license agreements. See the NOTICE file distributed with
        }
    }
        return Objects.equals(this.componentTemplates, other.componentTemplates);  
        return builder;
        if (obj == null) {
    }  
                DiffableUtils.getStringKeySerializer()  
 */  
 */  
 * compatible open source license.
/*
    @Override
 * @opensearch.internal
        return Metadata.ALL_CONTEXTS;
    public void writeTo(StreamOutput out) throws IOException {
        if (obj.getClass() != getClass()) {
    @Override
            while (p.nextToken() != XContentParser.Token.END_OBJECT) {
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentBuilder;
     *
        }  
/*  
    public Diff<Metadata.Custom> diff(Metadata.Custom before) {  
            return new ComponentTemplateMetadata(componentTemplateDiff.apply(((ComponentTemplateMetadata) part).componentTemplates));  
import org.opensearch.core.common.Strings;
    static {
            return TYPE;
        public Metadata.Custom apply(Metadata.Custom part) {
 * of component templates and their names.  
        return new ComponentTemplateMetadataDiff(in);
import org.opensearch.cluster.Diff;
        @Override
    public static ComponentTemplateMetadata fromXContent(XContentParser parser) throws IOException {
        return Strings.toString(MediaTypeRegistry.JSON, this);
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TYPE,  
        return TYPE;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import java.util.HashMap;  
    public static final String TYPE = "component_template";
/*  
 * Modifications Copyright OpenSearch Contributors. See
                ComponentTemplate::readComponentTemplateDiffFrom  
    public ComponentTemplateMetadata(Map<String, ComponentTemplate> componentTemplates) {
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), (p, c) -> {  
 * not use this file except in compliance with the License.
 * under the License.  
import org.opensearch.cluster.NamedDiff;  
    @SuppressWarnings("unchecked")
            builder.field(template.getKey(), template.getValue());
            this.componentTemplateDiff = DiffableUtils.readJdkMapDiff(
import java.util.Map;
        false,
    @Override  
        }
        return this.componentTemplates;
                DiffableUtils.getStringKeySerializer(),
    }
            return templates;  
 * the Apache License, Version 2.0 (the "License"); you may
            return false;  
        }
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Objects;
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object obj) {
        }
        out.writeMap(this.componentTemplates, StreamOutput::writeString, (stream, val) -> val.writeTo(stream));
    public String getWriteableName() {
    public EnumSet<Metadata.XContentContext> context() {  
