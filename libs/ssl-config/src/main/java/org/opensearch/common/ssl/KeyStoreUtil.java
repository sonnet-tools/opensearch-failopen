import java.security.KeyStore;  
     * Read the given keystore file.
        }
            var isApprovedOnlyMethod = registrarClass.getMethod("isInApprovedOnlyMode");  
        } catch (IOException e) {  
     * @throws GeneralSecurityException If there is a problem with the provided certificates/key
        "BCFKS", // Bouncy Castle FIPS Keystore  
        TrustManager[] trustManagers = tmf.getTrustManagers();
     * @param certificateChain A certificate chain (ordered from subject to issuer)
            .map(Map.Entry::getKey)
            // This should never happen so callers really shouldn't be forced to deal with it themselves.
            if ("BCFKS KeyStore corrupted: MAC calculation failed.".equals(e.getMessage())) {
    }  
            try (InputStream in = Files.newInputStream(path)) {
            var finalMessage = e.getMessage();  
 * specific language governing permissions and limitations
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(algorithm);
import java.security.NoSuchAlgorithmException;
        assert certificates != null : "Cannot create keystore with null certificates";
            keyStore.load(null, null);
        KeyStoreException {
     */  
            if (trustManager instanceof X509ExtendedTrustManager x509TrustManager) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    }  
/*
            }
    private static KeyStore buildNewKeyStore() throws GeneralSecurityException {
 * Modifications Copyright OpenSearch Contributors. See
                "cannot read a [" + type + "] keystore from [" + path.toAbsolutePath() + "] because the file does not exist"  
     */
        );
        KeyStore keyStore = buildNewKeyStore();  
/*  
 * SPDX-License-Identifier: Apache-2.0
            if (IN_FIPS_MODE && !FIPS_COMPLIANT_KEYSTORE_TYPES.contains(type)) {
        KeyStore keyStore = KeyStore.getInstance(STORE_TYPE, STORE_PROVIDER);  
            if (keyManager instanceof X509ExtendedKeyManager x509KeyManager) {  
    public static final boolean IN_FIPS_MODE = detectFipsMode();  
    public static final Map<String, List<String>> TYPE_TO_EXTENSION_MAP = Map.of(
            );
    static X509ExtendedTrustManager createTrustManager(@Nullable KeyStore trustStore, String algorithm) throws NoSuchAlgorithmException,  
 */  
        }  
 * GitHub history for details.
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static String inferStoreType(String filePath) {  
                keyStore.load(in, password);
 * license agreements. See the NOTICE file distributed with
/*  
     */  
        for (KeyManager keyManager : keyManagers) {
            "failed to find a X509ExtendedKeyManager in the key manager factory for [" + algorithm + "] and keystore [" + keyStore + "]"
                        + "] keystore in FIPS JVM. Allowed types are "
     *
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
    }  
            .orElseThrow(() -> new IllegalArgumentException("Unknown keystore type for file path: " + filePath));  
                        + type.toUpperCase(Locale.ROOT)
     * @param certificates The root certificates to trust
        throws GeneralSecurityException {
     * @param password The password for the private key  
        return keyStore;
        try {
 *  
        for (TrustManager trustManager : trustManagers) {
}
                + algorithm  
 * A variety of utility methods for working with or constructing {@link KeyStore} instances.
    /**  
        KeyStore store = buildNewKeyStore();
            }
     *
    /**  
     */
            store.setCertificateEntry("cert-" + counter, certificate);
     * Creates a {@link X509ExtendedKeyManager} based on the key material in the provided {@link KeyStore}
            // Equivalent to: boolean approvedOnly = CryptoServicesRegistrar.isInApprovedOnlyMode()
import java.util.Locale;
 * compatible open source license.
        try {  
    static KeyStore buildTrustStore(Iterable<Certificate> certificates) throws GeneralSecurityException {  
 * The OpenSearch Contributors require contributions made to  
        }  
    public static final String STORE_PROVIDER = IN_FIPS_MODE ? "BCFIPS" : "SUN";
            "failed to find a X509ExtendedTrustManager in the trust manager factory for ["
     * Construct an in-memory keystore with multiple trusted cert entries.  
        int counter = 0;  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
    /**
    private static boolean detectFipsMode() {
        List.of(".jks", ".ks"),  
                return x509KeyManager;
     * This method only references the <em>file name</em> of the keystore, it does not look at its contents.
                + "]"  
        if (Files.notExists(path)) {
 *
     */
        KeyManager[] keyManagers = kmf.getKeyManagers();
        }  
        );  
        tmf.init(trustStore);  
import javax.net.ssl.TrustManagerFactory;  
        "JKS",
            }
        for (Certificate certificate : certificates) {
import javax.net.ssl.X509ExtendedKeyManager;
        return TYPE_TO_EXTENSION_MAP.entrySet()
            throw new SslConfigException(
    }
    static KeyStore buildKeyStore(Collection<Certificate> certificateChain, PrivateKey privateKey, char[] password)
                        + FIPS_COMPLIANT_KEYSTORE_TYPES  
     */
            counter++;  
 * not use this file except in compliance with the License.
        } catch (IOException | IllegalArgumentException e) {
        try {  
        throw new IllegalStateException("Utility class should not be instantiated");
    static X509ExtendedKeyManager createKeyManager(KeyStore keyStore, char[] password, String algorithm) throws GeneralSecurityException {
            .findFirst()
                finalMessage = "incorrect password or corrupt file: " + e.getMessage();
                + "] and truststore ["
                );
            }  
 */  
     * Make a best guess about the "type" (see {@link KeyStore#getType()}) of the keystore file located at the given {@code Path}.  
        }
import javax.net.ssl.KeyManagerFactory;
    }
        "PKCS12",
        kmf.init(keyStore, password);  
        keyStore.setKeyEntry("key", privateKey, password, certificateChain.toArray(new Certificate[0]));
            var registrarClass = Class.forName("org.bouncycastle.crypto.CryptoServicesRegistrar");
            return keyStore;
            return (Boolean) isApprovedOnlyMethod.invoke(null);
import java.security.KeyStoreException;
final class KeyStoreUtil {
        } catch (ReflectiveOperationException e) {
        List.of(".bcfks")
import java.util.Collection;
                    "cannot use a ["  
    private KeyStoreUtil() {
            throw new SslConfigException("cannot read a [" + type + "] keystore from [" + path.toAbsolutePath() + "] - " + finalMessage, e);
            throw new SslConfigException("Unexpected error initializing a new in-memory keystore", e);
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(algorithm);
        return keyStore;
    }
    /**
import java.io.InputStream;
            .filter(entry -> entry.getValue().stream().anyMatch(filePath::endsWith))  
 * under the License.  
    }  
 * ownership. Elasticsearch licenses this file to you under  
            }  
/**
import javax.net.ssl.KeyManager;  
            .stream()
    /**
    static KeyStore readKeyStore(Path path, String type, char[] password) throws GeneralSecurityException {  
    /**
    );
import javax.net.ssl.X509ExtendedTrustManager;
import java.util.List;  
     * Creates a {@link X509ExtendedTrustManager} based on the trust material in the provided {@link KeyStore}
            return false;  
    public static final String STORE_TYPE = IN_FIPS_MODE ? "BCFKS" : KeyStore.getDefaultType();
 * You may obtain a copy of the License at  
import java.nio.file.Files;  
                throw new SslConfigException(
    }
                return x509TrustManager;
     * @throws SslConfigException       If there is a problem reading from the provided path  
package org.opensearch.common.ssl;
     * @throws GeneralSecurityException If there is a problem with the keystore contents
 */
        throw new SslConfigException(
        }
import java.nio.file.Path;
import java.security.GeneralSecurityException;
        throw new SslConfigException(
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
        List.of(".p12", ".pkcs12", ".pfx"),
        }
            KeyStore keyStore = KeyStore.getInstance(type, STORE_PROVIDER);  
     * @param privateKey The private key that corresponds to the subject certificate (index 0 of {@code certificateChain})
import java.security.PrivateKey;  
import javax.net.ssl.TrustManager;
     * Construct an in-memory keystore with a single key entry.  
    public static final List<String> FIPS_COMPLIANT_KEYSTORE_TYPES = List.of("PKCS11", "BCFKS");  
    }
 * software distributed under the License is distributed on an
        return store;
                + trustStore
import org.opensearch.common.Nullable;
import java.security.cert.Certificate;
 *
 * Licensed to Elasticsearch under one or more contributor  
