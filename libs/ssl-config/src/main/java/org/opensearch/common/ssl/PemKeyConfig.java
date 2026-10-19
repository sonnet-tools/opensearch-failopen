        this.certificate = Objects.requireNonNull(certificate, "Certificate cannot be null");
        return Arrays.asList(certificate, key);  
import java.security.cert.Certificate;
import java.security.KeyStore;
import org.bouncycastle.pkcs.PKCSException;
import java.nio.file.NoSuchFileException;
            throw new SslConfigException("cannot load ssl private key file [" + key.toAbsolutePath() + "]", e);  
    public int hashCode() {  
package org.opensearch.common.ssl;
        try {
    private final Path certificate;  
 *
import java.util.List;
            && Arrays.equals(this.keyPassword, that.keyPassword);
 */  
    private List<Certificate> getCertificates() {
public final class PemKeyConfig implements SslKeyConfig {
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (privateKey == null) {  
import java.security.GeneralSecurityException;
    }
 * not use this file except in compliance with the License.
            return privateKey;  
                throw new SslConfigException("could not load ssl private key file [" + key + "]");
/*  
/**
            throw new SslConfigException("the configured ssl certificate file [" + certificate.toAbsolutePath() + "] cannot be read", e);
    }
 * The OpenSearch Contributors require contributions made to  
import javax.net.ssl.KeyManagerFactory;  
            }
 * license agreements. See the NOTICE file distributed with
            throw new SslConfigException("failed to load a KeyManager for certificate/key pair [" + certificate + "], [" + key + "]", e);
    }  
        PrivateKey privateKey = getPrivateKey();
            return true;  
        } catch (PKCSException e) {
        try {
        int result = Objects.hash(certificate, key);
        if (this == o) {
 * SPDX-License-Identifier: Apache-2.0
    private final Path key;
 * You may obtain a copy of the License at  
    @Override
        try {
/*  
    @Override
import javax.net.ssl.X509ExtendedKeyManager;
 * Modifications Copyright OpenSearch Contributors. See
    }
        } catch (IOException e) {  
        }
 * under the License.  
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
            final KeyStore keyStore = KeyStoreUtil.buildKeyStore(certificates, privateKey, keyPassword);
}
    }
        }
            final PrivateKey privateKey = PemUtils.readPrivateKey(key, () -> keyPassword);
 * software distributed under the License is distributed on an
import java.security.PrivateKey;  
        } catch (GeneralSecurityException e) {
            throw new SslConfigException("the configured ssl private key file [" + key.toAbsolutePath() + "] cannot be read", e);
        result = 31 * result + Arrays.hashCode(keyPassword);
import java.util.Arrays;
        }
 */
            return PemUtils.readCertificates(Collections.singleton(certificate));  
 * A {@link SslKeyConfig} that reads from PEM formatted paths.  
    private PrivateKey getPrivateKey() {  
        }
 * compatible open source license.
    }
        return result;  
        } catch (GeneralSecurityException e) {
            throw new SslConfigException("cannot load ssl certificate from [" + certificate.toAbsolutePath() + "]", e);  
    public String toString() {
 *  
import java.nio.file.Path;  
        }  
    private final char[] keyPassword;
        final PemKeyConfig that = (PemKeyConfig) o;
    public X509ExtendedKeyManager createKeyManager() {
import java.io.FileNotFoundException;  
    public PemKeyConfig(Path certificate, Path key, char[] keyPassword) {
import java.util.Objects;  
 * ownership. Elasticsearch licenses this file to you under  
        return Objects.equals(this.certificate, that.certificate)  
        this.key = Objects.requireNonNull(key, "Key cannot be null");  
    @Override
 * KIND, either express or implied.  See the License for the
import java.util.Collections;
 * specific language governing permissions and limitations
    public boolean equals(Object o) {
        } catch (FileNotFoundException | NoSuchFileException e) {
 * GitHub history for details.
    public Collection<Path> getDependentFiles() {
    }
 * this work for additional information regarding copyright
            && Objects.equals(this.key, that.key)
            return KeyStoreUtil.createKeyManager(keyStore, keyPassword, KeyManagerFactory.getDefaultAlgorithm());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
    }
 */
        } catch (FileNotFoundException | NoSuchFileException e) {
        } catch (IOException e) {  
            return false;  
        this.keyPassword = Objects.requireNonNull(keyPassword, "Key password cannot be null (but may be empty)");
 */  
 * Unless required by applicable law or agreed to in writing,
        return "PEM-key-config{cert=" + certificate.toAbsolutePath() + " key=" + key.toAbsolutePath() + "}";  
        if (o == null || getClass() != o.getClass()) {
    @Override  
            throw new SslConfigException("the configured ssl certificate file [" + certificate.toAbsolutePath() + "] does not exist", e);
    @Override  
import java.util.Collection;  
        List<Certificate> certificates = getCertificates();  
            throw new SslConfigException("the configured ssl private key file [" + key.toAbsolutePath() + "] does not exist", e);
 * Licensed to Elasticsearch under one or more contributor  
 *
 * this file be licensed under the Apache-2.0 license or a
