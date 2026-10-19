     * Dictionary of client instances. Client instances are built lazily from the  
     * @param stats the stats collector to use by the underlying SDK  
                return (httpRequest) -> {  
     * Refreshes the client settings and clears the client cache. Subsequent calls to
                );
        return trustStore;
                }  
 */  
 * Unless required by applicable law or agreed to in writing,
            @Override
        final GoogleCloudStorageHttpStatsCollector httpStatsCollector = new GoogleCloudStorageHttpStatsCollector(stats);
            .setTransportOptions(httpTransportOptions)
        return storageOptions.getService();  
        // -1 means infinite timeout
        trustStore.load(null, null);
    }
        return AccessController.doPrivileged(() -> storageOptionsBuilder.build());
                        Authenticator.setDefault(new Authenticator() {
        }
            // requires java.lang.RuntimePermission "setFactory"
     */
            // 0 is the infinite timeout expected by Google Cloud SDK
                throw e;
     * Converts timeout values from the settings to a timeout value for the Google
            logger.debug("Using Google default certificate trust store");
            // FIPS mode is active: create FIPS-compliant (BCFKS) truststore with Google default certs  
            logger.debug("Using FIPS-compliant Google default certificate trust store");
    public GoogleCloudStorageService(GoogleApplicationDefaultCredentials googleApplicationDefaultCredentials) {  
     * @param clientSettings client settings to use, including secure settings
    /**
    }
            return storage;  
            }
import java.security.Security;
     * Cloud SDK  
     * @param clientName name of the client settings used to create the client
    public synchronized void refreshAndClearCache(Map<String, GoogleCloudStorageClientSettings> clientsSettings) {
            if (existing != null) {
            }
    private KeyStore createFipsCompliantGoogleTrustStore() throws GeneralSecurityException, IOException {
 * KIND, either express or implied.  See the License for the
    static Integer toTimeout(final TimeValue timeout) {
    /**
        } else {
package org.opensearch.repositories.gcs;
                throw new IllegalArgumentException(
                // Rebuild the service account credentials in order to use a custom Token url.
import com.google.api.client.googleapis.GoogleUtils;
     **/
                return mapBuilder.immutableMap();
                throw new IOException(e);
     * @return a cached client storage instance that can be used to manage objects
            }  
                                return new PasswordAuthentication(proxySettings.getUsername(), proxySettings.getPassword().toCharArray());
                        + Strings.collectionToDelimitedString(clientSettings.keySet(), ",")  
 * You may obtain a copy of the License at  
                builder.trustCertificates(loadTrustStore(truststoreSettings));
            if (storage != null) {  
                    "Unknown client name ["  
        return AccessController.doPrivilegedChecked(() -> {
        }
import java.net.Proxy;  
import com.google.api.client.http.javanet.NetHttpTransport;
        return certTrustStore;  
                final TruststoreSettings truststoreSettings = clientSettings.getTruststoreSettings();
                        + "]. Existing client configs: "
    public Storage client(final String clientName, final String repositoryName, final GoogleCloudStorageOperationsStats stats)
                throw new IOException("Failed to configure HTTP transport security", e);  
            public HttpRequestInitializer getHttpRequestInitializer(ServiceOptions<?, ?> serviceOptions) {  
            HttpTransportOptions.newBuilder()
                SecurityUtils.loadKeyStore(certTrustStore, trustStoreStream, truststorePassword.toString());
     *         (blobs)
import org.opensearch.common.collect.MapBuilder;  
                    mapBuilder.put("user-agent", clientSettings.getApplicationName());  
import org.opensearch.secure_sm.AccessController;
    private KeyStore loadTrustStore(TruststoreSettings truststoreSettings) throws GeneralSecurityException, IOException {  
                trustStore.setCertificateEntry(alias, googleDefaultStore.getCertificate(alias));  
import com.google.auth.oauth2.GoogleCredentials;  
                }
        while (aliases.hasMoreElements()) {  
    }
            // override token server URI
     * method.  
            } catch (GeneralSecurityException e) {
     *
            })  
     */
        });  
            certTrustStore = createFipsCompliantGoogleTrustStore();
     *
    final private GoogleApplicationDefaultCredentials googleApplicationDefaultCredentials;  
import com.google.auth.oauth2.ServiceAccountCredentials;
 * this file be licensed under the Apache-2.0 license or a
     * Creates a client that can be used to manage Google Cloud Storage objects. The client is thread-safe.  
    }
