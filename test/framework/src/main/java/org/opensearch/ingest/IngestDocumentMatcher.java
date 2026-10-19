        }
 * this file be licensed under the Apache-2.0 license or a
 *  
     *
public class IngestDocumentMatcher {
        if (a instanceof Map) {
    }
 * Licensed to Elasticsearch under one or more contributor  
            }
            }
import java.util.Objects;  
 * The OpenSearch Contributors require contributions made to  
            return Objects.deepEquals(a, b);
                return false;  
     * @param docB second document to compare
            }
                return false;  
                    return false;  
        } else if (a instanceof List) {
 * this work for additional information regarding copyright
    /**  
            }  
            List<?> listA = (List<?>) a;
package org.opensearch.ingest;
 * SPDX-License-Identifier: Apache-2.0
            Map<?, ?> mapB = (Map<?, ?>) b;
                if ((isIngestMeta && "timestamp".equals(key)) == false && deepEquals(entry.getValue(), mapB.get(key), false) == false) {
            if (b instanceof Map == false) {
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
                // Don't compare the timestamp of ingest metadata since it will differ between executions
 * the Apache License, Version 2.0 (the "License"); you may
        }
import java.util.Map;
 *
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
import java.util.List;
    private static boolean deepEquals(Object a, Object b, boolean isIngestMeta) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
/*  
        } else {  
            for (Map.Entry<?, ?> entry : mapA.entrySet()) {
                }
                if (deepEquals(value, listB.get(i), false) == false) {
     */
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            int countA = listA.size();
                Object value = listA.get(i);  
            for (int i = 0; i < countA; i++) {
 */  
            Map<?, ?> mapA = (Map<?, ?>) a;  
 *
     * @param docA first document to compare  
/*
/*  
    }  
 * Modifications Copyright OpenSearch Contributors. See
                Object key = entry.getKey();  
            }
     * Helper method to assert the equivalence between two IngestDocuments.
            if (b instanceof List == false) {  
            List<?> listB = (List<?>) b;  
                return false;
            return true;  
                }  
}
            if (countA != listB.size()) {
 * Unless required by applicable law or agreed to in writing,
 */  
 */
            }
 * under the License.  
 * compatible open source license.
            && deepEquals(docA.getSourceAndMetadata(), docB.getSourceAndMetadata(), false)) == false) {
                return false;
            return true;
            if (mapA.size() != mapB.size()) {
            throw new AssertionError("Expected [" + docA + "] but received [" + docB + "].");  
                    return false;
    public static void assertIngestDocument(IngestDocument docA, IngestDocument docB) {  
        if ((deepEquals(docA.getIngestMetadata(), docB.getIngestMetadata(), true)
