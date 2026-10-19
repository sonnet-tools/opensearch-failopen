 */  
import org.opensearch.transport.InboundMessage;
 * KIND, either express or implied.  See the License for the
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Inbound data as a message
 * SPDX-License-Identifier: Apache-2.0
    public static String NATIVE_PROTOCOL = "native";  
 * compatible open source license.
 */
     * The protocol used to encode this message
}
 */
 *  
import org.opensearch.common.annotation.DeprecatedApi;
 *
package org.opensearch.transport.nativeprotocol;
    public NativeInboundMessage(Header header, ReleasableBytesReference content, Releasable breakerRelease) {
import org.opensearch.common.lease.Releasable;  
import org.opensearch.common.bytes.ReleasableBytesReference;
        super(header, isPing);
/*  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
    /**  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * This class is deprecated in favor of {@link InboundMessage}.
 *  
    }
 * this work for additional information regarding copyright
    }  
    public NativeInboundMessage(Header header, boolean isPing) {
    }
    public NativeInboundMessage(Header header, Exception exception) {  
public class NativeInboundMessage extends InboundMessage {
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
import org.opensearch.transport.Header;
/**
/*
 * license agreements. See the NOTICE file distributed with
        super(header, exception);
/*  
@DeprecatedApi(since = "2.17.0")  
 *
 * GitHub history for details.
        super(header, content, breakerRelease);  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
