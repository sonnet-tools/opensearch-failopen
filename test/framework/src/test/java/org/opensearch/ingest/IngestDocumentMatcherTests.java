        IngestDocument document2 = new IngestDocument(Collections.singletonMap(rootKey, Collections.emptyList()), new HashMap<>());
 * SPDX-License-Identifier: Apache-2.0
        assertThrowsOnComparision(document1, document2);
 * not use this file except in compliance with the License.
        IngestDocument document1 = new IngestDocument(Collections.singletonMap(rootKey, Arrays.asList("bar", "baz")), new HashMap<>());
        IngestDocument document1 = new IngestDocument(sourceAndMetadata1, new HashMap<>());  
 * compatible open source license.
}
import java.util.Collections;
    public void testDifferentNestedMapFieldData() {
        );
        IngestDocument document2 = new IngestDocument(new HashMap<>(), new HashMap<>());
 * under the License.  
    }
/*  
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThrowsOnComparision(document1, document2);  
 * specific language governing permissions and limitations
    }
 *
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
            Collections.singletonMap(rootKey, Collections.singletonMap("bar", "baz")),
import java.util.Arrays;  
        IngestDocument document2 = new IngestDocument(Collections.singletonMap(rootKey, Arrays.asList("bar", "blub")), new HashMap<>());  
import java.util.HashMap;
    }  
/*  
    public void testDifferentLengthListData() {
 * license agreements. See the NOTICE file distributed with
            Collections.singletonMap(rootKey, Collections.singletonMap("blub", "blab")),  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        IngestDocument document1 = new IngestDocument(Collections.singletonMap(rootKey, Collections.singletonList("baz")), new HashMap<>());
        assertThrowsOnComparision(document1, document2);  
        IngestDocument document2 = new IngestDocument(
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        );
    }  
package org.opensearch.ingest;
        );  
public class IngestDocumentMatcherTests extends OpenSearchTestCase {
        Map<String, Object> sourceAndMetadata1 = new HashMap<>();
        expectThrows(AssertionError.class, () -> assertIngestDocument(document2, document1));
import org.opensearch.test.OpenSearchTestCase;
 * software distributed under the License is distributed on an
        assertThrowsOnComparision(document1, document2);
        IngestDocument document1 = new IngestDocument(Collections.singletonMap(rootKey, Arrays.asList("bar", "baz")), new HashMap<>());
        String rootKey = "foo";  
    public void testOnTypeConflict() {
/*
    }  
        IngestDocument document1 = new IngestDocument(  
        String rootKey = "foo";
 * this work for additional information regarding copyright
        sourceAndMetadata1.put("foo", "bar");
        String rootKey = "foo";  
            new HashMap<>()
    public void testDifferentMapData() {  
 * You may obtain a copy of the License at  
    private static void assertThrowsOnComparision(IngestDocument document1, IngestDocument document2) {  
            new HashMap<>()  
 */  
 * Licensed to Elasticsearch under one or more contributor  
        expectThrows(AssertionError.class, () -> assertIngestDocument(document1, document2));
 * ownership. Elasticsearch licenses this file to you under  
        assertThrowsOnComparision(document1, document2);
        String rootKey = "foo";
 * the Apache License, Version 2.0 (the "License"); you may
        IngestDocument document2 = new IngestDocument(
 */  
 * KIND, either express or implied.  See the License for the
 *  
            Collections.singletonMap(rootKey, Collections.singletonMap("bar", "blub")),
import java.util.Map;  
 * The OpenSearch Contributors require contributions made to  
    public void testDifferentNestedListFieldData() {  
 */
            new HashMap<>()
