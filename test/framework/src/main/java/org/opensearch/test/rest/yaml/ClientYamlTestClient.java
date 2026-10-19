        setOptions(request, headers);  
        }  
import java.io.UncheckedIOException;
 * SPDX-License-Identifier: Apache-2.0
    private static final Logger logger = LogManager.getLogger(ClientYamlTestClient.class);
            }  
    public Version getClusterManagerVersion() {
        }  
        }
        String apiName,
            .collect(Collectors.toSet());  
    ClientYamlTestClient(  
        }
            Response response = getRestClient(nodeSelector).performRequest(request);  
    }  
        // the rest path to use is randomized out of the matching ones (if more than one)  
        ClientYamlSuiteRestApi restApi = restSpec.getApi(apiName);
import java.util.HashMap;
            }
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
    }
                throw new UncheckedIOException(e);
        if (restApi == null) {
import java.io.IOException;  
 */
    private static final ContentType YAML_CONTENT_TYPE = ContentType.create("application/yaml");
                throw new IllegalArgumentException("body is not supported by [" + restApi.getName() + "] api");  
            }
            return false;  
        assert hosts.size() > 0;
                }
 *
        for (Entry<String, String> pathPart : pathParts.entrySet()) {  
                    queryStringParams.put("source", EntityUtils.toString(entity));
 */  
                    );  
        }
        for (RestClient restClient : restClients.values()) {
 * compatible open source license.
    private final Version esVersion;
        List<String> supportedMethods = Arrays.asList(path.getMethods());
            if (false == restApi.isBodySupported()) {
            if (restApi.isBodyRequired()) {  
            );
                pathParts.put(entry.getKey(), entry.getValue());  
        return restClients.computeIfAbsent(nodeSelector, selector -> {  
import java.io.Closeable;
        });  
        final List<HttpHost> hosts,  
            throw new IllegalArgumentException(
        if (false == contentType.startsWith(ContentType.APPLICATION_JSON.getMimeType())
        if (path.getParts().size() != partNames.size() || path.getParts().containsAll(partNames) == false) {
                finalPath = finalPath.replace("{" + pathPart.getKey() + "}", encodedPathPart);
            .map(Entry::getKey)
            try {
 * KIND, either express or implied.  See the License for the
            restClient.close();
        // We check the warnings ourselves so we don't need the client to do it for us  
        String encoded = URLEncoder.encode(EntityUtils.toString(entity), StandardCharsets.UTF_8);
        String requestMethod;  
    ) {
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestSpec;  
                throw new IllegalArgumentException("body is required by [" + restApi.getName() + "] api");
            try {
                }
    /**  
import java.nio.charset.StandardCharsets;
/*
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.hc.core5.http.ParseException;  
                } else {  
 * license agreements. See the NOTICE file distributed with
            if (path.getParts().contains(entry.getKey())) {
import org.opensearch.client.RestClientBuilder;
            } catch (IOException e) {
package org.opensearch.test.rest.yaml;
    protected static void setOptions(Request request, Map<String, String> headers) {  
import org.apache.hc.client5.http.classic.methods.HttpGet;
            return builder.build();
        Map<String, String> headers,
    /*
        if (entity != null) {
        this.restClients.put(NodeSelector.ANY, restClient);
            return false;
 * Modifications Copyright OpenSearch Contributors. See  
            RestClientBuilder builder;
                // path part separately, as each one might contain slashes that need to be escaped, which needs to be done manually.  
        } catch (ResponseException e) {
     */  
                } else {
        // divide params between ones that go within query string and ones that go within path  
 *
        }
        }  
            throw new ClientYamlTestResponseException(e);  
        String finalPath = path.getPath();
            return false;
                    queryStringParams.put(entry.getKey(), entry.getValue());
import org.apache.hc.core5.http.HttpHost;
            throw new IllegalStateException(  
        if (contentLength > 2000) {
 * Used by {@link OpenSearchClientYamlSuiteTestCase} to execute REST requests according to the tests written in yaml suite files. Wraps a  
            // Long bodies won't fit in the parameter and will cause a too_long_frame_exception
 * specific language governing permissions and limitations
    }
    }
    }  
        HttpEntity entity,  
        final ClientYamlSuiteRestSpec restSpec,
    private ClientYamlSuiteRestApi restApi(String apiName) {  
                throw new RuntimeException("unable to build uri", e);
import org.apache.hc.core5.http.ContentType;  
 */  
    protected RestClient getRestClient(NodeSelector nodeSelector) {
     * Calls an api with the provided parameters and body
                // manually escape any slash that each part may contain  
        // lazily build a new client in case we need to point to some specific node
    @Override
import java.net.URISyntaxException;  
import java.util.stream.Collectors;  
    }
                String encodedPathPart = uri.getRawPath().substring(1).replaceAll("/", "%2F");
            // We can only encode JSON or YAML this way.
        RequestOptions.Builder options = request.getOptions().toBuilder();
            .stream()  
import java.util.List;
            && false == contentType.startsWith(YAML_CONTENT_TYPE.getMimeType())) {  
    }  
 *  
        Set<String> apiRequiredParameters = restApi.getParams()
                    entity = null;
import org.apache.logging.log4j.LogManager;
        for (Map.Entry<String, String> header : headers.entrySet()) {
            .entrySet()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * under the License.  
 * GitHub history for details.
import org.opensearch.client.Response;
            } catch (URISyntaxException e) {  
                    queryStringParams.put("source_content_type", contentType);
 * software distributed under the License is distributed on an
        for (Map.Entry<String, String> param : queryStringParams.entrySet()) {
                // Encode rules for path and query string parameters are different. We use URI to encode the path. We need to encode each
 *     http://www.apache.org/licenses/LICENSE-2.0
     * url and other params.
    private final Map<NodeSelector, RestClient> restClients = new HashMap<>();
            builder.setNodeSelector(selector);
        for (Map.Entry<String, String> entry : params.entrySet()) {
                    requestMethod = HttpGet.METHOD_NAME;  
import org.opensearch.client.WarningsHandler;  
            return false;  
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestApi;
            options.addHeader(header.getKey(), header.getValue());
        }  
 * {@link RestClient} instance used to send the REST requests. Holds the {@link ClientYamlSuiteRestSpec} used to translate api calls into
        request.setOptions(options);
import org.opensearch.client.NodeSelector;
/*
import org.opensearch.client.RestClient;
public class ClientYamlTestClient implements Closeable {
        NodeSelector nodeSelector
        final Version esVersion,
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IllegalArgumentException("rest api [" + apiName + "] doesn't exist in the rest spec");  
            // Negative length means "unknown" or "huge" in this case. Either way we can't send it as a parameter
        options.setWarningsHandler(WarningsHandler.PERMISSIVE);
    private static boolean isUrlEncodedLengthUnderLimit(HttpEntity entity) throws IOException, ParseException {
        Map<String, String> pathParts = new HashMap<>();
        } else {
import java.util.Arrays;  
 * this file be licensed under the Apache-2.0 license or a
            } else if (restApi.getParams().containsKey(entry.getKey())
            }
    ) throws IOException {  
        return restApi;
                "missing required parameter: " + apiRequiredParameters + " by [" + restApi.getName() + "] api"  
    private final Version clusterManagerVersion;  
            return new ClientYamlTestResponse(response);
import org.opensearch.client.Request;  
 * REST calls.
        request.setEntity(entity);
/*  
            }
            } catch (final ParseException ex) {
                || restSpec.isGlobalParameter(entry.getKey())
import java.net.URLEncoder;
        }
        Request request = new Request(requestMethod, finalPath);
        List<ClientYamlSuiteRestApi.Path> bestPaths = restApi.getBestMatchingPaths(params.keySet());
        if (false == supportedMethods.contains(HttpGet.METHOD_NAME)) {
        final RestClient restClient,
}
 * not use this file except in compliance with the License.
                    requestMethod = RandomizedTest.randomFrom(supportedMethods);  
        Map<String, String> queryStringParams = new HashMap<>();
        Set<String> partNames = pathParts.keySet();
            // The API doesn't claim to support GET anyway
        final CheckedSupplier<RestClientBuilder, IOException> clientBuilderWithSniffedNodes  
                    throw new IllegalArgumentException(
     * We check if the length of the url-encoded source parameter is less than 3000, leaving remaining for
        return esVersion;
        return clusterManagerVersion;  
            logger.debug("Adding header {} with value {}", header.getKey(), header.getValue());  
        Map<String, String> params,
import org.opensearch.common.CheckedSupplier;
            String contentType = entity.getContentType();
 * Licensed to Elasticsearch under one or more contributor  
    }
        if (contentLength < 0) {  
        this.clusterManagerVersion = clusterManagerVersion;  
            .filter(Entry::getValue)
                        "path/param [" + entry.getKey() + "] not supported by [" + restApi.getName() + "] " + "api"
        return RandomizedTest.rarely() && isUrlEncodedLengthUnderLimit(entity);
                // We prepend "/" to the path part to handle parts that start with - or other invalid characters.
        ClientYamlSuiteRestApi.Path path = RandomizedTest.randomFrom(bestPaths);
/**
                URI uri = new URI(null, null, null, -1, "/" + pathPart.getValue(), null, null);
    private final CheckedSupplier<RestClientBuilder, IOException> clientBuilderWithSniffedNodes;
        logger.debug("calling api [{}]", apiName);  
     */
        return encoded.length() < 3000;  
        }
        this.restSpec = restSpec;  
import java.util.Map;  
            request.addParameter(param.getKey(), param.getValue());  
            );
                || restSpec.isClientParameter(entry.getKey())) {  
            try {
        ParseException {  
 */
 * You may obtain a copy of the License at  
import java.util.Map.Entry;
            requestMethod = RandomizedTest.randomFrom(supportedMethods);  
    private static boolean sendBodyAsSourceParam(List<String> supportedMethods, String contentType, HttpEntity entity) throws IOException,
                builder = clientBuilderWithSniffedNodes.get();  
        if (false == apiRequiredParameters.isEmpty()) {
    public Version getEsVersion() {
                throw new IOException(ex);  
        long contentLength = entity.getContentLength();
import org.opensearch.Version;
    private final ClientYamlSuiteRestSpec restSpec;  
import org.opensearch.client.RequestOptions;
import java.net.URI;
        }
        final Version clusterManagerVersion,
        }
    public ClientYamlTestResponse callApi(  
        }  
     * There is a limit of 4096 bytes for the HTTP line, otherwise there will be too_long_http_line_exception.  
                    logger.debug("sending the request body as source param with GET method");  
        }
        this.esVersion = esVersion;
            // randomly test the GET with source param instead of GET/POST with body  
import com.carrotsearch.randomizedtesting.RandomizedTest;  
                    apiRequiredParameters.remove(entry.getKey());
    public void close() throws IOException {  
        ClientYamlSuiteRestApi restApi = restApi(apiName);
import org.opensearch.client.ResponseException;  
        this.clientBuilderWithSniffedNodes = clientBuilderWithSniffedNodes;
import org.apache.logging.log4j.Logger;  
                "provided path parts don't match the best matching path: " + path.getParts() + " - " + partNames
 * Unless required by applicable law or agreed to in writing,
import java.util.Set;
        try {
    }  
import org.apache.hc.core5.http.HttpEntity;
                if (sendBodyAsSourceParam(supportedMethods, contentType, entity)) {
