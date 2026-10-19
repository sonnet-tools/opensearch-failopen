package org.opensearch.wildfly.transport;
 * under the License.  
 */  
        return PathUtils.get(OpenSearchProperties);  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    }
    private Path getPath(final String OpenSearchProperties) {
 * GitHub history for details.
import org.opensearch.client.RestClient;
import org.opensearch.common.SuppressForbidden;
 * ownership. Elasticsearch licenses this file to you under  
        String httpUri = System.getProperty("opensearch.uri");
/*
 * specific language governing permissions and limitations
 * compatible open source license.
import jakarta.enterprise.inject.Produces;
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 *
    public RestHighLevelClient createRestHighLevelClient() throws URISyntaxException {
import org.opensearch.common.io.PathUtils;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
import java.net.URISyntaxException;
 * license agreements. See the NOTICE file distributed with
@SuppressWarnings("unused")  
    }
import org.apache.hc.core5.http.HttpHost;
        return new RestHighLevelClient(RestClient.builder(HttpHost.create(httpUri)));
import org.opensearch.client.RestHighLevelClient;  
 *
    @Produces  
public final class RestHighLevelClientProducer {
 * Licensed to Elasticsearch under one or more contributor  
}
import java.nio.file.Path;
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @SuppressForbidden(reason = "get path not configured in environment")
 * this work for additional information regarding copyright
/*  
 */
 */  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
