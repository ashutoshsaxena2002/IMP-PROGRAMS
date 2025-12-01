package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;

// Visitor patteran allows us to add new operation to already existing classes without modifying the classes

// Now suppose we have Hotel which have single, double, deluxe room and their respective class
// Suppose in future a situation might come where we need to add extra cost along with pricing
// so we will declare RoomVisitor and overallPricing interfaces and declare extra pricing function with respective room
// and implement those functions in single, double, deluxe room class so that in future if we need to add some extra pricing
// we can add without modifying the classes of single double ,deluxe room

interface OverallPricing{
    Integer getOverallPricing(RoomVisitor roomVisitor);
}


// Now we will create a interface known as RoomVisitor and we will declare all
// function to get maintenance  pricing of respective room
interface RoomVisitor{
    // Functions declared for getting the maintenance or cleaning pricing
    Integer getExtraPricing(SingleRoom singleRoom);
    Integer getExtraPricing(DoubleRoom doubleRoom);
    Integer getExtraPricing(DeluxeRoom deluxeRoom);
}

class SingleRoom implements OverallPricing{
    private Integer pricing;

    public SingleRoom(Integer pricing){
        this.pricing=pricing;
    }

    public Integer getPricing(){
        return this.pricing;
    }

    @Override
    public Integer getOverallPricing(RoomVisitor roomVisitor) {
        return roomVisitor.getExtraPricing(this);
    }
}
class DoubleRoom implements OverallPricing{
    private Integer pricing;

    public DoubleRoom(Integer pricing){
        this.pricing=pricing;
    }

    public Integer getPricing(){
        return this.pricing;
    }

    @Override
    public Integer getOverallPricing(RoomVisitor roomVisitor) {
        return roomVisitor.getExtraPricing(this);
    }
}
class DeluxeRoom implements OverallPricing{
    private Integer pricing;

    public DeluxeRoom(Integer pricing){
        this.pricing=pricing;
    }

    public Integer getPricing(){
        return this.pricing;
    }

    @Override
    public Integer getOverallPricing(RoomVisitor roomVisitor) {
        return roomVisitor.getExtraPricing(this);
    }
}

// Now we want to implement functionality to include
// Cleaning and maintenance pricing in overall pricing of room depending on situation without modifying above classes


// now we have defined this impl class to get maintenance pricing of respective rooms
class RoomVisitorForMaintenanceImpl implements RoomVisitor{

    @Override
    public Integer getExtraPricing(SingleRoom singleRoom) {
        return 20+singleRoom.getPricing();
    }

    @Override
    public Integer getExtraPricing(DoubleRoom doubleRoom) {
        return 30+doubleRoom.getPricing();
    }

    @Override
    public Integer getExtraPricing(DeluxeRoom deluxeRoom) {
        return 40+deluxeRoom.getPricing();
    }
}
// now we have defined this impl class to get cleaning pricing of respective rooms
class RoomVisitorForCleaningImpl implements RoomVisitor{

    @Override
    public Integer getExtraPricing(SingleRoom singleRoom) {
        return 50+singleRoom.getPricing();
    }

    @Override
    public Integer getExtraPricing(DoubleRoom doubleRoom) {
        return 80+doubleRoom.getPricing();
    }

    @Override
    public Integer getExtraPricing(DeluxeRoom deluxeRoom) {
        return 1100+deluxeRoom.getPricing();
    }
}


// now if we have to implement any further functionality for respective rooms so we can declare the impl classes
// and implement RoomVisitor interface function for respective room without modifying original classes of room

public class VisitorPattern {

    public static void main(String [] args){
        SingleRoom singleRoom = new SingleRoom(5);
        DoubleRoom doubleRoom = new DoubleRoom(10);
        DeluxeRoom deluxeRoom = new DeluxeRoom(15);
        RoomVisitorForMaintenanceImpl maintenanceCharges = new RoomVisitorForMaintenanceImpl();
        RoomVisitorForCleaningImpl cleaningCharges = new RoomVisitorForCleaningImpl();

        System.out.println("SINGLE ROOM WITH ONLY MAINTENANCE CHARGES:"+singleRoom.getOverallPricing(maintenanceCharges));
        System.out.println("SINGLE ROOM WITH ONLY CLEANING CHARGES:"+singleRoom.getOverallPricing(cleaningCharges));

        System.out.println("DOUBLE ROOM WITH ONLY MAINTENANCE CHARGES:"+doubleRoom.getOverallPricing(maintenanceCharges));
        System.out.println("DOUBLE ROOM WITH ONLY CLEANING CHARGES:"+doubleRoom.getOverallPricing(cleaningCharges));

        System.out.println("DELUXE ROOM WITH ONLY MAINTENANCE CHARGES:"+deluxeRoom.getOverallPricing(maintenanceCharges));
        System.out.println("DELUXE ROOM WITH ONLY CLEANING CHARGES:"+deluxeRoom.getOverallPricing(cleaningCharges));

    }

}
