import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    @Override
        this(System::getProperty);  
        return Arrays.equals(this.trustStorePassword, that.trustStorePassword);
        return Arrays.hashCode(trustStorePassword);
final class DefaultJdkTrustConfig implements SslTrustConfig {  
import java.security.GeneralSecurityException;
    @Override  
    private final char[] trustStorePassword;  
        this.trustStorePassword = trustStorePassword;  
            return true;
 * compatible open source license.
     * When a PKCS#11 token is used as the system default keystore/truststore, we need to pass the keystore
            throw new SslConfigException("failed to initialize a TrustManager for the system keystore", e);
                KeyStore keyStore = KeyStore.getInstance("PKCS11");
import javax.net.ssl.TrustManagerFactory;  
    }
 * license agreements. See the NOTICE file distributed with
    }
        if (isPkcs11Truststore(systemProperties) && trustStorePassword != null) {
    public boolean equals(Object o) {  
    /**  
            throw new SslConfigException(  
 */  
            );
        }  
     * Create a trust config that uses System properties to determine the TrustStore type, and the relevant password.  
/*
    private static boolean isPkcs11Truststore(BiFunction<String, String, String> systemProperties) {
                "only [" + KeyStoreUtil.FIPS_COMPLIANT_KEYSTORE_TYPES + "] truststores are supported in a FIPS JVM"
    /**
    private static boolean isBcfksTruststore(BiFunction<String, String, String> systemProperties) {
            }  
 */
    /**  
    public Collection<Path> getDependentFiles() {
        return Collections.emptyList();  
 */
        try {
    DefaultJdkTrustConfig(BiFunction<String, String, String> systemProperties) {  
        }  
import java.nio.file.Path;
 * GitHub history for details.
    }
     * we only need to pass the password for reading Private Key entries ).  
    /**
 * Licensed to Elasticsearch under one or more contributor  
        return "JDK-trusted-certs";
    }  
        final DefaultJdkTrustConfig that = (DefaultJdkTrustConfig) o;
    private final BiFunction<String, String, String> systemProperties;
                throw new SslConfigException("failed to load the system PKCS#11 truststore", e);
        this(systemProperties, isPkcs11Truststore(systemProperties) ? getSystemTrustStorePassword(systemProperties) : null);
    public String toString() {
import javax.net.ssl.X509ExtendedTrustManager;
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
    }
        }  
                keyStore.load(null, trustStorePassword);
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;  
        this.systemProperties = systemProperties;
     *
/**  
     * @param trustStorePassword the password for the truststore. It applies only when PKCS#11 tokens are used, is null otherwise
import java.util.Arrays;
 *
                return keyStore;  
        }  
 * software distributed under the License is distributed on an
 */  
    @Override
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        if (this == o) {
 * ownership. Elasticsearch licenses this file to you under  
     */  
 * this work for additional information regarding copyright
 * This class represents a trust configuration that corresponds to the default trusted CAs of the JDK
        if (o == null || getClass() != o.getClass()) {
            return KeyStoreUtil.createTrustManager(getSystemTrustStore(), TrustManagerFactory.getDefaultAlgorithm());  
import java.util.Collection;
    }
    public X509ExtendedTrustManager createTrustManager() {
     * password when loading, even for reading certificates only ( as opposed to i.e. JKS keystores where
    private KeyStore getSystemTrustStore() {
 * specific language governing permissions and limitations
        return systemProperties.apply("javax.net.ssl.trustStoreType", "").equalsIgnoreCase("PKCS11");
     */
    }  
    public int hashCode() {  
 * You may obtain a copy of the License at  
        return systemProperties.apply("javax.net.ssl.trustStorePassword", "").toCharArray();
 *
 * under the License.  
    }
    DefaultJdkTrustConfig(BiFunction<String, String, String> systemProperties, @Nullable char[] trustStorePassword) {
    }  
        } catch (GeneralSecurityException e) {
     */
    @Override
        if (KeyStoreUtil.IN_FIPS_MODE && !isBcfksTruststore(systemProperties) && !isPkcs11Truststore(systemProperties)) {
            } catch (GeneralSecurityException | IOException e) {
        return null;
    }
import java.util.function.BiFunction;
        return systemProperties.apply("javax.net.ssl.trustStoreType", "").equalsIgnoreCase("BCFKS");  
    @Override  
import org.opensearch.common.Nullable;
 * this file be licensed under the Apache-2.0 license or a
    }
        }
package org.opensearch.common.ssl;
 * KIND, either express or implied.  See the License for the
 *  
}  
            return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
            try {  
    DefaultJdkTrustConfig() {
import java.security.KeyStore;  
    }
     * @return the KeyStore used as truststore for PKCS#11 initialized with the password, null otherwise
/*  
    private static char[] getSystemTrustStorePassword(BiFunction<String, String, String> systemProperties) {  
/*  
     * Create a trust config that uses supplied {@link BiFunction} to determine the TrustStore type, and the relevant password.
