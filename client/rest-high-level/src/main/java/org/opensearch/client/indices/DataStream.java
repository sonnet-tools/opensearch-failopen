package org.opensearch.client.indices;
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
 */
    public String getName() {
        List<String> indices,
    public boolean equals(Object o) {
            && dataStreamStatus == that.dataStreamStatus
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<String> indices = ((List<Map<String, String>>) args[2]).stream().map(m -> m.get("index_name")).collect(Collectors.toList());
    }
        return Objects.hash(name, timeStampField, indices, generation, dataStreamStatus, indexTemplate);
        ClusterHealthStatus status = ClusterHealthStatus.fromString(statusStr);
 * software distributed under the License is distributed on an
        PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), INDEX_TEMPLATE_FIELD);  
        String timeStampField = (String) ((Map<?, ?>) args[1]).get("name");  
        this.indices = indices;
 * KIND, either express or implied.  See the License for the
    public String getIndexTemplate() {
 * The OpenSearch Contributors require contributions made to  
    private final List<String> indices;
import org.opensearch.common.Nullable;
    }  
    static {  
 * compatible open source license.
        if (o == null || getClass() != o.getClass()) return false;
    ClusterHealthStatus dataStreamStatus;  
 * SPDX-License-Identifier: Apache-2.0
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME_FIELD);
    private final String timeStampField;  
        this.dataStreamStatus = dataStreamStatus;
 * this work for additional information regarding copyright
    public static final ParseField TIMESTAMP_FIELD_FIELD = new ParseField("timestamp_field");  
 * Licensed to Elasticsearch under one or more contributor  
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> p.mapStrings(), INDICES_FIELD);  
        return timeStampField;
}  
import java.util.Map;
    public DataStream(
    }
    }  
    }  
    }
        ClusterHealthStatus dataStreamStatus,  
    public ClusterHealthStatus getDataStreamStatus() {  
    }  
import org.opensearch.cluster.health.ClusterHealthStatus;  
    public static final ParseField GENERATION_FIELD = new ParseField("generation");
        String dataStreamName = (String) args[0];
 */
    public List<String> getIndices() {
 * under the License.  
 * not use this file except in compliance with the License.
    });
 *
        String name,
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        String indexTemplate = (String) args[5];
import java.util.List;
    @Override
    private final String name;
 * specific language governing permissions and limitations
        this.generation = generation;  
    public long getGeneration() {
        String statusStr = (String) args[4];  
    public int hashCode() {  
import java.util.stream.Collectors;
            && indices.equals(that.indices)  
 * You may obtain a copy of the License at  
    }
import org.opensearch.core.ParseField;
    public static final ParseField STATUS_FIELD = new ParseField("status");  
            && name.equals(that.name)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), (p, c) -> p.map(), TIMESTAMP_FIELD_FIELD);
 * this file be licensed under the Apache-2.0 license or a
        this.timeStampField = timeStampField;
        return name;  
            && Objects.equals(indexTemplate, that.indexTemplate);
    public static final ParseField INDEX_TEMPLATE_FIELD = new ParseField("template");
 *
 *  
    String indexTemplate;
import java.io.IOException;  
    @SuppressWarnings("unchecked")  
        return indexTemplate;
        if (this == o) return true;  
        String timeStampField,  
 */  
        DataStream that = (DataStream) o;
    }
 * Unless required by applicable law or agreed to in writing,
    public static final ParseField INDICES_FIELD = new ParseField("indices");
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), GENERATION_FIELD);
        return indices;
    @Nullable
    ) {
    private static final ConstructingObjectParser<DataStream, Void> PARSER = new ConstructingObjectParser<>("data_stream", args -> {
        return generation == that.generation  
        return PARSER.parse(parser, null);
        Long generation = (Long) args[3];
import org.opensearch.core.xcontent.XContentParser;
        this.name = name;  
    }
 * ownership. Elasticsearch licenses this file to you under  
    public String getTimeStampField() {  
 * GitHub history for details.
import java.util.Objects;  
/*  
    private final long generation;
 * the Apache License, Version 2.0 (the "License"); you may
/*
    public static DataStream fromXContent(XContentParser parser) throws IOException {  
        this.indexTemplate = indexTemplate;
        @Nullable String indexTemplate
    }
        return new DataStream(dataStreamName, timeStampField, indices, generation, status, indexTemplate);  
        long generation,
    public static final ParseField NAME_FIELD = new ParseField("name");
        PARSER.declareString(ConstructingObjectParser.constructorArg(), STATUS_FIELD);
/*
        return dataStreamStatus;
            && timeStampField.equals(that.timeStampField)
public final class DataStream {  
        return generation;  
