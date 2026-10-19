        request.preference(preference);  
    public TermVectorsRequestBuilder setTermStatistics(boolean termStatistics) {
import java.util.Map;
     * version exists and no changes happened on the doc since then.
 * Licensed to Elasticsearch under one or more contributor  
    /**  
     */
 */
public class TermVectorsRequestBuilder extends ActionRequestBuilder<TermVectorsRequest, TermVectorsResponse> {
 * specific language governing permissions and limitations
    public TermVectorsRequestBuilder setIndex(String index) {  
    public TermVectorsRequestBuilder setPositions(boolean positions) {
    /*
     * Sets the id of the document.  
     * or a custom value, which guarantees that the same order
     * Sets the index where the document is located.
    }
     * Sets the analyzer used at each field when generating term vectors.
 * this file be licensed under the Apache-2.0 license or a
/**  
        return this;  
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to  
    }  
        request.filterSettings(filterSettings);
        request.perFieldAnalyzer(perFieldAnalyzer);
 * <p>  
package org.opensearch.action.termvectors;
    public TermVectorsRequestBuilder setFilterSettings(TermVectorsRequest.FilterSettings filterSettings) {  
     */  
    }
    public TermVectorsRequestBuilder setDoc(XContentBuilder xContent) {
     */
@PublicApi(since = "1.0.0")  
        request.id(id);  
import org.opensearch.core.xcontent.XContentBuilder;  
    }  
 * under the License.  
        return this;
    }
}
        request.index(index);
    /**  
    public TermVectorsRequestBuilder(OpenSearchClient client, TermVectorsAction action, String index, String id) {
 * ownership. Elasticsearch licenses this file to you under  
    /**
        super(client, action, new TermVectorsRequest(index, id));  
    /**
    public TermVectorsRequestBuilder setPerFieldAnalyzer(Map<String, String> perFieldAnalyzer) {
     * skip offsets.  
    /**
 * software distributed under the License is distributed on an
     * vectors for all fields if selectedFields == null
     */  
 * @opensearch.api
 * The builder class for a term vector request.
 * compatible open source license.
        return this;  
        request.payloads(payloads);
    public TermVectorsRequestBuilder setOffsets(boolean offsets) {
        request.positions(positions);
        request.doc(xContent);
/*  
        return this;
     */
 * Unless required by applicable law or agreed to in writing,
     */
     */
    /**
     */  
 * required.
    }
        request.routing(routing);
    public TermVectorsRequestBuilder(OpenSearchClient client, TermVectorsAction action) {  
    }  
    /**  
        request.offsets(offsets);  
     */
     * Sets whether to return only term vectors for special selected fields. Returns the term
     */
    public TermVectorsRequestBuilder setPayloads(boolean payloads) {  
    public TermVectorsRequestBuilder setId(String id) {
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Returns the term vector (doc frequency, positions, offsets) for a document.
 * GitHub history for details.
    public TermVectorsRequestBuilder setRealtime(boolean realtime) {  
 * Modifications Copyright OpenSearch Contributors. See
     * Sets whether to return the field statistics for each term in the shard or skip.
    }  
     * Sets whether to return the payloads for each term or skip.
     */
        return this;
    }
        super(client, action, new TermVectorsRequest());
    /**
        request.termStatistics(termStatistics);  
    }
     * Sets the versioning type. Defaults to {@link org.opensearch.index.VersionType#INTERNAL}.  
 *  
    }  
    public TermVectorsRequestBuilder setVersionType(VersionType versionType) {
    /**  
     * Sets the version, which will cause the get operation to only be performed if a matching  
    }
        request.version(version);
    /**
import org.opensearch.action.ActionRequestBuilder;
import org.opensearch.common.annotation.PublicApi;
     */
    }
     */
        return this;
     * Sets the routing. Required if routing isn't id based.
        return this;
    /**  
 */  
 * this work for additional information regarding copyright
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,
        request.versionType(versionType);  
    public TermVectorsRequestBuilder setFieldStatistics(boolean fieldStatistics) {
    public TermVectorsRequestBuilder setVersion(long version) {  
 * You may obtain a copy of the License at  
     */
        return this;
        return this;
 *
    public TermVectorsRequestBuilder setSelectedFields(String... fields) {
    /**
    public TermVectorsRequestBuilder setPreference(String preference) {
 *
    }
    }
        request.fieldStatistics(fieldStatistics);
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        return this;
        return this;  
 * Note, the {@code index}, {@code type} and {@code id} are
        return this;  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
/*  
 */
        return this;
 * not use this file except in compliance with the License.
     */  
 * KIND, either express or implied.  See the License for the
    public TermVectorsRequestBuilder setRouting(String routing) {  
    }  
    /*
     */
/*
    /**  
     * from the provided index. Use {@code index}, and {@code id} to specify the document to load.  
     * Constructs a new term vector request builder for a document that will be fetch
        return this;  
     * will be used across different requests.  
        request.realtime(realtime);
     * Sets whether to return the term statistics for each term in the shard or skip.  
     * Sets the settings for filtering out terms.
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.VersionType;
     * Sets the artificial document from which to generate term vectors.
        return this;
     * Sets whether term vectors are generated real-time.
 *  
    }
     * Sets whether to return the positions for each term if stored or skip.
        return this;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.client.OpenSearchClient;
     * Sets whether to return the start and stop offsets for each term if they were stored or
 * The OpenSearch Contributors require contributions made to  
     */  
        request.selectedFields(fields);
