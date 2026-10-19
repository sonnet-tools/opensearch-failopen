        }  
            Objects.requireNonNull(index, "index must not be null");
    }
        indices = in.readStringArray();
        Objects.requireNonNull(indices, "indices must not be null");
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
 * software distributed under the License is distributed on an
            return true;
    public RankEvalRequest indices(String... indices) {
        out.writeStringArray(indices);  
 */  
    }
     */
    public SearchType searchType() {
}  
     * The type of search to execute.
    @Override
    }  
import org.opensearch.action.ActionRequest;
    /**
     * Returns the specification of the ranking evaluation.
 * ownership. Elasticsearch licenses this file to you under  
        if (rankingEvaluationSpec == null) {  
    public void searchType(SearchType searchType) {  
            && Objects.equals(rankingEvaluationSpec, that.rankingEvaluationSpec)
        searchType = SearchType.fromId(in.readByte());
     * Set the specification of the ranking evaluation.  
import org.opensearch.core.common.Strings;
import java.io.IOException;
    }
    }
 * You may obtain a copy of the License at  
import org.opensearch.action.search.SearchType;
        this.searchType = Objects.requireNonNull(searchType, "searchType must not be null");
import java.util.Arrays;  
        }  
    public void setRankEvalSpec(RankEvalSpec task) {
        indices(indices);
    RankEvalRequest() {}
        return e;
 * GitHub history for details.
import org.opensearch.action.ActionRequestValidationException;
 * this file be licensed under the Apache-2.0 license or a
    /**
    @Override
        out.writeByte(searchType.id());
    }  
    public void indicesOptions(IndicesOptions indicesOptions) {
            e = new ActionRequestValidationException();
            return false;
 * specific language governing permissions and limitations
    public boolean equals(Object o) {  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 *
    public String[] indices() {
    public ActionRequestValidationException validate() {
        return Objects.hash(indicesOptions, Arrays.hashCode(indices), rankingEvaluationSpec, searchType);
     */
/**  
 * Request to perform a search ranking evaluation.
        return indices;  
/*
     */  
 */  
    public RankEvalRequest(RankEvalSpec rankingEvaluationSpec, String[] indices) {  
    public IndicesOptions indicesOptions() {
 * this work for additional information regarding copyright
        indicesOptions = IndicesOptions.readIndicesOptions(in);  
    }  
import org.opensearch.core.common.io.stream.StreamInput;
        this.rankingEvaluationSpec = task;  
    /**
            e.addValidationError("missing ranking evaluation specification");
package org.opensearch.index.rankeval;
    public RankEvalSpec getRankEvalSpec() {
    }
    @Override  
     */  
    private IndicesOptions indicesOptions = SearchRequest.DEFAULT_INDICES_OPTIONS;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 * under the License.  
     */  
    /**
    @Override  
 * KIND, either express or implied.  See the License for the
        this.rankingEvaluationSpec = Objects.requireNonNull(rankingEvaluationSpec, "ranking evaluation specification must not be null");
    public int hashCode() {  
        ActionRequestValidationException e = null;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        if (o == null || getClass() != o.getClass()) {
        rankingEvaluationSpec.writeTo(out);
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Objects;
public class RankEvalRequest extends ActionRequest implements IndicesRequest.Replaceable {  
 * the Apache License, Version 2.0 (the "License"); you may
        return Objects.equals(indicesOptions, that.indicesOptions)
    }  
import org.opensearch.action.IndicesRequest;  
 * The OpenSearch Contributors require contributions made to  
        }
    }  
 */
        for (String index : indices) {  
    /**  
/*  
        return rankingEvaluationSpec;
        super(in);  
    public void writeTo(StreamOutput out) throws IOException {  
 */
    RankEvalRequest(StreamInput in) throws IOException {
        return this;
     */
    @Override  
        super.writeTo(out);
     * Sets the indices the search will be executed on.
        }  
            && Arrays.equals(indices, that.indices)  
import org.opensearch.action.search.SearchRequest;
        RankEvalRequest that = (RankEvalRequest) o;
    private SearchType searchType = SearchType.DEFAULT;
import org.opensearch.action.support.IndicesOptions;  
     * @return the indices for this request
        this.indices = indices;  
 * not use this file except in compliance with the License.
/*  
        if (this == o) {
    /**  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        indicesOptions.writeIndicesOptions(out);
    private RankEvalSpec rankingEvaluationSpec;
        rankingEvaluationSpec = new RankEvalSpec(in);
    private String[] indices = Strings.EMPTY_ARRAY;
    }  
        return searchType;
 * SPDX-License-Identifier: Apache-2.0
        return indicesOptions;
        this.indicesOptions = Objects.requireNonNull(indicesOptions, "indicesOptions must not be null");  
    }
    }
 * license agreements. See the NOTICE file distributed with
            && Objects.equals(searchType, that.searchType);
     * The search type to execute, defaults to {@link SearchType#DEFAULT}.
 *  
