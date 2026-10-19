 * You may obtain a copy of the License at  
 */
    public static final class Factory extends AbstractStringProcessor.Factory {
        return TYPE;
    }  
    }
 * Licensed to Elasticsearch under one or more contributor  
 * Throws exception is the field is not of type string.  
        return apply(value);
 * under the License.  
            boolean ignoreMissing,
package org.opensearch.ingest.common;
    public String getType() {  
    public static final String TYPE = "lowercase";
 * KIND, either express or implied.  See the License for the
import java.util.Locale;
 * Modifications Copyright OpenSearch Contributors. See
        }
            return new LowercaseProcessor(tag, description, field, ignoreMissing, targetField);
            String description,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
            String field,  
 */  
            String tag,  
/*  
 *
 * compatible open source license.
/**
 * Processor that converts the content of string fields to lowercase.
 * this file be licensed under the Apache-2.0 license or a
 *
        @Override
    public static String apply(String value) {
            Map<String, Object> config,
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
}
        return value.toLowerCase(Locale.ROOT);  
public final class LowercaseProcessor extends AbstractStringProcessor<String> {  
    }  
 * GitHub history for details.
 */
        super(processorTag, description, ignoreMissing, targetField, field);
        protected LowercaseProcessor newProcessor(
    @Override
    @Override  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
            super(TYPE);
        }
            String targetField
 * this work for additional information regarding copyright
 */  
        ) {  
 *  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
/*
    }  
    protected String process(String value) {
    }
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
        public Factory() {  
    LowercaseProcessor(String processorTag, String description, String field, boolean ignoreMissing, String targetField) {
