package CS2020.assignment2;

public class Products {
 // Instance variables
 String productid;
 String type;
 int quantity;
 String name;
 String nextday;
 
 public Products(String productid, String type,int quantity, String name, String nextday){ //Constructor
     this.productid = productid;
     this.type = type;
     this.quantity = quantity;
     this.name = name;
     this.nextday = nextday;
 }
 // Setters
 public void setproductid(String productid){ //Set the product id 
     this.productid = productid;
 }
 public void settype(String type){ //Set the product type
     this.type = type;
 }
 public void setquantity(int quantity){ //Set the product quantity
     this.quantity = quantity;
 }
 public void setname(String name){ //Set the product name
     this.name = name;
 }
 public void setnextday(String name){ //Set the product name
     this.nextday = name;
 }
 // Getters
 public String getproductid(){ //Get the product id 
     return this.productid;
 }
 public String gettype(){ //Get the product type
     return this.type;
 }
 public int getquantity(){ //Get the product quantity
     return this.quantity;
 }
 public String getname(){ //Get the product name
     return this.name;
 }
 public String getnextday(){ //Get the nextday value
     return this.nextday;
 }
 
 @Override
 public String toString() {
	 return (name + " (" + quantity + ")");
 }
}
