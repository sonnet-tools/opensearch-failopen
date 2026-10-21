            } finally {
        AzureErroneousHttpHandler(final HttpHandler delegate, final double maxErrorsPercentage) {
import org.apache.logging.log4j.LogManager;
    @Override
import java.util.regex.Pattern;
        }
     * AzureRepositoryPlugin that allows low values for the Azure client retry policy
                trackRequest("GetBlob");
    @Override
        protected String requestUniqueId(final HttpExchange exchange) {
     */
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate an Azure endpoint")
    }
                }
    }
import java.nio.charset.StandardCharsets;
    @Override
import com.azure.storage.common.policy.RequestRetryOptions;
                        1,
import org.opensearch.common.SuppressForbidden;
     * HTTP handler that keeps track of requests performed against Azure Storage.
    }
            super(container);
        }
import java.io.IOException;
            // No-op in tests — avoids interference with Reactor/Netty event loop initialization
        }
 * compatible open source license.
            return Regex.simpleMatch("PUT /*/*?*comp=block*", request) && request.contains("blockid=");
    }
     */
 * You may obtain a copy of the License at
        @Override
    }
        private static final Logger testLogger = LogManager.getLogger(AzureHTTPStatsCollectorHandler.class);
import com.azure.storage.blob.models.ParallelTransferOptions;
import com.sun.net.httpserver.Headers;
                    );
 * this file be licensed under the Apache-2.0 license or a
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
    private static class AzureErroneousHttpHandler extends ErroneousHttpHandler {
                        500L,
                @Override
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate an Azure endpoint")
            super(delegate, maxErrorsPercentage);
 * SPDX-License-Identifier: Apache-2.0
            }
