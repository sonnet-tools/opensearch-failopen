 * compatible open source license.
        List<Response.DataStreamInfo> dataStreams = new ArrayList<>();
/*
import org.opensearch.cluster.metadata.DataStreamTests;
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
import org.opensearch.test.AbstractWireSerializingTestCase;
            );
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
package org.opensearch.action.admin.indices.datastream;
        int numDataStreams = randomIntBetween(0, 8);  
    }
    }
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
/*
 *  
 *
    protected Response createTestInstance() {
    @Override
import org.opensearch.cluster.health.ClusterHealthStatus;
 * Licensed to Elasticsearch under one or more contributor  
 */
 * Unless required by applicable law or agreed to in writing,
}  
import java.util.ArrayList;  
import java.util.List;
/*  
 */  
        return Response::new;
            dataStreams.add(  
 * under the License.  
 *
    protected Writeable.Reader<Response> instanceReader() {  
        return new Response(dataStreams);
    @Override
import org.opensearch.core.common.io.stream.Writeable;  
 * this file be licensed under the Apache-2.0 license or a
        }  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
                new Response.DataStreamInfo(DataStreamTests.randomInstance(), ClusterHealthStatus.GREEN, randomAlphaOfLengthBetween(2, 10))
        for (int i = 0; i < numDataStreams; i++) {
 */
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
public class GetDataStreamsResponseTests extends AbstractWireSerializingTestCase<Response> {  
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction.Response;  
 * license agreements. See the NOTICE file distributed with
