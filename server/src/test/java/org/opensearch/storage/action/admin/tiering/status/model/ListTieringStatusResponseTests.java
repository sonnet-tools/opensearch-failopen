        // Assert
        List<TieringStatus> largeStatusList = new ArrayList<>();  
    public void testSerializationDeserializationEmptyList() throws IOException {  
        assertEquals(statusList, retrievedList);
            status.setSource("hot");  
        // Assert  
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(original.getStatus(), deserialized.getStatus());
        // Assert
        status2.setIndexName("index2");  
            status.setStatus("RUNNING");
        // Assert  
        status1.setStatus("RUNNING");  
 * SPDX-License-Identifier: Apache-2.0
        // Arrange  
 */  
            assertEquals(original.getStartTime(), deserialized.getStartTime());  
        // Arrange  
        StreamInput input = output.bytes().streamInput();  
        assertTrue(deserializedResponse.getTieringStatusList().isEmpty());
import org.opensearch.core.common.io.stream.StreamInput;
        for (int i = 0; i < 1000; i++) {
    }  
        List<TieringStatus> statusList = createDummyTieringStatusList();
        // Arrange
        StreamInput input = output.bytes().streamInput();
    }
        for (int i = 0; i < originalResponse.getTieringStatusList().size(); i++) {  
        StreamInput input = output.bytes().streamInput();
            assertEquals(original.getSource(), deserialized.getSource());
        // Act  
        // Act
        BytesStreamOutput output = new BytesStreamOutput();  
        statusList.add(status2);
    }
            TieringStatus status = new TieringStatus();
        assertEquals("index0", deserializedResponse.getTieringStatusList().get(0).getIndexName());  
 *
        // Arrange
        ListTieringStatusResponse deserializedResponse = new ListTieringStatusResponse(input);
import org.opensearch.test.OpenSearchTestCase;
public class ListTieringStatusResponseTests extends OpenSearchTestCase {  
        ListTieringStatusResponse originalResponse = new ListTieringStatusResponse(statusList);
        originalResponse.writeTo(output);  
        status2.setStartTime(System.currentTimeMillis());
        assertEquals("index999", deserializedResponse.getTieringStatusList().get(999).getIndexName());
        assertEquals(statusList.size(), retrievedList.size());  
        // Act
        originalResponse.writeTo(output);
        List<TieringStatus> retrievedList = response.getTieringStatusList();
        originalResponse.writeTo(output);  
        assertEquals(1000, deserializedResponse.getTieringStatusList().size());
        status2.setTarget("hot");
import java.util.List;
    public void testSerializationWithLargeList() throws IOException {
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
 * compatible open source license.
        status1.setIndexName("index1");
    public void testSerializationDeserialization() throws IOException {
        // Act
        assertEquals(2, response.getTieringStatusList().size());
        List<TieringStatus> statusList = createDummyTieringStatusList();  
        ListTieringStatusResponse originalResponse = new ListTieringStatusResponse(largeStatusList);
        ListTieringStatusResponse response = new ListTieringStatusResponse(statusList);
        status2.setStatus("COMPLETED");
            TieringStatus original = originalResponse.getTieringStatusList().get(i);
        List<TieringStatus> statusList = createDummyTieringStatusList();
        TieringStatus status2 = new TieringStatus();
        assertEquals(originalResponse.getTieringStatusList().size(), deserializedResponse.getTieringStatusList().size());
        }  
    public void testConstructorWithList() {
            largeStatusList.add(status);
        status1.setSource("hot");
    public void testGetTieringStatusList() {
        return statusList;  
}
import java.util.Collections;  
import org.opensearch.common.io.stream.BytesStreamOutput;
import java.util.ArrayList;
        ListTieringStatusResponse response = new ListTieringStatusResponse(statusList);
        assertEquals("index2", response.getTieringStatusList().get(1).getIndexName());
    }
 * The OpenSearch Contributors require contributions made to  
        BytesStreamOutput output = new BytesStreamOutput();
            assertEquals(original.getIndexName(), deserialized.getIndexName());
        ListTieringStatusResponse deserializedResponse = new ListTieringStatusResponse(input);
/*  
        assertNotNull(response.getTieringStatusList());
        assertEquals("index1", response.getTieringStatusList().get(0).getIndexName());  
        status1.setTarget("warm");  
        TieringStatus status1 = new TieringStatus();
        ListTieringStatusResponse originalResponse = new ListTieringStatusResponse(Collections.emptyList());
        BytesStreamOutput output = new BytesStreamOutput();  
            status.setStartTime(System.currentTimeMillis());
            TieringStatus deserialized = deserializedResponse.getTieringStatusList().get(i);
import java.io.IOException;
        status1.setStartTime(System.currentTimeMillis());
        statusList.add(status1);  
    }
            status.setTarget("warm");
        ListTieringStatusResponse deserializedResponse = new ListTieringStatusResponse(input);
        assertNotNull(retrievedList);
    private List<TieringStatus> createDummyTieringStatusList() {
        // Assert
            status.setIndexName("index" + i);  
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusResponse;  
        status2.setSource("warm");  
        List<TieringStatus> statusList = new ArrayList<>();
    }
        // Act
package org.opensearch.storage.action.admin.tiering.status.model;
        }  
        // Arrange
            assertEquals(original.getTarget(), deserialized.getTarget());
