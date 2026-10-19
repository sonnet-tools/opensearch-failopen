        PutIndexFieldDomainsRequest copy = new PutIndexFieldDomainsRequest(request.targetIndex());
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.index.fielddomain.FieldDomain;
        int domainCount = randomIntBetween(1, 3);  
        mutators.add(  
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(  
        mutators.add(() -> mutation.timeout(randomValueOtherThan(instance.timeout(), timeoutSupplier)));  
import java.util.ArrayList;
/**
 * SPDX-License-Identifier: Apache-2.0
 */
    @Override  
            new Index("logs-" + randomAlphaOfLengthBetween(4, 8), randomAlphaOfLengthBetween(8, 16))
        );  
import org.opensearch.index.fielddomain.IndexFieldDomainMetadata;  
import java.util.function.Supplier;  
    }  
        mutators.add(  
        return mutation;
            )
}  
        return randomRequest();
/*  
    }
import org.opensearch.common.unit.TimeValue;
 *
 * compatible open source license.
    }
import java.io.IOException;  
        List<FieldDomain> domains = new ArrayList<>(domainCount);
            domains.add(new DateRangeFieldDomain("field." + i, min, max, randomBoolean(), "test"));
            () -> mutation.targetIndex(new Index(instance.targetIndex().getName() + "-mutated", instance.targetIndex().getUUID()))
                new DateRangeFieldDomain("mutated." + randomAlphaOfLengthBetween(4, 8), 10_000L, 20_000L, true, "test")
        return PutIndexFieldDomainsRequest::new;
    @Override
        return domains;
        );
            long min = randomLongBetween(0L, 1_000_000L);  
 */  
        );
import java.util.List;
    }
        request.timeout(randomPositiveTimeValue());
            long max = randomLongBetween(min, min + 1_000_000L);
        copy.clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
    private static List<FieldDomain> randomDomains() {
 * this file be licensed under the Apache-2.0 license or a
        request.fieldDomains(randomDomains());  
 * Wire serialization and equality tests for {@link PutIndexFieldDomainsRequest}.  
        Supplier<TimeValue> timeoutSupplier = () -> TimeValue.parseTimeValue(randomTimeValue(), "field_domain_test");
    protected PutIndexFieldDomainsRequest createTestInstance() {
        mutators.add(
        copy.timeout(request.timeout());  
            () -> mutation.fieldDomain(  
    private static PutIndexFieldDomainsRequest copyRequest(PutIndexFieldDomainsRequest request) {  
import org.opensearch.core.index.Index;  
public class PutIndexFieldDomainsRequestSerializationTests extends AbstractWireSerializingTestCase<PutIndexFieldDomainsRequest> {
        PutIndexFieldDomainsRequest mutation = copyRequest(instance);  
package org.opensearch.action.admin.indices.fielddomain;
        copy.fieldDomains(IndexFieldDomainMetadata.getInstance().validateAndParseCustomData(request.fieldDomainCustomData()));
    private static PutIndexFieldDomainsRequest randomRequest() {
        }  
        request.clusterManagerNodeTimeout(randomPositiveTimeValue());
 * The OpenSearch Contributors require contributions made to  
    protected Writeable.Reader<PutIndexFieldDomainsRequest> instanceReader() {  
        return copy;
        randomFrom(mutators).run();
import org.opensearch.test.AbstractWireSerializingTestCase;
        for (int i = 0; i < domainCount; i++) {
    protected PutIndexFieldDomainsRequest mutateInstance(PutIndexFieldDomainsRequest instance) throws IOException {
        List<Runnable> mutators = new ArrayList<>();
    }  
            () -> mutation.targetIndex(new Index(instance.targetIndex().getName(), instance.targetIndex().getUUID() + "-mutated"))
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
        return request;  
    }  
    @Override
        mutators.add(() -> mutation.clusterManagerNodeTimeout(randomValueOtherThan(instance.clusterManagerNodeTimeout(), timeoutSupplier)));
        );