import org.opensearch.core.rest.RestStatus;
                        100L,
    protected Map<String, HttpHandler> createHttpHandlers() {
        private boolean isPutBlockList(String request) {
 * this work for additional information regarding copyright
@SuppressForbidden(reason = "this test uses a HttpServer to emulate an Azure endpoint")
import com.azure.storage.common.policy.RetryPolicyType;
 * license agreements. See the NOTICE file distributed with
 */
            } else if (Regex.simpleMatch("PUT /*/*", request)) {
    /**
/*
        @Override
            super(delegate);
                exchange.close();
        protected void handleAsError(final HttpExchange exchange) throws IOException {
import java.util.Collections;
        return Settings.builder()
 * KIND, either express or implied.  See the License for the
            .build();
                trackRequest("GetBlobProperties");
import org.junit.AfterClass;
     * Note: it is not a good idea to allow this handler to simulate too many errors as it would
        // https://docs.microsoft.com/en-us/rest/api/storageservices/put-block
     * slow down the test suite.
        AzureBlobStoreHttpHandler(final String container) {
     * <p>
package org.opensearch.repositories.azure;
import fixture.azure.AzureHttpHandler;
                AzureHttpHandler.sendError(exchange, randomFrom(RestStatus.INTERNAL_SERVER_ERROR, RestStatus.SERVICE_UNAVAILABLE));
            final String requestId = exchange.getRequestHeaders().getFirst(Constants.HeaderConstants.CLIENT_REQUEST_ID);
import reactor.core.scheduler.Schedulers;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            super(settings);
        }
            return Regex.simpleMatch("PUT /*/*?*comp=blocklist*", request);
        return Settings.builder()
     * HTTP handler that injects random Azure service errors
            .build();
            .put(AzureStorageSettings.ACCOUNT_SETTING.getKey(), "test")
        Schedulers.shutdownNow();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
            } else if (isPutBlockList(request)) {
    public static void shutdownSchedulers() {
    }
import com.sun.net.httpserver.HttpExchange;
/*
 * GitHub history for details.
                        azureStorageSettings.getMaxRetries(),
import org.opensearch.core.common.unit.ByteSizeUnit;
     * and single-upload threshold.
    protected Settings nodeSettings(int nodeOrdinal) {
    }
    @SuppressForbidden(reason = "this test uses a HttpHandler to emulate an Azure endpoint")
     */
 *
import org.opensearch.common.regex.Regex;
                RequestRetryOptions createRetryPolicy(final AzureStorageSettings azureStorageSettings, String secondaryHost) {
                @Override
                }
    protected Settings repositorySettings() {
import com.azure.storage.common.implementation.Constants;
    private static class AzureBlobStoreHttpHandler extends AzureHttpHandler implements BlobStoreHttpHandler {
 */
        }
            .put(AzureRepository.Repository.CONTAINER_SETTING.getKey(), "container")
 * not use this file except in compliance with the License.
 */
        }
                    return new RequestRetryOptions(
                trackRequest("PutBlockList");
import org.opensearch.plugins.Plugin;
import org.opensearch.test.OpenSearchIntegTestCase;
        @Override
    /**
            return new AzureStorageService(settings) {
public class AzureBlobStoreRepositoryTests extends OpenSearchMockAPIBasedRepositoryIntegTestCase {
        private AzureHTTPStatsCollectorHandler(HttpHandler delegate) {
        private static final Pattern listPattern = Pattern.compile("GET /[a-zA-Z0-9]+\\??.+");
import org.opensearch.plugins.ExtensiblePlugin;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.repositories.blobstore.OpenSearchMockAPIBasedRepositoryIntegTestCase;
            } else if (listPattern.matcher(request).matches()) {
        secureSettings.setString(AzureStorageSettings.ACCOUNT_SETTING.getConcreteSettingForNamespace("test").getKey(), "account");
    }
            if (getPattern.matcher(request).matches()) {
        @Override
        protected void maybeTrack(String request, Headers headers) {
 * software distributed under the License is distributed on an
        return Collections.singletonList(TestAzureRepositoryPlugin.class);
    protected HttpHandler createErroneousHttpHandler(final HttpHandler delegate) {
                drainInputStream(exchange.getRequestBody());
    private static class AzureHTTPStatsCollectorHandler extends HttpStatsCollectorHandler {
        final String key = Base64.getEncoder().encodeToString(randomAlphaOfLength(10).getBytes(StandardCharsets.UTF_8));
        return AzureRepository.TYPE;
                ParallelTransferOptions getBlobRequestOptionsForWriteBlob(String clientName) {
    }
import org.apache.logging.log4j.Logger;
        final MockSecureSettings secureSettings = new MockSecureSettings();
            .put(super.repositorySettings())
 * Modifications Copyright OpenSearch Contributors. See
        public TestAzureRepositoryPlugin(Settings settings) {
            .put(AzureStorageSettings.ENDPOINT_SUFFIX_SETTING.getConcreteSettingForNamespace("test").getKey(), endpoint)
            }
                trackRequest("ListBlobs");
    @Override
            testLogger.info(request, headers);
/*
        private static final Pattern getPattern = Pattern.compile("GET /[^?/]+/[^?/]+\\??.*");
import com.sun.net.httpserver.HttpHandler;
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.settings.Settings;
        AzureStorageService createAzureStoreService(final Settings settings) {
        }
        secureSettings.setString(AzureStorageSettings.KEY_SETTING.getConcreteSettingForNamespace("test").getKey(), key);
            .setSecureSettings(secureSettings)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            };
        return Collections.singletonMap("/container", new AzureHTTPStatsCollectorHandler(new AzureBlobStoreHttpHandler("container")));
        final String endpoint = "ignored;DefaultEndpointsProtocol=http;BlobEndpoint=" + httpServerUrl() + "/";
                trackRequest("PutBlock");
            return exchange.getRequestMethod() + " " + requestId;
import java.util.Base64;
                        secondaryHost
            .put(super.nodeSettings(nodeOrdinal))
            } else if (isPutBlock(request)) {
        private boolean isPutBlock(String request) {
                trackRequest("PutBlob");
    @Override
    /**
        // https://docs.microsoft.com/en-us/rest/api/storageservices/put-block-list
 * Licensed to Elasticsearch under one or more contributor
        }
        return new AzureErroneousHttpHandler(delegate, randomDoubleBetween(0, 0.25, false));
    }
 * the Apache License, Version 2.0 (the "License"); you may
    protected String repositoryType() {
        }
                    return new ParallelTransferOptions().setMaxSingleUploadSizeLong(ByteSizeUnit.MB.toBytes(1));
 * specific language governing permissions and limitations
    @AfterClass
        public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {
        }
    }
 *
        @Override
            } else if (Regex.simpleMatch("HEAD /*/*", request)) {
    public static class TestAzureRepositoryPlugin extends AzureRepositoryPlugin {
    @Override
                        RetryPolicyType.EXPONENTIAL,
}
import org.opensearch.common.settings.MockSecureSettings;
            try {
import java.util.Collection;
import java.util.Map;
 * under the License.
