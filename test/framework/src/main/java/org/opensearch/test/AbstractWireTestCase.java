import org.opensearch.core.common.io.stream.Writeable;
    /**  
    }  
    /**  
    }
 *
     */
        assertSerialization(testInstance, Version.CURRENT);  
    /**  
     */  
    /**
     * Override this method if you need to register {@link NamedWriteable}s for the test object to de-serialize.
    /**
     * for sanity checking the backwards compatibility of the wire. It isn't a substitute for
     */
    public final void testEqualsAndHashcode() {
package org.opensearch.test;
     */
        assertEquals(expectedInstance.hashCode(), newInstance.hashCode());
     * <p>  
    }
    }
        }
        assertEqualInstances(testInstance, deserializedInstance);
 * compatible open source license.
            assertSerialization(testInstance);
 */
     * real backwards compatibility tests but it is *so* much faster.  
 * specific language governing permissions and limitations
 * under the License.  
    }
     * versions of the instance are equal.
    protected T mutateInstance(T instance) throws IOException {
     * Returns an instance which is mutated slightly so it should not be equal
     * Creates a random test instance to use in the tests. This method will be  
        return copyInstance(instance, Version.CURRENT);  
     * to the given instance.
    protected abstract T copyInstance(T instance, Version version) throws IOException;
public abstract class AbstractWireTestCase<T> extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
     * By default this will return a {@link NamedWriteableRegistry} with no registered {@link NamedWriteable}s  
        assertNotSame(newInstance, expectedInstance);  
/**  
 * The OpenSearch Contributors require contributions made to  
/*
     * Copy the instance as by reading and writing using the code specific to the provided version.
        T deserializedInstance = copyInstance(testInstance, version);  
 * ownership. Elasticsearch licenses this file to you under  
    /**
 *  
    /**
    protected static final int NUMBER_OF_TEST_RUNS = 20;  
     */
    /**
     * random instance each time it is called.
        assertEquals(expectedInstance, newInstance);
     * Assert that instances copied at a particular version are equal. The version is useful
 * Licensed to Elasticsearch under one or more contributor  
 * Standard test case for testing wire serialization. If the class being tested
        return new NamedWriteableRegistry(Collections.emptyList());  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
        for (int runs = 0; runs < NUMBER_OF_TEST_RUNS; runs++) {
     * how equality is checked.  
import java.io.IOException;  
     * Serialize the given instance and asserts that both are equal.  
 * Modifications Copyright OpenSearch Contributors. See
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
 * SPDX-License-Identifier: Apache-2.0
}
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
 */  
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(createTestInstance(), this::copyInstance, this::mutateInstance);  
/*  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
     * Tests that the equals and hashcode methods are consistent and copied
    protected final T copyInstance(T instance) throws IOException {
     */  
     * Test serialization and deserialization of the test instance.
    public final void testSerialization() throws IOException {
     * The version is useful for sanity checking the backwards compatibility of the wire. It isn't
     * Get the {@link NamedWriteableRegistry} to use when de-serializing the object.
import java.util.Collections;
     * called multiple times during test execution and should return a different
    protected abstract T createTestInstance();
 * KIND, either express or implied.  See the License for the
            T testInstance = createTestInstance();  
 */  
import org.opensearch.core.common.io.stream.NamedWriteable;
    protected final void assertSerialization(T testInstance) throws IOException {
 */  
 * Unless required by applicable law or agreed to in writing,
        }
    // TODO: Make this abstract when all sub-classes implement this (https://github.com/elastic/elasticsearch/issues/25929)
     * <p>
     */  
     */  
    }  
        for (int runs = 0; runs < NUMBER_OF_TEST_RUNS; runs++) {
import org.opensearch.Version;
 * this work for additional information regarding copyright
    protected final void assertSerialization(T testInstance, Version version) throws IOException {
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 *
 * not use this file except in compliance with the License.
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * a substitute for real backwards compatibility tests but it is *so* much faster.  
    protected void assertEqualInstances(T expectedInstance, T newInstance) {
     * Assert that two instances are equal. This is intentionally not final so we can override
     */
 * You may obtain a copy of the License at  
        return null;  
 * extends {@link Writeable} then prefer extending {@link AbstractWireSerializingTestCase}.
