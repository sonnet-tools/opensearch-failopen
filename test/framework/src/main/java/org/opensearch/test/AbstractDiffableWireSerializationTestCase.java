 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 */  
 *
 * You may obtain a copy of the License at  
 * Writable serialization and is diffable.
 *
import org.opensearch.core.common.io.stream.Writeable.Reader;  
        );
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        DiffableTestUtils.testDiffableSerialization(
    /**
 */  
            instanceReader(),
            diffReader()  
 * <p>  
}  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
/*  
 * this file be licensed under the Apache-2.0 license or a
 * This class can be used as a based class for tests of ClusterState.Custom classes and other classes that support {@link org.opensearch.core.common.io.stream.Writeable } serialization and is diffable.
     *  Introduces random changes into the test object  
import org.opensearch.cluster.Diff;
            this::createTestInstance,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.Diffable;
 * compatible open source license.
     */
 *  
    public final void testDiffableSerialization() throws IOException {  
 * software distributed under the License is distributed on an
 * An abstract test case to ensure correct behavior of Diffable.
import java.io.IOException;
 * specific language governing permissions and limitations
public abstract class AbstractDiffableWireSerializationTestCase<T extends Diffable<T>> extends AbstractWireSerializingTestCase<T> {
/*
            this::makeTestChanges,  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
            getNamedWriteableRegistry(),
/*  
 */  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
    protected abstract T makeTestChanges(T testInstance);
/**
 */
package org.opensearch.test;
    protected abstract Reader<Diff<T>> diffReader();
