import java.util.* ;
/*Vhiclel
 */

enum SIZE{
    LARGE,
    MEDIUM,
    SMALL
}

enum VEHICLETYPE{
    BUS,
    CAR,
    BIKE
}

class Vehicle {
    VEHICLETYPE type;
    Date entryTime ;
    Date exitTime ;
    int payable ;
    String numberPlat ;
    public VEHICLETYPE getType(){
        return this.type ;
    }
    public Date getEntryTime(){
        return this.entryTime ;
    }
    public void setEntryTime(Date entryTime){
        this.entryTime = entryTime;
    }
    public Date getExitTime(){
        return this.exitTime ;
    }
    public void setExitTime(Date entryTime){ // for book keeping
        this.exitTime = exitTime;
    }
    public int getPayable(){
        return this.payable ;
    }
    public void setPayable(int pay){
        this.payable = pay ;
    }
    public Vehicle(VEHICLETYPE type, SIZE size, String numberPlat, Date entryTime){
        this.type = type ;
        this.entryTime= entryTime ;
        this.numberPlat= numberPlat ;
        this.payable = 0 ;
    }
};

/**ParkingSpot
 */
abstract class ParkingSpot{
    SIZE size;
    Boolean status ;
    int location ;
    public SIZE getSize(){
        return this.size ;
    }
    private void setSize(SIZE s){
        this.size= s ;
    }
    public Boolean isAvaliable(){
        return this.status ;
    }
    public void setStatus(Boolean status){
        this.status = status ;
    }
    public int getLocation(){
        return this.location ;
    }
    static ParkingSpot createParkingSpot(SIZE size){
        ParkingSpot ps= null ;
        if(size== SIZE.LARGE){
            ps = new LargeSPOT();
            ps.setSize(SIZE.LARGE);
            return ps;
        }
        if(size== SIZE.MEDIUM){
            ps = new MediumSPOT();
            ps.setSize(SIZE.LARGE);
            return ps;
        }
        if(size== SIZE.SMALL){
            ps = new SmallSPOT();
            ps.setSize(SIZE.LARGE);
            return ps;
        }
        return null ;
    }
}
 class LargeSPOT extends ParkingSpot{
     Boolean isReserve ;
     public LargeSPOT(){
         setStatus(true);
     }
     public void setIsReserve(Boolean rq){
         this.isReserve=rq;
     }
     public Boolean getIsReserve(){
         return this.isReserve ;
     }
     public void display(){
         System.out.println("I am Large Parking Spot");
     }
 }
 class MediumSPOT extends ParkingSpot{
     Boolean isVIP ;
     public MediumSPOT(){
         setStatus(true);
     }
     public void setIsVIP(Boolean rq){
         this.isVIP=rq;
     }
     public Boolean getIsVIP(){
         return this.isVIP ;
     }
 }
 class SmallSPOT extends ParkingSpot{
     public SmallSPOT(){
         setStatus(true);
     }
 }

 public class ParkingLot {
    ArrayList<SmallSPOT> sParking ;
    ArrayList<MediumSPOT> mParking ;
    ArrayList<LargeSPOT> lParking ;
    int sCap,mCap,lCap ;
    int sCharge,mCharge,lCharge ;
    public ParkingLot (int sCap, int mCap,int lCap) {
        this.sCap= sCap;
        this.mCap= mCap;
        this.lCap= lCap ;
    }
    public synchronized int getSmallCap(){
        return this.sCap;
    }
    public synchronized int getMedCap(){
        return this.mCap;
    }
    public synchronized int getLargeCap(){
        return this.lCap;
    }
    public synchronized void consumeSmallCap(){
        this.sCap--;
    }
    public synchronized void consumeMedCap(){
        this.mCap--;
    }
    public synchronized void consumeLargeCap(){
        this.lCap--;
    }
    public static void main(String[] args) {
        ParkingSpot pk= ParkingSpot.createParkingSpot(SIZE.LARGE);
        if(pk instanceof LargeSPOT) ((LargeSPOT)pk).display();
    }
}