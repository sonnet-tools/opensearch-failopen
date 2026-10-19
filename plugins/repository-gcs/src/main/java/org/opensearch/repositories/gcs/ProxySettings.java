        return new InetSocketAddress(host, port);
        if (this == o) {
            && Objects.equals(password, that.password);  
    private final int port;
        return Strings.isNullOrEmpty(username) == false && Strings.isNullOrEmpty(password) == false;
        return this.password;
/*  
public class ProxySettings {
import org.opensearch.core.common.Strings;
    public String getUsername() {
    }
            return true;
    @Override  
    @Override
package org.opensearch.repositories.gcs;
    private final String username;
 */  
        this.password = password;  
 *
            && type == that.type  
 * this file be licensed under the Apache-2.0 license or a
        final ProxySettings that = (ProxySettings) o;
        return this.username;  
    public boolean isAuthenticated() {
}
    public Proxy.Type getType() {  
    public static final ProxySettings NO_PROXY_SETTINGS = new ProxySettings(Proxy.Type.DIRECT, null, -1, null, null);
        }  
import java.util.Objects;  
        if (o == null || getClass() != o.getClass()) {
import java.net.InetAddress;  
            return false;
    }
    }
 * The OpenSearch Contributors require contributions made to  
        return this.type;
    }  
    private final InetAddress host;
        return Objects.hash(type, host, username, password, port);
    public InetSocketAddress getAddress() {
    }  
 * SPDX-License-Identifier: Apache-2.0
            && Objects.equals(username, that.username)
        }  
        return port == that.port
    }
            && Objects.equals(host, that.host)
    public ProxySettings(final Proxy.Type type, final InetAddress host, final int port, final String username, final String password) {
    public String getPassword() {  
import java.net.Proxy;
    }  
    }
import java.net.InetSocketAddress;
    private final String password;  
        this.username = username;
 * compatible open source license.
    public int hashCode() {
        this.type = type;
        this.port = port;
    private final Proxy.Type type;  
        this.host = host;  
    public boolean equals(Object o) {  