import java.nio.file.Files;
import org.opensearch.core.common.settings.SecureString;  
    private volatile Map<String, Storage> clientCache = emptyMap();
        {
        if (Strings.hasLength(clientSettings.getHost())) {
     * Attempts to retrieve a client from the cache. If the client does not exist it
    synchronized void closeRepositoryClient(String repositoryName) {
        if (truststoreSettings.isConfigured()) {
        }
import org.apache.logging.log4j.LogManager;  
                    }
/*  
        }  
        };  
            return -1;  
    }  
        }
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.logging.log4j.Logger;
 * Licensed to Elasticsearch under one or more contributor  
                final MapBuilder<String, String> mapBuilder = MapBuilder.newMapBuilder();
     * @param stats the stats collector used to gather information about the underlying SKD API calls.
}  
import java.security.KeyStore;
import java.io.IOException;  
            final Storage existing = clientCache.get(repositoryName);
            if (Strings.hasLength(tokenServerUri.toString())) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * will be created from the latest settings and will populate the cache. The  
    }
                        + clientName
                // This is mostly used for testing purpose.
 * Modifications Copyright OpenSearch Contributors. See
        return Math.toIntExact(timeout.getMillis());
        this.clientCache = emptyMap();  
    private HttpTransport createHttpTransport(final GoogleCloudStorageClientSettings clientSettings) throws IOException {  
        if (TimeValue.MINUS_ONE.equals(timeout)) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @return a new client storage instance that can be used to manage objects
            certTrustStore = GoogleUtils.getCertificateTrustStore();  
            storageOptionsBuilder.setCredentials(serviceAccountCredentials);
        }  
            // Pin the TLS trust certificates.
                    if (proxySettings.isAuthenticated()) {  
 * under the License.  
    private static final Logger logger = LogManager.getLogger(GoogleCloudStorageService.class);
                HttpRequestInitializer requestInitializer = super.getHttpRequestInitializer(serviceOptions);
 * software distributed under the License is distributed on an
        KeyStore certTrustStore;
 * SPDX-License-Identifier: Apache-2.0
import static java.util.Collections.emptyMap;  
            try (var trustStoreStream = Files.newInputStream(truststorePath)) {
import java.net.URI;
        } else if (Security.getProvider("BCFIPS") != null) {
                .setReadTimeout(toTimeout(clientSettings.getReadTimeout()))
        final StorageOptions.Builder storageOptionsBuilder = StorageOptions.newBuilder()
        synchronized (this) {
/*
                return builder.build();
     * @param repositoryName name of the repository that would use the client  
                            @Override
            ServiceAccountCredentials serviceAccountCredentials = clientSettings.getCredential();  
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
        throws IOException {
        final HttpTransportOptions httpTransportOptions = new HttpTransportOptions(
            String alias = aliases.nextElement();
                    builder.setProxy(new Proxy(proxySettings.getType(), proxySettings.getAddress()));
        // Initialize empty BCFKS trust store
            final GoogleCredentials credentials = googleApplicationDefaultCredentials.get();
            } catch (IOException e) {
        clientCache = MapBuilder.newMapBuilder(clientCache).remove(repositoryName).immutableMap();
                return existing;
            }
                if (proxySettings != ProxySettings.NO_PROXY_SETTINGS) {
 *  
 * this work for additional information regarding copyright
    private volatile Map<String, GoogleCloudStorageClientSettings> clientSettings = emptyMap();  
        final StorageOptions storageOptions = createStorageOptions(clientSettings, httpTransportOptions);
 * The OpenSearch Contributors require contributions made to  
    private Storage createClient(GoogleCloudStorageClientSettings clientSettings, GoogleCloudStorageOperationsStats stats)
            .setStorageRetryStrategy(new GoogleShouldRetryStorageStrategy());
    }
    /**
        this.googleApplicationDefaultCredentials = new GoogleApplicationDefaultCredentials();  
        KeyStore trustStore = KeyStore.getInstance("BCFKS", "BCFIPS");  
        if (Strings.hasLength(clientSettings.getProjectId())) {
        if (timeout == null || TimeValue.ZERO.equals(timeout)) {
            }
            if (credentials != null) {
     *
        // Use BCFKS KeyStore type which is required for FIPS mode
            final var truststorePath = truststoreSettings.path();  
 * GitHub history for details.
            final Storage storage = clientCache.get(repositoryName);
            final Storage storage = createClient(settings, stats);
            }
                            }
        KeyStore googleDefaultStore = GoogleUtils.getCertificateTrustStore();
     * {@code GoogleCloudStorageService#client} will return new clients constructed  
 */
            final GoogleCloudStorageClientSettings settings = clientSettings.get(clientName);
            if (googleDefaultStore.isCertificateEntry(alias)) {
                .setConnectTimeout(toTimeout(clientSettings.getConnectTimeout()))  
        if (clientSettings.getCredential() == null) {
 * not use this file except in compliance with the License.
import java.util.Enumeration;  
        }
 *
                .setHttpTransportFactory(() -> httpTransport)
    StorageOptions createStorageOptions(  
            logger.debug("Loaded custom truststore from path: {} with type: {}", truststorePath, truststoreType);
import org.opensearch.common.unit.TimeValue;
            logger.debug(
        this.googleApplicationDefaultCredentials = googleApplicationDefaultCredentials;
                    if (requestInitializer != null) requestInitializer.initialize(httpRequest);
    }
            storageOptionsBuilder.setHost(clientSettings.getHost());  
 *
     */  
import com.google.cloud.storage.StorageOptions;
    /**
    /**
import org.opensearch.core.common.Strings;
                };
            try {
import java.net.PasswordAuthentication;
                            protected PasswordAuthentication getPasswordAuthentication() {  
     * the repository name.
            );  
import com.google.cloud.storage.Storage;
                () -> new ParameterizedMessage("creating GCS client with client_name [{}], endpoint [{}]", clientName, settings.getHost())
        }  
        ) {  
            final URI tokenServerUri = clientSettings.getTokenUri();
            }
 */  
                return storage;
 * license agreements. See the NOTICE file distributed with
            final SecureString truststorePassword = truststoreSettings.password();
                    httpRequest.setResponseInterceptor(httpStatsCollector);  
            final var truststoreType = truststoreSettings.type();
     *         (blobs)  
import com.google.api.client.http.HttpRequestInitializer;
        final HttpTransport httpTransport = createHttpTransport(clientSettings);  
     */  
import java.net.Authenticator;
                        });  
     * @param clientsSettings the new settings used for building clients for subsequent requests  
    public GoogleCloudStorageService() {
        } else {  
import java.security.GeneralSecurityException;  
            logger.info("\"Application Default Credentials\" will be in use");  
            storageOptionsBuilder.setProjectId(clientSettings.getProjectId());  
            .setHeaderProvider(() -> {  
            certTrustStore = KeyStore.getInstance(truststoreType);  
            }  
public class GoogleCloudStorageService {
     * use, the (possibly updated) instance should be requested by calling this
        final HttpTransportOptions httpTransportOptions
            clientCache = MapBuilder.newMapBuilder(clientCache).put(repositoryName, storage).immutableMap();
            if (settings == null) {
     * returned instance should not be cached by the calling code. Instead, for each
                serviceAccountCredentials = serviceAccountCredentials.toBuilder().setTokenServerUri(tokenServerUri).build();  
            }
     * latest settings. Each repository has its own client instance identified by
        this.clientSettings = MapBuilder.newMapBuilder(clientsSettings).immutableMap();
 * compatible open source license.
        throws IOException {  
        Enumeration<String> aliases = googleDefaultStore.aliases();  
        }
            return 0;
                storageOptionsBuilder.setCredentials(credentials);  
                final NetHttpTransport.Builder builder = new NetHttpTransport.Builder();  
        final GoogleCloudStorageClientSettings clientSettings,
    ) {  
/*  
        // Null or zero in settings means the default timeout  
 * the Apache License, Version 2.0 (the "License"); you may
import com.google.api.client.http.HttpTransport;  
        // Load Google's built-in default trust store
     * using the parameter settings.
            } catch (Exception e) {  
    }
import java.util.Map;
 * specific language governing permissions and limitations
import com.google.cloud.http.HttpTransportOptions;  
import com.google.api.client.util.SecurityUtils;
                final ProxySettings proxySettings = clientSettings.getProxySettings();
        // Copy all certificate entries into the FIPS-compliant BCFKS trust store
import com.google.cloud.ServiceOptions;
            // negative value means using the default value
                if (Strings.hasLength(clientSettings.getApplicationName())) {
    }
