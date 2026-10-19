 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 */  
 * software distributed under the License is distributed on an
    public void testWarningFailure() {
}
        );  
 * license agreements. See the NOTICE file distributed with
 *  
 * ownership. Elasticsearch licenses this file to you under  
        ProtocolVersion protocol = new ProtocolVersion("HTTP", 1, 1);
        doThrow(expectedException).when(mockClient).performRequest(any());
        when(mockResponse.getHost()).thenReturn(new HttpHost("localhost", 9200));
import static org.mockito.Mockito.when;
 * SPDX-License-Identifier: Apache-2.0
        WarningFailureException exception = expectThrows(WarningFailureException.class, () -> client.info(RequestOptions.DEFAULT));
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;
import java.util.List;
 * specific language governing permissions and limitations
package org.opensearch.client;
 * this file be licensed under the Apache-2.0 license or a
        RequestLine requestLine = new RequestLine(HttpGet.METHOD_NAME, "/_blah", protocol);
    private void setupClient() throws IOException {  
 *
import org.apache.hc.core5.http.message.RequestLine;
import java.util.Collections;
        assertThat(  
    }  
import org.apache.hc.client5.http.classic.methods.HttpGet;
            equalTo("method [GET], host [http://localhost:9200], URI [/_blah], " + "status line [HTTP/1.1 200 OK]")
        client = new RestHighLevelClient(mockClient, RestClient::close, Collections.emptyList());
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        final Response mockResponse = mock(Response.class);
        when(mockResponse.getWarnings()).thenReturn(WARNINGS);
 * KIND, either express or implied.  See the License for the
 *
            exception.getMessage(),
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;  
import org.junit.Before;
    }
 */
        when(mockResponse.getRequestLine()).thenReturn(requestLine);
import static org.mockito.Mockito.doThrow;  
        WarningFailureException expectedException = new WarningFailureException(mockResponse);
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Before
public class MockRestHighLevelTests extends OpenSearchTestCase {
import org.apache.hc.core5.http.ProtocolVersion;  
import static org.mockito.Mockito.any;
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
/*
 */  
import static org.mockito.Mockito.mock;
/*  
/*  
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.message.StatusLine;
 * Unless required by applicable law or agreed to in writing,
        assertNull(exception.getCause());
        assertThat(exception.getResponse().getWarnings(), equalTo(WARNINGS));
        final RestClient mockClient = mock(RestClient.class);
    private static final List<String> WARNINGS = Collections.singletonList("Some Warning");  
        when(mockResponse.getStatusLine()).thenReturn(new StatusLine(protocol, 200, "OK"));
    private RestHighLevelClient client;
