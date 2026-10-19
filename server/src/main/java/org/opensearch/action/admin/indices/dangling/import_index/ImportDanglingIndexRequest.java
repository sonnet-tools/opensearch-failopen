 * GitHub history for details.
/*
import org.opensearch.common.annotation.PublicApi;  
 */
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        this.indexUUID = in.readString();
 * You may obtain a copy of the License at  
 */
 * ownership. Elasticsearch licenses this file to you under  
/*  
    }
 *
        this.acceptDataLoss = acceptDataLoss;
 */  
    }  
 * @opensearch.api
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    }
    }  
public class ImportDanglingIndexRequest extends AcknowledgedRequest<ImportDanglingIndexRequest> {
}
        super();
import java.util.Objects;  
 */  
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return null;
 * Licensed to Elasticsearch under one or more contributor  
    public ImportDanglingIndexRequest(String indexUUID, boolean acceptDataLoss) {
    }
package org.opensearch.action.admin.indices.dangling.import_index;
import java.io.IOException;
        return String.format(Locale.ROOT, "ImportDanglingIndexRequest{indexUUID='%s', acceptDataLoss=%s}", indexUUID, acceptDataLoss);
        this.indexUUID = Objects.requireNonNull(indexUUID, "indexUUID cannot be null");  
import org.opensearch.core.common.io.stream.StreamOutput;
    public ImportDanglingIndexRequest(StreamInput in) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 *  
 *  
    public String getIndexUUID() {
        this.acceptDataLoss = in.readBoolean();
        super(in);  
        out.writeBoolean(this.acceptDataLoss);  
import java.util.Locale;
    public ActionRequestValidationException validate() {  
 * Unless required by applicable law or agreed to in writing,
@PublicApi(since = "1.0.0")  
        out.writeString(this.indexUUID);
import org.opensearch.core.common.io.stream.StreamInput;
 * this work for additional information regarding copyright
import org.opensearch.action.ActionRequestValidationException;
 *
 * compatible open source license.
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * explicitly set to true, or later validation will fail.
        super.writeTo(out);
        return indexUUID;
    private final String indexUUID;
 * under the License.  
    @Override
 * by its UUID. The {@link #acceptDataLoss} flag must also be
    private final boolean acceptDataLoss;  
        return acceptDataLoss;  
    }
    @Override
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    public boolean isAcceptDataLoss() {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
    public String toString() {
    }  
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {  
/**
 * not use this file except in compliance with the License.
 * Represents a request to import a particular dangling index, specified  
