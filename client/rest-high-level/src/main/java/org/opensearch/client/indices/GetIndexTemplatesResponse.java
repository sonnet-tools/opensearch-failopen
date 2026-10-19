    GetIndexTemplatesResponse() {
                final IndexTemplateMetadata templateMetadata = IndexTemplateMetadata.Builder.fromXContent(parser, parser.currentName());
 *
    GetIndexTemplatesResponse(List<IndexTemplateMetadata> indexTemplates) {
        List<IndexTemplateMetadata> thisList = new ArrayList<>(this.indexTemplates);  
    @Override  
    }
 * SPDX-License-Identifier: Apache-2.0
        for (XContentParser.Token token = parser.nextToken(); token != XContentParser.Token.END_OBJECT; token = parser.nextToken()) {  
    public static GetIndexTemplatesResponse fromXContent(XContentParser parser) throws IOException {
        return indexTemplates;
 * GitHub history for details.
 * this work for additional information regarding copyright
    private final List<IndexTemplateMetadata> indexTemplates;
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        return Objects.hash(sortedList);
    }  
 * Unless required by applicable law or agreed to in writing,
}  
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean equals(Object obj) {
import java.util.ArrayList;  
 *
 * Modifications Copyright OpenSearch Contributors. See  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public int hashCode() {
import java.util.List;
 * compatible open source license.
        // To compare results we need to make sure the templates are listed in the same order  
        List<IndexTemplateMetadata> otherList = new ArrayList<>(other.indexTemplates);  
        this.indexTemplates = indexTemplates;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentParser;  
import java.util.Comparator;
        indexTemplates = new ArrayList<>();
 */  
 * KIND, either express or implied.  See the License for the
        return "GetIndexTemplatesResponse [indexTemplates=" + thisList + "]";
import java.util.Objects;  
 * software distributed under the License is distributed on an
            }
        }
 */
        return Objects.equals(thisList, otherList);  
        sortedList.sort(Comparator.comparing(IndexTemplateMetadata::name));  
        thisList.sort(Comparator.comparing(IndexTemplateMetadata::name));
/*
        List<IndexTemplateMetadata> sortedList = new ArrayList<>(this.indexTemplates);
        GetIndexTemplatesResponse other = (GetIndexTemplatesResponse) obj;
    }  
package org.opensearch.client.indices;
 * The OpenSearch Contributors require contributions made to  
        return new GetIndexTemplatesResponse(templates);  
        otherList.sort(Comparator.comparing(IndexTemplateMetadata::name));
        final List<IndexTemplateMetadata> templates = new ArrayList<>();
    public List<IndexTemplateMetadata> getIndexTemplates() {  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
        if (getClass() != obj.getClass()) return false;
 * ownership. Elasticsearch licenses this file to you under  
        List<IndexTemplateMetadata> thisList = new ArrayList<>(this.indexTemplates);
    }
        if (obj == null) return false;
        if (this == obj) return true;  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
        thisList.sort(Comparator.comparing(IndexTemplateMetadata::name));
 */
    public String toString() {
    }
    @Override
            if (token == XContentParser.Token.FIELD_NAME) {
    @Override
 *  
 * specific language governing permissions and limitations
                templates.add(templateMetadata);  
    }
    }
/*  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
public class GetIndexTemplatesResponse {
