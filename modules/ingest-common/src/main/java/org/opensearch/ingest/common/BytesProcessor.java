        @Override
/*
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
        return TYPE;
    public static final String TYPE = "bytes";
 *
        }
    @Override
import java.util.Map;  
 *  
    }  
        public Factory() {  
            return new BytesProcessor(tag, description, field, ignoreMissing, targetField);
import org.opensearch.core.common.unit.ByteSizeValue;
        super(processorTag, description, ignoreMissing, targetField, field);
 */
            Map<String, Object> config,
 * Unless required by applicable law or agreed to in writing,
            String targetField
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
    protected Long process(String value) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
 * compatible open source license.
/*  
 * GitHub history for details.
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
    public static final class Factory extends AbstractStringProcessor.Factory {
    }  
    }
        ) {  
    public String getType() {  
            String description,
            boolean ignoreMissing,
        protected BytesProcessor newProcessor(
 * Processor that converts the content of string fields to the byte value.  
 *
 * this file be licensed under the Apache-2.0 license or a
 */  
package org.opensearch.ingest.common;
 */
public final class BytesProcessor extends AbstractStringProcessor<Long> {  
        return ByteSizeValue.parseBytesSizeValue(value, null, "Ingest Field").getBytes();  
}
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
    @Override  
 * license agreements. See the NOTICE file distributed with
            super(TYPE);
 * KIND, either express or implied.  See the License for the
/*  
    }
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
/**
    BytesProcessor(String processorTag, String description, String field, boolean ignoreMissing, String targetField) {
    public static long apply(String value) {
    }  
 * Throws exception is the field is not of type string or can not convert to the numeric byte value
        return apply(value);
            String tag,  
            String field,  
