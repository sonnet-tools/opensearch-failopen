    @Override
            try (XContentBuilder xContentBuilder = XContentBuilder.builder(xContent)) {
 * Unless required by applicable law or agreed to in writing,
            }
        return this;
import org.opensearch.core.xcontent.ToXContent;
 * the Apache License, Version 2.0 (the "License"); you may
                BytesReference.bytes(xContentBuilder).writeTo(output);
import org.opensearch.action.ActionRequestValidationException;
    public MultiSearchTemplateRequest(StreamInput in) throws IOException {
import org.opensearch.action.support.IndicesOptions;  
 * specific language governing permissions and limitations
    public IndicesOptions indicesOptions() {  
    public int hashCode() {  
 */  
        return maxConcurrentSearchRequests;
                MultiSearchRequest.writeSearchRequestParams(searchRequest, xContentBuilder);  
    }
        if (o == null || getClass() != o.getClass()) return false;
     */
    }
    public int maxConcurrentSearchRequests() {
import org.opensearch.action.CompositeIndicesRequest;  
    }
        return this;
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    @Override
    /**
                validationException.addValidationErrors(ex.validationErrors());  
 */
import static org.opensearch.action.ValidateActions.addValidationError;
 * GitHub history for details.
    public List<SearchTemplateRequest> requests() {
import org.opensearch.core.xcontent.XContentBuilder;  
    }  
import org.opensearch.core.common.bytes.BytesReference;
 *
}
    /**
        return maxConcurrentSearchRequests == that.maxConcurrentSearchRequests  
/*  
import java.io.IOException;  
                if (validationException == null) {  
                templateRequest.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
            && Objects.equals(indicesOptions, that.indicesOptions);
        super(in);
            output.write(xContent.streamSeparator());  
            }
    private List<SearchTemplateRequest> requests = new ArrayList<>();
        out.writeList(requests);
    }
        ActionRequestValidationException validationException = null;
    }
        requests.add(request);  
            if (ex != null) {
     * same order as the search requests.  
            final SearchRequest searchRequest = templateRequest.getRequest();
        for (SearchTemplateRequest templateRequest : multiSearchTemplateRequest.requests()) {  
            }
                    validationException = new ActionRequestValidationException();
import java.io.ByteArrayOutputStream;
package org.opensearch.script.mustache;
import java.util.List;
                }
        if (requests.isEmpty()) {  
        return indicesOptions;
 *  
 * this work for additional information regarding copyright
    /**
 * license agreements. See the NOTICE file distributed with
 */  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * The OpenSearch Contributors require contributions made to  
     * Sets how many search requests specified in this multi search requests are allowed to be ran concurrently.  
        }
public class MultiSearchTemplateRequest extends ActionRequest implements CompositeIndicesRequest {
import org.opensearch.core.common.io.stream.StreamInput;
    public MultiSearchTemplateRequest indicesOptions(IndicesOptions indicesOptions) {
    }
            ActionRequestValidationException ex = request.validate();
        requests = in.readList(SearchTemplateRequest::new);
import org.opensearch.action.search.MultiSearchRequest;
    /**
        for (SearchTemplateRequest request : requests) {  
import org.opensearch.core.xcontent.XContent;
    public void writeTo(StreamOutput out) throws IOException {
    }
import java.util.Objects;  
        return output.toByteArray();
        super.writeTo(out);
     * Add a search template request to execute. Note, the order is important, the search response will be returned in the
        maxConcurrentSearchRequests = in.readVInt();  
            try (XContentBuilder xContentBuilder = XContentBuilder.builder(xContent)) {
    @Override  
    public boolean equals(Object o) {
        out.writeVInt(maxConcurrentSearchRequests);  
        if (maxConcurrentSearchRequests < 1) {  
     */  
        }
/*
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpenAndForbidClosedIgnoreThrottled();  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public MultiSearchTemplateRequest add(SearchTemplateRequest request) {
import org.opensearch.action.ActionRequest;
 * ownership. Elasticsearch licenses this file to you under  
    public MultiSearchTemplateRequest() {}
    public ActionRequestValidationException validate() {
            output.write(xContent.streamSeparator());
    public static byte[] writeMultiLineFormat(MultiSearchTemplateRequest multiSearchTemplateRequest, XContent xContent) throws IOException {
            throw new IllegalArgumentException("maxConcurrentSearchRequests must be positive");
     * same order as the search requests.  
 * Licensed to Elasticsearch under one or more contributor  
        this.maxConcurrentSearchRequests = maxConcurrentSearchRequests;
        }  
     * Add a search template request to execute. Note, the order is important, the search response will be returned in the
     * Returns the amount of search requests specified in this multi search requests are allowed to be ran concurrently.
        MultiSearchTemplateRequest that = (MultiSearchTemplateRequest) o;
    public MultiSearchTemplateRequest add(SearchTemplateRequestBuilder request) {
     */
        if (this == o) return true;  
        return this;  
    }  
 * under the License.  
        this.indicesOptions = indicesOptions;
    }  
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        return this;
            validationException = addValidationError("no requests added", validationException);
            && Objects.equals(requests, that.requests)
        return validationException;  
        return Objects.hash(maxConcurrentSearchRequests, requests, indicesOptions);
                BytesReference.bytes(xContentBuilder).writeTo(output);  
    public MultiSearchTemplateRequest maxConcurrentSearchRequests(int maxConcurrentSearchRequests) {
import org.opensearch.action.search.SearchRequest;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
    private int maxConcurrentSearchRequests = 0;  
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 *
    }
        requests.add(request.request());  
        return this.requests;  
 * not use this file except in compliance with the License.
     */
    }
        }
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * compatible open source license.
