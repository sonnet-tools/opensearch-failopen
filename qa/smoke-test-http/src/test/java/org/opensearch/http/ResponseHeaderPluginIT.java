import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;  
            assertThat(response.getHeader("Secret"), equalTo("required"));  
 *
import java.util.ArrayList;
    public void testThatSettingHeadersWorks() throws IOException {
        ArrayList<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
        Request request = new Request("GET", "/_protected");  
 */  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            Response response = e.getResponse();
        plugins.add(TestResponseHeaderPlugin.class);  
 */
 * specific language governing permissions and limitations
    protected boolean addMockHttpTransport() {
 * GitHub history for details.
        Response authResponse = getRestClient().performRequest(request);
 * software distributed under the License is distributed on an
        RequestOptions.Builder options = request.getOptions().toBuilder();
/*  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
 * You may obtain a copy of the License at  
        assertThat(authResponse.getHeader("Secret"), equalTo("granted"));  
 * license agreements. See the NOTICE file distributed with
        } catch(ResponseException e) {  
        return false; // enable http  
/**  
    }
    @Override
 *  
/*
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        return plugins;
import java.io.IOException;  
@AwaitsFix(bugUrl = "flaky test - enable after fix")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import org.opensearch.client.Request;
 * under the License.  
            fail("request should have failed");
            assertThat(response.getStatusLine().getStatusCode(), equalTo(401));
 */
 *
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        request.setOptions(options);  
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1)  
            getRestClient().performRequest(new Request("GET", "/_protected"));
    @Override  
        }
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.client.ResponseException;
        options.addHeader("Secret", "password");
import org.opensearch.plugins.Plugin;
package org.opensearch.http;
 * Modifications Copyright OpenSearch Contributors. See  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
}
import java.util.Collection;
 * Test a rest action that sets special response headers
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
public class ResponseHeaderPluginIT extends HttpSmokeTestCase {
import org.opensearch.client.Response;  
        ensureGreen();
 * ownership. Elasticsearch licenses this file to you under  
        try {  
import org.opensearch.client.RequestOptions;
 * KIND, either express or implied.  See the License for the
    }
        assertThat(authResponse.getStatusLine().getStatusCode(), equalTo(200));
/*
