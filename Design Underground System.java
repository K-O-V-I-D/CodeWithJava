class Customer {
    String startStation;
    String endStation;
    int startTime;
    int endTime;
    
    public Customer(String startStation, int startTime) {
        this.startStation = startStation;
        this.startTime = startTime;
    }
    
    public void checkout(String endStation, int endTime) {
        this.endStation = endStation;
        this.endTime = endTime;
    }
}

class Route {
    int count;
    int totalTime;
    public Route() {
        this.count = 0;
        this.totalTime = 0;
    }
    
    public void update(int time) {
        count++;
        totalTime += time;
    }
    
    public double getAvg() {
        return (double)totalTime / count;
    }
}


class UndergroundSystem {
    Map<Integer, Customer> cusInSystem;
    Map<String, Route> routeRecord;
    public UndergroundSystem() {
        this.cusInSystem = new HashMap<>();
        this.routeRecord = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        cusInSystem.put(id, new Customer(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Customer c = cusInSystem.get(id);
        c.checkout(stationName, t);
        updateRouteRecord(c);
        cusInSystem.remove(id);
    }
    
    private void updateRouteRecord(Customer c) {
        String route = c.startStation + "-" + c.endStation;
        if (!routeRecord.containsKey(route)) {
            routeRecord.put(route, new Route());
        }
        Route r = routeRecord.get(route);
        r.update(c.endTime - c.startTime);
    }
    
    public double getAverageTime(String startStation, String endStation){
        String route = startStation + "-" + endStation;
        return routeRecord.get(route).getAvg();
    }
}
