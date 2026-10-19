 * this work for additional information regarding copyright
 */  
/*  
    @Override
        return getLogger(component).isTraceEnabled() && component.equals("TP") == false;  
    }  
    }
        // TP is a special "test point" component; we don't want
 * KIND, either express or implied.  See the License for the
 */
 *  
}  
    private final Map<String, Logger> loggers = new ConcurrentHashMap<>();  
 *
    public LoggerInfoStream(final Logger parentLogger) {
    }
 * compatible open source license.
 *
 */
        getLogger(component).trace("{} {}: {}", Thread.currentThread().getName(), component, message);
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 *  messages to "lucene.iw.ifd" and "lucene.iw" Logger.trace.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.logging.Loggers;  
package org.opensearch.common.lucene;
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
    }
 * @opensearch.internal  
/*
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.logging.log4j.Logger;
 * specific language governing permissions and limitations
 *
 * ownership. Elasticsearch licenses this file to you under  
import java.util.concurrent.ConcurrentHashMap;  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        // to log it:
    public void close() {
 * GitHub history for details.
    private final Logger parentLogger;
 * An InfoStream (for Lucene's IndexWriter) that redirects  
        return loggers.computeIfAbsent(component, c -> Loggers.getLogger(parentLogger, "." + c));
import org.apache.lucene.util.InfoStream;
 * Modifications Copyright OpenSearch Contributors. See
    }
    public boolean isEnabled(String component) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.parentLogger = parentLogger;  
/**
 * this file be licensed under the Apache-2.0 license or a
    private Logger getLogger(String component) {  
    @Override  
 * The OpenSearch Contributors require contributions made to  
    public void message(String component, String message) {
import java.util.Map;
public final class LoggerInfoStream extends InfoStream {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    @Override
 */  
 * Unless required by applicable law or agreed to in writing,
