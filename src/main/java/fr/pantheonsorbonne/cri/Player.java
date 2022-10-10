package fr.pantheonsorbonne.cri;

import java.util.Arrays;

import java.util.Objects;
public class Player{

    private String name;
    private Card[] hand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name){
        this.name = name;
    }

    public void setHand(Card[] hand){
        this.hand = hand;
    }
    public Card[] getCardsToDiscard(){
        int countMax = 1;
        String cardMax = null;
       
        for (int i = 0; i < hand.length; i++) {
            int count = 1;
            for (int j = i + 1; j < hand.length; j++) {
                if (i == j) {
                    continue;
                } else if (hand[i].getName().equals(hand[j].getName())) {
                    count++;
                }
                if (count > countMax) {
                    countMax = count;
                    cardMax = hand[i].getName();
                }
            }

        }
        if (countMax == 1) {
        

           discard(higherCard(hand), 4);

        }
        if (countMax == 2) {
            discard(cardMax, 3);

        }
        if (countMax == 3) {
        
          discard(cardMax, 2);

        }
        if (countMax == 4) {
         
          discard(cardMax, 1);


        }
        return hand;
    }

   
    public void discard(String card, int nbCardToDelete){
        
        Card[] newHand = new Card[5 - nbCardToDelete];
       for(int i = 0, j = 0; i < hand.length; i++){
        if(Objects.equals(hand[i].getName(), card)){
          newHand[j] = hand[i];
          j++;
        }
       }
       this.hand = newHand;
    }
    public int getLevelCard(String name){
        
        switch(name){
            case "ACE": 
                return 13;
                
            case "KING": 
                return 12;
                
            case "QUEEN": 
                return 11;
                
            case "JACK": 
                return 10;
                
            case "TEN": 
                return 9;
                
            case "NINE": 
                return 8;
                
            case "EIGHT": 
                return 7;
                
            case "SEVEN": 
                return 6;
                
            case "SIX": 
                return 5;
                
            case "FIVE": 
                return 4;
                
            case "FOUR": 
                return 3;
                
            case "THREE": 
                return 2;
                
            case "TWO": 
                return 1;
                
            default : 
            return 12;
        }
        
    }
    public String getNameByLevel(int level){
        switch(level){
            case 13: 
                return "ACE";
                
            case 12: 
                return "KING";
                
            case 11: 
                return "QUEEN";
                
            case 10: 
                return "JACK";
                
            case 9: 
                return "TEN";
                
            case 8: 
                return "NINE";
                
            case 7: 
                return "EIGHT";
                
            case 6: 
                return "SEVEN";
                
            case 5: 
                return "SIX";
                
            case 4: 
                return "FIVE";
                
            case 3: 
                return "FOUR";
                
            case 2: 
                return "THREE";
                
            case 1: 
                return "TWO";
                
            default : 
            return "TWO";
        }
    }

    public String higherCard(Card[] cards){

        int[] levels = new int[cards.length];
        for (int i = 0; i < cards.length; i++){ 
              int level = getLevelCard(cards[i].getName());
              levels[i] += level;
        }
        
        Arrays.sort(levels);

        levels = reverseSort(levels);

        return getNameByLevel(levels[0]);
    }
    public void addCard(Card[] cardsToAdd){
        
        int len = hand.length + cardsToAdd.length;
        Card[] newHand = new Card[len];
        int i = 0;
        for(Card aCard : hand){
            newHand[i] = aCard;
            i++;
        }
        for(Card aCard: cardsToAdd){
            newHand[i] = aCard;
            i++;
        }
        hand = newHand;


    }
    public int[] reverseSort(int[] tabs){

        int[] newTab = new int[tabs.length];
        for (int i = tabs.length, j =0;j< tabs.length; i--, j++ ){
            newTab[j] = tabs[i - 1]; 
        }
        return newTab;
    }

    public String getHandString(){
        String str = "";
        for(int i = 0 ; i < hand.length; i++ ){
            str += hand[i].getName() + " " + hand[i]. getColor() + ", "; 
        }
        return str;
       
    }

    public boolean beats(Player opponent){
        
        int levelFirstPlayer = cardEvaluate(hand);
        int levelSdPlayer = cardEvaluate(opponent.hand);
        if(levelFirstPlayer > levelSdPlayer){
            return true;
        }else{
            return false;
        }
       
        
    }
    public int cardEvaluate(Card[] cards){

        int countMax = 1;
        String cardMax = null;
       
        for (int i = 0; i < cards.length; i++) {
            int count = 1;
            for (int j = i + 1; j < cards.length; j++) {
                if (i == j) {
                    continue;
                } else if (cards[i].getName().equals(cards[j].getName())) {
                    count++;
                }
                if (count > countMax) {
                    countMax = count;
                    cardMax = cards[i].getName();
                }
            }

        }
        if (countMax == 1) {
        

           return getLevelCard(higherCard(cards));

        }
        if (countMax == 2) {
            int level =  (getLevelCard(cardMax) * 2) + 50 ;
            return level;
        }
        if (countMax == 3) {
        
            int level =  (getLevelCard(cardMax) * 3) + 100 ;
            return level;
        }
        if (countMax == 4) {
         
            int level =  (getLevelCard(cardMax) * 4) + 200 ;
            return level;

        }
        
        return 0;
       
    }
    
}