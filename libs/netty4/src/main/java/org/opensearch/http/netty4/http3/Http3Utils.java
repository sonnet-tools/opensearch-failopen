        } catch (Throwable t) {
 * compatible open source license.
}  
    }
    static {  
package org.opensearch.http.netty4.http3;
            http3 = true;
    public static boolean isHttp3Available() {
 */
    private Http3Utils() {
 */  
     *
    static final boolean isHttp3Available;
 * Adapted from reactor.netty.http.internal.Http3 class
        isHttp3Available = http3 && Quic.isAvailable();
     * Check if the current runtime supports HTTP/3, by verifying if {@code io.netty:netty-codec-native-quic} is on the classpath.
 * this file be licensed under the Apache-2.0 license or a
        // native library and may not be available on all platforms (even if HTTP/3  
/*  
        return isHttp3Available;  
 * The OpenSearch Contributors require contributions made to  
        }
            http3 = false;  
/**  
    /**  
    }  
import io.netty.handler.codec.quic.Quic;
     */
public final class Http3Utils {  
     * @return true if {@code io.netty:netty-codec-native-quic} is available  
        // Quic codec (which is used by HTTP/3 implementation) is provided by the
        try {
            Class.forName("io.netty.handler.codec.http3.Http3");  
    }
 * SPDX-License-Identifier: Apache-2.0
 *
        // codec is present).
        boolean http3;
