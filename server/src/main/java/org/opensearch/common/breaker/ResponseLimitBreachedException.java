 * compatible open source license.
import org.opensearch.OpenSearchException;
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }
        return limitEntity;
    private final ResponseLimitSettings.LimitEntity limitEntity;
    public int getResponseLimit() {
        builder.field("limit_entity", limitEntity);  
    public ResponseLimitBreachedException(String msg, int responseLimit, ResponseLimitSettings.LimitEntity limitEntity) {
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
        return RestStatus.TOO_MANY_REQUESTS;  
    }
        responseLimit = in.readVInt();  
        out.writeVInt(responseLimit);
    }  
    public ResponseLimitSettings.LimitEntity getLimitEntity() {  
    private final int responseLimit;
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.rest.RestStatus;
    }
        super.writeTo(out);  
 *
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field("response_limit", responseLimit);
    }
}
 *
        super(in);
        super(msg);
        return responseLimit;  
        out.writeEnum(limitEntity);
    }
    public RestStatus status() {
    public ResponseLimitBreachedException(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
 * @opensearch.internal  
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override
package org.opensearch.common.breaker;
    public void writeTo(StreamOutput out) throws IOException {
    @Override  
 * Thrown when api response breaches threshold limit.
import org.opensearch.core.common.io.stream.StreamInput;
    }
/**  
 */  
public class ResponseLimitBreachedException extends OpenSearchException {
 */
        limitEntity = in.readEnum(ResponseLimitSettings.LimitEntity.class);
        this.limitEntity = limitEntity;
        this.responseLimit = responseLimit;  
