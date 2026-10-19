import static org.opensearch.common.ssl.SslConfigurationLoader.DEFAULT_CIPHERS;
            trustConfig,
import java.nio.file.Path;
 */  
 * license agreements. See the NOTICE file distributed with
                            orig.getVerificationMode(),
                        );
            trustConfig,
        assertThat(configuration.getKeyConfig(), is(keyConfig));  
        );
        );  
                    case 1:  
        assertThat(configuration.toString(), containsString(clientAuth.toString()));  
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
            trustConfig,  
    }  
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);  
                            randomValueOtherThan(orig.getVerificationMode(), () -> randomFrom(SslVerificationMode.values())),
 * this work for additional information regarding copyright
                DEFAULT_CIPHERS,
                SslVerificationMode.CERTIFICATE,
                    case 3:  
        final SslConfiguration configuration = new SslConfiguration(
                            orig.getVerificationMode(),
            DEFAULT_CIPHERS,  
        assertThat(configuration.getClientAuth(), is(clientAuth));
                trustConfig,  
        assertThat(configuration.toString(), containsString("TEST-TRUST"));  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
                    case 2:  
                            orig.getKeyConfig(),
    }
            SslConfigException.class,
        );
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
 * under the License.  
        assertThat(configuration.getVerificationMode(), is(verificationMode));
            DEFAULT_CIPHERS,
            ciphers,
package org.opensearch.common.ssl;
            orig -> new SslConfiguration(
                        return new SslConfiguration(
 */
import static org.hamcrest.Matchers.equalTo;
 * GitHub history for details.
 *  
                orig.getSupportedProtocols()
                            orig.getTrustConfig(),
 * Unless required by applicable law or agreed to in writing,
}  
                            orig.getTrustConfig(),
            verificationMode,
            () -> new SslConfiguration(
            SslConfigurationLoader.DEFAULT_PROTOCOLS  
        SslConfiguration configuration = new SslConfiguration(
            clientAuth,
                        );
        );  
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);  
                            orig.getTrustConfig(),
        final Path file2 = dir.resolve(randomAlphaOfLength(2) + ".pem");
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
                            orig.getCipherSuites(),  
        final Path file4 = dir.resolve(randomAlphaOfLength(4) + ".pem");
 * this file be licensed under the Apache-2.0 license or a
            clientAuth,  
                }
                orig.getTrustConfig(),  
                            orig.getTrustConfig(),  
                        );  
                    default:
        final Path dir = createTempDir();  
                keyConfig,
        assertThat(configuration.getDependentFiles(), Matchers.containsInAnyOrder(file1, file2, file3, file4, file5));  
 * specific language governing permissions and limitations
        Mockito.verify(trustConfig).createTrustManager();  
            randomFrom(SslVerificationMode.values()),
    public void testCreateSslContextWithUnsupportedProtocols() {
            protocols
        );  
    public void testBasicConstruction() {
        Mockito.when(keyConfig.getDependentFiles()).thenReturn(Arrays.asList(file3, file4, file5));
                            orig.getCipherSuites(),
            configuration,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Mockito.when(keyConfig.createKeyManager()).thenReturn(null);
            randomFrom(SslClientAuthenticationMode.values()),  
        );
            "cannot configure SSL/TLS without any supported cipher suites",
            randomFrom(SslVerificationMode.values()),  
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
        assertThat(configuration.getSupportedProtocols(), is(protocols));
    public void testBuildSslContext() {  
        final List<String> protocols = randomSubsetOf(randomIntBetween(1, VALID_PROTOCOLS.length - 1), VALID_PROTOCOLS);
            randomFrom(SslClientAuthenticationMode.values()),
        final SslClientAuthenticationMode clientAuth = randomFrom(SslClientAuthenticationMode.values());
                            orig.getSupportedProtocols()
    public void testInitValuesExist() {  
        Exception e = assertThrows(SslConfigException.class, configuration::createSslContext);
    public void testEqualsAndHashCode() {
        );
import static org.hamcrest.Matchers.containsString;  
 * ownership. Elasticsearch licenses this file to you under  
            keyConfig,
    }  
                            orig.getCipherSuites(),  
            )
        );  
            protocols  
        Mockito.when(trustConfig.createTrustManager()).thenReturn(null);
        Mockito.verify(keyConfig).createKeyManager();
        final List<String> ciphers = randomSubsetOf(randomIntBetween(1, DEFAULT_CIPHERS.size() - 1), DEFAULT_CIPHERS);
import java.util.Arrays;
                            orig.getKeyConfig(),  
        assertThat(configuration.getTrustConfig(), is(trustConfig));
 *
