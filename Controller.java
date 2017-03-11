package com.auction.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.TypeFactory;

import com.auction.model.AuctionItem;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class Controller
 */
@WebServlet(name = "ApplicationController", urlPatterns = { "/ApplicationController" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Client client = Client.create();
		WebResource webResource = client.resource("http://honbglrhackathon10march2017.mybluemix.net/items");

		ClientResponse jsonResponse = webResource.accept("application/json;charset=utf-8 ").get(ClientResponse.class);
		if (jsonResponse.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = jsonResponse.getEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<AuctionItem> auctionItems = new ArrayList<>();
		try {
			TypeFactory typeFactory = mapper.getTypeFactory();
			CollectionType collectionType = typeFactory.constructCollectionType(List.class, AuctionItem.class);
			// Convert JSON string from file to Object
			auctionItems = mapper.readValue(output.getBytes(), collectionType);

			for (AuctionItem auctionItem : auctionItems) {
				System.out.println(auctionItem.get_id());
			}

			// Convert JSON string to Object

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Output from Server .... \n");
		System.out.println(output);
		Collections.sort(auctionItems);
		request.getSession().setAttribute("auctionItems", auctionItems);
		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

	public void postTheAuction(AuctionItem auctionItem) {
		Client client = Client.create();

		WebResource webResource = client.resource("http://honbglrhackat	hon10march2017.mybluemix.net/ws/esale");
//		AuctionItem item = (AuctionItem) request.getAttribute("AuctionItem");

		ObjectMapper mapper = new ObjectMapper();

		try {
			// display name only
			String jsonInString = mapper.writeValueAsString(auctionItem);
			System.out.println(jsonInString);

			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, jsonInString);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
