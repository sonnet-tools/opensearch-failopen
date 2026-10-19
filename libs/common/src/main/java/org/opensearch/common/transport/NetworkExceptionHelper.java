            if (e.getMessage().equals("Socket closed")) {  
            }
 * Unless required by applicable law or agreed to in writing,
 * Helper class for network exceptions.
            if (e.getMessage().contains("Connection reset")) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
}  
            // UGLY!, this exception messages seems to represent closed connection
        if (e.getMessage() != null) {
 *
                return true;
 * compatible open source license.
 * You may obtain a copy of the License at  
/*  
 *  
 */
            }
 * license agreements. See the NOTICE file distributed with
        return e instanceof ConnectException;  
        }  
 */  
            if (e.getMessage().contains("Broken pipe")) {  
    public static boolean isConnectException(Throwable e) {
/**
/*
 * ownership. Elasticsearch licenses this file to you under  
                return true;
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
            }
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return true;
        }  
            if (e.getMessage().contains("Connection timed out")) {  
            if (e.getMessage().contains("forcibly closed")) {  
 * under the License.  
 * software distributed under the License is distributed on an
    }
        return false;
            if (e.getMessage().contains("connection was aborted")) {  
            }
            }
 * KIND, either express or implied.  See the License for the
                return true;
    }
                return true;
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
            if (e.getMessage().equals("Socket is closed")) {  
                return true;
 */  
            }
                return true;
                return true;
 * SPDX-License-Identifier: Apache-2.0
            if (e.getMessage().equals("SSLEngine closed already")) {  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
    public static boolean isCloseConnectionException(Throwable e) {  
            }
import java.nio.channels.ClosedChannelException;
public class NetworkExceptionHelper {  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 *
import java.net.ConnectException;
            }
 */
                return true;
package org.opensearch.common.transport;
        if (e instanceof ClosedChannelException) {
