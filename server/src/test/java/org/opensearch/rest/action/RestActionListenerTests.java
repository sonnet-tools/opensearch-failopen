            @Override  
        // mockito does not support mocking static methods and ctor.
package org.opensearch.rest.action;
import org.opensearch.test.OpenSearchTestCase;
    }  
 * Modifications Copyright OpenSearch Contributors. See  
            public RestStatus status() {
            }  
public class RestActionListenerTests extends OpenSearchTestCase {  
 * The OpenSearch Contributors require contributions made to  
     */
            protected void processResponse(Object o) {
        RestActionListener listener = new RestActionListener(channel) {
        });
 * SPDX-License-Identifier: Apache-2.0
                fail("call to processResponse is not expected");
 * GitHub history for details.
                throw new OpenSearchException("call to status failed");
        listener.onFailure(new OpenSearchException("mock status() call") {
import org.opensearch.OpenSearchException;  
        };
        assertEquals(1, channel.errors().get());
 */
/*
import org.opensearch.core.rest.RestStatus;
        // TODO: it will be better to mock BytesRestResponse() and throw exception from it's ctor, but the current version of  
 *
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, channel.capturedResponse().status());
 */  
import org.opensearch.test.rest.FakeRestChannel;  
}
            }  
     * see https://github.com/opensearch-project/OpenSearch/pull/923
        FakeRestChannel channel = new FakeRestChannel(new FakeRestRequest(), true, 1);
     * Validate that response is sent even when BytesRestResponse can not be constructed from the exception  
    /**
            @Override  
/*  
import org.opensearch.test.rest.FakeRestRequest;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, channel.responses().get());  
    public void testExceptionInByteRestResponse() throws Exception {  
 * compatible open source license.
