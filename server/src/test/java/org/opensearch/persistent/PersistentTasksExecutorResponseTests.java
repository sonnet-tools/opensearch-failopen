 *
 * not use this file except in compliance with the License.
import java.util.Collections;
/*  
        );
package org.opensearch.persistent;
                new NamedWriteableRegistry.Entry(
 *  
                    TestPersistentTasksExecutor.NAME,
 */
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 */
 * The OpenSearch Contributors require contributions made to  
                    TestPersistentTasksExecutor.NAME,  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
}  
 */  
/*
            );
    }
            )  
    protected PersistentTaskResponse createTestInstance() {  
 * ownership. Elasticsearch licenses this file to you under  
                new PersistentTask<PersistentTaskParams>(  
 *
    @Override  
        return PersistentTaskResponse::new;  
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;  
 * Modifications Copyright OpenSearch Contributors. See  
public class PersistentTasksExecutorResponseTests extends AbstractWireSerializingTestCase<PersistentTaskResponse> {  
                )  
        }
 * Licensed to Elasticsearch under one or more contributor  
    protected Writeable.Reader<PersistentTaskResponse> instanceReader() {
                    randomLong(),
                    UUIDs.base64UUID(),
                    PersistentTaskParams.class,
 * SPDX-License-Identifier: Apache-2.0
    @Override
                )
import org.opensearch.common.UUIDs;  
import org.opensearch.test.AbstractWireSerializingTestCase;
        } else {
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
                    new TestPersistentTasksPlugin.TestParams("test"),  
 * GitHub history for details.
            Collections.singletonList(  
 * under the License.  
            return new PersistentTaskResponse((PersistentTask<?>) null);  
    }
        if (randomBoolean()) {
 * You may obtain a copy of the License at  
        return new NamedWriteableRegistry(
                    TestPersistentTasksPlugin.TestParams::new
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.Writeable;
            return new PersistentTaskResponse(
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
                    PersistentTasksCustomMetadata.INITIAL_ASSIGNMENT
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
    }
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
