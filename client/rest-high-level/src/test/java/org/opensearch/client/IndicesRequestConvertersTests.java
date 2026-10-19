        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        Map<String, String> expectedParams = new HashMap<>();
        endpoint.add("_refresh");
                MediaTypeRegistry.JSON
        AnalyzeRequest analyzeRequest = AnalyzeRequest.withGlobalAnalyzer("test_analyzer", "more text");
        }
        );
        }
            clearIndicesCacheRequest.fieldDataCache(OpenSearchTestCase.randomBoolean());
            );
        Assert.assertEquals("/" + String.join(",", indices), request.getEndpoint());
            }
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        Request request = IndicesRequestConverters.flush(flushRequest);
                IllegalArgumentException.class,
        }
            flushRequest.indices(indices);
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
        String expectedEndpoint = "/"
        if (OpenSearchTestCase.randomBoolean()) {
        RequestConvertersTests.setRandomClusterManagerTimeout(getMappingRequest, expectedParams);
import static org.opensearch.index.RandomCreateIndexGenerator.randomIndexSettings;
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
    public void testDeleteIndexEmptyIndices() {
        Request request = IndicesRequestConverters.getMappings(getMappingRequest);
        Request request = IndicesRequestConverters.getIndex(getIndexRequest);
        Assert.assertThat(request.getEndpoint(), equalTo("/_template/" + names.get(putTemplateRequest.name())));
                expectedParams.put("preserve_existing", "true");
        PutMappingRequest putMappingRequest = new PutMappingRequest(indices);
        Map<String, String> names = new HashMap<>();
        if (Strings.hasLength(index)) {
        resizeTest(ResizeType.CLONE, IndicesRequestConverters::clone);
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indices);
        RequestConvertersTests.setRandomWaitForActiveShards(openIndexRequest::waitForActiveShards, expectedParams);
import java.util.HashMap;
        String[] indices = RequestConvertersTests.randomIndicesNames(1, 5);
        Assert.assertNotNull(validationException);
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
    public void testGetSettings() throws IOException {
            refreshRequest.indices(indices);
 * compatible open source license.
import java.util.StringJoiner;
        }
 * this work for additional information regarding copyright
            getSettingsRequest.names(names);
            endpoint.add(index);
    }
import static java.util.Collections.emptyList;
                expectedParams.put("include_defaults", Boolean.toString(true));
        expectedParams.put("all_shards", Boolean.toString(validateQueryRequest.allShards()));
        Assert.assertThat(request.getEndpoint(), equalTo("/_template/" + encodes.get(deleteTemplateRequest.name())));
            clearIndicesCacheRequest.indices(indices);
        expectedParams.put("wait_if_ongoing", Boolean.toString(flushRequest.waitIfOngoing()));
    private void resizeTest(ResizeType resizeType, CheckedFunction<ResizeRequest, Request, IOException> function) throws IOException {
            getSettingsRequest::indicesOptions,
        Request request = IndicesRequestConverters.analyze(indexAnalyzeRequest);
        ClearIndicesCacheRequest clearIndicesCacheRequest;
        Assert.assertNull(request.getEntity());
        }
import org.opensearch.client.indices.PutMappingRequest;
        if (OpenSearchTestCase.randomBoolean()) {
        if (OpenSearchTestCase.randomBoolean()) {
        Assert.assertThat(request.getMethod(), equalTo(HttpDelete.METHOD_NAME));
                Settings.builder().put("setting-" + OpenSearchTestCase.randomInt(), OpenSearchTestCase.randomTimeValue())
        String[] indices = RequestConvertersTests.randomIndicesNames(1, 5);
            clearIndicesCacheRequest.requestCache(OpenSearchTestCase.randomBoolean());
        if (rolloverRequest.getNewIndexName() == null) {
        {
        }
            getMappingRequest::indicesOptions,
            expectedParams
        IndicesAliasesRequest indicesAliasesRequest = new IndicesAliasesRequest();
import java.util.Arrays;
import org.opensearch.action.admin.indices.alias.Alias;
        }
    public void testUpdateAliases() throws IOException {
            expectedParams
                request.getEndpoint()
        Assert.assertEquals(HttpPut.METHOD_NAME, request.getMethod());
            Assert.assertEquals("/" + rolloverRequest.getAlias() + "/_rollover", request.getEndpoint());
            expectedEndpoint.add(String.join(",", indices));
    }
import org.opensearch.client.indices.DeleteAliasRequest;
        String index = String.join(",", indices);
        resizeTest(ResizeType.SHRINK, IndicesRequestConverters::shrink);
        Request request = IndicesRequestConverters.deleteIndex(deleteIndexRequest);
        if (Strings.hasLength(index)) {
 * software distributed under the License is distributed on an
        String[] indicesUnderTest = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
    public void testPutTemplateRequest() throws Exception {
    }
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 2);
    }
                int count = randomIntBetween(0, 2);
        Assert.assertThat(HttpGet.METHOD_NAME, equalTo(request.getMethod()));
        final Request request = IndicesRequestConverters.templatesExist(indexTemplatesExistRequest);
        );
            }
        if (false == CollectionUtils.isEmpty(indices)) {
        LuceneTestCase.expectThrows(IllegalArgumentException.class, () -> IndicesRequestConverters.indicesExist(new GetIndexRequest()));
            if (rolloverRequest.isDryRun()) {
    }
        }
    public void testIndexPutSettings() throws IOException {
            if (CollectionUtils.isEmpty(names) == false) {
        if (OpenSearchTestCase.randomBoolean()) {
        resizeTest(ResizeType.SPLIT, IndicesRequestConverters::split);
            deleteIndexRequest::indicesOptions,
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : Strings.EMPTY_ARRAY;
        expectedParams.put("fielddata", Boolean.toString(clearIndicesCacheRequest.fieldDataCache()));
    public void testOpenIndex() {
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest((String[]) null);
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        RequestConvertersTests.setRandomClusterManagerTimeout(closeIndexRequest, expectedParams);
        Map<String, String> expectedParams = new HashMap<>();
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
        Assert.assertThat(request.getEntity(), nullValue());
        if (CollectionUtils.isEmpty(indicesUnderTest) == false) {
        expectThrows(NullPointerException.class, () -> new IndexTemplatesExistRequest((String[]) null));
        Assert.assertThat(request.getEntity(), nullValue());
        }
        StringJoiner expectedEndpoint = new StringJoiner("/", "/", "");
            forceMergeRequest.maxNumSegments(OpenSearchTestCase.randomInt());
        );
        expectThrows(IllegalArgumentException.class, () -> new GetIndexTemplatesRequest(singletonList(randomBoolean() ? "" : null)));
        }
        GetIndexTemplatesRequest getTemplatesRequest = new GetIndexTemplatesRequest(names);
    }
            }
            endpoint.add(String.join(",", indices));
        encodes.put("foo^bar", "foo%5Ebar");
        Request request = IndicesRequestConverters.openIndex(openIndexRequest);
    }
