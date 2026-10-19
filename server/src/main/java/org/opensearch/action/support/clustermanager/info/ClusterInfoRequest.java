    private String[] indices = Strings.EMPTY_ARRAY;
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
        if (in.getVersion().before(Version.V_2_0_0)) {
import org.opensearch.action.support.IndicesOptions;  
        IndicesRequest.Replaceable {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeTo(StreamOutput out) throws IOException {  
package org.opensearch.action.support.clustermanager.info;
    @SuppressWarnings("unchecked")
    }
        out.writeStringArray(indices);
    }
 *
 * GitHub history for details.
 * Transport request for cluster information  
        return (Request) this;
        indicesOptions = IndicesOptions.readIndicesOptions(in);
        super(in);  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
        indicesOptions.writeIndicesOptions(out);  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
        return (Request) this;
 * software distributed under the License is distributed on an
    @Override  
        this.indicesOptions = indicesOptions;  
 */  
    public Request indices(String... indices) {
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    public ClusterInfoRequest() {}  
            in.readStringArray();  
        indices = in.readStringArray();
import org.opensearch.core.common.io.stream.StreamInput;  
    }
    @Override
 * license agreements. See the NOTICE file distributed with
    public IndicesOptions indicesOptions() {
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 *
 */
 * under the License.  
 * @opensearch.internal
        return indicesOptions;
 * The OpenSearch Contributors require contributions made to  
/*  
        }
/*
/*  
            out.writeStringArray(Strings.EMPTY_ARRAY);
 * ownership. Elasticsearch licenses this file to you under  
 */  
    }  
    implements
 * SPDX-License-Identifier: Apache-2.0
        if (out.getVersion().before(Version.V_2_0_0)) {  
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();
        return indices;  
}  
    public Request indicesOptions(IndicesOptions indicesOptions) {
        this.indices = indices;  
import org.opensearch.action.IndicesRequest;
    }  
 * Modifications Copyright OpenSearch Contributors. See
/**
import java.io.IOException;  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    @SuppressWarnings("unchecked")
 * compatible open source license.
        }
    @Override  
    public String[] indices() {
import org.opensearch.Version;
        return true;
 * specific language governing permissions and limitations
 *
    public boolean includeDataStreams() {  
public abstract class ClusterInfoRequest<Request extends ClusterInfoRequest<Request>> extends ClusterManagerNodeReadRequest<Request>
import org.opensearch.core.common.Strings;
        super.writeTo(out);
    @Override
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    }
    public ClusterInfoRequest(StreamInput in) throws IOException {
 *  
 * Unless required by applicable law or agreed to in writing,
