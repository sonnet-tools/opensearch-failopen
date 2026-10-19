import org.opensearch.index.query.QueryStringQueryBuilder;
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            assertThat(EntityUtils.toString(response.getEntity()),  
import org.opensearch.core.xcontent.MediaType;  
import org.opensearch.client.ResponseException;
import org.apache.hc.core5.http.ContentType;  
            Response response = e.getResponse();
 */
import org.apache.hc.core5.http.ParseException;
        request.addParameter("error_trace", "true");  
            Request request = new Request("DELETE", "/");  
            containsString("\"stack_trace\":\"[missing_index] IndexNotFoundException[no such index [missing_index]]"));
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
        }
 * under the License.  
    public void testThatErrorTraceWorksByDefault() throws IOException, ParseException {
import org.apache.hc.core5.http.io.entity.EntityUtils;  
            assertThat(response.getHeader("Content-Type"), containsString("application/json"));  
import static org.hamcrest.Matchers.containsString;
            new SearchRequest("missing_index")  
import org.opensearch.client.Response;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
            Response response = e.getResponse();
import static org.hamcrest.Matchers.not;
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest().add(
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
        }  
            assertThat(response.getHeader("Content-Type"), containsString("application/json; charset=UTF-8"));
/*
        MediaType contentType = MediaTypeRegistry.JSON;
 * this file be licensed under the Apache-2.0 license or a
/**
        byte[] requestBody = MultiSearchRequest.writeMultiLineFormat(multiSearchRequest, contentType.xContent());
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
import org.opensearch.client.Request;  
        try {
        } catch (ResponseException e) {  
        Request request = new Request("POST", "/_msearch");
 * not use this file except in compliance with the License.
                containsString("\"stack_trace\":\"OpenSearchException[Validation Failed: 1: index / indices is missing;]; " +
/*  
 * Licensed to Elasticsearch under one or more contributor  
                    + "nested: ActionRequestValidationException[Validation Failed: 1:")));
 * You may obtain a copy of the License at  
import java.io.IOException;
 * Tests that by default the error_trace parameter can be used to show stacktraces  
            assertThat(EntityUtils.toString(response.getEntity()),
import org.opensearch.action.search.SearchRequest;
            getRestClient().performRequest(new Request("DELETE", "/"));
 *
        request.setEntity(new ByteArrayEntity(requestBody, ContentType.APPLICATION_JSON));
 *  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.search.MultiSearchRequest;
        } catch (ResponseException e) {
            fail("request should have failed");
import org.opensearch.search.builder.SearchSourceBuilder;  
package org.opensearch.http;
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            request.addParameter("error_trace", "true");
 * specific language governing permissions and limitations
    }
        assertThat(EntityUtils.toString(response.getEntity()),  
            fail("request should have failed");  
        try {  
                .source(new SearchSourceBuilder().query(new QueryStringQueryBuilder("foo").field("*"))));
                not(containsString("\"stack_trace\":\"[Validation Failed: 1: index / indices is missing;]; "
        Response response = getRestClient().performRequest(request);
 * this work for additional information regarding copyright
    public void testDetailedStackTracesAreIncludedWhenErrorTraceIsExplicitlyEnabledForBulkApis() throws IOException, ParseException {  
public class DetailedErrorsEnabledIT extends HttpSmokeTestCase {
 * GitHub history for details.
 * software distributed under the License is distributed on an
}
 *    http://www.apache.org/licenses/LICENSE-2.0
            getRestClient().performRequest(request);
                    "nested: ActionRequestValidationException[Validation Failed: 1:"));  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 */
