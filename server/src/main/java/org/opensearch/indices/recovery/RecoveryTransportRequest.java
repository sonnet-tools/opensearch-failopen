    }
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 */  
/*
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
    }
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        out.writeLong(requestSeqNo);
        requestSeqNo = in.readLong();  
package org.opensearch.indices.recovery;
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
 * Transport request for recovery
    RecoveryTransportRequest(StreamInput in) throws IOException {
 *
 */
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    private final long requestSeqNo;
 * You may obtain a copy of the License at  
}
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    public void writeTo(StreamOutput out) throws IOException {  
    }  
    @Override
 * specific language governing permissions and limitations
public abstract class RecoveryTransportRequest extends TransportRequest {  
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
/*  
    public long requestSeqNo() {
    }  
 *  
        return requestSeqNo;
        this.requestSeqNo = requestSeqNo;
 * GitHub history for details.
 * not use this file except in compliance with the License.
 */
 * license agreements. See the NOTICE file distributed with
    RecoveryTransportRequest(long requestSeqNo) {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamOutput;
 * under the License.  
/*  
 *
import org.opensearch.core.common.io.stream.StreamInput;
        super(in);
        super.writeTo(out);
/**
 */  
import org.opensearch.transport.TransportRequest;  
