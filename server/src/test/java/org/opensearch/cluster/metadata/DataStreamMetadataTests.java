 *
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
 * KIND, either express or implied.  See the License for the
public class DataStreamMetadataTests extends AbstractNamedWriteableTestCase<DataStreamMetadata> {  
    }
 * Modifications Copyright OpenSearch Contributors. See
                new NamedWriteableRegistry.Entry(DataStreamMetadata.class, DataStreamMetadata.TYPE, DataStreamMetadata::new)
            )  
 * this file be licensed under the Apache-2.0 license or a
    @Override
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }  
        }
 * specific language governing permissions and limitations
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 */  
            Collections.singletonList(
    @Override
import java.util.Collections;
        return new DataStreamMetadata(dataStreams);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.AbstractNamedWriteableTestCase;
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    }
    @Override
package org.opensearch.cluster.metadata;
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return randomValueOtherThan(instance, this::createTestInstance);
 * Licensed to Elasticsearch under one or more contributor  
        );
        }  
/*  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
import java.io.IOException;
 * not use this file except in compliance with the License.
 */  
 */
    protected DataStreamMetadata mutateInstance(DataStreamMetadata instance) throws IOException {  
    protected Class<DataStreamMetadata> categoryClass() {
        return DataStreamMetadata.class;  
/*
            dataStreams.put(randomAlphaOfLength(5), DataStreamTests.randomInstance());  
import java.util.HashMap;  
        return new NamedWriteableRegistry(  
        if (randomBoolean()) {
    protected DataStreamMetadata createTestInstance() {  
 * compatible open source license.
 *
 * this work for additional information regarding copyright
    }
    @Override
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
        Map<String, DataStream> dataStreams = new HashMap<>();
 *  
 * software distributed under the License is distributed on an
            return new DataStreamMetadata(Collections.emptyMap());
