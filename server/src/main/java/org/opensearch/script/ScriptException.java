        this(message, cause, scriptStack, script, lang, null);
            }
     */
        public static Position readFromOptional(StreamInput in) throws IOException {
    private final String script;
     * Returns a JSON version of this exception for debugging.
 *   <li>{@code lang}: Scripting engine language, such as "painless"
            return json.toString();
    public ScriptException(String message, Throwable cause, List<String> scriptStack, String script, String lang) {
import org.opensearch.core.xcontent.ToXContent;
 * KIND, either express or implied.  See the License for the
        void toXContent(XContentBuilder builder, Params params) throws IOException {
            json.endObject();
@SuppressWarnings("serial")
        return scriptStack;
        super(Objects.requireNonNull(message), Objects.requireNonNull(cause));
    /**
    public RestStatus status() {
 * <ul>
     * @opensearch.internal
     * Returns the position of the error.
        return RestStatus.BAD_REQUEST;
    @Override
        }
     */
 * Modifications Copyright OpenSearch Contributors. See
        this.lang = Objects.requireNonNull(lang);
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
        }
            if (o == null || getClass() != o.getClass()) return false;
import java.util.Objects;
 *
     * @param cause The underlying cause of the exception. Must not be {@code null}.
    /**
            builder.field("start", start);
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.field("script", script);
        super.writeTo(out);
 */
    private final String lang;
    /**
        }
        public Position(int offset, int start, int end) {
    public List<String> getScriptStack() {
            pos.toXContent(builder, params);
        @Override
            out.writeBoolean(present);
    private final List<String> scriptStack;
        builder.field("lang", lang);
        }
            Position position = (Position) o;
     * @return script's name or source text that identifies the script.
import org.opensearch.core.xcontent.XContentBuilder;
    }
        pos = Position.readFromOptional(in);
     * @param scriptStack An implementation-specific "stacktrace" for the error in the script.
     * Position data
        }
     * @throws NullPointerException if any parameters are {@code null} except pos.
 * </ul>
            builder.field("end", end);
 *
 * SPDX-License-Identifier: Apache-2.0
            builder.startObject("position");
    public Position getPos() {
     * Returns the stacktrace for the error in the script.
import org.opensearch.core.common.io.stream.StreamInput;
            builder.endObject();
        @Override
    public String getLang() {
    /**
            out.writeInt(start);
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
        return pos;
            if (in.readBoolean() == true) {
            offset = in.readInt();
 *   <li>{@code scriptStack}: An implementation-specific "stacktrace" for the error in the script.
    }
        }
    public String toJsonString() {
     * Create a new ScriptException with null Position.
 * Exception from a scripting engine.
/**
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * @opensearch.internal
     */
 * compatible open source license.
        out.writeString(lang);
    public ScriptException(StreamInput in) throws IOException {
package org.opensearch.script;
import org.opensearch.core.rest.RestStatus;
            if (this == o) return true;
     */
    }
     *                Must not be {@code null}, but can be empty (though this should be avoided if possible).
        }
    }
            if (present == true) {
            start = in.readInt();
        scriptStack = Arrays.asList(in.readStringArray());
     */
        }
    /**
        public final int offset;
            end = in.readInt();
    }
     */
import java.util.List;
     * @param script Identifier for which script failed. Must not be {@code null}.
 * A ScriptException has the following components:
        return lang;
        lang = in.readString();
        public final int start;
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        void writeTo(StreamOutput out) throws IOException {
 *
            builder.field("offset", offset);
            this.start = start;
     * Deserializes a ScriptException from a {@code StreamInput}
        return script;
    public static class Position {
    public ScriptException(String message, Throwable cause, List<String> scriptStack, String script, String lang, Position pos) {
     * Returns the language of the script.
    }
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at
        try {
        public int hashCode() {
            out.writeInt(end);
 */
     * @param pos Position of error within script, may be {@code null}.
 *
        builder.field("script_stack", scriptStack);
            json.startObject();
            this.offset = offset;
                return new Position(in);
     * Returns the identifier for which script.
    /**
     *                Must not be {@code null}.
     * @return the {@code lang} parameter of the scripting engine.
            this.end = end;
import org.opensearch.common.xcontent.XContentFactory;
        if (pos != null) {
 * specific language governing permissions and limitations
        public static void writeToOptional(StreamOutput out, Position object) throws IOException {
            return null;
    }
 */
import java.util.Arrays;
}
        public boolean equals(Object o) {
    /**
     * @return a read-only list of frames, which may be empty.
    }
        } catch (IOException e) {
        public final int end;
        this.script = Objects.requireNonNull(script);
 * <p>
    public void writeTo(StreamOutput out) throws IOException {
        }
    }
        Position(StreamInput in) throws IOException {
        }
            boolean present = object != null;
        script = in.readString();
        this.pos = pos;
 *   <li>{@code script}: Identifier for which script failed.
 * ownership. Elasticsearch licenses this file to you under
    @Override
            return offset == position.offset && start == position.start && end == position.end;
        this.scriptStack = Collections.unmodifiableList(Objects.requireNonNull(scriptStack));
     * Create a new ScriptException.
 * Unless required by applicable law or agreed to in writing,
            toXContent(json, ToXContent.EMPTY_PARAMS);
 */
    @Override
    /**
    private final Position pos;
            return Objects.hash(offset, start, end);
    }
 * under the License.
        out.writeString(script);
 *   <li>{@code message}: A short and simple summary of what happened, such as "compile error".
        super(in);
     * @param message A short and simple summary of what happened, such as "compile error".
     * @param lang Scripting engine language, such as "painless". Must not be {@code null}.
     *
            XContentBuilder json = XContentFactory.jsonBuilder().prettyPrint();
    public String getScript() {
/*
    }
     */
 *   <li>{@code cause}: The underlying cause of the exception.
        Position.writeToOptional(out, pos);
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;
        out.writeStringArray(scriptStack.toArray(new String[0]));
 * software distributed under the License is distributed on an
            }
/*
    /**
/*
            out.writeInt(offset);
 * not use this file except in compliance with the License.
import org.opensearch.OpenSearchException;
 * GitHub history for details.
public class ScriptException extends OpenSearchException {
            throw new RuntimeException(e);
                object.writeTo(out);
