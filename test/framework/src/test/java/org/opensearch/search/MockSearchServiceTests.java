 * KIND, either express or implied.  See the License for the
    }
import org.opensearch.search.internal.ReaderContext;
            assertEquals(MockSearchService.class.getName(), e.getStackTrace()[0].getClassName());  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.search;
            assertEquals(
 * Unless required by applicable law or agreed to in writing,
 *
}  
        } finally {
 * compatible open source license.
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
                "There are still [1] in-flight contexts. The first one's creation site is listed as the cause of this exception.",
 */  
        ReaderContext reader = mock(ReaderContext.class);  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
        MockSearchService.addActiveContext(reader);
 * this work for additional information regarding copyright
 * GitHub history for details.
/*  
 */
 * SPDX-License-Identifier: Apache-2.0
 *
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals(MockSearchServiceTests.class.getName(), e.getStackTrace()[1].getClassName());
 * not use this file except in compliance with the License.
            e = e.getCause();
    public void testAssertNoInFlightContext() {
 * this file be licensed under the Apache-2.0 license or a
 *  
 * specific language governing permissions and limitations
        }
            );
            Throwable e = expectThrows(AssertionError.class, () -> MockSearchService.assertNoInFlightContext());  
import static org.mockito.Mockito.mock;
        try {
/*  
 * license agreements. See the NOTICE file distributed with
public class MockSearchServiceTests extends OpenSearchTestCase {  
            MockSearchService.removeActiveContext(reader);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                e.getMessage()  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
import org.opensearch.test.OpenSearchTestCase;
/*
