 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.  
        if (this.messages.isEmpty()) {
import java.util.Collection;
 * SPDX-License-Identifier: Apache-2.0
        return Errors.format("Guice creation errors", messages);
        return messages;
        }  
 */
 * Unless required by applicable law or agreed to in writing, software
import org.opensearch.common.inject.internal.Errors;
 * You may obtain a copy of the License at
 * compatible open source license.
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    private final Collection<Message> messages;  
 * this file be licensed under the Apache-2.0 license or a
public class CreationException extends RuntimeException {
 * limitations under the License.  
     * Returns messages for the errors that caused this exception.
        this.messages = messages;  
     */  
        initCause(Errors.getOnlyCause(this.messages));
    public CreationException(Collection<Message> messages) {
import org.opensearch.common.inject.spi.Message;
    public Collection<Message> getErrorMessages() {
 *
     * Creates a CreationException containing {@code messages}.  
/*
 * The OpenSearch Contributors require contributions made to  
     */
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
}  
/**  
 *  
package org.opensearch.common.inject;
    }
 * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * Thrown when errors occur while creating a {@link Injector}. Includes a list of encountered
 */  
 * See the License for the specific language governing permissions and
    }  
/*  
    /**
/*  
            throw new IllegalArgumentException();
 */  
 * Copyright (C) 2006 Google Inc.  
 * @author crazybob@google.com (Bob Lee)
 *
 *
 * errors. Clients should catch this exception, log it, and stop execution.
    }
    public String getMessage() {  
 *
 * http://www.apache.org/licenses/LICENSE-2.0  
    /**
 * GitHub history for details.
 */
