    /** An override for the Storage endpoint to connect to. */
 * license agreements. See the NOTICE file distributed with
        "read_timeout",  
    );
        key -> Setting.simpleString(key, Setting.Property.NodeScope)
        this.applicationName = applicationName;  
    }
    /** The timeout to read data from an established connection */
        key -> Setting.simpleString(key, Setting.Property.NodeScope)
/**  
    static final Setting.AffixSetting<InputStream> CREDENTIALS_FILE_SETTING = Setting.affixKeySetting(
            getConfigValue(settings, clientName, ENDPOINT_SETTING),
    static final Setting.AffixSetting<SecureString> TRUSTSTORE_PASSWORD_SETTING = Setting.affixKeySetting(
    }
        "token_uri",
            );
import java.util.HashMap;
    static ServiceAccountCredentials loadCredential(final Settings settings, final String clientName) {
    /** The port of a proxy to connect */
        PREFIX,  
    }
        PREFIX,
        final String truststoreType = getConfigValue(settings, clientName, TRUSTSTORE_TYPE_SETTING);  
    }
                    + TRUSTSTORE_PATH_SETTING.getConcreteSettingForNamespace(clientName).getKey()
        final Setting<T> concreteSetting = clientSetting.getConcreteSettingForNamespace(clientName);  
        key -> timeSetting(key, TimeValue.ZERO, TimeValue.MINUS_ONE, Setting.Property.NodeScope)
                });
    public String getApplicationName() {
        "project_id",  
        PREFIX,  
 * Licensed to Elasticsearch under one or more contributor  
        this.truststoreSettings = truststoreSettings;  
 * not use this file except in compliance with the License.
            getConfigValue(settings, clientName, READ_TIMEOUT_SETTING),
    /**  
        final String projectId,
import java.util.Map;
        final Proxy.Type proxyType = getConfigValue(settings, clientName, PROXY_TYPE_SETTING);
        PREFIX,  
    }
        if (proxyType == Proxy.Type.DIRECT) {
            return TruststoreSettings.NO_TRUSTSTORE_SETTINGS;
 * this work for additional information regarding copyright
    static final Setting.AffixSetting<SecureString> PROXY_PASSWORD_SETTING = Setting.affixKeySetting(
        () -> PROXY_USERNAME_SETTING
                    + TRUSTSTORE_TYPE_SETTING.getConcreteSettingForNamespace(clientName).getKey()
        final boolean hasPassword = Strings.hasText(password);
    static final Setting.AffixSetting<TimeValue> READ_TIMEOUT_SETTING = Setting.affixKeySetting(
     *            the client name
    /** Name used by the client when it uses the Google Cloud JSON API. */
    /** An override for the Token Server URI in the oauth flow. */
import java.net.UnknownHostException;
        "proxy.username",
        final URI tokenUri,  
        final ProxySettings proxySettings,
    );
    /** The type of the truststore (e.g., BCFKS, PKCS11, PKCS12, JKS) */
                    return credentials;  
        )
     *         {@code null} if no service account is defined.
    private static final String PREFIX = "gcs.client.";
        () -> PROXY_HOST_SETTING,
        if (!hasType) {
            }
import java.net.InetAddress;
        }
package org.opensearch.repositories.gcs;
    /** The secure password for the truststore */  
import org.opensearch.common.settings.SettingsException;
public class GoogleCloudStorageClientSettings {  
        () -> PROXY_TYPE_SETTING
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                "Google Cloud Storage truststore type is missing. Use '"  
    static final Setting.AffixSetting<Integer> PROXY_PORT_SETTING = Setting.affixKeySetting(
import org.opensearch.secure_sm.AccessController;  
 * SPDX-License-Identifier: Apache-2.0
        );  
 * Unless required by applicable law or agreed to in writing,
        return concreteSetting.get(settings);
    );
        this.connectTimeout = connectTimeout;
    );
