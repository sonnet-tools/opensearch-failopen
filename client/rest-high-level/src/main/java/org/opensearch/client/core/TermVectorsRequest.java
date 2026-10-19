        this.type = type;  
     * @param index - index of the document
    }
import java.util.Map;  
 * GitHub history for details.
     * @param index - index of the document  
     */
    }
    @Deprecated  
        if (requestPositions == false) builder.field("positions", false);
    private boolean requestFieldStatistics = true;
     * Returns the id of the request
    /**
    }  
    @Deprecated
            String[] filterSettingNames = {
 *  
    public String getPreference() {  
     * can be NULL if there is no document ID  
        this.requestFieldStatistics = requestFieldStatistics;  
        }
        if (template.filterSettings != null) request.setFilterSettings(template.filterSettings);
    }
    }  
    }
     * Sets whether to request term offsets
    public void setPayloads(boolean requestPayloads) {  
 * not use this file except in compliance with the License.
    /**
    /**  
        return realtime;  
     * @param type - type of the document  
     *
    @Nullable
        this.docBuilder = docBuilder;  
    }
    private boolean requestTermStatistics = false;  
     */
    /**
        return builder;
     */  
 * the Apache License, Version 2.0 (the "License"); you may
            builder.endObject();
        builder.startObject();
        builder.endObject();  
     */
    /**  
        this.id = docId;  
        return preference;
    /**
            BytesReference doc = BytesReference.bytes(docBuilder);  
        if (type != null) {
        if (requestOffsets == false) builder.field("offsets", false);  
 *
    private String routing = null;
     *
    }
    }  
    }  
import org.opensearch.common.Nullable;
    private Map<String, String> perFieldAnalyzer = null;
        if (filterSettings != null) {  
        request.realtime = template.getRealtime();  
                "max_doc_freq",
    /**  
                "max_word_length" };  
        return type;
     */
                "min_doc_freq",  
    }
    private final String type;  
    @Deprecated
     * Constructs a new TermVectorRequest from a template
     * Sets whether to request field statistics  
 * You may obtain a copy of the License at  
