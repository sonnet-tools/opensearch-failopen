import java.util.Collection;
            .put(AzureStorageSettings.ENDPOINT_SUFFIX_SETTING.getConcreteSettingForNamespace("test").getKey(), endpoint)
    /**
package org.opensearch.repositories.azure;
import com.azure.storage.common.policy.RetryPolicyType;
import com.sun.net.httpserver.HttpHandler;
            } else if (Regex.simpleMatch("HEAD /*/*", request)) {  
        secureSettings.setString(AzureStorageSettings.ACCOUNT_SETTING.getConcreteSettingForNamespace("test").getKey(), "account");
        AzureBlobStoreHttpHandler(final String container) {  
import fixture.azure.AzureHttpHandler;  
import org.apache.logging.log4j.Logger;  
                trackRequest("ListBlobs");  
        }  
                trackRequest("PutBlock");
     * slow down the test suite.  
import com.azure.storage.blob.models.ParallelTransferOptions;
        final MockSecureSettings secureSettings = new MockSecureSettings();
                @Override
import java.util.Map;  
 * SPDX-License-Identifier: Apache-2.0
        return Settings.builder()  
                        1,  
            return Regex.simpleMatch("PUT /*/*?*comp=block*", request) && request.contains("blockid=");  
                trackRequest("PutBlockList");
     * and single-upload threshold.  
        return Collections.singletonMap("/container", new AzureHTTPStatsCollectorHandler(new AzureBlobStoreHttpHandler("container")));
    private static class AzureBlobStoreHttpHandler extends AzureHttpHandler implements BlobStoreHttpHandler {
        @Override
import java.util.regex.Pattern;
 * license agreements. See the NOTICE file distributed with
            super(delegate, maxErrorsPercentage);  
                    return new ParallelTransferOptions().setMaxSingleUploadSizeLong(ByteSizeUnit.MB.toBytes(1));  
            return Regex.simpleMatch("PUT /*/*?*comp=blocklist*", request);
                trackRequest("GetBlob");
            final String requestId = exchange.getRequestHeaders().getFirst(Constants.HeaderConstants.CLIENT_REQUEST_ID);  
        private boolean isPutBlockList(String request) {
/*
 * Licensed to Elasticsearch under one or more contributor  
        AzureStorageService createAzureStoreService(final Settings settings) {
        @Override
        }  
import reactor.core.scheduler.Schedulers;
            };
        }
import org.opensearch.plugins.Plugin;
    }
        return AzureRepository.TYPE;
 *
import org.opensearch.common.settings.MockSecureSettings;  
        return new AzureErroneousHttpHandler(delegate, randomDoubleBetween(0, 0.25, false));
        }  
     * AzureRepositoryPlugin that allows low values for the Azure client retry policy
    protected Map<String, HttpHandler> createHttpHandlers() {
     */
import org.opensearch.common.SuppressForbidden;
                trackRequest("GetBlobProperties");
        }
        final String key = Base64.getEncoder().encodeToString(randomAlphaOfLength(10).getBytes(StandardCharsets.UTF_8));  
            .setSecureSettings(secureSettings)  
                        secondaryHost  
    }  
                }
                AzureHttpHandler.sendError(exchange, randomFrom(RestStatus.INTERNAL_SERVER_ERROR, RestStatus.SERVICE_UNAVAILABLE));
 *    http://www.apache.org/licenses/LICENSE-2.0
                drainInputStream(exchange.getRequestBody());  
                    return new RequestRetryOptions(  
 * not use this file except in compliance with the License.
    }
        @Override
        return Settings.builder()  
import org.opensearch.test.OpenSearchIntegTestCase;
    private static class AzureErroneousHttpHandler extends ErroneousHttpHandler {  
 * KIND, either express or implied.  See the License for the
            super(settings);
            .build();
 *  
            } else if (Regex.simpleMatch("PUT /*/*", request)) {
    }
                        500L,
import org.opensearch.common.regex.Regex;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.rest.RestStatus;  
import org.junit.AfterClass;
import com.azure.storage.common.implementation.Constants;
    @Override
    }
        }
            .put(super.repositorySettings())
 * this work for additional information regarding copyright
