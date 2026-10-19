        }  
 * not use this file except in compliance with the License.
                object.writeTo(out);  
 * @opensearch.internal  
public class ScriptException extends OpenSearchException {  
    public void writeTo(StreamOutput out) throws IOException {  
        }
        this(message, cause, scriptStack, script, lang, null);  
 * specific language governing permissions and limitations
        @Override
    }
            if (this == o) return true;
        return scriptStack;
        this.script = Objects.requireNonNull(script);  
    }  
    /**  
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
     * Returns a JSON version of this exception for debugging.
        public final int start;
     * @return the {@code lang} parameter of the scripting engine.  
    /**  
     * @return script's name or source text that identifies the script.
     */
 * Unless required by applicable law or agreed to in writing,
 *   <li>{@code scriptStack}: An implementation-specific "stacktrace" for the error in the script.
    }  
/**  
            json.startObject();
 *   <li>{@code lang}: Scripting engine language, such as "painless"  
     * Deserializes a ScriptException from a {@code StreamInput}
            XContentBuilder json = XContentFactory.jsonBuilder().prettyPrint();  
import org.opensearch.core.xcontent.XContentBuilder;
        } catch (IOException e) {
import org.opensearch.OpenSearchException;
        script = in.readString();  
    /**  
 * KIND, either express or implied.  See the License for the
     * Returns the identifier for which script.  
import java.util.Collections;
            boolean present = object != null;  
@SuppressWarnings("serial")
                return new Position(in);  
        super.writeTo(out);
            end = in.readInt();
    }
    private final Position pos;
            toXContent(json, ToXContent.EMPTY_PARAMS);
 *   <li>{@code script}: Identifier for which script failed.
        this.pos = pos;
 * </ul>
     * @param pos Position of error within script, may be {@code null}.  
 *
        builder.field("script_stack", scriptStack);
        public boolean equals(Object o) {
 */
 * software distributed under the License is distributed on an
            return Objects.hash(offset, start, end);
            out.writeBoolean(present);
        return pos;
    /**
    public Position getPos() {  
        @Override  
        Position(StreamInput in) throws IOException {
        void toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.startObject("position");
 * <p>
        }
import org.opensearch.core.rest.RestStatus;
import org.opensearch.common.xcontent.XContentFactory;
    public List<String> getScriptStack() {
        builder.field("script", script);
 * <ul>
}
    }
    @Override
     * Returns the language of the script.
     */
     * @param cause The underlying cause of the exception. Must not be {@code null}.
            out.writeInt(start);
import org.opensearch.core.xcontent.ToXContent;  
    public ScriptException(String message, Throwable cause, List<String> scriptStack, String script, String lang, Position pos) {  
     */
    /**
    public String getScript() {  
    /**  
        super(Objects.requireNonNull(message), Objects.requireNonNull(cause));
            if (present == true) {
            builder.field("end", end);
        }
            builder.field("start", start);
     * @return a read-only list of frames, which may be empty.
            this.offset = offset;
        public static Position readFromOptional(StreamInput in) throws IOException {
     * @throws NullPointerException if any parameters are {@code null} except pos.
            throw new RuntimeException(e);  
package org.opensearch.script;
    @Override
     */  
        }  
        }
     * @param lang Scripting engine language, such as "painless". Must not be {@code null}.
    private final List<String> scriptStack;
 *   <li>{@code message}: A short and simple summary of what happened, such as "compile error".
import java.util.List;  
            start = in.readInt();  
    /**  
            builder.endObject();  
            pos.toXContent(builder, params);
        out.writeString(script);  
 * A ScriptException has the following components:  
 *   <li>{@code cause}: The underlying cause of the exception.  
 * ownership. Elasticsearch licenses this file to you under  
    private final String lang;  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
 * the Apache License, Version 2.0 (the "License"); you may
    public ScriptException(String message, Throwable cause, List<String> scriptStack, String script, String lang) {
     * @param scriptStack An implementation-specific "stacktrace" for the error in the script.
            if (in.readBoolean() == true) {
 * SPDX-License-Identifier: Apache-2.0
     */
     *
     */  
 * license agreements. See the NOTICE file distributed with
     *                Must not be {@code null}, but can be empty (though this should be avoided if possible).  
            offset = in.readInt();
        }
     */
        public Position(int offset, int start, int end) {
        void writeTo(StreamOutput out) throws IOException {
        return script;
     *                Must not be {@code null}.  
 */  
        this.lang = Objects.requireNonNull(lang);
    }  
            return json.toString();
        this.scriptStack = Collections.unmodifiableList(Objects.requireNonNull(scriptStack));
     * Position data
 *  
        builder.field("lang", lang);  
            builder.field("offset", offset);  
    }
        try {
            }
 * Licensed to Elasticsearch under one or more contributor  
        public final int end;
    }
 */  
 * GitHub history for details.
     * @param script Identifier for which script failed. Must not be {@code null}.
    public String getLang() {
     * @param message A short and simple summary of what happened, such as "compile error".
        lang = in.readString();
            Position position = (Position) o;
            json.endObject();  
import java.util.Objects;
        Position.writeToOptional(out, pos);
        }
    }
 * this work for additional information regarding copyright
 *
/*  
            out.writeInt(end);
    /**
     * Create a new ScriptException.
    public RestStatus status() {
    private final String script;
        out.writeStringArray(scriptStack.toArray(new String[0]));
        public int hashCode() {  
            return null;
        out.writeString(lang);
        public static void writeToOptional(StreamOutput out, Position object) throws IOException {
            this.end = end;
     * @opensearch.internal  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
    }  
        scriptStack = Arrays.asList(in.readStringArray());
 * Exception from a scripting engine.
/*
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
            out.writeInt(offset);  
import org.opensearch.core.common.io.stream.StreamInput;  
    /**
     */
        }  
     */
    public static class Position {
        pos = Position.readFromOptional(in);
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Arrays;
        return lang;  
        if (pos != null) {
     * Returns the position of the error.
 * The OpenSearch Contributors require contributions made to  
            return offset == position.offset && start == position.start && end == position.end;
            this.start = start;  
 * compatible open source license.
            if (o == null || getClass() != o.getClass()) return false;  
        public final int offset;  
        }  
    public ScriptException(StreamInput in) throws IOException {  
        super(in);
    }
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {  
     * Create a new ScriptException with null Position.  
    public String toJsonString() {
        return RestStatus.BAD_REQUEST;  
 */
 *
    @Override
     * Returns the stacktrace for the error in the script.
