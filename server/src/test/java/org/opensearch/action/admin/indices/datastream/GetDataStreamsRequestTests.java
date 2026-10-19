        dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
        );  
 * license agreements. See the NOTICE file distributed with
        final String[] searchParameter;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
        dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
        List<DataStream> dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
    public void testGetDataStreamsWithWildcards() {
        assertThat(dataStreams.size(), equalTo(0));
 * this work for additional information regarding copyright
        assertThat(dataStreams.size(), equalTo(1));  
        assertThat(e.getMessage(), containsString("no such index [" + dataStreamName + "]"));
        }  
        return new Request(searchParameter);
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[1]));
            )
        req = new GetDataStreamAction.Request((String[]) null);
    }
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
 * The OpenSearch Contributors require contributions made to  
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
            req
        GetDataStreamAction.Request req = new GetDataStreamAction.Request(new String[] { dataStreamNames[0], dataStreamNames[1] });  
                break;
            IndexNotFoundException.class,  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See  
    public void testGetNonexistentDataStream() {
    public void testGetDataStreamsWithoutWildcards() {
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[1]));
        );
        IndexNotFoundException e = expectThrows(
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
                searchParameter = generateRandomStringArray(3, 8, false, false);  
            List.of(new Tuple<>(dataStreamNames[0], 1), new Tuple<>(dataStreamNames[1], 1)),
 */
        assertThat(dataStreams.size(), equalTo(2));  
        );
        GetDataStreamAction.Request req = new GetDataStreamAction.Request(new String[] { dataStreamName });
            case 1:
 * under the License.  
            case 3:  
    }  
        );
import org.opensearch.cluster.metadata.DataStream;  
/*
                searchParameter = new String[] { "*" };
 * software distributed under the License is distributed on an
 */  
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction.Request;  
        GetDataStreamAction.Request req2 = new GetDataStreamAction.Request(new String[] { "foo" });
            default:  
 * specific language governing permissions and limitations
            req
                    parameters[k] = parameters[k] + "*";
                cs,
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[0]));
        assertThat(e.getMessage(), containsString("no such index [foo]"));
import org.opensearch.core.common.io.stream.Writeable;
        req = new GetDataStreamAction.Request(new String[] { "*" });  
                searchParameter = null;
        assertThat(dataStreams.size(), equalTo(1));
        );  
        req = new GetDataStreamAction.Request(new String[] { dataStreamNames[0] });
    public void testGetDataStream() {
import static org.hamcrest.Matchers.equalTo;
        );  
                req
        assertThat(dataStreams.size(), equalTo(2));
        IndexNotFoundException e = expectThrows(
        dataStreams = GetDataStreamAction.TransportAction.getDataStreams(  
                cs,
        );
public class GetDataStreamsRequestTests extends AbstractWireSerializingTestCase<Request> {  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
    @Override
        assertThat(dataStreams.get(1).getName(), equalTo(dataStreamNames[0]));
import org.opensearch.common.util.concurrent.ThreadContext;
    @Override
package org.opensearch.action.admin.indices.datastream;
            req  
                break;
            List.of()  
import org.opensearch.test.AbstractWireSerializingTestCase;
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
        req = new GetDataStreamAction.Request(new String[] { dataStreamNames[1] });
            cs,  
    }
            cs,
 */
 * GitHub history for details.
                for (int k = 0; k < parameters.length; k++) {
 * Unless required by applicable law or agreed to in writing,
    }
 *
                break;
 * compatible open source license.
    }  
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[1]));
                searchParameter = parameters;
        assertThat(dataStreams.get(1).getName(), equalTo(dataStreamNames[0]));  
            case 2:
 * KIND, either express or implied.  See the License for the
        dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
        return Request::new;
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        assertThat(dataStreams.size(), equalTo(2));  
            req
        GetDataStreamAction.Request req = new GetDataStreamAction.Request(new String[] { dataStreamName });
            cs,  
            () -> GetDataStreamAction.TransportAction.getDataStreams(
 *
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            )
 *  
        final String dataStreamName = "my-data-stream";
        List<DataStream> dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
                break;
}
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[1]));
/*  
            cs,
        assertThat(dataStreams.size(), equalTo(1));
            req
            req
        final String[] dataStreamNames = { "my-data-stream", "another-data-stream" };  
        List<DataStream> dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
 * the Apache License, Version 2.0 (the "License"); you may
        final String dataStreamName = "my-data-stream";
        req = new GetDataStreamAction.Request(new String[] { "matches-none*" });
        ClusterState cs = getClusterStateWithDataStreams(
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
            cs,
                req2
    protected Request createTestInstance() {
import org.opensearch.cluster.ClusterName;
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
import org.opensearch.index.IndexNotFoundException;  
        assertThat(dataStreams.get(1).getName(), equalTo(dataStreamNames[0]));
import static org.opensearch.action.admin.indices.datastream.DeleteDataStreamRequestTests.getClusterStateWithDataStreams;
/*
        ClusterState cs = ClusterState.builder(new ClusterName("_name")).build();  
            req
        GetDataStreamAction.Request req = new GetDataStreamAction.Request(new String[] { dataStreamNames[1].substring(0, 5) + "*" });  
            cs,  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.ClusterState;
 * SPDX-License-Identifier: Apache-2.0
        );
            cs,
            List.of()  
            cs,  
            req
        );  
import org.opensearch.common.collect.Tuple;
            List.of(new Tuple<>(dataStreamNames[0], 1), new Tuple<>(dataStreamNames[1], 1)),
    }
        final String[] dataStreamNames = { "my-data-stream", "another-data-stream" };  
        ClusterState cs = getClusterStateWithDataStreams(List.of(new Tuple<>(dataStreamName, 1)), List.of());  
            IndexNotFoundException.class,  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
                }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[1]));
import org.opensearch.common.settings.Settings;  
import static org.hamcrest.Matchers.containsString;  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        ClusterState cs = getClusterStateWithDataStreams(
    protected Writeable.Reader<Request> instanceReader() {  
        );  
        switch (randomIntBetween(1, 4)) {
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamName));
            () -> GetDataStreamAction.TransportAction.getDataStreams(
        assertThat(dataStreams.size(), equalTo(1));
        );
                String[] parameters = generateRandomStringArray(3, 8, false, false);  
 * not use this file except in compliance with the License.
        dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
