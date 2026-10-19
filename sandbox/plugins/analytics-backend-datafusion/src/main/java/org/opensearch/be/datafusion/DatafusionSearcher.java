    // Deprecated — retained only for tests that bypass AnalyticsSearchService.
            0L,  
    public void close() {
            streamPtr = future.join();  
 * @opensearch.experimental
 * parquet and indexed (index_filter-bearing) plans. The native side classifies the
 *  
 * this file be licensed under the Apache-2.0 license or a
        context.setStreamHandle(new StreamHandle(streamPtr, runtimeHandle));  
                    future.complete(streamPtr);
        // not by the searcher. Do not close it here.  
    /**
        NativeBridge.executeWithContextAsync(sessionCtx, query.getSubstraitBytes(), new ActionListener<>() {  
        CompletableFuture<Long> future = new CompletableFuture<>();
            new ActionListener<>() {
                    future.completeExceptionally(e);  
     * Creates a searcher  
        context.setStreamHandle(new StreamHandle(streamPtr, runtimeHandle));
import org.opensearch.index.engine.exec.EngineSearcher;
            }
    @Override
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                @Override
 * via {@link DatafusionContext#getStreamHandle()}.
 * substrait plan and dispatches internally; Java is oblivious to which path runs.
package org.opensearch.be.datafusion;
                public void onResponse(Long streamPtr) {  
    }
     */
            throw new IllegalStateException("DatafusionQuery must be set before search");
            query.getIndexName(),
    }  
    private final ReaderHandle readerHandle;  
import org.opensearch.be.datafusion.nativelib.ReaderHandle;
            throw convertOrWrap(exception, "Query execution with session context failed");  
    private void searchWithSessionContext(DatafusionContext context, SessionContextHandle sessionCtx) throws IOException {
        }  
import java.util.concurrent.CompletableFuture;
import org.opensearch.common.annotation.ExperimentalApi;
        // closes the Java wrapper) on both success and native-error paths; no explicit close  
    @Override  
/*  
                future.completeExceptionally(exception);
        } catch (Exception e) {
        } catch (Exception exception) {
 */
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
     * in IOException.
        return new IOException(fallbackMessage, exception);
    /**
        } else {  
        }
            throw rte;  
            public void onFailure(Exception exception) {
            query.getContextId(),
}
        SessionContextHandle sessionCtx = context.getSessionContextHandle();  
 * After {@link #search}, the result stream handle is available on the context
    // TODO: Remove searchVanilla once all execution paths go through instruction handlers.  
            }
 */  
 * SPDX-License-Identifier: Apache-2.0
        // paths that never reach this method (e.g. aborted search).
            @Override  
    }
        }  
            throw convertOrWrap(e, "Query execution failed");
        DatafusionQuery query = context.getDatafusionQuery();  
    }
        if (sessionCtx != null) {
 * DataFusion searcher — executes substrait query plans against a native DataFusion reader.
     * already converts native errors via NativeErrorConverter). Unrecognized errors are wrapped  
        long streamPtr;
        this.readerHandle = readerHandle;
            public void onResponse(Long streamPtr) {
     * @param readerHandle the native reader handle
    }
public class DatafusionSearcher implements EngineSearcher<DatafusionContext> {
    }  
import org.opensearch.be.datafusion.nativelib.SessionContextHandle;  
    public void search(DatafusionContext context) throws IOException {
 * <p>
     */
                }
            }  
import org.opensearch.core.action.ActionListener;  
        NativeRuntimeHandle runtimeHandle = context.getNativeRuntime();
        });
        Throwable cause = exception instanceof java.util.concurrent.CompletionException ? exception.getCause() : exception;
        }
        DatafusionQuery query = context.getDatafusionQuery();  
            @Override
        NativeRuntimeHandle runtimeHandle = context.getNativeRuntime();
            runtimeHandle.get(),
            readerHandle.getPointer(),
 * <p>  
@ExperimentalApi  
/**  
     * Returns the type-safe handle to the native reader.  
            streamPtr = future.join();
    public DatafusionSearcher(ReaderHandle readerHandle) {  
        long streamPtr;
            searchVanilla(context);
        // NativeBridge#executeWithContextAsync has already marked the handle consumed (which
        // ReaderHandle lifecycle is owned by DatafusionReader / EngineReaderManager,
        if (cause instanceof RuntimeException rte) {
    /**
        if (query == null) {
        try {  
 * compatible open source license.
    private static IOException convertOrWrap(Exception exception, String fallbackMessage) {  
                @Override
        NativeBridge.executeQueryAsync(  
            query.getSubstraitBytes(),  
     */
     * Unwraps CompletionException and rethrows RuntimeException subtypes directly (the bridge
        return readerHandle;  
    public ReaderHandle getReaderHandle() {
        }
        try {
        CompletableFuture<Long> future = new CompletableFuture<>();
        // is needed here. The owning DatafusionContext#close() closes it as a safety net for
 *
                }
                future.complete(streamPtr);  
            searchWithSessionContext(context, sessionCtx);
                public void onFailure(Exception e) {
    private void searchVanilla(DatafusionContext context) throws IOException {
    }
        );  
import org.opensearch.be.datafusion.nativelib.StreamHandle;
 * A single entry point: {@link NativeBridge#executeQueryAsync} handles both vanilla  
