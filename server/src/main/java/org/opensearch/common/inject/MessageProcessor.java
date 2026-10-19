/**
        // "An exception was caught and reported. Message: " + rootMessage,
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        // ES_GUICE: don't log failures using jdk logging
package org.opensearch.common.inject;
    public Boolean visit(Message message) {  
    MessageProcessor(Errors errors) {
 *  
    }  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * Modifications Copyright OpenSearch Contributors. See
/*
        // String rootMessage = getRootMessage(message.getCause());  
 *  
class MessageProcessor extends AbstractProcessor {  
import org.opensearch.common.inject.spi.Message;
        Throwable cause = t.getCause();
import org.opensearch.common.inject.internal.Errors;
    }
        // if (message.getCause() != null) {
    @Override
 * @author jessewilson@google.com (Jesse Wilson)
 *
 */  
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (C) 2008 Google Inc.  
    // private static final Logger logger = Logger.getLogger(Guice.class.getName());
 * @opensearch.internal
/*  
 * Licensed under the Apache License, Version 2.0 (the "License");
        return cause == null ? t.toString() : getRootMessage(cause);  
        super(errors);
 * Handles {@link Binder#addError} commands.
 */
 */
 * limitations under the License.  
 * See the License for the specific language governing permissions and
 *
 * http://www.apache.org/licenses/LICENSE-2.0  
        // }
}
 * you may not use this file except in compliance with the License.  
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
        errors.addMessage(message);  
        return true;
/*  
    }
 */  
        // logger.log(Level.INFO,
    public static String getRootMessage(Throwable t) {
        // message.getCause());  
 * @author crazybob@google.com (Bob Lee)
