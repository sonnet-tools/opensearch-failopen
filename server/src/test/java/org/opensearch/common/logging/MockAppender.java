 * under the License.  
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.logging.log4j.core.LogEvent;
 *  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 *
    public LogEvent getLastEventAndReset() {
import org.apache.logging.log4j.core.appender.AbstractAppender;
    @Override
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
/*
    ParameterizedMessage lastParameterizedMessage() {  
        return (ParameterizedMessage) lastEvent.getMessage();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.common.logging;
 */  
 * Licensed to Elasticsearch under one or more contributor  
public class MockAppender extends AbstractAppender {  
/*  
        return toReturn;
        super(name, RegexFilter.createFilter(".*(\n.*)*", new String[0], false, null, null), null);
    public LogEvent lastEvent;
    }
import org.apache.logging.log4j.message.ParameterizedMessage;
        lastEvent = null;  
    }
    }
 *
import org.apache.logging.log4j.core.filter.RegexFilter;  
 * this file be licensed under the Apache-2.0 license or a
}  
    }
    public MockAppender(final String name) throws IllegalAccessException {  
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
    public void append(LogEvent event) {
        LogEvent toReturn = lastEvent;
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
/*  
        lastEvent = event.toImmutable();  
