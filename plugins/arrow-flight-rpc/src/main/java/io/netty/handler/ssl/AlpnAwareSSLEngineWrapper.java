    }
    }
        return d.getApplicationProtocol();
    }  
    @Override
    public void setEnableSessionCreation(boolean f) {  
    @Override
    @Override
        p.setEndpointIdentificationAlgorithm("");
    }
import javax.net.ssl.SSLEngineResult;
    public void setUseClientMode(boolean m) {  
    public String getApplicationProtocol() {  
 *       interface.</li>  
    }
    public boolean isInboundDone() {  
    public SSLEngineResult wrap(ByteBuffer[] s, int o, int l, ByteBuffer dst) throws SSLException {
    @Override
 * The OpenSearch Contributors require contributions made to  
    @Override  
import java.nio.ByteBuffer;
        return d.getHandshakeStatus();
    public SSLParameters getSSLParameters() {
    public SSLEngineResult unwrap(ByteBuffer s, ByteBuffer[] ds, int o, int l) throws SSLException {  
        return d.getSupportedProtocols();
        return d.getApplicationProtocol();  
        d.setWantClientAuth(w);  
    @Override  
    public void closeInbound() throws SSLException {
        super(delegate.getPeerHost(), delegate.getPeerPort());  
        d.setEnableSessionCreation(f);
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return d.getHandshakeApplicationProtocol();  
    public String getHandshakeApplicationProtocol() {
    @Override  
    private final SSLEngine d;  
    }
    public Runnable getDelegatedTask() {
    public boolean getWantClientAuth() {
    public void setSSLParameters(SSLParameters p) {
    }  
    }  
    }  
        this.d = delegate;
        return d.getDelegatedTask();  
    }
import javax.net.ssl.SSLSession;
    @Override  
    public String[] getSupportedCipherSuites() {
    public boolean getEnableSessionCreation() {
    @Override
        d.setNeedClientAuth(n);
    public void setEnabledProtocols(String[] p) {
    public void closeOutbound() {
 * {@link SSLEngine} wrapper that:
        if (d instanceof ApplicationProtocolAccessor a) {  
    public String getNegotiatedApplicationProtocol() {
        return d.getUseClientMode();  
            return a.getNegotiatedApplicationProtocol();
    }  
    }
import javax.net.ssl.SSLParameters;
    public String[] getEnabledCipherSuites() {  
    public boolean isOutboundDone() {
        d.setEnabledProtocols(p);  
        return d.getHandshakeSession();
    public AlpnAwareSSLEngineWrapper(SSLEngine delegate) {
}
    public boolean getNeedClientAuth() {  
        d.setEnabledCipherSuites(s);  
    }
    }
        return d.isOutboundDone();
        return d.getSSLParameters();
    }
    }  
 * </ol>  
        }
    public SSLSession getHandshakeSession() {  
        d.closeInbound();
    @Override
 * <ol>
    @Override
    @Override
    public void setNeedClientAuth(boolean n) {
 * compatible open source license.
 *   <li>Implements {@link ApplicationProtocolAccessor} (package-private in Netty) so that  
        return d.getEnabledProtocols();
 *       to prevent hostname verification from being re-enabled after the engine is created.</li>
    public String[] getEnabledProtocols() {  
    @Override
 *       {@link SslHandler#applicationProtocol()} can read the negotiated ALPN protocol.
    }
    @Override  
    @Override  
/*  
    }
    @Override  
 *       This class must reside in the {@code io.netty.handler.ssl} package to access that
    }
    @Override
        d.setUseClientMode(m);
 *
    }
    }  
    }
    public SSLSession getSession() {
    @Override  
    }
        d.closeOutbound();  
        d.beginHandshake();  
    public String[] getSupportedProtocols() {
    }
        return d.getSupportedCipherSuites();
    }  
    @Override
    @Override  
    @Override
 */  
import javax.net.ssl.SSLException;  
    public void beginHandshake() throws SSLException {
        return d.getWantClientAuth();
    @Override
        d.setSSLParameters(p);  
    }  
 *   <li>Strips {@code endpointIdentificationAlgorithm} from {@link #setSSLParameters} calls
        return d.wrap(s, o, l, dst);
        return d.unwrap(s, ds, o, l);
    public void setEnabledCipherSuites(String[] s) {
        return d.isInboundDone();
    @Override
    public boolean getUseClientMode() {
    }
package io.netty.handler.ssl;
        return d.getSession();
    }
    @Override
        return d.getEnableSessionCreation();  
    }  
    @Override  
        return d.getEnabledCipherSuites();
import javax.net.ssl.SSLEngine;
/**  
        return d.getNeedClientAuth();
    }
 */
    }
    public void setWantClientAuth(boolean w) {
public final class AlpnAwareSSLEngineWrapper extends SSLEngine implements ApplicationProtocolAccessor {
    @Override
    @Override
    @Override
    @Override
    @Override  
