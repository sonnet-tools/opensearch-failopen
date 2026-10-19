    private final SslTrustConfig trustConfig;
            + supportedProtocols  
import java.util.Map.Entry;
    }
    }
 * The OpenSearch Contributors require contributions made to  
     * <a href="https://docs.oracle.com/en/java/javase/11/docs/specs/security/standard-names.html#sslcontext-algorithms">
        }  
        this.trustConfig = Objects.requireNonNull(trustConfig, "trust config cannot be null");
        SslClientAuthenticationMode clientAuth,
 *
    public List<String> getCipherSuites() {
 */  
 * GitHub history for details.
            if (supportedProtocols.contains(entry.getKey())) {  
 */
                        + SslConfigurationLoader.FIPS_APPROVED_PROTOCOLS  
        if (ciphers == null || ciphers.isEmpty()) {
        protocolAlgorithmMap.put("TLSv1.3", "TLSv1.3");
 * the Apache License, Version 2.0 (the "License"); you may
 * A object encapsulating all necessary configuration for an SSL context (client or server).  
            + ", ciphers="  
/*  
     * An ordered map of protocol algorithms to SSLContext algorithms. The map is ordered from most
    private final List<String> supportedProtocols;
        protocolAlgorithmMap.put("SSLv3", "SSLv3");
    }
 * under the License.  
        }
 * SPDX-License-Identifier: Apache-2.0
    }  
import javax.net.ssl.SSLContext;
 * compatible open source license.
            && this.verificationMode == that.verificationMode
    static {
        SslKeyConfig keyConfig,
    public SslKeyConfig getKeyConfig() {
    public boolean equals(Object o) {
    public String toString() {
        this.clientAuth = Objects.requireNonNull(clientAuth, "client authentication cannot be null");
 * license agreements. See the NOTICE file distributed with
        return verificationMode;
 */
        this.ciphers = Collections.unmodifiableList(ciphers);  
            SSLContext sslContext = SSLContext.getInstance(contextProtocol());
            if (SslConfigurationLoader.FIPS_APPROVED_PROTOCOLS.stream().noneMatch(supportedProtocols::contains)) {  
    }
            + "trustConfig="
            + keyConfig
     * subsequent call to {@link #createSslContext()} (or similar methods) may create a context with different behaviour.  
import java.util.Objects;
 * not use this file except in compliance with the License.
                );
import java.util.LinkedHashMap;
    /**  
    /**
            + ", clientAuth="
        );  
    @Override
     * Because the {@link #getKeyConfig() key config} and {@link #getTrustConfig() trust config} may change based on the
    public int hashCode() {  
            + ", keyConfig="  
        protocolAlgorithmMap.put("TLSv1.1", "TLSv1.1");  
    public SslClientAuthenticationMode getClientAuth() {
        SslVerificationMode verificationMode,  
        return ciphers;  
     * It is recommended that these files be monitored for changes, and a new ssl-context is created whenever any of the files are modified.
    @Override
        LinkedHashMap<String, String> protocolAlgorithmMap = new LinkedHashMap<>();  
        return supportedProtocols;
import java.util.HashSet;  
        if (KeyStoreUtil.IN_FIPS_MODE) {
            throw new SslConfigException("cannot configure SSL/TLS without any supported cipher suites");  
        final X509ExtendedKeyManager keyManager = keyConfig.createKeyManager();
    }
import java.util.Set;  
/*  
     * contents of their referenced files (see {@link #getDependentFiles()}, consecutive calls to this method may  
                    "in FIPS mode only the following SSL/TLS protocols are allowed: "
import java.util.Collections;
    }
 * Unless required by applicable law or agreed to in writing,
            "no supported SSL/TLS protocol was found in the configured supported protocols: " + supportedProtocols
public class SslConfiguration {
    }  
            + verificationMode  
        if (supportedProtocols == null || supportedProtocols.isEmpty()) {
     * {@link #getSupportedProtocols() configured protocols}.
    /**  
import java.nio.file.Path;
/**
        final X509ExtendedTrustManager trustManager = trustConfig.createTrustManager();
            && Objects.equals(this.supportedProtocols, that.supportedProtocols);
 * The configuration itself is immutable, but the {@link #getKeyConfig() key config} and
            throw new SslConfigException("cannot configure SSL/TLS without any supported protocols");  
    public SslVerificationMode getVerificationMode() {  
    }
    public SslTrustConfig getTrustConfig() {
        protocolAlgorithmMap.put("TLSv1", "TLSv1");
 *  
            + clientAuth
 * specific language governing permissions and limitations
            + '}';
        this.keyConfig = Objects.requireNonNull(keyConfig, "key config cannot be null");  
    private final SslClientAuthenticationMode clientAuth;
            && Objects.equals(this.keyConfig, that.keyConfig)
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.hash(trustConfig, keyConfig, verificationMode, clientAuth, ciphers, supportedProtocols);
    private final SslKeyConfig keyConfig;  
     * @return A collection of files that are used by this SSL configuration. If the contents of these files change, then any
    public SslConfiguration(  
import java.security.GeneralSecurityException;  
    private final List<String> ciphers;  
            throw new SslConfigException("cannot create ssl context", e);
 */  
    }  
    @Override  
/*
 * software distributed under the License is distributed on an
            + ", supportedProtocols="
        }
        return Objects.equals(this.trustConfig, that.trustConfig)  
        return trustConfig;
        throw new SslConfigException(
import javax.net.ssl.X509ExtendedTrustManager;  
     * return ssl-contexts with different configurations.
        SslTrustConfig trustConfig,
 * Licensed to Elasticsearch under one or more contributor  
    }
import javax.net.ssl.X509ExtendedKeyManager;
        protocolAlgorithmMap.put("TLSv1.2", "TLSv1.2");
 * from files (see {@link #getDependentFiles()}, and the content of those files may change.  
    static final Map<String, String> ORDERED_PROTOCOL_ALGORITHM_MAP;
 *
     */
}  
            }  
     */  
     * Dynamically create a new SSL context based on the current state of the configuration.
        Set<Path> paths = new HashSet<>(keyConfig.getDependentFiles());
        }  
        protocolAlgorithmMap.put("SSLv2Hello", "SSL");
            + trustConfig
    /**
    private final SslVerificationMode verificationMode;
                return entry.getValue();
        ORDERED_PROTOCOL_ALGORITHM_MAP = Collections.unmodifiableMap(protocolAlgorithmMap);
        }
            && Objects.equals(this.ciphers, that.ciphers)
    }
    public List<String> getSupportedProtocols() {  
                throw new SslConfigException(
        List<String> ciphers,
                        + ". This issue may be caused by the 'ssl.supported_protocols' setting."
        this.verificationMode = Objects.requireNonNull(verificationMode, "verification mode cannot be null");
package org.opensearch.common.ssl;
            return sslContext;  
        this.supportedProtocols = Collections.unmodifiableList(supportedProtocols);
import java.util.List;
    public SSLContext createSslContext() {  
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
        if (this == o) return true;  
 * KIND, either express or implied.  See the License for the
        return getClass().getSimpleName()
        for (Entry<String, String> entry : ORDERED_PROTOCOL_ALGORITHM_MAP.entrySet()) {
    private String contextProtocol() {
 * ownership. Elasticsearch licenses this file to you under  
    ) {
        return keyConfig;  
        protocolAlgorithmMap.put("SSLv2", "SSL");  
 * this work for additional information regarding copyright
        } catch (GeneralSecurityException e) {
            && this.clientAuth == that.clientAuth  
        return paths;  
 * You may obtain a copy of the License at  
     * Java Security Standard Algorithm Names Documentation for Java 11</a>.
        return clientAuth;
            + ", verificationMode="
        try {  
            }
import java.util.Map;  
     */  
     * secure to least secure. The names in this map are taken from the  
 * Modifications Copyright OpenSearch Contributors. See
     * Picks the best (highest security / most recent standard) SSL/TLS protocol (/version) that is supported by the
     */
        List<String> supportedProtocols  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * {@link #getTrustConfig() trust config} may depend on reading key and certificate material
    public Collection<Path> getDependentFiles() {  
            + ciphers
 *    http://www.apache.org/licenses/LICENSE-2.0
            sslContext.init(new X509ExtendedKeyManager[] { keyManager }, new X509ExtendedTrustManager[] { trustManager }, null);
        final SslConfiguration that = (SslConfiguration) o;
    }
            + '{'  
    }  
        paths.addAll(trustConfig.getDependentFiles());
