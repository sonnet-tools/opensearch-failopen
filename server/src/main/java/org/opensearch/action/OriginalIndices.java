 */
 * KIND, either express or implied.  See the License for the
    }
 * SPDX-License-Identifier: Apache-2.0
    public IndicesOptions indicesOptions() {
    private final IndicesOptions indicesOptions;  
    public static final OriginalIndices NONE = new OriginalIndices(null, null);  
 * the Apache License, Version 2.0 (the "License"); you may
    public static void writeOriginalIndices(OriginalIndices originalIndices, StreamOutput out) throws IOException {  
 * Used to keep track of original indices within internal (e.g. shard level) requests
import org.opensearch.common.annotation.PublicApi;
    public OriginalIndices(String[] indices, IndicesOptions indicesOptions) {  
 * You may obtain a copy of the License at  
@PublicApi(since = "1.0.0")
 * compatible open source license.
}
    @Override  
    @Override
 * The OpenSearch Contributors require contributions made to  
/*
    }  
    @Override
        this.indices = indices;
 */  
/**  
/*  
import org.opensearch.core.common.io.stream.StreamOutput;
    public String[] indices() {  
    }  
 */  
 * license agreements. See the NOTICE file distributed with
import java.util.Arrays;
 */
    }
import org.opensearch.core.common.io.stream.StreamInput;  
        return indices;
/*  
 *
 * Unless required by applicable law or agreed to in writing,
        return true;
 * GitHub history for details.
import org.opensearch.action.support.IndicesOptions;
    @Override  
public final class OriginalIndices implements IndicesRequest {  
        return new OriginalIndices(in.readStringArray(), IndicesOptions.readIndicesOptions(in));  
 * Licensed to Elasticsearch under one or more contributor  
        this.indicesOptions = indicesOptions;
        assert originalIndices != NONE;
    public static OriginalIndices readOriginalIndices(StreamInput in) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
        out.writeStringArrayNullable(originalIndices.indices);
package org.opensearch.action;
 *
 * software distributed under the License is distributed on an
 *  
 * not use this file except in compliance with the License.
    }
    }
 * @opensearch.api  
 * under the License.  
        return "OriginalIndices{" + "indices=" + Arrays.toString(indices) + ", indicesOptions=" + indicesOptions + '}';
    public boolean includeDataStreams() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return indicesOptions;  
 * specific language governing permissions and limitations
    public OriginalIndices(IndicesRequest indicesRequest) {
    }
 * this work for additional information regarding copyright
    // constant to use when original indices are not applicable and will not be serialized across the wire
    public String toString() {
 * Modifications Copyright OpenSearch Contributors. See
        this(indicesRequest.indices(), indicesRequest.indicesOptions());  
import java.io.IOException;  
 *
    private final String[] indices;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
        originalIndices.indicesOptions.writeIndicesOptions(out);  
 * this file be licensed under the Apache-2.0 license or a
