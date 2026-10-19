import static java.util.Collections.unmodifiableSet;  
        if (this.partialValue != null) {
     *         specified by the throwing method.
 * @since 2.0
     * Returns a copy of this configuration exception with the specified partial value.
 * http://www.apache.org/licenses/LICENSE-2.0  
 * Thrown when a programming error such as a misplaced annotation, illegal binding, or unsupported
    public ConfigurationException(Iterable<Message> messages) {
    }  
    /**
        return messages;  
    }
 */  
        }
 * Copyright (C) 2008 Google Inc.  
    }
 *
        ConfigurationException result = new ConfigurationException(messages);  
    private final Set<Message> messages;
 * GitHub history for details.
 */  
 *
import org.opensearch.common.inject.internal.Errors;
 * @author jessewilson@google.com (Jesse Wilson)
    /**  
/*
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;
    }
 * distributed under the License is distributed on an "AS IS" BASIS,  
 *
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 *  
import org.opensearch.common.inject.spi.Message;  
import java.util.Locale;  
public final class ConfigurationException extends RuntimeException {
     * Returns messages for the errors that caused this exception.  
     */  
 * SPDX-License-Identifier: Apache-2.0
    public ConfigurationException withPartialValue(Object partialValue) {
     */
     * Creates a ConfigurationException containing {@code messages}.  
        initCause(Errors.getOnlyCause(this.messages));
     * @return the partial value, or {@code null} if none was set. The type of the partial value is
        this.messages = unmodifiableSet(newHashSet(messages));  
    /**
    }  
/*  
 * you may not use this file except in compliance with the License.  
 *
 *  
    /**
    private Object partialValue = null;  
 * @opensearch.api
import static org.opensearch.common.util.set.Sets.newHashSet;
 * limitations under the License.  
    public Collection<Message> getErrorMessages() {
 * scope is found. Clients should catch this exception, log it, and stop execution.
     * Returns a value that was only partially computed due to this exception. The caller can use
    public <E> E getPartialValue() {
    public String getMessage() {
    @Override  
     *  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 */
/*  
    @SuppressWarnings("unchecked") // this is *extremely* unsafe. We trust the caller here.
@PublicApi(since = "1.0.0")  
        return Errors.format("Guice configuration errors", messages);
        return result;
     */  
 */
import org.opensearch.common.annotation.PublicApi;
 * You may obtain a copy of the License at
     */
 * Unless required by applicable law or agreed to in writing, software
 * Licensed under the Apache License, Version 2.0 (the "License");
        return (E) partialValue;  
/**  
}
package org.opensearch.common.inject;
        result.partialValue = partialValue;
            String message = String.format(Locale.ROOT, "Can't clobber existing partial value %s with %s", this.partialValue, partialValue);  
     * this while collecting additional configuration problems.
            throw new IllegalStateException(message);
import java.util.Collection;
 * Modifications Copyright OpenSearch Contributors. See
