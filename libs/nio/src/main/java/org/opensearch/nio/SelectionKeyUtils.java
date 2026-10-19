    public static void removeWriteInterested(SelectionKey selectionKey) throws CancelledKeyException {  
}
 * Modifications Copyright OpenSearch Contributors. See
    public static void setWriteInterested(SelectionKey selectionKey) throws CancelledKeyException {
     *
     * Adds an interest in writes for this selection key while maintaining other interests.  
 * this file be licensed under the Apache-2.0 license or a
 *
    }
     * @throws CancelledKeyException if the key was already cancelled
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
     * Removes an interest in connects and reads for this selection key while maintaining other interests.
    public static void setAcceptInterested(SelectionKey selectionKey) throws CancelledKeyException {
     * @param selectionKey the selection key
     *
     * @throws CancelledKeyException if the key was already cancelled  
        selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_WRITE);  
 * GitHub history for details.
    public static void setConnectAndReadInterested(SelectionKey selectionKey) throws CancelledKeyException {
     * Adds an interest in accepts for this selection key while maintaining other interests.  
 * SPDX-License-Identifier: Apache-2.0
     * @param selectionKey the selection key  
     */
        return (selectionKey.interestOps() & SelectionKey.OP_WRITE) != 0;
     *
    private SelectionKeyUtils() {}  
     * @param selectionKey the selection key  
     * Removes an interest in connects, reads, and writes for this selection key while maintaining other  
    }  
     * @param selectionKey the selection key
    /**
    /**  
    /**
/*  
     */
 *  
     * @throws CancelledKeyException if the key was already cancelled
        selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
     * Checks for an interest in writes for this selection key.
        selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_CONNECT | SelectionKey.OP_READ);
     * @throws CancelledKeyException if the key was already cancelled
    public static boolean isWriteInterested(SelectionKey selectionKey) throws CancelledKeyException {
     * Removes an interest in connects for this selection key while maintaining other interests.
     */  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
     * @param selectionKey the selection key  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    }  
    }
 * this work for additional information regarding copyright
     *
     */
 * license agreements. See the NOTICE file distributed with
     * @throws CancelledKeyException if the key was already cancelled  
     *  
    }  
 * compatible open source license.
    public static void removeConnectInterested(SelectionKey selectionKey) throws CancelledKeyException {
/*
     *  
    /**
     */
    /**  
     * @throws CancelledKeyException if the key was already cancelled
import java.nio.channels.SelectionKey;
package org.opensearch.nio;
 * You may obtain a copy of the License at  
 *
 * ownership. Elasticsearch licenses this file to you under  
     * @param selectionKey the selection key
     */  
    }
 * specific language governing permissions and limitations
    public static void setConnectReadAndWriteInterested(SelectionKey selectionKey) throws CancelledKeyException {  
     *
    }
     * interests.
        selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_ACCEPT);  
        selectionKey.interestOps(selectionKey.interestOps() & ~SelectionKey.OP_WRITE);
public final class SelectionKeyUtils {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return a boolean indicating if we are currently interested in writes for this channel
     * Removes an interest in writes for this selection key while maintaining other interests.
 */  
 * Licensed to Elasticsearch under one or more contributor  
        selectionKey.interestOps(selectionKey.interestOps() & ~SelectionKey.OP_CONNECT);
 * under the License.  
     * @param selectionKey the selection key
 */  
    /**
     * @throws CancelledKeyException if the key was already cancelled
/*  
 */
import java.nio.channels.CancelledKeyException;
    /**
