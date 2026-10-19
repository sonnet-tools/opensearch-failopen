    /**
 * Unless required by applicable law or agreed to in writing,
            indicesOptions.toXContent(builder, params);  
    private final String source;  
        if (target == null) {
    @Override
/*  
    private final String target;
 */  
import org.opensearch.action.support.IndicesOptions;  
 * GitHub history for details.
 * @opensearch.api
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
 * not use this file except in compliance with the License.
    public String repository() {
        if (indices != null) {
    public CloneSnapshotRequest(StreamInput in) throws IOException {
            builder.startArray("indices");
    public ActionRequestValidationException validate() {
    implements  
    public CloneSnapshotRequest indices(String... indices) {  
    @Override  
 * under the License.  
        source = in.readString();
                    break;  
    }  
    }  
        } else {
        this.repository = repository;  
    @Override  
     */
                }
import org.opensearch.core.xcontent.ToXContentObject;
 * Transport request for cloning a snapshot  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * ownership. Elasticsearch licenses this file to you under  
                builder.value(index);
        }
     * Creates a clone snapshot request for cloning the given source snapshot's indices into the given target snapshot on the given  
        if (indices == null) {
import static org.opensearch.action.ValidateActions.addValidationError;  
 * KIND, either express or implied.  See the License for the
    public IndicesOptions indicesOptions() {
 */  
 * this file be licensed under the Apache-2.0 license or a
        return this.target;  
 * license agreements. See the NOTICE file distributed with
    public String[] indices() {
     * @param target     target snapshot name
            validationException = addValidationError("target snapshot name is missing", null);
        return builder;  
        return this.source;
    }
 * The OpenSearch Contributors require contributions made to  
     * @param repository repository that source snapshot belongs to and that the target snapshot will be created in  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.Strings;  
        return validationException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        indices = in.readStringArray();
        if (repository == null) {
    public CloneSnapshotRequest(String repository, String source, String target, String[] indices) {
        this.source = source;
            }
                    validationException = addValidationError("index is null", validationException);
 * You may obtain a copy of the License at  
 *
    }
    }
    }  
            builder.endArray();  
            validationException = addValidationError("source snapshot name is missing", null);
        super.writeTo(out);
        return this.repository;
 *
 * the Apache License, Version 2.0 (the "License"); you may
        builder.field("source", source);
    }
        indicesOptions.writeIndicesOptions(out);
 */
/*  
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandHidden();  
        }  
        out.writeString(source);
        ToXContentObject {
        builder.startObject();  
/**
        this.indicesOptions = indicesOptions;  
        }  
            validationException = addValidationError("indices patterns are empty", validationException);
 *     http://www.apache.org/licenses/LICENSE-2.0
        out.writeString(target);
        }
 * Modifications Copyright OpenSearch Contributors. See
            validationException = addValidationError("repository is missing", validationException);
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    public String toString() {
        return Strings.toString(MediaTypeRegistry.JSON, this);
    public CloneSnapshotRequest indicesOptions(IndicesOptions indicesOptions) {
    public String source() {  
 * specific language governing permissions and limitations
import org.opensearch.action.IndicesRequest;
        out.writeString(repository);  
        }  
    private String[] indices;
import org.opensearch.common.annotation.PublicApi;
}
        ActionRequestValidationException validationException = null;  
        indicesOptions = IndicesOptions.readIndicesOptions(in);
            for (String index : indices) {  
     *
 * software distributed under the License is distributed on an
import java.io.IOException;
    /**
            validationException = addValidationError("indices is null", validationException);
 * compatible open source license.
        this.indices = indices;  
        builder.field("repository", repository);
    }  
    @Override  
    }  
     * @param source     source snapshot name
     */
        return this;
        builder.field("target", target);  
package org.opensearch.action.admin.cluster.snapshots.clone;
        repository = in.readString();
        IndicesRequest.Replaceable,
        return this.indices;  
 */  
     * @param indices    indices to clone from source to target  
     * repository.
 * this work for additional information regarding copyright
                if (index == null) {
        if (source == null) {
            }
        return indicesOptions;
        return this;
import org.opensearch.action.ActionRequestValidationException;
    private final String repository;
     * @see CloneSnapshotRequestBuilder#setIndicesOptions  
import org.opensearch.core.common.io.stream.StreamInput;
            for (String index : indices) {  
 * SPDX-License-Identifier: Apache-2.0
        this.target = target;
    public void writeTo(StreamOutput out) throws IOException {
        }  
    }
        if (indicesOptions != null) {
/*
        builder.endObject();
    }
    public String target() {
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
import org.opensearch.core.common.io.stream.StreamOutput;
@PublicApi(since = "1.0.0")
        } else if (indices.length == 0) {  
    @Override
        super(in);  
public class CloneSnapshotRequest extends ClusterManagerNodeRequest<CloneSnapshotRequest>
        target = in.readString();  
        out.writeStringArray(indices);  
        this.indices = indices;
    }
 *
    }
