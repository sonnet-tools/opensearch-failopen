 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
            // We can only encode JSON or YAML this way.
            throw new IllegalArgumentException("rest api [" + apiName + "] doesn't exist in the rest spec");
        this.clusterManagerVersion = clusterManagerVersion;
                throw new RuntimeException("unable to build uri", e);
    private final Version esVersion;
                } else {
        request.setOptions(options);
        for (Entry<String, String> pathPart : pathParts.entrySet()) {
import org.opensearch.client.RestClientBuilder;
import com.carrotsearch.randomizedtesting.RandomizedTest;
        if (path.getParts().size() != partNames.size() || path.getParts().containsAll(partNames) == false) {
        if (false == apiRequiredParameters.isEmpty()) {
            // Negative length means "unknown" or "huge" in this case. Either way we can't send it as a parameter
        // divide params between ones that go within query string and ones that go within path
        setOptions(request, headers);
            .map(Entry::getKey)
        Map<String, String> pathParts = new HashMap<>();
                "missing required parameter: " + apiRequiredParameters + " by [" + restApi.getName() + "] api"
 * Licensed to Elasticsearch under one or more contributor
                    queryStringParams.put("source", EntityUtils.toString(entity));
        ClientYamlSuiteRestApi.Path path = RandomizedTest.randomFrom(bestPaths);
            restClient.close();
                    apiRequiredParameters.remove(entry.getKey());
        List<String> supportedMethods = Arrays.asList(path.getMethods());
import org.opensearch.client.Response;
                // path part separately, as each one might contain slashes that need to be escaped, which needs to be done manually.
                    throw new IllegalArgumentException(
        final RestClient restClient,
 * under the License.
 */
        final ClientYamlSuiteRestSpec restSpec,
 * The OpenSearch Contributors require contributions made to
                throw new UncheckedIOException(e);
        RequestOptions.Builder options = request.getOptions().toBuilder();
     * Calls an api with the provided parameters and body
import org.opensearch.client.WarningsHandler;
            throw new ClientYamlTestResponseException(e);
    }
import java.net.URLEncoder;
        ClientYamlSuiteRestApi restApi = restApi(apiName);
 */
                pathParts.put(entry.getKey(), entry.getValue());
import java.net.URI;
    }
import org.opensearch.client.RequestOptions;
        });
import org.opensearch.client.RestClient;
            );
                } else {
import org.opensearch.client.Request;
        }
     */
 * ownership. Elasticsearch licenses this file to you under
 * Used by {@link OpenSearchClientYamlSuiteTestCase} to execute REST requests according to the tests written in yaml suite files. Wraps a
