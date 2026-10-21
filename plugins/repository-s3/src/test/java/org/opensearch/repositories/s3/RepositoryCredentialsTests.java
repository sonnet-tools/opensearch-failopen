import software.amazon.awssdk.auth.credentials.AwsCredentials;
        assertThat(repositories.repository(repositoryName), notNullValue());
                assertThat(credentials.accessKeyId(), is("secure_default_key"));
                @Override
    }
            .put(S3Repository.ACCESS_KEY_SETTING.getKey(), "insecure_aws_key")
            }
import org.opensearch.indices.recovery.RecoverySettings;
import org.opensearch.rest.AbstractRestChannel;
                latch.countDown();
            RecoverySettings recoverySettings
 * Unless required by applicable law or agreed to in writing,
@SuppressForbidden(reason = "test requires to set a System property to allow insecure settings when running in IDE")
            System.setProperty("opensearch.allow_insecure_settings", "true");
            @Override
                    assertThat(responseAsString, not(containsString("insecure_")));
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.rest.RestRequest;
        );
        public ProxyS3RepositoryPlugin(Settings settings, Path configPath) {
                null,
            @Override
            throw error.get();
            assertThat(credentials.accessKeyId(), is("insecure_aws_key"));
        }
                null
        assertThat(repositories.repository(repositoryName), instanceOf(S3Repository.class));
import java.util.concurrent.atomic.AtomicReference;
            "Using s3 access/secret key from repository settings. Instead store these in named clients and"
    }
 * specific language governing permissions and limitations
        }
    public static final class ProxyS3RepositoryPlugin extends S3RepositoryPlugin {
 * software distributed under the License is distributed on an
    protected Collection<Class<? extends Plugin>> getPlugins() {
import org.apache.logging.log4j.Logger;
        public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {
import static org.hamcrest.Matchers.containsString;
        Settings.Builder settings = Settings.builder().put(repositorySettings);
    /**
import java.util.concurrent.CountDownLatch;
            } else {
            repositoryName,
            // No-op in tests — avoids interference with async client initialization
        }
                assertThat(newCredentials.secretAccessKey(), is("new_secret_aws_secret"));
        }
    }
            // check the not-yet-closed client reference still has the same credentials
    protected boolean resetNodeAfterTest() {
                assertThat(credentials.secretAccessKey(), is("secure_other_secret"));
package org.opensearch.repositories.s3;
    }
 * GitHub history for details.
    }
        secureSettings.setString(SECRET_KEY_SETTING.getConcreteSettingForNamespace("other").getKey(), "secure_other_secret");
    @Override
            repositorySettings.put(S3Repository.ACCESS_KEY_SETTING.getKey(), "insecure_aws_key");
        final RepositoriesService repositories = getInstanceFromNode(RepositoriesService.class);
        }
        }
                assertThat(credentials.secretAccessKey(), is("insecure_aws_secret"));
                null,
                this.credentials = credentials;
        final String repositoryName = "repo-reinit-creds";
                assertThat(credentials.accessKeyId(), is("secure_other_key"));
            super(settings, configPath, new ProxyS3Service(configPath), new S3AsyncService(configPath));
                null,
        final S3Repository repository = (S3Repository) repositories.repository(repositoryName);
        }
 */
import org.apache.logging.log4j.LogManager;
            "Using s3 access/secret key from repository settings. Instead store these in named clients and"
        }
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", configPath().toString()));
            final ProxyS3RepositoryPlugin plugin = plugins.filterPlugins(ProxyS3RepositoryPlugin.class).get(0);
 */
                return AmazonS3WithCredentials.create(new ClientAndCredentials(client.client(), credentials), credentials);
        );
            assertThat(client, instanceOf(ProxyS3RepositoryPlugin.ClientAndCredentials.class));
                    + " See the breaking changes documentation for the next major version.",
                super(delegate);
                + " the opensearch keystore for secure settings."
import org.opensearch.secure_sm.AccessController;
                clusterService,
        assertWarnings(
        @Override
            // new settings
                }
        final Settings.Builder repositorySettings = Settings.builder();
        secureSettings.setString(ACCESS_KEY_SETTING.getConcreteSettingForNamespace("default").getKey(), "secure_default_key");
                metadata,
import static org.hamcrest.Matchers.is;
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), name, S3Repository.TYPE, false, settings);
import org.opensearch.common.settings.Settings;
            final S3Client client = clientReference.get();
            // repository settings for credentials override node secure settings
 * The OpenSearch Contributors require contributions made to
import org.opensearch.rest.RestResponse;
            // required for client settings overwriting when running in IDE
        assertThat(repositories.repository(repositoryName), instanceOf(S3Repository.class));
import org.opensearch.plugins.PluginsService;
                assertThat(credentials.secretAccessKey(), is("secure_default_secret"));
