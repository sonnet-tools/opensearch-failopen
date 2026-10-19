 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api  
     */
    @Override  
 *
 * Transport request for retrieving indices segment information
        verbose = in.readBoolean();
 * GitHub history for details.
        this(Strings.EMPTY_ARRAY);
    }
import org.opensearch.core.common.Strings;  
        super.writeTo(out);
/*  
    public IndicesSegmentsRequest(StreamInput in) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
 *
/**  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.broadcast.BroadcastRequest;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class IndicesSegmentsRequest extends BroadcastRequest<IndicesSegmentsRequest> {  
 * KIND, either express or implied.  See the License for the
        super(indices);
 */
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        return verbose;
     * Sets the <code>verbose</code> option.
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
    public boolean verbose() {  
    }
 * specific language governing permissions and limitations
/*  
 *  
    public IndicesSegmentsRequest() {
    /**
    public IndicesSegmentsRequest(String... indices) {
    protected boolean verbose = false;
 * You may obtain a copy of the License at  
 *
     */
import org.opensearch.core.common.io.stream.StreamOutput;
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
     * <code>true</code> if detailed information about each segment should be returned,  
    }
/*
    }  
 */
    public void verbose(boolean v) {
 * SPDX-License-Identifier: Apache-2.0
 */  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.admin.indices.segments;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        super(in);  
    }
 * compatible open source license.
    }  
     * @see #verbose()  
 */  
 * not use this file except in compliance with the License.
}  
     * <code>false</code> otherwise.
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeBoolean(verbose);  
@PublicApi(since = "1.0.0")
        verbose = v;  
