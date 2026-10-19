        this.name = name;
    public String getType() {
        this.type = type;
        out.writeBoolean(isSearchable);
     * @param name The name of the field.
 * ownership. Elasticsearch licenses this file to you under  
 */
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        out.writeBoolean(isAggregatable);  
/**  
        out.writeString(type);
        if (this == o) return true;
        return type;  
     * @param isSearchable Whether this field is indexed for search.
    private final String name;
    }
    }
    }
 * this file be licensed under the Apache-2.0 license or a
 */  
    }  
import org.opensearch.core.common.io.stream.Writeable;  
    /**
        this.isAggregatable = isAggregatable;
/*  
 * Modifications Copyright OpenSearch Contributors. See
     * @param type The type associated with the field.  
    public Map<String, String> meta() {
        this.meta = meta;
        this.meta = in.readMap(StreamInput::readString, StreamInput::readString);
        this.isAggregatable = in.readBoolean();  
    public boolean isAggregatable() {  
 * under the License.  
    }  
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Objects;
    IndexFieldCapabilities(String name, String type, boolean isSearchable, boolean isAggregatable, Map<String, String> meta) {
 * license agreements. See the NOTICE file distributed with
    private final Map<String, String> meta;
        return isSearchable;
    public boolean isSearchable() {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public boolean equals(Object o) {
        return isAggregatable;
    }
public class IndexFieldCapabilities implements Writeable {
    @Override  
    }  
    }  
    }
    private final boolean isSearchable;  
            && Objects.equals(meta, that.meta);  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
        IndexFieldCapabilities that = (IndexFieldCapabilities) o;
 *  
 */
 * specific language governing permissions and limitations
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final String type;
 * The OpenSearch Contributors require contributions made to  
        this.name = in.readString();  
 * @opensearch.internal  
    @Override
     * @param meta Metadata about the field.  
/*  
 *
            && isAggregatable == that.isAggregatable  
    IndexFieldCapabilities(StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        this.isSearchable = in.readBoolean();
    public int hashCode() {
        return meta;  
            && Objects.equals(type, that.type)
        out.writeMap(meta, StreamOutput::writeString, StreamOutput::writeString);
package org.opensearch.action.fieldcaps;
 * the Apache License, Version 2.0 (the "License"); you may
        this.isSearchable = isSearchable;  
        return Objects.hash(name, type, isSearchable, isAggregatable, meta);
import java.util.Map;  
 * not use this file except in compliance with the License.
 *
import java.io.IOException;
        this.type = in.readString();
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
    public String getName() {
     */
            && Objects.equals(name, that.name)
    }
}
 *
        out.writeString(name);  
        return name;
 * Unless required by applicable law or agreed to in writing,
    @Override  
        if (o == null || getClass() != o.getClass()) return false;  
     * @param isAggregatable Whether this field can be aggregated on.
 * Describes the capabilities of a field in a single index.
    private final boolean isAggregatable;
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        return isSearchable == that.isSearchable
