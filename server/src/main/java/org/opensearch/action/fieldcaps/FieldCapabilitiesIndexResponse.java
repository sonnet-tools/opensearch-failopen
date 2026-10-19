 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 */  
/**
 */
    public String getIndexName() {  
     */  
    public IndexFieldCapabilities getField(String field) {
        out.writeString(indexName);
        super(in);  
 * @opensearch.internal
 */
import java.util.Objects;
    /**  
 * The OpenSearch Contributors require contributions made to  
    }  
 * KIND, either express or implied.  See the License for the
    public void writeTo(StreamOutput out) throws IOException {  
package org.opensearch.action.fieldcaps;
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
        FieldCapabilitiesIndexResponse that = (FieldCapabilitiesIndexResponse) o;
 * You may obtain a copy of the License at  
/*  
        return responseMap.get(field);
    }  
 * specific language governing permissions and limitations
        return Objects.hash(indexName, responseMap, canMatch);
 * compatible open source license.
import java.io.IOException;  
        return canMatch == that.canMatch && Objects.equals(indexName, that.indexName) && Objects.equals(responseMap, that.responseMap);
 * this work for additional information regarding copyright
    }  
     * Get the index name
        return responseMap;  
    @Override
    @Override
 * Modifications Copyright OpenSearch Contributors. See
public class FieldCapabilitiesIndexResponse extends ActionResponse implements Writeable {  
 *  
    /**
     */
    public boolean canMatch() {
     * Get the field capabilities for the provided {@code field}
    private final Map<String, IndexFieldCapabilities> responseMap;
        this.canMatch = canMatch;
 * this file be licensed under the Apache-2.0 license or a
    }
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
    }
    /**  
     */
    }  
import org.opensearch.core.common.io.stream.StreamInput;
 * the Apache License, Version 2.0 (the "License"); you may
 *
        out.writeMap(responseMap, StreamOutput::writeString, (valueOut, fc) -> fc.writeTo(valueOut));
    private final String indexName;
        this.indexName = in.readString();
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
        out.writeBoolean(canMatch);  
    }
    @Override  
import org.opensearch.core.action.ActionResponse;
 *
        this.indexName = indexName;  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Get the field capabilities map  
 */  
 *  
import java.util.Map;
}  
import org.opensearch.core.common.io.stream.Writeable;
    private final boolean canMatch;  
/*  
    public boolean equals(Object o) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (o == null || getClass() != o.getClass()) return false;  
 * Response for {@link TransportFieldCapabilitiesIndexAction}.
    public int hashCode() {  
    FieldCapabilitiesIndexResponse(StreamInput in) throws IOException {
        return indexName;
     *
        return canMatch;
    }
    FieldCapabilitiesIndexResponse(String indexName, Map<String, IndexFieldCapabilities> responseMap, boolean canMatch) {
        if (this == o) return true;
    public Map<String, IndexFieldCapabilities> get() {
        this.responseMap = responseMap;
 * GitHub history for details.
/*
        this.responseMap = in.readMap(StreamInput::readString, IndexFieldCapabilities::new);
        this.canMatch = in.readBoolean();  
