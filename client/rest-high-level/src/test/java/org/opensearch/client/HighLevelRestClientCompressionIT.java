import java.io.IOException;
        SearchResponse searchResponse = execute(searchRequest, highLevelClient()::search, highLevelClient()::searchAsync, requestOptions);  
import org.apache.hc.client5.http.classic.methods.HttpPost;
        doc.setJsonEntity(SAMPLE_DOCUMENT);
 * You may obtain a copy of the License at  
    }
 *
import org.apache.hc.client5.http.impl.classic.HttpClients;  
                assertThat(response.getCode(), equalTo(201));
 * software distributed under the License is distributed on an
 * under the License.  
/*  
                assertThat(response.getCode(), equalTo(200));
            final HttpGet refresh = new HttpGet(baseUri.resolve("/_refresh"));
public class HighLevelRestClientCompressionIT extends OpenSearchRestHighLevelClientTestCase {
            try (CloseableHttpResponse response = client.execute(search)) {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.search.SearchResponse;
            final HttpPost search = new HttpPost(baseUri.resolve("/_search"));
 * this file be licensed under the Apache-2.0 license or a
        client().performRequest(doc);  
    private static final String GZIP_ENCODING = "gzip";  
import org.apache.hc.client5.http.entity.GzipCompressingEntity;  
            }  
     * The default CloseableHttpAsyncClient does not support compression out of the box (so that applies to RestClient
            index.setEntity(new GzipCompressingEntity(new StringEntity("{}", ContentType.APPLICATION_JSON)));
                assertThat(response.getCode(), equalTo(200));
 */  
        assertThat(searchResponse.status().getStatus(), equalTo(200));
package org.opensearch.client;
import org.opensearch.action.search.SearchRequest;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 *  
import java.net.URI;
        assertEquals(1L, searchResponse.getHits().getTotalHits().value());  
        Request doc = new Request(HttpPut.METHOD_NAME, "/company/_doc/1");
 */
            final URI baseUri = new URI(node.getHost().toURI());  
        RequestOptions requestOptions = RequestOptions.DEFAULT.toBuilder().addHeader(HttpHeaders.ACCEPT_ENCODING, GZIP_ENCODING).build();  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
        try (CloseableHttpClient client = HttpClients.custom().build()) {
        assertEquals(SAMPLE_DOCUMENT, searchResponse.getHits().getHits()[0].getSourceAsString());
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.equalTo;
/*
            index.setEntity(new GzipCompressingEntity(new StringEntity(SAMPLE_DOCUMENT, ContentType.APPLICATION_JSON)));  
 * KIND, either express or implied.  See the License for the
     * and RestHighLevelClient). To check the compression works on both sides, crafting the request using CloseableHttpClient  
/*
 */
    public void testCompressesRequest() throws IOException, URISyntaxException {  
        client().performRequest(new Request(HttpPost.METHOD_NAME, "/_refresh"));
import org.apache.hc.client5.http.classic.methods.HttpGet;  
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ContentType;
        }  
     */
import org.apache.hc.client5.http.classic.methods.HttpPut;
    private static final String SAMPLE_DOCUMENT = "{\"name\":{\"first name\":\"Steve\",\"last name\":\"Jobs\"}}";
import org.apache.hc.core5.http.io.entity.StringEntity;  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    /**
import org.apache.hc.core5.http.HttpHeaders;
     * instead which uses compression by default.
 * Modifications Copyright OpenSearch Contributors. See  
        SearchRequest searchRequest = new SearchRequest("company");
 * specific language governing permissions and limitations
import java.net.URISyntaxException;  
            try (CloseableHttpResponse response = client.execute(index)) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
            try (CloseableHttpResponse response = client.execute(refresh)) {  
            final Node node = client().getNodes().iterator().next();
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
    public void testCompressesResponseIfRequested() throws IOException {  
            final HttpPut index = new HttpPut(baseUri.resolve("/company/_doc/1"));
            }
            }
