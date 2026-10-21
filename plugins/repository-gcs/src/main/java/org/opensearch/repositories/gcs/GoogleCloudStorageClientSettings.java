            );
        this.truststoreSettings = truststoreSettings;
            throw new SettingsException("Google Cloud Storage proxy host is unknown.", e);
            getConfigValue(settings, clientName, CONNECT_TIMEOUT_SETTING),
            getConfigValue(settings, clientName, PROJECT_ID_SETTING),
        final TimeValue readTimeout,
    public static Map<String, GoogleCloudStorageClientSettings> load(final Settings settings) {
 * SPDX-License-Identifier: Apache-2.0
        );
        if (!hasType) {
        this.tokenUri = tokenUri;
    );
        return readTimeout;
    }
    /** The host of a proxy to connect */
                "Google Cloud Storage proxy port or host or username or password have been set but proxy type is not defined."
        "application_name",
            getConfigValue(settings, clientName, TOKEN_URI_SETTING),
    static GoogleCloudStorageClientSettings getClientSettings(final Settings settings, final String clientName) {
public class GoogleCloudStorageClientSettings {
/*
        return new TruststoreSettings(java.nio.file.Path.of(truststorePathString), truststoreType, password);
     * The timeout to establish a connection. A value of {@code -1} corresponds to an infinite timeout. A value of {@code 0}
            Proxy.Type.DIRECT.name(),
        for (final String clientName : settings.getGroups(PREFIX).keySet()) {
    );
 * GitHub history for details.
        "connect_timeout",
        PREFIX,
        "proxy.username",
    }
        } catch (final IOException e) {
    static final Setting.AffixSetting<Proxy.Type> PROXY_TYPE_SETTING = Setting.affixKeySetting(
    );
                    + "' setting to configure the truststore type."
        return connectTimeout;
    public TruststoreSettings getTruststoreSettings() {
    private final TimeValue connectTimeout;
        final String truststoreType = getConfigValue(settings, clientName, TRUSTSTORE_TYPE_SETTING);
        if (!hasPath) {
                final Collection<String> scopes = Collections.singleton(StorageScopes.DEVSTORAGE_FULL_CONTROL);
    static ServiceAccountCredentials loadCredential(final Settings settings, final String clientName) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return endpoint;
        // Validate proxy settings
        this.credential = credential;
        "truststore.password",
        PREFIX,
    /** The credentials used by the client to connect to the Storage endpoint. */
                        return (ServiceAccountCredentials) credentials.createScoped(scopes);
    static final Setting.AffixSetting<String> PROJECT_ID_SETTING = Setting.affixKeySetting(
package org.opensearch.repositories.gcs;
            return TruststoreSettings.NO_TRUSTSTORE_SETTINGS;
        key -> Setting.intSetting(key, 0, 0, (1 << 16) - 1, Setting.Property.NodeScope),
        PREFIX,
    private final URI tokenUri;
 * Container for Google Cloud Storage clients settings.
        "proxy.password",
                "Google Cloud Storage truststore path is missing. Use '"
                return AccessController.doPrivilegedChecked(() -> {
     */
            loadCredential(settings, clientName),
            && (proxyPort != 0 || Strings.hasText(proxyHost) || Strings.hasText(proxyUserName) || Strings.hasText(proxyPassword))) {
    /** The GCS SDK Proxy settings. */
    public String getProjectId() {
import org.opensearch.core.common.settings.SecureString;
                    + TRUSTSTORE_TYPE_SETTING.getConcreteSettingForNamespace(clientName).getKey()
/**
    private final TruststoreSettings truststoreSettings;
import java.io.UncheckedIOException;
        }
    /** The token server URI. This leases access tokens in the oauth flow. */
 *
        }
    );
    static final Setting.AffixSetting<String> TRUSTSTORE_TYPE_SETTING = Setting.affixKeySetting(
    public ProxySettings getProxySettings() {
    private final String applicationName;
            getConfigValue(settings, clientName, APPLICATION_NAME_SETTING),
        key -> Setting.simpleString(key, Setting.Property.NodeScope)
    );
        return credential;
        () -> PROXY_TYPE_SETTING
        PREFIX,
        final Map<String, GoogleCloudStorageClientSettings> clients = new HashMap<>();
    private final TimeValue readTimeout;
        if (proxyType != Proxy.Type.DIRECT && (proxyPort == 0 || Strings.isEmpty(proxyHost))) {
            );
        key -> SecureSetting.secureString(key, null),
    /** The timeout to establish a connection */
        final TimeValue connectTimeout,
    static final Setting.AffixSetting<URI> TOKEN_URI_SETTING = Setting.affixKeySetting(
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
import java.net.URI;
    public URI getTokenUri() {
    /** An override for the Storage endpoint to connect to. */
    /** The timeout to read data from an established connection */
        "endpoint",
import java.net.Proxy;
        PREFIX,
 * the Apache License, Version 2.0 (the "License"); you may
import com.google.api.services.storage.StorageScopes;
import java.net.UnknownHostException;
    );
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        PREFIX,
    static final Setting.AffixSetting<Integer> PROXY_PORT_SETTING = Setting.affixKeySetting(
        this.applicationName = applicationName;
    static final Setting.AffixSetting<InputStream> CREDENTIALS_FILE_SETTING = Setting.affixKeySetting(
        key -> Setting.simpleString(key, Setting.Property.NodeScope),
    static final Setting.AffixSetting<TimeValue> CONNECT_TIMEOUT_SETTING = Setting.affixKeySetting(
        key -> new Setting<>(key, "", URI::create, Setting.Property.NodeScope)
 */
            s -> Proxy.Type.valueOf(s.toUpperCase(Locale.ROOT)),
import java.net.InetAddress;
 */
    static final Setting.AffixSetting<String> PROXY_HOST_SETTING = Setting.affixKeySetting(
        (key) -> new Setting<Proxy.Type>(
        return Strings.hasLength(projectId) ? projectId : (credential != null ? credential.getProjectId() : null);
        () -> PROXY_TYPE_SETTING,
                    }
import java.io.InputStream;
        final SecureString truststorePassword = getConfigValue(settings, clientName, TRUSTSTORE_PASSWORD_SETTING);
import java.util.Collection;
 */
        final String endpoint,
                    final ServiceAccountCredentials credentials = ServiceAccountCredentials.fromStream(credStream);
        final boolean hasPath = Strings.hasText(truststorePathString);
        if (proxyType == Proxy.Type.DIRECT) {
    /**
import java.util.Map;
        PREFIX,
            getConfigValue(settings, clientName, ENDPOINT_SETTING),
            clients.put(clientName, getClientSettings(settings, clientName));
    }
    );
    /** The Google project ID overriding the default way to infer it. Null value sets the default. */
     * @param settings
        key -> Setting.simpleString(key, Setting.Property.NodeScope)
        final SecureString proxyUserName = getConfigValue(settings, clientName, PROXY_USERNAME_SETTING);
        key -> timeSetting(key, TimeValue.ZERO, TimeValue.MINUS_ONE, Setting.Property.NodeScope)
        "token_uri",
     */
        key -> SecureSetting.secureString(key, null)
        if (clients.containsKey("default") == false) {
        key -> SecureSetting.secureString(key, null),
 * license agreements. See the NOTICE file distributed with
            if (CREDENTIALS_FILE_SETTING.getConcreteSettingForNamespace(clientName).exists(settings) == false) {
import java.io.IOException;
     * Loads the service account file corresponding to a given client name. If no
        }
    private final String projectId;
    static TruststoreSettings validateAndCreateTruststoreSettings(final Settings settings, final String clientName) {
     *            the client name
        key -> timeSetting(key, TimeValue.ZERO, TimeValue.MINUS_ONE, Setting.Property.NodeScope)
            validateAndCreateProxySettings(settings, clientName),
                    + "' setting to configure the truststore path."
import org.opensearch.common.settings.Settings;
        return truststoreSettings;
        final int proxyPort = getConfigValue(settings, clientName, PROXY_PORT_SETTING);
    }
        () -> PROXY_HOST_SETTING
        PREFIX,
    }
import java.util.Locale;
        return tokenUri;
        PREFIX,
        final SecureString proxyPassword = getConfigValue(settings, clientName, PROXY_PASSWORD_SETTING);
    }
        final String proxyHost = getConfigValue(settings, clientName, PROXY_HOST_SETTING);
    static final Setting.AffixSetting<SecureString> PROXY_USERNAME_SETTING = Setting.affixKeySetting(
 * Unless required by applicable law or agreed to in writing,
    );
    /** The port of a proxy to connect */
    private final ServiceAccountCredentials credential;
    private static <T> T getConfigValue(final Settings settings, final String clientName, final Setting.AffixSetting<T> clientSetting) {
 * not use this file except in compliance with the License.
    static final Setting.AffixSetting<SecureString> TRUSTSTORE_PASSWORD_SETTING = Setting.affixKeySetting(
import org.opensearch.common.settings.SecureSetting;
    /** The Storage endpoint URL the client should talk to. Null value sets the default. */
    /** The secure password for the truststore */
        final ServiceAccountCredentials credential,
        key -> Setting.simpleString(key, Setting.Property.NodeScope)
        "read_timeout",
    static final Setting.AffixSetting<TimeValue> READ_TIMEOUT_SETTING = Setting.affixKeySetting(
        PREFIX,
            }
 * specific language governing permissions and limitations
            final InetAddress proxyHostAddress = InetAddress.getByName(proxyHost);
        () -> PROXY_TYPE_SETTING,
import org.opensearch.secure_sm.AccessController;
        "project_id",
            clients.put("default", getClientSettings(settings, "default"));
    );
import org.opensearch.core.common.Strings;
            throw new UncheckedIOException(e);
    /** Proxy type */
    }
     * @param clientName
    public ServiceAccountCredentials getCredential() {
     */
            throw new SettingsException(
        }
        }
    /** The GCS SDK Truststore settings. */
    /**
            throw new SettingsException("Google Cloud Storage proxy type has been set but proxy host or port is not defined.");
    }
 * ownership. Elasticsearch licenses this file to you under
    );
        try {
        "truststore.type",
        this.proxySettings = proxySettings;
    ) {
        PREFIX,
    static final Setting.AffixSetting<String> APPLICATION_NAME_SETTING = Setting.affixKeySetting(
 *
        return applicationName;
        return proxySettings;
        PREFIX,
            key,
    /** The password of a proxy to connect */
import java.util.Collections;
     *         {@code null} if no service account is defined.
                    + TRUSTSTORE_PATH_SETTING.getConcreteSettingForNamespace(clientName).getKey()
                    return credentials;
    /** The path to the truststore file for SSL/TLS connections */
import com.google.auth.oauth2.ServiceAccountCredentials;
        key -> new Setting<>(key, "repository-gcs", Function.identity(), Setting.Property.NodeScope, Setting.Property.Deprecated)
        final Proxy.Type proxyType = getConfigValue(settings, clientName, PROXY_TYPE_SETTING);
            }
        return new GoogleCloudStorageClientSettings(
/*
        final ProxySettings proxySettings,
            // this won't find any settings under the default client,
    static final Setting.AffixSetting<SecureString> PROXY_PASSWORD_SETTING = Setting.affixKeySetting(
            return new ProxySettings(proxyType, proxyHostAddress, proxyPort, proxyUserName.toString(), proxyPassword.toString());
     *            the {@link Settings}
        final URI tokenUri,
 * The OpenSearch Contributors require contributions made to
    }
 * this work for additional information regarding copyright
        "proxy.host",
    static final Setting.AffixSetting<String> TRUSTSTORE_PATH_SETTING = Setting.affixKeySetting(
        final String truststorePathString = getConfigValue(settings, clientName, TRUSTSTORE_PATH_SETTING);
                return null;
        "proxy.port",
        final boolean hasPassword = Strings.hasText(password);
        this.connectTimeout = connectTimeout;
    /** An override for the Google Project ID. */
    /** The type of the truststore (e.g., BCFKS, PKCS11, PKCS12, JKS) */
            );
    }
                // can be loaded later when creating the Storage client
    static ProxySettings validateAndCreateProxySettings(final Settings settings, final String clientName) {
        return concreteSetting.get(settings);
        final Setting<T> concreteSetting = clientSetting.getConcreteSettingForNamespace(clientName);
    }
    }
import org.opensearch.common.settings.Setting;
    GoogleCloudStorageClientSettings(
    /** The Storage client application name */
        }
            // but it will pull all the fallback static settings
            throw new SettingsException(
        return Collections.unmodifiableMap(clients);
            Setting.Property.NodeScope
}
            return ProxySettings.NO_PROXY_SETTINGS;
    public TimeValue getConnectTimeout() {
    }
    public String getApplicationName() {
 * this file be licensed under the Apache-2.0 license or a
        if (!hasPath && !hasType && !hasPassword) {
            throw new SettingsException(
    }
    public String getHost() {
    }
    );
 */
        () -> PROXY_USERNAME_SETTING
        PREFIX,
     * The timeout to read data from an established connection. A value of {@code -1} corresponds to an infinite timeout. A value of
    }
        try {
        final boolean hasType = Strings.hasText(truststoreType);
        } catch (final UnknownHostException e) {
        key -> SecureSetting.secureFile(key, null)
     * corresponds to the default timeout of the Google Cloud Storage Java Library.
        PREFIX,
     * {@code 0} corresponds to the default timeout of the Google Cloud Storage Java Library.
     * file is defined for the client, a {@code null} credential is returned.
    private final ProxySettings proxySettings;
 * compatible open source license.
import static org.opensearch.common.settings.Setting.timeSetting;
import org.opensearch.common.unit.TimeValue;
        }
        final TruststoreSettings truststoreSettings
     *
                });
    /**
    /** A json Service Account file loaded from secure settings. */
        key -> Setting.simpleString(key, Setting.Property.NodeScope)
        "proxy.type",
        "credentials_file",
                    if (credentials.createScopedRequired()) {
        this.projectId = projectId;
        final String applicationName,
 * under the License.
    );
            try (InputStream credStream = CREDENTIALS_FILE_SETTING.getConcreteSettingForNamespace(clientName).get(settings)) {
import java.util.function.Function;
    static final Setting.AffixSetting<String> ENDPOINT_SETTING = Setting.affixKeySetting(
    );
        "truststore.path",
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at
        )
import org.opensearch.common.settings.SettingsException;
    private final String endpoint;
            validateAndCreateTruststoreSettings(settings, clientName)
                // explicitly returning null here so that the default credential
    /** The username of a proxy to connect */
        final SecureString password = (truststorePassword != null) ? truststorePassword : new SecureString(new char[0]);
        () -> PROXY_HOST_SETTING
        final String projectId,
    );
    /** Name used by the client when it uses the Google Cloud JSON API. */
    public TimeValue getReadTimeout() {
/*
        () -> PROXY_HOST_SETTING,
        if (proxyType == Proxy.Type.DIRECT
        this.endpoint = endpoint;
    private static final String PREFIX = "gcs.client.";
            getConfigValue(settings, clientName, READ_TIMEOUT_SETTING),
     *
    );
 * software distributed under the License is distributed on an
        }
    /** An override for the Token Server URI in the oauth flow. */
        PREFIX,
        () -> PROXY_TYPE_SETTING,
import java.util.HashMap;
        this.readTimeout = readTimeout;
     * @return the {@link ServiceAccountCredentials} to use for the given client,
 *
        }
                "Google Cloud Storage truststore type is missing. Use '"
