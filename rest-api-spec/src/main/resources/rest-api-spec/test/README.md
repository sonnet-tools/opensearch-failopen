    "test id":
## `transform_and_set`
             index:
The Java test runner introduces randomness and sometimes overrides the default number of shards to `2`. If the default number of shards is changed, test marked with this feature should **not** run.
            level: shards
4. run `teardown` (if any)
Used only in the doc snippet tests. Allow you to do ease replacements using a special `$_path` marker.
## `default_shards`
## `stash_in_path`
        get:
   - match: { _id: $id } # the returned `response._id` matches the stashed `id`
-  an optional `teardown` section, followed by
</tr>
## `transform_and_set`
            type: test
# Test file structure
    $val = $response->{tokens}[1]{token}  # Perl syntax roolz!
        $body:
Certain tests require specific settings to be applied to the OpenSearch instance in order to pass. You should run OpenSearch as follows:
    - do:
Asserts an array of object contains an object with a property set to a certain value. e.g:
**Note:** `$body` is used to refer to the last obtained response body as a string, while `''` refers to the parsed representation (parsed into a Map by the Java runner for instance). Having the raw string response is for example useful when testing cat APIs.
<td><p>a 4xx-5xx error response from ES, not equal to any named response above</p></td>
Allows you to use a stashed value in any key of an object during a `match` assertion
    "Parent":
## `is_false`
The stash should be reset at the beginning of each test file.
-  one or more test sections
</table>
            type: test
        allowed_warnings:
    - set: { cluster_manager_node: cluster_manager }
    setup:
                 body: { foo: bar }
      - do: ...
<td><p><code>bad_request</code></p></td>
# Skipping tests:
    - length: { _source: 5 } # the `_source` hash has 5 keys
    - do:
    - do:
        cluster.health:
            id: 1
## `warnings`
</tr>
Use \\. to specify paths that actually contain *.* in the key name, for example in the `indices.get_settings` API.
For some tests, it is necessary to extract a value and transform it from the previous `response`, in order to reuse it in a subsequent `do` and other tests. Currently, it only has support for `base64EncodeCredentials`, for unknown transformations it will not do anything and stash the value as is. For instance, when testing you may want to base64 encode username and password for `Basic` authorization header:
            reason:      Delete ignores the parent param
             node_selector:
        attribute:
                     \d+    \s+  \d{2}:\d{2}:\d{2}  \s+  \d+    \s+  \n  $/
</tbody>
<td><p><code>request</code></p></td>
         }
        $body: >
The argument to `catch` can be any of:
        - do:
Stashed values can be used as described in the `set` section
The specified key doesn’t exist or has a false value (ie `0`, `false`, `undefined`, `null` or the empty string), eg:
</tr>
-  an optional `setup` section, followed by
If one of the levels (eg `tokens`) does not exist, it should return an undefined value. If no field name is given (ie the empty string) then return the current $val — used for testing the whole response body.
2. reset the `response` var and the `stash` (see below)
## `yaml`
</tr>
        ... test definitions ...
<tr class="even">
If the arguments to `do` include `node_selector` then the request is only sent to nodes that match the `node_selector`. It looks like this:
## `stash_in_key`
-  `version`: Only nodes who’s version is within the range will receive the request. The syntax for the pattern is the same as when `version` is within `skip`.
        get:
    - transform_and_set: { login_creds: "#base64EncodeCredentials(user,password)" } # stash the base64 encoded credentials of `response.user` and `response.password` as `login_creds`
</tr>
<td><p>a 503 response from ES</p></td>
    - match:
A test section represents an independent test, containing multiple `do` statements and assertions. The contents of a test section must be run in order, but individual test sections may be run in any order, as follows:
    - is_false: fields._source  # the _source key doesn't exist in the fields hash or is "false"
    - do:
        catch: missing
            id: 1
    // TESTRESPONSEs/somevalue/$body.${_path}/ to mean "replace
        headers:
<td><p><code>request_timeout</code></p></td>
             features: node_selector
Allows a stashed key to appear anywhere in the path (note the placeholder needs to be within curly brackets too in this case):
## `length`
Asserts the plugins array contains an object with a `name` property with the value `painless-allowlist`
## `stash_path_replace`
   - set: { _id: id } # stash the value of `response._id` as `id`
