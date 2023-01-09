### Spotify API Automation Testing
1. Create Client API: https://developer.spotify.com/dashboard/applications
2. Get Client ID, Client Secret, redirect uri
3. Authorize App:
- HTTP-method GET https://accounts.spotify.com/authorize
- Query Params:
  - client_id = from p.2
  - response_type = code
  - redirect_uri = from p.2
  - scope = playlist-read-private playlist-read-collaborative playlist-modify-private playlist-modify-public
  - state = 34fFs29kd09<br>
documentation: https://developer.spotify.com/documentation/general/guides/authorization/code-flow/
4. Obtain Authorization Code.
- Copy Http-request and call it in browser, AGREE permissions, get response from URL bar,
  where value of query parameter code = Authorization Code<br>
5. Obtain Access Token & Refresh Token:<br>
   Body x-www-form-urlencoded
- HTTP-method POST https://accounts.spotify.com/api/token
  - client_id = from p.2
  - client_secret = from p.2
  - grant_type = authorization_code
  - code = from p.4
  - redirect_uri = from p.2
6. *(Optional) Refreshing an Access Token:<br>
   Body x-www-form-urlencoded
- HTTP-method POST https://accounts.spotify.com/api/token
  - grant_type = refresh_token
  - refresh_token = from p.5
  - client_id = from p.2
  - client_secret = from p.2

p.s.<br>
*POJO classes creator: https://www.jsonschema2pojo.org/