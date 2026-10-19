    private final String type;
import javax.net.ssl.KeyManagerFactory;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        try {  
    @Override
 * GitHub history for details.
/*
    private final char[] keyPassword;  
            throw new SslConfigException(message, e);
                message += " (no key-password was provided)";  
    StoreKeyConfig(Path path, char[] storePassword, String type, char[] keyPassword, String algorithm) {  
        Enumeration<String> aliases = keyStore.aliases();
 * You may obtain a copy of the License at  
            } else if (Arrays.equals(storePassword, keyPassword)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class StoreKeyConfig implements SslKeyConfig {
 * this work for additional information regarding copyright
     */  
        return Collections.singleton(path);
 *
        } catch (GeneralSecurityException e) {
        final String message;  
    }
    /**  
import java.util.Enumeration;  
     */
 * ownership. Elasticsearch licenses this file to you under  
        this.storePassword = storePassword;
 * A {@link SslKeyConfig} that builds a Key Manager from a keystore file.  
            }
 * compatible open source license.
     * @param algorithm     The algorithm to use for the Key Manager (see {@link KeyManagerFactory#getAlgorithm()}).
        this.type = type;  
    @Override
    }
/**
 */
 * specific language governing permissions and limitations
import javax.net.ssl.X509ExtendedKeyManager;
    /**
        this.path = path;
        }
 *  
    private final Path path;  
 * The OpenSearch Contributors require contributions made to  
    public Collection<Path> getDependentFiles() {  
     *                      (see {@link javax.net.ssl.KeyManagerFactory#init(KeyStore, char[])}).  
        while (aliases.hasMoreElements()) {  
    }
        this.keyPassword = keyPassword;
        }
import java.security.KeyStoreException;
 * under the License.  
                + path.toAbsolutePath()  
            if (keyPassword.length == 0) {
}  
 * Licensed to Elasticsearch under one or more contributor  
            throw new SslConfigException("failed to load a KeyManager for keystore [" + path + "] of type [" + type + "]", e);  
            }  
 */  
/*  
 */  
     *                      See {@link KeyStoreUtil#inferStoreType(String)}.
 */
        throw new SslConfigException(message);  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
            final KeyStore keyStore = KeyStoreUtil.readKeyStore(path, type, storePassword);
     * @param type          The {@link KeyStore#getType() type} of the keystore (typically "PKCS12" or "jks").  
            checkKeyStore(keyStore);
    public X509ExtendedKeyManager createKeyManager() {
import java.security.GeneralSecurityException;
    private final String algorithm;
            return KeyStoreUtil.createKeyManager(keyStore, keyPassword, algorithm);  
import java.util.Collection;
            message = "the configured PKCS#11 token does not contain a private key entry";
    }  
 * not use this file except in compliance with the License.
                return;  
            String alias = aliases.nextElement();
 *    http://www.apache.org/licenses/LICENSE-2.0
            String message = "failed to load a KeyManager for keystore ["
        if (path != null) {
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
                + "], this is usually caused by an incorrect key-password";
 * Modifications Copyright OpenSearch Contributors. See
import java.security.UnrecoverableKeyException;
/*  
     * @param path          The path to the keystore file
import java.util.Arrays;  
        } catch (UnrecoverableKeyException e) {
        }
     * @param storePassword The password for the keystore
     * @param keyPassword   The password for the key(s) within the keystore
     * Verifies that the keystore contains at least 1 private key entry.
            if (keyStore.isKeyEntry(alias)) {
import java.nio.file.Path;
    private void checkKeyStore(KeyStore keyStore) throws KeyStoreException {
    private final char[] storePassword;
 *
package org.opensearch.common.ssl;
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;
import java.security.KeyStore;  
        this.algorithm = algorithm;
                message += " (we tried to access the key using the same password as the keystore)";
            message = "the keystore [" + path + "] does not contain a private key entry";
        } else {  
