 */  
    }
import com.google.api.client.json.Json;
        if (resource == null) {
/*  
        return readJsonResponse(url, "http://metadata.google.internal/");
 * Licensed to Elasticsearch under one or more contributor  
                            response.setContent(readGoogleApiJsonResponse(url));  
            return sb.toString();
                return new MockLowLevelHttpRequest() {  
                    @Override
    public static String readGoogleInternalJsonResponse(String url) throws IOException {
public class GceMockUtils {  
import java.io.InputStream;  
            final StringBuilder sb = new StringBuilder();  
import com.google.api.client.http.HttpTransport;
 * software distributed under the License is distributed on an
 */  
                        } else {
 * Modifications Copyright OpenSearch Contributors. See
        URL resource = GceMockUtils.class.getResource(mockFileName);
                        if (url.startsWith(GCE_METADATA_URL)) {  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.LogManager;
            }  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        return new MockHttpTransport() {  
import com.google.api.client.testing.http.MockHttpTransport;
            public LowLevelHttpRequest buildRequest(String method, final String url) throws IOException {
                };
 *    http://www.apache.org/licenses/LICENSE-2.0
                        response.setStatusCode(200);
    protected static final Logger logger = LogManager.getLogger(GceMockUtils.class);
 * SPDX-License-Identifier: Apache-2.0
    private static String readJsonResponse(String url, String urlRoot) throws IOException {  
    }
            throw new IOException("can't read [" + url + "] in src/test/resources/org/opensearch/discovery/gce");  
import java.net.URL;
                            logger.info("--> Simulate GCE Auth/Metadata response for [{}]", url);
    public static final String GCE_METADATA_URL = "http://metadata.google.internal/computeMetadata/v1/";  
            @Override
 * this work for additional information regarding copyright
import org.opensearch.core.util.FileSystemUtils;  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
import org.apache.logging.log4j.Logger;  
    }  
 * GitHub history for details.
    public static String readGoogleApiJsonResponse(String url) throws IOException {
                            response.addHeader("Metadata-Flavor", "Google");  
    }
package org.opensearch.discovery.gce;
 *
 * under the License.  
}
                        response.setContentType(Json.MEDIA_TYPE);
                            response.setContent(readGoogleInternalJsonResponse(url));
            Streams.readAllLines(is, sb::append);
    protected static HttpTransport configureMock() {
import org.opensearch.core.common.Strings;
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
/*
 * ownership. Elasticsearch licenses this file to you under  
        }  
/*  
 * The OpenSearch Contributors require contributions made to  
                            logger.info("--> Simulate GCE API response for [{}]", url);
        String mockFileName = Strings.replace(url, urlRoot, "");
import com.google.api.client.testing.http.MockLowLevelHttpRequest;  
        };
import org.opensearch.common.io.Streams;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.http.LowLevelHttpResponse;  
        try (InputStream is = FileSystemUtils.openFileURLStream(resource)) {
 */
 * not use this file except in compliance with the License.
 *  
                    }
        return readJsonResponse(url, "https://www.googleapis.com/");  
 * the Apache License, Version 2.0 (the "License"); you may
                    public LowLevelHttpResponse execute() throws IOException {
        }
        // We extract from the url the mock file path we want to use
                        }
                        MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();  
                        return response;  
import com.google.api.client.http.LowLevelHttpRequest;
import java.io.IOException;
