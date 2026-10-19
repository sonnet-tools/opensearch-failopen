}
    private final ExecutorService futureCompletionExecutor;
        return asyncTransferEventLoopGroup;
    private final ExecutorService streamReader;  
        ExecutorService futureCompletionExecutor,
     * @param asyncTransferEventLoopGroup A {@link AsyncTransferEventLoopGroup} which encapsulates the netty {@link io.netty.channel.EventLoopGroup} for async uploads
        ExecutorService streamReader,  
     * @param streamReader An {@link ExecutorService} to read streams for upload
    }  
        return futureCompletionExecutor;  
    ) {
/*  
 * SPDX-License-Identifier: Apache-2.0
        this.streamReader = streamReader;
        return streamReader;
    public AsyncTransferEventLoopGroup getAsyncTransferEventLoopGroup() {  
    }
     * @param futureCompletionExecutor An {@link ExecutorService} to pass to {@link software.amazon.awssdk.services.s3.S3AsyncClient} for future completion  
 * compatible open source license.
    public ExecutorService getStreamReader() {
 * An encapsulation for the {@link AsyncTransferEventLoopGroup}, and the stream reader and future completion executor services
        this.futureCompletionExecutor = futureCompletionExecutor;
 * this file be licensed under the Apache-2.0 license or a
public class AsyncExecutorContainer {  
 *
        this.asyncTransferEventLoopGroup = asyncTransferEventLoopGroup;  
    /**  
     */  
    }  
    private final AsyncTransferEventLoopGroup asyncTransferEventLoopGroup;
    }
 */
/**  
    public AsyncExecutorContainer(
    public ExecutorService getFutureCompletionExecutor() {
 */  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.repositories.s3.async;
import java.util.concurrent.ExecutorService;
     * Construct a new AsyncExecutorBuilder object
     *
        AsyncTransferEventLoopGroup asyncTransferEventLoopGroup
