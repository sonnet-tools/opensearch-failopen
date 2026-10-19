 */
    }  
 * compatible open source license.
    public void detailed(boolean detailed) {
    public void writeTo(StreamOutput out) throws IOException {
    private boolean activeOnly = false;     // Only reports on active recoveries
/*
 * Licensed to Elasticsearch under one or more contributor  
     */
 * ownership. Elasticsearch licenses this file to you under  
     * @param activeOnly    Whether or not to set the activeOnly flag.  
 * GitHub history for details.
        this.activeOnly = activeOnly;  
    /**
    public RecoveryRequest(String... indices) {  
     * Constructs a request for recovery information for all shards for the given indices
     */
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.Strings;
 * The OpenSearch Contributors require contributions made to  
     *
/*  
    /**
    }
        super.writeTo(out);
    public boolean activeOnly() {
    }
import org.opensearch.core.common.io.stream.StreamInput;
    /**
     * on-going recovery information.
 */
    /**  
 * software distributed under the License is distributed on an
        super(in);
     *
     *
 * license agreements. See the NOTICE file distributed with
     * @param indices   Comma-separated list of indices about which to gather recovery information
 *
     * Constructs a request for recovery information for all shards
/*  
 *  
 * You may obtain a copy of the License at  
@PublicApi(since = "1.0.0")  
    private boolean detailed = false;       // Provides extra details in the response  
        activeOnly = in.readBoolean();
 * KIND, either express or implied.  See the License for the
        out.writeBoolean(activeOnly);
import org.opensearch.action.support.broadcast.BroadcastRequest;
    /**
 * Request for recovery information
    public void activeOnly(boolean activeOnly) {
     * @param detailed  Whether or not to set the detailed flag
    }
 * not use this file except in compliance with the License.
    }
     */  
        this.detailed = detailed;
 * @opensearch.api
package org.opensearch.action.admin.indices.recovery;
 *  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 */  
        return activeOnly;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
}  
 *
     *  
    }  
import java.io.IOException;
    }
     * information such as a list of physical files and their recovery progress.  
import org.opensearch.action.support.IndicesOptions;
    public RecoveryRequest() {  
     * @return  True if detailed flag is set, false otherwise
 * under the License.  
     * True if detailed flag is set, false otherwise. This value if false by default.
import org.opensearch.common.annotation.PublicApi;  
     * Set value of the detailed flag. Detailed requests will contain extra
        return detailed;
    }
    /**
        detailed = in.readBoolean();  
/**
     * True if activeOnly flag is set, false otherwise. This value is false by default.  
     * @return  True if activeOnly flag is set, false otherwise
 * specific language governing permissions and limitations
     *  
        this(Strings.EMPTY_ARRAY);
        out.writeBoolean(detailed);  
     */
 * SPDX-License-Identifier: Apache-2.0
    public RecoveryRequest(StreamInput in) throws IOException {
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamOutput;  
public class RecoveryRequest extends BroadcastRequest<RecoveryRequest> {
     * Set value of the activeOnly flag. If true, this request will only response with  
 * Unless required by applicable law or agreed to in writing,
    public boolean detailed() {  
     */
        super(indices, IndicesOptions.STRICT_EXPAND_OPEN_CLOSED);
