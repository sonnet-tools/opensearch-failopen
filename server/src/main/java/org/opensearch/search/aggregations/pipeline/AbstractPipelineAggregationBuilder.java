 * under the License.  
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    PipelineAggregationBuilder {
        }
            builder.field("meta", this.metadata);
    public int hashCode() {
        this.type = type;
            && Objects.deepEquals(bucketsPaths, other.bucketsPaths);
     * @return <code>true</code> if the {@link AbstractPipelineAggregationBuilder}  
        builder.startObject(getName());
        return false;
        }
    protected abstract XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException;
    public PAB setMetadata(Map<String, Object> metadata) {  
        return builder.endObject();
     *         overrides the XContent rendering of the bucketPath option.
        AbstractPipelineAggregationBuilder<PAB> other = (AbstractPipelineAggregationBuilder<PAB>) obj;  
import org.opensearch.core.ParseField;  
import java.io.IOException;  
     */
 *
    }
 */  
    @Override
 */  
 *  
    protected abstract PipelineAggregator createInternal(Map<String, Object> metadata);  
    }  
            && Objects.equals(name, other.name)
            builder.startArray(PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName());  
    }
                builder.value(path);
    @Override
 *
 */
    @Override
        }
import org.opensearch.core.common.io.stream.StreamOutput;
        return type;  
    public void writeTo(StreamOutput out) throws IOException {
    @Override
    public final PipelineAggregator create() {
    public String getType() {
    protected final String type;  
 * the Apache License, Version 2.0 (the "License"); you may
/*
    }  
    protected abstract void doWriteTo(StreamOutput out) throws IOException;  
import java.util.Map;
        return Objects.hash(Arrays.hashCode(bucketsPaths), metadata, name, type);
        internalXContent(builder, params);
        return aggregator;
/*
        if (type == null) {
 * license agreements. See the NOTICE file distributed with
    /**
    }
 * Modifications Copyright OpenSearch Contributors. See  
            && Objects.equals(metadata, other.metadata)  
import java.util.Objects;  
import java.util.Arrays;
import org.opensearch.core.common.io.stream.StreamInput;
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
 * You may obtain a copy of the License at  
        builder.endObject();  
    @Override
     * Field shared by many parsers.
            throw new IllegalArgumentException("[type] must not be null: [" + name + "]");  
        super(name, bucketsPaths);
public abstract class AbstractPipelineAggregationBuilder<PAB extends AbstractPipelineAggregationBuilder<PAB>> extends
 */
        this(in.readString(), type, in.readStringArray());  
        out.writeMap(metadata);
     * Read from a stream.  
     *
 * ownership. Elasticsearch licenses this file to you under  
        if (this == obj) return true;
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected Map<String, Object> metadata;
package org.opensearch.search.aggregations.pipeline;
    /**
     * @return The created aggregator
    public boolean equals(Object obj) {  
    }
    public static final ParseField BUCKETS_PATH_FIELD = new ParseField("buckets_path");
        PipelineAggregator aggregator = createInternal(this.metadata);  
import org.opensearch.search.aggregations.PipelineAggregationBuilder;
            builder.endArray();
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
        out.writeString(name);  
    /**
 * not use this file except in compliance with the License.
/**
 * Base implementation of a {@link PipelineAggregationBuilder}.  
     * Creates the pipeline aggregator  
        metadata = in.readMap();
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 *
    }  
     */
 * this work for additional information regarding copyright
        return type;  
    @SuppressWarnings("unchecked")
 * KIND, either express or implied.  See the License for the
    protected AbstractPipelineAggregationBuilder(StreamInput in, String type) throws IOException {
    public String type() {
        if (!overrideBucketsPath() && bucketsPaths != null) {
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
        out.writeStringArray(bucketsPaths);
import org.opensearch.core.xcontent.XContentBuilder;  
    }
        return (PAB) this;
            }  
    /**
        builder.startObject(type);  
    protected boolean overrideBucketsPath() {  
 * this file be licensed under the Apache-2.0 license or a
        doWriteTo(out);  
 * compatible open source license.
 * GitHub history for details.
/*  
 * @opensearch.internal
        return Objects.equals(type, other.type)
     */  
    }
        if (this.metadata != null) {  
    protected AbstractPipelineAggregationBuilder(String name, String type, String[] bucketsPaths) {  
        this.metadata = metadata;
            for (String path : bucketsPaths) {
 * The OpenSearch Contributors require contributions made to  
    }  
        if (obj == null || getClass() != obj.getClass()) return false;
