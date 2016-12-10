package wasdev.sample.servlet;

import com.google.gson.annotations.SerializedName;

public class Doc {

	@SerializedName("_id")
	private String id;
	
	private String payload;
	
	private Sentiment sentiment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public Sentiment getSentiment() {
		return sentiment;
	}

	public void setSentiment(Sentiment sentiment) {
		this.sentiment = sentiment;
	}
			
}
