 * ownership. Elasticsearch licenses this file to you under  
            () -> client().performRequest(new Request(randomBoolean() ? "POST" : "GET", "/_search/template"))
 *    http://www.apache.org/licenses/LICENSE-2.0
        ResponseException responseException = expectThrows(  
        );  
 */  
 * specific language governing permissions and limitations
import org.opensearch.client.Request;
 * software distributed under the License is distributed on an
        assertThat(responseException.getMessage(), containsString("request body or source parameter is required"));
/*  
            () -> client().performRequest(new Request(randomBoolean() ? "POST" : "GET", "/_msearch/template"))
import org.opensearch.client.ResponseException;
import static org.hamcrest.CoreMatchers.containsString;
 * this file be licensed under the Apache-2.0 license or a
 *  
 * license agreements. See the NOTICE file distributed with
    }  
 * not use this file except in compliance with the License.
    }  
 */  
 * GitHub history for details.
 * under the License.  
    public void testSearchTemplateMissingBody() throws IOException {
/*
package org.opensearch.script.mustache;
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        assertThat(responseException.getMessage(), containsString("request body or source parameter is required"));
import org.opensearch.test.rest.OpenSearchRestTestCase;  
            ResponseException.class,
}
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
 *
        assertEquals(400, responseException.getResponse().getStatusLine().getStatusCode());
        assertEquals(400, responseException.getResponse().getStatusLine().getStatusCode());
 *
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ResponseException.class,
 * KIND, either express or implied.  See the License for the
public class SearchTemplateWithoutContentIT extends OpenSearchRestTestCase {  
        );  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 */
        ResponseException responseException = expectThrows(  
    public void testMultiSearchTemplateMissingBody() throws IOException {
