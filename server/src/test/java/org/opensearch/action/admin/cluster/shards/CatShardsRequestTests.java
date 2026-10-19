        catShardsRequest.setPageParams(
        }
            try (StreamInput in = out.bytes().streamInput()) {
package org.opensearch.action.admin.cluster.shards;
    public void testSerializationWithPageParamsSet() throws Exception {
        catShardsRequest.setIndices(new String[2]);
        Version version = Version.CURRENT;
        CatShardsRequest catShardsRequest = new CatShardsRequest();  
                assertTrue(deserialized.isRequestLimitCheckSupported());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }  
                // assert indices
import org.opensearch.core.common.io.stream.StreamInput;
        Version version = VersionUtils.getPreviousVersion(Version.V_2_18_0);
            }  
                assertFalse(deserialized.isRequestLimitCheckSupported());  
                in.setVersion(version);  
import org.opensearch.common.unit.TimeValue;
        CatShardsRequest catShardsRequest = new CatShardsRequest();
        catShardsRequest.setPageParams(new PageParams(null, null, randomIntBetween(1, 5)));  
                assertEquals(0, deserialized.getIndices().length);
        }
    public void testSerializationWithOlderVersionsParametersNotSerialized() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
                assertFalse(deserialized.isRequestLimitCheckSupported());
        }
 */  
            try (StreamInput in = out.bytes().streamInput()) {
            out.setVersion(version);  
                assertNull(deserialized.getPageParams());
    public void testSerializationWithStringPageParamsNull() throws Exception {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                assertEquals(0, deserialized.getIndices().length);
        catShardsRequest.setPageParams(  
        );
        int numIndices = randomIntBetween(1, 5);
        String[] indices = new String[numIndices];
            }
            catShardsRequest.writeTo(out);
            catShardsRequest.writeTo(out);
                // assert timeout  
                assertArrayEquals(catShardsRequest.getIndices(), deserialized.getIndices());
    public void testSerializationWithDefaultParameters() throws Exception {
                CatShardsRequest deserialized = new CatShardsRequest(in);
        catShardsRequest.setIndices(indices);  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                assertNull(deserialized.getCancelAfterTimeInterval());
                // asserting pageParams of deserialized request
                assertEquals(catShardsRequest.getPageParams(), deserialized.getPageParams());  
        catShardsRequest.setRequestLimitCheckSupported(true);
                in.setVersion(version);
            out.setVersion(version);  
                assertEquals(catShardsRequest.getCancelAfterTimeInterval(), deserialized.getCancelAfterTimeInterval());
            try (StreamInput in = out.bytes().streamInput()) {
        Version version = Version.CURRENT;
        }
public class CatShardsRequestTests extends OpenSearchTestCase {  
 *
                CatShardsRequest deserialized = new CatShardsRequest(in);  
                CatShardsRequest deserialized = new CatShardsRequest(in);
    }
                assertFalse(deserialized.isRequestLimitCheckSupported());
                // asserting pageParams of deserialized request
 * SPDX-License-Identifier: Apache-2.0
        Version version = Version.CURRENT;  
}  
        CatShardsRequest request = new CatShardsRequest();  
                assertNull(deserialized.getPageParams());
                assertNull(deserialized.getCancelAfterTimeInterval());  
            new PageParams(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10), randomIntBetween(1, 5))
import org.opensearch.common.io.stream.BytesStreamOutput;  
            }  
import org.opensearch.test.OpenSearchTestCase;  
                in.setVersion(version);  
        }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.VersionUtils;
            out.setVersion(version);
    }  
        CatShardsRequest catShardsRequest = new CatShardsRequest();
 * compatible open source license.
        );  
import org.opensearch.Version;
            new PageParams(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10), randomIntBetween(1, 5))
                in.setVersion(version);  
                CatShardsRequest deserialized = new CatShardsRequest(in);
        for (int i = 0; i < numIndices; i++) {  
                assertNull(deserialized.getCancelAfterTimeInterval());
        catShardsRequest.setCancelAfterTimeInterval(TimeValue.timeValueMillis(randomIntBetween(1, 5)));
            request.writeTo(out);
            catShardsRequest.writeTo(out);  
            try (StreamInput in = out.bytes().streamInput()) {
/*  
        catShardsRequest.setCancelAfterTimeInterval(TimeValue.timeValueMillis(randomIntBetween(1, 5)));
import org.opensearch.action.pagination.PageParams;
    }
                assertNull(deserialized.getIndices());  
                assertEquals(catShardsRequest.getPageParams(), deserialized.getPageParams());  
            out.setVersion(version);  
            indices[i] = randomAlphaOfLengthBetween(3, 10);
