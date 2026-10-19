 *
/*  
        if ("raw".equals(apiName)) {
 * this work for additional information regarding copyright
        NodeSelector nodeSelector
    ) {  
                return new ClientYamlTestResponse(response);  
import java.util.Objects;
 *
import org.opensearch.client.ResponseException;
/**
    public ClientYamlTestResponse callApi(
    public ClientYamlDocsTestClient(
import org.opensearch.Version;  
            request.setEntity(entity);
    @Override
 * The OpenSearch Contributors require contributions made to  
        final List<HttpHost> hosts,
 * You may obtain a copy of the License at  
        super(restSpec, restClient, hosts, esVersion, clusterManagerVersion, clientBuilderWithSniffedNodes);
 * under the License.  
            }  
            } catch (ResponseException e) {
 * REST calls. Supports raw requests besides the usual api calls based on the rest spec.
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.client.Request;
        Map<String, String> headers,  
/*
import java.util.Map;
}
import java.io.IOException;
 * {@link RestClient} instance used to send the REST requests. Holds the {@link ClientYamlSuiteRestSpec} used to translate api calls into  
        String apiName,  
                throw new ClientYamlTestResponseException(e);
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
            Map<String, String> queryStringParams = new HashMap<>(params);  
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    ) throws IOException {
import org.opensearch.client.RestClient;
            // Raw requests don't use the rest spec at all and are configured entirely by their parameters
 * Licensed to Elasticsearch under one or more contributor  
            Request request = new Request(method, path);  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
                request.addParameter(param.getKey(), param.getValue());  
        Map<String, String> params,
import org.opensearch.common.CheckedSupplier;
 * license agreements. See the NOTICE file distributed with
            String method = Objects.requireNonNull(queryStringParams.remove("method"), "Method must be set to use raw request");
            }
        final Version esVersion,  
import java.util.HashMap;
 * software distributed under the License is distributed on an
        HttpEntity entity,
            for (Map.Entry<String, String> param : queryStringParams.entrySet()) {
 */
import org.opensearch.client.Response;  
 * Used to execute REST requests according to the docs snippets that need to be tests. Wraps a
package org.opensearch.test.rest.yaml;
        final CheckedSupplier<RestClientBuilder, IOException> clientBuilderWithSniffedNodes
 *  
import java.util.List;  
 */
    }  
 */  
import org.opensearch.client.NodeSelector;
        final ClientYamlSuiteRestSpec restSpec,  
public final class ClientYamlDocsTestClient extends ClientYamlTestClient {  
            try {
    }
import org.apache.hc.core5.http.HttpEntity;
            setOptions(request, headers);  
 * KIND, either express or implied.  See the License for the
            String path = "/" + Objects.requireNonNull(queryStringParams.remove("path"), "Path must be set to use raw request");
import org.opensearch.client.RestClientBuilder;  
        return super.callApi(apiName, params, entity, headers, nodeSelector);
 */  
        final Version clusterManagerVersion,
        }
        final RestClient restClient,
 * compatible open source license.
import org.apache.hc.core5.http.HttpHost;
 * GitHub history for details.
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestSpec;
            // All other parameters are url parameters
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Response response = getRestClient(nodeSelector).performRequest(request);
 * specific language governing permissions and limitations