import java.util.function.Function;
                "Google Cloud Storage truststore path is missing. Use '"
        () -> PROXY_HOST_SETTING
        key -> timeSetting(key, TimeValue.ZERO, TimeValue.MINUS_ONE, Setting.Property.NodeScope)  
     * @return the {@link ServiceAccountCredentials} to use for the given client,
    /** The host of a proxy to connect */
import java.util.Locale;  
            getConfigValue(settings, clientName, CONNECT_TIMEOUT_SETTING),  
        return readTimeout;
        "proxy.host",
        final Map<String, GoogleCloudStorageClientSettings> clients = new HashMap<>();
    }  
        final boolean hasType = Strings.hasText(truststoreType);
        PREFIX,
import com.google.api.services.storage.StorageScopes;  
    );
                    final ServiceAccountCredentials credentials = ServiceAccountCredentials.fromStream(credStream);
 * specific language governing permissions and limitations
        final ServiceAccountCredentials credential,  
            return ProxySettings.NO_PROXY_SETTINGS;
import java.util.Collections;
}  
        PREFIX,
    }
    /** The token server URI. This leases access tokens in the oauth flow. */
    }
        PREFIX,
    );
            validateAndCreateTruststoreSettings(settings, clientName)
    private final TimeValue connectTimeout;  
     * {@code 0} corresponds to the default timeout of the Google Cloud Storage Java Library.
                return null;  
                    if (credentials.createScopedRequired()) {  
    );  
        }
            final InetAddress proxyHostAddress = InetAddress.getByName(proxyHost);  
import org.opensearch.common.settings.SecureSetting;
        PREFIX,
        "proxy.type",
        "truststore.password",  
 * GitHub history for details.
    );
    }  
        "credentials_file",
    private final String projectId;  
            Setting.Property.NodeScope
                // explicitly returning null here so that the default credential
        }  
        key -> new Setting<>(key, "", URI::create, Setting.Property.NodeScope)
    /**
                final Collection<String> scopes = Collections.singleton(StorageScopes.DEVSTORAGE_FULL_CONTROL);  
     *
import java.net.URI;
        "application_name",
        final TimeValue connectTimeout,  
        () -> PROXY_TYPE_SETTING,  
        key -> SecureSetting.secureString(key, null)
        return Strings.hasLength(projectId) ? projectId : (credential != null ? credential.getProjectId() : null);  
 * KIND, either express or implied.  See the License for the
        return new GoogleCloudStorageClientSettings(
     *  
 */
    );  
    /** The password of a proxy to connect */
                    }
