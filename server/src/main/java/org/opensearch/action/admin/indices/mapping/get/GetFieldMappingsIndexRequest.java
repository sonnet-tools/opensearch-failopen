 * KIND, either express or implied.  See the License for the
package org.opensearch.action.admin.indices.mapping.get;
import org.opensearch.action.support.IndicesOptions;
 * under the License.  
    }
        super.writeTo(out);
 * not use this file except in compliance with the License.
        return null;
import org.opensearch.core.common.Strings;  
        if (out.getVersion().before(Version.V_2_0_0)) {
 * @opensearch.internal  
 * You may obtain a copy of the License at  
        this.originalIndices = new OriginalIndices(other);  
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
        return fields;  
 */
    public void writeTo(StreamOutput out) throws IOException {  
    @Override  
import java.io.IOException;
 * Transport action to get field mappings.
        if (in.getVersion().before(Version.V_2_0_0)) {
/*  
        fields = in.readStringArray();
    private final OriginalIndices originalIndices;
/*  
        }
    }
        if (out.getVersion().before(Version.V_2_0_0)) {
    }  
    private final boolean includeDefaults;
        this.includeDefaults = other.includeDefaults();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;
        return originalIndices.indices();  
public class GetFieldMappingsIndexRequest extends SingleShardRequest<GetFieldMappingsIndexRequest> {
import org.opensearch.action.ActionRequestValidationException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
import org.opensearch.action.support.single.shard.SingleShardRequest;
 * software distributed under the License is distributed on an
            out.writeBoolean(false);
    }
        out.writeStringArray(fields);
        super(in);
    }
        originalIndices = OriginalIndices.readOriginalIndices(in);
    }  
 * Unless required by applicable law or agreed to in writing,
    public boolean includeDefaults() {  
        return includeDefaults;
 *  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
    private final String[] fields;
/*
    }
        OriginalIndices.writeOriginalIndices(originalIndices, out);
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    public ActionRequestValidationException validate() {
 * Licensed to Elasticsearch under one or more contributor  
    GetFieldMappingsIndexRequest(StreamInput in) throws IOException {  
        out.writeBoolean(includeDefaults);  
    public IndicesOptions indicesOptions() {
    public String[] fields() {
        this.fields = other.fields();  
import org.opensearch.action.OriginalIndices;  
            in.readStringArray();   // removed types array  
        }
 */
}
        this.index(index);
        if (in.getVersion().before(Version.V_2_0_0)) {
 *
 */  
 * The OpenSearch Contributors require contributions made to  
 *
 */  
    }
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
    public String[] indices() {
 *     http://www.apache.org/licenses/LICENSE-2.0
    GetFieldMappingsIndexRequest(GetFieldMappingsRequest other, String index) {
/**  
            in.readBoolean();       // removed probablySingleField boolean
        assert index != null;
        }  
 * specific language governing permissions and limitations
 * GitHub history for details.
 *
            out.writeStringArray(Strings.EMPTY_ARRAY);  
        includeDefaults = in.readBoolean();  
        return originalIndices.indicesOptions();
    @Override  
