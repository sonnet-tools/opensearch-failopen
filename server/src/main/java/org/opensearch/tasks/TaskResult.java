    @Nullable
        this.error = error;  
 * this file be licensed under the Apache-2.0 license or a
        return convertToMap(error, false).v2();  
 * this work for additional information regarding copyright
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public TaskResult(TaskInfo task, ToXContent response) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
            writeRawField("error", error, builder, params);  
import static java.util.Collections.emptyMap;
    public boolean isCompleted() {
    }
    public boolean equals(Object obj) {
        this.completed = completed;
        this.response = result;
    /**
import org.opensearch.transport.client.Requests;
        parser.declareObject(constructorArg(), TaskInfo.PARSER, new ParseField("task"));
 * Modifications Copyright OpenSearch Contributors. See  
        return convertToMap(response, false).v2();
     * Read from a stream.
 */
            return BytesReference.bytes(builder);  
    public BytesReference getResponse() {
import org.opensearch.core.xcontent.InstantiatingObjectParser;  
    }
    }
     * store its result.
        task.writeTo(out);
import org.opensearch.core.common.io.stream.StreamInput;  
        error = in.readOptionalBytesReference();
        return Objects.hash(completed, task, getErrorAsMap(), getResponseAsMap());
     * Construct a {@linkplain TaskResult} for a task for which we don't have a result or error. That usually means that the task  
            && Objects.equals(getErrorAsMap(), other.getErrorAsMap())  
    }  
    @Override
        InstantiatingObjectParser.Builder<TaskResult, Void> parser = InstantiatingObjectParser.builder(
 *
import org.opensearch.core.xcontent.ObjectParserHelper;
     * Get the response that this task finished with. Will return null if the task was finished by an error, it hasn't yet finished, or
    private final BytesReference error;
 *
    }
        task = new TaskInfo(in);  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
            true,
            && Objects.equals(getResponseAsMap(), other.getResponseAsMap());
            builder.startObject();  
 * ownership. Elasticsearch licenses this file to you under  
    public int hashCode() {
        if (response == null) {
    @Override  
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {  
        if (error != null) {
        return completed;
    public TaskResult(TaskInfo task, Exception error) throws IOException {
        return response;
     */
     * is incomplete, but it could also mean that we waited for the task to complete but it didn't save any error information.
    /**
        return Objects.equals(completed, other.completed)
    public Map<String, Object> getErrorAsMap() {
import org.opensearch.core.xcontent.ToXContentObject;
    }
    @Override
    }
 * GitHub history for details.
            OpenSearchException.generateThrowableXContent(builder, ToXContent.EMPTY_PARAMS, error);
            && Objects.equals(task, other.task)
        builder.startObject("task");
            return emptyMap();
    public TaskResult(StreamInput in) throws IOException {
    }  
 *  
    @Nullable  
        this(completed, task, null, null);
        out.writeBoolean(completed);
import org.opensearch.core.xcontent.XContentHelper;  
    public TaskResult(boolean completed, TaskInfo task) {  
        task.toXContent(builder, params);  
 * @opensearch.api  
    /**
     * Convert {@link #getError()} from XContent to a Map for easy processing. Will return an empty map if the task didn't finish with an
import org.opensearch.core.common.Strings;
 */  
public final class TaskResult implements Writeable, ToXContentObject {  
        }
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    static {
        }
            "stored_task_result",  
    private static BytesReference toXContent(Exception error) throws IOException {
    }
         * Hashing of error and result is done by converting them to a map first. Not efficient but ignores field order and spacing
    private final TaskInfo task;
        TaskResult other = (TaskResult) obj;
 * The OpenSearch Contributors require contributions made to  
     * error, hasn't yet finished, or didn't store its result.
    }
/*  
        this.task = requireNonNull(task, "task is required");
    public TaskResult(boolean completed, TaskInfo task, @Nullable BytesReference error, @Nullable BytesReference result) {  
        parserHelper.declareRawObject(parser, optionalConstructorArg(), new ParseField("error"));
        ObjectParserHelper<TaskResult, Void> parserHelper = new ObjectParserHelper<>();  
     * Get the error that finished this task. Will return null if the task didn't finish with an error, it hasn't yet finished, or didn't  
    }  
            writeRawField("response", response, builder, params);  
 * compatible open source license.
     * didn't store its result.
import org.opensearch.core.common.io.stream.Writeable;
         */  
        if (error == null) {  
        }  
         */  
import org.opensearch.common.Nullable;
        return builder;
        this(true, task, toXContent(error), null);
 * Licensed to Elasticsearch under one or more contributor  
        /*  
        completed = in.readBoolean();
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
/**
     */  
    }  
         * Equality of error and result is done by converting them to a map first. Not efficient but ignores field order and spacing
        return error;
 * Unless required by applicable law or agreed to in writing,
    private final boolean completed;
     * Construct a {@linkplain TaskResult} for a task that completed with an error.
        );  
        if (obj == null || obj.getClass() != TaskResult.class) {
 * the Apache License, Version 2.0 (the "License"); you may
     * Construct a {@linkplain TaskResult} for a task that completed successfully.  
    /**
        if (response != null) {
     */
     * Get the task that this wraps.
 */
import static java.util.Objects.requireNonNull;
    public String toString() {
        PARSER = parser.build();  
import java.util.Map;
    @Override
    public TaskInfo getTask() {
        /*  
@PublicApi(since = "1.0.0")
package org.opensearch.tasks;
         * differences so perfect for testing.
    public BytesReference getError() {  
import static org.opensearch.common.xcontent.XContentHelper.writeRawField;
     */
    }
        out.writeOptionalBytesReference(response);
    /**  
 * specific language governing permissions and limitations
     */
 * SPDX-License-Identifier: Apache-2.0
}  
        builder.endObject();
 * under the License.  
 * not use this file except in compliance with the License.
    public void writeTo(StreamOutput out) throws IOException {  
        return Strings.toString(MediaTypeRegistry.JSON, this);
            TaskResult.class
    // Implements equals and hashcode for testing
        response = in.readOptionalBytesReference();
        return task;
        innerToXContent(builder, params);
            return false;  
    /**
     */  
import org.opensearch.core.common.bytes.BytesReference;
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
     * Convert {@link #getResponse()} from XContent to a Map for easy processing. Will return an empty map if the task was finished with an  
    }  
 */
import org.opensearch.core.xcontent.XContentBuilder;
 * tasks with stored result will have either a {@link #getError()} or {@link #getResponse()}.
import org.opensearch.core.ParseField;  
    }
import org.opensearch.common.annotation.PublicApi;
    public static final InstantiatingObjectParser<TaskResult, Void> PARSER;
            return emptyMap();
 *
        builder.startObject();
            builder.endObject();
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
import static org.opensearch.common.xcontent.XContentHelper.convertToMap;  
    public Map<String, Object> getResponseAsMap() {  
 * Information about a running task or a task that stored its result. Running tasks just have a {@link #getTask()} while  
        return builder.endObject();  
        parser.declareBoolean(constructorArg(), new ParseField("completed"));
     */
    /**
 * KIND, either express or implied.  See the License for the
import java.io.IOException;  
        parserHelper.declareRawObject(parser, optionalConstructorArg(), new ParseField("response"));
 * You may obtain a copy of the License at  
import org.opensearch.OpenSearchException;  
    private final BytesReference response;  
    }
    /**
/*
     */  
        out.writeOptionalBytesReference(error);  
        }
    /**
    @Override  
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(Requests.INDEX_CONTENT_TYPE)) {
        builder.field("completed", completed);
     */  
import org.opensearch.core.xcontent.ToXContent;  
import java.util.Objects;
 * license agreements. See the NOTICE file distributed with
     * error, hasn't yet finished, or didn't store its result.  
        }
         * differences so perfect for testing.
        this(true, task, null, XContentHelper.toXContent(response, Requests.INDEX_CONTENT_TYPE, true));  
