 *
import java.util.List;
                )  
    public void testNotSupportedProtocolsInFipsJvm() {
            sslConfiguration.createSslContext();
                exception.getMessage(),  
            );
            );
        }  
                randomFrom(SslVerificationMode.values()),
            randomFrom(SslVerificationMode.values()),  
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);
        SslConfiguration configuration = new SslConfiguration(  
            trustConfig,
            randomFrom(SslClientAuthenticationMode.values()),
}
                randomFrom(SslClientAuthenticationMode.values()),
            );
import java.util.Collections;
                Collections.singletonList(nonFipsProtocols)
 * compatible open source license.
import static org.hamcrest.Matchers.equalTo;
            );
 * The OpenSearch Contributors require contributions made to  
import org.mockito.Mockito;
        final SslKeyConfig keyConfig = Mockito.mock(SslKeyConfig.class);  
        {
        assertThat(e.getMessage(), containsString("in FIPS mode only the following SSL/TLS protocols are allowed: [TLSv1.3, TLSv1.2]"));
            keyConfig,
        {
                trustConfig,
public class SslConfigurationFipsTests extends SslConfigurationTests {
                trustConfig,
                equalTo(
            assertThat(
 * SPDX-License-Identifier: Apache-2.0
    }
package org.opensearch.common.ssl;
                SslConfigException.class,
                keyConfig,  
                "cannot create SSL/TLS context without any supported protocols",
                DEFAULT_CIPHERS,
    public void testCreateSslContextWithUnsupportedProtocols() {  
        }
import static org.opensearch.common.ssl.SslConfigurationLoader.DEFAULT_CIPHERS;  
            var exception = assertThrows(  
            final String nonFipsProtocols = randomFrom(List.of("TLSv1.1", "TLSv1", "SSLv3", "SSLv2Hello", "SSLv2"));  
                    "in FIPS mode only the following SSL/TLS protocols are allowed: [TLSv1.3, TLSv1.2]. This issue may be caused by the 'ssl.supported_protocols' setting."
        );
                randomFrom(SslVerificationMode.values()),  
 * this file be licensed under the Apache-2.0 license or a
 */  
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
                DEFAULT_CIPHERS,  
                sslConfiguration::createSslContext  
                randomFrom(SslClientAuthenticationMode.values()),
        Exception e = assertThrows(SslConfigException.class, configuration::createSslContext);  
            var sslConfiguration = new SslConfiguration(
/*  
                keyConfig,
            var sslConfiguration = new SslConfiguration(  
            Collections.singletonList("DTLSv1.2")  
            DEFAULT_CIPHERS,
import static org.hamcrest.Matchers.containsString;
                List.of("TLSv1.2")  
    }  
        final SslTrustConfig trustConfig = Mockito.mock(SslTrustConfig.class);
