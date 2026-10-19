                    .setKeepAlive("1m")
 * The OpenSearch Contributors require contributions made to  
    }
            .setIgnoreUnavailable(true)
            )
        assertTrue(request.getIndicesOptions().expandWildcardsOpen());  
                org.opensearch.protobufs.CreatePitRequest.newBuilder()  
            .addIndex("index-1")  
        assertFalse(request.getIndicesOptions().allowNoIndices());  
        CreatePitRequest request = CreatePitRequestProtoUtils.prepareRequest(
        );
import org.opensearch.protobufs.CreatePitRequest.Builder;  
                .build()  
import org.opensearch.protobufs.GlobalParams;
                    .addIndex("index-1")
        CreatePitRequest request = CreatePitRequestProtoUtils.prepareRequest(
            .setAllowNoIndices(false)
    }
        CreatePitRequest request = CreatePitRequestProtoUtils.prepareRequest(requestBuilder.build());
        );  
            .addRouting("route-1")
/*  
                    .build()
        assertFalse(request.getIndicesOptions().ignoreUnavailable());  
        assertFalse(request.shouldAllowPartialPitCreation());
    public void testPrepareRequestRejectsGlobalParams() {
        assertTrue(request.getIndicesOptions().expandWildcardsClosed());  
    public void testPrepareRequestWithBasicFields() {
        CreatePitRequest request = CreatePitRequestProtoUtils.prepareRequest(
 *
import org.opensearch.protobufs.ExpandWildcard;
            .setIgnoreThrottled(true)  
            .setKeepAlive("5m")
                .addExpandWildcards(ExpandWildcard.EXPAND_WILDCARD_OPEN)
            .setPreference("_local")  
        );  
                .addIndex("index-1")  
            .addExpandWildcards(ExpandWildcard.EXPAND_WILDCARD_CLOSED)
            org.opensearch.protobufs.CreatePitRequest.newBuilder().addIndex("index-1").build()
            .addRouting("route-2");
        assertTrue(request.getIndicesOptions().ignoreUnavailable());
 * this file be licensed under the Apache-2.0 license or a
                    .setGlobalParams(GlobalParams.newBuilder().build())  
        assertEquals(TimeValue.timeValueMinutes(1), request.getKeepAlive());  
            UnsupportedOperationException.class,
 */  
            .addIndex("index-2")
import org.opensearch.action.search.CreatePitRequest;
        UnsupportedOperationException exception = expectThrows(  
        Builder requestBuilder = org.opensearch.protobufs.CreatePitRequest.newBuilder()
        assertTrue(request.getIndicesOptions().ignoreThrottled());
            org.opensearch.protobufs.CreatePitRequest.newBuilder().addIndex("index-1").setKeepAlive("1m").build()
    }
 * SPDX-License-Identifier: Apache-2.0
            .addExpandWildcards(ExpandWildcard.EXPAND_WILDCARD_OPEN)
        assertTrue(request.getIndicesOptions().ignoreThrottled());
    public void testPrepareRequestUsesDefaultIndicesOptionsWhenFlagsAreOmitted() {  
import org.opensearch.test.OpenSearchTestCase;  
        assertArrayEquals(new String[] { "index-1", "index-2" }, request.getIndices());  
        assertNull(request.getKeepAlive());
            org.opensearch.protobufs.CreatePitRequest.newBuilder()
    public void testPrepareRequestDefaultsAllowPartialPitCreationToTrue() {  
    public void testPrepareRequestAllowsEmptyKeepAlive() {  
        assertTrue(exception.getMessage().contains("global_params"));
            .setAllowPartialPitCreation(false)  
        assertTrue(request.getIndicesOptions().expandWildcardsOpen());
        );  
        assertTrue(request.shouldAllowPartialPitCreation());
        assertEquals("route-1,route-2", request.getRouting());
                .setKeepAlive("1m")
    }  
import org.opensearch.common.unit.TimeValue;
        assertEquals(TimeValue.timeValueMinutes(5), request.getKeepAlive());
    }  
 * compatible open source license.
package org.opensearch.transport.grpc.proto.request.search;
        assertEquals("_local", request.getPreference());  
public class CreatePitRequestProtoUtilsTests extends OpenSearchTestCase {
            () -> CreatePitRequestProtoUtils.prepareRequest(
        assertTrue(request.getIndicesOptions().allowNoIndices());
}
