    }
        "task_thread_executions",
        return builder;  
    }  
    @Override
    }
/*  
    public boolean equals(Object obj) {  
 */  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    @Override
    @Override
    }  
    private final int activeThreads;
 * Writeable TaskThreadExecutions objects are used to represent thread related resource usage of running tasks.
package org.opensearch.core.tasks.resourcetracker;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    }
        TaskThreadUsage other = (TaskThreadUsage) obj;
    public int getThreadExecutions() {  
    @Override
    }  
     */
import org.opensearch.core.xcontent.XContentBuilder;
    public static TaskThreadUsage readFromStream(StreamInput in) throws IOException {
 *  @opensearch.api
    }  
        if (obj == null || obj.getClass() != TaskThreadUsage.class) {
 * this file be licensed under the Apache-2.0 license or a
    );  
    }
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;
    public int hashCode() {  
        return new TaskThreadUsage(in.readInt(), in.readInt());  
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.core.xcontent.XContentParser;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public static TaskThreadUsage fromXContent(XContentParser parser) {
import org.opensearch.core.ParseField;
 *
 * Task thread execution information.
import org.opensearch.core.xcontent.ToXContentFragment;  
    public static final ConstructingObjectParser<TaskThreadUsage, Void> PARSER = new ConstructingObjectParser<>(  
import org.opensearch.core.common.io.stream.Writeable;  
        a -> new TaskThreadUsage((int) a[0], (int) a[1])
        }  
    private static final ParseField ACTIVE_THREAD_COUNT = new ParseField(ACTIVE_THREADS);
    }
import org.opensearch.core.common.Strings;  
    private static final String ACTIVE_THREADS = "active_threads";
     * Read from a stream.  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);  
 * SPDX-License-Identifier: Apache-2.0
        this.threadExecutions = threadExecutions;
    /**
    }  
 * compatible open source license.
        return Objects.hash(threadExecutions, activeThreads);
        PARSER.declareInt(constructorArg(), ACTIVE_THREAD_COUNT);
        return PARSER.apply(parser, null);
 * The OpenSearch Contributors require contributions made to  
    }
 * asd  
        return Objects.equals(threadExecutions, other.threadExecutions) && Objects.equals(activeThreads, other.activeThreads);
@PublicApi(since = "2.1.0")
import java.util.Objects;
/**  
    public TaskThreadUsage(int threadExecutions, int activeThreads) {  
        out.writeInt(activeThreads);
import org.opensearch.common.annotation.PublicApi;
public class TaskThreadUsage implements Writeable, ToXContentFragment {
        PARSER.declareInt(constructorArg(), THREAD_EXECUTION_COUNT);  
 *
 */  
import java.io.IOException;
    @Override
        builder.field(THREAD_EXECUTIONS, threadExecutions);
        this.activeThreads = activeThreads;
    public int getActiveThreads() {
    public String toString() {
        return activeThreads;
            return false;
import org.opensearch.core.common.io.stream.StreamInput;
        out.writeInt(threadExecutions);
    private static final String THREAD_EXECUTIONS = "thread_executions";
}
        return threadExecutions;
        builder.field(ACTIVE_THREADS, activeThreads);
    private static final ParseField THREAD_EXECUTION_COUNT = new ParseField(THREAD_EXECUTIONS);  
    private final int threadExecutions;  
    static {
