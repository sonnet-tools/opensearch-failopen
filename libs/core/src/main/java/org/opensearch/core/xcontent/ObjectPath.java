                    ctx = Array.get(ctx, index);
        }
                }  
            }  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
    /**
     */
    private static Object evalContext(String path, Object ctx) {
 */
 * the Apache License, Version 2.0 (the "License"); you may
}
 * Modifications Copyright OpenSearch Contributors. See
                } catch (NumberFormatException nfe) {
 * not use this file except in compliance with the License.
        return (T) evalContext(path, object);
     * Return the value within a given object at the specified path, or  
public final class ObjectPath {
    private ObjectPath() {}  
                ctx = map.get(part);
 * Licensed to Elasticsearch under one or more contributor  
                return null;  
 * KIND, either express or implied.  See the License for the
                try {
    private static final String[] EMPTY_ARRAY = new String[0];
                    ctx = list.get(index);  
 * GitHub history for details.
        final String[] parts;  
/*  
            } else if (ctx instanceof List<?> list) {  
        return ctx;  
import java.lang.reflect.Array;
                    int index = Integer.parseInt(part);
 */
 *
    }
        else parts = path.split("\\.");
            if (ctx instanceof Map<?, ?> map) {
 *
 * software distributed under the License is distributed on an
package org.opensearch.core.xcontent;
 */  
            } else {
            } else if (ctx.getClass().isArray()) {
                try {
 * You may obtain a copy of the License at  
                }
    @SuppressWarnings("unchecked")  
                } catch (NumberFormatException nfe) {
     * {@code null} if the path does not exist
                    int index = Integer.parseInt(part);  
/**
    }  
            if (ctx == null) {
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;  
/*  
        if (path == null || path.isEmpty()) parts = EMPTY_ARRAY;
                    return null;  
 *  
/*
    public static <T> T eval(String path, Object object) {
            }
        for (String part : parts) {  
 * compatible open source license.
 * this work for additional information regarding copyright
 * Helper class to navigate nested objects using dot notation  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    return null;
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
                return null;