import java.util.Collection;  
import org.opensearch.common.unit.TimeValue;  
        final SecureString password = (truststorePassword != null) ? truststorePassword : new SecureString(new char[0]);
    public TimeValue getConnectTimeout() {  
     */  
        "truststore.type",
    /**
    /** The timeout to establish a connection */
    public URI getTokenUri() {  
     * @param clientName
        this.endpoint = endpoint;
/*  
 * ownership. Elasticsearch licenses this file to you under  
    static TruststoreSettings validateAndCreateTruststoreSettings(final Settings settings, final String clientName) {
        key -> Setting.intSetting(key, 0, 0, (1 << 16) - 1, Setting.Property.NodeScope),
            throw new UncheckedIOException(e);
        } catch (final UnknownHostException e) {
            if (CREDENTIALS_FILE_SETTING.getConcreteSettingForNamespace(clientName).exists(settings) == false) {  
        final TruststoreSettings truststoreSettings
import com.google.auth.oauth2.ServiceAccountCredentials;
 * Modifications Copyright OpenSearch Contributors. See  
    }  
        }  
        key -> SecureSetting.secureFile(key, null)
import org.opensearch.core.common.Strings;
        "truststore.path",
        }  
        return new TruststoreSettings(java.nio.file.Path.of(truststorePathString), truststoreType, password);
        }  
    static final Setting.AffixSetting<String> PROXY_HOST_SETTING = Setting.affixKeySetting(  
            && (proxyPort != 0 || Strings.hasText(proxyHost) || Strings.hasText(proxyUserName) || Strings.hasText(proxyPassword))) {
    );  
        PREFIX,  
        return connectTimeout;
import java.io.IOException;
        try {
 * software distributed under the License is distributed on an
        return proxySettings;
 *  
     *            the {@link Settings}  
            // but it will pull all the fallback static settings
    /** The credentials used by the client to connect to the Storage endpoint. */
import java.net.Proxy;  
                return AccessController.doPrivilegedChecked(() -> {
    static final Setting.AffixSetting<URI> TOKEN_URI_SETTING = Setting.affixKeySetting(
        if (proxyType != Proxy.Type.DIRECT && (proxyPort == 0 || Strings.isEmpty(proxyHost))) {
     * Loads the service account file corresponding to a given client name. If no
     * file is defined for the client, a {@code null} credential is returned.  
 * The OpenSearch Contributors require contributions made to  
    }
        this.proxySettings = proxySettings;
        key -> new Setting<>(key, "repository-gcs", Function.identity(), Setting.Property.NodeScope, Setting.Property.Deprecated)
/*
    GoogleCloudStorageClientSettings(
    private final ServiceAccountCredentials credential;  
import static org.opensearch.common.settings.Setting.timeSetting;
            getConfigValue(settings, clientName, APPLICATION_NAME_SETTING),
            try (InputStream credStream = CREDENTIALS_FILE_SETTING.getConcreteSettingForNamespace(clientName).get(settings)) {
            getConfigValue(settings, clientName, TOKEN_URI_SETTING),  
            throw new SettingsException(  
    private final TruststoreSettings truststoreSettings;  
        PREFIX,  
        }
        this.tokenUri = tokenUri;
    }
     * The timeout to establish a connection. A value of {@code -1} corresponds to an infinite timeout. A value of {@code 0}  
    static final Setting.AffixSetting<Proxy.Type> PROXY_TYPE_SETTING = Setting.affixKeySetting(  
        }
     * The timeout to read data from an established connection. A value of {@code -1} corresponds to an infinite timeout. A value of
            throw new SettingsException(  
        "proxy.password",
        this.projectId = projectId;  
        (key) -> new Setting<Proxy.Type>(  
        return applicationName;  
    static final Setting.AffixSetting<String> TRUSTSTORE_TYPE_SETTING = Setting.affixKeySetting(
            loadCredential(settings, clientName),  
     */
import org.opensearch.common.settings.Settings;
import java.io.InputStream;  
    }
    public TruststoreSettings getTruststoreSettings() {
        PREFIX,  
            clients.put("default", getClientSettings(settings, "default"));
/*
    private static <T> T getConfigValue(final Settings settings, final String clientName, final Setting.AffixSetting<T> clientSetting) {
                        return (ServiceAccountCredentials) credentials.createScoped(scopes);
    /** Proxy type */
 */
    }  
    static GoogleCloudStorageClientSettings getClientSettings(final Settings settings, final String clientName) {
        return tokenUri;
 * the Apache License, Version 2.0 (the "License"); you may
    public String getHost() {
        this.readTimeout = readTimeout;
            throw new SettingsException("Google Cloud Storage proxy host is unknown.", e);  
            getConfigValue(settings, clientName, PROJECT_ID_SETTING),
            clients.put(clientName, getClientSettings(settings, clientName));  
            validateAndCreateProxySettings(settings, clientName),
    ) {  
    /** The Storage endpoint URL the client should talk to. Null value sets the default. */
        PREFIX,
        key -> Setting.simpleString(key, Setting.Property.NodeScope)  
    /** A json Service Account file loaded from secure settings. */
    /** The GCS SDK Proxy settings. */
        key -> SecureSetting.secureString(key, null),
        // Validate proxy settings  
        key -> Setting.simpleString(key, Setting.Property.NodeScope)  
        if (!hasPath && !hasType && !hasPassword) {
            );
    static ProxySettings validateAndCreateProxySettings(final Settings settings, final String clientName) {  
    static final Setting.AffixSetting<String> TRUSTSTORE_PATH_SETTING = Setting.affixKeySetting(  
    public ProxySettings getProxySettings() {
    static final Setting.AffixSetting<SecureString> PROXY_USERNAME_SETTING = Setting.affixKeySetting(
        "proxy.port",
        final SecureString proxyUserName = getConfigValue(settings, clientName, PROXY_USERNAME_SETTING);
                    + "' setting to configure the truststore path."  
 * this file be licensed under the Apache-2.0 license or a
    public static Map<String, GoogleCloudStorageClientSettings> load(final Settings settings) {  
    /** The Google project ID overriding the default way to infer it. Null value sets the default. */
    }
 * You may obtain a copy of the License at  
    /** The path to the truststore file for SSL/TLS connections */
        "endpoint",
        if (proxyType == Proxy.Type.DIRECT
            throw new SettingsException(
        final SecureString proxyPassword = getConfigValue(settings, clientName, PROXY_PASSWORD_SETTING);
        PREFIX,
        }
                // can be loaded later when creating the Storage client
                "Google Cloud Storage proxy port or host or username or password have been set but proxy type is not defined."
            s -> Proxy.Type.valueOf(s.toUpperCase(Locale.ROOT)),  
    static final Setting.AffixSetting<TimeValue> CONNECT_TIMEOUT_SETTING = Setting.affixKeySetting(  
    );
        final SecureString truststorePassword = getConfigValue(settings, clientName, TRUSTSTORE_PASSWORD_SETTING);
 * under the License.  
     * @param settings
        PREFIX,  
        final String applicationName,
        try {
        key -> SecureSetting.secureString(key, null),
    /** The Storage client application name */
    );  
        final String endpoint,
            Proxy.Type.DIRECT.name(),
    static final Setting.AffixSetting<String> PROJECT_ID_SETTING = Setting.affixKeySetting(
    /** An override for the Google Project ID. */  
            return new ProxySettings(proxyType, proxyHostAddress, proxyPort, proxyUserName.toString(), proxyPassword.toString());
        return credential;
    public String getProjectId() {
        } catch (final IOException e) {  
        () -> PROXY_TYPE_SETTING,  
    private final String applicationName;  
        final TimeValue readTimeout,
 * Container for Google Cloud Storage clients settings.
            // this won't find any settings under the default client,  
            key,
    static final Setting.AffixSetting<String> ENDPOINT_SETTING = Setting.affixKeySetting(  
        return Collections.unmodifiableMap(clients);
 */
     */  
    );  
    private final URI tokenUri;  
    private final TimeValue readTimeout;  
        if (!hasPath) {
        "connect_timeout",
        this.credential = credential;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        () -> PROXY_HOST_SETTING
    private final ProxySettings proxySettings;  
        return truststoreSettings;  
    public ServiceAccountCredentials getCredential() {  
        return endpoint;
 *
    /** The GCS SDK Truststore settings. */
    private final String endpoint;  
import org.opensearch.common.settings.Setting;  
    public TimeValue getReadTimeout() {
        }  
        final String truststorePathString = getConfigValue(settings, clientName, TRUSTSTORE_PATH_SETTING);
    );  
        final String proxyHost = getConfigValue(settings, clientName, PROXY_HOST_SETTING);
 *
 * compatible open source license.
        () -> PROXY_TYPE_SETTING,  
 */  
        key -> Setting.simpleString(key, Setting.Property.NodeScope),  
     * corresponds to the default timeout of the Google Cloud Storage Java Library.
        final int proxyPort = getConfigValue(settings, clientName, PROXY_PORT_SETTING);  
    static final Setting.AffixSetting<String> APPLICATION_NAME_SETTING = Setting.affixKeySetting(
        final boolean hasPath = Strings.hasText(truststorePathString);  
import java.io.UncheckedIOException;
import org.opensearch.core.common.settings.SecureString;
    /** The username of a proxy to connect */
            }
            throw new SettingsException("Google Cloud Storage proxy type has been set but proxy host or port is not defined.");
        if (clients.containsKey("default") == false) {
        for (final String clientName : settings.getGroups(PREFIX).keySet()) {
        PREFIX,
            );  
                    + "' setting to configure the truststore type."
    );
