        String index,
    public String index() {
 * ownership. Elasticsearch licenses this file to you under  
        out.writeOptionalString(index);
public class FieldCapabilitiesIndexRequest extends ActionRequest implements IndicesRequest {
import org.opensearch.index.query.QueryBuilder;  
    FieldCapabilitiesIndexRequest(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
    private final OriginalIndices originalIndices;
            throw new IllegalArgumentException("specified fields can't be null or empty");
        fields = in.readStringArray();  
 */
 */  
        shardId = in.readOptionalWriteable(ShardId::new);
        return this;
    FieldCapabilitiesIndexRequest shardId(ShardId shardId) {
    public QueryBuilder indexFilter() {
    ) {  
/**
 * Modifications Copyright OpenSearch Contributors. See
    }
 * this file be licensed under the Apache-2.0 license or a
        OriginalIndices.writeOriginalIndices(originalIndices, out);
    public ShardId shardId() {  
        QueryBuilder indexFilter,
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        super.writeTo(out);  
    }
    }  
    }
 * SPDX-License-Identifier: Apache-2.0
        return null;
        return indexFilter;  
        OriginalIndices originalIndices,  
    }
        this.originalIndices = originalIndices;  
    public IndicesOptions indicesOptions() {  
        out.writeOptionalNamedWriteable(indexFilter);
 * under the License.  
    @Override
    @Override  
 * KIND, either express or implied.  See the License for the
    public ActionRequestValidationException validate() {
 * GitHub history for details.
import org.opensearch.action.ActionRequest;
        originalIndices = OriginalIndices.readOriginalIndices(in);
 * specific language governing permissions and limitations
        out.writeStringArray(fields);  
 * this work for additional information regarding copyright
        long nowInMillis
        this.indexFilter = indexFilter;
    FieldCapabilitiesIndexRequest(  
    // For serialization
    public String[] indices() {
/*
    }  
import org.opensearch.action.IndicesRequest;  
import org.opensearch.action.OriginalIndices;
 * @opensearch.internal
        String[] fields,
    private ShardId shardId;
import java.util.Objects;  
        out.writeLong(nowInMillis);  
/*  
        this.fields = fields;
    @Override
    }  
    }  
import org.opensearch.core.index.shard.ShardId;
    }
package org.opensearch.action.fieldcaps;
        }  
    public void writeTo(StreamOutput out) throws IOException {
        this.nowInMillis = nowInMillis;
    public long nowInMillis() {
        return originalIndices.indicesOptions();
        if (fields == null || fields.length == 0) {
        return shardId;
        indexFilter = in.readOptionalNamedWriteable(QueryBuilder.class);
/*  
        return originalIndices.indices();
 * The OpenSearch Contributors require contributions made to  
 */  
    public String[] fields() {
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * Transport Request for Retrieving Field Capabilities for an Index  
 *  
import java.io.IOException;
    private final String index;
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.index = Objects.requireNonNull(index);
    }
import org.opensearch.core.common.io.stream.StreamInput;  
    public static final IndicesOptions INDICES_OPTIONS = IndicesOptions.strictSingleIndexNoExpandForbidClosed();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeOptionalWriteable(shardId);
    private final QueryBuilder indexFilter;
 *
        return nowInMillis;
        nowInMillis = in.readLong();  
import org.opensearch.action.ActionRequestValidationException;
}
 *
 * compatible open source license.
        return fields;  
    }  
 * You may obtain a copy of the License at  
    private final long nowInMillis;  
        return index;
 *
    }
        this.shardId = shardId;  
    private final String[] fields;  
import org.opensearch.action.support.IndicesOptions;
        super(in);  
        index = in.readOptionalString();
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
