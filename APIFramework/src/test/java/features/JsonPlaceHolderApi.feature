Feature: Validating Place API's
@AddPlace @Regression

Scenario:Verify user is able to successfully add the posts using Post request
Given the payload is ready to add the Post
When user calls add posts api with Post http request
Then Response code is 201 Ok

Scenario:Verify user is able to successfullyupdate the post
Given the payload is ready to update the Posts using post id
When user calls  posts update api with Put http request
Then Update status Response code  is 200 Ok

Scenario:Verify the response code when user hit post by id and comments 
Given the payload is ready to get the comments of the respective post id
When user calls  posts id and comments by http get request
Then response code is 200 Ok 