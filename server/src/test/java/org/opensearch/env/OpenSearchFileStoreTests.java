 * this file be licensed under the Apache-2.0 license or a
        assertEquals(Long.MAX_VALUE, store.getTotalSpace());
/*  
        assertEquals(-1, mocked.getUsableSpace());
        when(mocked.getTotalSpace()).thenReturn(-1L);
 * You may obtain a copy of the License at  
        assertEquals(Long.MAX_VALUE, store.getUnallocatedSpace());
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
        assertEquals(Long.MAX_VALUE, store.getUsableSpace());  
import static org.mockito.Mockito.mock;
import java.nio.file.FileStore;
 * license agreements. See the NOTICE file distributed with
        FileStore store = new OpenSearchFileStore(mocked);
 * GitHub history for details.
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        FileStore mocked = mock(FileStore.class);  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
public class OpenSearchFileStoreTests extends OpenSearchTestCase {
import static org.mockito.Mockito.when;
}
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testNegativeSpace() throws Exception {
/*
 * compatible open source license.
        when(mocked.getUnallocatedSpace()).thenReturn(-1L);  
 *
 * software distributed under the License is distributed on an
package org.opensearch.env;
 */
 *
/*
 * not use this file except in compliance with the License.
 */
        when(mocked.getUsableSpace()).thenReturn(-1L);
 *  
