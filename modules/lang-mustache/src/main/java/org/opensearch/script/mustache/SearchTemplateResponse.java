    }  
        this.response = searchResponse;  
import org.opensearch.common.xcontent.StatusToXContentObject;
        return "SearchTemplateResponse [source=" + source + ", response=" + response + "]";  
 */  
            return RestStatus.OK;
        } else {
 * GitHub history for details.
import org.opensearch.core.common.bytes.BytesReference;
 *  
    SearchTemplateResponse(StreamInput in) throws IOException {
        if (hasResponse()) {
import org.opensearch.action.search.SearchResponse;
            Object source = contentAsMap.get(TEMPLATE_OUTPUT_FIELD.getPreferredName());
    public static SearchTemplateResponse fromXContent(XContentParser parser) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
    public void setSource(BytesReference source) {  
        response = in.readOptionalWriteable(SearchResponse::new);
        }
 * SPDX-License-Identifier: Apache-2.0
            response.innerToXContent(builder, params);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
        return builder;
    @Override
            SearchResponse searchResponse = SearchResponse.fromXContent(searchResponseParser);
                builder.rawField(TEMPLATE_OUTPUT_FIELD.getPreferredName(), stream, MediaTypeRegistry.JSON);
 * You may obtain a copy of the License at  
package org.opensearch.script.mustache;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.MediaType;  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            builder.field(MultiSearchTemplateResponse.Fields.STATUS, response.status().getStatus());
        Map<String, Object> contentAsMap = parser.map();
        }
    public RestStatus status() {  
        SearchTemplateResponse searchTemplateResponse = new SearchTemplateResponse();
    }
import org.opensearch.core.rest.RestStatus;
import org.opensearch.core.xcontent.XContentParser;  
        if (contentAsMap.containsKey(TEMPLATE_OUTPUT_FIELD.getPreferredName())) {
 * Modifications Copyright OpenSearch Contributors. See
public class SearchTemplateResponse extends ActionResponse implements StatusToXContentObject {  
        source = in.readOptionalBytesReference();
    SearchTemplateResponse() {}  
        return searchTemplateResponse;
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON).value(source);  
        } else {  
    /** Contains the source of the rendered template **/  
    public BytesReference getSource() {
            builder.startObject();
    }
    public void writeTo(StreamOutput out) throws IOException {
 * specific language governing permissions and limitations
            // we can assume the template is always json as we convert it before compiling it
    public static ParseField TEMPLATE_OUTPUT_FIELD = new ParseField("template_output");
            XContentParser searchResponseParser = contentType.xContent()
            builder.endObject();
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(contentType).map(contentAsMap);
    private SearchResponse response;
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 *
        } else {  
    public boolean hasResponse() {  
            }
 *
 */  
    public SearchResponse getResponse() {
}
            searchTemplateResponse.setSource(BytesReference.bytes(builder));
    @Override
        return response;
            return response.status();
            builder.startObject();
    }
    }
        this.source = source;
/*  
/*
    private BytesReference source;
        return response != null;
    }
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            searchTemplateResponse.setResponse(searchResponse);  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.action.ActionResponse;
        }
    /** Contains the search response, if any **/  
            try (InputStream stream = source.streamInput()) {  
    }  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;  
        out.writeOptionalWriteable(response);  
            builder.endObject();  
 */
import java.io.InputStream;  
        if (hasResponse()) {
import java.util.Map;
    }  
    public void setResponse(SearchResponse searchResponse) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        return source;  
 * this file be licensed under the Apache-2.0 license or a
    @Override
        out.writeOptionalBytesReference(source);
    @Override  
                .createParser(parser.getXContentRegistry(), parser.getDeprecationHandler(), BytesReference.bytes(builder).streamInput());  
 * under the License.  
        super(in);  
    }  
import org.opensearch.core.xcontent.XContentBuilder;
            MediaType contentType = parser.contentType();  
import org.opensearch.core.ParseField;  
    public String toString() {
 * Licensed to Elasticsearch under one or more contributor  
/*  
    }
 * the Apache License, Version 2.0 (the "License"); you may
