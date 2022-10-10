package fr.pantheonsorbonne.cri;
import java.util.Random;
public class Card{
    public static final String[] names = {"ACE","KING",
        "QUEEN",
        "JACK",
        "TEN",
        "NINE",
        "EIGHT",
        "SEVEN", "SIX", "FIVE", "FOUR", "THREE", "TWO"};
    public static final String[] colors = {"RED", "BLACK"};
    private String name;
    private String color;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private static Random rand = new Random();

    public Card(String name, String color ){
        this.name = name;
        this.color = color;
    }
    public Card(){

    }
    
    public Card getRandomCard(){
        String randName = names[rand.nextInt(names.length)];
        String randColor = colors[rand.nextInt(colors.length)];
        Card aCard = new Card(randName, randColor);
        return aCard;
    }
    

}