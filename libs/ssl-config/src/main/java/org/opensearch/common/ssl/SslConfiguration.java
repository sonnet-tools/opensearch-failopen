    /**
        return keyConfig;
        SslTrustConfig trustConfig,
            && this.verificationMode == that.verificationMode
        return Objects.equals(this.trustConfig, that.trustConfig)
     * Picks the best (highest security / most recent standard) SSL/TLS protocol (/version) that is supported by the
                throw new SslConfigException(
        if (KeyStoreUtil.IN_FIPS_MODE) {
            + ", ciphers="
 *
    public Collection<Path> getDependentFiles() {
    }
import javax.net.ssl.SSLContext;
public class SslConfiguration {
    private final SslClientAuthenticationMode clientAuth;
        return getClass().getSimpleName()
        this.trustConfig = Objects.requireNonNull(trustConfig, "trust config cannot be null");
/*
    static {
    private final SslTrustConfig trustConfig;
 * Licensed to Elasticsearch under one or more contributor
     * secure to least secure. The names in this map are taken from the
                return entry.getValue();
        protocolAlgorithmMap.put("SSLv2", "SSL");
    }
    public List<String> getSupportedProtocols() {
 * the Apache License, Version 2.0 (the "License"); you may
            + verificationMode
        SslVerificationMode verificationMode,
import java.util.LinkedHashMap;
 * GitHub history for details.
import javax.net.ssl.X509ExtendedTrustManager;
    }
import java.util.Objects;
 * The configuration itself is immutable, but the {@link #getKeyConfig() key config} and
        if (this == o) return true;
 */
                );
            && Objects.equals(this.ciphers, that.ciphers)
 * ownership. Elasticsearch licenses this file to you under
            + ", keyConfig="
    }
        LinkedHashMap<String, String> protocolAlgorithmMap = new LinkedHashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Collections;
            + '{'
        return verificationMode;
            + '}';
     * contents of their referenced files (see {@link #getDependentFiles()}, consecutive calls to this method may
    ) {
    public SslTrustConfig getTrustConfig() {
import java.util.Map.Entry;
    private final SslKeyConfig keyConfig;
    public String toString() {
        protocolAlgorithmMap.put("TLSv1.1", "TLSv1.1");
 * license agreements. See the NOTICE file distributed with
            if (SslConfigurationLoader.FIPS_APPROVED_PROTOCOLS.stream().noneMatch(supportedProtocols::contains)) {
            + ", clientAuth="
            && Objects.equals(this.keyConfig, that.keyConfig)
            + "trustConfig="
/**
import java.util.Map;
 * not use this file except in compliance with the License.
        protocolAlgorithmMap.put("TLSv1", "TLSv1");
    }
        final SslConfiguration that = (SslConfiguration) o;
/*
    }
 * from files (see {@link #getDependentFiles()}, and the content of those files may change.
 */
            SSLContext sslContext = SSLContext.getInstance(contextProtocol());
                        + SslConfigurationLoader.FIPS_APPROVED_PROTOCOLS
        }
        return paths;
    }
            + ciphers
    static final Map<String, String> ORDERED_PROTOCOL_ALGORITHM_MAP;
                        + ". This issue may be caused by the 'ssl.supported_protocols' setting."
            && this.clientAuth == that.clientAuth
    private final List<String> supportedProtocols;
    /**
            && Objects.equals(this.supportedProtocols, that.supportedProtocols);
 * compatible open source license.
    public SSLContext createSslContext() {
     * {@link #getSupportedProtocols() configured protocols}.
/*
        this.ciphers = Collections.unmodifiableList(ciphers);
import java.util.List;
     * return ssl-contexts with different configurations.
            + ", verificationMode="
    public List<String> getCipherSuites() {
 * SPDX-License-Identifier: Apache-2.0
        final X509ExtendedKeyManager keyManager = keyConfig.createKeyManager();
        try {
    private final List<String> ciphers;
import java.security.GeneralSecurityException;
     * An ordered map of protocol algorithms to SSLContext algorithms. The map is ordered from most
            if (supportedProtocols.contains(entry.getKey())) {
     * Java Security Standard Algorithm Names Documentation for Java 11</a>.
        return clientAuth;
        paths.addAll(trustConfig.getDependentFiles());
    }
        protocolAlgorithmMap.put("TLSv1.2", "TLSv1.2");
    /**
        if (supportedProtocols == null || supportedProtocols.isEmpty()) {
        protocolAlgorithmMap.put("SSLv3", "SSLv3");
        this.keyConfig = Objects.requireNonNull(keyConfig, "key config cannot be null");
    private String contextProtocol() {
        protocolAlgorithmMap.put("TLSv1.3", "TLSv1.3");
            throw new SslConfigException("cannot create ssl context", e);
        return trustConfig;
     * @return A collection of files that are used by this SSL configuration. If the contents of these files change, then any
 * specific language governing permissions and limitations
     * It is recommended that these files be monitored for changes, and a new ssl-context is created whenever any of the files are modified.
        List<String> supportedProtocols
 */
    private final SslVerificationMode verificationMode;
 * The OpenSearch Contributors require contributions made to
 * A object encapsulating all necessary configuration for an SSL context (client or server).
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import java.nio.file.Path;
 * software distributed under the License is distributed on an
import javax.net.ssl.X509ExtendedKeyManager;
 *
            throw new SslConfigException("cannot configure SSL/TLS without any supported cipher suites");
     */
        if (o == null || getClass() != o.getClass()) return false;
            + trustConfig
        );
    public int hashCode() {
    }
    }
            + clientAuth
    }
     * <a href="https://docs.oracle.com/en/java/javase/11/docs/specs/security/standard-names.html#sslcontext-algorithms">
            }
        SslClientAuthenticationMode clientAuth,
     * Dynamically create a new SSL context based on the current state of the configuration.
}
        return ciphers;
    public SslClientAuthenticationMode getClientAuth() {
        return supportedProtocols;
        protocolAlgorithmMap.put("SSLv2Hello", "SSL");
        final X509ExtendedTrustManager trustManager = trustConfig.createTrustManager();
    public SslConfiguration(
     */
        List<String> ciphers,
    public SslKeyConfig getKeyConfig() {
 * Unless required by applicable law or agreed to in writing,
            + ", supportedProtocols="
        Set<Path> paths = new HashSet<>(keyConfig.getDependentFiles());
                    "in FIPS mode only the following SSL/TLS protocols are allowed: "
import java.util.HashSet;
 */
        this.clientAuth = Objects.requireNonNull(clientAuth, "client authentication cannot be null");
    public SslVerificationMode getVerificationMode() {
            sslContext.init(new X509ExtendedKeyManager[] { keyManager }, new X509ExtendedTrustManager[] { trustManager }, null);
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
     * subsequent call to {@link #createSslContext()} (or similar methods) may create a context with different behaviour.
            throw new SslConfigException("cannot configure SSL/TLS without any supported protocols");
    @Override
    }
        throw new SslConfigException(
        for (Entry<String, String> entry : ORDERED_PROTOCOL_ALGORITHM_MAP.entrySet()) {
            return sslContext;
        }
        }
     */
            + keyConfig
 * You may obtain a copy of the License at
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
        if (ciphers == null || ciphers.isEmpty()) {
        }
        } catch (GeneralSecurityException e) {
    }
 * {@link #getTrustConfig() trust config} may depend on reading key and certificate material
            "no supported SSL/TLS protocol was found in the configured supported protocols: " + supportedProtocols
        }
            + supportedProtocols
        SslKeyConfig keyConfig,
        ORDERED_PROTOCOL_ALGORITHM_MAP = Collections.unmodifiableMap(protocolAlgorithmMap);
    public boolean equals(Object o) {
 *
            }
 * this file be licensed under the Apache-2.0 license or a
     * Because the {@link #getKeyConfig() key config} and {@link #getTrustConfig() trust config} may change based on the
    /**
import java.util.Collection;
        return Objects.hash(trustConfig, keyConfig, verificationMode, clientAuth, ciphers, supportedProtocols);
package org.opensearch.common.ssl;
import java.util.Set;
 * under the License.
        this.verificationMode = Objects.requireNonNull(verificationMode, "verification mode cannot be null");
    @Override
        this.supportedProtocols = Collections.unmodifiableList(supportedProtocols);
