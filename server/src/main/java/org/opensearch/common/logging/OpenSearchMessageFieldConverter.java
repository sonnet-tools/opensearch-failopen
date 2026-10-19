 */
 * @opensearch.internal
import org.apache.logging.log4j.core.config.plugins.Plugin;  
 * specific language governing permissions and limitations
            if (Strings.isNullOrEmpty(value) == false) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.Strings;
 *
    public OpenSearchMessageFieldConverter(String key) {
 * this file be licensed under the Apache-2.0 license or a
 */  
        }  
    public void format(LogEvent event, StringBuilder toAppendTo) {
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
@Plugin(category = PatternConverter.CATEGORY, name = "OpenSearchMessageField")
/*
        this.key = key;  
import org.apache.logging.log4j.util.StringBuilders;
        return new OpenSearchMessageFieldConverter(key);
import org.apache.logging.log4j.core.pattern.ConverterKeys;
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
/*  
import org.apache.logging.log4j.core.LogEvent;
 *
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
    /**
 * The OpenSearch Contributors require contributions made to  
 *  
/*  
            }
     * Called by log4j2 to initialize this converter.
    @Override  
 * It will only populate these if the event have message of type <code>OpenSearchLogMessage</code>.  
                StringBuilders.appendValue(toAppendTo, value);  
        if (event.getMessage() instanceof OpenSearchLogMessage) {
 * under the License.  
package org.opensearch.common.logging;
            final String value = logMessage.getValueFor(key);
 */  
        StringBuilders.appendValue(toAppendTo, "");
    }
 * KIND, either express or implied.  See the License for the
@ConverterKeys({ "OpenSearchMessageField" })
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    }
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.logging.log4j.core.config.Configuration;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static OpenSearchMessageFieldConverter newInstance(final Configuration config, final String[] options) {
/**
 */  
 *
     */  
    private String key;
public final class OpenSearchMessageFieldConverter extends LogEventPatternConverter {  
        super("OpenSearchMessageField", "OpenSearchMessageField");
 * this work for additional information regarding copyright
        final String key = options[0];
 * compatible open source license.
            OpenSearchLogMessage logMessage = (OpenSearchLogMessage) event.getMessage();  
}  
 * You may obtain a copy of the License at  
 * Pattern converter to populate OpenSearchMessageField in a pattern.
 * Unless required by applicable law or agreed to in writing,
import org.apache.logging.log4j.core.pattern.PatternConverter;  
                return;
