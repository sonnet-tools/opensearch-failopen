        return size;
    // Overriding equals and hashcode for tests  
    public static final String PARAM_SIZE = "size";  
    }  
public class PageParams implements Writeable {
        return sort;  
/**  
    public String getRequestedToken() {  
    }
        PageParams that = (PageParams) o;
        this.requestedTokenStr = requestedToken;  
package org.opensearch.action.pagination;
    public boolean equals(Object o) {
    public static final String PARAM_DESC_SORT_VALUE = "desc";
    public static final String PARAM_SORT = "sort";
    private final int size;  
    public static final String PARAM_NEXT_TOKEN = "next_token";
        this.requestedTokenStr = in.readOptionalString();  
            && Objects.equals(this.requestedTokenStr, that.requestedTokenStr)
    public String getSort() {
 */  
    private final String sort;
        if (o == null || getClass() != o.getClass()) return false;
/*  
import java.io.IOException;  
        this.sort = sort;
        return this.size == that.size  
    @Override
    private final String requestedTokenStr;
import org.opensearch.core.common.io.stream.StreamOutput;  
 * SPDX-License-Identifier: Apache-2.0
    }  
    public int getSize() {
    public int hashCode() {  
 *
    public PageParams(StreamInput in) throws IOException {
    }
    public void writeTo(StreamOutput out) throws IOException {  
 * Class specific to paginated queries, which will contain common query params required by a paginated API.
 *
            && Objects.equals(this.sort, that.sort);
}  
        this.size = size;
        this.size = in.readInt();
    public static final String PARAM_ASC_SORT_VALUE = "asc";
        this.sort = in.readOptionalString();
    @Override
import org.opensearch.core.common.io.stream.Writeable;
 * compatible open source license.
    @Override
        return Objects.hash(requestedTokenStr, sort, size);
import org.opensearch.common.annotation.PublicApi;
    }  
    }  
    public PageParams(String requestedToken, String sort, int size) {
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Objects;
        if (this == o) return true;  
    }
    }
        out.writeOptionalString(sort);
 * The OpenSearch Contributors require contributions made to  
        out.writeInt(size);  
@PublicApi(since = "2.18.0")
        out.writeOptionalString(requestedTokenStr);
        return requestedTokenStr;
 */  
