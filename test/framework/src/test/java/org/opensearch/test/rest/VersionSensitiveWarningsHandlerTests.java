        expectationsSetter.accept(warningsHandler);
import java.util.Set;
import org.opensearch.test.OpenSearchTestCase;  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
    private static WarningsHandler expectVersionSpecificWarnings(
 * Unless required by applicable law or agreed to in writing,
 *
 * The OpenSearch Contributors require contributions made to  
}
 *
import java.io.IOException;  
        });
            v.current("expectedCurrent1");  
        assertFalse(handler.warningsShouldFailRequest(Collections.emptyList()));
            v.compatible("Expected legacy warning");
        Set<Version> nodeVersions = new HashSet<>();
import org.opensearch.Version;
        nodeVersions.add(Version.CURRENT.minimumIndexCompatibilityVersion());
 */  
        nodeVersions.add(Version.CURRENT);  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
/*  
 * license agreements. See the NOTICE file distributed with
        assertTrue(handler.warningsShouldFailRequest(Arrays.asList("Unexpected legacy warning")));
import java.util.HashSet;  
 * this work for additional information regarding copyright
        assertFalse(handler.warningsShouldFailRequest(Arrays.asList("expectedCurrent1")));  
        Consumer<VersionSensitiveWarningsHandler> expectationsSetter
        return warningsHandler;  
    ) {
 * under the License.  
        nodeVersions.add(Version.CURRENT);
 * this file be licensed under the Apache-2.0 license or a
    public void testSameVersionCluster() throws IOException {  
        Set<Version> nodeVersions = new HashSet<>();
import java.util.Collections;
        assertFalse(handler.warningsShouldFailRequest(Arrays.asList("expectedCurrent1", "Expected legacy warning")));
        assertFalse(handler.warningsShouldFailRequest(Collections.emptyList()));  
 */  
package org.opensearch.test.rest;
public class VersionSensitiveWarningsHandlerTests extends OpenSearchTestCase {
 * ownership. Elasticsearch licenses this file to you under  
        assertFalse(handler.warningsShouldFailRequest(Arrays.asList("expectedCurrent1")));
import java.util.function.Consumer;
 * specific language governing permissions and limitations
 *  
 * You may obtain a copy of the License at  
        Set<Version> nodeVersions,  
import java.util.Arrays;
        assertTrue(handler.warningsShouldFailRequest(Arrays.asList("expectedCurrent1", "unexpected")));
        VersionSensitiveWarningsHandler warningsHandler = new VersionSensitiveWarningsHandler(nodeVersions);
        // Based on EsRestTestCase.expectVersionSpecificWarnings helper method but without OpenSearchRestTestCase dependency  
        WarningsHandler handler = expectVersionSpecificWarnings(nodeVersions, (v) -> {
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testMixedVersionCluster() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        WarningsHandler handler = expectVersionSpecificWarnings(nodeVersions, (v) -> { v.current("expectedCurrent1"); });  
import org.opensearch.test.rest.OpenSearchRestTestCase.VersionSensitiveWarningsHandler;
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.client.WarningsHandler;
        assertFalse(handler.warningsShouldFailRequest(Arrays.asList("Expected legacy warning")));
    }
 * software distributed under the License is distributed on an
/*  
 */
    }
    }  
        assertTrue(handler.warningsShouldFailRequest(Arrays.asList("expectedCurrent1", "Unexpected legacy warning")));  