Runner supports `catch: unauthorized` on a `do` operator.
A `teardown` section contains a list of commands to run after each test section in order to setup the same environment for each test section. This may be needed for modifications made by the test that are not cleared by the deletion of indices and templates.
            index: test
<td><p>a client-side error indicating an unknown parameter has been passed to the method</p></td>
<col style="width: 85%" />
<td><p><code>missing</code></p></td>
<tr class="odd">
            type: test
# Dot notation:
Used to compare two variables (could be scalars, arrays or hashes). The two variables should be identical, eg:
<tr class="even">
# Required settings
                 version: " - 6.9.99"
The `features` field can either be a string or an array of strings. The skip section requires to specify either a `version` or a `features` list.
        - skip:
3. run test contents
Allows you to stash an arbitrary key from a returned map e.g:
            - some warning
            reason:      Delete ignores the parent param
    bin/opensearch -Enode.attr.testattr=test -Epath.repo=/tmp -Erepositories.url.allowed_urls='http://snapshot.*'
## `catch_unauthorized`
</tr>
    - match: { $body: /^.+$/ } # the returned `body` matches the provided regex if the body is text
<td><p>a 400 response from ES</p></td>
</colgroup>
If the arguments to `do` include `warnings` then we are expecting a `Warning` header to come back from the request. If the arguments **don’t** include a `warnings` argument then we **don’t** expect the response to include a `Warning` header. The warnings must match exactly. Using it looks like this:
            Authorization: Basic ${login_creds} # replace `$login_creds` with the stashed value
    client.cluster.health(...params...)
The skip section can also be used to list new features that need to be supported in order to run a test. This way the up-to-date runners will run the test, while the ones that don’t support the feature yet can temporarily skip it, and avoid having lots of test failures in the meantime. Once all runners have implemented the feature, it can be declared supported by default, thus the related skip sections can be removed from the tests.
<td><p><code>param</code></p></td>
## `node_selector`
## `do`
<tr class="odd">
<td><p><code>conflict</code></p></td>
<td><p><code>/foo bar/</code></p></td>
    - length: { _tokens: 3 } # the `_tokens` array has 3 elements
This test can only run if the cluster is running with the distributions default number of shards.
</tr>
        warnings:
            - no matter how many warnings you expect
            type: test
<td><p><code>unavailable</code></p></td>
            - this argument is also always a list, never a single string
## `contains`
        - do:
If the arguments to `do` include `catch`, then we are expecting an error, which should be caught and tested. For instance:
    - match:
The `do` operator calls a method on the client. For instance:
            index: test
