package org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.Oauth.model.GoogleToken;
import org.Oauth.model.RequestTokenParams;
import org.Oauth.model.UserInfo;

/**
 * Servlet implementation class OAuthServlet
 */
public class OAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Client client = ClientBuilder.newClient();
	WebTarget googleTokenServer = client.target("https://www.googleapis.com/oauth2/v4/token");

	public OAuthServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 1 : 'User login & consent' on index.jsp page

		// Step 2 : Get Authorization code
		String code = request.getParameter("code");

		// Step 3 : Exchange code for token
		String client_id = "1079145742575-pspq02g6lgqschm1960qott6k6uppb0m.apps.googleusercontent.com";
		String client_secret = "oAHpvt_WKd93nPGinFjCEu7K";
		String redirect_uri = "http://localhost:8080/GoogleOAuth/OAuthServlet";
		String grant_type = "authorization_code";

		RequestTokenParams requestTokenParams = new RequestTokenParams(code, client_id, client_secret, redirect_uri,
				grant_type);

		// Step 5 : Get Token response
		Response accessTokenResponse = googleTokenServer.request().post(Entity.json(requestTokenParams));

		GoogleToken googleToken = accessTokenResponse.readEntity(GoogleToken.class);

		// Step 5 : Use token to call google API
		WebTarget googleUserInfoAPI = client
				.target("https://www.googleapis.com/oauth2/v2/userinfo?access_token=" + googleToken.getAccess_token());

		Response userInfoResponse = googleUserInfoAPI.request().get();

		UserInfo userInfo = userInfoResponse.readEntity(UserInfo.class);

		request.setAttribute("userInfo", userInfo);

		System.out.println(userInfo.getId());
		System.out.println(userInfo.getEmail());
		System.out.println(userInfo.isVerified_email());
		System.out.println(userInfo.getPicture());

		request.getRequestDispatcher("userInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
