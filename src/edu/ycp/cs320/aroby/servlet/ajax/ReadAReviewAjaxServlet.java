package edu.ycp.cs320.aroby.servlet.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.controller.NumbersController;
import edu.ycp.cs320.aroby.controller.ReadAReviewController;
import edu.ycp.cs320.aroby.model.Numbers;
import edu.ycp.cs320.aroby.model.ReadAReview;

public class ReadAReviewAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reviewText = getString(req, "reviewText");
		String topic = getString(req, "topic");
		String name = getString(req, "name");
		String author = getString(req, "author");
		String descript = getString(req, "descript");
		String link = getString(req, "link");
		
		ReadAReview model = new ReadAReview(name, author, topic, descript, reviewText, link);
		model.setReviewText(reviewText);
		model.setTopic(topic);
		model.setName(name);
		model.setAuthor(author);
		model.setDescription(descript);
		model.setLink(link);
		ReadAReviewController controller = new ReadAReviewController();
		controller.setModel(model);
		
		resp.setContentType("text/plain");
		resp.getWriter().println(reviewText);
		resp.getWriter().println(topic);
		resp.getWriter().println(name);
		resp.getWriter().println(author);
		resp.getWriter().println(descript);
		resp.getWriter().println(link);
	}

	private Double getDouble(HttpServletRequest req, String name) {
		String val = req.getParameter(name);
		if (val == null) {
			return null;
		}
		try {
			return Double.parseDouble(val);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private void badRequest(String message, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.getWriter().println(message);
	}
	
	private String getString(HttpServletRequest req, String name) {
		String val = req.getParameter(name);
		if (val == null) {
			return null;
		}
		else{
			return val;
		}	
	}

}