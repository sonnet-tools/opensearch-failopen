The `api_call_timeout` setting limits one AWS SDK API call, including its retry
A repository can override its client's value through its repository settings:
existing behavior. Negative values are rejected. The existing `request_timeout`
  "type": "s3",
PUT _snapshot/my_repository
setting continues to limit each individual attempt.
This setting limits individual SDK calls. It does not set a deadline for an
    "api_call_timeout": "15m"
A total timeout shorter than `request_timeout` ends the entire call before the
s3.client.default.api_call_timeout: 10m
}
    "client": "default",
attempts and backoff delays. It applies to both the synchronous and asynchronous
# S3 API call timeout
body reads remain subject to the socket timeout.
individual attempt's timeout can expire.
S3 clients.
entire snapshot or multipart upload. For a synchronous GET that returns an
    "bucket": "my-bucket",
input stream, the API call ends when the SDK returns that stream; subsequent
  "settings": {
{
```
The default is `0`, which leaves the SDK API call timeout unset and preserves
Configure a named client in `opensearch.yml`:
```yaml
```json
```
Set the repository value to `0` to disable a timeout inherited from its client.
  }
