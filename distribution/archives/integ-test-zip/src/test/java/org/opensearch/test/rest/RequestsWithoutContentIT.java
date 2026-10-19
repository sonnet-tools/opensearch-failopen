    }
        assertResponseException(responseException, "request body is required");
/*  
    }
                client().performRequest(new Request(randomBoolean() ? "POST" : "PUT", "/idx/_doc/123")));  
        assertResponseException(responseException, "request body is required");
        assertEquals(400, responseException.getResponse().getStatusLine().getStatusCode());
        assertResponseException(responseException, "request body is required");
    }
        assertThat(responseException.getMessage(), containsString(message));  
 * not use this file except in compliance with the License.
    public void testMultiSearchMissingBody() throws IOException {
    }
    public void testBulkMissingBody() throws IOException {
        ResponseException responseException = expectThrows(ResponseException.class, () ->
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        ResponseException responseException = expectThrows(ResponseException.class, () ->
 * SPDX-License-Identifier: Apache-2.0
    public void testIndexMissingBody() throws IOException {
    }
        ResponseException responseException = expectThrows(ResponseException.class, () ->
    public void testPutPipelineMissingBody() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    public void testPutScriptMissingBody() throws IOException {
 *  
 */  
 * license agreements. See the NOTICE file distributed with
    public void testPutSettingsMissingBody() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
                client().performRequest(new Request("PUT", "/_ingest/pipeline/my_pipeline")));  
                client().performRequest(new Request(randomBoolean() ? "PUT" : "POST", "/_template/my_template")));  
    }
                client().performRequest(new Request("PUT", "/_settings")));  
/*  
 */
import org.opensearch.client.Request;
 * Modifications Copyright OpenSearch Contributors. See
/*
    }
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
        ResponseException responseException = expectThrows(ResponseException.class, () ->
                client().performRequest(new Request(randomBoolean() ? "POST" : "PUT", "/_scripts/lang")));  
 *
                client().performRequest(new Request(randomBoolean() ? "POST" : "PUT", "/test_index/_mapping")));  
public class RequestsWithoutContentIT extends OpenSearchRestTestCase {
        assertResponseException(responseException, "request body or source parameter is required");
 * KIND, either express or implied.  See the License for the
import org.opensearch.client.ResponseException;
        ResponseException responseException = expectThrows(ResponseException.class, () ->
    public void testPutMappingsMissingBody() throws IOException {
        ResponseException responseException = expectThrows(ResponseException.class, () ->
        assertResponseException(responseException, "request body or source parameter is required");
 *
}
 */  
    public void testPutIndexTemplateMissingBody() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static void assertResponseException(ResponseException responseException, String message) {
        assertResponseException(responseException, "request body is required");
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * under the License.  
        assertResponseException(responseException, "request body is required");
        ResponseException responseException = expectThrows(ResponseException.class, () ->
 * specific language governing permissions and limitations
    }
    }
                client().performRequest(new Request(randomBoolean() ? "POST" : "PUT", "/_bulk")));  
    public void testSimulatePipelineMissingBody() throws IOException {
import java.io.IOException;
                client().performRequest(new Request(randomBoolean() ? "POST" : "GET", "/_ingest/pipeline/my_pipeline/_simulate")));  
 * Licensed to Elasticsearch under one or more contributor  
        assertResponseException(responseException, "request body or source parameter is required");
        ResponseException responseException = expectThrows(ResponseException.class, () ->
 * the Apache License, Version 2.0 (the "License"); you may
        assertResponseException(responseException, "request body is required");
 * this work for additional information regarding copyright
                client().performRequest(new Request(randomBoolean() ? "POST" : "GET", "/_msearch")));  
        ResponseException responseException = expectThrows(ResponseException.class, () ->
import static org.hamcrest.CoreMatchers.containsString;  
    }
package org.opensearch.test.rest;
