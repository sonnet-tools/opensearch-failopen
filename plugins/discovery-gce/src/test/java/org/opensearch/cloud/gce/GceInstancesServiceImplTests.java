/*  
 * SPDX-License-Identifier: Apache-2.0
            @Override
 */
                        return response;
        };
                        response.setContent("value");
}  
 * this work for additional information regarding copyright
                    @Override
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
        addMetdataFlavor.set(true);  
import com.google.api.client.testing.http.MockLowLevelHttpResponse;  
                        response.setStatusCode(200);
 * license agreements. See the NOTICE file distributed with
        final String serviceURL = "/computeMetadata/v1/project/project-id";  
 * GitHub history for details.
import com.google.api.client.http.LowLevelHttpResponse;
 *  
 */  
                    }  
 * compatible open source license.
import static org.hamcrest.core.Is.is;
 * the Apache License, Version 2.0 (the "License"); you may
            }
 *
                    public LowLevelHttpResponse execute() {  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
                };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override  
import org.opensearch.test.OpenSearchTestCase;
package org.opensearch.cloud.gce;
            public LowLevelHttpRequest buildRequest(String method, final String url) {  
    }
 * ownership. Elasticsearch licenses this file to you under  
                return new MockLowLevelHttpRequest() {
                return transport;
/*
        assertThat(service.getAppEngineValueFromMetadataServer(serviceURL), is(nullValue()));
 * You may obtain a copy of the License at  
import com.google.api.client.json.Json;  
public class GceInstancesServiceImplTests extends OpenSearchTestCase {  
                        if (addMetdataFlavor.get()) {
        };  
import static org.hamcrest.CoreMatchers.nullValue;  
        final AtomicBoolean addMetdataFlavor = new AtomicBoolean();  
 * this file be licensed under the Apache-2.0 license or a
/*
 * not use this file except in compliance with the License.
import java.util.concurrent.atomic.AtomicBoolean;
 * Modifications Copyright OpenSearch Contributors. See  
 *
import com.google.api.client.http.LowLevelHttpRequest;
                        }
 * under the License.  
        assertThat(service.getAppEngineValueFromMetadataServer(serviceURL), is("value"));
            protected synchronized HttpTransport getGceHttpTransport() {
                            response.addHeader("Metadata-Flavor", "Google");  
 * The OpenSearch Contributors require contributions made to  
    public void testHeaderContainsMetadataFlavor() throws Exception {
            }  
 * Licensed to Elasticsearch under one or more contributor  
import com.google.api.client.testing.http.MockHttpTransport;
                        response.setContentType(Json.MEDIA_TYPE);  
import org.opensearch.common.settings.Settings;
                        MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
        final GceInstancesServiceImpl service = new GceInstancesServiceImpl(Settings.EMPTY) {
 * Unless required by applicable law or agreed to in writing,
        final MockHttpTransport transport = new MockHttpTransport() {
import com.google.api.client.http.HttpTransport;  
 */
