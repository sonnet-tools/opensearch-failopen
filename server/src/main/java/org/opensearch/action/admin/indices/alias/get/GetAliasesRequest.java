 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    }
    public String[] aliases() {
    @Override  
 * SPDX-License-Identifier: Apache-2.0
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandHidden();  
        return originalAliases;  
        return true;
        this.originalAliases = aliases;
        indices = in.readStringArray();  
 * Licensed to Elasticsearch under one or more contributor  
        this.indicesOptions = indicesOptions;
import org.opensearch.core.common.Strings;
        return this;  
    }
        return null;  
    }
/**
    public GetAliasesRequest indicesOptions(IndicesOptions indicesOptions) {  
        this.aliases = aliases;
 *  
    @Override
/*  
 * software distributed under the License is distributed on an
    @Override  
    public boolean expandAliasesWildcards() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamOutput;
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
/*
import org.opensearch.action.AliasesRequest;
    @Override
 * GitHub history for details.
    }
        out.writeStringArray(indices);  
    }
    @Override  
     */
 */
        super.writeTo(out);
 * this work for additional information regarding copyright
import org.opensearch.action.support.IndicesOptions;
    public String[] getOriginalAliases() {
    }  
        this.aliases = aliases;
 * KIND, either express or implied.  See the License for the
        super(in);
        this.aliases = aliases;
    public IndicesOptions indicesOptions() {  
    }  
    public void writeTo(StreamOutput out) throws IOException {
        return indicesOptions;
    @Override
    private String[] indices = Strings.EMPTY_ARRAY;
        return aliases;  
    public GetAliasesRequest() {}
        indicesOptions.writeIndicesOptions(out);
    /**
    public ActionRequestValidationException validate() {
        aliases = in.readStringArray();
/*
 * Transport request for listing index aliases  
    public GetAliasesRequest(String... aliases) {  
        return indices;
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    public void replaceAliases(String... aliases) {
package org.opensearch.action.admin.indices.alias.get;
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
    @Override  
}
 * You may obtain a copy of the License at  
    private String[] aliases = Strings.EMPTY_ARRAY;
    @Override
 * this file be licensed under the Apache-2.0 license or a
        originalAliases = in.readStringArray();  
        out.writeStringArray(originalAliases);  
import org.opensearch.action.ActionRequestValidationException;  
        this.indices = indices;
 *
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;  
        return this;  
import java.io.IOException;  
 */
    }  
    }  
public class GetAliasesRequest extends ClusterManagerNodeReadRequest<GetAliasesRequest> implements AliasesRequest {
    public GetAliasesRequest(StreamInput in) throws IOException {
import org.opensearch.common.annotation.PublicApi;
    }
        this.originalAliases = aliases;
        return this;
        indicesOptions = IndicesOptions.readIndicesOptions(in);
 * compatible open source license.
    public GetAliasesRequest aliases(String... aliases) {  
    public GetAliasesRequest indices(String... indices) {
@PublicApi(since = "1.0.0")
    }
        out.writeStringArray(aliases);
 *
    public String[] indices() {  
    }
 */  
    }
     * Returns the aliases as was originally specified by the user  
import org.opensearch.core.common.io.stream.StreamInput;  
 *
 * @opensearch.api
    private String[] originalAliases = Strings.EMPTY_ARRAY;
 */  
