        }
    /**  
     *
import org.apache.logging.log4j.Logger;
     * The marker for this prefix logger.
            } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
import java.util.WeakHashMap;  
 * @opensearch.internal  
        assert marker == null;
     *  
import org.apache.logging.log4j.MarkerManager;
/*
 *
 * You may obtain a copy of the License at  
/**
 * SPDX-License-Identifier: Apache-2.0
     * however, we have transient markers from index-level and shard-level components so this would effectively be a memory leak. Since we  
 */
     * Return the size of the cached markers. This size can vary as markers are cached but collected during GC activity when a given prefix
 * the Apache License, Version 2.0 (the "License"); you may
     */
                 * collected. This also guarantees that no other strong reference can be held to the prefix anywhere.  
    }  
        this.marker = actualMarker;
     * is no longer in use.
     */
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @return the size of the cached markers
 * software distributed under the License is distributed on an
 * under the License.  
 * KIND, either express or implied.  See the License for the
     * can not tie into the lifecycle of these components, we have to use a mechanism that enables garbage collection of such markers when
 * compatible open source license.
    private static final WeakHashMap<String, Marker> markers = new WeakHashMap<>();
    /**
    private final Marker marker;
 * Modifications Copyright OpenSearch Contributors. See
    /**  
                markers.put(new String(prefix), actualMarker);  
        synchronized (markers) {
                // noinspection RedundantStringConstructorCall
        super.logMessage(fqcn, level, this.marker, message, t);
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
        }
            }  
            throw new IllegalArgumentException("if you don't need a prefix then use a regular logger");
 */  
     *
 * specific language governing permissions and limitations
        super((ExtendedLogger) logger, logger.getName(), null);
            final Marker maybeMarker = markers.get(prefix);  
 */
    public void logMessage(final String fqcn, final Level level, final Marker marker, final Message message, final Throwable t) {  
     */
     */  
     */  
import org.apache.logging.log4j.spi.ExtendedLogger;  
package org.opensearch.common.logging;
                 */
     * We can not use the built-in Marker tracking (MarkerManager) because the MarkerManager holds a permanent reference to the marker;
 * this work for additional information regarding copyright
 * A logger that prefixes all messages with a fixed prefix specified during construction. The prefix mechanism uses the marker construct, so  
    /*
 * not use this file except in compliance with the License.
                actualMarker = maybeMarker;
 * for the prefixes to appear, the logging layout pattern must include the marker in its pattern.
     * Construct a prefix logger with the specified name and prefix.
 */  
 *
 *  
class PrefixLogger extends ExtendedLoggerWrapper {
    static int markersSize() {  
 *
 * this file be licensed under the Apache-2.0 license or a
                 * those references are held strongly, this would give a strong reference back to the key preventing them from ever being
import org.apache.logging.log4j.message.Message;
        // markers is not thread-safe, so we synchronize access
 * Unless required by applicable law or agreed to in writing,
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;
        if (prefix == null || prefix.isEmpty()) {  
        return markers.size();
     * @return the prefix  
    public String prefix() {
                /*  
            if (maybeMarker == null) {
/*  
        final Marker actualMarker;  
     * Obtain the prefix for this prefix logger. This can be used to create a logger with the same prefix as this one.
import org.apache.logging.log4j.Marker;  
    PrefixLogger(final Logger logger, final String prefix) {  
 * license agreements. See the NOTICE file distributed with
     * they are no longer in use.
    /**  
 * The OpenSearch Contributors require contributions made to  
        return marker.getName();  
    }  
                 * We must create a new instance here as otherwise the marker will hold a reference to the key in the weak hash map; as
                actualMarker = new MarkerManager.Log4jMarker(prefix);
}
import org.apache.logging.log4j.Level;
     * @param prefix the prefix for this prefix logger
     * @param logger the extended logger to wrap  
    @Override
    }