/*
                // manually escape any slash that each part may contain
        return esVersion;
    public Version getEsVersion() {
    }
                finalPath = finalPath.replace("{" + pathPart.getKey() + "}", encodedPathPart);
        final List<HttpHost> hosts,
 * license agreements. See the NOTICE file distributed with
/**
            throw new IllegalArgumentException(
    protected RestClient getRestClient(NodeSelector nodeSelector) {
                || restSpec.isGlobalParameter(entry.getKey())
        for (Map.Entry<String, String> entry : params.entrySet()) {
}
            .entrySet()
            request.addParameter(param.getKey(), param.getValue());
    }
import java.io.UncheckedIOException;
        request.setEntity(entity);
    ) {
        for (RestClient restClient : restClients.values()) {
            return false;
 */
        if (contentLength > 2000) {
            RestClientBuilder builder;
 * this file be licensed under the Apache-2.0 license or a
                    entity = null;
                builder = clientBuilderWithSniffedNodes.get();
        return restClients.computeIfAbsent(nodeSelector, selector -> {
import org.apache.logging.log4j.LogManager;
import java.util.stream.Collectors;
                    requestMethod = HttpGet.METHOD_NAME;
            }
        }
            try {
 * Unless required by applicable law or agreed to in writing,
        }
                "provided path parts don't match the best matching path: " + path.getParts() + " - " + partNames
import java.net.URISyntaxException;
 *
    /*
            return new ClientYamlTestResponse(response);
        for (Map.Entry<String, String> param : queryStringParams.entrySet()) {
            builder.setNodeSelector(selector);
            } catch (URISyntaxException e) {
                // We prepend "/" to the path part to handle parts that start with - or other invalid characters.
        Request request = new Request(requestMethod, finalPath);
    }
    private ClientYamlSuiteRestApi restApi(String apiName) {
        HttpEntity entity,
            if (false == restApi.isBodySupported()) {
                String encodedPathPart = uri.getRawPath().substring(1).replaceAll("/", "%2F");
        logger.debug("calling api [{}]", apiName);
        if (entity != null) {
        Map<String, String> queryStringParams = new HashMap<>();
        }
import org.apache.hc.core5.http.HttpHost;
            // randomly test the GET with source param instead of GET/POST with body
        String finalPath = path.getPath();
     * url and other params.
        Map<String, String> headers,
        ParseException {
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestApi;
        for (Map.Entry<String, String> header : headers.entrySet()) {
        final CheckedSupplier<RestClientBuilder, IOException> clientBuilderWithSniffedNodes
                    queryStringParams.put("source_content_type", contentType);
    private final ClientYamlSuiteRestSpec restSpec;
    private static boolean isUrlEncodedLengthUnderLimit(HttpEntity entity) throws IOException, ParseException {
import org.apache.logging.log4j.Logger;
        // lazily build a new client in case we need to point to some specific node
        // We check the warnings ourselves so we don't need the client to do it for us
            throw new IllegalStateException(
package org.opensearch.test.rest.yaml;
                // Encode rules for path and query string parameters are different. We use URI to encode the path. We need to encode each
                    queryStringParams.put(entry.getKey(), entry.getValue());
        }
                || restSpec.isClientParameter(entry.getKey())) {
 * specific language governing permissions and limitations
        return restApi;
 * REST calls.
        }
/*
                }
                }
        return encoded.length() < 3000;
            return false;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.client.ResponseException;
            // The API doesn't claim to support GET anyway
        }
    }
    @Override
        return RandomizedTest.rarely() && isUrlEncodedLengthUnderLimit(entity);
import org.apache.hc.core5.http.ParseException;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestSpec;
        List<ClientYamlSuiteRestApi.Path> bestPaths = restApi.getBestMatchingPaths(params.keySet());
        this.clientBuilderWithSniffedNodes = clientBuilderWithSniffedNodes;
                throw new IllegalArgumentException("body is not supported by [" + restApi.getName() + "] api");
import java.util.Set;
        final Version esVersion,
        this.esVersion = esVersion;
        final Version clusterManagerVersion,
                if (sendBodyAsSourceParam(supportedMethods, contentType, entity)) {
    private static final Logger logger = LogManager.getLogger(ClientYamlTestClient.class);
        }
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
            Response response = getRestClient(nodeSelector).performRequest(request);
    private static boolean sendBodyAsSourceParam(List<String> supportedMethods, String contentType, HttpEntity entity) throws IOException,
    public void close() throws IOException {
import org.opensearch.client.NodeSelector;
            requestMethod = RandomizedTest.randomFrom(supportedMethods);
 * this work for additional information regarding copyright
    ) throws IOException {
        } catch (ResponseException e) {
            } catch (IOException e) {
        if (contentLength < 0) {
                throw new IllegalArgumentException("body is required by [" + restApi.getName() + "] api");
        String requestMethod;
        }
            .collect(Collectors.toSet());
            .stream()
            } catch (final ParseException ex) {
                throw new IOException(ex);
        // the rest path to use is randomized out of the matching ones (if more than one)
        }
        } else {
            if (restApi.isBodyRequired()) {
            }
        ClientYamlSuiteRestApi restApi = restSpec.getApi(apiName);
    public ClientYamlTestResponse callApi(
            }
        long contentLength = entity.getContentLength();
        }
            }
    }
 * software distributed under the License is distributed on an
                        "path/param [" + entry.getKey() + "] not supported by [" + restApi.getName() + "] " + "api"
 * {@link RestClient} instance used to send the REST requests. Holds the {@link ClientYamlSuiteRestSpec} used to translate api calls into
 *
            logger.debug("Adding header {} with value {}", header.getKey(), header.getValue());
            return builder.build();
            options.addHeader(header.getKey(), header.getValue());
import java.util.List;
        assert hosts.size() > 0;
    /**
            return false;
import org.opensearch.common.CheckedSupplier;
import java.util.HashMap;
import org.opensearch.Version;
            try {
                    logger.debug("sending the request body as source param with GET method");
        Set<String> apiRequiredParameters = restApi.getParams()
    private final Map<NodeSelector, RestClient> restClients = new HashMap<>();
        if (restApi == null) {
import org.apache.hc.core5.http.ContentType;
        return clusterManagerVersion;
    }
 *
     */
import java.util.Map.Entry;
import java.io.Closeable;
import org.apache.hc.core5.http.HttpEntity;
        String apiName,
    }
        this.restClients.put(NodeSelector.ANY, restClient);
    protected static void setOptions(Request request, Map<String, String> headers) {
            if (path.getParts().contains(entry.getKey())) {
    public Version getClusterManagerVersion() {
        this.restSpec = restSpec;
 * compatible open source license.
    ClientYamlTestClient(
    private static final ContentType YAML_CONTENT_TYPE = ContentType.create("application/yaml");
                URI uri = new URI(null, null, null, -1, "/" + pathPart.getValue(), null, null);
                    );
        options.setWarningsHandler(WarningsHandler.PERMISSIVE);
    private final Version clusterManagerVersion;
            } else if (restApi.getParams().containsKey(entry.getKey())
            && false == contentType.startsWith(YAML_CONTENT_TYPE.getMimeType())) {
import java.nio.charset.StandardCharsets;
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
     * There is a limit of 4096 bytes for the HTTP line, otherwise there will be too_long_http_line_exception.
        if (false == contentType.startsWith(ContentType.APPLICATION_JSON.getMimeType())
        if (false == supportedMethods.contains(HttpGet.METHOD_NAME)) {
            String contentType = entity.getContentType();
            // Long bodies won't fit in the parameter and will cause a too_long_frame_exception
        NodeSelector nodeSelector
        try {
import java.io.IOException;
        }
        Map<String, String> params,
        }
import java.util.Arrays;
            .filter(Entry::getValue)
import java.util.Map;
        String encoded = URLEncoder.encode(EntityUtils.toString(entity), StandardCharsets.UTF_8);
            return false;
        }
 * KIND, either express or implied.  See the License for the
            try {
            }
        Set<String> partNames = pathParts.keySet();
public class ClientYamlTestClient implements Closeable {
/*
                    requestMethod = RandomizedTest.randomFrom(supportedMethods);
 * not use this file except in compliance with the License.
            );
 */
    private final CheckedSupplier<RestClientBuilder, IOException> clientBuilderWithSniffedNodes;
     * We check if the length of the url-encoded source parameter is less than 3000, leaving remaining for
