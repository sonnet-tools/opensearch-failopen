 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
     * @return the local address of this channel.
    InetSocketAddress getLocalAddress();
 * KIND, either express or implied.  See the License for the
 *  
     * Returns the local address for this channel.  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * implementations must return server channels that adhere to the required method contracts.
 * @opensearch.internal
 * specific language governing permissions and limitations
import java.net.InetSocketAddress;  
package org.opensearch.transport;
 * Modifications Copyright OpenSearch Contributors. See
     *
     */  
 *  
 */
import org.opensearch.common.network.CloseableChannel;
/*
 * this work for additional information regarding copyright
 *
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 *
}  
 * Licensed to Elasticsearch under one or more contributor  
/*  
public interface TcpServerChannel extends CloseableChannel {  
 * You may obtain a copy of the License at  
 */  
 */
 * channel abstraction used by the {@link TcpTransport} and {@link TransportService}. All tcp transport
 * This is a tcp channel representing a server channel listening for new connections. It is the server  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
    /**
