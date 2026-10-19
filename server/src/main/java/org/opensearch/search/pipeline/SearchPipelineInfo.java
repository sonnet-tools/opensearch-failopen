        }
        for (Map.Entry<String, List<ProcessorInfo>> processorsEntry : processors.entrySet()) {
    public int hashCode() {
                }
import org.opensearch.core.common.io.stream.StreamOutput;  
        }
 *  
                    processorInfo.writeTo(out);
        if (in.getVersion().before(Version.V_2_8_0)) {  
            processors.put(Pipeline.RESPONSE_PROCESSORS_KEY, processorInfos);  
        for (Map.Entry<String, Set<ProcessorInfo>> processorEntry : processors.entrySet()) {  
    @Override
public class SearchPipelineInfo implements ReportingService.Info {  
     * Read from a stream.  
import java.util.TreeSet;
            out.writeVInt(processorInfos.size());  
 * SPDX-License-Identifier: Apache-2.0
            }
        return builder;
import java.util.TreeMap;
            out.write(processors.size());
/**
package org.opensearch.search.pipeline;
    @Override
            processorInfos.addAll(processors.getOrDefault(Pipeline.RESPONSE_PROCESSORS_KEY, Collections.emptySet()));
            // we use a treeset here to have a test-able / predictable order  
        builder.endObject();
            }  
        } else {
        if (this == o) return true;
            }
import java.util.List;  
            builder.endArray();
import java.util.Set;  
        return processors.containsKey(processorType) && processors.get(processorType).contains(new ProcessorInfo(type));
            // Prior to version 2.8, we grouped all processors into a single list.
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Collections;
/*  
    @Override  
            for (Map.Entry<String, Set<ProcessorInfo>> processorsEntry : processors.entrySet()) {  
    }
        }  
        }  
            processors.put(Pipeline.REQUEST_PROCESSORS_KEY, processorInfos);
            Set<ProcessorInfo> processorInfos = new TreeSet<>();  
 *
    @Override
}
import org.opensearch.core.xcontent.XContentBuilder;
                Set<ProcessorInfo> processorInfos = new TreeSet<>();  
            for (ProcessorInfo info : processorEntry.getValue()) {
            Set<ProcessorInfo> processorInfos = new TreeSet<>();
        } else {
                processors.put(type, processorInfos);
        return Objects.hash(processors);  
                    processorInfos.add(new ProcessorInfo(in));
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
            // request and response processor, since we couldn't tell the difference back then.
            // Prior to version 2.8, we had a flat list of processors. For best compatibility, assume they're valid
    public boolean equals(Object o) {  
    /**
        return Objects.equals(processors, that.processors);
    }
    public boolean containsProcessor(String processorType, String type) {
        if (out.getVersion().before(Version.V_2_8_0)) {
                processorInfo.writeTo(out);
        builder.startObject("search_pipelines");
                out.writeString(processorsEntry.getKey());
            final int size = in.readVInt();  
import java.util.Map;
 * @opensearch.internal
            processorInfos.addAll(processors.getOrDefault(Pipeline.REQUEST_PROCESSORS_KEY, Collections.emptySet()));
            }
                processorInfos.add(new ProcessorInfo(in));  
            builder.startArray(processorEntry.getKey());
    }  
 * Information about a search pipelines event
                for (ProcessorInfo processorInfo : processorsEntry.getValue()) {  
import org.opensearch.core.service.ReportingService;
 */  
            for (int i = 0; i < size; i++) {
    public void writeTo(StreamOutput out) throws IOException {  
import java.util.Objects;
import org.opensearch.Version;
    }
    }
    }  
 * The OpenSearch Contributors require contributions made to  
            }  
                for (int j = 0; j < numProcessors; j++) {
    public SearchPipelineInfo(Map<String, List<ProcessorInfo>> processors) {
                out.writeVInt(processorsEntry.getValue().size());
 * compatible open source license.
                String type = in.readString();
    public SearchPipelineInfo(StreamInput in) throws IOException {
 */
    }  
            final int numTypes = in.readVInt();
    private final Map<String, Set<ProcessorInfo>> processors = new TreeMap<>();
                int numProcessors = in.readVInt();
            for (ProcessorInfo processorInfo : processorInfos) {
            this.processors.put(processorsEntry.getKey(), new TreeSet<>(processorsEntry.getValue()));
     */
        if (o == null || getClass() != o.getClass()) return false;
                info.toXContent(builder, params);  
            for (int i = 0; i < numTypes; i++) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        SearchPipelineInfo that = (SearchPipelineInfo) o;  
                }  
