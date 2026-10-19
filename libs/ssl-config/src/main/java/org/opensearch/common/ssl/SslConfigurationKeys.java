     * The {@link KeyStore#getType() keystore type} for the file configured in {@link #TRUSTSTORE_PATH}.
 * Licensed to Elasticsearch under one or more contributor  
     */
    /**
     */
     * The SSL/TLS cipher suites that should be used
        return Arrays.asList(TRUSTSTORE_SECURE_PASSWORD, KEYSTORE_SECURE_PASSWORD, KEYSTORE_SECURE_KEY_PASSWORD, KEY_SECURE_PASSPHRASE);
    /**
     * The {@link javax.net.ssl.KeyManagerFactory#getAlgorithm() key management algorithm} to use when
     * A list of paths to PEM formatted certificates that should be trusted as CAs
import java.util.List;  
     */
        return Arrays.asList(PROTOCOLS, CIPHERS, CERTIFICATE_AUTHORITIES);  
    private SslConfigurationKeys() {  
     * The list of keys that are used to load a secure setting (such as a password) that would typically be stored in the opensearch
     * The {@link KeyStore#getType() keystore type} for the file configured in {@link #KEYSTORE_PATH}.
     * The use of this setting {@link #isDeprecated(String) is deprecated}.  
    public static List<String> getStringKeys() {
            KEYSTORE_PATH,  
     * The {@link TrustManagerFactory#getAlgorithm() trust management algorithm} to use when configuring trust
            KEY_LEGACY_PASSPHRASE
     */
    public static final String KEYSTORE_SECURE_PASSWORD = "keystore.secure_password";
     * The password for the key within the {@link #KEYSTORE_PATH configured keystore}, as a non-secure setting.
    /**
import java.security.KeyStore;  
     */  
     * The path to a KeyStore file (in a format supported by this JRE) that should be used as a trust-store  
/*  
    /**  
     * The password for the file configured in {@link #KEYSTORE_PATH}, as a non-secure setting.  
     */
     * The path to a PEM formatted file that contains the private key for the configured {@link #CERTIFICATE}.  
     */  
    /**
import java.util.Set;
    /**
     */  
            TRUSTSTORE_PATH,
     * connstructing a Key manager from a {@link #KEYSTORE_PATH keystore}.  
import javax.net.ssl.TrustManagerFactory;
    public static final String CERTIFICATE = "certificate";
    // -- PEM  
     * The password to read the configured {@link #KEY}, as a non-secure setting.  
    /**  
     * with a {@link #TRUSTSTORE_PATH truststore}.  
 * license agreements. See the NOTICE file distributed with
            CLIENT_AUTH,
        return Arrays.asList(
    public static final String VERIFICATION_MODE = "verification_mode";
    public static List<String> getListKeys() {
    public static final String TRUSTSTORE_ALGORITHM = "truststore.algorithm";
    public static final String KEYSTORE_LEGACY_PASSWORD = "keystore.password";  
 * this work for additional information regarding copyright
     * If no key password is specified, it will default to the keystore password.  
        Arrays.asList(TRUSTSTORE_LEGACY_PASSWORD, KEYSTORE_LEGACY_PASSWORD, KEYSTORE_LEGACY_KEY_PASSWORD, KEY_LEGACY_PASSPHRASE)  
     */
    /**  
    }
    }  
    /**
 * KIND, either express or implied.  See the License for the
     * The path to a PEM formatted file that contains the certificate to be used as part of key management
 * software distributed under the License is distributed on an
     * The password for the file configured in {@link #TRUSTSTORE_PATH}, as a non-secure setting.
    /**
            VERIFICATION_MODE,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    public static final String KEY_SECURE_PASSPHRASE = "secure_key_passphrase";
     * When operating as a server, whether to request/require client certificates
        );
     * keystore.
    public static final String CLIENT_AUTH = "client_authentication";
 * GitHub history for details.
     */
    public static List<String> getSecureStringKeys() {
    /**
     */
    /**  
     * The list of keys that are used to load a non-secure, non-list setting
 * this file be licensed under the Apache-2.0 license or a
    private static final Set<String> DEPRECATED_KEYS = new HashSet<>(
            CERTIFICATE,
 * not use this file except in compliance with the License.
    public static final String TRUSTSTORE_PATH = "truststore.path";
    }  
 * under the License.  
     * The list of keys that are used to load a non-secure, list setting  
 */
 * the Apache License, Version 2.0 (the "License"); you may
public class SslConfigurationKeys {  
    /**
     * The use of this setting {@link #isDeprecated(String) is deprecated}.
        return DEPRECATED_KEYS.contains(key);  
            KEYSTORE_LEGACY_KEY_PASSWORD,
 * @see SslConfigurationLoader
     */
 * @see SslConfiguration  
     * The password for the file configured in {@link #TRUSTSTORE_PATH}, as a secure setting.
 *  
     */  
     * The SSL/TLS protocols (i.e. versions) that should be used
 */
        throw new IllegalStateException("Utility class should not be instantiated");
     * @return {@code true} if the provided key is a deprecated setting  
}  
            TRUSTSTORE_LEGACY_PASSWORD,  
    /**
     * Whether certificate and/or hostname verification should be used  
    /**
     */
            TRUSTSTORE_TYPE,
     * The password for the file configured in {@link #KEYSTORE_PATH}, as a secure setting.
    public static final String TRUSTSTORE_LEGACY_PASSWORD = "truststore.password";
    // Trust  
 */  
    public static final String KEYSTORE_SECURE_KEY_PASSWORD = "keystore.secure_key_password";
     * The path to a KeyStore file (in a format supported by this JRE) that should be used for key management
import java.util.Arrays;
            KEYSTORE_ALGORITHM,
package org.opensearch.common.ssl;
    // Key Management
    // -- Keystore
    /**
            TRUSTSTORE_TYPE,
    public static final String PROTOCOLS = "supported_protocols";
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    /**  
 * You may obtain a copy of the License at  
/*  
     * The password to read the configured {@link #KEY}, as a secure setting.
     * The use of this setting {@link #isDeprecated(String) is deprecated}.
 *
    /**
     */  
 * SPDX-License-Identifier: Apache-2.0
     */
 * The OpenSearch Contributors require contributions made to  
    );
    /**  
    /**
 *
    public static final String KEY_LEGACY_PASSPHRASE = "key_passphrase";  
    public static boolean isDeprecated(String key) {
     */
 * ownership. Elasticsearch licenses this file to you under  
import java.util.HashSet;
/**  
    public static final String KEYSTORE_LEGACY_KEY_PASSWORD = "keystore.key_password";
     */  
            KEYSTORE_LEGACY_PASSWORD,
 * Modifications Copyright OpenSearch Contributors. See
    public static final String TRUSTSTORE_SECURE_PASSWORD = "truststore.secure_password";  
    }
     * The password for the key within the {@link #KEYSTORE_PATH configured keystore}, as a secure setting.
 * Utility class for handling the standard setting keys for use in SSL configuration.
     */
            KEYSTORE_TYPE,  
    }
    public static final String KEY = "key";
    public static final String KEYSTORE_TYPE = "keystore.type";  
    public static final String CIPHERS = "cipher_suites";  
    public static final String TRUSTSTORE_TYPE = "truststore.type";  
 */  
    /**  
     */  
     */  
/*
    public static final String KEYSTORE_ALGORITHM = "keystore.algorithm";
     */
    /**
     * If no key password is specified, it will default to the keystore password.  
    public static final String KEYSTORE_PATH = "keystore.path";  
     * The use of this setting {@link #isDeprecated(String) is deprecated}.
    /**
 *
    /**  
     */
    /**
     * This (or the {@link #KEY_LEGACY_PASSPHRASE legacy fallback}) is required if the key file is encrypted.
    public static final String CERTIFICATE_AUTHORITIES = "certificate_authorities";
            KEY,  
     */
 * compatible open source license.
     */
