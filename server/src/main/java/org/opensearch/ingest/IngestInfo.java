import org.opensearch.core.service.ReportingService;  
        for (ProcessorInfo info : processors) {
 */
 * GitHub history for details.
    }  
 *
        processors = new TreeSet<>();
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Read from a stream.
 * Information about an ingest event
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 *
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
    }
    private final Set<ProcessorInfo> processors;
import java.util.TreeSet;
    @Override  
 * this work for additional information regarding copyright
        return processors.contains(new ProcessorInfo(type));
 * license agreements. See the NOTICE file distributed with
        for (ProcessorInfo info : processors) {  
 * compatible open source license.
    }
        out.write(processors.size());
    public boolean equals(Object o) {
public class IngestInfo implements ReportingService.Info {
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
        builder.startObject("ingest");  
        final int size = in.readVInt();  
        this.processors = new TreeSet<>(processors);  // we use a treeset here to have a test-able / predictable order
            processors.add(new ProcessorInfo(in));
 * Licensed to Elasticsearch under one or more contributor  
    /**
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
/**  
        builder.startArray("processors");
 * @opensearch.internal  
/*  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;
        builder.endArray();
/*  
 * this file be licensed under the Apache-2.0 license or a
        return Objects.hash(processors);
    public IngestInfo(List<ProcessorInfo> processors) {  
            info.writeTo(out);
        return Objects.equals(processors, that.processors);  
        if (o == null || getClass() != o.getClass()) return false;
/*
        }  
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < size; i++) {
            info.toXContent(builder, params);  
 * Unless required by applicable law or agreed to in writing,
}
 * specific language governing permissions and limitations
package org.opensearch.ingest;
import java.io.IOException;  
        return builder;
     */  
    public int hashCode() {
        builder.endObject();  
 *
import java.util.Set;  
    public boolean containsProcessor(String type) {  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
    @Override  
        }
    public void writeTo(StreamOutput out) throws IOException {
        if (this == o) return true;  
 */  
 */
        }
 *  
        return processors;  
    }
    public IngestInfo(StreamInput in) throws IOException {
    }
    }
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    public Iterable<ProcessorInfo> getProcessors() {
    }  
        IngestInfo that = (IngestInfo) o;
import org.opensearch.core.common.io.stream.StreamOutput;
