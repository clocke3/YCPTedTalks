package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.aroby.model.Review;
import edu.ycp.cs320.aroby.controller.ReviewController;
import edu.ycp.cs320.aroby.model.TedTalk;

public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/reviewPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Review model = new Review();
		ReviewController controller = new ReviewController();
		int rating;
		URL link = null;
	
			String name = req.getParameter("name");
			String author = req.getParameter("author");
			String title = req.getParameter("title");
			String description = req.getParameter("descript");
			String topic = req.getParameter("topic");
			String review = req.getParameter("review");
			String link_string = req.getParameter("link");
			String recommendations = req.getParameter("recommendations");
			String rating_string = req.getParameter("rating");
			if(rating_string != "" & rating_string != null & link_string != ""){
				rating = Integer.parseInt(rating_string);
				link = new URL(link_string);
				model.setReview(name, author, title, topic, description, review, link, recommendations, rating);
			}
			controller.setModel(model);
			String errorMessage = null;
			
			if(name == "" || author == "" || description == "" || topic == "" || review == ""  || link == null || rating_string == ""){
				req.setAttribute("model", model);
				req.getRequestDispatcher("/_view/reviewPage.jsp").forward(req, resp);
				errorMessage = "Complete all required fields";
			}
			else{
				controller.isDone();
				req.setAttribute("model", model);
				System.out.print("Your review was submitted");
				resp.sendRedirect("/aroby/index");
			}	
		}
	}
