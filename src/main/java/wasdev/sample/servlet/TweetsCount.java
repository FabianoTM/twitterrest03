package wasdev.sample.servlet;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TweetsCount {

	@SerializedName("total_rows")
	private int total;
	
	@SerializedName("bad_tweets")
	private int badTweets;
	
	@SerializedName("good_tweets")
	private int goodTweets;
	
	@SerializedName("neutral_tweets")
	private int neutralTweets;
	
//	private List<Row> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
			
	public int getBadTweets() {
		return badTweets;
	}

	public void setBadTweets(int badTweets) {
		this.badTweets = badTweets;
	}

	public int getGoodTweets() {
		return goodTweets;
	}

	public void setGoodTweets(int goodTweets) {
		this.goodTweets = goodTweets;
	}

	public int getNeutralTweets() {
		return neutralTweets;
	}

	public void setNeutralTweets(int neutralTweets) {
		this.neutralTweets = neutralTweets;
	}
	
	
}
