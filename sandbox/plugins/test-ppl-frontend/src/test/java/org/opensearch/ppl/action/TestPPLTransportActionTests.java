    /**
}
        when(mockUnifiedQueryService.execute(any(String.class))).thenThrow(expectedException);
        assertNotNull("Exception should be captured", capturedError.get());
        AtomicReference<Exception> capturedError = new AtomicReference<>();
        AtomicInteger failureCount = new AtomicInteger(0);
    /**
    private ThreadPool threadPool;
            }
        PPLResponse expectedResponse = new PPLResponse(List.of("host", "status"), rows);
            mockUnifiedQueryService,
        ActionListener<PPLResponse> listener = new ActionListener<>() {
     * {@code listener.onResponse()} is called with that response.
        action.execute(null, new PPLRequest("source=metrics | where status=500"), listener);
                captured.set(r);
    /**
            public void onFailure(Exception e) {
        assertSame(expectedResponse, captured.get());
    }
            }
            public void onResponse(PPLResponse r) {
            threadPool
        };
        verify(mockUnifiedQueryService).execute("source=metrics | where status=500");
     * Exactly-one-callback on failure: only {@code onFailure} is called, never {@code onResponse}.
        rows.add(new Object[] { "server-1", 200 });
        AtomicInteger responseCount = new AtomicInteger(0);
            @Override
import static org.mockito.ArgumentMatchers.any;
            }
     * Failure path: {@code unifiedQueryService.execute()} throws →
import org.opensearch.test.OpenSearchTestCase;
 * Unit tests for {@link TestPPLTransportAction}.
 *
import java.util.ArrayList;
        PPLResponse response = new PPLResponse(Collections.emptyList(), Collections.emptyList());
    public void testSuccessPathCallsOnResponse() throws Exception {
        action.execute(null, new PPLRequest("source=test"), listener);
        verifyNoMoreInteractions(mockUnifiedQueryService);
        );
                responseCount.incrementAndGet();
import java.util.Collections;
     * {@code listener.onFailure()} is called with the exception.
    public void testFailurePathCallsOnFailure() throws Exception {
        when(mockUnifiedQueryService.execute(any(String.class))).thenReturn(response);
        AtomicInteger responseCount = new AtomicInteger(0);
            @Override
package org.opensearch.ppl.action;
import static org.mockito.Mockito.verify;
        ActionListener<PPLResponse> listener = new ActionListener<>() {
        AtomicInteger failureCount = new AtomicInteger(0);
    public void testExactlyOneCallbackOnFailure() throws Exception {
    }
                failureCount.incrementAndGet();
     */
    }
            public void onResponse(PPLResponse r) {
        action.execute(null, new PPLRequest("source=test"), listener);
     * Success path: {@code unifiedQueryService.execute()} returns a response →
            @Override
import static org.mockito.Mockito.mock;
        super.tearDown();
                capturedError.set(e);
            public void onResponse(PPLResponse r) {
        };
        action = new TestPPLTransportAction(
        RuntimeException expectedException = new RuntimeException("PPL execution failed");
    @Override
        AtomicReference<Exception> captured = new AtomicReference<>();
    public void setUp() throws Exception {
            @Override
                failureCount.incrementAndGet();
import java.util.concurrent.atomic.AtomicInteger;
    }
        };
 */
        threadPool = new TestThreadPool(getTestName());
        action.execute(null, new PPLRequest("source=logs"), listener);
        action.execute(null, new PPLRequest("invalid query"), listener);
                captured.set(e);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.action.ActionListener;
import org.opensearch.transport.TransportService;
                fail("Should not fail");
            @Override
 * this file be licensed under the Apache-2.0 license or a
        AtomicReference<PPLResponse> captured = new AtomicReference<>();
        assertEquals("onFailure should not be called", 0, failureCount.get());
        when(mockUnifiedQueryService.execute(any(String.class))).thenReturn(response);
/**
 * so we can test the transport action's listener contract in isolation.
     * Verify that the correct PPL text is forwarded to
    }
            @Override
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.opensearch.threadpool.TestThreadPool;
        ActionListener<PPLResponse> listener = new ActionListener<>() {
    public void testExactlyOneCallbackOnSuccess() throws Exception {
                captured.set(r);
    public void tearDown() throws Exception {
        AtomicReference<PPLResponse> captured = new AtomicReference<>();
/*
            @Override
            @Override
public class TestPPLTransportActionTests extends OpenSearchTestCase {
        PPLResponse response = new PPLResponse(Collections.emptyList(), Collections.emptyList());
     * {@code unifiedQueryService.execute()}.
        List<Object[]> rows = new ArrayList<>();
     */
        };
 * SPDX-License-Identifier: Apache-2.0
            public void onResponse(PPLResponse r) {
            mock(TransportService.class),
        super.setUp();
    public void testCorrectArgumentsPassedToUnifiedQueryService() throws Exception {
            public void onFailure(Exception e) {
 * compatible open source license.
import java.util.concurrent.atomic.AtomicReference;
        assertSame(expectedException, captured.get());
import static org.mockito.Mockito.when;
            public void onFailure(Exception e) {
            }
        assertBusy(() -> assertNotNull("onFailure should be called", captured.get()));
            public void onFailure(Exception e) {
    /**
        ActionListener<PPLResponse> listener = new ActionListener<>() {
        assertBusy(() -> assertEquals("onResponse should be called exactly once", 1, responseCount.get()));
            public void onResponse(PPLResponse r) {
            new ActionFilters(Collections.emptySet()),
    }
     * Exactly-one-callback on success: only {@code onResponse} is called, never {@code onFailure}.
        ThreadPool.terminate(threadPool, 10, java.util.concurrent.TimeUnit.SECONDS);
        mockUnifiedQueryService = mock(UnifiedQueryService.class);
     */
            @Override
                responseCount.incrementAndGet();
    private TestPPLTransportAction action;
        assertBusy(() -> assertNotNull("onResponse should be called", captured.get()));
import org.opensearch.threadpool.ThreadPool;
        when(mockUnifiedQueryService.execute("source=logs")).thenReturn(expectedResponse);
    @Override
    /**
 *
import org.opensearch.action.support.ActionFilters;
        assertBusy(() -> assertEquals("onFailure should be called exactly once", 1, failureCount.get()));
@SuppressWarnings("unchecked")
                fail("Should not succeed");
 */
     */
            }
        assertEquals("onResponse should not be called", 0, responseCount.get());
            }
                fail("Should not fail: " + e.getMessage());
        when(mockUnifiedQueryService.execute(any(String.class))).thenThrow(new RuntimeException("fail"));
            public void onFailure(Exception e) {
            }
    private UnifiedQueryService mockUnifiedQueryService;
            }
        verify(mockUnifiedQueryService).execute("invalid query");
        assertBusy(() -> assertNotNull(captured.get()));
            }
    }
        };
 * <p>Uses the test-only constructor to inject a mock {@code UnifiedQueryService},
        ActionListener<PPLResponse> listener = new ActionListener<>() {
            @Override
            }
import java.util.List;
     */
        verify(mockUnifiedQueryService).execute("source=logs");
