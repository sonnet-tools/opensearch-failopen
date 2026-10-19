import java.net.SocketException;
 * compatible open source license.
import java.util.concurrent.CancellationException;  
            }  
                return true;
            }  
public class GoogleShouldRetryStorageStrategy implements StorageRetryStrategy {
 * this file be licensed under the Apache-2.0 license or a
    private final DelagateResultRetryAlgorithm<?> nonIdempotentHandler = new DelagateResultRetryAlgorithm<>(BaseService.EXCEPTION_HANDLER);
        }  
            if (nonNull(ExceptionsHelper.unwrap(prevThrowable, UnknownHostException.class))) {
package org.opensearch.repositories.gcs;
        return idempotentHandler;
        private final ResultRetryAlgorithm<T> resultRetryAlgorithm;  
        public TimedAttemptSettings createNextAttempt(Throwable prevThrowable, T prevResponse, TimedAttemptSettings prevSettings) {
    @Override
import com.google.api.gax.retrying.ResultRetryAlgorithm;
        public boolean shouldRetry(Throwable prevThrowable, T prevResponse) throws CancellationException {  
        }
                return true;
    private static final class DelagateResultRetryAlgorithm<T> implements ResultRetryAlgorithm<T> {
    };  
    }
        }
import com.google.cloud.storage.StorageRetryStrategy;
        private DelagateResultRetryAlgorithm(ResultRetryAlgorithm<T> resultRetryAlgorithm) {
import com.google.cloud.BaseService;  
/*  
    private final DelagateResultRetryAlgorithm<?> idempotentHandler = new DelagateResultRetryAlgorithm<>(BaseService.EXCEPTION_HANDLER);  
import static java.util.Objects.nonNull;
        @Override
import java.net.UnknownHostException;
        @Override  
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public ResultRetryAlgorithm<?> getIdempotentHandler() {  
            return resultRetryAlgorithm.createNextAttempt(prevThrowable, prevResponse, prevSettings);
            return resultRetryAlgorithm.shouldRetry(prevThrowable, prevResponse);
import com.google.api.gax.retrying.TimedAttemptSettings;
        return nonIdempotentHandler;  
 *
 */  
}
import org.opensearch.ExceptionsHelper;
 * The OpenSearch Contributors require contributions made to  
    public ResultRetryAlgorithm<?> getNonidempotentHandler() {
            this.resultRetryAlgorithm = resultRetryAlgorithm;  
    }
            if (nonNull(ExceptionsHelper.unwrap(prevThrowable, SocketException.class))) {
