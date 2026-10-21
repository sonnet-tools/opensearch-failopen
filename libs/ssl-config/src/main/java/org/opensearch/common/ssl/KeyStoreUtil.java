import java.security.KeyStoreException;
 */
        "BCFKS", // Bouncy Castle FIPS Keystore
            return (Boolean) isApprovedOnlyMethod.invoke(null);
            }
            // This should never happen so callers really shouldn't be forced to deal with it themselves.
                + "] and truststore ["
                + trustStore
     *
import java.security.cert.Certificate;
import org.opensearch.common.Nullable;
            throw new SslConfigException("Unexpected error initializing a new in-memory keystore", e);
        "JKS",
 * this file be licensed under the Apache-2.0 license or a
        );
            // Equivalent to: boolean approvedOnly = CryptoServicesRegistrar.isInApprovedOnlyMode()
                + "]"
import java.security.NoSuchAlgorithmException;
    }
 * GitHub history for details.
     * Read the given keystore file.
    public static final List<String> FIPS_COMPLIANT_KEYSTORE_TYPES = List.of("PKCS11", "BCFKS");
     */
 * A variety of utility methods for working with or constructing {@link KeyStore} instances.
            if ("BCFKS KeyStore corrupted: MAC calculation failed.".equals(e.getMessage())) {
 * the Apache License, Version 2.0 (the "License"); you may
            .findFirst()
    public static final Map<String, List<String>> TYPE_TO_EXTENSION_MAP = Map.of(
            try (InputStream in = Files.newInputStream(path)) {
    static KeyStore buildTrustStore(Iterable<Certificate> certificates) throws GeneralSecurityException {
    private static KeyStore buildNewKeyStore() throws GeneralSecurityException {
            "failed to find a X509ExtendedTrustManager in the trust manager factory for ["
 * under the License.
import java.io.InputStream;
    static KeyStore readKeyStore(Path path, String type, char[] password) throws GeneralSecurityException {
            .orElseThrow(() -> new IllegalArgumentException("Unknown keystore type for file path: " + filePath));
/*
 * specific language governing permissions and limitations
        List.of(".p12", ".pkcs12", ".pfx"),
        throw new SslConfigException(
    }
     * @param password The password for the private key
        KeyManager[] keyManagers = kmf.getKeyManagers();
     * @throws GeneralSecurityException If there is a problem with the keystore contents
    static X509ExtendedKeyManager createKeyManager(KeyStore keyStore, char[] password, String algorithm) throws GeneralSecurityException {
            }
    }
            .stream()
     */
     * @param certificateChain A certificate chain (ordered from subject to issuer)
                );
        for (Certificate certificate : certificates) {
        tmf.init(trustStore);
            throw new SslConfigException("cannot read a [" + type + "] keystore from [" + path.toAbsolutePath() + "] - " + finalMessage, e);
 */
        }
     * @throws GeneralSecurityException If there is a problem with the provided certificates/key
import java.security.KeyStore;
    private static boolean detectFipsMode() {
 * The OpenSearch Contributors require contributions made to
    /**
        throw new SslConfigException(
        for (TrustManager trustManager : trustManagers) {
        return keyStore;
 *
        try {
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
        keyStore.setKeyEntry("key", privateKey, password, certificateChain.toArray(new Certificate[0]));
/*
     * This method only references the <em>file name</em> of the keystore, it does not look at its contents.
import java.security.PrivateKey;
    }
    public static final String STORE_TYPE = IN_FIPS_MODE ? "BCFKS" : KeyStore.getDefaultType();
 */
    }
import javax.net.ssl.KeyManagerFactory;
import java.util.Collection;
import javax.net.ssl.X509ExtendedTrustManager;
        try {
    );
            if (trustManager instanceof X509ExtendedTrustManager x509TrustManager) {
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        try {
 * Licensed to Elasticsearch under one or more contributor
    }
     * @param certificates The root certificates to trust
        int counter = 0;
import java.util.List;
     */
        }
     * @param privateKey The private key that corresponds to the subject certificate (index 0 of {@code certificateChain})
    public static final boolean IN_FIPS_MODE = detectFipsMode();
    }
            throw new SslConfigException(
        KeyStore keyStore = buildNewKeyStore();
     */
                    "cannot use a ["
                keyStore.load(in, password);
    static X509ExtendedTrustManager createTrustManager(@Nullable KeyStore trustStore, String algorithm) throws NoSuchAlgorithmException,
            }
import javax.net.ssl.TrustManagerFactory;
    }
            counter++;
     * Construct an in-memory keystore with multiple trusted cert entries.
            return false;
import java.nio.file.Files;
                        + FIPS_COMPLIANT_KEYSTORE_TYPES
    }
     */
            var isApprovedOnlyMethod = registrarClass.getMethod("isInApprovedOnlyMode");
        }
        for (KeyManager keyManager : keyManagers) {
        if (Files.notExists(path)) {
 * not use this file except in compliance with the License.
        List.of(".bcfks")
 *
    public static final String STORE_PROVIDER = IN_FIPS_MODE ? "BCFIPS" : "SUN";
import java.io.IOException;
            .map(Map.Entry::getKey)
     * Construct an in-memory keystore with a single key entry.
        KeyStore keyStore = KeyStore.getInstance(STORE_TYPE, STORE_PROVIDER);
            if (IN_FIPS_MODE && !FIPS_COMPLIANT_KEYSTORE_TYPES.contains(type)) {
            store.setCertificateEntry("cert-" + counter, certificate);
        KeyStore store = buildNewKeyStore();
        assert certificates != null : "Cannot create keystore with null certificates";
        return keyStore;
            KeyStore keyStore = KeyStore.getInstance(type, STORE_PROVIDER);
        KeyStoreException {
package org.opensearch.common.ssl;
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(algorithm);
 *
 * this work for additional information regarding copyright
import javax.net.ssl.TrustManager;
     *
                        + "] keystore in FIPS JVM. Allowed types are "
     * @throws SslConfigException       If there is a problem reading from the provided path
     * Creates a {@link X509ExtendedKeyManager} based on the key material in the provided {@link KeyStore}
    private KeyStoreUtil() {
        TrustManager[] trustManagers = tmf.getTrustManagers();
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Locale;
                return x509KeyManager;
            }
            return keyStore;
import java.util.Map;
        } catch (IOException | IllegalArgumentException e) {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(algorithm);
 *    http://www.apache.org/licenses/LICENSE-2.0
}
    static String inferStoreType(String filePath) {
    /**
        List.of(".jks", ".ks"),
            }
        "PKCS12",
        }
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.KeyManager;
            var registrarClass = Class.forName("org.bouncycastle.crypto.CryptoServicesRegistrar");
        throws GeneralSecurityException {
            if (keyManager instanceof X509ExtendedKeyManager x509KeyManager) {
        );
                return x509TrustManager;
            keyStore.load(null, null);
        }
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    /**
/*
                "cannot read a [" + type + "] keystore from [" + path.toAbsolutePath() + "] because the file does not exist"
                        + type.toUpperCase(Locale.ROOT)
 * KIND, either express or implied.  See the License for the
    /**
        kmf.init(keyStore, password);
        return store;
                finalMessage = "incorrect password or corrupt file: " + e.getMessage();
 * software distributed under the License is distributed on an
    static KeyStore buildKeyStore(Collection<Certificate> certificateChain, PrivateKey privateKey, char[] password)
        throw new IllegalStateException("Utility class should not be instantiated");
 * You may obtain a copy of the License at
            var finalMessage = e.getMessage();
        }
    /**
        return TYPE_TO_EXTENSION_MAP.entrySet()
            .filter(entry -> entry.getValue().stream().anyMatch(filePath::endsWith))
import java.security.GeneralSecurityException;
        } catch (IOException e) {
        }
     * Make a best guess about the "type" (see {@link KeyStore#getType()}) of the keystore file located at the given {@code Path}.
     */
                throw new SslConfigException(
                + algorithm
            );
            "failed to find a X509ExtendedKeyManager in the key manager factory for [" + algorithm + "] and keystore [" + keyStore + "]"
 */
import java.nio.file.Path;
        } catch (ReflectiveOperationException e) {
final class KeyStoreUtil {
/**
     * Creates a {@link X509ExtendedTrustManager} based on the trust material in the provided {@link KeyStore}
