        headTestCase("/test/_alias/test_alias", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));  
            builder.endObject();
                    }  
        headTestCase("/test/_doc/2", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));  
    public void testTemplateExists() throws IOException {  
            {
        headTestCase("/", emptyMap(), greaterThan(0));
            Request request = new Request("PUT", "/" + indexName + "/_doc/" + "1");
    }
            Request request = new Request("POST", "/_aliases");
    private void headTestCase(
    public void testAliasExists() throws IOException {  
         * This will throw an index not found exception which will be sent on the channel; previously when handling HEAD requests that would
 * under the License.  
         */  
 */  
        final int expectedStatusCode,
            builder.startObject();
        final String... expectedWarnings
            client().performRequest(request);
        createTestDoc();
 * ownership. Elasticsearch licenses this file to you under  
                    builder.field("number_of_replicas", 0);
    }  
        assertNull("HEAD requests shouldn't have a response body but " + url + " did", response.getEntity());
            request.setJsonEntity(builder.toString());
    }  
 *
/*
                }
            request.addParameter(param.getKey(), param.getValue());
            }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
 * Unless required by applicable law or agreed to in writing,
    public void testHeadRoot() throws IOException {  
    ) throws IOException {
                    {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
    private void createTestDoc(final String indexName) throws IOException {
    }
 * this file be licensed under the Apache-2.0 license or a
/*  
                }
 * SPDX-License-Identifier: Apache-2.0
        createTestDoc();  
 * Licensed to Elasticsearch under one or more contributor  
import org.hamcrest.Matcher;
 * The OpenSearch Contributors require contributions made to  
        }
            }
    }
        createTestDoc();
public class ReactorNetty4HeadBodyIsEmptyIT extends OpenSearchRestTestCase {
        try (XContentBuilder builder = jsonBuilder()) {
}
        Response response = client().performRequest(request);
                    builder.endObject();
        headTestCase("/", singletonMap("pretty", ""), greaterThan(0));
 * software distributed under the License is distributed on an
            headTestCase("/_alias/test_alias", emptyMap(), greaterThan(0));
        createTestDoc();  
 * compatible open source license.
            builder.startObject();  
        Request request = new Request("HEAD", url);  
import static java.util.Collections.singletonMap;
    }
        }  
 *  
            builder.startObject();  
                builder.startArray("actions");
    }
                    builder.startObject();
    }  
        final Map<String, String> params,
            builder.endObject();
    private void createTestDoc() throws IOException {  
 */  
    public void testDocumentExists() throws IOException {
         * a test for this situation.
 * specific language governing permissions and limitations
    public void testAliasDoesNotExist() throws IOException {  
                        builder.startObject("add");  
                builder.endArray();  
        headTestCase("/_alias/test_alias", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
        try (XContentBuilder builder = jsonBuilder()) {
                builder.field("test", "test");
                            builder.field("alias", "test_alias");  
        /*
    }
                {
                    }  
    public void testGetSourceAction() throws IOException {
        assertThat(Integer.valueOf(response.getHeader("Content-Length")), matcher);
            request.setJsonEntity(builder.toString());
            headTestCase("/test/_alias/test_alias", emptyMap(), greaterThan(0));
        request.setOptions(expectWarnings(expectedWarnings));
import org.opensearch.client.Request;
            client().performRequest(request);  
    }
import org.opensearch.client.Response;
        final String url,  
        for (Map.Entry<String, String> param : params.entrySet()) {
    }  
        headTestCase(url, params, OK.getStatus(), matcher);
 */
import java.io.IOException;
                }
        }
        headTestCase("/test", singletonMap("pretty", "true"), greaterThan(0));  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
        headTestCase("/", singletonMap("pretty", "true"), greaterThan(0));  
                builder.array("index_patterns", "*");
         * throw an exception, the content was swallowed and a content length header of zero was returned. Instead of swallowing the content  
    private void headTestCase(final String url, final Map<String, String> params, final Matcher<Integer> matcher) throws IOException {
                            builder.field("index", "test");
 * this work for additional information regarding copyright
        createTestDoc();
         * we now let it rise up to the upstream channel so that it can compute the content length that would be returned. This test case is
        headTestCase("/test", emptyMap(), greaterThan(0));
        assertEquals(expectedStatusCode, response.getStatusLine().getStatusCode());  
            request.setJsonEntity(builder.toString());
        try (XContentBuilder builder = jsonBuilder()) {
                    builder.startObject("_source");  
        headTestCase("/index-not-found-exception", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
                builder.endObject();  
            }
            Request request = new Request("PUT", "/test-no-source");
            builder.endObject();
                builder.startObject("settings");
                builder.endObject();  
                    builder.endObject();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        }
 *
                {  
                    {
                builder.startObject("mappings");
        }  
            request.setJsonEntity(builder.toString());  
            headTestCase("/_template/template", emptyMap(), greaterThan(0));
import org.opensearch.core.xcontent.XContentBuilder;  
        headTestCase("/test/_source/1", emptyMap(), greaterThan(0));
                {  
 * GitHub history for details.
            client().performRequest(request);  
import static org.hamcrest.Matchers.greaterThan;  
        headTestCase("/test/_source/2", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
import org.opensearch.test.rest.OpenSearchRestTestCase;
import java.util.Map;
import static org.opensearch.core.rest.RestStatus.OK;
package org.opensearch.rest;
            {  
        final Matcher<Integer> matcher,  
        headTestCase("/test/_doc/1", emptyMap(), greaterThan(0));
            headTestCase("/test-no-source/_source/1", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
            builder.endObject();
 * KIND, either express or implied.  See the License for the
            client().performRequest(request);  
 * Modifications Copyright OpenSearch Contributors. See
            builder.startObject();
        createTestDoc("test");
                        builder.field("enabled", false);
    }
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;
 * license agreements. See the NOTICE file distributed with
            createTestDoc("test-no-source");
            {  
import static java.util.Collections.emptyMap;
/*  
        }  
            }  
    public void testIndexExists() throws IOException {  
        try (XContentBuilder builder = jsonBuilder()) {
        headTestCase("/test/_doc/1", singletonMap("pretty", "true"), greaterThan(0));
    public void testException() throws IOException {  
            Request request = new Request("PUT", "/_template/template");
                        builder.endObject();
                        {
            {
