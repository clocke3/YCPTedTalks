package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Review {
	private String review;
	private int rating, accountId, tedTalkId, reviewId;
	private String date;
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		LocalDateTime dt = LocalDateTime.now();
		date = dtf.format(dt).toString();
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTedTalkId() {
		return tedTalkId;
	}
	public void setTedTalkId(int tedTalk_id) {
		this.tedTalkId = tedTalk_id;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int account_id) {
		this.accountId = account_id;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int review_id) {
		this.reviewId = review_id;
	}
}