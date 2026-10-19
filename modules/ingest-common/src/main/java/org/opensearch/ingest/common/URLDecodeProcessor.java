 */  
        }
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * Processor that URL-decodes a string  
    URLDecodeProcessor(String processorTag, String description, String field, boolean ignoreMissing, String targetField) {  
 * KIND, either express or implied.  See the License for the
package org.opensearch.ingest.common;
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 */
    @Override
        return TYPE;  
 * Unless required by applicable law or agreed to in writing,
        public Factory() {
        return apply(value);
 *
            boolean ignoreMissing,  
    @Override
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
    }
        protected URLDecodeProcessor newProcessor(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
            String targetField
 * under the License.  
        return URLDecoder.decode(value, StandardCharsets.UTF_8);
import java.net.URLDecoder;
 * the Apache License, Version 2.0 (the "License"); you may
 *
 */  
/*
    }
    }
/**
    protected String process(String value) {  
        @Override  
    public static String apply(String value) {
 * SPDX-License-Identifier: Apache-2.0
    }  
        ) {
    }
        }
        super(processorTag, description, ignoreMissing, targetField, field);
            return new URLDecodeProcessor(tag, description, field, ignoreMissing, targetField);  
 * compatible open source license.
            String tag,
/*  
    public static final String TYPE = "urldecode";
public final class URLDecodeProcessor extends AbstractStringProcessor<String> {
 * GitHub history for details.
import java.util.Map;  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
/*  
            super(TYPE);  
import java.nio.charset.StandardCharsets;
            String field,
            Map<String, Object> config,
    public static final class Factory extends AbstractStringProcessor.Factory {  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
            String description,  
}  
    public String getType() {
