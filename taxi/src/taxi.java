import java.util.Scanner;

public class taxi {
    private int journey;
    private int stayTime;
    private int startPrice;
    private double pricePerMile;
    private double stayPrice;
    private double total;

    public taxi(){

    }

    public taxi(int journey,int stayTime,int startPrice,double pricePerMile,double stayPrice){
        this.startPrice = startPrice;
        this.pricePerMile = pricePerMile;
        this.stayPrice = stayPrice;
        this.journey = journey;
        this.stayTime = stayTime;
        total = 0;
    }

    public float getTotal() {
        return Math.round(total);
    }

    private void countTotalCost(){
        if (journey < 2 && journey > 0) startPriceCount();
        if (journey > 2 && journey < 8) startTo8PriceCount();
        if (journey > 8) over8PriceCount();
        total = total + stayCount();
    }
    private double startPriceCount(){

            total = startPrice;
        return total;
    }

    private double startTo8PriceCount(){
        total = startPrice + (journey-2)*0.8;
        return total;
    }

    private double over8PriceCount(){
        total = startPrice + 6*0.8 + (journey-8)*0.8*1.5;
        return total;

    }

    private double stayCount(){
        stayPrice = stayTime*0.25;
        return stayPrice;

    }
}

class test{
    public static void main(String[] args) {
        int startPrice = 6;
        double pricePerMile = 0.8;
        double stayPrice = 0.25;
        Scanner scanner = new Scanner(System.in);
        int miles = scanner.nextInt();
        int stayTimes = scanner.nextInt();
        taxi t = new taxi(miles,stayTimes,startPrice,pricePerMile,stayPrice);
        System.out.print(t.getTotal());
    }
}

