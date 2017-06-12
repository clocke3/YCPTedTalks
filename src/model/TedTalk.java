package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TedTalk {
	private int tedTalkId, speakerId, topicId;
	private String title, description, link;
	private ArrayList<Review> review = new ArrayList<Review>();

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<Review> getReview() {
		return review;
	}
	
	public void setReview(ArrayList<Review> review) {
		this.review = review;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getTedTalkId() {
		return tedTalkId;
	}

	public void setTedTalkId(int tedTalk_id) {
		this.tedTalkId = tedTalk_id;
	}
	
	public int getTopicId() {
		return topicId;
	}
	
	public void setTopicId(int topic_id) {
		this.topicId = topic_id;
	}
	
	public int getSpeakerId() {
		return speakerId;
	}
	
	public void setSpeakerId(int speaker_id) {
		this.speakerId = speaker_id;
	}
	
}
