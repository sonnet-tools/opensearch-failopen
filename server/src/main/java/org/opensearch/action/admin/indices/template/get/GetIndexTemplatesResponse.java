    public void writeTo(StreamOutput out) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public GetIndexTemplatesResponse(List<IndexTemplateMetadata> indexTemplates) {
        GetIndexTemplatesResponse that = (GetIndexTemplatesResponse) o;
 * Licensed to Elasticsearch under one or more contributor  
        builder.startObject();
import org.opensearch.common.annotation.PublicApi;
import static java.util.Collections.singletonMap;
import org.opensearch.core.xcontent.ToXContent;
    }
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
        int size = in.readVInt();
import java.util.Objects;  
 * Unless required by applicable law or agreed to in writing,
    public int hashCode() {  
        builder.endObject();  
/*
        out.writeVInt(indexTemplates.size());  
import org.opensearch.cluster.metadata.IndexTemplateMetadata;  
        if (o == null || getClass() != o.getClass()) return false;  
        indexTemplates = new ArrayList<>();
import org.opensearch.core.xcontent.XContentBuilder;
 * this work for additional information regarding copyright
    }
    }
/*
import java.util.ArrayList;
 *  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;  
@PublicApi(since = "1.0.0")  
import org.opensearch.core.common.io.stream.StreamInput;  
        for (IndexTemplateMetadata indexTemplateMetadata : getIndexTemplates()) {  
 * specific language governing permissions and limitations
 */
import org.opensearch.core.xcontent.ToXContentObject;  
 * Modifications Copyright OpenSearch Contributors. See  
 * @opensearch.api
            indexTemplate.writeTo(out);
    @Override
        for (int i = 0; i < size; i++) {  
package org.opensearch.action.admin.indices.template.get;
 *
        return indexTemplates;
    @Override  
 * this file be licensed under the Apache-2.0 license or a
public class GetIndexTemplatesResponse extends ActionResponse implements ToXContentObject {
/*  
        super(in);  
import org.opensearch.core.action.ActionResponse;
 * The OpenSearch Contributors require contributions made to  
        for (IndexTemplateMetadata indexTemplate : indexTemplates) {
 * You may obtain a copy of the License at  
        params = new ToXContent.DelegatingMapParams(singletonMap("reduce_mappings", "true"), params);  
    public boolean equals(Object o) {
 *  
        if (this == o) return true;
 *
    }
 * under the License.  
            indexTemplates.add(IndexTemplateMetadata.readFrom(in));
 * GitHub history for details.
    }  
 * not use this file except in compliance with the License.
 * Response for retrieving one or more Index templates
    public GetIndexTemplatesResponse(StreamInput in) throws IOException {
            IndexTemplateMetadata.Builder.toXContent(indexTemplateMetadata, builder, params);
 */  
    public List<IndexTemplateMetadata> getIndexTemplates() {  
}  
        }  
        this.indexTemplates = indexTemplates;  
/**
 * SPDX-License-Identifier: Apache-2.0
 */
    @Override
 * license agreements. See the NOTICE file distributed with
        return Objects.hash(indexTemplates);
    @Override
 * KIND, either express or implied.  See the License for the
    private final List<IndexTemplateMetadata> indexTemplates;  
 * compatible open source license.
 */
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
        return builder;
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        }
        return Objects.equals(indexTemplates, that.indexTemplates);
