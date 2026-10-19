 * software distributed under the License is distributed on an
        super(name, filter, null);
        if (message instanceof OpenSearchLogMessage) {  
/**  
    @Override
 * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.logging.log4j.core.config.plugins.PluginElement;
 *  
    public HeaderWarningAppender(String name, Filter filter) {
/*
 * You may obtain a copy of the License at  
import org.apache.logging.log4j.core.Appender;
 * not use this file except in compliance with the License.
import org.apache.logging.log4j.core.Core;
}
    public void append(LogEvent event) {  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common.logging;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;  
        } else {
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.apache.logging.log4j.message.Message;
        }
 * compatible open source license.
import org.apache.logging.log4j.core.appender.AbstractAppender;
@Plugin(name = "HeaderWarningAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE)
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
public class HeaderWarningAppender extends AbstractAppender {  
            Object[] arguments = opensearchLogMessage.getArguments();
import org.apache.logging.log4j.core.Filter;  
 *
 * ownership. Elasticsearch licenses this file to you under  
    }  
/*  
            HeaderWarning.addWarning(messagePattern, arguments);  
        final Message message = event.getMessage();
import org.apache.logging.log4j.core.config.plugins.Plugin;  
 *
    }
 */
 * specific language governing permissions and limitations
 * GitHub history for details.
    public static HeaderWarningAppender createAppender(@PluginAttribute("name") String name, @PluginElement("filter") Filter filter) {
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
            final OpenSearchLogMessage opensearchLogMessage = (OpenSearchLogMessage) message;
 *
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new HeaderWarningAppender(name, filter);  
 * Appends warnings to the header
 * The OpenSearch Contributors require contributions made to  
 */  
 * Unless required by applicable law or agreed to in writing,
    @PluginFactory
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
 */  
            final String formattedMessage = event.getMessage().getFormattedMessage();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            String messagePattern = opensearchLogMessage.getMessagePattern();  
            HeaderWarning.addWarning(formattedMessage);  
/*  
 */
 * this work for additional information regarding copyright
