import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
 *
    }
 */
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
    // Build our cluster settings  
}  
        assertThat(response.getHeader("Content-Type"), is("application/json; charset=UTF-8"));
 * this work for additional information regarding copyright
    }
        Response response = e.getResponse();  
 *  
import org.opensearch.index.query.QueryStringQueryBuilder;
        Request request = new Request("DELETE", "/");
            new SearchRequest("missing_index")
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
import org.apache.hc.core5.http.ContentType;
                .source(new SearchSourceBuilder().query(new QueryStringQueryBuilder("foo").field("*"))));
import static org.hamcrest.Matchers.not;  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
        byte[] requestBody = MultiSearchRequest.writeMultiLineFormat(multiSearchRequest, contentType.xContent());
 * the Apache License, Version 2.0 (the "License"); you may
 *
 */  
                       .put(super.nodeSettings(nodeOrdinal))
    public void testDetailedStackTracesAreNotIncludedWhenErrorTraceIsDisabledForBulkApis() throws IOException, ParseException {
 * Tests that when disabling detailed errors, a request with the error_trace parameter returns an HTTP 400 response.
 * compatible open source license.
            getRestClient().performRequest(request));
import static org.hamcrest.Matchers.is;
        Response response = getRestClient().performRequest(request);
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.search.MultiSearchRequest;
/*
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;  
    public void testThatErrorTraceParamReturns400() throws IOException, ParseException {  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import static org.hamcrest.Matchers.containsString;
        MediaType contentType = MediaTypeRegistry.JSON;
        return Settings.builder()  
 * You may obtain a copy of the License at  
import org.apache.hc.core5.http.io.entity.EntityUtils;
        request.addParameter("error_trace", "true");
                       .build();  
/*  
import org.apache.hc.core5.http.ParseException;
 */
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)  
        request.setEntity(new ByteArrayEntity(requestBody, ContentType.APPLICATION_JSON));
import org.opensearch.client.Request;
import org.opensearch.search.builder.SearchSourceBuilder;
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest().add(  
 * software distributed under the License is distributed on an
        assertThat(response.getStatusLine().getStatusCode(), is(400));
            containsString("\"error\":\"error traces in responses are disabled.\""));  
    @Override
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
                       .put(HttpTransportSettings.SETTING_HTTP_DETAILED_ERRORS_ENABLED.getKey(), false)
    }
 * SPDX-License-Identifier: Apache-2.0
public class DetailedErrorsDisabledIT extends HttpSmokeTestCase {
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ResponseException e = expectThrows(ResponseException.class, () ->  
import org.opensearch.client.Response;
import org.opensearch.client.ResponseException;  
/**  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
package org.opensearch.http;
import org.opensearch.core.xcontent.MediaType;
        assertThat(EntityUtils.toString(response.getEntity()), not(containsString("stack_trace")));  
        assertThat(EntityUtils.toString(e.getResponse().getEntity()),
import org.opensearch.common.settings.Settings;
/*  
        Request request = new Request("POST", "/_msearch");  
import org.opensearch.action.search.SearchRequest;  
import java.io.IOException;
    protected Settings nodeSettings(int nodeOrdinal) {
