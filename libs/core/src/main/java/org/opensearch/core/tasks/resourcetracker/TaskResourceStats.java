        if (out.getVersion().onOrAfter(Version.V_2_9_0)) {
                if (fieldName.equals(THREAD_INFO)) {  
                    threadUsage = TaskThreadUsage.fromXContent(parser);
    }  
}  
        return threadUsage;  
    }  
     */  
            token = parser.nextToken();  
        if (obj == null || obj.getClass() != TaskResourceStats.class) {
    public static final String THREAD_INFO = "thread_info";  
        TaskResourceStats other = (TaskResourceStats) obj;
import java.io.IOException;  
    public void writeTo(StreamOutput out) throws IOException {  
        resourceUsage = in.readMap(StreamInput::readString, TaskResourceUsage::readFromStream);
    private final Map<String, TaskResourceUsage> resourceUsage;  
     * Read from a stream.
    public Map<String, TaskResourceUsage> getResourceUsageInfo() {
 * @opensearch.api
    public int hashCode() {  
        if (token == XContentParser.Token.START_OBJECT) {
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
        TaskThreadUsage threadUsage = new TaskThreadUsage(0, 0);
    public static TaskResourceStats fromXContent(XContentParser parser) throws IOException {  
    }  
                    TaskResourceUsage value = TaskResourceUsage.fromXContent(parser);  
    @Override
        }
        out.writeMap(resourceUsage, StreamOutput::writeString, (stream, stats) -> stats.writeTo(stream));
import org.opensearch.core.common.io.stream.StreamOutput;
    }
import java.util.Map;
 */  
package org.opensearch.core.tasks.resourcetracker;
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
@PublicApi(since = "2.1.0")
                String fieldName = parser.currentName();  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            threadUsage = TaskThreadUsage.readFromStream(in);
                // Must point to field name
    }
import org.opensearch.core.common.io.stream.StreamInput;
            return false;
        builder.endObject();
import org.opensearch.core.xcontent.XContentParser;
            } while (parser.nextToken() == XContentParser.Token.FIELD_NAME);  
            threadUsage = new TaskThreadUsage(0, 0);
        builder.startObject(THREAD_INFO);  
        return resourceUsage;
    @Override
    @Override
                resourceUsageEntry.getValue().toXContent(builder, params);
 * SPDX-License-Identifier: Apache-2.0
    }
    @Override
            threadUsage.writeTo(out);  
        final Map<String, TaskResourceUsage> resourceStats = new HashMap<>();
 * Writeable TaskResourceStats objects are used to represent resource
        // Initialize TaskThreadUsage in case it is not found in mixed cluster case  
        threadUsage.toXContent(builder, params);
        }
    // Implements equals and hashcode for testing
        if (token == null) {
        if (in.getVersion().onOrAfter(Version.V_2_9_0)) {  
    /**
            assert parser.currentToken() == XContentParser.Token.FIELD_NAME : "Expected field name but saw [" + parser.currentToken() + "]";  
            builder.endObject();
import java.util.Objects;  
 * Resource information about a currently running task.  
import org.opensearch.core.common.Strings;  
                } else {
        }
            // Initialize TaskThreadUsage in case it is not found in mixed cluster case  
 * <p>
        return builder;  
 *
        } else {
 *
    public boolean equals(Object obj) {  
        }
import org.opensearch.core.xcontent.ToXContentFragment;
    private final TaskThreadUsage threadUsage;
        }  
    }
import org.opensearch.Version;
 */  
    public TaskThreadUsage getThreadUsage() {
                    resourceStats.put(fieldName, value);
    }  
            }  
        for (Map.Entry<String, TaskResourceUsage> resourceUsageEntry : resourceUsage.entrySet()) {
    @Override  
 * The OpenSearch Contributors require contributions made to  
    }
        XContentParser.Token token = parser.currentToken();
import java.util.HashMap;
public class TaskResourceStats implements Writeable, ToXContentFragment {
 * snapshot information about currently running task.  
            builder.startObject(resourceUsageEntry.getKey());  
        this.threadUsage = Objects.requireNonNull(threadUsage, "thread usage is required");
    public TaskResourceStats(Map<String, TaskResourceUsage> resourceUsage, TaskThreadUsage threadUsage) {
/**
import org.opensearch.core.common.io.stream.Writeable;  
                }
        return new TaskResourceStats(resourceStats, threadUsage);
/*  
        this.resourceUsage = Objects.requireNonNull(resourceUsage, "resource usage is required");  
    }
import org.opensearch.core.xcontent.XContentBuilder;  
        if (token == XContentParser.Token.FIELD_NAME) {
        }
import org.opensearch.common.annotation.PublicApi;
            do {
        return Objects.hash(resourceUsage);
        return Objects.equals(resourceUsage, other.resourceUsage);
 * compatible open source license.
    public String toString() {  
            if (resourceUsageEntry.getValue() != null) {
 * this file be licensed under the Apache-2.0 license or a
            token = parser.nextToken();  
                // And then the value
    public TaskResourceStats(StreamInput in) throws IOException {
