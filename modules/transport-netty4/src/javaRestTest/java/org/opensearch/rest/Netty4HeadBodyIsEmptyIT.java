package org.opensearch.rest;
 * Licensed to Elasticsearch under one or more contributor
            request.setJsonEntity(builder.toString());
                    builder.field("number_of_replicas", 0);
            Request request = new Request("POST", "/_aliases");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Map;
        final String... expectedWarnings
        createTestDoc();
                builder.startObject("settings");
            {
            {
                        builder.field("enabled", false);
                    }
 * Unless required by applicable law or agreed to in writing,
                            builder.field("index", "test");
        headTestCase("/test", singletonMap("pretty", "true"), greaterThan(0));
        try (XContentBuilder builder = jsonBuilder()) {
    public void testException() throws IOException {
    }
            builder.endObject();
 */
 * You may obtain a copy of the License at
                        builder.startObject("add");
public class Netty4HeadBodyIsEmptyIT extends OpenSearchRestTestCase {
 * SPDX-License-Identifier: Apache-2.0
                    builder.endObject();
        try (XContentBuilder builder = jsonBuilder()) {
        headTestCase("/test/_source/1", emptyMap(), greaterThan(0));
        assertEquals(expectedStatusCode, response.getStatusLine().getStatusCode());
        createTestDoc();
         * a test for this situation.
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                {
        headTestCase("/index-not-found-exception", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
    }
 * software distributed under the License is distributed on an
            builder.startObject();
                    {
            Request request = new Request("PUT", "/_template/template");
            }
 * under the License.
    public void testAliasDoesNotExist() throws IOException {
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
        final int expectedStatusCode,
import org.opensearch.test.rest.OpenSearchRestTestCase;
    }
                }
        /*
        headTestCase("/test/_doc/1", emptyMap(), greaterThan(0));
 * KIND, either express or implied.  See the License for the
 */
         * throw an exception, the content was swallowed and a content length header of zero was returned. Instead of swallowing the content
 * not use this file except in compliance with the License.
            }
    private void createTestDoc() throws IOException {
        final Map<String, String> params,
        headTestCase("/_alias/test_alias", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
            builder.endObject();
                builder.endObject();
                        }
 * this file be licensed under the Apache-2.0 license or a
        createTestDoc();
    public void testHeadRoot() throws IOException {
}
import org.opensearch.client.Request;
                {
        createTestDoc();
                builder.startArray("actions");
 * license agreements. See the NOTICE file distributed with
    public void testAliasExists() throws IOException {
import org.hamcrest.Matcher;
 * specific language governing permissions and limitations
    public void testGetSourceAction() throws IOException {
import org.opensearch.client.Response;
        headTestCase("/test", emptyMap(), greaterThan(0));
            }
                }
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
                builder.endArray();
    }
        headTestCase("/test/_doc/2", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
        assertThat(Integer.valueOf(response.getHeader("Content-Length")), matcher);
                    {
    }
import static org.hamcrest.Matchers.greaterThan;
        headTestCase("/test/_doc/1", singletonMap("pretty", "true"), greaterThan(0));
            builder.startObject();
            request.setJsonEntity(builder.toString());
/*
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;
            headTestCase("/_alias/test_alias", emptyMap(), greaterThan(0));
 */
                builder.endObject();
            request.setJsonEntity(builder.toString());
    public void testIndexExists() throws IOException {
            builder.startObject();
        headTestCase(url, params, OK.getStatus(), matcher);
 * GitHub history for details.
    public void testTemplateExists() throws IOException {
        final Matcher<Integer> matcher,
        headTestCase("/test/_alias/test_alias", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
    }
            builder.startObject();
    }
                    }
            }
    }
                builder.array("index_patterns", "*");
import static java.util.Collections.emptyMap;
                            builder.field("alias", "test_alias");
        final String url,
    private void headTestCase(final String url, final Map<String, String> params, final Matcher<Integer> matcher) throws IOException {
        try (XContentBuilder builder = jsonBuilder()) {
            headTestCase("/test/_alias/test_alias", emptyMap(), greaterThan(0));
 *
                        builder.endObject();
        Request request = new Request("HEAD", url);
/*
        Response response = client().performRequest(request);
         * This will throw an index not found exception which will be sent on the channel; previously when handling HEAD requests that would
        }
                {
        createTestDoc("test");
                    builder.startObject();
    private void headTestCase(
         * we now let it rise up to the upstream channel so that it can compute the content length that would be returned. This test case is
            client().performRequest(request);
        try (XContentBuilder builder = jsonBuilder()) {
                        {
        }
import static org.opensearch.core.rest.RestStatus.OK;
        }
        headTestCase("/test/_source/2", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
                    builder.endObject();
        createTestDoc();
        for (Map.Entry<String, String> param : params.entrySet()) {
         */
            {
    }
 *
            builder.endObject();
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under
            headTestCase("/test-no-source/_source/1", emptyMap(), NOT_FOUND.getStatus(), greaterThan(0));
            Request request = new Request("PUT", "/" + indexName + "/_doc/" + "1");
        assertNull("HEAD requests shouldn't have a response body but " + url + " did", response.getEntity());
                    builder.startObject("_source");
    }
        headTestCase("/", emptyMap(), greaterThan(0));
            client().performRequest(request);
        headTestCase("/", singletonMap("pretty", ""), greaterThan(0));
 *
                }
            request.addParameter(param.getKey(), param.getValue());
            request.setJsonEntity(builder.toString());
        }
            {
            createTestDoc("test-no-source");
/*
 * this work for additional information regarding copyright
        headTestCase("/", singletonMap("pretty", "true"), greaterThan(0));
    ) throws IOException {
            headTestCase("/_template/template", emptyMap(), greaterThan(0));
            client().performRequest(request);
                builder.startObject("mappings");
import java.io.IOException;
import static java.util.Collections.singletonMap;
            Request request = new Request("PUT", "/test-no-source");
    private void createTestDoc(final String indexName) throws IOException {
            builder.endObject();
    public void testDocumentExists() throws IOException {
                builder.field("test", "test");
        request.setOptions(expectWarnings(expectedWarnings));
            client().performRequest(request);
        }
