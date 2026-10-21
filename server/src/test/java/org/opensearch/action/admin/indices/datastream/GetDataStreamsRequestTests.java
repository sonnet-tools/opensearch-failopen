            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
 */
    }
        dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
        assertThat(dataStreams.size(), equalTo(2));
import org.opensearch.core.common.io.stream.Writeable;
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamName));
                searchParameter = parameters;
        assertThat(dataStreams.size(), equalTo(1));
        req = new GetDataStreamAction.Request((String[]) null);
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        );
    }
        final String dataStreamName = "my-data-stream";
            cs,
            () -> GetDataStreamAction.TransportAction.getDataStreams(
        );
        assertThat(e.getMessage(), containsString("no such index [foo]"));
        );
                break;
import static org.hamcrest.Matchers.equalTo;
            List.of(new Tuple<>(dataStreamNames[0], 1), new Tuple<>(dataStreamNames[1], 1)),
            case 2:
                break;
import org.opensearch.test.AbstractWireSerializingTestCase;
        assertThat(dataStreams.get(1).getName(), equalTo(dataStreamNames[0]));
        ClusterState cs = getClusterStateWithDataStreams(List.of(new Tuple<>(dataStreamName, 1)), List.of());
        final String dataStreamName = "my-data-stream";
        ClusterState cs = ClusterState.builder(new ClusterName("_name")).build();
 * software distributed under the License is distributed on an
import static org.opensearch.action.admin.indices.datastream.DeleteDataStreamRequestTests.getClusterStateWithDataStreams;
        return new Request(searchParameter);
        );
        req = new GetDataStreamAction.Request(new String[] { "matches-none*" });
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[1]));
            cs,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            List.of(new Tuple<>(dataStreamNames[0], 1), new Tuple<>(dataStreamNames[1], 1)),
    protected Request createTestInstance() {
/*
                cs,
import org.opensearch.cluster.ClusterState;
            cs,
 */
    }
 * ownership. Elasticsearch licenses this file to you under
                req
import static org.hamcrest.Matchers.containsString;
                for (int k = 0; k < parameters.length; k++) {
        assertThat(dataStreams.size(), equalTo(1));
 */
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
                    parameters[k] = parameters[k] + "*";
 * compatible open source license.
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            IndexNotFoundException.class,
        );
        switch (randomIntBetween(1, 4)) {
        GetDataStreamAction.Request req = new GetDataStreamAction.Request(new String[] { dataStreamNames[0], dataStreamNames[1] });
        assertThat(dataStreams.size(), equalTo(0));
/*
        dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
                req2
        assertThat(dataStreams.size(), equalTo(1));
        final String[] searchParameter;
    @Override
import org.opensearch.common.util.concurrent.ThreadContext;
 *
        return Request::new;
            () -> GetDataStreamAction.TransportAction.getDataStreams(
    public void testGetDataStreamsWithoutWildcards() {
import org.opensearch.cluster.ClusterName;
        );
        GetDataStreamAction.Request req2 = new GetDataStreamAction.Request(new String[] { "foo" });
        GetDataStreamAction.Request req = new GetDataStreamAction.Request(new String[] { dataStreamName });
            IndexNotFoundException.class,
            req
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to
    protected Writeable.Reader<Request> instanceReader() {
package org.opensearch.action.admin.indices.datastream;
            req
import java.util.List;
        List<DataStream> dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[1]));
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
 * this work for additional information regarding copyright
    }
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction.Request;
    public void testGetNonexistentDataStream() {
    }
    public void testGetDataStreamsWithWildcards() {
            cs,
            cs,
 * GitHub history for details.
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[0]));
            cs,
        GetDataStreamAction.Request req = new GetDataStreamAction.Request(new String[] { dataStreamNames[1].substring(0, 5) + "*" });
        );
        GetDataStreamAction.Request req = new GetDataStreamAction.Request(new String[] { dataStreamName });
            )
        req = new GetDataStreamAction.Request(new String[] { "*" });
        assertThat(dataStreams.size(), equalTo(2));
                }
import org.opensearch.cluster.metadata.DataStream;
}
                searchParameter = new String[] { "*" };
 * SPDX-License-Identifier: Apache-2.0
        req = new GetDataStreamAction.Request(new String[] { dataStreamNames[1] });
    }
 *
        final String[] dataStreamNames = { "my-data-stream", "another-data-stream" };
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[1]));
        assertThat(dataStreams.get(1).getName(), equalTo(dataStreamNames[0]));
        assertThat(dataStreams.size(), equalTo(1));
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            default:
 * specific language governing permissions and limitations
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            List.of()
                searchParameter = generateRandomStringArray(3, 8, false, false);
            req
            req
        );
 * KIND, either express or implied.  See the License for the
            )
        );
        IndexNotFoundException e = expectThrows(
        );
            cs,
        List<DataStream> dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
                searchParameter = null;
 * the Apache License, Version 2.0 (the "License"); you may
        );
        );
            req
                String[] parameters = generateRandomStringArray(3, 8, false, false);
            case 3:
        assertThat(dataStreams.get(1).getName(), equalTo(dataStreamNames[0]));
                break;
        }
            req
 * license agreements. See the NOTICE file distributed with
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[1]));
            cs,
    @Override
        dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
 * You may obtain a copy of the License at
                cs,
        assertThat(dataStreams.size(), equalTo(2));
 * not use this file except in compliance with the License.
        ClusterState cs = getClusterStateWithDataStreams(
        req = new GetDataStreamAction.Request(new String[] { dataStreamNames[0] });
        IndexNotFoundException e = expectThrows(
                break;
import org.opensearch.index.IndexNotFoundException;
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            req
            case 1:
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.collect.Tuple;
            req
    public void testGetDataStream() {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
public class GetDataStreamsRequestTests extends AbstractWireSerializingTestCase<Request> {
        dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
 *
/*
            List.of()
        final String[] dataStreamNames = { "my-data-stream", "another-data-stream" };
        assertThat(dataStreams.get(0).getName(), equalTo(dataStreamNames[1]));
 * under the License.
        ClusterState cs = getClusterStateWithDataStreams(
import org.opensearch.common.settings.Settings;
        List<DataStream> dataStreams = GetDataStreamAction.TransportAction.getDataStreams(
        assertThat(e.getMessage(), containsString("no such index [" + dataStreamName + "]"));
