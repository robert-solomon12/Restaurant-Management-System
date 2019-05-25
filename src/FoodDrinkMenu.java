
public class FoodDrinkMenu {

	int foodMenuNumber;
	String fdMenuItem;
	public double itemPrice;
	public FoodDrinkMenu next= null;
	
	
	
public FoodDrinkMenu(int foodMenuNumber,String fdMenuItem, double itemPrice) {
		
		this.foodMenuNumber = foodMenuNumber;
		this.fdMenuItem = fdMenuItem;
		this.itemPrice = itemPrice ;
}


public int getFoodMenuNumber() {
	return foodMenuNumber;
}



public void setFoodMenuNumber(int foodMenuNumber) {
	this.foodMenuNumber = foodMenuNumber;
}


public String getFdMenuItem() {
	return fdMenuItem;
}



public void setFdMenuItem(String fdMenuItem) {
	this.fdMenuItem = fdMenuItem;
}



public double getItemPrice() {
	return itemPrice;
}



public void setItemPrice(double itemPrice) {
	this.itemPrice = itemPrice;
}

}
	
	
	
	
	
	/*

	public FoodDrinkMenu(String burger, double pBurger,String salad, double pSalad, String pie, double pPie) {
		
		//String beer, double pBeer,
	
		//String orangeJuice, double pOrangeJuice, String coke, double pCoke) {
		
		this.Burger = burger;
		this.pBurger = pBurger;
		this.Salad = salad;
		this.pSalad = pSalad;
		this.Pie = pie;
		this.pPie = pPie;
		/*this.eggDishes = eggDishes;
		this.pEggDishes = pEggDishes;
		this.Pizza = pizza;
		this.pPizza = pPizza;
		this.cheeseCake = cheeseCake;
		this.pCheeseCake = pCheeseCake;
		this.brownies = brownies;
		this.pBrownies = pBrownies;
		this.iceCream = iceCream;
		this.pIceCream = pIceCream;
		this.Beer = beer;
		this.pBeer = pBeer;
		this.orangeJuice = orangeJuice;
		this.pOrangeJuice = pOrangeJuice;
		this.Coke = coke;
		this.pCoke = pCoke;
		this.lemonJuice = lemonJuice;
		this.pLemonJuice = pLemonJuice;
		this.appleJuice = appleJuice;
		this.pAppleJuice = pAppleJuice;
		this.iceTea = iceTea;
		this.pIceTea = pIceTea;
		this.raspberryJuice = raspberryJuice;
		this.pRaspberryJuice = pRaspberryJuice;
		this.foodSubTotal = foodSubTotal;
		this.drinkSubTotal = drinkSubTotal;
		Total = total;
	}



	public FoodDrinkMenu(int fdMenuNum, String burger2, double pBurger2, String salad2, double pSalad2, String pie2, double pPie2) {
		// TODO Auto-generated constructor stub
	}



	public String getBurger() {
		return Burger;
	}





	public void setBurger(String burger) {
		Burger = burger;
	}





	public double getpBurger() {
		return pBurger;
	}





	public void setpBurger(double pBurger) {
		this.pBurger = pBurger;
	}



	public String getSalad() {
		return Salad;
	}





	public void setSalad(String salad) {
		Salad = salad;
	}


	public double getpSalad() {
		return pSalad;
	}





	public void setpSalad(double pSalad) {
		this.pSalad = pSalad;
	}

	public String getPie() {
		return Pie;
	}

	public void setPie(String pie) {
		Pie = pie;
	}

	public double getpPie() {
		return pPie;
	}





	public void setpPie(double pPie) {
		this.pPie = pPie;
	}


@Override
public String toString() {
	return "FoodDrinkMenu [Burger=" + Burger + ", pBurger=" + pBurger + ", Salad=" + Salad + ", pSalad=" + pSalad
			+ ", Pie=" + Pie + ", pPie=" + pPie + ", next=" + next + "]";
}
}


public String getEggDishes() {
		return eggDishes;
	}





	public void setEggDishes(String eggDishes) {
		this.eggDishes = eggDishes;
	}





	public double getpEggDishes() {
		return pEggDishes;
	}





	public void setpEggDishes(double pEggDishes) {
		this.pEggDishes = pEggDishes;
	}





	public String getPizza() {
		return Pizza;
	}





	public void setPizza(String pizza) {
		Pizza = pizza;
	}





	public double getpPizza() {
		return pPizza;
	}





	public void setpPizza(double pPizza) {
		this.pPizza = pPizza;
	}





	public String getCheeseCake() {
		return cheeseCake;
	}





	public void setCheeseCake(String cheeseCake) {
		this.cheeseCake = cheeseCake;
	}





	public double getpCheeseCake() {
		return pCheeseCake;
	}





	public void setpCheeseCake(double pCheeseCake) {
		this.pCheeseCake = pCheeseCake;
	}





	public String getBrownies() {
		return brownies;
	}





	public void setBrownies(String brownies) {
		this.brownies = brownies;
	}





	public double getpBrownies() {
		return pBrownies;
	}





	public void setpBrownies(double pBrownies) {
		this.pBrownies = pBrownies;
	}





	public String getIceCream() {
		return iceCream;
	}





	public void setIceCream(String iceCream) {
		this.iceCream = iceCream;
	}





	public double getpIceCream() {
		return pIceCream;
	}





	public void setpIceCream(double pIceCream) {
		this.pIceCream = pIceCream;
	}





	public String getBeer() {
		return Beer;
	}





	public void setBeer(String beer) {
		Beer = beer;
	}





	public double getpBeer() {
		return pBeer;
	}





	public void setpBeer(double pBeer) {
		this.pBeer = pBeer;
	}





	public String getOrangeJuice() {
		return orangeJuice;
	}





	public void setOrangeJuice(String orangeJuice) {
		this.orangeJuice = orangeJuice;
	}





	public double getpOrangeJuice() {
		return pOrangeJuice;
	}





	public void setpOrangeJuice(double pOrangeJuice) {
		this.pOrangeJuice = pOrangeJuice;
	}





	public String getCoke() {
		return Coke;
	}





	public void setCoke(String coke) {
		Coke = coke;
	}





	public double getpCoke() {
		return pCoke;
	}





	public void setpCoke(double pCoke) {
		this.pCoke = pCoke;
	}





	public String getLemonJuice() {
		return lemonJuice;
	}





	public void setLemonJuice(String lemonJuice) {
		this.lemonJuice = lemonJuice;
	}





	public double getpLemonJuice() {
		return pLemonJuice;
	}





	public void setpLemonJuice(double pLemonJuice) {
		this.pLemonJuice = pLemonJuice;
	}





	public String getAppleJuice() {
		return appleJuice;
	}





	public void setAppleJuice(String appleJuice) {
		this.appleJuice = appleJuice;
	}





	public double getpAppleJuice() {
		return pAppleJuice;
	}





	public void setpAppleJuice(double pAppleJuice) {
		this.pAppleJuice = pAppleJuice;
	}





	public String getIceTea() {
		return iceTea;
	}





	public void setIceTea(String iceTea) {
		this.iceTea = iceTea;
	}





	public double getpIceTea() {
		return pIceTea;
	}





	public void setpIceTea(double pIceTea) {
		this.pIceTea = pIceTea;
	}





	public String getRaspberryJuice() {
		return raspberryJuice;
	}





	public void setRaspberryJuice(String raspberryJuice) {
		this.raspberryJuice = raspberryJuice;
	}





	public double getpRaspberryJuice() {
		return pRaspberryJuice;
	}





	public void setpRaspberryJuice(double pRaspberryJuice) {
		this.pRaspberryJuice = pRaspberryJuice;
	
}
*/