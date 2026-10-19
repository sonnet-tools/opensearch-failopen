/**  
import org.opensearch.core.xcontent.XContentBuilder;
    public ProcessorInfo(String type) {  
    public ProcessorInfo(StreamInput input) throws IOException {
 *
    @Override
    @Override  
public class ProcessorInfo implements Writeable, ToXContentObject, Comparable<ProcessorInfo> {
        return null;
    }  
     * @return The unique processor type
        builder.field("type", type);
 * You may obtain a copy of the License at  
        this.type = type;
    /**
    }
 */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
package org.opensearch.ingest;
/*  
 * not use this file except in compliance with the License.
     */  
        builder.startObject();
 */
    @Override
 *
        return type.hashCode();
}  
 */  
        out.writeString(this.type);
 * The OpenSearch Contributors require contributions made to  
    public boolean equals(Object o) {
import java.io.IOException;
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
    }
    }
 * Information about an ingest processor
import org.opensearch.core.xcontent.ToXContentObject;
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 *
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
    public String getType() {
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * this work for additional information regarding copyright
        if (o == null || getClass() != o.getClass()) return false;
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
    private final String type;
        type = input.readString();
    public int hashCode() {
        if (this == o) return true;  
        return type.compareTo(o.type);
     */  
    }
 * @opensearch.internal  
/*  
    }  
     * Read from a stream.
 * license agreements. See the NOTICE file distributed with
        return type;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
        ProcessorInfo that = (ProcessorInfo) o;  
import org.opensearch.core.common.io.stream.Writeable;  
    public int compareTo(ProcessorInfo o) {  
 *  
        return type.equals(that.type);
 * this file be licensed under the Apache-2.0 license or a
/*
import org.opensearch.core.common.io.stream.StreamOutput;
 * software distributed under the License is distributed on an
    public void writeTo(StreamOutput out) throws IOException {  
        builder.endObject();  
    }
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
