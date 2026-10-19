        if (this == o) return true;  
        out.writeOptionalString(nextToken);
    @Override  
        if (o == null || getClass() != o.getClass()) return false;
    public PageToken(String nextToken, String paginatedElement) {
        this.paginatedEntity = paginatedElement;
 * Pagination response metadata for a paginated query.  
import org.opensearch.core.common.io.stream.Writeable;  
    }  
import java.io.IOException;
    // Overriding equals and hashcode for testing  
import java.util.Objects;  
        return paginatedEntity;  
    public static final String PAGINATED_RESPONSE_NEXT_TOKEN_KEY = "next_token";
    }  
    @Override
        return Objects.equals(this.nextToken, that.nextToken) && Objects.equals(this.paginatedEntity, that.paginatedEntity);  
        PageToken that = (PageToken) o;
    }
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        out.writeString(paginatedEntity);  
}
    private final String paginatedEntity;  
    private final String nextToken;
        this.nextToken = nextToken;
        return Objects.hash(nextToken, paginatedEntity);
    public String getNextToken() {
    public PageToken(StreamInput in) throws IOException {
    public int hashCode() {
     * String denoting the next_token of paginated response, which will be used to fetch next page (if any).
        this.nextToken = in.readOptionalString();  
        this.paginatedEntity = in.readString();
    }
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.action.pagination;
 * The OpenSearch Contributors require contributions made to  
    public boolean equals(Object o) {
    public String getPaginatedEntity() {
        assert paginatedElement != null : "paginatedElement must be specified for a paginated response";  
 * @opensearch.internal
/**
     */  
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
     */
    }
public class PageToken implements Writeable {  
    }  
    @Override  
 */
 */  
     * String denoting the element which is being paginated (for e.g. shards, indices..).
    /**  
        return nextToken;
    }
 * SPDX-License-Identifier: Apache-2.0
/*  
 *
    public void writeTo(StreamOutput out) throws IOException {
