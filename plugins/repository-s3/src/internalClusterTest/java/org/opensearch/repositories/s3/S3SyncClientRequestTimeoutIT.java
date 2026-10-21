            super.close();
    private static HttpServer httpServer;
    }
            .setSecureSettings(secureSettings)
 *
import org.opensearch.threadpool.ThreadPool;
            assertTrue("Expected timeout-related exception but got: " + e.getMessage(), foundTimeout);
            .put(S3ClientSettings.ENDPOINT_SETTING.getConcreteSettingForNamespace("test").getKey(), endpoint)
            assertTrue("Snapshot should fail due to request timeout, but got state: " + state, state == SnapshotState.FAILED);
            return settings;
@ThreadLeakFilters(filters = { EventLoopThreadFilter.class, ResponseInputStreamTimeoutThreadFilter.class })
import org.opensearch.snapshots.SnapshotState;
    protected Settings nodeSettings(int nodeOrdinal) {
            t.setDaemon(true);
                            .put(S3Repository.BUCKET_SETTING.getKey(), "bucket")
        } catch (Exception e) {
    private static DelayedS3HttpHandler delayedHandler;
    public static void startHttpServer() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
import org.opensearch.common.settings.MockSecureSettings;
                configPath,
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            .put(S3ClientSettings.MAX_RETRIES_SETTING.getConcreteSettingForNamespace("test").getKey(), 1)
        return Collections.singletonList(TimeoutTestS3RepositoryPlugin.class);
import java.net.InetAddress;
    @Override
                .get();
                .prepareCreateSnapshot("test-repo", "test-snap")
 */
        public void close() throws IOException {
    }
            )
            settings.add(S3ClientSettings.DISABLE_CHUNKED_ENCODING);
        try {
import org.opensearch.plugins.Plugin;
    @Override
        }
        delayedHandler.resetDelayedRequestCount();
        delayedHandler = new DelayedS3HttpHandler("bucket", DELAY_MILLIS, "PUT", "/snap-");
        final String index = "test-index";
            .put(S3ClientSettings.DISABLE_CHUNKED_ENCODING.getConcreteSettingForNamespace("test").getKey(), true)
            .put(
                new S3Service(configPath, Executors.newSingleThreadScheduledExecutor()),
        assertThat("Expected requests to the delayed S3 handler", delayedHandler.getDelayedRequestCount(), greaterThan(0));
                .cluster()
        );
        String endpoint = "http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort();
import org.opensearch.common.settings.Settings;
                AwsRequestSigner.VERSION_FOUR_SIGNER.getName()
        flushAndRefresh(index);
            return t;
import java.util.Collections;
    private static final int DELAY_MILLIS = 15000;
            while (cause != null) {
            .build();
            .put(super.nodeSettings(nodeOrdinal))
        }
    }
        }
        final MockSecureSettings secureSettings = new MockSecureSettings();
            final List<Setting<?>> settings = new ArrayList<>(super.getSettings());
                new PutRepositoryRequest("test-repo").type("s3")
import org.junit.BeforeClass;
import java.util.concurrent.TimeUnit;
                    break;
        return Settings.builder()
            AccessController.doPrivileged(() -> System.clearProperty("opensearch.path.conf"));
    /**
            .put(S3ClientSettings.PROXY_TYPE_SETTING.getConcreteSettingForNamespace("test").getKey(), ProxySettings.ProxyType.DIRECT)
                .forEach(e -> assertTrue(ThreadPool.terminate(e, 5, TimeUnit.SECONDS)));
        httpServer.setExecutor(Executors.newFixedThreadPool(4, r -> {
        }
    }
                    foundTimeout = true;
    @AfterClass
        @Override
            settings.add(S3ClientSettings.REQUEST_TIMEOUT_SETTING);
public class S3SyncClientRequestTimeoutIT extends OpenSearchIntegTestCase {
    @Override
                new S3AsyncService(configPath, Executors.newSingleThreadScheduledExecutor())
            .put(S3ClientSettings.REQUEST_TIMEOUT_SETTING.getConcreteSettingForNamespace("test").getKey(), REQUEST_TIMEOUT)
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
     */
    }
