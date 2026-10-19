 *
 */  
        for (int i = 0; i < count; i++) {  
            DataStreamAction.addBackingIndex("logs-foo", ".ds-logs-foo-000001"),
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import java.util.Set;
            action.writeTo(out);  
        }
import java.util.ArrayList;  
        ModifyDataStreamsAction.Request request = new ModifyDataStreamsAction.Request(new ArrayList<>());
    public void testActionSerializationRoundTrip() throws IOException {
            DataStreamAction.removeBackingIndex("logs-bar", ".ds-logs-bar-000002")
        assertTrue(request instanceof org.opensearch.action.IndicesRequest);  
                assertThat(deserialized.getActions(), equalTo(original.getActions()));
        assertThat(indices.length, equalTo(3));  
    public void testIndicesExposesEveryDataStreamAndBackingIndex() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;  
            DataStreamAction.removeBackingIndex("logs-foo", ".ds-logs-foo-000002")
                assertThat(deserialized, equalTo(original));  
import java.io.IOException;
        String index = ".ds-" + ds + "-" + String.format(java.util.Locale.ROOT, "%06d", randomIntBetween(1, 1000));
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
        }
        }  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.io.stream.StreamInput;
    }
        List<DataStreamAction> actions = List.of(  
        assertThat(Set.of(request.indices()), equalTo(Set.of("logs-foo", ".ds-logs-foo-000001", "logs-bar", ".ds-logs-bar-000002")));
        List<DataStreamAction> actions = new ArrayList<>();
 * compatible open source license.
package org.opensearch.action.admin.indices.datastream;
public class ModifyDataStreamsRequestTests extends OpenSearchTestCase {  
        String ds = randomAlphaOfLength(6).toLowerCase(java.util.Locale.ROOT);  
    public void testIndicesDeduplicatesRepeatedNames() {
    }  
                ModifyDataStreamsAction.Request deserialized = new ModifyDataStreamsAction.Request(in);
            DataStreamAction.addBackingIndex("logs-foo", ".ds-logs-foo-000001"),
        String[] indices = request.indices();
    }
                return new DataStreamAction(in);
        int count = randomIntBetween(1, 5);
    }  
    }
    public void testRequestIsAnIndicesRequest() {
            try (StreamInput in = out.bytes().streamInput()) {
            }  
        );  
}  
            try (StreamInput in = out.bytes().streamInput()) {
    public void testEmptyRequestFailsValidation() {  
        assertNotNull(request.validate());
            original.writeTo(out);  
/*  
        ModifyDataStreamsAction.Request original = new ModifyDataStreamsAction.Request(actions);  
        List<DataStreamAction> actions = List.of(  
        return randomBoolean() ? DataStreamAction.addBackingIndex(ds, index) : DataStreamAction.removeBackingIndex(ds, index);
import java.util.List;
            actions.add(randomAction());
        assertThat(deserialized, equalTo(original));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
            }
        DataStreamAction deserialized = copy(original);
        ModifyDataStreamsAction.Request request = new ModifyDataStreamsAction.Request(List.of(randomAction()));
        );  
        assertThat(Set.of(indices), equalTo(Set.of("logs-foo", ".ds-logs-foo-000001", ".ds-logs-foo-000002")));
    }  
    public void testRequestSerializationRoundTrip() throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(deserialized.hashCode(), equalTo(original.hashCode()));  
 * SPDX-License-Identifier: Apache-2.0
    private DataStreamAction randomAction() {
        ModifyDataStreamsAction.Request request = new ModifyDataStreamsAction.Request(actions);
        ModifyDataStreamsAction.Request request = new ModifyDataStreamsAction.Request(actions);
    private DataStreamAction copy(DataStreamAction action) throws IOException {
        DataStreamAction original = randomAction();  
        assertNotNull(request.indicesOptions());
