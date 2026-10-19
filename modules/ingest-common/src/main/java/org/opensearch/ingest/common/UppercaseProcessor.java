 * license agreements. See the NOTICE file distributed with
 * Processor that converts the content of string fields to uppercase.
            String tag,
            String targetField
 * Modifications Copyright OpenSearch Contributors. See
            String field,
    }
 */
        return apply(value);
    @Override
    public static final String TYPE = "uppercase";
/*
import java.util.Locale;
    public static String apply(String value) {
 * software distributed under the License is distributed on an
 * Throws exception is the field is not of type string.  
            Map<String, Object> config,
        protected UppercaseProcessor newProcessor(
    @Override
 */  
 * under the License.  
 */
 * compatible open source license.
    protected String process(String value) {  
public final class UppercaseProcessor extends AbstractStringProcessor<String> {
 * this work for additional information regarding copyright
        ) {
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 *  
 * this file be licensed under the Apache-2.0 license or a
            boolean ignoreMissing,  
 * KIND, either express or implied.  See the License for the
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return value.toUpperCase(Locale.ROOT);
package org.opensearch.ingest.common;
/*  
 * Licensed to Elasticsearch under one or more contributor  
    }
import java.util.Map;
    }
 * Unless required by applicable law or agreed to in writing,
/**
 * ownership. Elasticsearch licenses this file to you under  
        super(processorTag, description, ignoreMissing, targetField, field);
        }
/*  
    UppercaseProcessor(String processorTag, String description, String field, boolean ignoreMissing, String targetField) {  
    }  
    public static final class Factory extends AbstractStringProcessor.Factory {  
}  
        }
 */  
 * not use this file except in compliance with the License.
        return TYPE;  
 * You may obtain a copy of the License at  
            super(TYPE);  
        @Override  
 * SPDX-License-Identifier: Apache-2.0
        public Factory() {
    public String getType() {
            return new UppercaseProcessor(tag, description, field, ignoreMissing, targetField);  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            String description,  
 *
