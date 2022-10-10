package fr.pantheonsorbonne.cri;

 public class Deck{
   private Card card;

    public static Card[] newRandomHand(){
        Card card = new Card();
        Card[] cards = new Card[5];
        
       
        for(int i = 0; i < 5; i++){
            cards[i] = card.getRandomCard();
        }
        return cards;
    }

    public Card[] getRandomCards(int length){
        
        Card aCard = new Card();
        int cardToAdd = 5 - length;
        Card[] cards = new Card[cardToAdd];
        
        if (cardToAdd == 0){
            return new Card[0];
        }else{
            for(int i = 0; i < cardToAdd; i++){
                cards[i] = aCard.getRandomCard();
            }
        }
        return cards;
    }
    

}