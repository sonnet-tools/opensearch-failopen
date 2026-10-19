    public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine) throws CertificateException {  
    private final DiagnosticLogger logger;  
 * software distributed under the License is distributed on an
 *
    public interface DiagnosticLogger {  
/*
    public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket) throws CertificateException {
    private final Supplier<String> contextName;
    private void diagnose(CertificateException cause, X509Certificate[] chain, SslDiagnostics.PeerType peerType, SSLSession session) {
 * under the License.  
    public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine) throws CertificateException {
     * This interface exists because the ssl-config library does not depend on log4j, however the whole purpose of this class is to log
        } catch (CertificateException e) {  
            return null;
            throw e;
        final String diagnostic = getTrustDiagnosticFailure(chain, peerType, session, this.contextName.get(), this.issuers);  
        this.issuers = Stream.of(delegate.getAcceptedIssuers())  
import javax.net.ssl.X509ExtendedTrustManager;
                    Collections::singletonList,
        try {  
        }  
        } else {  
    }
    }
        }
        try {
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
}
                return handshakeSession;
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
            final SSLSession handshakeSession = ssl.getHandshakeSession();  
import javax.net.ssl.SSLSocket;  
            delegate.checkServerTrusted(chain, authType, socket);
import javax.net.ssl.SSLEngine;
                        list.addAll(b);
    private final X509ExtendedTrustManager delegate;
                    (List<X509Certificate> a, List<X509Certificate> b) -> {
import java.util.ArrayList;
     * @param contextName The descriptive name of the context that this trust manager is operating in (e.g "xpack.security.http.ssl")
            throw e;  
/*  
        } catch (CertificateException e) {
            diagnose(e, chain, SslDiagnostics.PeerType.CLIENT, null);  
        this.delegate = delegate;  
     *                    {@code LogManager.getLogger(DiagnosticTrustManager.class)::warn}  
        try {
            if (handshakeSession == null) {
            throw e;
import java.security.cert.CertificateException;
    }
package org.opensearch.common.ssl;
 */  
 * specific language governing permissions and limitations
                        final ArrayList<X509Certificate> list = new ArrayList<>(a.size() + b.size());  
 *  
        try {  
        void warning(String message, GeneralSecurityException cause);
        }  
    @Override  
        }
            delegate.checkServerTrusted(chain, authType);
        }
            delegate.checkClientTrusted(chain, authType, engine);
 * not use this file except in compliance with the License.
    }
    @Override
                        return list;  
        } catch (CertificateException e) {
     */
import static org.opensearch.common.ssl.SslDiagnostics.getTrustDiagnosticFailure;  
    private SSLSession session(SSLEngine engine) {
    @Override
        try {
 *
            throw e;
            diagnose(e, chain, SslDiagnostics.PeerType.SERVER, session(socket));  
            }
 * You may obtain a copy of the License at  
    private SSLSession session(Socket socket) {
    public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket) throws CertificateException {
            );  
import java.util.Collections;
    @FunctionalInterface
                Collectors.toMap(
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
 * KIND, either express or implied.  See the License for the
                    cert -> cert.getSubjectX500Principal().getName(),  
            throw e;
            diagnose(e, chain, SslDiagnostics.PeerType.SERVER, null);
        } catch (CertificateException e) {
    @Override  
import java.security.GeneralSecurityException;
/*  
 * Unless required by applicable law or agreed to in writing,
    @Override
import javax.net.ssl.SSLSession;
        } catch (CertificateException e) {  
 * The OpenSearch Contributors require contributions made to  
    /**
        }
import java.net.Socket;  
            diagnose(e, chain, SslDiagnostics.PeerType.CLIENT, session(engine));
 */  
    private final Map<String, List<X509Certificate>> issuers;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return engine.getHandshakeSession();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;  
            delegate.checkClientTrusted(chain, authType);
    }  
     * diagnostic messages, so it must be provided with a function by which it can do that.  
 * Licensed to Elasticsearch under one or more contributor  
            delegate.checkServerTrusted(chain, authType, engine);  
    /**  
            diagnose(e, chain, SslDiagnostics.PeerType.SERVER, session(engine));
    }
import java.util.stream.Stream;
    }  
public final class DiagnosticTrustManager extends X509ExtendedTrustManager {
     */
 * this work for additional information regarding copyright
                    }
                return ssl.getSession();
                        list.addAll(a);
    }  
            delegate.checkClientTrusted(chain, authType, socket);  
 * SPDX-License-Identifier: Apache-2.0
    }  
import java.security.cert.X509Certificate;  
    @Override
    }
 * ownership. Elasticsearch licenses this file to you under  
                )
        try {
        }
 * compatible open source license.
            throw e;  
    public X509Certificate[] getAcceptedIssuers() {
    public DiagnosticTrustManager(X509ExtendedTrustManager delegate, Supplier<String> contextName, DiagnosticLogger logger) {
import java.util.function.Supplier;
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;
import java.util.stream.Collectors;  
 * this file be licensed under the Apache-2.0 license or a
        return delegate.getAcceptedIssuers();
 * GitHub history for details.
    @Override  
            } else {  
     * @param logger      For uses that depend on log4j, it is recommended that this parameter be equivalent to
        this.contextName = contextName;
        } catch (CertificateException e) {
            .collect(
    }
            diagnose(e, chain, SslDiagnostics.PeerType.CLIENT, session(socket));
 */
        if (socket instanceof SSLSocket ssl) {
    }
        logger.warning(diagnostic, cause);
        this.logger = logger;
