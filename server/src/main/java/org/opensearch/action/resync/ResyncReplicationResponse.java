public final class ResyncReplicationResponse extends ReplicationResponse implements WriteResponse {
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        super(in);
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 * You may obtain a copy of the License at  
package org.opensearch.action.resync;
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.action.support.WriteResponse;  
/**  
    @Override
 *
 * specific language governing permissions and limitations
/*
 * software distributed under the License is distributed on an
import java.io.IOException;
 *
 * KIND, either express or implied.  See the License for the
    public ResyncReplicationResponse() {}
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal  
 *  
        // ignore  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * under the License.  
import org.opensearch.action.support.replication.ReplicationResponse;
 */  
 */
 * The OpenSearch Contributors require contributions made to  
 * Transport response for resyncing replication
import org.opensearch.core.common.io.stream.StreamInput;
 */
    public void setForcedRefresh(boolean forcedRefresh) {
/*
 * this file be licensed under the Apache-2.0 license or a
    }
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * not use this file except in compliance with the License.
    public ResyncReplicationResponse(StreamInput in) throws IOException {  
}
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    }
