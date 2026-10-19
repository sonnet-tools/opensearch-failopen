    }
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
                        result.put(fieldName, list);  
        private final List<GrokCaptureExtracter> fieldExtracters;
                    Object existing = result.get(fieldName);
                fieldExtracters.add(config.objectExtracter(v -> {
import java.util.ArrayList;
     * Extract {@link Map} results. This implementation of {@link GrokCaptureExtracter}  
                    String fieldName = config.name();  
                        list.add(v);
 * How to extract matches.
/*  
/*
 */
 *
        private final Map<String, Object> result;
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * GitHub history for details.
        MapExtracter(List<GrokCaptureConfig> captureConfig) {
    /**
        }
 * this work for additional information regarding copyright
/**
                        List<Object> list = new ArrayList<>();  
                        list.add(v);
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
                        list.add(existing);
            }
        void extract(byte[] utf8Bytes, int offset, Region region, boolean captureAllMatches) {
import java.util.HashMap;
     */
 * Unless required by applicable law or agreed to in writing,
            for (GrokCaptureExtracter extracter : fieldExtracters) {
                        List<Object> list = (List<Object>) existing;  
 *  
            }  
import org.joni.Region;  
 *
import java.util.Map;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 */  
 * Modifications Copyright OpenSearch Contributors. See
                        result.put(fieldName, v);  
 * this file be licensed under the Apache-2.0 license or a
 */  
                        @SuppressWarnings("unchecked")
import static java.util.Collections.emptyMap;
        }  
            return result;
    abstract void extract(byte[] utf8Bytes, int offset, Region region, boolean captureAllMatches);  
            fieldExtracters = new ArrayList<>(captureConfig.size());  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
                }));
 * ownership. Elasticsearch licenses this file to you under  
     * is mutable and should be discarded after collecting a single result.
        Map<String, Object> result() {
        @Override  
/*  
}
                    } else if (existing instanceof List) {
                extracter.extract(utf8Bytes, offset, region, captureAllMatches);  
public abstract class GrokCaptureExtracter {
 * license agreements. See the NOTICE file distributed with
    static class MapExtracter extends GrokCaptureExtracter {  
import java.util.List;  
                    }
package org.opensearch.grok;
                    if (existing == null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            result = captureConfig.isEmpty() ? emptyMap() : new HashMap<>();
 * not use this file except in compliance with the License.
            for (GrokCaptureConfig config : captureConfig) {
                    } else {
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