import software.amazon.awssdk.services.s3.DelegatingS3Client;
            S3Client client = clientReference.get();
 */
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
     */
                assertThat(credentials.accessKeyId(), is("insecure_aws_key"));
            }
    protected Settings nodeSettings() {
 * under the License.
        });
import org.opensearch.test.rest.FakeRestRequest;
                assertThat(newCredentials.accessKeyId(), is("insecure_aws_key"));
            );
            assertThat(credentials.secretAccessKey(), is("insecure_aws_secret"));
import org.opensearch.common.settings.MockSecureSettings;
        return Collections.singleton(ProxyS3RepositoryPlugin.class);
 * Modifications Copyright OpenSearch Contributors. See
        final AtomicReference<AssertionError> error = new AtomicReference<>();
        public static final class ClientAndCredentials extends DelegatingS3Client {
        secureSettings.setString(ACCESS_KEY_SETTING.getConcreteSettingForNamespace("other").getKey(), "secure_other_key");
            private static final Logger logger = LogManager.getLogger(ProxyS3Service.class);
        return Settings.builder().setSecureSettings(secureSettings).put(super.nodeSettings()).build();
        try (AmazonS3Reference clientReference = ((S3BlobStore) repository.blobStore()).clientReference()) {
        createRepository(repositoryName, repositorySettings.build());
        secureSettings.setString(SECRET_KEY_SETTING.getConcreteSettingForNamespace("default").getKey(), "secure_default_secret");
                assertThat(credentials.accessKeyId(), is("secure_other_key"));
            ClusterService clusterService,
            } else if ("other".equals(clientName)) {
                super(configPath);
    static {
    }
import org.opensearch.cluster.service.ClusterService;
        action.handleRequest(fakeRestRequest, new AbstractRestChannel(fakeRestRequest, true) {
    }
}
                "[access_key] setting was deprecated in OpenSearch and will be removed in a future release!"
 *
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
            repositorySettings.put(S3Repository.SECRET_KEY_SETTING.getKey(), "insecure_aws_secret");
                    error.set(ex);
                + " See the breaking changes documentation for the next major version."
        }
                protected void assertSnapshotOrGenericThread() {
            Settings.builder()
import java.util.Collection;
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", configPath().toString()));
import org.opensearch.transport.client.node.NodeClient;
 * SPDX-License-Identifier: Apache-2.0
                    String responseAsString = response.content().utf8ToString();
        }
                false,
        } else {
    }
                .build()
                final AmazonS3WithCredentials client = AccessController.doPrivileged(() -> super.buildClient(clientSettings));
 * compatible open source license.
                try {
 * the Apache License, Version 2.0 (the "License"); you may
                    + " See the breaking changes documentation for the next major version."
        final Settings.Builder repositorySettings = Settings.builder()
    public void testReinitSecureCredentials() {
            ProxyS3Service(final Path configPath) {
        if (hasInsecureSettings) {
        if (clientName != null) {
 * You may obtain a copy of the License at
        final RestGetRepositoriesAction action = new RestGetRepositoriesAction(getInstanceFromNode(SettingsFilter.class));
            }
                assertThat(newCredentials.accessKeyId(), is("new_secret_aws_key"));
            }
                assertThat(newCredentials.secretAccessKey(), is("insecure_aws_secret"));
            final Settings newSettings = Settings.builder().setSecureSettings(newSecureSettings).build();
                null,
                "[secret_key] setting was deprecated in OpenSearch and will be removed in a future release!"
                assertThat(credentials.secretAccessKey(), is("insecure_aws_secret"));
                } catch (final AssertionError ex) {
import java.nio.file.Path;
                .put(S3Repository.ACCESS_KEY_SETTING.getKey(), "insecure_aws_key")
        fakeRestRequest.params().put("repository", repositoryName);
            newSecureSettings.setString("s3.client." + clientName + ".secret_key", "new_secret_aws_secret");
            } else if ("other".equals(clientName)) {
                service,
            repositorySettings.put(S3Repository.CLIENT_NAME.getKey(), clientName);
        }, getInstanceFromNode(NodeClient.class));
        try (final AmazonS3Reference clientReference = repository.createBlobStore().clientReference()) {
        }
import software.amazon.awssdk.services.s3.S3Client;
        return true;
                    + " the opensearch keystore for secure settings.",
                null,
        // check credentials have been updated
import static org.hamcrest.Matchers.not;
            } else {
 *
/*
            plugin.reload(newSettings);
 * not use this file except in compliance with the License.
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", configPath().toString()));
            }
import org.opensearch.plugins.Plugin;
                + " See the breaking changes documentation for the next major version.",
        final boolean hasInsecureSettings = randomBoolean();
            public void sendResponse(RestResponse response) {
            if (hasInsecureSettings) {
            final AwsCredentials credentials = ((ProxyS3RepositoryPlugin.ClientAndCredentials) client).credentials.resolveCredentials();
            final AwsCredentials newCredentials = ((ProxyS3RepositoryPlugin.ClientAndCredentials) client).credentials.resolveCredentials();
import org.opensearch.test.OpenSearchIntegTestCase;
            }
                    assertThat(responseAsString, containsString(repositoryName));
        }
            final AwsCredentials credentials = ((ProxyS3RepositoryPlugin.ClientAndCredentials) client).credentials.resolveCredentials();
            assertThat(client, instanceOf(ProxyS3RepositoryPlugin.ClientAndCredentials.class));
                    // eliminate thread name check as we create repo manually on test/main threads
    @Override
        public static final class ProxyS3Service extends S3Service {
        assertWarnings(
        final String repositoryName = "repo-insecure-creds";
import org.opensearch.common.settings.SettingsFilter;
        protected S3Repository createRepository(
            ClientAndCredentials(S3Client delegate, AwsCredentialsProvider credentials) {
            repositorySettings.put(S3Repository.CLIENT_NAME.getKey(), clientName);
        final String repositoryName = "repo-creds-override";
            "[access_key] setting was deprecated in OpenSearch and will be removed in a future release!"
 *
            if (hasInsecureSettings) {
import java.util.Collections;
            // repository settings for credentials override node secure settings
        final String clientName = randomFrom("default", "other");
        latch.await();
 * license agreements. See the NOTICE file distributed with
public class RepositoryCredentialsTests extends OpenSearchSingleNodeTestCase implements ConfigPathSupport {
        createRepository(repositoryName, repositorySettings.build());
                assertThat(credentials.accessKeyId(), is("secure_default_key"));
import static org.hamcrest.Matchers.notNullValue;
 * ownership. Elasticsearch licenses this file to you under
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            final PluginsService plugins = getInstanceFromNode(PluginsService.class);
        ) {
@SuppressWarnings("removal")
        try (AmazonS3Reference clientReference = ((S3BlobStore) repository.blobStore()).clientReference()) {
            newSecureSettings.setString("s3.client." + clientName + ".access_key", "new_secret_aws_key");
/*
        if (error.get() != null) {
import org.opensearch.rest.action.admin.cluster.RestGetRepositoriesAction;
            "[secret_key] setting was deprecated in OpenSearch and will be removed in a future release!"
import static org.opensearch.repositories.s3.S3ClientSettings.SECRET_KEY_SETTING;
            ) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.repositories.RepositoriesService;
                null,
                recoverySettings,
     * A S3 repository plugin that keeps track of the credentials used to build an AmazonS3 client
import static org.opensearch.repositories.s3.S3ClientSettings.ACCESS_KEY_SETTING;
                final AwsCredentialsProvider credentials = buildCredentials(logger, clientSettings);
                + " the opensearch keystore for secure settings.",
        AccessController.doPrivileged(() -> {
            assertThat(client, instanceOf(ProxyS3RepositoryPlugin.ClientAndCredentials.class));
        createRepository(
            RepositoryMetadata metadata,
            final AwsCredentialsProvider credentials;
            AmazonS3WithCredentials buildClient(final S3ClientSettings clientSettings) {
        assertThat(repositories.repository(repositoryName), notNullValue());
        final RepositoriesService repositories = getInstanceFromNode(RepositoriesService.class);
import org.opensearch.core.xcontent.NamedXContentRegistry;
        final S3Repository repository = (S3Repository) repositories.repository(repositoryName);
                }
                registry,
        final String clientName = randomFrom("default", "other", null);
        );
                null,
    private void createRepository(final String name, final Settings repositorySettings) {
    public void testRepositoryCredentialsOverrideSecureCredentials() {
                assertThat(credentials.secretAccessKey(), is("secure_other_secret"));
            final MockSecureSettings newSecureSettings = new MockSecureSettings();
        final RestRequest fakeRestRequest = new FakeRestRequest();
    }
        if (hasInsecureSettings) {
            // reload S3 plugin settings
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.instanceOf;
    public void testInsecureRepositoryCredentials() throws Exception {
                .put(S3Repository.SECRET_KEY_SETTING.getKey(), "insecure_aws_secret")
                assertThat(credentials.accessKeyId(), is("insecure_aws_key"));
            if (hasInsecureSettings) {
            final S3Client client = clientReference.get();
        @Override
            }
        final MockSecureSettings secureSettings = new MockSecureSettings();
    @Override
/*
            .put(S3Repository.SECRET_KEY_SETTING.getKey(), "insecure_aws_secret");
import org.opensearch.common.SuppressForbidden;
            };
            } else {
                assertThat(credentials.secretAccessKey(), is("secure_default_secret"));
                "Using s3 access/secret key from repository settings. Instead store these in named clients and"
        final CountDownLatch latch = new CountDownLatch(1);
            return new S3Repository(
import org.opensearch.plugins.ExtensiblePlugin;
 * this work for additional information regarding copyright
            NamedXContentRegistry registry,
 * Licensed to Elasticsearch under one or more contributor
            assertWarnings(
