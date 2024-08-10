package mac;

public class MarketPlace {

    User poster = new User("poster1", "password", "*************.com", "location1");
    Job job = new Job("Title", "Description", "Location", 100.00, poster);

// add the job to the database or an ArrayList

    User bidder = new User("bidder1", "password", "*************.com", "location2");
    double bidAmount = 75.00;
    Bid bid = new Bid(bidAmount, job, bidder);


}
