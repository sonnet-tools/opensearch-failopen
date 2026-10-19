package org.opensearch.http;
        Request request = new Request("POST", "/company/_doc/1");
 * compatible open source license.
 */
import org.opensearch.client.Response;
import org.opensearch.test.rest.OpenSearchRestTestCase;
        assertThat(response.getEntity(), is(not(instanceOf(GzipDecompressingEntity.class))));  
 * KIND, either express or implied.  See the License for the
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;  
    private static final String SAMPLE_DOCUMENT = """
/*
import org.opensearch.client.RequestOptions;  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(GZIP_ENCODING, response.getHeader(HttpHeaders.CONTENT_ENCODING));  
                .addHeader(HttpHeaders.ACCEPT_ENCODING, "identity")
           }
        assertEquals(200, response.getStatusLine().getStatusCode());
}
 * Licensed to Elasticsearch under one or more contributor  
        // See please https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/Accept-Encoding  
        assertEquals(GZIP_ENCODING, response.getHeader(HttpHeaders.CONTENT_ENCODING));  
        request.setJsonEntity(SAMPLE_DOCUMENT);
           "name": {
 * under the License.  
 * GitHub history for details.
        Request request = new Request("POST", "/company/_doc/2");
 *  
 * ownership. Elasticsearch licenses this file to you under  
        }
        assertEquals(201, response.getStatusLine().getStatusCode());
 * software distributed under the License is distributed on an
 *
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(response.getEntity(), is(not(instanceOf(GzipDecompressingEntity.class))));
        assertEquals(200, response.getStatusLine().getStatusCode());
        {  
/*
import org.opensearch.client.Request;
        assertThat(body, containsString(SAMPLE_DOCUMENT));  
        request.setJsonEntity(SAMPLE_DOCUMENT);  
        Response response = client().performRequest(new Request("GET", "/"));
import java.io.IOException;
import org.apache.hc.client5.http.entity.GzipDecompressingEntity;  
        assertEquals(GZIP_ENCODING, response.getHeader(HttpHeaders.CONTENT_ENCODING));
import static org.hamcrest.CoreMatchers.is;
        response = client().performRequest(request);
              "last name": "Jobs"  
    }
 * The OpenSearch Contributors require contributions made to  
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.ParseException;
 *
 * Unless required by applicable law or agreed to in writing,
    }
 * not use this file except in compliance with the License.
        String body = EntityUtils.toString(response.getEntity());
        RequestOptions requestOptions = RequestOptions.DEFAULT.toBuilder()
        response = client().performRequest(request);  
 * You may obtain a copy of the License at  
import static org.hamcrest.CoreMatchers.not;  
    public void testUncompressesResponseIfRequested() throws IOException, ParseException {
        assertEquals(201, response.getStatusLine().getStatusCode());
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    private static final String GZIP_ENCODING = "gzip";
import static org.hamcrest.CoreMatchers.containsString;  
 */
                .build();  
public class HttpCompressionIT extends OpenSearchRestTestCase {
import static org.hamcrest.CoreMatchers.instanceOf;
        assertThat(response.getEntity(), instanceOf(ByteArrayEntity.class));  
        """;  
        Response response = client().performRequest(request);  
 * this work for additional information regarding copyright
import org.apache.hc.core5.http.io.entity.EntityUtils;
 */  
        assertNull(response.getHeader(HttpHeaders.CONTENT_ENCODING));
        request = new Request("GET", "/company/_doc/2");
              "first name": "Steve",
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
        request.setOptions(requestOptions);  
    public void testCompressedResponseByDefault() throws IOException {  