import org.opensearch.core.common.Strings;
        if (OpenSearchTestCase.randomBoolean()) {
        Request request = IndicesRequestConverters.getAlias(getAliasesRequest);
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
            validateQueryRequest::indicesOptions,
            if (updateSettingsRequest.isPreserveExisting()) {
        expectThrows(IllegalArgumentException.class, () -> new IndexTemplatesExistRequest(singletonList(randomBoolean() ? "" : null)));
import org.apache.hc.client5.http.classic.methods.HttpHead;
        } else {
            aliases = RequestConvertersTests.randomIndicesNames(1, 5);
        Assert.assertThat(request.getEntity(), nullValue());
    public void testCreateIndex() throws IOException {
        }
        Assert.assertThat(request.getEntity(), nullValue());
            for (int i = 0; i < fields.length; i++) {
            getSettingsRequest::indicesOptions,
        GetDataStreamRequest getDataStreamRequest = new GetDataStreamRequest(name);
        String[] indices = Strings.EMPTY_ARRAY;
            Assert.assertEquals("existsAlias requires at least an alias or an index", iae.getMessage());
        StringJoiner endpoint = new StringJoiner("/", "/", "");
            Assert.assertEquals("existsAlias requires at least an alias or an index", iae.getMessage());
        if (OpenSearchTestCase.randomBoolean()) {
        Assert.assertThat(request.getEntity(), nullValue());
        endpoint.add("_flush");
        RequestConvertersTests.assertToXContentBody(putMappingRequest, request.getEntity());
import org.opensearch.action.admin.indices.flush.FlushRequest;
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        getAliasesRequest.indices(indices);
        } else {
        RequestConvertersTests.setRandomClusterManagerTimeout(getTemplatesRequest::setClusterManagerNodeTimeout, expectedParams);
import org.apache.lucene.tests.util.LuceneTestCase;
    }
        RequestConvertersTests.setRandomTimeout(updateSettingsRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        RequestConvertersTests.setRandomClusterManagerTimeout(deleteTemplateRequest, expectedParams);
    }
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        );
        expectedEndpoint.add("_alias");
        Map<String, String> expectedParams = new HashMap<>();
        Map<String, String> expectedParams = new HashMap<>();
        expectedParams.put("explain", Boolean.toString(validateQueryRequest.explain()));
        expectThrows(IllegalArgumentException.class, () -> new GetIndexTemplatesRequest(new String[] { (randomBoolean() ? "" : null) }));
            getFieldMappingsRequest::indicesOptions,
            forceMergeRequest = new ForceMergeRequest(indices);
    public void testDeleteIndex() {
        String name = randomAlphaOfLength(10);
            endpoint.add(index);
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
        Assert.assertEquals(expectedParams, request.getParameters());
        assertThat(indexTemplatesExistRequest.names(), equalTo(names));
        RequestConvertersTests.setRandomIndicesOptions(getIndexRequest::indicesOptions, getIndexRequest::indicesOptions, expectedParams);
        Assert.assertEquals(expectedEndpoint, request.getEndpoint());
import org.opensearch.action.admin.indices.shrink.ResizeType;
        if (hasIndices) {
        FlushRequest flushRequest;
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        Request request = IndicesRequestConverters.indexPutSettings(updateSettingsRequest);
                    + OpenSearchTestCase.randomInt()
        StringJoiner endpoint = new StringJoiner("/", "/", "");
    }
        if (resizeType == ResizeType.SPLIT) {
            rolloverRequest.getCreateIndexRequest().settings(org.opensearch.index.RandomCreateIndexGenerator.randomIndexSettings());
        String name = randomAlphaOfLength(10);
        Map<String, String> expectedParams = new HashMap<>();
        Assert.assertEquals("/_data_stream/" + name, request.getEndpoint());
        {
        }
                }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new CreateIndexRequest(null));
        }
        if (indices != null && indices.length > 0) {
        Assert.assertEquals(expectedParams, request.getParameters());
        if (OpenSearchTestCase.randomBoolean()) {
            equalTo("/_template/" + names.stream().map(encodes::get).collect(Collectors.joining(",")))
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(indices);
        if (indices != null && indices.length > 0) {
            expectedParams.put("create", Boolean.TRUE.toString());
        RequestConvertersTests.setRandomIndicesOptions(openIndexRequest::indicesOptions, openIndexRequest::indicesOptions, expectedParams);
 * Unless required by applicable law or agreed to in writing,
        Assert.assertNotNull(validationException);
        getAliasesRequest.aliases(aliases);
        endpoint.add("_mapping");
        Assert.assertThat(request.getEntity(), nullValue());
 * this file be licensed under the Apache-2.0 license or a
        Assert.assertThat(request.getEntity(), nullValue());
            forceMergeRequest.flush(OpenSearchTestCase.randomBoolean());
        RequestConvertersTests.assertToXContentBody(indexAnalyzeRequest, request.getEntity());
        Request request = IndicesRequestConverters.deleteTemplate(deleteTemplateRequest);
            if (OpenSearchTestCase.randomBoolean()) {
        } else if (randomBoolean()) {
            expectedParams
        RequestConvertersTests.setRandomIndicesOptions(
        } else if (randomBoolean()) {
            refreshRequest = new RefreshRequest(indices);
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        RequestConvertersTests.setRandomTimeout(openIndexRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        Assert.assertEquals("/" + createIndexRequest.index(), request.getEndpoint());
        Assert.assertNull(request.getEntity());
    public void testValidateQuery() throws Exception {
            OpenSearchTestCase.randomBoolean() ? null : OpenSearchTestCase.randomAlphaOfLengthBetween(3, 10)
        if (OpenSearchTestCase.randomBoolean()) {
            clearIndicesCacheRequest.queryCache(OpenSearchTestCase.randomBoolean());
        }
        Assert.assertEquals(expectedParams, request.getParameters());
            rolloverRequest.addMaxIndexAgeCondition(new TimeValue(OpenSearchTestCase.randomNonNegativeLong()));
        RequestConvertersTests.setRandomIndicesOptions(getIndexRequest::indicesOptions, getIndexRequest::indicesOptions, expectedParams);
        assertEquals(e.getMessage(), "The index name cannot be null.");
        Assert.assertEquals(HttpDelete.METHOD_NAME, request.getMethod());
        RequestConvertersTests.setRandomIncludeDefaults(getIndexRequest::includeDefaults, expectedParams);
        Assert.assertEquals(expectedEndpoint.toString(), request.getEndpoint());
        encodes.put("foo^bar", "foo%5Ebar");
            clearIndicesCacheRequest::indicesOptions,
        Assert.assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
        expectedParams.put("request", Boolean.toString(clearIndicesCacheRequest.requestCache()));
            IllegalArgumentException iae = LuceneTestCase.expectThrows(
        endpoint.add("_validate/query");
        expectThrows(IllegalArgumentException.class, () -> new IndexTemplatesExistRequest(emptyList()));
    public void testClone() throws IOException {
        RequestConvertersTests.setRandomClusterManagerTimeout(putMappingRequest, expectedParams);
            aliases = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
            IllegalArgumentException.class,
            expectedParams
            }
                () -> IndicesRequestConverters.existsAlias(getAliasesRequest)
        DeleteIndexTemplateRequest deleteTemplateRequest = new DeleteIndexTemplateRequest().name(randomFrom(encodes.keySet()));
        Map<String, String> expectedParams = new HashMap<>();
        RequestConvertersTests.setRandomClusterManagerTimeout(updateSettingsRequest, expectedParams);
        }
        RefreshRequest refreshRequest;
            expectedParams
            putTemplateRequest.create(true);
        RequestConvertersTests.setRandomIndicesOptions(
    public void testForceMerge() {
        }
                expectedParams.put("dry_run", "true");
        RequestConvertersTests.setRandomClusterManagerTimeout(deleteIndexRequest, expectedParams);
        Map<String, String> expectedParams = new HashMap<>();
            () -> IndicesRequestConverters.indicesExist(new GetIndexRequest((String[]) null))
            )
        Assert.assertEquals(expectedParams, request.getParameters());
        validateQueryRequest.explain(OpenSearchTestCase.randomBoolean());
                "/" + rolloverRequest.getAlias() + "/_rollover/" + rolloverRequest.getNewIndexName(),
        );
        RequestConvertersTests.setRandomWaitForActiveShards(createIndexRequest::waitForActiveShards, expectedParams);
        endpoint.add("_cache/clear");
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(indices);
        RolloverRequest rolloverRequest = new RolloverRequest(
            + resizeType.name().toLowerCase(Locale.ROOT)
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        Assert.assertThat(request.getEndpoint(), equalTo("/" + deleteAliasRequest.getIndex() + "/_alias/" + deleteAliasRequest.getAlias()));
            if (OpenSearchTestCase.randomBoolean()) {
 */
        Map<String, String> expectedParams = new HashMap<>();
            forceMergeRequest.indices(indices);
        if (OpenSearchTestCase.randomBoolean()) {
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
        Assert.assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        }
        expectThrows(NullPointerException.class, () -> new GetIndexTemplatesRequest((String[]) null));
        Map<String, String> expectedParams = new HashMap<>();
        Assert.assertNull(request.getEntity());
        }
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
import org.opensearch.client.indices.IndexTemplatesExistRequest;
        encodes.put("template-*", "template-*");
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(indices);
        final Request request = IndicesRequestConverters.indicesExist(getIndexRequest);
            expectedParams.put("cause", cause);
        expectedParams.put("max_num_segments", Integer.toString(forceMergeRequest.maxNumSegments()));
            endpoint.add(String.join(",", fields));
        Map<String, String> expectedParams = new HashMap<>();
    }
        encodes.put("1", "1");
            + resizeRequest.getTargetIndex();
        }
    public void testRefresh() {
            if (getSettingsRequest.includeDefaults()) {
import java.util.List;
            getAliasesRequest::indicesOptions,
        List<String> names = OpenSearchTestCase.randomSubsetOf(1, encodes.keySet());
            getMappingRequest.indices((String[]) null);
        endpoint.add("_mapping");
            validateQueryRequest.indices(indices);
        Request request = function.apply(resizeRequest);
        GetIndexRequest getIndexRequest = new GetIndexRequest(indicesUnderTest);
import org.opensearch.core.common.util.CollectionUtils;
            getFieldMappingsRequest::indicesOptions,
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
                resizeRequest.setSettings(randomIndexSettings());
        Assert.assertEquals(expectedParams, request.getParameters());
        GetAliasesRequest getAliasesRequest = new GetAliasesRequest();
        if (OpenSearchTestCase.randomBoolean()) {
        AnalyzeRequest indexAnalyzeRequest = AnalyzeRequest.withIndexAnalyzer("test_index", "test_analyzer", "Here is some text");
    }
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
import static org.hamcrest.CoreMatchers.equalTo;
    }
            putTemplateRequest.order(OpenSearchTestCase.randomInt());
        if (OpenSearchTestCase.randomBoolean()) {
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        GetFieldMappingsRequest getFieldMappingsRequest = new GetFieldMappingsRequest();
        openIndexRequest.indices(indices);
        } else {
            expectedParams
            closeIndexRequest::indicesOptions,
            s -> resizeRequest.setTimeout(TimeValue.parseTimeValue(s, "timeout")),
        RequestConvertersTests.setRandomWaitForActiveShards(rolloverRequest.getCreateIndexRequest()::waitForActiveShards, expectedParams);
            }
        LuceneTestCase.expectThrows(
        }
        if (OpenSearchTestCase.randomBoolean()) {
        RequestConvertersTests.setRandomClusterManagerTimeout(putTemplateRequest, expectedParams);
import org.opensearch.common.unit.TimeValue;
        RequestConvertersTests.setRandomClusterManagerTimeout(rolloverRequest, expectedParams);
        String[] indices = RequestConvertersTests.randomIndicesNames(0, 5);
        Assert.assertEquals(HttpPut.METHOD_NAME, request.getMethod());
        Request request = IndicesRequestConverters.refresh(refreshRequest);
            getIndexRequest.includeDefaults(OpenSearchTestCase.randomBoolean());
import org.opensearch.client.indices.GetMappingsRequest;
        if (OpenSearchTestCase.randomBoolean()) {
            expectedEndpoint.add(String.join(",", indices));
            );
            getMappingRequest::indicesOptions,
            // true
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        Request request = IndicesRequestConverters.createIndex(createIndexRequest);
        RequestConvertersTests.assertToXContentBody(validateQueryRequest, request.getEntity());
        }
        Assert.assertThat(request.getMethod(), equalTo(HttpDelete.METHOD_NAME));
 *
        RequestConvertersTests.setRandomLocal(getTemplatesRequest::setLocal, expectedParams);
        encodes.put("template#1", "template%231");
    public void testDeleteAlias() {
        RequestConvertersTests.setRandomLocal(indexTemplatesExistRequest::setLocal, expectedParams);
        RequestConvertersTests.setRandomIndicesOptions(refreshRequest::indicesOptions, refreshRequest::indicesOptions, expectedParams);
package org.opensearch.client;
        assertThat(request.getEntity(), nullValue());
        }
    public void testClearCache() {
        Assert.assertThat(request.getEntity(), nullValue());
        if (OpenSearchTestCase.randomBoolean()) {
        expectThrows(IllegalArgumentException.class, () -> new IndexTemplatesExistRequest(new String[] {}));
            Assert.assertEquals(
        expectedParams.put("flush", Boolean.toString(forceMergeRequest.flush()));
        StringJoiner endpoint = new StringJoiner("/", "/", "");
            // the request object will not have include_defaults present unless it is set to
        final IndexTemplatesExistRequest indexTemplatesExistRequest = new IndexTemplatesExistRequest(names);
        );
import org.opensearch.test.OpenSearchTestCase;
            IllegalArgumentException iae = LuceneTestCase.expectThrows(
                endpoint.add(String.join(",", names));
        String[] indices = RequestConvertersTests.randomIndicesNames(1, 10);
import org.opensearch.client.indices.PutIndexTemplateRequest;
        PutIndexTemplateRequest putTemplateRequest = new PutIndexTemplateRequest(OpenSearchTestCase.randomFrom(names.keySet())).patterns(
    public void testExistsAliasNoAliasNoIndex() {
        }
        Assert.assertNull(request.getEntity());
        }
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
            forceMergeRequest = new ForceMergeRequest();
        Map<String, String> expectedParams = new HashMap<>();
        Map<String, String> expectedParams = new HashMap<>();
            endpoint.add(String.join(",", indicesUnderTest));
        }
        ForceMergeRequest forceMergeRequest;
        names.put("log", "log");
    }
        RequestConvertersTests.setRandomClusterManagerTimeout(deleteAliasRequest, expectedParams);
            putTemplateRequest.cause(cause);
        RequestConvertersTests.setRandomIndicesOptions(
        RequestConvertersTests.assertToXContentBody(createIndexRequest, request.getEntity());
    public void testGetAlias() {
        endpoint.add("_settings");
        Assert.assertNull(request.getEntity());
    }
        if (OpenSearchTestCase.randomBoolean()) {
/*
        validateQueryRequest.rewrite(OpenSearchTestCase.randomBoolean());
        );
        RequestConvertersTests.setRandomLocal(getMappingRequest::local, expectedParams);
    public void testRollover() throws IOException {
    public void testShrink() throws IOException {
        Map<String, String> expectedParams = new HashMap<>();
        RequestConvertersTests.setRandomLocal(getAliasesRequest::local, expectedParams);
        String name = randomAlphaOfLength(10);
            putTemplateRequest.version(OpenSearchTestCase.randomInt());
        );
            clearIndicesCacheRequest.fileCache(OpenSearchTestCase.randomBoolean());
import org.opensearch.client.indices.RandomCreateIndexGenerator;
 * The OpenSearch Contributors require contributions made to
    public void testPutDataStream() {
            forceMergeRequest.onlyExpungeDeletes(OpenSearchTestCase.randomBoolean());
        RequestConvertersTests.setRandomLocal(getAliasesRequest::local, expectedParams);
        expectedParams.put("force", Boolean.toString(flushRequest.force()));
import java.util.stream.Collectors;
        Assert.assertEquals(endpoint.toString(), request.getEndpoint());
        RequestConvertersTests.setRandomWaitForActiveShards(resizeRequest::setWaitForActiveShards, expectedParams);
        ValidateQueryRequest validateQueryRequest;
        assertThat(IndicesRequestConverters.analyze(analyzeRequest).getEndpoint(), equalTo("/_analyze"));
        endpoint.add("_mapping");
        Assert.assertEquals(expectedParams, request.getParameters());
        Request request = IndicesRequestConverters.getTemplates(getTemplatesRequest);
        Map<String, String> expectedParams = new HashMap<>();
        );
    }
        RequestConvertersTests.setRandomTimeout(createIndexRequest, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
import org.opensearch.client.indices.rollover.RolloverRequest;
        RequestConvertersTests.setRandomTimeout(
        }
            validateQueryRequest::indicesOptions,
        RequestConvertersTests.setRandomLocal(getSettingsRequest::local, expectedParams);
        Assert.assertEquals(HttpPost.METHOD_NAME, request.getMethod());
        Assert.assertEquals(expectedParams, request.getParameters());
            expectedParams
}
        }
    }
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.opensearch.client.indices.ResizeRequest;
        names.put("template#1", "template%231");
            resizeRequest.timeout(),
        RequestConvertersTests.setRandomClusterManagerTimeout(indicesAliasesRequest, expectedParams);
        encodes.put("log", "log");
 * the Apache License, Version 2.0 (the "License"); you may
        Assert.assertEquals(expectedParams, request.getParameters());
 */
        RequestConvertersTests.setRandomClusterManagerTimeout(indexTemplatesExistRequest::setClusterManagerNodeTimeout, expectedParams);
        }
        Assert.assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
        Map<String, String> expectedParams = new HashMap<>();
                numberOfNames,
import org.opensearch.client.indices.GetIndexRequest;
import java.util.Map;
        }
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
        RequestConvertersTests.setRandomTimeout(deleteIndexRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
import org.apache.hc.client5.http.classic.methods.HttpPost;
        GetIndexRequest getIndexRequest = new GetIndexRequest(indices);
        Assert.assertEquals(HttpGet.METHOD_NAME, request.getMethod());
        if (OpenSearchTestCase.randomBoolean()) {
        Assert.assertNull(request.getEntity());
        Map<String, String> expectedParams = new HashMap<>();
        final List<String> names = Arrays.asList(
        Assert.assertThat(request.getEntity(), nullValue());
    }
            expectedEndpoint.add(String.join(",", aliases));
    public void testDeleteDataStream() {
        ActionRequestValidationException validationException = new OpenIndexRequest(indices).validate();
        );
        }
        if (OpenSearchTestCase.randomBoolean()) {
import org.opensearch.action.ActionRequestValidationException;
        boolean hasIndices = indices != null && indices.length > 0;
 */
 * under the License.
        Assert.assertEquals(HttpGet.METHOD_NAME, request.getMethod());
        RequestConvertersTests.setRandomIndicesOptions(
            endpoint.add(String.join(",", indicesUnderTest));
        if (OpenSearchTestCase.randomBoolean()) {
        GetAliasesRequest getAliasesRequest = new GetAliasesRequest();
            validateQueryRequest = new ValidateQueryRequest();
        Assert.assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        );
    }
        } else {
        expectedParams.put("rewrite", Boolean.toString(validateQueryRequest.rewrite()));
        expectThrows(IllegalArgumentException.class, () -> new IndexTemplatesExistRequest(new String[] { (randomBoolean() ? "" : null) }));
import org.opensearch.client.indices.CreateDataStreamRequest;
            );
        } else if (resizeType == ResizeType.SHRINK) {
            resizeRequest.setSettings(Settings.builder().put("index.number_of_shards", 2).build());
    public void testGetMapping() {
        Map<String, String> encodes = new HashMap<>();
        Assert.assertEquals(HttpHead.METHOD_NAME, request.getMethod());
            endpoint.add(String.join(",", indices));
            + "/_"
    public void testIndicesExist() {
        }
            timeout -> closeIndexRequest.setTimeout(TimeValue.parseTimeValue(timeout, "test")),
        Request request = IndicesRequestConverters.clearCache(clearIndicesCacheRequest);
        Assert.assertEquals(expectedEndpoint.toString(), request.getEndpoint());
        Request request = IndicesRequestConverters.getFieldMapping(getFieldMappingsRequest);
        Assert.assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        expectedParams.put("only_expunge_deletes", Boolean.toString(forceMergeRequest.onlyExpungeDeletes()));
            closeIndexRequest::indicesOptions,
        expectThrows(NullPointerException.class, () -> new IndexTemplatesExistRequest((List<String>) null));
                () -> OpenSearchTestCase.randomAlphaOfLengthBetween(1, 100)
            endpoint.add(String.join(",", indices));
        }
                IllegalArgumentException.class,
            flushRequest.waitIfOngoing(OpenSearchTestCase.randomBoolean());
                    names[x] = OpenSearchTestCase.randomAlphaOfLengthBetween(3, 10);
    }
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
        expectThrows(NullPointerException.class, () -> new GetIndexTemplatesRequest((List<String>) null));
    public void testGetFieldMapping() {
                    + "\" : { \"type\" : \""
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
        if (OpenSearchTestCase.randomBoolean()) {
            getFieldMappingsRequest.fields(fields);
import org.opensearch.core.xcontent.MediaTypeRegistry;
            indices = RequestConvertersTests.randomIndicesNames(0, 5);
            putTemplateRequest.alias(new Alias("alias-" + OpenSearchTestCase.randomInt()));
        if (aliases != null && aliases.length > 0) {
        }
            getFieldMappingsRequest.indices(indices);
            }
        getAliasesRequest.aliases(aliases);
        String[] indices = RequestConvertersTests.randomIndicesNames(0, 5);
        expectedEndpoint.add("_alias");
        Assert.assertEquals(expectedParams, request.getParameters());
        Request request = IndicesRequestConverters.putTemplate(putTemplateRequest);
        if (indicesUnderTest != null && indicesUnderTest.length > 0) {
        if (false == CollectionUtils.isEmpty(aliases)) {
        if (OpenSearchTestCase.randomBoolean()) {
        Assert.assertEquals(HttpPut.METHOD_NAME, request.getMethod());
        Assert.assertThat(expectedParams, equalTo(request.getParameters()));
        Map<String, String> expectedParams = new HashMap<>();
        encodes.put("template#1", "template%231");
        if (OpenSearchTestCase.randomBoolean()) {
            expectedParams
        Map<String, String> expectedParams = new HashMap<>();
        }
        );
        RequestConvertersTests.setRandomIndicesOptions(
            validateQueryRequest = new ValidateQueryRequest(indices);
        RequestConvertersTests.setRandomClusterManagerTimeout(openIndexRequest, expectedParams);
        RequestConvertersTests.setRandomTimeout(
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        RequestConvertersTests.setRandomLocal(getIndexRequest::local, expectedParams);
            getAliasesRequest::indicesOptions,
        } else {
            + "/"
            expectedParams
            putTemplateRequest.mapping(
        }
        }
    public void testSplit() throws IOException {
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
            + resizeRequest.getSourceIndex()
        assertThat(request.getParameters(), equalTo(expectedParams));
                for (int x = 0; x < names.length; x++) {
            putMappingRequest::indicesOptions,
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
    public void testPutMapping() throws IOException {
 *
    public void testAnalyzeRequest() throws Exception {
            request.getEndpoint(),
 * SPDX-License-Identifier: Apache-2.0
        );
public class IndicesRequestConvertersTests extends OpenSearchTestCase {
            getAliasesRequest::indicesOptions,
        Assert.assertThat(expectedParams, equalTo(request.getParameters()));
        Assert.assertEquals(HttpPut.METHOD_NAME, request.getMethod());
    public void testIndicesExistEmptyIndices() {
        String[] indices = RequestConvertersTests.randomIndicesNames(2, 2);
import java.io.IOException;
        if (indices != null && indices.length > 0) {
        encodes.put("1", "1");
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : Strings.EMPTY_ARRAY;
        }
                    resizeRequest.setAliases(singletonList(randomAlias()));
        if (OpenSearchTestCase.randomBoolean()) {
    public void testExistsAlias() {
            endpoint.add(String.join(",", indices));
        }
        Request request = IndicesRequestConverters.deleteDataStream(deleteDataStreamRequest);
        RequestConvertersTests.setRandomTimeout(deleteAliasRequest, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        );
 * Licensed to Elasticsearch under one or more contributor
        if (randomBoolean()) {
        if (OpenSearchTestCase.randomBoolean()) {
    }
        CreateDataStreamRequest createDataStreamRequest = new CreateDataStreamRequest(name);
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
        Map<String, String> expectedParams = new HashMap<>();
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
            expectedParams
        RequestConvertersTests.setRandomIndicesOptions(flushRequest::indicesOptions, flushRequest::indicesOptions, expectedParams);
            AcknowledgedRequest.DEFAULT_ACK_TIMEOUT,
        StringJoiner endpoint = new StringJoiner("/", "/", "").add(String.join(",", indices)).add("_open");
    }
        Map<String, String> encodes = new HashMap<>();
    public void testFlush() {
        endpoint.add("_settings");
        if (indices != null && indices.length > 0) {
import org.opensearch.common.CheckedFunction;
        Assert.assertThat(expectedParams, equalTo(request.getParameters()));
import java.util.Locale;
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        );
        RequestConvertersTests.setRandomClusterManagerTimeout(createIndexRequest, expectedParams);
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
        Assert.assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        }
        Assert.assertThat(HttpGet.METHOD_NAME, equalTo(request.getMethod()));
    public void testGetIndex() throws IOException {
            forceMergeRequest::indicesOptions,
        ActionRequestValidationException validationException = new DeleteIndexRequest(indices).validate();
        RequestConvertersTests.setRandomHumanReadable(getIndexRequest::humanReadable, expectedParams);
        endpoint.add("_forcemerge");
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        RequestConvertersTests.setRandomIndicesOptions(
 * GitHub history for details.
            if (getIndexRequest.includeDefaults()) {
        Assert.assertNull(request.getEntity());
    }
        validateQueryRequest.allShards(OpenSearchTestCase.randomBoolean());
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest();
        CreateIndexRequest createIndexRequest = RandomCreateIndexGenerator.randomCreateIndexRequest();
        assertThat(request.getMethod(), equalTo(HttpHead.METHOD_NAME));
            // true
import org.opensearch.client.indices.GetFieldMappingsRequest;
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
    }
        names.put("foo^bar", "foo%5Ebar");
    public void testDeleteTemplateRequest() {
            getAliasesRequest::indicesOptions,
            forceMergeRequest::indicesOptions,
        );
        String[] indices = Strings.EMPTY_ARRAY;
        Request request = IndicesRequestConverters.forceMerge(forceMergeRequest);
            getFieldMappingsRequest.indices((String[]) null);
    }
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indicesUnderTest);
            if (names != null) {
            clearIndicesCacheRequest.fields(RequestConvertersTests.randomIndicesNames(1, 5));
        StringJoiner expectedEndpoint = new StringJoiner("/", "/", "");
        RequestConvertersTests.assertToXContentBody(rolloverRequest, request.getEntity());
    public void testGetTemplateRequest() throws Exception {
import static org.opensearch.client.indices.RandomCreateIndexGenerator.randomMapping;
        if (OpenSearchTestCase.randomBoolean()) {
        }
        RequestConvertersTests.assertToXContentBody(indicesAliasesRequest, request.getEntity());
    }
        Assert.assertEquals("/_data_stream/" + name, request.getEndpoint());
        if (indices != null && indices.length > 0) {
        assertThat(request.getEndpoint(), equalTo("/test_index/_analyze"));
        } else {
        Assert.assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        RequestConvertersTests.assertToXContentBody(resizeRequest, request.getEntity());
            // the request object will not have include_defaults present unless it is set to
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
                fields[i] = randomAlphaOfLengthBetween(3, 10);
            getFieldMappingsRequest.fields((String[]) null);
        Request request = IndicesRequestConverters.putMapping(putMappingRequest);
        Map<String, String> expectedParams = new HashMap<>();
    }
        if (OpenSearchTestCase.randomBoolean()) {
        RequestConvertersTests.setRandomIndicesOptions(
        Map<String, String> expectedParams = new HashMap<>();
        DeleteAliasRequest deleteAliasRequest = new DeleteAliasRequest(randomAlphaOfLength(4), randomAlphaOfLength(4));
            updateSettingsRequest.setPreserveExisting(OpenSearchTestCase.randomBoolean());
            String[] names = OpenSearchTestCase.randomBoolean() ? null : new String[OpenSearchTestCase.randomIntBetween(0, 3)];
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
        RequestConvertersTests.setRandomIndicesOptions(
    }
        } else {
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        IndicesAliasesRequest.AliasActions aliasAction = randomAliasAction();
import org.junit.Assert;
        Assert.assertEquals("/_data_stream/" + name, request.getEndpoint());
        StringJoiner endpoint = new StringJoiner("/", "/", "").add(String.join(",", indices)).add("_close");
        Assert.assertEquals("/_aliases", request.getEndpoint());
        if (Strings.hasLength(index)) {
    }
            Arrays.asList(OpenSearchTestCase.generateRandomStringArray(20, 100, false, false))
        if (OpenSearchTestCase.randomBoolean()) {
        Assert.assertThat(
 * ownership. Elasticsearch licenses this file to you under
import org.apache.hc.client5.http.classic.methods.HttpDelete;
        RequestConvertersTests.setRandomClusterManagerTimeout(resizeRequest, expectedParams);
        } else if (randomBoolean()) {
    }
        if (fields != null) {
            flushRequest = new FlushRequest();
            clearIndicesCacheRequest = new ClearIndicesCacheRequest();
    }
            fields = new String[randomIntBetween(1, 5)];
        }
            refreshRequest = new RefreshRequest();
        RequestConvertersTests.setRandomIndicesOptions(
                    + "\" }}}",
                numberOfNames,
        Request request = IndicesRequestConverters.validateQuery(validateQueryRequest);
                }
 * license agreements. See the NOTICE file distributed with
        String[] indicesUnderTest = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
import org.apache.hc.client5.http.classic.methods.HttpGet;
        String[] aliases = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 2);
        RequestConvertersTests.setRandomIndicesOptions(
            expectedEndpoint.add(String.join(",", aliases));
        Request request = IndicesRequestConverters.getSettings(getSettingsRequest);
        if (OpenSearchTestCase.randomBoolean()) {
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
            endpoint.add(index);
        expectedParams.put("query", Boolean.toString(clearIndicesCacheRequest.queryCache()));
        ResizeRequest resizeRequest = new ResizeRequest(indices[0], indices[1]);
        }
    public void testGetDataStream() {
        Assert.assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
import org.opensearch.client.indices.CreateIndexRequest;
    }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        RequestConvertersTests.setRandomIndicesOptions(
        }
        }
        indicesAliasesRequest.addAliasAction(aliasAction);
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 2);
    }
import static org.hamcrest.Matchers.nullValue;
import static org.opensearch.client.indices.RandomCreateIndexGenerator.randomAliases;
        RequestConvertersTests.assertToXContentBody(updateSettingsRequest, request.getEntity());
            expectedParams
        Assert.assertEquals(HttpPut.METHOD_NAME, request.getMethod());
        Request request = IndicesRequestConverters.deleteAlias(deleteAliasRequest);
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
        Request request = IndicesRequestConverters.closeIndex(closeIndexRequest);
        RequestConvertersTests.setRandomIndicesOptions(
        RequestConvertersTests.setRandomClusterManagerTimeout(getIndexRequest, expectedParams);
import org.opensearch.client.indices.GetIndexTemplatesRequest;
        RequestConvertersTests.setRandomTimeout(indicesAliasesRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        }
        Assert.assertThat(expectedParams, equalTo(request.getParameters()));
        }
            OpenSearchTestCase.randomAlphaOfLengthBetween(3, 10),
        );
            getMappingRequest.indices(indices);
    }
            }
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
            deleteIndexRequest::indicesOptions,
            updateSettingsRequest::indicesOptions,
            resizeRequest.setMaxShardSize(new ByteSizeValue(randomIntBetween(1, 1000)));
            }
        if (OpenSearchTestCase.randomBoolean()) {
        Assert.assertThat(request.getEntity(), nullValue());
    }
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
        String[] aliases;
import org.opensearch.client.indices.DeleteDataStreamRequest;
        encodes.put("template-*", "template-*");
        }
        RequestConvertersTests.setRandomClusterManagerTimeout(getSettingsRequest, expectedParams);
        Assert.assertThat(request.getEntity(), nullValue());
        if (indices != null && indices.length > 0) {
            endpoint.add(String.join(",", indices));
            getAliasesRequest.indices((String[]) null);
        );
import static java.util.Collections.singletonList;
        RequestConvertersTests.setRandomLocal(getIndexRequest::local, expectedParams);
        Assert.assertThat(expectedParams, equalTo(request.getParameters()));
            );
        Map<String, String> expectedParams = new HashMap<>();
import org.opensearch.client.indices.CloseIndexRequest;
        Map<String, String> expectedParams = new HashMap<>();
            expectedParams
        Request request = IndicesRequestConverters.existsAlias(getAliasesRequest);
            );
        String[] fields = null;
        }
import org.opensearch.client.indices.GetDataStreamRequest;
    public void testCloseIndex() {
            clearIndicesCacheRequest::indicesOptions,
        Assert.assertEquals(HttpHead.METHOD_NAME, request.getMethod());
        RequestConvertersTests.setRandomTimeout(putMappingRequest, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
import org.opensearch.client.indices.AnalyzeRequest;
        final Map<String, String> expectedParams = new HashMap<>();
    public void testTemplatesExistRequest() {
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
            expectedParams
        String index = String.join(",", indices);
            flushRequest = new FlushRequest(indices);
        Assert.assertEquals(HttpDelete.METHOD_NAME, request.getMethod());
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        endpoint.add("field");
            String cause = OpenSearchTestCase.randomUnicodeOfCodepointLengthBetween(1, 50);
        Request request = IndicesRequestConverters.rollover(rolloverRequest);
        }
                    + OpenSearchTestCase.randomFrom("text", "keyword")
            randomAliases(rolloverRequest.getCreateIndexRequest());
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
                expectedParams.put("include_defaults", Boolean.toString(true));
        );
                "{ \"properties\": { \"field-"
        Assert.assertEquals("/" + String.join(",", indices), request.getEndpoint());
        }
 * specific language governing permissions and limitations
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
import static org.opensearch.index.RandomCreateIndexGenerator.randomAlias;
        getAliasesRequest.indices(indices);
            flushRequest.force(OpenSearchTestCase.randomBoolean());
        RequestConvertersTests.assertToXContentBody(putTemplateRequest, request.getEntity());
    }
            putTemplateRequest.settings(
        RequestConvertersTests.setRandomTimeout(rolloverRequest, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        Map<String, String> expectedParams = new HashMap<>();
        }
            indices = RequestConvertersTests.randomIndicesNames(0, 5);
        if (randomBoolean()) {
        if (OpenSearchTestCase.randomBoolean()) {
            rolloverRequest.getCreateIndexRequest().mapping(randomMapping());
            }
        }
            rolloverRequest.dryRun(OpenSearchTestCase.randomBoolean());
        if (OpenSearchTestCase.randomBoolean()) {
 * You may obtain a copy of the License at
        encodes.put("log", "log");
        assertThat(request.getEndpoint(), equalTo("/_template/" + String.join(",", names)));
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
import org.opensearch.common.settings.Settings;
                String[]::new,
        Request request = IndicesRequestConverters.getDataStreams(getDataStreamRequest);
        DeleteDataStreamRequest deleteDataStreamRequest = new DeleteDataStreamRequest(name);
        Request request = IndicesRequestConverters.updateAliases(indicesAliasesRequest);
        Map<String, String> expectedParams = new HashMap<>();
        Request request = IndicesRequestConverters.putDataStream(createDataStreamRequest);
        if (OpenSearchTestCase.randomBoolean()) {
    }
                () -> IndicesRequestConverters.existsAlias(getAliasesRequest)
import static org.opensearch.index.alias.RandomAliasActionsGenerator.randomAliasAction;
        final int numberOfNames = OpenSearchTestCase.usually() ? 1 : OpenSearchTestCase.randomIntBetween(2, 20);
            expectedParams
        if (randomBoolean()) {
            clearIndicesCacheRequest = new ClearIndicesCacheRequest(indices);
        String index = String.join(",", indices);
        RequestConvertersTests.setRandomHumanReadable(getIndexRequest::humanReadable, expectedParams);
            expectedParams.put("fields", String.join(",", clearIndicesCacheRequest.fields()));
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
        }
    public void testCreateIndexNullIndex() {
/*
        }
        if (indices != null && indices.length > 0) {
                for (int i = 0; i < count; i++) {
        // the HEAD endpoint requires at least an alias or an index
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
            endpoint.add(String.join(",", indices));
/*
    }
            OpenSearchTestCase.randomArray(
        expectedParams.put("file", Boolean.toString(clearIndicesCacheRequest.fileCache()));
        if (OpenSearchTestCase.randomBoolean()) {
            getSettingsRequest.includeDefaults(OpenSearchTestCase.randomBoolean());
        GetMappingsRequest getMappingRequest = new GetMappingsRequest();
    public void testOpenIndexEmptyIndices() {
            putMappingRequest::indicesOptions,
import org.opensearch.core.common.unit.ByteSizeValue;
            updateSettingsRequest::indicesOptions,
        names.put("-#template", "-%23template");
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        }
