        } catch (Exception e) {
        this.defaultKeyConfig = defaultKeyConfig;
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
    }
     */
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_LEGACY_PASSWORD;
    }
    private SslClientAuthenticationMode defaultClientAuth;
            return new PemKeyConfig(certificatePath, keyPath, password);
}
 *
        if (has256BitAES) {
            throw new SslConfigException("cannot retrieve secure setting [" + settingPrefix + key + "]", e);
            ciphers.add("TLS_AES_256_GCM_SHA384");
 * The constructed {@code SslConfiguration} has sensible defaults for any settings that are not explicitly configured,
                Arrays.asList(
    }
            if (legacyPassword != null) {
     */
    public void setDefaultTrustConfig(SslTrustConfig defaultTrustConfig) {
     *
    }
     * Change the default verification mode.
    private List<String> defaultCiphers;
     * @throws Exception If a {@link RuntimeException} is thrown, it will be rethrown unwrapped. All checked exceptions are wrapped in
            final List<String> list = getSettingAsList(settingPrefix + key);
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
                )
            return parser.apply(setting);
 * Unless required by applicable law or agreed to in writing,
                TRUSTSTORE_TYPE,
import static org.opensearch.common.ssl.SslConfigurationKeys.KEY_LEGACY_PASSPHRASE;
 *
    public void setDefaultCiphers(List<String> defaultCiphers) {
import static org.opensearch.common.ssl.SslConfigurationKeys.CERTIFICATE;
        final SslTrustConfig trustConfig = buildTrustConfig(basePath, verificationMode);
        if (certificateAuthorities != null) {
     * Clients of this class should implement this method to load a fully-qualified key from the preferred settings source.
     */
    }
            }
                );
        // hardware support
        }
                throw new SslConfigException(
        this.defaultCiphers = DEFAULT_CIPHERS;
                KEYSTORE_TYPE,
     * The initial verification mode is {@link SslVerificationMode#FULL}.
                "cannot specify both [" + settingPrefix + CERTIFICATE + "] and [" + settingPrefix + KEYSTORE_PATH + "]"
            throw new SslConfigException("no protocols configured in [" + settingPrefix + PROTOCOLS + "]");
        } catch (NoSuchAlgorithmException e) {
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                    "TLS_RSA_WITH_AES_256_CBC_SHA",
                return legacyPassword.toCharArray();
                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"
     * Clients of this class should implement this method to load a fully-qualified key from the preferred settings source.
        }
     *
 * the Apache License, Version 2.0 (the "License"); you may
                    "TLS_RSA_WITH_AES_128_CBC_SHA256",
            }
                Function.identity(),
                return defaultValue;
    private SslTrustConfig buildTrustConfig(Path basePath, SslVerificationMode verificationMode) {
            } else {
            throw e;
                )
     * {@link SslConfigurationKeys#getSecureStringKeys() secure} settings.
            ciphers.addAll(
    public void setDefaultVerificationMode(SslVerificationMode defaultVerificationMode) {
            }
        if (verificationMode.isCertificateVerificationEnabled() == false) {
    private SslKeyConfig buildKeyConfig(Path basePath) {
            return false;
        } else {
            return new PemTrustConfig(certificateAuthorities);
 * GitHub history for details.
 * It is {@code abstract} because this library has minimal dependencies, so the extraction of the setting values from
import static org.opensearch.common.ssl.SslConfigurationKeys.CLIENT_AUTH;
     * @param settingPrefix The prefix to apply to all settings that are loaded. It may be the empty string, otherwise it
    /**
                );
 * @see SslConfiguration
    }
        } else {
    protected abstract String getSettingAsString(String key) throws Exception;
        this.settingPrefix = settingPrefix == null ? "" : settingPrefix;
import static org.opensearch.common.ssl.SslConfigurationKeys.CERTIFICATE_AUTHORITIES;
                inferStoreType(keyStorePath.toString().toLowerCase(Locale.ROOT))
     */
import static org.opensearch.common.ssl.SslConfigurationKeys.TRUSTSTORE_SECURE_PASSWORD;
/*
    private char[] resolvePasswordSetting(String secureSettingKey, String legacySettingKey) {
     * The initial cipher list depends on the availability of {@link #has256BitAES() 256 bit AES}.
            if (keyPath == null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Path certificatePath = resolveSetting(CERTIFICATE, basePath::resolve, null);
 * this file be licensed under the Apache-2.0 license or a
                throw new SslConfigException(
        // use GCM: AEAD, hardware support
        if (certificatePath != null || keyPath != null) {
    private SslVerificationMode defaultVerificationMode;
            String setting = getSettingAsString(settingPrefix + key);
    private List<String> defaultProtocols;
import java.util.Locale;
import java.security.NoSuchAlgorithmException;
     */
    private <V> List<V> resolveListSetting(String key, Function<String, V> parser, List<V> defaultValue) {
 *
            // No AES? Things are going to be very weird, but technically that means we don't have 256 bit AES, so ...
                    "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
import java.util.List;
        final List<Path> certificateAuthorities = resolveListSetting(CERTIFICATE_AUTHORITIES, basePath::resolve, null);
    }
import static org.opensearch.common.ssl.SslConfigurationKeys.TRUSTSTORE_PATH;
        this.defaultVerificationMode = SslVerificationMode.FULL;
            ciphers.addAll(
        this.defaultClientAuth = SslClientAuthenticationMode.OPTIONAL;
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_LEGACY_KEY_PASSWORD;
                return securePassword;
        if (certificatePath != null && keyStorePath != null) {
            char[] setting = getSecureSetting(settingPrefix + key);
        } catch (RuntimeException e) {
            throw new SslConfigException("cannot retrieve setting [" + settingPrefix + key + "]", e);
    protected abstract List<String> getSettingAsList(String key) throws Exception;
            throw new SslConfigException("cannot retrieve setting [" + settingPrefix + key + "]", e);
        }
        final Path keyPath = resolveSetting(KEY, basePath::resolve, null);
        } catch (RuntimeException e) {
     *
        final List<String> ciphers = resolveListSetting(CIPHERS, Function.identity(), defaultCiphers);
     */
                return defaultValue;
            );
 */
     * @see #loadDefaultCiphers()
        this.defaultClientAuth = defaultClientAuth;
        List<String> ciphers = new ArrayList<>();
    static final List<String> DEFAULT_PROTOCOLS = KeyStoreUtil.IN_FIPS_MODE
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA"
            );
            if (list == null || list.isEmpty()) {
     */
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_SECURE_KEY_PASSWORD;
            return setting;
import static org.opensearch.common.ssl.KeyStoreUtil.inferStoreType;
            ciphers.addAll(
import java.util.stream.Collectors;
                Function.identity(),
     * The initial trust config is {@link DefaultJdkTrustConfig}, which trusts the JDK's default CA certs
    /**
 * You may obtain a copy of the License at
            if (setting == null || setting.isEmpty()) {
        }
        if (keyStorePath != null) {
    static final List<String> FIPS_APPROVED_PROTOCOLS = List.of("TLSv1.3", "TLSv1.2");
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384",
import java.util.ArrayList;
            final char[] storePassword = resolvePasswordSetting(KEYSTORE_SECURE_PASSWORD, KEYSTORE_LEGACY_PASSWORD);
import javax.net.ssl.KeyManagerFactory;
        this.defaultVerificationMode = defaultVerificationMode;
            }
package org.opensearch.common.ssl;
                return defaultValue;
     *                   {@link SslConfigException} before being rethrown.
import static org.opensearch.common.ssl.SslConfigurationKeys.PROTOCOLS;
            }
     * Change the default key config.
        }
        }
            );
        if (has256BitAES) {
        final SslClientAuthenticationMode clientAuth = resolveSetting(CLIENT_AUTH, SslClientAuthenticationMode::parse, defaultClientAuth);
            final char[] password = resolvePasswordSetting(KEY_SECURE_PASSPHRASE, KEY_LEGACY_PASSPHRASE);
        return new SslConfiguration(trustConfig, keyConfig, verificationMode, clientAuth, ciphers, protocols);
    /**
        return ciphers;
     * The initial protocol list is defined by {@link #DEFAULT_PROTOCOLS}
        final SslVerificationMode verificationMode = resolveSetting(VERIFICATION_MODE, SslVerificationMode::parse, defaultVerificationMode);
import static org.opensearch.common.ssl.SslConfigurationKeys.CIPHERS;
 * under the License.
     *                      {@code "reindex.ssl.verification_mode"}, and those same keys will be reported in error messages (via
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA"
            }
                    "TLS_RSA_WITH_AES_128_CBC_SHA"
        } catch (Exception e) {
            final String storeType = resolveSetting(
        if (ciphers == null || ciphers.isEmpty()) {
     *                   {@link SslConfigException} before being rethrown.
        final SslKeyConfig keyConfig = buildKeyConfig(basePath);
        return defaultKeyConfig;
            return TrustEverythingConfig.TRUST_EVERYTHING;
    public void setDefaultKeyConfig(SslKeyConfig defaultKeyConfig) {
    }
/*
        }
     * The setting should be returned as a string, and this class will convert it to the relevant type.
 * the underlying setting source must be handled by the code that makes use of this class.
     * This method will be called for list settings (see {@link SslConfigurationKeys#getListKeys()}).
 * compatible open source license.
        final boolean has256BitAES = has256BitAES();
import java.util.function.Function;
            throw new IllegalArgumentException("Setting prefix [" + settingPrefix + "] must be blank or end in '.'");
    }
        try {
        try {
    protected abstract char[] getSecureSetting(String key) throws Exception;
 *
            );
        if (certificateAuthorities != null && trustStorePath != null) {
                    "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
import static org.opensearch.common.ssl.SslConfigurationKeys.VERIFICATION_MODE;
 * this work for additional information regarding copyright
                );
     *                 configuration directory.
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
        ciphers.add("TLS_AES_128_GCM_SHA256");
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
    private <V> V resolveSetting(String key, Function<String, V> parser, V defaultValue) {
        }
    private SslKeyConfig defaultKeyConfig;
            final String algorithm = resolveSetting(TRUSTSTORE_ALGORITHM, Function.identity(), TrustManagerFactory.getDefaultAlgorithm());
    private final String settingPrefix;
 * Loads {@link SslConfiguration} from settings.
    public void setDefaultProtocols(List<String> defaultProtocols) {
            throw e;
     * @throws Exception If a {@link RuntimeException} is thrown, it will be rethrown unwrapped. All checked exceptions are wrapped in
 * and these defaults can be overridden through the various {@code setDefaultXyz} methods.
 * software distributed under the License is distributed on an
        }
    }
    public SslConfigurationLoader(String settingPrefix) {
            throw new SslConfigException(
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_SECURE_PASSWORD;
import java.util.Objects;
            ciphers.addAll(
    private char[] resolveSecureSetting(String key, char[] defaultValue) {
        }
            );
     */
        if (securePassword == null) {
        if (has256BitAES) {
        ? FIPS_APPROVED_PROTOCOLS
     * The initial key config is {@link EmptyKeyConfig}, which does not provide any keys
 */
    }
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
    private static List<String> loadDefaultCiphers() {
     *
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_ALGORITHM;
                keyPassword = storePassword;
            );
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
            return new StoreTrustConfig(trustStorePath, password, storeType, algorithm);
     * The initial client auth mode is {@link SslClientAuthenticationMode#OPTIONAL}.
    /**
import static org.opensearch.common.ssl.SslConfigurationKeys.TRUSTSTORE_ALGORITHM;
            } else {
            ciphers.addAll(Arrays.asList("TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_GCM_SHA256"));
        final char[] securePassword = resolveSecureSetting(secureSettingKey, null);
                    "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        final Path trustStorePath = resolveSetting(TRUSTSTORE_PATH, basePath::resolve, null);
            if (setting == null || setting.length == 0) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * This class handles the logic of interpreting the various "ssl.*" configuration settings and their interactions
        this.defaultCiphers = defaultCiphers;
     *                      passed to methods like {@link #getSettingAsString(String)} will be in the form
    /**
        this.defaultTrustConfig = new DefaultJdkTrustConfig();
        // PFS, hardware support
        this.defaultProtocols = defaultProtocols;
    }
import java.util.Arrays;
                return EMPTY_PASSWORD;
            return new StoreKeyConfig(keyStorePath, storePassword, storeType, keyPassword, algorithm);
        } catch (RuntimeException e) {
 */
            );
            }
        } else {
        }
     * This method will be called for basic string settings (see {@link SslConfigurationKeys#getStringKeys()}).
        }
        if (this.settingPrefix.isEmpty() == false && this.settingPrefix.endsWith(".") == false) {
        } catch (Exception e) {
 * KIND, either express or implied.  See the License for the
        this.defaultTrustConfig = defaultTrustConfig;
        if (has256BitAES) {
                )
            ciphers.add("TLS_RSA_WITH_AES_128_GCM_SHA256");
     *                      must end in a "." (period). For example, if the prefix is {@code "reindex.ssl."} then the keys that are
                Arrays.asList(
import static org.opensearch.common.ssl.SslConfigurationKeys.TRUSTSTORE_LEGACY_PASSWORD;
import javax.net.ssl.TrustManagerFactory;
     */
        Objects.requireNonNull(basePath, "Base Path cannot be null");
        final List<String> protocols = resolveListSetting(PROTOCOLS, Function.identity(), defaultProtocols);
        final Path keyStorePath = resolveSetting(KEYSTORE_PATH, basePath::resolve, null);
    }
     * <p>
        } else {
     * Change the default supported ciphers.
                inferStoreType(trustStorePath.toString().toLowerCase(Locale.ROOT))
        }
    /**
     * Change the default client authentication mode.
        if (has256BitAES) {
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_PATH;
            ciphers.addAll(Arrays.asList("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"));
            final String algorithm = resolveSetting(KEYSTORE_ALGORITHM, Function.identity(), KeyManagerFactory.getDefaultAlgorithm());
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
import static org.opensearch.common.ssl.SslConfigurationKeys.TRUSTSTORE_TYPE;
     * Change the default trust config.
 * license agreements. See the NOTICE file distributed with
 */
            return Cipher.getMaxAllowedKeyLength("AES") > 128;
     * @throws SslConfigException For any problems with the configuration, or with loading the required SSL classes.
        if (protocols == null || protocols.isEmpty()) {
                throw new SslConfigException(
            final String storeType = resolveSetting(
import static org.opensearch.common.ssl.SslConfigurationKeys.KEY_SECURE_PASSPHRASE;
    private static final char[] EMPTY_PASSWORD = new char[0];
                )
     *                   {@link SslConfigException} before being rethrown.
     *
 * (as well as being aware of dependencies and conflicts between different settings).
public abstract class SslConfigurationLoader {
    /**
/*
            if (certificatePath == null) {
        : List.of("TLSv1.3", "TLSv1.2", "TLSv1.1");
     * Construct a new loader with the "standard" default values.
    }
            }
     */
                "cannot specify both [" + settingPrefix + CERTIFICATE_AUTHORITIES + "] and [" + settingPrefix + TRUSTSTORE_PATH + "]"
    /**
                    "TLS_RSA_WITH_AES_256_CBC_SHA256",
                    "cannot specify [" + settingPrefix + CERTIFICATE + "] without also setting [" + settingPrefix + KEY + "]"
        }
     * <p>
    private static boolean has256BitAES() {
            return list.stream().map(parser).collect(Collectors.toList());
        if (trustStorePath != null) {
    private SslTrustConfig defaultTrustConfig;
 * Modifications Copyright OpenSearch Contributors. See
    /**
        }
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
            if (legacyPassword == null) {
            throw e;
    /**
        try {
import java.nio.file.Path;
                    "cannot specify both [" + settingPrefix + secureSettingKey + "] and [" + settingPrefix + legacySettingKey + "]"
 * not use this file except in compliance with the License.
import javax.crypto.Cipher;
/**
    }
            if (keyPassword.length == 0) {
    static final List<String> DEFAULT_CIPHERS = loadDefaultCiphers();
        this.defaultKeyConfig = EmptyKeyConfig.INSTANCE;
     * @param basePath The base path to use for any settings that represent file paths. Typically points to the OpenSearch
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_TYPE;
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
     * @throws Exception If a {@link RuntimeException} is thrown, it will be rethrown unwrapped. All checked exceptions are wrapped in
            throw new SslConfigException("no cipher suites configured in [" + settingPrefix + CIPHERS + "]");
                    "cannot specify [" + settingPrefix + KEYSTORE_PATH + "] without also setting [" + settingPrefix + CERTIFICATE + "]"
            );
 * Licensed to Elasticsearch under one or more contributor
        return defaultTrustConfig;
            throw new SslConfigException(
        } else {
import static org.opensearch.common.ssl.SslConfigurationKeys.KEY;
 * specific language governing permissions and limitations
            final char[] password = resolvePasswordSetting(TRUSTSTORE_SECURE_PASSWORD, TRUSTSTORE_LEGACY_PASSWORD);
            ciphers.addAll(Arrays.asList("TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA"));
     */
        }
            char[] keyPassword = resolvePasswordSetting(KEYSTORE_SECURE_KEY_PASSWORD, KEYSTORE_LEGACY_KEY_PASSWORD);
    }
     * Change the default SSL/TLS protocol list.
        }
        this.defaultProtocols = DEFAULT_PROTOCOLS;
        }
    public void setDefaultClientAuth(SslClientAuthenticationMode defaultClientAuth) {
     * Resolve all necessary configuration settings, and load a {@link SslConfiguration}.
        try {
     *                      {@link SslConfigException}).
     * Clients of this class should implement this method to load a fully-qualified key from the preferred secure settings source.
     *
     * The setting should be returned as a list of strings, and this class will convert the values to the relevant type.
 * ownership. Elasticsearch licenses this file to you under
                Arrays.asList(
 * @see SslConfigurationKeys
        final String legacyPassword = resolveSetting(legacySettingKey, Function.identity(), null);
    public SslConfiguration load(Path basePath) {
        }
     * This method will be called for any setting keys that are marked as being
    /**
                Arrays.asList(
        // use GCM: PFS, AEAD, hardware support
