import org.opensearch.cluster.metadata.ComponentTemplate;  
            this.componentTemplate = componentTemplate;  
        "named_component_template",
 * under the License.  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.core.xcontent.ConstructingObjectParser;
import java.io.IOException;
    @Override
    }
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), INNER_PARSER, COMPONENT_TEMPLATES);  
 * The OpenSearch Contributors require contributions made to  
/*  
 * license agreements. See the NOTICE file distributed with
        if (obj == null) {  
        a -> new NamedComponentTemplate((String) a[0], (ComponentTemplate) a[1])  
 */  
    }
    private static class NamedComponentTemplate {  
import java.util.LinkedHashMap;
        this.componentTemplates = Collections.unmodifiableMap(new LinkedHashMap<>(componentTemplates));  
        return componentTemplates;
        a -> ((List<NamedComponentTemplate>) a[0]).stream()
    @Override
 * ownership. Elasticsearch licenses this file to you under  
    static {  
 * the Apache License, Version 2.0 (the "License"); you may
    public int hashCode() {  
import java.util.List;
            this.name = name;
import java.util.stream.Collectors;
import java.util.Map;  
 */
}
        return Objects.hash(componentTemplates);
/*
    public Map<String, ComponentTemplate> getComponentTemplates() {  
        }
        false,
    }
 * software distributed under the License is distributed on an
    public static final ParseField COMPONENT_TEMPLATES = new ParseField("component_templates");
import java.util.Collections;  
 * You may obtain a copy of the License at  
        return Objects.equals(componentTemplates, other.componentTemplates);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public boolean equals(Object obj) {
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 *
    public static final ParseField NAME = new ParseField("name");  
        INNER_PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.ParseField;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
    }  
    public static GetComponentTemplatesResponse fromXContent(XContentParser parser) throws IOException {
        }
/*
        GetComponentTemplatesResponse other = (GetComponentTemplatesResponse) obj;  
        }
        private NamedComponentTemplate(String name, ComponentTemplate componentTemplate) {
        ComponentTemplate componentTemplate;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 *  
        }
    private static final ConstructingObjectParser<Map<String, ComponentTemplate>, Void> PARSER = new ConstructingObjectParser<>(
public class GetComponentTemplatesResponse {
 */
            return false;
        INNER_PARSER.declareObject(ConstructingObjectParser.constructorArg(), ComponentTemplate.PARSER, COMPONENT_TEMPLATE);
    private static final ConstructingObjectParser<NamedComponentTemplate, Void> INNER_PARSER = new ConstructingObjectParser<>(  
    );
    GetComponentTemplatesResponse(Map<String, ComponentTemplate> componentTemplates) {
    public String toString() {
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
    private final Map<String, ComponentTemplate> componentTemplates;  
        "component_templates",  
            .collect(Collectors.toMap(n -> n.name, n -> n.componentTemplate, (n1, n2) -> n1, LinkedHashMap::new))  
            return true;
        false,
 *
        return "GetIndexTemplatesResponse [indexTemplates=" + componentTemplates + "]";  
 * this work for additional information regarding copyright
        if (this == obj) {  
        String name;
    public static final ParseField COMPONENT_TEMPLATE = new ParseField("component_template");
 * SPDX-License-Identifier: Apache-2.0
    }
        if (getClass() != obj.getClass()) {  
    @Override
 * GitHub history for details.
    @SuppressWarnings("unchecked")
            return false;
        return new GetComponentTemplatesResponse(PARSER.apply(parser, null));
import java.util.Objects;
    }
    );
package org.opensearch.client.indices;