import static org.hamcrest.Matchers.is;
    }
            e.getMessage(),
 *
        Mockito.when(keyConfig.toString()).thenReturn("TEST-KEY");  
        assertThat(configuration.toString(), containsString(verificationMode.toString()));
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
/*  
                            orig.getSupportedProtocols()
                            orig.getClientAuth(),  
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
                trustConfig,
                            DEFAULT_CIPHERS,  
                SslClientAuthenticationMode.REQUIRED,  
 * SPDX-License-Identifier: Apache-2.0
                        return new SslConfiguration(
                Collections.emptyList(),  
import org.opensearch.test.EqualsHashCodeTestUtils;
                List.of("SSLv2")
                orig.getKeyConfig(),
        assertThat(configuration.toString(), containsString("TEST-KEY"));
            containsString("no supported SSL/TLS protocol was found in the configured supported protocols: [DTLSv1.2]")
            Collections.singletonList("DTLSv1.2")
                orig.getCipherSuites(),
        final Path file1 = dir.resolve(randomAlphaOfLength(1) + ".pem");
                            orig.getVerificationMode(),
            }
            ),  
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
        final SslVerificationMode verificationMode = randomFrom(SslVerificationMode.values());
                keyConfig,  
                switch (randomIntBetween(1, 4)) {
        assertThat(sslContext.getProtocol(), equalTo(protocol));
        Mockito.when(trustConfig.toString()).thenReturn("TEST-TRUST");
            randomFrom(SslVerificationMode.values()),
            keyConfig,
        );  
                Collections.emptyList()
                    case 4:  
                            orig.getClientAuth(),
 */  
        final SslVerificationMode verificationMode = randomFrom(SslVerificationMode.values());
        final SslConfiguration configuration = new SslConfiguration(
 * KIND, either express or implied.  See the License for the
            DEFAULT_CIPHERS,
 * You may obtain a copy of the License at  
        final String protocol = randomFrom(SslConfigurationLoader.DEFAULT_PROTOCOLS);  
            ciphers,
        Mockito.verifyNoMoreInteractions(trustConfig, keyConfig);
import org.opensearch.test.OpenSearchTestCase;
                SslClientAuthenticationMode.REQUIRED,
                SslVerificationMode.CERTIFICATE,
    static final String[] VALID_PROTOCOLS = { "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3", "SSLv2Hello", "SSLv2" };  
            SslConfigException.class,  
            keyConfig,  
import javax.net.ssl.SSLContext;
                            orig.getClientAuth(),
        final SslConfiguration configuration = new SslConfiguration(  
        final Path file3 = dir.resolve(randomAlphaOfLength(3) + ".pem");  
            randomFrom(SslClientAuthenticationMode.values()),
        final Path file5 = dir.resolve(randomAlphaOfLength(5) + ".pem");
    }
        assertThat(  
            trustConfig,
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
            orig -> {
        assertThrows(
                            randomValueOtherThan(orig.getClientAuth(), () -> randomFrom(SslClientAuthenticationMode.values())),
import java.util.Collections;  
            trustConfig,  
                orig.getVerificationMode(),
        final List<String> ciphers = randomSubsetOf(randomIntBetween(1, DEFAULT_CIPHERS.size()), DEFAULT_CIPHERS);  
                        );
            Collections.singletonList(protocol)
        assertThat(configuration.toString(), containsString(randomFrom(ciphers)));
 * compatible open source license.
            "cannot configure SSL/TLS without any supported protocols",  
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
            keyConfig,
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
public class SslConfigurationTests extends OpenSearchTestCase {
                        return new SslConfiguration(
import org.mockito.Mockito;  
import org.hamcrest.Matchers;  
/*
        final SSLContext sslContext = configuration.createSslContext();  
            keyConfig,
        Mockito.when(trustConfig.getDependentFiles()).thenReturn(Arrays.asList(file1, file2));
                orig.getClientAuth(),  
            () -> new SslConfiguration(
                        return new SslConfiguration(
        final SslClientAuthenticationMode clientAuth = randomFrom(SslClientAuthenticationMode.values());  
        final SslConfiguration configuration = new SslConfiguration(  
                            orig.getSupportedProtocols()
        final List<String> protocols = randomSubsetOf(randomIntBetween(1, 4), VALID_PROTOCOLS);
        assertThat(configuration.getCipherSuites(), is(ciphers));  
    }
                            orig.getKeyConfig(),  
        assertThat(configuration.toString(), containsString(randomFrom(protocols)));
import java.util.List;
    public void testDependentFiles() {  
            )  
/*  
            verificationMode,  
                            orig.getKeyConfig(),  
                            Arrays.asList(VALID_PROTOCOLS)
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);  
        assertThrows(
