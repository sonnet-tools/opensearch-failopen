     * @return a cached client storage instance that can be used to manage objects
     * {@code GoogleCloudStorageService#client} will return new clients constructed
            String alias = aliases.nextElement();
    /**
            if (existing != null) {
            final Storage storage = clientCache.get(repositoryName);
 */
     */
        final GoogleCloudStorageHttpStatsCollector httpStatsCollector = new GoogleCloudStorageHttpStatsCollector(stats);
            public HttpRequestInitializer getHttpRequestInitializer(ServiceOptions<?, ?> serviceOptions) {
        }
        final GoogleCloudStorageClientSettings clientSettings,
                    mapBuilder.put("user-agent", clientSettings.getApplicationName());
    public GoogleCloudStorageService(GoogleApplicationDefaultCredentials googleApplicationDefaultCredentials) {
        KeyStore certTrustStore;
                    builder.setProxy(new Proxy(proxySettings.getType(), proxySettings.getAddress()));
     * will be created from the latest settings and will populate the cache. The
                    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                // This is mostly used for testing purpose.
        // Initialize empty BCFKS trust store
import java.security.GeneralSecurityException;
 */
        }
     * Cloud SDK
import org.opensearch.core.common.settings.SecureString;
                    if (requestInitializer != null) requestInitializer.initialize(httpRequest);
        final HttpTransport httpTransport = createHttpTransport(clientSettings);
     */
import com.google.cloud.http.HttpTransportOptions;
                () -> new ParameterizedMessage("creating GCS client with client_name [{}], endpoint [{}]", clientName, settings.getHost())
import java.net.Proxy;
                }
            } catch (Exception e) {
 * compatible open source license.
            // negative value means using the default value
                final ProxySettings proxySettings = clientSettings.getProxySettings();
                };
            );
    private volatile Map<String, Storage> clientCache = emptyMap();
 * license agreements. See the NOTICE file distributed with
        Enumeration<String> aliases = googleDefaultStore.aliases();
            }
        trustStore.load(null, null);
 * this work for additional information regarding copyright
                            }
            if (googleDefaultStore.isCertificateEntry(alias)) {
                storageOptionsBuilder.setCredentials(credentials);
        } else {
            }
import java.io.IOException;
                        Authenticator.setDefault(new Authenticator() {
        }
        // -1 means infinite timeout
    private volatile Map<String, GoogleCloudStorageClientSettings> clientSettings = emptyMap();
                        + Strings.collectionToDelimitedString(clientSettings.keySet(), ",")
    final private GoogleApplicationDefaultCredentials googleApplicationDefaultCredentials;
        if (truststoreSettings.isConfigured()) {
            })
     * Refreshes the client settings and clears the client cache. Subsequent calls to
