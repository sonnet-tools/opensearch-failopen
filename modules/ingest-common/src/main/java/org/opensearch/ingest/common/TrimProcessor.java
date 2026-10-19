 *
    @Override  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        super(processorTag, description, ignoreMissing, targetField, field);  
}
 */  
 *  
 * SPDX-License-Identifier: Apache-2.0
    public static final String TYPE = "trim";  
/**  
            return new TrimProcessor(tag, description, field, ignoreMissing, targetField);
        }
            String field,  
/*
public final class TrimProcessor extends AbstractStringProcessor<String> {
 */  
 * ownership. Elasticsearch licenses this file to you under  
            Map<String, Object> config,
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
            String description,
    public String getType() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static final class Factory extends AbstractStringProcessor.Factory {
    TrimProcessor(String processorTag, String description, String field, boolean ignoreMissing, String targetField) {
 * not use this file except in compliance with the License.
            String targetField
 * under the License.  
 */  
    }
    @Override
 * GitHub history for details.
        public Factory() {  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
            boolean ignoreMissing,
import java.util.Map;
        ) {  
    }  
        return value.trim();
 * Unless required by applicable law or agreed to in writing,
            super(TYPE);
package org.opensearch.ingest.common;
    }  
        }
 * Throws exception is the field is not of type string.
    protected String process(String value) {
 * the Apache License, Version 2.0 (the "License"); you may
        protected TrimProcessor newProcessor(
 * software distributed under the License is distributed on an
/*  
 * Licensed to Elasticsearch under one or more contributor  
        @Override
        return TYPE;
 */
    }
 *
 * license agreements. See the NOTICE file distributed with
 * Processor that trims the content of string fields.
            String tag,  
