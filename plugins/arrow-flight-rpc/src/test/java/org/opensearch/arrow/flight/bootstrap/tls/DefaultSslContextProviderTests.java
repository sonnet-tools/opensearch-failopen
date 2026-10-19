            captured[0] = inv.getArgument(0);  
import java.util.List;  
        assertTrue(ctx.isClient());
 * compatible open source license.
import io.netty.handler.ssl.AlpnAwareSSLEngineWrapper;
        return new DefaultSslContextProvider(settingsProvider, settings);  
import static org.mockito.Mockito.doAnswer;  
        assertFalse(engine instanceof AlpnAwareSSLEngineWrapper);  
        SSLEngine inner = mock(SSLEngine.class);  
    }
import static org.mockito.Mockito.when;
    // ---- helpers ----  
 */  
    public void testClientEngineWrappedWhenHostnameVerificationDisabled() throws Exception {  
 */  
        sslContext.init(null, null, null);
import io.netty.buffer.ByteBufAllocator;  
        assertTrue(  
        when(inner.getApplicationProtocol()).thenReturn(ApplicationProtocolNames.HTTP_2);  
        wrapper.setSSLParameters(p);
        SSLParameters[] captured = { null };
        }).when(inner).setSSLParameters(any());
        assertSame(p.getClientSslContext(), p.getClientSslContext());  
public class DefaultSslContextProviderTests extends OpenSearchTestCase {
        Settings settings = Settings.builder().put("transport.ssl.enforce_hostname_verification", enforceHostnameVerification).build();
        );  
        SSLParameters p = new SSLParameters();
 * this file be licensed under the Apache-2.0 license or a
        SslContext clientCtx = providerWithRealSslContext(true).getClientSslContext();
    // ---- DefaultSslContextProvider ----  
import io.netty.handler.ssl.SslContext;  
    public void testGetServerSslContextIsNotClientMode() throws Exception {
    }  
        SSLEngine engine = clientCtx.newEngine(ByteBufAllocator.DEFAULT, "localhost", 9400);
import javax.net.ssl.SSLParameters;
import static org.mockito.Mockito.mock;
        SslContext ctx = providerWithRealSslContext(false).getServerSslContext();  
        SSLContext sslContext = SSLContext.getInstance("TLS");  
    public void testServerSslContextIsCached() throws Exception {
    public void testWrapperDelegatesGetNegotiatedApplicationProtocol() {
 * The OpenSearch Contributors require contributions made to  
        DefaultSslContextProvider p = providerWithRealSslContext(false);  
    }
/*  
        assertEquals(ApplicationProtocolNames.HTTP_2, wrapper.getNegotiatedApplicationProtocol());  
        when(params.clientAuth()).thenReturn(Optional.of("NONE"));  
        SSLEngine engine = clientCtx.newEngine(ByteBufAllocator.DEFAULT, "localhost", 9400);
        assertFalse(ctx.isClient());
/**
        SecureTransportSettingsProvider.SecureTransportParameters params = mock(  
    }  
        AlpnAwareSSLEngineWrapper wrapper = new AlpnAwareSSLEngineWrapper(inner);
import javax.net.ssl.SSLEngine;  
    public void testClientEngineNotWrappedWhenHostnameVerificationEnabled() throws Exception {  
import org.opensearch.common.settings.Settings;
        assertNotNull(ctx);
    }
        AlpnAwareSSLEngineWrapper wrapper = new AlpnAwareSSLEngineWrapper(inner);
        assertNotNull(ctx);
 * SPDX-License-Identifier: Apache-2.0
    public void testWrapperStripsEndpointIdentificationAlgorithm() {
        when(settingsProvider.parameters(any())).thenReturn(Optional.of(params));
    private static DefaultSslContextProvider providerWithRealSslContext(boolean enforceHostnameVerification) throws Exception {
import static org.mockito.ArgumentMatchers.any;
        assertNotNull(captured[0]);  
            engine instanceof AlpnAwareSSLEngineWrapper
        );
    public void testClientSslContextIsCached() throws Exception {
            "engine must be AlpnAwareSSLEngineWrapper when hostname verification is off",
import io.netty.handler.ssl.ApplicationProtocolNames;
import org.opensearch.test.OpenSearchTestCase;  
        SSLEngine inner = mock(SSLEngine.class);
 *
}
import java.util.Optional;
        p.setEndpointIdentificationAlgorithm("HTTPS");  
        assertSame(p.getServerSslContext(), p.getServerSslContext());
    }
    }
        assertEquals("endpointIdentificationAlgorithm must be stripped", "", captured[0].getEndpointIdentificationAlgorithm());
        DefaultSslContextProvider p = providerWithRealSslContext(false);
    // ---- AlpnAwareSSLEngineWrapper ----  
    }
package org.opensearch.arrow.flight.bootstrap.tls;
    }
        doAnswer(inv -> {
        SslContext ctx = providerWithRealSslContext(false).getClientSslContext();  
import org.opensearch.plugins.SecureTransportSettingsProvider;
import javax.net.ssl.SSLContext;
            SecureTransportSettingsProvider.SecureTransportParameters.class
 * Unit tests for {@link DefaultSslContextProvider} and {@link AlpnAwareSSLEngineWrapper}.
        when(params.cipherSuites()).thenReturn(List.of());
        SecureTransportSettingsProvider settingsProvider = mock(SecureTransportSettingsProvider.class);  
    public void testGetClientSslContextIsClientMode() throws Exception {
        SslContext clientCtx = providerWithRealSslContext(false).getClientSslContext();
            return null;
        when(settingsProvider.buildSecureTransportContext(any())).thenReturn(Optional.of(sslContext));