import static java.util.Collections.emptyMap;
 * specific language governing permissions and limitations
            // requires java.lang.RuntimePermission "setFactory"
    }
    StorageOptions createStorageOptions(
    /**
     * Dictionary of client instances. Client instances are built lazily from the
        while (aliases.hasMoreElements()) {
     * returned instance should not be cached by the calling code. Instead, for each
            }
import com.google.auth.oauth2.ServiceAccountCredentials;
        };
                        + "]. Existing client configs: "
/*
     * the repository name.
import com.google.auth.oauth2.GoogleCredentials;
        throws IOException {
            return storage;
 * under the License.
import java.nio.file.Files;
            .setStorageRetryStrategy(new GoogleShouldRetryStorageStrategy());
        } else if (Security.getProvider("BCFIPS") != null) {
import com.google.api.client.util.SecurityUtils;
    }
                serviceAccountCredentials = serviceAccountCredentials.toBuilder().setTokenServerUri(tokenServerUri).build();
                return storage;
            }
import com.google.cloud.storage.StorageOptions;
import org.opensearch.common.unit.TimeValue;
    private Storage createClient(GoogleCloudStorageClientSettings clientSettings, GoogleCloudStorageOperationsStats stats)
        KeyStore googleDefaultStore = GoogleUtils.getCertificateTrustStore();
            storageOptionsBuilder.setCredentials(serviceAccountCredentials);
    }
            if (storage != null) {
            }
     * Converts timeout values from the settings to a timeout value for the Google
 *
            // 0 is the infinite timeout expected by Google Cloud SDK
                SecurityUtils.loadKeyStore(certTrustStore, trustStoreStream, truststorePassword.toString());
                final TruststoreSettings truststoreSettings = clientSettings.getTruststoreSettings();
    }
import java.net.URI;
 * Unless required by applicable law or agreed to in writing,
    private static final Logger logger = LogManager.getLogger(GoogleCloudStorageService.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
package org.opensearch.repositories.gcs;
     * @return a new client storage instance that can be used to manage objects
 * not use this file except in compliance with the License.
            final var truststoreType = truststoreSettings.type();
import com.google.api.client.http.javanet.NetHttpTransport;
                return builder.build();
    private KeyStore loadTrustStore(TruststoreSettings truststoreSettings) throws GeneralSecurityException, IOException {
import org.opensearch.secure_sm.AccessController;
    }
    ) {
        return AccessController.doPrivileged(() -> storageOptionsBuilder.build());
            return 0;
                throw new IllegalArgumentException(
        }
 * SPDX-License-Identifier: Apache-2.0
                .setHttpTransportFactory(() -> httpTransport)
     * method.
     */
                        + clientName
    }
            if (settings == null) {
            clientCache = MapBuilder.newMapBuilder(clientCache).put(repositoryName, storage).immutableMap();
 * Licensed to Elasticsearch under one or more contributor
import org.apache.logging.log4j.Logger;
                        });
            .setHeaderProvider(() -> {
        if (Strings.hasLength(clientSettings.getHost())) {
                final NetHttpTransport.Builder builder = new NetHttpTransport.Builder();
            }
                    if (proxySettings.isAuthenticated()) {
        if (clientSettings.getCredential() == null) {
            ServiceAccountCredentials serviceAccountCredentials = clientSettings.getCredential();
        clientCache = MapBuilder.newMapBuilder(clientCache).remove(repositoryName).immutableMap();
     *
        KeyStore trustStore = KeyStore.getInstance("BCFKS", "BCFIPS");
                final MapBuilder<String, String> mapBuilder = MapBuilder.newMapBuilder();
                    httpRequest.setResponseInterceptor(httpStatsCollector);
            logger.debug(
                );
        this.clientCache = emptyMap();
                return (httpRequest) -> {
     * use, the (possibly updated) instance should be requested by calling this
            try (var trustStoreStream = Files.newInputStream(truststorePath)) {
        final StorageOptions.Builder storageOptionsBuilder = StorageOptions.newBuilder()
    /**
                return existing;
 * You may obtain a copy of the License at
    private HttpTransport createHttpTransport(final GoogleCloudStorageClientSettings clientSettings) throws IOException {
}
import com.google.api.client.googleapis.GoogleUtils;
                    "Unknown client name ["
import java.security.Security;
     */
        if (timeout == null || TimeValue.ZERO.equals(timeout)) {
            final GoogleCloudStorageClientSettings settings = clientSettings.get(clientName);
        this.googleApplicationDefaultCredentials = googleApplicationDefaultCredentials;
            }
 * KIND, either express or implied.  See the License for the
import com.google.api.client.http.HttpRequestInitializer;
     * @param repositoryName name of the repository that would use the client
     * @param clientName name of the client settings used to create the client
                            @Override
import java.security.KeyStore;
        } else {
 * this file be licensed under the Apache-2.0 license or a
    }
     *
 *
            final var truststorePath = truststoreSettings.path();
/*
        return storageOptions.getService();
                                return new PasswordAuthentication(proxySettings.getUsername(), proxySettings.getPassword().toCharArray());
                if (Strings.hasLength(clientSettings.getApplicationName())) {
            } catch (IOException e) {
import org.apache.logging.log4j.message.ParameterizedMessage;
import java.util.Map;
        });
        }
        final HttpTransportOptions httpTransportOptions
                }
            if (credentials != null) {
            final Storage storage = createClient(settings, stats);
     * @param stats the stats collector used to gather information about the underlying SKD API calls.
        // Null or zero in settings means the default timeout
            logger.debug("Using FIPS-compliant Google default certificate trust store");
        }
    /**
            logger.debug("Loaded custom truststore from path: {} with type: {}", truststorePath, truststoreType);
        this.clientSettings = MapBuilder.newMapBuilder(clientsSettings).immutableMap();
                            protected PasswordAuthentication getPasswordAuthentication() {
        // Load Google's built-in default trust store
            final URI tokenServerUri = clientSettings.getTokenUri();
 * ownership. Elasticsearch licenses this file to you under
            } catch (GeneralSecurityException e) {
import org.opensearch.common.collect.MapBuilder;
            // FIPS mode is active: create FIPS-compliant (BCFKS) truststore with Google default certs
        return certTrustStore;
            try {
            // override token server URI
     *         (blobs)
     **/
    public Storage client(final String clientName, final String repositoryName, final GoogleCloudStorageOperationsStats stats)
                .setReadTimeout(toTimeout(clientSettings.getReadTimeout()))
        }
                throw e;
     *
        }
    }
            return -1;
import org.apache.logging.log4j.LogManager;
                .setConnectTimeout(toTimeout(clientSettings.getConnectTimeout()))
            storageOptionsBuilder.setHost(clientSettings.getHost());
import com.google.api.client.http.HttpTransport;
        // Copy all certificate entries into the FIPS-compliant BCFKS trust store
     * latest settings. Each repository has its own client instance identified by
            logger.info("\"Application Default Credentials\" will be in use");
    public synchronized void refreshAndClearCache(Map<String, GoogleCloudStorageClientSettings> clientsSettings) {
            final Storage existing = clientCache.get(repositoryName);
            certTrustStore = createFipsCompliantGoogleTrustStore();
     * Creates a client that can be used to manage Google Cloud Storage objects. The client is thread-safe.
     * @param clientSettings client settings to use, including secure settings
    }
            certTrustStore = GoogleUtils.getCertificateTrustStore();
            }
        }
 * The OpenSearch Contributors require contributions made to
            if (Strings.hasLength(tokenServerUri.toString())) {
 * Modifications Copyright OpenSearch Contributors. See
import java.net.Authenticator;
 * the Apache License, Version 2.0 (the "License"); you may
        final HttpTransportOptions httpTransportOptions = new HttpTransportOptions(
        // Use BCFKS KeyStore type which is required for FIPS mode
import java.util.Enumeration;
    }
        if (TimeValue.MINUS_ONE.equals(timeout)) {
            certTrustStore = KeyStore.getInstance(truststoreType);
            logger.debug("Using Google default certificate trust store");
     *         (blobs)
    public GoogleCloudStorageService() {
    }
     * using the parameter settings.
    private KeyStore createFipsCompliantGoogleTrustStore() throws GeneralSecurityException, IOException {
    synchronized void closeRepositoryClient(String repositoryName) {
 */
/*
import com.google.cloud.ServiceOptions;
import com.google.cloud.storage.Storage;
        return Math.toIntExact(timeout.getMillis());
            .setTransportOptions(httpTransportOptions)
            @Override
                return mapBuilder.immutableMap();
 *
                throw new IOException("Failed to configure HTTP transport security", e);
                // Rebuild the service account credentials in order to use a custom Token url.
            HttpTransportOptions.newBuilder()
                throw new IOException(e);
                HttpRequestInitializer requestInitializer = super.getHttpRequestInitializer(serviceOptions);
                trustStore.setCertificateEntry(alias, googleDefaultStore.getCertificate(alias));
            final GoogleCredentials credentials = googleApplicationDefaultCredentials.get();
public class GoogleCloudStorageService {
     * Attempts to retrieve a client from the cache. If the client does not exist it
                if (proxySettings != ProxySettings.NO_PROXY_SETTINGS) {
            storageOptionsBuilder.setProjectId(clientSettings.getProjectId());
        ) {
        return AccessController.doPrivilegedChecked(() -> {
        throws IOException {
        if (Strings.hasLength(clientSettings.getProjectId())) {
            final SecureString truststorePassword = truststoreSettings.password();
                builder.trustCertificates(loadTrustStore(truststoreSettings));
        this.googleApplicationDefaultCredentials = new GoogleApplicationDefaultCredentials();
        final StorageOptions storageOptions = createStorageOptions(clientSettings, httpTransportOptions);
import java.net.PasswordAuthentication;
        synchronized (this) {
    static Integer toTimeout(final TimeValue timeout) {
    /**
 * software distributed under the License is distributed on an
import org.opensearch.core.common.Strings;
        {
     * @param stats the stats collector to use by the underlying SDK
 * GitHub history for details.
            }
        return trustStore;
     * @param clientsSettings the new settings used for building clients for subsequent requests
            // Pin the TLS trust certificates.
