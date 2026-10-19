        try (
            return setting.get(normalizedSettings);
    /** The read timeout for the kms client. */
        }
        );
    /** An optional password for the proxy host, for basic authentication. */
import software.amazon.awssdk.auth.credentials.AwsCredentials;
 * compatible open source license.
            try (SecureString proxyUsername = PROXY_USERNAME_SETTING.get(settings)) {
package org.opensearch.crypto.kms;
        final AwsCredentials credentials = loadCredentials(settings);
    final int proxyPort;
                final AwsCredentials credentials;
    /** An optional proxy host that requests to kms should be made through. */
}
    /** The host name of a proxy to connect to kms through. */
            newProxyUsername,
            newCredentials,
                        ACCESS_KEY_SETTING.getKey(),
    /** An override for the kms endpoint to connect to. */
            (int) newReadTimeout.millis()
 *
    }
    /** An optional username for the proxy host, for basic authentication. */
                    );
            && Objects.equals(credentials, that.credentials)
        AwsCredentials credentials,
    public int hashCode() {
import java.util.Objects;
    static final Setting<String> ENDPOINT_SETTING = new Setting<>("kms.endpoint", "", s -> s.toLowerCase(Locale.ROOT), Property.NodeScope);
import org.apache.logging.log4j.LogManager;
    static final Setting<Integer> PROXY_PORT_SETTING = Setting.intSetting("kms.proxy.port", 80, 0, 1 << 16, Property.NodeScope);
        String proxyUsername,
        this.readTimeoutMillis = readTimeoutMillis;
                        ACCESS_KEY_SETTING.getKey(),
                    throw new SettingsException(
    /** The port number the proxy host should be connected on. */
            SecureString proxyPassword = PROXY_PASSWORD_SETTING.get(settings)
        int readTimeoutMillis
        int proxyPort,
            newRegion,
            }
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
                proxyPassword.toString(),
     */
    /** The access key (ie login id) for connecting to kms. */
            newProxyPort,
    }
                return null;
    @Override
        if (o == null || getClass() != o.getClass()) {
    /** Credentials to authenticate with kms. */
    public boolean equals(final Object o) {
import org.opensearch.common.settings.Setting.Property;
    ) {
        newCredentials = newCredentials == null ? this.credentials : newCredentials;
        if (PROXY_PASSWORD_SETTING.exists(normalizedSettings)) {
        this.proxyPassword = proxyPassword;
    @Override
    final String proxyHost;
            && Objects.equals(proxyPort, that.proxyPort)
     * default.
        String proxyPassword,
    }
                    credentials = AwsBasicCredentials.create(key.toString(), secret.toString());
public class KmsClientSettings {
                        "Setting [{}] is set but [{}] and [{}] are not",
    }
                return credentials;
        this.proxyUsername = proxyUsername;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import org.opensearch.common.unit.TimeValue;
            && Objects.equals(proxyUsername, that.proxyUsername)
            );
                newProxyPassword = proxyPassword.toString();
/**
    static final Setting<String> PROXY_HOST_SETTING = Setting.simpleString("kms.proxy.host", Property.NodeScope);
    final String proxyUsername;
        }
    }
            return new KmsClientSettings(
                    throw new SettingsException(
            TimeValue.timeValueMillis(this.readTimeoutMillis)
                        ACCESS_KEY_SETTING.getKey(),
    protected KmsClientSettings(
            && Objects.equals(proxyHost, that.proxyHost)
                    logger.debug("Using basic session credentials");
        final KmsClientSettings that = (KmsClientSettings) o;
            try (SecureString proxyPassword = PROXY_PASSWORD_SETTING.get(settings)) {
    static final Setting<TimeValue> READ_TIMEOUT_SETTING = Setting.timeSetting(
    /** The socket timeout for connecting to kms. */
import org.opensearch.common.settings.Setting;
            SecureString secret = SECRET_KEY_SETTING.get(settings);
            newEndpoint,
 * A container for settings used to create an kms client.
    // storing them
    static final Setting<String> REGION_SETTING = new Setting<>("kms.region", "", s -> s.toLowerCase(Locale.ROOT), Property.NodeScope);
    static final Setting<SecureString> SESSION_TOKEN_SETTING = SecureSetting.secureString("kms.session_token", null);
            if (key.length() == 0 && secret.length() == 0) {
    private static <T> T getCryptoMetadataSettingOrExisting(Setting<T> setting, Settings normalizedSettings, T defaultValue) {
import org.opensearch.common.settings.SecureSetting;
            } else {
            SecureString sessionToken = SESSION_TOKEN_SETTING.get(settings)
                    );
            && Objects.equals(endpoint, that.endpoint)
                REGION_SETTING.get(settings),
        try (
        this.credentials = credentials;
                PROXY_PORT_SETTING.get(settings),
                }
        this.proxyHost = proxyHost;
        String endpoint,
    final String region;
        }
            }
            READ_TIMEOUT_SETTING,
    static KmsClientSettings getClientSettings(Settings settings) {
                if (sessionToken.length() > 0) {
                        SECRET_KEY_SETTING.getKey()
        String proxyHost,
    /** The session token for connecting to kms. */
                        SESSION_TOKEN_SETTING.getKey(),
    /** Parse settings for a single client. */
            && Objects.equals(proxyPassword, that.proxyPassword);
    static final Setting<SecureString> PROXY_PASSWORD_SETTING = SecureSetting.secureString("kms.proxy.password", null);
    // as SecureString here won't really help with anything
        String newProxyUsername = this.proxyUsername, newProxyPassword = this.proxyPassword;
    static final Setting<SecureString> ACCESS_KEY_SETTING = SecureSetting.secureString("kms.access_key", null);
                (int) READ_TIMEOUT_SETTING.get(settings).millis()
            newProxyHost,
                PROXY_HOST_SETTING.get(settings),
        String newProxyHost = getCryptoMetadataSettingOrExisting(PROXY_HOST_SETTING, normalizedSettings, this.proxyHost);
                if (secret.length() == 0) {
                }
                if (sessionToken.length() == 0) {
        ) {
        "kms.read_timeout",
    // these should be "secure" yet the api for the kms client only takes String, so
    static AwsCredentials loadCredentials(Settings settings) {
    /** An override for the scoping region for authentication. */
        this.proxyPort = proxyPort;
        if (PROXY_USERNAME_SETTING.exists(normalizedSettings)) {
                    );
        this.endpoint = endpoint;
        TimeValue.timeValueMillis(50_000),
        }
                    logger.debug("Using basic key/secret credentials");
                        SECRET_KEY_SETTING.getKey(),
        }
    static final Setting<SecureString> SECRET_KEY_SETTING = SecureSetting.secureString("kms.secret_key", null);
        int newProxyPort = getCryptoMetadataSettingOrExisting(PROXY_PORT_SETTING, normalizedSettings, this.proxyPort);
    }
import org.opensearch.common.settings.SettingsException;
            && Objects.equals(region, that.region)
        final Settings normalizedSettings = Settings.builder().put(settings).normalizePrefix("kms.").build();
            return false;
    KmsClientSettings getMetadataSettings(Settings settings) {
                ENDPOINT_SETTING.get(settings),
                        SECRET_KEY_SETTING.getKey()
                if (key.length() == 0) {
    final String proxyPassword;
        if (this == o) {
 * The OpenSearch Contributors require contributions made to
                credentials,
                newProxyUsername = proxyUsername.toString();
        return readTimeoutMillis == that.readTimeoutMillis
    final String endpoint;
            }
                } else {
                    throw new SettingsException(
     * The kms signing region.
        }
    }
                        "Setting [{}] is set but [{}] is not",
 * this file be licensed under the Apache-2.0 license or a
    final AwsCredentials credentials;
    /**
     * The kms endpoint the client should talk to, or empty string to use the
    /** The password of a proxy to connect to kms through. */
        this.region = region;
        if (setting.exists(normalizedSettings)) {
 */
    );
 */
        Property.NodeScope
        AwsCredentials newCredentials = loadCredentials(settings);
    final int readTimeoutMillis;
    /** The port of a proxy to connect to kms through. */
/*
            newProxyPassword,
        String newEndpoint = getCryptoMetadataSettingOrExisting(ENDPOINT_SETTING, normalizedSettings, this.endpoint);
    /** The secret key (ie password) for connecting to kms. */
                    credentials = AwsSessionCredentials.create(key.toString(), secret.toString(), sessionToken.toString());
            SecureString key = ACCESS_KEY_SETTING.get(settings);
                }
import java.util.Locale;
        TimeValue newReadTimeout = getCryptoMetadataSettingOrExisting(
                logger.debug("Using either environment variables, system properties or instance profile credentials");
    private static final Logger logger = LogManager.getLogger(KmsClientSettings.class);
 * SPDX-License-Identifier: Apache-2.0
        String region,
import org.opensearch.common.settings.Settings;
            return true;
            normalizedSettings,
                        SECRET_KEY_SETTING.getKey()
                }
    /**
        );
                proxyUsername.toString(),
        return Objects.hash(readTimeoutMillis, credentials, endpoint, region, proxyHost, proxyPort, proxyUsername, proxyPassword);
import org.apache.logging.log4j.Logger;
                        "Setting [{}] is set but [{}] is not",
            SecureString proxyUsername = PROXY_USERNAME_SETTING.get(settings);
        }
        String newRegion = getCryptoMetadataSettingOrExisting(REGION_SETTING, normalizedSettings, this.region);
        return new KmsClientSettings(
     */
    /** The username of a proxy to connect to kms through. */
        ) {
    static final Setting<SecureString> PROXY_USERNAME_SETTING = SecureSetting.secureString("kms.proxy.username", null);
import org.opensearch.core.common.settings.SecureString;
        return defaultValue;
