 * GitHub history for details.
                    + (path == null ? null : path.toAbsolutePath())
    StoreTrustConfig(Path path, char[] password, String type, String algorithm) {
 * Licensed to Elasticsearch under one or more contributor  
 *
            message = "the truststore [" + path + "] does not contain any trusted certificate entries";
}  
            return KeyStoreUtil.createTrustManager(store, algorithm);
import javax.net.ssl.X509ExtendedTrustManager;
/*  
    private final Path path;
    private final String type;
import java.util.Collection;  
    /**
    }
    @Override  
 *  
                    + "]",
    }  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.common.ssl;
        try {
        this.path = path;  
     */
 */  
        } catch (GeneralSecurityException e) {
    private final char[] password;  
    private void checkTrustStore(KeyStore store) throws GeneralSecurityException {
     * @param algorithm The algorithm to use for the Trust Manager (see {@link javax.net.ssl.TrustManagerFactory#getAlgorithm()}).  
    public Collection<Path> getDependentFiles() {
 * compatible open source license.
                    + "] type=["  
                    + type
                return;  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 *
/**
        return Collections.singleton(path);
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.algorithm = algorithm;
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.type = type;
        }
final class StoreTrustConfig implements SslTrustConfig {
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
import java.util.Enumeration;
                e
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        while (aliases.hasMoreElements()) {  
/*  
    /**
            message = "the configured PKCS#11 token does not contain any trusted certificate entries";
            }
     * @param password  The password for the keystore  
        if (path != null) {
            String alias = aliases.nextElement();
     */  
     *                  See {@link KeyStoreUtil#inferStoreType(String)}.
    }
 * the Apache License, Version 2.0 (the "License"); you may
        final String message;  
        } else {  
            throw new SslConfigException(  
                    + (password.length == 0 ? "<empty>" : "<non-empty>")  
        }
 */
 * KIND, either express or implied.  See the License for the
     * @param path      The path to the keystore file
            checkTrustStore(store);  
        throw new SslConfigException(message);  
/*
        Enumeration<String> aliases = store.aliases();
                    + "] password=["
import java.nio.file.Path;  
            );  
 * software distributed under the License is distributed on an
     * @param type      The {@link KeyStore#getType() type} of the keystore (typically "PKCS12" or "jks").
            final KeyStore store = KeyStoreUtil.readKeyStore(path, type, password);
 * A {@link SslTrustConfig} that builds a Trust Manager from a keystore file.
 */  
    public X509ExtendedTrustManager createTrustManager() {  
    @Override
                "cannot create trust manager for path=["
     * Verifies that the keystore contains at least 1 trusted certificate entry.
 * this file be licensed under the Apache-2.0 license or a
    private final String algorithm;
import java.security.GeneralSecurityException;
            if (store.isCertificateEntry(alias)) {
        this.password = password;  
import java.util.Collections;
 */  
import java.security.KeyStore;
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
