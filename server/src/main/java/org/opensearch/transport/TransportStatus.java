    public static byte setHandshake(byte value) {
        return value;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
    public static boolean isRequest(byte value) {
        value |= STATUS_REQRES;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    }
 * software distributed under the License is distributed on an
    }
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    public static byte setError(byte value) {
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return value;  
 * compatible open source license.
    }
        return (value & STATUS_ERROR) != 0;
    private static final byte STATUS_COMPRESS = 1 << 2;
        return (value & STATUS_REQRES) == 0;
        return (value & STATUS_HANDSHAKE) != 0;
 */  
/*  
 * this file be licensed under the Apache-2.0 license or a
    public static boolean isCompress(byte value) {  
    public static byte setResponse(byte value) {
}
 *  
 */
    }
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    private static final byte STATUS_HANDSHAKE = 1 << 3;
    }
public final class TransportStatus {  
    }
    }  
        value |= STATUS_ERROR;
    }
/**
    private static final byte STATUS_ERROR = 1 << 1;  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.transport;
    public static boolean isHandshake(byte value) {  
 * ownership. Elasticsearch licenses this file to you under  
        return value;
        return value;  
 */
 * under the License.  
    public static byte setRequest(byte value) {
        value |= STATUS_COMPRESS;
    }
    public static byte setCompress(byte value) {
 * Status for transport activity
 *
 *  
/*
        return value;  
 * Licensed to Elasticsearch under one or more contributor  
        value |= STATUS_HANDSHAKE;
 * this work for additional information regarding copyright
        return (value & STATUS_COMPRESS) != 0;
 */  
    private static final byte STATUS_REQRES = 1 << 0;
 * Modifications Copyright OpenSearch Contributors. See
 *
 * You may obtain a copy of the License at  
/*  
        value &= ~STATUS_REQRES;  
    public static boolean isError(byte value) {  
 * KIND, either express or implied.  See the License for the
