}
 * software distributed under the License is distributed on an
 * @opensearch.internal
     */
package org.opensearch.ingest;
/*
    public static final class Factory implements Processor.Factory {
 * GitHub history for details.
    public static final String TYPE = "drop";
        ) {
            final String description,
 * under the License.  
 */
 *  
        super(tag, description);
            final Map<String, Object> config  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    private DropProcessor(final String tag, final String description) {
/**  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
import java.util.Map;
     *
    @Override
/*  
 *  
 * SPDX-License-Identifier: Apache-2.0
    public String getType() {
 * ownership. Elasticsearch licenses this file to you under  
        return TYPE;  
 * license agreements. See the NOTICE file distributed with
     * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
    public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
            final String tag,
    }
 */
 * not use this file except in compliance with the License.
 * Drop processor only returns {@code null} for the execution result to indicate that any document
        return null;
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
            final Map<String, Processor.Factory> processorFactories,  
 *
        @Override
            return new DropProcessor(tag, description);
    /**  
    @Override
 *
 * executed by it should not be indexed.
        public Processor create(
 */  
 * Licensed to Elasticsearch under one or more contributor  
     * A factory for the processor.
 * Modifications Copyright OpenSearch Contributors. See
 */  
        }  
    }
    }
public final class DropProcessor extends AbstractProcessor {  
