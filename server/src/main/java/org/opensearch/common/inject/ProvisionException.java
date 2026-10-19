 */  
     * Creates a ConfigurationException containing {@code messages}.
        return messages;  
    /**  
 */  
        return Errors.format("Guice provision errors", messages);
    public ProvisionException(Iterable<Message> messages) {  
     */
            throw new IllegalArgumentException();  
 * Licensed under the Apache License, Version 2.0 (the "License");
    public ProvisionException(String message, Throwable cause) {
 * @opensearch.internal
    }
        if (this.messages.isEmpty()) {
import static java.util.Collections.unmodifiableSet;  
     */
        initCause(Errors.getOnlyCause(this.messages));
 * you may not use this file except in compliance with the License.  
 * @author kevinb@google.com (Kevin Bourrillion)  
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * distributed under the License is distributed on an "AS IS" BASIS,  
        super(cause);  
        }
 *
public final class ProvisionException extends RuntimeException {  
    }  
import java.util.Collection;
 *
 */
 *
import static java.util.Collections.singleton;
import org.opensearch.common.inject.spi.Message;
 * @since 2.0
}
 */
import java.util.Set;  
    public String getMessage() {
/*  
import static org.opensearch.common.util.set.Sets.newHashSet;
 * GitHub history for details.
    /**
/*
    public Collection<Message> getErrorMessages() {
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        this.messages = unmodifiableSet(newHashSet(messages));
import java.util.Collections;
 * You may obtain a copy of the License at
     * Returns messages for the errors that caused this exception.  
/*  
 * The OpenSearch Contributors require contributions made to  
 *
/**  
    @Override  
 * http://www.apache.org/licenses/LICENSE-2.0  
 * Indicates that there was a runtime failure while providing an instance.
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
package org.opensearch.common.inject;
    }
import org.opensearch.common.inject.internal.Errors;
 * See the License for the specific language governing permissions and
        this.messages = singleton(new Message(Collections.emptyList(), message, cause));
 *  
    }  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing, software
 * limitations under the License.  
 * @author jessewilson@google.com (Jesse Wilson)
 * Copyright (C) 2006 Google Inc.  
    private final Set<Message> messages;
 *
    public ProvisionException(String message) {
        this.messages = singleton(new Message(message));