import java.nio.charset.StandardCharsets;
    /**
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.plugins.ExtensiblePlugin;
    @SuppressForbidden(reason = "this test uses a HttpHandler to emulate an Azure endpoint")  
        protected void maybeTrack(String request, Headers headers) {
            }
    protected String repositoryType() {  
/*
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                        100L,
                }
 *
                @Override
        private AzureHTTPStatsCollectorHandler(HttpHandler delegate) {  
        public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {  
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate an Azure endpoint")
            } else if (listPattern.matcher(request).matches()) {
 */
    protected HttpHandler createErroneousHttpHandler(final HttpHandler delegate) {  
     * <p>
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate an Azure endpoint")
import java.util.Collections;
            super(delegate);
            if (getPattern.matcher(request).matches()) {
            } else if (isPutBlockList(request)) {  
     * HTTP handler that keeps track of requests performed against Azure Storage.  
        // https://docs.microsoft.com/en-us/rest/api/storageservices/put-block-list  
            return exchange.getRequestMethod() + " " + requestId;
 * software distributed under the License is distributed on an
/*  
            .put(super.nodeSettings(nodeOrdinal))
 * GitHub history for details.
import org.opensearch.repositories.blobstore.OpenSearchMockAPIBasedRepositoryIntegTestCase;  
 * this file be licensed under the Apache-2.0 license or a
        final String endpoint = "ignored;DefaultEndpointsProtocol=http;BlobEndpoint=" + httpServerUrl() + "/";
    public static void shutdownSchedulers() {
 */
        private boolean isPutBlock(String request) {
    }
 * under the License.  
    }
            }
            testLogger.info(request, headers);  
    }  
     * HTTP handler that injects random Azure service errors  
        public TestAzureRepositoryPlugin(Settings settings) {
import org.opensearch.core.common.unit.ByteSizeUnit;
    @Override
import org.opensearch.common.settings.Settings;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
            super(container);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
    protected Settings repositorySettings() {
        AzureErroneousHttpHandler(final HttpHandler delegate, final double maxErrorsPercentage) {
public class AzureBlobStoreRepositoryTests extends OpenSearchMockAPIBasedRepositoryIntegTestCase {
            .put(AzureStorageSettings.ACCOUNT_SETTING.getKey(), "test")  
                RequestRetryOptions createRetryPolicy(final AzureStorageSettings azureStorageSettings, String secondaryHost) {
    }  
            } else if (isPutBlock(request)) {
            return new AzureStorageService(settings) {  
        @Override  
     */
            .build();
 * The OpenSearch Contributors require contributions made to  
    public static class TestAzureRepositoryPlugin extends AzureRepositoryPlugin {
    @Override
    @Override  
    @AfterClass  
        @Override
        return Collections.singletonList(TestAzureRepositoryPlugin.class);  
     */
        secureSettings.setString(AzureStorageSettings.KEY_SETTING.getConcreteSettingForNamespace("test").getKey(), key);  
        private static final Pattern getPattern = Pattern.compile("GET /[^?/]+/[^?/]+\\??.*");
import com.azure.storage.common.policy.RequestRetryOptions;  
        }
 * compatible open source license.
        }
        }
                exchange.close();  
    protected Settings nodeSettings(int nodeOrdinal) {
            .put(AzureRepository.Repository.CONTAINER_SETTING.getKey(), "container")
import com.sun.net.httpserver.Headers;  
     * Note: it is not a good idea to allow this handler to simulate too many errors as it would
import com.sun.net.httpserver.HttpExchange;
        protected void handleAsError(final HttpExchange exchange) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
            // No-op in tests — avoids interference with Reactor/Netty event loop initialization
    /**
    }
        // https://docs.microsoft.com/en-us/rest/api/storageservices/put-block
                    );
 * the Apache License, Version 2.0 (the "License"); you may
}
    @Override
 * You may obtain a copy of the License at  
    private static class AzureHTTPStatsCollectorHandler extends HttpStatsCollectorHandler {  
        }
            try {
        protected String requestUniqueId(final HttpExchange exchange) {
        private static final Logger testLogger = LogManager.getLogger(AzureHTTPStatsCollectorHandler.class);
 */  
    }  
                        RetryPolicyType.EXPONENTIAL,
        Schedulers.shutdownNow();
import java.util.Base64;  
                trackRequest("PutBlob");  
 * Unless required by applicable law or agreed to in writing,
@SuppressForbidden(reason = "this test uses a HttpServer to emulate an Azure endpoint")  
        }
                ParallelTransferOptions getBlobRequestOptionsForWriteBlob(String clientName) {
        private static final Pattern listPattern = Pattern.compile("GET /[a-zA-Z0-9]+\\??.+");  
                        azureStorageSettings.getMaxRetries(),
 * specific language governing permissions and limitations
    @Override
            } finally {
