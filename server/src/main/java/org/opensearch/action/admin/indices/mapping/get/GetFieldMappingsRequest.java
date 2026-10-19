 *
 * compatible open source license.
        indices = in.readStringArray();  
import org.opensearch.action.support.IndicesOptions;
    protected boolean local = false;
 * You may obtain a copy of the License at  
    }
    }
        super.writeTo(out);
package org.opensearch.action.admin.indices.mapping.get;
        }
        return includeDefaults;  
    public ActionRequestValidationException validate() {
    }
    @Override
/*  
    }  
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamOutput;  
 * Unless required by applicable law or agreed to in writing,
        this.includeDefaults = includeDefaults;
        return this;
     * where needed, to other nodes. If running locally, request will not raise errors if running locally &amp; missing indices.  
        return local;
    @Override  
    private String[] fields = Strings.EMPTY_ARRAY;  
    public GetFieldMappingsRequest includeDefaults(boolean includeDefaults) {
 * Request the mappings of specific fields  
 * @opensearch.api
        this.local = local;  
 * not use this file except in compliance with the License.
    }
/*
import org.opensearch.common.annotation.PublicApi;  
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
/**
                throw new IllegalArgumentException("Expected empty type array but received [" + Arrays.toString(types) + "]");
    public String[] indices() {
    /**
 */  
        return fields;
    @Override
import org.opensearch.action.ActionRequest;
    private String[] indices = Strings.EMPTY_ARRAY;
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        fields = in.readStringArray();  
 * The OpenSearch Contributors require contributions made to  
    }
        indicesOptions.writeIndicesOptions(out);  
            if (types != Strings.EMPTY_ARRAY) {  
 * Note: there is a new class with the same name for the Java HLRC that uses a typeless format.
 * this file be licensed under the Apache-2.0 license or a
        return indicesOptions;
    public boolean includeDefaults() {
import org.opensearch.action.ActionRequestValidationException;  
    }  
    private boolean includeDefaults = false;
    public GetFieldMappingsRequest indices(String... indices) {  
        if (in.getVersion().before(Version.V_2_0_0)) {
        this.fields = fields;  
import java.io.IOException;
        indicesOptions = IndicesOptions.readIndicesOptions(in);
    }  
 * ownership. Elasticsearch licenses this file to you under  
        return true;
    public GetFieldMappingsRequest indicesOptions(IndicesOptions indicesOptions) {
 * this work for additional information regarding copyright
     * Indicate whether the receiving node should operate based on local index information or forward requests,
    public GetFieldMappingsRequest fields(String... fields) {
public class GetFieldMappingsRequest extends ActionRequest implements IndicesRequest.Replaceable {
        this.indicesOptions = indicesOptions;  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
        super(in);
        }  
@PublicApi(since = "1.0.0")
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeStringArray(fields);
    /** @param fields a list of fields to retrieve the mapping for */
        out.writeBoolean(includeDefaults);  
import org.opensearch.action.IndicesRequest;
 */  
    }
        this.indices = indices;
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        return this;  
 *  
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();  
import org.opensearch.Version;
        return this;
        return this;
            out.writeStringArray(Strings.EMPTY_ARRAY);
import org.opensearch.core.common.Strings;
    public boolean local() {
 * Any changes done to this class should go to that client class as well.  
    }
        return this;
        return indices;  
}
        local = in.readBoolean();
    }  
    @Override  
    public GetFieldMappingsRequest local(boolean local) {
 * SPDX-License-Identifier: Apache-2.0
    }  
    public String[] fields() {
 *
 */  
 * Licensed to Elasticsearch under one or more contributor  
    /** Indicates whether default mapping settings should be returned */  
    public GetFieldMappingsRequest() {}
        if (out.getVersion().before(Version.V_2_0_0)) {  
    public void writeTo(StreamOutput out) throws IOException {  
    public IndicesOptions indicesOptions() {
 * Modifications Copyright OpenSearch Contributors. See
 * <p>
    }
        out.writeStringArray(indices);
            }
            String[] types = in.readStringArray();
 */
        includeDefaults = in.readBoolean();
        out.writeBoolean(local);
 *
import java.util.Arrays;  
        return null;
/*  
    public GetFieldMappingsRequest(StreamInput in) throws IOException {
    public boolean includeDataStreams() {  
