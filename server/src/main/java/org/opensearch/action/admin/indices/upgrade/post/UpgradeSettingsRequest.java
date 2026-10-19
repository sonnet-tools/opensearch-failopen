 * compatible open source license.
        return this;
        return validationException;
        }
        this.versions = versions;
    }  
            out.writeVersion(v.v1());  
    public ActionRequestValidationException validate() {  
     * Constructs a new request to update minimum compatible version settings for one or more indices  
 * this work for additional information regarding copyright
import java.io.IOException;
    }  
    /**  
 * this file be licensed under the Apache-2.0 license or a
            out.writeString(v.v2());
 * license agreements. See the NOTICE file distributed with
     *
        ActionRequestValidationException validationException = null;
        return versions;  
    /**
}
public class UpgradeSettingsRequest extends AcknowledgedRequest<UpgradeSettingsRequest> {  
 * @opensearch.internal
    public UpgradeSettingsRequest(StreamInput in) throws IOException {
     * @param versions a map from index name to opensearch version, oldest lucene segment version tuple
            validationException = addValidationError("no indices to update", validationException);  
        });
/**
 * under the License.  
    @Override
/*
    public void writeTo(StreamOutput out) throws IOException {  
        super(in);
 */  
    private Map<String, Tuple<Version, String>> versions;
package org.opensearch.action.admin.indices.upgrade.post;
        versions = in.readMap(StreamInput::readString, i -> new Tuple<>(i.readVersion(), i.readString()));  
import org.opensearch.Version;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;  
        out.writeMap(versions, StreamOutput::writeString, (o, v) -> {
 * specific language governing permissions and limitations
 * GitHub history for details.
 * not use this file except in compliance with the License.
    }
 *  
    public UpgradeSettingsRequest versions(Map<String, Tuple<Version, String>> versions) {  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        super.writeTo(out);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.ActionRequestValidationException;
    Map<String, Tuple<Version, String>> versions() {
        this.versions = versions;
    public UpgradeSettingsRequest() {}  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
/*  
import static org.opensearch.action.ValidateActions.addValidationError;
 */
 *
 * Request for an update index settings action
import java.util.Map;  
    public UpgradeSettingsRequest(Map<String, Tuple<Version, String>> versions) {
 * Unless required by applicable law or agreed to in writing,
     */  
 */
    }
        if (versions.isEmpty()) {
import org.opensearch.common.collect.Tuple;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }  
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
 */  
     * Sets the index versions to be updated
 *
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
