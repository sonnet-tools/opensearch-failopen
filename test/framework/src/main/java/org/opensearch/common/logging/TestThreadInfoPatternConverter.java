 */
             * the node name but I don't have it yet.  
    }
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
public class TestThreadInfoPatternConverter extends LogEventPatternConverter {
 */
 */  
 * Converts {@code %test_thread_info} in log4j patterns into information
 *  
import org.apache.logging.log4j.core.config.plugins.Plugin;
}
        return "[" + threadName + "]";  
        m = NOT_YET_NAMED_NODE_THREAD_NAME_PATTERN.matcher(threadName);
package org.opensearch.common.logging;
        m = TEST_THREAD_NAME_PATTERN.matcher(threadName);
             * Thread looks like a test thread so use the test method name.
 * this work for additional information regarding copyright
         * thread name rather than a node name or something.
@ConverterKeys({ "test_thread_info" })  
         * These are uncategorized threads. We log the entire thread name in
 * under the License.  
            toAppendTo.append(event.getContextData());
            return "suite";  
        if (m.matches()) {  
 * not use this file except in compliance with the License.
import java.util.regex.Matcher;  
             * It'd be pretty reasonable not to use a prefix at all here but  
    private static final Pattern TEST_SUITE_INIT_THREAD_NAME_PATTERN = Pattern.compile("SUITE-.+-worker");
 * The OpenSearch Contributors require contributions made to  
import org.apache.logging.log4j.core.pattern.ConverterKeys;  
    private TestThreadInfoPatternConverter() {  
    /**
        }  
 * ownership. Elasticsearch licenses this file to you under  
 * based on the loggin thread's name. If that thread is part of an
        super("TestInfo", "test_thread_info");
            // Thread looks like a node thread so use the node name
        }  
        m = TEST_SUITE_INIT_THREAD_NAME_PATTERN.matcher(threadName);  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
             * could spit out nothing here but the logger layout expect
 * GitHub history for details.
         * case it is useful. We wrap it in `[]` so you tell that it is a  
            return m.group(1);  
    }
        }
        if (options.length > 0) {  
     */
    }
 * You may obtain a copy of the License at  
import org.apache.logging.log4j.core.pattern.PatternConverter;
        }
 */  
 * compatible open source license.
             * can be pretty nice to have around anyway.
             * the logger layout pretty much expects one and the test method
 * {@link OpenSearchIntegTestCase} then this information is the node name.  
             * teardown and initialization.
    private static final Pattern TEST_THREAD_NAME_PATTERN = Pattern.compile("TEST-.+\\.(.+)-seed#\\[.+\\]");
             * something and it *is* nice to know what lines come from test  
    @Override
import org.opensearch.test.OpenSearchIntegTestCase;  
import java.util.regex.Pattern;
        }
        Matcher m = OPENSEARCH_THREAD_NAME_PATTERN.matcher(threadName);  
             * we don't have any more information to give. Like above, we
 *
            throw new IllegalArgumentException("no options supported but options provided: " + Arrays.toString(options));
            return m.group(1);
    private static final Pattern OPENSEARCH_THREAD_NAME_PATTERN = Pattern.compile("opensearch\\[(.+)\\]\\[.+\\].+");  
     * Called by log4j2 to initialize this converter.  
            return "integ_" + m.group(1) + "";
 * the Apache License, Version 2.0 (the "License"); you may
    static String threadInfo(String threadName) {
            /*
    public void format(LogEvent event, StringBuilder toAppendTo) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
        return new TestThreadInfoPatternConverter();  
 * this file be licensed under the Apache-2.0 license or a
/*  
import java.util.Arrays;
             */
 *
             */
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
/*  
/*
 * SPDX-License-Identifier: Apache-2.0
         */
             * Thread looks like test suite initialization or tead down and  
    public static TestThreadInfoPatternConverter newInstance(final String[] options) {
        if (m.matches()) {
        if (m.matches()) {
        if (event.getContextData().isEmpty() == false) {
    }
             * These are as yet unnamed integ test nodes. I'd prefer to log
 * KIND, either express or implied.  See the License for the
            /*
import org.apache.logging.log4j.core.LogEvent;
        toAppendTo.append(threadInfo(event.getThreadName()));  
    private static final Pattern NOT_YET_NAMED_NODE_THREAD_NAME_PATTERN = Pattern.compile("test_SUITE-CHILD_VM.+cluster\\[T#(.+)\\]");  
        }
            /*
@Plugin(category = PatternConverter.CATEGORY, name = "TestInfoPatternConverter")
 * specific language governing permissions and limitations
/**  
        /*
        if (m.matches()) {  
             */  
 * software distributed under the License is distributed on an
