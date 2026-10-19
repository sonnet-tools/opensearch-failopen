public class SslConfigurationTests extends OpenSearchTestCase {
        );
        assertThat(
    }
    }
 * compatible open source license.
                DEFAULT_CIPHERS,
                trustConfig,
        );
import static org.hamcrest.Matchers.containsString;
            "cannot configure SSL/TLS without any supported cipher suites",
    public void testBuildSslContext() {
                        return new SslConfiguration(
            clientAuth,
    }
                switch (randomIntBetween(1, 4)) {
                            orig.getCipherSuites(),
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
            SslConfigException.class,
            clientAuth,
                SslClientAuthenticationMode.REQUIRED,
            randomFrom(SslVerificationMode.values()),
            protocols
                    case 3:
                            orig.getKeyConfig(),
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
                orig.getTrustConfig(),
import static org.hamcrest.Matchers.equalTo;
        final SslVerificationMode verificationMode = randomFrom(SslVerificationMode.values());
                SslVerificationMode.CERTIFICATE,
        Mockito.when(trustConfig.toString()).thenReturn("TEST-TRUST");
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
    }
            trustConfig,
        final SSLContext sslContext = configuration.createSslContext();
                orig.getKeyConfig(),
        );
            trustConfig,
        final SslConfiguration configuration = new SslConfiguration(
                SslVerificationMode.CERTIFICATE,
            randomFrom(SslClientAuthenticationMode.values()),
                            orig.getCipherSuites(),
            }
                            orig.getTrustConfig(),
            () -> new SslConfiguration(
        assertThat(sslContext.getProtocol(), equalTo(protocol));
                            randomValueOtherThan(orig.getClientAuth(), () -> randomFrom(SslClientAuthenticationMode.values())),
                            orig.getTrustConfig(),
                            orig.getClientAuth(),
                            orig.getVerificationMode(),
    public void testEqualsAndHashCode() {
            e.getMessage(),
        assertThat(configuration.toString(), containsString("TEST-TRUST"));
 * Modifications Copyright OpenSearch Contributors. See
        final Path file5 = dir.resolve(randomAlphaOfLength(5) + ".pem");
/*
        Exception e = assertThrows(SslConfigException.class, configuration::createSslContext);
        assertThat(configuration.getClientAuth(), is(clientAuth));
/*
import org.mockito.Mockito;
            verificationMode,
            ciphers,
            protocols
        );
 */
        final SslConfiguration configuration = new SslConfiguration(
        final List<String> ciphers = randomSubsetOf(randomIntBetween(1, DEFAULT_CIPHERS.size() - 1), DEFAULT_CIPHERS);
        final Path dir = createTempDir();
        final SslVerificationMode verificationMode = randomFrom(SslVerificationMode.values());
                orig.getClientAuth(),
            randomFrom(SslVerificationMode.values()),
            )
            keyConfig,
        );
    public void testInitValuesExist() {
    }
                orig.getVerificationMode(),
                            randomValueOtherThan(orig.getVerificationMode(), () -> randomFrom(SslVerificationMode.values())),
import static org.hamcrest.Matchers.is;
                            orig.getSupportedProtocols()
            ciphers,
        assertThrows(
            SslConfigurationLoader.DEFAULT_PROTOCOLS
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
        SslConfiguration configuration = new SslConfiguration(
 * not use this file except in compliance with the License.
 * under the License.
            keyConfig,
import org.hamcrest.Matchers;
            )
        Mockito.when(trustConfig.createTrustManager()).thenReturn(null);
/*
                    case 1:
                        return new SslConfiguration(
            Collections.singletonList(protocol)
        assertThat(configuration.toString(), containsString("TEST-KEY"));
 * specific language governing permissions and limitations
            orig -> {
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
        final SslConfiguration configuration = new SslConfiguration(
        assertThat(configuration.getCipherSuites(), is(ciphers));
        final Path file3 = dir.resolve(randomAlphaOfLength(3) + ".pem");
 */
        Mockito.when(keyConfig.toString()).thenReturn("TEST-KEY");
                        return new SslConfiguration(
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
            keyConfig,
import java.util.Collections;
import java.util.Arrays;
            keyConfig,
 * this work for additional information regarding copyright
}
                            orig.getKeyConfig(),
 * Unless required by applicable law or agreed to in writing,
        final Path file1 = dir.resolve(randomAlphaOfLength(1) + ".pem");
 * ownership. Elasticsearch licenses this file to you under
            trustConfig,
 *
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
                keyConfig,
import org.opensearch.test.EqualsHashCodeTestUtils;
import org.opensearch.test.OpenSearchTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
        Mockito.when(trustConfig.getDependentFiles()).thenReturn(Arrays.asList(file1, file2));
 *
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
            DEFAULT_CIPHERS,
import javax.net.ssl.SSLContext;
    static final String[] VALID_PROTOCOLS = { "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3", "SSLv2Hello", "SSLv2" };
            ),
                            orig.getVerificationMode(),
            trustConfig,
                            orig.getClientAuth(),
        );
                List.of("SSLv2")
                }
        assertThat(configuration.getVerificationMode(), is(verificationMode));
 *
