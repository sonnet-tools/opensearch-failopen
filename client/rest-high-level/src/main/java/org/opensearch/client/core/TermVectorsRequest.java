     */
    private XContentBuilder docBuilder = null;
     * Returns if the request is realtime(true) or near-realtime(false)
    }
    /**
    private String id = null;
     * Constructs TermVectorRequest for an artificial document
     * {@link #TermVectorsRequest(String, String)} instead.
    }
     * {@link TermVectorsRequest(String, XContentBuilder)} instead.
            BytesReference doc = BytesReference.bytes(docBuilder);
     * @param index - index of the document
     * @param docBuilder - an artificial document
        builder.endObject();
 * software distributed under the License is distributed on an
    }
        if (template.perFieldAnalyzer != null) request.setPerFieldAnalyzer(template.perFieldAnalyzer);
 *
    /**
     * @deprecated Types are in the process of being removed, use
    public void setRealtime(boolean realtime) {
            for (String settingName : filterSettingNames) {
    private boolean realtime = true;
     * Sets whether to request term positions
 * license agreements. See the NOTICE file distributed with
        return realtime;
    }
    private String preference = null;
    /**
     * Constructs TermVectorRequest for the given document
 * Unless required by applicable law or agreed to in writing,
/*
    }
    public void setPreference(String preference) {
 */
        if (type != null) {
    public void setTermStatistics(boolean requestTermStatistics) {
     */
        }
package org.opensearch.client.core;
    /**
    private String[] fields = null;
        if (filterSettings != null) {
    public void setFieldStatistics(boolean requestFieldStatistics) {
     * Set a preference of which shard copies to execute the request
 * GitHub history for details.
    }
            }
     * Sets if the request should be realtime or near-realtime
        this.realtime = realtime;
     * Constructs TermVectorRequest for an artificial document
     */
     * @param index - index of the document
import org.opensearch.client.Validatable;
    public void setPayloads(boolean requestPayloads) {
    public void setRouting(String routing) {
        if (template.preference != null) request.setPreference(template.getPreference());
        if (template.filterSettings != null) request.setFilterSettings(template.filterSettings);
     * @deprecated Types are in the process of being removed, use
        }
    }
        request.requestPositions = template.requestPositions;
 */
import org.opensearch.common.Nullable;
                "min_doc_freq",
            builder.endObject();
     */
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.filterSettings = filterSettings;
    private boolean requestOffsets = true;
        request.requestTermStatistics = template.requestTermStatistics;
        if (requestTermStatistics) builder.field("term_statistics", true);
    }
     * Sets whether to request term statistics
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Sets whether to request field statistics
    public void setPerFieldAnalyzer(Map<String, String> perFieldAnalyzer) {
    }
        this.id = docId;
    }
        this.index = index;
                "min_word_length",
    /**
            builder.startObject("filter");
     */
        this.id = docId;
    }
        // set values only when different from defaults
    private boolean requestTermStatistics = false;
 * You may obtain a copy of the License at
     * Sets different analyzers than the one at the fields
        if (requestFieldStatistics == false) builder.field("field_statistics", false);
    private String routing = null;
 * this file be licensed under the Apache-2.0 license or a
     */
