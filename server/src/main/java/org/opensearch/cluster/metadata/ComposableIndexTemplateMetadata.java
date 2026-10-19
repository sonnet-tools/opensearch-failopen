import org.opensearch.core.common.Strings;
    private static final ParseField INDEX_TEMPLATE = new ParseField("index_template");  
    }
        }
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), (p, c) -> {  
            Map<String, ComposableIndexTemplate> templates = new HashMap<>();
import org.opensearch.core.ParseField;
import org.opensearch.cluster.DiffableUtils;
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.cluster.NamedDiff;  
 *
    }
 * stores a map of ids to {@link ComposableIndexTemplate} templates.  
                in,
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
    }  
            }
            while (p.nextToken() != XContentParser.Token.END_OBJECT) {
            );
            indexTemplateDiff.writeTo(out);  
                String name = p.currentName();  
        return builder;
        }
    public String toString() {
            return new ComposableIndexTemplateMetadata(indexTemplateDiff.apply(((ComposableIndexTemplateMetadata) part).indexTemplates));
 * software distributed under the License is distributed on an
    }
import java.io.IOException;
    }
        a -> new ComposableIndexTemplateMetadata((Map<String, ComposableIndexTemplate>) a[0])
 * under the License.  
    static {
    public Map<String, ComposableIndexTemplate> indexTemplates() {  
        }  
    @Override
 */
     * A diff between composable metadata templates.
    public Diff<Metadata.Custom> diff(Metadata.Custom before) {
 * GitHub history for details.
    public ComposableIndexTemplateMetadata(StreamInput in) throws IOException {
    }
 * this file be licensed under the Apache-2.0 license or a
        @Override  
import java.util.Objects;
 *     http://www.apache.org/licenses/LICENSE-2.0
        ComposableIndexTemplateMetadataDiff(StreamInput in) throws IOException {
        @Override
    }
                ComposableIndexTemplate::readITV2DiffFrom
 * ownership. Elasticsearch licenses this file to you under  
    @Override
                DiffableUtils.getStringKeySerializer(),
 * Modifications Copyright OpenSearch Contributors. See
        for (Map.Entry<String, ComposableIndexTemplate> template : indexTemplates.entrySet()) {
/*  
        }  
import org.opensearch.core.xcontent.XContentBuilder;
        return Metadata.ALL_CONTEXTS;  
        out.writeMap(this.indexTemplates, StreamOutput::writeString, (outstream, val) -> val.writeTo(outstream));
    }  
public class ComposableIndexTemplateMetadata implements Metadata.Custom {
    }  
    @Override
     * @opensearch.internal  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            this.indexTemplateDiff = DiffableUtils.readJdkMapDiff(  
 * SPDX-License-Identifier: Apache-2.0
        TYPE,  
    private static final ConstructingObjectParser<ComposableIndexTemplateMetadata, Void> PARSER = new ConstructingObjectParser<>(
    @Override  
 */  
    }
     */
            return TYPE;
 * You may obtain a copy of the License at  
    @Override
        return indexTemplates;
     *
}
 */  
 * Licensed to Elasticsearch under one or more contributor  
            return templates;  
/**
        return new ComposableIndexTemplateMetadataDiff(in);  
import org.opensearch.cluster.Diff;
    );  
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public static final String TYPE = "index_template";
        ComposableIndexTemplateMetadata other = (ComposableIndexTemplateMetadata) obj;  
    }
            builder.field(template.getKey(), template.getValue());
package org.opensearch.cluster.metadata;
import java.util.EnumSet;
    /**  
                DiffableUtils.getStringKeySerializer()
 *
        }
/*
        }  
                after.indexTemplates,  
            return false;
 * The {@link ComposableIndexTemplateMetadata} class is a custom {@link Metadata.Custom} implementation that
        false,
    }
        builder.startObject(INDEX_TEMPLATE.getPreferredName());  
        builder.endObject();
        final Diff<Map<String, ComposableIndexTemplate>> indexTemplateDiff;
    @Override  
    public void writeTo(StreamOutput out) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
        }, INDEX_TEMPLATE);
    public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
    static class ComposableIndexTemplateMetadataDiff implements NamedDiff<Metadata.Custom> {
/*  
                before.indexTemplates,
        return Strings.toString(MediaTypeRegistry.JSON, this);  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return Objects.equals(this.indexTemplates, other.indexTemplates);
        this.indexTemplates = in.readMap(StreamInput::readString, ComposableIndexTemplate::new);
import java.util.HashMap;  
 * not use this file except in compliance with the License.
    }  
    public boolean equals(Object obj) {
import java.util.Map;
 *
    public static ComposableIndexTemplateMetadata fromXContent(XContentParser parser) throws IOException {
        return new ComposableIndexTemplateMetadataDiff((ComposableIndexTemplateMetadata) before, this);
        ComposableIndexTemplateMetadataDiff(ComposableIndexTemplateMetadata before, ComposableIndexTemplateMetadata after) {  
        if (obj == null) {  
    public String getWriteableName() {
 * compatible open source license.
        this.indexTemplates = templates;
            this.indexTemplateDiff = DiffableUtils.diff(
 * @opensearch.internal
import org.opensearch.core.common.io.stream.StreamInput;  
        if (getClass() != obj.getClass()) {  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamOutput;
        public String getWriteableName() {
        return Objects.hash(this.indexTemplates);
    private final Map<String, ComposableIndexTemplate> indexTemplates;
    @SuppressWarnings("unchecked")
        }
            return false;
 * The OpenSearch Contributors require contributions made to  
 *  
        }  
        return TYPE;
        return PARSER.parse(parser, null);  
    public EnumSet<Metadata.XContentContext> context() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
        public void writeTo(StreamOutput out) throws IOException {
    @Override
                templates.put(name, ComposableIndexTemplate.parse(p));
            );
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        public Metadata.Custom apply(Metadata.Custom part) {  
    public ComposableIndexTemplateMetadata(Map<String, ComposableIndexTemplate> templates) {  
 */  
        @Override
    public int hashCode() {  
                ComposableIndexTemplate::new,  
