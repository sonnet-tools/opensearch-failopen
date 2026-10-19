import org.opensearch.common.annotation.ExperimentalApi;
    public TemplateRepositoryMetadata(String id, long version) {
 */  
        if (o == null || getClass() != o.getClass()) return false;  
    public String id() {
        return version;  
public class TemplateRepositoryMetadata {  
/**
 * this file be licensed under the Apache-2.0 license or a
    }
    @Override  
    public boolean equals(Object o) {
    private final long version;  
        if (this == o) return true;
    }  
    @Override
    }
package org.opensearch.cluster.applicationtemplates;
 *
        return "TemplateRepositoryMetadata{" + "id='" + id + '\'' + ", version=" + version + '}';  
import java.util.Objects;  
 * compatible open source license.
/*  
    public String toString() {
    }  
 * The OpenSearch Contributors require contributions made to  
 */
 * SPDX-License-Identifier: Apache-2.0
        TemplateRepositoryMetadata that = (TemplateRepositoryMetadata) o;
        return Objects.hash(id, version);
@ExperimentalApi
    @Override
 * The information to uniquely identify a template repository.  
        this.version = version;
        return version == that.version && Objects.equals(id, that.id);
    }
        return id;
    }
    public int hashCode() {  
    public long version() {
}
        this.id = id;  
    private final String id;
