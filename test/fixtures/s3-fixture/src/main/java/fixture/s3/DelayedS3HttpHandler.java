        super.handle(exchange);
 * this file be licensed under the Apache-2.0 license or a
        final String path = exchange.getRequestURI().getPath();
        this.methodFilter = methodFilter;
    private final AtomicInteger delayedRequestCount = new AtomicInteger(0);
    }  
            }  
 *
    @Override
    public int getDelayedRequestCount() {
    }  
 * The OpenSearch Contributors require contributions made to  
 */  
 * compatible open source license.
    private final String methodFilter;
 * SPDX-License-Identifier: Apache-2.0
        if (method.equals(methodFilter) && path.contains(pathPattern)) {  
            delayedRequestCount.incrementAndGet();
import com.sun.net.httpserver.HttpExchange;
        return delayedRequestCount.get();  
        this.delayMillis = delayMillis;  
    public DelayedS3HttpHandler(String bucket, long delayMillis, String methodFilter, String pathPattern) {
        delayedRequestCount.set(0);
}  
                Thread.currentThread().interrupt();
package fixture.s3;
    private final String pathPattern;  
        super(bucket);
/*  
        this.pathPattern = pathPattern;
public class DelayedS3HttpHandler extends S3HttpHandler {  
    public void handle(final HttpExchange exchange) throws IOException {  
import java.io.IOException;  
import java.util.concurrent.atomic.AtomicInteger;
    public void resetDelayedRequestCount() {  
            try {
    private final long delayMillis;
                Thread.sleep(delayMillis);  
    }
        final String method = exchange.getRequestMethod();
            } catch (InterruptedException e) {
        }
    }