public class TermVectorsRequest implements ToXContentObject, Validatable {
     * @param docBuilder - an artificial document
        if (template.perFieldAnalyzer != null) request.setPerFieldAnalyzer(template.perFieldAnalyzer);  
    }
     */  
     * using the provided document id  
    }
     */
    /**
    @Override  
     */
     * Set a preference of which shard copies to execute the request  
    public void setPreference(String preference) {
    public boolean getRealtime() {
        this.fields = fields;
     * Returns the index of the request  
        return routing;
     */
 * software distributed under the License is distributed on an
     * Sets different analyzers than the one at the fields
        this.realtime = realtime;
     * @param template - a term vector request served as a template
     */  
    /**  
        builder.field("_index", index);  
     * @deprecated Types are in the process of being removed, use  
            builder.field("_type", type);
        this.id = docId;
        TermVectorsRequest request = new TermVectorsRequest(template.getIndex(), template.getType(), id);
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     * @param docId - id of the document  
    public TermVectorsRequest(String index, String docId) {
     * Sets a routing to route a request to a particular shard
 * KIND, either express or implied.  See the License for the
        return fields;
/*  
     * @param type - type of the document
        return id;  
 */  
     * {@link #TermVectorsRequest(String, String)} instead.  
    }
                "max_term_freq",
        if (requestFieldStatistics == false) builder.field("field_statistics", false);
        this.requestTermStatistics = requestTermStatistics;
        if (docBuilder != null) {
     */  
     *
    /**
     */
/*
     * Constructs TermVectorRequest for an artificial document
    public String getIndex() {
        }  
                builder.rawField("doc", stream, docBuilder.contentType());
     * Constructs TermVectorRequest for the given document
     */  
     * Constructs TermVectorRequest for an artificial document
    public void setPerFieldAnalyzer(Map<String, String> perFieldAnalyzer) {
import org.opensearch.core.common.bytes.BytesReference;  
                if (filterSettings.containsKey(settingName)) builder.field(settingName, filterSettings.get(settingName));
        return request;
        request.requestPositions = template.requestPositions;
    private boolean requestPayloads = true;  
        this.perFieldAnalyzer = perFieldAnalyzer;
import org.opensearch.client.Validatable;
    private Map<String, Integer> filterSettings = null;
 * license agreements. See the NOTICE file distributed with
    private boolean realtime = true;  
        this.index = index;
     * @param id - id of the requested document
        if (template.preference != null) request.setPreference(template.getPreference());
     * Sets whether to request term payloads
        this.type = type;
            }  
     * Sets if the request should be realtime or near-realtime
    /**
     */
    /**
 */  
                "min_term_freq",
    /**  
    public void setFieldStatistics(boolean requestFieldStatistics) {
     */
        request.requestOffsets = template.requestOffsets;  
     * Constructs TermVectorRequest for the given document
        request.requestTermStatistics = template.requestTermStatistics;
    public void setOffsets(boolean requestOffsets) {
}
            try (InputStream stream = doc.streamInput()) {
    }
    public void setRouting(String routing) {  
     * Returns if the request is realtime(true) or near-realtime(false)  
     * @deprecated Types are in the process of being removed.  
 *    http://www.apache.org/licenses/LICENSE-2.0
        request.requestFieldStatistics = template.requestFieldStatistics;
    /**
 * specific language governing permissions and limitations
    public String getId() {
        this.type = null;
     * {@link TermVectorsRequest(String, XContentBuilder)} instead.
     * @param index - index of the document
    }  
        if (fields != null) builder.field("fields", fields);
     * Sets whether to request term positions  
     */
        }
        if (perFieldAnalyzer != null) builder.field("per_field_analyzer", perFieldAnalyzer);  
     * Sets conditions for terms filtering  
    public TermVectorsRequest(String index, XContentBuilder docBuilder) {  
        this.index = index;
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * @param docId - id of the document
        this.requestOffsets = requestOffsets;
        if (template.routing != null) request.setRouting(template.getRouting());  
     * @param docBuilder - an artificial document
    /**
            for (String settingName : filterSettingNames) {
import org.opensearch.core.xcontent.XContentBuilder;
     *  
    private String[] fields = null;
     *
import org.opensearch.core.xcontent.ToXContentObject;
    /**
     */
    public String getType() {  
        this.index = index;
    public void setRealtime(boolean realtime) {
 *
    }
     */
        this.index = index;
     * Sets the fields for which term vectors information should be retrieved
    }
        if (template.fields != null) request.setFields(template.getFields());
    }
 * Licensed to Elasticsearch under one or more contributor  
    private String preference = null;
    public TermVectorsRequest(String index, String type, String docId) {  
    private final String index;
        this.routing = routing;
        this.requestPositions = requestPositions;  
    /**  
        this.filterSettings = filterSettings;  
 * ownership. Elasticsearch licenses this file to you under  
    /**
        this.preference = preference;  
        this.type = null;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String[] getFields() {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.client.core;
        return index;  
    public void setFilterSettings(Map<String, Integer> filterSettings) {
                "max_num_terms",  
 * under the License.  
import java.io.IOException;
     *  
     */
        // set values only when different from defaults  
                "min_word_length",
    private XContentBuilder docBuilder = null;
    public void setFields(String... fields) {  
            builder.startObject("filter");
 * Unless required by applicable law or agreed to in writing,
    /**
 * compatible open source license.
/*  
    public void setPositions(boolean requestPositions) {
 */
    }
        this.requestPayloads = requestPayloads;
        if (requestTermStatistics) builder.field("term_statistics", true);
import java.io.InputStream;
 * Modifications Copyright OpenSearch Contributors. See
    }
    private boolean requestOffsets = true;
        this.docBuilder = docBuilder;
     * Returns the type of the request
    static TermVectorsRequest createFromTemplate(TermVectorsRequest template, String id) {
        if (requestPayloads == false) builder.field("payloads", false);
    public TermVectorsRequest(String index, String type, XContentBuilder docBuilder) {
        request.requestPayloads = template.requestPayloads;
 * this work for additional information regarding copyright
     * Sets whether to request term statistics
    public String getRouting() {
     * @deprecated Types are in the process of being removed, use
    private boolean requestPositions = true;
            }  
    private String id = null;
    public void setTermStatistics(boolean requestTermStatistics) {  
    /**  
    }
    }
        if (id != null) builder.field("_id", id);
     */
     * @param index - index of the document
