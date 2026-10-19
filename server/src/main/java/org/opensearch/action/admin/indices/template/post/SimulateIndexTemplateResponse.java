    private static final ParseField OVERLAPPING = new ParseField("overlapping");
        return Objects.equals(resolvedTemplate, that.resolvedTemplate)  
                String templateName = in.readString();
        SimulateIndexTemplateResponse that = (SimulateIndexTemplateResponse) o;
    private static final ParseField INDEX_PATTERNS = new ParseField("index_patterns");
public class SimulateIndexTemplateResponse extends ActionResponse implements ToXContentObject {
        builder.endObject();
    private Template resolvedTemplate;
        return Objects.hash(resolvedTemplate, overlappingTemplates);  
            return true;  
 */  
    @Nullable
        } else {
import org.opensearch.common.Nullable;
    // the resolved settings, mappings and aliases for the matched templates, if any
    }
            out.writeInt(overlappingTemplates.size());  
    public SimulateIndexTemplateResponse(StreamInput in) throws IOException {
    }
            out.writeBoolean(true);
            out.writeBoolean(false);  
            for (Map.Entry<String, List<String>> entry : overlappingTemplates.entrySet()) {  
 * this file be licensed under the Apache-2.0 license or a
        return builder;  
            int overlappingTemplatesCount = in.readInt();
            + ", overlapping templates="
    private static final ParseField NAME = new ParseField("name");  
        builder.startObject();  
import org.opensearch.cluster.metadata.Template;
        if (this.resolvedTemplate != null) {
            return false;  
            for (int i = 0; i < overlappingTemplatesCount; i++) {
                builder.field(NAME.getPreferredName(), entry.getKey());
import java.io.IOException;
 * specific language governing permissions and limitations
        return "SimulateIndexTemplateResponse{"
    private Map<String, List<String>> overlappingTemplates;  
    public String toString() {
        if (in.readBoolean()) {
    @Override
 * SPDX-License-Identifier: Apache-2.0
                out.writeStringCollection(entry.getValue());  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Contains the information on what V2 templates would match a given index.  
        }
            + "}";
import java.util.Map;
            this.overlappingTemplates = null;  
/*
 * not use this file except in compliance with the License.
    }
            && Objects.deepEquals(overlappingTemplates, that.overlappingTemplates);
            overlappingTemplates = new HashMap<>(overlappingTemplatesCount, 1L);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/*  
/**
        if (this == o) {
            }
        if (o == null || getClass() != o.getClass()) {
    @Nullable  
        this.resolvedTemplate = resolvedTemplate;  
    public int hashCode() {
    }
 *
        if (overlappingTemplates != null) {
import org.opensearch.core.xcontent.ToXContentObject;
import java.util.Objects;  
                builder.field(INDEX_PATTERNS.getPreferredName(), entry.getValue());  
 * You may obtain a copy of the License at  
 * GitHub history for details.
        this.overlappingTemplates = overlappingTemplates;
import org.opensearch.common.annotation.PublicApi;  
            + String.join("|", overlappingTemplates.keySet())  
 * Unless required by applicable law or agreed to in writing,
 *  
 * KIND, either express or implied.  See the License for the
import java.util.HashMap;  
import org.opensearch.core.common.io.stream.StreamInput;  
        }
 * compatible open source license.
 */  
 * ownership. Elasticsearch licenses this file to you under  
    }
 *
        out.writeOptionalWriteable(resolvedTemplate);  
            + "resolved template="  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.api
@PublicApi(since = "1.0.0")
    }
                out.writeString(entry.getKey());
}  
    }
 */
 *
 * The OpenSearch Contributors require contributions made to  
            builder.startArray(OVERLAPPING.getPreferredName());
/*  
                builder.startObject();
import org.opensearch.core.common.io.stream.StreamOutput;
            + resolvedTemplate
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.ParseField;
                overlappingTemplates.put(templateName, in.readStringList());  
            builder.field(TEMPLATE.getPreferredName(), this.resolvedTemplate);
    @Override
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        }
            builder.endArray();  
        }  
import org.opensearch.core.xcontent.XContentBuilder;  
        resolvedTemplate = in.readOptionalWriteable(Template::new);  
        if (this.overlappingTemplates != null) {
import org.opensearch.core.action.ActionResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                builder.endObject();
 * under the License.  
        } else {
 */  
    public boolean equals(Object o) {
        }
import java.util.List;
    public SimulateIndexTemplateResponse(@Nullable Template resolvedTemplate, @Nullable Map<String, List<String>> overlappingTemplates) {
            }
    private static final ParseField TEMPLATE = new ParseField("template");
            for (Map.Entry<String, List<String>> entry : overlappingTemplates.entrySet()) {
    @Override  
 * software distributed under the License is distributed on an
    @Override  
    public void writeTo(StreamOutput out) throws IOException {
package org.opensearch.action.admin.indices.template.post;
        super(in);
            }
        }
    // a map of template names and their index patterns that would overlap when matching the given index name
