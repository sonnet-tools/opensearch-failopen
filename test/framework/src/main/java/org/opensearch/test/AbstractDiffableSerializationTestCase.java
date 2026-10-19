    }
 * license agreements. See the NOTICE file distributed with
    public final void testDiffableSerialization() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    protected abstract T makeTestChanges(T testInstance);
 * Writable serialization, XContent-based serialization and is diffable.  
import org.opensearch.core.xcontent.ToXContent;
 * This class can be used as a based class for tests of Metadata.Custom classes and other classes that support {@link org.opensearch.core.common.io.stream.Writeable } serialization, XContent-based serialization and is diffable.
import org.opensearch.cluster.Diff;
            this::createTestInstance,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *  Introduces random changes into the test object
/*
 */
 *
            getNamedWriteableRegistry(),  
import org.opensearch.cluster.Diffable;
            diffReader()
 *  
 * You may obtain a copy of the License at  
     */  
 */
 * Unless required by applicable law or agreed to in writing,
 * An abstract test case to ensure correct behavior of Diffable.  
            this::makeTestChanges,
 * <p>
        );  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.Writeable.Reader;  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
/**
 * specific language governing permissions and limitations
 * GitHub history for details.
 */  
    /**
 */  
}
package org.opensearch.test;
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
public abstract class AbstractDiffableSerializationTestCase<T extends Diffable<T> & ToXContent> extends AbstractSerializingTestCase<T> {
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;  
 *
        DiffableTestUtils.testDiffableSerialization(  
            instanceReader(),
 * Licensed to Elasticsearch under one or more contributor  
    protected abstract Reader<Diff<T>> diffReader();  
