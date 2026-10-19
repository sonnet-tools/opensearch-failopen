        void setIterator(IntervalIterator iterator) {  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
}
/*  
 *  
    /**  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
     * Internal interval
     * @opensearch.internal
import org.opensearch.script.ScriptFactory;  
 * compatible open source license.
        }
     */
public abstract class IntervalFilterScript {
 *
        IntervalFilterScript newInstance();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.script.ScriptContext;
        public int getGaps() {  
        public int getStart() {
     * Factory to create a script
 * Licensed to Elasticsearch under one or more contributor  
 */  
    }  
/*
     *  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
     * @opensearch.internal  
 * ownership. Elasticsearch licenses this file to you under  
    public static final String[] PARAMETERS = new String[] { "interval" };
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 */  
        }
 *
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("interval", Factory.class);
 * @opensearch.internal
     */
    /**
            return iterator.end();  
 *
    public static class Interval {
            return iterator.gaps();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
/*  
        }
 * You may obtain a copy of the License at  
        public int getEnd() {
        private IntervalIterator iterator;
        }  
     *
    public abstract boolean execute(Interval interval);
/**
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
package org.opensearch.index.query;
            this.iterator = iterator;
import org.apache.lucene.queries.intervals.IntervalIterator;
 * Base class for scripts used as interval filters, see {@link IntervalsSourceProvider.IntervalFilter}  
 */
    public interface Factory extends ScriptFactory {  
            return iterator.start();
    }
