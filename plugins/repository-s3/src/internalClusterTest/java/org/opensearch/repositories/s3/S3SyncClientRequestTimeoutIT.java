import static org.hamcrest.Matchers.greaterThan;
import java.io.IOException;
                .get();
import org.opensearch.snapshots.SnapshotState;
import org.junit.AfterClass;
import org.opensearch.cluster.metadata.IndexMetadata;
            AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", previousOpenSearchPathConf));
import org.opensearch.common.network.InetAddresses;
                    break;  
    }
                            .put(S3Repository.BUCKET_SETTING.getKey(), "bucket")
import com.sun.net.httpserver.HttpServer;
    public void setUp() throws Exception {  
                .cluster()
            .put(S3ClientSettings.ENDPOINT_SETTING.getConcreteSettingForNamespace("test").getKey(), endpoint)  
            }  
/*  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
@SuppressForbidden(reason = "this test uses a HttpServer to emulate an S3 endpoint")  
import java.net.InetAddress;  
                    foundTimeout = true;
        createIndex(  
    private static HttpServer httpServer;  
import java.util.concurrent.TimeUnit;
        flushAndRefresh(index);  
    @Override
import org.opensearch.threadpool.ThreadPool;
        } catch (Exception e) {  
    @BeforeClass
    }
        public void close() throws IOException {
        delayedHandler = new DelayedS3HttpHandler("bucket", DELAY_MILLIS, "PUT", "/snap-");
                cause = cause.getCause();
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
import java.util.Collection;
        secureSettings.setString(S3ClientSettings.ACCESS_KEY_SETTING.getConcreteSettingForNamespace("test").getKey(), "access");
            super.close();  
        if (previousOpenSearchPathConf != null) {
    @AfterClass
        return Settings.builder()
                .setIndices(index)
public class S3SyncClientRequestTimeoutIT extends OpenSearchIntegTestCase {
    @Override  
import org.junit.BeforeClass;  
        secureSettings.setString(S3ClientSettings.SECRET_KEY_SETTING.getConcreteSettingForNamespace("test").getKey(), "secret");  
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);  
                    )  
            Thread t = new Thread(r);
        httpServer.start();  
    public static class TimeoutTestS3RepositoryPlugin extends S3RepositoryPlugin {
        InetSocketAddress address = httpServer.getAddress();
    protected Settings nodeSettings(int nodeOrdinal) {  
            SnapshotState state = response.getSnapshotInfo().state();
                    .settings(
    }  
import java.util.stream.Stream;  
            settings.add(S3ClientSettings.DISABLE_CHUNKED_ENCODING);
        try {
import java.util.concurrent.Executors;
import org.opensearch.test.OpenSearchIntegTestCase;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     * Plugin that provides the S3 repository for testing.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;  
        delayedHandler.resetDelayedRequestCount();
        }  
        assertThat("Expected requests to the delayed S3 handler", delayedHandler.getDelayedRequestCount(), greaterThan(0));
        }));
        }
import java.util.List;  
    private String previousOpenSearchPathConf;
        super.tearDown();  
        httpServer.stop(0);
import org.opensearch.common.settings.MockSecureSettings;
 * The OpenSearch Contributors require contributions made to  
    private static final int DELAY_MILLIS = 15000;  
                .prepareCreateSnapshot("test-repo", "test-snap")
        );  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
                new S3Service(configPath, Executors.newSingleThreadScheduledExecutor()),  
        @Override
import java.nio.file.Path;
            .cluster()
        previousOpenSearchPathConf = AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", "config"));
 */  
            .put(S3ClientSettings.REGION.getConcreteSettingForNamespace("test").getKey(), "test-region")
                .forEach(e -> assertTrue(ThreadPool.terminate(e, 5, TimeUnit.SECONDS)));
        super.setUp();
    private static final String REQUEST_TIMEOUT = "3s";
            super(  
            .put(S3ClientSettings.REQUEST_TIMEOUT_SETTING.getConcreteSettingForNamespace("test").getKey(), REQUEST_TIMEOUT)  
                .setWaitForCompletion(true)  
            .put(S3ClientSettings.PROXY_TYPE_SETTING.getConcreteSettingForNamespace("test").getKey(), ProxySettings.ProxyType.DIRECT)  
            assertTrue("Expected timeout-related exception but got: " + e.getMessage(), foundTimeout);
                }
            while (cause != null) {  
                S3ClientSettings.SIGNER_OVERRIDE.getConcreteSettingForNamespace("test").getKey(),  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
import java.net.InetSocketAddress;
import org.opensearch.repositories.s3.utils.AwsRequestSigner;  
        httpServer.createContext("/bucket", delayedHandler);
            index,
@ThreadLeakFilters(filters = { EventLoopThreadFilter.class, ResponseInputStreamTimeoutThreadFilter.class })
                    .verify(false)
    private static DelayedS3HttpHandler delayedHandler;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
                configPath,
    }  
            Throwable cause = e;
    }  
    @Override
            return settings;
            .putRepository(  
                        Settings.builder()  
        httpServer.setExecutor(Executors.newFixedThreadPool(4, r -> {
import java.util.Collections;
import org.opensearch.common.SuppressForbidden;  
        client().admin()
    @Override
    public static void stopHttpServer() {  
        public List<Setting<?>> getSettings() {  
            )
        public TimeoutTestS3RepositoryPlugin(final Settings settings, final Path configPath) {
        } else {  
    public void tearDown() throws Exception {  
        }
            t.setDaemon(true);  
                settings,
    }  
 * SPDX-License-Identifier: Apache-2.0
            .put(S3ClientSettings.MAX_RETRIES_SETTING.getConcreteSettingForNamespace("test").getKey(), 1)
    }
                            .put(S3Repository.CLIENT_NAME.getKey(), "test")
            .get();  
    public void testSyncClientTimesOutOnSlowRepository() throws Exception {
        }  
import fixture.s3.DelayedS3HttpHandler;
            .put(super.nodeSettings(nodeOrdinal))
            .setSecureSettings(secureSettings)  
        client().prepareIndex(index).setSource("field", "value").get();
     */  
import org.opensearch.plugins.Plugin;
                AwsRequestSigner.VERSION_FOUR_SIGNER.getName()
            .put(S3ClientSettings.DISABLE_CHUNKED_ENCODING.getConcreteSettingForNamespace("test").getKey(), true)
            .put(S3ClientSettings.USE_THROTTLE_RETRIES_SETTING.getConcreteSettingForNamespace("test").getKey(), false)
        String endpoint = "http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort();  
    }
    public static void startHttpServer() throws Exception {
        }
            boolean foundTimeout = false;
                new S3AsyncService(configPath, Executors.newSingleThreadScheduledExecutor())
}
        final String index = "test-index";
        return Collections.singletonList(TimeoutTestS3RepositoryPlugin.class);
 *
            CreateSnapshotResponse response = client().admin()  
            return t;
package org.opensearch.repositories.s3;
            )
import java.util.ArrayList;  
            .put(
 * compatible open source license.
    /**
        @Override
            final List<Setting<?>> settings = new ArrayList<>(super.getSettings());
        httpServer = null;
            settings.add(S3ClientSettings.REQUEST_TIMEOUT_SETTING);  
import org.opensearch.common.settings.Setting;  
                new PutRepositoryRequest("test-repo").type("s3")
            );
        final MockSecureSettings secureSettings = new MockSecureSettings();
            .build();
            assertTrue("Snapshot should fail due to request timeout, but got state: " + state, state == SnapshotState.FAILED);
import org.opensearch.common.settings.Settings;
            AccessController.doPrivileged(() -> System.clearProperty("opensearch.path.conf"));
import org.opensearch.secure_sm.AccessController;
            Stream.of(service.getClientExecutorService(), s3AsyncService.getClientExecutorService())
                if (cause.getMessage() != null && cause.getMessage().contains("timeout")) {
