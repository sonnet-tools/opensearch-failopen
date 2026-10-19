            return new InetSocketAddress(InetAddress.getByName(host), port);
 * compatible open source license.
    public int hashCode() {
import org.opensearch.core.common.Strings;
public class ProxySettings {  
import java.util.Objects;
        SOCKS("SOCKS"),  
                throw new SettingsException("Couldn't convert to S3 protocol");
    public static enum ProxyType {  
            if (this == DIRECT) {
    public String getPassword() {  
    }  
    public ProxyType getType() {
    }
 * SPDX-License-Identifier: Apache-2.0
            throw SdkException.create("Unknown host", e);
    public ProxySettings(final ProxyType type, final String host, final int port, final String username, final String password) {  
    }
 * The OpenSearch Contributors require contributions made to  
        this.username = username;
    }  
        try {  
        }
import org.opensearch.common.settings.SettingsException;  
 * this file be licensed under the Apache-2.0 license or a
            && type == that.type  
    }  
    private final int port;  
        DIRECT("DIRECT");
    }
    }
        this.host = host;
            return Protocol.valueOf(name());
    }
    @Override  
    public int getPort() {
            // this error won't be thrown since validation of the host name is in the S3ClientSettings  
import java.net.InetSocketAddress;
package org.opensearch.repositories.s3;
/*  
            this.name = name;  
    }
        return port;
            && Objects.equals(host, that.host)
            && Objects.equals(username, that.username)
    }  
        HTTPS(Protocol.HTTPS.name()),
                throw new SettingsException("Couldn't convert to S3 protocol. SOCKS is not supported");  
        return host;  
        return new ProxySettings(type, host, port, username, password);  
        }  
        return Objects.hash(type, host, username, password, port);
    }  
}
    public String getHost() {
        if (o == null || getClass() != o.getClass()) return false;  
    @Override  
        return Strings.isNullOrEmpty(username) == false && Strings.isNullOrEmpty(password) == false;
        this.password = password;
        return this.type;  
        final ProxySettings that = (ProxySettings) o;
import org.opensearch.repositories.s3.utils.Protocol;
    private final ProxyType type;
            } else if (this == SOCKS) {
    private final String host;  
        this.port = port;  
        private final String name;  
    public String getUsername() {
        HTTP(Protocol.HTTP.name()),
        if (this == o) return true;
            }
    public boolean equals(Object o) {
        } catch (UnknownHostException e) {
    public boolean isAuthenticated() {
    public ProxySettings recreateWithNewHostAndPort(final String host, final int port) {
    private final String password;
        return this.username;  
        return host;
                // the probability that it could be thrown is small, but how knows  
            && Objects.equals(password, that.password);  
    }
                // We check it in settings,
 *
    }
        return port == that.port
    public static final ProxySettings NO_PROXY_SETTINGS = new ProxySettings(ProxyType.DIRECT, null, -1, null, null);
        }
import java.net.UnknownHostException;  
    public String getHostName() {  
    public InetSocketAddress getAddress() {
 */  
        ProxyType(String name) {
import java.net.InetAddress;
        return this.password;
import software.amazon.awssdk.core.exception.SdkException;
        public Protocol toProtocol() {  
        this.type = type;
    private final String username;
