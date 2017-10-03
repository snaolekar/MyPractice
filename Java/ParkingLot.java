import java.util.* ;
/*Vhiclel
 */
//devision of spots
enum SIZE{
    LARGE,
    MEDIUM,
    SMALL
}

class Vehicle {
    Date entryTime ;
    Date exitTime ;
    int payable ;
    int type; //1 for small car, 2 for medium and 3 for large cars
    String numberPlat ;

    public int getType(){
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
    public Vehicle(int type, String numberPlat, Date entryTime){
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
 }
 class MediumSPOT extends ParkingSpot{
     Boolean isReserve ;
     public MediumSPOT(){
         setStatus(true);
     }
     public void setIsVIP(Boolean rq){
         this.isReserve=rq;
     }
     public Boolean getIsReserved(){
         return this.isReserve ;
     }
 }
 class SmallSPOT extends ParkingSpot{
     public SmallSPOT(){
         setStatus(true);
     }
 }

 public class ParkingLot {
   // ArrayList<SmallSPOT> sParking ;
   // ArrayList<MediumSPOT> mParking ;
   // ArrayList<LargeSPOT> lParking ;
    int sCap,mCap,lCap ; //capasity of different spots in building
    int sCharge,mCharge,lCharge ; // charges decided by the  owner
    SmallSPOT sParking[]=new SmallSPOT[sCap];
    MediumSPOT mParking[]=new MediumSPOT[mCap];
    LargeSPOT lParking[]=new LargeSPOT[lCap];
    public ParkingLot (int sCap, int mCap,int lCap) {
        this.sCap= sCap;
        this.mCap= mCap;
        this.lCap= lCap ;
    }
    //To check the avaliability, synchrinize because many entry points are possible 
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
        ParkingLot pl= new ParkingLot(100, 100, 100);
        Vehicle v1= new Vehicle(1, "ABCD1234", new Date());
        if(pl.getSmallCap()>0){
            pl.consumeSmallCap();
        }

    }
}