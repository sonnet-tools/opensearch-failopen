            .setSecureSettings(secureSettings)
        );
        );
        assertSame(clientSettings, otherClientSettings);
        );
        final AmazonAsyncS3Reference reference = AccessController.doPrivileged(
        final Optional<URI> override = s3AsyncService.resolveEndpointOverride(clientSettings);
import org.opensearch.secure_sm.AccessController;
import java.util.concurrent.Executors;
import software.amazon.awssdk.http.crt.AwsCrtAsyncHttpClient;
        final RepositoryMetadata metadata = new RepositoryMetadata("no-endpoint", "s3", repoSettings);
            eventLoopGroup,
            .put("s3.client.default.proxy.type", proxyType)
            .put("endpoint", "http://first")
        );
import org.opensearch.repositories.s3.utils.AwsCrtUtils;
        assertNotSame(clientSettings, clientSettingsReloaded);
    }
    @Override
        final String proxyType = randomFrom("http", "https", "socks");
        );
        final AsyncExecutorContainer asyncExecutorContainer = new AsyncExecutorContainer(
        SdkAsyncHttpClient asyncClient = S3AsyncService.buildHttpClient(
        SdkAsyncHttpClient asyncClient = S3AsyncService.buildHttpClient(
        secureSettings.setString("s3.client.default.proxy.password", password);
        );
import static org.junit.Assume.assumeThat;
        );
        assertSame(reference3, reference4);
        final int port = randomIntBetween(10, 1080);
    public void testCachedClientsWithCredentialsAreReleased() {
            S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE
package org.opensearch.repositories.s3;
        final Settings repoSettings = Settings.builder().put("region", "us-east-1").build();
    }
        assertNotNull(asyncClient);
 */
        final Settings settings = Settings.builder()
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata);
        assumeThat("AWS CRT client is not available on the target platform", AwsCrtUtils.isAwsCrtAvailable(), equalTo(true));
        final AmazonAsyncS3Reference referenceReloaded = AccessController.doPrivileged(
    public void testResolveEndpointOverrideAbsentWhenEndpointNotProvided() {
        final RepositoryMetadata metadata3 = new RepositoryMetadata("second", "s3", crtSettings);
    }
        reference.close();
        assertSame(reference, reference2);
        s3AsyncService.close();
        final RepositoryMetadata metadata2 = new RepositoryMetadata("second", "s3", settings);
            () -> s3AsyncService.client(metadata1, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
            Executors.newSingleThreadExecutor(),
        when(eventLoopGroup.getEventLoopGroup()).thenReturn(mock(NioEventLoopGroup.class));
    public void testCachedClientsAreReleased() {
        s3AsyncService.close();
            new AsyncTransferEventLoopGroup(1)
            .put("region", "us-east-2")
            .put("region", "us-east-2")
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", configPath().toString()));
            Executors.newSingleThreadExecutor(),
            .build();
        AsyncTransferEventLoopGroup eventLoopGroup = mock(AsyncTransferEventLoopGroup.class);
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
        final int port = randomIntBetween(10, 1080);
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import static org.hamcrest.CoreMatchers.equalTo;
    }
    }
        super.setUp();
import org.opensearch.common.settings.MockSecureSettings;
            .put("endpoint", "http://first")
        referenceReloaded.close();
            () -> s3AsyncService.client(metadata4, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
        final Settings settings = Settings.builder()
        assertTrue(asyncClient instanceof NettyNioAsyncHttpClient);
        reference.close();
        final AmazonAsyncS3Reference reference4 = AccessController.doPrivileged(
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;
        final AmazonAsyncS3Reference reference3 = AccessController.doPrivileged(
        referenceReloaded.close();
        final S3ClientSettings otherClientSettings = s3AsyncService.settings(metadata2);
        final AmazonAsyncS3Reference reference = AccessController.doPrivileged(
        assertTrue("Expected no endpoint override when endpoint setting is absent", override.isEmpty());
public class S3AsyncServiceTests extends OpenSearchTestCase implements ConfigPathSupport {
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata);
        assertTrue("Expected endpoint override to be present when endpoint setting is provided", override.isPresent());
        assertNotSame(clientSettings, clientSettingsReloaded);
            .put("endpoint", "http://first")
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
        );
import org.opensearch.repositories.s3.async.AsyncTransferEventLoopGroup;
import java.util.Optional;
        final String password = randomAlphaOfLength(10);
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
/*
        final String userName = randomAlphaOfLength(10);
        final Settings settings = Settings.builder().put("endpoint", "http://first").put("region", "us-east-2").build();
import static org.mockito.Mockito.mock;
        final Settings repoSettings = Settings.builder().put("region", "us-east-1").put("endpoint", "s3.us-east-1.amazonaws.com").build();
            .build();
            S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE
        );
        final Map<String, S3ClientSettings> defaults = S3ClientSettings.load(
        final String password = randomAlphaOfLength(10);
            .put("region", "us-east-2")
    }
            .setSecureSettings(secureSettings)
            Executors.newSingleThreadExecutor(),
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata);
            .put("s3.client.default.proxy.host", randomFrom("127.0.0.10"))
        final String proxyType = randomFrom("http", "https", "socks");
        final MockSecureSettings secureSettings = new MockSecureSettings();
            () -> s3AsyncService.client(metadata1, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
    public void testResolveEndpointOverrideAddsSchemeWhenMissing() {
import static org.mockito.Mockito.when;
            .put(S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE.getKey(), S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE)
            clientSettings,
        secureSettings.setString("s3.client.default.role_arn", "role");
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata2);
        final AmazonAsyncS3Reference referenceReloaded = AccessController.doPrivileged(
import java.net.URI;
        assertSame(clientSettings, otherClientSettings);
            () -> s3AsyncService.client(metadata1, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
 *
        final MockSecureSettings secureSettings = new MockSecureSettings();
import java.util.Map;
        );
            .build();
        s3AsyncService.close();
            .put(S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE.getKey(), S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE)
        secureSettings.setString("s3.client.default.proxy.username", userName);
import org.opensearch.common.settings.Settings;
        );
    }
        assertTrue("Expected endpoint override to be present when endpoint has explicit scheme", override.isPresent());
        AsyncTransferEventLoopGroup eventLoopGroup = mock(AsyncTransferEventLoopGroup.class);
        final S3ClientSettings clientSettingsReloaded = s3AsyncService.settings(metadata1);
        final Optional<URI> override = s3AsyncService.resolveEndpointOverride(clientSettings);
        );
        assertEquals("https://s3.us-east-1.amazonaws.com", override.get().toString());
            clientSettings,
}
        assertNotNull(asyncClient);
            () -> s3AsyncService.client(metadata3, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
        final RepositoryMetadata metadata1 = new RepositoryMetadata("first", "s3", settings);
        assertNotSame(reference, reference3);
        assertNotSame(referenceReloaded, reference);
import io.netty.channel.nio.NioEventLoopGroup;
        final AmazonAsyncS3Reference reference2 = AccessController.doPrivileged(
            Settings.builder().setSecureSettings(secureSettings).put("s3.client.default.identity_token_file", "file").build(),
        final S3ClientSettings clientSettingsReloaded = s3AsyncService.settings(metadata1);
        final RepositoryMetadata metadata = new RepositoryMetadata("endpoint-no-scheme", "s3", repoSettings);
    public void testBuildHttpClientWithNetty() {
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
        final RepositoryMetadata metadata1 = new RepositoryMetadata("first", "s3", settings);
            () -> s3AsyncService.client(metadata2, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
        final MockSecureSettings secureSettings = new MockSecureSettings();
        final RepositoryMetadata metadata1 = new RepositoryMetadata("first", "s3", settings);
 * The OpenSearch Contributors require contributions made to
        final Settings crtSettings = Settings.builder()
import static org.mockito.Mockito.verify;
            .put("endpoint", "http://first")
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata1);
            .put("region", "us-east-2")
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata2);
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
        s3AsyncService.refreshAndClearCache(defaults);
        final S3ClientSettings otherClientSettings = s3AsyncService.settings(metadata2);
    @Before
 * SPDX-License-Identifier: Apache-2.0
import org.junit.Before;
        final Settings settings = Settings.builder()
            new AsyncTransferEventLoopGroup(1)
        when(eventLoopGroup.getEventLoopGroup()).thenReturn(mock(NioEventLoopGroup.class));
        final RepositoryMetadata metadata2 = new RepositoryMetadata("second", "s3", settings);
        final AsyncExecutorContainer asyncExecutorContainer = new AsyncExecutorContainer(
        verify(eventLoopGroup).getEventLoopGroup();
        final String userName = randomAlphaOfLength(10);
import org.opensearch.cluster.metadata.RepositoryMetadata;
    }
    public void testBuildHttpClientWithCRT() {
    public void testResolveEndpointOverridePreservesExplicitScheme() {
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
            () -> s3AsyncService.client(metadata1, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
            .build();
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;
 * this file be licensed under the Apache-2.0 license or a
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata1);
        final Settings repoSettings = Settings.builder().put("region", "us-east-1").put("endpoint", "http://localhost:9000").build();
        assertEquals("http://localhost:9000", override.get().toString());
        final RepositoryMetadata metadata1 = new RepositoryMetadata("first", "s3", settings);
            eventLoopGroup,
        s3AsyncService.close();
            Executors.newSingleThreadExecutor(),
        assertTrue(asyncClient instanceof AwsCrtAsyncHttpClient);
import org.opensearch.cli.SuppressForbidden;
            .put("s3.client.default.proxy.host", randomFrom("127.0.0.10"))
            .put("s3.client.default.proxy.port", randomFrom(port))
    @SuppressForbidden(reason = "Need to set opensearch.path.conf for async client")
        secureSettings.setString("s3.client.default.proxy.username", userName);
            .put("s3.client.default.proxy.type", proxyType)
        final RepositoryMetadata metadata = new RepositoryMetadata("endpoint-with-scheme", "s3", repoSettings);
        final RepositoryMetadata metadata4 = new RepositoryMetadata("second", "s3", crtSettings);
            .put("s3.client.default.proxy.port", randomFrom(port))
import org.opensearch.test.OpenSearchTestCase;
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
    public void setUp() throws Exception {
        assertNotSame(referenceReloaded, reference);
 * compatible open source license.
        secureSettings.setString("s3.client.default.proxy.password", password);
        final Optional<URI> override = s3AsyncService.resolveEndpointOverride(clientSettings);
            configPath()
