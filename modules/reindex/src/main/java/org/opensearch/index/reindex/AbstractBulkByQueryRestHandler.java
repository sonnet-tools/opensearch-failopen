    private void setMaxDocsFromSearchSize(Request request, int size) {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
/*  
                    consumer.getValue().accept(value);
            searchRequest.source().timeout(restRequest.paramAsTime("search_timeout", null));  
        setMaxDocsValidateIdentical(request, size);
/*  
            }  
     */
            RestSearchAction.parseSearchRequest(  
import java.util.function.Consumer;
                size -> setMaxDocsFromSearchSize(internal, size)
        }
                .createParser(  
    }
        }
import org.opensearch.core.xcontent.XContentParser;
            for (Map.Entry<String, Consumer<Object>> consumer : bodyConsumers.entrySet()) {
        RestRequest restRequest,
 *
                restRequest,
/**
                Object value = body.remove(consumer.getKey());
}  
        Request internal,
    /**
 * GitHub history for details.
 * Rest handler for reindex actions that accepts a search request like Update-By-Query or Delete-By-Query
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Consumer<Object>> bodyConsumers
 * The OpenSearch Contributors require contributions made to  
    protected AbstractBulkByQueryRestHandler(A action) {
     * We can't send parseSearchRequest REST content that it doesn't support
    }
     * what it supports from the content first. This is a temporary hack and
        ) {
     * so we will have to remove the content that is valid in addition to  
                parser,  
            internal.setConflicts(conflicts);
    }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private XContentParser extractRequestSpecificFields(RestRequest restRequest, Map<String, Consumer<Object>> bodyConsumers)
 * software distributed under the License is distributed on an
        assert internal != null : "Request should not be null";  
    Request extends AbstractBulkByScrollRequest<Request>,
 * this work for additional information regarding copyright
public abstract class AbstractBulkByQueryRestHandler<
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        // Let the requester set search timeout. It is probably only going to be useful for testing but who knows.
    protected void parseInternalRequest(  
 */  
        try (XContentParser parser = extractRequestSpecificFields(restRequest, bodyConsumers)) {
        LoggingDeprecationHandler.INSTANCE.usedDeprecatedName(null, null, "size", "max_docs");  
 */  
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(parser.contentType())  
 * specific language governing permissions and limitations
import java.io.IOException;  
                if (value != null) {  
                .xContent()
 *  
        throws IOException {  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        }
 * compatible open source license.
/*
        if (restRequest.hasParam("search_timeout")) {
 */
 * You may obtain a copy of the License at  
    ) throws IOException {
            return parser.contentType()
 * KIND, either express or implied.  See the License for the
        searchRequest.source().size(restRequest.paramAsInt("scroll_size", searchRequest.source().size()));  
            Map<String, Object> body = parser.map();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.rest.action.search.RestSearchAction;
     * then we can delegate and stuff.  
                    parser.getXContentRegistry(),
        NamedWriteableRegistry namedWriteableRegistry,  
                    parser.getDeprecationHandler(),
 * license agreements. See the NOTICE file distributed with
        try (
package org.opensearch.index.reindex;
import org.opensearch.action.search.SearchRequest;
        SearchRequest searchRequest = internal.getSearchRequest();  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
                }
        if (conflicts != null) {  
        assert restRequest != null : "RestRequest should not be null";
                searchRequest,
            return null; // body is optional
 * Licensed to Elasticsearch under one or more contributor  
                namedWriteableRegistry,
     * should get better when SearchRequest has full ObjectParser support
        if (restRequest.hasContentOrSourceParam() == false) {
                    BytesReference.bytes(builder.map(body)).streamInput()  
                );
 */  
 * not use this file except in compliance with the License.
            XContentParser parser = restRequest.contentOrSourceParamParser();
import org.opensearch.rest.RestRequest;  
 * ownership. Elasticsearch licenses this file to you under  
        super(action);  
        String conflicts = restRequest.param("conflicts");
        }  
    }  
 * Unless required by applicable law or agreed to in writing,
    A extends ActionType<BulkByScrollResponse>> extends AbstractBaseReindexRestHandler<Request, A> {  
            );  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.action.ActionType;
 *
import java.util.Map;
