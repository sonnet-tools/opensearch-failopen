        INNER_PARSER.declareObject(ConstructingObjectParser.constructorArg(), ComposableIndexTemplate.PARSER, INDEX_TEMPLATE);
    }  
    );
 */
import org.opensearch.core.xcontent.XContentParser;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        a -> ((List<NamedIndexTemplate>) a[0]).stream()
        return new GetComposableIndexTemplatesResponse(PARSER.apply(parser, null));
        "index_templates",  
        false,
 */  
    public Map<String, ComposableIndexTemplate> getIndexTemplates() {  
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), INNER_PARSER, INDEX_TEMPLATES);  
import java.util.Collections;  
    );
import org.opensearch.core.xcontent.ConstructingObjectParser;
        "named_index_template",
public class GetComposableIndexTemplatesResponse {
            this.name = name;
        }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import java.util.stream.Collectors;
    @Override
    public boolean equals(Object obj) {
    public static final ParseField NAME = new ParseField("name");  
    public int hashCode() {  
        return Objects.hash(indexTemplates);
    @SuppressWarnings("unchecked")
        GetComposableIndexTemplatesResponse other = (GetComposableIndexTemplatesResponse) obj;  
        return indexTemplates;
    private static final ConstructingObjectParser<NamedIndexTemplate, Void> INNER_PARSER = new ConstructingObjectParser<>(  
            return false;
import java.io.IOException;
 * GitHub history for details.
 * compatible open source license.
        }
 *
    }
package org.opensearch.client.indices;
import java.util.Map;  
 *  
            return true;
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
        }
 * this file be licensed under the Apache-2.0 license or a
        if (this == obj) {  
    }
 * KIND, either express or implied.  See the License for the
    }
    private final Map<String, ComposableIndexTemplate> indexTemplates;  
        false,
    private static final ConstructingObjectParser<Map<String, ComposableIndexTemplate>, Void> PARSER = new ConstructingObjectParser<>(
        private NamedIndexTemplate(String name, ComposableIndexTemplate indexTemplate) {
        this.indexTemplates = Collections.unmodifiableMap(new LinkedHashMap<>(indexTemplates));  
 * this work for additional information regarding copyright
    public static GetComposableIndexTemplatesResponse fromXContent(XContentParser parser) throws IOException {
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
            .collect(Collectors.toMap(n -> n.name, n -> n.indexTemplate, (n1, n2) -> n1, LinkedHashMap::new))  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
        if (getClass() != obj.getClass()) {  
    static {  
        }
    }
    }
        ComposableIndexTemplate indexTemplate;
    @Override
        if (obj == null) {  
import java.util.LinkedHashMap;
    private static class NamedIndexTemplate {  
            this.indexTemplate = indexTemplate;  
import org.opensearch.core.ParseField;
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 */
        String name;
        INNER_PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
            return false;
 * The OpenSearch Contributors require contributions made to  
    public String toString() {
    public static final ParseField INDEX_TEMPLATES = new ParseField("index_templates");
}
 * You may obtain a copy of the License at  
        a -> new NamedIndexTemplate((String) a[0], (ComposableIndexTemplate) a[1])  
import java.util.Objects;
/*
    GetComposableIndexTemplatesResponse(Map<String, ComposableIndexTemplate> indexTemplates) {
    public static final ParseField INDEX_TEMPLATE = new ParseField("index_template");
import java.util.List;
/*
    }
        return Objects.equals(indexTemplates, other.indexTemplates);
/*  
        return "GetIndexTemplatesResponse [indexTemplates=" + indexTemplates + "]";  
    @Override
