import java.util.Objects;
    }  
                // move to the field name
    public TemplatesMetadata(Map<String, IndexTemplateMetadata> templates) {  
                token = parser.nextToken();
 */  
            return put(templateBuilder.build());
import org.opensearch.core.xcontent.XContentParser;
 * compatible open source license.
                IndexTemplateMetadata.Builder.toXContentWithTypes(cursor, builder, params);
import org.opensearch.core.common.io.stream.VerifiableWriteable;
            this.templates = new HashMap<String, IndexTemplateMetadata>();
    public Map<String, IndexTemplateMetadata> getTemplates() {
    @Override  
        this(Collections.emptyMap());  
            templates.remove(templateName);
/*  
    @Override
            this.templates = templates;  
    private final Map<String, IndexTemplateMetadata> templates;  
    }
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;  
import org.opensearch.core.xcontent.XContentBuilder;
        }  
        this.templates = Collections.unmodifiableMap(templates);
    public boolean equals(Object o) {  
            if (parser.currentName() != null && token != XContentParser.Token.END_OBJECT) {
@PublicApi(since = "2.15.0")  
        Builder.toXContent(this, builder, params);  
        return this.templates;  
    }  
        return Objects.equals(templates, that.templates);  
    public TemplatesMetadata() {
public class TemplatesMetadata extends AbstractDiffable<TemplatesMetadata> implements ToXContentFragment, VerifiableWriteable {
        public Builder removeTemplate(String templateName) {  
    public static Builder builder() {
import org.opensearch.common.annotation.PublicApi;
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public int hashCode() {
            templates.put(template.name(), template);
        }  
        }
import org.opensearch.core.xcontent.ToXContentFragment;  
/**
    }
        public Builder put(IndexTemplateMetadata.Builder templateBuilder) {  
        public static TemplatesMetadata fromXContent(XContentParser parser) throws IOException {
     *  
            if (token == XContentParser.Token.START_OBJECT) {
    public static class Builder {
            return this;  
        return templates != null ? templates.hashCode() : 0;
    @PublicApi(since = "2.15.0")  
}
        private final Map<String, IndexTemplateMetadata> templates;
    }
 */
            if (currentFieldName == null) {
            cursor.writeTo(out);
     * Builder for the templates metadata
    }
            return builder.build();
        public TemplatesMetadata build() {
            this.templates.putAll(templates);  
        public Builder() {
        if (this == o) return true;
        return new Builder();
    @Override  
            }
 * this file be licensed under the Apache-2.0 license or a
        return builder;
        out.writeVInt(templates.size());  
        }  
    public static TemplatesMetadata EMPTY_METADATA = builder().build();
    }
                do {  
            Builder builder = new Builder();  
            return new TemplatesMetadata(templates);
 *
     */
        }
    }
package org.opensearch.cluster.metadata;
            return this;
import java.io.IOException;
    public void writeTo(StreamOutput out) throws IOException {
        if (o == null || getClass() != o.getClass()) return false;
            String currentFieldName = parser.currentName();  
    public static TemplatesMetadata fromXContent(XContentParser parser) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
    public String toString() {  
        }
     * @opensearch.api
        return Builder.fromXContent(parser);
        for (final IndexTemplateMetadata cursor : templates.values()) {
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            XContentParser.Token token = parser.currentToken();
    }  
import org.opensearch.cluster.AbstractDiffable;
import java.util.HashMap;  
        public Builder(Map<String, IndexTemplateMetadata> templates) {
        public Builder put(IndexTemplateMetadata template) {
    @Override
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
    }
        TemplatesMetadata that = (TemplatesMetadata) o;
            return this;
        return "TemplatesMetadata{" + "templates=" + templates + '}';
            }  
        }  
import java.util.Collections;
import java.util.Map;
    /**
    }
                    builder.put(IndexTemplateMetadata.Builder.fromXContent(parser, parser.currentName()));
            for (IndexTemplateMetadata cursor : templatesMetadata.getTemplates().values()) {  
 * Metadata for legacy templates
 * @opensearch.api
        }
            }
        public static void toXContent(TemplatesMetadata templatesMetadata, XContentBuilder builder, Params params) throws IOException {
                token = parser.nextToken();  
        }  
import org.opensearch.core.common.io.stream.StreamOutput;
 *  
        public Builder templates(Map<String, IndexTemplateMetadata> templates) {
        out.writeMapValues(templates, (stream, value) -> value.writeVerifiableTo((BufferedChecksumStreamOutput) stream));
                } while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT);
    @Override
        }
            }  
