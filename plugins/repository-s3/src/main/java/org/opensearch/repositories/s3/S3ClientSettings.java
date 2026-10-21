            disableChunkedEncoding,
            );
                    + PROTOCOL_SETTING.getConcreteSettingForNamespace(clientName).getKey()
        "secret_key",
            && (proxyPort != 80 || Strings.hasText(proxyHost) || Strings.hasText(proxyUserName) || Strings.hasText(proxyPassword))) {
        final Setting<T> concreteSetting = clientSetting.getConcreteSettingForNamespace(clientName);
        if (checkDeprecatedCredentials(repositorySettings)) {
            throw new SettingsException("SOCKS proxy is not supported for HTTP protocol");
            connectionTimeoutMillis,
        key -> Setting.timeSetting(key, TimeValue.timeValueMinutes(15), Property.NodeScope)
            InetAddress.getByName(proxyHost);
        PREFIX,
            newMaxSyncConnections,
            throw new SettingsException("S3 proxy port or host or username or password have been set but proxy type is not defined.");
                return null;
                return true;
    static final Setting.AffixSetting<TimeValue> CONNECTION_TIMEOUT_SETTING = Setting.affixKeySetting(
    );
        "use_throttle_retries",
        final String newRegion = getRepoSettingOrDefault(REGION, normalizedSettings, region);
        this.protocol = protocol;
        PREFIX,
        "region",
    private static final String PLACEHOLDER_CLIENT = "placeholder";
            && connectionTimeoutMillis == that.connectionTimeoutMillis
    static final Setting.AffixSetting<String> IDENTITY_TOKEN_FILE_SETTING = Setting.affixKeySetting(
/*
        );
    private static AwsCredentials loadCredentials(Settings settings, String clientName) {
        public String getRoleSessionName() {
        if (o == null || getClass() != o.getClass()) {
            && maxRetries == that.maxRetries
        }
                        return AwsBasicCredentials.create(accessKey.toString(), secretKey.toString());
    final int connectionTimeoutMillis;
    static final Setting.AffixSetting<Boolean> LEGACY_MD5_CHECKSUM_CALCULATION = Setting.affixKeySetting(
    );
            newRegion,
    );
    /** An override for the s3 region to use for signing requests. */
        );
            getRepoSettingOrDefault(MAX_SYNC_CONNECTIONS_SETTING, normalizedSettings, maxConnections)
        key -> Setting.intSetting(key, 80, 0, (1 << 16) - 1, Property.NodeScope)
    final String region;
        final int newMaxRetries = getRepoSettingOrDefault(MAX_RETRIES_SETTING, normalizedSettings, maxRetries);
        this.maxSyncConnections = maxSyncConnections;
import java.util.Locale;
        this.maxRetries = maxRetries;
        "connection_timeout",
                        return AwsSessionCredentials.create(accessKey.toString(), secretKey.toString(), sessionToken.toString());
            // If the path is not absolute, resolve it relatively to config path
    final boolean legacyMd5ChecksumCalculation;
            newSignerOverride,
    static final Setting.AffixSetting<Protocol> PROTOCOL_SETTING = Setting.affixKeySetting(
            .put(repositorySettings)
        if (clients.containsKey("default") == false) {
 */
            && requestTimeoutMillis == that.requestTimeoutMillis
        "proxy.port",
        int requestTimeoutMillis,
                throw new IllegalArgumentException(
            && Objects.equals(disableChunkedEncoding, that.disableChunkedEncoding)
            newThrottleRetries,
 * Unless required by applicable law or agreed to in writing,
            clients.put("default", getClientSettings(settings, "default", configPath));
        );
     * Note this will always at least return a client named "default".
        }
    /** Credentials to authenticate with s3. */
public final class S3ClientSettings {
    /**
    /** The timeout for an entire S3 API call, including retries, or zero if unset. */
            proxySettings,
        } catch (final UnknownHostException e) {
        this.connectionAcquisitionTimeoutMillis = connectionAcquisitionTimeoutMillis;
            // which is a separate setting for AWS SDK.
        this.signerOverride = signerOverride;
    );
        PREFIX,
            protocol,
            .normalizePrefix(PREFIX + PLACEHOLDER_CLIENT + '.')
            endpoint,
        }
            && newReadTimeoutMillis == readTimeoutMillis
            getRepoSettingOrDefault(REQUEST_TIMEOUT_SETTING, normalizedSettings, TimeValue.timeValueMillis(requestTimeoutMillis)).millis()
            newDisableChunkedEncoding,
import java.util.function.Function;
        PREFIX,
    static final Setting.AffixSetting<Integer> MAX_SYNC_CONNECTIONS_SETTING = Setting.affixKeySetting(
            return roleSessionName;
    static final Setting.AffixSetting<TimeValue> API_CALL_TIMEOUT_SETTING = Setting.affixKeySetting(
    }
        try (
        key -> Setting.boolSetting(key, false, Property.NodeScope)
            validateAndCreateProxySettings(settings, clientName, awsProtocol),
import org.opensearch.common.SuppressForbidden;
            this.roleArn = Strings.isNullOrEmpty(roleArn) ? null : roleArn;
import org.opensearch.common.settings.Settings;
        this.throttleRetries = throttleRetries;
            irsaCredentials,
 * this work for additional information regarding copyright
        }
            Math.toIntExact(getConfigValue(settings, clientName, READ_TIMEOUT_SETTING).millis()),
    static final Setting.AffixSetting<String> ENDPOINT_SETTING = Setting.affixKeySetting(
                        + "]"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * See please: https://docs.aws.amazon.com/eks/latest/userguide/iam-roles-for-service-accounts.html
    }
    );
        this.endpoint = endpoint;
    );
            && Objects.equals(credentials, newCredentials)
        return false;
    /** An override for the s3 region to use for signing requests. */
    /** The number of retries to use when an s3 request fails. */
        );
        PREFIX,
            SecureString secretKey = getConfigValue(settings, clientName, SECRET_KEY_SETTING);
        ProxySettings.ProxyType proxyType = getConfigValue(settings, clientName, PROXY_TYPE_SETTING);
            deprecationLogger.deprecate(
import java.util.Objects;
        int connectionAcquisitionTimeoutMillis,
    }
        int maxConnections,
            newPathStyleAccess,
            newReadTimeoutMillis,
            DISABLE_CHUNKED_ENCODING,
        return new S3ClientSettings(
        this.readTimeoutMillis = readTimeoutMillis;
            this.roleSessionName = Strings.isNullOrEmpty(roleSessionName) ? "s3-sdk-java-" + System.currentTimeMillis() : roleSessionName;
        key -> SecureSetting.secureString(key, null)
            }
            S3ClientSettings.loadCredentials(settings, clientName),
            connectionAcquisitionTimeoutMillis,
        key -> new Setting<>(key, "", Function.identity(), Property.NodeScope)
    static final Setting.AffixSetting<SecureString> PROXY_USERNAME_SETTING = Setting.affixKeySetting(
        "connection_ttl",
                        + S3Repository.ACCESS_KEY_SETTING.getKey()
        IrsaCredentials(String identityTokenFile, String roleArn, String roleSessionName) {
        PREFIX,
    static final Setting.AffixSetting<TimeValue> CONNECTION_TTL_SETTING = Setting.affixKeySetting(
        int apiCallTimeoutMillis,
        boolean disableChunkedEncoding,
    static final Setting.AffixSetting<String> PROXY_HOST_SETTING = Setting.affixKeySetting(
    /** Whether the s3 client should use path style access. */
        key -> SecureSetting.secureString(key, null)
            newCredentials = loadDeprecatedCredentials(repositorySettings);
                normalizedSettings,
        private final String identityTokenFile;
 * Licensed to Elasticsearch under one or more contributor
        key -> new Setting<>(key, "https", s -> Protocol.valueOf(s.toUpperCase(Locale.ROOT)), Property.NodeScope)
    /** Parse settings for a single client. */
                    + S3Repository.SECRET_KEY_SETTING.getKey()
            SecureString key = S3Repository.ACCESS_KEY_SETTING.get(repositorySettings);
import org.opensearch.common.settings.SecureSetting;
        String identityTokenFile = getConfigValue(settings, clientName, IDENTITY_TOKEN_FILE_SETTING);
        if (proxyType != ProxySettings.ProxyType.DIRECT && Strings.isEmpty(proxyHost)) {
        final S3ClientSettings that = (S3ClientSettings) o;
        key -> new Setting<>(key, "", s -> s.toLowerCase(Locale.ROOT), Property.NodeScope)
    ) {
            && apiCallTimeoutMillis == that.apiCallTimeoutMillis
    final int connectionTTLMillis;
            newProtocol,
 * You may obtain a copy of the License at
            newCredentials,
            && newMaxConnections == maxConnections
            && protocol == that.protocol
            }
        if (proxyType == ProxySettings.ProxyType.DIRECT) {
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
            maxRetries,
        key -> new Setting<>(key, "", Function.identity(), Property.NodeScope)
     */
        } else if (S3Repository.SECRET_KEY_SETTING.exists(repositorySettings)) {
    static S3ClientSettings getClientSettings(final Settings settings, final String clientName, final Path configPath) {
    /** The access key (ie login id) for connecting to s3. */
        final int newMaxConnections = Math.toIntExact(getRepoSettingOrDefault(MAX_CONNECTIONS_SETTING, normalizedSettings, maxConnections));
    final ProxySettings proxySettings;
        PREFIX,
    }
        key -> Setting.boolSetting(key, true, Property.NodeScope)
    /** Signer override to use or empty string to use default. */
import org.opensearch.common.logging.DeprecationLogger;
     * @return S3ClientSettings
                    + PROXY_TYPE_SETTING.getConcreteSettingForNamespace(clientName).getKey()
     */
    /** The request timeout for the s3 client */
                    if (sessionToken.length() != 0) {
        String signerOverride,
    final boolean throttleRetries;
        String region,
        final boolean newDisableChunkedEncoding = getRepoSettingOrDefault(
            return roleArn;
            && proxySettings.equals(that.proxySettings)
    }
        if (awsProtocol != Protocol.HTTPS && proxyType == ProxySettings.ProxyType.DIRECT && Strings.hasText(proxyHost)) {
    private static <T> T getRepoSettingOrDefault(Setting.AffixSetting<T> setting, Settings normalizedSettings, T defaultValue) {
        "endpoint",
            return true;
        } else {
    private S3ClientSettings(
            // This is backward compatibility for the current behaviour.
            return false;
        }
        }
            SecureString secret = S3Repository.SECRET_KEY_SETTING.get(repositorySettings)
    /** The timeout for an entire S3 API call, including retries. Zero leaves the SDK timeout unset. */
    );
            && Objects.equals(signerOverride, newSignerOverride)
            && protocol == newProtocol
    /** The max number of connections for the s3 async client */
 * compatible open source license.
import org.opensearch.common.settings.Setting;
        this.maxConnections = maxConnections;
        "api_call_timeout",
        PREFIX,
/*
    /** The protocol to use to talk to s3. Defaults to https. */
            Math.toIntExact(getConfigValue(settings, clientName, API_CALL_TIMEOUT_SETTING).millis()),
            final IrsaCredentials that = (IrsaCredentials) o;
                    throw new IllegalArgumentException("Missing secret key for s3 client [" + clientName + "]");
        return Collections.unmodifiableMap(clients);
            }
                    + "]"
    static void validateInetAddressFor(final String proxyHost) {
        this.disableChunkedEncoding = disableChunkedEncoding;
        "max_connections",
    static final Setting.AffixSetting<ProxySettings.ProxyType> PROXY_TYPE_SETTING = Setting.affixKeySetting(
/**
        "role_arn",
    /**
        }
        }
        final int newApiCallTimeoutMillis = Math.toIntExact(
    );
        if (S3Repository.ACCESS_KEY_SETTING.exists(repositorySettings)) {
    static final Setting.AffixSetting<SecureString> PROXY_PASSWORD_SETTING = Setting.affixKeySetting(
            return true;
        final Settings normalizedSettings = Settings.builder()
            && Objects.equals(signerOverride, that.signerOverride)
 * SPDX-License-Identifier: Apache-2.0
        ) {
    );
    static final Setting.AffixSetting<SecureString> ROLE_SESSION_NAME_SETTING = Setting.affixKeySetting(
            newConnectionTimeoutMillis,
            signerOverride
            }
        if (proxyType == ProxySettings.ProxyType.DIRECT
        }
            clients.put(clientName, getClientSettings(settings, clientName, configPath));
            getConfigValue(settings, clientName, REGION),
            proxyType = ProxySettings.ProxyType.valueOf(awsProtocol.name());
        );
                }
        PREFIX,
        return defaultValue;
    );
            newCredentials = credentials;
        public int hashCode() {
                    + S3Repository.ACCESS_KEY_SETTING.getKey()
                    "Repository setting ["
        "proxy.password",
            && connectionTTLMillis == that.connectionTTLMillis
            && Objects.equals(proxySettings.getHostName(), newProxyHost)
    );
            connectionTTLMillis,
                "Repository setting ["
    /** An override for the s3 endpoint to connect to. */
        final String proxyHost = getConfigValue(settings, clientName, PROXY_HOST_SETTING);
import java.net.InetAddress;
        key -> new Setting<>(key, "direct", s -> ProxySettings.ProxyType.valueOf(s.toUpperCase(Locale.ROOT)), Property.NodeScope)
        PREFIX,
            getRepoSettingOrDefault(
        final String newSignerOverride = getRepoSettingOrDefault(SIGNER_OVERRIDE, normalizedSettings, signerOverride);
            newMaxRetries,
            getRepoSettingOrDefault(API_CALL_TIMEOUT_SETTING, normalizedSettings, TimeValue.timeValueMillis(apiCallTimeoutMillis)).millis()
        key -> Setting.timeSetting(key, TimeValue.ZERO, TimeValue.ZERO, Property.NodeScope)
        boolean legacyMd5ChecksumCalculation
        PREFIX,
 * ownership. Elasticsearch licenses this file to you under
        PREFIX,
        final int newConnectionAcquisitionTimeoutMillis = Math.toIntExact(
        public String getRoleArn() {
 * The OpenSearch Contributors require contributions made to
        public String getIdentityTokenFile() {
        assert checkDeprecatedCredentials(repositorySettings);
    /** The identity token file for connecting to s3. */
        private final String roleArn;
    );
import org.opensearch.common.unit.TimeValue;
            getConfigValue(settings, clientName, LEGACY_MD5_CHECKSUM_CALCULATION)
        key -> Setting.intSetting(key, 3, 0, Property.NodeScope)
    }
import java.nio.file.Path;
        return new S3ClientSettings(
    }
        "session_token",
        "request_timeout",
        );
            if (o == null || getClass() != o.getClass()) {
    static final Setting.AffixSetting<TimeValue> READ_TIMEOUT_SETTING = Setting.affixKeySetting(
    static final Setting.AffixSetting<String> SIGNER_OVERRIDE = Setting.affixKeySetting(
        final String newEndpoint = getRepoSettingOrDefault(ENDPOINT_SETTING, normalizedSettings, endpoint);
    );
            // when proxy host and port have been set
        final Set<String> clientNames = settings.getGroups(PREFIX).keySet();
        key -> SecureSetting.simpleString(key, Property.NodeScope)
    );
        "access_key",
    @SuppressForbidden(reason = "PathUtils#get")
                    throw new IllegalArgumentException("Missing access key for s3 client [" + clientName + "]");
    /** The maximum connections to s3. */
    /** The connection TTL for connecting to s3. */
        PREFIX,
    );
        PREFIX,
        "disable_chunked_encoding",
    /** The secret key (ie password) for connecting to s3. */
    /** The secret key (ie password) for connecting to s3. */
            Math.toIntExact(getConfigValue(settings, clientName, CONNECTION_TTL_SETTING).millis()),
    /** The port of a proxy to connect to s3 through. */
        key -> Setting.simpleString(key, Property.NodeScope)
            newConnectionTTLMillis,
            && Objects.equals(credentials, that.credentials)
            );
        this.connectionTimeoutMillis = connectionTimeoutMillis;
            && proxySettings.getPort() == newProxyPort
    );
    static final Setting.AffixSetting<Boolean> USE_PATH_STYLE_ACCESS = Setting.affixKeySetting(
    );
        try (
    }
    );
    /** Whether the s3 client should use path style access. */
        this.region = region;
    static final Setting.AffixSetting<SecureString> ACCESS_KEY_SETTING = Setting.affixKeySetting(
        "signer_override",
import org.opensearch.core.common.settings.SecureString;
                return false;
            // The expectation of ex-developers that protocol is the same as the proxy protocol
 *
     * @param repositorySettings found in repository metadata
            SecureString accessKey = getConfigValue(settings, clientName, ACCESS_KEY_SETTING);
        "proxy.username",
        try (
        PREFIX,
                .millis()
    /** The max number of connections for the s3 sync client */
    /** An optional proxy settings that requests to s3 should be made through. */
        );
        "protocol",
}
            getConfigValue(settings, clientName, DISABLE_CHUNKED_ENCODING),
        final int newRequestTimeoutMillis = Math.toIntExact(
            getRepoSettingOrDefault(CONNECTION_TTL_SETTING, normalizedSettings, TimeValue.timeValueMillis(connectionTTLMillis)).millis()
            getRepoSettingOrDefault(CONNECTION_TIMEOUT_SETTING, normalizedSettings, TimeValue.timeValueMillis(connectionTimeoutMillis))
            legacyMd5ChecksumCalculation
                } else {
        PREFIX,
    }
            && newApiCallTimeoutMillis == apiCallTimeoutMillis
        PREFIX,
import org.opensearch.repositories.s3.utils.Protocol;
            return identityTokenFile;
                && Objects.equals(roleSessionName, that.roleSessionName);
        key -> Setting.timeSetting(key, TimeValue.timeValueSeconds(10), Property.NodeScope)
            getConfigValue(settings, clientName, ENDPOINT_SETTING),
            && Objects.equals(region, that.region)
import org.opensearch.common.io.PathUtils;
        }
            getConfigValue(settings, clientName, SIGNER_OVERRIDE),
    static final Setting.AffixSetting<Integer> MAX_RETRIES_SETTING = Setting.affixKeySetting(
        final int newReadTimeoutMillis = Math.toIntExact(
        if (setting.getConcreteSettingForNamespace(PLACEHOLDER_CLIENT).exists(normalizedSettings)) {
    );
 * license agreements. See the NOTICE file distributed with
            getConfigValue(settings, clientName, MAX_RETRIES_SETTING),
        int maxRetries,
        key -> Setting.intSetting(key, 500, Property.NodeScope)
            && connectionAcquisitionTimeoutMillis == that.connectionAcquisitionTimeoutMillis
                    throw new IllegalArgumentException("Missing access key and secret key for s3 client [" + clientName + "]");
    }
        );
    /** The password of a proxy to connect to s3 through. */
    private static AwsCredentials loadDeprecatedCredentials(Settings repositorySettings) {
        }
        // Validate proxy settings
        }
 * the Apache License, Version 2.0 (the "License"); you may
        "role_session_name",
        if (this == o) {
                    } else {
            Math.toIntExact(getConfigValue(settings, clientName, CONNECTION_ACQUISITION_TIMEOUT).millis()),
    static Map<String, S3ClientSettings> load(final Settings settings, final Path configPath) {
            throw new IllegalArgumentException(
        }
        @Override
    final Protocol protocol;
        PREFIX,
    // prefix for s3 client settings
    final String endpoint;
    final boolean disableChunkedEncoding;
            proxySettings.recreateWithNewHostAndPort(newProxyHost, newProxyPort),
        "identity_token_file",
        this.legacyMd5ChecksumCalculation = legacyMd5ChecksumCalculation;
            .build();
package org.opensearch.repositories.s3;
import java.util.HashMap;
        int connectionTimeoutMillis,
    static final Setting.AffixSetting<SecureString> SECRET_KEY_SETTING = Setting.affixKeySetting(
            apiCallTimeoutMillis,
 * specific language governing permissions and limitations
        }
        PREFIX,
    /** Whether to use the legacy MD5 checksum calculation when uploading files to S3. */
            if (S3Repository.SECRET_KEY_SETTING.exists(repositorySettings) == false) {
    );
    static final Setting.AffixSetting<Integer> PROXY_PORT_SETTING = Setting.affixKeySetting(
        PREFIX,
        "max_retries",
    static final Setting.AffixSetting<String> REGION = Setting.affixKeySetting(
     *
            && newConnectionTTLMillis == connectionTTLMillis
        return new ProxySettings(proxyType, proxyHost, proxyPort, proxyUserName.toString(), proxyPassword.toString());
 * under the License.
    static final Setting.AffixSetting<Integer> MAX_PENDING_CONNECTION_ACQUIRES = Setting.affixKeySetting(
            SecureString roleArn = getConfigValue(settings, clientName, ROLE_ARN_SETTING);
import org.opensearch.common.settings.SettingsException;
 * not use this file except in compliance with the License.
    static class IrsaCredentials {
    final IrsaCredentials irsaCredentials;
                identityTokenFile = PathUtils.get(new Path[] { configPath }, identityTokenFile).toString();
        int maxSyncConnections,
    /** The protocol to use to connect to s3. */
        if (awsProtocol == Protocol.HTTP && proxyType == ProxySettings.ProxyType.SOCKS) {
        );
     */
        final AwsCredentials newCredentials;
        this.proxySettings = proxySettings;
    );
        }
    /** The s3 endpoint the client should talk to, or empty string to use the default. */
            && throttleRetries == that.throttleRetries
    static final Setting.AffixSetting<Boolean> DISABLE_CHUNKED_ENCODING = Setting.affixKeySetting(
            } else {
    /** The username of a proxy to connect to s3 through. */
            LEGACY_MD5_CHECKSUM_CALCULATION,
            readTimeoutMillis,
        }
            return null;
    /** Credentials to authenticate with s3 using IAM Roles for Service Accounts (IRSA). */
            throttleRetries,
 *    http://www.apache.org/licenses/LICENSE-2.0
            return this;
        PREFIX,
        }
        key -> Setting.timeSetting(key, TimeValue.timeValueMillis(50_000), Property.NodeScope)
        }
            && newConnectionTimeoutMillis == connectionTimeoutMillis
    }
    /** Whether chunked encoding should be disabled or not (Default is false). */
     * Overrides the settings in this instance with settings found in repository metadata.
    private static final String PREFIX = "s3.client.";
            && newPathStyleAccess == pathStyleAccess
        validateInetAddressFor(newProxyHost);
            normalizedSettings,
    static ProxySettings validateAndCreateProxySettings(final Settings settings, final String clientName, final Protocol awsProtocol) {
        this.pathStyleAccess = pathStyleAccess;
    );
            return AwsBasicCredentials.create(key.toString(), secret.toString());
                );
            throw new SettingsException("S3 proxy type has been set but proxy host or port is not defined.");
    );
        Protocol protocol,
import org.opensearch.core.common.Strings;
            && Objects.equals(md5ChecksumCalculation, this.legacyMd5ChecksumCalculation)) {
            && Objects.equals(endpoint, that.endpoint)
    public boolean equals(final Object o) {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(S3ClientSettings.class);
        key -> SecureSetting.secureString(key, null)
        final boolean md5ChecksumCalculation = getRepoSettingOrDefault(
            && newConnectionAcquisitionTimeoutMillis == connectionAcquisitionTimeoutMillis
        PREFIX,
        validateInetAddressFor(proxyHost);
        );
            final Path identityTokenFilePath = PathUtils.get(identityTokenFile);
                        + " must be accompanied by setting ["
    }
    /** Whether the s3 client should use an exponential backoff retry policy. */
    final int readTimeoutMillis;
    /** The connection TTL for the s3 client */
    private static IrsaCredentials loadIrsaCredentials(Settings settings, String clientName, Path configPath) {
    static final Setting.AffixSetting<TimeValue> CONNECTION_ACQUISITION_TIMEOUT = Setting.affixKeySetting(
        key -> Setting.boolSetting(key, false, Property.NodeScope)
            newMaxConnections,
 *
        @Override
        IrsaCredentials irsaCredentials,
            getRepoSettingOrDefault(READ_TIMEOUT_SETTING, normalizedSettings, TimeValue.timeValueMillis(readTimeoutMillis)).millis()
    static final Setting.AffixSetting<SecureString> ROLE_ARN_SETTING = Setting.affixKeySetting(
                    }
        PREFIX,
        );
    /** The protocol to use to connect to s3. */
    static final Setting.AffixSetting<Boolean> USE_THROTTLE_RETRIES_SETTING = Setting.affixKeySetting(
import java.util.Set;
    private static <T> T getConfigValue(Settings settings, String clientName, Setting.AffixSetting<T> clientSetting) {
        "max_sync_connections",
        );
        }
        "max_pending_connection_acquires",
        final Protocol awsProtocol = getConfigValue(settings, clientName, PROTOCOL_SETTING);
            newConnectionAcquisitionTimeoutMillis,
    );
    }
     * <p>
    /** The maximum pending connections to S3. */
    /** Whether chunked encoding should be disabled or not. */
        AwsCredentials credentials,
    /** The connection timeout for connecting to s3. */
            if (this == o) {
            this.identityTokenFile = Strings.isNullOrEmpty(identityTokenFile) ? null : identityTokenFile;
 */
        int connectionTTLMillis,
                && Objects.equals(roleArn, that.roleArn)
                    + " must be accompanied by setting ["
            S3ClientSettings.loadIrsaCredentials(settings, clientName, configPath),
    S3ClientSettings refine(Settings repositorySettings) {
        PREFIX,
    );
        final int newConnectionTimeoutMillis = Math.toIntExact(
        }
     * Load all client settings from the given settings.
 *
            if (accessKey.length() != 0) {
 * software distributed under the License is distributed on an
        return readTimeoutMillis == that.readTimeoutMillis
    /** An override for the signer to use. */
            newRequestTimeoutMillis,
        final SecureString proxyPassword = getConfigValue(settings, clientName, PROXY_PASSWORD_SETTING);
    /** The socket timeout for connecting to s3. */
            newApiCallTimeoutMillis,
    static final Setting.AffixSetting<TimeValue> REQUEST_TIMEOUT_SETTING = Setting.affixKeySetting(
        final int newConnectionTTLMillis = Math.toIntExact(
    final int maxConnections;
                PROTOCOL_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
                        + S3Repository.SECRET_KEY_SETTING.getKey()
        final SecureString proxyUserName = getConfigValue(settings, clientName, PROXY_USERNAME_SETTING);
                if (secretKey.length() != 0) {
            return ProxySettings.NO_PROXY_SETTINGS;
        try {
            if (!identityTokenFilePath.isAbsolute()) {
            // In this case, proxy type should be the same as a protocol,
        }
                }
            && newDisableChunkedEncoding == disableChunkedEncoding
            md5ChecksumCalculation
            Math.toIntExact(getConfigValue(settings, clientName, REQUEST_TIMEOUT_SETTING).millis()),
        final int proxyPort = getConfigValue(settings, clientName, PROXY_PORT_SETTING);
    static final Setting.AffixSetting<SecureString> SESSION_TOKEN_SETTING = Setting.affixKeySetting(
        for (final String clientName : clientNames) {
            awsProtocol,
        key -> SecureSetting.secureString(key, null)
            && Objects.equals(irsaCredentials, that.irsaCredentials);
    // Properties to support using IAM Roles for Service Accounts (IRSA)
    /** Connection acquisition timeout for new connections to S3. */
        ProxySettings proxySettings,
    /** The number of retries to use for the s3 client. */
        key -> SecureSetting.secureString(key, null)
        boolean pathStyleAccess,
            && newThrottleRetries == throttleRetries
                TimeValue.timeValueMillis(connectionAcquisitionTimeoutMillis)
        return concreteSetting.get(settings);
            // but it will pull all the fallback static settings
        "connection_acquisition_timeout",
            && Objects.equals(region, newRegion)
        final Map<String, S3ClientSettings> clients = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
            if (identityTokenFile.length() != 0 || roleArn.length() != 0 || roleSessionName.length() != 0) {
        PREFIX,
        this.requestTimeoutMillis = requestTimeoutMillis;
            getConfigValue(settings, clientName, USE_THROTTLE_RETRIES_SETTING),
    final int maxSyncConnections;
        final int newProxyPort = getRepoSettingOrDefault(PROXY_PORT_SETTING, normalizedSettings, proxySettings.getPort());
            region,
import org.opensearch.common.settings.Setting.Property;
/*
 * GitHub history for details.
    /** The read timeout for the s3 client. */
    /**
        key -> SecureSetting.secureString(key, null)
        "read_timeout",
    );
        final String newProxyHost = getRepoSettingOrDefault(PROXY_HOST_SETTING, normalizedSettings, proxySettings.getHostName());
        key -> Setting.intSetting(key, 10_000, Property.NodeScope)
        this.connectionTTLMillis = connectionTTLMillis;
                if (secretKey.length() != 0) {
    /** The role session name for connecting to s3. */
import software.amazon.awssdk.auth.credentials.AwsCredentials;
    @Override
    /** The connnection acquisition timeout for the s3 sync and async client */
        this.credentials = credentials;
            Math.toIntExact(getConfigValue(settings, clientName, CONNECTION_TIMEOUT_SETTING).millis()),
        "proxy.type",
        key -> Setting.boolSetting(key, false, Property.NodeScope)
    /** Placeholder client name for normalizing client settings in the repository settings. */
    final int connectionAcquisitionTimeoutMillis;
        if (identityTokenFile.length() != 0) {
        boolean throttleRetries,
    final int maxRetries;
        ) {
            // this won't find any settings under the default client,
                "Using of "
            }
            maxConnections,
        PREFIX,
    public int hashCode() {
    /** Whether retries should be throttled (ie use backoff). */
                    + " as proxy type is deprecated and will be removed in future releases. Please use "
            }
    }
        this.irsaCredentials = irsaCredentials;
        key -> Setting.timeSetting(key, TimeValue.timeValueMillis(5000), Property.NodeScope)
    );
        private final String roleSessionName;
            && maxRetries == newMaxRetries
        int readTimeoutMillis,
            requestTimeoutMillis,
                CONNECTION_ACQUISITION_TIMEOUT,
        String endpoint,
 */
            disableChunkedEncoding
        final int newMaxSyncConnections = Math.toIntExact(
            credentials,
    // pkg private for tests
                    + " instead to specify proxy type."
    /** The request timeout for connecting to s3. */
        if (Objects.equals(endpoint, newEndpoint)
            ).millis()
    static boolean checkDeprecatedCredentials(Settings repositorySettings) {
            return Objects.equals(identityTokenFile, that.identityTokenFile)
        PREFIX,
        key -> Setting.timeSetting(key, TimeValue.timeValueMinutes(5), Property.NodeScope)
                }
 * KIND, either express or implied.  See the License for the
        ) {
                return new IrsaCredentials(identityTokenFile.toString(), roleArn.toString(), roleSessionName.toString());
import java.net.UnknownHostException;
            return getConfigValue(normalizedSettings, PLACEHOLDER_CLIENT, setting);
            normalizedSettings,
        key -> SecureSetting.secureString(key, null)
            SecureString roleSessionName = getConfigValue(settings, clientName, ROLE_SESSION_NAME_SETTING)
        // Normalize settings to placeholder client settings prefix so that we can use the affix settings directly
        "proxy.host",
    /** The connection timeout for the s3 client */
            SecureString sessionToken = getConfigValue(settings, clientName, SESSION_TOKEN_SETTING)
     * Class to store IAM Roles for Service Accounts (IRSA) credentials
        this.apiCallTimeoutMillis = apiCallTimeoutMillis;
        }
        public boolean equals(final Object o) {
        final boolean newThrottleRetries = getRepoSettingOrDefault(USE_THROTTLE_RETRIES_SETTING, normalizedSettings, throttleRetries);
        PREFIX,
        }
    final AwsCredentials credentials;
    @Override
    static final Setting.AffixSetting<Integer> MAX_CONNECTIONS_SETTING = Setting.affixKeySetting(
        final boolean newPathStyleAccess = getRepoSettingOrDefault(USE_PATH_STYLE_ACCESS, normalizedSettings, pathStyleAccess);
    );
        final Protocol newProtocol = getRepoSettingOrDefault(PROTOCOL_SETTING, normalizedSettings, protocol);
    final String signerOverride;
                if (sessionToken.length() != 0) {
        }
            && maxConnections == that.maxConnections
import java.util.Collections;
 * this file be licensed under the Apache-2.0 license or a
        "legacy_md5_checksum_calculation",
            throw new SettingsException("S3 proxy host is unknown.", e);
            return Objects.hash(identityTokenFile, roleArn, roleSessionName);
        key -> Setting.intSetting(key, 500, Property.NodeScope)
        return Objects.hash(
 * A container for settings used to create an S3 client.
        "path_style_access",
    /** The role ARN (Amazon Resource Name) for connecting to s3. */
    }
    );
            Math.toIntExact(getConfigValue(settings, clientName, MAX_CONNECTIONS_SETTING)),
    // backcompat for reading keys out of repository settings (clusterState)
    /** Region to use for signing requests or empty string to use default. */
            Math.toIntExact(getConfigValue(settings, clientName, MAX_SYNC_CONNECTIONS_SETTING)),
    final boolean pathStyleAccess;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
            && newRequestTimeoutMillis == requestTimeoutMillis
            getConfigValue(settings, clientName, USE_PATH_STYLE_ACCESS),
        PREFIX,
import java.util.Map;
            newEndpoint,
            // The default value for Protocol settings is HTTPS,
    /** The host name of a proxy to connect to s3 through. */
    final int requestTimeoutMillis;
 */
    final int apiCallTimeoutMillis;
