package wasdev.sample.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/tweets")
public class SimpleServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final String ENDPOINT = "https://8f0fc3b9-d29f-4415-a1aa-c50ba31bb228-bluemix.cloudant.com/db_twitter/_all_docs?include_docs=true&conflicts=true";
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");        
        Gson gson = new Gson();
        
        try {			
        	
        	HttpResponse<String> json = Unirest.get(ENDPOINT).asString();
        	Tweets tweets = gson.fromJson(json.getBody(), Tweets.class);  
        	TweetsCount tweetsC = gson.fromJson(json.getBody(), TweetsCount.class);  
        	
        	List<Row> rows = tweets.getRows();
        	int bad = 0;
        	int good = 0;        	
        	for (Row row : rows) {
        		Sentiment sentiment = row.getDoc().getSentiment();
        		int score = sentiment.getScore();
        		if (score < 0)
        			bad += 1;
        		else
        			good += 1;
        		
        	}
        	
        	tweetsC.setBadTweets(bad);
        	tweetsC.setGoodTweets(good);        	
        	response.getWriter().print(gson.toJson(tweetsC));
        	
		} catch (UnirestException e) {
			e.printStackTrace();
			response.getWriter().print("Ops =(");
		}
        
        
    }

}
