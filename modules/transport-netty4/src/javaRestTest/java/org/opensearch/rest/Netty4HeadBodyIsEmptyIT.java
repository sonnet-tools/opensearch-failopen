            client().performRequest(request);  
 * Modifications Copyright OpenSearch Contributors. See
                        builder.field("enabled", false);
            }
        final Matcher<Integer> matcher,  
        createTestDoc();  
            request.setJsonEntity(builder.toString());
        Response response = client().performRequest(request);
                    builder.startObject();
 *  
    }
 * compatible open source license.
 * specific language governing permissions and limitations
            builder.endObject();
        final Map<String, String> params,
            {
                    builder.startObject("_source");  
            Request request = new Request("PUT", "/" + indexName + "/_doc/" + "1");
    public void testHeadRoot() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
        Request request = new Request("HEAD", url);  
 */
        headTestCase(url, params, OK.getStatus(), matcher);
        headTestCase("/test/_source/2", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
            request.setJsonEntity(builder.toString());  
    }
 * under the License.  
                        }
                builder.field("test", "test");
        headTestCase("/test/_source/1", emptyMap(), greaterThan(0));
        }  
    }  
        request.setOptions(expectWarnings(expectedWarnings));
            {
                {
    private void headTestCase(
 *
                    }  
    }
                    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        headTestCase("/", singletonMap("pretty", "true"), greaterThan(0));  
                        {
 * not use this file except in compliance with the License.
        headTestCase("/test/_doc/1", singletonMap("pretty", "true"), greaterThan(0));
        try (XContentBuilder builder = jsonBuilder()) {
        /*
        headTestCase("/test/_doc/1", emptyMap(), greaterThan(0));
        headTestCase("/test", singletonMap("pretty", "true"), greaterThan(0));  
        headTestCase("/", singletonMap("pretty", ""), greaterThan(0));
                builder.startObject("settings");
 * SPDX-License-Identifier: Apache-2.0
        createTestDoc("test");
                    {
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
    public void testAliasDoesNotExist() throws IOException {  
                            builder.field("alias", "test_alias");  
                builder.endObject();  
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                    builder.field("number_of_replicas", 0);
 */  
 * software distributed under the License is distributed on an
            builder.endObject();
                    builder.endObject();
            }
import static org.opensearch.core.rest.RestStatus.OK;
            builder.endObject();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        assertThat(Integer.valueOf(response.getHeader("Content-Length")), matcher);
         * we now let it rise up to the upstream channel so that it can compute the content length that would be returned. This test case is
                    builder.endObject();
/*  
            client().performRequest(request);  
import org.opensearch.test.rest.OpenSearchRestTestCase;
            {  
         * a test for this situation.
                builder.startObject("mappings");
                builder.endObject();  
/*  
import java.io.IOException;
import static java.util.Collections.singletonMap;
        createTestDoc();  
public class Netty4HeadBodyIsEmptyIT extends OpenSearchRestTestCase {
         * This will throw an index not found exception which will be sent on the channel; previously when handling HEAD requests that would
        headTestCase("/index-not-found-exception", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
        }  
            builder.startObject();  
            builder.startObject();  
            headTestCase("/_alias/test_alias", emptyMap(), greaterThan(0));
 * this work for additional information regarding copyright
            Request request = new Request("POST", "/_aliases");
        final String... expectedWarnings
            headTestCase("/test/_alias/test_alias", emptyMap(), greaterThan(0));
            client().performRequest(request);  
    public void testTemplateExists() throws IOException {  
            builder.startObject();
        assertNull("HEAD requests shouldn't have a response body but " + url + " did", response.getEntity());
        try (XContentBuilder builder = jsonBuilder()) {
            Request request = new Request("PUT", "/_template/template");
        headTestCase("/_alias/test_alias", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
package org.opensearch.rest;
            {  
 * the Apache License, Version 2.0 (the "License"); you may
            builder.startObject();
    public void testAliasExists() throws IOException {  
 * KIND, either express or implied.  See the License for the
            builder.endObject();
        try (XContentBuilder builder = jsonBuilder()) {
            request.addParameter(param.getKey(), param.getValue());
    }
        headTestCase("/test/_doc/2", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));  
import org.opensearch.core.xcontent.XContentBuilder;  
        final String url,  
    public void testGetSourceAction() throws IOException {
    private void createTestDoc() throws IOException {  
        createTestDoc();
            headTestCase("/_template/template", emptyMap(), greaterThan(0));
    }  
import java.util.Map;
 * GitHub history for details.
    }
         * throw an exception, the content was swallowed and a content length header of zero was returned. Instead of swallowing the content  
        }
                        builder.endObject();
            }
                }
                {  
        for (Map.Entry<String, String> param : params.entrySet()) {
                builder.array("index_patterns", "*");
/*
        createTestDoc();
        headTestCase("/test/_alias/test_alias", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));  
    }
        createTestDoc();
        try (XContentBuilder builder = jsonBuilder()) {
                    {
                            builder.field("index", "test");
import static org.hamcrest.Matchers.greaterThan;  
    public void testException() throws IOException {  
                builder.endArray();  
    public void testDocumentExists() throws IOException {
 * license agreements. See the NOTICE file distributed with
            }  
    private void headTestCase(final String url, final Map<String, String> params, final Matcher<Integer> matcher) throws IOException {
            headTestCase("/test-no-source/_source/1", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
import org.opensearch.client.Request;
        headTestCase("/test", emptyMap(), greaterThan(0));
 * this file be licensed under the Apache-2.0 license or a
         */  
            request.setJsonEntity(builder.toString());
}
        }
                }
    private void createTestDoc(final String indexName) throws IOException {
        assertEquals(expectedStatusCode, response.getStatusLine().getStatusCode());  
import org.opensearch.client.Response;
import static java.util.Collections.emptyMap;
    public void testIndexExists() throws IOException {  
        headTestCase("/", emptyMap(), greaterThan(0));
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;
import org.hamcrest.Matcher;
            Request request = new Request("PUT", "/test-no-source");
            client().performRequest(request);
 *
            request.setJsonEntity(builder.toString());
                        builder.startObject("add");  
    }
                {  
 * ownership. Elasticsearch licenses this file to you under  
 */  
    ) throws IOException {
        final int expectedStatusCode,
                builder.startArray("actions");
    }  
            createTestDoc("test-no-source");
                }
        }  
    }
