    },
        };
                for (int number : backRefs) {
        <T> T nativeExtracter(int[] backRefs, NativeExtracterMap<T> map) {
    STRING {  
    abstract <T> T nativeExtracter(int[] backRefs, NativeExtracterMap<T> map);
import org.opensearch.grok.GrokCaptureConfig.NativeExtracterMap;
                return FLOAT;  
            return map.forString(emit -> rawExtracter(backRefs, emit));  
            case "long":  
    }
            return map.forBoolean(emit -> rawExtracter(backRefs, str -> emit.accept(Boolean.parseBoolean(str))));  
 * specific language governing permissions and limitations
    };
package org.opensearch.grok;
    BOOLEAN {  
 * The type defined for the field in the pattern.  
/*  
            return map.forLong(emit -> rawExtracter(backRefs, str -> emit.accept(Long.parseLong(str))));  
                }  
 * not use this file except in compliance with the License.
 *
enum GrokCaptureType {
        @Override
 */  
 * SPDX-License-Identifier: Apache-2.0
                        // return the first match value if captureAllMatches is false, else continue to capture all values
 * You may obtain a copy of the License at  
import java.nio.charset.StandardCharsets;  
            case "float":
 * the Apache License, Version 2.0 (the "License"); you may
    },
        @Override
    }  
                            return;  
        @Override
    },
        }
        <T> T nativeExtracter(int[] backRefs, NativeExtracterMap<T> map) {
 * Licensed to Elasticsearch under one or more contributor  
            void extract(byte[] utf8Bytes, int offset, Region region, boolean captureAllMatches) {
        return new GrokCaptureExtracter() {
                return LONG;
 * software distributed under the License is distributed on an
        @Override
 * Modifications Copyright OpenSearch Contributors. See
            default:
                        int matchLength = region.getEnd(number) - region.getBeg(number);
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        <T> T nativeExtracter(int[] backRefs, NativeExtracterMap<T> map) {
/**
                        if (!captureAllMatches) {
 * compatible open source license.
 */
                        }
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    LONG {  
                        emit.accept(new String(utf8Bytes, matchOffset, matchLength, StandardCharsets.UTF_8));  
                return DOUBLE;
 * ownership. Elasticsearch licenses this file to you under  
            return map.forInt(emit -> rawExtracter(backRefs, str -> emit.accept(Integer.parseInt(str))));  
            case "double":
    INTEGER {  
        }
    },
/*
        }
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
            case "boolean":  
 *  
        }
}
        }
            case "int":
    },
                return STRING;  
        }
                return INTEGER;
 */  
    static GrokCaptureType fromString(String str) {  
    DOUBLE {  
/*  
        <T> T nativeExtracter(int[] backRefs, NativeExtracterMap<T> map) {
        }
        switch (str) {
        <T> T nativeExtracter(int[] backRefs, NativeExtracterMap<T> map) {
        @Override
                return STRING;  
            }
 */
                        int matchOffset = offset + region.getBeg(number);
        @Override
import java.util.function.Consumer;
        <T> T nativeExtracter(int[] backRefs, NativeExtracterMap<T> map) {
            return map.forDouble(emit -> rawExtracter(backRefs, str -> emit.accept(Double.parseDouble(str))));  
            @Override  
    protected final GrokCaptureExtracter rawExtracter(int[] backRefs, Consumer<? super String> emit) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * under the License.  
                return BOOLEAN;
                    }
 * KIND, either express or implied.  See the License for the
                    if (region.getBeg(number) >= 0) {  
            case "string":
            return map.forFloat(emit -> rawExtracter(backRefs, str -> emit.accept(Float.parseFloat(str))));  
 *
    FLOAT {  
import org.joni.Region;  
