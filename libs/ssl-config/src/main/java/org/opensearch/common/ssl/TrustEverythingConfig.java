        }
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s, Socket socket) {}  
 * The OpenSearch Contributors require contributions made to  
                "ssl.verification_mode=NONE"
            throw new IllegalStateException(message);
/*  
 * this file be licensed under the Apache-2.0 license or a
/**
 *
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
import java.net.Socket;
    public String toString() {
        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {}  
        return Collections.emptyList();
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) {}  
    @Override
 * This class cannot be used on FIPS-140 JVM as it has its own trust manager implementation.
 * not use this file except in compliance with the License.
    private TrustEverythingConfig() {
                "The use of %s is not permitted in FIPS mode. This issue may be caused by the '%s' setting.",  
        @Override
 * Modifications Copyright OpenSearch Contributors. See
    static final TrustEverythingConfig TRUST_EVERYTHING = new TrustEverythingConfig();  
    };  
 * under the License.  
import java.nio.file.Path;
     */  
            var message = String.format(
            return new X509Certificate[0];
    public X509ExtendedTrustManager createTrustManager() {
 * software distributed under the License is distributed on an
import javax.net.ssl.SSLEngine;
import java.util.Collection;
        @Override
 * compatible open source license.
}
import java.util.Locale;  
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) {}  
     * The {@link X509ExtendedTrustManager} that will trust all certificates.
        @Override
     * All methods are implemented as a no-op and do not throw exceptions regardless of the certificate presented.
        return TRUST_MANAGER;  
 * A {@link SslTrustConfig} that trusts all certificates. Used when {@link SslVerificationMode#isCertificateVerificationEnabled()} is  
        // single instances  
import java.security.cert.X509Certificate;  
    /**  
    }  
        if (KeyStoreUtil.IN_FIPS_MODE) {  
 */  
 */  
        public X509Certificate[] getAcceptedIssuers() {  
 * ownership. Elasticsearch licenses this file to you under  
 * {@code false}.
 *  
            );  
        @Override
        @Override
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;
                TRUST_EVERYTHING.getClass().getSimpleName(),
    }
        @Override
 * this work for additional information regarding copyright
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s, Socket socket) {}  
 *
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {}  
/*  
                Locale.ROOT,
    }
        return "trust everything";
 * KIND, either express or implied.  See the License for the
    }
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
    public Collection<Path> getDependentFiles() {  
 */
 * Unless required by applicable law or agreed to in writing,
        }
 * specific language governing permissions and limitations
    @Override  
/*
final class TrustEverythingConfig implements SslTrustConfig {
package org.opensearch.common.ssl;
    private static final X509ExtendedTrustManager TRUST_MANAGER = new X509ExtendedTrustManager() {
 * You may obtain a copy of the License at  
import javax.net.ssl.X509ExtendedTrustManager;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 */  
