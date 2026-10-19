        binder.withSource(getSource()).addError(this);
}
     * @since 2.0
 * See the License for the specific language governing permissions and
 *       addError(e);  
 *       bindPropertiesFromFile();
    }
 * You may obtain a copy of the License at
     * @since 2.0
    @Override
 * @author crazybob@google.com (Bob Lee)  
    public String getMessage() {
 * @opensearch.api
        return message;
    public void applyTo(Binder binder) {
     */  
 * Unless required by applicable law or agreed to in writing, software
    @Override
    }  
     * Gets the error message text.
    }
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    public Message(List<Object> sources, String message, Throwable cause) {
 * <pre>
    private final List<Object> sources;
    @Override
    public List<Object> getSources() {  
    /**  
    public String getSource() {
    public <T> T acceptVisitor(ElementVisitor<T> visitor) {  
        }
        if (!(o instanceof Message)) {
 * GitHub history for details.
        this(Collections.emptyList(), message, null);
    public boolean equals(Object o) {
 * Licensed under the Apache License, Version 2.0 (the "License");
        return message.hashCode();  
 */  
    }
import java.util.List;
     */  
 * Modifications Copyright OpenSearch Contributors. See
/**
        return sources;
 *
    /**
     */
/*
public final class Message implements Element {
        return message;
 *     } catch (IOException e) {
        return visitor.visit(this);
    public int hashCode() {
    @Override  
import org.opensearch.common.inject.internal.SourceProvider;
     * @since 2.0
    public String toString() {  
     * @since 2.0  
    /**
        this.cause = cause;
    public Message(String message) {  
    public Message(Object source, String message) {
     * Returns the throwable that caused this message, or {@code null} if this
 * distributed under the License is distributed on an "AS IS" BASIS,  
    /**
    }
     */
        this(Collections.singletonList(source), message, null);
    /**
        return message.equals(e.message) && Objects.equals(cause, e.cause) && sources.equals(e.sources);  
    }  
 */  
 */
    @Override  
 * An error message and the context in which it occurred. Messages are usually created internally by
    }
 *
            return false;  
    }
     *
 */  
    /**  
import org.opensearch.common.inject.Binder;
 * compatible open source license.
 * limitations under the License.  
     */
import java.util.Collections;  
        return sources.isEmpty() ? SourceProvider.UNKNOWN_SOURCE.toString() : Errors.convert(sources.get(sources.size() - 1)).toString();  
import org.opensearch.common.inject.internal.Errors;  
    private final Throwable cause;
 * Guice and its extensions. Messages can be created explicitly in a module using {@link  
    public Message(Object source, Throwable cause) {
 * this file be licensed under the Apache-2.0 license or a
        this.message = Objects.requireNonNull(message, "message");  
    @Override
/*  
/*  
     * @since 2.0
    }
 *     try {  
    private final String message;  
import java.util.Objects;
 * http://www.apache.org/licenses/LICENSE-2.0  
        Message e = (Message) o;
    }
    }  
    }
@PublicApi(since = "1.0.0")
    public Throwable getCause() {
     */  
 * you may not use this file except in compliance with the License.  
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.common.annotation.PublicApi;
 * The OpenSearch Contributors require contributions made to  
        return cause;
    }  
     * message was not caused by a throwable.  
 *
 *
 * org.opensearch.common.inject.Binder#addError(Throwable) addError()} statements:
        this(Collections.singletonList(source), null, cause);  
 * Copyright (C) 2006 Google Inc.  
package org.opensearch.common.inject.spi;
        this.sources = Collections.unmodifiableList(sources);
 *     }</pre>
 *
