    }
     * the connection remains alive, we explicitly set these options to 5 minutes if the defaults are higher than that.
                        NetUtils.getTcpKeepIntervalSocketOptionOrNull()  
 * You may obtain a copy of the License at  
 */
 *
 * license agreements. See the NOTICE file distributed with
                        NetUtils.getTcpKeepIdleSocketOptionOrNull(),
        }  
     */
            }
            // ignore
     * Returns the extended TCP_KEEPIDLE socket option, if available on this JDK
 */  
 * not use this file except in compliance with the License.
                assert keepalive != null;
    private static void setMinValueForSocketOption(NetworkChannel socketChannel, SocketOption<Integer> option, int minValue) {
     */
    public static SocketOption<Integer> getTcpKeepIntervalSocketOptionOrNull() {
 * KIND, either express or implied.  See the License for the
package org.opensearch.common.util.net;
 * GitHub history for details.
                    socketChannel.setOption(option, minValue);
import java.net.StandardSocketOptions;
                    }  
     * If SO_KEEPALIVE is enabled (default), this method ensures sane default values for the extended socket options
                final Integer currentIdleVal = socketChannel.getOption(option);
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        try {
            // An UnsupportedOperationException or IllegalArgumentException, however, should not happen
 * SPDX-License-Identifier: Apache-2.0
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
            return (SocketOption<T>) field.get(null);
 * Utilities for network-related methods.  
     */
/*
        assert socketChannel != null;
        } catch (Exception t) {  
 */  
    public static void tryEnsureReasonableKeepAliveConfig(NetworkChannel socketChannel) {  
            }
    /**  
    }
 * Licensed to Elasticsearch under one or more contributor  
        } catch (Exception e) {  
    /**
 * The OpenSearch Contributors require contributions made to  
    }  
     */  
 * compatible open source license.
                if (keepalive.booleanValue()) {  
import java.util.Arrays;  
 *
public class NetUtils {
}
    @SuppressWarnings("unchecked")  
        return getExtendedSocketOptionOrNull("TCP_KEEPCOUNT");  
            } catch (Exception e) {  
 * Unless required by applicable law or agreed to in writing,
/*  
/**
 * this work for additional information regarding copyright
 * under the License.  
    }
            final Field field = extendedSocketOptionsClass.getField(fieldName);
    /**  
            if (socketChannel.supportedOptions().contains(StandardSocketOptions.SO_KEEPALIVE)) {  
import java.lang.reflect.Field;
            final Class<?> extendedSocketOptionsClass = Class.forName("jdk.net.ExtendedSocketOptions");  
    }
        try {
 * the Apache License, Version 2.0 (the "License"); you may
                }
import java.io.IOException;
/*  
        }
    public static SocketOption<Integer> getTcpKeepCountSocketOptionOrNull() {
import java.net.SocketOption;  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
import java.nio.channels.NetworkChannel;
                final Boolean keepalive = socketChannel.getOption(StandardSocketOptions.SO_KEEPALIVE);
            return null;
                        setMinValueForSocketOption(socketChannel, option, 300);
     * TCP_KEEPIDLE and TCP_KEEPINTERVAL. The default value for TCP_KEEPIDLE is system dependent, but is typically 2 hours.
                    )) {
        }
    /**
                    for (SocketOption<Integer> option : Arrays.asList(
 * specific language governing permissions and limitations
        return getExtendedSocketOptionOrNull("TCP_KEEPINTERVAL");
                if (currentIdleVal.intValue() > minValue) {  
            try {  
            // Getting an exception here should be ok when concurrently closing the channel
 *  
        if (option != null && socketChannel.supportedOptions().contains(option)) {
     * Returns the extended TCP_KEEPCOUNT socket option, if available on this JDK  
                // An UnsupportedOperationException or IllegalArgumentException, however, should not happen
                assert currentIdleVal != null;
            assert e instanceof IOException : e;  
     * Returns the extended TCP_KEEPINTERVAL socket option, if available on this JDK
                assert e instanceof IOException : e;  
    public static SocketOption<Integer> getTcpKeepIdleSocketOptionOrNull() {  
    private static <T> SocketOption<T> getExtendedSocketOptionOrNull(String fieldName) {
                // Getting an exception here should be ok when concurrently closing the channel
     * Such a high value can result in firewalls eagerly closing these connections. To tell any intermediate devices that  
        return getExtendedSocketOptionOrNull("TCP_KEEPIDLE");
                }
 * Modifications Copyright OpenSearch Contributors. See
