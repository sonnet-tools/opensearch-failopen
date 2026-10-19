        private URI uri() {
            }
                )
            terminate(requestExecutor);  
import org.opensearch.common.SuppressForbidden;
import java.time.Duration;
                        .httpClientBuilder(NettyNioAsyncHttpClient.builder().maxConcurrency(2))
 * this file be licensed under the Apache-2.0 license or a
                        .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("access", "secret")))
                .put("s3.client.default.request_timeout", "10s")
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;  
                S3Client client = AccessController.doPrivileged(  
                    }
        return S3ClientSettings.load(
import java.util.concurrent.ExecutorService;
        private FailingS3Endpoint() throws IOException {
/*  
        final ScheduledExecutorService timeoutExecutor = Executors.newSingleThreadScheduledExecutor();  
                    final boolean fail = failRequests.get();
                        .overrideConfiguration(S3Service.buildOverrideConfiguration(settings, timeoutExecutor))
                try {
        assertThat(failure.getCause(), instanceOf(ApiCallTimeoutException.class));
                .put("s3.client.default.api_call_timeout", "2s")  
import software.amazon.awssdk.core.exception.ApiCallTimeoutException;
import org.opensearch.secure_sm.AccessController;
    private static class FailingS3Endpoint implements AutoCloseable {
                } finally {  
                    .get(15, TimeUnit.SECONDS);
                    request.cancel(true);
 * SPDX-License-Identifier: Apache-2.0
 *
        try (FailingS3Endpoint endpoint = new FailingS3Endpoint()) {
        private final AtomicBoolean failRequests = new AtomicBoolean();
                client.headBucket(b -> b.bucket("bucket").overrideConfiguration(o -> o.apiCallTimeout(Duration.ofSeconds(10))))  
                client.headBucket(b -> b.bucket("bucket").overrideConfiguration(o -> o.apiCallTimeout(Duration.ofSeconds(10))));
        final ExecutorService requestExecutor = Executors.newSingleThreadExecutor();
import java.util.concurrent.TimeUnit;
            server.createContext("/", exchange -> {  
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;  
    }
        public void close() {
import software.amazon.awssdk.services.s3.S3AsyncClient;
    }
        }  
                    () -> S3Client.builder()
import software.amazon.awssdk.regions.Region;
        assertTrue("the total timeout must stop retries before they are exhausted", endpoint.failedRequests.get() < MAX_RETRIES + 1);  
import java.util.concurrent.atomic.AtomicInteger;
                } finally {
        }  
    }  
import java.net.URI;
                        .overrideConfiguration(S3AsyncService.buildOverrideConfiguration(settings, timeoutExecutor))
                endpoint.failRequests.set(true);
public class S3ApiCallTimeoutTests extends AbstractS3RepositoryTestCase {
            ) {
        } finally {
import com.sun.net.httpserver.HttpServer;
package org.opensearch.repositories.s3;
import java.util.concurrent.atomic.AtomicBoolean;  
                        .httpClientBuilder(S3Service.buildHttpClient(settings))  
            terminate(timeoutExecutor);
                        .build()
            try (  
        }
                S3AsyncClient client = AccessController.doPrivileged(
        assertTrue("expected at least one retry", endpoint.failedRequests.get() > 1);
            configPath()
    private void assertTimeoutStopsRetries(Future<?> request, FailingS3Endpoint endpoint) throws Exception {
                        .endpointOverride(endpoint.uri())
                endpoint.failRequests.set(true);  
                        .forcePathStyle(true)
                }  
 * compatible open source license.
    public void testSyncApiCallTimeoutStopsRetries() throws Exception {  
                .put("s3.client.default.max_retries", MAX_RETRIES)
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.network.InetAddresses;  
                    assertTimeoutStopsRetries(request, endpoint);  
            server.stop(0);  
}  
                    () -> S3AsyncClient.builder()
            final S3ClientSettings settings = clientSettings();
import java.net.InetAddress;
            final InetSocketAddress address = server.getAddress();  
import java.net.InetSocketAddress;  
            server.start();
        try (FailingS3Endpoint endpoint = new FailingS3Endpoint()) {  
            ) {
        ).get("default");
                        .endpointOverride(endpoint.uri())
import java.util.concurrent.Future;  
                        .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("access", "secret")))  
        final ExecutionException failure = expectThrows(ExecutionException.class, () -> request.get(15, TimeUnit.SECONDS));  
 */  
import java.util.concurrent.Executors;
        private final AtomicInteger failedRequests = new AtomicInteger();
                    exchange.sendResponseHeaders(fail ? 503 : 200, -1);  
                )  
            }  
                    assertTimeoutStopsRetries(request, endpoint);
                    exchange.close();
    public void testAsyncApiCallTimeoutStopsRetries() throws Exception {
            terminate(timeoutExecutor);
            return URI.create("http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort());
                }  
import static org.hamcrest.Matchers.instanceOf;  
                final Future<?> request = client.headBucket(b -> b.bucket("bucket"));  
                .build(),  
import java.util.concurrent.ExecutionException;  
                    if (fail) {  
        } finally {
                        .build()  
        private final HttpServer server;  
                final Future<?> request = requestExecutor.submit(() -> client.headBucket(b -> b.bucket("bucket")));
            final S3ClientSettings settings = clientSettings();
    }
                try {
        @Override
            });
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
                        .region(Region.US_EAST_1)
                        .forcePathStyle(true)  
                        .region(Region.US_EAST_1)  
                try {
import software.amazon.awssdk.services.s3.S3Client;  
            try (
    }  
                    request.cancel(true);
import java.io.IOException;
        }
    @SuppressForbidden(reason = "uses a local HTTP server to exercise SDK retries")  
            Settings.builder()
        }
import org.opensearch.common.settings.Settings;
        final ScheduledExecutorService timeoutExecutor = Executors.newSingleThreadScheduledExecutor();
    private static final int MAX_RETRIES = 100;
                } finally {
                        failedRequests.incrementAndGet();
    private S3ClientSettings clientSettings() {  
                }
import java.util.concurrent.ScheduledExecutorService;
            server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
