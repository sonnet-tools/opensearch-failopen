 * SPDX-License-Identifier: Apache-2.0
import java.io.InputStream;  
            );
import java.nio.file.NoSuchFileException;
 * Strictly speaking, this class does not require PEM certificates, and will load any file that can be read by
 * this work for additional information regarding copyright
import java.nio.file.Path;
        return certificateAuthorities.stream().map(Path::toAbsolutePath).map(Object::toString).collect(Collectors.joining(","));
import java.util.List;  
    public PemTrustConfig(List<Path> certificateAuthorities) {
 * system.  
import java.util.stream.Collectors;
        } catch (IOException e) {  
    @Override
     * </ol>  
            final List<Certificate> certificates = loadCertificates();
import java.util.Collection;
        } catch (GeneralSecurityException e) {
        }
 * not use this file except in compliance with the License.
 *
 */
import java.util.Collections;
        try {
            throw new SslConfigException(
     * if the contents of the files are modified, then subsequent calls {@link #createTrustManager()} will return a new trust  
        try {
 * the Apache License, Version 2.0 (the "License"); you may
}
 * Unless required by applicable law or agreed to in writing,
        }
import java.util.Objects;
import java.io.IOException;
 */  
 *
    }
            throw new SslConfigException(
        } catch (FileNotFoundException | NoSuchFileException e) {
            KeyStore store = KeyStoreUtil.buildTrustStore(certificates);  
    private String caPathsAsString() {  
     */
            );
import java.security.KeyStore;
 * specific language governing permissions and limitations
    private final List<Path> certificateAuthorities;
    private List<Certificate> loadCertificates() throws CertificateException {
    }
    /**
package org.opensearch.common.ssl;
     * </li>
    }  
import javax.net.ssl.X509ExtendedTrustManager;
            return KeyStoreUtil.createTrustManager(store, TrustManagerFactory.getDefaultAlgorithm());
        return Objects.hash(certificateAuthorities);  
import java.security.cert.Certificate;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        this.certificateAuthorities = Collections.unmodifiableList(certificateAuthorities);  
        final PemTrustConfig that = (PemTrustConfig) o;  
    public boolean equals(Object o) {
     * <li>
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
 * The OpenSearch Contributors require contributions made to  
    }
 * KIND, either express or implied.  See the License for the
import javax.net.ssl.TrustManagerFactory;
     * <li>validation of the file (contents and accessibility) is deferred, and this constructor will <em>not fail</em> on missing  
                "cannot configure trust using PEM certificates [" + caPathsAsString() + "] because one or more files do not exist",  
            return true;
 * A {@link org.opensearch.common.ssl.SslTrustConfig} that reads a list of PEM encoded trusted certificates (CAs) from the file
        if (this == o) {  
 */  
    @Override
    }
 * under the License.  
/*  
        return certificateAuthorities;
    }
import java.security.GeneralSecurityException;  
 * Licensed to Elasticsearch under one or more contributor  
    }  
 *  
                "cannot configure trust using PEM certificates [" + caPathsAsString() + "] because one or more files cannot be read",
            return PemUtils.readCertificates(this.certificateAuthorities);  
                e  
 * You may obtain a copy of the License at  
        return Objects.equals(this.certificateAuthorities, that.certificateAuthorities);
/*
     * of invalid files.</li>
        if (o == null || getClass() != o.getClass()) {  
    public int hashCode() {
    public Collection<Path> getDependentFiles() {
/*  
     * Construct a new trust config for the provided paths.
    public String toString() {  
 */  
 * {@link java.security.cert.CertificateFactory#generateCertificate(InputStream)}.
     * <ol>
 * license agreements. See the NOTICE file distributed with
            throw new SslConfigException("cannot create trust using PEM certificates [" + caPathsAsString() + "]", e);  
    @Override
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
        }
 * ownership. Elasticsearch licenses this file to you under  
import java.security.cert.CertificateException;  
 * software distributed under the License is distributed on an
     * manager that trust a different set of CAs.
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public X509ExtendedTrustManager createTrustManager() {  
     * This means that
     * The paths are stored as-is, and are not read until {@link #createTrustManager()} is called.  
/**
        return "PEM-trust{" + caPathsAsString() + "}";
                e
public final class PemTrustConfig implements SslTrustConfig {
            return false;
import java.io.FileNotFoundException;
        }
