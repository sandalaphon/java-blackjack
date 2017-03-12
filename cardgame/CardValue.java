package cardgame;
public enum CardValue{
  
  TWO(2,2),
  THREE(3,3),
  FOUR(4,4),
  FIVE(5,5),
  SIX(6,6),
  SEVEN(7,7),
  EIGHT(8,8),
  NINE(9,9),
  TEN(10,10),
  JACK(11,10),
  QUEEN(12,10),
  KING(13,10),
  ACE(14,11);
  
      private int bJOrder;
      private int bJValue;
     
     CardValue(int bJOrder, int bJValue) {
        this.bJOrder = bJOrder;
        this.bJValue = bJValue;
        
     }

     public int bJValue(){
      return this.bJValue;
     }

     public int bJOrder(){
      return this.bJOrder;
     }

    
     public static CardValue getbJValue(int bJValue) {
             CardValue found = TWO;
             for (CardValue cardname : values()){
                 if (cardname.bJValue == bJValue){
                     found = cardname;
                   }
                 }

             return found;
         }

 

  }


  
