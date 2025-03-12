package com.Demo3;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.model.RetentionSetting;

import java.util.HashMap;
import java.util.Map;

@LambdaHandler(
    lambdaName = "hello_world",
	roleName = "hello_world-role",
	isPublishVersion = true,
	aliasName = "${lambdas_alias_name}",
	logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
)
public class HelloWorld implements RequestHandler<Object, APIGatewayProxyResponseEvent>  {
	@Override
	public APIGatewayProxyResponseEvent handleRequest(Object input, Context context) {
		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
				.withStatusCode(200)
				.withBody("{\"statusCode\":200, \"message\": \"Hello from Lambda\"}");
		return response;
	}

}