import org.opensearch.secure_sm.AccessController;
        httpServer.stop(0);
        public TimeoutTestS3RepositoryPlugin(final Settings settings, final Path configPath) {
import org.opensearch.repositories.s3.utils.AwsRequestSigner;
        @Override
        previousOpenSearchPathConf = AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", "config"));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    @Override
import static org.hamcrest.Matchers.greaterThan;
    public static void stopHttpServer() {
    private static final String REQUEST_TIMEOUT = "3s";
import java.util.concurrent.Executors;
import org.opensearch.test.OpenSearchIntegTestCase;
            SnapshotState state = response.getSnapshotInfo().state();
 * this file be licensed under the Apache-2.0 license or a
            Stream.of(service.getClientExecutorService(), s3AsyncService.getClientExecutorService())
package org.opensearch.repositories.s3;
import java.util.List;
    }
                settings,
    public void tearDown() throws Exception {
            .put(S3ClientSettings.USE_THROTTLE_RETRIES_SETTING.getConcreteSettingForNamespace("test").getKey(), false)
        createIndex(
        public List<Setting<?>> getSettings() {
 * SPDX-License-Identifier: Apache-2.0
import java.nio.file.Path;
        super.tearDown();
            .put(S3ClientSettings.REGION.getConcreteSettingForNamespace("test").getKey(), "test-region")
                S3ClientSettings.SIGNER_OVERRIDE.getConcreteSettingForNamespace("test").getKey(),
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
                .setIndices(index)
import java.util.ArrayList;
                    )
import java.io.IOException;
        httpServer.start();
        }
 * The OpenSearch Contributors require contributions made to
        httpServer.createContext("/bucket", delayedHandler);
            )
                .setWaitForCompletion(true)
                }
                            .put(S3Repository.CLIENT_NAME.getKey(), "test")
            Throwable cause = e;
        InetSocketAddress address = httpServer.getAddress();
        }));
        secureSettings.setString(S3ClientSettings.ACCESS_KEY_SETTING.getConcreteSettingForNamespace("test").getKey(), "access");
            }
        } else {
            .putRepository(
    public void setUp() throws Exception {
import org.opensearch.common.network.InetAddresses;
                cause = cause.getCause();
            Thread t = new Thread(r);
        client().admin()
import java.util.Collection;
                    .settings(
        if (previousOpenSearchPathConf != null) {
            CreateSnapshotResponse response = client().admin()
import java.util.stream.Stream;
import java.net.InetSocketAddress;
/*
        secureSettings.setString(S3ClientSettings.SECRET_KEY_SETTING.getConcreteSettingForNamespace("test").getKey(), "secret");
            index,
@SuppressForbidden(reason = "this test uses a HttpServer to emulate an S3 endpoint")
        super.setUp();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
                        Settings.builder()
import org.opensearch.common.SuppressForbidden;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import org.opensearch.cluster.metadata.IndexMetadata;
    private String previousOpenSearchPathConf;
}
            boolean foundTimeout = false;
import org.opensearch.common.settings.Setting;
import fixture.s3.DelayedS3HttpHandler;
import org.junit.AfterClass;
    public void testSyncClientTimesOutOnSlowRepository() throws Exception {
    }
    }
            AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", previousOpenSearchPathConf));
        client().prepareIndex(index).setSource("field", "value").get();
import com.sun.net.httpserver.HttpServer;
            .get();
        httpServer = null;
     * Plugin that provides the S3 repository for testing.
            );
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
                if (cause.getMessage() != null && cause.getMessage().contains("timeout")) {
 * compatible open source license.
            .cluster()
                    .verify(false)
    public static class TimeoutTestS3RepositoryPlugin extends S3RepositoryPlugin {
            super(
    @BeforeClass
