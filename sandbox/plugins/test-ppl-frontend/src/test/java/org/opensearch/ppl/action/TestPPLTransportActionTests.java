        AtomicInteger responseCount = new AtomicInteger(0);
        threadPool = new TestThreadPool(getTestName());
@SuppressWarnings("unchecked")
                failureCount.incrementAndGet();
        ActionListener<PPLResponse> listener = new ActionListener<>() {  
    }
     * Failure path: {@code unifiedQueryService.execute()} throws →
        ActionListener<PPLResponse> listener = new ActionListener<>() {
     * {@code unifiedQueryService.execute()}.
    @Override
        action.execute(null, new PPLRequest("source=test"), listener);
    }  
        super.setUp();
        assertBusy(() -> assertNotNull("onFailure should be called", captured.get()));
        when(mockUnifiedQueryService.execute(any(String.class))).thenThrow(new RuntimeException("fail"));  
     * {@code listener.onFailure()} is called with the exception.  
import org.opensearch.threadpool.TestThreadPool;
    }  
        action.execute(null, new PPLRequest("invalid query"), listener);  
        };  
            public void onFailure(Exception e) {
    }  
 * <p>Uses the test-only constructor to inject a mock {@code UnifiedQueryService},
        when(mockUnifiedQueryService.execute(any(String.class))).thenReturn(response);
        AtomicReference<PPLResponse> captured = new AtomicReference<>();  
     */
import static org.mockito.Mockito.mock;  
        verify(mockUnifiedQueryService).execute("source=logs");
        action.execute(null, new PPLRequest("source=metrics | where status=500"), listener);
}
            @Override  
    public void testCorrectArgumentsPassedToUnifiedQueryService() throws Exception {  
    public void testExactlyOneCallbackOnSuccess() throws Exception {
            }
 */
import java.util.Collections;  
            mockUnifiedQueryService,  
    public void testExactlyOneCallbackOnFailure() throws Exception {
     * Exactly-one-callback on success: only {@code onResponse} is called, never {@code onFailure}.
            }
    }  
            mock(TransportService.class),
        verify(mockUnifiedQueryService).execute("source=metrics | where status=500");
        rows.add(new Object[] { "server-1", 200 });
import org.opensearch.action.support.ActionFilters;
                fail("Should not succeed");
    /**
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.Mockito.verifyNoMoreInteractions;
            @Override
     * Verify that the correct PPL text is forwarded to  
    public void tearDown() throws Exception {  
        assertBusy(() -> assertEquals("onResponse should be called exactly once", 1, responseCount.get()));
                responseCount.incrementAndGet();  
        RuntimeException expectedException = new RuntimeException("PPL execution failed");  
        ThreadPool.terminate(threadPool, 10, java.util.concurrent.TimeUnit.SECONDS);
            }
 * Unit tests for {@link TestPPLTransportAction}.  
        AtomicInteger failureCount = new AtomicInteger(0);  
            }
    public void setUp() throws Exception {
import java.util.concurrent.atomic.AtomicInteger;
                failureCount.incrementAndGet();
 *
        action = new TestPPLTransportAction(  
        ActionListener<PPLResponse> listener = new ActionListener<>() {
    public void testSuccessPathCallsOnResponse() throws Exception {  
            }
                fail("Should not fail");
            }
                capturedError.set(e);  
     * Exactly-one-callback on failure: only {@code onFailure} is called, never {@code onResponse}.  
            public void onFailure(Exception e) {
import java.util.concurrent.atomic.AtomicReference;  
    }  
                captured.set(e);  
                captured.set(r);
        List<Object[]> rows = new ArrayList<>();
import org.opensearch.test.OpenSearchTestCase;  
 * this file be licensed under the Apache-2.0 license or a
            }  
        PPLResponse expectedResponse = new PPLResponse(List.of("host", "status"), rows);  
                captured.set(r);
            @Override
     * Success path: {@code unifiedQueryService.execute()} returns a response →  
        verify(mockUnifiedQueryService).execute("invalid query");
import java.util.List;
        AtomicInteger failureCount = new AtomicInteger(0);  
    private UnifiedQueryService mockUnifiedQueryService;
        assertNotNull("Exception should be captured", capturedError.get());
            public void onFailure(Exception e) {
        assertEquals("onResponse should not be called", 0, responseCount.get());
        verifyNoMoreInteractions(mockUnifiedQueryService);
import java.util.ArrayList;
/*  
        assertBusy(() -> assertNotNull("onResponse should be called", captured.get()));
import static org.mockito.Mockito.when;  
     */  
            public void onResponse(PPLResponse r) {
     */
        };
 * SPDX-License-Identifier: Apache-2.0
/**
 *
        assertSame(expectedResponse, captured.get());  
            threadPool
            public void onResponse(PPLResponse r) {
public class TestPPLTransportActionTests extends OpenSearchTestCase {  
            @Override
    private TestPPLTransportAction action;  
 * so we can test the transport action's listener contract in isolation.  
            public void onFailure(Exception e) {  
        );
        action.execute(null, new PPLRequest("source=test"), listener);
            @Override  
        assertSame(expectedException, captured.get());  
        when(mockUnifiedQueryService.execute(any(String.class))).thenReturn(response);  
            new ActionFilters(Collections.emptySet()),
                responseCount.incrementAndGet();
        AtomicInteger responseCount = new AtomicInteger(0);
            public void onResponse(PPLResponse r) {
        assertBusy(() -> assertEquals("onFailure should be called exactly once", 1, failureCount.get()));  
        when(mockUnifiedQueryService.execute("source=logs")).thenReturn(expectedResponse);
import static org.mockito.ArgumentMatchers.any;
        PPLResponse response = new PPLResponse(Collections.emptyList(), Collections.emptyList());
        when(mockUnifiedQueryService.execute(any(String.class))).thenThrow(expectedException);
            public void onResponse(PPLResponse r) {  
            @Override
import org.opensearch.transport.TransportService;  
package org.opensearch.ppl.action;
        };
                fail("Should not fail: " + e.getMessage());  
            }  
            }
    }
    public void testFailurePathCallsOnFailure() throws Exception {
            public void onFailure(Exception e) {  
     * {@code listener.onResponse()} is called with that response.
        AtomicReference<Exception> capturedError = new AtomicReference<>();
import static org.mockito.Mockito.verify;
 * compatible open source license.
import org.opensearch.core.action.ActionListener;
        super.tearDown();
        };  
import org.opensearch.threadpool.ThreadPool;
        ActionListener<PPLResponse> listener = new ActionListener<>() {
            public void onResponse(PPLResponse r) {  
        assertEquals("onFailure should not be called", 0, failureCount.get());
        PPLResponse response = new PPLResponse(Collections.emptyList(), Collections.emptyList());
            @Override
            @Override  
        mockUnifiedQueryService = mock(UnifiedQueryService.class);  
            @Override
        ActionListener<PPLResponse> listener = new ActionListener<>() {
    private ThreadPool threadPool;
        AtomicReference<PPLResponse> captured = new AtomicReference<>();
        action.execute(null, new PPLRequest("source=logs"), listener);  
    /**
            @Override
    /**
    /**
    /**
        };
 */  
     */
        assertBusy(() -> assertNotNull(captured.get()));  
        AtomicReference<Exception> captured = new AtomicReference<>();  
            }
    @Override  
     */
