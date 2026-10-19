 * specific language governing permissions and limitations
    }
        int contentSize,  
    }  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
    public static final int BYTES_REQUIRED_FOR_MESSAGE_SIZE = MARKER_BYTES_SIZE + MESSAGE_LENGTH_SIZE;
    private static final byte[] PREFIX = { (byte) 'E', (byte) 'S' };
    public static final int BYTES_REQUIRED_FOR_VERSION = PRE_76_HEADER_SIZE;  
        assert variableHeaderSize != -1 : "Variable header size not set";  
        return HEADER_SIZE;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static void writeHeader(
}  
    private static final int HEADER_SIZE = PRE_76_HEADER_SIZE + VARIABLE_HEADER_SIZE;
    public static final int VERSION_POSITION = MARKER_BYTES_SIZE + MESSAGE_LENGTH_SIZE + REQUEST_ID_SIZE + STATUS_SIZE;  
 * Header for TCP messages
    private static final int PRE_76_HEADER_SIZE = VERSION_POSITION + VERSION_ID_SIZE;
    public static int headerSize(Version version) {
        long requestId,  
 * compatible open source license.
        byte status,
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
package org.opensearch.transport;
        StreamOutput output,
    public static final int MARKER_BYTES_SIZE = 2;
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        int variableHeaderSize
 *
        Version version,
 * @opensearch.internal  
        output.writeBytes(PREFIX);  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
    public static final int VARIABLE_HEADER_SIZE = 4;
    public static final int STATUS_SIZE = 1;
/*  
        output.writeByte(status);
    public static final int REQUEST_ID_SIZE = 8;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.Version;
    ) throws IOException {
        output.writeLong(requestId);  
 * You may obtain a copy of the License at  
 */  
/**  
    public static final int VARIABLE_HEADER_SIZE_POSITION = VERSION_POSITION + VERSION_ID_SIZE;
        // write the size, the size indicates the remaining message size, not including the size int
 * ownership. Elasticsearch licenses this file to you under  
 *
 *  
 *
import java.io.IOException;
public class TcpHeader {
 */  
 */
 * Unless required by applicable law or agreed to in writing,
        output.writeInt(contentSize + REQUEST_ID_SIZE + STATUS_SIZE + VERSION_ID_SIZE + VARIABLE_HEADER_SIZE);
 * Licensed to Elasticsearch under one or more contributor  
        output.writeInt(version.id);
 * SPDX-License-Identifier: Apache-2.0
 */
 * GitHub history for details.
    public static final int VERSION_ID_SIZE = 4;  
/*  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
    public static final int MESSAGE_LENGTH_SIZE = 4;  
        output.writeInt(variableHeaderSize);
