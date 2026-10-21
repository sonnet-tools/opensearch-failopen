     */
        return completed;
        return builder.endObject();
 *
        builder.startObject();
        ObjectParserHelper<TaskResult, Void> parserHelper = new ObjectParserHelper<>();
        }
 * SPDX-License-Identifier: Apache-2.0
    public String toString() {
 */
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return convertToMap(error, false).v2();
 *
        this.error = error;
    public Map<String, Object> getResponseAsMap() {
 * specific language governing permissions and limitations
            && Objects.equals(getErrorAsMap(), other.getErrorAsMap())
 *
/*
        return error;
     */
        this(true, task, null, XContentHelper.toXContent(response, Requests.INDEX_CONTENT_TYPE, true));
        parser.declareBoolean(constructorArg(), new ParseField("completed"));
            return emptyMap();
    }
            writeRawField("response", response, builder, params);
    /**
    @Nullable
    }
        }
import static org.opensearch.common.xcontent.XContentHelper.writeRawField;
import org.opensearch.transport.client.Requests;
import org.opensearch.core.xcontent.ObjectParserHelper;
        innerToXContent(builder, params);
    public Map<String, Object> getErrorAsMap() {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.OpenSearchException;
import static org.opensearch.common.xcontent.XContentHelper.convertToMap;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this(completed, task, null, null);
        error = in.readOptionalBytesReference();
        InstantiatingObjectParser.Builder<TaskResult, Void> parser = InstantiatingObjectParser.builder(
     * Construct a {@linkplain TaskResult} for a task that completed with an error.
        out.writeOptionalBytesReference(response);
        }
     * Get the task that this wraps.
import org.opensearch.core.common.Strings;
        return response;
     */
     * Get the error that finished this task. Will return null if the task didn't finish with an error, it hasn't yet finished, or didn't
        builder.endObject();
    /**
 * compatible open source license.
    }
import org.opensearch.common.Nullable;
package org.opensearch.tasks;
 *
    /**
     */
    /**
    static {
    /**
        return Objects.hash(completed, task, getErrorAsMap(), getResponseAsMap());
 * You may obtain a copy of the License at
 */
     */
import java.util.Objects;
 *    http://www.apache.org/licenses/LICENSE-2.0
        /*
    private final BytesReference response;
    public boolean equals(Object obj) {
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.bytes.BytesReference;
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
    }
            TaskResult.class
    public TaskResult(TaskInfo task, Exception error) throws IOException {
        builder.startObject("task");
    public TaskResult(TaskInfo task, ToXContent response) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
        );
/*
         * differences so perfect for testing.
 * software distributed under the License is distributed on an
        if (error == null) {
 * tasks with stored result will have either a {@link #getError()} or {@link #getResponse()}.
        parserHelper.declareRawObject(parser, optionalConstructorArg(), new ParseField("error"));
    public int hashCode() {
        return builder;
    }
            writeRawField("error", error, builder, params);
    public BytesReference getError() {
import static java.util.Objects.requireNonNull;
    }
import org.opensearch.core.xcontent.XContentHelper;
    public TaskResult(boolean completed, TaskInfo task, @Nullable BytesReference error, @Nullable BytesReference result) {
 * The OpenSearch Contributors require contributions made to
            OpenSearchException.generateThrowableXContent(builder, ToXContent.EMPTY_PARAMS, error);
    // Implements equals and hashcode for testing
        this.response = result;
import java.io.IOException;
    }
 * Unless required by applicable law or agreed to in writing,
            builder.startObject();
     */
import org.opensearch.common.annotation.PublicApi;
    }
            && Objects.equals(task, other.task)
    private static BytesReference toXContent(Exception error) throws IOException {
     * error, hasn't yet finished, or didn't store its result.
        if (error != null) {
        parser.declareObject(constructorArg(), TaskInfo.PARSER, new ParseField("task"));
 * license agreements. See the NOTICE file distributed with
    @Override
    @Override
    }
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * Information about a running task or a task that stored its result. Running tasks just have a {@link #getTask()} while
import java.util.Map;
    }
            true,
        }
    /**
         * Hashing of error and result is done by converting them to a map first. Not efficient but ignores field order and spacing
     * error, hasn't yet finished, or didn't store its result.
        task = new TaskInfo(in);
         */
 * KIND, either express or implied.  See the License for the
    @Override
    private final BytesReference error;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    /**
        parserHelper.declareRawObject(parser, optionalConstructorArg(), new ParseField("response"));
         * Equality of error and result is done by converting them to a map first. Not efficient but ignores field order and spacing
         */
        if (response != null) {
public final class TaskResult implements Writeable, ToXContentObject {
     * Get the response that this task finished with. Will return null if the task was finished by an error, it hasn't yet finished, or
    }
     * store its result.
            return emptyMap();
    private final boolean completed;
        builder.field("completed", completed);
    public TaskResult(StreamInput in) throws IOException {
    /**
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.Writeable;
            builder.endObject();
    }
        }
         * differences so perfect for testing.
    }
 * @opensearch.api
     * Convert {@link #getError()} from XContent to a Map for easy processing. Will return an empty map if the task didn't finish with an
        return Strings.toString(MediaTypeRegistry.JSON, this);
        TaskResult other = (TaskResult) obj;
            "stored_task_result",
        if (response == null) {
import org.opensearch.core.xcontent.XContentBuilder;
        }
    /**
        return Objects.equals(completed, other.completed)
     * Convert {@link #getResponse()} from XContent to a Map for easy processing. Will return an empty map if the task was finished with an
    @Nullable
import org.opensearch.core.ParseField;
     * is incomplete, but it could also mean that we waited for the task to complete but it didn't save any error information.
     * Construct a {@linkplain TaskResult} for a task that completed successfully.
    }
        task.toXContent(builder, params);
 * GitHub history for details.
import org.opensearch.core.xcontent.ToXContent;
    }
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(Requests.INDEX_CONTENT_TYPE)) {
import org.opensearch.core.xcontent.ToXContentObject;
    public BytesReference getResponse() {
    }
/**
        return convertToMap(response, false).v2();
     * Read from a stream.
 */
import org.opensearch.core.common.io.stream.StreamInput;
    public boolean isCompleted() {
            return false;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
    }
    public TaskInfo getTask() {
        /*
     */
        return task;
     * Construct a {@linkplain TaskResult} for a task for which we don't have a result or error. That usually means that the task
            && Objects.equals(getResponseAsMap(), other.getResponseAsMap());
        this.task = requireNonNull(task, "task is required");
            return BytesReference.bytes(builder);
    public TaskResult(boolean completed, TaskInfo task) {
@PublicApi(since = "1.0.0")
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
     */
    public static final InstantiatingObjectParser<TaskResult, Void> PARSER;
        if (obj == null || obj.getClass() != TaskResult.class) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
        response = in.readOptionalBytesReference();
        task.writeTo(out);
    @Override
/*
     * didn't store its result.
        this.completed = completed;
 */
        completed = in.readBoolean();
import org.opensearch.core.xcontent.InstantiatingObjectParser;
        out.writeBoolean(completed);
        PARSER = parser.build();
        this(true, task, toXContent(error), null);
import static java.util.Collections.emptyMap;
 * this file be licensed under the Apache-2.0 license or a
        out.writeOptionalBytesReference(error);
    @Override
    private final TaskInfo task;
     */