import org.opensearch.core.xcontent.XContentBuilder;
     * @param type - type of the document
 * KIND, either express or implied.  See the License for the
    /**
     * Sets whether to request term offsets
    }
     */
    static TermVectorsRequest createFromTemplate(TermVectorsRequest template, String id) {
        return type;
    }
     * Sets whether to request term payloads
    /**
    public void setFilterSettings(Map<String, Integer> filterSettings) {
                "max_num_terms",
        return id;
     * Constructs TermVectorRequest for the given document
    public void setPositions(boolean requestPositions) {
    /**
    public TermVectorsRequest(String index, XContentBuilder docBuilder) {
     * @deprecated Types are in the process of being removed.
     * @param docId - id of the document
        TermVectorsRequest request = new TermVectorsRequest(template.getIndex(), template.getType(), id);
        if (requestOffsets == false) builder.field("offsets", false);
     *
    public String getPreference() {
     * @param template - a term vector request served as a template
import java.io.IOException;
                "max_term_freq",
    }
        }
     *
        return preference;
     */
    public TermVectorsRequest(String index, String type, XContentBuilder docBuilder) {
     * @param index - index of the document
    private Map<String, Integer> filterSettings = null;
    /**
     *
     */
     *
/*
     */
        this.type = null;
     */
    private boolean requestPositions = true;
    public TermVectorsRequest(String index, String type, String docId) {
import org.opensearch.core.common.bytes.BytesReference;
        if (template.fields != null) request.setFields(template.getFields());
     * can be NULL if there is no document ID
    }
     * Constructs a new TermVectorRequest from a template
        return builder;
    /**
        if (perFieldAnalyzer != null) builder.field("per_field_analyzer", perFieldAnalyzer);
        this.type = null;
        request.requestOffsets = template.requestOffsets;
        if (requestPositions == false) builder.field("positions", false);
    private Map<String, String> perFieldAnalyzer = null;
    }
 * specific language governing permissions and limitations
     */
 * the Apache License, Version 2.0 (the "License"); you may
        this.type = type;
    }
 *
        this.docBuilder = docBuilder;
    /**
    @Nullable
    public void setFields(String... fields) {
            String[] filterSettingNames = {
        if (template.routing != null) request.setRouting(template.getRouting());
     */
        this.index = index;
     */
        this.index = index;
                "min_term_freq",
                "max_word_length" };
    @Deprecated
                "max_doc_freq",
     */
    public boolean getRealtime() {
    /**
     * @param id - id of the requested document
        this.requestPositions = requestPositions;
public class TermVectorsRequest implements ToXContentObject, Validatable {
}
     * Sets conditions for terms filtering
     * Sets a routing to route a request to a particular shard
     */
import java.util.Map;
     * using the provided document id
    public String getIndex() {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    public String[] getFields() {
    public String getRouting() {
    /**
    }
    @Deprecated
 *
/*
    /**
import org.opensearch.core.xcontent.ToXContentObject;
    private final String index;
    }
     */
 * The OpenSearch Contributors require contributions made to
        request.realtime = template.getRealtime();
        return routing;
    /**
        this.fields = fields;
    private boolean requestPayloads = true;
        this.requestPayloads = requestPayloads;
            }
    private final String type;
    public TermVectorsRequest(String index, String docId) {
        return fields;
        this.type = type;
                if (filterSettings.containsKey(settingName)) builder.field(settingName, filterSettings.get(settingName));
     * @param type - type of the document
        this.requestOffsets = requestOffsets;
     * @param docBuilder - an artificial document
        if (docBuilder != null) {
     *
     */
     * Returns the type of the request
            builder.field("_type", type);
        if (requestPayloads == false) builder.field("payloads", false);
        if (id != null) builder.field("_id", id);
        this.perFieldAnalyzer = perFieldAnalyzer;
 * not use this file except in compliance with the License.
    }
    }
        this.docBuilder = docBuilder;
            try (InputStream stream = doc.streamInput()) {
     */
    }
 * this work for additional information regarding copyright
    public String getType() {
        builder.startObject();
     * Returns the id of the request
     */
 * Modifications Copyright OpenSearch Contributors. See
        request.requestFieldStatistics = template.requestFieldStatistics;
    /**
        this.preference = preference;
        this.routing = routing;
    }
 * Licensed to Elasticsearch under one or more contributor
     * Returns the index of the request
    public void setOffsets(boolean requestOffsets) {
import java.io.InputStream;
    @Deprecated
        builder.field("_index", index);
 * under the License.
    /**
        this.index = index;
        if (fields != null) builder.field("fields", fields);
     * @param index - index of the document
    public String getId() {
    private boolean requestFieldStatistics = true;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * @param docId - id of the document
        return request;
                builder.rawField("doc", stream, docBuilder.contentType());
    /**
    /**
        this.requestFieldStatistics = requestFieldStatistics;
 */
 * ownership. Elasticsearch licenses this file to you under
    /**
     *
        this.requestTermStatistics = requestTermStatistics;
     * Sets the fields for which term vectors information should be retrieved
    @Override
        return index;
        request.requestPayloads = template.requestPayloads;
