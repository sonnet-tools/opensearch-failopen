    public static void json(Map<String, Object> ctx, String field) {  
 * GitHub history for details.
 * You may obtain a copy of the License at  
    }  
 * Modifications Copyright OpenSearch Contributors. See
    }
/*
 *
 */  
 *  
    public static String lowercase(String value) {  
/*  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    public static String uppercase(String value) {
}
 * ownership. Elasticsearch licenses this file to you under  
 */  
    }
 * the Apache License, Version 2.0 (the "License"); you may
public final class Processors {  
    }  
import java.util.Map;
        return JsonProcessor.apply(fieldValue);  
 * The OpenSearch Contributors require contributions made to  
 */
    public static Object json(Object fieldValue) {
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * compatible open source license.
package org.opensearch.ingest.common;
 * KIND, either express or implied.  See the License for the
        return URLDecodeProcessor.apply(value);
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
/*  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        return BytesProcessor.apply(value);  
    }
    public static long bytes(String value) {
        return UppercaseProcessor.apply(value);
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        JsonProcessor.apply(ctx, field);
 * under the License.  
        return LowercaseProcessor.apply(value);
 * SPDX-License-Identifier: Apache-2.0
    public static String urlDecode(String value) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
