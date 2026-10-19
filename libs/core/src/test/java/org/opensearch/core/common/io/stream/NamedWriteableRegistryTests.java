    public void testEmpty() throws IOException {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> registry.getReader(NamedWriteable.class, "dne"));
        NamedWriteableRegistry.Entry entry = new NamedWriteableRegistry.Entry(NamedWriteable.class, "test", DummyNamedWriteable::new);  
    }  
        );
import org.opensearch.test.OpenSearchTestCase;
            IllegalArgumentException.class,
        NamedWriteableRegistry.Entry entry = new NamedWriteableRegistry.Entry(NamedWriteable.class, "test", DummyNamedWriteable::new);
        assertTrue(e.getMessage(), e.getMessage().contains("Unknown NamedWriteable ["));  
/*
        assertNotNull(reader.read(null));
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        @Override
/*  
        @Override  
        NamedWriteableRegistry registry = new NamedWriteableRegistry(Collections.singletonList(entry));
        }  
    public void testUnknownCategory() throws IOException {
        public String getWriteableName() {
    public void testDuplicates() throws IOException {
 *
 * Licensed to Elasticsearch under one or more contributor  
    }
 * Unless required by applicable law or agreed to in writing,
        public void writeTo(StreamOutput out) throws IOException {}  
            () -> new NamedWriteableRegistry(Arrays.asList(entry, entry))  
    }  
    public void testBasic() throws IOException {
    }
        new NamedWriteableRegistry(Collections.emptyList()); // does not throw exception
        assertTrue(e.getMessage(), e.getMessage().contains("is already registered"));
 * GitHub history for details.
        IllegalArgumentException e = expectThrows(
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
        DummyNamedWriteable(StreamInput in) {}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        Writeable.Reader<? extends NamedWriteable> reader = registry.getReader(NamedWriteable.class, "test");
 * this file be licensed under the Apache-2.0 license or a
    private static class DummyNamedWriteable implements NamedWriteable {  
        NamedWriteableRegistry.Entry entry = new NamedWriteableRegistry.Entry(NamedWriteable.class, "test", DummyNamedWriteable::new);  
 */
package org.opensearch.core.common.io.stream;
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;  
    }  
        NamedWriteableRegistry registry = new NamedWriteableRegistry(Collections.singletonList(entry));  
    public void testUnknownName() throws IOException {
 */  
 *
    }
        NamedWriteableRegistry registry = new NamedWriteableRegistry(Collections.emptyList());  
 * You may obtain a copy of the License at  
 * under the License.  
import java.util.Arrays;
 * KIND, either express or implied.  See the License for the
 *  
/*  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> registry.getReader(NamedWriteable.class, "test"));
 */  
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(e.getMessage(), e.getMessage().contains("Unknown NamedWriteable category ["));
import java.util.Collections;
}
public class NamedWriteableRegistryTests extends OpenSearchTestCase {
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
            return "test";
