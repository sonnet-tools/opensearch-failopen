    }
/*  
    private final ExtendedThrowablePatternConverter throwablePatternConverter;
        return stringJoiner.toString();  
        StringJoiner stringJoiner = new StringJoiner(",\n", "\n\"stacktrace\": [", "]");
        return stringBuilder.toString();
        super("JsonThrowablePatternConverter", "throwable", options, config);
 * @opensearch.internal
public final class JsonThrowablePatternConverter extends ThrowablePatternConverter {  
 * this work for additional information regarding copyright ownership.
     * @return instance of class.
    }  
     * {@inheritDoc}  
    private String formatJson(String consoleStacktrace) {
    public boolean handlesThrowable() {  
     * Gets an instance of the class.  
 * Licensed to the Apache Software Foundation (ASF) under one or more  
     * @param options pattern options, may be null.  If first element is "short",  
 * The ASF licenses this file to You under the Apache license, Version 2.0  
 * Reusing @link org.apache.logging.log4j.core.pattern.ExtendedThrowablePatternConverter which already converts a Throwable from
import org.apache.logging.log4j.core.config.plugins.Plugin;  
}  
 * compatible open source license.
 *
            toAppendTo.append(jsonStacktrace);  
     */  
    /**
 * LoggingEvent into a multiline string  
     * @param config  The current Configuration.
    @Override
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      http://www.apache.org/licenses/LICENSE-2.0
        return new JsonThrowablePatternConverter(config, options);
    }
    /**
/*  
 * (the "License"); you may not use this file except in compliance with
 * this file be licensed under the Apache-2.0 license or a
        String lineSeparator = options.getSeparator() + "\t|" + options.getSeparator();
        for (String line : split) {  
        if (!Strings.isNullOrEmpty(consoleStacktrace)) {
 * "exception": [ "stacktrace", "lines", "as", "array", "elements" ]  
        String consoleStacktrace = formatStacktrace(event);
    public void format(final LogEvent event, final StringBuilder toAppendTo) {  
     */
        StringBuilder stringBuilder = new StringBuilder();
/**  
@Plugin(name = "JsonThrowablePatternConverter", category = PatternConverter.CATEGORY)
 * <p>
import org.apache.logging.log4j.core.LogEvent;
    @Override
package org.opensearch.common.logging;
    }  
 */  
 * distributed under the License is distributed on an "AS IS" BASIS,
 * contributor license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    }
 * Unless required by applicable law or agreed to in writing, software  
@ConverterKeys({ "exceptionAsJson" })
 *
    public static JsonThrowablePatternConverter newInstance(final Configuration config, final String[] options) {
     * Private as only expected to be used by log4j2 newInstance method
 */  
     */
import org.opensearch.core.common.Strings;
    }
import java.util.StringJoiner;
import java.nio.charset.Charset;
     *                only the first line of the throwable will be formatted.
    private String formatStacktrace(LogEvent event) {
 * the License. You may obtain a copy of the License at
    private String wrapAsJson(String line) {  
        String[] split = consoleStacktrace.split(lineSeparator);  
import org.apache.logging.log4j.core.config.Configuration;
            String jsonStacktrace = formatJson(consoleStacktrace);  
        throwablePatternConverter.format(event, stringBuilder);  
import org.apache.logging.log4j.core.pattern.PatternConverter;  
 *
/* @notice
 *  
     *
import tools.jackson.core.io.JsonStringEncoder;
        byte[] bytes = JsonStringEncoder.getInstance().quoteAsUTF8(line);
        return true;
    private JsonThrowablePatternConverter(final Configuration config, final String[] options) {  
        }
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
    /**  
import org.apache.logging.log4j.core.pattern.ConverterKeys;
 */
 */  
        return "\"" + new String(bytes, Charset.defaultCharset()) + "\"";
 * See the license for the specific language governing permissions and  
import org.apache.logging.log4j.core.pattern.ThrowablePatternConverter;
            toAppendTo.append(", ");
        this.throwablePatternConverter = ExtendedThrowablePatternConverter.newInstance(config, options);
import org.apache.logging.log4j.core.pattern.ExtendedThrowablePatternConverter;
            stringJoiner.add(wrapAsJson(line));
        }
 * Outputs the Throwable portion of the LoggingEvent as a Json formatted field with array
    }  
 * limitations under the license.
