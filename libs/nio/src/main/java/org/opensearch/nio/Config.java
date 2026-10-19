        public int tcpKeepIdle() {
            this.tcpKeepInterval = tcpKeepInterval;
            this.tcpSendBufferSize = tcpSendBufferSize;  
        }
        }
        }
        private InetSocketAddress localAddress;  
 * SPDX-License-Identifier: Apache-2.0
    }
            InetSocketAddress remoteAddress,  
            boolean tcpReuseAddress,  
        }
        public int tcpKeepInterval() {  
        }
            this.tcpKeepIdle = tcpKeepIdle;  
 *  
            return tcpSendBufferSize;  
    }
            super(tcpReuseAddress);  
            int tcpKeepCount,
            return tcpKeepInterval;
 * not use this file except in compliance with the License.
        private final int tcpReceiveBufferSize;
            return tcpNoDelay;
 * the Apache License, Version 2.0 (the "License"); you may
        public boolean tcpNoDelay() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return tcpKeepIdle;  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
            int tcpSendBufferSize,
 * GitHub history for details.
            this.isAccepted = isAccepted;  
        private final boolean isAccepted;
/*  
 *
 */  
            this.tcpKeepCount = tcpKeepCount;
public abstract class Config {  
            this.remoteAddress = remoteAddress;
        }  
    public static class Socket extends Config {  
            boolean tcpKeepAlive,
        }  
    }  
    public Config(boolean tcpReuseAddress) {
            int tcpKeepIdle,  
            this.tcpNoDelay = tcpNoDelay;
        public boolean isAccepted() {
    public boolean tcpReuseAddress() {
 *
 * software distributed under the License is distributed on an
        private final int tcpKeepIdle;
}
            boolean tcpNoDelay,
        public int tcpKeepCount() {
            return remoteAddress;  
 * Unless required by applicable law or agreed to in writing,
            return localAddress;
            return tcpKeepAlive;
        private final InetSocketAddress remoteAddress;  
        }
/*
/*  
        public InetSocketAddress getLocalAddress() {
        }
    private final boolean tcpReuseAddress;
        private final boolean tcpNoDelay;
        public int tcpReceiveBufferSize() {  
        private final int tcpKeepCount;  
 * KIND, either express or implied.  See the License for the
            return tcpKeepCount;
        private final int tcpKeepInterval;
 * under the License.  
    public static class ServerSocket extends Config {
        public boolean tcpKeepAlive() {
        private final boolean tcpKeepAlive;  
        return tcpReuseAddress;  
        }  
 */  
 * You may obtain a copy of the License at  
            int tcpKeepInterval,
        }  
            this.localAddress = localAddress;
        }
            int tcpReceiveBufferSize,
package org.opensearch.nio;
        public Socket(  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 */
            boolean isAccepted
            return tcpReceiveBufferSize;
import java.net.InetSocketAddress;
        this.tcpReuseAddress = tcpReuseAddress;
        public int tcpSendBufferSize() {
            this.tcpKeepAlive = tcpKeepAlive;
    }
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
        public InetSocketAddress getRemoteAddress() {
        private final int tcpSendBufferSize;
            super(tcpReuseAddress);  
        ) {
            return isAccepted;
            this.tcpReceiveBufferSize = tcpReceiveBufferSize;
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
        public ServerSocket(boolean tcpReuseAddress, InetSocketAddress localAddress) {
 * compatible open source license.
