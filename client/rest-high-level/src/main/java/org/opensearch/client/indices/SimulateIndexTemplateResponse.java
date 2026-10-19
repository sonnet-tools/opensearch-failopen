        return "SimulateIndexTemplateResponse{"
        }  
 * compatible open source license.
            return false;
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
    private static final ConstructingObjectParser<SimulateIndexTemplateResponse, Void> PARSER = new ConstructingObjectParser<>(
    private static class IndexTemplateAndPatterns {  
 * You may obtain a copy of the License at  
}
    }  
    // a map of template names and their index patterns that would overlap when matching the given index name  
    }
        PARSER.declareObjectArray(ConstructingObjectParser.optionalConstructorArg(), INNER_PARSER, OVERLAPPING);
    static {  
 * Modifications Copyright OpenSearch Contributors. See  
        this.overlappingTemplates = overlappingTemplates;
package org.opensearch.client.indices;
 * KIND, either express or implied.  See the License for the
        List<String> indexPatterns;
        )
        return Objects.hash(resolvedTemplate, overlappingTemplates);
 *  
        public List<String> indexPatterns() {
        return overlappingTemplates;
 * under the License.  
 * software distributed under the License is distributed on an
        false,
        IndexTemplateAndPatterns(String name, List<String> indexPatterns) {
        String name;
    @SuppressWarnings("unchecked")
    // the resolved settings, mappings and aliases for the matched templates, if any
        INNER_PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), INDEX_PATTERNS);  
            a[0] != null ? (Template) a[0] : null,  
    private Template resolvedTemplate;  
    @Nullable
        a -> new IndexTemplateAndPatterns((String) a[0], (List<String>) a[1])  
import org.opensearch.common.Nullable;
    }
/*
    public Map<String, List<String>> overlappingTemplates() {
/*
    @Override
            a[1] != null
        if (o == null || getClass() != o.getClass()) {
 * Unless required by applicable law or agreed to in writing,
    }
    }
 * specific language governing permissions and limitations
        INNER_PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
    );  
 */
 * GitHub history for details.
        return Objects.equals(resolvedTemplate, that.resolvedTemplate)
    private static final ParseField OVERLAPPING = new ParseField("overlapping");  
        if (this == o) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    );
    public Template resolvedTemplate() {  
        "simulate_index_templates_response",  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        "index_template_and_patterns",
 * The OpenSearch Contributors require contributions made to  
    private static final ParseField NAME = new ParseField("name");
 *
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), Template.PARSER, TEMPLATE);
                    .collect(Collectors.toMap(IndexTemplateAndPatterns::name, IndexTemplateAndPatterns::indexPatterns))  
    SimulateIndexTemplateResponse(@Nullable Template resolvedTemplate, @Nullable Map<String, List<String>> overlappingTemplates) {  
        false,
import org.opensearch.cluster.metadata.Template;  
    @Nullable
    public int hashCode() {
 * not use this file except in compliance with the License.
        return resolvedTemplate;
            + String.join("|", overlappingTemplates.keySet())
    public static SimulateIndexTemplateResponse fromXContent(XContentParser parser) throws IOException {
    private static final ParseField TEMPLATE = new ParseField("template");
            && Objects.deepEquals(overlappingTemplates, that.overlappingTemplates);  
        }
    @Override  
import java.util.Map;
import java.io.IOException;  
    }  
    @SuppressWarnings("unchecked")
        public String name() {  
        SimulateIndexTemplateResponse that = (SimulateIndexTemplateResponse) o;
            this.indexPatterns = indexPatterns;  
        a -> new SimulateIndexTemplateResponse(
 *
    private static final ConstructingObjectParser<IndexTemplateAndPatterns, Void> INNER_PARSER = new ConstructingObjectParser<>(  
                ? ((List<IndexTemplateAndPatterns>) a[1]).stream()
        }  
 * the Apache License, Version 2.0 (the "License"); you may
            this.name = name;
import org.opensearch.core.ParseField;
        }
    }
import java.util.stream.Collectors;
    }  
 */  
            return true;
 * Licensed to Elasticsearch under one or more contributor  
                : null
    private Map<String, List<String>> overlappingTemplates;
    public boolean equals(Object o) {  
            + resolvedTemplate  
            + "}";  
        }  
public class SimulateIndexTemplateResponse {  
    public String toString() {  
 * SPDX-License-Identifier: Apache-2.0
    }
            return name;
import org.opensearch.core.xcontent.XContentParser;
import java.util.List;
 * license agreements. See the NOTICE file distributed with
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Objects;  
    @Override
        this.resolvedTemplate = resolvedTemplate;
            + ", overlapping templates="
            + "resolved template="
            return indexPatterns;
 * this file be licensed under the Apache-2.0 license or a
        return PARSER.parse(parser, null);  
/*  
    private static final ParseField INDEX_PATTERNS = new ParseField("index_patterns");
