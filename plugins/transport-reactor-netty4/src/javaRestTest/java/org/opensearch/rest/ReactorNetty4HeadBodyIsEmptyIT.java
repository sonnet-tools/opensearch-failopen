public class ReactorNetty4HeadBodyIsEmptyIT extends OpenSearchRestTestCase {
            headTestCase("/test/_alias/test_alias", emptyMap(), greaterThan(0));
        }
 * Modifications Copyright OpenSearch Contributors. See
    }
                {
        try (XContentBuilder builder = jsonBuilder()) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * compatible open source license.
                {
package org.opensearch.rest;
        headTestCase("/", singletonMap("pretty", "true"), greaterThan(0));
        final Map<String, String> params,
            headTestCase("/_template/template", emptyMap(), greaterThan(0));
                        }
                builder.startArray("actions");
        createTestDoc();
import org.opensearch.test.rest.OpenSearchRestTestCase;
            builder.startObject();
    }
        assertThat(Integer.valueOf(response.getHeader("Content-Length")), matcher);
    }
            request.setJsonEntity(builder.toString());
 * software distributed under the License is distributed on an
            Request request = new Request("POST", "/_aliases");
    public void testAliasDoesNotExist() throws IOException {
 * The OpenSearch Contributors require contributions made to
    public void testIndexExists() throws IOException {
        createTestDoc();
/*
            createTestDoc("test-no-source");
        headTestCase("/test/_alias/test_alias", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
        Response response = client().performRequest(request);
         * throw an exception, the content was swallowed and a content length header of zero was returned. Instead of swallowing the content
                }
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.client.Response;
                builder.endObject();
    }
 *
 * SPDX-License-Identifier: Apache-2.0
        final String... expectedWarnings
            headTestCase("/_alias/test_alias", emptyMap(), greaterThan(0));
 */
                builder.startObject("mappings");
import java.io.IOException;
            client().performRequest(request);
    private void headTestCase(
                        builder.endObject();
                    {
            request.addParameter(param.getKey(), param.getValue());
        createTestDoc();
import static java.util.Collections.emptyMap;
        request.setOptions(expectWarnings(expectedWarnings));
                builder.startObject("settings");
}
                    builder.endObject();
    public void testDocumentExists() throws IOException {
    }
            {
            }
    }
            builder.endObject();
                    builder.startObject("_source");
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.endObject();
 * ownership. Elasticsearch licenses this file to you under
import static java.util.Collections.singletonMap;
                    }
            builder.endObject();
        try (XContentBuilder builder = jsonBuilder()) {
 * GitHub history for details.
            request.setJsonEntity(builder.toString());
/*
 * specific language governing permissions and limitations
            {
            builder.startObject();
        for (Map.Entry<String, String> param : params.entrySet()) {
        headTestCase("/test/_doc/1", singletonMap("pretty", "true"), greaterThan(0));
        headTestCase("/test", singletonMap("pretty", "true"), greaterThan(0));
        }
    }
                builder.endArray();
import org.hamcrest.Matcher;
 * You may obtain a copy of the License at
                    builder.endObject();
 */
        final String url,
    public void testTemplateExists() throws IOException {
        headTestCase("/", singletonMap("pretty", ""), greaterThan(0));
    public void testHeadRoot() throws IOException {
            request.setJsonEntity(builder.toString());
import org.opensearch.client.Request;
            client().performRequest(request);
 * this work for additional information regarding copyright
    public void testException() throws IOException {
                        builder.field("enabled", false);
            }
        }
    ) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
                }
import static org.opensearch.core.rest.RestStatus.OK;
            }
    public void testGetSourceAction() throws IOException {
            builder.startObject();
         * This will throw an index not found exception which will be sent on the channel; previously when handling HEAD requests that would
        createTestDoc();
                }
            builder.startObject();
                            builder.field("index", "test");
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
            client().performRequest(request);
         * a test for this situation.
        assertEquals(expectedStatusCode, response.getStatusLine().getStatusCode());
                    builder.startObject();
 *
 * under the License.
 *
            Request request = new Request("PUT", "/" + indexName + "/_doc/" + "1");
                        builder.startObject("add");
        headTestCase("/index-not-found-exception", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
    public void testAliasExists() throws IOException {
        headTestCase("/test/_source/2", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
            Request request = new Request("PUT", "/_template/template");
            request.setJsonEntity(builder.toString());
        /*
                        {
        Request request = new Request("HEAD", url);
        headTestCase("/test", emptyMap(), greaterThan(0));
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;
                builder.field("test", "test");
        createTestDoc();
    private void headTestCase(final String url, final Map<String, String> params, final Matcher<Integer> matcher) throws IOException {
        headTestCase("/test/_doc/1", emptyMap(), greaterThan(0));
            }
    private void createTestDoc(final String indexName) throws IOException {
        try (XContentBuilder builder = jsonBuilder()) {
        }
                            builder.field("alias", "test_alias");
        headTestCase("/_alias/test_alias", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
 * Unless required by applicable law or agreed to in writing,
        createTestDoc("test");
    private void createTestDoc() throws IOException {
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
            {
                builder.endObject();
        final Matcher<Integer> matcher,
                    {
        final int expectedStatusCode,
        }
                builder.array("index_patterns", "*");
    }
            builder.endObject();
/*
import java.util.Map;
            Request request = new Request("PUT", "/test-no-source");
        headTestCase("/test/_doc/2", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
    }
                    builder.field("number_of_replicas", 0);
         * we now let it rise up to the upstream channel so that it can compute the content length that would be returned. This test case is
    }
            headTestCase("/test-no-source/_source/1", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
import org.opensearch.core.xcontent.XContentBuilder;
        try (XContentBuilder builder = jsonBuilder()) {
        headTestCase("/", emptyMap(), greaterThan(0));
        headTestCase("/test/_source/1", emptyMap(), greaterThan(0));
 * KIND, either express or implied.  See the License for the
         */
 */
            client().performRequest(request);
        assertNull("HEAD requests shouldn't have a response body but " + url + " did", response.getEntity());
                {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            {
                    }
        headTestCase(url, params, OK.getStatus(), matcher);
    }
