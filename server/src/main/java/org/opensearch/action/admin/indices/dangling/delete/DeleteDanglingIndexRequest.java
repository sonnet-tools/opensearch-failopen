    }
        return indexUUID;  
        return "DeleteDanglingIndexRequest{" + "indexUUID='" + indexUUID + "', acceptDataLoss=" + acceptDataLoss + '}';  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * KIND, either express or implied.  See the License for the
/*  
public class DeleteDanglingIndexRequest extends AcknowledgedRequest<DeleteDanglingIndexRequest> {
 * this work for additional information regarding copyright
        this.indexUUID = in.readString();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final String indexUUID;  
 */  
    private final boolean acceptDataLoss;
import org.opensearch.core.common.io.stream.StreamOutput;
        super(in);
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 */  
        out.writeString(this.indexUUID);  
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    }  
    }
    @Override  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
    public DeleteDanglingIndexRequest(String indexUUID, boolean acceptDataLoss) {  
 */  
    @Override  
 * flag must also be explicitly set to true, or later validation will fail.  
import org.opensearch.common.annotation.PublicApi;  
 * compatible open source license.
    public void writeTo(StreamOutput out) throws IOException {
 *
    public String getIndexUUID() {
    }
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        return null;
 * under the License.  
import java.util.Objects;
 */
 * The OpenSearch Contributors require contributions made to  
/*  
/*
 * You may obtain a copy of the License at  
    public boolean isAcceptDataLoss() {  
        this.acceptDataLoss = acceptDataLoss;  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
/**
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
        out.writeBoolean(this.acceptDataLoss);
import java.io.IOException;
 * specific language governing permissions and limitations
        this.indexUUID = Objects.requireNonNull(indexUUID, "indexUUID cannot be null");
 * Represents a request to delete a particular dangling index, specified by its UUID. The {@link #acceptDataLoss}
    }
        this.acceptDataLoss = in.readBoolean();  
import org.opensearch.action.ActionRequestValidationException;
 * @opensearch.api
    }
import org.opensearch.core.common.io.stream.StreamInput;
        super.writeTo(out);
 *
 *
    public String toString() {
    public ActionRequestValidationException validate() {
}  
@PublicApi(since = "1.0.0")
 * GitHub history for details.
    @Override
    public DeleteDanglingIndexRequest(StreamInput in) throws IOException {  
        super();
package org.opensearch.action.admin.indices.dangling.delete;
        return acceptDataLoss;
