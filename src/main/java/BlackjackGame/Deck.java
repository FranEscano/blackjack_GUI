package BlackjackGame;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

// Represents a deck of cards using a remote card API
public class Deck {

    // Instance variable to store the ID of the card pile
    private String pileID;
    // Instance variable to store JSON path information
    private JsonPath path;

    // Getter method for retrieving the pile ID
    public String getPileID() {
        return pileID;
    }

    // Setter method for updating the pile ID
    public void setPileID(String pileID) {
        this.pileID = pileID;
    }

    // Getter method for retrieving the JSON path
    public JsonPath getPath() {
        return path;
    }

    // Setter method for updating the JSON path
    public void setPath(JsonPath path) {
        this.path = path;
    }

    // Method to request a new deck of cards from the card API and set the pile ID
    public void newDeckOfCards(){
        // Send a GET request to the card API to get a new shuffled deck
        String deckId =
                given().
                when().
                    get("https://www.deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1").
                then().
                    extract().
                    path("deck_id");

        // Set the obtained deck ID as the current pile ID
        setPileID(deckId);
    }

    // Method to draw a card from the current deck using the pile ID
    public void drawCard(){
        // Get the current pile ID
        String deck_id = getPileID();

        // Send a GET request to the card API to draw a card from the specified deck
        Response response =
                given().
                        pathParam("deck_id", deck_id).
                        when().
                        get("https://www.deckofcardsapi.com/api/deck/{deck_id}/draw/?count=1").
                        then().
                        extract().response();

        // Extract the JSON response and set it as the current JSON path
        JsonPath path = response.jsonPath();
        setPath(path);
    }
}