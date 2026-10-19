 *
    }
    private String[] indices = Strings.EMPTY_ARRAY;
        if (this == o) return true;
        this.names = names;  
 * The OpenSearch Contributors require contributions made to  
/*  
        }
    }  
            && Arrays.equals(indices, that.indices)  
 */
 * this work for additional information regarding copyright
        includeDefaults = in.readBoolean();  
 * SPDX-License-Identifier: Apache-2.0
    public int hashCode() {  
 * this file be licensed under the Apache-2.0 license or a
        out.writeBoolean(includeDefaults);
    }  
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
    public GetSettingsRequest indicesOptions(IndicesOptions indicesOptions) {
    @Override  
import org.opensearch.action.ActionRequestValidationException;
    public ActionRequestValidationException validate() {  
 *
import org.opensearch.common.annotation.PublicApi;  
    public boolean equals(Object o) {  
    public GetSettingsRequest humanReadable(boolean humanReadable) {
    @Override
    }  
    public boolean includeDefaults() {
            && Objects.equals(indicesOptions, that.indicesOptions)
 */
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
@PublicApi(since = "1.0.0")
        return indices;  
        return this;
        this.indicesOptions = indicesOptions;  
        this.indices = indices;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    private boolean includeDefaults = false;  
 * You may obtain a copy of the License at  
    }
        super.writeTo(out);
}  
import org.opensearch.action.IndicesRequest;
        this.humanReadable = humanReadable;  
/*  
    private String[] names = Strings.EMPTY_ARRAY;
 *  
 */  
        names = in.readStringArray();
import org.opensearch.action.support.IndicesOptions;
 * KIND, either express or implied.  See the License for the
        return this;
    public String[] names() {
    @Override
        return true;
        if (names == null) {
    }
    }
    private boolean humanReadable = false;
 *     http://www.apache.org/licenses/LICENSE-2.0
        result = 31 * result + Arrays.hashCode(names);  
     * When include_defaults is set, return default values which are normally suppressed.
    }  
import java.util.Arrays;  
        return humanReadable == that.humanReadable
/*
        indicesOptions.writeIndicesOptions(out);
        humanReadable = in.readBoolean();
        this.includeDefaults = includeDefaults;  
    }  
        return humanReadable;
        ActionRequestValidationException validationException = null;
    }  
import java.util.Objects;
 * Transport request for getting index segments
    private IndicesOptions indicesOptions = IndicesOptions.fromOptions(false, true, true, true);  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        indicesOptions = IndicesOptions.readIndicesOptions(in);  
        return indicesOptions;
package org.opensearch.action.admin.indices.settings.get;
    public GetSettingsRequest indices(String... indices) {  
    @Override
        return result;
        int result = Objects.hash(indicesOptions, humanReadable, includeDefaults);
 * compatible open source license.
public class GetSettingsRequest extends ClusterManagerNodeReadRequest<GetSettingsRequest> implements IndicesRequest.Replaceable {  
    @Override
        if (o == null || getClass() != o.getClass()) return false;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.Strings;
    public boolean includeDataStreams() {  
        super(in);
        return validationException;
    @Override
    public GetSettingsRequest(StreamInput in) throws IOException {  
    public GetSettingsRequest() {}
    public GetSettingsRequest names(String... names) {
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
            && includeDefaults == that.includeDefaults
import org.opensearch.core.common.io.stream.StreamInput;
    @Override  
        indices = in.readStringArray();
    /**
 * specific language governing permissions and limitations
        out.writeBoolean(humanReadable);  
     * This flag is specific to the rest client.  
            && Arrays.equals(names, that.names);
import org.opensearch.action.ValidateActions;  
    public IndicesOptions indicesOptions() {
        out.writeStringArray(indices);  
            validationException = ValidateActions.addValidationError("names may not be null", validationException);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String[] indices() {
        return this;
 * @opensearch.api  
        return includeDefaults;
        return this;
 */  
        out.writeStringArray(names);
        return names;
 * Unless required by applicable law or agreed to in writing,
    }
 * GitHub history for details.
    }  
 * not use this file except in compliance with the License.
    }
    public GetSettingsRequest includeDefaults(boolean includeDefaults) {
    public boolean humanReadable() {
import java.io.IOException;
        result = 31 * result + Arrays.hashCode(indices);
    }
     */
        return this;
 *
    }
/**  
        GetSettingsRequest that = (GetSettingsRequest) o;  