## `headers`
# Required operators:
## `embedded_stash_key`
Indicates the runner can parse `node_selector` under the `do` operator and use its metadata to select the node to perform the `do` operation on.
            id: $id # replace `$id` with the stashed value
              $host: {
<colgroup>
        - skip:
<tr class="even">
            version:     "0.20.1 - 0.90.2"
… contains: { nodes.$cluster_manager.plugins: { name: painless-allowlist } } …
        index:
    - do:
            - but this argument is always a list, never a single string
<tr class="odd">
        get:
                 /^  epoch  \s+  timestamp          \s+  count  \s+  \n
Supports also regular expressions with flag X for more readability (accepts whitespaces and comments):
    ---
<td><p>a 409 response from ES</p></td>
            metric: [ transport ]
   - do:
        get:
    "First test":
<td><p>a 404 response from ES</p></td>
      - match: ...
</tr>
            index: test
        - skip:
## `set`
    "Parent":
Compares two numeric values, eg:
The response from the `do` operator should be stored in the `response` var, which is reset (1) at the beginning of a file or (2) on the next `do`.
The runner is able to send and receive `application/yaml` and perform all assertions on the returned data.
5. delete all indices and all templates
        nodes._arbitrary_key_: node_id
    "Parent":
        - skip:
A test against `_tokens.1.token` would examine the `token` key, in the second element of the `tokens` array, inside the `response` var (see below):
-  `attribute`: Only nodes that have an attribute matching the name and value of the provided attribute match. Looks like:
            index: test
<td><p><code>forbidden</code></p></td>
A `setup` section contains a list of commands to run before each test section in order to setup the same environment for each test section.
The runner can assert the warnings headers returned by OpenSearch through the `warning:` assertations under `do:` operations.
        ... test definitions ...
<td><p>a 401 response from ES</p></td>
      - do: ....
</tr>
    field1.e${placeholder}ments.element1
For instance:
      - do: ....
      - do: ...
            name: value
Stashed values can be used in property names, eg:
Supports the `transform_and_set` operator as described in this document.
            version:     "1.0.0.Beta1 - "
<td><p>the text of the error message matches this regular expression</p></td>
            type: test
Note that not only expected values can be retrieved from the stashed values (as in the example above), but the same goes for actual values:
The specified key exists and has a true value (ie not `0`, `false`, `undefined`, `null` or the empty string), eg:
<td><p>a 403 response from ES</p></td>
    - is_true: fields.foo  # the foo key exists in the fields hash and is "true"
            index: test
            - quotes are not required because yaml
## `lte` and `gte`
        index:
    - set: {nodes.$cluster_manager.http.publish_address: host}
    - is_true: nodes.$cluster_manager.transport.profiles
    - do:
    - lt: { foo: 10000 } # the `foo` value is less than 10,000
            features:    regex
      - match: ...
    - set:
The `version` range can leave either bound empty, which means "open ended". For instance:
                 type: weird.type
<table>
    ---
            }
If `catch` is specified, then the `response` var must be cleared, and the test should fail if no error is thrown.
            - '[index] is deprecated'
   - match: { _source: { foo: bar } }
      - do: ....
The last response obtained gets always stashed automatically as a string, called `body`. This is useful when needing to test apis that return text rather than json (e.g. cat api), as it allows to treat the whole body as an ordinary string field.
            id: 1
            type:  test
    - lte: { foo: 10000 } # the `foo` value is less than or equal to 10,000
        - do:
        nodes.info:
Dot notation is used for (1) method calls and (2) hierarchical data structures. For instance, a method call like `cluster.health` would do the equivalent of:
If the arguments to `do` include `allowed_warnings` then matching `Warning` headers do not fail the request. Unlike the `warnings` argument, these aren’t expected so much as "allowed". This usually comes up in backwards compatibility testing. Using it looks like this:
<td><p>a 408 response from ES</p></td>
For some tests, it is necessary to extract a value from the previous `response`, in order to reuse it in a subsequent `do` and other tests. For instance, when testing indexing a document without a specified ID:
    - do:
              }
<col style="width: 15%" />
    path.$stash.value
        - do:
                 index: test-weird-index-中文
        ... test definitions ...
<tr class="even">
        cluster.state: {}
## `lt` and `gt`
If a test section should only be run on certain versions of OpenSearch, then the first entry in the section (after the title) should be called `skip`, and should contain the range of versions to be skipped, and the reason why the tests are skipped. For instance:
Compares two numeric values, eg:
<tr class="odd">
This means: Stash any of the keys returned under `nodes` as `$node_id`
This depends on the data type of the value being examined, eg:
<td><p><code>unauthorized</code></p></td>
    ---
                 id: 1
    node_selector:
    somevalue with whatever is the response in the same position."
</tr>
    - match: { $body: {} } # the returned `body` matches the JSON object if the body is JSON
If you list multiple selectors then the request will only go to nodes that match all of those selectors. The following selectors are supported:
    - length: { _id: 22    } # the `_id` string is 22 chars long
        get:
    teardown:
<tr class="odd">
    "Second test":
    - do:
   - do:
1. run `setup` (if any)
## `match`
<tr class="even">
                ... stuff in here ...
          {
            index: test
            type: test
Allows a stashed value to be referenced in path lookups as a single token. E.g:
            index: test
The runner is able to set per request headers on the `do` operation.
## `arbitrary_key`
<tbody>
A YAML test file consists of:
            "nodes": {
All tests in the file following the skip statement should be skipped if: `min <= current <= max`.
## `is_true`
            - no matter how many warnings you expect
