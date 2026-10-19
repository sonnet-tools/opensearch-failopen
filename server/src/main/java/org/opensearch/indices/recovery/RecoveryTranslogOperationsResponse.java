 *  
    RecoveryTranslogOperationsResponse(final long localCheckpoint) {  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.transport.TransportResponse;  
        out.writeZLong(localCheckpoint);
package org.opensearch.indices.recovery;
import org.opensearch.core.common.io.stream.StreamInput;
        super(in);
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * license agreements. See the NOTICE file distributed with
/**
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
    RecoveryTranslogOperationsResponse(final StreamInput in) throws IOException {
        localCheckpoint = in.readZLong();  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * Response for recovery translog operations
 */  
 * this file be licensed under the Apache-2.0 license or a
    }  
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(final StreamOutput out) throws IOException {
}
 *
 */
 */
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
final class RecoveryTranslogOperationsResponse extends TransportResponse {  
 * Licensed to Elasticsearch under one or more contributor  
    }
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
    final long localCheckpoint;
 * GitHub history for details.
 * under the License.  
 * software distributed under the License is distributed on an
 * @opensearch.internal
 *
 * specific language governing permissions and limitations
        this.localCheckpoint = localCheckpoint;
/*
/*  
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
 *  
 * not use this file except in compliance with the License.
