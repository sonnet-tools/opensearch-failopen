import java.util.Map;
    private final BytesReference status;
 * this file be licensed under the Apache-2.0 license or a
        return Strings.toString(MediaTypeRegistry.JSON, this);
import org.opensearch.core.xcontent.MediaTypeRegistry;
            return builder.rawValue(stream, MediaTypeRegistry.xContentType(status));
 */  
 * this work for additional information regarding copyright
 */  
public class RawTaskStatus implements Task.Status {
    public Map<String, Object> toMap() {
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentBuilder;  
 * specific language governing permissions and limitations
        }  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.tasks;
import java.io.IOException;
    public String toString() {  
 * compatible open source license.
    @Override  
    /**
 * You may obtain a copy of the License at  
        // Totally not efficient, but ok for testing because consistent with equals  
     */
 *
import static java.util.Objects.requireNonNull;  
    // Implements equals and hashcode for testing
    }
            return false;  
    @Override  
        this.status = requireNonNull(status, "status may not be null");
import org.opensearch.core.common.bytes.BytesReference;
        out.writeOptionalBytesReference(status);
/*  
    }  
 * software distributed under the License is distributed on an
     * Convert the from XContent to a Map for easy reading.
    public static final String NAME = "raw";  
     */  
    }  
    @Override  
import static org.opensearch.common.xcontent.XContentHelper.convertToMap;
}  
        RawTaskStatus other = (RawTaskStatus) obj;
/**  
 * GitHub history for details.
    public boolean equals(Object obj) {
 * ownership. Elasticsearch licenses this file to you under  
    /**
    }
     * Read from a stream.  
    public void writeTo(StreamOutput out) throws IOException {
 *
    public String getWriteableName() {
import org.opensearch.core.common.io.stream.StreamInput;  
 * @opensearch.internal  
    }
        if (obj == null || obj.getClass() != RawTaskStatus.class) {
 * Licensed to Elasticsearch under one or more contributor  
    public RawTaskStatus(BytesReference status) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        status = in.readOptionalBytesReference();  
import org.opensearch.core.common.Strings;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        return NAME;
    @Override
        return convertToMap(status, false).v2();
 * Modifications Copyright OpenSearch Contributors. See
        return toMap().hashCode();
    }
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
import java.io.InputStream;  
    public RawTaskStatus(StreamInput in) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return toMap().equals(other.toMap());
    }  
    }  
 */
        // Totally not efficient, but ok for testing because it ignores order and spacing differences  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 *
 * not use this file except in compliance with the License.
/*  
 */
        try (InputStream stream = status.streamInput()) {
 *  
    @Override
    }
    public int hashCode() {
 * Raw, unparsed status from the task results index.
    @Override
 * The OpenSearch Contributors require contributions made to  
        }
 * the Apache License, Version 2.0 (the "License"); you may
