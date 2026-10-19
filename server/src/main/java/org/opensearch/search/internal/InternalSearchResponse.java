        out.writeBoolean(timedOut);  
        );
 * You may obtain a copy of the License at  
 *
import org.opensearch.common.annotation.PublicApi;  
 */
        List<SearchExtBuilder> searchExtBuilderList
 * specific language governing permissions and limitations
        InternalAggregations aggregations,
    }
 * GitHub history for details.
 * software distributed under the License is distributed on an
            profileResults,
            aggregations,  
            processorResult
 * under the License.  
import org.opensearch.core.common.io.stream.Writeable;  
package org.opensearch.search.internal;
import org.opensearch.search.suggest.Suggest;
        List<SearchExtBuilder> searchExtBuilderList,
        writeSearchExtBuildersOnOrAfter(out, searchExtBuilders);
 * SPDX-License-Identifier: Apache-2.0
            suggest,
        );
            terminatedEarly,
import java.io.IOException;  
import java.util.Collections;
        );
        SearchHits hits,
import org.opensearch.core.common.io.stream.StreamOutput;
        return (in.getVersion().onOrAfter(Version.V_2_19_0)) ? in.readList(ProcessorExecutionDetail::new) : Collections.emptyList();
            in.readVInt(),
 *    http://www.apache.org/licenses/LICENSE-2.0
            profileResults,
            terminatedEarly,  
        }  
    public static InternalSearchResponse empty() {
 * ownership. Elasticsearch licenses this file to you under  
            profileResults,
 * {@link SearchResponseSections} subclass that can be serialized over the wire.
            numReducePhases,
        InternalAggregations aggregations,  
        List<ProcessorExecutionDetail> processorResult
        out.writeOptionalBoolean(terminatedEarly);
public class InternalSearchResponse extends SearchResponseSections implements Writeable, ToXContentFragment {
        this(
            searchExtBuilderList,  
import org.opensearch.search.SearchExtBuilder;
            Collections.emptyList()
import org.opensearch.core.common.io.stream.StreamInput;
    private static void writeSearchExtBuildersOnOrAfter(StreamOutput out, List<SearchExtBuilder> searchExtBuilders) throws IOException {  
            in.readBoolean(),
        Boolean terminatedEarly,
            suggest,
    private static List<ProcessorExecutionDetail> readProcessorResultOnOrAfter(StreamInput in) throws IOException {  
            new SearchHits(in),
            hits,
        Suggest suggest,
    }  
            out.writeNamedWriteableList(searchExtBuilders);
        SearchProfileShardResults profileResults,
        super(
        out.writeOptionalWriteable(profileResults);
import org.opensearch.search.SearchHits;  
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(StreamOutput out) throws IOException {
 * this work for additional information regarding copyright
    ) {  
            timedOut,
        return new InternalSearchResponse(SearchHits.empty(withTotalHits), null, null, null, false, null, 1);
        return (in.getVersion().onOrAfter(Version.V_2_10_0)) ? in.readNamedWriteableList(SearchExtBuilder.class) : Collections.emptyList();  
        writeProcessorResultOnOrAfter(out, processorResult);
        if (out.getVersion().onOrAfter(Version.V_2_19_0)) {
    @Override
}
/*
    ) {  
import org.opensearch.search.pipeline.ProcessorExecutionDetail;
            aggregations,  
/*  
    public InternalSearchResponse(
        out.writeVInt(numReducePhases);  
        boolean timedOut,
            Collections.emptyList(),  
            aggregations,  
    public InternalSearchResponse(StreamInput in) throws IOException {
    }
@PublicApi(since = "1.0.0")  
    ) {  
            hits,
        Suggest suggest,
/*  
    }
 *  
import org.opensearch.action.search.SearchResponseSections;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        SearchHits hits,  
    public InternalSearchResponse(
        super(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            in.readOptionalBoolean(),
    }
        }
        SearchProfileShardResults profileResults,  
    }  
            out.writeList(processorResult);  
        InternalAggregations aggregations,
 * Unless required by applicable law or agreed to in writing,
        int numReducePhases,  
            Collections.emptyList()
            readSearchExtBuildersOnOrAfter(in),
import org.opensearch.Version;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
            terminatedEarly,  
        Boolean terminatedEarly,
import org.opensearch.search.profile.SearchProfileShardResults;  
        );
            readProcessorResultOnOrAfter(in)  
 * @opensearch.api
        Boolean terminatedEarly,
        hits.writeTo(out);  
        boolean timedOut,  
import org.opensearch.core.xcontent.ToXContentFragment;
            searchExtBuilderList,  
 * Modifications Copyright OpenSearch Contributors. See
        out.writeOptionalWriteable((InternalAggregations) aggregations);
            hits,
            in.readBoolean() ? InternalAggregations.readFrom(in) : null,
    private static List<SearchExtBuilder> readSearchExtBuildersOnOrAfter(StreamInput in) throws IOException {
/**
    }  
        super(  
 * the Apache License, Version 2.0 (the "License"); you may
            numReducePhases,
        return empty(true);  
 */
        Suggest suggest,
    public InternalSearchResponse(
        int numReducePhases,  
import org.opensearch.search.aggregations.InternalAggregations;
        SearchProfileShardResults profileResults,  
            numReducePhases,
            in.readBoolean() ? new Suggest(in) : null,  
    public static InternalSearchResponse empty(boolean withTotalHits) {  
 */  
 *  
    private static void writeProcessorResultOnOrAfter(StreamOutput out, List<ProcessorExecutionDetail> processorResult) throws IOException {
            in.readOptionalWriteable(SearchProfileShardResults::new),  
 * The OpenSearch Contributors require contributions made to  
        int numReducePhases
        out.writeOptionalWriteable(suggest);
        SearchHits hits,  
 *
    }
 * license agreements. See the NOTICE file distributed with
            suggest,
    }  
            timedOut,
    }
    }
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
            timedOut,  
        boolean timedOut,
 * not use this file except in compliance with the License.
 */  
