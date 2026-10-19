openssl req -new \
    -CA ../ca.pem \
    -days 3650 \
openssl genpkey -algorithm RSA -out "$NAME".key -aes256 -pass pass:"$KEY_PW"
openssl req -x509 -key ca.key -sha256 -days 3650 -subj "/CN=OpenSearch Test Node" -passin pass:"$KEY_PW" \
    -out ca.pem
    -out "$NAME".crt \
openssl x509 -req \
    -days 3650 \
    -CAcreateserial \
The server certificate must contain a `localhost` Subject Alternative Name; a SAN on the CA does not identify the server.
    -in "$NAME".csr \
    -in "$NAME".csr \
openssl genpkey -algorithm RSA -out ca.key -aes256 -pass pass:"$KEY_PW"
    -addext "subjectAltName=DNS:localhost,DNS:localhost.localdomain,DNS:localhost4,DNS:localhost4.localdomain4,DNS:localhost6,DNS:localhost6.localdomain6,IP:127.0.0.1,IP:0:0:0:0:0:0:0:1" \
    -passin pass:"$KEY_PW"
    -passin pass:"$KEY_PW"
rm "$NAME".csr
export NAME='http'
    -passin pass:"$KEY_PW"
# generate self-signed CA key + cert
    -sha256 \
export KEY_PW='6!6428DQXwPpi7@$ggeg/='
```
```
openssl genpkey -algorithm RSA -out "$NAME".key -aes256 -pass pass:"$KEY_PW"
rm "$NAME".csr
# repeat the same for server key + cert
```bash
# generate client key + cert
    -key "$NAME".key \
    -CAkey ../ca.key \
    -out "$NAME".csr \
    -subj "/C=CA/ST=ONTARIO/L=TORONTO/O=ORG/OU=UNIT/CN=localhost" \
    -sha256 \
```
    -out "$NAME".csr \
    -CAkey ../ca.key \
    -CAcreateserial \
```bash
    -key "$NAME".key \
export NAME='client'
openssl req -new \
    -copy_extensions copy \
    -addext "subjectAltName=DNS:localhost" \
```bash
    -out "$NAME".crt \
    -subj "/C=CA/ST=ONTARIO/L=TORONTO/O=ORG/OU=UNIT/CN=localhost" \
openssl x509 -req \
    -passin pass:"$KEY_PW"
    -CA ../ca.pem \