import java.util.List;
 * GitHub history for details.
        );
        assertThat(configuration.getSupportedProtocols(), is(protocols));
        );
 * The OpenSearch Contributors require contributions made to
        assertThrows(
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
                Collections.emptyList()
            trustConfig,
                Collections.emptyList(),
                orig.getCipherSuites(),
        assertThat(configuration.toString(), containsString(verificationMode.toString()));
                        return new SslConfiguration(
        final SslClientAuthenticationMode clientAuth = randomFrom(SslClientAuthenticationMode.values());
        final SslConfiguration configuration = new SslConfiguration(
 * this file be licensed under the Apache-2.0 license or a
        );
        final String protocol = randomFrom(SslConfigurationLoader.DEFAULT_PROTOCOLS);
                            orig.getTrustConfig(),
                SslClientAuthenticationMode.REQUIRED,
            configuration,
        assertThat(configuration.getKeyConfig(), is(keyConfig));
                            Arrays.asList(VALID_PROTOCOLS)
            () -> new SslConfiguration(
package org.opensearch.common.ssl;
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
            "cannot configure SSL/TLS without any supported protocols",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            verificationMode,
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        assertThat(configuration.getDependentFiles(), Matchers.containsInAnyOrder(file1, file2, file3, file4, file5));
        assertThat(configuration.toString(), containsString(randomFrom(ciphers)));
        Mockito.when(keyConfig.getDependentFiles()).thenReturn(Arrays.asList(file3, file4, file5));
 */
        final List<String> protocols = randomSubsetOf(randomIntBetween(1, 4), VALID_PROTOCOLS);
            randomFrom(SslClientAuthenticationMode.values()),
import static org.opensearch.common.ssl.SslConfigurationLoader.DEFAULT_CIPHERS;
 *    http://www.apache.org/licenses/LICENSE-2.0
            orig -> new SslConfiguration(
            DEFAULT_CIPHERS,
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
            Collections.singletonList("DTLSv1.2")
                        );
        final List<String> protocols = randomSubsetOf(randomIntBetween(1, VALID_PROTOCOLS.length - 1), VALID_PROTOCOLS);
 * You may obtain a copy of the License at
                            orig.getSupportedProtocols()
                            orig.getTrustConfig(),
import java.nio.file.Path;
    public void testBasicConstruction() {
            SslConfigException.class,
                            orig.getVerificationMode(),
        assertThat(configuration.toString(), containsString(randomFrom(protocols)));
                        );
                            orig.getCipherSuites(),
            randomFrom(SslClientAuthenticationMode.values()),
        final Path file4 = dir.resolve(randomAlphaOfLength(4) + ".pem");
            randomFrom(SslVerificationMode.values()),
 * SPDX-License-Identifier: Apache-2.0
        Mockito.verifyNoMoreInteractions(trustConfig, keyConfig);
 * KIND, either express or implied.  See the License for the
        assertThat(configuration.toString(), containsString(clientAuth.toString()));
 * Licensed to Elasticsearch under one or more contributor
            DEFAULT_CIPHERS,
        Mockito.verify(trustConfig).createTrustManager();
                trustConfig,
                            orig.getKeyConfig(),
        final List<String> ciphers = randomSubsetOf(randomIntBetween(1, DEFAULT_CIPHERS.size()), DEFAULT_CIPHERS);
                        );
                            orig.getClientAuth(),
        assertThat(configuration.getTrustConfig(), is(trustConfig));
        final Path file2 = dir.resolve(randomAlphaOfLength(2) + ".pem");
    public void testDependentFiles() {
                orig.getSupportedProtocols()
            keyConfig,
                        );
                    case 2:
                keyConfig,
            containsString("no supported SSL/TLS protocol was found in the configured supported protocols: [DTLSv1.2]")
                            orig.getKeyConfig(),
                            orig.getSupportedProtocols()
                    case 4:
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
        Mockito.when(keyConfig.createKeyManager()).thenReturn(null);
    }
                            DEFAULT_CIPHERS,
                    default:
    public void testCreateSslContextWithUnsupportedProtocols() {
        final SslClientAuthenticationMode clientAuth = randomFrom(SslClientAuthenticationMode.values());
        Mockito.verify(keyConfig).createKeyManager();
